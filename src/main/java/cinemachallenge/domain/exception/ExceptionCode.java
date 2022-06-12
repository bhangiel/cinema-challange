package cinemachallenge.domain.exception;

public enum ExceptionCode {
    SCHEDULE_NOT_FOUND("SCH_001", "Schedule with id % not found", 400);

    private final String code;
    private final String message;
    private final int httpStatus;

    ExceptionCode(String code, String message, Integer httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
