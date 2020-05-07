import java.io.InputStream;
import java.util.Enumeration;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class ProjetModel {

	public int distanceRecue;	
	public int seuil = 0;
	public SerialPort monPortSerie;
	public CommPortIdentifier portId;
    public Enumeration portList;
    public CommPort monCommPort;
    InputStream inputStream;
    Thread readThread;
    
	public void setSeuil(int val) {
		this.seuil = val;
	}
	
	public int getSeuil() {
		return seuil;
	}
	
	public void setDistance(String dist) {
		int tempo = Integer.parseInt(dist);
		this.distanceRecue = tempo;
	}
	
	public int getDistance() {
		return distanceRecue;
	}
}
