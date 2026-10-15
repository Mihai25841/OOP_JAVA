package interfete;
import clase.*;
import mypackage.InfoProdus;
import baza_date.ProdusService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FereastraPrincipala extends JFrame {
    private final ProdusService service = new ProdusService();
    private JTable tabelDate;
    private DefaultTableModel modelTabel;

    public FereastraPrincipala() {
        setTitle("Gestiune Stoc Produse");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] coloane = {"ID", "Denumire", "Pret (Ron)", "Stoc", "Categorie", "Detalii Specifice"};
        modelTabel = new DefaultTableModel(coloane, 0);
        tabelDate = new JTable(modelTabel);

        JPanel panelActiuni = new JPanel();
        JButton btnAdauga = new JButton("Adauga");
        JButton btnSterge = new JButton("Sterge");
        JButton btnActualizeaza = new JButton("Incarcare date");

        panelActiuni.add(btnAdauga);
        panelActiuni.add(btnSterge);
        panelActiuni.add(btnActualizeaza);

        add(new JScrollPane(tabelDate), BorderLayout.CENTER);
        add(panelActiuni, BorderLayout.SOUTH);

        btnAdauga.addActionListener(e -> {
            FormularProdus formular = new FormularProdus(this, service);
            formular.setVisible(true);
            incarcaDateleInTabel();
        });

        btnSterge.addActionListener(e -> {
            int randSelectat = tabelDate.getSelectedRow();
            if (randSelectat != -1) {
                int id = (int) modelTabel.getValueAt(randSelectat, 0);
                try {
                    service.getRepo().sterge(id);
                    JOptionPane.showMessageDialog(this, "Produsul a fost sters!");
                    incarcaDateleInTabel();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Eroare: " + ex.getMessage(), "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selectati un rand din tabel mai intai.");
            }
        });

        btnActualizeaza.addActionListener(e -> incarcaDateleInTabel());
        incarcaDateleInTabel();
    }

    private void incarcaDateleInTabel() {
        try {
            modelTabel.setRowCount(0);
            List<Produs> produse = service.getRepo().gasesteToate();

            for (Produs p : produse) {
                String categorie = (p instanceof ProdusAlimentar) ? "Alimentar" : "Electronic";
                String detalii = (p instanceof InfoProdus) ? ((InfoProdus) p).obtineDetaliiSpecifice() : "";
                modelTabel.addRow(new Object[] {p.getId(), p.getNume(), p.getPret(), p.getStoc(), categorie, detalii});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Eroare Neon: " + ex.getMessage(), "Eroare Conexiune", JOptionPane.ERROR_MESSAGE);
        }
    }
}
