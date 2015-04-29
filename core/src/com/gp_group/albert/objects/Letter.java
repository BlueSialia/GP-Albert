package com.gp_group.albert.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * @author bluesialia
 *         Date: 11/02/15
 */
public class Letter {


    private final Vector2 position;
    private final Vector2 velocity;
    private final Vector2 maxVelocity;
    private final Vector2 acceleration;

    private final Rectangle boundingRectangle;

    public Letter(float side, float x, float y, float gravity, float maxSpeed) {
        Gdx.app.log("Letter", "created");
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.maxVelocity = new Vector2(0, maxSpeed);
        this.acceleration = new Vector2(0, gravity);
        this.boundingRectangle = new Rectangle(this.position.x, this.position.y, side, side);
    }

    /**
     * Updates this Letter (all the movement variables and checks collision).
     *
     * @param delta
     * @param column List containing the Letters this letter may collide with.
     * @param floor  Height of the position of the floor.
     */
    public void update(float delta, List<Letter> column, float floor) {
        Gdx.app.log("Letter", "updated");
        updateVelocity(delta);
        updatePosition(delta, column, floor);
    }

    /**
     * Updates de position of the Letter.
     *
     * @param delta
     * @param column List containing the Letters this letter may collide with.
     * @param floor  Height of the position of the floor.
     */
    private void updatePosition(float delta, List<Letter> column, float floor) {
        Gdx.app.log("Letter", "position updated");
        if (column.indexOf(this) == 0) {
            position.y += velocity.y * delta;
            if (position.y > floor) {
                position.y = floor;
            }
        } else {
            if (!Intersector.overlaps(boundingRectangle, column.get(column.indexOf(this) - 1).boundingRectangle)) {
                position.y += velocity.y * delta;
            }
        }
        boundingRectangle.setPosition(position); //NOTE: Needs testing. Lots of. Because the coordinates system is... ¿?
    }

    /**
     * Updates the velocity of the Letter. Checking it doesn't surpass the maxVelocity.
     *
     * @param delta
     */
    private void updateVelocity(float delta) {
        Gdx.app.log("Letter", "velocity updated");
        velocity.y += acceleration.y * delta;
        if (velocity.y > maxVelocity.y) {
            velocity.y = maxVelocity.y;
        }
    }
}
