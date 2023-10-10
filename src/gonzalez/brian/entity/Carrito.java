package gonzalez.brian.entity;

import java.time.LocalDate;
import java.util.List;

public class Carrito {
	private LocalDate fecha;
	private List<ItemCarrito> itemsCarrito;

	public Carrito() {
	}

	public Carrito(LocalDate fecha, List<ItemCarrito> itemsCarrito) {
		super();
		this.fecha = fecha;
		this.itemsCarrito = itemsCarrito;
	}

	public double precio(Descuento descuento) {
		double total = 0;

		for (ItemCarrito item : itemsCarrito) {
			total += item.precio();
		}

		return total - descuento.descuento(total);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<ItemCarrito> getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}
}
