package com.practica.cajablanca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cajanegra.EmptyCollectionException;

public class MayorLongitudPruebas {

  private static Editor editor;

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
  public void mayorLongTestPath2() {
    editor.leerFichero("MayorLongitudPath3.txt");
    assertThrows(EmptyCollectionException.class, () -> {
      editor.mayorLongitud();
    });
  }

//PATH5
  @Test
  public void mayorLongTestPath5() {
    editor.leerFichero("MayorLongitudPath5.txt");
    try {
      assertEquals(editor.mayorLongitud(), "HOLA");
    } catch (EmptyCollectionException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }

//Extra1
  @Test
  public void mayorLongTestExtra1() {
    editor.leerFichero("MayorLongitudExtra1.txt");
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
    editor.leerFichero("MayorLongitudExtra2.txt");
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
    editor.leerFichero("MayorLongitudExtra3.txt");
    try {
      assertEquals(editor.mayorLongitud(), "HOLAADIOS");
    } catch (EmptyCollectionException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }
}