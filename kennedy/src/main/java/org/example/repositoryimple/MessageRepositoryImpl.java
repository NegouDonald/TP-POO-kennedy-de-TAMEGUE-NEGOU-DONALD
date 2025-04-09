package org.example.repositoryimple;



import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageRepositoryImpl implements MessageRepository {

    private Message map(ResultSet rs) throws SQLException {
        return new Message(
                rs.getInt("id"),
                rs.getString("content"),
                rs.getInt("sender_id"),
                rs.getInt("receiver_id"),
                rs.getTimestamp("date_envoi").toLocalDateTime()
        );
    }

    public Message findById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM message WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public List<Message> findAll() {
        List<Message> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM message")) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Message> findBySenderId(int senderId) {
        List<Message> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM message WHERE sender_id = ?");
            stmt.setInt(1, senderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Message> findByReceiverId(int receiverId) {
        List<Message> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM message WHERE receiver_id = ?");
            stmt.setInt(1, receiverId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean save(Message message) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO message (content, sender_id, receiver_id, date_envoi) VALUES (?, ?, ?, ?)");
            stmt.setString(1, message.getContent());
            stmt.setInt(2, message.getSenderId());
            stmt.setInt(3, message.getReceiverId());
            stmt.setTimestamp(4, Timestamp.valueOf(message.getDateEnvoi()));
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean delete(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM message WHERE id = ?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}