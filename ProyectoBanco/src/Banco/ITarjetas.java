package Banco;

public interface ITarjetas {

	public String getClavePIN();
	public String getClaveSeguridad();
	public Cliente getClienteAsociado();
	public Cuentas getCuentaAsociada();
	public String getFechaCaducidad();
	public String getNumeroTarjeta();
	public double getSaldoDiario();
}
