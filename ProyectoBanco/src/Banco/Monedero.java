package Banco;

public class Monedero extends Tarjetas{

	private double saldoMonedero;

	

	public Monedero(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			boolean Acceso, Cuentas cuentaAsociada, String numeroTarjeta, String clavePIN,
			String claveSeguridad, double saldoDiario, String fechaCaducidad, double saldoMonedero) {
		
		super(descripcion, comision, fInicio, fFinal, clienteAsociado,clave, Acceso, cuentaAsociada, numeroTarjeta, 
				clavePIN, claveSeguridad, saldoDiario, fechaCaducidad);
		this.saldoMonedero = saldoMonedero;
	}

	public double getSaldoMonedero() {
		return saldoMonedero;
	}

	public void setSaldoMonedero(double saldoMonedero) {
		this.saldoMonedero = saldoMonedero;
	}

	@Override
	public String toString() {
		return "Monedero [saldoMonedero=" + saldoMonedero + "]";
	}
	
	
}
