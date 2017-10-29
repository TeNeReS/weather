package arkhipov.weather.repositories;

import arkhipov.weather.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
