package headfirst.proxy.kaugummiueberwachung;

public class KaugummiAutomatTestlauf {

	public static void main(String[] args) {
		int anzahl = 0;

        if (args.length < 2) {
            System.out.println("<Name> <Bestand> des Automaten");
            System.exit(1);
        }

        try {
        	anzahl = Integer.parseInt(args[1]);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		KaugummiAutomat kaugummiAutomat = new KaugummiAutomat(args[0], anzahl);

		KaugummiUeberwachung �berwachung = new KaugummiUeberwachung(kaugummiAutomat);

 
		System.out.println(kaugummiAutomat);

		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();
		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();

		System.out.println(kaugummiAutomat);

		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();
		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();

		System.out.println(kaugummiAutomat);

		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();
		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();

		System.out.println(kaugummiAutomat);

		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();
		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();

		System.out.println(kaugummiAutomat);

		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();
		kaugummiAutomat.m�nzeEinwerfen();
		kaugummiAutomat.griffDrehen();

		System.out.println(kaugummiAutomat);

		�berwachung.berichten();
	}
}
