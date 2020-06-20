package juego;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import juego.entidades.*;

import java.util.LinkedList;

public class Juego extends InterfaceJuego {

    protected final Entorno entorno;
    protected Princesa princesa;
    protected LinkedList<Fondo> fondos = new LinkedList<>();
    protected LinkedList<Obstaculo> obstaculos = new LinkedList<>();
    protected LinkedList<Enemigo> enemigos = new LinkedList<>();

    protected int nivel;

    Juego() {
        // Inicializa el objeto entorno

        this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 5 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        this.nivel = 0;


        Fondo fondoMario = new Fondo(Herramientas.cargarImagen("./background.png"), 600, 300, 0.3);

        princesa = new Princesa();

        Obstaculo tuberia = new Obstaculo(1000, 500, 0, 0.2, 0.5, Herramientas.cargarImagen("green-pipe.png"));
        Obstaculo tuberia1 = new Obstaculo(1350, 500, 0, 0.2, 0.5, Herramientas.cargarImagen("green-pipe.png"));
        Obstaculo tuberia2 = new Obstaculo(1700, 500, 0, 0.2, 0.5, Herramientas.cargarImagen("green-pipe.png"));

        Enemigo soldado = new Enemigo(1200, 500, 0, 0.7, 0.7, Herramientas.cargarImagen("soldier.gif"));
        Enemigo soldado1 = new Enemigo(1600, 500, 0, 0.7, 0.7, Herramientas.cargarImagen("soldier.gif"));
        Enemigo soldado2 = new Enemigo(2000, 500, 0, 0.7, 0.7, Herramientas.cargarImagen("soldier.gif"));

        fondos.add(fondoMario);

        obstaculos.add(tuberia);
        obstaculos.add(tuberia1);
        obstaculos.add(tuberia2);

        enemigos.add(soldado);
        enemigos.add(soldado1);
        enemigos.add(soldado2);

        // Inicia el juego!
        this.entorno.iniciar();
    }

    public void tick() {

        TareasTick.fondo(entorno, fondos, nivel);
        TareasTick.dibujarBarraPrincesa(entorno, princesa);
        TareasTick.obstaculos(entorno, obstaculos);
        TareasTick.enemigos(entorno, enemigos);
        TareasTick.princesa(entorno, princesa);
        TareasTick.generarEnemigos(enemigos);
        TareasTick.colisiones(entorno, princesa, obstaculos, enemigos);
        TareasTick.controladorPuntaje(entorno, princesa, enemigos);

    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
