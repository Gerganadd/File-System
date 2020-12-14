package problems3_12;

public class Main 
{
	public static void main(String[] args) 
	{
		Folder f = new Folder();
		
		File file1 = new File("f1", 35);
		File file2 = new File("f2", 35);
		
		f.add(file1);
		f.add(file2);
		
		System.out.println(f.getSize());
		
	}

}
