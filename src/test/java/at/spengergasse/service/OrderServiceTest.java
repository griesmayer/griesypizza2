package at.spengergasse.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    public void testToString() {
        OrderService griesypizza = new OrderService();
        System.out.println(griesypizza);
    }
}