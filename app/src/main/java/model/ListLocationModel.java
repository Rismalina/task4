package model;

import com.google.gson.annotations.Serializedname;
import java.util.List;

public class ListLocationModel {
    @Serializedname("data")
    private List<LocationModel> mData;
    public ListLocationModel (List<LocationModel>mData){this.mData = mData;}
    public ListLocationModel(){

    }
    public  List<ListLocationModel> getmData() { return mData; }
    public void setmData(List<ListLocationModel>mData) {this.mData = mData; }
}
