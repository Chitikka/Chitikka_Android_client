package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.CartApiResponse;
import com.chitikka.app.repository.CartRepository;

public class CartViewModel extends ViewModel {

    private final CartRepository cartRepository;

    public CartViewModel() {
        cartRepository = new CartRepository();
    }

    public LiveData<CartApiResponse> getProductsInCart(int userId) {
        return cartRepository.getProductsInCart(userId);
    }
}
