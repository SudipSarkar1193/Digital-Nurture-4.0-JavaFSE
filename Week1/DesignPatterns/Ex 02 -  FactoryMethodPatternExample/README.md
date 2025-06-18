# Factory Method Pattern Example

This project demonstrates the implementation of the **Factory Method Pattern** in Java for a document management system that creates different types of documents (Word, PDF, Excel).


## 📁 Project Structure

- **bin/**: Contains compiled `.class` files.
- **output/**: Contains a screenshot of the program output
- **src/**: Contains source `.java` files.
  - `Main.java`: Entry point for testing the Factory Method Pattern.
  - `documents/`: Package for different types of document classes.
    - `Document.java`: Interface representing a generic document.
    - `WordDocument.java`: Concrete class for Word documents.
    - `PdfDocument.java`: Concrete class for PDF documents.
    - `ExcelDocument.java`: Concrete class for Excel documents.
  - `factories/`: Package for factory classes.
    - `DocumentFactory.java`: Abstract factory class with the `createDocument()` method.
    - `WordDocumentFactory.java`: Factory for creating Word documents.
    - `PdfDocumentFactory.java`: Factory for creating PDF documents.
    - `ExcelDocumentFactory.java`: Factory for creating Excel documents.


## Steps Implemented
1. **Created a New Java Project**:
   - Initialized a Java project named `FactoryMethodPatternExample`.
2. **Defined Document Classes**:
   - Created a `Document` interface or abstract class to define common behavior for all document types.
3. **Created Concrete Document Classes**:
   - Implemented `WordDocument`, `PdfDocument`, and `ExcelDocument` classes that extend or implement the `Document` interface/abstract class.
4. **Implemented the Factory Method**:
   - Defined an abstract `DocumentFactory` class with the `createDocument()` method.
   - Created concrete factory classes (`WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`) that override `createDocument()` to return specific document instances.
5. **Tested the Factory Method Implementation**:
   - Developed a `FactoryMethodTest` class to demonstrate the creation and usage of different document types using the factory method.



## Output
```bash

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\DesignPatterns\Ex 02 -  FactoryMethodPatternExample> javac -d bin -cp bin src\documents\Document.java src\documents\WordDocument.java src\documents\PdfDocument.java src\documents\ExcelDocument.java src\factories\DocumentFactory.java src\factories\WordDocumentFactory.java src\factories\PdfDocumentFactory.java src\factories\ExcelDocumentFactory.java src\Main.java
PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\DesignPatterns\Ex 02 -  FactoryMethodPatternExample> java -cp bin Main


Opening a Word document...
Opening a PDF document...
Opening an Excel document.


PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\DesignPatterns\Ex 02 -  FactoryMethodPatternExample>

```

## Purpose
This project illustrates the **Factory Method Pattern**, which provides a way to delegate the instantiation of objects to subclasses, promoting flexibility and extensibility in object creation.