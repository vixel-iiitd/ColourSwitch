package sample;

public abstract class Obstacle {

    public abstract  boolean checkColor (BallController ball);
    public float movingSpeed(){return 0;}
    public float rotatingSpeed(){return 0;}


}
