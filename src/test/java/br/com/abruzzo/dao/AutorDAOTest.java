package br.com.abruzzo.dao;

import br.com.abruzzo.model.Autor;

/**
 * @author Emmanuel Abruzzo
 * @date 12/01/2022
 */
class AutorDAOTest {

    /**
     * TODO injetar o AutorDAO ou o persistence Context
     * Ou mockar AutorDAO
     */
    public AutorDAO autorDAO;


    void testaBuscaAutorPeloNome(){

        Autor autor = this.autorDAO.findAutorByNome("José Saramago");


    }





}
