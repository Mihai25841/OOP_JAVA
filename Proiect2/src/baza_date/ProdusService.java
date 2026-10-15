package baza_date;

import clase.Produs;

public class ProdusService {
    private final ProdusRepository repo = new ProdusRepository();

    public void valideazaSiSalveaza(Produs p) throws Exception {
        if (p.getNume() == null || p.getNume().trim().isEmpty()) {
            throw new Exception("Numele produsului nu poate fi lasat gol!");
        }
        if (p.getPret() <= 0) {
            throw new Exception("Pretul trebuie sa fie un numar pozitiv!");
        }
        if (p.getStoc() < 0) {
            throw new Exception("Stocul nu poate fi negativ!");
        }
        repo.adauga(p);
    }

    public ProdusRepository getRepo() { return repo; }
}
