package com.devetibit.givemeblood.serviceinteraction;

import retrofit.http.GET;
import retrofit.http.Path;

public interface API1 {
	 public static String API_LOCATION = "http://ernestfoi.herokuapp.com";
	 @GET("/donor/{user}.json")
	 public String signIn(@Path("user") int username);
}
