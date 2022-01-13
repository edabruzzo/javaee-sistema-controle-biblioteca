package br.com.abruzzo.dao;

import br.com.abruzzo.model.Autor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 * @author Emmanuel Abruzzo
 * @date 12/01/2022
 */
@Stateless
public class AutorDAO {


    @PersistenceContext(unitName = "biblioteca-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;


    public Autor findAutorByNome(String josé_saramago) {

        Query queryFindAuthorByFirstName = this.entityManager.createNamedQuery("findAuthorByFirstName");
        queryFindAuthorByFirstName.setParameter("firstName", "José Saramago");
        Autor autor = (Autor) queryFindAuthorByFirstName.getSingleResult();
        return autor;
    }
}
