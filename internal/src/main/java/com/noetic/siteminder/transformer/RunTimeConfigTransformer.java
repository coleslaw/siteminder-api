package com.noetic.siteminder.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noetic.dto.RunTimeConfigDTO;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.domain.internal.RunTimeConfig;
import com.noetic.siteminder.domain.internal.repository.SystemRepository;

/**
 * Ruwan Chathuranga on 06-July-2018
 */
@Component
public class RunTimeConfigTransformer extends AbstractTransformer<RunTimeConfig, RunTimeConfigDTO> {
    
    @Autowired
    SystemRepository sysRepo;

    @Override
    public RunTimeConfigDTO transformDomainToDTO(RunTimeConfig domain) throws TransformerException {
        RunTimeConfigDTO dto = new RunTimeConfigDTO();
        dto.setActive(domain.isActive());
        dto.setActiveFrom(domain.getActiveFrom());
        dto.setActiveTo(domain.getActiveTo());
        dto.setConfigKey(domain.getConfigKey());
        dto.setConfigValue(domain.getConfigValue());
        dto.setCreated(domain.getCreated());
        dto.setEncrypted(domain.isEncrypted());
        dto.setEnvironment(domain.getEnvironment());
        dto.setSubSystem(domain.getSubSystem());
        dto.setTag(domain.getTag());
        dto.setUpdated(domain.getUpdated());
        dto.setUrn(domain.getUrn());
        dto.setSystemId(domain.getSystem().getId());
        return dto;
    }

    @Override
    public RunTimeConfig transformDTOToDomain(RunTimeConfigDTO dto) throws TransformerException {

        RunTimeConfig domain = new RunTimeConfig();
        domain.setActive(dto.isActive());
        domain.setActiveFrom(dto.getActiveFrom());
        domain.setActiveTo(dto.getActiveTo());
        domain.setConfigKey(dto.getConfigKey());
        domain.setConfigValue(dto.getConfigValue());
        domain.setEncrypted(dto.isEncrypted());
        domain.setEnvironment(dto.getEnvironment());
        domain.setSubSystem(dto.getSubSystem());
        domain.setSystem(sysRepo.findById(dto.getSystemId()).get());
        domain.setTag(dto.getTag());
        domain.setUrn(dto.getUrn());

        return domain;
    }

}
