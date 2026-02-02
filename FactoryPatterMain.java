package LAbCODE;

interface shape{

    double getArea();
}

class circle implements shape
{
    private double r;
    public circle()
    {
        this.r = 2.8;
    }

    public double getArea()
    {
        return Math.PI*r*r;
    }

}


class  rectangle implements shape
{
private  double width , height ;
public rectangle(){
    this.width = 2.4;
    this.height = 3.4;

}

public double getArea()
{
    return width*height;
}

}


class triangle implements shape
{
   private double a, b , c;
   public triangle()
   {
    this.a = 2;
    this.b= 3;
    this.c = 4;

   }

   public double getArea()
   {
    double s = (a+b+c)/2;
    return Math.sqrt(s*(s-a)*(s-b)*(s-c)) ;
   }
}


class FactoryPatterns {
    public static shape getshape (String s)
    {
        if(s.equalsIgnoreCase( "circle"))
        {
            return new circle();
        }
        else if (s.equalsIgnoreCase("rectangle"))
        {
            return new rectangle();
        }
        else if (s.equalsIgnoreCase("triangle")) {
            return new triangle();
            
        }

        else{
            return null;
        }

    }
}


public class FactoryPatterMain {
    public static void main(String[] args)
    {
       shape circle = FactoryPatterns.getshape("circle");
       shape triangle = FactoryPatterns.getshape("triangle");
       shape rectangle = FactoryPatterns.getshape("rectangle");
       System.out.println(circle.getArea());
       System.out.println(rectangle.getArea());
       System.out.println(triangle.getArea());
       
    }
    
}

