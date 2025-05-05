# Assignment 5: Grid World Navigation
Course     : Data Structures (CSCI‑UA 102, Sec 7)
Instructor : Max Sklar
Author     : Anushay Anjum

## RUNBOOK

1. Compile all sources

   cd src
   javac *.java

2. Run the pre‑built test suite

   java GridWorldTest

3. Generate & solve random puzzles

   # 20 × 20 grid with 20 % blocked cells
   java RandomPuzzleGenerator 20 20 0.2 | java GridWorld

   # Stress‑test on a tall grid (100 000 × 20, 20 % blocked)
   java RandomPuzzleGenerator 100000 20 0.2 | java GridWorld

> Successful runs print the solved grid and a **PASS** verdict for each puzzle in `GridWorldTest`.

## TIME SPENT

Roughly one week total (spread out while recovering from illness).

## NOTES

* Direction‑iteration pitfalls: earlier versions stepped into blocked cells or looped. Guarding every candidate move with both bounds‐ and blockage‑checks fixed it.
* Edge‑case testing: the 100 000 × 20 stress test confirmed the solver fits within a 4 GB heap.
* All changes confined to `PathFinder.java`; the rest of the skeleton is unmodified.

## RESOURCES & ACKNOWLEDGEMENTS

* Oracle Java Docs (standard‑library reference)
* No external code copied; full implementation written and tested by the author.