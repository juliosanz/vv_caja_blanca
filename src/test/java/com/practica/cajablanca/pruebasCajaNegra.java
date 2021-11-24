package com.practica.cajablanca;

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

public class pruebasCajaNegra {

	private static AbstractSingleLinkedListImpl<AbstractSingleLinkedListImpl<String>> editor;
	private static SingleLinkedListImpl<String> unElemento;

	
	/*
	 * En el beforeAll asignamos valores al hashMap que usaremos
	 * en algunos de los metodos, por lo que tambien instanciamos
	 * cada una de las listas.
	 */
	
	@Test
	@BeforeAll
	static void setUp() {
	editor = new SingleLinkedListImpl<AbstractSingleLinkedListImpl<String>>();	
	unElemento = new SingleLinkedListImpl<String>("A");
	}
	
	@Test
	@BeforeEach
	public void init() {
		editor = new SingleLinkedListImpl<AbstractSingleLinkedListImpl<String>>();	
		unElemento = new SingleLinkedListImpl<String>("A");
		
	}	
	
	@DisplayName("Testea size Parametrizado")
	@ParameterizedTest()
	@CsvSource({
	"3",
	"2",
	"1",
	"0"
	})
	public void sizeTest(int key) {
		if(key == 0) {
			assertEquals(0, editor.size());
		} else {
		editor.addNTimes(unElemento, key);
		assertEquals(key, editor.size());
		}
	}
	
	
	
	
	
}
