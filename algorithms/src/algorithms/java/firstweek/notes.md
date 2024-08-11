## Introduction
Algorithm -> method of solving a problem
Data structure -> method to store information 

## Union-find problems
Is a set of algorithms to solve a dynamic connectivity problems. There are `Quick find` and `Quick union` algorithms and data structures. 
There are a similar appproaches but in case of `Quick find` data stored in linear manner and  and `Quick union` data stored as a tree and 

### Quick-find 
* Data stored in linear manner
* Easy to find whether component belongs to the group
* In merging it changes all entries that belong to the group

### Quick-union
* Data stored as a tree
* In merging it changes only root component
* On find it have to check all entries are belongs to the same group

### Improvements
* Weighted quick-union

Note: When the size of one tree is bigger or equal than size of another tree, it means the size of tree can doubles at most Log(n) times.

## Assignment results

```
Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   PASSED

Correctness:  27/38 tests passed
Memory:       8/8 tests passed
Timing:       20/20 tests passed

Aggregate score: 82.63%
```

[Full summary](./assignment-summary.md)