package com.practica.cajablancatest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;


public class SustituirPalabraTest {

	private Editor editor= new Editor();
    private static final String SOURCE_PATH = TestUtils.ROOT_PATH + "SustituirPalabraTest/";
	
	/*path 1*/
	@Test
	public void emptyEditor() throws EmptyCollectionException {

		System.out.println(editor.editIsEmpty()); 
		editor.sustituirPalabra("any", "any1");
		assertTrue(editor.editIsEmpty());
		
	}
	/*path 2*/
	@Test
	public void oneEmptyList() throws EmptyCollectionException {

		editor.leerFichero(SOURCE_PATH + "path2.txt");	
		String linea1=editor.getLinea(1).toString();
		editor.sustituirPalabra("any", "any1");
		assertEquals(linea1, editor.getLinea(1).toString());
		
	}
	/*path 3*/
	@Test
	public void twoEmptyList() throws EmptyCollectionException {
		editor.leerFichero(SOURCE_PATH + "path3.txt");	
		String linea1=editor.getLinea(1).toString();
		String linea2=editor.getLinea(2).toString();
		editor.sustituirPalabra("any", "any1");
		assertEquals(linea1, editor.getLinea(1).toString());
		assertEquals(linea2, editor.getLinea(2).toString());

	}
	
	// PRUEBAS EXTRA
	@ParameterizedTest(name="prueba {index}")
	@CsvSource(delimiter=':', value= {
		"extra1sustituir.txt:[foo, foo1, foo2]:[foo3, foo4]:[foo5, changed]:[foo6, foo7, foo8]",
		"extra2sustituir.txt:[foo1, changed, changed]:[foo2, changed]:[foo3, changed]:[changed, changed, foo4]"
	})
	public void extra( ArgumentsAccessor args) throws ArgumentAccessException, EmptyCollectionException {
		//String arrayDeLineas[]=new String[editor.size()];
		editor.leerFichero(SOURCE_PATH + args.getString(0));
		editor.sustituirPalabra("target", "changed");
		
		for (int i = 1; i < args.size(); i++) {
			assertEquals(args.getString(i), editor.getLinea(i).toString()); 
		}

	}
	
	/*path 4*/
	@Test
	public void four() throws EmptyCollectionException {
		editor.leerFichero(SOURCE_PATH + "path4.txt");
		editor.sustituirPalabra("foo", "palabra");
		assertEquals("[palabra]", editor.getLinea(1).toString());		
	}
	
	/*path 5*/
	@Test
	public void five() throws EmptyCollectionException {
		editor.leerFichero(SOURCE_PATH + "path5.txt");
		String linea1=editor.getLinea(1).toString();
		editor.sustituirPalabra("palabra", "any");
		assertEquals(linea1, editor.getLinea(1).toString());
		
	}
	
	
	
}
