package org.skypro.skyshop.searchable;
import java.util.*;

public class SearchEngine {
    Map<String, Searchable> searchElement;

    public SearchEngine() {
        this.searchElement = new TreeMap<>();
    }

    public void add(Searchable element) {
        System.out.println("Добавлен новый объект: ");
        searchElement.put(element.getSearchTerm(), element);
        System.out.println(element);
    }


    public Map<String, Searchable> search(String item) {
        System.out.println("Метод поиска");
        Map<String, Searchable> results = new TreeMap<>();
        for (Map.Entry<String, Searchable> entry : searchElement.entrySet()) {
            Searchable element = entry.getValue();
            if (element != null && element.getSearchTerm().contains(item)) {
                results.put(element.getSearchTerm(), element);
            }
                    }
        return results;

    }

    public Searchable searchBestMatch(String search, Searchable[] items) throws BestResultNotFound {
        if (search == null || items == null || items.length == 0) {
            throw new BestResultNotFound("Ничего не найдено");
        }
        Searchable bestMatch = null;
        int maxCount = -1;
        for (Searchable item : items) {
            String term = item.getSearchTerm();
            int count = 0;
            int index = 0;
            int searchLength = search.length();
            while (true) {
                index = term.indexOf(search, index);
                if (index == -1) break;
                count++;
                index += searchLength;
            }

            if (count > 0 && count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }
        if (maxCount == -1) {
            throw new BestResultNotFound("Ничего не найдено");
        }
        return bestMatch;
    }

}







