package LAbCODE;

interface shape
{
void draw();
}

class circle implements shape
{
    public void draw()
    {
        System.out.println("drawing.... circle");
    }
}

class rectangle implements shape{
    public void draw()
    {
        System.out.println("drawing....... rectangel");
    }
}


class Roundedcircle implements shape
{
    public void draw()
    {
        System.out.println("drawing.... Roundedcircle");
    }
}

class Roundedrectangle implements shape{
    public void draw()
    {
        System.out.println("drawing....... Roundedrectangel");
    }
}

abstract class AbstractFactory{
    abstract shape getshape(String s);
}

class ShapeFactory extends AbstractFactory{
    public shape getshape(String s)
    {
             if(s.equalsIgnoreCase("circle"))
             {
                return new circle();
             }
             else if (s.equalsIgnoreCase("rectangle"))
             {
                return new rectangle();
             }
          return null;
             
    }
}


class  RoundedSHapeFactory extends AbstractFactory
{
    public shape  getshape(String s)
    {
        if(s.equalsIgnoreCase("circle"))
        {
            return new Roundedcircle();
        }
        else if(s.equalsIgnoreCase("rectangle"))
        {
            return new  Roundedrectangle();
    }

    return null;

}

}

class FactoryProducer {
public static AbstractFactory  getfFactory(boolean round)
{
if(round)
{
    return new RoundedSHapeFactory();
}
else
{
    return new ShapeFactory();
}

}

}



public class AbstractFactoryMain {

    
    public static void main(String[] args){
        AbstractFactory  normalFactory =  FactoryProducer.getfFactory(false);
        shape s1 = normalFactory.getshape("circle");
        s1.draw();
        shape s2 = normalFactory.getshape("rectangle");
        s2.draw();

        AbstractFactory roundedfactory = FactoryProducer.getfFactory(true);
        shape s3 = roundedfactory.getshape("circle");
        s3.draw();
        shape s4 = roundedfactory.getshape("rectangle");
        s4.draw();



    }
    
}
