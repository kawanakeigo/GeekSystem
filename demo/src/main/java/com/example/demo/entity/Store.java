package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    private Long id;

    private String name;

    // この行が「存在していない」または「名前が違う」可能性あり
    private String location; // ← これは DB上は address っぽい

    // Getter（Thymeleafはここを参照します）
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
