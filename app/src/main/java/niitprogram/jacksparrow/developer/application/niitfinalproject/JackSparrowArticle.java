/*
 * Copyright (c) $2015. Just For Fun :)
 */

package niitprogram.jacksparrow.developer.application.niitfinalproject;

/**
 * Created by Jack Sparrow on 5/31/2015.
 */
public class JackSparrowArticle {
    private String name;
    private String sumary;
    private String date;
    private String image;
    private String id;
    private String content;

    public JackSparrowArticle(String name, String id, String image, String date, String sumary) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.date = date;
        this.sumary = sumary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JackSparrowArticle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSumary() {
        return sumary;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }
}
