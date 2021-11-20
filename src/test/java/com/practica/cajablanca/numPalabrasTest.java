package com.practica.cajablanca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.practica.cajablanca.Editor;

public class numPalabrasTest {
	
	Editor editor;
	
	@Test
	@BeforeAll
	public void init()
	{
		editor = new Editor();
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
		System.out.println(editor.size());
		assertThrows(IllegalArgumentException.class, () -> {
			editor.numPalabras(1, 3, null);
		});
	}
	
	// path 3
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

}
