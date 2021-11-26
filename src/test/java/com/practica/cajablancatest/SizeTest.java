package com.practica.cajablancatest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import com.practica.cajablanca.Editor;

public class SizeTest {

	private static Editor testEditor;
	private static SingleLinkedListImpl<String> unElemento;

	private static final String SOURCE_PATH = "./src/test/misc/SizeTest/";
	
	/*
	 * En el beforeAll asignamos valores al hashMap que usaremos
	 * en algunos de los metodos, por lo que tambien instanciamos
	 * cada una de las listas.
	 */
	
	@Test
	@BeforeAll
	static void setUp() {
		testEditor = new Editor();	
		unElemento = new SingleLinkedListImpl<String>("A");
	}
	
	@Test
	@BeforeEach
	public void init() {
		testEditor = new Editor();	
		unElemento = new SingleLinkedListImpl<String>("A");
		
	}	
	
	@DisplayName("Testea size Parametrizado")
	@ParameterizedTest()
	@CsvSource({
	"3,size3.txt",
	"2,size2.txt",
	"1,size1.txt",
	"0,"
	})
	public void sizeTest(int key, String txt) {
		if(key == 0) {
			assertEquals(0, testEditor.size());
		} else {
		testEditor.leerFichero(SOURCE_PATH + txt);
		assertEquals(key, testEditor.size());
		}
	}
	
	
	
	
	
}
