package headfirst.proxy.kaugummi;

import java.io.*;
  
public interface Zustand extends Serializable {
	public void m�nzeEinwerfen();
	public void m�nzeAuswerfen();
	public void griffDrehen();
	public void kugelAusgeben();
}
