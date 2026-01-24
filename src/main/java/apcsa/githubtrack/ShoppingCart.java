package apcsa.githubtrack;

// Implement your ShoppingCart class here
public class ShoppingCart {
    private ShoppingList list; // storage for shopping list
    private String name; // customer name
    private boolean complete; // whether or not the mission is complete
    private boolean isReturned; // whether or not the cart can be returned
    private static int returned = 0; // static variable to keep track of total carts returned

    public ShoppingCart(String name, ShoppingList list) // constructor
    {
        this.name = name; // sets customer name
        this.list = list; // sets shopping list
        this.complete = false; // sets complete to false by default
        this.isReturned = false; // sets isReturned to false by default
    }

    public ShoppingCart(String name) // constructor with no ShoppingList
    {
        this.name = name; // sets customer name
        this.list = new ShoppingList(); // initializes list to an empty shopping list
        this.complete = false; // complete set to false by default
        this.isReturned = false; // isReturned set to false by default
    }

    public boolean isCompleted() // returns true if all items in ShoppingList are bought
    {
        for(int i = 0; i < list.getSize(); i++) // loops through ShoppingList
        {
            if(list.getAt(i).isSold() == false) // checks if any item is not sold (gets the object at list position i and checks if it's sold using ShoppingItem's method)
            {
                return false; // returns false if any item is not sold
            }
        }
        complete = true; // sets complete to true if all items are sold
        return true; // returns true if all items are sold
    }

    public void returnCart() // method to return cart
    {
        if(isCompleted() && isReturned == false) // checks if cart is complete and has not been returned yet
        {
            ShoppingCart.returned++; // adds 1 to total carts returned
            isReturned = true; // sets returned variable to true
        }
    }

    public static int getTotalCartsReturned() // static method to get total carts returned (called with class name)
    {
        return ShoppingCart.returned; // returns total carts returned
    }

    public String getName() // method to get customer name
    {
        return name; // returns customer name
    }

}
