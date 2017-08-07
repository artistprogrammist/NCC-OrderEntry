package com.netcracker.courses.oe.dto.processor;

import com.netcracker.courses.oe.dto.inventory.Item;

import java.util.List;

public class Order {
    private long id;
    private String email;
    private List<Item> items;
}
