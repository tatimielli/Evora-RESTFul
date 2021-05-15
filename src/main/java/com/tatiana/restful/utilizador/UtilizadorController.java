package com.tatiana.restful.utilizador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UtilizadorController {

    private final UtilizadorService utilizadorService;

    @Autowired
    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping(path = "api/v1/utilizadores")
    public Iterable<Utilizador> getUtilizador(){
        return utilizadorService.getAll();
    }

    @GetMapping(path = "api/v1/utilizador/{id}")
    public Utilizador getUtilizador(@PathVariable Long id){
        return utilizadorService.getById(id);
    }

    @PostMapping(path = "api/v1/utilizador")
    public void insertUtilizador(@RequestBody Utilizador utilizador){
        utilizadorService.insert(utilizador);
    }

    @PutMapping(path = "api/v1/utilizador/{id}")
    public void insertUtilizador(@RequestBody Utilizador utilizador, @PathVariable Long id){
        utilizadorService.update(utilizador, id);
    }

    @DeleteMapping(path = "api/v1/utilizador/{id}")
    public void deleteUtilizador(@PathVariable Long id){
        utilizadorService.delete(id);
    }
}
