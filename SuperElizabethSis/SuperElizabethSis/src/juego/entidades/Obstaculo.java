package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Obstaculo {
    private double x;
    private double y;
    private Image image;
    private double moveSpeed = 0.5;

    public Obstaculo(double x) { //Solo recibe como parametro x, para evitar que lo desacomoden del piso.
        this.x = x;
        this.y = 500;
        this.image = Herramientas.cargarImagen("green-pipe.png");
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(this.image,x,y,0,0.2);
    }

    public void moverIzq() {
        this.x = this.x - moveSpeed;
    }
}
