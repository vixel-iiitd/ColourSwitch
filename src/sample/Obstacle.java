package sample;

public abstract class Obstacle {

    public abstract double getCenter();

    public abstract  boolean checkColor (BallController ball);
    public abstract void movingSpeed(double speed);

    public float rotatingSpeed(){return 0;}


    public abstract void setCenter();
}
