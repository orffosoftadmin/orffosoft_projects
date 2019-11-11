package co.orffosoft.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.AppPreference;
import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.RestException;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.InitialStockUploadDTO;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("initialStockUploadBean")
@Scope("session")
public class InitialStockUploadBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8267829780984422492L;

	private final String STOCKUPLOAD_PAGE = "/pages/billing/initialStockUpload.xhtml?faces-redirect=true;";

	@Getter
	@Setter
	String fileName;

	@Getter
	@Setter
	Date stockUploadDate = null;

	@Getter
	@Setter
	InitialStockUploadDTO initialStockUploadDTO = new InitialStockUploadDTO();

	@Getter
	@Setter
	List<InitialStockUploadDTO> initialStockUploadDTOList = new ArrayList<>();

	@Autowired
	LoginBean loginBean;

	@Getter
	@Setter
	FileOutputStream fos;

	@Getter
	@Setter
	byte[] downloadName = null;

	@Getter
	@Setter
	StreamedContent file;

	@Getter
	@Setter
	private UploadedFile uploadedFile;

	@Getter
	@Setter
	File files = null;

	@Getter
	@Setter
	String filePathName = "G:/office work/file upload path/excel/InitialStockUpload.xls";

	@Getter
	@Setter
	String uploadFilePath = "G:/office work/file upload path/uploaded/excel";

	public static final String SERVER_URL = AppUtil.getPortalServerURL();

	@Autowired
	HttpService httpService;

	@Autowired
	AppPreference appPreference;

	public String showListPage() {
		stockUploadDate = new Date();
		initialStockUploadDTO = new InitialStockUploadDTO();
		initialStockUploadDTOList = new ArrayList<>();
		return STOCKUPLOAD_PAGE;

	}

	/**
	 * This Method will use to create upload Stock
	 * 
	 * @param files
	 */
	public void uploadInitialStock(FileUploadEvent event) {

		log.info(":::<- uploadInitialStock Start ->::: ");
		BaseDTO baseDTO = null;

		try {
			InputStream excelFile = null;
			if (event == null || event.getFile() == null) {
				log.error(" Upload document is null ");
				AppUtil.addError("Uploaded Document Is Empty ");
				return;
			}
			uploadedFile = event.getFile();
			long size = uploadedFile.getSize();
			log.info("Employee retirement request document size is : " + size);

			String fileName = event.getFile().getFileName();

			boolean fileCopied = copyFile(uploadedFile.getInputstream(), fileName, uploadFilePath);
			if (!fileCopied) {
				log.info("Initial Stock Upload File not copied.");
				throw new RestException("Initial Stock Upload File not copied.");
			}
			String absoluteFilePathForStockUpdate = uploadFilePath + "/" + fileName;
			File fileForUpdateStock = new File(absoluteFilePathForStockUpdate);
			excelFile = new FileInputStream(fileForUpdateStock);
			Workbook workbook = new HSSFWorkbook(excelFile);
			Sheet sheet = workbook.getSheetAt(0);
			Row row = null;
			int cellCount = 1;
			int rowCount = 0;
			boolean exit = false;
			for (Row rows : sheet) {
				if (exit) {
					return;
				}
				for (Cell cellValue : rows) {
					initialStockUploadDTO = new InitialStockUploadDTO();
					++rowCount;
					row = sheet.getRow(rowCount);
					if (row == null) {
						updateStock(initialStockUploadDTOList);
						exit = true;
						return;
					}
					cellCount = 1;
					cellValue = row.getCell(cellCount);
					if (cellValue == null) {
						return;
					}
					initialStockUploadDTO.setItemName(cellValue.getStringCellValue());

					cellValue = row.getCell(++cellCount);
					if (cellValue == null) {
						return;
					}
					initialStockUploadDTO.setQuantity((long) cellValue.getNumericCellValue());
					cellValue = row.getCell(++cellCount);
					if (cellValue == null) {
						return;
					}
					initialStockUploadDTO.setCgstPercentage((long) cellValue.getNumericCellValue());

					cellValue = row.getCell(++cellCount);
					if (cellValue == null) {
						return;
					}
					initialStockUploadDTO.setSgstPercentage((long) cellValue.getNumericCellValue());

					cellValue = row.getCell(++cellCount);
					if (cellValue == null) {
						return;
					}
					initialStockUploadDTO.setPurchaseAmout(cellValue.getNumericCellValue());

					cellValue = row.getCell(++cellCount);
					if (cellValue == null) {
						return;
					}
					initialStockUploadDTO.setSellingAmount(cellValue.getNumericCellValue());

					if (initialStockUploadDTO.getCgstPercentage() != null) {
						initialStockUploadDTO.setCgstAmount((initialStockUploadDTO.getPurchaseAmout() / 100)
								* initialStockUploadDTO.getCgstPercentage());
					}
					if (initialStockUploadDTO.getCgstAmount() == null) {
						initialStockUploadDTO.setCgstAmount(0D);
					}

					if (initialStockUploadDTO.getSgstPercentage() != null) {
						initialStockUploadDTO.setSgstAmount((initialStockUploadDTO.getPurchaseAmout() / 100)
								* initialStockUploadDTO.getSgstPercentage());
					}
					if (initialStockUploadDTO.getSgstAmount() == null) {
						initialStockUploadDTO.setSgstAmount(0D);
					}
					initialStockUploadDTO.setTotalPurchaseAmt(
							(initialStockUploadDTO.getQuantity() * (initialStockUploadDTO.getPurchaseAmout()
									+ initialStockUploadDTO.getCgstAmount() + initialStockUploadDTO.getSgstAmount())));
					initialStockUploadDTO.setTotalSellingAmt(
							(initialStockUploadDTO.getQuantity() * initialStockUploadDTO.getSellingAmount())
									+ initialStockUploadDTO.getCgstAmount() + initialStockUploadDTO.getSgstAmount());
//					initialStockUploadDTO.setCgstAmount(
//							(initialStockUploadDTO.getTotalPurchaseAmt() * initialStockUploadDTO.getCgstPercentage())
//									/ 100);
//					initialStockUploadDTO.setSgstAmount(
//							(initialStockUploadDTO.getTotalPurchaseAmt() * initialStockUploadDTO.getSgstPercentage())
//									/ 100);

					initialStockUploadDTOList.add(initialStockUploadDTO);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateStock(List<InitialStockUploadDTO> dtoList) {
		if (dtoList != null && dtoList.size() > 0) {
			String url = SERVER_URL + "/initialStockUploadController/saveinitialstockupload";
			log.info("::: updateStock Method In InitialStockUpload:::");
			BaseDTO baseDTO = httpService.post(url, dtoList);
			if (baseDTO.getStatusCode() == 0) {
				AppUtil.addInfo("Stock Has Been Successfully Uploaded :: Total Record" + baseDTO.getTotalRecords());
			} else {
				AppUtil.addInfo(" Stock Uploaded Failed :: ");
			}
		} else {
			AppUtil.addInfo("Please Add Item");
		}

	}

	/**
	 * This method is used to .
	 *
	 */
	public void getDownloadFile() {
		InputStream input = null;
		try {
			files = new File(filePathName);
			Path path = Paths.get(filePathName);
			if (Files.notExists(path)) {
				Files.createDirectories(path);
			}
			input = new FileInputStream(files);
			if (input != null) {
				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext externalContext = context.getExternalContext();
				file = (new DefaultStreamedContent(input, externalContext.getMimeType(files.getName()),
						files.getName()));
			}
		} catch (Exception ex) {
			log.error(" Error in while getting getDownloadFile", ex);
			AppUtil.addError("Download Error");
		}
	}

	/**
	 * @param inputStream
	 * @param name
	 * @param outFilePath
	 * @return
	 */
	private boolean copyFile(InputStream inputStream, String name, String outFilePath) {

		OutputStream outputStream = null;
		boolean flag = false;
		try {

			outputStream = new FileOutputStream(new File(outFilePath, name));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			log.info("copyFile-Done!");
			flag = true;
		} catch (IOException ex) {
			log.error("Exception at copyFile() ", ex);
			flag = false;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return flag;
	}

}
