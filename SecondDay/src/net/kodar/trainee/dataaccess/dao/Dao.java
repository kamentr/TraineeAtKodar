package net.kodar.trainee.dataaccess.dao;

import java.util.List;

public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    T save(T t);

    void update(T t);

    void delete(T t);

    void delete(int id);
}