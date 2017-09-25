package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.ArrayList;
import org.json.JSONObject;

public final class d {
    String fwY;
    public String hEr;
    public String kMS;
    public String qJM;
    String rPA;
    public String rPB;
    long rPC;
    int rPD;
    public String rPE;
    public String rPF;
    public String rPG;
    public String rPH;

    public d(String str, String str2, String str3) {
        this.rPA = str;
        this.rPF = str2;
        JSONObject jSONObject = new JSONObject(this.rPF);
        this.rPB = jSONObject.optString("orderId");
        this.fwY = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        this.kMS = jSONObject.optString("productId");
        this.rPC = jSONObject.optLong("purchaseTime");
        this.rPD = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList Iv = Iv(optString);
        if (Iv.size() == 3) {
            this.rPE = (String) Iv.get(0);
            this.rPH = (String) Iv.get(1);
            this.rPG = (String) Iv.get(2);
        } else {
            this.rPE = optString;
        }
        this.hEr = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.qJM = str3;
    }

    public d(String str, String str2, String str3, String str4) {
        this.kMS = str;
        this.rPE = str2;
        this.rPG = str3;
        this.rPH = str4;
    }

    private static ArrayList<String> Iv(String str) {
        ArrayList<String> arrayList = new ArrayList();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        return arrayList;
    }

    public final String toString() {
        return "PurchaseInfo(type:" + this.rPA + "):" + this.rPF;
    }
}
