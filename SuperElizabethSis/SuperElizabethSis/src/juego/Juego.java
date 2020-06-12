package juego;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import juego.entidades.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Princesa princesa;
	private LinkedList<Fondo> fondos = new LinkedList<>();
	private LinkedList<Obstaculo> obstaculos =  new LinkedList<>();
	private LinkedList<Enemigo> enemigos = new LinkedList<>();
	private Poder poder;
	private int nivel = 0;

	// Variables y métodos propios de cada grupo
	// ...
	Juego()
	{
		// Inicializa el objeto entorno

		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 5 - v1", 800, 600);

		// Inicializar lo que haga falta para el juego

		Fondo fondoMario = new Fondo(Herramientas.cargarImagen("./background.png"),600,300,0.3);

		princesa = new Princesa();

		Obstaculo tuberia =  new Obstaculo(1000,500,0,0.2,0.5,Herramientas.cargarImagen("green-pipe.png"));
        Obstaculo tuberia1 =  new Obstaculo(1350,500,0,0.2,0.5,Herramientas.cargarImagen("green-pipe.png"));
        Obstaculo tuberia2 =  new Obstaculo(1700,500,0,0.2,0.5,Herramientas.cargarImagen("green-pipe.png"));

		Enemigo soldado = new Enemigo(1200,500,01,0.7,0.7, Herramientas.cargarImagen("soldier.gif"));
		Enemigo soldado1 = new Enemigo(1600,500,0,0.7,0.7, Herramientas.cargarImagen("soldier.gif"));
		Enemigo soldado2 = new Enemigo(2000,500,0,0.7,0.7, Herramientas.cargarImagen("soldier.gif"));

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

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y
	 * por lo tanto es el método más importante de esta clase. Aquí se debe
	 * actualizar el estado interno del juego para simular el paso del tiempo
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		fondo(entorno,fondos,nivel);
        obstaculos(entorno,obstaculos);
		enemigos(entorno,enemigos);
		princesa.dibujarse(entorno);
		poder = princesa.atacar();

		if(poder != null){
			poder.dibujar(entorno);
			poder.avanzar();
		}

		if(enemigos.size() != 0) {
			if(poder != null && enemigos.get(nivel) != null ){
				if(poder.colision(enemigos.get(nivel).getBorder())) {
					enemigos.remove(nivel);
					poder.setY(-10000000);
				}
			}
		}

		// Procesamiento de un instante de tiempo
		// ...

	}

	public static void obstaculos(Entorno entorno, LinkedList<Obstaculo> obstaculos){
        for(Obstaculo obstaculo : obstaculos) {
            obstaculo.dibujarse(entorno);
            obstaculo.moverIzq();
        }
    }

	public static void enemigos(Entorno entorno, LinkedList<Enemigo> enemigos){
		for(Enemigo enemigo : enemigos) {
			enemigo.dibujarse(entorno);
			enemigo.moverIzq();
		}
	}
	public static void fondo(Entorno entorno, LinkedList<Fondo> fondos, int nivel){
		fondos.get(nivel).dibujar(entorno);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
