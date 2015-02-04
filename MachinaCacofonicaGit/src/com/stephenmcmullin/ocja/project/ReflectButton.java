/* A class to create buttons with reflections underneath.
 * 
 */

package com.stephenmcmullin.ocja.project;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ReflectButton extends JPanel{

    private BufferedImage image;

    public ReflectButton(String str) {
        try {
            image = ImageIO.read(getClass().getResource(str));
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public void paintComponent( Graphics g ) {
        Graphics2D g2d = (Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        int gap = 0;
        float opacity = 0.2f;
        float fadeHeight = 0.5f;

        g2d.setPaint( new GradientPaint( 0, 0, new Color(0,0,0,0), 0, height, new Color(0,0,0,0)) );
        g2d.fillRect( 0, 0, width, height );
        g2d.translate( (width-imageWidth)/2, height/2-imageHeight );
        g2d.drawRenderedImage( image, null );
        g2d.translate( 0, 2*imageHeight+gap );
        g2d.scale( 1, -1 );

        BufferedImage reflection = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
		Graphics2D rg = reflection.createGraphics();
        rg.drawRenderedImage( image, null );
		rg.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_IN ) );
        rg.setPaint( 
            new GradientPaint( 
                0, imageHeight*fadeHeight, new Color( 0.0f, 0.0f, 0.0f, 0.0f ),
                0, 150, new Color( 0.0f, 0.0f, 0.0f, opacity )
            )
        );
        rg.fillRect( 0, 0, imageWidth, imageHeight );
        rg.dispose();
        g2d.drawRenderedImage( reflection, null );
    }
}