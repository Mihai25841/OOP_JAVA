import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Elev> totiElevii = new ArrayList<>();
    static List<Sala> toateSalile = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int optiune = -1;
        while (optiune != 0) {
            afiseazaMeniu();
            optiune = sc.nextInt();
            sc.nextLine();

            if (optiune == 1)  adaugaElev();
            else if (optiune == 2)  creeazaSala();
            else if (optiune == 3)  adaugaElevInSala();
            else if (optiune == 4)  afiseazaTotiElevii();
            else if (optiune == 5)  afiseazaToateSalile();
            else if (optiune == 6)  afiseazaEleviiUneiSali();
            else if (optiune == 7)  cautaElevDupaId();
            else if (optiune == 8)  mutaElev();
            else if (optiune == 9)  stergeElev();
            else if (optiune == 10) stergeSala();
            else if (optiune == 11) filtreazaPromovati();
            else if (optiune == 12) filtreazaNepromovati();
            else if (optiune == 13) filtreazaDupaMedia();
            else if (optiune == 14) filtreazaDupaVarsta();
            else if (optiune == 15) cautaDupaNume();
            else if (optiune == 16) afiseazaStatistici();
            else if (optiune == 17) sorteazaElevi();
            else if (optiune == 0) {
                System.out.println("inchidere program");
            } else {
                System.out.println("Optiune inexistenta! Alegeti din nou.");
            }
        }
    }

    static void afiseazaMeniu() {
        System.out.println("\n MENIU ");
        System.out.println("1.  Adauga elev");
        System.out.println("2.  Creeaza sala");
        System.out.println("3.  Adauga elev intr-o sala");
        System.out.println("4.  Afiseaza toti elevii");
        System.out.println("5.  Afiseaza toate salile");
        System.out.println("6.  Afiseaza elevii unei sali");
        System.out.println("7.  Cauta elev dupa ID");
        System.out.println("8.  Muta elev dintr-o sala in alta");
        System.out.println("9.  Sterge elev");
        System.out.println("10. Sterge sala");
        System.out.println("11. Filtreaza elevii promovati");
        System.out.println("12. Filtreaza elevii nepromovati");
        System.out.println("13. Filtreaza dupa interval de medie");
        System.out.println("14. Filtreaza dupa varsta");
        System.out.println("15. Cauta elevi dupa nume");
        System.out.println("16. Afiseaza statistici");
        System.out.println("17. Sorteaza elevii");
        System.out.println("0/18. Inchide aplicatia");
        System.out.print("Alegeti optiunea: ");
    }

    static void adaugaElev() {
        System.out.print("Nume: ");
        String nume = sc.nextLine();

        System.out.print("Varsta: ");
        int varsta = sc.nextInt(); sc.nextLine();

        System.out.print("Medie: ");
        double medie = sc.nextDouble(); sc.nextLine();

        Elev elev = new Elev(nume, varsta, medie);
        totiElevii.add(elev);
        System.out.println("Elev adaugat!");
        System.out.println(elev);
    }

    static void creeazaSala() {
        System.out.print("Denumire: ");
        String denumire = sc.nextLine();

        System.out.print("Capacitate: ");
        int capacitate = sc.nextInt(); sc.nextLine();

        Sala sala = new Sala(denumire, capacitate);
        toateSalile.add(sala);
        System.out.println("Sala creata!");
        System.out.println(sala);
    }

    static void adaugaElevInSala() {
        System.out.print("ID elev: ");
        int idElev = sc.nextInt(); sc.nextLine();
        System.out.print("ID sala: ");
        int idSala = sc.nextInt(); sc.nextLine();

        Elev elev = gasestElevDupaId(idElev);
        Sala sala = gasestSalaDupaId(idSala);

        if (elev == null) {
            System.out.println("Elev negasit!");
            return;
        }
        if (sala == null) {
            System.out.println("Sala negasita!");
            return;
        }

        sala.adaugaElev(elev);
    }

    static void afiseazaTotiElevii() {
        if (totiElevii.isEmpty()) {
            System.out.println("Nu exista elevi!");
            return;
        }
        for (Elev e : totiElevii) {
            System.out.println(e);

        }
    }

    static void afiseazaToateSalile() {
        if (toateSalile.isEmpty()) {
            System.out.println("Nu exista sali!");
            return;
        }
        for (Sala s : toateSalile) {
            System.out.println(s);

        }
    }

    static void afiseazaEleviiUneiSali() {
        System.out.print("ID sala: ");
        int idSala = sc.nextInt(); sc.nextLine();
        Sala sala = gasestSalaDupaId(idSala);
        if (sala == null) {
            System.out.println("Sala negasita!");
            return;
        }
        System.out.println(sala);
    }

    static void cautaElevDupaId() {
        System.out.print("ID elev: ");
        int id = sc.nextInt(); sc.nextLine();
        Elev elev = gasestElevDupaId(id);
        if (elev == null) {
            System.out.println("Elev negasit!");
        } else {
            System.out.println(elev);
        }
    }

    static void mutaElev() {
        System.out.print("ID elev: ");
        int idElev = sc.nextInt(); sc.nextLine();
        System.out.print("ID sala sursa: ");
        int idSursa = sc.nextInt(); sc.nextLine();
        System.out.print("ID sala destinatie: ");
        int idDest = sc.nextInt(); sc.nextLine();

        Elev elev = gasestElevDupaId(idElev);
        Sala sursa = gasestSalaDupaId(idSursa);
        Sala dest = gasestSalaDupaId(idDest);

        if (elev == null || sursa == null || dest == null) {
            System.out.println("Elev sau sala negasita!");
            return;
        }

        if (sursa.cautaElevDupaId(idElev) == null) {
            System.out.println("Elevul nu se afla in sala!");
            return;
        }

        sursa.stergeElev(idElev);
        dest.adaugaElev(elev);
        System.out.println("Elev mutat!");
    }

    static void stergeElev() {
        System.out.print("ID elev de sters: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Sala s : toateSalile) {
            s.stergeElev(id);
        }

        Elev gasit = gasestElevDupaId(id);
        if (gasit != null) {
            totiElevii.remove(gasit);
            System.out.println("Elev sters!");
        } else {
            System.out.println("Elev negasit!");
        }
    }

    static void stergeSala() {
        System.out.print("ID sala de sters: ");
        int id = sc.nextInt(); sc.nextLine();
        Sala sala = gasestSalaDupaId(id);
        if (sala != null) {
            toateSalile.remove(sala);
            System.out.println("Sala stearsa!");
        } else {
            System.out.println("Sala negasita!");
        }
    }

    static void filtreazaPromovati() {
        System.out.println("ELEVI PROMOVATI");
        boolean gasit = false;
        for (Elev e : totiElevii) {
            if (e.getMedie() >= 5) {
                System.out.println(e);

                gasit = true;
            }
        }
        if (!gasit) System.out.println("Niciun elev promovat.");
    }

    static void filtreazaNepromovati() {
        System.out.println(" ELEVI NEPROMOVATI ");
        boolean gasit = false;
        for (Elev e : totiElevii) {
            if (e.getMedie() < 5) {
                System.out.println(e);

                gasit = true;
            }
        }
        if (!gasit) System.out.println("Toti elevii sunt promovati.");
    }

    static void filtreazaDupaMedia() {
        System.out.print("Medie minima: ");
        double min = sc.nextDouble();
        System.out.print("Medie maxima: ");
        double max = sc.nextDouble();
        sc.nextLine();

        System.out.println(" ELEVI CU MEDIA INTRE " + min + " SI " + max );
        boolean gasit = false;
        for (Elev e : totiElevii) {
            if (e.getMedie() >= min && e.getMedie() <= max) {
                System.out.println(e);

                gasit = true;
            }
        }
        if (!gasit) System.out.println("Niciun elev in acest interval.");
    }

    static void filtreazaDupaVarsta() {
        System.out.print("Varsta minima: ");
        int min = sc.nextInt();
        System.out.print("Varsta maxima: ");
        int max = sc.nextInt();
        sc.nextLine();

        System.out.println(" ELEVI CU VARSTA INTRE " + min + " SI " + max);
        boolean gasit = false;
        for (Elev e : totiElevii) {
            if (e.getVarsta() >= min && e.getVarsta() <= max) {
                System.out.println(e);

                gasit = true;
            }
        }
        if (!gasit) System.out.println("interval de varsta negasit ");
    }

    static void cautaDupaNume() {
        System.out.print("Nume cautat: ");
        String nume = sc.nextLine().toLowerCase();

        System.out.println(" REZULTATE CAUTARE ");
        boolean gasit = false;
        for (Elev e : totiElevii) {
            if (e.getNume().toLowerCase().contains(nume)) {
                System.out.println(e);

                gasit = true;
            }
        }
        if (!gasit) System.out.println("Niciun elev gasit cu numele: " + nume);
    }

    static void afiseazaStatistici() {
        if (totiElevii.isEmpty()) {
            System.out.println("Nu exista elevi!");
            return;
        }

        double suma = 0;
        double max = totiElevii.get(0).getMedie();
        double min = totiElevii.get(0).getMedie();
        int promovati = 0;

        for (Elev e : totiElevii) {
            suma += e.getMedie();
            if (e.getMedie() > max) max = e.getMedie();
            if (e.getMedie() < min) min = e.getMedie();
            if (e.getMedie() >= 5) promovati++;
        }

        System.out.println("=== STATISTICI ");
        System.out.println("Total elevi: " + totiElevii.size());
        System.out.printf("Media generala: %.2f%n", suma / totiElevii.size());
        System.out.println("Nota maxima: " + max);
        System.out.println("Nota minima: " + min);
        System.out.println("Elevi promovati: " + promovati);
        System.out.println("Elevi nepromovati: " + (totiElevii.size() - promovati));
        System.out.println("Total sali: " + toateSalile.size());
    }

    static void sorteazaElevi() {
        System.out.println("Sorteaza dupa:");
        System.out.println("1. Nume (alfabetic)");
        System.out.println("2. Medie (descrescator)");
        System.out.println("3. Varsta (crescator)");
        System.out.print("Optiune: ");
        int opt = sc.nextInt(); sc.nextLine();

        List<Elev> sortati = new ArrayList<>(totiElevii);

        if (opt == 1) {
            for (int i = 0; i < sortati.size() - 1; i++) {
                for (int j = i + 1; j < sortati.size(); j++) {
                    if (sortati.get(i).getNume().compareTo(sortati.get(j).getNume()) > 0) {
                        Elev temp = sortati.get(i);
                        sortati.set(i, sortati.get(j));
                        sortati.set(j, temp);
                    }
                }
            }
        } else if (opt == 2) {
            for (int i = 0; i < sortati.size() - 1; i++) {
                for (int j = i + 1; j < sortati.size(); j++) {
                    if (sortati.get(i).getMedie() < sortati.get(j).getMedie()) {
                        Elev temp = sortati.get(i);
                        sortati.set(i, sortati.get(j));
                        sortati.set(j, temp);
                    }
                }
            }
        } else if (opt == 3) {
            for (int i = 0; i < sortati.size() - 1; i++) {
                for (int j = i + 1; j < sortati.size(); j++) {
                    if (sortati.get(i).getVarsta() > sortati.get(j).getVarsta()) {
                        Elev temp = sortati.get(i);
                        sortati.set(i, sortati.get(j));
                        sortati.set(j, temp);
                    }
                }
            }
        } else {
            System.out.println("Optiune invalida!");
            return;
        }

        System.out.println("=== ELEVI SORTATI ===");
        for (Elev e : sortati) {
            System.out.println(e);

        }
    }

    static Elev gasestElevDupaId(int id) {
        for (Elev e : totiElevii) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    static Sala gasestSalaDupaId(int id) {
        for (Sala s : toateSalile) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}