package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.Image;
import com.chitikka.app.repository.UserImageRepository;

public class UserImageViewModel extends ViewModel {

    private final UserImageRepository userImageRepository;

    public UserImageViewModel() {
        userImageRepository = new UserImageRepository();
    }

    public LiveData<Image> getUserImage(int userId) {
        return userImageRepository.getUserImage(userId);
    }
}
