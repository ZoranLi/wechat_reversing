package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new Creator<ProductSectionItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ProductSectionItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProductSectionItem[i];
        }
    };
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public List<Skus> ohn;
    public String oho;
    public String ohp;
    public int scene;

    public static class Skus implements Parcelable {
        public static final Creator<Skus> CREATER = new Creator<Skus>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Skus(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Skus[i];
            }
        };
        public String arH;
        public String value;

        public Skus(Parcel parcel) {
            this.arH = parcel.readString();
            this.value = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.arH);
            parcel.writeString(this.value);
        }

        public static String aW(List<Skus> list) {
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                Skus skus = (Skus) list.get(i);
                if (i != 0) {
                    stringBuilder.append("、");
                }
                stringBuilder.append(skus.value);
            }
            return stringBuilder.toString();
        }
    }

    public ProductSectionItem(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.ohn = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.arH = parcel.readString();
                skus.value = parcel.readString();
                this.ohn.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.oho = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.ohp = parcel.readString();
        this.scene = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.ohn != null) {
            parcel.writeInt(this.ohn.size());
            for (int i2 = 0; i2 < this.ohn.size(); i2++) {
                Skus skus = (Skus) this.ohn.get(i2);
                parcel.writeString(skus.arH);
                parcel.writeString(skus.value);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.oho);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.ohp);
        parcel.writeInt(this.scene);
    }
}
