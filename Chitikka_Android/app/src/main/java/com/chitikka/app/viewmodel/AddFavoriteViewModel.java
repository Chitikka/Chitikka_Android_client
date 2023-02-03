package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.Favorite;
import com.chitikka.app.repository.AddFavoriteRepository;
import com.chitikka.app.utils.RequestCallback;

import okhttp3.ResponseBody;

public class AddFavoriteViewModel extends ViewModel {

    private final AddFavoriteRepository addFavoriteRepository;

    public AddFavoriteViewModel() {
        addFavoriteRepository = new AddFavoriteRepository();
    }

    public LiveData<ResponseBody> addFavorite(Favorite favorite, RequestCallback callback) {
        return addFavoriteRepository.addFavorite(favorite,callback);
    }
}
