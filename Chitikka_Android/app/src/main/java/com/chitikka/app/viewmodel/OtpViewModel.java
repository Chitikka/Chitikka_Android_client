package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.Otp;
import com.chitikka.app.repository.OtpRepository;

public class OtpViewModel extends ViewModel {

    private final OtpRepository otpRepository;

    public OtpViewModel() {
        otpRepository = new OtpRepository();
    }

    public LiveData<Otp> getOtpCode(String token,String email) {
        return otpRepository.getOtpCode(token,email);
    }
}
