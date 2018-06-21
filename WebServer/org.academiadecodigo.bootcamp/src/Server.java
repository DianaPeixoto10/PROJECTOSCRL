import javax.lang.model.element.NestingKind;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codecadet on 19/06/2018.
 */
public class Server {

    FileInputStream fileInputStream = null;
    File file;
    BufferedReader in;
    Socket socket;
    ServerSocket serverSocket;
    DataOutputStream out;
    int port = 5000;
    byte[] bytes;
    int numbers;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println(serverSocket.getLocalPort());


            while (true) {
                socket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String request = in.readLine();
                System.out.println(request);

                String[] requestSplitted = request.split(" ");


                if (requestSplitted[1].equals("/")) {
                    file = new File("org.academiadecodigo.bootcamp/rsc/index.html");
                } else {
                    file = new File("org.academiadecodigo.bootcamp/rsc/" + requestSplitted[1]);
                }

                headerGenerator(file);
                readFile(file);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void headerGenerator(File file) {

        String statusCode = statusCode();

        try {
            out = new DataOutputStream(socket.getOutputStream());
            if (file.getName().endsWith(".jpg")) {
                out.writeBytes("HTTP/1.0" + statusCode
                        + "Document follows" + "\r\n"
                        + "Content-Type: image/jpg"
                        + "; charset=UTF-8\r\n" +
                        "Content-Length: " + file.length()
                        + "\r\n\r\n");

            } else if (file.getName().endsWith(".html")) {
                out.writeBytes("HTTP/1.0" + statusCode
                        + "Document Follows" + "\r\n"
                        + "Content-Type: text/html;"
                        + "charset=UTF-8\r\n"
                        + "Content-Length: " + file.length()
                        + "\r\n\r\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readFile(File file) {
        try {
            fileInputStream = new FileInputStream(file);
            bytes = new byte[1024];

            while (numbers != -1) {
                numbers = fileInputStream.read(bytes);
                out.write(bytes);
            }

        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String statusCode() {
        return "200";
    }

}



