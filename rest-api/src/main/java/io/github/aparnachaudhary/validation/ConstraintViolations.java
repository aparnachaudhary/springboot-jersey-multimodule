package io.github.aparnachaudhary.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aparna on 4/25/17.
 */
public class ConstraintViolations {

    private ConstraintViolations() { /* singleton */ }

    public static <T> String format(ConstraintViolation<T> v) {
        return String.format("%s %s (was %s)",
                v.getPropertyPath(),
                v.getMessage(),
                v.getInvalidValue());
    }

    public static String formatUntyped(Set<ConstraintViolation<?>> violations) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (ConstraintViolation<?> v : violations) {
            if (!first) {
                builder.append("; ");
            }
            builder.append(format(v));
            first = false;
        }
        return builder.toString();
    }

    public static ConstraintViolationException simpleException(String msg) {
        return new ConstraintViolationException(msg, new HashSet<ConstraintViolation<?>>());
    }
}
