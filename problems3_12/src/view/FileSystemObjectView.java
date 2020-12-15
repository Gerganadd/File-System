package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import problems3_12.File;
import problems3_12.FileSystemObject;
import problems3_12.Folder;

public class FileSystemObjectView extends JComponent
{
	public final int START_POINT_X = 10;
	public final int START_POINT_Y = 10;
	public final int SQUARE_SIZE = 15;
	public final int SPACE = 5;
	
	private FileSystemObject[] objects;
	private int lastElement;
	
	public FileSystemObjectView(FileSystemObject[] objects)
	{
		this.objects = objects;
		
		int i = 0;
		for(; i < objects.length && objects[i] != null; i++);
		this.lastElement = i;
	}
	
	private int calculateY(int number)
	{
		return (SQUARE_SIZE + SPACE) * (1 + number);
	}
	
	private void drawFolder(int x, int y, FileSystemObject object, Graphics2D g)
	{
		g.setColor(Color.yellow);
		g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
		g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
		
		g.setColor(Color.black);
		String name = String.format("%s (%d bytes)", object.getName(), object.getSize());
		x += SQUARE_SIZE + SPACE;
		g.drawString(name, x, y + SQUARE_SIZE);
		
		Folder currentFolder = (Folder) object;
		for(FileSystemObject o : currentFolder.getArray())
		{
			if (o == null) break;
			y += SQUARE_SIZE + SPACE;
			
			if (o.getClass().equals(File.class))
			{
				drawFile(x, y, o, g);
			}
			else 
			{
				drawFolder(x, y, o, g);
				x += SQUARE_SIZE + SPACE;
			}
		}
	}
	
	private void drawFile(int x, int y, FileSystemObject object, Graphics2D g)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
		g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
		
		g.setColor(Color.black);
		String name = String.format("%s (%d bytes)", object.getName(), object.getSize());
		x += SQUARE_SIZE + SPACE;
		g.drawString(name, x, y + SQUARE_SIZE);
		
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D)graphics;
		
		int x = START_POINT_X;
		int y = START_POINT_Y;
		
		for (int i = 0; i < lastElement; i++)
		{
			if (objects[i].getClass().equals(Folder.class))
			{
				drawFolder(x, y, objects[i], g);
				Folder currentFolder = (Folder) objects[i];
				y += calculateY(currentFolder.getLastIndex());
			}
			else 
			{
				drawFile(x, y, objects[i], g);
			}
			y += SQUARE_SIZE + SPACE;
		}
	}
}
