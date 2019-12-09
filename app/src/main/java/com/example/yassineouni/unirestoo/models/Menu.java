package com.example.yassineouni.unirestoo.models;

import java.io.Serializable;
import java.sql.Date;

public class Menu implements Serializable {

    private String id;

    private String title;

    private String description;

    private String type;

    private Date dateMenu;

    private String imageUrl;

    public Menu(String title, String description, String type, Date dateMenu, String imageUrl) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.dateMenu = dateMenu;
        this.imageUrl = imageUrl;
    }

    public Menu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Date getDateMenu() {
        return dateMenu;
    }

    public void setDateMenu(Date dateMenu) {
        this.dateMenu = dateMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", dateMenu=" + dateMenu +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
