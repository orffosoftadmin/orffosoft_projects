/**
 * 
 */
package co.orffosoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.LoginDTO;
import co.orffosoft.dto.LoginResponseDTO;
import co.orffosoft.service.LoginService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	/**
	 * @param loginDTO
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validateuser", method = RequestMethod.POST)
	public @ResponseBody LoginResponseDTO login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {
		log.info("<===== Inside login() Method =====>");
		return loginService.validateUser(loginDTO, request);
	}

	@RequestMapping(value = "/logmeout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request) {
		loginService.logout(request);
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public @ResponseBody BaseDTO resetPassword(@RequestBody LoginDTO loginDTO) {
		return loginService.resetPassword(loginDTO);
	}

}
