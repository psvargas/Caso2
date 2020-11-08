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

		String mensaje=null;
		String algoritmo = null;
		Scanner consola = new Scanner(System.in);
		System.out.println("Ingrese el mensaje seguido de el algoritmo (MD5, SHA256, SHA384 o SHA512) separado por ',' Ejemplo: holahola,MD5 ");
		String linea=consola.nextLine();
		String[] line = linea.split(",");
		mensaje = line[0];
		algoritmo = line[1];
		//	if(mensaje!=null && algoritmo!=null && mensaje.length()<=7)
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
		//String hash = metds.generarCodigo(mensaje, MD5);
		//System.out.println(hash);
		//combinations2(alfabeto, 3, 0, new String[3]); 
	}

	public void crearDiccionario(ArrayList<String> array, String alg) throws IOException
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
	
	public ArrayList<String> lista2() throws IOException
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
	
	public ArrayList<String> lista3() throws IOException
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
	public ArrayList<String> lista4() throws IOException
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
	public ArrayList<String> lista5() throws IOException
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
	public ArrayList<String> lista6() throws IOException
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
	public ArrayList<String> lista7() throws IOException
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


