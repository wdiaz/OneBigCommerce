package com.commerce.inventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class Product extends BaseEntity {

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description", length = 255)
    private String shortDescription;

    @Column(name = "long_description", length = 2000)

    private String longDescription;

    @Column(name = "is_download")
    private boolean isDownload;

    @Column(name = "is_published")
    private boolean isPublished;

    protected Product() {
    }

    public Product(String sku, String name, String shortDescription, String longDescription, boolean isDownload, boolean isPublished) {
        this.sku = sku;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isDownload = isDownload;
        this.isPublished = isPublished;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isDownload() {
        return isDownload;
    }

    public void setDownload(boolean download) {
        isDownload = download;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", isDownload=" + isDownload +
                ", isPublished=" + isPublished +
                '}';
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }
}
