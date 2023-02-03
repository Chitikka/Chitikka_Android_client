package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.repository.RemoveFavoriteRepository;
import com.chitikka.app.utils.RequestCallback;

import okhttp3.ResponseBody;

public class RemoveFavoriteViewModel extends ViewModel {

    private final RemoveFavoriteRepository removeFavoriteRepository;

    public RemoveFavoriteViewModel() {
        removeFavoriteRepository = new RemoveFavoriteRepository();
    }

    public LiveData<ResponseBody> removeFavorite(int userId, int productId, RequestCallback callback) {
        return removeFavoriteRepository.removeFavorite(userId, productId, callback);
    }
}
