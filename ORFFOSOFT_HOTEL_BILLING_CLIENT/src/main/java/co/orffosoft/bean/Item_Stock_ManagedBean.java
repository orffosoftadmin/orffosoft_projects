package co.orffosoft.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.orffosoft.dto.Item_Stock_DTO;
import co.orffosoft.utill.HttpService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Service("itemStockBean")
@Log4j2
@Scope("session")
@Data
public class Item_Stock_ManagedBean implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -6640497611677906369L;
	
	@Autowired
	HttpService httpService;

	@Autowired
	LoginBean loginBean;
	
	DateFormat frtm=new SimpleDateFormat("dd-MM-yyyy");
	
	private boolean showlistPage;
	private boolean showaddPage;
	private boolean showviewPage;
	
	private final String stockListPage="/pages/Orrfo_Billing_Pages/Item_Stock.xhtml?faces-redirect=true";
	private final String stockAddPage="/pages/Orrfo_Billing_Pages/Item_Stock_Add.xhtml?faces-redirect=true";
	private final String stockViewPage="/pages/Orrfo_Billing_Pages/Item_Stock_View.xhtml?faces-redirect=true";
	
	private Item_Stock_DTO stock_head=new Item_Stock_DTO();
	private Item_Stock_DTO filter=new Item_Stock_DTO();
	private Item_Stock_DTO selectData=new Item_Stock_DTO();
	private List<Item_Stock_DTO> stock_detail_list=new ArrayList<Item_Stock_DTO>();
	
	@PostConstruct
	public void init() {
		stock_head=new Item_Stock_DTO();
		filter=new Item_Stock_DTO();
		stock_detail_list=new ArrayList<Item_Stock_DTO>();
		listPage();
	}
	
	public String listPage() {
		selectData=new Item_Stock_DTO();
		stock_head=new Item_Stock_DTO();
		filter=new Item_Stock_DTO();
		stock_detail_list=new ArrayList<Item_Stock_DTO>();
		showlistPage=true;
		showaddPage=false;
		showviewPage=false;
		
		Item_Stock_DTO  dto=new Item_Stock_DTO();
		dto.setStock_head_pk(1);
		dto.setStock_id("ST20191117SVM001");
		dto.setStock_date_str("17-11-2019");
		dto.setCreated_by_name("Orffoadmin");
		dto.setStock_status("Active");
		dto.setCreated_by_date_str("17-11-2019");
		dto.setModify_by_name("Orffoadmin");
		dto.setModify_by_date_str("17-11-2019");
		stock_detail_list.add(dto);
		dto=new Item_Stock_DTO();
		dto.setStock_head_pk(2);
		dto.setStock_id("ST20191117SVM002");
		dto.setStock_date_str("17-11-2019");
		dto.setCreated_by_name("Orffoadmin");
		dto.setStock_status("Active");
		dto.setCreated_by_date_str("17-11-2019");
		dto.setModify_by_name("Orffoadmin");
		dto.setModify_by_date_str("17-11-2019");
		stock_detail_list.add(dto);
		return stockListPage;
	}
	
	public String addPage() {
		stock_head=new Item_Stock_DTO();
		filter=new Item_Stock_DTO();
		stock_detail_list=new ArrayList<Item_Stock_DTO>();
		
	
		stock_head.setStock_id("#Auto");
		stock_head.setStock_date(new Date());
		stock_head.setStock_date_str(frtm.format(new Date()));
		
		
		Item_Stock_DTO  dto=new Item_Stock_DTO();
		dto.setStock_head_pk(1);
		dto.setItem_name("RW101 - RICE");
		dto.setItem_uom_name("KG");
		dto.setStock_status("Active");
		stock_head.getStock_detail().add(dto);
		
		dto=new Item_Stock_DTO();
		dto.setStock_head_pk(1);
		dto.setItem_name("RW102 - DALL");
		dto.setItem_uom_name("KG");
		dto.setStock_status("Active");
		stock_head.getStock_detail().add(dto);
		
		dto=new Item_Stock_DTO();
		dto.setStock_head_pk(1);
		dto.setItem_name("RW103 - WHEAT FLOUE");
		dto.setItem_uom_name("KG");
		dto.setStock_status("Active");
		stock_head.getStock_detail().add(dto);
		
		dto=new Item_Stock_DTO();
		dto.setStock_head_pk(1);
		dto.setItem_name("RW104 - SALT");
		dto.setItem_uom_name("KG");
		dto.setStock_status("Active");
		stock_head.getStock_detail().add(dto);
		
		dto=new Item_Stock_DTO();
		dto.setStock_head_pk(1);
		dto.setItem_name("RW105 - OIL");
		dto.setItem_uom_name("LITER");
		dto.setStock_status("Active");
		stock_head.getStock_detail().add(dto);
		
		showlistPage=false;
		showaddPage=true;
		showviewPage=false;
		return stockAddPage;
	}
	
	public String modifyPage() {
		stock_head=new Item_Stock_DTO();
		filter=new Item_Stock_DTO();
		stock_detail_list=new ArrayList<Item_Stock_DTO>();
		
		showlistPage=false;
		showaddPage=true;
		showviewPage=false;
		return stockAddPage;
	}
	
	public String viedPage() {
		stock_head=new Item_Stock_DTO();
		filter=new Item_Stock_DTO();
		stock_detail_list=new ArrayList<Item_Stock_DTO>();
		
		showlistPage=false;
		showaddPage=false;
		showviewPage=true;
		return stockViewPage;
	}
	
	public void clearlistPage() {
		stock_head=new Item_Stock_DTO();
		filter=new Item_Stock_DTO();
		stock_detail_list=new ArrayList<Item_Stock_DTO>();
		showlistPage=true;
		showaddPage=false;
		showviewPage=false;
	}
	
	
	public void clearDetai() {
		stock_head.setStock_detail(new ArrayList<Item_Stock_DTO>());
		showlistPage=true;
		showaddPage=false;
		showviewPage=false;
	}

}
