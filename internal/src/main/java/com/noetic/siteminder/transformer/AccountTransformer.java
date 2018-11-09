package com.noetic.siteminder.transformer;

import org.springframework.stereotype.Component;

import com.noetic.dto.AccountDTO;
import com.noetic.exception.TransformerException;
import com.noetic.siteminder.domain.internal.Account;

/**
 * Ruwan Chathuranga on 05-July-2018
 */
@Component
public class AccountTransformer extends AbstractTransformer<Account, AccountDTO>{

	@Override
	public AccountDTO transformDomainToDTO(Account domain) throws TransformerException {
		
		AccountDTO dto = new AccountDTO();
	
		dto.setId(domain.getId());
		dto.setVersion(domain.getVersion());
		dto.setName(domain.getName());
		dto.setCreated(domain.getCreated());
		dto.setModified(domain.getModified());
		dto.setIsDeleted(domain.getIsDeleted());
		dto.setIsActive(domain.getIsActive());

		return dto;
	}

	@Override
	public Account transformDTOToDomain(AccountDTO dto) throws TransformerException {
		
		Account domain = new Account();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setVersion(dto.getVersion());
		domain.setIsDeleted(dto.getIsDeleted());
		domain.setIsActive(dto.getIsActive());

		return domain;
	}

}
