package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.ProductApiResponse;
import com.chitikka.app.repository.SearchRepository;

public class SearchViewModel  extends ViewModel {

    private final SearchRepository searchRepository;

    public SearchViewModel(  ) {
        searchRepository = new SearchRepository();
    }


    public LiveData<ProductApiResponse> getProductsBySearch(String keyword, int userId) {
        return searchRepository.getResponseDataBySearch(keyword, userId);
    }
}
