import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti un numar: ");
        int nr = sc.nextInt();
        Random rnd = new Random();
        for (int i = 0; i < nr; ++i) {
            System.out.println("Urmatorul nr.:" + rnd.nextInt(255));
        }
    }
}