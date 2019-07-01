package net.kodar.university.business.validator;


import javax.validation.ValidationException;

public interface GenericValidator<T> {

    void validate(T object) throws ValidationException;

}
