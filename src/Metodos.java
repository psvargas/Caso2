import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Metodos 
{
	public static String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
	public static String[] diccionarios = new String[7];

	/***
	 * Encripta un mensaje de texto.
	 * @param message texto a encriptar
	 * @param algorithm algoritmo de encriptacion, puede ser: MD5, SHA-256, SHA-384, SHA-512
	 * @return mensaje encriptado ***/
	public static String generarCodigo(String msm, String algoritmo)
	{
		byte[] digest = null;
		byte[] buffer = msm.getBytes();
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance(algoritmo);
			messageDigest.reset();
			messageDigest.update(buffer);
			digest = messageDigest.digest();
			return toHexadecimal(digest);
		}
		catch(NoSuchAlgorithmException ex){
			System.out.println("Error creando Digest");
			return null;
		}

	}
	/***
	 *Convierte un arreglo de bytes a String usando valores hexadecimales
	 * @param digest arreglo de bytes a convertir
	 *@return String creado a partir de digest ***/
	private static String toHexadecimal(byte[] digest)
	{ 
		String hash = "";
		for(byte aux : digest)
		{
			int b = aux & 0xff;
			if(Integer.toHexString(b).length() == 1)
			{ hash += "0";}
			hash += Integer.toHexString(b);
		}
		return hash;
	}

	public static String identificar_entrada(String codigo, String algoritmo) throws IOException
	{
		boolean encontro = false;
		String  cadena = null;
		crearArchivos(algoritmo);
		
		for(int i=0; i<diccionarios.length && !encontro; i++)
		{
			BufferedReader bf = new BufferedReader(new FileReader(diccionarios[i]));
			String c = bf.readLine();
			
			while (c!=null && !encontro) 
			{
				String[] cad = c.split(",");
				if(codigo.equals(cad[1]))
				{
					encontro = true;
					cadena = cad[0];	
				}
			}
		}
		return cadena;
	}
	
	public static void crearArchivos(String alg) throws IOException 
	{
		String ruta = "data/diccionario1.txt";
		FileWriter fw = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fw);
		diccionarios[0] = ruta;

		for(int i=0; i<alfabeto.length; i++)
		{
			String act = alfabeto[i];
			pw.println(act + "," + generarCodigo(act,alg));
		}
		fw.close();

		crearDiccionarios(lista2(),alg, 2);
		crearDiccionarios(lista3(),alg, 3);
		crearDiccionarios(lista4(),alg, 4);
		crearDiccionarios(lista5(),alg, 5);
		crearDiccionarios(lista6(),alg, 6);
		crearDiccionarios(lista7(),alg, 7);


	}

	public static void crearDiccionarios(ArrayList<String> array, String alg, int n) throws IOException 
	{
		String ruta = "data/diccionario"+ n +".txt";
		FileWriter fw = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fw);
		diccionarios[n-1]=ruta;

		for(int i=0; i<array.size(); i++)
		{
			String act = array.get(i);
			pw.println(act + "," + generarCodigo(act,alg));
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
