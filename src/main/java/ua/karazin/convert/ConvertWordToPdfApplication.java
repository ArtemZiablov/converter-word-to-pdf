package ua.karazin.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConvertWordToPdfApplication {

    @Autowired
    WordToPdfConverter wordToPdfConverter;

    public static void main(String[] args) {
        SpringApplication.run(ConvertWordToPdfApplication.class, args);
    }

    @Bean
    ApplicationRunner runner() {
        return args -> {

            String inputPath1 = "C:\\Users\\Artem\\Desktop\\Word Documents\\Iванов Михайло Андрiйович 211-22-05см.doc";
            String outputPath1 = "C:\\Users\\Artem\\Desktop\\PDF Documents\\from_doc_Iванов Михайло Андрiйович 211-22-05см.pdf";

            // convert doc file to pdf
            wordToPdfConverter.convertDocAndDocxToPdf(inputPath1, outputPath1);

            String inputPath2 = "C:\\Users\\Artem\\Desktop\\Word Documents\\Iванов Михайло Андрiйович 211-22-05см.docx";
            String outputPath2 = "C:\\Users\\Artem\\Desktop\\PDF Documents\\from_docx_Iванов Михайло Андрiйович 211-22-05см.pdf";

            // convert docx file to pdf
            wordToPdfConverter.convertDocAndDocxToPdf(inputPath2, outputPath2);

        };
    }
}
