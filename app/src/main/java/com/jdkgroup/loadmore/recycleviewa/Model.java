package com.jdkgroup.loadmore.recycleviewa;

/**
 * Created by Kamlesh on 7/31/2016.
 */
public class Model {
    private String subject, year, description, author;

    public Model(String subject, String year, String description, String author) {
        this.subject = subject;
        this.year = year;
        this.description = description;
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
