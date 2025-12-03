import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException {

        try {
            Socket client = new Socket("127.0.0.1", 45000);

            System.out.println("We got in");

            //inputstream
            InputStream inStream = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(inStream);
            BufferedReader buffin = new BufferedReader(reader);
            //outputstream
            OutputStream outStream = client.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true);

            //write to socket
            Scanner sc = new Scanner(System.in);
            System.out.println("Your message :");
            String message = sc.nextLine();
            out.println(message);
            //read from socket
            String line = buffin.readLine();
            System.out.println(line);

            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            FileInputStream fis = new FileInputStream("c://toSend//googleplayfeature2.png");

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}