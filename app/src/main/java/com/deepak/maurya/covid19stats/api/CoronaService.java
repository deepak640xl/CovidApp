 package com.deepak.maurya.covid19stats.api;


import com.deepak.maurya.covid19stats.data.CountriesResponse;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoronaService {

    @GET("countries/?sort=country")
    Call<List<CountriesResponse>> getCountries();


    @GET("countries/{country}")
    Call<CountriesResponse> getCountryInfo(

            @Path("country") String country
    );

    @GET("all")
    Call<List<CountriesResponse>> getAllCountries();
}
