package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 45000)) {

            System.out.println("Connected to server.");

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(client.getOutputStream(), true);
            Scanner consoleInput = new Scanner(System.in);

            String welcomeMessage = serverInput.readLine();
            if (welcomeMessage != null) {
                System.out.println("Server: " + welcomeMessage);
            }

            while (true) {
                System.out.print("Enter command: ");
                String command = consoleInput.nextLine();

                if (command.trim().isEmpty()) {
                    continue;
                }
                serverOutput.println(command);

                if (command.equalsIgnoreCase("QUIT")) {
                    System.out.println("Exiting client...");
                    break;
                }
                String response = serverInput.readLine();
                if (response == null) {
                    System.out.println("Server closed connection.");
                    break;
                }
                System.out.println(response.replace("\\n", "\n"));
            }

        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}