package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(45000);
            System.out.println("server is listening on port 45000");
            Socket exchangeSocket = server.accept();
            System.out.println("We got a connection");

            //inputstream
            InputStream inStream = exchangeSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inStream);
            BufferedReader buffin = new BufferedReader(reader);
            //outputstream
            OutputStream outStream = exchangeSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true);
            //read from socket
             String line = buffin.readLine();
             System.out.println(line);
            //write to socket
            Scanner sc = new Scanner(System.in);
            System.out.println("Your message :");
            String message = sc.nextLine();
            out.println(message);


            DataInputStream dis = new DataInputStream(exchangeSocket.getInputStream());
            FileOutputStream fos = new FileOutputStream("c://received//DataOutputStream.png");

            System.out.println("client connected");

            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File received");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
