package net.kodar.universityUI.business.validator;


import javax.validation.ValidationException;

public interface GenericValidator<T> {

    void validate(T object) throws ValidationException;

}
