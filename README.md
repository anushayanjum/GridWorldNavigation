# Assignment 5: Grid World Navigation

**Course**: Data Structures (CSCI-UA 102, Section 7)  
**Instructor**: Max Sklar  
**Author**: Anushay Anjum  

---

## Table of Contents

1. [Runbook](#runbook)  
2. [Time Spent](#time-spent)  
3. [Notes](#notes)  
4. [Resources & Acknowledgements](#resources--acknowledgements)  

---

## Runbook

### 1. Compile All Sources

```bash
cd src
javac *.java
````

### 2. Run the Test Suite

```bash
java GridWorldTest
```

> A **PASS** verdict will appear for each puzzle in `GridWorldTest` upon success.

### 3. Generate & Solve Random Puzzles

* **20×20 grid, 20% blocked**

  ```bash
  java RandomPuzzleGenerator 20 20 0.2 | java GridWorld
  ```
* **Stress test: 100000×20 grid, 20% blocked**

  ```bash
  java RandomPuzzleGenerator 100000 20 0.2 | java GridWorld
  ```

---

## Time Spent

Roughly **one week**, spread out while recovering from illness.

---

## Notes

* **Direction-iteration pitfalls**
  Early attempts stepped into blocked cells or looped infinitely.
  *Fix:* Wrap each candidate move in both boundary and blockage checks.
* **Edge-case validation**
  The 100000×20 stress test confirmed memory usage stays under a 4 GB heap.
* **Scope of changes**
  All work confined to `PathFinder.java`; other skeleton files remain untouched.

---

## Resources & Acknowledgements

* [Oracle Java Documentation](https://docs.oracle.com/javase/8/docs/api/) — Standard-library reference
* No external code copied; implementation authored and tested end-to-end by Anushay Anjum.

