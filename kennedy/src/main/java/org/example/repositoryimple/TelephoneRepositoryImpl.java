package org.example.repositoryimple;



import org.example.model.Telephone;
import org.example.repository.TelephoneRepository;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelephoneRepositoryImpl implements TelephoneRepository {

    private Telephone map(ResultSet rs) throws SQLException {
        return new Telephone(
                rs.getInt("id"),
                rs.getString("imei"),
                rs.getString("marque"),
                rs.getString("description"),
                rs.getBoolean("vole")
        );
    }

    public Telephone findById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM telephone WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public Telephone findByImei(String imei) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM telephone WHERE imei = ?");
            stmt.setString(1, imei);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public List<Telephone> findAll() {
        List<Telephone> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM telephone")) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean save(Telephone tel) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO telephone (imei, marque, description, vole) VALUES (?, ?, ?, ?)");
            stmt.setString(1, tel.getImei());
            stmt.setString(2, tel.getMarque());
            stmt.setString(3, tel.getDescription());
            stmt.setBoolean(4, tel.isVole());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean update(Telephone tel) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE telephone SET marque = ?, description = ?, vole = ? WHERE imei = ?");
            stmt.setString(1, tel.getMarque());
            stmt.setString(2, tel.getDescription());
            stmt.setBoolean(3, tel.isVole());
            stmt.setString(4, tel.getImei());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean delete(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM telephone WHERE id = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}