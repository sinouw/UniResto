package com.example.yassineouni.unirestoo.ui.addmenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddMenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddMenuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is addmenu fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}