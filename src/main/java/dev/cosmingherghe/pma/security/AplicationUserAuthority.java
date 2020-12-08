package dev.cosmingherghe.pma.security;

public enum AplicationUserAuthority {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    PROJECT_READ("project:read"),
    PROJECT_WRITE("project:write");

    private final String authority;

    AplicationUserAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}