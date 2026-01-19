package br.com.controle.controle_notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository repository;

    // LISTAR (GET)
    @GetMapping
    public List<NotaFiscal> listarNotas() {
        return repository.findAll();
    }

    // CRIAR (POST)
    @PostMapping
    public NotaFiscal criarNota(@RequestBody NotaFiscal nota) {
        return repository.save(nota);
    }

    // EDITAR (PUT)
    @PutMapping("/{id}")
    public NotaFiscal atualizarNota(@PathVariable Long id, @RequestBody NotaFiscal notaAtualizada) {
        notaAtualizada.setId(id); // Garante que vai atualizar o ID certo
        return repository.save(notaAtualizada);
    }

    // DELETAR (DELETE)
    @DeleteMapping("/{id}")
    public void deletarNota(@PathVariable Long id) {
        repository.deleteById(id);
    }
}