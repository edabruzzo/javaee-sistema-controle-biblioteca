package br.com.abruzzo.model;

import jakarta.persistence.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @link https://www.baeldung.com/hibernate-date-time
 *
 * @author Emmanuel Abruzzo
 * @date 13/01/2022
 */
@Entity
@Table(name="tb_livro")

@NamedQueries({
    @NamedQuery(name = "Livro_FindByNome",
        query = "from Livro where nomeLivro = :nomeLivro"),
        @NamedQuery(name = "Livro_FindAllByDataPublicacao",
        query = "from Livro where dataPublicacao = :dataPublicacao")

})
public class Livro {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isbn", updatable = false, unique = true, nullable = false)
    private Long ISBN;

    @Column(name="nomeLivro", nullable = false)
    private String nomeLivro;


    @Basic
    private LocalDate dataPublicao;


    @ManyToMany
    private List<Autor> autores;


    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public LocalDate getDataPublicao() {
        return dataPublicao;
    }

    public void setDataPublicao(LocalDate dataPublicao) {
        this.dataPublicao = dataPublicao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Livro{" +
                "ISBN=" + ISBN +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", dataPublicao=" + dataPublicao +
                ", autores=" + autores +
                '}';
    }
}
