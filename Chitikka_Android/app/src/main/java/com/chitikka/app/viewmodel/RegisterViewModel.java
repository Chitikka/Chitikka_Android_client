package com.chitikka.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.chitikka.app.model.RegisterApiResponse;
import com.chitikka.app.model.User;
import com.chitikka.app.repository.RegisterRepository;

public class RegisterViewModel extends ViewModel {

    private final RegisterRepository registerRepository;

    public RegisterViewModel() {
        registerRepository = new RegisterRepository();
    }

    public LiveData<RegisterApiResponse> getRegisterResponseLiveData(User user) {
        return registerRepository.getRegisterResponseData(user);
    }
}
