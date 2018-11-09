package com.noetic.siteminder.service.admin;

import com.noetic.dto.AccountDTO;
import com.noetic.dto.GenericListDTO;
import com.noetic.exception.AccountNotFoundException;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.domain.internal.Account;

public interface AccountService {
    
    public void addAccount(Account system);

    public void deleteAccount(String urn);

    public AccountDTO getAccount(String urn) throws TransformerException, AccountNotFoundException;

    public GenericListDTO getAllAccounts(int page, int size) throws TransformerException;
}
