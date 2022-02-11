package mainapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Alumno;
import models.ColaDelCastigo;

class MainAppTest {
	
	private ColaDelCastigo<Alumno> cola = new ColaDelCastigo<Alumno>((Alumno c1, Alumno c2) -> {

		if(c1.getMedia() == c2.getMedia()) { //Compara la nota media de los dos alumnos entre ellos
			return 0;
		} else if (c1.getMedia() >= c2.getMedia()) {
			return -1;
		} else {
			return 1;
		}
	});
	
	@BeforeEach
	void Before() throws Exception {
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
	}
	

	@Test
	void testTamanoCola() throws Exception {
		cola.add(new Alumno("Fede", "Perico", 5));
		

		
	}

}
