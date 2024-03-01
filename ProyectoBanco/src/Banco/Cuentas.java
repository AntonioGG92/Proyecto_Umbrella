package Banco;

import java.util.Scanner;

public class Cuentas extends Banco implements ICuentas{
	
	protected TiposCuenta Tipo;
	protected int Iban;
	protected double Saldo;
	protected double Cmantenimiento;
	protected Cliente cliente;

	
	
	public Cuentas(String descripcion, double comision, String fInicio, String fFinal, Cliente cliente, int clave, 
			TiposCuenta tipo, int iban,double saldo, double cmantenimiento) {
		super(descripcion,comision, fInicio, fFinal, clave);
		this.cliente= cliente;
		this.Tipo = tipo;
		this.Iban = iban;
		this.Saldo= saldo;
		this.Cmantenimiento = cmantenimiento;
	}

	

	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	public TiposCuenta getTipo() {
		return Tipo;
	}

	public void setTipo(TiposCuenta tipo) {
		Tipo = tipo;
	}

	public int getIban() {
		return Iban;
	}

	public void setIban(int iban) {
		Iban = iban;
	}


	public double getCmantenimiento() {
		return Cmantenimiento;
	}

	public void setCmantenimiento(double cmantenimiento) {
		Cmantenimiento = cmantenimiento;
	}

	

	public double getComision() {
		return comision;
	}
	
	public void setComision(double comision) {
		this.comision = comision;
	}



	public int getClave() {
		return clave;
	}



	public void setClave(int clave) {
		this.clave = clave;
	}

	

	@Override
	public String toString() {
		return "Cuentas [Tipo=" + Tipo + ", Iban=" + Iban + ", Saldo=" + Saldo + ", Cmantenimiento=" + Cmantenimiento
				+ ", clave=" + clave + ", Descripcion=" + descripcion + ", Comision=" + comision + ", FInicio="
				+ fInicio + ", FFinal=" + fFinal + "]";
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

	 
    @Override
    public double SacarDinero(double cantidad) {
    if (this.acceso && this.getSaldo() >= cantidad) {
        setSaldo(getSaldo() - cantidad);
        System.out.println("Has retirado dinero un total de: " + cantidad + "€");
        System.out.println("Saldo posterior: " + getSaldo() + "€");
    } else {
        System.out.println("Clave incorrecta o saldo insuficiente para realizar la operación");
    }

    return getSaldo();
}
	@Override
	public double IngresarDinero(double cantidad) {
	
    if (this.acceso) {
        setSaldo(getSaldo() + cantidad);
        System.out.println("Usted ha ingresado " + cantidad + "€");
        System.out.println("Saldo actual: " + getSaldo() + "€");
    } else {
        System.out.println("Clave incorrecta");
    }

    return getSaldo();
}

	@Override
	public String VisualizarCuenta() {
		Scanner miScan= new Scanner(System.in);
    System.out.println("Introduzca su clave de acceso para visualizar la cuenta:");
    int claveAcceso = miScan.nextInt();

    String cadena = "";
    if (this.Acceso(claveAcceso)) {
        cadena = "Saldo actual: " + getSaldo();
    } else {
        cadena = "Clave incorrecta";
    }
    return cadena;
}

	@Override
	public String DatosCuenta() {
		Scanner miScan= new Scanner(System.in);
    System.out.println("Introduzca su clave de acceso para ver los datos de la cuenta:");
    int claveAcceso = miScan.nextInt();

    String infoCuenta = "";
    if (this.Acceso(claveAcceso)) {
        infoCuenta = "Tipo de Cuenta: " + Tipo + "\n" +
                     "IBAN: " + Iban + "\n" +
                     "Saldo: " + Saldo + "\n" +
                     "Comisión de Mantenimiento: " + Cmantenimiento + "\n" +
                     "Descripción: " + descripcion + "\n" +
                     "Comisión: " + comision + "\n" +
                     "Fecha de Inicio: " + fInicio + "\n" +
                     "Fecha Final: " + fFinal + "\n" +
                     "Clave: " + clave;
    } else {
        infoCuenta = "Clave incorrecta";
    }
    return infoCuenta;
}

	@Override
	
	public TiposCuenta TipoCuenta() {
		Scanner miScan= new Scanner(System.in);
    System.out.println("Introduzca su clave de acceso para obtener el tipo de cuenta:");
    int claveAcceso = miScan.nextInt();

    if (this.Acceso(claveAcceso)) {
        return getTipo();
    } else {
        System.out.println("Clave incorrecta");
        return null;
    }
}

	@Override
	public double DevolverIntereses() {
		double intereses=0.0;
		if(acceso) {
		intereses= getSaldo()*super.getComision()/100;
		System.out.println("Los interes a devolver son: "+ intereses);
		
		}else {
			System.out.println("Clave incorrecta");
		}
		return intereses;
		
	}




	//-----------------------------------------------//
	
	
	
	

	
}

