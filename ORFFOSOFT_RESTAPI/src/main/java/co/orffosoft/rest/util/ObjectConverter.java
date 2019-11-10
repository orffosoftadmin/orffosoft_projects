package co.orffosoft.rest.util;

import co.orffosoft.dto.ProductVarietyMasterDTO;
import co.orffosoft.entity.ProductVarietyMaster;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ObjectConverter {

	/**
	 * converting ProductVarietyMaster Entity to ProductVarietyMasterDTO
	 */
	public static ProductVarietyMasterDTO productVarietyMasterToProductVarietyMasterDTO(
			ProductVarietyMaster productVarietyMaster) {
		ProductVarietyMasterDTO productVarietyMasterDTO = new ProductVarietyMasterDTO();
		productVarietyMasterDTO.setId(productVarietyMaster.getId());
		productVarietyMasterDTO.setCode(productVarietyMaster.getCode());
		productVarietyMasterDTO.setName(productVarietyMaster.getName());
		productVarietyMasterDTO.setLname(productVarietyMaster.getLname());
		productVarietyMasterDTO.setLengthActual(productVarietyMaster.getLengthActual());
		productVarietyMasterDTO.setLengthTolerance(productVarietyMaster.getLengthTolerance());
		productVarietyMasterDTO.setWidthActual(productVarietyMaster.getWidthActual());
		productVarietyMasterDTO.setWidthTolerance(productVarietyMaster.getWidthTolerance());

		productVarietyMasterDTO.setWarpYarnWeight(productVarietyMaster.getWarpYarnWeight());
		productVarietyMasterDTO.setWarpYarnCountActual(productVarietyMaster.getWarpYarnCountActual());
		productVarietyMasterDTO.setWarpYarnCountTolerance(productVarietyMaster.getWarpYarnCountTolerance());
		productVarietyMasterDTO.setWeftYarnWeight(productVarietyMaster.getWeftYarnWeight());
		productVarietyMasterDTO.setWeftYarnCountActual(productVarietyMaster.getWeftYarnCountActual());
		productVarietyMasterDTO.setWeftYarnCountTolerance(productVarietyMaster.getWeftYarnCountTolerance());
		productVarietyMasterDTO.setPicksPerInchActual(productVarietyMaster.getPicksPerInchActual());
		productVarietyMasterDTO.setPicksPerInchTolerance(productVarietyMaster.getPicksPerInchTolerance());
		productVarietyMasterDTO.setEndspPerInchActual(productVarietyMaster.getEndspPerInchActual());
		productVarietyMasterDTO.setEndsPerInchTolerance(productVarietyMaster.getEndsPerInchTolerance());
		productVarietyMasterDTO.setActiveStatus(productVarietyMaster.getActiveStatus());
		productVarietyMasterDTO.setCreatedDate(productVarietyMaster.getCreatedDate());

		if (productVarietyMaster.getModifiedBy() != null && productVarietyMaster.getModifiedDate() != null) {
			productVarietyMasterDTO.setModifiedDate(productVarietyMaster.getModifiedDate());
		}
		productVarietyMasterDTO.setVersion(productVarietyMaster.getVersion());

		return productVarietyMasterDTO;

	}

}
