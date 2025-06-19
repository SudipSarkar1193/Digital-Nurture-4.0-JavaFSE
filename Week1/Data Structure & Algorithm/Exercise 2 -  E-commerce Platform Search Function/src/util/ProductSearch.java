
package util;

import model.Product;
import java.util.List;

public class ProductSearch {

    // Linear Search by productName (after/before sorting) 
    // Time complexity : O(n) 
    //Space complexity : O(1) 

    public static Product linearSearchByName(List<Product> products, String targetName) {
        if (products == null || targetName == null) {
            return null;
        }
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search by productName (ONLY after sorting)
    // Time complexity : O(log(n)) 
    // Space complexity : O(1)
    public static Product binarySearchByName(List<Product> products, String targetName) {
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midName = products.get(mid).getProductName();
            int comparison = midName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }
}
