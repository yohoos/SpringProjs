package com.project.models;

import javax.persistence.*;

@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String url;
    private String title;
    @Column(nullable = false)
    private int visit_count = 0;
    @Column(nullable = false)
    private int typed_count = 0;
    @Column(nullable = false)
    private int last_visit_time;
    @Column(nullable = false)
    private int hidden = 0;

    public Url() {

    }

    public Url(String url, String title, int visit_count, int typed_count, int last_visit_time, int hidden) {
        this.url = url;
        this.title = title;
        this.visit_count = visit_count;
        this.typed_count = typed_count;
        this.last_visit_time = last_visit_time;
        this.hidden = hidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVisitCount() {
        return visit_count;
    }

    public void setVisitCount(int visitCount) {
        this.visit_count = visitCount;
    }

    public int getTypedCount() {
        return typed_count;
    }

    public void setTypedCount(int typedCount) {
        this.typed_count = typedCount;
    }

    public int getLastVisitTime() {
        return last_visit_time;
    }

    public void setLastVisitTime(int lastVisitTime) {
        this.last_visit_time = lastVisitTime;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }
}
