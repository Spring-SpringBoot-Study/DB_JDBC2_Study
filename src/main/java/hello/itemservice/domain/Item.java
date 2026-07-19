package hello.itemservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
// @Entity -> JPA가 해당 객체를 관리함
@Entity
public class Item {

    // PK를 @Id로 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY -> DB에서 값이 자동으로 1씩 증가해서 넣게 하기 위함
    private Long id;

    @Column(name = "item_name", length = 10) // 컬럼명과 테이블의 속성명이 같으면 생략 가능(under바 형식 <-> camelcase)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
