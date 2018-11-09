package com.noetic.api.siteminder.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noetic.api.siteminder.config.DeployProfileConfig;
import com.noetic.api.siteminder.config.DeployProfileConfigFactory;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        DeployProfileConfig deployProfileConfig = DeployProfileConfigFactory.forEnvironment();

        if (deployProfileConfig == null) {
            throw new UsernameNotFoundException("User for deployment environment not found");
        }

        if (!deployProfileConfig.getExternalApiUsername().equals(s)) {
           throw new UsernameNotFoundException("User for deployment environment not found");
        }

        return new CustomUserDetail(deployProfileConfig);
    }
}
