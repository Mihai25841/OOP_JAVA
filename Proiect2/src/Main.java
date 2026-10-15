import interfete.FereastraPrincipala;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FereastraPrincipala().setVisible(true);
        });
    }
}