package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;

public final class an extends af<an> {
    public String aBo;
    public long aBp;
    public String aqY;
    public String sk;

    public final /* synthetic */ void a(af afVar) {
        an anVar = (an) afVar;
        if (!TextUtils.isEmpty(this.sk)) {
            anVar.sk = this.sk;
        }
        if (!TextUtils.isEmpty(this.aqY)) {
            anVar.aqY = this.aqY;
        }
        if (!TextUtils.isEmpty(this.aBo)) {
            anVar.aBo = this.aBo;
        }
        if (this.aBp != 0) {
            anVar.aBp = this.aBp;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.sk);
        hashMap.put("action", this.aqY);
        hashMap.put("label", this.aBo);
        hashMap.put(Columns.VALUE, Long.valueOf(this.aBp));
        return af.ac(hashMap);
    }
}
