package apcsa.githubtrack;

// Implement your Main class (with the main method) here
public class Main {
    public static void main(String[] args) { // main method

        ShoppingList breakfastEssentials = new ShoppingList(); // creates new ShoppingList object
        breakfastEssentials.addToEnd(new ShoppingItem("Eggs", 350)); // adds item to end of list
        ShoppingItem Zucchini = new ShoppingItem("Zucchini", 275); // creates new ShoppingItem object
        breakfastEssentials.insertAt(1, Zucchini); // inserts Zucchini at index 1
        ShoppingItem FrozenBerries = new ShoppingItem("Frozen Berries", 515); // creates new ShoppingItem object
        breakfastEssentials.insertAt(2, FrozenBerries); // inserts FrozenBerries at index 2
        ShoppingItem SmokedSalmon = new ShoppingItem("Smoked Salmon", 999); // creates new ShoppingItem object
        breakfastEssentials.addToEnd(SmokedSalmon); // adds SmokedSalmon to end of list
        ShoppingItem Bacon = new ShoppingItem("Bacon", 450); // creates new ShoppingItem object (testing remove feature)
        breakfastEssentials.insertAt(1, Bacon); // inserts Bacon at index 1
        breakfastEssentials.removeAt(1); // removes item at index 1
        ShoppingCart breakfastCart = new ShoppingCart("Micah", breakfastEssentials); // creates new ShoppingCart object

        ShoppingList dormRun = new ShoppingList(); // creates new ShoppingList object
        ShoppingItem Eggs = new ShoppingItem("Eggs", 350); // creates new ShoppingItem object
        dormRun.addToEnd(Eggs); // adds eggs to end of list
        ShoppingItem Tissues = new ShoppingItem("Tissues", 100); // creates new ShoppingItem object
        dormRun.addToEnd(Tissues); // adds tissues to end of list
        dormRun.addToEnd(Zucchini); // adds zucchini to end of list
        dormRun.addToEnd(FrozenBerries); // adds frozen berries to end of list
        dormRun.addToEnd(SmokedSalmon); // adds smoked salmon to end of list
        ShoppingCart dormCart = new ShoppingCart("Emilia", dormRun); // creates new ShoppingCart object

        System.out.println(breakfastEssentials.isIdentical(dormRun)); // checks if breakfastEssentials and dormRun are identical and prints out the result

        dormRun.removeAt(1); // removes tissues from dormRun
        dormRun.removeAt(4); // removes smoked salmon from dormRun
        dormRun.getAt(0).buy(); // buys eggs
        dormRun.getAt(4).buy(); // buys smoked salmon (which has been removed)
        System.out.println(dormCart.isCompleted()); // checks if dormCart is completed and prints out the result
        breakfastEssentials.goShopping(); // buys all items in breakfastEssentials
        System.out.println(breakfastCart.isCompleted()); // checks if breakfastCart is completed and prints out the result
        System.out.println(ShoppingCart.getTotalCartsReturned()); // prints total carts returned
        breakfastCart.returnCart(); // returns breakfastCart
        dormCart.returnCart(); // returns dormCart
        System.out.println(ShoppingCart.getTotalCartsReturned()); // prints total carts returned

        System.out.println(breakfastEssentials.getAt(1).compareTo(dormRun.getAt(3))); // compares the first item in breakfastEssentials to the third item in dormRun and prints out the result

        // prints a summary:
        System.out.println("breakfastCart contains: Eggs, Zucchini, Frozen Berries, Smoked Salmon for a total of $" + breakfastEssentials.getTotalPrice());
        System.out.println("dormCart contains: Eggs, Tissues, Zucchini, Frozen Berries, Smoked Salmon for a total of $" + dormRun.getTotalPrice());

    }
}