package helpme_productions.com.flkrrimagesearch.data.remote;


import helpme_productions.com.flkrrimagesearch.model.Photos;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIProvider {

    private static final String BASE_URL = "https://api.flickr.com/";
    private static final String API_KEY = "3e7cc266ae2b0e0d78e279ce8e361736";
    private static final String FORMAT = "json";
    private static final int NO_CALL_BACK = 1;
    private static final String METHOD = "method=flickr.photos.search";


    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Call<Photos> photoInformationCall(String searched){
        Retrofit retrofit = create();
        APIService services = retrofit.create(APIService.class);
        return services.getPictures(METHOD,API_KEY,FORMAT,searched,NO_CALL_BACK);
    }

}
