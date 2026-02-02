package EmailObservers;

import java.util.ArrayList;
import java.util.List;

interface Subscriber{
    void update(String videoTitle);

}

class Youtubechannel{
   private List<Subscriber> Subscribers = new ArrayList<>();
   String videoTitle ;
   public void uploadvideo(String videoTitle)
   {
    this.videoTitle = videoTitle;
    notifySubscriber();
   }
   public  void AddSubscriber(Subscriber s )
   {
    Subscribers.add(s);

   }

   public void Removesubscriber(Subscriber s)
   {
    Subscribers.remove(s);
   }


  private void  notifySubscriber()
   {
    for(Subscriber s : Subscribers)
    {
        s.update(videoTitle);
    }

   }

}


class Emailsubscriber implements Subscriber
{
    private String email ;
    public  Emailsubscriber(String email)
    {
        this.email = email;
    }
    public void update(String videoTitle)
    {
System.out.println("EMail is : "+ email + "video title is : " + videoTitle);
    }
}


class mobileSubscriber implements Subscriber
{

   private  String name ; 
   public mobileSubscriber (String name)
   {

    this.name = name;
    
   }
   public void update(String videoTitle)
   {
System.out.println("Moblie scubriver name : " + name + "video title name is :  "+videoTitle);
   }


}


public class Main {
    public  static void main(String[] args)
    {
        Youtubechannel yc = new Youtubechannel();
        Subscriber  s1 = new Emailsubscriber("hshsh@gmail.com");
        Subscriber s2 = new mobileSubscriber("Sujan Prodhan");

        yc.AddSubscriber(s1);
        yc.AddSubscriber(s2);

        yc.uploadvideo("hddhvdd csn  tu meriiii");
        yc.uploadvideo("Mon mane naaaaaaa");
    }
    
}
