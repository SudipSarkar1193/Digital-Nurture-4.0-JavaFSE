
import model.Product;
import service.ProductService;
import util.ProductSearch;
import util.ProductMergeSort;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        productService.loadProductsFromCSV("src/products.csv");

        List<Product> productList = productService.getProducts();
  

        System.out.println("Products : ");
        System.out.println();
        for (Product p : productList) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter product name to search: ");
        String searchName = scanner.nextLine().trim();

        long linearStart = System.nanoTime();
        Product linearResult = ProductSearch.linearSearchByName(productList, searchName);
        long linearEnd = System.nanoTime();

        System.out.println();
        if (linearResult != null) {
            System.out.println("Linear Search: Product Found: " + linearResult);
        } else {
            System.out.println("Linear Search: Product Not Found.");
        }
        System.out.println("Linear Search Time: " + (linearEnd - linearStart) + " ns");
        System.out.println();

        // Sort products by productName using Merge sort
        ProductMergeSort.sortProductsByName(productList);
        // Perform Binary Search with timing
        long binaryStart = System.nanoTime();
        Product binaryResult = ProductSearch.binarySearchByName(productList, searchName);
        long binaryEnd = System.nanoTime() ;

        System.out.println();
        if (binaryResult != null) {
            System.out.println("Binary Search: Product Found: " + binaryResult);
        } else {
            System.out.println("Binary Search: Product Not Found.");
        }
        System.out.println("Binary Search Time: " + (binaryEnd - binaryStart) + " ns");
        System.out.println();

        scanner.close();
    }
}
