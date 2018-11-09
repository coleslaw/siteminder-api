package com.noetic.api.siteminder.resource.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noetic.common.v1.dto.ResponseDTO;
import com.noetic.dto.AccountDTO;
import com.noetic.dto.RunTimeConfigDTO;
import com.noetic.dto.SystemDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@RequestMapping(value = "/v1/admin")
public interface AdminResource {
    
/*   CRUD OPERATIONS*/
    
    //Add Account
    @ApiOperation(value = "Add Account", nickname = "add-account",
            response = ResponseDTO.class ,
            notes = "This will add a new account", 
            responseContainer = "ResponseDTO",
            responseReference = "AccountDTO")

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @RequestMapping(produces = "application/json",
            consumes = "application/json",
            value = "/account",
            method = RequestMethod.POST)

    public ResponseDTO<?> addAccount(
            @RequestBody AccountDTO accountDto,
            HttpServletResponse httpServletResponse);
    
    //==============================================================================================
    //Edit Account
    @ApiOperation(value = "Edit Account", nickname = "edit-account",
            response = ResponseDTO.class ,
            notes = "This will edit an existing account", 
            responseContainer = "ResponseDTO",
            responseReference = "AccountDTO")

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @RequestMapping(produces = "application/json",
            consumes = "application/json",
            value = "/account",
            method = RequestMethod.PUT)

    public ResponseDTO<?> editAccount(
            @RequestBody AccountDTO accountDto,
            HttpServletResponse httpServletResponse);
    
    //==============================================================================================
    
    //Delete Account
    @ApiOperation(value = "Delete Account", nickname = "delete-account",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "AccountDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/account/{id}", method = RequestMethod.DELETE)
    public ResponseDTO<?> deleteAccount(@PathVariable int id,
            HttpServletResponse httpServletResponse);
    
    //==============================================================================================
    
    //Find Account
    @ApiOperation(value = "Find Account", nickname = "find-account",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "AccountDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/account/{id}", method = RequestMethod.GET)
    public ResponseDTO<?> findAccount(@PathVariable int id,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Find All
    @ApiOperation(value = "Find All Accounts", nickname = "find-all-account",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "AccountDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/account", method = RequestMethod.GET)
    public ResponseDTO<?> findAllAccounts(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    // SYSTEM CRUD OPS    
    //Add system
    @ApiOperation(value = "Add System", nickname = "add-system",
            response = ResponseDTO.class ,
            notes = "This will add a new system", 
            responseContainer = "ResponseDTO",
            responseReference = "SystemDTO")

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @RequestMapping(produces = "application/json",
            consumes = "application/json",
            value = "/system",
            method = RequestMethod.POST)

    public ResponseDTO<?> addSystem(
            @RequestBody SystemDTO systemDTO,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Edit system
    @ApiOperation(value = "Edit System", nickname = "edit-system",
            response = ResponseDTO.class ,
            notes = "This will edit an existing system", 
            responseContainer = "ResponseDTO",
            responseReference = "SystemDTO")

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @RequestMapping(produces = "application/json",
            consumes = "application/json",
            value = "/system",
            method = RequestMethod.PUT)

    public ResponseDTO<?> editSystem(
            @RequestBody SystemDTO systemDTO,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Delete system
    @ApiOperation(value = "Delete System", nickname = "delete-system",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "SystemDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/system/{id}", method = RequestMethod.DELETE)
    public ResponseDTO<?> deleteSystem(@PathVariable int id,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Find Account
    @ApiOperation(value = "Find System", nickname = "find-system",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "SystemDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/system/{id}", method = RequestMethod.GET)
    public ResponseDTO<?> findSystem(@PathVariable int id,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Find All
    @ApiOperation(value = "Find All systems", nickname = "find-all-systems",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "SystemDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/system", method = RequestMethod.GET)
    public ResponseDTO<?> findAllSystems(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    // RunTimeConfig CRUD OPS    
    //Add runConf
    @ApiOperation(value = "Add RunTimeConfig", nickname = "add-runConf",
            response = ResponseDTO.class ,
            notes = "This will add a new runTime config", 
            responseContainer = "ResponseDTO",
            responseReference = "RunTimeConfigDTO")

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @RequestMapping(produces = "application/json",
            consumes = "application/json",
            value = "/runtimeConfig",
            method = RequestMethod.POST)

    public ResponseDTO<?> addRunConf(
            @RequestBody RunTimeConfigDTO runTimeConfigDTO,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Edit system
    @ApiOperation(value = "Edit RunTimeConfig", nickname = "edit-runConf",
            response = ResponseDTO.class ,
            notes = "This will edit an existing runtime Config", 
            responseContainer = "ResponseDTO",
            responseReference = "RunTimeConfigDTO")

    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @RequestMapping(produces = "application/json",
            consumes = "application/json",
            value = "/runtimeConfig",
            method = RequestMethod.PUT)

    public ResponseDTO<?> editRunConf(
            @RequestBody RunTimeConfigDTO runTimeConfigDTO,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Delete run conf
    @ApiOperation(value = "Delete Run conf", nickname = "delete-run conf",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "RunTimeConfigDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/runtimeConfig/{id}", method = RequestMethod.DELETE)
    public ResponseDTO<?> deleteRunConf(@PathVariable int id,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Find Account
    @ApiOperation(value = "Find Runtim Config", nickname = "find-run COnf",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "RunTimeConfigDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/runtimeConfig/{id}", method = RequestMethod.GET)
    public ResponseDTO<?> findRunConf(@PathVariable int id,
            HttpServletResponse httpServletResponse);
    
    
    //==============================================================================================
    
    //Find All
    @ApiOperation(value = "Find All runtime configs", nickname = "find-all-runConfs",
            response = ResponseDTO.class , responseContainer = "ResponseDTO",
            responseReference = "RunTimeConfigDTO")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Found"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    
    @RequestMapping(produces = "application/json", value = "/runtimeConfig", method = RequestMethod.GET)
    public ResponseDTO<?> findAllRunConfs(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse);
    
    
    //===========================================================================================

}
