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
import co.orffosoft.dto.ProductVarietyMasterDTO;
import co.orffosoft.dto.ProductVariryMastersearchDTO;
import co.orffosoft.dto.WrapperDTO;
import co.orffosoft.service.ProductVarietyMasterService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/itemmaster")
public class ProductVarietyMasterController {

	@Autowired
	ProductVarietyMasterService productVarietyMasterService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public BaseDTO create(@RequestBody ProductVarietyMasterDTO productVarietyMasterDTO) {
		log.info("ProductVarietyMasterController  create---------#Start");
		BaseDTO baseDto = productVarietyMasterService.create(productVarietyMasterDTO);
		return baseDto;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public BaseDTO update(@RequestBody ProductVarietyMasterDTO productVarietyMasterDTO) {
		log.info("ProductVarietyMasterController  update---------#Start");
		BaseDTO baseDto = productVarietyMasterService.update(productVarietyMasterDTO);
		return baseDto;

	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public WrapperDTO getProductVariery() {
		log.info("ProductVarietyMasterController  getProductVariery---------#Start");
		WrapperDTO wrapperDTO = productVarietyMasterService.getProductVariery();
		return wrapperDTO;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> getVaritybyId(@RequestBody ProductVarietyMasterDTO productVarietyMasterDTO) {
		log.info("<< == Inside ProductVariuetyControler >>  getVaritybyId Method == >>");
		BaseDTO baseDTO = new BaseDTO();
		baseDTO = productVarietyMasterService.getVaritybyId(productVarietyMasterDTO.getId());

		if (baseDTO != null) {
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public BaseDTO delete(@PathVariable Long id) {
		log.info("<--- Starts ProductVarietyMasterController Delete  --->");
		BaseDTO baseDto = productVarietyMasterService.delete(id);
		log.info("<--- Ends ProductVarietyMasterController Delete  --->");
		return baseDto;
	}

	@RequestMapping(value = "/searchvaritys", method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> searchVarities(
			@RequestBody ProductVariryMastersearchDTO productVariryMastersearchDTO) {
		log.info("<< == Start Of Retail Society Plan Search == >>");
		BaseDTO baseDTO = new BaseDTO();
		baseDTO = productVarietyMasterService.searchProductVarities(productVariryMastersearchDTO);

		if (baseDTO != null) {
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(value = "/getuoms", method = RequestMethod.GET)
	public BaseDTO getUOM() {
		log.info("<--- Starts ProductVarietyMasterController getUOM  --->");
		BaseDTO baseDto = productVarietyMasterService.getUOM();
		log.info("<--- Ends ProductVarietyMasterController getUOM   --->");
		return baseDto;
	}

	@RequestMapping(value = "/getallproductvarietys", method = RequestMethod.GET)
	public ResponseEntity<BaseDTO> getAllProductVarietys() {
		log.info("<--- Starts ProductVarietyMasterController getAllProductVarietys  --->");
		BaseDTO baseDto = productVarietyMasterService.getAllProductVarietys();
		log.info("<--- Ends ProductVarietyMasterController getAllProductVarietys  --->");
		if (baseDto != null) {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BaseDTO>(baseDto, HttpStatus.NO_CONTENT);
		}
	}
}
