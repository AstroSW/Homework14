package org.skypro.skyshop.Search;

public interface Searchable {
    String getName();

    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation() {
        return (getName() + ". " + getTypeContent());
    }
}
