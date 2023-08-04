package com.example.product.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order{
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice(){       // 계산된 가격
        return itemPrice-discountPrice;
    }

    @Override
    public String toString() {  // 객체 출력시 나옴.
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }

}
