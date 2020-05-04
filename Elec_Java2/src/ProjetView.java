import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProjetView extends JFrame {
	
	private JLabel labelChoixPort = new JLabel("Choisissez le port : ");
	private String[] ports = new String[] {"COM1", "COM2"};
	private JComboBox<String> choixPort = new JComboBox<>(ports);
	
	private JLabel labelAfficherSeuil = new JLabel("Seuil de distance maximal : ");
	
	private JLabel labelEntrerSeuil = new JLabel("Modifier le seuil de distance : ");
	private JTextField entrerSeuil = new JTextField(10);
	private JLabel resultat = new JLabel("Distance : ");
	private JButton calculerDistance = new JButton("Afficher");

	public ProjetView() {
		
		setTitle("Electronique Groupe 4");
		JPanel affichage = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 600);
	
		affichage.add(labelChoixPort);
		affichage.add(choixPort);
		affichage.add(labelAfficherSeuil);
		affichage.add(labelEntrerSeuil);
		affichage.add(entrerSeuil);
		affichage.add(resultat);
		affichage.add(calculerDistance);
		
		this.add(affichage);
	}
	
	public int getSeuil() {
		return(Integer.parseInt(entrerSeuil.getText()));
	}
	
	public void setDistance(int dist) {
		resultat.setText(Integer.toString(dist));
	}
	
	void calculerDistance(ActionListener listenForDistanceButton){
		calculerDistance.addActionListener(listenForDistanceButton);
	}
}
