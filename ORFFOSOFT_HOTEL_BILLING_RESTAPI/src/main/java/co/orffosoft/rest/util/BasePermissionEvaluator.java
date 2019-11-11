/**
 * 
 */
package co.orffosoft.rest.util;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import co.orffosoft.entity.UserMaster;
import lombok.extern.log4j.Log4j2;

/**
 * @author ftuser
 *
 */
@Log4j2
public class BasePermissionEvaluator implements PermissionEvaluator {

	boolean hasFeature = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.PermissionEvaluator#hasPermission(org
	 * .springframework.security.core.Authentication, java.lang.Object,
	 * java.lang.Object)
	 */

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		log.info("Inside hasPermission()");
		boolean hasPermission = false;
		try {
			if (permission instanceof String) {
				String featureCode = (String) permission;
				log.info("featureCode >>>> " + featureCode);
				hasPermission = hasFeature(((UserMaster) authentication.getPrincipal()), featureCode);
			}
		} catch (Exception ex) {
			log.error("Exception at hasPermission(1) >>>>> ", ex);
		}
		log.info("hasPermission >>>> " + hasPermission);
		return hasPermission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.PermissionEvaluator#hasPermission(org
	 * .springframework.security.core.Authentication, java.io.Serializable,
	 * java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param userMaster
	 * @param featureCode
	 * @return
	 */
	public boolean hasFeature(UserMaster userMaster, final String featureCode) {
		log.info("hasFeature - 2 In Time >>>> " + new Date().getTime());
		hasFeature = false;

		userMaster.getRoleMaster().stream().forEach(roleMaster -> {
			if (!hasFeature) {
				roleMaster.getFeature().stream().forEach(appFeature -> {

					if (appFeature.getCode() != null && appFeature.getCode().equals(featureCode)) {
						hasFeature = true;
						return;
					}

				});
			} else {
				return;
			}
		});
		log.info("hasFeature - 2 Out Time >>>> " + new Date().getTime());
		return hasFeature;

	}

}
