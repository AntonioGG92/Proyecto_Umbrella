package Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionAdm {

	private ArrayList<Cliente> misCliente = new ArrayList<Cliente>(10);
	private ArrayList<Empleados> misEmpleados = new ArrayList<Empleados>(10);
	private ArrayList<Cuentas> miCuenta = new ArrayList<Cuentas>(10);

	public ArrayList<Cliente> getMisCliente() {
		return misCliente;
	}

	public void setMisCliente(ArrayList<Cliente> misCliente) {
		this.misCliente = misCliente;
	}

	public ArrayList<Empleados> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleados> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Cuentas> getMiCuenta() {
		return miCuenta;
	}

	public void setMiCuenta(ArrayList<Cuentas> miCuenta) {
		this.miCuenta = miCuenta;
	}

	// Metodo para creador del Banco

	Scanner miScan2 = new Scanner(System.in);
	Scanner miScan = new Scanner(System.in);

	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);

	public void altaCuenta() {

		boolean clienteCreado = false;

		while (!clienteCreado) {

			if (misCliente.isEmpty()) {
				System.out.println("Por favor cree un cliente primero antes de crear una cuenta");
				AltaCliente();
			}

			System.out.println("Ingrese el DNI del cliente para abrir la cuenta:");
			String dniCliente = scanner.nextLine();
			Cliente clienteEncontrado = null;
			for (Cliente c : getMisCliente()) {
				if (c.getDni().equals(dniCliente)) {
					clienteEncontrado = c;
					break;
				}
			}

			if (clienteEncontrado == null) {
				System.out.println("El cliente con dni " + dniCliente + " no ha sido encontrado");
				System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
				AltaCliente();
			} else {

				System.out.println();
				System.out.println("\u001B[36mCreación de nueva cuenta:");

				System.out.println("\u001B[37mIngrese la descripción de la cuenta:");
				String descripcion = scanner.nextLine();
				System.out.println();

				System.out.println("Ingrese la comision de la cuenta");
				double comision = scanner2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
				String fInicio = scanner.nextLine();
				System.out.println();

				System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
				String fFinal = scanner.nextLine();
				System.out.println();

				System.out.println("Ingrese el cliente asociado");
				Cliente cliente = clienteEncontrado;
				System.out.println(clienteEncontrado.toString());
				System.out.println();

				System.out.println("Ingrese su clave de acceso bancaria");
				int clave = scanner2.nextInt();

				System.out.println("Ingrese el tipo de cuenta (JOVEN, CORRIENTE, NOMINA, SUPERIOR, AHORRO):");
				String tipoCuentaInput = scanner.nextLine();
				TiposCuenta tipo = null;
				try {
					tipo = TiposCuenta.valueOf(tipoCuentaInput.toUpperCase());
				} catch (IllegalArgumentException e) {
					System.out.println("Tipo de cuenta inválido. Ingrese un tipo de cuenta válido");
				}
				System.out.println();

				System.out.println("Ingrese el iban de la cuenta");
				int iban = (int) (Math.random() * 1000000000 + 1);
				System.out.println("Iban aleatorio generado automaticamente");
				System.out.println(iban);
				System.out.println();

				System.out.println("Ingrese el saldo inicial");
				double saldo = scanner2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la cuota de mantenimiento");
				double cmantenimiento = scanner2.nextDouble();
				System.out.println();

				// Crear una nueva instancia de Cuentas utilizando el constructor predefinido
				Cuentas nuevaCuenta = new Cuentas(descripcion, comision, fInicio, fFinal, cliente, clave, tipo, iban,
						saldo, cmantenimiento);

				// Agregar la nueva cuenta a la lista miCuenta
				miCuenta.add(nuevaCuenta);

				System.out.println(nuevaCuenta.toString());
				System.out.println("\u001B[33m¡Nueva cuenta creada con éxito!");
				System.out.println("\u001B[37m");
				clienteCreado = true;
			}
		}
	}

	// Metodos para el Administrador del banco

	public void AltaCliente() {
		Scanner miScan2 = new Scanner(System.in);
		Scanner miScan = new Scanner(System.in);

		System.out.println("Introduzca el DNI del cliente:");
		String dni = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca el nombre del cliente:");
		String nombre = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca el primer apellido del cliente:");
		String apellido = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca el segundo apellido del cliente:");
		String apellido2 = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca el teléfono del cliente:");
		String telefono = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca el correo electrónico del cliente:");
		String correo = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca la dirección del cliente:");
		String direccion = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca la localidad del cliente:");
		String localidad = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca el código postal del cliente:");
		int cPostal = miScan2.nextInt();
		System.out.println();

		System.out.println("Introduzca la provincia del cliente:");
		String provincia = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca la fecha de nacimiento del cliente (formato dd/mm/yyyy):");
		String fnacimiento = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca observaciones sobre el cliente:");
		String observaciones = miScan.nextLine();
		System.out.println();

		System.out.println("Introduzca su situación laboral");
		String situacionLaboral = miScan.nextLine();
		System.out.println();

		Cliente nuevoCliente = new Cliente(dni, nombre, apellido, apellido2, telefono, correo, direccion, localidad,
				cPostal, provincia, fnacimiento, observaciones, situacionLaboral);

		misCliente.add(nuevoCliente);

		System.out.println("\u001B[33m¡Cliente dado de alta correctamente!.");
		System.out.println("\u001B[37m");
		for (Cliente Cliente : misCliente) {
			int posicion = misCliente.indexOf(Cliente);
			System.out.println("Posicion en la lista: " + posicion + " - " + Cliente);
			System.out.println();
		}

	}

	public void ModificarCliente() {

		int opcion;

		Scanner miScan3 = new Scanner(System.in);
		Scanner miScan = new Scanner(System.in);

		System.out.println("Lista de Cliente:");
		for (int i = 0; i < getMisCliente().size(); i++) {
			System.out.println(i + ". " + getMisCliente().get(i));
		}

		System.out.println("Ingrese el índice del cliente a modificar:");
		int indice = miScan3.nextInt();
		while (indice < 0 || indice >= getMisCliente().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan3.nextInt();
		}

		Cliente clienteAModificar = getMisCliente().get(indice);
		do {
			System.out.println("Modificar cliente:");
			System.out.println("----------------");
			System.out.println();
			System.out.println("1.Modificar DNI");
			System.out.println("2.Modificar Nombre");
			System.out.println("3.Modificar Apellido");
			System.out.println("4.Modificar Apellido2");
			System.out.println("5.Modificar Telefono");
			System.out.println("6.Modificar Email");
			System.out.println("7.Modificar Direccion");
			System.out.println("8.Modificar Localidad");
			System.out.println("9.Modificar Codigo postal");
			System.out.println("10.Modificar Provincia");
			System.out.println("11.Modificar Fecha nacimiento");
			System.out.println("12.Modificar Observaciones");
			System.out.println("13.Modificar Situacion laboral");
			System.out.println("0.SALIR");

			opcion = miScan3.nextInt();

			if (opcion == 1) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setDni(dato);
			}
			if (opcion == 2) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setNombre(dato);
			}
			if (opcion == 3) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setApellido(dato);
			}

			if (opcion == 4) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setApellido2(dato);
			}

			if (opcion == 5) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setTelefono(dato);
			}
			if (opcion == 6) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setCorreo(dato);
			}
			if (opcion == 7) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setDireccion(dato);
			}
			if (opcion == 8) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setLocalidad(dato);
			}
			if (opcion == 9) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				try {
					int codigoPostal = Integer.parseInt(dato);
					clienteAModificar.setCPostal(codigoPostal);
				} catch (NumberFormatException e) {
					System.out.println(
							"El dato introducido no es válido. Introduce un número entero para el código postal.");
				}

			}
			if (opcion == 10) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setProvincia(dato);
			}
			if (opcion == 11) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setFnacimiento(dato);
			}
			if (opcion == 12) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setObservaciones(dato);
			}
			if (opcion == 13) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setSituacionLaboral(dato);
			}

		} while (opcion != 0);
		System.out.println("Lista de Cliente modificado:");
		for (int i = 0; i < getMisCliente().size(); i++) {
			System.out.println(i + ". " + getMisCliente().get(i));
		}
		System.out.println();
	}

	public void ImprimirListaCliente() {
		if (misCliente.isEmpty()) {
			System.out.println("La lista de Cliente esta vacia");
			System.out.println();
		} else {
			for (Cliente Cliente : misCliente) {
				int posicion = misCliente.indexOf(Cliente);
				System.out.println("Posicion en la lista: " + posicion + " - " + Cliente);
				System.out.println();
			}
		}
	}

	public void AltaEmpleados() {

		Scanner miScan2 = new Scanner(System.in);
		Scanner miScan = new Scanner(System.in);

		System.out.println("Introduzca el DNI del empleado:");
		String dni = miScan2.nextLine();

		System.out.println("Introduzca el nombre del empleado:");
		String nombre = miScan.nextLine();

		System.out.println("Introduzca el primer apellido del empleado:");
		String apellido = miScan.nextLine();

		System.out.println("Introduzca el segundo apellido del empleado:");
		String apellido2 = miScan.nextLine();

		System.out.println("Introduzca el teléfono del empleado:");
		String telefono = miScan.nextLine();

		System.out.println("Introduzca el correo electrónico del empleado:");
		String correo = miScan.nextLine();

		System.out.println("Introduzca la dirección del empleado:");
		String direccion = miScan.nextLine();

		System.out.println("Introduzca la localidad del empleado:");
		String localidad = miScan.nextLine();

		System.out.println("Introduzca el código postal del empleado:");
		int cPostal = miScan2.nextInt();

		System.out.println("Introduzca la provincia del empleado:");
		String provincia = miScan.nextLine();

		System.out.println("Introduzca la fecha de nacimiento del empleado (formato dd/mm/yyyy):");
		String fnacimiento = miScan.nextLine();

		System.out.println("Introduzca observaciones sobre el empleado:");
		String observaciones = miScan.nextLine();

		System.out.println("Introduzca la fecha de contratacion del empleado (formato dd/mm/yyyy):");
		String fechaContratacion = miScan.nextLine();

		System.out.println("Introduzca el puesto de trabajo del empleado");
		String puestoTrabajo = miScan.nextLine();

		System.out.println("Introduzca el sueldo del empleado");
		Double sueldo = miScan2.nextDouble();

		System.out.println("Introduzca los años de experiencia del empleado");
		int aniosExperiencia = miScan2.nextInt();

		Empleados nuevoEmpleado = new Empleados(dni, nombre, apellido, apellido2, telefono, correo, direccion,
				localidad, cPostal, provincia, fnacimiento, observaciones, fechaContratacion, puestoTrabajo, sueldo,
				aniosExperiencia);

		misEmpleados.add(nuevoEmpleado);

	}

	public void ModificarEmpleado() {

		Scanner miScan4 = new Scanner(System.in);
		int opcion;

		System.out.println("Lista de Empleados:");
		for (int i = 0; i < getMisEmpleados().size(); i++) {
			System.out.println(i + ". " + getMisEmpleados().get(i));
		}

		System.out.println("Ingrese el índice del empleado a modificar:");
		int indice = miScan4.nextInt();
		while (indice < 0 || indice >= getMisEmpleados().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan4.nextInt();
		}

		Empleados empleadoAModificar = getMisEmpleados().get(indice);
		do {
			System.out.println("Modificar empleado:");
			System.out.println("----------------");
			System.out.println("1.Modificar DNI");
			System.out.println("2.Modificar Nombre");
			System.out.println("3.Modificar Apellido");
			System.out.println("4.Modificar Apellido2");
			System.out.println("5.Modificar Telefono");
			System.out.println("6.Modificar Email");
			System.out.println("7.Modificar Direccion");
			System.out.println("8.Modificar Localidad");
			System.out.println("9.Modificar Codigo postal");
			System.out.println("10.Modificar Provincia");
			System.out.println("11.Modificar Fecha nacimiento");
			System.out.println("12.Modificar Observaciones");
			System.out.println("13.Modificar Fecha de contratacion");
			System.out.println("14.Modificar Puesto de trabajo");
			System.out.println("15.Modificar Sueldo");
			System.out.println("16.Modificar Años de Experiencia");
			System.out.println("0.SALIR");

			opcion = miScan4.nextInt();

			if (opcion == 1) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setDni(dato);
			}
			if (opcion == 2) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setNombre(dato);
			}
			if (opcion == 3) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setApellido(dato);
			}

			if (opcion == 4) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setApellido2(dato);
			}

			if (opcion == 5) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setTelefono(dato);
			}
			if (opcion == 6) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setCorreo(dato);
			}
			if (opcion == 7) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setDireccion(dato);
			}
			if (opcion == 8) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setLocalidad(dato);
			}
			if (opcion == 9) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				try {
					int codigoPostal = Integer.parseInt(dato);
					empleadoAModificar.setCPostal(codigoPostal);
				} catch (NumberFormatException e) {
					System.out.println(
							"El dato introducido no es válido. Introduce un número entero para el código postal.");
				}

			}
			if (opcion == 10) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setProvincia(dato);
			}
			if (opcion == 11) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setFnacimiento(dato);
			}
			if (opcion == 12) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setObservaciones(dato);
			}
			if (opcion == 13) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setFechaContratacion(dato);
			}
			if (opcion == 14) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan4.next();
				empleadoAModificar.setPuestoTrabajo(dato);
			}
			if (opcion == 15) {
				System.out.println("Introduzca nuevo dato");
				Double datos = miScan4.nextDouble();
				empleadoAModificar.setSueldo(datos);
			}
			if (opcion == 16) {
				System.out.println("Introduzca nuevo dato");
				int datos = miScan4.nextInt();
				empleadoAModificar.setAniosExperiencia(datos);
			}
		} while (opcion != 0);
		System.out.println("Lista modificada:");
		System.out.println(misEmpleados.toString());
	}

	public void ImprimirListaEmpleado() {

		if (misEmpleados.isEmpty()) {
			System.out.println("La lista de empleados está vacía.");
		} else {
			for (Empleados empleado : misEmpleados) {
				int posicion = misEmpleados.indexOf(empleado);
				System.out.println("Posición en la lista: " + posicion + " - " + empleado);
			}
		}
	}

	public void aplicarAumentoSalarial(int indiceEmpleado, double porcentajeAumento) {
		if (getMisEmpleados().isEmpty()) {
			System.out.println("La lista esta vacia, añada antes un empleado.");
			AltaEmpleados();
		}

		Scanner miScan4 = new Scanner(System.in);
		System.out.println("Lista de Empleados:");
		for (int i = 0; i < getMisEmpleados().size(); i++) {
			System.out.println(i + ". " + getMisEmpleados().get(i));
		}

		int indice = indiceEmpleado;
		while (indice < 0 || indice >= getMisEmpleados().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan4.nextInt();
		}
		if (indiceEmpleado >= 0 && indiceEmpleado < misEmpleados.size()) {
			Empleados empleado = misEmpleados.get(indiceEmpleado);
			empleado.aumentoSalarial(porcentajeAumento);
		} else {
			System.out.println("Índice de empleado inválido. Por favor, seleccione un índice válido.");
		}
	}

	public void ascenso() {
		if (getMisEmpleados().isEmpty()) {
			System.out.println("La lista esta vacia, añada antes un empleado.");
			AltaEmpleados();
		}
		Scanner miScanner = new Scanner(System.in);
		Scanner miScanner2 = new Scanner(System.in);
		System.out.println("Modificar ascenso del empleado");

		Scanner miScan4 = new Scanner(System.in);
		System.out.println("Lista de Empleados:");
		for (int i = 0; i < getMisEmpleados().size(); i++) {
			System.out.println(i + ". " + getMisEmpleados().get(i));
		}

		System.out.println("Ingrese el índice del empleado a modificar:");
		int indice = miScan4.nextInt();
		while (indice < 0 || indice >= getMisEmpleados().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan4.nextInt();
		}

		int indiceEmpleado = miScanner.nextInt();

		System.out.println("Ingrese el nuevo puesto el empleado");
		String nuevoPuesto = miScanner2.nextLine();
		System.out.println("Ingrese el nuevo sueldo del empleado");
		double sueldo = miScanner.nextDouble();

		double nuevoSueldo = 0.0;
		if (indiceEmpleado >= 0 && indiceEmpleado < misEmpleados.size()) {
			Empleados empleado = misEmpleados.get(indiceEmpleado);
			empleado.ascenso(nuevoPuesto, nuevoSueldo);
		}
		System.out.println(getMisEmpleados().toString());
	}

	// Metodos para el Cliente



	public void SacarDinero(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		// Verificar que el cliente y la cuenta coincidan
		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("Saldo disponible antes de la operación: " + cuenta.getSaldo());

			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese la clave de acceso para realizar la operación: ");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				System.out.println("Ingrese la cantidad que desea retirar: ");
				double cantidad = scanner.nextDouble();

				if (cuenta.getSaldo() >= cantidad) {
					cuenta.SacarDinero(cantidad);

					System.out.println("Saldo disponible después de la operación: " + cuenta.getSaldo());
				} else {
					System.out.println("Saldo insuficiente para realizar la operación de retiro.");
				}
			} else {
				System.out.println("Clave incorrecta. Operación de retiro cancelada.");
			}
		} else {
			System.out.println("Cliente o cuenta no encontrados o no coinciden.");
		}
	}

	public void IngresarDinero(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		// Verificar que el cliente y la cuenta coincidan
		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduzca su clave de acceso para ingresar dinero:");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				System.out.println("Saldo disponible antes de la operación: " + cuenta.getSaldo());

				System.out.println("¿Qué cantidad de dinero quiere ingresar?");
				double cantidad = scanner.nextDouble();

				cuenta.IngresarDinero(cantidad);

				System.out.println("Saldo disponible después de la operación: " + cuenta.getSaldo());
			} else {
				System.out.println("Clave incorrecta. Operación de ingreso cancelada.");
			}
		} else {
			System.out.println("Cliente o cuenta no encontrados o no coinciden.");
		}
	}

	public void VisualizarCuenta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null) {
			if (cuenta != null) {
				String infoCuenta = cuenta.VisualizarCuenta();
				System.out.println(infoCuenta);
			} else {
				System.out.println("El cliente no tiene una cuenta asociada para visualizar.");
			}
		} else {
			System.out.println("Cliente no encontrado o no tiene acceso para visualizar la cuenta.");
		}
	}

	public void DatosCuenta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}
		if (cliente != null) {
			String infocuenta = cuenta.DatosCuenta();
			System.out.println(infocuenta);
		} else {
			System.out.println("Cliente no encontrado o no tiene acceso para visualizar los datos de la cuenta.");
		}
	}

	public TiposCuenta TipoCuenta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}
		if (cliente != null) {
			String tipo = cuenta.getTipo().name();
			System.out.println("Su tipo de cuenta es: " + tipo);
		} else {
			System.out.println("Cliente no encontrado o no tiene acceso para visualizar los datos de la cuenta.");
		}
		return null;
	}

	public void DevolverInteres(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null) {
			double intereses = cuenta.DevolverIntereses();
			System.out.println("Los interes a devolver son: " + intereses);
		} else {
			System.out.println("Cliente no encontrado o no tiene acceso para visualizar los datos de la cuenta.");

		}
	}
}