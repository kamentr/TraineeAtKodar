package net.kodar.universityUI.business.processor;

import javax.validation.ValidationException;

import java.util.List;

public interface Processor<IN, OUT> {

    OUT get(int id);

    List<OUT> getAll();

    OUT save(IN t) throws ValidationException;

    void update(IN t) throws ValidationException;

    void delete(IN t) throws ValidationException;

    void delete(int id);
}
