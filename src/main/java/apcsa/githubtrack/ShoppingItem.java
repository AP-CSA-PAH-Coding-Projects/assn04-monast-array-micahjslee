package apcsa.githubtrack;


// Implement your ShoppingItem class here

public class ShoppingItem{

private String name;
private int price; // in pennies
private boolean sold;

public ShoppingItem(String name, int price)  // constructor that sets up name and price, and sets sold to false by default
{
    this.name = name;
    this.price = price;
    this.sold = false;
}

public void buy()   // this method marks the item as sold
{
    sold = true; // sets sold to true
}

public boolean equals(ShoppingItem other)      // this method returns true if the item's name and price are equal
{
    if(this.name.equals(other.name) && this.price == other.price) // checks if name and price are equal
    {
        return true; // returns true if both are equal
    }
    else
    {
        return false; // returns false if both are not equal
    }
}

public int compareTo(ShoppingItem item)    // compares two items if they have the same name, returning positive if the item costs more, negative if it costs less, and zero if the price is the same. Prints an error message if they have different names.
{
    if(this.name.equals(item.name)) // same name
    {
        if(this.price > item.price) // this item costs more
        {
            return this.price - item.price;
        }
        else if(this.price < item.price) // this item costs less
        {
            return this.price - item.price;
        }
        else // prices are equal
        {
            return 0;
        }
    }
    else // different names
    {
        System.out.println("Error: Different items!");
        return 0;
    }
}

public boolean isSold()   // returns whether the item has been sold
{
    return sold; // returns the boolean variable sold
}

public String getName()  // returns the name of the item
{
    return name; // returns the variable name
}

public double getPrice()  // returns the price of the item in dollars
{
    double priceInDollars = (double)price / 100; // converts price from pennies to dollars
    return priceInDollars; // returns price in dollars
}

}