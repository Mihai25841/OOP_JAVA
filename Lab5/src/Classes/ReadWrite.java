package Classes;

import interfaces.IReader;
import interfaces.IWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;

public class ReadWrite implements IReader, IWriter {

    String caleFisier;
    String continut;

    public ReadWrite(String caleFisier) {
        this.caleFisier = caleFisier;
    }

    public void citeste() {
        try {
            File f = new File(caleFisier);
            Scanner sc = new Scanner(f);

            continut = "gol";

            while (sc.hasNextLine()) {
                continut = continut + sc.nextLine() + " ";
            }

            sc.close();
            System.out.println("Citit");

        } catch (Exception e) {
            System.out.println("Err fisier");
        }
    }
    public void scriu_IWriter() {
        scrie(continut);
    }
    public void scrie(String text) {
        try {
            FileWriter fw = new FileWriter(caleFisier, true);
            fw.write(text + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Err fisier");
        }
    }

    public void scrie(List<String> lista) {
        try {
            FileWriter fw = new FileWriter(caleFisier, true);

            for (String element : lista) {
                fw.write(element + "\n");
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("Err fisier");
        }
    }
}
