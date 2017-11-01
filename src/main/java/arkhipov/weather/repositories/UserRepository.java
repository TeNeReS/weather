package arkhipov.weather.repositories;

import arkhipov.weather.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByName(String name);

    Optional<User> findById(Integer id);
}
