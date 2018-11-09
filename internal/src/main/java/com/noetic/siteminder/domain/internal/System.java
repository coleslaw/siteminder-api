package com.noetic.siteminder.domain.internal;
// Generated Mar 29, 2018 11:42:16 AM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ruwan Chathuranga on 02-May-2018
 */
@Entity
@Table(name = "System")
public class System implements Serializable {

    private static final long serialVersionUID = 6589577956996527781L;
    @Id
    @Column(name = "system_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "version")
    private int version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "apiKey")
    private String apiKey;
    @Column(name = "startDate", nullable = false)
    private long startDate;
    @Column(name = "endDate", nullable = false)
    private long endDate;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "created")
    private long created;
    @Column(name = "modified")
    private long modified;
    @Column(name = "isDeleted")
    private boolean isDeleted;
    @Column(name = "systemCode", nullable = false, length = 50)
    private String systemCode;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public long getCreated() {
        return this.created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getModified() {
        return this.modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}