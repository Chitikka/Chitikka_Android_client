package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.LoginApiResponse;
import com.chitikka.app.repository.LoginRepository;

public class LoginViewModel extends ViewModel {

    private final LoginRepository loginRepository;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

    public LiveData<LoginApiResponse> getLoginResponseLiveData(String email, String password) {
        return loginRepository.getLoginResponseData(email, password);
    }
}
