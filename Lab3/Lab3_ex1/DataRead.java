import java.io.File;
import java.util.Scanner;

public class DataRead {
    private String dateCitite;
    public String tipCititor = "tastatura";

    private String caleFisier;
    private String continutFisier;

    public DataRead() {
    }

    public DataRead(String caleFisier) {
        this.tipCititor = "fisier";
        this.caleFisier = caleFisier;
    }

    public String getDateCitite() {
        return dateCitite;
    }

    public void setDateCitite(String dateCitite) {
        if (dateCitite != null) {
            this.dateCitite = dateCitite;
        } else {
            System.out.println("Err: Date goale!");
        }
    }

    public String getCaleFisier() {
        return caleFisier;
    }

    public void setCaleFisier(String caleFisier) {
        this.caleFisier = caleFisier;
    }

    public String getContinutFisier() {
        return continutFisier;
    }

    public void setContinutFisier(String continutFisier) {
        this.continutFisier = continutFisier;
    }

    public void citeste() {
        if (tipCititor.equals("tastatura")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceti datele: ");
            String linie = scanner.nextLine();
            setDateCitite(linie);
        }
        else if (tipCititor.equals("fisier")) {
            try {

                File f = new File(caleFisier);
                Scanner scFisier = new Scanner(f);

                String text = "";
                while (scFisier.hasNextLine()) {
                    text = text + scFisier.nextLine() + " ";
                }

                this.continutFisier = text;
                scFisier.close();
                System.out.println("Fisier citit!");
            }catch (Exception e) {
                System.out.println("Err fisier");
                this.continutFisier = "gol";
            }
        }
    }

    @Override
    public String toString() {
        if (tipCititor.equals("tastatura")) {
            return "DateCitire:\n" +
                    "\nTip: " + tipCititor +
                    "\ndate: " + dateCitite;
        } else {
            return "DateCitire:\n" +
                    "\nTip date: " + tipCititor +
                    "\nloc stocare: " + caleFisier +
                    "\ndate: " + continutFisier;
        }
    }
}
