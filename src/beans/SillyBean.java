package beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="silly")
public class SillyBean implements Silly {

	@PersistenceContext(unitName="ejb3samplePU")
	private EntityManager em;
	
	public void someMethod() {
		System.out.println(" some method called. ");
	}

	public void queryDatabase() {
		System.out.println(" querying database ...");
		List list = em.createQuery("select a from Auction a").getResultList();
		System.out.println("found " + list.size() + " auctions");
	}

}
