import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int id;
    private String denumire;
    private int capacitate;
    private  static int sequence = 0;
    private List<Elev> elevi;

    public Sala() {
        elevi = new ArrayList<>();
    }

    public Sala(String denumire, int capacitate) {
        sequence++;
        id =sequence;
        setDenumire(denumire);
        setCapacitate(capacitate);
        elevi = new ArrayList<>();
        System.out.print(this);
    }

    public Sala(String denumire, int capacitate, List<Elev> elevi) {
        sequence++;
        id =sequence;
        setDenumire(denumire);
        setCapacitate(capacitate);
        this.elevi = new ArrayList<>();
        for (Elev e : elevi) {
            adaugaElev(e);
        }
    }

    public int getId() {
        return id; }

    /*public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Err id sala invalid!");
        }
    }
*/
    public String getDenumire() {
        return denumire; }

    public void setDenumire(String denumire) {
        if (denumire != null && !denumire.isEmpty()) {
            this.denumire = denumire;
        } else {
            System.out.println("Err denumire lipsa!");
        }
    }

    public int getCapacitate() { return capacitate; }

    public void setCapacitate(int capacitate) {
        if (capacitate > 0) {
            this.capacitate = capacitate;
        } else {
            System.out.println("Err capacitate invalida!");
        }
    }

    public List<Elev> getElevi() {
        return elevi; }

    public void adaugaElev(Elev elev) {
        if (elevi.size() < capacitate) {
            elevi.add(elev);
        } else {
            System.out.println("Sala full!");
        }
    }

    public void stergeElev(int idElev) {
        Elev gasit = cautaElevDupaId(idElev);
        if (gasit != null ) {
            elevi.remove(gasit);
            System.out.println("Elevul  sters din sala.");
        } else {
            System.out.println("Elevul nu e in aceea sala.");
        }
    }

    public Elev cautaElevDupaId(int idElev) {
        for (Elev e : elevi) {
            if (e.getId() == idElev) {
                return e;
            }
        }
        return null;
    }

    public List<Elev> getEleviPromovati() {
        List<Elev> promovati = new ArrayList<>();
        for (Elev e : elevi) {
            if (e.getMedie() >= 5) {
                promovati.add(e);
            }
        }
        return promovati;
    }

    public List<Elev> getEleviNepromovati() {
        List<Elev> nepromovati = new ArrayList<>();
        for (Elev e : elevi) {
            if (e.getMedie() < 5) {
                nepromovati.add(e);
            }
        }
        return nepromovati;
    }

    @Override
    public String toString() {
        String rezultat = "Sala: " + denumire + "\n" +
                "Id: " + id + "\n" +
                "Capacitate: " + elevi.size() + "/" + capacitate + "\n" +
                "Elevi:\n";
        if (elevi.isEmpty()) {
            rezultat += "  (niciun elev)\n";
        } else {
            for (Elev e : elevi) {
                rezultat += " " + e.getNume() + " (media: " + e.getMedie() + ")\n";
            }
        }
        return rezultat;
    }
}