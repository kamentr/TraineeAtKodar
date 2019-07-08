package net.kodar.university.presentation.service;

import net.kodar.university.business.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

public abstract class ServiceGeneric<IN, OUT,
        PR extends Processor<IN, OUT>> {

    @Autowired
    protected PR processor;


    @GetMapping
    public List<OUT> getAll() {
        return processor.getAll();
    }

    @GetMapping(value = "/{id}")
    public OUT get(@PathVariable(name="id") int id) {
        return processor.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id") int id) {
        processor.delete(id);
    }

    @PostMapping
    public OUT save(@Valid @RequestBody IN param){
        OUT result= processor.save(param);
        return result;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable(name="id") int id, @Valid @RequestBody IN param) throws Exception {
        if(getId(param) == id) {
            processor.update(param);
        }else {
            throw new Exception("Wrong id or param");
        }
    }

    protected abstract int getId(IN param);
}
