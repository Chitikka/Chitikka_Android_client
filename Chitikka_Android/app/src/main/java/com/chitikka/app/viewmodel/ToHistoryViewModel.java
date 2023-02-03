package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.History;
import com.chitikka.app.repository.ToHistoryRepository;

import okhttp3.ResponseBody;

public class ToHistoryViewModel extends ViewModel {

    private final ToHistoryRepository toHistoryRepository;

    public ToHistoryViewModel() {
        toHistoryRepository = new ToHistoryRepository();
    }

    public LiveData<ResponseBody> addToHistory(History history) {
        return toHistoryRepository.addToHistory(history);
    }
}
