package net.kodar.trainee.dataaccess.dao;

import java.util.*;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {


    protected abstract PK getId(ENT entity);
    protected abstract ENT getByIdentifier(ENT entity);
    protected abstract UUID getIdentifier(ENT entity);
    protected abstract Map<PK, ENT> getData();

    @Override
    public ENT get(int index) {
        return getData().get(index);
    }

    @Override
    public List<ENT> getAll() {
        return new ArrayList<>(getData().values());
    }

    @Override
    public ENT save(ENT entity) {
        if (entity != null) {
            getData().put(getId(entity), entity);

            return getByIdentifier(entity);
        }
        return null;
    }


    @Override
    public void update(ENT entity) {
        getData().put(getId(entity), entity);
    }

    @Override
    public void delete(ENT entity) {
        getData().remove(getId(entity));
    }

    @Override
    public void delete(int id) {
        if (getData().containsValue(get(id))) {
            ENT entity = getData().get(id);
            getData().remove(getId(entity));
        } else {
            //exception
        }
    }
}
