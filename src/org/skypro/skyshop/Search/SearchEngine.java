package org.skypro.skyshop.Search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> searchInfo(String term) {
        return  searchables.stream()
                .filter(s -> s.getSearchTerm().contains(term))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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