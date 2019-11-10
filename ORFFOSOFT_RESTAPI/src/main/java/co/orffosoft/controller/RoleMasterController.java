package co.orffosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.orffosoft.core.util.PaginationRequestData;
import co.orffosoft.dto.BaseDTO;
import co.orffosoft.dto.RoleDTO;
import co.orffosoft.entity.RoleMaster;
import co.orffosoft.service.RoleMasterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping(value = "/role")
public class RoleMasterController {

	@Autowired
	RoleMasterService roleService;

	@PreAuthorize("hasPermission(#roleMaster, 'ROLE_ADD')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BaseDTO addRoleDetails(@RequestBody RoleDTO roleMasterDto) {

		log.info("<<<< ------- Start RoleController.addRoleDetails ---------- >>>>>>>");
		return roleService.addRoleDetailsDto(roleMasterDto);
	}

	@PreAuthorize("hasPermission(#roleMaster, 'ROLE_EDIT')")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public BaseDTO updateRoleDetails(@RequestBody RoleDTO roleMaster) {

		log.info("<<<< ------- Start RoleController.updateRoleDetails ---------- >>>>>>>");
		return roleService.updateRoleDetails(roleMaster);

	}

	@PreAuthorize("hasPermission(#roleMaster, 'ROLE_VIEW')")
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public BaseDTO getRoleDetails(@RequestBody RoleMaster roleMaster) {

		log.info("<<<< ------- Start RoleController.getRoleDetails ---------- >>>>>>>");
		return roleService.getRoleDetails(roleMaster);

	}

	@PreAuthorize("hasPermission(#roleMaster, 'USER_MANAGEMENT_ROLE')")
	@RequestMapping(value = "/getalllazy", method = RequestMethod.POST)
	@ApiOperation(value = "List of available roles with pagination", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public BaseDTO getAllRoleDetailsLazy(@RequestBody PaginationRequestData req) {

		log.info("<<<< ------- Start RoleController.getAllRoleDetailsLazy ---------- >>>>>>>");
		return roleService.getAllRoleDetailsLazy(req);
	}

	@PreAuthorize("hasPermission(#roleMaster, 'USER_MANAGEMENT_ROLE')")
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ApiOperation(value = "List of available roles", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public BaseDTO getAllRoleDetails() {
		log.info("<------Role master controller -> get all role list called------->");
		return roleService.getAllRoleDetails();
	}
	
	@RequestMapping(value = "/getallactive", method = RequestMethod.GET)
	@ApiOperation(value = "List of available roles", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public BaseDTO getAllActiveRoleDetails() {
		log.info("<------Role master controller -> get all role list called------->");
		return roleService.getAllActiveRoleDetails();
	}

	@PreAuthorize("hasPermission(#roleMaster, 'USER_MANAGEMENT_ROLE')")
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public BaseDTO searchRoles(@RequestBody RoleMaster roleMaster) {

		log.info("<<<< ------- Start RoleController.searchRoles ---------- >>>>>>>");
		return roleService.searchRoles(roleMaster);

	}
	
	@PreAuthorize("hasPermission(#roleMaster, 'ROLE_DELETE')")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public BaseDTO deleteRoles(@RequestBody RoleMaster roleMaster) {
		log.info("Delete role controller called");
		return roleService.deleteRole(roleMaster);
	}
}
