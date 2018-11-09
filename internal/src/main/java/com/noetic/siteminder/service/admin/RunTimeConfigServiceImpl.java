package com.noetic.siteminder.service.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noetic.dto.GenericListDTO;
import com.noetic.dto.RunTimeConfigDTO;
import com.noetic.exception.AuthorizationFailedException;
import com.noetic.exception.RunTimeConfigNotFoundException;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.config.DeployProfile;
import com.noetic.siteminder.domain.internal.RunTimeConfig;
import com.noetic.siteminder.domain.internal.repository.RunTimConfigRepo;
import com.noetic.siteminder.domain.internal.repository.SystemRepository;
import com.noetic.siteminder.enums.RunTimeTag;
import com.noetic.siteminder.transformer.RunTimeConfigTransformer;
import com.noetic.siteminder.util.SiteminderUtil;

/**
 * 
 * @author Ruwan Chathuranga 2018-04-23
 *
 */
@Service
public class RunTimeConfigServiceImpl implements RunTimeConfigService {

    @Autowired
    private RunTimConfigRepo configRepo;
    
    @Autowired
    private SystemRepository systemRepository;
    
    @Autowired
    private RunTimeConfigTransformer transformer;

    /**
     * returns a cached runtimeConfigs with configKey as the key
     * @throws Exception 
     */
    @Override
    @Transactional
    //@Cacheable(value = "RunTimeConfigCacheByTag")
    public Map<String, RunTimeConfig> getRuntimeConfigCached(DeployProfile deployProfile, RunTimeTag tagName)
            throws Exception {
        return getRuntimeConfigByDepProfileAndTag(deployProfile, tagName);
    }
    
    /**
     * returns enriched a map of runtimeConfigs with configKey as the key
     * @throws Exception 
     */
    @Override
    @Transactional
    public Map<String, RunTimeConfig> getRuntimeConfigEnriched(DeployProfile deployProfile, RunTimeTag tagName)
            throws Exception {
        return getRuntimeConfigByDepProfileAndTag(deployProfile, tagName);
    }
    
    public Map<String, RunTimeConfig> getRuntimeConfigByDepProfileAndTag(DeployProfile deployProfile,
            RunTimeTag tagName) throws Exception{
        Map<String, RunTimeConfig> configNameMap = new HashMap<>();
        List<RunTimeConfig> runCofigs = new ArrayList<>();
        runCofigs.addAll(configRepo.getRunTimeConfigsByTagAndEnvironment(tagName.name(), deployProfile.name()));
        for (RunTimeConfig runTimeConfig : runCofigs) {
            configNameMap.put(runTimeConfig.getConfigKey(), runTimeConfig);
        }
        return configNameMap;

    }
    
    /**
     * return RunTimeConfig by deploy profile & configKey
     */
    @Override
    @Transactional
    public RunTimeConfig getRunTimeConfigByConfigKeyAndEnvironmentCached(DeployProfile deployProfile,
            String configKey) throws Exception{
        return configRepo.getRunTimeConfigByConfigKeyAndEnvironment(configKey, deployProfile.name());
    }
    
    @Override
    public Boolean authorisation(String xAuthorisation, int systemId) throws AuthorizationFailedException {
        Boolean result = false;
        if (xAuthorisation != null || systemId != 0) {
            com.noetic.siteminder.domain.internal.System system = systemRepository.getLicenseSystem(xAuthorisation
                    , systemId , SiteminderUtil.timeStampGenerator().longValue());
            if (system != null) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void addRuntimeConfig(RunTimeConfig runTimeConfig) {
        configRepo.save(runTimeConfig);
    }

    @Override
    public void deleteRunTimeConfig(String urn) {
        configRepo.deleteById(urn);
    }

    @Override
    public RunTimeConfig getRunTimeConfig(String urn) throws RunTimeConfigNotFoundException {
        if (!configRepo.findById(urn).isPresent()) {
            throw new RunTimeConfigNotFoundException();
        } else {
            return configRepo.findById(urn).get();
        }
    }
    
    @Override
    @Transactional
    public RunTimeConfigDTO getRunTimeConfigDTO(String urn)
            throws RunTimeConfigNotFoundException, TransformerException {
        if (!configRepo.findById(urn).isPresent()) {
            throw new RunTimeConfigNotFoundException();
        } else {
            return transformer.transformDomainToDTO(configRepo.findById(urn).get());
        }
    }

    
    @Override
    @Transactional
    public GenericListDTO getAllRunTimeConfigs(int page, int size) throws TransformerException {

        Page<RunTimeConfig> runConfigList = null;
        List<RunTimeConfigDTO> runConfDTOList = new ArrayList<>();
        RunTimeConfigDTO runDTO = null;
        GenericListDTO genericListDTO = new GenericListDTO();
        Pageable pageRequest = createPageRequest(page, size);

        runConfigList = configRepo.findAll(pageRequest);

        for (RunTimeConfig runConfig : runConfigList) {
            runDTO = transformer.transformDomainToDTO(runConfig);
            runConfDTOList.add(runDTO);
        }
        genericListDTO.setRunTimeConfigs(runConfDTOList);
        return genericListDTO;
    }

    private Pageable createPageRequest(int page, int size) {
        return new PageRequest(page, size);
    }

}
