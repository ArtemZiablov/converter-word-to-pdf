# Word to PDF Converter

This project is a Spring Boot application that converts `.doc` and `.docx` Word files into PDF format using the JODConverter library.

## Libraries Used

The project includes the following key dependencies:

- **Spring Boot Starter**: Provides core Spring Boot functionality.
- **JODConverter (Core and Local)**: A library used for converting different document formats (e.g., Word to PDF). It integrates with LibreOffice to perform the conversions.

## Requirements

- **LibreOffice**: The application relies on LibreOffice to perform the document conversions. Ensure that LibreOffice is installed on your machine and its path is added to the system's environment variables.

## How it Works

1. The `WordToPdfConverter` class handles the conversion process.
2. It uses the `OfficeManager` from JODConverter to start and manage the LibreOffice service.
3. The `convertDocAndDocxToPdf` method accepts an input file (Word format) and converts it into PDF format using `DocumentConverter`.
4. The converted PDF is saved to the specified output location.

The program automatically converts example `.doc` and `.docx` files to PDF when executed.
