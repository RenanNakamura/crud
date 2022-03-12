package com.br.crud.command.sk.constraintValidator;

import javax.validation.Validator;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class ConstraintValidator {

    private static final LocalValidatorFactoryBean validatorFactory;

    public static synchronized Validator getValidator() {
        return validatorFactory.getValidator();
    }

    static {
        validatorFactory = new LocalValidatorFactoryBean();
        validatorFactory.afterPropertiesSet();
    }

}
