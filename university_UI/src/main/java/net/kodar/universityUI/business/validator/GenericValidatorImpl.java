package net.kodar.universityUI.business.validator;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;

public class GenericValidatorImpl<T> implements GenericValidator<T> {

    @Autowired
    protected Validator validator;

    public void validate(T obj){

        this.validator.validate(obj);

    }
}
