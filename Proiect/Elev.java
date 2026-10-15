public class Elev {
    private int id;
    private String nume;
    private int varsta;
    private double medie;
    private  static int sequence = 0;
    public Elev() {
        sequence++;
        id= sequence;
    }

    public Elev(String nume) {
        sequence++;
        id= sequence;
        setNume(nume);
    }

    public Elev(String nume, int varsta, double medie) {
        sequence++;
        id =sequence;
        setNume(nume);
        setVarsta(varsta);
        setMedie(medie);
    }

    public int getId() {
        return id;
    }
/*    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Err id invalid!");
        }
    }
*/
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        if (nume != null && !nume.isEmpty()) {
            this.nume = nume;
        } else {
            System.out.println("Err nume lipsa!");
        }
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        if (varsta >= 7 && varsta <= 60) {
            this.varsta = varsta;
        } else {
            System.out.println("Err varsta!");
        }
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        if (medie >= 1.0 && medie <= 10.0) {
            this.medie = medie;
        } else {
            System.out.println("Err medie!");
        }
    }

    public String getStatus() {
        if (medie >= 5) {
            return "Promovat";
        } else {
            return "Nepromovat";
        }
    }

    @Override
    public String toString() {
        return "Elevul: " + nume + "\n" +
                "Id: " + id + "\n" +
                "Varsta: " + varsta + "\n" +
                "Media: " + medie + "\n" +
                "Status: " + getStatus();
    }
}
