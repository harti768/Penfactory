package Gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GuiKategorieAdd implements ActionListener{

    JFrame frame;
    JPanel panel;
    JLabel ueberschrift = new JLabel("Kategorie hinzufuegen");
    JLabel name = new JLabel("Kategoriename");
    JTextField textName = new JTextField(50);
    JButton btnAddKategorie = new JButton("Kategorie hinzufuegen");
    JButton btnAbbrechen = new JButton("Abbrechen");
    GridBagConstraints gridPanel;

    public GuiKategorieAdd(){
        frame = new JFrame("Kategorie hinzufuegen");
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridBagLayout());
        btnAbbrechen.addActionListener(this);
        btnAddKategorie.addActionListener(this);
        textName.addActionListener(this);
        gridPanel.insets = new Insets(20,10,30,10);
        gridPanel.gridx = 1;
        gridPanel.gridy = 0;
        panel.add(ueberschrift, gridPanel);
        gridPanel.gridx = 0;
        gridPanel.gridy = 1;
        panel.add(name, gridPanel);
        gridPanel.gridx = 1;
        gridPanel.gridy = 1;
        panel.add(textName, gridPanel);
        gridPanel.gridx = 0;
        gridPanel.gridy = 2;
        panel.add(btnAbbrechen, gridPanel);
        gridPanel.gridx = 1;
        gridPanel.gridy = 2;
        panel.add(btnAddKategorie, gridPanel);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

     public void actionPerformed(ActionEvent action){
                String kategorieName = textName.getText();

                if (action.getSource() == btnAddKategorie){
                    frame.dispose();
                    JOptionPane.showMessageDialog((Component)null, "Kategorie " + kategorieName + " wurde hinzugefuegt");
                }

                if (action.getSource() == btnAbbrechen){
                    frame.dispose();
                }


}}