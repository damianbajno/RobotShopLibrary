package com.epam.file;

/**
 * Created by damian on 21.03.16.
 */
public class Link {
    private String linkAdress;
    private String fileName;

    public Link(String linkAdress) {
        this.linkAdress=linkAdress;
        this.fileName=createFileName();
    }

    protected String createFileName(){
        return linkAdress.replaceAll("/","");
    }

    public String getLinkAdress() {
        return linkAdress;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return linkAdress.equals(link.linkAdress);

    }

    @Override
    public int hashCode() {
        return linkAdress.hashCode();
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkAdress='" + linkAdress + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
