package baza_date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiuneNeon {
    private static final String URL = "link";

    private static final String UTILIZATOR = "nenondb";
    private static final String PAROLA = "nenondb_owner";

    public static Connection iaConexiune() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver-ul JDBC PostgreSQL nu a fost gasit in classpath!", e);
        }
        return DriverManager.getConnection(URL, UTILIZATOR, PAROLA);
    }
}
