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

---
# Output 

## Output 1

```bash
PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 2 -  E-commerce Platform Search Function> javac -d bin src\Main.java src\model\Product.java src\service\ProductService.java src\util\ProductMergeSort.java src\util\ProductSearch.java
PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 2 -  E-commerce Platform Search Function> java -cp bin Main
Products :

Product{ID=1, Name='Laptop Pro', Category='Electronics'}
Product{ID=2, Name='Smartphone X', Category='Electronics'}
Product{ID=3, Name='Wireless Headphones', Category='Accessories'}
Product{ID=4, Name='Running Shoes', Category='Fashion'}
Product{ID=5, Name='Graphic Novel', Category='Books'}
Product{ID=6, Name='Desk Lamp', Category='Home'}
Product{ID=7, Name='Yoga Mat', Category='Sports'}
Product{ID=8, Name='Action Figure', Category='Toys'}
Product{ID=9, Name='Smart Watch', Category='Accessories'}
Product{ID=10, Name='Bluetooth Speaker', Category='Electronics'}
Product{ID=11, Name='Casual Jacket', Category='Fashion'}
Product{ID=12, Name='Mystery Book', Category='Books'}
Product{ID=13, Name='Coffee Maker', Category='Home'}
Product{ID=14, Name='Tennis Racket', Category='Sports'}
Product{ID=15, Name='Board Game', Category='Toys'}
Product{ID=16, Name='Tablet', Category='Electronics'}
Product{ID=17, Name='Denim Jeans', Category='Fashion'}
Product{ID=18, Name='Science Fiction Book', Category='Books'}
Product{ID=19, Name='Table Fan', Category='Home'}
Product{ID=20, Name='Soccer Ball', Category='Sports'}
Product{ID=21, Name='Building Blocks', Category='Toys'}
Product{ID=22, Name='Wireless Mouse', Category='Accessories'}
Product{ID=23, Name='T-shirt', Category='Fashion'}
Product{ID=24, Name='History Book', Category='Books'}
Product{ID=25, Name='Bookshelf', Category='Home'}
Product{ID=26, Name='Basketball', Category='Sports'}
Product{ID=27, Name='Puzzle Set', Category='Toys'}
Product{ID=28, Name='USB Charger', Category='Electronics'}
Product{ID=29, Name='Sweater', Category='Fashion'}
Product{ID=30, Name='Biography Book', Category='Books'}
Product{ID=31, Name='Kitchen Mixer', Category='Home'}
Product{ID=32, Name='Golf Club', Category='Sports'}
Product{ID=33, Name='Stuffed Animal', Category='Toys'}
Product{ID=34, Name='Wireless Keyboard', Category='Accessories'}
Product{ID=35, Name='Dress Shirt', Category='Fashion'}
Product{ID=36, Name='Fantasy Book', Category='Books'}
Product{ID=37, Name='Wall Clock', Category='Home'}
Product{ID=38, Name='Baseball Glove', Category='Sports'}
Product{ID=39, Name='Card Game', Category='Toys'}
Product{ID=40, Name='Smart TV', Category='Electronics'}
Product{ID=41, Name='Leather Belt', Category='Accessories'}
Product{ID=42, Name='Romance Book', Category='Books'}
Product{ID=43, Name='Table Runner', Category='Home'}
Product{ID=44, Name='Swimming Goggles', Category='Sports'}
Product{ID=45, Name='Robot Toy', Category='Toys'}
Product{ID=46, Name='Portable Charger', Category='Electronics'}
Product{ID=47, Name='Skirt', Category='Fashion'}
Product{ID=48, Name='Thriller Book', Category='Books'}
Product{ID=49, Name='Floor Lamp', Category='Home'}
Product{ID=50, Name='Jump Rope', Category='Sports'}
Product{ID=51, Name='Doll House', Category='Toys'}
Product{ID=52, Name='Earphones', Category='Accessories'}
Product{ID=53, Name='Hoodie', Category='Fashion'}
Product{ID=54, Name='Poetry Book', Category='Books'}
Product{ID=55, Name='Curtains', Category='Home'}
Product{ID=56, Name='Football', Category='Sports'}
Product{ID=57, Name='Remote Control Car', Category='Toys'}
Product{ID=58, Name='Smart Thermostat', Category='Electronics'}
Product{ID=59, Name='Scarf', Category='Fashion'}
Product{ID=60, Name='Non-fiction Book', Category='Books'}
Product{ID=61, Name='Coffee Table', Category='Home'}
Product{ID=62, Name='Volleyball', Category='Sports'}
Product{ID=63, Name='Building Kit', Category='Toys'}
Product{ID=64, Name='Fitness Tracker', Category='Accessories'}
Product{ID=65, Name='Blazer', Category='Fashion'}
Product{ID=66, Name='Self-help Book', Category='Books'}
Product{ID=67, Name='Desk Organizer', Category='Home'}
Product{ID=68, Name='Tennis Ball', Category='Sports'}
Product{ID=69, Name='Play Dough', Category='Toys'}
Product{ID=70, Name='Webcam', Category='Electronics'}
Product{ID=71, Name='Tie', Category='Fashion'}
Product{ID=72, Name='Cookbook', Category='Books'}
Product{ID=73, Name='Throw Pillow', Category='Home'}
Product{ID=74, Name='Badminton Racket', Category='Sports'}
Product{ID=75, Name='Action Toy', Category='Toys'}
Product{ID=76, Name='External Hard Drive', Category='Electronics'}
Product{ID=77, Name='Cap', Category='Fashion'}
Product{ID=78, Name='Travel Book', Category='Books'}
Product{ID=79, Name='Wall Art', Category='Home'}
Product{ID=80, Name='Skateboard', Category='Sports'}
Product{ID=81, Name='Toy Train', Category='Toys'}
Product{ID=82, Name='Smart Bulb', Category='Electronics'}
Product{ID=83, Name='Sunglasses', Category='Accessories'}
Product{ID=84, Name='Children?s Book', Category='Books'}
Product{ID=85, Name='Area Rug', Category='Home'}
Product{ID=86, Name='Cycling Helmet', Category='Sports'}
Product{ID=87, Name='Toy Soldier', Category='Toys'}
Product{ID=88, Name='Wireless Router', Category='Electronics'}
Product{ID=89, Name='Backpack', Category='Fashion'}
Product{ID=90, Name='Art Book', Category='Books'}
Product{ID=91, Name='Table Cloth', Category='Home'}
Product{ID=92, Name='Boxing Gloves', Category='Sports'}
Product{ID=93, Name='Puppet', Category='Toys'}
Product{ID=94, Name='Portable Speaker', Category='Electronics'}
Product{ID=95, Name='Wallet', Category='Accessories'}
Product{ID=96, Name='Classic Book', Category='Books'}
Product{ID=97, Name='Picture Frame', Category='Home'}
Product{ID=98, Name='Gym Bag', Category='Sports'}
Product{ID=99, Name='Toy Car', Category='Toys'}
Product{ID=100, Name='Headset', Category='Electronics'}



Enter product name to search: Smart Headset

Linear Search: Product Not Found.
Linear Search Time: 3699300 ns


Binary Search: Product Not Found.
Binary Search Time: 41200 ns

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 2 -  E-commerce Platform Search Function>

```

## output 2

```bash

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 2 -  E-commerce Platform Search Function> java -cp bin Main

Products :

Product{ID=1, Name='Laptop Pro', Category='Electronics'}
Product{ID=2, Name='Smartphone X', Category='Electronics'}
Product{ID=3, Name='Wireless Headphones', Category='Accessories'}
Product{ID=4, Name='Running Shoes', Category='Fashion'}
Product{ID=5, Name='Graphic Novel', Category='Books'}
Product{ID=6, Name='Desk Lamp', Category='Home'}
Product{ID=7, Name='Yoga Mat', Category='Sports'}
Product{ID=8, Name='Action Figure', Category='Toys'}
Product{ID=9, Name='Smart Watch', Category='Accessories'}
Product{ID=10, Name='Bluetooth Speaker', Category='Electronics'}
Product{ID=11, Name='Casual Jacket', Category='Fashion'}
.
.
.
.
.
Product{ID=86, Name='Cycling Helmet', Category='Sports'}
Product{ID=87, Name='Toy Soldier', Category='Toys'}
Product{ID=88, Name='Wireless Router', Category='Electronics'}
Product{ID=89, Name='Backpack', Category='Fashion'}
Product{ID=90, Name='Art Book', Category='Books'}
Product{ID=91, Name='Table Cloth', Category='Home'}
Product{ID=92, Name='Boxing Gloves', Category='Sports'}
Product{ID=93, Name='Puppet', Category='Toys'}
Product{ID=94, Name='Portable Speaker', Category='Electronics'}
Product{ID=95, Name='Wallet', Category='Accessories'}
Product{ID=96, Name='Classic Book', Category='Books'}
Product{ID=97, Name='Picture Frame', Category='Home'}
Product{ID=98, Name='Gym Bag', Category='Sports'}
Product{ID=99, Name='Toy Car', Category='Toys'}
Product{ID=100, Name='Headset', Category='Electronics'}



Enter product name to search: Gym BaG

Linear Search: Product Found: Product{ID=98, Name='Gym Bag', Category='Sports'}
Linear Search Time: 4850600 ns


Binary Search: Product Found: Product{ID=98, Name='Gym Bag', Category='Sports'}
Binary Search Time: 20300 ns

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 2 -  E-commerce Platform Search Function>

```