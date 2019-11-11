package co.orffosoft.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.ErrorCodeDescription;
import co.orffosoft.core.util.Util;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("entityMasterBean")
@Scope("session")
public class EntityMasterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8596993769669674996L;

	private final String INPUT_FORM_ADD_URL = "/pages/masters/createEntityMaster.xhtml?faces-redirect=true;";

	private final String INPUT_FORM_LIST_URL = "/pages/masters/listEntityMaster.xhtml?faces-redirect=true;";

	@Getter
	@Setter
	String buttonName;

	@Getter
	@Setter
	private String onchandgeName;

	@Getter
	@Setter
	private String serverURL;

	

	@Getter
	@Setter
	private EntityMaster selectedRegion = new EntityMaster();

	@Autowired
	HttpService httpService;

	@Getter
	@Setter
	int regionListSize;

	@Autowired
	LoginBean loginBean;

	@Getter
	@Setter
	private List<EntityMaster> regionList = new ArrayList<EntityMaster>();

	@Getter
	@Setter
	String action;
	
	@Getter
	@Setter
	EntityMaster entityMaster = new EntityMaster();
	
	@Autowired
	ErrorMap errorMap;

	public String showList() {
		log.info("<---------------Redirecting to region list page---------------->");
		loadValues();
		getAllRegion();
		entityMaster = new EntityMaster();
		selectedRegion = new EntityMaster();
		return INPUT_FORM_LIST_URL;
	}

	private void loadValues() {
		try {
			serverURL = AppUtil.getPortalServerURL();
		} catch (Exception e) {
			log.fatal("Exception at loadValues() >>>> " + e.toString());
		}
		log.info("<------Server url----->" + serverURL);
	}

	public void getAllRegion() {
		log.info("<--------Loading region list-->getAllRegion()---------->");
		try {
			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/entitymaster/getallentitymasterregionwise";
			log.info("<----Get all region api = " + url);
			baseDTO = httpService.get(url);
			if (baseDTO != null) {
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
				regionList = mapper.readValue(jsonResponse, new TypeReference<List<EntityMaster>>() {
				});
				if(regionList!=null)
					regionListSize = regionList.size();
				log.info("<---Responsed recieved--- List size = " + regionListSize);

			}
		} catch (JsonProcessingException e) {
			log.error("Json processing exception occured while converting ... ", e);
		} catch (IOException e) {
			log.error("IO Exception occured ... ", e);
		} catch (Exception e) {
			log.error("Exception occured while fetching Regions ... ", e);
		}
	}
	/*private void filterDates(Date createdDate)  {
		List<EntityMaster> tempList=regionList;
		tempList.stream()
                .filter(dates -> dates.after(start) && dates.before(end))
                .collect(Collectors.toList())
                .forEach(januaryDate->System.out.println(januaryDate));
    }*/
	public String addRegion() {
		log.info("==>> RegionBean inside addRegion() <<== Start");
		entityMaster = new EntityMaster();
		entityMaster.setActiveStatus(true);
		action="ADD";
		log.info("==>> RegionBean inside addRegion() <<== End");
		return INPUT_FORM_ADD_URL;
	}

	public String saveRegion() {
		try {
			log.info("Save rgion called=---->" + entityMaster.getName());
			UserMaster existingUser = new UserMaster();
			existingUser.setId(loginBean.getUserDetailSession().getId());
			entityMaster.setCreatedBy(existingUser);

			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/entitymaster/add";
			baseDTO = httpService.post(url, entityMaster);
			if (baseDTO.getStatusCode() == 1250) {
				errorMap.notify(baseDTO.getStatusCode());
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			} else if (baseDTO.getStatusCode() == 1251) {
				errorMap.notify(baseDTO.getStatusCode());
				return null;
			} else if (baseDTO.getStatusCode() == 1259) {
				errorMap.notify(baseDTO.getStatusCode());
				return null;
			} else {
				errorMap.notify(baseDTO.getStatusCode());
				return null;
			}
			entityMaster = new EntityMaster();
			getAllRegion();
		} catch (Exception e) {
			log.error("===>>  Exception occured <<===<", e);
			Util.addError("Something went wrong");
			return null;
		}
		log.info("==>> RegionBean inside saveRegion() <<== End");
		return INPUT_FORM_LIST_URL;
	}

	public String cancel() {
		log.info("==>> RegionBean inside cancel() <<== Start");
		entityMaster = new EntityMaster();
		selectedRegion = new EntityMaster();
		getAllRegion();
		return INPUT_FORM_LIST_URL;
	}

	public String editRegion() {
		log.info("==>> RegionBean inside editRegion() <<== Start");
		action = "EDIT";
		if (selectedRegion == null) {
			Util.addWarn("Please select one region");
			return null;
		}
		entityMaster = selectedRegion;
		return INPUT_FORM_ADD_URL;
	}

	public String deleteRegion() {
		log.info("==>> RegionBean inside deleteRegion() <<== Start");
		if (selectedRegion == null || selectedRegion.getName().isEmpty()) {
//			Util.addWarn(
//					ErrorCodeDescription.getDescription(ErrorCodeDescription.ERROR_REGION_REQUIRED.getErrorCode()));
			return null;
		} else {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('confirmdelete').show();");
		}
		return null;
	}

	public String confirmDelete() {
		try {
			log.info("==>> RegionBean inside confirmDelete() <<== Start" + selectedRegion);
			entityMaster = selectedRegion;
			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/entitymaster/deleteentitymaster";
			baseDTO = httpService.post(url, entityMaster);
			log.info("Response  " + baseDTO);
			if (baseDTO != null) {
				if (baseDTO.getStatusCode() == 1257) {
					errorMap.notify(baseDTO.getStatusCode());
					FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
					getAllRegion();
				} else if (baseDTO.getStatusCode() == 4209) {
					errorMap.notify(baseDTO.getStatusCode());
					FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
					getAllRegion();
				} else if (baseDTO.getStatusCode() == 1251) {
					Util.addWarn("Can't delete deleted recoded");
					return null;
				} else if (baseDTO.getStatusCode() == 1365) {
					Util.addWarn("Record is already deleted by another user");
					return null;
				} else {errorMap.notify(baseDTO.getStatusCode());}
			}
			entityMaster = new EntityMaster();
			selectedRegion = new EntityMaster();
		} catch (Exception e) {
			log.error("exception while deleting region", e);
			Util.addError("Region not delete successfully");
			return null;
		}
		log.info("==>> RegionBean inside deleteRegion() <<== End");
		return INPUT_FORM_LIST_URL;
	}

	public String updateRegion() {
		try {
			log.info("==>> RegionBean inside updateRegion() <<== Start");
			UserMaster userentity = new UserMaster();
			selectedRegion = new EntityMaster();
			userentity.setId(loginBean.getUserDetailSession().getId());
			entityMaster.setModifiedBy(userentity);
			entityMaster.setModifiedDate(new Date());
			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/entitymaster/updateentitymaster";
			baseDTO = httpService.put(url, entityMaster);
			log.info("response---->"+baseDTO);
			if (baseDTO != null) {
				if (baseDTO.getStatusCode() == 1254) {
					errorMap.notify(baseDTO.getStatusCode());
					FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
					selectedRegion = new EntityMaster();
					entityMaster = new EntityMaster();
					getAllRegion();
				} else if (baseDTO.getStatusCode() == 1251) {
					errorMap.notify(baseDTO.getStatusCode());
					return null;
				} else if (baseDTO.getStatusCode() == 1003) {
					Util.addWarn("Can't update locked recoded");
					return null;
				} else if (baseDTO.getStatusCode() == 1004) {
					Util.addWarn("Can't update deleted recoded");
					return null;
				} else {
					errorMap.notify(baseDTO.getStatusCode());
				}
			}
		} catch (Exception e) {
			log.error("Exception whiile updating region", e);
			//errorMap.notify(ErrorCodeDescription.ERROR_GENERIC.getErrorCode());
			return null;
		}
		return INPUT_FORM_LIST_URL;
	}

	public String clear() {
		log.info("==>> RegionBean inside clear() <<== Start");
		entityMaster = new EntityMaster();
		selectedRegion = new EntityMaster();
		log.info("==>> RegionBean inside clear() <<== End");
		return INPUT_FORM_LIST_URL;
	}

}
