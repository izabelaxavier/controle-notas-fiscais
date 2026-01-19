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
            // Criando uma nota de teste COMPLETA
            NotaFiscal nota = new NotaFiscal();
            nota.setNumeroNF("12345");
            nota.setObservacoes("Teste de inserção automática");

            // --- AQUI ESTÁ A CORREÇÃO: Preenchendo os campos obrigatórios ---
            nota.setResponsavelSecretaria("Maria da Silva");
            nota.setSecretaria("Educação");
            nota.setResponsavelSetor("João");
            nota.setStatus("Pendente");

            repository.save(nota);
            System.out.println("✅ Nota de teste inserida com sucesso!");
        };
    }
}