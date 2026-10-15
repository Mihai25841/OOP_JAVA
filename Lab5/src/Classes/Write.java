        package Classes;

import interfaces.IWriter;
import java.io.FileWriter;

public class Write implements IWriter {

    public void scriu_IWriter() {
        try {
            FileWriter fw = new FileWriter("date.txt");

            fw.write("Mihai\n");
            fw.write("An 2\n");
            fw.write("Info\n");

            fw.close();

            System.out.println("Scris in fisier");

        } catch (Exception e) {
            System.out.println("Err fisier");
        }
    }
}
