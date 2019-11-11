package co.orffosoft.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.Util;
import co.orffosoft.dto.AppFeatureDto;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.RoleDTO;
import co.orffosoft.entity.AppFeature;
import co.orffosoft.entity.RoleMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service("roleBean")
@Log4j2
@Scope("session")
public class RoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String serverURL = AppUtil.getPortalServerURL();

	@Autowired
	HttpService httpService;

	@Autowired
	LoginBean loginBean;

	@Getter
	@Setter
	String action;

	@Getter
	@Setter
	String ADD_FORM_URL = "/pages/masters/createRole.xhtml?faces-redirect=true";

	@Getter
	@Setter
	RoleMaster selectedRole;

	@Getter
	@Setter
	private TreeNode root;

	@Getter
	@Setter
	private List<TreeNode> treeNodes = new ArrayList<TreeNode>();

	@Getter
	@Setter
	private TreeNode[] selectedNodes;

	@Getter
	@Setter
	RoleMaster role = new RoleMaster();

	@Getter
	@Setter
	List<AppFeature> features = new ArrayList<>();

	@Getter
	@Setter
	List<AppFeatureDto> featureList = new ArrayList<>();

	@Getter
	@Setter
	List<Long> featureListId = new ArrayList<>();

	@Getter
	@Setter
	RoleDTO roleDto = new RoleDTO();

	public String loadRoleListPage() {

		featureList = new ArrayList<>();
		featureList = new ArrayList<>();
		roleDto = new RoleDTO();

		log.info("Loading role create page");
		return "/pages/masters/createRole.xhtml?faces-redirect=true;";
	}

	public void clear() {
		loadRoleListPage();
		log.info("clear called");
	}

	public void updateFeature() {
		log.info("<---------Loading updateFeature.....--------->");
		try {
			if (roleDto != null) {
				if (roleDto.getRoleName() != null && roleDto.getRoleName().isEmpty()) {
					getAllFeatrues();
				}
			}

		} catch (Exception e) {
			log.error(" ===== >> Exception Occured In updateFeature === >> ", e);
		}
	}

	public void getAllFeatrues() {
		log.info("<---------Loading loadAllRoleList List.....--------->");
		try {
			featureList = new ArrayList<>();
			selectedRole = new RoleMaster();
			BaseDTO response = new BaseDTO();
			String url = serverURL + "/role/getall";
			response = httpService.get(url);

			if (response != null && response.getStatusCode() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String jsonResponse = mapper.writeValueAsString(response.getResponseContents());
				featureList = mapper.readValue(jsonResponse, new TypeReference<List<AppFeatureDto>>() {
				});
			}

		} catch (Exception e) {
			log.error("Exception occured while loadAllRoleList ... ", e);
		}
	}

	public void submit() {
		log.info("<<<<<<<<<========Start Role submit ===== >>>>>>>>>>");
		try {
			BaseDTO baseDTO = null;
			log.info("Add::::::" + action);
			if (action.equals("ADD")) {
				if (roleDto == null) {
					Util.addWarn("Role is empty");
					return;
				}
				if (roleDto.getRoleName() == null || roleDto.getRoleName().isEmpty()) {
					Util.addWarn("Role name is required");
					return;
				}
				if (roleDto.getApplication() == null) {
					log.info("Application:::::" + roleDto.getApplication());
					Util.addWarn("Application is required");
					return;
				}

				List<Long> featureList = featureListId.stream().distinct().collect(Collectors.toList());
				log.info("selected features::::::" + featureListId);
				UserMaster createdBy = loginBean.getUserDetailSession();
				roleDto.setCreatedBy(createdBy.getId());
				roleDto.setFeaturesList(featureList);
				String url = serverURL + "/role/add";
				baseDTO = httpService.post(url, roleDto);

			}
			if (baseDTO != null) {
				if (baseDTO.getStatusCode() == 1022) {
					Util.addInfo("Role Added successfully");
				}
				if (baseDTO.getStatusCode() == 1023) {
					Util.addInfo("Role updated successfully");
				}

				if (baseDTO.getStatusCode() == 1021) {
					log.info("<<<< --- error code--->>>" + 1021);
					Util.addWarn("Duplicate Role name");
					return;
				}
			}

		} catch (Exception e) {
			log.info("Exception occured while submitting role....... ", e);
		}

		log.info("<<<<<<<<<========End Role submit ===== >>>>>>>>>>");
		log.info("Redirecting to Role List Page ..... ");

	}

	
}