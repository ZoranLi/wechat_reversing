package com.google.android.gms.c;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ak extends af<ak> {
    public String aAW;
    public String aAX;
    public String aAY;
    public String aAZ;
    public String aBa;
    public String aBb;
    public String aBc;
    public String aBd;
    public String ahk;
    public String mName;

    public final /* synthetic */ void a(af afVar) {
        ak akVar = (ak) afVar;
        if (!TextUtils.isEmpty(this.mName)) {
            akVar.mName = this.mName;
        }
        if (!TextUtils.isEmpty(this.aAW)) {
            akVar.aAW = this.aAW;
        }
        if (!TextUtils.isEmpty(this.aAX)) {
            akVar.aAX = this.aAX;
        }
        if (!TextUtils.isEmpty(this.aAY)) {
            akVar.aAY = this.aAY;
        }
        if (!TextUtils.isEmpty(this.aAZ)) {
            akVar.aAZ = this.aAZ;
        }
        if (!TextUtils.isEmpty(this.ahk)) {
            akVar.ahk = this.ahk;
        }
        if (!TextUtils.isEmpty(this.aBa)) {
            akVar.aBa = this.aBa;
        }
        if (!TextUtils.isEmpty(this.aBb)) {
            akVar.aBb = this.aBb;
        }
        if (!TextUtils.isEmpty(this.aBc)) {
            akVar.aBc = this.aBc;
        }
        if (!TextUtils.isEmpty(this.aBd)) {
            akVar.aBd = this.aBd;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put("source", this.aAW);
        hashMap.put("medium", this.aAX);
        hashMap.put("keyword", this.aAY);
        hashMap.put("content", this.aAZ);
        hashMap.put(SlookAirButtonFrequentContactAdapter.ID, this.ahk);
        hashMap.put("adNetworkId", this.aBa);
        hashMap.put("gclid", this.aBb);
        hashMap.put("dclid", this.aBc);
        hashMap.put("aclid", this.aBd);
        return af.ac(hashMap);
    }
}
