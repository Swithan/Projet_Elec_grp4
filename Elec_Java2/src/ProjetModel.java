import gnu.io.SerialPort;

public class ProjetModel {

	public String seuil = "0";
	public SerialPort monPortSerie;
	
	public void setSeuil(String val) {
		this.seuil = val;
	}
	
	public String getSeuil() {
		return seuil;
	}
}
