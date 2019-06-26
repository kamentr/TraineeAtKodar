package net.kodar.trainee.business.processor;

import java.util.List;

public interface Processor<P, R> {

    R get(int id);

    List<R> getAll();

    R save(P t);

    void update(P t);

    void delete(P t);

    void delete(int id);
}
