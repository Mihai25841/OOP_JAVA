import Classes.Read;
import Classes.Write;
import Classes.ReadWrite;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Read r1 = new Read("test.txt");
        r1.citeste();

        Read r2 = new Read("date.txt");
        r2.citeste();

        if (r1.equals(r2)) {
            System.out.println("egale.");
        } else {
            System.out.println("nu sunt egale.");
        }

        Write w = new Write();
        w.scriu_IWriter();

        ReadWrite rw = new ReadWrite("date.txt");
        rw.scrie("test scris");

        List<String> lista = Arrays.asList("Ana", "Maria", "Ion");
        rw.scrie(lista);
        rw.citeste();

        System.out.println("scris lista ");
    }
}
