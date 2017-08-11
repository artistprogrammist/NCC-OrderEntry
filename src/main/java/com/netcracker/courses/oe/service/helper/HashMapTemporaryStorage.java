package com.netcracker.courses.oe.service.helper;

import com.netcracker.courses.oe.dto.processor.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class HashMapTemporaryStorage implements TemporaryStorage {

    private ConcurrentMap<String, OrderDTO> storage = new ConcurrentHashMap<>(64, 0.9F);

    public HashMapTemporaryStorage() {
    }

    @Override
    public void save(OrderDTO data) {
        storage.putIfAbsent(data.getEmail(), data);
    }

    @Override
    public OrderDTO get(String key) {
        return storage.get(key);
    }

    @Override
    public OrderDTO delete(String key) {
        return storage.remove(key);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        Collection<OrderDTO> values = storage.values();
        ArrayList<OrderDTO> ordersDTO = new ArrayList<>(values);
        return ordersDTO;
    }
}
