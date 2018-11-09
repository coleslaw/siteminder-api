package com.noetic.siteminder.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.noetic.dto.AccountDTO;
import com.noetic.dto.GenericListDTO;
import com.noetic.exception.AccountNotFoundException;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.domain.internal.Account;
import com.noetic.siteminder.domain.internal.repository.AccountRepository;
import com.noetic.siteminder.transformer.AccountTransformer;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository acountRepo;
    
    @Autowired
    AccountTransformer transformer;

    @Override
    public void addAccount(Account system) {
        acountRepo.save(system);
    }

    @Override
    public void deleteAccount(String urn) {
        acountRepo.deleteById(urn);
    }

    @Override
    public AccountDTO getAccount(String urn) throws TransformerException, AccountNotFoundException {
        
        if (!acountRepo.findById(urn).isPresent()) {
            throw new AccountNotFoundException("Account not found");
        } else {
            Account account = acountRepo.findById(urn).get();
            return transformer.transformDomainToDTO(account);
        }
    }

    @Override
    public GenericListDTO getAllAccounts(int page, int size) throws TransformerException {

        Page<Account> accList = null;
        List<AccountDTO> accountDTOList = new ArrayList<>();
        GenericListDTO genericListDTO = new GenericListDTO();
        AccountDTO accDTO = null;
        Pageable pageRequest = createPageRequest(page, size);
        accList = acountRepo.findAll(pageRequest);

        for (Account runConfig : accList) {
            accDTO = transformer.transformDomainToDTO(runConfig);
            accountDTOList.add(accDTO);
        }
        genericListDTO.setAccounts(accountDTOList);
        return genericListDTO;
    }

    private Pageable createPageRequest(int page, int size) {
        return new PageRequest(page, size);
    }

}
