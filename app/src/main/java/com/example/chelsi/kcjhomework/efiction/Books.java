package com.example.chelsi.kcjhomework.efiction;

import java.util.List;

public class Books {
    private String ageGroup;
    private String amazonProductUrl;
    private String articleChapterLink;
    private String author;
    private String book_image;
    private int bookImageWidth;
    private int book_image_height;
    private String bookReviewLink;
    private String contributor;
    private String contributorNote;
    private String createdDate;
    private String description;
    private String firstChapterLink;
    private int price;
    private String primaryIsbn10;
    private String primaryIsbn13;
    private String publisher;
    private int rank;
    private int rankLastWeek;
    private String sundayReviewLink;
    private String title;
    private String updatedDate;
    private int weeksOnList;
    private List<BuyLinks> buyLinks;

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getAmazonProductUrl() {
        return amazonProductUrl;
    }

    public String getArticleChapterLink() {
        return articleChapterLink;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookImage() {
        return book_image;
    }

    public int getBookImageWidth() {
        return bookImageWidth;
    }

    public int getBookImageHeight() {
        return book_image_height;
    }

    public String getBookReviewLink() {
        return bookReviewLink;
    }

    public String getContributor() {
        return contributor;
    }

    public String getContributorNote() {
        return contributorNote;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getFirstChapterLink() {
        return firstChapterLink;
    }

    public int getPrice() {
        return price;
    }

    public String getPrimaryIsbn10() {
        return primaryIsbn10;
    }

    public String getPrimaryIsbn13() {
        return primaryIsbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getRank() {
        return rank;
    }

    public int getRankLastWeek() {
        return rankLastWeek;
    }

    public String getSundayReviewLink() {
        return sundayReviewLink;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public int getWeeksOnList() {
        return weeksOnList;
    }

    public List<BuyLinks> getBuyLinks() {
        return buyLinks;
    }
}
