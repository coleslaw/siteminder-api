package com.noetic.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Ruwan Chathuranga on 10-July-2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class GenericListDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<AccountDTO> accounts;

    private List<SystemDTO> systems;

    private List<RunTimeConfigDTO> runTimeConfigs;

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    public List<SystemDTO> getSystems() {
        return systems;
    }

    public void setSystems(List<SystemDTO> systems) {
        this.systems = systems;
    }

    public List<RunTimeConfigDTO> getRunTimeConfigs() {
        return runTimeConfigs;
    }

    public void setRunTimeConfigs(List<RunTimeConfigDTO> runTimeConfigs) {
        this.runTimeConfigs = runTimeConfigs;
    }

}
