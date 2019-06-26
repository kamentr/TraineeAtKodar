package net.kodar.trainee.dataaccess.dao;

import java.util.*;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {

    Map<PK, ENT> data = new HashMap<>();

    protected abstract PK getId(ENT entity);
    protected abstract UUID getIdentifier(ENT entity);

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

            Collection<ENT> list = data.values();
            return list
                    .stream()
                    .filter(ENT -> getIdentifier(ENT).equals(getIdentifier(entity)))
                    .findFirst()
                    .get();
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
        if (data.containsValue(get(id))) {
            ENT entity = data.get(id);
            data.remove(getId(entity));
        } else {
            //exception
        }
    }
}
