package beans;

import javax.ejb.Remote;

@Remote
public interface Silly {

	void someMethod();
	void queryDatabase();
	Auction queryForAuction(long id);
	Auction queryForAuctionUsingSingleResult(long id);
}
