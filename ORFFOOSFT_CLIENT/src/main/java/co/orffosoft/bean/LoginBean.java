package co.orffosoft.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.core.util.AppUtil;
import co.orffosoft.core.util.CustomException;
import co.orffosoft.core.util.Util;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.LoginDTO;
import co.orffosoft.dto.LoginResponseDTO;
import co.orffosoft.dto.UserDTO;
import co.orffosoft.dto.UserInfoDTO;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.SupplierMaster;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.enums.AppConfigEnum;
import co.orffosoft.enums.UserType;
import co.orffosoft.utill.ErrorMap;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Scope("session")
public class LoginBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2436661126661137293L;

	private static final String APPNAME_PORTAL = "PORTAL";

	final String SERVER_URL = AppUtil.getPortalServerURL();

	final String DASHBOARD_VIEW = "DASHBOARD_VIEW";

	@Getter
	@Setter
	String username;

	@Getter
	@Setter
	String password;

	@Getter
	@Setter
	String message;

	@Getter
	@Setter
	public HttpEntity requestEntity;

	@Getter
	@Setter
	public MultiValueMap<String, String> headers;

	@Getter
	@Setter
	LoginBean login;

	@Getter
	@Setter
	String emailId;

	/*
	 * Rest object to 0call the REST API for authentication
	 */
	RestTemplate restTemplate;

	@Getter
	@Setter
	private String serverURL = null;

	@Getter
	@Setter
	LoginResponseDTO loginResponseDTO = null;

	@Getter
	@Setter
	private Map<String, Boolean> userFeatures = new HashMap<String, Boolean>();

	/** get the user details who logged in */
	@Getter
	@Setter
	UserDTO userDto;

	@Getter
	@Setter
	UserMaster userMaster;

	@Getter
	@Setter
	UserMaster userDetailSession;

	ExternalContext extCon;

	HttpSession session;

	HttpServletRequest req;

	@Value("${server.session.timeout}")
	public Integer sessionTimeOut;

	public static String AUTH_KEY = "name";

	@Getter
	@Setter
	private LoginResponseDTO loginResponse;

	@Autowired
	LanguageBean languageBean;

	@Autowired
	ErrorMap errorMap;

	@Getter
	@Setter
	TimeZone timeZone = TimeZone.getDefault();

	private SupplierMaster supplierMaster;

	private String defaultLandingPage;

	@Getter
	@Setter
	private String portalClientLandingUrl;

	@Getter
	@Setter
	String misTableRowSize;

	@Getter
	@Setter
	String misTablePageTemplate;

	@Getter
	@Setter
	private String casServerUrl;

	@Getter
	@Setter
	private String appName;

	@Getter
	@Setter
	private UserInfoDTO userInfoDTO;

	@Getter
	@Setter
	private List<LoginDTO> sellingProductList = new ArrayList<>();

	@Getter
	@Setter
	private LoginDTO loginDTO = new LoginDTO();

	@Getter
	@Setter
	private String action;

	@Getter
	@Setter
	private EntityMaster entityMaster;

	/**
	 * 
	 */
	public LoginBean() {
		restTemplate = new RestTemplate();
		loginDTO = new LoginDTO();
		sellingProductList = new ArrayList<>();

		log.info("Inside LoginBean()");
		loadValues();
	}

	/**
	 * 
	 */
	private void loadValues() {
		try {
			serverURL = AppUtil.getPortalServerURL();
			log.info("serverURL " + serverURL);

			loginDTO.setItemName("Fresh Milk");
			loginDTO.setSoldQuantity(10L);
			sellingProductList.add(loginDTO);

		} catch (Exception e) {
			log.fatal("Exception at loadValues() >>>> " + e.toString());
			e.printStackTrace();
		}
	}

	private String getHiddenValue(String paramName) {
		String hiddenValue = null;
		try {
			hiddenValue = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get(paramName);
		} catch (Exception e) {
			log.fatal("Exception at getHiddenValue() >>>> " + e.toString());
		}
		return hiddenValue;
	}

	private void setAppValues() {
		appName = getHiddenValue("appName");

		log.info("submit-appName " + appName);

		if (APPNAME_PORTAL.equals(appName)) {
			serverURL = AppUtil.getPortalServerURL();
			defaultLandingPage = AppUtil.getPortalDefaultLandingPage();
		}

		portalClientLandingUrl = AppUtil.getPortalClientURL() + AppUtil.getPortalLandingPage();

		log.info("defaultLandingPage==> " + defaultLandingPage);

	}

	public String submit() {
		log.info("Inside submit()");

		try {
			if (action != null) {
				if (action.equalsIgnoreCase("FORGOT")) {
					username = loginDTO.getUsername();
					password = loginDTO.getPassword();
					if (loginDTO.getStoreCode() == null || loginDTO.getStoreCode().trim().isEmpty()) {
						AppUtil.addWarn(" Please Enter Store Code ");
						log.info(" Please Enter Store Code ");
						return null;
					} else if (loginDTO.getUsername() == null || loginDTO.getUsername().trim().isEmpty()) {
						AppUtil.addWarn(" Please Enter User Name ");
						log.info(" Please Enter User Name ");
						return null;

					} else if (loginDTO.getPassword() == null || loginDTO.getPassword().isEmpty()) {
						AppUtil.addWarn(" Please Enter Password ");
						log.info(" Please Enter Password ");
						return null;
					}
					BaseDTO baseDTO = new BaseDTO();
					String url = SERVER_URL + "/login/resetPassword";
					log.info("resetPassword()" + url);

					RestTemplate restTemplate = new RestTemplate();

					ResponseEntity<BaseDTO> responseDto = restTemplate.postForEntity(url, loginDTO, BaseDTO.class);
					baseDTO = responseDto.getBody();

					if (baseDTO != null) {
						if (baseDTO.getStatusCode() == 0) {
							log.info("Password rest successfull");
							AppUtil.addInfo("Password reset successfull");
						} else if (baseDTO != null && baseDTO.getGeneralContent() != null) {
							AppUtil.addWarn(baseDTO.getGeneralContent());
							log.info(baseDTO.getGeneralContent());
							return null;
						} else {
							AppUtil.addWarn("Internal Service");
							return null;
						}
					}
				}

			}
			log.info("User name is ==> " + username);
			if (Util.isEmpty(password) && Util.isEmpty(username)) {
				Util.addWarn("Username and Password is required");
				log.error("Username and password is required");
				return null;
			} else if (Util.isEmpty(username)) {
				Util.addWarn("Please Enter Your UserName");
				log.error("Please Enter Your UserName");
				return null;
			} else if (Util.isEmpty(password)) {
				Util.addWarn("Please Enter Your Password");
				log.error("Please Enter Your Password");
				return null;
			}

			setAppValues();

			String restURL = serverURL + "/login/validateuser";

			log.info("restURL: " + restURL);

			login = new LoginBean();
			login.setUsername(username);
			login.setPassword(password);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<LoginResponseDTO> responseDto = restTemplate.postForEntity(restURL, login,
					LoginResponseDTO.class);
			loginResponseDTO = responseDto.getBody();
			password = "";

		} catch (ResourceAccessException e) {
			Util.addWarn("Service is not available");
			log.error("ResourceAccessException ", e);
			return null;
		} catch (HttpClientErrorException ex) {
			Util.addWarn("Service is not available");
			log.error("HttpClientErrorException ", ex);
			return null;
		} catch (HttpServerErrorException ex) {
			Util.addWarn("Service is not available");
			log.error("HttpServerErrorException ", ex);
			return null;
		} catch (Exception e) {
			log.error("inside error ", e);
		}
		log.info("loginResponseDto :" + loginResponseDTO);
		if (loginResponseDTO != null) {
			if (loginResponseDTO.isAuthenticationStatus()) {
				log.info("JSESSIONID ::::::::" + loginResponseDTO.getSessionid());
				userMaster = new UserMaster();
				userMaster = loginResponseDTO.getUserDetails();
				userDetailSession = userMaster;
				entityMaster = loginResponseDTO.getEntityMaster();
				misTableRowSize = loginResponseDTO.getMisTableRowSize();
				misTablePageTemplate = loginResponseDTO.getMisTablePageTemplate();

				userFeatures = loginResponseDTO.getUserFeatures();
				MultiValueMap<String, String> headersMap = new LinkedMultiValueMap<String, String>();
				headersMap.add("Cookie", "JSESSIONID=" + loginResponseDTO.getSessionid());
				headersMap.add("Content-Type", "application/json");
				headersMap.add("languageCode", languageBean.getLocaleCode());
				headersMap.add("Cookie", "SESSION=" + loginResponseDTO.getSessionid());

				requestEntity = new HttpEntity(headersMap);
				headers = headersMap;

				extCon = FacesContext.getCurrentInstance().getExternalContext();
				session = (HttpSession) extCon.getSession(true);
				session.setMaxInactiveInterval(sessionTimeOut);
				req = (HttpServletRequest) extCon.getRequest();
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, username);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UserObject",
						loginResponseDTO);
				loginResponse = loginResponseDTO;
				log.info("loginResponse " + loginResponse);

				// Load All Error Messages
				errorMap.loadErrorMessages(serverURL, requestEntity);

				// Get Employee or Supplier Information based on the UserType
				// loadUserProfile(serverURL, userMaster);

				timeZone = TimeZone.getDefault();

				// if (!hashPrivilege(DASHBOARD_VIEW)) {
				// defaultLandingPage = "/pages/welcomeMarkSolution.xhtml?faces-redirect=true";
				// }

				log.info("defaultLandingPage-1 >>> " + defaultLandingPage);

				return defaultLandingPage;

			} else {
				Util.addWarn("Invalid credentials");
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				log.error("Invalid credentials");
			}
		}

		return null;
	}

	/**
	 * 
	 */
	public void resetPassword() {
		log.info("Inside resetPassword()");

		log.info("Email id ----->" + emailId);
		LoginDTO loginDto = new LoginDTO();
		// if (Util.isEmpty(emailId)) {
		// // Util.addWarn("Email Id is required");
		// log.error("Email Id is required");
		// } else {
		if (loginDTO.getStoreCode() == null || loginDTO.getStoreCode().trim().isEmpty()) {
			AppUtil.addWarn(" Please Enter Store Code ");
			log.info(" Please Enter Store Code ");
			return;
		} else if (loginDTO.getUsername() == null || loginDTO.getUsername().trim().isEmpty()) {
			AppUtil.addWarn(" Please Enter User Name ");
			log.info(" Please Enter User Name ");
			return;

		} else if (loginDTO.getPassword() == null || loginDTO.getPassword().isEmpty()) {
			AppUtil.addWarn(" Please Enter Password ");
			log.info(" Please Enter Password ");
			return;
		}
		loginDto.setEmailId(emailId);
		BaseDTO baseDTO = new BaseDTO();
		String url = SERVER_URL + "/login/resetPassword";
		log.info("resetPassword()" + url);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<BaseDTO> responseDto = restTemplate.postForEntity(url, loginDTO, BaseDTO.class);
		baseDTO = responseDto.getBody();

		if (baseDTO != null) {
			if (baseDTO.getStatusCode() == 0) {
				log.info("Password rest successfull");
				AppUtil.addInfo("Password reset successfull");
				username = loginDTO.getUsername();
				password = loginDTO.getPassword();
				submit();
			} else if (baseDTO != null && baseDTO.getGeneralContent() != null) {
				AppUtil.addWarn(baseDTO.getGeneralContent());
				log.info(baseDTO.getGeneralContent());
			} else {
				AppUtil.addWarn("Internal Service");
			}
			// }
		}
	}

	public String logout() throws CustomException {
		username = null;
		try {
			log.info("Inside logout...");

			extCon = FacesContext.getCurrentInstance().getExternalContext();
			extCon.invalidateSession();

			String ip = serverURL;
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(ip + "/login/logmeout", HttpMethod.GET, requestEntity, String.class);
			headers = null;
			requestEntity = null;
			Util.addInfo("Logged out successfully");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			log.info("Logged out successfully");
			return "/login.xhtml?faces-redirect=true?faces-redirect=true";
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public String goToErrorPage() {
		return "/login.xhtml?faces-redirect=true";
	}

	public void loadUserProfile(String serverURL, UserMaster userMaster) {
		userInfoDTO = new UserInfoDTO();
		if (userMaster == null) {
			log.error("loadUserProfile - 1 userMaster is empty");
			return;
		}

		try {

			String URL = serverURL + "/user/id/" + userMaster.getId() + "/type/" + userMaster.getUserType();

			log.info("loadUserProfile-URL : " + URL);
			// BaseDTO baseDTO = httpService.get(URL);

			HttpEntity<?> httpRequestEntity = new HttpEntity<>(headers);

			ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, httpRequestEntity,
					BaseDTO.class);

			BaseDTO baseDTO = responseEntity.getBody();

			ObjectMapper mapper = new ObjectMapper();
			String jsonValue = mapper.writeValueAsString(baseDTO.getResponseContent());

			log.info("userMaster.getUserType() : " + userMaster.getUserType());

			switch (userMaster.getUserType()) {

			default:
			}

			// Get UserInfo Details based on the UserType
			// if (employeeMaster != null) {
			// EmployeePersonalInfoEmployment personalInfoEmployment = null;
			// EntityMaster workLocationEntity = null;
			// Designation empDesignation = null;
			// String employeeName = ((employeeMaster.getFirstName() == null ? ""
			// : employeeMaster.getFirstName().trim()) + " "
			// + (employeeMaster.getLastName() == null ? "" :
			// employeeMaster.getLastName().trim()))
			// .toUpperCase();
			// String empEmailId = employeeMaster.getEmailId();
			// log.error("User is an Employee. Name: " + employeeName);
			// log.error("empEmailId: " + empEmailId);
			// personalInfoEmployment = employeeMaster.getPersonalInfoEmployment();
			// if (personalInfoEmployment != null) {
			// workLocationEntity = personalInfoEmployment.getWorkLocation();
			// if (workLocationEntity != null) {
			// userInfoDTO.setShowRoomCode(String.valueOf(workLocationEntity.getCode()));
			// userInfoDTO.setShowRoomName(workLocationEntity.getName());
			// userInfoDTO.setEmployeeName(employeeName);
			// userInfoDTO.setEmployeeEmail(empEmailId);
			// empDesignation = personalInfoEmployment.getCurrentDesignation();
			// if (empDesignation != null) {
			// log.error("empDesignation: " + empDesignation.getName());
			// userInfoDTO.setEmployeeDesignation(empDesignation.getName());
			// } else {
			// log.error("empDesignation is null");
			// }
			// } else {
			// log.error("workLocationEntity is null");
			// }
			// } else {
			// log.error("personalInfoEmployment is null");
			// }
			// }
			// else
			if (supplierMaster != null) {
				log.info("User is a Supplier");
				userInfoDTO.setShowRoomCode(supplierMaster.getCode());
				userInfoDTO.setShowRoomName(supplierMaster.getName());
			} else {
				log.info("User neither an Employee nor a Supplier");
			}
			/*
			 * loadKeyValueMap
			 */
			loadKeyValueMap();

		} catch (Exception e) {
			log.error("Exception ", e);
		}

	}

	public Object getUserProfile() {
		if (userMaster == null) {
			return null;
		}
		log.info("userMaster id" + userMaster.getId());
		if (userMaster.getUserType().equals(UserType.EMPLOYEE)) {
			// return employeeMaster;
		} else if (userMaster.getUserType().equals(UserType.SUPPLIER)) {
			log.info("supplierMaster ===> " + supplierMaster);
			return supplierMaster;
		}
		return null;
	}

	/**
	 * @param featureCode
	 * @return
	 */
	public String checkPrivilege(String featureCode) {
		log.info("Inside checkPrivilege() - Feature Code: " + featureCode);
		try {

			extCon = FacesContext.getCurrentInstance().getExternalContext();
			session = (HttpSession) extCon.getSession(true);
			String contextPath = session.getServletContext().getContextPath();

			log.info("ajax request............"
					+ FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest());

			if (!userFeatures.containsKey(featureCode)
					&& FacesContext.getCurrentInstance().getPartialViewContext() != null
					&& !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
				log.info("Access denied to this feature.");
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(AppUtil.getUnAuthorizedPageUrl(contextPath));
			}
		} catch (Exception e) {
			log.error("Exception occured in authorization..............", e);
		}
		return null;
	}

	public boolean hashPrivilege(String featureCode) {
		boolean hashPrivilege = false;
		log.info("hashPrivilege called. Feature Code: " + featureCode);
		try {

			if (!userFeatures.containsKey(featureCode)) {
				log.info("Access denied to this page.");
				hashPrivilege = false;
			} else {
				log.info("Access permitted to this page.");
				hashPrivilege = true;
			}
		} catch (Exception e) {
			log.error("Exception occured in hashPrivilege..............", e);
		}
		return hashPrivilege;
	}

	/**
	 * 
	 */
	private void loadKeyValueMap() {
		log.info("<======= loadKeyValueMap() Starts==========> ");
		try {

			if (loginResponseDTO != null) {
				Map<String, String> keyValueMap = loginResponseDTO.getKeyValueMap();
				if (keyValueMap != null && !keyValueMap.isEmpty()) {
					String dateFormat = keyValueMap.get(AppConfigEnum.DATE_FORMAT.toString());
					log.info("<======= dateFormat: " + dateFormat);
					if (dateFormat == null) {
						log.error("<======= dateFormat is null ==========> ");
					} else {
						log.error("<======= Set dateFormat in userInfoDTO ==========> ");
						userInfoDTO.setDateFormat(dateFormat);
					}
				} else {
					log.error("<======= keyValueMap is null or empty ==========> ");
				}
			} else {
				log.error("<======= loadKeyValueMap() loginResponseDTO is null ==========> ");
			}

		} catch (Exception e) {
			log.error("Exception occured in loadKeyValueMap ", e);
		}
	}
}
