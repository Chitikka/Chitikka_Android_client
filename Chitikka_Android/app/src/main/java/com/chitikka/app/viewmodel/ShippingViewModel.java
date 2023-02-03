package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.Shipping;
import com.chitikka.app.repository.ShippingRepository;

import okhttp3.ResponseBody;

public class ShippingViewModel  extends ViewModel {

    private final ShippingRepository shippingRepository;

    public ShippingViewModel() {
        shippingRepository = new ShippingRepository();
    }

    public LiveData<ResponseBody> addShippingAddress(Shipping shipping) {
        return shippingRepository.addShippingAddress(shipping);
    }
}
