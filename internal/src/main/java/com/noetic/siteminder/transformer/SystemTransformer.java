package com.noetic.siteminder.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noetic.dto.SystemDTO;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.domain.internal.System;
import com.noetic.siteminder.domain.internal.repository.AccountRepository;
/**
 * Ruwan Chathuranga on 06-July-2018
 */
@Component
public class SystemTransformer extends AbstractTransformer<System, SystemDTO> {
    
    @Autowired
    AccountRepository accRepo;

    @Override
    public SystemDTO transformDomainToDTO(System domain) throws TransformerException {

        SystemDTO dto = new SystemDTO();

        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setApiKey(domain.getApiKey());
        dto.setSystemCode(domain.getSystemCode());
        dto.setStartDate(domain.getStartDate());
        dto.setEndDate(domain.getEndDate());
        dto.setActive(domain.getIsActive());
        dto.setCreated(domain.getCreated());
        dto.setModified(domain.getModified());
        dto.setVersion(domain.getVersion());
        dto.setDeleted(domain.getIsDeleted());
        dto.setAccountId(domain.getAccount().getId());
        
        return dto;
    }

    @Override
    public System transformDTOToDomain(SystemDTO dto) throws TransformerException {

        System domain = new System();

        domain.setId(dto.getId());
        domain.setName(dto.getName());
        domain.setSystemCode(dto.getSystemCode());
        domain.setApiKey(dto.getApiKey());
        domain.setStartDate(dto.getStartDate());
        domain.setEndDate(dto.getEndDate());
        domain.setIsActive(dto.isActive());
        domain.setVersion(dto.getVersion());
        domain.setAccount(accRepo.findById(dto.getAccountId()).get());
        //domain.setCreated(dto.getCreated());
        //domain.setModified(dto.getModified());
        domain.setIsDeleted(dto.isDeleted());
        return domain;
    }

}
