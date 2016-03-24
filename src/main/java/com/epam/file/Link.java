package com.epam.file;

/**
 * Created by damian on 21.03.16.
 */
public class Link {
    private String linkAdress;
    private String typeForSearch;
    private String nameForSearch;

    public Link(String linkAdress, String typeForSearch, String nameForSearch) {
        this.linkAdress = linkAdress;
        this.typeForSearch = typeForSearch;
        this.nameForSearch = nameForSearch;
    }

    public Link(String[] parameters) {
        this.linkAdress = parameters[0];
        this.typeForSearch = parameters[1];
        this.nameForSearch = parameters[2];
    }

    public String getElementType() {
        return typeForSearch;
    }

    public String getElementName() {
        return nameForSearch;
    }

    public String getLinkAdress() {
        return linkAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!linkAdress.equals(link.linkAdress)) return false;
        if (!typeForSearch.equals(link.typeForSearch)) return false;
        return nameForSearch.equals(link.nameForSearch);

    }

    @Override
    public int hashCode() {
        int result = linkAdress.hashCode();
        result = 31 * result + typeForSearch.hashCode();
        result = 31 * result + nameForSearch.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return linkAdress + ' ' + typeForSearch + ' ' + nameForSearch;
    }

}
