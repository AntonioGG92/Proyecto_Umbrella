package Banco;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class App extends GestionAdm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GestionAdm Gestion = new GestionAdm();

		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		int opcion;
		int opciones;
		int rol;

		
			System.out.println();
			System.out.println("\u001B[36m------------------------------------------Bienvenidos a la APP------------------------------------------");
			System.out.println();
			System.out.println("\u001B[33mNecesitamos que cree un Cliente principal y posteriormente un Banco, una Cuenta y un Empleado antes de comenzar");
			System.out.println("\u001B[37m");
			
			
			do {
			System.out.println();
			System.out.println("\u001B[36m----------MENU PRINCIPAL----------");
			System.out.println("\u001B[37m");
			System.out.println("Escriba 1 para crear Cliente y Cuenta (Prioridad)");
			System.out.println("Escriba 2 para Administrador de Banco");
			System.out.println("Escriba 3 para Cliente de Banco");
			System.out.println("Escriba 0 para Salir del programa");

			rol = scanner.nextInt();

			if (rol == 1){ // Menu para Director

				do {
					System.out.println("Seleccione una opción:");
					System.out.println("\u001B[33m1. Creación de cliente");
					System.out.println("\u001B[33m2. Creación de cuenta");
					System.out.println("\u001B[37m3. Volver al menu principal");
					System.out.println("0. Salir del programa");

					opcion = scanner.nextInt();

					switch (opcion) {
					
					case 1:
						System.out.println("Alta cliente inicial");
						Gestion.AltaCliente();
						break;
						
					case 2:
						System.out.println("Alta de cuenta");
						Gestion.altaCuenta();			
						break;

					case 3:
						System.out.println("Menu Principal");
						break;
					case 0:
						System.out.println("Saliendo del programa.");
						break;

					default:
						System.out.println(
								"Por favor, primero complete la creación del banco antes de acceder a otras opciones.");
						break;
					}
				} while (opcion == 0);
			}
			if (rol == 2) { // Menu para Administrador
				do {
					System.out.println("Seleccione una opción del menu Administrador:");
					System.out.println("1. Alta de cliente");
					System.out.println("2. Modificar cliente específico");
					System.out.println("3. Imprimir lista clientes");
					System.out.println("4. Alta de empleado");
					System.out.println("5. Modificar empleado especifico");
					System.out.println("6. Imprimir lista empleados");
					System.out.println("7. Aumentar salario al empleado");
					System.out.println("8. Dar ascenso al empleado");
					System.out.println("9. Ir al Menu Principal");
					System.out.println("0. Salir del programa");

					opcion = scanner.nextInt();

					switch (opcion) {

					case 1:
						System.out.println("Alta de cliente:");
						Gestion.AltaCliente();
						break;

					case 2:
						if (Gestion.getMisCliente().isEmpty()) {
							System.out.println("La lista se encuentra vacia");
							System.out.println("Debe dar de alta antes a un cliente");
							Gestion.AltaCliente();
						} else {
							System.out.println("Modificar cliente específico:");
							Gestion.ModificarCliente();
						}
						break;

					case 3:
						System.out.println("Su lista de clientes");
						Gestion.ImprimirListaCliente();
						break;

					case 4:
						System.out.println("Alta de empleado:");
						Gestion.AltaEmpleados();
						break;

					case 5:
						if (Gestion.getMisEmpleados().isEmpty()) {
							System.out.println("La lista se encuentra vacia");
							System.out.println("Debe dar de alta antes a un empleado");
							Gestion.AltaEmpleados();
						} else {
							System.out.println("Modificar empleado específico:");
							Gestion.ModificarEmpleado();
							System.out.println();
						}
						break;

					case 6:
						System.out.println("Su lista de empleados");
						Gestion.ImprimirListaEmpleado();
						break;

					case 7:

						if (Gestion.getMisEmpleados().isEmpty()) {
							System.out.println("La lista esta vacia, añada antes un empleado.");
							Gestion.AltaEmpleados();
						}
						System.out.println("Modificar aumento del empleado");
						System.out.println("Ingrese el índice del empleado a modificar:");
						System.out.println(Gestion.getMisEmpleados().toString());
						int indiceEmpleado = scanner.nextInt();

						System.out.println("¿Qué porcentaje desea aumentar el salario?");
						double porcentajeAumento = scanner2.nextDouble();

						Gestion.aplicarAumentoSalarial(indiceEmpleado, porcentajeAumento);
						break;

					case 8:
						Gestion.ascenso();
						break;
					case 9:
						System.out.println("Menu Principal");
						break;

					case 0:
						System.out.println("Saliendo del programa.");
						System.exit(0);
						break;
					default:
						System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
						break;
					}
				} while (opcion == 0);
			}
			
			if (rol == 3) {	// Menu para Clientes
				
									
					
				do {	
					
					Scanner scanner3= new Scanner(System.in);
					System.out.println("Indique su DNI por favor");

					String miDNI = scanner3.nextLine();
					
					
					System.out.println("Seleccione una opcion del menu Cliente");
					System.out.println("1. Sacar Dinero");
					System.out.println("2. Ingresar Dinero");
					System.out.println("3. Visualizar Cuenta");
					System.out.println("4. Datos de la Cuenta");
					System.out.println("5. Tipo de Cuenta");
					System.out.println("6. Devolver intereses");
					System.out.println("7. Ir al menu Principal");
					System.out.println("8. Salir del programa");

					
			
					opciones = scanner2.nextInt();
					switch (opciones) {

					case 1:
						Gestion.SacarDinero(miDNI);
						break;
					case 2:
						Gestion.IngresarDinero(miDNI);
						break;
					case 3:
						Gestion.VisualizarCuenta(miDNI);
						break;
					case 4:
						Gestion.DatosCuenta(miDNI);
						break;
					case 5:
						Gestion.TipoCuenta(miDNI);
						break;
					case 6:
						Gestion.DevolverInteres(miDNI);
						break;
					case 7:
						System.out.println("Menu Principal");
						break;
					case 8: 
						System.out.println("Saliendo del programa...");
						System.exit(0);
					default:
						throw new IllegalArgumentException("Unexpected value: " + opciones);
					}
				} while (opciones == 0);
			}
			if(rol == 0) {
				System.err.println("Gracias por utilizar nuestro banco personal PALASACA");
			}
		} while (rol != 0);

	}
}
