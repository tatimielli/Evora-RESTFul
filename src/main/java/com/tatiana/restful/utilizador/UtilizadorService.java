package com.tatiana.restful.utilizador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.apache.commons.validator.routines.EmailValidator;

@Service
public class UtilizadorService {

    private final UtilizadorRepository utilizadorRepository;

    @Autowired
    public UtilizadorService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    public Iterable<Utilizador> getAll(){
        return utilizadorRepository.findAll();
    }

    public void insert(Utilizador utilizador) {
        validate(utilizador);
        utilizadorRepository.save(utilizador);
    }

    public Utilizador getById(Long id) {
        return utilizadorRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            String.format("Utilizador %d não encontrado",id)
                    );
                });
    }

    public void update(Utilizador utilizadorAtualizado, Long id) {

        Utilizador utilizador = getById(id);
        utilizador.setDataNascimento(utilizadorAtualizado.getDataNascimento());
        utilizador.setEmail(utilizadorAtualizado.getEmail());
        utilizador.setNome(utilizadorAtualizado.getNome());
        insert(utilizador);
    }

    public void delete(Long id) {
        utilizadorRepository.deleteById(id);
    }

    private void validate(Utilizador utilizador){
        if(!isValidEmail(utilizador.getEmail())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Email '%s' inválido",utilizador.getEmail())
            );
        }
    }

    private boolean isValidEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }
}
