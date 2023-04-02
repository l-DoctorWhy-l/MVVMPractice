package com.example.mvvmpractice;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FirstFragmentViewModel extends ViewModel {

    final MutableLiveData<Double> counter = new MutableLiveData<Double>();
    Disposable priceDisposable;


    void onPressed(){
        CurrencyRepository.getPriceData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(priceData -> counter.setValue(priceData.Valute.USD.Value));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        priceDisposable.dispose();
    }
}
