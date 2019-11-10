package co.orffosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.DailyTransactionReportDTO;
import co.orffosoft.service.DailyTransactionReportService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/dailyTransactionReportController")
@Log4j2
public class DailyTransactionReportController {
	
	@Autowired
	DailyTransactionReportService dailyTransactionReportService;
	
	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> autoCompleteMobileNo(@RequestBody DailyTransactionReportDTO dto) {
		log.info("generateATNumber Controller Receive ");
		BaseDTO baseDTO = dailyTransactionReportService.generateReport(dto);
		return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
	}

}
