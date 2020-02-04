package br.com.caelum.financas.modelo.dao;

import javax.persistence.EntityManager;

public class CategoriaDao {
	
    private EntityManager em;

    public CategoriaDao(EntityManager manager) {
        this.em = manager;
    }

}
