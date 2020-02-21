package Runecessor;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * Created by Jason MacKeigan on 2018-05-23 at 6:02 PM
 */
public class EmptyGraphics extends Graphics {

    /**
     * Creates a new <code>Graphics</code> object that is
     * a copy of this <code>Graphics</code> object.
     *
     * @return a new graphics context that is a copy of
     * this graphics context.
     */
    @Override
    public Graphics create() {
        return null;
    }

    /**
     * Translates the origin of the graphics context to the point
     * (<i>x</i>,&nbsp;<i>y</i>) in the current coordinate system.
     * Modifies this graphics context so that its new origin corresponds
     * to the point (<i>x</i>,&nbsp;<i>y</i>) in this graphics context's
     * original coordinate system.  All coordinates used in subsequent
     * rendering operations on this graphics context will be relative
     * to this new origin.
     *
     * @param x the <i>x</i> coordinate.
     * @param y the <i>y</i> coordinate.
     */
    @Override
    public void translate(int x, int y) {

    }

    /**
     * Gets this graphics context's current color.
     *
     * @return this graphics context's current color.
     * @see Color
     * @see Graphics#setColor(Color)
     */
    @Override
    public Color getColor() {
        return null;
    }

    /**
     * Sets this graphics context's current color to the specified
     * color. All subsequent graphics operations using this graphics
     * context use this specified color.
     *
     * @param c the new rendering color.
     * @see Color
     * @see Graphics#getColor
     */
    @Override
    public void setColor(Color c) {

    }

    /**
     * Sets the paint mode of this graphics context to overwrite the
     * destination with this graphics context's current color.
     * This sets the logical pixel operation function to the paint or
     * overwrite mode.  All subsequent rendering operations will
     * overwrite the destination with the current color.
     */
    @Override
    public void setPaintMode() {

    }

    /**
     * Sets the paint mode of this graphics context to alternate between
     * this graphics context's current color and the new specified color.
     * This specifies that logical pixel operations are performed in the
     * XOR mode, which alternates pixels between the current color and
     * a specified XOR color.
     * <p>
     * When drawing operations are performed, pixels which are the
     * current color are changed to the specified color, and vice versa.
     * <p>
     * Pixels that are of colors other than those two colors are changed
     * in an unpredictable but reversible manner; if the same figure is
     * drawn twice, then all pixels are restored to their original values.
     *
     * @param c1 the XOR alternation color
     */
    @Override
    public void setXORMode(Color c1) {

    }

    /**
     * Gets the current font.
     *
     * @return this graphics context's current font.
     * @see Font
     * @see Graphics#setFont(Font)
     */
    @Override
    public Font getFont() {
        return null;
    }

    /**
     * Sets this graphics context's font to the specified font.
     * All subsequent text operations using this graphics context
     * use this font. A null argument is silently ignored.
     *
     * @param font the font.
     * @see Graphics#getFont
     * @see Graphics#drawString(String, int, int)
     * @see Graphics#drawBytes(byte[], int, int, int, int)
     * @see Graphics#drawChars(char[], int, int, int, int)
     */
    @Override
    public void setFont(Font font) {

    }

    /**
     * Gets the font metrics for the specified font.
     *
     * @param f the specified font
     * @return the font metrics for the specified font.
     * @see Graphics#getFont
     * @see FontMetrics
     * @see Graphics#getFontMetrics()
     */
    @Override
    public FontMetrics getFontMetrics(Font f) {
        return null;
    }

    /**
     * Returns the bounding rectangle of the current clipping area.
     * This method refers to the user clip, which is independent of the
     * clipping associated with device bounds and window visibility.
     * If no clip has previously been set, or if the clip has been
     * cleared using <code>setClip(null)</code>, this method returns
     * <code>null</code>.
     * The coordinates in the rectangle are relative to the coordinate
     * system origin of this graphics context.
     *
     * @return the bounding rectangle of the current clipping area,
     * or <code>null</code> if no clip is set.
     * @see Graphics#getClip
     * @see Graphics#clipRect
     * @see Graphics#setClip(int, int, int, int)
     * @see Graphics#setClip(Shape)
     * @since JDK1.1
     */
    @Override
    public Rectangle getClipBounds() {
        return null;
    }

    /**
     * Intersects the current clip with the specified rectangle.
     * The resulting clipping area is the intersection of the current
     * clipping area and the specified rectangle.  If there is no
     * current clipping area, either because the clip has never been
     * set, or the clip has been cleared using <code>setClip(null)</code>,
     * the specified rectangle becomes the new clip.
     * This method sets the user clip, which is independent of the
     * clipping associated with device bounds and window visibility.
     * This method can only be used to make the current clip smaller.
     * To set the current clip larger, use any of the setClip methods.
     * Rendering operations have no effect outside of the clipping area.
     *
     * @param x      the x coordinate of the rectangle to intersect the clip with
     * @param y      the y coordinate of the rectangle to intersect the clip with
     * @param width  the width of the rectangle to intersect the clip with
     * @param height the height of the rectangle to intersect the clip with
     * @see #setClip(int, int, int, int)
     * @see #setClip(Shape)
     */
    @Override
    public void clipRect(int x, int y, int width, int height) {

    }

    /**
     * Sets the current clip to the rectangle specified by the given
     * coordinates.  This method sets the user clip, which is
     * independent of the clipping associated with device bounds
     * and window visibility.
     * Rendering operations have no effect outside of the clipping area.
     *
     * @param x      the <i>x</i> coordinate of the new clip rectangle.
     * @param y      the <i>y</i> coordinate of the new clip rectangle.
     * @param width  the width of the new clip rectangle.
     * @param height the height of the new clip rectangle.
     * @see Graphics#clipRect
     * @see Graphics#setClip(Shape)
     * @see Graphics#getClip
     * @since JDK1.1
     */
    @Override
    public void setClip(int x, int y, int width, int height) {

    }

    /**
     * Gets the current clipping area.
     * This method returns the user clip, which is independent of the
     * clipping associated with device bounds and window visibility.
     * If no clip has previously been set, or if the clip has been
     * cleared using <code>setClip(null)</code>, this method returns
     * <code>null</code>.
     *
     * @return a <code>Shape</code> object representing the
     * current clipping area, or <code>null</code> if
     * no clip is set.
     * @see Graphics#getClipBounds
     * @see Graphics#clipRect
     * @see Graphics#setClip(int, int, int, int)
     * @see Graphics#setClip(Shape)
     * @since JDK1.1
     */
    @Override
    public Shape getClip() {
        return null;
    }

    /**
     * Sets the current clipping area to an arbitrary clip shape.
     * Not all objects that implement the <code>Shape</code>
     * interface can be used to set the clip.  The only
     * <code>Shape</code> objects that are guaranteed to be
     * supported are <code>Shape</code> objects that are
     * obtained via the <code>getClip</code> method and via
     * <code>Rectangle</code> objects.  This method sets the
     * user clip, which is independent of the clipping associated
     * with device bounds and window visibility.
     *
     * @param clip the <code>Shape</code> to use to set the clip
     * @see Graphics#getClip()
     * @see Graphics#clipRect
     * @see Graphics#setClip(int, int, int, int)
     * @since JDK1.1
     */
    @Override
    public void setClip(Shape clip) {

    }

    /**
     * Copies an area of the component by a distance specified by
     * <code>dx</code> and <code>dy</code>. From the point specified
     * by <code>x</code> and <code>y</code>, this method
     * copies downwards and to the right.  To copy an area of the
     * component to the left or upwards, specify a negative value for
     * <code>dx</code> or <code>dy</code>.
     * If a portion of the source rectangle lies outside the bounds
     * of the component, or is obscured by another window or component,
     * <code>copyArea</code> will be unable to copy the associated
     * pixels. The area that is omitted can be refreshed by calling
     * the component's <code>paint</code> method.
     *
     * @param x      the <i>x</i> coordinate of the source rectangle.
     * @param y      the <i>y</i> coordinate of the source rectangle.
     * @param width  the width of the source rectangle.
     * @param height the height of the source rectangle.
     * @param dx     the horizontal distance to copy the pixels.
     * @param dy     the vertical distance to copy the pixels.
     */
    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {

    }

    /**
     * Draws a line, using the current color, between the points
     * <code>(x1,&nbsp;y1)</code> and <code>(x2,&nbsp;y2)</code>
     * in this graphics context's coordinate system.
     *
     * @param x1 the first point's <i>x</i> coordinate.
     * @param y1 the first point's <i>y</i> coordinate.
     * @param x2 the second point's <i>x</i> coordinate.
     * @param y2 the second point's <i>y</i> coordinate.
     */
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

    }

    /**
     * Fills the specified rectangle.
     * The left and right edges of the rectangle are at
     * <code>x</code> and <code>x&nbsp;+&nbsp;width&nbsp;-&nbsp;1</code>.
     * The top and bottom edges are at
     * <code>y</code> and <code>y&nbsp;+&nbsp;height&nbsp;-&nbsp;1</code>.
     * The resulting rectangle covers an area
     * <code>width</code> pixels wide by
     * <code>height</code> pixels tall.
     * The rectangle is filled using the graphics context's current color.
     *
     * @param x      the <i>x</i> coordinate
     *               of the rectangle to be filled.
     * @param y      the <i>y</i> coordinate
     *               of the rectangle to be filled.
     * @param width  the width of the rectangle to be filled.
     * @param height the height of the rectangle to be filled.
     * @see Graphics#clearRect
     * @see Graphics#drawRect
     */
    @Override
    public void fillRect(int x, int y, int width, int height) {

    }

    /**
     * Clears the specified rectangle by filling it with the background
     * color of the current drawing surface. This operation does not
     * use the current paint mode.
     * <p>
     * Beginning with Java&nbsp;1.1, the background color
     * of offscreen images may be system dependent. Applications should
     * use <code>setColor</code> followed by <code>fillRect</code> to
     * ensure that an offscreen image is cleared to a specific color.
     *
     * @param x      the <i>x</i> coordinate of the rectangle to clear.
     * @param y      the <i>y</i> coordinate of the rectangle to clear.
     * @param width  the width of the rectangle to clear.
     * @param height the height of the rectangle to clear.
     * @see Graphics#fillRect(int, int, int, int)
     * @see Graphics#drawRect
     * @see Graphics#setColor(Color)
     * @see Graphics#setPaintMode
     * @see Graphics#setXORMode(Color)
     */
    @Override
    public void clearRect(int x, int y, int width, int height) {

    }

    /**
     * Draws an outlined round-cornered rectangle using this graphics
     * context's current color. The left and right edges of the rectangle
     * are at <code>x</code> and <code>x&nbsp;+&nbsp;width</code>,
     * respectively. The top and bottom edges of the rectangle are at
     * <code>y</code> and <code>y&nbsp;+&nbsp;height</code>.
     *
     * @param x         the <i>x</i> coordinate of the rectangle to be drawn.
     * @param y         the <i>y</i> coordinate of the rectangle to be drawn.
     * @param width     the width of the rectangle to be drawn.
     * @param height    the height of the rectangle to be drawn.
     * @param arcWidth  the horizontal diameter of the arc
     *                  at the four corners.
     * @param arcHeight the vertical diameter of the arc
     *                  at the four corners.
     * @see Graphics#fillRoundRect
     */
    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

    }

    /**
     * Fills the specified rounded corner rectangle with the current color.
     * The left and right edges of the rectangle
     * are at <code>x</code> and <code>x&nbsp;+&nbsp;width&nbsp;-&nbsp;1</code>,
     * respectively. The top and bottom edges of the rectangle are at
     * <code>y</code> and <code>y&nbsp;+&nbsp;height&nbsp;-&nbsp;1</code>.
     *
     * @param x         the <i>x</i> coordinate of the rectangle to be filled.
     * @param y         the <i>y</i> coordinate of the rectangle to be filled.
     * @param width     the width of the rectangle to be filled.
     * @param height    the height of the rectangle to be filled.
     * @param arcWidth  the horizontal diameter
     *                  of the arc at the four corners.
     * @param arcHeight the vertical diameter
     *                  of the arc at the four corners.
     * @see Graphics#drawRoundRect
     */
    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

    }

    /**
     * Draws the outline of an oval.
     * The result is a circle or ellipse that fits within the
     * rectangle specified by the <code>x</code>, <code>y</code>,
     * <code>width</code>, and <code>height</code> arguments.
     * <p>
     * The oval covers an area that is
     * <code>width&nbsp;+&nbsp;1</code> pixels wide
     * and <code>height&nbsp;+&nbsp;1</code> pixels tall.
     *
     * @param x      the <i>x</i> coordinate of the upper left
     *               corner of the oval to be drawn.
     * @param y      the <i>y</i> coordinate of the upper left
     *               corner of the oval to be drawn.
     * @param width  the width of the oval to be drawn.
     * @param height the height of the oval to be drawn.
     * @see Graphics#fillOval
     */
    @Override
    public void drawOval(int x, int y, int width, int height) {

    }

    /**
     * Fills an oval bounded by the specified rectangle with the
     * current color.
     *
     * @param x      the <i>x</i> coordinate of the upper left corner
     *               of the oval to be filled.
     * @param y      the <i>y</i> coordinate of the upper left corner
     *               of the oval to be filled.
     * @param width  the width of the oval to be filled.
     * @param height the height of the oval to be filled.
     * @see Graphics#drawOval
     */
    @Override
    public void fillOval(int x, int y, int width, int height) {

    }

    /**
     * Draws the outline of a circular or elliptical arc
     * covering the specified rectangle.
     * <p>
     * The resulting arc begins at <code>startAngle</code> and extends
     * for <code>arcAngle</code> degrees, using the current color.
     * Angles are interpreted such that 0&nbsp;degrees
     * is at the 3&nbsp;o'clock position.
     * A positive value indicates a counter-clockwise rotation
     * while a negative value indicates a clockwise rotation.
     * <p>
     * The center of the arc is the center of the rectangle whose origin
     * is (<i>x</i>,&nbsp;<i>y</i>) and whose size is specified by the
     * <code>width</code> and <code>height</code> arguments.
     * <p>
     * The resulting arc covers an area
     * <code>width&nbsp;+&nbsp;1</code> pixels wide
     * by <code>height&nbsp;+&nbsp;1</code> pixels tall.
     * <p>
     * The angles are specified relative to the non-square extents of
     * the bounding rectangle such that 45 degrees always falls on the
     * line from the center of the ellipse to the upper right corner of
     * the bounding rectangle. As a result, if the bounding rectangle is
     * noticeably longer in one axis than the other, the angles to the
     * start and end of the arc segment will be skewed farther along the
     * longer axis of the bounds.
     *
     * @param x          the <i>x</i> coordinate of the
     *                   upper-left corner of the arc to be drawn.
     * @param y          the <i>y</i>  coordinate of the
     *                   upper-left corner of the arc to be drawn.
     * @param width      the width of the arc to be drawn.
     * @param height     the height of the arc to be drawn.
     * @param startAngle the beginning angle.
     * @param arcAngle   the angular extent of the arc,
     *                   relative to the start angle.
     * @see Graphics#fillArc
     */
    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    /**
     * Fills a circular or elliptical arc covering the specified rectangle.
     * <p>
     * The resulting arc begins at <code>startAngle</code> and extends
     * for <code>arcAngle</code> degrees.
     * Angles are interpreted such that 0&nbsp;degrees
     * is at the 3&nbsp;o'clock position.
     * A positive value indicates a counter-clockwise rotation
     * while a negative value indicates a clockwise rotation.
     * <p>
     * The center of the arc is the center of the rectangle whose origin
     * is (<i>x</i>,&nbsp;<i>y</i>) and whose size is specified by the
     * <code>width</code> and <code>height</code> arguments.
     * <p>
     * The resulting arc covers an area
     * <code>width&nbsp;+&nbsp;1</code> pixels wide
     * by <code>height&nbsp;+&nbsp;1</code> pixels tall.
     * <p>
     * The angles are specified relative to the non-square extents of
     * the bounding rectangle such that 45 degrees always falls on the
     * line from the center of the ellipse to the upper right corner of
     * the bounding rectangle. As a result, if the bounding rectangle is
     * noticeably longer in one axis than the other, the angles to the
     * start and end of the arc segment will be skewed farther along the
     * longer axis of the bounds.
     *
     * @param x          the <i>x</i> coordinate of the
     *                   upper-left corner of the arc to be filled.
     * @param y          the <i>y</i>  coordinate of the
     *                   upper-left corner of the arc to be filled.
     * @param width      the width of the arc to be filled.
     * @param height     the height of the arc to be filled.
     * @param startAngle the beginning angle.
     * @param arcAngle   the angular extent of the arc,
     *                   relative to the start angle.
     * @see Graphics#drawArc
     */
    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    /**
     * Draws a sequence of connected lines defined by
     * arrays of <i>x</i> and <i>y</i> coordinates.
     * Each pair of (<i>x</i>,&nbsp;<i>y</i>) coordinates defines a point.
     * The figure is not closed if the first point
     * differs from the last point.
     *
     * @param xPoints an array of <i>x</i> points
     * @param yPoints an array of <i>y</i> points
     * @param nPoints the total number of points
     * @see Graphics#drawPolygon(int[], int[], int)
     * @since JDK1.1
     */
    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

    }

    /**
     * Draws a closed polygon defined by
     * arrays of <i>x</i> and <i>y</i> coordinates.
     * Each pair of (<i>x</i>,&nbsp;<i>y</i>) coordinates defines a point.
     * <p>
     * This method draws the polygon defined by <code>nPoint</code> line
     * segments, where the first <code>nPoint&nbsp;-&nbsp;1</code>
     * line segments are line segments from
     * <code>(xPoints[i&nbsp;-&nbsp;1],&nbsp;yPoints[i&nbsp;-&nbsp;1])</code>
     * to <code>(xPoints[i],&nbsp;yPoints[i])</code>, for
     * 1&nbsp;&le;&nbsp;<i>i</i>&nbsp;&le;&nbsp;<code>nPoints</code>.
     * The figure is automatically closed by drawing a line connecting
     * the final point to the first point, if those points are different.
     *
     * @param xPoints a an array of <code>x</code> coordinates.
     * @param yPoints a an array of <code>y</code> coordinates.
     * @param nPoints a the total number of points.
     * @see Graphics#fillPolygon
     * @see Graphics#drawPolyline
     */
    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    /**
     * Fills a closed polygon defined by
     * arrays of <i>x</i> and <i>y</i> coordinates.
     * <p>
     * This method draws the polygon defined by <code>nPoint</code> line
     * segments, where the first <code>nPoint&nbsp;-&nbsp;1</code>
     * line segments are line segments from
     * <code>(xPoints[i&nbsp;-&nbsp;1],&nbsp;yPoints[i&nbsp;-&nbsp;1])</code>
     * to <code>(xPoints[i],&nbsp;yPoints[i])</code>, for
     * 1&nbsp;&le;&nbsp;<i>i</i>&nbsp;&le;&nbsp;<code>nPoints</code>.
     * The figure is automatically closed by drawing a line connecting
     * the final point to the first point, if those points are different.
     * <p>
     * The area inside the polygon is defined using an
     * even-odd fill rule, also known as the alternating rule.
     *
     * @param xPoints a an array of <code>x</code> coordinates.
     * @param yPoints a an array of <code>y</code> coordinates.
     * @param nPoints a the total number of points.
     * @see Graphics#drawPolygon(int[], int[], int)
     */
    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    /**
     * Draws the text given by the specified string, using this
     * graphics context's current font and color. The baseline of the
     * leftmost character is at position (<i>x</i>,&nbsp;<i>y</i>) in this
     * graphics context's coordinate system.
     *
     * @param str the string to be drawn.
     * @param x   the <i>x</i> coordinate.
     * @param y   the <i>y</i> coordinate.
     * @throws NullPointerException if <code>str</code> is <code>null</code>.
     * @see Graphics#drawBytes
     * @see Graphics#drawChars
     */
    @Override
    public void drawString(String str, int x, int y) {

    }

    /**
     * Renders the text of the specified iterator applying its attributes
     * in accordance with the specification of the
     * {@link TextAttribute TextAttribute} class.
     * <p>
     * The baseline of the leftmost character is at position
     * (<i>x</i>,&nbsp;<i>y</i>) in this graphics context's coordinate system.
     *
     * @param iterator the iterator whose text is to be drawn
     * @param x        the <i>x</i> coordinate.
     * @param y        the <i>y</i> coordinate.
     * @throws NullPointerException if <code>iterator</code> is
     *                              <code>null</code>.
     * @see Graphics#drawBytes
     * @see Graphics#drawChars
     */
    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {

    }

    /**
     * Draws as much of the specified image as is currently available.
     * The image is drawn with its top-left corner at
     * (<i>x</i>,&nbsp;<i>y</i>) in this graphics context's coordinate
     * space. Transparent pixels in the image do not affect whatever
     * pixels are already there.
     * <p>
     * This method returns immediately in all cases, even if the
     * complete image has not yet been loaded, and it has not been dithered
     * and converted for the current output device.
     * <p>
     * If the image has completely loaded and its pixels are
     * no longer being changed, then
     * <code>drawImage</code> returns <code>true</code>.
     * Otherwise, <code>drawImage</code> returns <code>false</code>
     * and as more of
     * the image becomes available
     * or it is time to draw another frame of animation,
     * the process that loads the image notifies
     * the specified image observer.
     *
     * @param img      the specified image to be drawn. This method does
     *                 nothing if <code>img</code> is null.
     * @param x        the <i>x</i> coordinate.
     * @param y        the <i>y</i> coordinate.
     * @param observer object to be notified as more of
     *                 the image is converted.
     * @return <code>false</code> if the image pixels are still changing;
     * <code>true</code> otherwise.
     * @see Image
     * @see ImageObserver
     * @see ImageObserver#imageUpdate(Image, int, int, int, int, int)
     */
    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return false;
    }

    /**
     * Draws as much of the specified image as has already been scaled
     * to fit inside the specified rectangle.
     * <p>
     * The image is drawn inside the specified rectangle of this
     * graphics context's coordinate space, and is scaled if
     * necessary. Transparent pixels do not affect whatever pixels
     * are already there.
     * <p>
     * This method returns immediately in all cases, even if the
     * entire image has not yet been scaled, dithered, and converted
     * for the current output device.
     * If the current output representation is not yet complete, then
     * <code>drawImage</code> returns <code>false</code>. As more of
     * the image becomes available, the process that loads the image notifies
     * the image observer by calling its <code>imageUpdate</code> method.
     * <p>
     * A scaled version of an image will not necessarily be
     * available immediately just because an unscaled version of the
     * image has been constructed for this output device.  Each size of
     * the image may be cached separately and generated from the original
     * data in a separate image production sequence.
     *
     * @param img      the specified image to be drawn. This method does
     *                 nothing if <code>img</code> is null.
     * @param x        the <i>x</i> coordinate.
     * @param y        the <i>y</i> coordinate.
     * @param width    the width of the rectangle.
     * @param height   the height of the rectangle.
     * @param observer object to be notified as more of
     *                 the image is converted.
     * @return <code>false</code> if the image pixels are still changing;
     * <code>true</code> otherwise.
     * @see Image
     * @see ImageObserver
     * @see ImageObserver#imageUpdate(Image, int, int, int, int, int)
     */
    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return false;
    }

    /**
     * Draws as much of the specified image as is currently available.
     * The image is drawn with its top-left corner at
     * (<i>x</i>,&nbsp;<i>y</i>) in this graphics context's coordinate
     * space.  Transparent pixels are drawn in the specified
     * background color.
     * <p>
     * This operation is equivalent to filling a rectangle of the
     * width and height of the specified image with the given color and then
     * drawing the image on top of it, but possibly more efficient.
     * <p>
     * This method returns immediately in all cases, even if the
     * complete image has not yet been loaded, and it has not been dithered
     * and converted for the current output device.
     * <p>
     * If the image has completely loaded and its pixels are
     * no longer being changed, then
     * <code>drawImage</code> returns <code>true</code>.
     * Otherwise, <code>drawImage</code> returns <code>false</code>
     * and as more of
     * the image becomes available
     * or it is time to draw another frame of animation,
     * the process that loads the image notifies
     * the specified image observer.
     *
     * @param img      the specified image to be drawn. This method does
     *                 nothing if <code>img</code> is null.
     * @param x        the <i>x</i> coordinate.
     * @param y        the <i>y</i> coordinate.
     * @param bgcolor  the background color to paint under the
     *                 non-opaque portions of the image.
     * @param observer object to be notified as more of
     *                 the image is converted.
     * @return <code>false</code> if the image pixels are still changing;
     * <code>true</code> otherwise.
     * @see Image
     * @see ImageObserver
     * @see ImageObserver#imageUpdate(Image, int, int, int, int, int)
     */
    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return false;
    }

    /**
     * Draws as much of the specified image as has already been scaled
     * to fit inside the specified rectangle.
     * <p>
     * The image is drawn inside the specified rectangle of this
     * graphics context's coordinate space, and is scaled if
     * necessary. Transparent pixels are drawn in the specified
     * background color.
     * This operation is equivalent to filling a rectangle of the
     * width and height of the specified image with the given color and then
     * drawing the image on top of it, but possibly more efficient.
     * <p>
     * This method returns immediately in all cases, even if the
     * entire image has not yet been scaled, dithered, and converted
     * for the current output device.
     * If the current output representation is not yet complete then
     * <code>drawImage</code> returns <code>false</code>. As more of
     * the image becomes available, the process that loads the image notifies
     * the specified image observer.
     * <p>
     * A scaled version of an image will not necessarily be
     * available immediately just because an unscaled version of the
     * image has been constructed for this output device.  Each size of
     * the image may be cached separately and generated from the original
     * data in a separate image production sequence.
     *
     * @param img      the specified image to be drawn. This method does
     *                 nothing if <code>img</code> is null.
     * @param x        the <i>x</i> coordinate.
     * @param y        the <i>y</i> coordinate.
     * @param width    the width of the rectangle.
     * @param height   the height of the rectangle.
     * @param bgcolor  the background color to paint under the
     *                 non-opaque portions of the image.
     * @param observer object to be notified as more of
     *                 the image is converted.
     * @return <code>false</code> if the image pixels are still changing;
     * <code>true</code> otherwise.
     * @see Image
     * @see ImageObserver
     * @see ImageObserver#imageUpdate(Image, int, int, int, int, int)
     */
    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return false;
    }

    /**
     * Draws as much of the specified area of the specified image as is
     * currently available, scaling it on the fly to fit inside the
     * specified area of the destination drawable surface. Transparent pixels
     * do not affect whatever pixels are already there.
     * <p>
     * This method returns immediately in all cases, even if the
     * image area to be drawn has not yet been scaled, dithered, and converted
     * for the current output device.
     * If the current output representation is not yet complete then
     * <code>drawImage</code> returns <code>false</code>. As more of
     * the image becomes available, the process that loads the image notifies
     * the specified image observer.
     * <p>
     * This method always uses the unscaled version of the image
     * to render the scaled rectangle and performs the required
     * scaling on the fly. It does not use a cached, scaled version
     * of the image for this operation. Scaling of the image from source
     * to destination is performed such that the first coordinate
     * of the source rectangle is mapped to the first coordinate of
     * the destination rectangle, and the second source coordinate is
     * mapped to the second destination coordinate. The subimage is
     * scaled and flipped as needed to preserve those mappings.
     *
     * @param img      the specified image to be drawn. This method does
     *                 nothing if <code>img</code> is null.
     * @param dx1      the <i>x</i> coordinate of the first corner of the
     *                 destination rectangle.
     * @param dy1      the <i>y</i> coordinate of the first corner of the
     *                 destination rectangle.
     * @param dx2      the <i>x</i> coordinate of the second corner of the
     *                 destination rectangle.
     * @param dy2      the <i>y</i> coordinate of the second corner of the
     *                 destination rectangle.
     * @param sx1      the <i>x</i> coordinate of the first corner of the
     *                 source rectangle.
     * @param sy1      the <i>y</i> coordinate of the first corner of the
     *                 source rectangle.
     * @param sx2      the <i>x</i> coordinate of the second corner of the
     *                 source rectangle.
     * @param sy2      the <i>y</i> coordinate of the second corner of the
     *                 source rectangle.
     * @param observer object to be notified as more of the image is
     *                 scaled and converted.
     * @return <code>false</code> if the image pixels are still changing;
     * <code>true</code> otherwise.
     * @see Image
     * @see ImageObserver
     * @see ImageObserver#imageUpdate(Image, int, int, int, int, int)
     * @since JDK1.1
     */
    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        return false;
    }

    /**
     * Draws as much of the specified area of the specified image as is
     * currently available, scaling it on the fly to fit inside the
     * specified area of the destination drawable surface.
     * <p>
     * Transparent pixels are drawn in the specified background color.
     * This operation is equivalent to filling a rectangle of the
     * width and height of the specified image with the given color and then
     * drawing the image on top of it, but possibly more efficient.
     * <p>
     * This method returns immediately in all cases, even if the
     * image area to be drawn has not yet been scaled, dithered, and converted
     * for the current output device.
     * If the current output representation is not yet complete then
     * <code>drawImage</code> returns <code>false</code>. As more of
     * the image becomes available, the process that loads the image notifies
     * the specified image observer.
     * <p>
     * This method always uses the unscaled version of the image
     * to render the scaled rectangle and performs the required
     * scaling on the fly. It does not use a cached, scaled version
     * of the image for this operation. Scaling of the image from source
     * to destination is performed such that the first coordinate
     * of the source rectangle is mapped to the first coordinate of
     * the destination rectangle, and the second source coordinate is
     * mapped to the second destination coordinate. The subimage is
     * scaled and flipped as needed to preserve those mappings.
     *
     * @param img      the specified image to be drawn. This method does
     *                 nothing if <code>img</code> is null.
     * @param dx1      the <i>x</i> coordinate of the first corner of the
     *                 destination rectangle.
     * @param dy1      the <i>y</i> coordinate of the first corner of the
     *                 destination rectangle.
     * @param dx2      the <i>x</i> coordinate of the second corner of the
     *                 destination rectangle.
     * @param dy2      the <i>y</i> coordinate of the second corner of the
     *                 destination rectangle.
     * @param sx1      the <i>x</i> coordinate of the first corner of the
     *                 source rectangle.
     * @param sy1      the <i>y</i> coordinate of the first corner of the
     *                 source rectangle.
     * @param sx2      the <i>x</i> coordinate of the second corner of the
     *                 source rectangle.
     * @param sy2      the <i>y</i> coordinate of the second corner of the
     *                 source rectangle.
     * @param bgcolor  the background color to paint under the
     *                 non-opaque portions of the image.
     * @param observer object to be notified as more of the image is
     *                 scaled and converted.
     * @return <code>false</code> if the image pixels are still changing;
     * <code>true</code> otherwise.
     * @see Image
     * @see ImageObserver
     * @see ImageObserver#imageUpdate(Image, int, int, int, int, int)
     * @since JDK1.1
     */
    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        return false;
    }

    /**
     * Disposes of this graphics context and releases
     * any system resources that it is using.
     * A <code>Graphics</code> object cannot be used after
     * <code>dispose</code>has been called.
     * <p>
     * When a Java program runs, a large number of <code>Graphics</code>
     * objects can be created within a short time frame.
     * Although the finalization process of the garbage collector
     * also disposes of the same system resources, it is preferable
     * to manually free the associated resources by calling this
     * method rather than to rely on a finalization process which
     * may not run to completion for a long period of time.
     * <p>
     * Graphics objects which are provided as arguments to the
     * <code>paint</code> and <code>update</code> methods
     * of components are automatically released by the system when
     * those methods return. For efficiency, programmers should
     * call <code>dispose</code> when finished using
     * a <code>Graphics</code> object only if it was created
     * directly from a component or another <code>Graphics</code> object.
     *
     * @see Graphics#finalize
     * @see Component#paint
     * @see Component#update
     * @see Component#getGraphics
     * @see Graphics#create
     */
    @Override
    public void dispose() {

    }
}
