package co.orffosoft.controller;

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
import co.orffosoft.dto.StockItemInwardPNSDTO;
import co.orffosoft.service.StockItemInwardPNSService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("${operation.api.url}/stockItemInwardPNS")
@Api(tags = "StockItemInwardPNS", value = "StockItemInwarnPNS Request")
@Log4j2
public class StockItemInwardPNSController {

	@Autowired
	StockItemInwardPNSService stockItemInwardPNSService;
	
	
	
	
	
	@RequestMapping(value = "/getAllProductVariety/{id}", method = RequestMethod.GET)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS") })
	public @ResponseBody ResponseEntity<BaseDTO> getAllProductVariety(@PathVariable("id") Long id) {
		log.info("<--- Received getPurchaseOrder .create() ---> ");
		//@RequestBody PurchaseOrderItems items
		BaseDTO baseDTO = new BaseDTO();
		baseDTO = stockItemInwardPNSService.getAllProductVariety();
		if (baseDTO != null) {
			log.info("<--- Starts getAllProductVariety .fetch Success() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			log.error("<--- Starts getAllProductVariety .created Failed() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}

	}
	
	//submit data
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseDTO> saveStockInward(@RequestBody StockItemInwardPNSDTO stockUpload) {
		log.info("<--- Received PurchaseOrderItems .create() ---> ");
		BaseDTO baseDTO = new BaseDTO();
		baseDTO = stockItemInwardPNSService.saveStockItem(stockUpload);
		if (baseDTO != null) {
			log.info("<--- Save ItemInwardnPNS Items Success() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			log.error("<--- save ItemInwardnPNS created Failed() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}

	}
	
	//update ItemInward
	@RequestMapping(value = "/updateStockTransferInward", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseDTO> updateStockInward(@RequestBody StockItemInwardPNSDTO stockItem) {
		log.info("<--- Received Update ItemInward ItemInwardnPNS.create() ---> ");
		BaseDTO baseDTO = new BaseDTO();
		baseDTO = stockItemInwardPNSService.updateStockItemInward(stockItem);
		if (baseDTO != null) {
			log.info("<--- Update ItemInward ItemInwardnPNS Success() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			log.error("<--- Update ItemInward ItemInwardnPNS created Failed() ---> ");
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}

	}
	
	
	@RequestMapping(value = "/searchData", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> search(@RequestBody StockItemInwardPNSDTO request) {
		log.info("stockItemInwardPNSService Controller:search() [" + request + "]");
		BaseDTO baseDTO = stockItemInwardPNSService.lazySearchStockTransfer(request);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getAllProductVarietyMasterList/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> getAllProductVarietyMasterList(@PathVariable("id") Long id) {
		log.info("getAllProductVarietyMasterList Controller Receive ");
		BaseDTO baseDTO = stockItemInwardPNSService.getAllProductVarietyMasterList(id);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	@RequestMapping(value = "/selectedProductVarietyMasterID/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> selectedProductVarietyMasterID(@PathVariable("id") Long id) {
		log.info("getAllProductVarietyMasterList Controller Receive ");
		BaseDTO baseDTO = stockItemInwardPNSService.getSelectedProductVarietyMaster(id);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autocompletesupplierCode/{suppliercode}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> autoCompleteSupplier(@PathVariable("suppliercode") String suppliercode) {
		log.info("generateATNumber Controller Receive ");
		BaseDTO baseDTO = stockItemInwardPNSService.autoCompleteSupplier(suppliercode);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autocompleteitemName/{itemname}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> autoCompleteItem(@PathVariable("itemname") String itemName) {
		log.info("generateATNumber Controller Receive ");
		BaseDTO baseDTO = stockItemInwardPNSService.autoCompleteItem(itemName);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
}
