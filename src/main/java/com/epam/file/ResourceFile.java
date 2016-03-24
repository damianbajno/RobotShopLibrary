package com.epam.file;

import java.io.File;
import java.net.URL;

/**
 * Created by damian on 24.03.16.
 */
public class ResourceFile {
    String filePath;
    File file;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
        createFile();
    }

    private void createFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        file=new File(resource.getFile());
    }

    public File getFile() {
        return file;
    }

    public boolean exists(){
        return file.exists();
    }

}
