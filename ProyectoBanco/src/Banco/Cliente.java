package Banco;

import java.util.Scanner;

public class Cliente extends DatosPersonales {

	
	private String situacionLaboral;
	

	
	public Cliente(String dni, String nombre, String apellido, String apellido2, String telefono, String correo, String direccion,
			String localidad, int cPostal, String provincia, String fnacimiento, String observaciones,String situacionLaboral) {
		super(dni, nombre, apellido, apellido2, telefono, correo, direccion, localidad, cPostal, provincia, fnacimiento, observaciones);
		this.situacionLaboral=situacionLaboral;	
		
	}
	
	

	public void setSituacionLaboral(String situacionLaboral) {
		this.situacionLaboral = situacionLaboral;
	}


	public String getSituacionLaboral() {
		return situacionLaboral;
	}

	


	@Override
	public String toString() {
		return "Clientes [Dni=" + Dni + ", Nombre="
				+ Nombre + ", Apellido=" + Apellido + ", Apellido2=" + Apellido2 + ", Telefono=" + Telefono
				+ ", Correo=" + Correo + ", Direccion=" + Direccion + ", Localidad=" + Localidad + ", CPostal="
				+ CPostal + ", Provincia=" + Provincia + ", Fnacimiento=" + Fnacimiento + ", Observaciones="
				+ Observaciones + ", SituacionLaboral=" + situacionLaboral + " ]";
	}
	






	
}
	