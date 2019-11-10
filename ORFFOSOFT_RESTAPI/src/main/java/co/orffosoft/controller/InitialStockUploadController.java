package co.orffosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.InitialStockUploadDTO;
import co.orffosoft.service.InitialStockUploadService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/initialStockUploadController")
public class InitialStockUploadController {
	
	@Autowired
	InitialStockUploadService initialStockUploadService;
	
	@RequestMapping(value = "/saveinitialstockupload", method = RequestMethod.POST)
	public BaseDTO create(@RequestBody List<InitialStockUploadDTO> dtoList) {
		log.info("InitialStockUploadController  create---------#Start");
		BaseDTO baseDto = initialStockUploadService.SaveInitialStockUpload(dtoList);
		return baseDto;

	}

}
