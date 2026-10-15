public class Produs {
    private String denumire;
    private double pret;
    protected int stoc;

    public Produs() {
        denumire = " ";
        pret = 0;
        stoc = 0;
    }

    public Produs(String denumire) {
        this.denumire = denumire;
        pret = 0;
        stoc = 0;
    }

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    @Override
    public String toString() {
        return "Denumire: " + denumire +
                ", Pret: " + pret +
                ", Stoc: " + stoc;
    }

    public void afiseazaPret() {
        System.out.println("Pretul este: " + pret + " lei");
    }
}