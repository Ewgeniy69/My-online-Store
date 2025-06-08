package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public final class Article implements Searchable {
    private final String description;
    private final String text;

    public Article(String description, String text) {
        this.description = description;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return description + ", " + text;
    }

    @Override
    public String getSearchContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return description;
    }


    @Override
    public String toString() {
        return "Название статьи - " + description + System.lineSeparator() + "Текст статьи: " + text;
    }
}
