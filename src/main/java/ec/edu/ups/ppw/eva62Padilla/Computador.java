package ec.edu.ups.ppw.eva62Padilla;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Computador {

	@Id
	@GeneratedValue
	int id_computador;
	String id_unico;
	String marca;
	String modelo;
	String precio;
	String almacenamiento;
	
	public Computador() {
	    }

	public int getId_computador() {
		return id_computador;
	}

	public void setId_computador(int id_computador) {
		this.id_computador = id_computador;
	}

	public String getId_unico() {
		return id_unico;
	}

	public void setId_unico(String id_unico) {
		this.id_unico = id_unico;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	@Override
	public String toString() {
		return "Computador [id_computador=" + id_computador + ", id_unico=" + id_unico + ", marca=" + marca
				+ ", modelo=" + modelo + ", precio=" + precio + ", almacenamiento=" + almacenamiento + "]";
	}
}