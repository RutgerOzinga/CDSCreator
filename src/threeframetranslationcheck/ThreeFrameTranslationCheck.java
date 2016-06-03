/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threeframetranslationcheck;

import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author Rutger
 */
public class ThreeFrameTranslationCheck {

    /**
     * the line containing protein information.
     */
    private String proteinLine;
    /**
     * line containing the transcript information.
     */
    private String transcriptLine;
    /**
     * the path to the protein file.
     */
    private Path proteinPath;
    /**
     * path to the transcript file.
     */
    private Path transcriptPath;
    /**
     * path to the new transcript file.
     */
    private String newtranscriptPath;
    /**
     * path to the new protein file.
     */
    private String newproteinPath;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        ThreeFrameTranslationCheck check = new ThreeFrameTranslationCheck();
        check.run(args);
    }

    /**
     * runs the main classes for this program.
     *
     * @param args
     * @throws ParseException
     * @throws IOException
     */
    private void run(String[] args) throws ParseException, IOException {
        ParseCLI parse = new ParseCLI(args);
        newproteinPath = parse.getNewFilePath();
        newtranscriptPath = parse.getNewTranscriptFilePath();
        proteinPath = parse.getProtPath();
        transcriptPath = parse.getTransPath();
        checkThreeFrame();
    }

    /**
     * Checks the translation of the sequence in all three frames. Then matches
     * it with the protein sequence. If it matches the start stop and the cDNA
     * sequence are writen in a new file.
     *
     * @throws IOException
     */
    private void checkThreeFrame() throws IOException {
        int lineCount = 0;
        int xCount = 0;
        ThreeFrameTranslation translate = new ThreeFrameTranslation();
        FileReader readProteinFile = new FileReader(proteinPath);
        FileReader readTranscriptFile = new FileReader(transcriptPath);
        FileWriter write = new FileWriter();
        write.OpenFile(newtranscriptPath);
        while (readProteinFile.nextLine() && readTranscriptFile.nextLine()) {
            proteinLine = readProteinFile.getLine();
            transcriptLine = readTranscriptFile.getLine();
            //for all three frames.
            for (int frame = 0; frame <= 2; frame++) {
                String translation = translate.codonToAminoAcid(transcriptLine.split("\t")[1], frame);
                //if the sequence contains an X it is skipped.
                if (proteinLine.split("\t")[1].contains("X")) {
                    xCount++;
                    break;
                    //the translation is matched with the protein sequence.
                } else {
                    int index = translation.indexOf(proteinLine.split("\t")[1]);
                    //If the result is not -1 aka no match, then the start and the stop along with the frame and sequence are 
                    //writen in to a new file.
                    if (index != -1) {
                        int start = index;
                        int stop = index + proteinLine.split("\t")[1].length();
                        write.writeLine(createOutput(transcriptLine, proteinLine, start, stop, frame));
                        lineCount++;
                        break;
                    }
                }

            }

        }
        write.CloseFile();
    }

    /**
     * Creates an output line with the given variables.
     *
     * @param transcriptLine the transcript line
     * @param proteinLine the protein Line
     * @param startIndex the start of the cds sequence
     * @param stopIndex the stop of the cds sequence
     * @param frame the frame the cds sequence is found in.
     * @return the output line.
     */
    private String createOutput(String transcriptLine, String proteinLine, int startIndex, int stopIndex, int frame) {
        int transcriptStart = (startIndex * 3) + frame;
        int transcriptStop = (stopIndex * 3) + frame;
        String[] splittedProtLine = proteinLine.split("\t");
        String[] splittedTransLine = transcriptLine.split("\t");
        String[] splittedProtID = splittedProtLine[0].split(" ");
        String cdsSequence = splittedTransLine[1].substring(transcriptStart, transcriptStop);
        return splittedProtID[0] + " " + splittedProtID[4] + "\t" + splittedProtLine[1] + "\t" + cdsSequence;
    }
}
