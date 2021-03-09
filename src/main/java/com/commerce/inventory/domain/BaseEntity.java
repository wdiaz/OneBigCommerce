package com.commerce.inventory.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BaseEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    protected Date createdAt;

    protected BaseEntity() {
        this.createdAt = new Date();
    }

    public BaseEntity(Date createdAt) {
        this.createdAt = createdAt;
    }

    protected BaseEntity(Long id) {
        this.id = id;
    }

    protected Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
