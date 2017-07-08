package com.vc.play.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vc on 2016/8/6.
 */
public class Test implements Parcelable {

    private String id;
    private String name;

    protected Test(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<Test> CREATOR = new Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
    }
}
