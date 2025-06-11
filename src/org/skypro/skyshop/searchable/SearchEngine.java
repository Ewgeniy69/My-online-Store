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
}





