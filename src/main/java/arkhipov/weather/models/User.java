package arkhipov.weather.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
}
