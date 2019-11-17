package co.orffosoft.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.orffosoft.dto.Customer_Billing_DTO;
import co.orffosoft.dto.Item_Stock_DTO;
import co.orffosoft.utill.HttpService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Service("billingBean")
@Log4j2
@Scope("session")
@Data
public class Customer_Billing_ManagedBean implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -3501351410291059402L;
	
	@Autowired
	HttpService httpService;

	@Autowired
	LoginBean loginBean;
	
	private Customer_Billing_DTO bill_head=new Customer_Billing_DTO();
	
	private List<Customer_Billing_DTO> selling_itemList=new ArrayList<Customer_Billing_DTO>();
	
	private Customer_Billing_DTO selectData=new Customer_Billing_DTO();
	
	@PostConstruct
	public void init() {
		bill_head=new Customer_Billing_DTO();
		loasSellingitems();
	}
	
	public void loasSellingitems() {
		Customer_Billing_DTO newitem=new Customer_Billing_DTO();
		selling_itemList=new ArrayList<Customer_Billing_DTO>();
		newitem.setItem(1);
		newitem.setItem_uom_name("Plate");
		newitem.setItem_cost(100);
		newitem.setItem_name("SL101 - RICE PLATE");
		selling_itemList.add(newitem);
		
		newitem=new Customer_Billing_DTO();
		newitem.setItem(2);
		newitem.setItem_name("SL102 - ROTI PLATE");
		newitem.setItem_uom_name("Plate");
		newitem.setItem_cost(100);
		selling_itemList.add(newitem);
		
		newitem=new Customer_Billing_DTO();
		newitem.setItem(3);
		newitem.setItem_name("SL103 - RASHGULA ");
		newitem.setItem_uom_name("Piece");
		newitem.setItem_cost(10);
		selling_itemList.add(newitem);
		
		newitem=new Customer_Billing_DTO();
		newitem.setItem(3);
		newitem.setItem_name("SL104 - CHICKEN PLATE ");
		newitem.setItem_uom_name("Plate");
		newitem.setItem_cost(100);
		selling_itemList.add(newitem);
		
		newitem=new Customer_Billing_DTO();
		newitem.setItem(3);
		newitem.setItem_name("SL105 - PANEER PLATE ");
		newitem.setItem_uom_name("Plate");
		newitem.setItem_cost(100);
		selling_itemList.add(newitem);
	}

	public void addBillingItem(Customer_Billing_DTO selectitemData) {
		bill_head.getBilling_ItemList().add(selectitemData);
//		selectData=new Customer_Billing_DTO();
	}
}
