package org.example;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MessageToManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String from;
    protected String to;
    protected String title;
    @Column(length=1000)
    protected String body;
    protected boolean read;
    protected LocalDate date;

    public MessageToManager(String from,String to, String title, String body) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.body = body;
        this.read = false;
        this.date = LocalDate.now();
    }

    public MessageToManager() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
