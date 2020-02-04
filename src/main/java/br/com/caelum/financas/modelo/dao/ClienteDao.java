package br.com.caelum.financas.modelo.dao;

import javax.persistence.EntityManager;

public class ClienteDao {
	
    private EntityManager em;

    public ClienteDao(EntityManager manager) {
        this.em = manager;
    }


}
