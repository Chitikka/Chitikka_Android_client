package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.NewsFeedResponse;
import com.chitikka.app.repository.NewsFeedRepository;

public class NewsFeedViewModel extends ViewModel {

    private final NewsFeedRepository newsFeedRepository;

    public NewsFeedViewModel() {
        newsFeedRepository = new NewsFeedRepository();
    }

    public LiveData<NewsFeedResponse> getPosters() {
        return newsFeedRepository.getPosters();
    }
}
