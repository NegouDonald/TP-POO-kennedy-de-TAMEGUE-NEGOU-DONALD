package org.example.api;

import com.sun.net.httpserver.HttpServer;
import org.example.handlers.*;
import org.example.repository.*;
import org.example.service.AuthService;
import org.example.service.AuthServiceImpl;
import org.example.service.VerificationService;
import org.example.service.VerificationServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;


public class ObjetController {
    private final VerificationService verificationService;
    private final AuthService authService;
    private final ObjetRepository objetRepository;
    private final MessageRepository messageRepository;

    public ObjetController() {
        this.objetRepository = new ObjetRepositoryImpl();
        UtilisateurRepository utilisateurRepository = new UtilisateurRepositoryImpl();
        this.messageRepository = new MessageRepositoryImpl();
        this.verificationService = new VerificationServiceImpl(objetRepository);
        this.authService = new AuthServiceImpl(utilisateurRepository);
    }

    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/objet/verifier", new VerifierHandler(verificationService));
        server.createContext("/objet/search", new SearchHandler(objetRepository));
        server.createContext("/auth/inscription", new InscriptionHandler(authService));
        server.createContext("/auth/connexion", new ConnexionHandler(authService));
        server.createContext("/objet/signaler", new SignalerHandler(objetRepository));
        server.createContext("/messages", new MessagesHandler(messageRepository));
        server.setExecutor(null);
        server.start();
        System.out.println("Serveur démarré sur le port 8080...");
    }
}