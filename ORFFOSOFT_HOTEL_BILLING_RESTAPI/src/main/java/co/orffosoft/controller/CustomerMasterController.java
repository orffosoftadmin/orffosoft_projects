package co.orffosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.CustomerMasterDTO;
import co.orffosoft.service.CustomerMasterService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("${operation.api.url}/customerMaster")
public class CustomerMasterController {

	@Autowired
	CustomerMasterService customerMasterService;

	@PreAuthorize("hasPermission(#customermasteradd, 'CUSTOMER_MASTER_ADD')")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> create(@RequestBody CustomerMasterDTO customerMaster) {
		log.info("<--- Starts CustomerMasterController create  --->");
		BaseDTO baseDto = customerMasterService.create(customerMaster);
		log.info("<--- Ends CustomerMasterController create  --->");
		if (baseDto != null) {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> getCustomer(@PathVariable Long id) {
		log.info("<--- Starts CustomerMasterController update  --->");
		BaseDTO baseDto = customerMasterService.getCustomerMaster(id);
		log.info("<--- Ends CustomerMasterController create  --->");
		if (baseDto != null) {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/nextsequenceconfigvalue", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> getNextSequenceConfigValue() {
		log.info("<--- Starts CustomerMasterController getNextSequenceConfigValue  --->");
		BaseDTO baseDto = customerMasterService.nextSequenceConfigValueForCustomerCode();
		log.info("<--- Ends CustomerMasterController getNextSequenceConfigValue  --->");
		if (baseDto != null) {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.NO_CONTENT);
		}
	}

	@PreAuthorize("hasPermission(#customermasterdelete, 'CUSTOMER_MASTER_DELETE')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> deleteCustomerMaster(@PathVariable Long id) {
		log.info("<<=========== CustomerMasterController ------  deleteCustomerMaster  ===###   STARTS");
		BaseDTO baseDTO = customerMasterService.deleteCustomer(id);
		log.info("<<=========== CustomerMasterController ------  deleteCustomerMaster  ===###   ENDS");
		if (baseDTO != null) {
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}
	}

}
