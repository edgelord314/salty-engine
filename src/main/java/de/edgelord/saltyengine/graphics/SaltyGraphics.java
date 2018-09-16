package de.edgelord.saltyengine.graphics;

import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.transform.Dimensions;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.transform.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class SaltyGraphics {

    private Graphics2D graphics2D;

    public SaltyGraphics(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    /*
    Rendering bindings
     */

    /*
    Fill a rect
     */

    /**
     * The base method to DRAW filled rect. It automatically rounds the given floats to ints
     *
     * @param x      the x position of the rect
     * @param y      the y position of the rect
     * @param width  the width of the rect
     * @param height the height of the rect
     * @see Graphics2D#fillRect(int, int, int, int)
     */
    public void fillRect(float x, float y, float width, float height) {
        graphics2D.fillRect(Math.round(x), Math.round(y), Math.round(width), Math.round(height));
    }

    /**
     * Draws a filled rect by calling the base method
     *
     * @param transform the transform from which to take the needed information
     * @see #fillRect(float, float, float, float)
     */
    public void fillRect(Transform transform) {
        fillRect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    /**
     * Draws a filled rect by calling the base method
     *
     * @param position   the position of the rect
     * @param dimensions the dimension of the rect
     * @see #fillRect(float, float, float, float)
     */
    public void fillRect(Vector2f position, Dimensions dimensions) {
        fillRect(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    /**
     * Draws a filled rectangle by calling <code>fillRect(Transform)</code>
     *
     * @param gameObject the GameObject from which to take the Transform
     * @see #fillRect(Transform)
     */
    public void fillRect(GameObject gameObject) {
        fillRect(gameObject.getTransform());
    }
    
    /*
    Draw a rect
     */

    /**
     * The base method to DRAW the outline of a rect. It automatically rounds the given floats to ints
     *
     * @param x      the x position of the rect
     * @param y      the y position of the rect
     * @param width  the width of the rect
     * @param height the height of the rect
     * @see Graphics2D#drawRect(int, int, int, int)
     */
    public void drawRect(float x, float y, float width, float height) {
        graphics2D.drawRect(Math.round(x), Math.round(y), Math.round(width), Math.round(height));
    }

    /**
     * Draws the outline of a rect by calling the base method
     *
     * @param transform the transform from which to take the needed information
     * @see #drawRect(float, float, float, float)
     */
    public void drawRect(Transform transform) {
        drawRect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    /**
     * Draws the outline of a rect by calling the base method
     *
     * @param position   the position of the rect
     * @param dimensions the dimensions of the rect
     * @see #drawRect(float, float, float, float)
     */
    public void drawRect(Vector2f position, Dimensions dimensions) {
        drawRect(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    /**
     * Draws the outline of a rect by calling the method <code>drawRect(Transform)</code>
     *
     * @param gameObject the gameObject from which to take the transform with the necessary information
     * @see #drawRect(Transform)
     */
    public void drawRect(GameObject gameObject) {
        drawRect(gameObject.getTransform());
    }
    
    /*
    Fill an oval
     */

    /**
     * The base method to DRAW a filled oval. It automatically rounds the given floats to ints.
     *
     * @param x      the x position of the oval
     * @param y      the y position of the oval
     * @param width  the width of the oval
     * @param height the height of the oval
     * @see Graphics2D#fillOval(int, int, int, int)
     */
    public void fillOval(float x, float y, float width, float height) {
        graphics2D.fillOval(Math.round(x), Math.round(y), Math.round(width), Math.round(height));
    }

    /**
     * Draws a filled oval by calling the base method
     *
     * @param transform the transform from which to take the needed information
     * @see #fillOval(float, float, float, float)
     */
    public void fillOval(Transform transform) {
        fillOval(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    /**
     * Draws a filled oval by calling the base method
     *
     * @param position   the position of the oval
     * @param dimensions the dimensions of the oval
     * @see #fillOval(float, float, float, float)
     */
    public void fillOval(Vector2f position, Dimensions dimensions) {
        fillOval(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    /**
     * Draws a filled oval by calling <code>fillOval(Transform)</code>
     *
     * @param gameObject the gameObject from which to take the Transform to DRAW the oval
     */
    public void fillOval(GameObject gameObject) {
        fillOval(gameObject.getTransform());
    }
    
    /*
    Draw an oval
     */

    /**
     * The base method to DRAW the outline of an oval. It automatically round the given floats to ints.
     *
     * @param x      the x position of the oval
     * @param y      the y position of the oval
     * @param width  the width of the oval
     * @param height the height of the oval
     * @see Graphics2D#drawOval(int, int, int, int)
     */
    public void drawOval(float x, float y, float width, float height) {
        graphics2D.drawOval(Math.round(x), Math.round(y), Math.round(width), Math.round(height));
    }

    /**
     * Draws the outline of an oval by calling the base method
     *
     * @param transform the transform from which to take the needed information
     * @see #drawOval(float, float, float, float)
     */
    public void drawOval(Transform transform) {
        drawOval(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    /**
     * Draws the outline of an oval by calling the base method
     *
     * @param position   the position of the oval
     * @param dimensions the dimesniosn of the oval
     * @see #drawOval(float, float, float, float)
     */
    public void drawOval(Vector2f position, Dimensions dimensions) {
        drawOval(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    /**
     * Draws the outline of an oval by calling <code>drawOval(Transform)</code>
     *
     * @param gameObject the GameObject from which to take the transform
     * @see #drawOval(Transform)
     */
    public void drawOval(GameObject gameObject) {
        drawOval(gameObject.getTransform());
    }

    /*
    Draw an image
     */

    /**
     * The base method to DRAW an image. It automatically rounds the given floats to ints.
     *
     * @param image  the image to DRAW
     * @param x      the x position of the image
     * @param y      the y position of the image
     * @param width  the width with which the image should be drawn
     * @param height the height with which the image should be drawn
     * @see Graphics2D#drawImage(Image, int, int, int, int, ImageObserver)
     */
    public void drawImage(BufferedImage image, float x, float y, float width, float height) {
        graphics2D.drawImage(image, Math.round(x), Math.round(y), Math.round(width), Math.round(height), null);
    }

    /**
     * Draws an image by calling the base method. It will be drawn with its original width and height
     *
     * @param image    the image to be drawn
     * @param position the position of the image
     * @see #drawImage(BufferedImage, float, float, float, float)
     */
    public void drawImage(BufferedImage image, Vector2f position) {
        drawImage(image, position.getX(), position.getY(), Math.round(image.getWidth()), Math.round(image.getHeight()));
    }

    /**
     * Draws an image by calling the base method
     *
     * @param image     the image to be drawn
     * @param transform the transform from which to take the position and dimensions of the image to be drawn with
     * @see #drawImage(BufferedImage, float, float, float, float)
     */
    public void drawImage(BufferedImage image, Transform transform) {
        drawImage(image, transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    /**
     * Draws an image by calling the base method
     *
     * @param image      the image to be drawn
     * @param position   the position of the image
     * @param dimensions the dimensions with to DRAW the image
     */
    public void drawImage(BufferedImage image, Vector2f position, Dimensions dimensions) {
        drawImage(image, position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight());
    }

    /**
     * Draws an image by calling <code>drawImage(BufferedImage, Transform)</code>
     *
     * @param image      the image to be drawn
     * @param gameObject the GameObject from which to take the Transform to DRAW the image
     */
    public void drawImage(BufferedImage image, GameObject gameObject) {
        drawImage(image, gameObject.getTransform());
    }

    /*
    Fill a round rect
     */

    /**
     * The base method to DRAW a filled round rect. It automatically round the given floats to ints
     *
     * @param x         the x position of the round rect
     * @param y         the y position of the round rect
     * @param width     the width of the round rect
     * @param height    the height of the round rect
     * @param arcWidth  the horizontal diameter of the arc
     * @param arcHeight the vertical diameter of the arc
     * @see Graphics2D#fillRoundRect(int, int, int, int, int, int)
     */
    public void fillRoundRect(float x, float y, float width, float height, float arcWidth, float arcHeight) {
        graphics2D.fillRoundRect(Math.round(x), Math.round(y), Math.round(width), Math.round(height), Math.round(arcWidth), Math.round(arcHeight));
    }

    /**
     * The base method to DRAW a filled round rect with the same arc both horizontally and vertically. It automatically round the given floats to ints
     *
     * @param x      the x position of the round rect
     * @param y      the y position of the round rect
     * @param width  the width of the round rect
     * @param height the height of the round rect
     * @param arc    the diameter for the arc both horizontally and vertically
     * @see Graphics2D#fillRoundRect(int, int, int, int, int, int)
     */
    public void fillRoundRect(float x, float y, float width, float height, float arc) {
        fillRoundRect(x, y, width, height, arc, arc);
    }

    /**
     * Draws a filled round rect by calling the base method
     *
     * @param transform the transform of the round rect
     * @param arcWidth  the diameter of the horizontal arc
     * @param arcHeight the diameter of the vertical arc
     * @see #fillRoundRect(float, float, float, float, float, float)
     */
    public void fillRoundRect(Transform transform, float arcWidth, float arcHeight) {
        fillRoundRect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), arcWidth, arcHeight);
    }

    /**
     * Draws a filled round rect with the same horizontal and vertical arc by calling the base method
     *
     * @param transform the transform of the round rect
     * @param arc       the horizontal and vertical diameter of the arc
     * @see #fillRoundRect(float, float, float, float, float, float)
     */
    public void fillRoundRect(Transform transform, float arc) {
        fillRoundRect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), arc, arc);
    }

    /**
     * Draws a filled rect by calling the base method
     *
     * @param position   the position of the round rect
     * @param dimensions the dimensions of the round rect
     * @param arcWidth   the diameter of the horizontal arc
     * @param arcHeight  the diameter of the vertical arc
     * @see #fillRoundRect(float, float, float, float, float, float)
     */
    public void fillRoundRect(Vector2f position, Dimensions dimensions, float arcWidth, float arcHeight) {
        fillRoundRect(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight(), arcWidth, arcHeight);
    }

    /**
     * Draws a filled round rect with the same horizontal and vertical arc by calling the base method
     *
     * @param position   the position of the round rect
     * @param dimensions the dimensions of the round rect
     * @param arc        the horizontal and vertical diameter of the arc
     * @see #fillRoundRect(float, float, float, float, float, float)
     */
    public void fillRoundRect(Vector2f position, Dimensions dimensions, float arc) {
        fillRoundRect(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight(), arc, arc);
    }

    /**
     * Draws a filled round rect by calling <code>fillRoundRect(Transform, float, float)</code>
     *
     * @param gameObject the gameObject from which to take the transform
     * @param arcWidth   the diameter of the horizontal arc
     * @param arcHeight  the diameter of the vertical arc
     * @see #fillRoundRect(Transform, float, float)
     */
    public void fillRoundRect(GameObject gameObject, float arcWidth, float arcHeight) {
        fillRoundRect(gameObject.getTransform(), arcWidth, arcHeight);
    }

    /**
     * Draws a filled round rect with the same horizontal and vertical arc by calling <code>fillRoundRect(Transform, float, float)</code>
     *
     * @param gameObject the gameObject from which to take the transform
     * @param arc        the horizontal and vertical diameter of the arc
     * @see #fillRoundRect(Transform, float, float)
     */
    public void fillRoundRect(GameObject gameObject, float arc) {
        fillRoundRect(gameObject.getTransform(), arc, arc);
    }
    
    /*
    Draw a round rect
     */

    /**
     * The base method to DRAW a round rect. It automatically round the given floats to ints
     *
     * @param x         the x position of the round rect
     * @param y         the y position of the round rect
     * @param width     the width of the round rect
     * @param height    the height of the round rect
     * @param arcWidth  the horizontal diameter of the arc
     * @param arcHeight the vertical diameter of the arc
     * @see Graphics2D#drawRoundRect(int, int, int, int, int, int)
     */
    public void drawRoundRect(float x, float y, float width, float height, float arcWidth, float arcHeight) {
        graphics2D.drawRoundRect(Math.round(x), Math.round(y), Math.round(width), Math.round(height), Math.round(arcWidth), Math.round(arcHeight));
    }

    /**
     * The base method to DRAW a round rect with the same arc both horizontally and vertically. It automatically round the given floats to ints
     *
     * @param x      the x position of the round rect
     * @param y      the y position of the round rect
     * @param width  the width of the round rect
     * @param height the height of the round rect
     * @param arc    the diameter for the arc both horizontally and vertically
     * @see Graphics2D#drawRoundRect(int, int, int, int, int, int)
     */
    public void drawRoundRect(float x, float y, float width, float height, float arc) {
        drawRoundRect(x, y, width, height, arc, arc);
    }

    /**
     * Draws the outline of a round rect by calling the base method
     *
     * @param transform the transform of the round rect
     * @param arcWidth  the diameter of the horizontal arc
     * @param arcHeight the diameter of the vertical arc
     * @see #drawRoundRect(float, float, float, float, float, float)
     */
    public void drawRoundRect(Transform transform, float arcWidth, float arcHeight) {
        drawRoundRect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), arcWidth, arcHeight);
    }

    /**
     * Draws the outline of a round rect with the same horizontal and vertical arc by calling the base method
     *
     * @param transform the transform of the round rect
     * @param arc       the horizontal and vertical diameter of the arc
     * @see #drawRoundRect(float, float, float, float, float, float)
     */
    public void drawRoundRect(Transform transform, float arc) {
        drawRoundRect(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), arc, arc);
    }

    /**
     * Draws the outline of a round rect by calling the base method
     *
     * @param position   the position of the round rect
     * @param dimensions the dimensions of the round rect
     * @param arcWidth   the diameter of the horizontal arc
     * @param arcHeight  the diameter of the vertical arc
     * @see #drawRoundRect(float, float, float, float, float, float)
     */
    public void drawRoundRect(Vector2f position, Dimensions dimensions, float arcWidth, float arcHeight) {
        drawRoundRect(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight(), arcWidth, arcHeight);
    }

    /**
     * Draws the outline of a round rect with the same horizontal and vertical arc by calling the base method
     *
     * @param position   the position of the round rect
     * @param dimensions the dimensions of the round rect
     * @param arc        the horizontal and vertical diameter of the arc
     * @see #drawRoundRect(float, float, float, float, float, float)
     */
    public void drawRoundRect(Vector2f position, Dimensions dimensions, float arc) {
        drawRoundRect(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight(), arc, arc);
    }

    /**
     * Draws the outline of a round rect by calling <code>fillRoundRect(Transform, float, float)</code>
     *
     * @param gameObject the gameObject from which to take the transform
     * @param arcWidth   the diameter of the horizontal arc
     * @param arcHeight  the diameter of the vertical arc
     * @see #drawRoundRect(Transform, float, float)
     */
    public void drawRoundRect(GameObject gameObject, float arcWidth, float arcHeight) {
        drawRoundRect(gameObject.getTransform(), arcWidth, arcHeight);
    }

    /**
     * Draws the outline of a round rect with the same horizontal and vertical arc by calling <code>fillRoundRect(Transform, float, float)</code>
     *
     * @param gameObject the gameObject from which to take the transform
     * @param arc        the horizontal and vertical diameter of the arc
     * @see #drawRoundRect(Transform, float, float)
     */
    public void drawRoundRect(GameObject gameObject, float arc) {
        drawRoundRect(gameObject.getTransform(), arc, arc);
    }

    /**
     * The base method to clear a rect.
     * Clears the given rect from the graphics.
     *
     * @param x the x position of the rect to be cleared
     * @param y the y position of the rect to be cleared
     * @param width the width of the rect to be cleared
     * @param height the height of the rect to be cleared
     *
     * @see Graphics2D#clearRect(int, int, int, int)
     */
    public void clear(float x, float y, float width, float height) {
        graphics2D.clearRect(Math.round(x), Math.round(y), Math.round(width), Math.round(height));
    }

    /**
     * Clears a rect build from the given transform by calling the base method.
     *
     * @param transform the {@link Transform} of the rect to be cleared
     *
     * @see #clear(float, float, float, float)
     */
    public void clear(Transform transform) {
        clear(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight());
    }

    /*
    Binding for drawing Shapes and lines
     */

    /**
     * Draws the given Shape
     *
     * @param shape the shape to be drawn
     * @see Graphics2D#draw(Shape)
     */
    public void drawShape(Shape shape) {
        graphics2D.draw(shape);
    }

    /**
     * Fills the given Shape
     *
     * @param shape the shape to be drawn
     * @see Graphics2D#fill(Shape)
     */
    public void fillShape(Shape shape) {
        graphics2D.fill(shape);
    }

    /**
     * The base method to DRAW a line. The given floats are automatically rounded to ints.
     * This method draws a line from point p1(x1 | y1) to point p2(x2 | y2)
     *
     * @param x1 x position of the start point
     * @param y1 y position of the start point
     * @param x2 x position of the end point
     * @param y2 y position of the end point
     * @see Graphics2D#drawLine(int, int, int, int)
     */
    public void drawLine(float x1, float y1, float x2, float y2) {
        graphics2D.drawLine(Math.round(x1), Math.round(y1), Math.round(x2), Math.round(y2));
    }

    /**
     * The base method to DRAW a Line with a temporary Stroke. The given floats are automatically rounded to ints.
     * Before the line is drawn, the current stroke gets fetched and the temporary one is set,
     * after the line is drawn, the fetched stroke gets set again.
     *
     * @param x1              x position of the start point
     * @param y1              y position of the start point
     * @param x2              x position of the end point
     * @param y2              y position of the end point
     * @param temporaryStroke the temporary Stroke with which to DRAW the line
     * @see #drawLine(float, float, float, float)
     * @see #getStroke()
     * @see #setStroke(Stroke)
     */
    public void drawLine(float x1, float y1, float x2, float y2, Stroke temporaryStroke) {

        Stroke stroke = getStroke();

        setStroke(temporaryStroke);
        drawLine(x1, y1, x2, y2);

        setStroke(stroke);
    }

    /**
     * Draws a line by calling the base method
     *
     * @param startPoint the start point of the line
     * @param endPoint   the end point of the line
     */
    public void drawLine(Vector2f startPoint, Vector2f endPoint) {
        drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
    }

    /**
     * Draws a line with a temporary Stroke by calling the base method
     *
     * @param startPoint      the start point of the line
     * @param endPoint        the end point of the line
     * @param temporaryStroke the temporary Stroke with which to DRAW the line
     * @see #drawLine(float, float, float, float, Stroke)
     */
    public void drawLine(Vector2f startPoint, Vector2f endPoint, Stroke temporaryStroke) {
        drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), temporaryStroke);
    }

    /**
     * Draws a line by calling the base method
     *
     * @param x1       x position of the start point
     * @param y1       y position of the start point
     * @param endPoint the end point
     * @see #drawLine(float, float, float, float)
     */
    public void drawLine(float x1, float y1, Vector2f endPoint) {
        drawLine(x1, y1, endPoint.getX(), endPoint.getY());
    }

    /**
     * Draws a line with a temporary Stroke by calling the base method
     *
     * @param x1              x position of the start point
     * @param y1              y position of the start point
     * @param endPoint        the end point
     * @param temporaryStroke the temporary Stroke with which to DRAW the line
     * @see #drawLine(float, float, float, float, Stroke)
     */
    public void drawLine(float x1, float y1, Vector2f endPoint, Stroke temporaryStroke) {
        drawLine(x1, y1, endPoint.getX(), endPoint.getY(), temporaryStroke);
    }

    /**
     * Draws a line by calling the base method
     *
     * @param startPoint the end point
     * @param x2         x position of the end point
     * @param y2         y position of the end point
     * @see #drawLine(float, float, float, float)
     */
    public void drawLine(Vector2f startPoint, float x2, float y2) {
        drawLine(startPoint.getX(), startPoint.getY(), x2, y2);
    }

    /**
     * Draws a line with a temporary Stroke by calling the base method
     *
     * @param startPoint      the end point
     * @param x2              x position of the end point
     * @param y2              y position of the end point
     * @param temporaryStroke the temporary Stroke with which to DRAW the line
     * @see #drawLine(float, float, float, float, Stroke)
     */
    public void drawLine(Vector2f startPoint, float x2, float y2, Stroke temporaryStroke) {
        drawLine(startPoint.getX(), startPoint.getY(), x2, y2, temporaryStroke);
    }

    /*
    Bindings for drawing text
     */

    /**
     * The base method to DRAW a String using the current <code>Font</code> of the graphics
     *
     * @param text the String to be drawn
     * @param x    the x position of the baseLine of the first character
     * @param y    the y position of the baseLine of the first character
     * @see Graphics2D#drawString(String, float, float)
     */
    public void drawText(String text, float x, float y) {
        graphics2D.drawString(text, x, y);
    }

    /**
     * The base method to DRAW a String using a temporary <code>Font</code>
     *
     * @param text          the String to be drawn
     * @param x             the x position of the baseLine of the first character
     * @param y             the y position of the baseLine of the first character
     * @param temporaryFont the temporary Font with which to DRAW the text
     * @see #drawText(String, float, float)
     */
    public void drawText(String text, float x, float y, Font temporaryFont) {

        Font font = getFont();

        setFont(temporaryFont);
        drawText(text, x, y);

        setFont(font);
    }

    /**
     * Draws the given text by calling the base method
     *
     * @param text     the text to be drawn
     * @param position the position of the baseLine of the first letter
     * @see #drawText(String, float, float)
     */
    public void drawText(String text, Vector2f position) {
        drawText(text, position.getX(), position.getY());
    }

    /**
     * Draws the given text with the given temporary Font by calling the base method
     *
     * @param text          the text to be drawn
     * @param position      the position of the baseLine of the first letter
     * @param temporaryFont the temporary Font with which to DRAW the text
     * @see #drawText(String, float, float, Font)
     */
    public void drawText(String text, Vector2f position, Font temporaryFont) {
        drawText(text, position.getX(), position.getY(), temporaryFont);
    }

    /*
    Bindings for setting the configuration of the drawing context
     */

    /**
     * Sets the color of the Graphics
     *
     * @param color the color to be set the graphics to
     * @see Graphics2D#setColor(Color)
     */
    public void setColor(Color color) {
        graphics2D.setColor(color);
    }

    /**
     * Sets the <code>Font</code> of the graphics
     *
     * @param font the new font
     */
    public void setFont(Font font) {
        graphics2D.setFont(font);
    }

    /**
     * Sets the stroke of the Graphics
     *
     * @param stroke the stroke to be set the graphics to
     * @see Graphics2D#setStroke(Stroke)
     */
    public void setStroke(Stroke stroke) {
        graphics2D.setStroke(stroke);
    }

    /**
     * Sets the paint of the graphics
     *
     * @param paint the new paint for the graphics
     * @see Graphics2D#setPaint(Paint)
     */
    public void setPaint(Paint paint) {
        graphics2D.setPaint(paint);
    }

    /**
     * Sets the Composite of the Graphics
     *
     * @param composite the new composite for the graphics
     * @see Graphics2D#setComposite(Composite)
     */
    public void setComposite(Composite composite) {
        graphics2D.setComposite(composite);
    }

    /**
     * Sets the composite of the Graphics
     *
     * @param composite the new composite for the graphics
     * @see Graphics2D#setComposite(Composite)
     */
    public void setAlphaComposite(AlphaComposite composite) {
        graphics2D.setComposite(composite);
    }

    /**
     * Sets the background of the graphics
     *
     * @param color the new background color
     * @see Graphics2D#setBackground(Color)
     */
    public void setBackground(Color color) {
        graphics2D.setBackground(color);
    }

    /**
     * The base method to set the clipping of the graphics.
     * The graphics will from then only be repainted in the specified Shape.
     * This can be used multiple times during the rendering process.
     *
     * @param shape the new clipping area
     *
     * @see Shape
     * @see Graphics2D#setClip(Shape)
     */
    public void setClip(Shape shape) {
        graphics2D.setClip(shape);
    }

    /**
     * Sets the clipping area by calling the base method with the default {@link java.awt.geom.Rectangle2D} of the
     * given {@link Transform}
     *
     * @param transform the {@link Transform} for the new Rectangle clipping area
     *
     * @see Transform
     * @see java.awt.geom.Rectangle2D
     * @see #setClip(Shape)
     */
    public void setClip(Transform transform) {
        setClip(transform.getRect());
    }

    /**
     * Sets the clipping area by calling the base method.
     *
     * @param x the x position of the clipping rect
     * @param y the y position of the clipping rect
     * @param width the width of the clipping rect
     * @param height the height of the clipping rect
     */
    public void setClip(float x, float y, float width, float height) {
        setClip(new Transform(x, y, width, height));
    }

    /*
    Bindings for getting the configuration of the drawing context
     */

    /**
     * Returns the current color of the Graphics.
     * With this Color, all of the primitives (e.g. Rectangles, Ovals) are filled and outlined
     *
     * @return the current color of the graphics
     * @see Graphics2D#getColor()
     */
    public Color getColor() {
        return graphics2D.getColor();
    }

    /**
     * Returns the current Font of the Graphics.
     * With this Font, all of the text is drawn
     *
     * @return the current font of the graphics
     * @see Graphics2D#getFont()
     */
    public Font getFont() {
        return graphics2D.getFont();
    }

    /**
     * Returns the current <code>FontRenderContext</code> of the graphics
     *
     * @return the current <code>FontRenderContext</code> of the graphics
     * @see Graphics2D#getFontMetrics()
     */
    public FontMetrics getFontMetrics() {
        return graphics2D.getFontMetrics();
    }

    /**
     * Returns the current Stroke of the Graphics.
     * The Stroke defines how to DRAW lines (e.g. outlines)
     *
     * @return the current Stroke of the graphics
     * @see Graphics2D#getStroke()
     */
    public Stroke getStroke() {
        return graphics2D.getStroke();
    }

    /**
     * Returns the current Paint of the Graphics.
     * With this paint, all of the primitives (e.g. Rectangles and Ovals) are filled.
     * Default for this is a plain Color
     *
     * @return the current Paint of the graphics
     * @see Graphics2D#getPaint()
     */
    public Paint getPaint() {
        return graphics2D.getPaint();
    }

    /**
     * Returns the current Composite of the graphics
     *
     * @return the current Composite of the graphics
     * @see Graphics2D#getComposite()
     */
    public Composite getComposite() {
        return graphics2D.getComposite();
    }

    /**
     * Returns the current background color of the graphics
     *
     * @return the current background color of the graphics
     * @see Graphics2D#getBackground()
     */
    public Color getBackgroundColor() {
        return graphics2D.getBackground();
    }
}
