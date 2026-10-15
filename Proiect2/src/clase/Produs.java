package clase;

import java.util.Objects;

public class Produs {
    private int id;
    private String nume;
    private double pret;
    private int stoc;

    public Produs(int id, String nume, double pret, int stoc) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
    }

    public Produs(String nume, double pret, int stoc) {
        this(-1, nume, pret, stoc);
    }

    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id; }
    public String getNume() {
        return nume; }
    public void setNume(String nume) {
        this.nume = nume; }
    public double getPret() {
        return pret; }
    public void setPret(double pret) {
        this.pret = pret; }
    public int getStoc() {
        return stoc; }
    public void setStoc(int stoc) {
        this.stoc = stoc; }

    @Override
    public String toString() {
        return "Produs: " + nume + " | Pret: " + pret + " lei | Stoc: " + stoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return id == produs.id && Objects.equals(nume, produs.nume);
    }
}
