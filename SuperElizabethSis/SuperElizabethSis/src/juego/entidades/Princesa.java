package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Princesa {

    private double x;
    private double y;
    private Image image;
    private Poder poder;
    private final Image vida;
    private int vidas;
    private boolean golpeada;
    private long tiempoDelGolpe;
    private  Rectangle bordes;

    public Princesa() {
        this.x = 200;
        this.y = 490;
        this.image = Herramientas.cargarImagen("./Peach.gif");
        this.vida = Herramientas.cargarImagen("vida.png");
        this.vidas = 3;
        this.golpeada = false;
        this.bordes = new Rectangle((int)x,(int)y,50,60);
    }

    public void dibujarse(Entorno entorno) {

        if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
            entorno.dibujarImagen(image, x, y - 200, 0, 0.2);
            bordes.setBounds((int) x,(int) y-200,50,60);

        } else if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
            entorno.dibujarImagen(image, x + 100, y, 0, 0.2);
            bordes.setBounds((int) x + 100,(int) y,50,60);

        } else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
            entorno.dibujarImagen(image, x - 100, y, 0, 0.2);
            bordes.setBounds((int) x-100,(int) y,50,60);

        } else if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
            entorno.dibujarImagen(image, x, y, 0, 0.2);
            this.poder = new Poder(this.x + 50, this.y);

        } else {
            entorno.dibujarImagen(image, x, y, 0, 0.2);
            bordes.setBounds((int) x,(int) y,50,60);
        }
        this.controladorVidas(entorno);
    }
    public Poder atacar() {
        return poder;
    }

    public void controladorVidas(Entorno entorno) {

        entorno.dibujarImagen(vida, 200, 50, 0, 0.3);
        entorno.cambiarFont("Arial", 30, Color.BLACK);
        entorno.escribirTexto("X", 250, 60);
        entorno.cambiarFont("Arial", 50, Color.BLACK);
        entorno.escribirTexto(this.getVidas() + "", 275, 65);

        if(System.currentTimeMillis() - this.getTiempoDelGolpe()   > 2500 && this.isGolpeada()){
            this.setGolpeada(false);
        }
    }

    public boolean colision(Rectangle objeto) {
        return objeto.intersects(getBordes());
    }

    public Rectangle getBordes() {
        return this.bordes;
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

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean isGolpeada() {
        return golpeada;
    }

    public void setGolpeada(boolean golpeada) {
        this.golpeada = golpeada;
        if(golpeada) {
            this.vidas -= 1;
        }
    }

    public long getTiempoDelGolpe() {
        return tiempoDelGolpe;
    }

    public void setTiempoDelGolpe(long tiempoDelGolpe) {
        this.tiempoDelGolpe = tiempoDelGolpe;
    }
}
