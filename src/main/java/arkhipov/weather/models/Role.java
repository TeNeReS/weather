package arkhipov.weather.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Vladimir Arkhipov, v.arkhipov.v@gmail.com.
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}