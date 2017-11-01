package arkhipov.weather.security;

import arkhipov.weather.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class TokenAuthService {
    private static final String AUTH_HEADRE_NAME = "X-Auth-Token";

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private UserService userService;

    public Optional<Authentication> getAuthentication(HttpServletRequest request) {
        return null;
//                Optional
//                .ofNullable(request.getHeader(AUTH_HEADRE_NAME))
//                .flatMap(tokenHandler::extractUserId)
//                .flatMap(userService::fyndById)
//                .map(UserAuthenticarion::new);
    }
}
