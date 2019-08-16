package net.kodar.universityUI.dataaccess.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public abstract class DaoImplGeneric<PK, ENT> implements Dao<ENT> {

    protected abstract PK getId(ENT entity);

    protected abstract Class<ENT> getClazz();

    private final String URLprefix = "http://localhost:8080/";

    private final String TYPE = getClazz().getSimpleName().toLowerCase();

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private
    RestTemplate restTemplate;

    @Autowired
    protected CrudRepository<ENT, PK> repository;

    @Override
    public ENT get(Object id) {

        String url = URLprefix + TYPE + "/" + id;

        ENT entity = restTemplate.getForObject(url, getClazz());

        if (entity != null) {
            return entity;
        } else {
            throw new IllegalArgumentException("Incorrect id");
        }
    }


    @Override
    public List<ENT> getAll() {
        String url = URLprefix + TYPE;

        ResponseEntity<List<ENT>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ENT>>() {
        });

        List<ENT> responseList = response.getBody();

        List<ENT> result = responseList.stream()
                .map(ent -> mapper.convertValue(ent, getClazz())) //from linked hash map to List<ENT>
                .collect(Collectors.toList());

        return result;

    }

    @Override
    public ENT save(ENT entity) {
        String url = URLprefix + TYPE;

        if (entity != null) {

            restTemplate.postForEntity(url, entity, String.class);

            return entity;

        }
        return null;
    }

    @Override
    public void update(ENT entity) {
        String url = URLprefix + TYPE;

        if (this.get(getId(entity)) != null) {

            restTemplate.postForEntity(url, entity, String.class);

        }
    }

    @Override
    public void delete(ENT entity) {
        if (entity != null) {
            if (repository.existsById(getId(entity))) {
                repository.delete(entity);
            } else {
                throw new IllegalArgumentException(entity.getClass().toString() + " could not be deleted");
            }
        } else {
            throw new IllegalArgumentException("Cannot delete null");
        }
    }

    @Override
    public void deleteById(Object id) {
        String url = URLprefix + TYPE;

        if (repository.existsById((PK) id)) {
            restTemplate.delete(url + "/" + id);
        } else {
            throw new IllegalArgumentException("Object could not be deleted");
        }
    }
}
