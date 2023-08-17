package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_AREA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_AREA", columnNames = {"NM_AREA"})
})
public class Area {
    @Id
    @Column(name = "ID_AREA")
    // @GeneratedValue: define quais sao as regras de geracao de valor
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AREA")
    // @SequenceGenerator: da o nome do gerador de sequencia
    @SequenceGenerator(name = "SQ_AREA")
    private Long id;
    @Column(name = "NM_AREA", nullable = false)
    private String nome;
    @Column(name = "NM_DESCRICAO")
    private String descricao;

    public Area(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Area() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Area setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Area setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
