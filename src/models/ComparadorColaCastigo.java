package models;

import java.util.Comparator;

public class ComparadorColaCastigo implements Comparator<Alumno>{

	@Override
	public int compare(Alumno c1, Alumno c2) {

		if(c1.getMedia() == c2.getMedia()) { //Compara la nota media de los dos alumnos entre ellos
			return 0;
		} else if (c1.getMedia() >= c2.getMedia()) {
			return -1;
		} else {
			return 1;
		}
	}

	
	
}
