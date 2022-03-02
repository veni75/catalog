package catalog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog {

    private List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int numberOfPages) {
        int sumNumberOfPages = 0;
        int counter = 0;
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        for (CatalogItem ci: catalogItems) {
            if (ci.numberOfPagesAtOneItem() > numberOfPages) {
                sumNumberOfPages += ci.numberOfPagesAtOneItem();
                if (ci.hasPrintedFeature()) {
                    counter++;
                }
            }
        }

        if (sumNumberOfPages < numberOfPages) {
            throw new IllegalArgumentException("No page");
        }
        return sumNumberOfPages / counter;
    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        Iterator<CatalogItem> iterator = catalogItems.iterator();
        while (iterator.hasNext()) {
            CatalogItem ci = iterator.next();
            if (ci.getRegistrationNumber().equals(regNumber)) {
                iterator.remove();
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        if (searchCriteria.hasTitle() || searchCriteria.hasContributor()) {
            for (CatalogItem ci: catalogItems) {
                if (ci.getTitles().equals(searchCriteria.getTitle())) {
                    result.add(ci);
                }
            }
        }


        return result;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem ci: catalogItems) {
            if (ci.hasAudioFeature()) {
                result.add(ci);
            }
        }
        return result;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem ci: catalogItems) {
            if (ci.hasPrintedFeature()) {
                result.add(ci);
            }
        }
        return result;
    }

    public int getAllPageNumber() {
        int sumPageNumber = 0;
        for (CatalogItem ci: catalogItems) {
            sumPageNumber += ci.numberOfPagesAtOneItem();
        }
        return sumPageNumber;
    }

    public int getFullLength() {
        int sumLength = 0;
        for (CatalogItem ci: catalogItems) {
            sumLength += ci.fullLengthAtOneItem();
        }
        return sumLength;
    }


    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }
}
