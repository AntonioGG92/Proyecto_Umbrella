package Banco;

public class Tarjetas extends Banco implements ITarjetas{

	
	private Cuentas cuentaAsociada;
	private String numeroTarjeta;
	private String clavePIN;
	private String claveSeguridad;
	private double saldoDiario;
	private String fechaCaducidad;
	private Cliente clienteAsociado;
	
	
	

	public Tarjetas(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			boolean Acceso, Cuentas cuentaAsociada, String numeroTarjeta,
			String clavePIN, String claveSeguridad, double saldoDiario, String fechaCaducidad) {
		
		super(descripcion,comision, fInicio, fFinal,clave);
		
		this.cuentaAsociada = cuentaAsociada;
		this.numeroTarjeta = numeroTarjeta;
		this.clavePIN = clavePIN;
		this.claveSeguridad = claveSeguridad;
		this.saldoDiario = saldoDiario;
		this.fechaCaducidad = fechaCaducidad;
		this.clienteAsociado= clienteAsociado;
	}



	public Cuentas getCuentaAsociada() {
		return cuentaAsociada;
	}


	public void setCuentaAsociada(Cuentas cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
	}


	public Cliente getClienteAsociado() {
		return clienteAsociado;
	}



	public void setClienteAsociado(Cliente clienteAsociado) {
		this.clienteAsociado = clienteAsociado;
	}



	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public String getClavePIN() {
		return clavePIN;
	}


	public void setClavePIN(String clavePIN) {
		this.clavePIN = clavePIN;
	}


	public String getClaveSeguridad() {
		return claveSeguridad;
	}


	public void setClaveSeguridad(String claveSeguridad) {
		this.claveSeguridad = claveSeguridad;
	}


	public double getSaldoDiario() {
		return saldoDiario;
	}


	public void setSaldoDiario(double saldoDiario) {
		this.saldoDiario = saldoDiario;
	}


	public String getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	@Override
	public String toString() {
		return "Tarjetas [ cuentaAsociada=" + cuentaAsociada
				+ ", numeroTarjeta=" + numeroTarjeta + ", clavePIN=" + clavePIN + ", claveSeguridad=" + claveSeguridad
				+ ", saldoDiario=" + saldoDiario + ", fechaCaducidad=" + fechaCaducidad + "]";
	}
}
