package org.skypro.skyshop.Article;

import org.skypro.skyshop.Search.Searchable;

public final class Article implements Searchable {
    private final String articleName;
    private final String text;

    public Article(String articleName, String text) {
        this.articleName = articleName;
        this.text = text;
    }

    public String getName() {
        return articleName;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return getName() + ". " + getText();
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }
}
