package org.example.repositoryimple;



import org.example.model.Ordinateur;
import org.example.repository.OrdinateurRepository;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdinateurRepositoryImpl implements OrdinateurRepository {

    private Ordinateur map(ResultSet rs) throws SQLException {
        return new Ordinateur(
                rs.getInt("id"),
                rs.getString("mac_address"),
                rs.getString("marque"),
                rs.getString("frequence_processeur"),
                rs.getBoolean("vole")
        );
    }

    public Ordinateur findById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordinateur WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public Ordinateur findByMacAddress(String macAddress) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordinateur WHERE mac_address = ?");
            stmt.setString(1, macAddress);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public List<Ordinateur> findAll() {
        List<Ordinateur> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ordinateur")) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean save(Ordinateur ordinateur) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO ordinateur (mac_address, marque, frequence_processeur, vole) VALUES (?, ?, ?, ?)");
            stmt.setString(1, ordinateur.getMacAddress());
            stmt.setString(2, ordinateur.getMarque());
            stmt.setString(3, ordinateur.getFrequenceProcesseur());
            stmt.setBoolean(4, ordinateur.isVole());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean update(Ordinateur ordinateur) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE ordinateur SET marque = ?, frequence_processeur = ?, vole = ? WHERE mac_address = ?");
            stmt.setString(1, ordinateur.getMarque());
            stmt.setString(2, ordinateur.getFrequenceProcesseur());
            stmt.setBoolean(3, ordinateur.isVole());
            stmt.setString(4, ordinateur.getMacAddress());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean delete(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM ordinateur WHERE id = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}