package org.skypro.skyshop.Search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        int result = Integer.compare(s2.getName().length(), s1.getName().length());
        if (result == 0) {
            result = s1.getName().compareTo(s2.getName());
        }
        return result;
    }
}