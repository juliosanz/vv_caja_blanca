package com.practica.cajablanca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utilidad {

	public static Editor leerFichero(String nombre, String text)
	{
		File file = new File(nombre);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try
		{
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(text);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bw.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		Editor editor = new Editor();
		editor.leerFichero(nombre);
		file.delete();
		return editor;
	}
}
