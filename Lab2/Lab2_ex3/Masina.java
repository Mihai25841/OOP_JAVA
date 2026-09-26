public class Masina {
    private String marca;
    private String model;
    private double pret;
    private String culoare;
    private double viteza;

    public Masina() {
    }

    public void setMarca(String m) {
        if (m.equals("BMW") == false) {
            this.marca = m;
        } else {
            System.out.println("Nu acceptam BMW!");
        }
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Masina are marca " + marca + " si are modelul " + model;
    }

    public Masina(String marca, String model, String culoare, double viteza) {
        setMarca(marca);
        this.model = model;
        this.culoare = culoare;
        this.viteza = viteza;
    }

    public Masina(String marca, String model, double pret, String culoare, double viteza) {
        setMarca(marca);
        this.model = model;
        this.pret = pret;
        this.culoare = culoare;
        this.viteza = viteza;
    }

    public void afisare() {
        System.out.println("Marca: " + marca);
        System.out.println("Model: " + model);
        System.out.println("Pret: " + pret);
        System.out.println("Culoare: " + culoare);
        System.out.println("Viteza: " + viteza);
    }
}