package com.jdkgroup.loadmore.retrofit2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {
    @GET("movies.php")
    Call<List<Model>> getMovies(@Query("index") int index);
}
