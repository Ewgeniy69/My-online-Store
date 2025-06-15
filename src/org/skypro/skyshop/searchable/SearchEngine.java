package org.skypro.skyshop.searchable;

import org.skypro.skyshop.article.Article;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    List<Searchable> searchElement;

    public SearchEngine() {
        this.searchElement = new LinkedList<>();
    }

    public void add(Searchable element) {
        System.out.println("Добавлен новый объект: ");
        searchElement.add(element);
        System.out.println(element);
    }


    public List<Searchable> search(String item) {
        System.out.println("Метод поиска");
        List<Searchable> results = new LinkedList<>();
        for (Searchable elements : searchElement) {
            if (elements != null && elements.getSearchTerm().contains(item)) {
                results.add(elements);
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







