// GraphicsLab08st.java
// The Paint Brush Program
// Student Version


// The Student version starts with just one color (red) and all that can be drawn is one pixel at a time.



import java.applet.Applet;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class GraphicsLab08v110ChivallatiPearce extends Applet
{
	Rectangle red , green , blue , yellow , black , tool1 , tool2 , tool3 , tool4 , tool5 , tool6;
	int numColor, numTool, newX, newY , oldX , oldY , appletWidth , appletHeight;
	Graphics gBuffer;
	Image virtualMem;

	public void init()
	{
		numColor = 1;
		numTool = 1;

		red = new Rectangle(5,5,42,42);
		green = new Rectangle( 5, 47, 42, 42 );
		blue = new Rectangle(5,89,42,42);
		yellow = new Rectangle(5,131,42,42);
		black = new Rectangle(5,173,42,42);
		tool1 = new Rectangle(50 , 10 , 200 , 10);
		tool2 = new Rectangle(350 , 10 , 200 , 10);
		tool3 = new Rectangle(50 , 25 , 200 , 10);
		tool4 = new Rectangle(50 , 40 , 200 , 10);
		tool5 = new Rectangle(50 , 55 , 200 , 10);

		appletWidth = getWidth();
		appletHeight = getHeight();
		virtualMem = createImage( appletWidth, appletHeight );
		gBuffer = virtualMem.getGraphics();
		gBuffer.setColor( Color.white );
		gBuffer.fillRect( 0, 0, appletWidth, appletHeight );
	}

	public void paint(Graphics g)
	{
		switch (numColor)
		{
			case 1 : gBuffer.setColor(Color.red);
				break;
			case 2 : gBuffer.setColor(Color.green);
				break;
			case 3 : gBuffer.setColor(Color.blue);
				break;
			case 4 : gBuffer.setColor(Color.yellow);
				break;
			case 5 : gBuffer.setColor(Color.black);
				break;
		}


		switch (numTool)
		{
			case 1 : gBuffer.fillRect( oldX, oldY, 2, 2 );
				break;
			case 2 : gBuffer.drawLine( oldX, oldY, newX, newY );
				break;
			case 3 : gBuffer.fillRect( oldX, oldY, 2, 2 );
				break;
			case 4 : gBuffer.fillRect( oldX, oldY, 40, 35 );
				break;
			case 5:
				gBuffer.fillRect( oldX, oldY, 75,50 );
				break;
		}

		gBuffer.setColor(Color.darkGray);
		gBuffer.fillRect(0,0,55,225);
		gBuffer.fillRect(55,0,appletWidth,75);

		gBuffer.setColor(Color.red);
		gBuffer.fillRect( 5, 5, 42, 42 );

		gBuffer.setColor( Color.green );
		gBuffer.fillRect( 5, 47, 42, 42 );

		gBuffer.setColor( Color.blue );
		gBuffer.fillRect(5,89,42,42);

		gBuffer.setColor(Color.yellow);
		gBuffer.fillRect(5,131,42,42);

		gBuffer.setColor(Color.black);
		gBuffer.fillRect(5,173,42,42);

		gBuffer.setColor(Color.white);
		gBuffer.fillRect( 349, 10, 200, 11 );
		gBuffer.fillRect( 49, 10, 200, 11 );
		gBuffer.fillRect( 49, 25, 200, 11 );
		gBuffer.fillRect( 49, 40, 200, 11 );
		gBuffer.fillRect( 49, 55, 200, 11 );

		gBuffer.setColor( Color.black );
		gBuffer.drawString( "Click to choose the Free-Paint Tool", 50, 20 );

		gBuffer.drawString("Click to choose the Line Tool" , 350 , 20);

		gBuffer.setColor(Color.white);
		gBuffer.drawString("Click the color squares to change paint color" , 550 , 20);

		gBuffer.setColor( Color.black );
		gBuffer.drawString("Click to use the Pen" , 50 , 35);

		gBuffer.drawString("Click to use the Brush" , 50 , 50);

		gBuffer.drawString( "Click to use the Roller", 50, 65 );

		g.drawImage(virtualMem,0,0,this);
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		if(red.inside(x,y)) {
			numColor = 1;
		} else if (green.inside(x , y)) {
			numColor = 2;
		} else if (blue.inside(x , y)) {
			numColor = 3;
		} else if (yellow.inside(x , y)) {
			numColor = 4;
		} else if (black.inside(x , y)) {
			numColor = 5;
		}

		if (tool1.inside(x,y)) {
			numTool = 1;
		} else if (tool2.inside(x , y)) {
			numTool = 2;
		} else if (tool3.inside(x,y)) {
			numTool = 3;
		} else if (tool4.inside(x,y)) {
			numTool = 4;
		} else if (tool5.inside(x,y)) {
			numTool = 5;
		}

		newX = x;
		newY = y;
		oldX = newX;
		oldY = newY;
		repaint();
		return true;
	}

	public boolean mouseDrag(Event e, int x, int y)
	{
		if (numTool == 2) {
			newX = x;
			newY = y;
		} else {
			newX = x;
			newY = y;
			oldX = newX;
			oldY = newY;
		}

		repaint();
		return true;
	}

	public void update(Graphics g)
	{
		paint(g);
	}

}