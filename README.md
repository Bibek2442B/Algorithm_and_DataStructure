# Academic Class Management System

A Java-based academic cohort management application backed by a custom generic, self-sorting linked list data structure. The project demonstrates core object-oriented principles, custom Abstract Data Types (ADTs), and balanced student distribution algorithms.

---

## Overview

Managing academic cohorts requires dynamic allocation rules based on student demographics and balanced class sizing. This system models students, classes, and administrative enrollment rules without relying on built-in Java collection frameworks, utilizing an underlying custom-built generic linked list that enforces natural ordering and duplicate prevention.

---

## Key Features

- **Custom Generic Data Structure (`LinkedSortedList<E>`)**:
  - Implements a sorted linked list maintaining permanent natural ordering upon insertion (`O(N)` insertion, `O(1)` best-case retrieval/iteration).
  - Enforces duplicate prevention without Java standard collections (`java.util.List` / `Set`).
  - Implements the `SortedList<E>` ADT interface with strict generic constraints (`E extends Comparable<E>`).

- **Domain Entity Modeling**:
  - Object-oriented hierarchy distinguishing domestic (`Aluno_pt`) and international (`Aluno_en`) student profiles.
  - Automatic identifier assignment for cohorts using alphabetical sequence (`Class A`, `Class B`, etc.).

- **Automated Distribution & Rebalancing**:
  - **Class Generation**: Instantiates $n \ge 2$ classes and partitions international students into a dedicated cohort (`Class A`) while evenly distributing domestic students across remaining classes.
  - **Dynamic Rebalancing**: Safely drops the terminal class (retaining $\ge 2$ active cohorts) and recalculates student allocations across remaining sections.
  - Formatted terminal outputs for class-by-class student rosters.

---

## Architecture & Class Design

| Class / Interface | Responsibility |
|---|---|
| `SortedList<E>` | ADT interface specifying sorted list behavior and contract operations. |
| `LinkedSortedList<E>` | Node-based generic linked list managing sorted sequential data without duplicates. |
| `Aluno` | Abstract base student entity tracking registration ID and name with `Comparable` sorting. |
| `Aluno_pt` / `Aluno_en` | Concrete implementations modeling domestic and international student types. |
| `Turma` | Represents an individual class cohort containing a sorted roster of enrolled students. |
| `AED` | Central controller orchestrating student registrations, cohort generation, and redistribution. |

---

## Tech Stack

- **Language**: Java (SE 17+)
- **Build / IDE**: Apache Ant / NetBeans compatible structure
- **Documentation**: Javadoc-compliant annotations across all domain classes

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher

