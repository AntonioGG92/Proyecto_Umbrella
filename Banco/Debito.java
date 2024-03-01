package Banco;

public class Debito extends Tarjetas{

	private double maximoDiario;

	

	public Debito(String descripcion, double comision, String fInicio, String fFinal, Cliente clienteAsociado,int clave,
			boolean Acceso, Cuentas cuentaAsociada, String numeroTarjeta, String clavePIN,
			String claveSeguridad, double saldoDiario, String fechaCaducidad, double maximoDiario) {
		
		super(descripcion, comision, fInicio, fFinal, clienteAsociado,clave, Acceso, cuentaAsociada, numeroTarjeta,
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
	
	
}
