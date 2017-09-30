package com.example.loginauth.models;

public class UrlCounts implements Comparable<UrlCounts> {

    public String title;
    public int visit_counts = 0;
    public int typed_counts = 0;

    public UrlCounts() {
    }

    public UrlCounts(String title, int visit_counts, int typed_counts) {
        this.title = title;
        this.visit_counts = visit_counts;
        this.typed_counts = typed_counts;
    }

    @Override
    public int compareTo(UrlCounts o) {
        if (this.visit_counts != o.visit_counts) {
            return (this.visit_counts - o.visit_counts) * -1;
        } else {
            return (this.typed_counts - o.typed_counts) * -1;
        }
    }
}
