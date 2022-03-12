package com.br.crud.command.sk.constraintValidator;

import javax.validation.Validator;

import org.junit.jupiter.api.Assertions;
import org.springframework.lang.NonNull;

public class ConstraintAssert {

    static Validator validator = ConstraintValidator.getValidator();

    public static <T> void validate(@NonNull T object, Class<?> type) {
        var constraint = ConstraintValidator.getValidator().validate(object);
        var violations = constraint.stream()
            .filter(c -> c.getConstraintDescriptor().getAnnotation().annotationType().equals(type))
            .findFirst();

        if (violations.isEmpty()) {
            Assertions.fail(String.format("A constraint %s difere da esperada.", type));
        }
    }
}
