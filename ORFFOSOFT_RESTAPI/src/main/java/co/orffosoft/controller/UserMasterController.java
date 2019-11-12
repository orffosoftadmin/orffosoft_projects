package co.orffosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.core.util.PaginationRequestData;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.UserMasterDTO;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.enums.UserType;
import co.orffosoft.repository.UserMasterRepository;
import co.orffosoft.service.UserMasterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping(value = "/user")
public class UserMasterController {

	@Autowired
	UserMasterService userService;

	@Autowired
	UserMasterRepository user;

	/**
	 * @param userType
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/id/{id}/type/{userType}", method = RequestMethod.GET)
	public BaseDTO getInfoByUserType(@PathVariable("userType") UserType userType, @PathVariable("id") Long id) {
		log.info("getInfoByUserType - id: " + id + " / userType: " + userType);
		return userService.getInfoByUserType(userType, id);
	}

	//@PreAuthorize("hasPermission(#userManagement, 'USER_ADD')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BaseDTO addUserDetails(@RequestBody UserMasterDTO userMasterDto) {

		log.info("<<<< ------- Start UserManagementController.addUserDetails ---------- >>>>>>>");
		return userService.addNewUser(userMasterDto);

	}

	@PreAuthorize("hasPermission(#userManagement, 'USER_ADD')")
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public BaseDTO addUserDetails(@RequestBody UserMaster userMaster) {

		log.info("<<<< -------  UserManagementController.addUserDetails user ---------- >>>>>>>");
		return userService.addUserDetails(userMaster);

	}

	@PreAuthorize("hasPermission(#userManagement, 'USER_EDIT')")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public BaseDTO updateUserDetails(@RequestBody UserMasterDTO userMasterDto) {

		log.info("<<<< ------- Start UserManagementController.updateUserDetails ---------- >>>>>>>");
		return userService.updateUserDetailsDto(userMasterDto);
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public BaseDTO getUserDetails(@RequestBody UserMaster userMaster) {

		log.info("<<<< ------- Start UserManagementController.getUserDetails ---------- >>>>>>>");
		return userService.getUserDetails(userMaster);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ApiOperation(value = "List of available users", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public BaseDTO getAllUserDetails() {

		log.info("<<<< ------- Start UserManagementController.getAllUserDetails ---------- >>>>>>>");
		return userService.getAllUserDetails();
	}

	@PreAuthorize("hasPermission(#userManagement, 'USER_MANAGEMENT_USER')")
	@RequestMapping(value = "/getalllazy", method = RequestMethod.POST)
	@ApiOperation(value = "List of available users with pagination", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public BaseDTO getAllUserDetailsLazy(@RequestBody PaginationRequestData paginationReq) {

		log.info("<<<< ------- Start UserManagementController.getAllUserDetailsLazy ---------- >>>>>>>");
		return userService.getAllUserDetailsLazy(paginationReq);
	}

	@PreAuthorize("hasPermission(#userManagement, 'USER_DELETE')")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public BaseDTO deleteUserDetails(@RequestBody UserMaster userMaster) {
		log.info("<<<< ------- Start UserManagementController.deleteUserDetails ---------- >>>>>>>");
		return userService.deleteUser(userMaster);
	}

	@PreAuthorize("hasPermission(#userManagement, 'USER_MANAGEMENT_USER')")
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public BaseDTO getAllByCriteria(@RequestBody UserMaster userMaster) {

		log.info("<<<< ------- Start UserManagementController.getAllByCriteria ---------- >>>>>>>");
		return userService.userSearch(userMaster);
	}

	@RequestMapping(value = "/getbyId", method = RequestMethod.POST)
	public BaseDTO getbyId(@RequestBody UserMaster userMaster) {
		log.info("<<<< ------- get User by ID  ---------- >>>>>>>", userMaster);
		return userService.getUserById(userMaster);
	}

}
