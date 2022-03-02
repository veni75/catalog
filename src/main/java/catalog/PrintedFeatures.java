package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {

    private String title;
    private int numberOfPages;
    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        isBlankTitleValidator(title);
        numberOfPagesValidator(numberOfPages);
        authorsListValidate(authors);
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    private void isBlankTitleValidator(String title) {
        if (!Validators.isBlank(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Empty title");
        }
    }

    private void numberOfPagesValidator(int numberOfPages) {
        if (numberOfPages > 0) {
            this.numberOfPages = numberOfPages;
        } else {
            throw new IllegalArgumentException("A hossznak nullánál nagyobbnak kell lenni!");
        }
    }

    private void authorsListValidate(List<String> authors) {
        if (Validators.isEmpty(authors) ) {
            throw new IllegalArgumentException("A szerzők listája üres!");
        }
    }
}
