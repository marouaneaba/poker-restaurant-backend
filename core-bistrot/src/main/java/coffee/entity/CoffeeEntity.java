package coffee.entity;

import javax.persistence.*;

@Entity
public class CoffeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "available", nullable = false)
    private boolean isAvailable;

    @Column(name = "selected", nullable = false)
    private boolean isSelected;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
