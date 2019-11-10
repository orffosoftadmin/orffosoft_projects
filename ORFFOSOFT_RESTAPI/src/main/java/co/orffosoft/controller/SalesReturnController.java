package co.orffosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.SalesReturnDTO;
import co.orffosoft.service.SalesReturnService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/salesReturnController")
@Log4j2
public class SalesReturnController {
	
	@Autowired
	SalesReturnService salesReturnService;
	
	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> autoCompleteMobileNo(@RequestBody SalesReturnDTO dto) {
		log.info("SalesReturnController Controller Receive ");
		BaseDTO baseDTO = salesReturnService.generateReport(dto);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/submitsalesreturn", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> submit(@RequestBody SalesReturnDTO dto) {
		log.info("SalesReturnController Controller Receive ");
		BaseDTO baseDTO = salesReturnService.submit(dto);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/getbilldetailsbyid", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> getBillDetailsByID(@RequestBody SalesReturnDTO dto) {
		log.info("SalesReturnController Controller Receive ");
		BaseDTO baseDTO = salesReturnService.getBillDetailsByID(dto);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}

}
