package com.example.models;

import javax.persistence.*;

@Entity
public class Reviews {

    //создаваемые поля в бд при добавлении элемента
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//генерация id в автоматическом режиме
    @Column(name="review_id")//переименовываем с типом стринг
    private Long review_id;

    private String title, text;

    public Reviews(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Reviews() {
    }


    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
