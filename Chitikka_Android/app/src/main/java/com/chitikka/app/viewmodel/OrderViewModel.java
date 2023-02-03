package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.OrderApiResponse;
import com.chitikka.app.repository.OrderRepository;

public class OrderViewModel extends ViewModel {

    private final OrderRepository orderRepository;

    public OrderViewModel() {
        orderRepository = new OrderRepository();
    }

    public LiveData<OrderApiResponse> getOrders(int userId) {
        return orderRepository.getOrders(userId);
    }
}

