package problems3_12;

public class File extends FileSystemObject 
{
	private int size;
	
	public File()
	{
		super();
		setSize(0);
	}
	
	public File(int size)
	{
		super();
		setSize(size);
	}
	
	public File(String name, int size)
	{
		super(name);
		setSize(size);
	}
	
	private void setSize(int size)
	{
		if (size >= 0) this.size = size;
	}
	
	@Override
	public int getSize() 
	{
		return size;
	}

}
