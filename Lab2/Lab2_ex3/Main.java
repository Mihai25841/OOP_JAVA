import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Masina skoda = new Masina("Skoda", "Octavia", 25000, "Alb", 220);
        Masina vw = new Masina("VW", "Passat", 20000, "Negru", 200);

        Masina bmw = new Masina();
        bmw.setMarca("BMW");
        skoda.afisare();
        vw.afisare();
        bmw.afisare();
        System.out.println("Introdu masina: ");
        int N = sc.nextInt();
        sc.nextLine();
        List<Masina> listaMasini = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            System.out.println("\n date masina pt masina : " + i);

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Pret: ");
            double pret = sc.nextDouble();
            sc.nextLine();

            System.out.print("Culoare: ");
            String culoare = sc.nextLine();

            System.out.print("Viteza: ");
            double viteza = sc.nextDouble();
            sc.nextLine();

            Masina m = new Masina(marca, model, pret, culoare, viteza);
            listaMasini.add(m);
        }

        System.out.println("\n masini: " + N);
        for (Masina m : listaMasini) {
            m.afisare();
        }

        sc.close();
    }
}