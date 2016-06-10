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
public class ThreeFrameTranslationCheckTest {
    
    public ThreeFrameTranslationCheckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ThreeFrameTranslationCheck.
     */
    @Test
    public void createOutput() throws Exception {
        String transLine = ">ENSRNOT00000068149 cdna:known chromosome:RGSC3.4:13:1120899:1121213:-1 gene:ENSRNOG00000043314 gene_biotype:protein_coding transcript_biotype:protein_coding	CAAGAGGCTTTGTCCGGATCCGAGGTCAAAATGCAAATCTTCGTGAAGACCCTGACCGGCAAGACCATCACCCTGGAGGTGGAGCCCAGTGACACCATCAAGAACGTGAAGGCCAAGATCCAGGATAAGGAGGGCATCCCCCCTGACCAGCAGAGGCTCATCTTTGCCGGCAAGCAGCTGGAAGATGGCCGCACCCTCTCTGACTACAACATCCAGAAAAAGTCAACCCTGCACCTAGTCCTCCGCCTGAGG";
        String protLine = ">ENSRNOP00000063300 pep:known chromosome:RGSC3.4:13:1120899:1121213:-1 gene:ENSRNOG00000043314 transcript:ENSRNOT00000068149 gene_biotype:protein_coding transcript_biotype:protein_coding	QEALSGSEVKMQIFVKTLTGKTITLEVEPSDTIKNVKAKIQDKEGIPPDQQRLIFAGKQLEDGRTLSDYNIQKKSTLHLVLRLR";
        int startIndex = 0;
        int stopIndex = 84; 
        int frame = 0;
        System.out.println("main");
        String[] args = null;
        ThreeFrameTranslationCheck instance = new ThreeFrameTranslationCheck();
        String result = instance.createOutput(transLine, protLine, startIndex, stopIndex, frame);
        System.out.println(result);
    }
    
}
