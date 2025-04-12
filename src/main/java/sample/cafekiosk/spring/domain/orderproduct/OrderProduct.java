package sample.cafekiosk.spring.domain.orderproduct;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.BaseEntity;
import sample.cafekiosk.spring.domain.order.Order;
import sample.cafekiosk.spring.domain.product.Product;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product; // Product 에서는 관계 불필요

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
