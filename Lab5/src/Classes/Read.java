package Classes;

import interfaces.IReader;
import java.io.File;
import java.util.Scanner;
import java.util.Objects;

public class Read implements IReader {

    String caleFisier;
    String continut;

    public Read(String caleFisier) {
        this.caleFisier = caleFisier;
    }

    public void citeste() {
        try {
            File f = new File(caleFisier);
            Scanner scFisier = new Scanner(f);
            String text = "";

            while (scFisier.hasNextLine()) {
                text = text + scFisier.nextLine() + " ";
            }

            this.continut = text;
            scFisier.close();
            System.out.println("Text fisier: " + caleFisier + ":");
            System.out.println(continut);

        } catch (Exception e) {
            System.out.println("Err fisier");
            this.continut = "gol";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Read)) {
            return false;
        }
        Read c = (Read) o;
        return //Objects.equals(this.caleFisier, c.caleFisier) &&
                Objects.equals(this.continut, c.continut);
    }

    @Override
    public String toString() {
        return "Read [caleFisier=" + caleFisier + ", continut=" + continut + "]";
    }
}
