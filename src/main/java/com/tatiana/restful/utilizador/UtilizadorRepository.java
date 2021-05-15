package com.tatiana.restful.utilizador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizadorRepository extends CrudRepository<Utilizador, Long> {


}
