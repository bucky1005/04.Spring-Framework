package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    /* 메모. 컬렉션에는 final을 붙이자!
        1. 컬렉션 객체는 초기화를 하지 않으면 nullPointException이 발생하므로, final을 명시하여 반드시 초기화 하도록 한다.
        2. 장바구니에 담긴 값들은 변경되지 않을 객체이므로 final을 선언한다.
     */
    private final List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /* 설명. 카트에 물품 담는 기능 */
    public void addItem(Product item) {
        items.add(item);
    }

    /* 설명. 카트의 물품 꺼내기 */
    public List<Product> getItems() {
        return items;
    }
}
