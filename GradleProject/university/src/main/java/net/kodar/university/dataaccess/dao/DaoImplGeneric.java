package net.kodar.university.dataaccess.dao;

import com.google.common.collect.Lists;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {


    protected abstract PK getId(ENT entity);

    @Autowired
    private CrudRepository<ENT, PK> repository;

    @Override
    public ENT get(Object id) {
        Optional<ENT> entity = repository.findById((PK) id);

        return entity.orElse(null);

    }

    @Override
    public List<ENT> getAll() {

        Iterable<ENT> entList = repository.findAll();
        return Lists.newArrayList(entList);

    }

    @Override
    public ENT save(ENT entity) {
        if (entity != null) {

            return repository.save(entity);

        }
        return null;
    }

    @Override
    public void update(ENT entity) {

        Optional<ENT> entityToUpdate = repository.findById(getId(entity));

        if (entityToUpdate.isPresent()) {
            repository.save(entity);
        }
    }

    @Override
    public void delete(ENT entity) {
        if (entity != null) {
            repository.delete(entity);
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deleteById(Object id) {

        Optional<ENT> entityToDelete = repository.findById((PK) id);
        if (entityToDelete.isPresent()) {
            repository.deleteById((PK) id);
        }
    }
}
