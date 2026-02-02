package LAbCODE;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temp);
}

class Weatherstation {

    private List<Observer> Observers = new ArrayList<>();
    private float temp;
    public void setTemp(float temp)
    {
        this.temp = temp;
        notifyObserve();
    }
    public void addObservers(Observer o)
    {
        Observers.add(o);
    }

    public void removeObservers(Observer o)
    {
        Observers.remove(0);
    }
    private void notifyObserve() {
        for(Observer o : Observers)
        {
            o.update(temp);
        }

}

}

class Display implements Observer
{

    private String name ;

    public  Display(String name)
    {
        this.name = name;
    }

    public void update(float temp)
    {

        System.out.println(name +"    Seees temp   " + temp);
    }

}




public class ObserverYutubeMain {
    public static void main(String[] args)
    {

        Weatherstation station = new Weatherstation();

        Display d1 = new Display("Sujan");
        Display d2 = new Display("Prodhan");

        station.addObservers(d2);
        station.addObservers(d1);
        station.setTemp(30F);
        station.setTemp(32.0F);


    }

}
