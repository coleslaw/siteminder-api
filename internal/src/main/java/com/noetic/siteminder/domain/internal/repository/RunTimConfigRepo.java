package com.noetic.siteminder.domain.internal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noetic.siteminder.domain.internal.RunTimeConfig;

@Repository
public interface RunTimConfigRepo extends PagingAndSortingRepository<RunTimeConfig, String> {

    public final String GET_BY_CONFIGKEY_AND_ENV = "SELECT RT FROM RunTimeConfig RT WHERE configKey=:configkey AND "
            + "environment=:environment AND active=1";

    @Query(GET_BY_CONFIGKEY_AND_ENV)
    public RunTimeConfig getRunTimeConfigByConfigKeyAndEnvironment(@Param("configkey") String configKey,
            @Param("environment") String environment);

    public final String GET_BY_TAG_AND_ENV = "SELECT RT FROM RunTimeConfig RT WHERE tag=:tag AND "
            + "environment=:environment AND active=1";

    @Query(GET_BY_TAG_AND_ENV)
    public List<RunTimeConfig> getRunTimeConfigsByTagAndEnvironment(@Param("tag") String tag,
            @Param("environment") String environment);

}
