package arkhipov.weather.exceptions;

public class ErrorInfo {
    private final String url;
    private final String detail;

    public ErrorInfo(CharSequence url, Throwable ex) {
        this.url = url.toString();
        this.detail = ex.getLocalizedMessage();
    }

    public String getUrl() {
        return url;
    }

    public String getDetail() {
        return detail;
    }
}