package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String rQM;
    public PayUBankcardElement rQO;

    public static class PayUBankcardElement implements Parcelable {
        public String cardType = "";
        public String fOv = "";
        public String ofY = "";
        public String rQP = "";
        public String rQQ = "";

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.rQP);
            parcel.writeString(this.ofY);
            parcel.writeString(this.rQQ);
            parcel.writeString(this.cardType);
            parcel.writeString(this.fOv);
        }
    }

    public NetScenePayUElementQuery(String str) {
        this.rQM = str;
        Map hashMap = new HashMap();
        hashMap.put("card_number", str);
        x(hashMap);
    }

    public final int btw() {
        return 22;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.rQO = new PayUBankcardElement();
        this.rQO.rQP = jSONObject.optString("bin");
        this.rQO.ofY = jSONObject.optString("bank_name");
        this.rQO.rQQ = jSONObject.optString("issuer_type");
        this.rQO.cardType = jSONObject.optString("card_type");
        this.rQO.fOv = jSONObject.optString("payu_reference");
    }
}
