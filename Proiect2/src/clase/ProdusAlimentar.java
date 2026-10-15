package clase;
import mypackage.InfoProdus;
import java.time.LocalDate;

public class ProdusAlimentar extends Produs implements InfoProdus {
    private LocalDate dataExpirare;

    public ProdusAlimentar(int id, String nume, double pret, int stoc, LocalDate dataExpirare) {
        super(id, nume, pret, stoc);
        this.dataExpirare = dataExpirare;
    }

    public LocalDate getDataExpirare() { return dataExpirare;
    }
    public void setDataExpirare(LocalDate dataExpirare) {
        this.dataExpirare = dataExpirare; }

    @Override
    public String obtineDetaliiSpecifice() {
        return "Expira la: " + dataExpirare.toString();
    }

    @Override
    public boolean esteExpiratSauFaraGarantie() {
        return LocalDate.now().isAfter(dataExpirare);
    }

    @Override
    public String toString() {
        return super.toString() + " [Alimentar, " + obtineDetaliiSpecifice() + "]";
    }
}
