# Base
JVM:
Java source (.java) -javac-> Bytecode (.class) -JVM classloader-> Execution (interpretation +  "just-in-time"=JIT compilation)

implements vs extends?
range
streams
some hotkeys
protected | public etc

Core library:
* File Read\write; parse CSV into objects
* Networking, httpclient
* pseudorandom generation
* logging

Debugging

## Java Type System
* Interfaces


# data structures
* arrays
* linked lists
* stacks
* queues 
* trees
* graphs
* hash tables


# Algorithms
* Sorting & Searching
* Recursion
* Graphs
* Greedy


# space/time complexity


# OOP Patterns
* Singleton
* Factory
* Builder


# concurrency

Whenever Thread:start() this creates OS thread. This OS thread exec() - a new copy of JVM bytecode interpreter. It starts execution at the run() (Thread.run() method) it has their access to CPU controlled by OS scheduler. In modern versions of java runtime-management concurrency has appeared. (fire and forget) this management depends on the runtime.
Objects are visible by default. Because of muttability and object visibility (heap sharing between threads), it raises complexity for concurrent Java programs.

* Syncronized
* Volatile - run-until-shutdown(graceful completion)
* Locking?
* Monitors?

## exceptions


## memory management
Memory occupied by object. When it is not needed - garbage collector. GC relies on mark-and-sweer algorithm.
Needs to be discovered.