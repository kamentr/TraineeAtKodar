package net.kodar.university.dataaccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {


    protected abstract PK getId(ENT entity);

    protected abstract Map<PK, ENT> getData();

    protected Map<PK, ENT> data = getData();

    @Autowired
    private CrudRepository<ENT, PK> repository;

    @Override
    public ENT get(Object id) {
        return (ENT) repository.findById((PK) id);
        //return data.get(id);
    }

    @Override
    public List<ENT> getAll() {
        return (List<ENT>) repository.findAll();
        //return new ArrayList<>(data.values());
    }

    @Override
    public ENT save(ENT entity) {
        if (entity != null) {

            //data.put(getId(entity), entity);
            repository.save(entity);
            return (ENT) repository.findById(getId(entity));

        }
        return null;
    }


    @Override
    public void update(ENT entity) {
        //data.put(getId(entity), entity);
        repository.save(entity);
    }

    @Override
    public void delete(ENT entity) {
        //data.remove(getId(entity));
        repository.delete(entity);
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById((PK) id);
        //data.remove(id);
    }
}
