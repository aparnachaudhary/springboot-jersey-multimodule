package io.github.aparnachaudhary.exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * ConstraintViolationException that includes RestException-like data to create a standard error
 * response. Note that this does not inherit from RestException because it must inherit from
 * ConstraintViolationException to be caught by the correct ExceptionMapper.
 */
public class RestConstraintViolationException extends ConstraintViolationException {

    public static final int DEFAULT_ERROR_CODE =
            ConstraintViolationExceptionMapper.UNPROCESSABLE_ENTITY_CODE;
    private int errorCode;

    public RestConstraintViolationException(String message, int errorCode) {
        this(message, errorCode, null);
    }

    public RestConstraintViolationException(String message, int errorCode,
                                            Set<? extends ConstraintViolation<?>>
                                                    constraintViolations) {
        super(message, constraintViolations);
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return ConstraintViolationExceptionMapper.UNPROCESSABLE_ENTITY_CODE;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
