# Java Product Recommendation System

This project uses **Apache Mahout** to build a basic recommendation engine in Java.

##  Features

- Collaborative filtering using user-based similarity
- Recommendation based on user preferences
- Simple CSV-based data model
- Uses Apache Mahout libraries

##  Files

| File | Description |
|------|-------------|
| `ProductRecommender.java` | Main Java file using Mahout for recommendations |
| `data.csv` | Sample user-product rating data |
| `README.md` | Project documentation |

## How to Run

1. Make sure you have **Apache Mahout** and dependencies added to your project.
   - Use Maven or manually include Mahout JAR files.

2. Compile:
```bash
javac -cp .:mahout-core-0.9.jar ProductRecommender.java
```

3. Run:
```bash
java -cp .:mahout-core-0.9.jar ProductRecommender
```

> Replace `:` with `;` on Windows for classpath

##  Sample Output

```
Recommended product ID: 104 (Score: 4.2)
 Recommended product ID: 105 (Score: 3.8)
```

---

##  Concepts Used

- Pearson Correlation Similarity
- Nearest N Neighborhood
- Apache Mahout Taste Recommender

##  Author

Mohit Kumar | July 2025
