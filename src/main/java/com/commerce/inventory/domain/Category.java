package com.commerce.inventory.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Lob
    @Column(name = "long_description", length = 2000)
    private String longDescription;

    @Column(name = "active_start_date")
    private Date activeStartDate;

    @Column(name = "active_end_date")
    private Date activeEndDate;

    @Column(name = "meta_title")
    private String metaTile;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "canonical_url")
    private String canonicalUrl;


    public Category() {
    }

    public Category(String name, String shortDescription, String longDescription, Date activeStartDate, Date activeEndDate, String metaTile, String metaDescription, String canonicalUrl) {
        super();
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.activeStartDate = activeStartDate;
        this.activeEndDate = activeEndDate;
        this.metaTile = metaTile;
        this.metaDescription = metaDescription;
        this.canonicalUrl = canonicalUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMetaTile() {
        return metaTile;
    }

    public void setMetaTile(String metaTile) {
        this.metaTile = metaTile;
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
}
