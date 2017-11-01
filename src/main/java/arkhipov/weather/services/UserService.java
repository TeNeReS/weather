package arkhipov.weather.services;

import arkhipov.weather.models.User;
import arkhipov.weather.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Created by Vladimir Arkhipov, v.arkhipov.v@gmail.com.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("User " + name + " not found!"));
    }

    public Optional<User> fyndById(Integer id) {
        return repository.findById(id);
    }
}