import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Arte implements Serializable{
    private final String nombre;
    private final String autor;
    transient private BufferedImage obra; 

    public Arte(String nombre, String autor, BufferedImage obra) {
        this.nombre = nombre;
        this.autor = autor;
        this.obra = obra;
    }

    public String getNombre() { return this.nombre;}
    public String getAutor() { return this.autor;}
    public BufferedImage getObra() { return this.obra;}

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(this.obra, "png", out); // png is lossless
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.obra = ImageIO.read(in);
    }
}