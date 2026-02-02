package LAbCODE;

interface Mediaplayer {

    void play(String fileType , String filename);
}

class VlcPlayer{
    public void plyvlc(String filename)
    {
        System.out.println("ply vlc player " + filename);
    }

}


class MediaAdapter implements Mediaplayer{

    private VlcPlayer vlcPlayer;
    public MediaAdapter()
    {
        vlcPlayer = new VlcPlayer();
    }

    public void play(String fileType , String filename)
    {

        if(fileType.equalsIgnoreCase("vlc"))
        {
            vlcPlayer.plyvlc(fileType);
        }

        else{
        System.out.println("Unsupported formate " + fileType);
    }

    }
}



public class AdapterMain {

    public static void main(String args[])
    {
       Mediaplayer m = new MediaAdapter();
       m.play("vlc", "movie.vlc");
       m.play("mp4", "video.mp4");
    }
    
}
