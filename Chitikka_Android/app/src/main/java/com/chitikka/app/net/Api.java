package com.chitikka.app.net;

import com.chitikka.app.model.Cart;
import com.chitikka.app.model.CartApiResponse;
import com.chitikka.app.model.Favorite;
import com.chitikka.app.model.FavoriteApiResponse;
import com.chitikka.app.model.History;
import com.chitikka.app.model.HistoryApiResponse;
import com.chitikka.app.model.Image;
import com.chitikka.app.model.LoginApiResponse;
import com.chitikka.app.model.NewsFeedResponse;
import com.chitikka.app.model.OrderApiResponse;
import com.chitikka.app.model.Ordering;
import com.chitikka.app.model.Otp;
import com.chitikka.app.model.ProductApiResponse;
import com.chitikka.app.model.RegisterApiResponse;
import com.chitikka.app.model.Review;
import com.chitikka.app.model.ReviewApiResponse;
import com.chitikka.app.model.Shipping;
import com.chitikka.app.model.User;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @POST("users/register")
    Call<RegisterApiResponse> createUser(@Body User user);

    @GET("users/login")
    Call<LoginApiResponse> logInUser(@Query("email") String email, @Query("password") String password);

    @DELETE("users/{userId}")
    Call<ResponseBody> deleteAccount(@Header("authorization") String token , @Path("userId") int userId);

    @Multipart
    @PUT("users/upload")
    Call<ResponseBody> uploadPhoto(@Header("authorization") String token , @Part MultipartBody.Part userPhoto, @Part("id") RequestBody userId);

    @PUT("users/info")
    Call<ResponseBody> updatePassword(@Header("authorization") String token, @Query("password") String password, @Query("id") int userId);

    @Multipart
    @POST("products/insert")
    Call<ResponseBody> insertProduct(@Header("authorization") String token, @PartMap Map<String, RequestBody> productInfo, @Part MultipartBody.Part image);

    @GET("users/getImage")
    Call<Image> getUserImage(@Query("id") int userId);

    @GET("users/otp")
    Call<Otp> getOtp(@Header("authorization") String token, @Query("email") String email);

    @GET("products")
    Call<ProductApiResponse> getProductsByCategory(@Query("category") String category, @Query("userId") int userId,@Query("page") int page);

    @GET("products/search")
    Call<ProductApiResponse> searchForProduct(@Query("q") String keyword, @Query("userId") int userId);

    @POST("favorites/add")
    Call<ResponseBody> addFavorite(@Body Favorite favorite);

    @DELETE("favorites/remove")
    Call<ResponseBody> removeFavorite(@Query("userId") int userId, @Query("productId") int productId);

    @GET("favorites")
    Call<FavoriteApiResponse> getFavorites(@Query("userId") int userId);

    @POST("carts/add")
    Call<ResponseBody> addToCart(@Body Cart cart);

    @DELETE("carts/remove")
    Call<ResponseBody> removeFromCart(@Query("userId") int userId, @Query("productId") int productId);

    @GET("carts")
    Call<CartApiResponse> getProductsInCart(@Query("userId") int userId);

    @POST("history/add")
    Call<ResponseBody> addToHistory(@Body History history);

    @DELETE("history/remove")
    Call<ResponseBody> removeAllFromHistory();

    @GET("history")
    Call<HistoryApiResponse> getProductsInHistory(@Query("userId") int userId, @Query("page") int page);

    @POST("review/add")
    Call<ResponseBody> addReview(@Body Review review);

    @GET("review")
    Call<ReviewApiResponse> getAllReviews(@Query("productId") int productId);

    @GET("posters")
    Call<NewsFeedResponse> getPosters();

    @GET("orders/get")
    Call<OrderApiResponse> getOrders(@Query("userId") int userId);

    @POST("address/add")
    Call<ResponseBody> addShippingAddress(@Body Shipping shipping);

    @POST("orders/add")
    Call<ResponseBody> orderProduct(@Body Ordering ordering);
}
