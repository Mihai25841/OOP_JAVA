import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int optiune = -1;

        while (optiune != 0) {
            System.out.println("\n MEniu");
            System.out.println("1. fisier: ");
            System.out.println("2. tastatura: ");
            System.out.println("0. iesire: ");
            System.out.print("optiunea: ");

            optiune = sc.nextInt();
            sc.nextLine();
            if (optiune == 1) {
                System.out.print("numele fisier: ");
                String fisier = sc.nextLine();

                DataRead dr1 = new DataRead(fisier);
                dr1.citeste();
                System.out.println(dr1);

            } else if (optiune == 2) {
                DataRead dr2 = new DataRead();
                dr2.citeste();
                System.out.println(dr2);

            } else if (optiune == 0) {
                System.out.println("Inchidere");
            } else {
                System.out.println("err optiune");
            }
        }

        sc.close();
    }
}
