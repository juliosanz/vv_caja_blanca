package com.practica.cajablancatest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;


public class PruebaSustituirPalabra {

	private Editor editor= new Editor();
	
	
	/*path 2*/
	@Test
	public void emptyEditor() {
		System.out.println(editor.editIsEmpty()); 
		editor.sustituirPalabra("any", "any1");
		assertTrue(editor.editIsEmpty());
		
	}
	
	/*path 3*/
	@Test
	public void twoEmptyList() throws EmptyCollectionException {
		editor.leerFichero("path3.txt");
		System.out.println(editor.size()); 
		System.out.println(editor.getLinea(2)); 
		System.out.println(editor.getLinea(1)); 
		editor.sustituirPalabra("any", "any1");
		System.out.println(editor.getLinea(2)); 
		System.out.println(editor.getLinea(1)); 
		
	}
	/*path 4*/
	@Test
	public void four() throws EmptyCollectionException {
		editor.leerFichero("path4.txt");
		System.out.println(editor.size()); 
		System.out.println(editor.getLinea(1)); 
		editor.sustituirPalabra("foo", "palabra");
		System.out.println(editor.getLinea(1)); 
		
	}
	/*path 5*/
	@Test
	public void five() throws EmptyCollectionException {
		editor.leerFichero("path5.txt");
		System.out.println(editor.size()); 
		System.out.println(editor.getLinea(1)); 
		editor.sustituirPalabra("palabra", "any");
		System.out.println(editor.getLinea(1)); 
		
	}
	
}
