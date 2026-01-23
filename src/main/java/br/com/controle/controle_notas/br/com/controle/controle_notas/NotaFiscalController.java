package br.com.controle.controle_notas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notas")

@Tag(name = "Gestão de Notas Fiscais", description = "Controle completo do fluxo de documentos da Prefeitura")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository repository;

    @GetMapping

    @Operation(summary = "Listar todas", description = "Busca e retorna a lista de todas as notas cadastradas")
    public List<NotaFiscal> listarNotas() {
        return repository.findAll();
    }

    @PostMapping

    @Operation(summary = "Cadastrar nota", description = "Salva uma nova nota fiscal no banco de dados")
    public NotaFiscal criarNota(@RequestBody NotaFiscal nota) {
        return repository.save(nota);
    }

    @PutMapping("/{id}")

    @Operation(summary = "Atualizar nota", description = "Atualiza os dados de uma nota existente pelo ID")
    public NotaFiscal atualizarNota(@PathVariable Long id, @RequestBody NotaFiscal notaAtualizada) {
        notaAtualizada.setId(id);
        return repository.save(notaAtualizada);
    }

    @DeleteMapping("/{id}")

    @Operation(summary = "Excluir nota", description = "Remove permanentemente uma nota do sistema")
    public void deletarNota(@PathVariable Long id) {
        repository.deleteById(id);
    }
}