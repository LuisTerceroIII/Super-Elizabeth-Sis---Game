package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Princesa {

    private double x;
    private double y;
    private double angulo;
    private double escala;
    private Image image;
    private Poder poder;
    private int vidas;
    private boolean golpeada;
    private long tiempoDelGolpe;
    private boolean saltando;
    private final int SUELO = 490;
    private Rectangle bordes; // Rectangulo para verificar colisiones



    public Princesa(double x, double y, double angulo, double escala, Image image) {
        setX(x);
        setY(y);
        setAngulo(angulo);
        setEscala(escala);
        setImage(image);
        this.poder = new Poder(-10, -20,0,0.1,5.9, Herramientas.cargarImagen("juego/recursos/fireball.gif"));
        setVidas(3);
        setGolpeada(false);
        setTiempoDelGolpe(tiempoDelGolpe);
        setSaltando(false);
        this.bordes = new Rectangle((int) x, (int) y, 50, 60);
    }

    /*Se verifica todo lo que deba actualizarse en tick() : movimientos, ataque y vidas */
    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(image, x, y, angulo, escala);
        bordes.setBounds((int) x, (int) y, 50, 60);
        if (getY() == SUELO) {
            if (entorno.sePresiono(entorno.TECLA_ARRIBA) && getY() == SUELO) {
                setSaltando(true);
                Herramientas.play("juego/recursos/jump.wav");

            } else if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
                if (getX() < 300) {
                    setX(getX() + 2.5);
                }
                entorno.dibujarImagen(image, x, y, angulo, escala);
                bordes.setBounds((int) getX(), (int) getY(), 50, 60);
            } else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
                if (getX() > 55) {
                    setX(getX() - 2.5);
                }
                entorno.dibujarImagen(image, x, y, angulo, escala);
                bordes.setBounds((int) x, (int) y, 50, 60);

            } else if (entorno.sePresiono(entorno.TECLA_ESPACIO) && (this.poder.getX() > 850 || this.poder.getY() == -20)) {
                entorno.dibujarImagen(image, x, y, angulo, escala);
                this.poder.setX(getX() + 50);
                this.poder.setY(getY());
                Herramientas.play("juego/recursos/fireball.wav");

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
        if (getY() > 200) {
           setY(getY() - 5.5);
            if (getX() < 300) {
                setX(getX() + 1.5);
            }
        }
        if (getY() <= 200) {
            setSaltando(false);
        }

    }

    /* Metodo que se ejecuta cuando saltando = false*/
    public void caer() {
        if (getY() < SUELO) {
            setY(getY() + 5.5);
            if (getX() < 300) {
                setX(getX() + 1.5);
            }
        }
        if (this.getY() >= SUELO) {
            setY(SUELO);
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
            setVidas(getVidas() - 1);
            Herramientas.play("juego/recursos/stomp_koopa_kid.wav");
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
        if(x >= 40 && x <= 310) {
            this.x = x;
        } else {
            throw new RuntimeException("El valor de X debe estar entre 40 y 310");
        }

    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(y >= 190 && y <= 490) {
            this.y = y;
        } else {
            throw new RuntimeException("El valor de Y debe estar entre 190 y 490");
        }
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
        if(vidas >= 0 && vidas < 4) {
            this.vidas = vidas;
        } else {
            throw new RuntimeException("La cantidad de vidas permitas son 0 a 3");
        }

    }


    public boolean isSaltando() {
        return saltando;
    }

    public void setSaltando(boolean saltando) {
        this.saltando = saltando;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getEscala() {
        return escala;
    }

    public void setEscala(double escala) {
        this.escala = escala;
    }
}
