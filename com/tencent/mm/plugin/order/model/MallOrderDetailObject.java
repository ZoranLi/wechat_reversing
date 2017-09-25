package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MallOrderDetailObject {
    public String fKK;
    public String lmf;
    public List<HelpCenter> ofA = new LinkedList();
    int ofB = -1;
    public String ofC;
    public String ofD;
    public int ofE;
    public MallTransactionObject ofw;
    public b ofx;
    public ArrayList<ProductSectionItem> ofy;
    public List<a> ofz;

    public static class HelpCenter implements Parcelable {
        public static final Creator<HelpCenter> CREATOR = new Creator<HelpCenter>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HelpCenter(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HelpCenter[i];
            }
        };
        public boolean fEq;
        public String name;
        public String url;

        protected HelpCenter() {
        }

        protected HelpCenter(Parcel parcel) {
            this.name = parcel.readString();
            this.url = parcel.readString();
            this.fEq = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeByte((byte) (this.fEq ? 1 : 0));
        }

        public int describeContents() {
            return 0;
        }
    }

    public static class a {
        public int jumpType;
        public String jumpUrl;
        public boolean kdT;
        public String name;
        public int type = 0;
        public String value;
    }

    public static class b {
        public int cIm;
        public String msF;
        public String ofF;
        public String ofG;
        public String thumbUrl;
    }

    static ArrayList<ProductSectionItem> E(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("product_section");
        if (jSONObject2 == null) {
            return null;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("items");
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList<ProductSectionItem> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            ProductSectionItem productSectionItem = new ProductSectionItem();
            productSectionItem.iconUrl = jSONObject3.optString("icon_url");
            productSectionItem.name = jSONObject3.optString("name");
            try {
                productSectionItem.ohn = F(jSONObject3);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
            }
            productSectionItem.count = jSONObject3.optInt("count");
            productSectionItem.oho = jSONObject3.optString("price");
            productSectionItem.jumpUrl = jSONObject3.optString("jump_url");
            productSectionItem.ohp = jSONObject3.optString("pid");
            productSectionItem.scene = jSONObject3.optInt("scene");
            arrayList.add(productSectionItem);
        }
        return arrayList;
    }

    private static List<Skus> F(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("skus");
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        List<Skus> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Skus skus = new Skus();
            skus.arH = jSONObject2.optString("key");
            skus.value = jSONObject2.optString(Columns.VALUE);
            arrayList.add(skus);
        }
        return arrayList;
    }
}
