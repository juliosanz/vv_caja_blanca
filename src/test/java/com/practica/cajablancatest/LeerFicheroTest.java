package com.practica.cajablancatest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import com.practica.cajablanca.Editor;
import com.practica.cajablanca.Utilidad;

public class LeerFicheroTest {

	static Editor editor;
	
	@BeforeAll
	public static void init()
	{
		editor = new Editor();
	}
	
	@Test
	public void leerFicheroTest()
	{
		
		String[] testLine1 = {"Lorem", "ipsum", "dolor"};
		String[] testLine2 = {"sit", "amet", "consectetur"};
		String[] testLine3 = {"adipisicing", "elit"};
		String[][] tests = {testLine1, testLine2, testLine3};
		
		String fileTest = "Lorem ipsum dolor\r\nsit amet consectetur\r\nadipisicing elit";
		String fileName = "leerFicheroPrueba.txt";
		
		editor = Utilidad.leerFichero(fileName, fileTest);
		
		for(int i = 1; i < 4; i++)
		{
			try
			{
				SingleLinkedListImpl<String> fichText = (SingleLinkedListImpl<String>) editor.getLinea(i);
				SingleLinkedListImpl<String> textTest = new SingleLinkedListImpl<String>(tests[i-1]);
				for(int j = 1; j <= fichText.size(); j++)
				{
					assertEquals(fichText.getAtPos(j), textTest.getAtPos(j));
				}
			}
			catch(EmptyCollectionException e)
			{
				e.printStackTrace();
			}
		}
	}
}
