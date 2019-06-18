package net.kodar.trainee.business;

import net.kodar.trainee.data.entities.Student;

import java.util.List;

public interface Processor<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    void delete(int id);
}
