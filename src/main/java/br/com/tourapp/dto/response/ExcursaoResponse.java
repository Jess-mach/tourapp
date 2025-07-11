package br.com.tourapp.dto.response;

import br.com.tourapp.enums.StatusExcursao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
public class ExcursaoResponse {

    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataSaida;
    private LocalDateTime dataRetorno;
    private BigDecimal preco;
    private Integer vagasTotal;
    private Integer vagasOcupadas;
    private Integer vagasDisponiveis;
    private String localSaida;
    private String localDestino;
    private String observacoes;
    private List<String> imagens;
    private Boolean aceitaPix;
    private Boolean aceitaCartao;
    private StatusExcursao status;
    private LocalDateTime createdAt;

    // Para responses de organizador (dados públicos)
    private String nomeOrganizador;
    private String emailOrganizador;
    private String telefoneOrganizador;
    private CompaniaResponse compania;
    private UserInfoResponse criador;

    // Construtores
    public ExcursaoResponse() {}

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(LocalDateTime dataSaida) { this.dataSaida = dataSaida; }

    public LocalDateTime getDataRetorno() { return dataRetorno; }
    public void setDataRetorno(LocalDateTime dataRetorno) { this.dataRetorno = dataRetorno; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getVagasTotal() { return vagasTotal; }
    public void setVagasTotal(Integer vagasTotal) { this.vagasTotal = vagasTotal; }

    public Integer getVagasOcupadas() { return vagasOcupadas; }
    public void setVagasOcupadas(Integer vagasOcupadas) { this.vagasOcupadas = vagasOcupadas; }

    public Integer getVagasDisponiveis() { return vagasDisponiveis; }
    public void setVagasDisponiveis(Integer vagasDisponiveis) { this.vagasDisponiveis = vagasDisponiveis; }

    public String getLocalSaida() { return localSaida; }
    public void setLocalSaida(String localSaida) { this.localSaida = localSaida; }

    public String getLocalDestino() { return localDestino; }
    public void setLocalDestino(String localDestino) { this.localDestino = localDestino; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public List<String> getImagens() { return imagens; }
    public void setImagens(List<String> imagens) { this.imagens = imagens; }

    public Boolean getAceitaPix() { return aceitaPix; }
    public void setAceitaPix(Boolean aceitaPix) { this.aceitaPix = aceitaPix; }

    public Boolean getAceitaCartao() { return aceitaCartao; }
    public void setAceitaCartao(Boolean aceitaCartao) { this.aceitaCartao = aceitaCartao; }

    public StatusExcursao getStatus() { return status; }
    public void setStatus(StatusExcursao status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getNomeOrganizador() { return nomeOrganizador; }
    public void setNomeOrganizador(String nomeOrganizador) { this.nomeOrganizador = nomeOrganizador; }

    public String getEmailOrganizador() { return emailOrganizador; }
    public void setEmailOrganizador(String emailOrganizador) { this.emailOrganizador = emailOrganizador; }

    public String getTelefoneOrganizador() { return telefoneOrganizador; }
    public void setTelefoneOrganizador(String telefoneOrganizador) { this.telefoneOrganizador = telefoneOrganizador; }

    public void setCompaniaId(UUID id) {
        this.compania.setId(id);
    }

    public void setNomeCompania(@NotBlank(message = "Nome da empresa é obrigatório") @Size(min = 2, max = 150, message = "Nome da empresa deve ter entre 2 e 150 caracteres") String nomeEmpresa) {
        this.compania.setNomeEmpresa(nomeEmpresa);
    }

    public void setCriadorId(UUID id) {
        if (this.criador == null) {
            this.criador = UserInfoResponse.builder()
                    .id(id)
                    .build();
        } else {
            this.criador = this.criador.toBuilder()
                    .id(id)
                    .build();
        }
    }

    public void setNomeCriador(@NotBlank(message = "Nome é obrigatório") @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres") String fullName) {
        if (this.criador == null) {
            this.criador = UserInfoResponse.builder()
                    .fullName(fullName)
                    .build();
        } else {
            this.criador = this.criador.toBuilder()
                    .fullName(fullName)
                    .build();
        }
    }
}

