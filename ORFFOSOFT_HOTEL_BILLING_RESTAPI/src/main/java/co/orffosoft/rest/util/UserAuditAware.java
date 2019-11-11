package co.orffosoft.rest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import co.orffosoft.entity.UserMaster;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.service.LoginService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserAuditAware implements AuditorAware<UserMaster> {

	@Autowired
	LoginService loginService;

	@Autowired
	UserMasterRepository userMasterRepository;

	@Override
	public UserMaster getCurrentAuditor() {
		UserMaster userMaster = null;
		if (loginService != null) {
			userMaster = userMasterRepository.findOne(loginService.getCurrentUser().getId());
			log.info(userMaster.getUsername() + " retreived ");
		}
		return userMaster;
	}

}
