# E-commerce Platform Search Functionality

This project implements search functionality for an E-commerce platform using Linear Search and Binary Search algorithms. It is s part of DSA assignment of week-1

# Folder Structure 

- **bin/**: Contains compiled `.class` files.
- **output/**: Contains a screenshot of the program output (`E-commerce_Search.png`).
- **src/**: Contains all Java source code organized into packages:
  - `model/Product.java`: Model class representing a product with `productId`, `productName`, and `category`.
  - `service/ProductService.java`: Service class responsible for managing product list and loading data from CSV.
  - `util/ProductMergeSort.java`: Utility class containing manual implementation of Merge Sort algorithm for sorting products by `productName`.
  - `util/ProductSearh.java`: Utility class containing both Linear Search and Binary Search implementations for product name searching.
  - `Main.java`: Main entry point of the application for user interaction, loading data, performing search, and showing results.
- **src/products.csv**: CSV file containing **150 product records** loaded into the system at runtime.
  
## Big O Notation and Algorithm Analysis

Big O notation is a mathematical representation used to describe the upper bound of an algorithm's running time or space complexity as a function of input size (`n`). It provides a standardized way to analyze and compare algorithm efficiency, focusing on the `worst-case` scenario while also considering best and average cases.

- **Purpose**: Helps evaluate how an algorithm scales with larger inputs, enabling developers to choose optimal solutions for performance-critical applications like e-commerce search.
- **Key Insight**: Ignores constants and lower-order terms (e.g., O(2n) simplifies to O(n)), focusing on dominant growth rates.

## Assignment Summary

This project implements a simple e-commerce product search functionality using core Java, following proper software design principles.

The user searches for products based on **product name**. The search system implements:

- **Manual Merge Sort (O(n log n))** to sort product list based on `product name`.
- **Linear Search (O(n))** and **Binary Search (O(log n))** algorithms for searching.
- **Time measurement** for both search algorithms to demonstrate their efficiency.

**Note** - We are using a CSV file containing 150 product records. The product data is loaded into memory using the following method call:

```java
  productService.loadProductsFromCSV("src/products.csv");

```


## 🔧 Key Features

✅ Load product data from a CSV file (`products.csv`)  
✅ Sort products by **product name** using **custom Merge Sort**  
✅ Perform both **Linear Search** and **Binary Search**  
✅ Measure and display **execution time** for both search approaches  
✅ Fully modular package structure following real-world software architectu


## Search Operation Scenarios

The project implements two search algorithms: Linear Search and Binary Search. Below are their time complexities for different scenarios when searching by `productName` in an array of products.

### Linear Search
- **Description**: Sequentially checks each element until a match is found or the array is exhausted.
- **Time Complexities**:
  - **Best Case**: O(1) – Target is the first element.
  - **Average Case**: O(n) – Target is typically in the middle, requiring half the array to be scanned on average.
  - **Worst Case**: O(n) – Target is the last element or not present, requiring a full scan.
- **Space Complexity**: O(1) – Uses only a constant amount of extra space.

### Binary Search
- **Description**: Requires a sorted array and repeatedly divides the search interval in half, comparing the middle element to the target.
- **Time Complexities**:
  - **Best Case**: O(1) – Target is the middle element on the first comparison.
  - **Average Case**: O(log n) – Requires logarithmic steps to narrow down to the target.
  - **Worst Case**: O(log n) – Target is at the edge of the array or not present, still requiring logarithmic steps.
- **Prerequisite**: Array must be sorted, which incurs a one-time O(n log n) cost using Merge Sort.
- **Space Complexity**: O(1) for iterative implementation (used here).

## Algorithm Comparison

- **Linear Search**:
  - **Time Complexity**: O(n) for average and worst cases.
  - **Advantages**: Simple, works on unsorted data, no preprocessing required.
  - **Disadvantages**: Inefficient for large datasets, as performance degrades linearly with array size.
- **Binary Search**:
  - **Time Complexity**: O(log n) for average and worst cases, but requires O(n log n) for sorting upfront.
  - **Advantages**: Highly efficient for large datasets, logarithmic scaling ensures fast searches.
  - **Disadvantages**: Requires sorted data, incurring a sorting cost if the array isn’t pre-sorted.
- **Key Trade-off**: Linear Search is better for small or unsorted datasets with infrequent searches, while Binary Search excels for large, sorted datasets with frequent searches.

## Suitability for E-commerce Platform

For an e-commerce platform with a large product catalog (e.g., thousands of products) and frequent user searches, **Binary Search** is the more suitable algorithm:

- **Performance**: O(log n) search time significantly outperforms O(n), especially for large `n`. For example, searching 10,000 products takes ~14 comparisons with Binary Search vs. ~10,000 with Linear Search (worst case).
- **Sorting Cost**: The O(n log n) cost of Merge Sort is incurred once (or when products are added), but this is amortized over multiple searches, making it negligible for frequent queries.
- **Real-world Context**: E-commerce platforms prioritize fast search response times to enhance user experience. Binary Search’s logarithmic complexity aligns with this need, assuming products can be maintained in sorted order by `productName`.
- **Scalability**: As the product catalog grows, Binary Search’s performance advantage becomes more pronounced, ensuring scalability.

In conclusion, while Linear Search is simpler and viable for small catalogs, Binary Search is the optimal choice for an e-commerce platform due to its efficiency and suitability for large-scale, frequent search operations.