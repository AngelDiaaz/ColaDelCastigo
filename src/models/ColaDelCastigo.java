package models;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import exceptions.ColaExceededSizeException;
import exceptions.ElementBlockedException;
import exceptions.LlevateTuNullDeAquiException;

public class ColaDelCastigo<E> {

	private LinkedList<E> cola;
	private Comparator<E> comparador;

	public ColaDelCastigo(Comparator<E> comparador) {
		super();
		this.cola = new LinkedList<E>();
		this.comparador = comparador;
	}

	/**
	 * Devuelve cuantos elementos tiene la lista
	 * 
	 * @return Tamaño de la lista
	 */

	public int size() {
		return cola.size();
	}

	/**
	 * Indica si la lista esta vacia o no
	 * 
	 * @return True se la lista esta vacia y false si no lo esta
	 */

	public boolean isEmpty() {
		if (cola.size() > 0)
			return false;
		else
			return true;
	}

	/**
	 * Indica si en la cola contiene el objeto o
	 * 
	 * @param o Objeto que queremos saber si contiene la lista
	 * @return True si lo contiene y false si no
	 */

	public boolean contains(Object o) {
		if (cola.contains(o))
			return true;
		else
			return false;
	}

	/**
	 * Devuelve el iterador que contiene la cola
	 * 
	 * @return Iterador de la cola
	 */

	public Iterator<E> iterator() {
		return cola.iterator();
	}

	/**
	 * Devuleve un objeto con todos los elementos que contiene, del primero al
	 * ultimo
	 * 
	 * @return Objeto con todos los elementos
	 */

	public Object[] toArray() {
		return cola.toArray();
	}

	/**
	 * Devuelve un objeto con todos los elementos que contine un objeto especifico,
	 * del primero al ultimo
	 * 
	 * @param a Objeto especifico que contiene los elementos que queremos sacar
	 * @return Objeto con todos los elementos de a
	 */

	public Object[] toArray(Object[] a) {
		return cola.toArray(a);
	}

	/**
	 * Elimina el primer objeto que se especifica de la lista
	 * 
	 * @param o Objeto especifico que queremos eliminar
	 * @return True si se ha eliminado y false si no
	 * @throws Exception ElementBlockedException Si se intenta eliminar el ultimo
	 *                   elemento que queda en la lista
	 */

	public boolean remove(Object o) throws Exception {
		if (cola.size() != 1) {
			if (cola.remove(o))
				return true;
			else
				return false;
		} else {
			throw new Exception(
					new ElementBlockedException("No puedes eliminar el ultimo elemento que queda en la cola"));
		}
	}

	/**
	 * Comprueba si tiene todos los elementos en una coleccion especifica, verifica
	 * si tiene el conjunto de elementos o no en la coleccion
	 * 
	 * @param c Coleccion especifica
	 * @return True si lo contiene y false si no
	 */

	public boolean containsAll(Collection<E> c) {
		if (cola.containsAll(c))
			return true;
		else
			return false;
	}

	/**
	 * Añade una coleccion de elementos al final de la lista de otra coleccion
	 * 
	 * @param c Coleccion que queremos añadir a otra coleccion
	 * @return True si se ha añadido y false si no
	 * @throws Exception ColaExceededSizeException Si al añadir la coleccion c a la
	 *                   coleccion que queremos es mayor de 10
	 */

	public boolean addAll(Collection<E> c) throws Exception {
		if ((cola.size() + c.size()) < 10) {
			if (cola.addAll(c))
				return true;
			else
				return false;
		} else {
			throw new Exception(new ColaExceededSizeException(
					"No puedes añadir más elementos a la cola, ya hay 10 elementos en la cola"));
		}
	}

	/**
	 * Elimina todos los elementos que esten contenidos en una lista especifica
	 * 
	 * @param c Lista especifica que queremos eliminar
	 * @return Excepcion
	 * @throws Exception ElementBlockedException no se pueden eliminar todos los
	 *                   componentes de una lista
	 */

	public boolean removeAll(Collection<E> c) throws Exception {
		if(cola.size() > c.size()) {
		if (cola.removeAll(c))
			return true;
		else
			return false;
		} else {
			throw new Exception(new ElementBlockedException("No puedes eliminar todos los elementos de la cola"));
		}
	}

	/**
	 * Elimina todo los elementos que no esten en la coleccion c
	 * 
	 * @param c Coleccion con los elementos que no queremos que se eliminen
	 * @return True si se han eliminado y false si no
	 * @throws Exception ElementBlockedException No permite eliminar todos los
	 *                   componentes de la cola y dejarla vacia
	 */

	public boolean retainAll(Collection<E> c) throws Exception {
		if (cola.retainAll(c))
			if (cola.size() > 0)
				return true;
			else
				throw new Exception(new ElementBlockedException("No puedes eliminar todos los elementos de la cola"));
		else
			return false;
	}

	/**
	 * Elimina todos los elementos de la cola, la cola se queda vacia cuando se usa
	 * esta funcion
	 * 
	 * @throws Exception ElementBlockedException No permite eliminar todos los
	 *                   componentes de la cola y dejarla vacia
	 */

	public void clear() throws Exception {
		// cola.clear();
		throw new Exception(new ElementBlockedException("No puedes eliminar todos los elementos de la cola"));

	}

	/**
	 * Añade el elemento especifico al final de la lista
	 * 
	 * @param e Elemento especifico que queremos añadir
	 * @return True si se ha añadido y false si no
	 * @throws Exception ColaExceededSizeException Cuando al añadir ese elemento el
	 *                   tamaño de la cola es mayor de 10 -
	 *                   LlevateTuNullDeAquiException cuando se quiere añadir un
	 *                   elemento nulo a la cola
	 */

	public boolean add(E e) throws Exception {
		if (!e.equals(null)) {
			if (cola.size() < 10) {
				if (cola.add(e)) {
					Collections.sort(cola, comparador);
					return true;
				} else
					return false;
			} else {
				throw new Exception(new ColaExceededSizeException(
						"No puedes añadir más elementos a la cola, ya hay 10 elementos en la cola"));
			}
		} else {
			throw new Exception(new LlevateTuNullDeAquiException("No puedes añadir nulos a la cola"));
		}
	}

	/**
	 * Indica si un elemento se ha añadido a la cola o no
	 * 
	 * @param e Elemento que queremos añadir a la cola
	 * @return True si se ha añadido y false si no
	 * @throws Exception ColaExceededSizeException Cuando al añadir ese elemento el
	 *                   tamaño de la cola es mayor de 10
	 */

	public boolean offer(E e) throws Exception {
		if (cola.size() < 10) {
			if (cola.offer(e))
				return true;
			else
				return false;
		} else {
			throw new Exception(new ColaExceededSizeException(
					"No puedes añadir más elementos a la cola, ya hay 10 elementos en la cola"));
		}
	}

	/**
	 * Elimina el primer elemento de la cola
	 * 
	 * @return Primer elemento de la cola
	 * @throws Exception ElementBlockedException Cuando se intente eliminar el
	 *                   ultimo elemento que quede en la cola y se deje vacia
	 */

	public Object remove() throws Exception {
		if (cola.size() == 1) {
			throw new Exception(new ElementBlockedException("No puedes eliminar el ultimo elemento de la cola"));
		} else {
			return cola.remove();
		}
	}

	/**
	 * Elimina el primer elemento de la cola y si esta vacia te devuelve null
	 * 
	 * @return Primer elemento de la cola o null si no tiene ningun elemento
	 */

	public Object poll() {
		if (cola.isEmpty())
			return null;
		else
			return cola.poll();
	}

	/**
	 * Devuelve el primer elemento de la cola, pero no lo elimina
	 * 
	 * @return Primer elemento de la cola
	 */

	public Object element() {
		return cola.element();
	}

	/**
	 * Devuelve el primer elemento de la cola sin eliminarlo o si la cola esta vacia
	 * te devuelve null
	 * 
	 * @return Primer elemento de la cola o null si la cola esta vacia
	 */

	public Object peek() {
		if (cola.isEmpty())
			return null;
		else
			return cola.peek();
	}

}
