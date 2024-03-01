package Banco;

public class Debito extends Tarjetas{

	private double maximoDiario;

	

	public Debito(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			Cuentas cuentaAsociada, String numeroTarjeta, int clavePIN,
			int claveSeguridad, double saldoDiario, String fechaCaducidad, double maximoDiario) {
		
		super(descripcion, comision, fInicio, fFinal, clienteAsociado,clave, cuentaAsociada, numeroTarjeta,
				clavePIN, claveSeguridad, saldoDiario, fechaCaducidad);
		
		this.maximoDiario = maximoDiario;
	}

	public double getMaximoDiario() {
		return maximoDiario;
	}

	public void setMaximoDiario(double maximoDiario) {
		this.maximoDiario = maximoDiario;
	}

	@Override
	public String toString() {
		return "Debito [maximoDiario=" + maximoDiario + "]";
	}
	public Double sacaDebito(double cantidad) {
		if(acceso) {
			if (cantidad<maximoDiario && cantidad<cuentaAsociada.getSaldo()) {
			cuentaAsociada.setSaldo(cuentaAsociada.getSaldo()-cantidad);
			maximoDiario=maximoDiario-cantidad;	
			System.out.println("dinero retirado ("+cantidad+")");
			}else {
			System.out.println("esa cantidad supera el maximo diario permitido o la cuenta no tiene saldo suficiente");
			}
		}
		acceso=false;
		return cuentaAsociada.getSaldo();
	}
	public void finDia(double maximoDiario) {
		this.maximoDiario=maximoDiario;
	}
	
}
