package com.commerce.inventory.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product extends BaseEntity {

    @Column(name = "sku", unique = true)
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description", length = 255)
    private String shortDescription;

    @Lob
    @Column(name = "long_description", length = 2000)
    private String longDescription;

    @Column(name = "is_download")
    private boolean isDownload;

    @Column(name = "is_published")
    private boolean isPublished;

    @Column(name = "active_start_date", nullable = true)
    private Date activeStartDate;

    @Column(name = "active_end_date", nullable = true)
    private Date activeEndDate;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;


    @Column(name = "width")
    private Long width;

    @Column(name = "height")
    private Long height;

    @Column(name = "depth")
    private Long depth;


    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "canonical_url")
    private String canonicalUrl;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductCategory> categories = new ArrayList<ProductCategory>();


    protected Product() {
        super();
    }

    public Product(String sku, String name, String shortDescription, String longDescription, boolean isDownload, boolean isPublished, Date activeStartDate, Date activeEndDate, String manufacturer, Long width, Long height, Long depth, String metaTitle, String metaDescription, String canonicalUrl) {
        super();
        this.sku = sku;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isDownload = isDownload;
        this.isPublished = isPublished;
        this.activeStartDate = activeStartDate;
        this.activeEndDate = activeEndDate;
        this.manufacturer = manufacturer;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.canonicalUrl = canonicalUrl;
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

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Date getActiveStartDate() {
        return activeStartDate;
    }

    public void setActiveStartDate(Date activeStartDate) {
        this.activeStartDate = activeStartDate;
    }

    public Date getActiveEndDate() {
        return activeEndDate;
    }

    public void setActiveEndDate(Date activeEndDate) {
        this.activeEndDate = activeEndDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer.isEmpty()) {

        } else {
            this.manufacturer = manufacturer;
        }
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<ProductCategory> categories) {
        this.categories = categories;
    }

    public Product setCategory(ProductCategory category) {
        this.categories.add(category);
        return this;
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
                ", activeStartDate=" + activeStartDate +
                ", activeEndDate=" + activeEndDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", metaTitle='" + metaTitle + '\'' +
                ", metaDescription='" + metaDescription + '\'' +
                ", canonicalUrl='" + canonicalUrl + '\'' +
                '}';
    }
}
