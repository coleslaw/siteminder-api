package com.noetic.siteminder.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noetic.siteminder.config.DeployProfileConfig;
import com.noetic.siteminder.config.DeployProfileConfigFactory;

/**
 * Created by hurman on 29/06/2017.
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        DeployProfileConfig deployProfileConfig = DeployProfileConfigFactory.forEnvironment();

        if (deployProfileConfig == null) {
            throw new UsernameNotFoundException("User for deployment environment not found");
        }

        if (!deployProfileConfig.getApiUsername().equals(s)) {
            throw new UsernameNotFoundException("User for deployment environment not found");
        }

        return new CustomUserDetail(deployProfileConfig);
    }
}
