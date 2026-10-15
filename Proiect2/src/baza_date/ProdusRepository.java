package baza_date;

import clase.*;
import mypackage.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProdusRepository {

    public void adauga(Produs p) throws SQLException {
        String sql = "INSERT INTO produse (nume, pret, stoc, tip, data_expirare, garantie_luni) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexiuneNeon.iaConexiune();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNume());
            stmt.setDouble(2, p.getPret());
            stmt.setInt(3, p.getStoc());

            if (p instanceof ProdusAlimentar) {
                stmt.setString(4, "ALIMENTAR");
                stmt.setDate(5, Date.valueOf(((ProdusAlimentar) p).getDataExpirare()));
                stmt.setNull(6, Types.INTEGER);
            } else {
                stmt.setString(4, "ELECTRONIC");
                stmt.setNull(5, Types.DATE);
                stmt.setInt(6, ((ProdusElectronic) p).getLuniGarantie());
            }
            stmt.executeUpdate();
        }
    }

    public List<Produs> gasesteToate() throws SQLException {
        List<Produs> lista = new ArrayList<>();
        String sql = "SELECT * FROM produse";

        try (Connection conn = ConexiuneNeon.iaConexiune();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                double pret = rs.getDouble("pret");
                int stoc = rs.getInt("stoc");
                String tip = rs.getString("tip");

                if ("ALIMENTAR".equals(tip)) {
                    lista.add(new ProdusAlimentar(id, nume, pret, stoc, rs.getDate("data_expirare").toLocalDate()));
                } else {
                    lista.add(new ProdusElectronic(id, nume, pret, stoc, rs.getInt("garantie_luni")));
                }
            }
        }
        return lista;
    }

    public void sterge(int id) throws SQLException {
        String sql = "DELETE FROM produse WHERE id = ?";
        try (Connection conn = ConexiuneNeon.iaConexiune();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
