package headfirst.proxy.kaugummi;

import java.rmi.*;
 
public class KaugummiUeberwachungTestlauf {
 
	public static void main(String[] args) {
		String[] standort = {"rmi://frankfurt.kaukugel.de/kaugummiautomat",
		                     "rmi://stuttgart.kaukugel.de/kaugummiautomat",
		                     "rmi://hamburg.kaukugel.de/kaugummiautomat"}; 
 
		KaugummiUeberwachung[] �berwachung = new KaugummiUeberwachung[standort.length];
 
		for (int i=0;i < standort.length; i++) {
			try {
           		KaugummiAutomatRemote automat = 
						(KaugummiAutomatRemote) Naming.lookup(standort[i]);
           		�berwachung[i] = new KaugummiUeberwachung(automat);
				System.out.println(�berwachung[i]);
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
		}
 
		for(int i=0; i < �berwachung.length; i++) {
			�berwachung[i].berichten();
		}
	}
}
