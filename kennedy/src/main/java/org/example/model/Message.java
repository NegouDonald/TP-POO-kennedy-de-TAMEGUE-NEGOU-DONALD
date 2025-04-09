package org.example.model;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private String content;
    private int senderId; // ID de l'expéditeur
    private int receiverId; // ID du destinataire
    private LocalDateTime dateEnvoi;

    // Optionnel : si tu souhaites un constructeur sans ID
    public Message(String content, int senderId, int receiverId) {
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.dateEnvoi = LocalDateTime.now(); // Définit la date d'envoi à la création
    }
}
