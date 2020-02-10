import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesNovasCategorias {

	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Restaurantes");
        Categoria categoria2 = new Categoria("Viagens");

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(1);

        Query query = em.createQuery("select m from Movimentacao m where m.id=3");

        List<Movimentacao> movimentacoes = query.getResultList();

        em.persist(categoria1);
        em.persist(categoria2);
        
        for (Movimentacao m : movimentacoes) {
        	m.setCategorias(Arrays.asList(categoria1, categoria2));
        	em.persist(m);
        }

        em.getTransaction().commit();
        em.close();
	}

}
