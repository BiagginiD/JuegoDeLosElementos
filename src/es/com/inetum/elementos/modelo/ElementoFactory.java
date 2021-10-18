package es.com.inetum.elementos.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoFactory {
	// constantes
	public static final int PIEDRA = 0;

	public static final int PAPEL = 1;

	public static final int TIJERA = 2;

	// atributos

	protected String descripcionResultado;

	private static List<ElementoFactory> elementos;

	protected String nombre;

	protected int numero;

	// constructor

	public ElementoFactory(String pNombre, int pNumero) {
		nombre = pNombre;
		numero = pNumero;
	}

	// getter y setter accesos

	public String getDescripcionResultado() {
		return descripcionResultado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	// metodos de negocio

	public boolean isMe(int pNum) {
		return numero == pNum;
	}

	public abstract int comparar(ElementoFactory pElem);

	public static ElementoFactory getInstance(int pInt) {
		elementos = new ArrayList<ElementoFactory>();
		elementos.add(new Piedra());
		elementos.add(new Papel());
		elementos.add(new Tijera());

		for (ElementoFactory elementoFactory : elementos) {
			if (elementoFactory.isMe(pInt))
				return elementoFactory;
		}
		return null;

	}

}
