package LAbCODE;


import java.util.ArrayList;
import java.util.List;

interface Packing {
String pack();
    
}

class bottle implements Packing
{
    public String pack()
    {
        return "bottle";
    }

}
class wrapper implements Packing
{
    public String pack()
    {
        return "wrapper";
    }

}

interface Iteam {

    String name();
    float price();
    Packing packing();
}

abstract class burger implements Iteam {
    public  Packing packing()
    {
            return new wrapper();
    }

    public abstract float price();
}

abstract class  ClodDrink  implements Iteam{

    public Packing packing()
    {
        return new bottle();
    }
    public abstract float price();
    
}

class VegitableBurger extends  burger
{

    public String name ()
    {
        return "vegitable burger";
    }
    public float price()
    {
        return 40.5f;
    }

}

class chickenBurger extends burger
{
    public String name ()
    {
        return "chicken burger";
    }
    public float price()
    {
        return 43.4f;
    }
}

class pepsi extends ClodDrink{

    public String name()
    {
        return "Pepsi";
    }
 public float price()
 {
    return 20.4f;
 }
}

class coke extends ClodDrink
{
    public String name()
    {
        return  "coke";
    }
    public float price()
    {
        return 40.4f;
    }
}


class meal {

    private List<Iteam>items = new ArrayList<>();
    
    public void AddIteams(Iteam i)
    {
        items.add(i);
    }
    public float getprice()
    {
        float cost = 0;
        for(Iteam i : items)
        {
            cost+=i.price();
        }

        return cost;
    }

    public void ShowIteams()
    {
       for(Iteam i : items)
       {
         System.out.println("Name OF iteams : " + i.name());
        System.out.println("price of this iteams   " + i.price());
        System.out.println("Packing of this : "+ i.packing().pack());
       }
    }

    
}

class Mealbuilder {
    public meal vegitableMeal()
    {
        meal meal = new meal();
        meal.AddIteams(new coke());
        meal.AddIteams(new VegitableBurger());

        return meal ;
    }

    public meal NonvegitableMeal()
    {
        meal meal = new meal();
        meal.AddIteams(new pepsi());
        meal.AddIteams(new chickenBurger());

        return meal ;
    }
}


public class MealBuilder {

    public static void main(String[] args)
    {
        Mealbuilder Mealbuilder = new Mealbuilder();
        meal  vegi = Mealbuilder.vegitableMeal();
        System.out.println("___________vegitable___________________");
        vegi.ShowIteams();
        System.out.println("total cost = " + vegi.getprice());
        System.out.println("___________________________________________");


        meal nonvegi = Mealbuilder.NonvegitableMeal();
        System.out.println("____________npn vegitable --------------");
        nonvegi.ShowIteams();
        System.out.println("Total cost = " + nonvegi.getprice());
        
    }
    
}
