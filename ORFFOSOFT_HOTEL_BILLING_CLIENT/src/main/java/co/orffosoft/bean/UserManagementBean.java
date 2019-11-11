package co.orffosoft.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.ProductVarietyMasterDTO;
import co.orffosoft.dto.UserMasterDTO;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.utill.ErrorMap;
import co.orffosoft.utill.HttpService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service("userManagementBean")
@Log4j2
@Scope("session")
public class UserManagementBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	UserMasterDTO userMasterDTO = null;

	@Getter
	@Setter
	String action;

	private final String SIGNUP_NEWUSER = "/signup.xhtml?faces-redirect=true;";
	private final String LOGIN_PAGE = "/login.xhtml?faces-redirect=true;";
	private final String ADD_PAGE = "/pages/userManagement/createUser.xhtml?faces-redirect=true;";
	private final String LIST_PAGE = "/pages/userManagement/listUser.xhtml?faces-redirect=true;";
	private final String VIEW_PAGE = "/pages/userManagement/viewUser.xhtml?faces-redirect=true;";
	
	private final String VIEW_PRODUCT_VARITY_MASTER = "/pages/masters/viewProductVariety.xhtml?faces-redirect=true;";

	@Getter
	@Setter
	String serverURL = null;

	@Autowired
	HttpService httpService;

	@Autowired
	ErrorMap errorMap;

	@Autowired
	LoginBean loginBean;

	@Getter
	@Setter
	List<UserMaster> userMasterList = new ArrayList<UserMaster>();

	@Getter
	@Setter
	private Integer userMasterListSize;

	@Getter
	@Setter
	UserMaster selectedUser = new UserMaster();

	@Value("${server.session.timeout}")
	public Integer sessionTimeOut;

	@PostConstruct
	public void init() {
		userMasterDTO = new UserMasterDTO();
		serverURL = AppUtil.getPortalServerURL();
	}

	/**
	 * @return
	 */
	public String newUser() {
		if (action.equalsIgnoreCase("NEW_SIGNUP")) {
			return SIGNUP_NEWUSER;
		} else {
			return LOGIN_PAGE;
		}

	}

	public String addUser() {
		userMasterDTO = new UserMasterDTO();
		return ADD_PAGE;

	}

	/**
	 * 
	 */
	public void submit() {
		try {
			boolean valid = validate();
			if (valid) {
				if (userMasterDTO != null) {
					if (action.equalsIgnoreCase("REGISTER_WITH_NEW_STORE")) {
						userMasterDTO.setUserType("Admin");
						userMasterDTO.setStatus(true);
						BaseDTO baseDTO = new BaseDTO();
						String url = serverURL + "/user/add";
						baseDTO = httpService.post(url, userMasterDTO);
						if (baseDTO != null) {
							if (baseDTO.getGeneralContent() != null) {
								AppUtil.addWarn(baseDTO.getGeneralContent());
							} else {
								AppUtil.addInfo("Successfully Registered . Please Login ");
								RequestContext context = RequestContext.getCurrentInstance();
								context.execute("PF('goToLoginPage').show();");
								newUser();
							}

						}
					} else {
						userMasterDTO.setId(loginBean.getUserMaster().getId());
						userMasterDTO.setUserType(userMasterDTO.getRoleName());
						userMasterDTO.setStatus(true);
						BaseDTO baseDTO = new BaseDTO();
						String url = serverURL + "/user/add";
						baseDTO = httpService.post(url, userMasterDTO);
						if (baseDTO != null) {
							AppUtil.addInfo("Successfully Registered ");

						}
					}

				}

			}

		} catch (Exception e) {
			log.error("Exception Occured in Submit Button UserManagementBean== ", e);
		}

	}

	private boolean validate() {
		boolean valid = true;
		userMasterDTO.setUsername(userMasterDTO.getUsername().trim());

		if (userMasterDTO.getUsername() == null || userMasterDTO.getUsername().isEmpty()) {
			AppUtil.addError("Please Enter User Name");
			valid = false;
		} else if (userMasterDTO.getPassword() == null || userMasterDTO.getPassword().isEmpty()) {
			AppUtil.addError("Please Enter Password");
			valid = false;
		} else if (userMasterDTO.getConfirmPassword() == null || userMasterDTO.getConfirmPassword().isEmpty()) {
			AppUtil.addError("Please Enter Confirm Password");
			valid = false;
		} else if (!userMasterDTO.getPassword().equals(userMasterDTO.getConfirmPassword())) {
			AppUtil.addError("Confirm Password Not Matching to Password");
			valid = false;
		}

		if (action.equalsIgnoreCase("REGISTER_WITH_NEW_STORE")) {

			if (userMasterDTO.getStoreCode() == null || userMasterDTO.getStoreCode().isEmpty()) {
				AppUtil.addError("Please Enter Store Code");
				valid = false;
			} else if (userMasterDTO.getStoreName() == null || userMasterDTO.getStoreName().isEmpty()) {
				AppUtil.addError("Please Enter Store Name");
				valid = false;
			}
			userMasterDTO.setStoreName(userMasterDTO.getStoreName().trim());
			userMasterDTO.setStoreCode(userMasterDTO.getStoreCode().trim());
		}

		if (action.equalsIgnoreCase("REGISTER_WITH_OLD_STORE")) {
			if (userMasterDTO.getRoleName() == null || userMasterDTO.getRoleName().isEmpty()) {
				AppUtil.addError("Please Select Role Name");
				valid = false;
			}

		}

		return valid;

	}

	public String showList() {
		log.info("<---------- Loading user list page---------->");
		serverURL = AppUtil.getPortalServerURL();
		loadAllUserList();
		return "/pages/userManagement/listUser.xhtml?faces-redirect=true";
	}

	public void loadAllUserList() {
		log.info("<<<< ----------Start UsermangementBean . loadAllUserList ------- >>>>");
		try {
			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/user/getall";
			baseDTO = httpService.get(url);
			userMasterList = new ArrayList<>();
			if (baseDTO != null) {
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContents());
				userMasterList = mapper.readValue(jsonResponse, new TypeReference<List<UserMaster>>() {
				});
			}
		} catch (JsonProcessingException jpEx) {
			log.error("Json processing exception occured while converting .... ", jpEx);
		} catch (IOException ioEx) {
			log.error("IO Exception occured .... ", ioEx);
		} catch (Exception e) {
			log.error("Exception occured .... ", e);
		}

		if (userMasterList != null)
			userMasterListSize = userMasterList.size();
		else
			userMasterListSize = 0;
		log.info("<<<< ----------End UsermangementBean . loadAllUserList ------- >>>>");
	}

	public String showEditForm() {
		if (selectedUser == null || selectedUser.getId() == null) {
			AppUtil.addWarn("Please Select At Least One Record");
			return null;
		}
		try {
			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/user/getbyId";
			baseDTO = httpService.post(url, selectedUser);
			if (baseDTO != null && baseDTO.getResponseContent() != null && baseDTO.getStatusCode() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
				userMasterDTO = mapper.readValue(jsonResponse, UserMasterDTO.class);
			}

		} catch (Exception e) {
			log.error("<<====   ERROR::: " + e);
		}
		return ADD_PAGE;
	}

	public String showViewForm() {

		if (selectedUser == null || selectedUser.getId() == null) {
			AppUtil.addWarn("Please Select At Least One Record");
			return null;
		}
		try {
			BaseDTO baseDTO = new BaseDTO();
			String url = serverURL + "/user/getbyId";
			baseDTO = httpService.post(url, selectedUser);
			if (baseDTO != null && baseDTO.getResponseContent() != null && baseDTO.getStatusCode() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				String jsonResponse = mapper.writeValueAsString(baseDTO.getResponseContent());
				userMasterDTO = mapper.readValue(jsonResponse, UserMasterDTO.class);
			}

		} catch (Exception e) {
			log.error("<<====   ERROR::: " + e);
		}

		return VIEW_PAGE;
	}

}
