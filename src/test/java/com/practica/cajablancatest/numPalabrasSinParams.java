package com.practica.cajablancatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class numPalabrasSinParams {
	
	Editor editor= new Editor();
	
	@Test
	public void emptyEditor() {
		assertThrows(EmptyCollectionException.class, ()->{
			editor.numPalabras();
		} );
		
	}
	/*FALLA
	 * 
	 * el salto de linea se cuenta como si fuera una palabra
	 * */
	@Test
	public void emptyList() throws EmptyCollectionException {
		editor.leerFichero("path2.txt");
		System.out.println(editor.getLinea(1));
		assertEquals(0, editor.numPalabras());
	}
	@Test
	public void oneElement() throws EmptyCollectionException {
		editor.leerFichero("path4.txt");
		assertEquals(1, editor.numPalabras());
	}
	
	//extras
	
	/*FALLA
	 */
	@Test
	public void twoEmptyList() throws EmptyCollectionException {
		editor.leerFichero("path3.txt");
		System.out.println(editor.getLinea(1));
		assertEquals(0, editor.numPalabras());
	}
	
	@Test
	public void severalElements() throws EmptyCollectionException {
		editor.leerFichero("path6.txt");
		assertEquals(5, editor.numPalabras());
	}
	
	
}
