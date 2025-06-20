
package util;

import model.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductMergeSort {

    public static void sortProductsByName(List<Product> products) {
        if (products == null || products.size() <= 1) {
            return;
        }
        mergeSort(products, 0, products.size() - 1);
    }

    private static void mergeSort(List<Product> products, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(products, start, mid);
        mergeSort(products, mid + 1, end);
        merge(products, start, end);
    }

    private static void merge(List<Product> products, int start, int end) {
        int mid = (start + end) / 2;

        int leftArrayLen = mid - start + 1;
        int rightArrayLen = end - mid;

        List<Product> left = new ArrayList<>();
        List<Product> right = new ArrayList<>();

        for (int i = start; i <= mid; i++) {
            left.add(products.get(i));
        }
        for (int i = mid + 1; i <= end; i++) {
            right.add(products.get(i));
        }

        int i = 0, j = 0, k = start;

        while (i < leftArrayLen && j < rightArrayLen) {
    
            if (left.get(i).getProductName().compareToIgnoreCase(right.get(j).getProductName()) <= 0) {
                products.set(k++, left.get(i++));
            } else {
                products.set(k++, right.get(j++));
            }
        }

        while (i < leftArrayLen) {
            products.set(k++, left.get(i++));
        }

        while (j < rightArrayLen) {
            products.set(k++, right.get(j++));
        }
    }
}
