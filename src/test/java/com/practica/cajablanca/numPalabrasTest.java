package com.practica.cajablanca;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;



public class numPalabrasTest {
	
	static Editor editor;
	static SingleLinkedListImpl<String> unElemento;
	
	@BeforeAll
	public static void init()
	{
		editor = new Editor();
		unElemento = new SingleLinkedListImpl<String>("A");
	}
	
	@BeforeEach
	public void update()
	{
		editor = new Editor();
		unElemento = new SingleLinkedListImpl<String>("A");
	}

	// path1
	@Test
	public void numPalabrasTestPath1()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			editor.numPalabras(0, -1, null);
		});
	}
	
	// path2
	@Test
	public void numPalabrasTestPath2()
	{
		editor.leerFichero("path2.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			editor.numPalabras(1, 3, null);
		});
	}
	
	// path3
	@Test
	public void numPalabrasTestPath3()
	{
		int apariciones = editor.numPalabras(1, 0, null);
		assertEquals(apariciones, 0);
	}
	
	// path4
	@Test
	public void numPalabrasTestPath4()
	{
		editor.leerFichero("path4.txt");
		assertEquals(0, editor.numPalabras(5, 3, null));
	}
	
	// path5
	@Test
	public void numPalabrasExtraTestPath5() {
		editor.leerFichero("path5.txt");
		assertEquals(0,editor.numPalabras(1,2,null));
		//como aseguramos que pos sea 3?
	}
	
	// path 6
	@Test
	public void numPalabrasExtraTestPath6() {
		editor.leerFichero("path6.txt");
		assertEquals(1,editor.numPalabras(1,2,"yoshi"));
	}
	
	// path 7
	@Test
	public void numPalabrasExtraTestPath7() {
		editor.leerFichero("path7.txt");
		assertEquals(0,editor.numPalabras(1,2,"noAparece"));
	}
	
	@Test
	public void leerFicheroTest()
	{
		File file = new File("leerFicheroPrueba.txt");
		String[] testLine1 = {"Lorem", "ipsum", "dolor"};
		String[] testLine2 = {"sit", "amet", "consectetur"};
		String[] testLine3 = {"adipisicing", "elit"};
		String[][] tests = {testLine1, testLine2, testLine3};
		String test = "Lorem ipsum dolor\r\nsit amet consectetur\r\nadipisicing elit";
		FileWriter fw = null;
		BufferedWriter bw = null;
		try
		{
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(test);
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
		editor.leerFichero("leerFicheroPrueba.txt");
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
