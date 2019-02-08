package headfirst.proxy.kaugummi;

import java.util.Random;

public class HatMuenzeZustand implements Zustand {
	Random randomGewinn = new Random(System.currentTimeMillis());
	transient KaugummiAutomat kaugummiAutomat;
 
	public HatMuenzeZustand(KaugummiAutomat kaugummiAutomat) {
		this.kaugummiAutomat = kaugummiAutomat;
	}
  
	public void m�nzeEinwerfen() {
		System.out.println("Sie k�nnen keine weitere M�nze einwerfen");
	}
 
	public void m�nzeAuswerfen() {
		System.out.println("M�nze wird zur�ckgegeben");
		kaugummiAutomat.setZustand(kaugummiAutomat.getKeineM�nzeZustand());
	}
 
	public void griffDrehen() {
		System.out.println("Sie haben den Griff gedreht ...");
		int winner = randomGewinn.nextInt(10);
		if (winner == 0) {
			kaugummiAutomat.setZustand(kaugummiAutomat.getGewinnZustand());
		} else {
			kaugummiAutomat.setZustand(kaugummiAutomat.getVerkauftZustand());
		}
	}

    public void kugelAusgeben() {
        System.out.println("Es wird keine Kugel ausgegeben");
    }
 
	public String toString() {
		return "bereit f�r Drehen des Griffs";
	}
}
