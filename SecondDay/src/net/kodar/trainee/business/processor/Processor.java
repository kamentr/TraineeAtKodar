package net.kodar.trainee.business.processor;

import net.kodar.trainee.data.entities.Student;

import java.util.List;

public interface Processor<P, R> {

    R get(int id);

    List<R> getAll();

    void save(P t);

    void update(P t);

    void delete(P t);

    void delete(int id);
}
