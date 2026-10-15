public class Garantie extends Produs {
    private int aniGarantie;

    public Garantie() {
        super();
        aniGarantie = 0;
    }

    public Garantie(String denumire, double pret, int stoc, int aniGarantie) {
        super(denumire, pret, stoc);
        this.aniGarantie = aniGarantie;
    }

    public int getAniGarantie() {
        return aniGarantie;
    }

    public void setAniGarantie(int aniGarantie) {
        this.aniGarantie = aniGarantie;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Garantie: " + aniGarantie + " ani";
    }
}