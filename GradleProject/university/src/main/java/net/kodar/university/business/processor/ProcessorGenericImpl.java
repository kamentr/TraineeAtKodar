package net.kodar.university.business.processor;

import net.kodar.university.business.validator.GenericValidator;
import net.kodar.university.dataaccess.dao.DaoImplGeneric;

import javax.validation.ValidationException;
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

    protected DAO dao;
    protected PTR ptr;
    protected RTR rtr;
    protected VAL val;


    @Override
    public OUT get(int id) {
        OUT out = rtr.apply(dao.get(id));

        return out;
    }

    @Override
    public List<OUT> getAll() {
        List<ENT> list = dao.getAll();

        List<OUT> entResults = list
                .stream()
                .map(s -> rtr.apply(s))
                .collect(Collectors.toList());

        return entResults;
    }

    @Override
    public OUT save(IN param) throws ValidationException {

        val.validate(param);

        ENT entToSave = ptr.apply(param, null);
        ENT save = dao.save(entToSave);

        return rtr.apply(save);
    }

    @Override
    public void update(IN param) throws ValidationException {

        val.validate(param);

        ENT entity = dao.get(getID(param));

        if (null != entity) {
            ENT entToUpdate = ptr.apply(param, entity);
            dao.update(entToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(IN param) throws ValidationException {

        val.validate(param);

        ENT entity = dao.get(getID(param));

        ENT entToDelete = ptr.apply(param, entity);
        dao.delete(entToDelete);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
