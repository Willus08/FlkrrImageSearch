package helpme_productions.com.flkrrimagesearch.view.activities.search;


import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import helpme_productions.com.flkrrimagesearch.data.remote.APIProvider;
import helpme_productions.com.flkrrimagesearch.model.PhotoInformation;
import helpme_productions.com.flkrrimagesearch.model.Photos;
import retrofit2.Call;
import retrofit2.Response;

public class SearchPresenter implements SearchContract.Presenter{
    private static final String TAG = "test";
    private SearchContract.View view;
    private List<PhotoInformation> photoInformationList = new ArrayList<>();
    @Override
    public void addView(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getPhotoInformation(String search) {
        retrofit2.Call<Photos> photosCall = APIProvider.photoInformationCall(search);
        photosCall.enqueue(new retrofit2.Callback<Photos>() {


            @Override
            public void onResponse(@NonNull Call<Photos> call, @NonNull Response<Photos> response) {
                photoInformationList = response.body().getPhotoInformations();
                view.setupAdapter(photoInformationList);
            }

            @Override
            public void onFailure(@NonNull Call<Photos> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t);
                view.showError(t.toString());
            }
        });

    }
}
