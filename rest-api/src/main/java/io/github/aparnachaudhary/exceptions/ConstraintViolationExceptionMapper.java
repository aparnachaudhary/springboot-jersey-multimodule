package io.github.aparnachaudhary.exceptions;

import io.github.aparnachaudhary.entities.RestErrorEntity;
import io.github.aparnachaudhary.validation.ConstraintViolations;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by aparna on 4/25/17.
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {


    public static final int UNPROCESSABLE_ENTITY_CODE = 422;
    public static final Response.StatusType UNPROCESSABLE_ENTITY = new Response.StatusType() {
        @Override
        public int getStatusCode() {
            return UNPROCESSABLE_ENTITY_CODE;
        }

        @Override
        public Response.Status.Family getFamily() {
            return Response.Status.Family.CLIENT_ERROR;
        }

        @Override
        public String getReasonPhrase() {
            return "Unprocessable entity";
        }
    };

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        final RestErrorEntity message;
        if (exception instanceof RestConstraintViolationException) {
            RestConstraintViolationException restException = (RestConstraintViolationException) exception;
            message = new RestErrorEntity(restException.getErrorCode(), restException.getMessage(), restException.getMessage());
        } else {
            String violationMessage = ConstraintViolations.formatUntyped(exception.getConstraintViolations());
            if (violationMessage.length() == 0) {
                violationMessage = exception.getMessage();
            }
            message = new RestErrorEntity(
                    UNPROCESSABLE_ENTITY_CODE,
                    violationMessage,
                    violationMessage
            );
        }

        return Response.status(UNPROCESSABLE_ENTITY_CODE)
                .entity(message)
                .build();
    }
}
