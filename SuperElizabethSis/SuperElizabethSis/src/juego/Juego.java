package juego;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import juego.entidades.*;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Fondo fondo;
	private Princesa princesa;
	private Obstaculo obstaculo;
	private Enemigo enemigo;

	// Variables y métodos propios de cada grupo
	// ...
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 5 - v1", 800, 600);
		// Inicializar lo que haga falta para el juego
		fondo = new Fondo(Herramientas.cargarImagen("./background.png"),600,300,0.3);
		princesa = new Princesa();
		obstaculo =  new Obstaculo(500);
		enemigo = new Enemigo(1000,500,0.7,Herramientas.cargarImagen("soldier.gif"), 1);
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
		fondo.dibujar(entorno);
		princesa.dibujarse(entorno);
		Poder poder = princesa.atacar();
		if(poder != null){
			poder.dibujar(entorno);
			poder.avanzar();
		}
		obstaculo.dibujarse(entorno);
		obstaculo.moverIzq();
		enemigo.dibujarse(entorno);
		enemigo.moverIzq();
		// Procesamiento de un instante de tiempo
		// ...
		

	}
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
