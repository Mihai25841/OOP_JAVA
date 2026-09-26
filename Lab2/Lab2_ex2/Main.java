//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        u1.email = "andrei@gmail.com";
        u1.pin = 1234;
        u1.bal = 500;
        u1.age = 23;
        System.out.println("email: " + u1.email);
        System.out.println("pin: " + u1.pin);
        System.out.println("bal: " + u1.bal);
        System.out.println("age: " + u1.age);

        System.out.println("bal: " + u1.bal);
        depozit(u1, 700);
        System.out.println("bal2: " + u1.bal);

        Random rand = new Random();
        int n = rand.nextInt(1001);
        for (int i = 0; i < n; i++) {
            int suma = rand.nextInt(101)
            double optiune1 = depozit(suma);
            double optiune2 = retragere(suma);

            int sansa = rand.nextInt(2);
            if (sansa == 1) {
                u1.bal = u1.bal + optiune1;
            }
            else{
                u1.bal = u1.bal + optiune2;
        }
    }
public static void depozit(User x, double sold){
    x.bal= x.bal + sold;
        }

}
public static void retragere(User x, double sold) {
    x.bal = x.bal - sold;
}
}