package apcsa.githubtrack;

// Implement the ShoppingList class here

public class ShoppingList implements MyList {
    
    private ShoppingItem[] items; // storage
    private int size; // current size
    private int capacity; // current maximum capacity

    public ShoppingList() // capacity initialized to 8, storage starts with size 8, size starts at 0
    {   
        capacity = 10;
        items = new ShoppingItem[capacity];
        size = 0;
    }

    public void addToEnd(Object item) // this method adds item to end of list (debug console said to use Object type for parameter)
    {
        ShoppingItem shoppingItem = (ShoppingItem) item; // casts Object to ShoppingItem (Debug console said this will fix error message)
        if(size == capacity)
        {
            makeCapacity(capacity * 2); // doubles capacity if size equals capacity
        }
        items[size] = shoppingItem; // adds shoppingItem to end of the list
        size++; // increases size by 1
    }

    public void insertAt(int index, Object item) // this method inserts item at index, and again, debug console said to use Object as a parameter
    {
        if(index < 0 || index > size) // checks if index is in bounds
        {
            System.out.println("Invalid index!");
        }
        else
        {
            ShoppingItem shoppingItem = (ShoppingItem) item; // casts Object to ShoppingItem (Again, debug console said this will fix error message)
            if(size == capacity)
            {
                makeCapacity(capacity * 2); // doubles capacity if size equals capacity
            }
            for(int i = size; i > index; i--) // shifts elements to the right to make space for item, starting from the end of the list
            {
                items[i] = items[i - 1];
            }
            items[index] = shoppingItem; // inserts shoppingItem at index
            size++; // increases size by 1
        }
    }

    public void removeAt(int index) // method removes item at index
    {
        if(index < 0 || index > size) // checks if index is in bounds
        {
            System.out.println("Invalid index!");
        }
        else
        {
            for(int i = index; i < size - 1; i++) // shifts elements to the left to fill the gap left by the removed item
            {
                items[i] = items[i + 1];
            }
            size--; // decreases size by 1
        }
    }

    public ShoppingItem getAt(int index) // method returns ShoppingItem object at index
    {
        if(index < 0 || index > size || items[index] == null) // checks if index is in bounds
        {
            System.out.println("Invalid index!");
            ShoppingItem invalid = new ShoppingItem("Invalid index!", 0); // creates dummy ShoppingItem to return
            return invalid; // returns dummy ShoppingItem
        }
        else
        {
            return items[index]; // returns item at index
        }
    }

    public int getSize() // method returns size instance variable
    {
        return size; // returns the current size of the list (number of stored items)
    }

    public void makeCapacity(int minCapacity)
    {
        if (minCapacity != capacity && (minCapacity > size || minCapacity < capacity)) // only makes changes if minCapacity is greater than size and different from current capacity
        {
            if(minCapacity < 8) // if minCapacity is less than 8, it gets set to 8
            {
                minCapacity = 8;
            }
            ShoppingItem[] newItems = new ShoppingItem[minCapacity]; // new array with size minCapacity
            for(int i = 0; i < size; i++) // copies elements from old array to new array
            {
                newItems[i] = items[i];
            }
            this.items = newItems; // sets the array items to newItems
            this.capacity = minCapacity; // adjusts capacity variable (size does not change because we added capacity and not items)
        }
    }

    public void trimExcess() // this uses makeCapacity to set the capacity to size
    {
        
        makeCapacity(size);
    }

    public void goShopping() // method buys all items in list
    {
        for(int i = 0; i < size; i++) // loops through array
        {
            if (items[i] != null) // checks to make sure element isn't null
            {
                items[i].buy(); // buys items
            }
        }
    }

    public void goShopping(ShoppingList toBuy) // method buys all items in toBuy list that are also in this list
    {
        for(int i = 0; i < toBuy.getSize(); i++) // loops through full toBuy list
        {
            ShoppingItem itemToBuy = toBuy.getAt(i); // gets every item in toBuy
            for(int j = 0; j < size; j++) // loops through "items" array
            {
                if(items[j].equals(itemToBuy)) // checks that the item in items list equals the item in toBuy
                {
                    items[j].buy(); // buys the item if they're equal
                }
            }
        }
    }

    public double getTotalPrice() // method returns total price of all items in list
    {
        double total = 0.0; // counter variable
        for(int i = 0; i < size; i++) // loops through array
        {
            if (items[i] != null) // checks if element is null
            {
                total += items[i].getPrice(); // adds price of each item to total
            }
        }
        return total; // returns total price
    }

    public int getCapacity() // method returns capacity instance variable
    {
        return capacity; // returns current capacity of the list
    }

    public boolean isIdentical(ShoppingList other) // method checks if two ShoppingLists are identical
    {
       boolean found = false; // boolean variable to track if item is found in other list
        if(this.size != other.size) // checks if sizes are different
        {
            return false; // returns false
        }
        else
        {
            for(int i = 0; i < size; i++) // loops through array for each item
            {
                for(int j = 0; j < other.size; j++) // loops through complete other array for each item first array
                {
                    if(this.items[i].equals(other.items[j])) // checks if items are equal
                    {
                        found = true; // sets found to true if item is found
                    }
                }
                if(found == false) // if item was not found in other list
                {
                    return false; // returns false
                }
            }
            return true; // returns true if all items are equal
        }
    }

}
