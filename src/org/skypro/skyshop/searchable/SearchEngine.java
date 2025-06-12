package org.skypro.skyshop.searchable;

public class SearchEngine {
    Searchable[] searchElement;
    int countElement;


    public SearchEngine(int size) {
        this.searchElement = new Searchable[size];
        this.countElement = 0;

    }

    public void add(Searchable element) {
        if (countElement >= searchElement.length) {
            throw new IllegalStateException("Достигнута максимальная вместимость");
        }
        searchElement[countElement] = element;
        countElement++;
    }


    public Searchable[] search(String item) {
        System.out.println("Метод поиска");
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        for (Searchable elements : this.searchElement) {
            if (elements != null && elements.getSearchTerm().contains(item)) {
                results[foundCount] = elements;
                foundCount++;
                if (foundCount == 5) break;
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







