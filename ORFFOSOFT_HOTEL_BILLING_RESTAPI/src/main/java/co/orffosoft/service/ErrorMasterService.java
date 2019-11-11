package co.orffosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorCodeDescription;
import co.orffosoft.dto.WrapperDTO;
import co.orffosoft.entity.ErrorMaster;
import co.orffosoft.repository.ErrorMasterRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ErrorMasterService {

	@Autowired
	ErrorMasterRepository errorMasterRepository;

	public WrapperDTO getAll() {

		log.info("ErrorMasterService:findAll()");

		WrapperDTO wrapperDTO = new WrapperDTO();

		try {

			List<ErrorMaster> list = errorMasterRepository.findAll();

			log.info("Successfully getting list.");

			wrapperDTO.setErrorMasterList(list);
			wrapperDTO.setStatusCode(ErrorCodeDescription.SUCCESS_RESPONSE.getErrorCode());

		} catch (Exception exception) {

			log.error("Exception in getAll ", exception);
			wrapperDTO.setStatusCode(ErrorCodeDescription.FAILURE_RESPONSE.getErrorCode());

		}

		return wrapperDTO;
	}
}
