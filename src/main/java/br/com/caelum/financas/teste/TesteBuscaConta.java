package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);
       
        //System.out.println(conta.getCliente().getNome());
        
        Query query = em.createQuery("select c from Conta c");
        List<Conta> contas = query.getResultList();
        
        for (Conta c : contas) {
			System.out.println(c.getCliente().getNome());
		}
        

        em.getTransaction().commit();
        em.close();
    }

}
