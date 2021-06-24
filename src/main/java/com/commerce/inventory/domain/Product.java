package com.commerce.inventory.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sku")
    private String sku;

    @Column(name = "short_description")
    private String shortDescription;

    @Lob
    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "active_start_date")
    private Date activeStartDate;

    @Column(name = "active_end_date")
    private Date activeEndDate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "is_download")
    private boolean isDownload;

    @Column(name = "is_published")
    private boolean isPublished;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "canonical_url")
    private String canonicalUrl;

    @Column(name = "is_promoted")
    private boolean isPromoted;

    public Product() {
    }

    public Product(Integer id, String name, String sku, String shortDescription, String longDescription, Date activeStartDate, Date activeEndDate, String manufacturer, Date createdAt, Date updatedAt, boolean isDownload, boolean isPublished, String metaTitle, String metaDescription, String canonicalUrl, boolean isPromoted) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.activeStartDate = activeStartDate;
        this.activeEndDate = activeEndDate;
        this.manufacturer = manufacturer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDownload = isDownload;
        this.isPublished = isPublished;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.canonicalUrl = canonicalUrl;
        this.isPromoted = isPromoted;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Date getActiveStartDate() {
        return this.activeStartDate;
    }

    public void setActiveStartDate(java.sql.Date activeStartDate) {
        this.activeStartDate = activeStartDate;
    }

    public Date getActiveEndDate() {
        return this.activeEndDate;
    }

    public void setActiveEndDate(java.sql.Date activeEndDate) {
        this.activeEndDate = activeEndDate;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getIsDownload() {
        return this.isDownload;
    }

    public Product setIsDownload(boolean isDownload) {

        this.isDownload = isDownload;

        return this;
    }

    public boolean getIsPublished() {
        return this.isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public String getMetaTitle() {
        return this.metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return this.metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getCanonicalUrl() {
        return this.canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public boolean getIsPromoted() {
        return this.isPromoted;
    }

    public Product setIsPromoted(boolean isPromoted) {

        this.isPromoted = isPromoted;

        return this;
    }
}
