package com.practica.cajablancatest;



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
import com.practica.cajablanca.Editor;



public class NumPalabrasTest {
	
	static Editor editor;
	static SingleLinkedListImpl<String> unElemento;
	private static final String SOURCE_PATH = "./src/test/misc/NumPalabrasTest/";
	
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
		editor.leerFichero(SOURCE_PATH + "paths.txt");
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
		editor.leerFichero(SOURCE_PATH + "path4.txt");
		assertEquals(0, editor.numPalabras(5, 3, null));
	}
	
	// path5
	@Test
	public void numPalabrasExtraTestPath5() {
		editor.leerFichero(SOURCE_PATH + "paths.txt");
		assertEquals(0,editor.numPalabras(1,2,null));
		//como aseguramos que pos sea 3?
	}
	
	// path 6
	@Test
	public void numPalabrasExtraTestPath6() {
		editor.leerFichero(SOURCE_PATH + "paths.txt");
		assertEquals(1,editor.numPalabras(1,2,"yoshi"));
	}
	
	// path 7
	@Test
	public void numPalabrasExtraTestPath7() {
		editor.leerFichero(SOURCE_PATH + "paths.txt");
		assertEquals(0,editor.numPalabras(1,2,"noAparece"));
	}
}
