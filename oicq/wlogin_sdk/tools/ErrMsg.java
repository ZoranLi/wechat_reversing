package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ErrMsg implements Parcelable, Cloneable {
    public static final Creator<ErrMsg> CREATOR = new Creator<ErrMsg>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ErrMsg(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ErrMsg[i];
        }
    };
    public String message;
    public String title;
    private int type;
    public String xoO;

    public ErrMsg() {
        this.type = 0;
        this.title = "";
        this.message = "";
        this.xoO = "";
    }

    public final void cis() {
        this.type = 0;
        this.title = "";
        this.message = "";
        this.xoO = "";
    }

    public Object clone() {
        return super.clone();
    }

    public ErrMsg(Parcel parcel) {
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.xoO = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.xoO);
    }
}
