package ru.itis.entities;

/**
 * Created by UseR7 on 27.10.2016.
 */
public class NewsItem {
    private String link;
    private String head;

    public NewsItem(String link, String head) {
        this.link = link;
        this.head = head;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
