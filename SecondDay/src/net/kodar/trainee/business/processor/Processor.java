package net.kodar.trainee.business.processor;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface Processor<P, R> {

    R get(int id);

    List<R> getAll();

    R save(P t) throws ValidationException;

    void update(P t) throws ValidationException;

    void delete(P t) throws ValidationException;

    void delete(int id);
}
