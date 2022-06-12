package cinemachallenge.domain.exception;

public class DomainException extends RuntimeException {
    private final ExceptionCode code;

    public DomainException(ExceptionCode code, Object... variables) {
        super(String.format(code.getMessage(), variables));
        this.code = code;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
