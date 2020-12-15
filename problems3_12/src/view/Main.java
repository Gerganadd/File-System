package view;

import javax.swing.JFrame;

import problems3_12.File;
import problems3_12.FileSystemObject;
import problems3_12.Folder;

public class Main {

	public static void main(String[] args) {
		
		Folder documents = new Folder("Documents");
		File firstFile = new File("homework_BEL", 30);
		File secondFile = new File("homework_MAT", 31);
		documents.add(firstFile);
		documents.add(secondFile);
		
		Folder pictures = new Folder("Pictures");
		File thirdFile = new File("Background.jpg", 10);
		File fourthFile = new File("image.png", 30);
		pictures.add(thirdFile);
		pictures.add(fourthFile);
		
		Folder downloads = new Folder("Downloads");
		File fifthFile = new File("instuction.docx", 30);
		downloads.add(fifthFile);
		
		Folder desktop = new Folder("Desktop");
		File sixthFile = new File("Google Chrome", 60);
		desktop.add(sixthFile);
		desktop.add(pictures);
		
		FileSystemObject[] objects = {documents, pictures, downloads, desktop};
		FileSystemObjectView view = new FileSystemObjectView(objects);
		
		JFrame app = new JFrame("FileExpoler");
	    app.setLocationRelativeTo(null);
	    app.setBounds(100, 100, 500, 500);
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    app.setVisible(true);
	    
	    app.add(view);

	}

}
