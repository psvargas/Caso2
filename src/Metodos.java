import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Metodos 
{


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
	/***
	 * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
	 * @param message texto a encriptar
	 * @param algorithm algoritmo de encriptacion, puede ser: MD5, SHA-256, SHA-384, SHA-512
	 * @return mensaje encriptado ***/
	public String generarCodigo(String msm, String algoritmo)
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

	public String identificar_entrada(String codigo, String algoritmo) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader("data/diccionario.txt"));
		String c = bf.readLine();
		String  cadena = null;
		boolean encontro = false;
		while (cadena!=null && !encontro) 
		{
			String[] cad = cadena.split(",");
			if(codigo.equals(cad[1]))
			{
				encontro = true;
				cadena = cad[0];	
			}
		}

		return cadena;
	}

}
