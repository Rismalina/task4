package ApiService;

import online.galipatsecret.maps.model.ListLocationModel;
import retrofit2.call;
import retrofit2.http.GET;
import android.telecom.Call;

import model.ListLocationModel;

public interface ApiService {
    @GET("JsonDisplayMarker.php")
    Call<ListLocationModel> getAllLocation();
}
