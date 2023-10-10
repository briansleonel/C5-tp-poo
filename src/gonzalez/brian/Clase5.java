package gonzalez.brian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import gonzalez.brian.entity.Carrito;
import gonzalez.brian.entity.Descuento;
import gonzalez.brian.entity.DescuentoPorPorcentaje;
import gonzalez.brian.entity.ItemCarrito;
import gonzalez.brian.entity.Producto;

public class Clase5 {

	public static void main(String[] args) {
		Path carritoFile = Paths.get("./src/carrito.txt");

		List<ItemCarrito> items = new ArrayList<ItemCarrito>();

		try {
			// Creo el objeto de items del carrito leidos desde el archivo
			for (String texto : Files.readAllLines(carritoFile)) {
				String[] carritoSeparado = texto.split(",");

				Producto producto = new Producto();
				producto.setNombre(carritoSeparado[2]);
				producto.setPrecio(Double.parseDouble(carritoSeparado[1]));

				ItemCarrito item = new ItemCarrito(Integer.parseInt(carritoSeparado[0]), producto);

				items.add(item);
			}

			Carrito carrito = new Carrito();
			carrito.setItemsCarrito(items);

			Descuento desc = new DescuentoPorPorcentaje(0.2);

			System.out.println("cant    precio    producto");
			for (ItemCarrito item : carrito.getItemsCarrito()) {
				System.out.println(item.getCantidad() + "       " + item.getProducto().getPrecio() + "     "
						+ item.getProducto().getNombre());
			}
			System.out.println("\n                  Precio: " + carrito.precio(desc));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
