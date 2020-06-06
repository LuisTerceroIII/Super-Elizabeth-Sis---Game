package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Princesa {

    private double x;
    private double y;
    Image image;
    private boolean atancando = false;
    private Poder poder;


    public Princesa() {
        this.x = 200;
        this.y = 490;
        this.image = Herramientas.cargarImagen("./Peach.gif");
    }

    public void dibujarse(Entorno entorno) {

        if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
            entorno.dibujarImagen(image, x, y - 200, 0, 0.2);
        } else if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
            entorno.dibujarImagen(image, x + 100, y, 0, 0.2);
        } else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
            entorno.dibujarImagen(image, x - 100, y, 0, 0.2);
        } else if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
            entorno.dibujarImagen(image, x, y, 0, 0.2);
            this.poder = new Poder(this.x + 50, this.y);
        } else {
            entorno.dibujarImagen(image, x, y, 0, 0.2);
        }
    }
    public Poder atacar() {
        return poder;
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
}
