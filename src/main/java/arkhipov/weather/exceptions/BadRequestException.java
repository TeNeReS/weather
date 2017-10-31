package arkhipov.weather.exceptions;

/**
 * Created by Vladimir Arkhipov, v.arkhipov.v@gmail.com.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}