package com.netcracker.courses.oe.processor.service.util;

import com.netcracker.courses.oe.processor.dto.processor.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class HashMapTemporaryStorage implements TemporaryStorage {

    private ConcurrentMap<String, ConcurrentHashMap<String, OrderDTO>> storage = new ConcurrentHashMap<>(256, 0.9F);

    public HashMapTemporaryStorage() {
    }

    @Override
    public void save(OrderDTO data) {
        ConcurrentHashMap<String, OrderDTO> storageData = storage.get(data.getEmail());
        if (storageData == null) {
            ConcurrentHashMap<String, OrderDTO> newData = new ConcurrentHashMap<>();
            newData.putIfAbsent(data.getOrderNumber(), data);
            storage.putIfAbsent(data.getEmail(), newData);
        } else {
            storageData.putIfAbsent(data.getOrderNumber(), data);
            storage.putIfAbsent(data.getEmail(), storageData);
        }
    }

    @Override
    public OrderDTO get(String email, String orderNumber) {
        return storage.get(email).get(orderNumber);
    }

    @Override
    public List<OrderDTO> get(String email) {
        List<OrderDTO> ordersDTO = new ArrayList<>();
        ConcurrentHashMap<String, OrderDTO> map = storage.get(email);
        if (map != null) {
            ordersDTO.addAll(map.values());
        }
        return ordersDTO;
    }

    @Override
    public void delete(String key) {
        storage.remove(key);
    }

    @Override
    public OrderDTO deleteOrder(String email, String orderNumber) {
        return storage.get(email).remove(orderNumber);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        Collection<ConcurrentHashMap<String, OrderDTO>> values = storage.values();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        values.forEach(map -> {
            orderDTOS.addAll(map.values());
        });
        return orderDTOS;
    }
}
