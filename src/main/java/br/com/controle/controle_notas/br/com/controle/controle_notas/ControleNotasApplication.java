package br.com.controle.controle_notas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleNotasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleNotasApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(NotaFiscalRepository repository) {
        return (args) -> {
           //O código abaixo está desligado agora
          /*NotaFiscal nota = new NotaFiscal();
            nota.setNumeroNF("12345");
            nota.setObservacoes("Teste de inser&ccedil;&atilde;o autom&aacute;tica");


            nota.setResponsavelSecretaria("Maria da Silva");
            nota.setSecretaria("Educa&ccedil;&atilde;o");
            nota.setResponsavelSetor("Jo&atilde;o");
            nota.setStatus("Pendente");

            repository.save(nota);
            System.out.println("&#x2705; Nota de teste inserida com sucesso!");
             */

        };
    }
}