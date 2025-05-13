# AI Algorithms in Java

> Hey Java enthusiasts! ☕ Here's my collection of AI algorithms from those endless nights when my IDE was open and my brain was running on caffeine overflow.

<p align="center">
  <img src="https://media.giphy.com/media/26gJAJQ1TD9pG4i0E/giphy.gif" alt="Java AI" width="300" />
</p>

## 🛠️ What's Inside

Behold, the AI algorithms that made me question my life choices:

<details>
<summary><b>🔍 Search Algorithms</b> - Navigating the solution space, one node at a time</summary>
<br>

| Algorithm | Description | File |
|-----------|-------------|------|
| **BFS** | Breadth-First Search - The methodical explorer that checks every floor before using the stairs | `BFS.java` |
| **DFS** | Depth-First Search - The adventurer that dives deep before coming up for air | `DFS.java` |
| **DFID** | Depth-First Iterative Deepening - When you can't decide between BFS and DFS | `DFID.java` |
| **UCS** | Uniform Cost Search - Like BFS with a budget calculator | `UCS.java` |
| **A*** | A-Star - The smart navigator with a map and a plan | `Astar.java` |
| **GBFS** | Greedy Best-First Search - Always chasing the closest goal without looking back | `GBFS.java` |
| **DLS** | Depth-Limited Search - DFS with a strict curfew | `DLS.java` |

</details>

<details>
<summary><b>⛰️ Hill Climbing</b> - The algorithm that never learned to look before it leaps</summary>
<br>

Local optimization algorithm implemented in true Java verbosity:
- Begins with an arbitrary solution
- Makes incremental improvements
- Gets stuck in local optima with remarkable consistency

```java
public Solution hillClimbing(Problem problem) {
    Solution current = problem.generateInitialSolution();
    while (true) {
        Solution neighbor = problem.getBestNeighbor(current);
        if (problem.evaluate(neighbor) <= problem.evaluate(current)) {
            return current;
        }
        current = neighbor;
    }
}
```

</details>

<details>
<summary><b>🧬 Genetic Algorithms</b> - Where code reproduction gets weird</summary>
<br>

Evolution-inspired approach with proper OOP principles:
- Maintains a population of `Chromosome` objects
- Uses interfaces like `FitnessEvaluator` and `SelectionStrategy`
- Implements crossover and mutation with factory patterns
- Everything is an AbstractFactoryBuilderVisitorSingleton because, well, Java

</details>

<details>
<summary><b>🧠 Prolog</b> - Logic programming that'll make you question your life choices 🤔</summary>
<br>

Python implementations of logic programming concepts:
- Knowledge representation
- Rule-based systems
- Logical inference

</details>

## ⚙️ Installation

```bash
# Clone this repository
git clone https://github.com/YourUsername/AI-codes-in-Java.git

# Navigate into the directory
cd AI-codes-in-Java

# No need for Maven - just compile with javac
javac *.java
```

## 🚀 How to Run

```bash
# Compile all Java files
javac *.java

# Run specific algorithms
java BFS
```

## 🐍 Python Version

Prefer Python's simplicity? No judgment (ok, maybe a tiny bit 😉)

<a href="https://github.com/Jia2005/AI-codes-in-Python">
  <img src="https://img.shields.io/badge/Check%20out-Python%20Version-blue?style=for-the-badge&logo=python" alt="Python Version" />
</a>

## 🤝 Contributing

Found a more elegant pattern? Know how to reduce the boilerplate? Share your wisdom!

```
1. Fork the repository
2. Create your feature branch: git checkout -b feature/AmazingImprovement
3. Commit your changes: git commit -m 'Add some AmazingImprovement'
4. Push to the branch: git push origin feature/AmazingImprovement
5. Submit a pull request
```

<p align="center">
  If this helped with your assignments or interview prep, consider giving it a star ⭐<br>
  It costs you nothing but means a lot (and feeds my validation-hungry developer soul)
</p>

## ⚠️ Disclaimer

This code was written during the wee hours when design patterns seemed like a good idea for everything. It works, it's educational, but in production it might just be overkill.

---

<div align="center">
  Made with ☕ (both Java and coffee) and an unhealthy dose of inheritance
</div>
