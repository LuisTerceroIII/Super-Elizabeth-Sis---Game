package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Princesa {

    private double x;
    private double y;
    private Image image;
    private Poder poder;
    private int vidas;
    private boolean golpeada;
    private long tiempoDelGolpe;
    private boolean saltando;
    private final int SUELO = 490;
    private Rectangle bordes; // Rectangulo para verificar colisiones

    public Princesa() {
        this.x = 200;
        this.y = SUELO;
        this.image = Herramientas.cargarImagen("./Peach.gif");
        this.vidas = 3;
        this.golpeada = false;
        this.saltando = false;
        this.bordes = new Rectangle((int) x, (int) y, 50, 60);
    }

    /*Se verifica todo lo que deba actualizarse en tick() : movimientos, ataque y vidas */
    public void dibujarse(Entorno entorno) {
        if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
            setSaltando(true);
            entorno.dibujarImagen(image, x, y, 0, 0.2);
            bordes.setBounds((int) x, (int) y, 50, 60);
        } else {
            entorno.dibujarImagen(image, x, y, 0, 0.2);
            bordes.setBounds((int) x, (int) y, 50, 60);
        }
        if (this.y == SUELO) {
            if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
                if (this.getX() < 300) {
                    this.setX(this.x + 2.5);
                }
                entorno.dibujarImagen(image, x, y, 0, 0.2);
                bordes.setBounds((int) this.getX(), (int) y, 50, 60);
            } else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
                if (this.getX() > 50) {
                    this.setX(this.x - 2.5);
                }
                entorno.dibujarImagen(image, x, y, 0, 0.2);
                bordes.setBounds((int) x, (int) y, 50, 60);
            } else if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
                entorno.dibujarImagen(image, x, y, 0, 0.2);
                this.poder = new Poder(this.x + 50, this.y);
            }
        }
        this.controladorVidas();
        controladorSalto();
    }

    /* Se utiliza para obtener la instancia poder y usarla desde la clase Juego */
    public Poder atacar() {
        return poder;
    }

    /* Controlador de estado "golpeada".
     Cambia el estado de golpeada a no golpeada pasado 2.5 seg, tras ese tiempo puede ser golpeada otra vez */
    public void controladorVidas() {
        if (System.currentTimeMillis() - this.getTiempoDelGolpe() > 2500 && this.isGolpeada()) {
            this.setGolpeada(false);
        }
    }
    /* Controlador del salto */
    public void controladorSalto() {
        if (this.isSaltando()) {
            saltar();
        } else if (!isSaltando()) {
            caer();
        }
    }
    /* Metodo que se ejecuta cuando saltando = true*/
    public void saltar() {
        if (this.y > 200) {
            this.y = this.y - 5.5;
            if (this.x < 300) {
                this.x = this.x + 1.5;
            }

        }
        if (this.y <= 200) {
            this.setSaltando(false);
        }
    }
    /* Metodo que se ejecuta cuando saltando = false*/
    public void caer() {
        if (this.y < SUELO) {
            this.y = this.y + 3.5;
            if (this.x < 300) {
                this.x = this.x + 1.5;
            }
        }
        if (this.y >= SUELO) {
            this.y = SUELO;
        }

    }

    /* Se verifica si la instancia colisiona con otra */
    public boolean colision(Rectangle objeto) {
        return objeto.intersects(getBordes());
    }

    /* Se obtiene el rectángulo de colisión de la instancia */
    public Rectangle getBordes() {
        return this.bordes;
    }

    /* Se controla restar una vida por cada vez que se cambie el estado de golpeada a true*/
    public void setGolpeada(boolean golpeada) {
        this.golpeada = golpeada;
        if (golpeada) {
            this.vidas -= 1;
        }
    }

    public boolean isGolpeada() {
        return golpeada;
    }

    public long getTiempoDelGolpe() {
        return tiempoDelGolpe;
    }

    public void setTiempoDelGolpe(long tiempoDelGolpe) {
        this.tiempoDelGolpe = tiempoDelGolpe;
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


    public boolean isSaltando() {
        return saltando;
    }

    public void setSaltando(boolean saltando) {
        this.saltando = saltando;

    }
}
