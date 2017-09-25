package com.google.android.gms.c;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import java.util.HashMap;
import java.util.Map;

public final class h extends af<h> {
    public String aiI;
    public String ayN;
    public String ayO;
    public String ayP;
    public boolean ayQ;
    public String ayR;
    public boolean ayS;
    public double ayT;

    public final /* synthetic */ void a(af afVar) {
        boolean z = true;
        h hVar = (h) afVar;
        if (!TextUtils.isEmpty(this.ayN)) {
            hVar.ayN = this.ayN;
        }
        if (!TextUtils.isEmpty(this.aiI)) {
            hVar.aiI = this.aiI;
        }
        if (!TextUtils.isEmpty(this.ayO)) {
            hVar.ayO = this.ayO;
        }
        if (!TextUtils.isEmpty(this.ayP)) {
            hVar.ayP = this.ayP;
        }
        if (this.ayQ) {
            hVar.ayQ = true;
        }
        if (!TextUtils.isEmpty(this.ayR)) {
            hVar.ayR = this.ayR;
        }
        if (this.ayS) {
            hVar.ayS = this.ayS;
        }
        if (this.ayT != 0.0d) {
            double d = this.ayT;
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            w.b(z, "Sample rate must be between 0% and 100%");
            hVar.ayT = d;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.ayN);
        hashMap.put(Columns.CLIENTID, this.aiI);
        hashMap.put("userId", this.ayO);
        hashMap.put("androidAdId", this.ayP);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.ayQ));
        hashMap.put("sessionControl", this.ayR);
        hashMap.put("nonInteraction", Boolean.valueOf(this.ayS));
        hashMap.put("sampleRate", Double.valueOf(this.ayT));
        return af.ac(hashMap);
    }
}
