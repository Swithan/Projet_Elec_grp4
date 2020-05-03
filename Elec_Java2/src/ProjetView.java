import java.awt.event.ActionListener;

import javax.swing.*;

public class ProjetView extends JFrame {
	
	private JComboBox choixPort = new JComboBox();
	private JTextField entrerDistance = new JTextField(10);
	private JLabel resultat = new JLabel();
	private JButton calculerDistance = new JButton("Afficher");
	
	ProjetView() {
		JPanel affichage = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
		affichage.add(choixPort);
		affichage.add(entrerDistance);
		affichage.add(resultat);
		affichage.add(calculerDistance);
		
		this.add(affichage);
	}
	
	public int getDistance() {
		return(Integer.parseInt(entrerDistance.getText()));
	}
	
	public void setDistance(int dist) {
		resultat.setText(Integer.toString(dist));
	}
	
	void calculerDistance(ActionListener listenForDistanceButton){
		calculerDistance.addActionListener(listenForDistanceButton);
	}
}
