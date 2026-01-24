[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/JahSbUK2)
# 🛒 Assn04: Monast`Array` (ArrayLists Under the Hood!)

## 📘 Project Overview

In this project, you will **recreate the core behavior of Java’s `ArrayList`** using a **plain Java array**. You’ll then use your custom list to model a realistic shopping scenario involving items, shopping lists, and shopping carts.

This assignment blends **data structures**, **object-oriented design**, and **problem-solving**—all essential computer science skills! For a thorough overview of how your work will be graded, refer to the grading rubric file (also located in the Google Classroom post for this assignment): `Student_Rubric.pdf`

---

## 🔍 Background: How Does an `ArrayList` Actually Work?

You’ve already been introduced to Java’s `ArrayList`, which can be declared and initialized as follows:

```java
ArrayList<String> names = new ArrayList<>();
names.add("Alex");
```

It may *seem* magical—but under the hood, an `ArrayList` turns out **not** to be magical at all...

### What’s Really Happening?

* An `ArrayList` stores elements in a **regular array**
* These arrays have a **fixed size**
* When the array fills up:

  * A **new, larger array** is created
  * Existing elements are **copied over**
  * The old array is discarded

In this project, **you will implement this logic yourself** using:

* An array
* A `size` variable (number of actual items)
* A `capacity` variable (representing the array length)

By the end of this project, you’ll understand *exactly* what happens when you call `add()` on an `ArrayList`.

---

## 🧩 Interfaces & `implements` (A Sneak Peek 👀)

In this project, you'll also see something new:

```java
public class ShoppingList implements MyList
```

### What is an Interface?

An **interface** defines a set of methods that a class **must** implement.
It’s like a **contract**:

> “If you say you implement this interface, you promise to write these methods.”

### What Does `implements` Do?

* This keyword signifies that your class agrees to follow the interface’s rules
* The compiler checks that all required methods exist

⚠️ **Note:** Interfaces were recently removed from the AP CSA curriculum (sadly 😢), but they are **extremely important in real-world Java**, so these concepts. So, these concepts give you a **head start**, but are not something you’re expected to fully master yet.

---
## 🧠 Explanation & Reflection (Required)

Before diving into the code specifications for this requirement, you must include a **brief explanation of your thinking**—either in your project README or directly in your code comments.

In your explanations, be sure to:

* **Explain what your program does** at a high level
* **Explain why your logic works**, especially for array resizing, shifting elements, and shopping logic
* **Mention any challenges, assumptions, or design decisions** you made along the way

Remember: **clear explanation is part of AP-level reasoning**, not just correct output! The goal is to show that you understand *why* your solution works—not just that it does. This is part of your grade!

You may write this explanation in:

* A separate student reflection file (optional), located in:

  ```
  src/main/resources/STUDENT_README.md
  ```
* Or through clear, well-written comments in your code

Choose the format that best represents your thinking clearly and professionally.

---
## 🧱 Classes You Must Implement

You will implement the following **four classes**:

1. `ShoppingItem`
2. `ShoppingList` (implements `MyList`)
3. `ShoppingCart`
4. `Main`

Each class has **specific behaviors and constraints**, similar to an AP Free Response Question.

---

## 🧺 Class 1: `ShoppingItem`

### Purpose

Represents a single item in a store.

### Required Attributes

* Item name
* Item price (stored **in pennies**)
* Whether or not the item is sold

### Required Behaviors

#### `buy()`

* Marks the item as sold
* If already sold, nothing changes
* Once sold, **cannot be “unbought”**

#### `equals(ShoppingItem other)`

* Returns `true` **if and only if**:

  * The item's `name` is the same as `other`'s
  * The item's `price` is the same as `other`'s 

#### `compareTo(ShoppingItem other)`

* If names are different:

  * Print: `"Error: Different items!"`
* If names are the same:

  * Return `0` if prices are equal
  * Return a **positive difference** (magnitude equal to the price difference) if this item is more expensive 
  * Return a **negative difference** (magnitude equal to the price difference) if this item is cheaper

#### Accessor Methods

* All attributes must be able to be accessed outside the class
* The **price getter must return a `double` in dollars**

---

## 📝 Class 2: `ShoppingList` (implements `MyList`)

### Purpose

A **custom ArrayList implementation** that stores `ShoppingItem` objects.

### Required Instance Variables

* `capacity` → `int`, initialized to `8`
* `size` → `int`, initialized to `0`
* `storage` → `ShoppingItem[]`, starting with length `8`

---

### Required Methods

#### `addToEnd(ShoppingItem item)`

* Appends `item` to the end
* If full, double capacity using the `makeCapacity` method you will implement

#### `insertAt(int index, ShoppingItem item)`

* Shifts items right to make space
* Prints `"Invalid index!"` if `index` < 0 or > `size`
* Increases capacity if needed

#### `removeAt(int index)`

* Removes item and shifts remaining items left
* Prints `"Invalid index!"` if `index` < 0 or > `size`

#### `getAt(int index)`

* Returns item at index
* Prints `"Invalid index!"` if `index` < 0 or > `size`

#### `getSize()`

* Returns number of stored items

---

### Capacity Management Methods

#### `makeCapacity(int minCapacity)`

* Does nothing if:

  * `minCapacity <= size`
  * `minCapacity == capacity`
* Otherwise:

  * The capacity of the list must be changed to either 8 or `minCapacity` (whichever is greater)
  * Create new array
  * Copy elements
  * Replace old storage

#### `trimExcess()`

* This method will remove any excess capacity by simply calling the `makeCapacity` method with an argument value that is equal to the current size of this list.


---

### Shopping-Specific Methods

#### `goShopping()`

* Buys **all items** in this list

#### `goShopping(ShoppingList toBuy)`

* Buys only items **common to both lists**

#### `totalPrice()`

* Returns total cost of all items in this list

#### `isIdentical(ShoppingList other)`

* Returns `true` only if:

  * This list is the same size as other
  * This list contains the same items as other (order does **not** matter)
#### Accessors
* All attributes must be accessible outside the class


---

## 🛒 Class 3: `ShoppingCart`

### Purpose

Represents a shopper’s cart.

### Required Attributes

* Associated `ShoppingList`
* Customer name
* Whether or not the shopping mission is complete
* **Total** number of `ShoppingCarts` returned

### Constructors

* If no `ShoppingList` provided:

  * Initialize with an empty `ShoppingList`

---

### Required Methods

#### `isCompleted()`

* Returns `true` only if **all items in the `ShoppingList` are bought**

#### `returnCart()`

* Can only return a cart if:

  * The associated shopping list is completed
* Once returned:

  * Counts toward total returned carts
  * Cannot be returned again

#### Accessors

* All attributes must be accessible outside the class

---

## ▶️ Class 4: `Main`

Your `main` method must accomplish **all** of the following:

### Step 1: Create Shopping Lists

#### `breakfastEssentials` must consist of:

* eggs → $3.50
* zucchini → $2.75
* frozen berries → $5.15
* smoked salmon → $9.99

#### `dormRun` must consist of:

* eggs → $3.50
* tissues → $1.00
* zucchini → $2.75
* frozen berries → $5.15
* smoked salmon → $9.99

🚨 While building these lists, you **must demonstrate** that:

* `addToEnd`
* `insertAt`
* `removeAt`

#### all work as intended!
---

### Step 2: Compare Lists

1. Check if `dormRun` and `breakfastEssentials` are identical using the appropriate method
2. Print an appropriate message to indicate *no.1*

---

### Step 3: Modify & Shop

* Remove `tissues` and `smoked salmon` from `dormRun`
* Then buy:
  * eggs
  * smoked salmon
* Print an appropriate message to declare whether or not `dormRun` is completed

---

### Step 4: Finish Shopping

* Buy all items in `breakfastEssentials`
* Print the number of carts returned
* Attempt to return both carts
* Print number of carts returned again

---

### Step 5: compareTo Demo

* Compare:

  * First item of `breakfastEssentials`
  * Third item of `dormRun`
* Print the returned value

---

### Step 6: Final Summary Output

Print a clean, creative summary such as:

> “DormRun’s cart includes the following items: eggs, zucchini, frozen berries for a total of $11.40. It is completed!”

📌 Formatting is up to you—be creative! However, it must clearly reflect the object’s state.

---

## ✅ Final Notes

* Follow method names **exactly**
* Console messages must match specifications
* Think like the AP grader: **clarity, correctness, completeness**

Good luck, coding Jedi—and enjoy building your own `ArrayList` from scratch! 💪📚
