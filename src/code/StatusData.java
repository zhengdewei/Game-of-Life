package code;


public class StatusData {

    public static class Pixel {
    	
      private int _x, _y;

      public int getX() { return _x; }
      public int getY() { return _y; }

      public void setX(int s) { _x = s; }
      public void setY(int s) { _y = s; }
    }


    private Pixel _pixel;
    private int _status;


    public Pixel getPixel() { return _pixel; }
    public int getStatus() { return _status; }


    public void setPixel(Pixel n) { _pixel = n; }
    public void setStatus(int b) { _status = b; }
}
