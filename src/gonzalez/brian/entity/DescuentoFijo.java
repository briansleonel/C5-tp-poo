package gonzalez.brian.entity;

import java.time.LocalDate;

public class DescuentoFijo extends Descuento {
	private double monto;

	public DescuentoFijo() {
	}

	public DescuentoFijo(int monto) {
		super();
		this.monto = monto;
	}

	public DescuentoFijo(LocalDate comienzo, LocalDate fin) {
		super(comienzo, fin);
	}

	@Override
	public double descuento(double base) {
		return monto;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
}
