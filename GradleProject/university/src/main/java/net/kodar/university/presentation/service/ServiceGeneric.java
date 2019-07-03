package net.kodar.university.presentation.service;


import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ServiceGeneric<IN, OUT> {

    @GetMapping
    List<OUT> getAll();

    @GetMapping(value = "/{id}")
    OUT get(@PathVariable(name = "id") int id);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable(name = "id") int id);


    @PostMapping
    OUT save(@RequestBody IN param);

    @PutMapping("/{id}")
    void update(@PathVariable(name = "id") int id, @RequestBody IN param) throws Exception;
}
