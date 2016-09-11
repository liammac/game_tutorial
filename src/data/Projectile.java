package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Clock.*;
import static helpers.Artist.*;

/**
 * Created by Liam on 2016-09-10.
 */
public class Projectile {

    private Texture texture;
    private float x, y, speed, xVelocity, yVelocity;
    private int damage;
    private Enemy target;

    public Projectile(Texture texture, Enemy target,float x, float y, float speed, int damage) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.target = target;
        this.xVelocity = 0;
        this.yVelocity = 0;
        calculateDirection();

    }

    private void calculateDirection() {
        float totalAllowedMovement = 1.0f;
        float xDistanceFromTarget = Math.abs(target.getX() - x);
        float yDistanceFromTarget = Math.abs(target.getY() - y);
        float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
        float xPercentOfMovement = xDistanceFromTarget / totalDistanceFromTarget;
        xVelocity = xPercentOfMovement;
        yVelocity = totalAllowedMovement - xPercentOfMovement;

        if (target.getX() < x)
            xVelocity *= -1;
        if (target.getY() < y)
            yVelocity *= -1;


    }

    public void update() {
        x += xVelocity * speed * Delta();
        y += yVelocity * speed * Delta();
        draw();
    }

    public void draw() {
        DrawQuadTex(texture, x, y, 32, 32);
    }
}
