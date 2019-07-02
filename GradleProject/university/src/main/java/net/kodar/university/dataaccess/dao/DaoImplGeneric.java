package net.kodar.university.dataaccess.dao;

import java.util.*;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {


    protected abstract PK getId(ENT entity);

    protected abstract ENT getByIdentifier(ENT entity);

    protected abstract UUID getIdentifier(ENT entity);

    protected abstract Map<PK, ENT> getData();

    private Map<PK, ENT> data = getData();

    @Override
    public ENT get(int index) {
        return data.get(index);
    }

    @Override
    public List<ENT> getAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public ENT save(ENT entity) {
        if (entity != null) {
            data.put(getId(entity), entity);

            return getByIdentifier(entity);
        }
        return null;
    }


    @Override
    public void update(ENT entity) {
        data.put(getId(entity), entity);
    }

    @Override
    public void delete(ENT entity) {
        data.remove(getId(entity));
    }

    @Override
    public void delete(int id) {
        data.remove(id);
    }
}
