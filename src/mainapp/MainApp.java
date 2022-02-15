package mainapp;

import java.util.ArrayList;
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
		Alumno a = new Alumno("Snake", "Perico", 1);
		Alumno b = new Alumno("Ramon", "Perico", 5.2);
		Alumno c = new Alumno("Pichu", "Perico", 10);
		
		cola.add(new Alumno("Pepe", "Perico", 5));
		//cola.add(b);
		cola.add(new Alumno("Pep", "Perico", 5.3));
		cola.add(new Alumno("Juan", "Perico", 5));
		cola.add(new Alumno("Jose", "Perico", 2));
		//cola.add(c);
		cola.add(new Alumno("Pichon", "Perico", 4));
		cola.add(new Alumno("Fede", "Perico", 5));
		cola.add(a);
		
		//Te muestra si se ha añadido el alumno o no con esta funcion
		System.out.println(cola.offer(new Alumno("Fulanito", "Perico", 6)));

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
		
		//Para mostrar el largo de la cola
		System.out.println(cola.size());
		
		//Comprobando que la cola no esta vacia
		System.out.println(cola.isEmpty());
		
		//Compruebo si la cola tiene el alumno a
		System.out.println(cola.contains(a));
		
		
		//Elimino el alumno a
		cola.remove(a);
		
		//Elimino el primer alumno de la cola, con una de las dos funciones
		cola.remove();
		//cola.poll();
		
		//Compruebo que tengan todos los elementos de un objeto a la cola
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(b);
		alumnos.add(c);
		
		//Te muestra que los alumnos del array list los contiene la cola
		cola.containsAll(alumnos);
		
		//Añade a cola todos los alumnos del array list alumnos
		cola.addAll(alumnos);
		
		//Elimina a todos los alumnos que no esten en el array list de la cola
		//cola.retainAll(alumnos);
		
		// Para mostrar a los alumnos de la cola
		Iterator<Alumno> iterador = cola.iterator();
		while (iterador.hasNext()) {
			System.out.println(iterador.next());
		}

		//Almaceno la cola en un objeto y para comprobarlo saco el tamaño
		System.out.println(cola.toArray().length);
		
		//Elimina a todos los alumnos del array list alumnos de la cola
		cola.removeAll(alumnos);
		
		//Obtengo el primer alumno de la cola
		System.out.println(cola.element().toString());
		//System.out.println(cola.peek().toString());
	}

}
