package com.practica.cajablancatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

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
	
	@Test
	public void oneList() throws EmptyCollectionException {
		editor.leerFichero("extra1numpalabras.txt");
		assertEquals(5, editor.numPalabras());
	}
	// PRUEBAS EXTRA
	@ParameterizedTest(name="prueba {index}")
	@CsvSource(delimiter=':', value= {
		"extra1numpalabras.txt: 3",
		"extra2numpalabras.txt: 6"
	})
	public void extra( ArgumentsAccessor args) throws ArgumentAccessException, EmptyCollectionException {
		editor.leerFichero(args.getString(0));
		
		assertEquals(args.getInteger(1), editor.numPalabras());

	}
	
}
