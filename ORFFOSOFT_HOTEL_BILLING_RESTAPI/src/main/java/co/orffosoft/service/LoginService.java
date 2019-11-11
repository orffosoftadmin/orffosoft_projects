package co.orffosoft.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.digest.StringDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.client.RestTemplate;

import co.orffosoft.core.util.ErrorCodeDescription;
import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.NotificationException;
import co.orffosoft.core.util.PassCode;
import co.orffosoft.core.util.RestException;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.LoginDTO;
import co.orffosoft.dto.LoginResponseDTO;
import co.orffosoft.dto.UserDTO;
import co.orffosoft.entity.AppConfig;
import co.orffosoft.entity.EmailConfig;
import co.orffosoft.entity.EmailMessage;
import co.orffosoft.entity.EntityMaster;
import co.orffosoft.entity.TemplateDetails;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.enums.AppConfigEnum;
import co.orffosoft.repository.AppConfigRepository;
import co.orffosoft.repository.AppFeatureRepository;
import co.orffosoft.repository.EmailConfigRepository;
import co.orffosoft.repository.EntityMasterRepository;
import co.orffosoft.repository.LoginRepository;
import co.orffosoft.repository.TemplateDetailsRepository;
import co.orffosoft.rest.util.ResponseWrapper;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LoginService {

	final String APP_FEATURE_BY_ROLE = "APP_FEATURE_BY_ROLE";

	final String APP_FEATURE_BY_USER = "APP_FEATURE_BY_USER";

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	EmailConfigRepository emailConfigRepository;

	@Autowired
	AppConfigRepository appConfigRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	StringDigester stringDigester;

	@Autowired
	ResponseWrapper responseWrapper;

	@Autowired
	LoginService loginService;

	@Autowired
	TemplateDetailsRepository emailTemplateRepository;

	@Autowired
	AppFeatureRepository appFeatureRepository;

	@Autowired
	EntityMasterRepository entityMasterRepository;

	/**
	 * @param loginDTO
	 * @param request
	 * @return
	 */
	public LoginResponseDTO validateUser(LoginDTO loginDTO, HttpServletRequest request) {

		LoginResponseDTO loginResponseDto = new LoginResponseDTO();

		log.info("Inside validateUser()");

		String username = loginDTO.getUsername();

		String password = loginDTO.getPassword();

		// log.info("String digester password : " +
		// stringDigester.digest(password));

		try {

			log.info("username : " + username);

			UserMaster userMaster = loginRepository.findByUsername(username);

			if (userMaster != null) {
				if (userMaster.getStatus()/* && !userMaster.getIsDelete() */) {
					boolean result = stringDigester.matches(password, userMaster.getPassword());

					if (result == true) {

						UserDTO userDto = new UserDTO();

						userDto.setId(userMaster.getId());

						userDto.setUsername(userMaster.getUsername());

						userDto.setUserType(userMaster.getUserType());

						loginResponseDto.setUserDetails(userMaster);
						// userMaster.setRegion(null);

						loginResponseDto.setAuthenticationStatus(true);

						loginResponseDto.setAuthenticationStatus(true);

						EntityMaster entityMaster = entityMasterRepository.findOne(userMaster.getEntityId());

						if (entityMaster != null) {
							loginResponseDto.setEntityMaster(entityMaster);
						}

						Map<String, Boolean> userFeaturesMap = loadFeaturesByUserName(userMaster);

						loginResponseDto.setUserFeatures(userFeaturesMap);

						HttpSession session = request.getSession(true);

						loginResponseDto.setSessionid(session.getId());

						session.setAttribute("userDetailsId", loginResponseDto.getUserDetails().getId());

						session.setAttribute("userid", loginDTO.getUsername());

						List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

						session.setAttribute("userFeaturesMap", loginResponseDto.getUserFeatures());

						Authentication authentication = new UsernamePasswordAuthenticationToken(userMaster, "user",
								authorities);

						SecurityContextHolder.getContext().setAuthentication(authentication);

						/*
						 * Load User settings
						 */
						// loadSettings(loginResponseDto, userMaster, session);

						loginResponseDto.setStatusCode(0);

						log.info("Login Successful for the user [" + userDto.getUsername() + "]");
					} else {
						throw new RestException(ErrorDescription.ERROR_USERID_INVALID);
					}
				} else {
					log.info("User is not active");
					throw new RestException(ErrorDescription.ERROR_INACTIVE_USER);
				}

			} else {
				log.info("Invalid User()");
				throw new RestException(ErrorDescription.ERROR_INVALID_USER);
			}
		} catch (RestException restException) {
			log.error("RestException -:", restException);
			loginResponseDto.setStatusCode(restException.getStatusCode());
			loginResponseDto.setAuthenticationStatus(false);
			loginResponseDto.setMessage("Invalid Login Credentials");
		} catch (Exception exception) {
			log.error("Display the message", exception);
			loginResponseDto = new LoginResponseDTO();
			loginResponseDto.setAuthenticationStatus(false);
			loginResponseDto.setMessage("Invalid Login Credentials");
			//loginResponseDto.setStatusCode(ErrorCodeDescription.ERROR_GENERIC.getErrorCode());
		}

		return loginResponseDto;
	}

	public void logout(HttpServletRequest request) {
		log.info("<---------logout service called---------->");
		HttpSession session = request.getSession(true);
		if (session != null) {

			log.info("Session is active, Inactivating session, sessionId-->" + session.getId());

			session.invalidate();

		}
	}

	public UserMaster getCurrentUser() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.info("getCurrentUser() - SecurityContextHolder.getContext().getAuthentication()  is null");
			return null;
		}

		Object authObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (authObject == null || authObject.equals("anonymousUser")) {
			log.info("getCurrentUser() - authObject  is null or authObject.equals(\"anonymousUser\")");
			return null;
		} else {
			log.info("getCurrentUser()-UserMaster - found");
			return (UserMaster) authObject;
		}
	}
	
	public EntityMaster getStoreDetails(Long UserId) {
		
		EntityMaster entityMaster = entityMasterRepository.findOne(UserId);
		
		return entityMaster;
	}

	/**
	 * @param userMaster
	 * @return
	 */
	@SuppressWarnings("unused")
	private Map<String, Boolean> loadFeatures(UserMaster userMaster) {

		Map<String, Boolean> map = new HashMap<String, Boolean>();

		log.info("RoleList-------->" + userMaster.getRoleMaster().size());

		// List<AppFeature> appFeatures = new ArrayList<AppFeature>();
		userMaster.getRoleMaster().stream().forEach(roleMaster -> {
			roleMaster.getFeature().stream().forEach(appFeature -> {

				if (appFeature.getCode() != null)
					map.put(appFeature.getCode(), true);
			});
		});

		return map;

	}

	/**
	 * @param userMaster
	 * @return
	 */
	private Map<String, Boolean> loadFeaturesByUserName(UserMaster userMaster) {

		Map<String, Boolean> map = new HashMap<String, Boolean>();

		try {
			if (userMaster == null) {
				throw new Exception("loadFeaturesByUserName-userMaster is empty");
			}
			List<String> featureCodeList = appFeatureRepository.getAppFeatureListByUserName(userMaster.getId());
			if (featureCodeList == null || featureCodeList.isEmpty()) {
				log.info("FEATURE LIST IS EMPTY FOR USERNAME: " + userMaster.getUsername());
			} else {
				for (String code : featureCodeList) {
					if (code != null && !code.isEmpty()) {
						map.put(code, true);
					} else {
						log.error("loadFeaturesByUserName :: code is null or empty");
					}
				}
			}
		} catch (Exception ex) {
			log.error("Exception at loadFeaturesByUserName() ", ex);
		}

		return map;

	}

	/**
	 * @param userMaster
	 * @return
	 */
	private Map<String, Boolean> loadUserFeaturesByUserName(UserMaster userMaster) {
		log.info("========== INSIDE loadUserFeaturesByUserName METHOD ==========");
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		try {
			if (userMaster == null) {
				throw new Exception("loadUserFeaturesByUserName-userMaster is empty");
			}
			List<String> featureCodeList = appFeatureRepository.getUserFeaturesByUserName(userMaster.getUsername());
			if (featureCodeList == null || featureCodeList.isEmpty()) {
				log.info("FEATURE LIST IN 'user_feature' TABLE IS EMPTY FOR USERNAME: " + userMaster.getUsername());
			} else {
				for (String code : featureCodeList) {
					if (code != null && !code.isEmpty()) {
						map.put(code, true);
					} else {
						log.error("loadUserFeaturesByUserName :: code is null or empty");
					}
				}
			}
		} catch (Exception ex) {
			log.error("Exception at loadUserFeaturesByUserName() ", ex);
		}

		return map;

	}

	/**
	 * @param password
	 * @return
	 * 
	 * 		validateUser Second Password
	 */
	public BaseDTO validateUserSecondPassword(String password) {
		log.info("<-Inside SERVICE Starts validateUserConfigPassword --> " + password);
		BaseDTO baseDTO = new BaseDTO();
		try {
			String userName = loginService.getCurrentUser().getUsername();
			UserMaster userMaster = loginRepository.findByUsername(userName);
			if (userMaster != null) {
				if (userMaster.getStatus()) {
					boolean result = stringDigester.matches(password, userMaster.getSecondPassword());
					if (result == true) {
						baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
						return baseDTO;
					} else {
						log.error("Password Did't Match :");
					}
				}
			}
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
		} catch (RestException restException) {
			baseDTO.setStatusCode(restException.getStatusCode());
			log.error("RestException in validateUserConfigPassword () ", restException);
		} catch (Exception exception) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("Exception in validateUserConfigPassword() ", exception);
		}
		return baseDTO;
	}

	/**
	 * @param loginDTO
	 * @return
	 */
	public BaseDTO resetPassword(LoginDTO loginDTO) {
		log.info("<-Inside SERVICE Starts resetPassword --> " + loginDTO);
		BaseDTO baseDTO = new BaseDTO();
		try {

			EntityMaster entityMaster = entityMasterRepository.findByCode(loginDTO.getStoreCode());

			if (entityMaster == null) {
				baseDTO.setGeneralContent("Wrong Store Code");
				log.warn("Wrong Store Code");
				return baseDTO;
			}

			UserMaster userMaster = loginRepository.findByUsername(loginDTO.getUsername());

			if (userMaster == null) {
				baseDTO.setGeneralContent("Wrong User Name");
				log.warn("Wrong User Name");
				return baseDTO;
			}
			String newPassword = stringDigester.digest(loginDTO.getPassword());
			userMaster.setPassword(newPassword);
			loginRepository.save(userMaster);
			baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());

		} catch (RestException restException) {
			baseDTO.setStatusCode(restException.getStatusCode());
			log.error("RestException in resetPassword () ", restException);
		} catch (Exception exception) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("Exception in resetPassword() ", exception);
		}
		return baseDTO;
	}

	/**
	 *
	 * This method is written to reset and send mail to the user's email address
	 *
	 * @param userMaster
	 */

	private BaseDTO resetPasswordAndSendMail(UserMaster userMaster) throws Exception {

		log.info("<-Inside SERVICE Starts resetPasswordAndSendMail-> " + userMaster);
		BaseDTO baseDTO = new BaseDTO();
		try {
			EmailMessage emailMessage = saveEmailDetails(userMaster);
			AppConfig appConfig = appConfigRepository.findByKey("NOTIFICATION_SERVER_EMAIL_URL");
			log.info("<-Start emailConfig.sendEmail->" + appConfig);

			HttpEntity<?> httpRequestEntity = new HttpEntity<>(emailMessage);
			ResponseEntity<BaseDTO> responseEntity = restTemplate.exchange(appConfig.getAppValue(), HttpMethod.POST,
					httpRequestEntity, BaseDTO.class);

			if (responseEntity == null) {
				log.error("resetPasswordAndSendMail() - Response entity is null");
			} else {
				log.info("<-resetPasswordAndSendMail() - New Password is pushed to email service successfully->");
				baseDTO.setStatusCode(ErrorDescription.SUCCESS_RESPONSE.getErrorCode());
			}
		} catch (NotificationException ex) {
			if (ex.getErrorCode() != null) {
				baseDTO.setErrorDescription(ex.getMessage());
				baseDTO.setStatusCode(ex.getErrorCode());
				log.error("Email Template not found in template_details table", ex);
			}
		} catch (Exception e) {
			baseDTO.setStatusCode(ErrorDescription.FAILURE_RESPONSE.getErrorCode());
			log.error("Exception occured while sending email to customer", e);
		}
		return baseDTO;
	}

	/**
	 * THis method is written to save email config detail and other details in email
	 * message
	 * 
	 * @param userMaster
	 * @return emailMessage
	 * @throws NotificationException
	 */

	private EmailMessage saveEmailDetails(UserMaster userMaster) throws NotificationException {

		final String ORGANIZATION_MOBILE_NUMBER = "ORGANIZATION_MOBILE_NUMBER";
		final String ORGANIZATION_EMAIL_ADDRESS = "ORGANIZATION_EMAIL_ADDRESS";
		final String ORGANIZATION_WEB_ADDRESS = "ORGANIZATION_WEB_ADDRESS";
		final String EMAIL_DISCLAIMER = "EMAIL_DISCLAIMER";
		final String ORGANIZATION_ADDRESS = "ORGANIZATION_ADDRESS";

		log.info("<-Inside SERVICE Starts saveEmailDetails --> " + userMaster);

		TemplateDetails template = new TemplateDetails();
		EmailMessage emailMessage = new EmailMessage();

		EmailConfig emailConfig = emailConfigRepository.findByCode("GENERAL_SERVICE");
		log.info("email_config table details for code GENERAL_REGISTER -->" + emailConfig);
		if (emailConfig == null) {
			throw new NotificationException("Email configuration is empty");
		}
		/*
		 * email_config table id is set in config_id column of email_message table
		 */
		emailMessage.setEmailConfig(emailConfig);
		// template =
		// emailTemplateRepository.findByTemplateCode(TemplateCode.NEW_PASSWORD_TEMPLATE);

		log.info("template" + template);

		log.info("New_PASSWORD_TEMPLATE details retrieved from template_details table-->" + template);
		String emailSubject = template.getSubject();
		log.info("EmailMessageService -> emailSubject " + emailSubject);

		String orgPhoneNumber = "";
		String orgWebAddress = "";
		String orgEmailAddress = "";
		String orgAddress = "";
		String disclaimer = "";

		/*
		 * Generate random password
		 */
		String newPassword = PassCode.generate(10, false);
		/*
		 * Encrypt new password and set
		 */
		String newPasswordEnc = stringDigester.digest(newPassword.trim());
		userMaster.setPassword(newPasswordEnc);

		AppConfig appConfigMNO = appConfigRepository.findByKey(ORGANIZATION_MOBILE_NUMBER);

		if (appConfigMNO == null) {
			throw new NotificationException(
					"Organization mobile number not found in app config. Key is: " + ORGANIZATION_MOBILE_NUMBER);
		}
		orgPhoneNumber = appConfigMNO.getAppValue();
		orgPhoneNumber = orgPhoneNumber == null ? "" : orgPhoneNumber.trim();

		AppConfig appConfigEmail = appConfigRepository.findByKey(ORGANIZATION_EMAIL_ADDRESS);
		if (appConfigEmail == null) {
			throw new NotificationException(
					"Organization email address not found in app config. Key is: " + ORGANIZATION_EMAIL_ADDRESS);
		}
		orgEmailAddress = appConfigEmail.getAppValue();
		orgEmailAddress = orgEmailAddress == null ? "" : orgEmailAddress.trim();

		AppConfig appConfigWebAddr = appConfigRepository.findByKey(ORGANIZATION_WEB_ADDRESS);
		if (appConfigWebAddr == null) {
			throw new NotificationException(
					"Organization web address not found in app config. Key is: " + ORGANIZATION_WEB_ADDRESS);
		}
		orgWebAddress = appConfigWebAddr.getAppValue();
		orgWebAddress = orgWebAddress == null ? "" : orgWebAddress.trim();

		AppConfig appConfigEmailDisclaimer = appConfigRepository.findByKey(EMAIL_DISCLAIMER);
		if (appConfigEmailDisclaimer == null) {
			throw new NotificationException("Disclaimer not found in app config. Key is: " + EMAIL_DISCLAIMER);
		}
		disclaimer = appConfigEmailDisclaimer.getAppValue();
		disclaimer = disclaimer == null ? "" : disclaimer.trim();

		AppConfig appConfigOrgAddr = appConfigRepository.findByKey(ORGANIZATION_ADDRESS);
		if (appConfigOrgAddr == null) {
			throw new NotificationException(
					"Organization address not found in app config. Key is: " + ORGANIZATION_ADDRESS);
		}
		orgAddress = appConfigOrgAddr.getAppValue();
		orgAddress = orgAddress == null ? "" : orgAddress.trim();

		Properties properties = new Properties();
		properties.put("newPassword", newPassword);
		properties.put("orgAddress", orgAddress);
		properties.put("orgPhoneNumber", orgPhoneNumber);
		properties.put("orgWebAddress", orgWebAddress);
		properties.put("orgEmailAddress", orgEmailAddress);
		properties.put("disclaimer", disclaimer);

		String messgeTemplate = template.getDescription();
		PropertyPlaceholderHelper placeholderResolver = new PropertyPlaceholderHelper("{", "}");
		String message = placeholderResolver.replacePlaceholders(messgeTemplate, properties);

		if (message.isEmpty()) {
			throw new NotificationException("Message is empty");
		}

		// EMAIL_DISCLAIMER

		emailMessage.setMailMessage(message);
		emailMessage.setToAddress(userMaster.getEmailId());
		emailMessage.setCreatedDate(new Date());
		emailMessage.setContentType("PLAIN");
		emailMessage.setImportantMail("Y");
		emailMessage.setMailSubject(emailSubject);
		emailMessage.setMailSent("Y");

		/*
		 * Update Usermaster with new password
		 */
		loginRepository.save(userMaster);
		log.info("New password encrypted and saved");

		return emailMessage;
	}

	/**
	 * @param loginResponseDto
	 */
	private void loadSettings(LoginResponseDTO loginResponseDto, UserMaster userMaster, HttpSession session) {

		log.info("<========== INSIDE loadSettings METHOD STARTS ==============>");

		AppConfig appConfig = new AppConfig();
		Map<String, String> keyValueMap = new HashMap<>();
		Map<String, Boolean> userFeaturesMap = null;
		AppConfig appConfigForAppFeatureMode = null;
		String appFeatureBy = null;
		try {

			appConfigForAppFeatureMode = appConfigRepository.findByKey("APP_FEATURE_MODE");

			appFeatureBy = appConfigForAppFeatureMode == null ? APP_FEATURE_BY_ROLE
					: appConfigForAppFeatureMode.getAppValue();

			appFeatureBy = appFeatureBy == null ? APP_FEATURE_BY_ROLE : appFeatureBy.trim();

			log.info("AppFeatureBy : " + appFeatureBy);

			if (appFeatureBy.equals(APP_FEATURE_BY_USER)) {
				log.info("Loading App Feature By User");
				userFeaturesMap = loadUserFeaturesByUserName(userMaster);
			} else {
				log.info("Loading App Feature By Role - By Default");
				userFeaturesMap = loadFeaturesByUserName(userMaster);
			}

			loginResponseDto.setUserFeatures(userFeaturesMap);

			session.setAttribute("userFeaturesMap", userFeaturesMap);

			appConfig = appConfigRepository.findByKey("MIS_TABLE_PAGE_TEMPLATE");

			if (appConfig != null) {
				loginResponseDto.setMisTablePageTemplate(appConfig.getAppValue());
			} else {
				log.info("App Config for key MIS_TABLE_PAGE_TEMPLATE not found");
			}

			appConfig = appConfigRepository.findByKey("MIS_TABLE_ROW_SIZE");

			if (appConfig != null) {
				loginResponseDto.setMisTableRowSize(appConfig.getAppValue());
			} else {
				log.info("App Config for key MIS_TABLE_ROW_SIZE not found");
			}

			/*
			 * Load keyValueMap
			 */

			appConfig = appConfigRepository.findByKey(AppConfigEnum.DATE_FORMAT.toString());

			if (appConfig != null) {
				keyValueMap.put(AppConfigEnum.DATE_FORMAT.toString(), appConfig.getAppValue());
				log.info("App Config for key " + AppConfigEnum.DATE_FORMAT + " : " + appConfig.getAppValue());
			} else {
				log.info("App Config for key " + AppConfigEnum.DATE_FORMAT + " not found");
			}

			loginResponseDto.setKeyValueMap(keyValueMap);
		} catch (Exception ex) {
			log.error("Exception at loadSettings() ", ex);
		}

		log.info("<========== INSIDE loadSettings METHOD ENDS ==============>");

	}

}
