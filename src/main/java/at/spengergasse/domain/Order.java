package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Order implements Cloneable {
    @Id
    private Long orderId;

    @NotNull(message = "Order date is required!")
    @PastOrPresent(message = "Order date must be now or in the past")
    private LocalDate orderDate = LocalDate.now();

    @NotBlank(message = "The pizza is required")
    @Size(min=2, max=20, message = "Wrong Pizza!")
    private String    pizza = "Salami";

    @NotNull(message = "Size is required!")
    @Pattern(regexp = "Small|Medium|Large|Family", message = "Wrong size Small|Medium|Large|Family!")
    private String    size="Medium";

    @NotNull(message = "Quantity is required!")
    @Min(value = 1, message = "Min 1 pizza")
    @Max(value = 5, message = "Max 5 pizzas")
    private Integer   quantity=1;

    @NotNull(message = "The price is required!")
    @DecimalMin(value = "5", message = "The min price is 5 EUR!")
    private Double    price=9.0;

    @NotNull(message = "The garlic is required!")
    private Boolean   garlic=false;

    private static final AtomicLong sequence = new AtomicLong(1000);

    public Order(Long orderId, LocalDate orderDate, String pizza, String size, Integer quantity, Double price, Boolean garlic) {
        setOrderId (orderId);
        setOrderDate (orderDate);
        setPizza (pizza);
        setSize (size);
        setQuantity (quantity);
        setPrice (price);
        setGarlic (garlic);
    }

    public Order(LocalDate orderDate, String pizza, String size, Integer quantity, Double price, Boolean garlic) {
        setOrderId ();
        setOrderDate (orderDate);
        setPizza (pizza);
        setSize (size);
        setQuantity (quantity);
        setPrice (price);
        setGarlic (garlic);
    }

    public Order() {
    }

    public void setOrderId() {
        orderId = sequence.getAndIncrement();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getGarlic() {
        return garlic;
    }

    public void setGarlic(Boolean garlic) {
        this.garlic = garlic;
    }

    @Override
    public Order clone() {
        return new Order(orderId, orderDate, pizza, size, quantity, price, garlic);
    }
}
