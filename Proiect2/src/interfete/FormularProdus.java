package interfete;

import clase.*;
import baza_date.ProdusService;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FormularProdus extends JDialog {
    private JTextField txtNume = new JTextField(15);
    private JTextField txtPret = new JTextField(15);
    private JTextField txtStoc = new JTextField(15);
    private JComboBox<String> comboTip = new JComboBox<>(new String[]{"Alimentar", "Electronic"});
    private JTextField txtSpecific = new JTextField(15);
    private JLabel lblSpecific = new JLabel("Data Expirare (YYYY-MM-DD):");

    public FormularProdus(JFrame parinte, ProdusService service) {
        super(parinte, "Adaugare Produs Nou", true);
        setSize(380, 280);
        setLocationRelativeTo(parinte);
        setLayout(new GridLayout(6, 2, 8, 8));

        add(new JLabel(" Nume produs:")); add(txtNume);
        add(new JLabel(" Pret unitar:")); add(txtPret);
        add(new JLabel(" Cantitate stoc:")); add(txtStoc);
        add(new JLabel(" Tip produs:")); add(comboTip);
        add(lblSpecific); add(txtSpecific);

        JButton btnSalveaza = new JButton("Salveaza in baza de date");
        add(btnSalveaza);

        comboTip.addActionListener(e -> {
            if (comboTip.getSelectedIndex() == 0) {
                lblSpecific.setText("Data Expirare (YYYY-MM-DD):");
            } else {
                lblSpecific.setText("Garantie (numar luni):");
            }
        });

        btnSalveaza.addActionListener(e -> {
            try {
                String nume = txtNume.getText();
                double pret = Double.parseDouble(txtPret.getText());
                int stoc = Integer.parseInt(txtStoc.getText());
                Produs p;

                if (comboTip.getSelectedIndex() == 0) {
                    LocalDate data = LocalDate.parse(txtSpecific.getText());
                    p = new ProdusAlimentar(0, nume, pret, stoc, data);
                } else {
                    int garantie = Integer.parseInt(txtSpecific.getText());
                    p = new ProdusElectronic(0, nume, pret, stoc, garantie);
                }

                service.valideazaSiSalveaza(p);
                JOptionPane.showMessageDialog(this, "Produs adaugat cu succes!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Date eronate: " + ex.getMessage(), "Eroare Validare", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
