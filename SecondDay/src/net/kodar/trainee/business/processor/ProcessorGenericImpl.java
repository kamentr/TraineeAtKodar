package net.kodar.trainee.business.processor;

import net.kodar.trainee.business.validator.GenericValidator;
import net.kodar.trainee.dataaccess.dao.DaoImplGeneric;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ProcessorGenericImpl
        <IN, OUT, PK, ENT,
                DAO extends DaoImplGeneric<PK, ENT>,
                PTR extends BiFunction<IN, ENT, ENT>,
                RTR extends Function<ENT, OUT>,
                VAL extends GenericValidator<IN>>
        implements Processor<IN, OUT> {

    public abstract int getID(IN param);

    private DAO dao;
    private PTR ptr;
    private RTR rtr;
    private VAL val;

    @Override
    public OUT get(int id) {
        OUT out = rtr.apply(dao.get(id));

        return out;
    }

    @Override
    public List<OUT> getAll() {
        List<ENT> list = dao.getAll();

        List<OUT> studentResults = list
                .stream()
                .map(s -> rtr.apply(s))
                .collect(Collectors.toList());

        return studentResults;
    }

    @Override
    public OUT save(IN param) throws ValidationException {

        val.validate(param);

        ENT studentToSave = ptr.apply(param, null);
        ENT save = dao.save(studentToSave);

        return rtr.apply(save);
    }

    @Override
    public void update(IN param) throws ValidationException {

        val.validate(param);

        ENT entity = dao.get(getID(param));

        if (null != entity) {
            ENT studentToUpdate = ptr.apply(param, entity);
            dao.update(studentToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(IN param) throws ValidationException {

        val.validate(param);

        ENT entity = dao.get(getID(param));

        if (null != entity) {
            ENT entToDelete = ptr.apply(param, entity);
            dao.delete(entToDelete);
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }


}
