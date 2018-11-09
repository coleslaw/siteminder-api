package com.noetic.siteminder.resource;

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

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@RequestMapping(value = "/internal/admin",
        produces = "application/json; charset=UTF-8",
        consumes = "application/json")
public interface AdminResource {


    
    /*CRUD Operations*/
    //add account
    @RequestMapping(produces = "application/json", consumes = "application/json",
            value = "/siteminder/account", method = RequestMethod.POST)
    public ResponseDTO<?> addAccount(@RequestBody AccountDTO accountDto, HttpServletResponse httpServletResponse);
    
    //edit account
    @RequestMapping(produces = "application/json", consumes = "application/json",
            value = "/siteminder/account", method = RequestMethod.PUT)
    public ResponseDTO<?> editAccount(@RequestBody AccountDTO accountDto, HttpServletResponse httpServletResponse);
    
    // delete account
    @RequestMapping(produces = "application/json", consumes = "application/json", 
            value = "/siteminder/account/{id}", method = RequestMethod.DELETE)
    public ResponseDTO<?> deleteAccount(@PathVariable String id,
            HttpServletResponse httpServletResponse);
    
    // find account
    @RequestMapping(produces = "application/json", consumes = "application/json", 
            value = "/siteminder/account/{id}", method = RequestMethod.GET)
    public ResponseDTO<?> findAccount(@PathVariable String id,
            HttpServletResponse httpServletResponse);
    
    //findAllAccounts
    @RequestMapping(produces = "application/json", consumes = "application/json",
            value = "/siteminder/account", method = RequestMethod.GET)
    public ResponseDTO<?> findAllAccounts(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse);
    
    //SYSTEM CRUD
    //add system
    @RequestMapping(produces = "application/json", consumes = "application/json",
            value = "/siteminder/addSystem", method = RequestMethod.POST)
    public ResponseDTO<?> addSystem(@RequestBody SystemDTO systemDto, HttpServletResponse httpServletResponse);
    
    //edit system
    @RequestMapping(produces = "application/json", consumes = "application/json",
            value = "/siteminder/editSystem", method = RequestMethod.PUT)
    public ResponseDTO<?> editSystem(@RequestBody SystemDTO systemDto, HttpServletResponse httpServletResponse);
    
    // delete system
    @RequestMapping(produces = "application/json", consumes = "application/json", 
            value = "/siteminder/system/{id}", method = RequestMethod.DELETE)
    public ResponseDTO<?> deleteSystem(@PathVariable String id,
            HttpServletResponse httpServletResponse);
    
    // find system
    @RequestMapping(produces = "application/json", consumes = "application/json", 
            value = "/siteminder/system/{id}", method = RequestMethod.GET)
    public ResponseDTO<?> findSystem(@PathVariable String id,
            HttpServletResponse httpServletResponse);
    
    //findAllSystem
    @RequestMapping(produces = "application/json", consumes = "application/json",
            value = "/siteminder/system", method = RequestMethod.GET)
    public ResponseDTO<?> findAllSystems(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse);
    
    //RunTimeConfig CRUD
    //add RunConf
    @RequestMapping(produces = "application/json", consumes = "application/json", value = "/siteminder/runConf",
            method = RequestMethod.POST)
    public ResponseDTO<?> addRunTimeConfig(@RequestBody RunTimeConfigDTO runTimeConfigDTO,
            HttpServletResponse httpServletResponse);

    // edit system
    @RequestMapping(produces = "application/json", consumes = "application/json", value = "/siteminder/runConf",
            method = RequestMethod.PUT)
    public ResponseDTO<?> editRunConf(@RequestBody RunTimeConfigDTO runTimeConfigDTO,
            HttpServletResponse httpServletResponse);

    // delete system
    @RequestMapping(produces = "application/json", consumes = "application/json", value = "/siteminder/runConf/{id}",
            method = RequestMethod.DELETE)
    public ResponseDTO<?> deleteRunConf(@PathVariable String id,
            HttpServletResponse httpServletResponse);

    // find system
    @RequestMapping(produces = "application/json", consumes = "application/json", value = "/siteminder/runConf/{id}",
            method = RequestMethod.GET)
    public ResponseDTO<?> findRunConf(@PathVariable String id,
            HttpServletResponse httpServletResponse);

    // findAllSystem
    @RequestMapping(produces = "application/json", consumes = "application/json", value = "/siteminder/runConf",
            method = RequestMethod.GET)
    public ResponseDTO<?> findAllRunConfs(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse);

}
