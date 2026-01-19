package br.com.controle.controle_notas;

import jakarta.persistence.*;

@Entity
@Table(name = "notas_fiscais_v2")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroNF;
    private String responsavelSetor;
    private String secretaria;
    private String responsavelSecretaria;
    private String status;

    @Column(length = 1000)
    private String observacoes;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String historicoLog;

    private Double valor;
    private String nafGlobal;

    // 1. PRIMEIRA MUDANÇA: O CAMPO DA DATA
    // (Coloquei aqui junto com os outros campos)
    private java.time.LocalDateTime dataCadastro; // <--- NOVO CAMPO

    public NotaFiscal() {
    }

    // 2. SEGUNDA MUDANÇA: O GATILHO AUTOMÁTICO
    // (Essa função roda sozinha antes de salvar no banco)
    @PrePersist // <--- IMPORTANTE
    protected void aoCriar() {
        this.dataCadastro = java.time.LocalDateTime.now();
    }

    // --- GETTERS E SETTERS ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroNF() { return numeroNF; }
    public void setNumeroNF(String numeroNF) { this.numeroNF = numeroNF; }

    public String getResponsavelSetor() { return responsavelSetor; }
    public void setResponsavelSetor(String responsavelSetor) { this.responsavelSetor = responsavelSetor; }

    public String getSecretaria() { return secretaria; }
    public void setSecretaria(String secretaria) { this.secretaria = secretaria; }

    public String getResponsavelSecretaria() { return responsavelSecretaria; }
    public void setResponsavelSecretaria(String responsavelSecretaria) { this.responsavelSecretaria = responsavelSecretaria; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String getHistoricoLog() { return historicoLog; }
    public void setHistoricoLog(String historicoLog) { this.historicoLog = historicoLog; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getNafGlobal() { return nafGlobal; }
    public void setNafGlobal(String nafGlobal) { this.nafGlobal = nafGlobal; }

    // 3. TERCEIRA MUDANÇA: GETTER E SETTER DA DATA
    public java.time.LocalDateTime getDataCadastro() { // <--- NOVO GETTER
        return dataCadastro;
    }

    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { // <--- NOVO SETTER
        this.dataCadastro = dataCadastro;
    }
}