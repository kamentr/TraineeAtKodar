package net.kodar.university.dataaccess.dao;

import java.util.List;

public interface Dao<ENT> {

    ENT get(Object id) throws Exception;

    List<ENT> getAll();

    ENT save(ENT t);

    void update(ENT t);

    void delete(ENT t);

    void deleteById(Object id);
}