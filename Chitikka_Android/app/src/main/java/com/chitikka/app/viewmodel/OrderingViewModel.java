package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.Ordering;
import com.chitikka.app.repository.OrderingRepository;

import okhttp3.ResponseBody;

public class OrderingViewModel extends ViewModel {

    private final OrderingRepository orderingRepository;

    public OrderingViewModel(  ) {
        orderingRepository = new OrderingRepository();
    }

    public LiveData<ResponseBody> orderProduct(Ordering ordering) {
        return orderingRepository.orderProduct(ordering);
    }
}
