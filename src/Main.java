import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	public static String MD5 = "MD5";
	public static String SHA256 = "SHA-256";
	public static String SHA384 = "SHA-384";
	public static String SHA512 = "SHA-512";
	
	public static void main(String[] args) throws IOException 
	{
		boolean b = false;
		String mensaje = null;
		String algoritmo = null;
		String codigo = null;
		Scanner consola = new Scanner(System.in);

		while(b == false)
		{
			System.out.println("Caso 2 - Infraestructura Computacional");
			System.out.println("1. Generar código criptográfico de hash");
			System.out.println("2. Encontrar cadena");

			String opcion = consola.nextLine();
			if(opcion=="1")
			{
				System.out.println("Ingrese el mensaje seguido de el algoritmo (MD5, SHA256, SHA384 o SHA512) separado por ',' Ejemplo: holahola,MD5 ");
				String linea = consola.nextLine();
				String[] line = linea.split(",");
				mensaje = line[0].toLowerCase();
				algoritmo = line[1];
				String hash=null;

				if(mensaje!=null && algoritmo!=null && mensaje.length()<=7)
				{
					if(algoritmo.equalsIgnoreCase("MD5"))
					{
						hash = Metodos.generarCodigo(mensaje, MD5); 
						b=true;
					}
					else if(algoritmo.equalsIgnoreCase("SHA256"))
					{
						hash = Metodos.generarCodigo(mensaje, SHA256);
						b=true;
					}
					else if(algoritmo.equalsIgnoreCase("SHA384"))
					{
						hash = Metodos.generarCodigo(mensaje, SHA384);
						b=true;
					}
					else if(algoritmo.equalsIgnoreCase("SHA512"))
					{
						hash = Metodos.generarCodigo(mensaje, SHA512);
						b=true;
					}
					else
						System.out.println("El algoritmo no es correcto");
				}
				else
					System.out.println("Hubo algún problema");

				System.out.println("Código criptográfico de hash: " + hash);


			}
			else
			{
				System.out.println("Ingrese el código y el algoritmo (MD5, SHA256, SHA384 o SHA512) separado por ',' Ejemplo: a3dk203,MD5");
				String linea = consola.nextLine();
				String[] line = linea.split(",");
				codigo = line[0];
				algoritmo = line[1];
				String cadena = null;
				if(codigo!=null && algoritmo!=null)
				{
					if(algoritmo.equalsIgnoreCase("MD5"))
					{
						cadena = Metodos.identificar_entrada(codigo, MD5);
						b=true;
					}
					else if(algoritmo.equalsIgnoreCase("SHA256"))
					{
						cadena = Metodos.identificar_entrada(codigo, SHA256);
						b=true;
					}
					else if(algoritmo.equalsIgnoreCase("SHA384"))
					{
						cadena = Metodos.identificar_entrada(codigo, SHA384);
						b=true;
					}
					else if(algoritmo.equalsIgnoreCase("SHA512"))
					{
						cadena = Metodos.identificar_entrada(codigo, SHA512);
						b=true;
					}
					else
						System.out.println("El algoritmo no es correcto");
				}
				else 
					System.out.println("Hubo algún problema");

				if(cadena!=null)
					System.out.println("La cadena que se usó para generar el código fue: " + cadena );
				else 
					System.out.println("No se encontró respuesta");	
			}
		}
		consola.close();
	}

	
}


