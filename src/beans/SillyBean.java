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
		System.out.println("some method called. ");
	}

	public void queryDatabase() {
		//try{
		System.out.println("*querying database ...");
		List list = em.createQuery("select a from Auction a").getResultList();
		System.out.println("found " + list.size() + " auctions");
		//}catch(Exception e){
		//	e.printStackTrace();
		//}
	}
	
	public Auction queryForAuction(long id){
		System.out.println("queryForAuction() called.");
		List list =  em.createQuery("select a from Auction a where a.id = ?1")
		.setParameter(1, id)
		.getResultList();
		
		Auction auction = (Auction) (list.isEmpty()? null: list.get(0));
		
		System.out.println("found " + auction);
		return auction;
	}
	
	public Auction queryForAuctionUsingSingleResult(long id){
		Auction auction  = (Auction) em.createQuery("select a from Auction a where a.id = ?1")
		.setParameter(1, id)
		.getSingleResult();
		return auction;
	}

}
