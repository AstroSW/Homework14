package org.skypro.skyshop.Search;

public class SearchEngine {
    Searchable [] searchables;
    int count;

    public SearchEngine (int size) {
        searchables = new Searchable [size];
    }

    public void searchInfo (String term) {
        Searchable[] info = new Searchable[5];
        int count = 0;
        for (Searchable s : searchables) {
            if (s == null) {continue;}
            if (s.getSearchTerm().contains(term)) {
                info [count++] = s;
            }
            if (count == 5) {
                break;
            }
        }
        System.out.println();
        for (int i=0; i < count; i++) {
            System.out.println(info[i].getStringRepresentation());
            //System.out.println(info[i].getStringRepresentation());
        }
    }

    public void addInfo (Searchable searchable) {
        searchables [count++] = searchable;
    }
}
