package headfirst.proxy.javaproxy;

import java.lang.reflect.*;
import java.util.*;

public class PartnerVermittlungsTestlauf {
	Hashtable datingDB = new Hashtable();
 	
	public static void main(String[] args) {
		PartnerVermittlungsTestlauf test = new PartnerVermittlungsTestlauf();
		test.laufen();
	}
 
	public PartnerVermittlungsTestlauf() {
		initialisiereDatenbank();
	}

	public void laufen() {
		PersonBean henri = getPersonAusDatenbank("Henri Javabean"); 
		
		PersonBean eigent�merProxy = getEigent�merProxy(henri);
		System.out.println("Name ist " + eigent�merProxy.getName());
		eigent�merProxy.setInteressen("Bowling, Schach");
		System.out.println("Interessen durch Eigent�mer-Proxy gesetzt.");
		try {
			eigent�merProxy.setHotOrNotBewertung(10);
		} catch (Exception e) {
			System.out.println("Bewertung kann nicht durch Eigent�mer-Proxy gesetzt werden.");
		}
		System.out.println("Bewertung ist " + eigent�merProxy.getHotOrNotBewertung());

		PersonBean nichtEigent�merProxy = getNichtEigent�merProxy(henri);
		System.out.println("Name ist " + nichtEigent�merProxy.getName());
		try {
			nichtEigent�merProxy.setInteressen("Bowling, Schach");
		} catch (Exception e) {
			System.out.println("Interessen k�nnen nicht durch Nicht-Eigent�mer-Proxy gesetzt werden.");
		}
		nichtEigent�merProxy.setHotOrNotBewertung(3);
		System.out.println("Bewertung durch Nicht-Eigent�mer-Proxy gesetzt.");
		System.out.println("Bewertung ist " + nichtEigent�merProxy.getHotOrNotBewertung());
	}

	PersonBean getEigent�merProxy(PersonBean person) {
 		
        return (PersonBean) Proxy.newProxyInstance( 
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new EigentuemerInvocationHandler(person));
	}

	PersonBean getNichtEigent�merProxy(PersonBean person) {
		
        return (PersonBean) Proxy.newProxyInstance(
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new NichtEigentuemerInvocationHandler(person));
	}

	PersonBean getPersonAusDatenbank(String name) {
		return (PersonBean)datingDB.get(name);
	}

	void initialisiereDatenbank() {
		PersonBean henri = new PersonBeanImpl();
		henri.setName("Henri Javabean");
		henri.setInteressen("Autos, Computer, Musik");
		henri.setHotOrNotBewertung(7);
		datingDB.put(henri.getName(), henri);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInteressen("ebay, Filme, Musik");
		kelly.setHotOrNotBewertung(6);
		datingDB.put(kelly.getName(), kelly);
	}
}
