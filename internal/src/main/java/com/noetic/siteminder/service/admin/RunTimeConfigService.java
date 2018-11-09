package com.noetic.siteminder.service.admin;

import java.util.Map;

import com.noetic.dto.GenericListDTO;
import com.noetic.dto.RunTimeConfigDTO;
import com.noetic.exception.AuthorizationFailedException;
import com.noetic.exception.RunTimeConfigNotFoundException;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.config.DeployProfile;
import com.noetic.siteminder.domain.internal.RunTimeConfig;
import com.noetic.siteminder.enums.RunTimeTag;

public interface RunTimeConfigService {

    public abstract Map<String, RunTimeConfig> getRuntimeConfigCached(DeployProfile deployProfile, RunTimeTag tagName)
            throws Exception;
    
    public abstract Map<String, RunTimeConfig> getRuntimeConfigEnriched(DeployProfile deployProfile,
            RunTimeTag tagName) throws Exception;

    public abstract RunTimeConfig getRunTimeConfigByConfigKeyAndEnvironmentCached(DeployProfile deployProfile,
            String configKey) throws Exception;
    
    public Boolean authorisation(String xAuthorisation, int systemId) throws AuthorizationFailedException;
    
    public void addRuntimeConfig(RunTimeConfig runTimeConfig);

    public void deleteRunTimeConfig(String urn);

    public RunTimeConfig getRunTimeConfig(String urn) throws RunTimeConfigNotFoundException;
    
    public RunTimeConfigDTO getRunTimeConfigDTO(String urn) throws RunTimeConfigNotFoundException, TransformerException;

    public GenericListDTO getAllRunTimeConfigs(int page, int size) throws TransformerException ;
    
}
