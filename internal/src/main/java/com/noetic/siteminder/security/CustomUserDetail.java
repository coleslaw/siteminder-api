package com.noetic.siteminder.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.noetic.siteminder.config.DeployProfileConfig;

import java.util.Collection;

/**
 * Created by hurman on 29/06/2017.
 */
public class CustomUserDetail implements UserDetails {

    String password;
    String userName;

    public CustomUserDetail(DeployProfileConfig deployProfileConfig) {
        this.password = new BCryptPasswordEncoder().encode(deployProfileConfig.getApiPassword());
        this.userName = deployProfileConfig.getApiUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN,USER");
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
