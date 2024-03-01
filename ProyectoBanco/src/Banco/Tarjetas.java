package Banco;

public class Tarjetas extends Banco implements ITarjetas{


	protected Cuentas cuentaAsociada;
	private String numeroTarjeta;
	private int clavePIN;
	private int claveSeguridad;
	private double saldoDiario;
	private String fechaCaducidad;
	private Cliente clienteAsociado;




	public Tarjetas(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			boolean Acceso, Cuentas cuentaAsociada, String numeroTarjeta,
			int clavePIN, int claveSeguridad, double saldoDiario, String fechaCaducidad) {

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


	public int getClavePIN() {
		return clavePIN;
	}


	public void setClavePIN(int clavePIN) {
		this.clavePIN = clavePIN;
	}


	public int getClaveSeguridad() {
		return claveSeguridad;
	}


	public void setClaveSeguridad(int claveSeguridad) {
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

	@Override
	public boolean Acceso(int codigo) {
		if (super.Acceso(codigo)) {
			acceso = true;
		} else {
			acceso = false;
		}
		return acceso;
	}
	public void sacaDinero(int cantidad) {
		if(acceso) {
			if (this instanceof Debito) {
				//MODIFICA CLIENTE
				Debito debito = (Debito) this;
				debito.sacaDebito(cantidad);
			}
			if (this instanceof Credito) {
				//MODIFICA EMPLEADO
				Credito credito = (Credito) this;
				credito.sacaCredito(cantidad);
			}
			if (this instanceof Monedero) {
				//MODIFICA EMPLEADO
				Monedero monedero = (Monedero) this;
				monedero.sacaMonedero(cantidad);
			}	
		}else {
			System.out.println("ping incorrecto");
		}

	}
	public Double cargarMonedero(int cantidad) {
		Double resultado=(double) 0;
		if(acceso) {
			if(this instanceof Monedero){
				Monedero monedero = (Monedero) this;
				if(cuentaAsociada.getSaldo()>cantidad) {
					resultado=monedero.cargaSaldo(cantidad);
					cuentaAsociada.setSaldo(cuentaAsociada.getSaldo()-cantidad);
					System.out.println("dinero ingresado ("+cantidad+")");
				}
			}
		}else {
			System.out.println("ping incorrecto");
		}
		return resultado;
	}

	public String saldoDisponible() {
		String respuesta="";
		if(acceso) {
			if (this instanceof Debito) {
				Debito debito = (Debito) this;
				respuesta="su cuenta dispone de:"+debito.getCuentaAsociada().getSaldo();
			}
			if (this instanceof Credito) {
				Credito credito = (Credito) this;
				respuesta="este mes aun dispone de:"+credito.getSaldoDiario();
			}
			if (this instanceof Monedero) {
				Monedero monedero = (Monedero) this;
				respuesta="el saldo en la tarjeta es de:"+monedero.getSaldoMonedero();
			}	
		}else {
			System.out.println("ping incorrecto");
		}
		return respuesta;
	}
	public String datosTarjeta() {
		String respuesta="";
		if(acceso) {
			if (this instanceof Debito) {
				Debito debito = (Debito) this;
				respuesta=debito.toString();
			}
			if (this instanceof Credito) {
				Credito credito = (Credito) this;
				respuesta=credito.toString();
			}
			if (this instanceof Monedero) {
				Monedero monedero = (Monedero) this;
				respuesta=monedero.toString();
			}	
		}else {
			System.out.println("ping incorrecto");
		}
		return respuesta;
	}
	public boolean acceso(int codigo) {
		if(codigo==clavePIN) {
			acceso=true;
		}else {
			System.out.println("ping incorrecto");
		}
		return acceso;
	}

}
