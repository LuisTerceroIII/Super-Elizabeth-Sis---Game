package juego;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import juego.entidades.*;

import javax.sound.sampled.Clip;
import java.util.LinkedList;

public class Juego extends InterfaceJuego {

    protected final Entorno entorno;
    protected Princesa princesa;
    protected LinkedList<Fondo> fondos = new LinkedList<>();
    protected LinkedList<Obstaculo> obstaculos = new LinkedList<>();
    protected LinkedList<Enemigo> enemigos = new LinkedList<>();
    protected int nivel;
    protected boolean gameOver;
    Clip gameOverSound;

    Juego() {
        // Inicializa el objeto entorno

        this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 5 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        this.nivel = 0;

        Fondo fondoMario = new Fondo(Herramientas.cargarImagen("juego/recursos/background.png"), 600, 300, 0.3);
        Fondo gameOver = new Fondo(Herramientas.cargarImagen("juego/recursos/PAGE_gameover.jpg"), 400, 0, 0);

        princesa = new Princesa();

        Obstaculo tuberia = new Obstaculo(1000, 500, 0, 0.2, 0.9, Herramientas.cargarImagen("juego/recursos/green-pipe.png"));
        Obstaculo tuberia1 = new Obstaculo(1350, 500, 0, 0.2, 0.9, Herramientas.cargarImagen("juego/recursos/green-pipe.png"));
        Obstaculo tuberia2 = new Obstaculo(1700, 500, 0, 0.2, 0.9, Herramientas.cargarImagen("juego/recursos/green-pipe.png"));

        Enemigo enemigo = new Enemigo(1200, 490, 0, 0.5, 1.0, Herramientas.cargarImagen("juego/recursos/enemy.gif"));
        Enemigo enemigo1 = new Enemigo(1600, 490, 0, 0.5, 1.0, Herramientas.cargarImagen("juego/recursos/enemy.gif"));
        Enemigo enemigo2 = new Enemigo(2000, 490, 0, 0.5, 1.0, Herramientas.cargarImagen("juego/recursos/enemy.gif"));

        fondos.add(fondoMario);
        fondos.add(gameOver);

        obstaculos.add(tuberia);
        obstaculos.add(tuberia1);
        obstaculos.add(tuberia2);

        enemigos.add(enemigo);
        enemigos.add(enemigo1);
        enemigos.add(enemigo2);

        this.gameOver = false;
        this.gameOverSound = Herramientas.cargarSonido("juego/recursos/Super Princess Peach Music - Oh, No Peach Fell.wav");
        //jugando.start();

        // Inicia el juego!
        this.entorno.iniciar();
    }

    public void tick() {

        TareasTick.musica(gameOver, gameOverSound);
        if (princesa.getVidas() > 0) {
            TareasTick.fondo(entorno, fondos, princesa, nivel);
            TareasTick.dibujarBarraPrincesa(entorno, princesa);
            TareasTick.obstaculos(entorno, obstaculos);
            TareasTick.enemigos(entorno, enemigos);
            TareasTick.princesa(entorno, princesa);
            TareasTick.generarEnemigos(enemigos);
            TareasTick.colisiones(entorno, princesa, obstaculos, enemigos);
            TareasTick.controladorPuntaje(entorno, princesa, enemigos);
        } else {
            TareasTick.gameOver(entorno, fondos);
            gameOver = true;
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();

    }
}
