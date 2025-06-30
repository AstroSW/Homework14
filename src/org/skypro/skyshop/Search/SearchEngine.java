package org.skypro.skyshop.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    List<Searchable> searchables;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public void searchInfo(String term) {
        List<Searchable> info = new ArrayList<>();
        for (Searchable s : searchables) {
            if (s.getSearchTerm().contains(term)) {
                info.add(s);
            }
        }
        System.out.println();
        for (Searchable s : info) {
            System.out.println(s.getStringRepresentation());
        }
    }

    public void addInfo(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable bestSearchEngine(String search) {
        int maxCount = 0;
        Searchable bestResult = null;
        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }
            int n = 0;
            String term = searchable.getSearchTerm();
            int index = term.indexOf(search);
            while (index != -1) {
                n++;
                index = term.indexOf(search, index + search.length());
            }
            if (n > maxCount) {
                maxCount = n;
                bestResult = searchable;
            }
        }
        if (bestResult == null) throw new BestResultNotFound("Поисковая строка '" + search + "' отсутствует.");
        return bestResult;
    }
}
