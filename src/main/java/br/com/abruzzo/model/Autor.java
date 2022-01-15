package br.com.abruzzo.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * @author Emmanuel Abruzzo
 * @date 12/01/2022
 */
@Entity
@Table(name="tb_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_autor", updatable = false, unique = true, nullable = false)
    private UUID uuid;

    @Column(name="nome", nullable = false)
    private String nome;

    @ManyToMany
    private List<Livro> livrosPublicados;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivrosPublicados() {
        return livrosPublicados;
    }

    public void setLivrosPublicados(List<Livro> livrosPublicados) {
        this.livrosPublicados = livrosPublicados;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Autor{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", livrosPublicados=" + livrosPublicados +
                '}';
    }
}
