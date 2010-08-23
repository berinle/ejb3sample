package client;

import java.util.Hashtable;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

import beans.Silly;


public class SillyClient {
//	@EJB
//	private static Silly silly;

	public static void main(String[] args) throws Exception {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		Context c = new InitialContext(ht);	
		System.out.println("starting lookup and invocation");
		Object obj = c.lookup("silly#beans/Silly");
		System.out.println( "found: " + obj);
		Silly silly = (Silly) obj;		
		silly.someMethod();
		System.out.println("done!");
		
		silly.queryDatabase();
		System.out.println("done querying database!");
		
		//Running it via ACC within the container
		/*silly.someMethod();
		System.out.println("done!");*/
	}
}
