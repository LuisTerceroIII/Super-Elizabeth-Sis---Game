package juego.entidades;

import entorno.Entorno;

import java.awt.*;
import java.util.Objects;

public class Obstaculo {
    private double x;
    private double y;
    private double angulo;
    private double escala;
    private Image image;
    private double velocidad = 1.5;



    public Obstaculo(double x,double y,double angulo, double escala,double velocidad, Image image) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.escala = escala;
        this.velocidad = velocidad;
        this.image = image;

    }

    public Obstaculo() {}

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
        entorno.dibujarImagen(this.image,x,y,angulo,escala);

    }

    public void moverIzq() {
        this.x = this.x - velocidad;
        if(this.x < -40 ){
           this.x = 1000 ;
        }
    }
    public Rectangle getBordes() {
        return new Rectangle((int)x,(int)y,60,80);
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Obstaculo obstaculo = (Obstaculo) object;
        return Double.compare(obstaculo.x, x) == 0 &&
                Double.compare(obstaculo.y, y) == 0 &&
                Double.compare(obstaculo.angulo, angulo) == 0 &&
                Double.compare(obstaculo.escala, escala) == 0 &&
                Double.compare(obstaculo.velocidad, velocidad) == 0 &&
                Objects.equals(image, obstaculo.image);
    }

}
