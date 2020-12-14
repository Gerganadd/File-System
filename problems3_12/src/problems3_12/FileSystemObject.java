package problems3_12;

public abstract class FileSystemObject 
{
	public final String DEFAULT_NAME = "new";
	
	private String name;
	
	public FileSystemObject()
	{
		setName(null);
	}
	
	public FileSystemObject(String name)
	{
		setName(name);
	}
	
	public void setName(String name)
	{
		if (name != null && !name.isEmpty())
		{
			this.name = name;
		}
		else 
		{
			this.name = DEFAULT_NAME;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public abstract int getSize();

}
