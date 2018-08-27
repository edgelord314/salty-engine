/*
 * Copyright (c) by Malte Dostal
 * Germany, 8.2018
 * All rights reserved
 */

package de.edgelord.saltyengine.gameobject;

import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.event.TouchingEvent;
import de.edgelord.saltyengine.gameobject.components.Accelerator;
import de.edgelord.saltyengine.gameobject.components.RecalculateHitboxComponent;
import de.edgelord.saltyengine.gameobject.components.RecalculateMiddleComponent;
import de.edgelord.saltyengine.gameobject.components.SimplePhysicsComponent;
import de.edgelord.saltyengine.hitbox.SimpleHitbox;
import de.edgelord.saltyengine.location.Coordinates;
import de.edgelord.saltyengine.location.Vector2f;
import de.edgelord.saltyengine.utils.Directions;
import de.edgelord.stdf.Species;
import de.edgelord.stdf.reading.DataReader;
import de.edgelord.stdf.reading.ValueToListConverter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {

    public static final String DEFAULT_PHYSICS_NAME = "de.edgelord.saltyengine.coreComponents.physics";
    public static final String DEFAULT_RECALCULATE_HITBOX_NAME = "de.edgelord.saltyengine.coreComponents.recalculateHitbox";
    public static final String DEFAULT_RECALCULATE_MIDDLE_NAME = "de.edgelord.saltyengine.coreComponents.recalculateMiddle";
    public static final String DEFAULT_ACCELERATOR_NAME = "de.edgelord.saltyengine.coreComponents.accelerator";

    private final List<TouchingEvent> touchingEvents = new LinkedList<>();
    private final List<GameObjectComponent> components = new LinkedList<>();

    private final SimplePhysicsComponent physicsComponent;
    private final RecalculateHitboxComponent recalculateHitboxComponent;
    private final RecalculateMiddleComponent recalculateMiddleComponent;
    private final Accelerator defaultAccelerator;

    private Directions.Direction lastDirection = null;

    private Coordinates coordinates;
    private Coordinates middle;
    private Vector2f position = new Vector2f(0, 0);
    private String tag;
    private float width, height;
    private HashMap<String, String> properties = new HashMap<>();
    private File propertiesFile;
    private SimpleHitbox hitbox;
    private float mass = 1f;

    public GameObject(final Coordinates coordinates, final float width, final float height, final String tag) {
        this.coordinates = coordinates;
        position.parseVector2f(coordinates);
        this.width = width;
        this.height = height;
        hitbox = new SimpleHitbox(this, getWidth(), getHeight(), 0, 0);
        this.tag = tag;

        middle = new Coordinates(getCoordinates().getX() + getWidth() / 2, getCoordinates().getY() + getHeight() / 2);

        physicsComponent = new SimplePhysicsComponent(this, GameObject.DEFAULT_PHYSICS_NAME);
        recalculateHitboxComponent = new RecalculateHitboxComponent(this, GameObject.DEFAULT_RECALCULATE_HITBOX_NAME);
        recalculateMiddleComponent = new RecalculateMiddleComponent(this, GameObject.DEFAULT_RECALCULATE_MIDDLE_NAME);
        defaultAccelerator = new Accelerator(this, GameObject.DEFAULT_ACCELERATOR_NAME);

        components.add(physicsComponent);
        components.add(recalculateHitboxComponent);
        components.add(recalculateMiddleComponent);
        components.add(defaultAccelerator);
    }

    public abstract void initialize();

    public abstract void onCollision(CollisionEvent event);

    public abstract void onFixedTick();

    public abstract void onTick();

    public abstract void draw(Graphics2D graphics);

    public void addComponent(final GameObjectComponent gameObjectComponent) {

        components.add(gameObjectComponent);
    }

    public void doComponentOnFixedTick() {

        for (final GameObjectComponent gameObjectComponent : components) {

            if (gameObjectComponent.isEnabled()) {
                gameObjectComponent.onFixedTick();
            }
        }
    }

    public void doComponentDrawing(final Graphics2D graphics) {

        for (final GameObjectComponent gameObjectComponent : components) {

            if (gameObjectComponent.isEnabled()) {
                gameObjectComponent.draw(graphics);
            }
        }
    }

    public void doCollisionDetection(final List<GameObject> gameObjects, final List<GameObjectComponent> collisionComponenets) {

        Directions collisionDirections = new Directions();

        touchingEvents.clear();

        for (final GameObject other : gameObjects) {

            if (other == this) {
                continue;
            }

            if (getHitbox().collides(other)) {

                Directions.appendGameObjectRelation(this, other, collisionDirections);

                // final CollisionEvent e = new CollisionEvent(other, collisionDirections);
                final CollisionEvent eSelf = new CollisionEvent(other, collisionDirections);

                getTouchingEvents().add(new TouchingEvent(eSelf, this));

                // other.onCollision(e);
                onCollision(eSelf);

                for (final GameObjectComponent component : getComponents()) {
                    component.onCollision(eSelf);
                    collisionComponenets.add(component);
                }

                /*
                for (final GameObjectComponent component : other.getComponents()) {
                    if (!component.getTag().equals(GameObjectComponent.PUSH_OUT_ON_COLLISION)) {
                        component.onCollision(e);
                    }
                }
                */
            } else {
                final CollisionEvent eSelf = new CollisionEvent(other, new Directions());

                for (final GameObjectComponent component : getComponents()) {
                    if (!collisionComponenets.contains(component)) {
                        component.onCollision(eSelf);
                    }
                }
            }
        }
    }

    public void removeComponent(final String name) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getName().equals(name)) {
                components.remove(i);
            }
        }
    }

    public void initPropertiesFile(final File file) {

        propertiesFile = file;
    }

    public void addProperty(final String key, final String value) {

        getProperties().put(key, value);
    }

    public void changeProperty(final String key, final String newValue) {

        getProperties().replace(key, getProperties().get(key), newValue);
    }

    public String getLocalProperty(final String key) {

        return getProperties().get(key);
    }

    public int getPropertyAsInteger(final String key) {

        return Integer.valueOf(getLocalProperty(key));
    }

    public String readProperty(final String property) throws IOException {

        final DataReader propertiesReader = new DataReader(propertiesFile);

        return propertiesReader.getTagValue(property);
    }

    public void syncPropertiesToFile() {

    }

    public void readKeyProperties() throws IOException {

        final DataReader propertiesReader = new DataReader(propertiesFile);
        final Species keyProperties = propertiesReader.getSpecies("keyProperties");

        if (keyProperties.getContent().contains("location")) {

            final List<Integer> readenCoordinates = ValueToListConverter.convertToIntegerList(keyProperties, "location", ",");
            setCoordinates(new Coordinates(readenCoordinates.get(0), readenCoordinates.get(1)));
        }
    }

    public void basicMove(final float delta, final Directions.BasicDirection direction) {

        if (direction == Directions.BasicDirection.x) {
            position.setX(getX() + delta);
        } else {
            position.setY(getY() + delta);
        }
    }

    public void move(float delta, final Directions.Direction direction) {

        if (delta != 0) {
            lastDirection = direction;
        }

        // Check if delta is negative and if so, mirror its value
        if (delta < 0f) {
            delta = delta * (-1);
        }

        switch (direction) {

            case RIGHT:
                basicMove(delta, Directions.BasicDirection.x);
                break;
            case LEFT:
                basicMove(-delta, Directions.BasicDirection.x);
                break;
            case UP:
                basicMove(-delta, Directions.BasicDirection.y);
                break;
            case DOWN:
                basicMove(delta, Directions.BasicDirection.y);
                break;
        }
    }

    public void moveY(final float delta) {
        position.setY(getY() + delta);
    }

    public void moveX(final float delta) {
        position.setX(getX() + delta);
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(final HashMap<String, String> properties) {
        this.properties = properties;
    }

    public void updateCoordinates() {

        coordinates.parseCoordinates(position);
    }

    public Coordinates getCoordinates() {
        updateCoordinates();

        return coordinates;
    }

    public void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public float getWidthExact() {
        return width;
    }

    public int getWidth() {
        return (int) width;
    }

    public void setWidth(final float width) {
        this.width = width;
    }

    public float getHeightExact() {
        return height;
    }

    public int getHeight() {
        return (int) height;
    }

    public void setHeight(final float height) {
        this.height = height;
    }

    public SimpleHitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(final SimpleHitbox hitbox) {
        this.hitbox = hitbox;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(final Vector2f position) {
        this.position = position;
    }

    public float getX() {
        return getPosition().getX();
    }

    public void setX(final float x) {

        getPosition().setX(x);
    }

    public float getY() {

        return getPosition().getY();
    }

    public void setY(final float y) {

        getPosition().setY(y);
    }

    public List<TouchingEvent> getTouchingEvents() {
        return touchingEvents;
    }

    public List<GameObjectComponent> getComponents() {
        return components;
    }

    public SimplePhysicsComponent getPhysics() {
        return physicsComponent;
    }

    public RecalculateHitboxComponent getRecalculateHitboxComponent() {
        return recalculateHitboxComponent;
    }

    public Accelerator getDefaultAccelerator() {
        return defaultAccelerator;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

    public Coordinates getMiddle() {
        return middle;
    }

    public void setMiddle(final Coordinates middle) {
        this.middle = middle;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(final float mass) {
        this.mass = mass;
    }

    public Directions.Direction getLastDirection() {
        return lastDirection;
    }

    public void setLastDirection(final Directions.Direction lastDirection) {
        this.lastDirection = lastDirection;
    }
}