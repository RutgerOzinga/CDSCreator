/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdscreator;

/**
 * 
 * @author Rutger
 */
public class ThreeFrameTranslation {
    
    private final  String mRNA = "TACGATCGCGCCGATCGCTACGATCGC"; 
    
    private static final String[] CODONS = {
        "TTT", "TTC", "TTA", "TTG", "TCT",
        "TCC", "TCA", "TCG", "TAT", "TAC", "TGT", "TGC", "TGG", "CTT",
        "CTC", "CTA", "CTG", "CCT", "CCC", "CCA", "CCG", "CAT", "CAC",
        "CAA", "CAG", "CGT", "CGC", "CGA", "CGG", "ATT", "ATC", "ATA",
        "ATG", "ACT", "ACC", "ACA", "ACG", "AAT", "AAC", "AAA", "AAG",
        "AGT", "AGC", "AGA", "AGG", "GTT", "GTC", "GTA", "GTG", "GCT",
        "GCC", "GCA", "GCG", "GAT", "GAC", "GAA", "GAG", "GGT", "GGC",
        "GGA", "GGG", "TGA", "TAG", "TAA"};

    private static final String[] AMINOS_PER_CODON = {
        "F", "F", "L", "L", "S", "S",
        "S", "S", "Y", "Y", "C", "C", "W", "L", "L", "L", "L", "P", "P",
        "P", "P", "H", "H", "Q", "Q", "R", "R", "R", "R", "I", "I", "I",
        "M", "T", "T", "T", "T", "N", "N", "K", "K", "S", "S", "R", "R",
        "V", "V", "V", "V", "A", "A", "A", "A", "D", "D", "E", "E", "G",
        "G", "G", "G", "*", "*", "*"};
    
    /**
     * Return the single-letter abbreviation for a codon, e.g., "F" for "TTT"
     * (phenylalanine) for each codon in the given sequence.
     * This method returns "X" if the parameter is a non-valid
     * codon.
     *
     * @param mRNA a string containing a aminoacid sequence.
     * @param frame the frame the translation is in.
     * @return the one-letter abbreviation for the codon, or "X" if the codon
     * isn't valid
     */
    public String codonToAminoAcid(String mRNA, int frame) {
        int i = frame;
        String result = "";
        while (i <= mRNA.length() - 3) {
            String triplet = mRNA.substring(i, i += 3);
            for (int k = 0; k < CODONS.length; k++) {
                if (CODONS[k].equals(triplet)) {
                    result += AMINOS_PER_CODON[k];
                }
            }
        }
        return result;
    }
}
