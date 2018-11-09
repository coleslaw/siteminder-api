package com.noetic.siteminder.domain.internal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noetic.siteminder.domain.internal.System;


@Repository
public interface SystemRepository extends PagingAndSortingRepository<System, Integer> {

	public final String CHECK_AUTH_QRY = "SELECT s FROM System s WHERE apiKey=:apiKey " 
			+ "AND isActive=true "
			+ "AND isDeleted=false " 
			+ "AND system_id = :systemId " 
			+ "AND startDate<:currentDate AND endDate>:currentDate";

	@Query(CHECK_AUTH_QRY)
	public System getLicenseSystem(@Param("apiKey") String apiKey,
			@Param("systemId") int systemId, @Param("currentDate") long currentDate);
}
