package com.practica.cajablancatest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;

public class GetLineaIsEmptyTest {

  private static Editor editor;
  // refactorizar la cte de abajo para centralizarla en otra clase TODO
  private static final String SOURCE_PATH = "./src/test/misc/mayorLongitud/";

  @BeforeEach
  public void init() {
    editor = new Editor();
  }

  @Test
  public void testGetLineaVacio() throws Exception {
    assertThrows(EmptyCollectionException.class, () -> {
      editor.getLinea(0);
    });
    assertThrows(EmptyCollectionException.class, () -> {
      editor.getLinea(1);
    });
  }

  @Test
  public void testGetLineaRangoInvalido() throws Exception {
    editor.leerFichero(SOURCE_PATH + "TestGetLinea.txt");
    assertThrows(IllegalArgumentException.class, () -> {
      editor.getLinea(-1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      editor.getLinea(editor.size() + 1);
    });
  }

  // ERROR DE LA IMPLEMENTACION DEL EDITOR
  // la lista que implementa el editor comienza en 1 y la logica
  // del editor no contempla este caso ya que para el editor comienza a contar en
  // 0
  @Test
  public void testGetLineaRangoValido() throws Exception {
    editor.leerFichero(SOURCE_PATH + "TestGetLinea.txt");
    try {
	    assertEquals(editor.getLinea(0).toString(), "[HOLA, ADIOS]");
	    assertEquals(editor.getLinea(1).toString(), "[HOLAADIOS]");
	    assertEquals(editor.getLinea(editor.size() - 1).toString(), "[]");
	    assertEquals(editor.getLinea(editor.size()).toString(), "[IPSUM]");
    }
    catch(IllegalArgumentException e)
    {
    	fail("IllegalArgumentException");
    }

  }

  @Test
  public void testIsEmpty() {
    assertTrue(editor.editIsEmpty());
    editor.leerFichero(SOURCE_PATH + "TestGetLinea.txt");
    assertFalse(editor.editIsEmpty());
  }

}
