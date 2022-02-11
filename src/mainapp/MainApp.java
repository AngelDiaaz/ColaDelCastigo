package mainapp;

import java.util.Iterator;

import models.Alumno;
import models.ColaDelCastigo;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		//Creamos una cola del castigo y metemos el comparador en una funcion lambda
		ColaDelCastigo<Alumno> cola = new ColaDelCastigo<Alumno>((Alumno c1, Alumno c2) -> {

			if (c1.getMedia() == c2.getMedia()) { // Compara la nota media de los dos alumnos entre ellos
				return 0;
			} else if (c1.getMedia() >= c2.getMedia()) {
				return -1;
			} else {
				return 1;
			}
		});

		// Creamos a los alumnos y los añadimos a la cola
		cola.add(new Alumno("Pepe", "Perico", 5));
		cola.add(new Alumno("Ramon", "Perico", 5.2));
		cola.add(new Alumno("Pep", "Perico", 5.3));
		cola.add(new Alumno("Juan", "Perico", 5));
		cola.add(new Alumno("Jose", "Perico", 2));
		cola.add(new Alumno("Pichu", "Perico", 10));
		cola.add(new Alumno("Pichon", "Perico", 4));
		cola.add(new Alumno("Fede", "Perico", 5));
		cola.add(new Alumno("Snake", "Perico", 1));
		cola.add(new Alumno("Fulanito", "Perico", 6));

		// Al añadir este nuevo alumno a la cola nos saltara la excepcion de que la cola
		// ya tiene 10
		// elementos y no nos dejara añadir mas elementos
		
		// cola.add(new Alumno("Pepe", "Perico", 5));

		
		// Al usar esta funcion e intentar eliminar todos los elementos de la cola nos
		// saldra la excepcion de ElementBlockedException, que no nos permitira eliminar
		// la cola al completo y dejarla vacia

		// cola.clear();

		
		// Al añadir un objeto null nos mostrara la excepcion de
		// LlevateTuNullDeAquiException, que a su vez llamara a la excepcion
		// NullPointerException, ya que la hereda
		
		//cola.add(null);
		

		// Para mostrar a los alumnos de la cola
		Iterator<Alumno> iterador = cola.iterator();
		while (iterador.hasNext()) {
			System.out.println(iterador.next());
		}

	}

}
