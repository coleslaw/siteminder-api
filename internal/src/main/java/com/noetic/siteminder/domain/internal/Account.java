package com.noetic.siteminder.domain.internal;

import java.io.Serializable;

// Generated Mar 29, 2018 11:42:16 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Ruwan Chathuranga on 02-May-2018
 */
@Entity
@Table(name = "Account")
public class Account implements Serializable {

    private static final long serialVersionUID = -7511534121130732727L;
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "account_id", unique = true, nullable = false)
    private String id;
    
    @Column(name = "version")
	private Integer version;
    
    @Column(name = "name")
	private String name;
    
    @Column(name = "created")
	private Long created;
    
    @Column(name = "modified")
	private Long modified;
    
    @Column(name = "isDeleted")
	private Boolean isDeleted;
    
    @Column(name = "isActive")
	private Boolean isActive;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<System> systems = new HashSet<>();

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}
	
	public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreated() {
		return this.created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getModified() {
		return this.modified;
	}

	public void setModified(Long modified) {
		this.modified = modified;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<System> getSystems() {
		return this.systems;
	}

	public void setSystems(Set<System> systems) {
		this.systems = systems;
	}

}
