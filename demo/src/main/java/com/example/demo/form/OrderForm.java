// src/main/java/com/example/demo/form/OrderForm.java
package com.example.demo.form;

public class OrderForm {

    private Long productId;
    private Long storeId;
    private Integer quantity;

    // ゲッター・セッター
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

