package dev.cosmingherghe.pma.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static dev.cosmingherghe.pma.security.AplicationUserAuthority.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(PROJECT_READ, PROJECT_WRITE, USER_READ, USER_WRITE)),
    USER(Sets.newHashSet());

    private final Set<AplicationUserAuthority> authorities;

    ApplicationUserRole(Set<AplicationUserAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<AplicationUserAuthority> getAuthorities() {
        return authorities;
    }
}
