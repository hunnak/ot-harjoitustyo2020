package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortinSaldoAlussaOikein(){
       assertEquals(10, kortti.saldo());
    }
    @Test
    public void saldoKasvaaoikein(){
        kortti.lataaRahaa(20);
        assertEquals(30,kortti.saldo());
    }
    
    @Test
    public void vaheneeOikein(){
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void riittaakorahna(){
       boolean palautusarvo = kortti.otaRahaa(11);
       assertFalse(palautusarvo);
       assertEquals(10,kortti.saldo());
              
    }
    @Test
    public void riittaarahna(){
       boolean palautusarvo = kortti.otaRahaa(10);
       assertTrue(palautusarvo);
       assertEquals(0,kortti.saldo());
              
    }     
    @Test
    public void toStringTest(){
        assertEquals("saldo: 0.10",kortti.toString());
    }
    
}
