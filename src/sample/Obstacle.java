package sample;

import java.io.Serializable;

public abstract class Obstacle implements Serializable {

    public abstract double getCenter();
    public String name;
    public abstract  boolean checkColor (BallController ball);
    public abstract void movingSpeed(double speed);

    public float rotatingSpeed(){return 0;}

    public abstract void setCenter();

    public abstract void setCenter2(double center);

    public abstract void setCenter3();
}
