package org.example.serviceimplement;



import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.example.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    public Message getMessageById(int id) {
        return repository.findById(id);
    }

    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    public List<Message> getMessagesBySenderId(int senderId) {
        return repository.findBySenderId(senderId);
    }

    public List<Message> getMessagesByReceiverId(int receiverId) {
        return repository.findByReceiverId(receiverId);
    }

    public boolean sendMessage(Message message) {
        return repository.save(message);
    }

    public boolean deleteMessage(int id) {
        return repository.delete(id);
    }
}