package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.FavoriteApiResponse;
import com.chitikka.app.repository.FavoriteRepository;

public class FavoriteViewModel extends ViewModel {

    private final FavoriteRepository favoriteRepository;

    public FavoriteViewModel() {
        favoriteRepository = new FavoriteRepository();
    }

    public LiveData<FavoriteApiResponse> getFavorites(int userId) {
        return favoriteRepository.getFavorites(userId);
    }
}
