import java.io.*;
import java.net.Socket;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Client {

    public static void main(String[] args) throws IOException {
        // need host and port, we want to connect to the ServerSocket at port 7777
        try (Socket socket = new Socket("localhost", 7777)) {
            try (OutputStream outputStream = socket.getOutputStream()){
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
                    BufferedImage img = ImageIO.read(new File("monalisa.jpeg"));
                    
                    Arte arte = new Arte("Monalisa", "Leonardo da Vinci", img);
            
                    objectOutputStream.writeObject(arte);
                }
            }
        }
    }
}