package net.kodar.universityMVC.dataaccess.dao;

import net.kodar.universityMVC.dataaccess.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


import java.util.*;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {


    protected abstract PK getId(ENT entity);

    @Autowired
    protected CrudRepository<ENT, PK> repository;

    @Override
    public ENT get(Object id){
        Optional<ENT> entity = repository.findById((PK) id);

        if(entity.isPresent()){
            return entity.get();
        }else {
            throw new IllegalArgumentException("Incorrect id");
        }
    }

    @Override
    public List<ENT> getAll() {

        Iterable<ENT> entList = repository.findAll();
        List<ENT> result = new ArrayList<>();
        entList.forEach(result::add);
        return result;

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

        entityToUpdate.ifPresent(ent -> repository.save(entity));
    }

    @Override
    public void delete(ENT entity) {
        if(entity!=null) {
            if (repository.existsById(getId(entity))) {
                repository.delete(entity);
            } else {
                throw new IllegalArgumentException(entity.getClass().toString() + " could not be deleted");
            }
        }else {
            throw new IllegalArgumentException("Cannot delete null");
        }
    }

    @Override
    public void deleteById(Object id) {

        if (repository.existsById((PK)id)) {
            repository.deleteById((PK) id);
        }else {
            throw new IllegalArgumentException("Object could not be deleted");
        }
    }
}
