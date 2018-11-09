package com.noetic.siteminder.service.admin;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noetic.dto.GenericListDTO;
import com.noetic.dto.SystemDTO;
import com.noetic.exception.SystemNotFoundException;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.domain.internal.System;
import com.noetic.siteminder.domain.internal.repository.SystemRepository;
import com.noetic.siteminder.transformer.SystemTransformer;

@Service
public class SystemServiceImpl implements SystemService{
    
    @Autowired
    SystemRepository systemRepository;

    @Autowired
    SystemTransformer sysTrans;
    
    @Override
    public void addSystem(System system) {
        systemRepository.save(system);
    }

    @Override
    public void deleteSystem(int urn) {
        systemRepository.deleteById(urn);
    }

    @Override
    @Transactional
    public SystemDTO getSystem(int urn) throws TransformerException, SystemNotFoundException {
        if (!systemRepository.findById(urn).isPresent()) {
            throw new SystemNotFoundException();
        } else {
            return sysTrans.transformDomainToDTO(systemRepository.findById(urn).get());
        }
    }

    @Override
    @Transactional
    public GenericListDTO getAllSystems(int page, int size) throws TransformerException {

        Page<System> systemList = null;
        List<SystemDTO> systemDTOList = new ArrayList<>();
        GenericListDTO genericListDTO = new GenericListDTO();
        SystemDTO sysDTO = null;
        Pageable pageRequest = createPageRequest(page, size);
        systemList = systemRepository.findAll(pageRequest);

        for (System runConfig : systemList) {
            sysDTO = sysTrans.transformDomainToDTO(runConfig);
            systemDTOList.add(sysDTO);
        }
        genericListDTO.setSystems(systemDTOList);
        return genericListDTO;
    }

    private Pageable createPageRequest(int page, int size) {
        return new PageRequest(page, size);
    }

}
