/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joelhunn
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    public KassapaateTest() {
        
    }
    
    @Before
    public void setUp() {
        kassa=new Kassapaate();
        kortti=new Maksukortti(1000);
    }
    
    @Test
    public void alkuTestiSaldolle(){
        assertEquals(100000,kassa.kassassaRahaa());
        
    }
    
    @Test
    public void alkuTestiMyynnille(){
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        
    }
    @Test
    public void edullisestiKateinenEdullistenmaara(){
        int maksu =240;
        if(maksu>=240){
            kassa.syoEdullisesti(maksu);
            assertEquals(1,kassa.edullisiaLounaitaMyyty());
            
        }
        
        
    }
    @Test
    public void maukkaastiKateinenMaukkaidenmaara(){
        int maksu = 400;
        if(maksu>=400){
            kassa.syoMaukkaasti(maksu);
            assertEquals(1,kassa.maukkaitaLounaitaMyyty());
        }
        
        
    }
    @Test
    public void maukkaastiKateinenMaksu(){
        int maksu= 500;
        int vaihtoraha;
        if(maksu>=400){
            vaihtoraha=kassa.syoMaukkaasti(maksu);
            assertEquals(100400,kassa.kassassaRahaa());
            assertEquals(vaihtoraha, maksu-400);
        }
    }    
        
    @Test
    public void edullisestiKateinenMaksu(){
        int maksu= 500;
        int vaihtoraha;
        if(maksu>=240){
            vaihtoraha=kassa.syoEdullisesti(maksu);
            assertEquals(100240,kassa.kassassaRahaa());
            assertEquals(vaihtoraha, maksu-240);
        }  
    }
    
    @Test
    public void edullisestiKateineneiriita(){
        int maksu= 230;
        int vaihtoraha;
      
            vaihtoraha=kassa.syoEdullisesti(maksu);
            assertEquals(100000,kassa.kassassaRahaa());
            assertEquals(vaihtoraha, maksu);
            assertEquals(0,kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void maukkaastiKateineneiriita(){
        int maksu= 230;
        int vaihtoraha;
      
            vaihtoraha=kassa.syoMaukkaasti(maksu);
            assertEquals(100000,kassa.kassassaRahaa());
            assertEquals(vaihtoraha, maksu);
            assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    } 
    @Test
    public void maukkaastiKortilRiittaaRaha(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(600,kortti.saldo());
        assertEquals(1,kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000,kassa.kassassaRahaa());
        
    }
    @Test
    public void edullisestiKortilRiittaaRaha(){
        kassa.syoEdullisesti(kortti);
        assertEquals(760,kortti.saldo());
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
        assertEquals(100000,kassa.kassassaRahaa());
    }
    @Test
    public void maukkaastiAMEERIKANEXPRESS(){
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(280,kortti.saldo());
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000,kassa.kassassaRahaa());
    }
    @Test
    public void edullisestiAMEERICANEXPRESS(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(200,kortti.saldo());
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        assertEquals(100000,kassa.kassassaRahaa());
    }
    @Test
    public void latausTesti(){
        int summa=200;
        
        kassa.lataaRahaaKortille(kortti, summa);
        assertEquals(1200, kortti.saldo());
        assertEquals(100200,kassa.kassassaRahaa());
        
        
    }
    @Test
    public void latausTesti2(){
        int summa=-200;
        
        kassa.lataaRahaaKortille(kortti, summa);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000,kassa.kassassaRahaa());
        
        
    }
    
        
}