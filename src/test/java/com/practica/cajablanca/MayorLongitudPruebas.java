package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class MayorLongitudPruebas {

  private static Editor editor;
  private static final String SOURCE_PATH = "./src/test/misc/mayorLongitud/";

  @BeforeAll
  public static void init() {
    editor = new Editor();
  }

//PATH1
  @Test
  public void mayorLongTestPath1() {
    assertThrows(EmptyCollectionException.class, () -> {
      editor.mayorLongitud();
    });
  }

//PATH3
  @Test
  public void mayorLongTestPath3() {
    editor.leerFichero(SOURCE_PATH + "MayorLongitudPath3.txt");
    try{assertTrue(editor.mayorLongitud()=="null");
    } catch (EmptyCollectionException e) {
    	Assert.fail();
    }
  }

//PATH5
  @Test
  public void mayorLongTestPath5() {
    editor.leerFichero(SOURCE_PATH + "MayorLongitudPath5.txt");
    try {
      assertEquals(editor.mayorLongitud(), "HOLA");
    } catch (EmptyCollectionException e) {
      Assert.fail();
    }
  }

//Extra1
  @Test
  public void mayorLongTestExtra1() {
    editor.leerFichero(SOURCE_PATH + "MayorLongitudExtra1.txt");
    try {
      assertEquals(editor.mayorLongitud(), "ADIOS");
    } catch (EmptyCollectionException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }

//Extra2
  @Test
  public void mayorLongTestExtra2() {
    editor.leerFichero(SOURCE_PATH + "MayorLongitudExtra2.txt");
    try {
      assertEquals(editor.mayorLongitud(), "ADIOS");
    } catch (EmptyCollectionException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }

//Extra3
  @Test
  public void mayorLongTestExtra3() {
    editor.leerFichero(SOURCE_PATH + "MayorLongitudExtra3.txt");
    try {
      assertEquals(editor.mayorLongitud(), "HOLAADIOS");
    } catch (EmptyCollectionException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }
}