package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features;
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.features = features;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int fullLengthAtOneItem() {
        int lengthSum = 0;
        for (Feature f: features) {
            if (f instanceof AudioFeatures) {
                lengthSum += ((AudioFeatures) f).getLength();
            }
        }
        return lengthSum;
    }

    public List<String> getContributors() {
        List<String> allContributors = new ArrayList<>();
        for (Feature f: features) {
            audioFeatureAttributeAddList(allContributors, f);
            printedFeatureAttributeAddList(allContributors, f);
        }
        return allContributors;
    }

    private void printedFeatureAttributeAddList(List<String> allContributors, Feature f) {
        if (f instanceof PrintedFeatures) {
            List<String> printedContributors = ((PrintedFeatures) f).getContributors();
            allContributors.addAll(printedContributors);
        }
    }

    private void audioFeatureAttributeAddList(List<String> allContributors, Feature f) {
        if (f instanceof AudioFeatures) {
            List<String> audioContributors = ((AudioFeatures) f).getContributors();
            allContributors.addAll(audioContributors);
        }
    }

    public List<String> getTitles() {
        List<String> allTitles = new ArrayList<>();
        for (Feature f: features) {
            allTitles.add(f.getTitle());
        }
        return allTitles;
    }

    public boolean hasAudioFeature() {
        for (Feature f: features) {
            if (f instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature f: features) {
            if (f instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int pages = 0;
        for (Feature f: features) {
            if (f instanceof PrintedFeatures) {
                 pages = ((PrintedFeatures) f).getNumberOfPages();
            }
        }
       return pages;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
