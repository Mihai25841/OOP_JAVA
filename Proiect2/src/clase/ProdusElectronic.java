package clase;

import mypackage.InfoProdus;

public class ProdusElectronic extends Produs implements InfoProdus {
    private int luniGarantie;

    public ProdusElectronic(int id, String nume, double pret, int stoc, int luniGarantie) {
        super(id, nume, pret, stoc);
        this.luniGarantie = luniGarantie;
    }

    public int getLuniGarantie() { return luniGarantie; }
    public void setLuniGarantie(int luniGarantie) { this.luniGarantie = luniGarantie; }

    @Override
    public String obtineDetaliiSpecifice() {
        return "Garantie: " + luniGarantie + " luni";
    }

    @Override
    public boolean esteExpiratSauFaraGarantie() {
        return luniGarantie == 0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Electronic, " + obtineDetaliiSpecifice() + "]";
    }
}
