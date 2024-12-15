package com.example.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "products")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // nullable false la khong duoc de trong
    @Column(name = "name", nullable = false, length = 350)
    private String name;

    private Float price;

    @Column(name = "url", length = 300)
    private String url;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoty_id", referencedColumnName = "id")
    private Category categoty;
}
