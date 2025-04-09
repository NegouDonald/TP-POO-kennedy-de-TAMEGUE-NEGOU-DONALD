package org.example.repository;



import org.example.model.Message;
import java.util.List;

public interface MessageRepository {
    Message findById(int id);
    List<Message> findAll();
    List<Message> findBySenderId(int senderId);
    List<Message> findByReceiverId(int receiverId);
    boolean save(Message message);
    boolean delete(int id);
}