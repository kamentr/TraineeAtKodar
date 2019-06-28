package net.kodar.trainee.business.validator;


import javax.xml.bind.ValidationException;

public interface GenericValidator<T> {

    void validate(T object) throws ValidationException;

}
