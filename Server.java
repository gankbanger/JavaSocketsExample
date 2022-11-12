import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class Server implements ObservadorDeArte{
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server srv = new Server();
        try (ServerSocket ss = new ServerSocket(7777)) {
            System.out.println("ServerSocket awaiting connections...");
            try (Socket socket = ss.accept()) {
                try (InputStream inputStream = socket.getInputStream()) {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
                        Arte arte = (Arte) objectInputStream.readObject();
                        srv.notificarNuevoArte(arte);
                    }
                }
            }
        }        
    }

    private JFrame frame = new JFrame("server");
    private JLabel autorLabel = new JLabel();
    private JLabel nombreLabel = new JLabel();
    private JLabel imageLabel = new JLabel();
    public Server() {
        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(autorLabel);
        frame.add(nombreLabel);
        frame.add(imageLabel);
    }
    @Override
    public void notificarNuevoArte(Arte arte) {
        autorLabel.setText(arte.getAutor());
        nombreLabel.setText(arte.getNombre());
        imageLabel.setIcon(new ImageIcon(arte.getObra()));
    }

}