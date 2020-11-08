import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
	private static Metodos metds;
	public static String MD5 = "MD5";
	public static String SHA256 = "SHA-256";
	public static String SHA384 = "SHA-384";
	public static String SHA512 = "SHA-512";
	public static String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};

	public static void main(String[] args) throws IOException 
	{
		//		try (   InputStreamReader is= new InputStreamReader(System.in); BufferedReader br = new BufferedReader(is);)
		//		{
		//			String msm = null;
		//			String algoritmo = null;
		//			boolean b=false;
		//
		//			String line = br.readLine();
		//			while(!b)
		//			{
		//				System.out.println("Ingrese el mensaje seguido de el algoritmo (MD5, SHA256, SHA384 o SHA512) separado por ',' Ejemplo: holahola,MD5 ");
		//				String[] linea = line.split(",");
		//				msm=linea[0];
		//				algoritmo=linea[1];
		//				
		//				if(msm!=null && algoritmo!=null && msm.length()<=7)
		//				{
		//					if(algoritmo.equalsIgnoreCase("MD5"))
		//					{System.out.println(metds.generarCodigo(msm, MD5)); b=true;}
		//					else if(algoritmo.equalsIgnoreCase("SHA256"))
		//					{metds.generarCodigo(msm, SHA256); b=true;}
		//					else if(algoritmo.equalsIgnoreCase("SHA384"))
		//					{metds.generarCodigo(msm, SHA384); b=true;}
		//					else if(algoritmo.equalsIgnoreCase("SHA512"))
		//					{metds.generarCodigo(msm, SHA512); b=true;}
		//				}	
		//				
		//				line = br.readLine();
		//			}
		//		}

		boolean b=false;
		String mensaje = null;
		String algoritmo = null;
		Scanner consola = new Scanner(System.in);
		while(b==false)
		{
			System.out.println("Ingrese el mensaje seguido de el algoritmo (MD5, SHA256, SHA384 o SHA512) separado por ',' Ejemplo: holahola,MD5 ");
			String linea = consola.nextLine();
			String[] line = linea.split(",");
			mensaje = line[0];
			algoritmo = line[1];
			String hash=null;

			if(mensaje!=null && algoritmo!=null && mensaje.length()<=7)
			{
				if(algoritmo.equalsIgnoreCase("MD5"))
				{
					hash = metds.generarCodigo(mensaje, MD5); 
					identificarTam(mensaje, MD5);
					b=true;
				}
				else if(algoritmo.equalsIgnoreCase("SHA256"))
				{
					hash = metds.generarCodigo(mensaje, SHA256);
					identificarTam(mensaje, SHA256);
					b=true;
				}
				else if(algoritmo.equalsIgnoreCase("SHA384"))
				{
					hash = metds.generarCodigo(mensaje, SHA384);
					identificarTam(mensaje, SHA384);
					b=true;
				}
				else if(algoritmo.equalsIgnoreCase("SHA512"))
				{
					hash = metds.generarCodigo(mensaje, SHA512);
					identificarTam(mensaje, SHA512);
					b=true;
				}
				else
					System.out.println("El algoritmo no es correcto");
			}
			else
				System.out.println("Hubo algún problema");

			System.out.println("Código criptográfico de hash: "+hash);
			
			String cadena = metds.identificar_entrada(hash, algoritmo);
			
			if(cadena!=null)
				System.out.println("La cadena que se usó para generar el código fue: " + cadena );
			else 
				System.out.println("No se encontró respuesta");

		}
	}

	public static void identificarTam(String msm, String alg) throws IOException
	{
		int n = msm.length();
		if(n==1)
		{
			FileWriter fw = new FileWriter("data/diccionario.txt");
			PrintWriter pw = new PrintWriter(fw);

			for(int i=0; i<alfabeto.length; i++)
			{
				String act = alfabeto[i];
				pw.println(act + "," + metds.generarCodigo(act,alg));
			}
			fw.close();
		}
		else if(n==2) crearDiccionario(lista2(),alg);
		else if(n==3) crearDiccionario(lista3(),alg);
		else if(n==4) crearDiccionario(lista4(),alg);
		else if(n==5) crearDiccionario(lista5(),alg);
		else if(n==6) crearDiccionario(lista6(),alg);
		else crearDiccionario(lista7(),alg);

	}
	public static void crearDiccionario(ArrayList<String> array, String alg) throws IOException
	{
		FileWriter fw = new FileWriter("data/Diccionario.txt");
		PrintWriter pw = new PrintWriter(fw);

		for(int i=0; i<array.size(); i++)
		{
			String act = array.get(i);
			pw.println(act + "," + metds.generarCodigo(act,alg));
		}
		fw.close();
	}

	public static ArrayList<String> lista2() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();

		for(int i=0; i<alfabeto.length; i++)
		{
			for(int j=0; j<alfabeto.length; j++)
			{
				array.add(alfabeto[i]+alfabeto[j]);
			}
		}
		return array;
	}

	public static ArrayList<String> lista3() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<String> anterior = lista2();

		for(int i=0; i<anterior.size(); i++)
		{
			for(int j=0; j<alfabeto.length; j++)
			{
				array.add(anterior.get(i)+alfabeto[j]);
			}
		}
		return array;
	}
	public static ArrayList<String> lista4() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<String> anterior = lista3();

		for(int i=0; i<anterior.size(); i++)
		{
			for(int j=0; j<alfabeto.length; j++)
			{
				array.add(anterior.get(i)+alfabeto[j]);
			}
		}
		return array;
	}
	public static ArrayList<String> lista5() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<String> anterior = lista4();

		for(int i=0; i<anterior.size(); i++)
		{
			for(int j=0; j<alfabeto.length; j++)
			{
				array.add(anterior.get(i)+alfabeto[j]);
			}
		}
		return array;
	}
	public static ArrayList<String> lista6() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<String> anterior = lista5();

		for(int i=0; i<anterior.size(); i++)
		{
			for(int j=0; j<alfabeto.length; j++)
			{
				array.add(anterior.get(i)+alfabeto[j]);
			}
		}
		return array;
	}
	public static ArrayList<String> lista7() throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<String> anterior = lista6();

		for(int i=0; i<anterior.size(); i++)
		{
			for(int j=0; j<alfabeto.length; j++)
			{
				array.add(anterior.get(i)+alfabeto[j]);
			}
		}
		return array;
	}
}


