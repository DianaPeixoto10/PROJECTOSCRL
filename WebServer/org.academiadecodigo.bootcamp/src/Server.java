import com.sun.net.httpserver.Headers;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.jvm.hotspot.memory.HeapBlock;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/**
 * Created by codecadet on 19/06/2018.
 */
public class Server {

    FileInputStream fileInputStream = null;
    FileInputStream index;
    BufferedReader in;
    Socket socket;
    ServerSocket serverSocket;
    DataOutputStream out;
    int port = 5000;
    int readFile;
    byte[] bytes;
    int numbers;


    public void start() {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println(serverSocket.getLocalPort());


            while (true) {
                socket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(in.readLine());

                headerGenerator();
                readFile("rsc/index.html");

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void headerGenerator() {

        String statusCode = statusCode();
        String fileType = fileType();
        int size = size();

        try {
            out = new DataOutputStream(socket.getOutputStream());
            out.writeBytes("HTTP/1.0" + statusCode
                    + "Document Follows" + "\r\n"
                    + "Content-Type: " + fileType
                    + "; charset=UTF-8\r\n" + "Content-Length: "
                    + size + "\r\n\r\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readFile(String file) {
        try {
            fileInputStream = new FileInputStream(file);
            while (numbers != -1) {
                readFile = fileInputStream.read();
                bytes = new byte[1024];
                numbers = fileInputStream.read(bytes);
                out.write(numbers);
            }

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String statusCode() {
        return "hi";
    }

    public String fileType() {
        return "bye";
    }

    public int size() {
        return 0;
    }

}



