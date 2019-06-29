package xebia.nytimes.popular.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xebia.nytimes.popular.model.NYDetails;


public interface ApiInterface {
    @GET("mostpopular/v2/viewed/7.json")
    Call<NYDetails> getPopularNYDetails(@Query("api-key") String apiKey);

}
