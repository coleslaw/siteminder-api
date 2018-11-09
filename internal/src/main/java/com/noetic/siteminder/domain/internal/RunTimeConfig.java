package com.noetic.siteminder.domain.internal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author Ruwan Chathuranga
 * Created on 23 04 2018
 *
 */
@Entity
@Table(name = "RunTimeConfig")
public class RunTimeConfig implements Serializable{

    private static final long serialVersionUID = 489217392027453860L;
    
	private String urn;
	private String configKey;
	private String configValue;
	private String environment;
	private System system;
	private String subSystem;
	private boolean active;
	private long activeFrom;
	private long activeTo;
	private long created;
	private long updated;
	private String tag;
	private boolean encrypted;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getUrn() {
        return urn;
    }

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "system", nullable = false)
	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public String getSubSystem() {
		return subSystem;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(long activeFrom) {
		this.activeFrom = activeFrom;
	}

	public long getActiveTo() {
		return activeTo;
	}

	public void setActiveTo(long activeTo) {
		this.activeTo = activeTo;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public long getUpdated() {
		return updated;
	}

	public void setUpdated(long updated) {
		this.updated = updated;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}

}