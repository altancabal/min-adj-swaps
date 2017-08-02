# min-adj-swaps

Java project to get the similarity value between 2 surnames (Latin alphabet upper cased strings) by calculating the minimum number of adjacent character swaps required to make the two strings the same.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Install [Java](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)
* [Clone](https://help.github.com/articles/cloning-a-repository/) this project.


### Compile and run

In the cloned directory in your machine, compile the code by doing:

```
javac SwapDistance.java
```

Then run it

```
java SwapDistance
```

The expected output is the following

```
("ABCDEF", "ABCDEF") returns 100
("ABCDEF", "BBCDEF") returns 0
("BBDCEF", "BBCDEF") returns 95
("HARRIS", "HARIRS") returns 95
("HARRIS", "HRARIS") returns 95
("BACDFE", "ABCDEF") returns 90
("ABCFDE", "ABCDEF") returns 90
("ANNE", "ENNA") returns 75
("FEDCBA", "ABCDEF") returns 25
("GFEDCBA", "ABCDEFG") returns 0
```

More details about compiling and running Java code [here](http://www.oracle.com/technetwork/java/compile-136656.html).

## Authors

* **[Altán Cabal](https://github.com/altancabal)**

