package co.orffosoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.service.SupplierMasterService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/supplier/master")
public class SupplierMasterController {
	
	@Autowired
	SupplierMasterService supplierMasterService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public ResponseEntity<BaseDTO> create(@RequestBody SupplierMaster supplierMaster) {
		log.info("<--Starts SupplierMasterController .create-->");
		BaseDTO baseDTO = supplierMasterService.create(supplierMaster);
		log.info("<--Ends SupplierMasterController .create-->");
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK); 

	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/search")
	public BaseDTO search(@RequestBody SupplierMaster supplierMaster) {
		log.info("<< SupplierMasterController.search >>" + supplierMaster);
		return supplierMasterService.search(supplierMaster);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
	public BaseDTO get(@PathVariable Long id) {
		log.info("<< SupplierMasterController.get >>" + id);
		return supplierMasterService.get(id);

	}
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/update")
	public ResponseEntity<BaseDTO> update(@RequestBody SupplierMaster supplierMaster) {
		log.info("<--Starts SupplierMasterController .update-->");
		BaseDTO baseDTO = supplierMasterService.update(supplierMaster);
		log.info("<--Ends SupplierMasterController .update-->");
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK); 

	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/delete/{id}")
	public BaseDTO delete(@PathVariable Long id) {
		log.info("<< SupplierMasterController.delete >>" + id);
		return supplierMasterService.delete(id);

	}
	
	
	@RequestMapping(value = "/loadsupplierautocomplete/{supplierName}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> loadSupplierAutoComplete(@PathVariable String supplierName) {
		log.info("<--Starts SupplierMasterController .loadSupplierAutoComplete--> " + supplierName);
		BaseDTO baseDTO = supplierMasterService.loadSupplierAutoComplete(supplierName);
		log.info("<--Ends SupplierMasterController .loadSupplierAutoComplete-->");
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/getAllSuplierMaster", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> getAllFuelCoupon() {
		BaseDTO baseDTO = supplierMasterService.getAllSuplierMasterServices();
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/getByUserId/{userId}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> getSupplierMasterByUserId(@PathVariable  Long userId) {
		log.info("<--Starts SupplierMasterController .getSupplierMasterByUserId-->");
		BaseDTO baseDTO = supplierMasterService.getSupplierMasterByUserId(userId);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	
	
}
