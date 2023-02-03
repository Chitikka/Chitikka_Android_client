package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.ReviewApiResponse;
import com.chitikka.app.repository.ReviewRepository;

public class ReviewViewModel extends ViewModel {

    private final ReviewRepository reviewRepository;

    public ReviewViewModel(  ) {
        reviewRepository = new ReviewRepository();
    }

    public LiveData<ReviewApiResponse> getReviews(int productId) {
        return reviewRepository.getReviews(productId);
    }
}
