package problems3_12;

public class Folder extends FileSystemObject {
	public final int ARRAY_LENGHT = 10;
	public final int DEFAULT_SIZE = 0;
	
	private FileSystemObject[] array;
	private int size;
	private int lastIndex;
	
	public Folder()
	{
		super();
		this.array = new FileSystemObject[ARRAY_LENGHT];
		this.size = DEFAULT_SIZE;
		this.lastIndex = 0;
	}
	
	public Folder(String name)
	{
		super(name);
		this.array = new FileSystemObject[ARRAY_LENGHT];
		this.size = DEFAULT_SIZE;
		this.lastIndex = 0;
	}
	
	public Folder(String name, int size)
	{
		super(name);
		this.array = new FileSystemObject[ARRAY_LENGHT];
		this.size = size;
		this.lastIndex = 0;
	}
	
	public Folder(FileSystemObject o)
	{
		this.array[lastIndex] = o;
		lastIndex++;
	}
	
	public FileSystemObject[] getArray()
	{
		return this.array;
	}
	
	public int getLastIndex()
	{
		return this.lastIndex;
	}
	
	private boolean isExist(FileSystemObject o)
	{
		for (int i = 0; i < this.lastIndex; i++)
		{
			if (this.array[i].getName().equals(o.getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	private void sumSizes()
	{
		int sum = 0;
		for (int i = 0; i < this.lastIndex; i++)
		{
			sum += array[i].getSize();
		}
		
		this.size = sum;
	}
	
	public void add(FileSystemObject î)
	{
		if (!isExist(î))
		{
			this.array[lastIndex] = î;
			lastIndex++;
		}
	}
	
	@Override
	public int getSize() {
		sumSizes();
		return this.size;
	}

}
