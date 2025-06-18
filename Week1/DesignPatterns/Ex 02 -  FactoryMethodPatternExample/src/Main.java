import factories.*;
import documents.Document;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.createDocument();
        excel.open();

        System.out.println();
        System.out.println();
    }
}
