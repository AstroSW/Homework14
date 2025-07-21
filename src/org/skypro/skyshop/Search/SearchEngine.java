package org.skypro.skyshop.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public Map<String, Searchable> searchInfo(String term) {
        Map<String, Searchable> info = new TreeMap();
        for (Searchable s : searchables) {
            if (s.getSearchTerm().contains(term)) {
                info.put(s.getName(), s);
            }
        }
        return info;
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

    public void printInfo(Map<String, Searchable> map) {
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}
