package com.noetic.siteminder.domain.internal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.noetic.siteminder.domain.internal.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, String>{

}
