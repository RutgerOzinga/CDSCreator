/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdscreator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rutger
 */
public class ThreeFrameTranslationTest {
    
    public ThreeFrameTranslationTest() {
    }

    /**
     * Test of codonToAminoAcid method, of class ThreeFrameTranslation.
     */
    @Test
    public void testCodonToAminoAcid() {
        System.out.println("codonToAminoAcid");
        String mRNA = "ATGGATGCATTCGTGAAC";
        int frame = 0;
        ThreeFrameTranslation instance = new ThreeFrameTranslation();
        String expResult = "MDAFVN";
        String result = instance.codonToAminoAcid(mRNA, frame);
        assertEquals(expResult, result);
    }
    
}
