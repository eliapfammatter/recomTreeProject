package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final CommandProcessor commandProcessor;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        this.commandProcessor = new CommandProcessor();
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            out.println("Welcome to RecomTree! Type HELP for commands.");

            while ((inputLine = in.readLine()) != null) {
                String response = commandProcessor.process(inputLine);
                out.println(response.replace("\n", "\\n"));

                if (inputLine.trim().equalsIgnoreCase("QUIT")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Client handler error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}