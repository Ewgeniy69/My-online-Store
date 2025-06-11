package org.skypro.skyshop.searchable;

public interface Searchable {


    String getSearchTerm();

    String getSearchContent();

    String getName();

    default String getStringRepresentation() {
        return "Имя: " + getName() + " тип: " + getSearchContent();
    }


}
