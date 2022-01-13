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

    private List<Livro> livrosPublicados;



}
