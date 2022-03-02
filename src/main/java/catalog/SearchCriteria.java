package catalog;

public class SearchCriteria {

    public final String title;
    public  String contributor;

    public SearchCriteria(String title, String contributor) {
        if (!Validators.isBlank(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Empty title");
        }

        if (!Validators.isBlank(contributor)) {
            this.contributor = contributor;
        } else {
            throw new IllegalArgumentException("Empty contributor");
        }
    }

    public SearchCriteria(String title) {
        if (!Validators.isBlank(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Empty title");
        }
    }


    public static SearchCriteria createByBoth(String title, String contributor) {
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        return new SearchCriteria(contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        return new SearchCriteria(title);
    }

    public boolean hasTitle() {
        if (!(title == null) && !(title.length() == 0)) {
            return true;
        }
        return false;
    }

    public boolean hasContributor() {
        if (!(contributor == null) && !(contributor.length() == 0)) {
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }

}
