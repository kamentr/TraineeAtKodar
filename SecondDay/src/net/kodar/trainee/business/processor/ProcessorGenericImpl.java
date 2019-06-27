package net.kodar.trainee.business.processor;

import net.kodar.trainee.dataaccess.dao.Dao;
import net.kodar.trainee.dataaccess.dao.DaoImplGeneric;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ProcessorGenericImpl
        <IN, OUT, PK, ENT,
                DAO extends DaoImplGeneric<PK, ENT>,
                PTR extends BiFunction<IN, ENT, ENT>,
                RTR extends Function<ENT, OUT>>
        implements Processor<IN, OUT> {

    abstract int getID(IN entity);

    private DAO dao;
    private PTR ptr;
    private RTR rtr;

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
    public OUT save(IN ent) {

        ENT studentToSave = ptr.apply(ent, null);
        ENT save = dao.save(studentToSave);

        return rtr.apply(save);
    }

    @Override
    public void update(IN ent) {
        ENT entity = dao.get(getID(ent));

        if (null != entity) {
            ENT studentToUpdate = ptr.apply(ent, entity);
            dao.update(studentToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(IN ent) {
        ENT entity = dao.get(getID(ent));

        if (null != entity) {
            ENT entToDelete = ptr.apply(ent, entity);
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
