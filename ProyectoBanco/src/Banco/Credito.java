package Banco;

public class Credito extends Tarjetas{

	private double saldoMaximo;
	private double saldoFactura;
	private String fechaFacturacion;
	private double recargoTarjeta;
	


	public Credito(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			boolean Acceso, Cuentas cuentaAsociada, String numeroTarjeta, String clavePIN,
			String claveSeguridad, double saldoDiario, String fechaCaducidad, double saldoMaximo, double saldoFactura,
			String fechaFacturacion, double recargoTarjeta) {
		
		super(descripcion, comision, fInicio, fFinal, clienteAsociado,clave, Acceso, cuentaAsociada, numeroTarjeta,
				clavePIN, claveSeguridad, saldoDiario, fechaCaducidad);
		this.saldoMaximo = saldoMaximo;
		this.saldoFactura = saldoFactura;
		this.fechaFacturacion = fechaFacturacion;
		this.recargoTarjeta = recargoTarjeta;
	}


	public double getSaldoMaximo() {
		return saldoMaximo;
	}


	public void setSaldoMaximo(double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}


	public double getSaldoFactura() {
		return saldoFactura;
	}


	public void setSaldoFactura(double saldoFactura) {
		this.saldoFactura = saldoFactura;
	}


	public String getFechaFacturacion() {
		return fechaFacturacion;
	}


	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}


	public double getRecargoTarjeta() {
		return recargoTarjeta;
	}


	public void setRecargoTarjeta(double recargoTarjeta) {
		this.recargoTarjeta = recargoTarjeta;
	}


	@Override
	public String toString() {
		return "Credito [saldoMaximo=" + saldoMaximo + ", saldoFactura=" + saldoFactura + ", fechaFacturacion="
				+ fechaFacturacion + ", recargoTarjeta=" + recargoTarjeta + "]";
	}
	
	public Double sacaCredito(int cantidad) {
		if(acceso) {
			if (cantidad<saldodisponible) {
			setSaldodisponible(getSaldodisponible()-cantidad);
			setSaldofactura(getSaldofactura()+cantidad);
			System.out.println("dinero retirado ("+cantidad+")");
			}else {
				System.out.println("saldo insuficiente");
			}
		}
		acceso=false;
		return getSaldodisponible();
	}
	public void findemes() {
		setSaldodisponible(recargoCredito);
		getCuenta().setSaldo(getCuenta().getSaldo()-getSaldofactura());
		setSaldofactura(0.0);
	}
	
}
