package Banco;

public class Monedero extends Tarjetas{

	private double saldoMonedero;

	

	public Monedero(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			Cuentas cuentaAsociada, String numeroTarjeta, int clavePIN,
			int claveSeguridad, double saldoDiario, String fechaCaducidad, double saldoMonedero) {
		
		super(descripcion, comision, fInicio, fFinal, clienteAsociado,clave, cuentaAsociada, numeroTarjeta, 
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
	
	public Double sacaMonedero(double cantidad) {
		if(acceso) {
			if (cantidad<saldoMonedero) {
				setSaldoDiario(getSaldoDiario()-cantidad);
				System.out.println("dinero retirado ("+cantidad+")");
			}else {
				System.out.println("saldo insuficiente");
			}
		}
		acceso=false;
		return getSaldoDiario();
	}
	
	public Double cargaSaldo(int cantidad) {
		if(acceso) {
			setSaldoDiario(getSaldoDiario()+cantidad);
			System.out.println("dinero ingresado");
		}
		acceso=false;
		return getSaldoDiario();
	}
}
