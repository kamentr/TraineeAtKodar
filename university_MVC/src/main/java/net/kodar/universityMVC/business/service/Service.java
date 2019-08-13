package net.kodar.universityMVC.business.service;

import javax.validation.ValidationException;

import java.util.List;

public interface Service<IN, OUT> {

    OUT get(int id);

    List<OUT> getAll();

    OUT save(IN t) throws ValidationException;

    void update(IN t) throws ValidationException;

    void delete(IN t) throws ValidationException;

    void delete(int id);
}
