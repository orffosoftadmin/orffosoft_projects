package co.orffosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.WrapperDTO;
import co.orffosoft.service.ErrorMasterService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/errors")
public class ErrorMasterController {

	@Autowired
	ErrorMasterService errorMasterService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<WrapperDTO> getAll() {
		log.info("ErrorMasterController:getAll()");
		WrapperDTO wrapperDTO = errorMasterService.getAll();
		return new ResponseEntity<WrapperDTO>(wrapperDTO, HttpStatus.OK);
	}
}
