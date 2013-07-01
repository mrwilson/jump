package uk.co.probablyfine.jump.core;

import java.io.File;
import java.io.IOException;

public class Files {

	public static File createFile(String path, String contents) throws IOException {
		final File file = new File(path);
		
		if(!file.mkdirs()) {
			throw new RuntimeException("Cannot create directory tree");
		}

		if(!file.createNewFile()) {
			throw new RuntimeException("Cannot create directory tree");
		}
			
		return file;
	}
	
}
