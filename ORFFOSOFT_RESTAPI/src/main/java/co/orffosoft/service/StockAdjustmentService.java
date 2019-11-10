package co.orffosoft.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.DailyStockTransactionReportDTO;
import co.orffosoft.repository.ItemPriceRepository;
import co.orffosoft.repository.ProductVarietyMasterRepository;
import co.orffosoft.repository.StockTransactionRepository;
import co.orffosoft.repository.StockTransactionTypeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class StockAdjustmentService {
	
	@Autowired
	LoginService loginService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StockTransactionRepository stockTransactionRepository;

	@Autowired
	StockTransactionTypeRepository stockTransactionTypeRepository;

	@Autowired
	ItemPriceRepository itemPriceRepository;

	@Autowired
	ProductVarietyMasterRepository productVarietyMasterRepository;

	@PersistenceContext
	EntityManager manager;

	@Transactional
	public BaseDTO generateReport(DailyStockTransactionReportDTO items) {
		log.info(" >> DailyTransactionReportService >>  generateReport method >> ");
		BaseDTO response = new BaseDTO();
		try {
			
			
			response.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getCode());
			log.info("<<<  === Success Response === >>>");
		} catch (Exception e) {
			log.error(" >>  Exception Occured In DailyTransactionReportService >> generateReport method >> ", e);
		}
		return response;
	}

}
