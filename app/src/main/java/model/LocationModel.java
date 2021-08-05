package model;

import android.location.Location;

public class LocationModel {
    @SerializedName("nama")
    private String imageLocationName;
    @SerializedName("latitude")
    private String latitude;
    @serializedName("longitude")
    private String longitude;

    public LocationModel (String imageLocationName, String latitude, String longitude){
        this.imageLocationName = imageLocationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(){
        public String getImageLocationName() {return imageLocationName;}
        public void setImageLOcationName(String imageLocationName) {
            this.imageLocationName = imageLocationName;
        }
        public String getLatitude() {return latitude; }
        public void setLatitude(String latitude) {this.latitude = latitude; }
        public String getLongitude() {return longitude; }
        public void setLongtude(String longitude) {this.longitude = longitude;}

        }
}
