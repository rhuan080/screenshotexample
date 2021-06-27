package net.rhuanrocha;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AppTest 
{
    @Test
    public void shouldExtractScreenShotFullScreen() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("single-screen.bmp");
        ImageIO.write(capture, "bmp", imageFile );
        assertTrue(imageFile .exists());

    }

    @Test
    public void shouldExtractScreenShotWithoutFullScreen() throws Exception {
        int x = 250;
        int y = 0;
        int width = 200;
        int height = 100;
        Rectangle screenRect = new Rectangle(x,y,width,height);
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("single-screen-component.bmp");
        ImageIO.write(capture, "bmp", imageFile );
        assertTrue(imageFile .exists());
    }

    @Test
    public void shouldExtractScreenShot50Percent() throws Exception {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth()/2;
        int height = gd.getDisplayMode().getHeight()/2;
        int x = gd.getDisplayMode().getWidth()/2;
        int y = 0;

        Rectangle screenRect = new Rectangle(x,y,width,height);
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("single-screen-50percent.bmp");
        ImageIO.write(capture, "bmp", imageFile );
        assertTrue(imageFile .exists());
    }


}
