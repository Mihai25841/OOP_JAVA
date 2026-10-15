public class Main {
    public static void main(String[] args) {

        Produs p1 = new Produs();
        Produs p2 = new Produs("Laptop");
        Produs p3 = new Produs("Telefon", 2500, 10);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        p3.setPret(2300);
        p3.setStoc(15);

        System.out.println();
        System.out.println("modif:");
        System.out.println(p3);

        p3.afiseazaPret();

        System.out.println();
        System.out.println("Produs cu garantie:");

        Garantie g1 = new Garantie("Laptop Lenovo", 3500, 5, 2);

        System.out.println(g1);

        g1.setAniGarantie(3);

        System.out.println("modifi gar:");
        System.out.println(g1);
    }
}