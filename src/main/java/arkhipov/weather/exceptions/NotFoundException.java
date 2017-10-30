package arkhipov.weather.exceptions;

/**
 * Created by Vladimir Arkhipov, v.arkhipov.v@gmail.com.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}