package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private String title;
    private int length;
    private  List<String> composer;
    private final List<String> performers;

    public AudioFeatures(String title, int length, List<String> performers) {
        isBlankTitleValidator(title);
        lengthValidator(length);
        this.performers = performers;
    }

    private void lengthValidator(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("A hossznak nullánál nagyobbnak kell lenni!");
        }
    }

    private void isBlankTitleValidator(String title) {
        if (!Validators.isBlank(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("A cím nem lehet üres!");
        }
    }

    public AudioFeatures(String title, int length,  List<String> performers, List<String> composer) {
        isBlankTitleValidator(title);
        lengthValidator(length);
        this.composer = composer;
        this.performers = performers;
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        listForEachAndValidate(result, composer);
        listForEachAndValidate(result, performers);
        return result;
    }

    private void listForEachAndValidate(List<String> result, List<String> composerOrPerformer) {
        if (!Validators.isEmpty(composerOrPerformer) ) {
            for (String c: composerOrPerformer) {
                result.add(c);
            }
        }
    }


    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
