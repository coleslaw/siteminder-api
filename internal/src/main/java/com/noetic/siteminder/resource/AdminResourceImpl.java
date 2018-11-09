package com.noetic.siteminder.resource;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noetic.common.v1.dto.MessageDTO;
import com.noetic.common.v1.dto.ResponseDTO;
import com.noetic.common.v1.enums.ResultStatus;
import com.noetic.dto.AccountDTO;
import com.noetic.dto.GenericListDTO;
import com.noetic.dto.RunTimeConfigDTO;
import com.noetic.dto.SystemDTO;
import com.noetic.exception.AccountNotFoundException;
import com.noetic.exception.RunTimeConfigNotFoundException;
import com.noetic.exception.SystemNotFoundException;
import com.noetic.siteminder.domain.internal.Account;
import com.noetic.siteminder.domain.internal.RunTimeConfig;
import com.noetic.siteminder.domain.internal.System;
import com.noetic.siteminder.service.SiteminderService;
import com.noetic.siteminder.service.admin.AccountService;
import com.noetic.siteminder.service.admin.RunTimeConfigService;
import com.noetic.siteminder.service.admin.SystemService;
import com.noetic.siteminder.transformer.AccountTransformer;
import com.noetic.siteminder.transformer.RunTimeConfigTransformer;
import com.noetic.siteminder.transformer.SystemTransformer;
import com.noetic.siteminder.util.SiteminderUtil;

/**
 * Created by hurman on 29/06/2017.
 */
@RestController
public class AdminResourceImpl implements AdminResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminResourceImpl.class);

    @Autowired
    SiteminderService metaService;
    
    @Autowired
    RunTimeConfigService runTimeConfigService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private AccountTransformer accountTransformer;
    
    @Autowired
    private SystemTransformer systemTransformer;
    
    @Autowired
    SystemService systemService;
    
    @Autowired
    RunTimeConfigTransformer runTimeConfigTransformer;
    
    @Autowired
    SiteminderService siteminderService;
    
    //private static final String AUTHORIZE_FAIL = "Authorization Failed.";
    
    public AdminResourceImpl() {
    }

    @Override
    public ResponseDTO<?> addAccount(@RequestBody AccountDTO accountDto, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();
        MessageDTO message =  new MessageDTO();
        try {
          Account account = accountTransformer.transformDTOToDomain(accountDto);
          account.setCreated(SiteminderUtil.timeStampGenerator());
          accountService.addAccount(account);
          response.setResultStatus(ResultStatus.SUCCESSFUL);
          response.setHttpStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
        
    }
    
    @Override
    public ResponseDTO<?> editAccount(@RequestBody AccountDTO accountDto, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();
        MessageDTO message =  new MessageDTO();
        try {
          Account account = accountTransformer.transformDTOToDomain(accountDto);
          AccountDTO prevAccount = accountService.getAccount(account.getId());
          account.setCreated(prevAccount.getCreated());
          account.setModified(SiteminderUtil.timeStampGenerator());
          accountService.addAccount(account);
          response.setResultStatus(ResultStatus.SUCCESSFUL);
          response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (AccountNotFoundException e) {
            LOGGER.error("Account not found  , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
    }

    @Override
    public ResponseDTO<?> deleteAccount(@RequestParam String accountId, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<?> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            accountService.deleteAccount(accountId);
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
    }
    
    @Override
    public ResponseDTO<?> findAccount(@RequestParam String accountId, HttpServletResponse httpServletResponse) {

        ResponseDTO<AccountDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            response.setPayload(accountService.getAccount(accountId));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (AccountNotFoundException e) {
            LOGGER.error("Account not found  , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    }

    @Override
    public ResponseDTO<?> findAllAccounts(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse) {
        ResponseDTO<GenericListDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            response.setPayload(accountService.getAllAccounts(page, size));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    }

//System
    
    @Override
    public ResponseDTO<?> addSystem(@RequestBody SystemDTO systemDto, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();
        MessageDTO message =  new MessageDTO();
        try {
          System system = systemTransformer.transformDTOToDomain(systemDto);
          system.setCreated(SiteminderUtil.timeStampGenerator());
          systemService.addSystem(system);
          response.setResultStatus(ResultStatus.SUCCESSFUL);
          response.setHttpStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
        
    }
    
    @Override
    public ResponseDTO<?> editSystem(@RequestBody SystemDTO systemDto, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<AccountDTO> response = new ResponseDTO<>();
        MessageDTO message =  new MessageDTO();
        try {
          System system = systemTransformer.transformDTOToDomain(systemDto);
          SystemDTO dto = systemService.getSystem(system.getId());
          system.setCreated(dto.getCreated());
          system.setModified(SiteminderUtil.timeStampGenerator());
          systemService.addSystem(system);
          response.setResultStatus(ResultStatus.SUCCESSFUL);
          response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (SystemNotFoundException e) {
            LOGGER.error("System not found  , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
    }

    @Override
    public ResponseDTO<?> deleteSystem(@RequestParam String systemId, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<?> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            systemService.deleteSystem(Integer.parseInt(systemId));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
    }
    
    @Override
    public ResponseDTO<?> findSystem(@RequestParam String systemId, HttpServletResponse httpServletResponse) {

        ResponseDTO<SystemDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            response.setPayload(systemService.getSystem(Integer.parseInt(systemId)));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (SystemNotFoundException e) {
            LOGGER.error("System not found  , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    }

    @Override
    public ResponseDTO<?> findAllSystems(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse) {
        ResponseDTO<GenericListDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            response.setPayload(systemService.getAllSystems(page, size));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    }
    
    
//RunConf

    @Override
    public ResponseDTO<?> addRunTimeConfig(@RequestBody RunTimeConfigDTO runTimeConfigDTO,
            HttpServletResponse httpServletResponse) {

        ResponseDTO<RunTimeConfigDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            RunTimeConfig runTimeConfig = runTimeConfigTransformer.transformDTOToDomain(runTimeConfigDTO);
            runTimeConfig.setCreated(SiteminderUtil.timeStampGenerator());
            runTimeConfigService.addRuntimeConfig(runTimeConfig);
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;

    }
    
    @Override
    public ResponseDTO<?> editRunConf(@RequestBody RunTimeConfigDTO runTimeConfigDTO,
            HttpServletResponse httpServletResponse) {

        ResponseDTO<RunTimeConfigDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            RunTimeConfig runTimeConfig = runTimeConfigTransformer.transformDTOToDomain(runTimeConfigDTO);
            RunTimeConfig prevRc = runTimeConfigService.getRunTimeConfig(runTimeConfig.getUrn());
            runTimeConfig.setCreated(prevRc.getCreated());
            runTimeConfig.setUpdated(SiteminderUtil.timeStampGenerator());
            runTimeConfigService.addRuntimeConfig(runTimeConfig);
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (RunTimeConfigNotFoundException e) {
            LOGGER.error("RunTimeConfig not found  , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    }

    @Override
    public ResponseDTO<?> deleteRunConf(@RequestParam String runConfId, HttpServletResponse httpServletResponse) {
        
        ResponseDTO<?> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            runTimeConfigService.deleteRunTimeConfig(runConfId);
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } 
        return response;
    }
    
    @Override
    public ResponseDTO<?> findRunConf(@RequestParam String runConfId, HttpServletResponse httpServletResponse) {

        ResponseDTO<RunTimeConfigDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            response.setPayload(runTimeConfigService.getRunTimeConfigDTO(runConfId));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (RunTimeConfigNotFoundException e) {
            LOGGER.error("RunTimeConfig not found  , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    }

    @Override
    public ResponseDTO<?> findAllRunConfs(@RequestParam(required = true) int page,
            @RequestParam(required = true) int size, HttpServletResponse httpServletResponse) {
        ResponseDTO<GenericListDTO> response = new ResponseDTO<>();
        MessageDTO message = new MessageDTO();
        try {
            
            response.setPayload(runTimeConfigService.getAllRunTimeConfigs(page, size));
            response.setResultStatus(ResultStatus.SUCCESSFUL);
            response.setHttpStatus(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Error requesting , error {}", e.getMessage());
            response.setResultStatus(ResultStatus.FAILED);
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            message.setMessage(e.getMessage());
            response.setMessage(message);
        }
        return response;
    } 
}
