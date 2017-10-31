package arkhipov.weather.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionInfoHandler {
    private static Logger LOG = LoggerFactory.getLogger(ExceptionInfoHandler.class);

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ErrorInfo handleError(HttpServletRequest req, NotFoundException e) {
        return logAndGetErrorInfo(req, e, false);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ErrorInfo handleError(HttpServletRequest req, BadRequestException e) {
        return logAndGetErrorInfo(req, e, false);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo handleError(HttpServletRequest req, Exception e) {
        return logAndGetErrorInfo(req, e, true);
    }

    private static ErrorInfo logAndGetErrorInfo(HttpServletRequest req, Exception e, boolean logException) {
        if (logException) {
            LOG.error("Exception at request " + req.getRequestURL() +
                    "; parameters {name=" + req.getParameter("name") +
                    ", lon=" + req.getParameter("lon") +
                    ", lat=" + req.getParameter("lat") +
                    "}; " + e.getClass());
        } else {
            LOG.warn("Exception at request " + req.getRequestURL() +
                    "; parameters {name=" + req.getParameter("name") +
                    ", lon=" + req.getParameter("lon") +
                    ", lat=" + req.getParameter("lat") +
                    "}; " + e.getClass());
        }
        return new ErrorInfo(req.getRequestURL(), e);
    }
}