package helpme_productions.com.flkrrimagesearch.data.remote;


import helpme_productions.com.flkrrimagesearch.model.Photos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET( "/services/rest/")
    Call<Photos> getPictures(@Query("method") String method,@Query("key") String key, @Query("format") String format, @Query("text") String searched,@Query("nojsoncallback") int noCallBack);

}
