import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public void CrearDiccionarios() throws IOException
	{
		File file = null;
		for(int i=0; i<7; i++)
		{
			file = new File("data/Diccionario"+(i+1)+".txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.append("c");
			bw.close();
		}


	}

	public String[] Combinaciones (int n)
	{

		return null;
	}

	public void combinations2(String[] alfabeto2, int len, int startPosition, String[] result)
	{ 
		if (len == 0)
		{ 
			System.out.println(Arrays.toString(result)); 
			return; 
		} 
		for (int i = startPosition; i <= alfabeto2.length-len; i++)
		{ 
			result[result.length - len] = alfabeto2[i];
			combinations2(alfabeto2, len-1, i+1, result); 
		}
	} 
	
//	public void print_combinations(char string) 
//	{ 
//		int i, j, k; 
//		int len = strlen(string); 
//		for (i = 0; i < len - 2; i++)
//		{ 
//			for (j = i + 1; j < len - 1; j++)
//			{
//				for (k = j + 1; k < len; k++) 
//					printf("%c%c%c\n", string[i], string[j], string[k]); 
//			}
//		}
//	} 
}


