package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Poder {
    private double x;
    private double y;
    private double velocidad = 5.9;
    private final Image image;


    public Poder(double x, double y) {
        this.x = x;
        this.y = y;
        this.image = Herramientas.cargarImagen("juego/recursos/fireball.gif");
    }



    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,0,0.1);
    }

    public void avanzar(){
        if(this.x > 850) {
            this.y = -10000000;
        }
        this.x = this.x + velocidad;
    }

    /* Se verifica si la instancia colisiona con otra */
    public boolean colision(Rectangle objeto) {
        return objeto.intersects(getBordes());
    }

    /* Se obtiene el rectángulo de colisión de la instancia */
    public Rectangle getBordes() {
        return new Rectangle((int)x,(int)y,10,20);
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

}
