package com.tatiana.restful.utilizador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UtilizadorConfig {

    @Bean
    CommandLineRunner commandLineRunner(UtilizadorRepository repository){
        return args -> {
            Utilizador tatiana = new Utilizador(
                    "tatiana@email.com",
                    "Tatiana Rinaldi",
                    LocalDate.of(2000, Month.APRIL,01)
            );
            Utilizador teste = new Utilizador(
                    "teste@email.com",
                    "Teste Teste",
                    LocalDate.of(2001, Month.APRIL,30)
            );

            repository.saveAll(
                    List.of(tatiana,teste)
            );
        };
    }
}
