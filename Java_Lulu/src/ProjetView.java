import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProjetView {
	
	private JLabel titre = new JLabel("PROJET D'ELECTRONIQUE");
	private JLabel labelChoixPort = new JLabel("Choisissez le port : ");
	private String[] ports = new String[] {" ", " ", " ", " ", " "};
	public JComboBox<String> choixPort = new JComboBox<>(ports);
	private JLabel labelAfficherSeuil = new JLabel("Seuil de distance maximal actuel (cm) : 1");	
	private JLabel labelEntrerSeuil = new JLabel("  Nouveau seuil de distance (cm): ");
	private JTextField entrerSeuil = new JTextField(3);
	private JButton appliquerSeuil = new JButton("Appliquer");
	private JLabel alerte = new JLabel("Pas d'alertes");
	private JLabel resultat = new JLabel("Distance reçue : /");
	private JButton recherche = new JButton("Recherche ports");
	

	public ProjetView() {
		
		JFrame window = new JFrame();
		window.setTitle("Electronique Groupe 4");
		window.setSize(400, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setLayout(null);
		Font titreFont = new Font("Comic Sans MS", Font.PLAIN, 15);
	
		titre.setBounds(90, 10, 300, 20);
		titre.setForeground(Color.black);
		titre.setFont(titreFont);
		window.add(titre);
		
		
		
		labelChoixPort.setBounds(90, 70, 150, 20);
		window.add(labelChoixPort);
		choixPort.setBounds(210, 70, 70, 20);
		window.add(choixPort);
		
		
		labelEntrerSeuil.setBounds(70, 137, 200, 20);
		window.add(labelEntrerSeuil);
		entrerSeuil.setText("100");
		entrerSeuil.setBounds(260, 138, 50, 20);
		window.add(entrerSeuil);	
		appliquerSeuil.setBounds(150, 170, 100, 20);
		window.add(appliquerSeuil);
		
		labelAfficherSeuil.setBounds(65, 200, 250, 20);
		window.add(labelAfficherSeuil);
		
		alerte.setForeground(Color.green);
		alerte.setBounds(130, 260, 150, 20);
		window.add(alerte);
		
		resultat.setBounds(120, 350, 200, 20);
		window.add(resultat);
		
		recherche.setBounds(160, 300, 200, 20);
		window.add(recherche);

		window.setVisible(true);
	}
	
	public String getSeuil() {
		return(entrerSeuil.getText());
	}
	
	public void setSeuil(String seuil) {
		labelAfficherSeuil.setText("Seuil de distance maximal actuel (cm) : " + seuil);
	}
	
	public void setAlerte(String msgAlerte, Color color) {
		alerte.setText(msgAlerte);
		alerte.setForeground(color);
	}
	
	public void setDistance(String dist) {
		resultat.setText(dist);
	}

	void choisirPort(ActionListener listenForPort) {
		choixPort.addActionListener(listenForPort);
	}
	void recherchePorts(ActionListener listenForRechercheButton){
		recherche.addActionListener(listenForRechercheButton);
	}
	void calculerDistance(ActionListener listenForDistanceButton){
		appliquerSeuil.addActionListener(listenForDistanceButton);
	}
}