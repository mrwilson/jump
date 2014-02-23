package uk.co.probablyfine.jump.core;

import java.io.*;
import java.util.LinkedList;

public class Files {

    /**
     * Creates a new file with some predefined content
     * @param path
     * @param contents
     * @return
     * @throws IOException
     */
	public static File createFile(String path, String contents) throws IOException {
		final File file = new File(path);
		
		if(!file.mkdirs()) {
			throw new RuntimeException("Cannot create directory tree");
		}

		if(!file.createNewFile()) {
			throw new RuntimeException("Cannot create File");
		}

        if (contents != null) {
            FileWriter fw = new FileWriter(file);
            fw.write(contents);
        }

		return file;
	}

    public static LinkedList<String> readFile(String path) throws IOException {
        LinkedList<String> data = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;
        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        return data;
    }
	
}
