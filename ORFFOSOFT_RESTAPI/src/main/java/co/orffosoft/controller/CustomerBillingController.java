package co.orffosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.CustomerBillingDTO;
import co.orffosoft.service.CustomerBillingService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customerbillingcontroller")
@Log4j2
public class CustomerBillingController {
	
	@Autowired
	CustomerBillingService customerBillingService;
	
	//This is method is user for get All Supplier_Type Details  
//		@RequestMapping(value = "/getcustomerdetails", method = RequestMethod.GET)
//		@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS") })
//		public ResponseEntity<BaseDTO> getCustomerDetails() {
//			log.info("getCustomerDetails Controller:get()");
//			BaseDTO baseDTO = customerBillingService.getAllSupplierType();
//			if (baseDTO != null) {
//				return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
//			}
//		}
		

//		@RequestMapping(value = "/getAllPurchaseOrderItem", method = RequestMethod.POST)
//		public @ResponseBody ResponseEntity<BaseDTO> getAllPurchaseOrderDetails(@RequestBody PurchaseOrderItems items) {
//			log.info("<--- Received PurchaseOrderItems .create() ---> ");
//			BaseDTO baseDTO = new BaseDTO();
//			baseDTO = customerBillingService.getSelectedPurchaseOrderItem(items.getId());
//			if (baseDTO != null) {
//				log.info("<--- Starts PurchaseOrderItems .fetch Success() ---> ");
//				return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
//			} else {
//				log.error("<--- Starts PurchaseOrderItems .created Failed() ---> ");
//				return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
//			}
//
//		}
	
	@RequestMapping(value = "/autocompletemobile/{mobileNo}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> autoCompleteMobileNo(@PathVariable String mobileNo) {
		log.info("generateATNumber Controller Receive ");
		BaseDTO baseDTO = customerBillingService.autoCompleteMobileNo(mobileNo);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/itempricedetails/{itemid}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> autoSearchItemName(@PathVariable Long itemid) {
		log.info("autoSearchItemName Controller Receive ");
		BaseDTO baseDTO = customerBillingService.findItemPriceDetails(itemid);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/billadd", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseDTO> getAllPurchaseOrderDetails(@RequestBody List<CustomerBillingDTO> items) {
		log.info("<--- Received PurchaseOrderItems .create() ---> ");
		BaseDTO baseDTO = new BaseDTO();
		baseDTO = customerBillingService.billCreation(items);
		if (baseDTO != null) {
			log.info("<--- Starts customerBillingService .fetch Success() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			log.error("<--- Starts customerBillingService .created Failed() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}

	}

}
