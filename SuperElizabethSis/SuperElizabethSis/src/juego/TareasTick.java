package juego;

import entorno.Entorno;
import entorno.Herramientas;
import juego.entidades.*;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.util.LinkedList;

public class TareasTick {

    /* Metodos auxiliares, creados para ordenar el metodo tick() : */

    /* Se que contabiliza puntaje. */
    protected static int puntos;


    protected static void controladorPuntaje(Entorno entorno, Princesa princesa, LinkedList<Enemigo> enemigos) {
       try {
           if (colisionPoder(entorno, princesa, enemigos)) {
               puntos += 5;
           }
       } catch (LineUnavailableException e) {
           e.getMessage();
       }
    }

    /* Dibuja vida y puntos en pantalla */

    protected static void dibujarBarraPrincesa(Entorno entorno, Princesa princesa) {
        entorno.dibujarImagen(Herramientas.cargarImagen("juego/recursos/vida.png"), 100, 100, 0, 0.7);
        entorno.dibujarImagen(Herramientas.cargarImagen("juego/recursos/sparkly.gif"), 100, 110, 0,0.4);
        entorno.cambiarFont("Arial", 30, Color.BLACK);
        entorno.dibujarImagen(Herramientas.cargarImagen("juego/recursos/ICON_puntos.png"), 215, 65, 0);
        entorno.escribirTexto(puntos + "", 153, 108);
        int x  = 170;
        for (int i = 1; i <= princesa.getVidas() ; i++) {
            entorno.dibujarImagen(Herramientas.cargarImagen("juego/recursos/ICONO_vidascorazones.png"), x, 130, 0, 0.7);
            x = x + 40;
        }
    }

    /* Se verifican las colisiones : Princesa/Obstaculo y Princesa/Enemigo */

    protected static void colisiones(Entorno entorno, Princesa princesa, LinkedList<Obstaculo> obstaculos, LinkedList<Enemigo> enemigos) {
        for (Obstaculo obstaculo : obstaculos) {
            if (princesa.colision(obstaculo.getBordes()) && !princesa.isGolpeada()) {
                princesa.setGolpeada(true);
                princesa.setTiempoDelGolpe(System.currentTimeMillis());
            }
        }
        for (Enemigo enemigo : enemigos) {
            if (princesa.colision(enemigo.getBordes()) && !princesa.isGolpeada()) {
                princesa.setGolpeada(true);
                princesa.setTiempoDelGolpe(System.currentTimeMillis());
            }
        }
    }
    /* Se verifica colisión : Poder/Enemigo */

    protected static boolean colisionPoder(Entorno entorno, Princesa princesa, LinkedList<Enemigo> enemigos) throws LineUnavailableException {
        boolean colisiona = false;
        Poder poder = princesa.atacar();

        if (poder != null) {
            poder.dibujar(entorno);
            poder.avanzar();
        }
        if (enemigos.size() != 0 && poder != null) {
            for (int i = 0; i < enemigos.size(); i++) {
                if (poder.colision(enemigos.get(i).getBordes())) {
                    Herramientas.play("juego/recursos/goomba-kick.wav");
                    poder.setY(-10000000);
                    enemigos.remove(i);
                    colisiona = true;
                }
            }
        }
        return colisiona;
    }

    /* Genera entre 3 y 5 Enemigos */

    protected static void generarEnemigos(LinkedList<Enemigo> enemigos) {
        if (enemigos.size() <= 0) {
            int cantidadDeEnemigos = (int) Math.floor(Math.random() * (5 - 3 + 1) + 3);
            int x = 1000;
            for (int i = 0; i < cantidadDeEnemigos; i++) {
                Enemigo soldado = new Enemigo(x, 490, 0, 0.5, 1.0, Herramientas.cargarImagen("juego/recursos/enemy.gif"));
                x = x + (int) Math.floor(Math.random() * (400 - 200 + 1) + 200);
                enemigos.add(soldado);
            }
        }
    }

    /* Dibuja a princesa */

    protected static void princesa(Entorno entorno, Princesa princesa) {
        princesa.dibujarse(entorno);
    }

    /* Dibuja a los obstáculos */
    protected static void obstaculos(Entorno entorno, LinkedList<Obstaculo> obstaculos) {
        for (Obstaculo obstaculo : obstaculos) {
            obstaculo.dibujarse(entorno);
            obstaculo.moverIzq();
        }
    }

    /* Dibuja a los enemigos */

    protected static void enemigos(Entorno entorno, LinkedList<Enemigo> enemigos) {
        for (Enemigo enemigo : enemigos) {
            enemigo.dibujarse(entorno);
            enemigo.moverIzq();
        }
    }

    /* Dibuja el pantalla GameOver */
    protected static void gameOver(Entorno entorno, LinkedList<Fondo> fondos,Clip gameOverSound) {

        double y = fondos.get(1).getY();
        if(fondos.get(1).getY() < 300) {
            fondos.get(1).setY(y + 1.5);
        }
        fondos.get(1).dibujar(entorno);
        entorno.cambiarFont("Arial", 30, Color.WHITE);
        entorno.escribirTexto("Puntos : " + puntos + "", 20, 30);

        gameOverSound.start();

    }


    /* Dibuja el fondo */
    protected static void fondo(Entorno entorno, LinkedList<Fondo> fondos, int nivel) {
        fondos.get(nivel).dibujar(entorno);
    }
}
