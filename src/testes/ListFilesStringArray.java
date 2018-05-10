package testes;

import java.io.File;
import java.io.FilenameFilter;

public class ListFilesStringArray {

	public static void main(String[] args) {
		File dir = new File("c:/");
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		String[] files = dir.list(filter);
		System.out.println(files);
		System.out.println(files.length);
		
		for(String s : files) {
			System.out.println(s);
		}
	}

}
