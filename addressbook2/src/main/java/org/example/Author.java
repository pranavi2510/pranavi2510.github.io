package org.example;

import org.springframework.stereotype.Component;

@Component
public class Author {
    private String authorName;
    private int numOfPub;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumOfPub() {
        return numOfPub;
    }

    public void setNumOfPub(int numOfPub) {
        this.numOfPub = numOfPub;
    }

    public Author(String authorName, int numOfPub) {
        this.authorName = authorName;
        this.numOfPub = numOfPub;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", numOfPub=" + numOfPub +
                '}';
    }
}