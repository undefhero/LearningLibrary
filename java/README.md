# base
implements vs extends?


# algorithms


# space/time complexity


# data structures


# Patterns


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