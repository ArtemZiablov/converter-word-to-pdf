package ua.karazin.convert;

import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class WordToPdfConverter {

    public void convertDocAndDocxToPdf(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        // Create office manager
        OfficeManager officeManager = LocalOfficeManager.builder().build();

        try {
            // Start the office manager
            officeManager.start();

            // Create a document converter
            DocumentConverter converter = LocalConverter.builder().officeManager(officeManager).build();

            // Convert the document
            converter.convert(inputFile).to(outputFile).execute();

            System.out.println("Conversion completed successfully!");

        } catch (OfficeException e) {
            e.printStackTrace();
            System.err.println("Conversion failed: " + e.getMessage());
        } finally {
            try {
                // Stop the office manager
                officeManager.stop();
            } catch (OfficeException e) {
                e.printStackTrace();
            }
        }
    }

   /* public void convertDocxToPdf(String inputPath, String outputPath)  {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        // Create office manager
        OfficeManager officeManager = LocalOfficeManager.builder().build();

        try {
            // Start the office manager
            officeManager.start();

            // Create a document converter
            DocumentConverter converter = LocalConverter.builder().officeManager(officeManager).build();

            // Convert the document
            converter.convert(inputFile).to(outputFile).execute();

            System.out.println("Conversion completed successfully!");

        } catch (OfficeException e) {
            e.printStackTrace();
            System.err.println("Conversion failed: " + e.getMessage());
        } finally {
            try {
                // Stop the office manager
                officeManager.stop();
            } catch (OfficeException e) {
                e.printStackTrace();
            }
        }
    }*/
}
