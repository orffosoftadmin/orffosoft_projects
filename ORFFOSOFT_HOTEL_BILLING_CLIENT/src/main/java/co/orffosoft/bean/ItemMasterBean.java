package co.orffosoft.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.dto.ItemDTO;
import co.orffosoft.dto.ItemMasterDTO;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author Pratap Kumar Sahu
 *
 */
@Log4j2
@Service("itemMasterBean")
@Scope("session")
@Data
public class ItemMasterBean implements Serializable {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1818039738991406334L;

	private final String ITEM_MSTER_ADD = "/pages/items/ItemMasterAdd.xhtml?faces-redirect=true;";
	private final String ITEM_MSTER_VIEW = "/pages/items/ItemMasterView.xhtml?faces-redirect=true;";
	private final String DAMAGE_CONTROLLER = "/pages/items/DamageController.xhtml?faces-redirect=true;";
	private final String ITEM_MASTER_LIST = "/pages/items/ItemMasterList.xhtml?faces-redirect=true;";
	private boolean sellingRender = false;

	ItemDTO itemMasterDTO = new ItemDTO();
	ItemDTO itemMasterAddDTO = new ItemDTO();
	List<ItemDTO> itemMasterDTOList = new ArrayList<ItemDTO>();

	ItemDTO selectedItemMasterAddDTO = new ItemDTO();

	// @PostConstruct
	public String init() {
		selectedItemMasterAddDTO = null;
		retriveItemList();

		return ITEM_MASTER_LIST;
	}

	public String saveItem() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String addItem() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITEM_MSTER_ADD;
	}

	public String backItem() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITEM_MASTER_LIST;
	}

	public String editItem() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITEM_MSTER_ADD;
	}

	public String viewItem() {
		try {

			if (selectedItemMasterAddDTO == null) {
				AppUtil.addWarn("Please select one record");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITEM_MSTER_VIEW;
	}

	public String retriveItemList() {
		try {
			itemMasterDTOList = new ArrayList<ItemDTO>();

			itemMasterDTO = new ItemDTO();
			itemMasterDTO.setItemPk(1);
			itemMasterDTO.setItemCode("RW101");
			itemMasterDTO.setItemName("RICE");
			itemMasterDTO.setItemTypeName("ROW ITEM");
			itemMasterDTO.setUomName("KG");
			itemMasterDTO.setCreatedBy("Pinku");
			itemMasterDTOList.add(itemMasterDTO);

			itemMasterDTO = new ItemDTO();
			itemMasterDTO.setItemPk(2);
			itemMasterDTO.setItemCode("RW102");
			itemMasterDTO.setItemName("DAL");
			itemMasterDTO.setItemTypeName("ROW ITEM");
			itemMasterDTO.setUomName("KG");
			itemMasterDTO.setCreatedBy("Shiba");
			itemMasterDTOList.add(itemMasterDTO);

			itemMasterDTO = new ItemDTO();
			itemMasterDTO.setItemPk(3);
			itemMasterDTO.setItemCode("RW103");
			itemMasterDTO.setItemName("SUJI");
			itemMasterDTO.setItemTypeName("ROW ITEM");
			itemMasterDTO.setUomName("KG");
			itemMasterDTO.setCreatedBy("Jaga");
			itemMasterDTOList.add(itemMasterDTO);

			itemMasterDTO = new ItemDTO();
			itemMasterDTO.setItemPk(4);
			itemMasterDTO.setItemCode("RW104");
			itemMasterDTO.setItemName("SUGAR");
			itemMasterDTO.setItemTypeName("ROW ITEM");
			itemMasterDTO.setUomName("KG");
			itemMasterDTO.setCreatedBy("Lulu");
			itemMasterDTOList.add(itemMasterDTO);

			itemMasterDTO = new ItemDTO();
			itemMasterDTO.setItemPk(5);
			itemMasterDTO.setItemCode("RW105");
			itemMasterDTO.setItemName("OIL");
			itemMasterDTO.setItemTypeName("SELLING ITEM");
			itemMasterDTO.setUomName("KG");
			itemMasterDTO.setCreatedBy("pratap");
			itemMasterDTOList.add(itemMasterDTO);
			
			itemMasterDTO = new ItemDTO();
			itemMasterDTO.setItemPk(6);
			itemMasterDTO.setItemCode("RW106");
			itemMasterDTO.setItemName("AMUL");
			itemMasterDTO.setItemTypeName("SELLING ITEM");
			itemMasterDTO.setUomName("KG");
			itemMasterDTO.setCreatedBy("JITU");
			itemMasterDTOList.add(itemMasterDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITEM_MSTER_ADD;
	}

	public String sellingPanelVisible() {
		try {
			if (itemMasterAddDTO.getItemTypeFk() == 2) {
				sellingRender = true;
			} else {
				sellingRender = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ITEM_MSTER_ADD;

	}

}
