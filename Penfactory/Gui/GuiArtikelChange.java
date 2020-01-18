package Gui;

import java.awt.*;
import javax.swing.*;

import Src.Artikel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import Src.*;

public class GuiArtikelChange extends JFrame implements ActionListener{

    JFrame frame;
    String changeName;
    ArrayList<String> kategorieListe = new ArrayList();
    JLabel ueberschrift = new JLabel("Aritikel veraendern");
    JLabel bezeichnung = new JLabel("Bezeichnung");
    JLabel kategorie = new JLabel("Kategorie");
    JLabel anzalh = new JLabel("Anzahl");
    JLabel gewicht = new JLabel("Gewicht");
    JLabel preis = new JLabel("Preis");
    JLabel platzNummer = new JLabel("Platznummer");
    JLabel stueck = new JLabel("Stk");
    JLabel euro = new JLabel("Euro");
    JLabel kilo = new JLabel("kg");
    JTextField textBezeichnung = new JTextField(20);
    JTextField textAnzahl = new JTextField(10);
    JTextField textGewicht = new JTextField(10);
    JTextField textPlatznummer = new JTextField(20);
    JTextField textPreis = new JTextField(10);
    JComboBox comboKategorie;
    JButton btnKategorieAdd;
    JButton btnArtikelChange;
    JButton btnAbbrechen;
    JPanel ganzes;
    JPanel oben;
    JPanel unten;
    GridBagConstraints gridOben;
    GridBagConstraints gridUnten;


    public GuiArtikelChange(String artikelName) {
    	changeName = artikelName;
    	Src.Artikel artikel = Src.Datenverwaltung.getArtikel(artikelName);
        frame = new JFrame("Artikel veraendern");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textBezeichnung.setText(artikel.produktBezeichnung);
        textAnzahl.setText(artikel.anzahl); //Casten
        textGewicht.setText(artikel.gewicht);
        textPlatznummer.setText(artikel.platzNummer);
        textPreis.setText(artikel.preis);
        btnKategorieAdd = new JButton("Kategorie hinzufuegen");
        btnArtikelChange = new JButton("Artikel verändern");
        btnAbbrechen = new JButton("Abbrechen");
        comboKategorie = new JComboBox(Src.Datenverwaltung.getKList().toArray());
        comboKategorie.setSelectedItem(artikel.kategorie);
        ganzes = new JPanel(new FlowLayout(1, 0, 0));
        oben = new JPanel(new GridBagLayout());
        unten = new JPanel(new GridBagLayout());
        gridOben = new GridBagConstraints();
        gridUnten = new GridBagConstraints();
        frame.getContentPane().add(ganzes);
        ganzes.add(oben);
        ganzes.add(unten);
        btnArtikelChange.addActionListener(this);
        btnAbbrechen.addActionListener(this);
        btnKategorieAdd.addActionListener(this);
        textAnzahl.addActionListener(this);
        textBezeichnung.addActionListener(this);
        textGewicht.addActionListener(this);
        textPlatznummer.addActionListener(this);
        comboKategorie.addActionListener(this);
        gridOben.insets = new Insets(10,10,10,10);
        gridUnten.insets = new Insets(50,200,15,200);
        gridOben.gridx = 1;
        gridOben.gridy = 0;
        oben.add(ueberschrift, gridOben);
        gridOben.gridx = 0;
        gridOben.gridy = 1;
        oben.add(bezeichnung, gridOben);
        gridOben.gridx = 1;
        oben.add(textBezeichnung, gridOben);
        gridOben.gridx = 0;
        gridOben.gridy = 2;
        oben.add(kategorie, gridOben);
        gridOben.gridx = 1;
        oben.add(comboKategorie, gridOben);
        gridOben.gridx = 3;
        gridOben.gridy = 2;
        oben.add(btnKategorieAdd, gridOben);
        gridOben.gridx = 0;
        gridOben.gridy = 3;
        oben.add(anzalh, gridOben);
        gridOben.gridx = 1;
        oben.add(textAnzahl, gridOben);
        gridOben.gridx = 2;
        oben.add(stueck, gridOben);
        gridOben.gridx = 0;
        gridOben.gridy = 4;
        oben.add(gewicht, gridOben);
        gridOben.gridx = 1;
        oben.add(textGewicht, gridOben);
        gridOben.gridx = 2;
        oben.add(kilo, gridOben);
        gridOben.gridx = 0;
        gridOben.gridy = 5;
        oben.add(preis, gridOben);
        gridOben.gridx = 1;
        oben.add(textPreis, gridOben);
        gridOben.gridx = 2;
        oben.add(euro, gridOben);
        gridOben.gridx = 0;
        gridOben.gridy = 6;
        oben.add(platzNummer, gridOben);
        gridOben.gridx = 1;
        gridOben.gridy = 6;
        oben.add(textPlatznummer, gridOben);
        gridUnten.gridx = 0;
        gridUnten.gridy = 5;
        unten.add(btnAbbrechen, gridUnten);
        gridUnten.gridx = 1;
        unten.add(btnArtikelChange, gridUnten);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent action){
        String artikelBezeichnung = textBezeichnung.getText();
        String kategorie =(String) comboKategorie.getSelectedItem(); //Casten!!
        String preis = textPreis.getText();
        String gewicht = textGewicht.getText();
        String anzahl = textAnzahl.getText();
        String nummer = textPlatznummer.getText();

        if (action.getSource() == btnKategorieAdd){
            GuiKategorieAdd fenster = new GuiKategorieAdd();

        }

        if (action.getSource() == btnAbbrechen){
            frame.dispose();
            GuiHauptfenster fenster = new GuiHauptfenster();

        }

        if (action.getSource() == btnArtikelChange){
            frame.dispose();
            Src.Artikel a = new Src.Artikel(artikelBezeichnung, kategorie, anzahl, gewicht, preis, nummer);  //Casten
            Src.Datenverwaltung.changeArtikel(changeName, a);
            JOptionPane.showMessageDialog((Component)null, "Artikel " + artikelBezeichnung + " wurde veraendert");
            GuiHauptfenster fenster = new GuiHauptfenster();

        }
    }

}