import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ProjetModel implements Observable {
	
	private String seuil = "0";
	private String dist = "20";
	
	public void setSeuil(String string) {
		this.seuil = string;
	}
	
	public String getSeuil() {
		return seuil;
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}
}
