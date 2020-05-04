import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gnu.io.CommPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ProjetController implements SerialPortEventListener {
	private ProjetView theView;
	private ProjetModel theModel;
	
	public ProjetController(ProjetView theView, ProjetModel theModel/*, CommPort monCommPort*/){
		this.theView = theView;
		this.theModel = theModel;
		this.theView.calculerDistance(new DistanceListener());	
	}
	
	class DistanceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				theModel.setSeuil(theView.getSeuil());
				theView.setDistance(theModel.getSeuil());
			}
			catch(NumberFormatException ex){
				
			}
			
		}
		
	}
	
	@Override
	public void serialEvent(SerialPortEvent event) {
		try {
			BufferedReader myBuffer = new BufferedReader(new InputStreamReader(theModel.monPortSerie.getInputStream()));
			if(event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				String dataReceived = myBuffer.readLine();
				System.out.println("Recu : " + dataReceived);
				
				if(dataReceived.compareToIgnoreCase("1") ==0) {
					theView.setAlerte("! ! ! ALERTE RECUE ! ! !", Color.red);
				}
				else if(dataReceived.compareToIgnoreCase("2")==0) {
					theView.setAlerte("Rien à signaler.", Color.green);
				}
				else {
					theView.setDistance("Distance reçue : " + dataReceived + "cm.");
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
