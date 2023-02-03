package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.Cart;
import com.chitikka.app.repository.ToCartRepository;
import com.chitikka.app.utils.RequestCallback;

import okhttp3.ResponseBody;

public class ToCartViewModel extends ViewModel {

    private final ToCartRepository toCartRepository;

    public ToCartViewModel() {
        toCartRepository = new ToCartRepository();
    }

    public LiveData<ResponseBody> addToCart(Cart cart, RequestCallback callback) {
        return toCartRepository.addToCart(cart, callback);
    }
}
