package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.g;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends com.google.android.gms.common.data.f implements com.google.android.gms.wearable.f {
    private final int aHk;

    public f(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.aHk = i2;
    }

    public final byte[] getData() {
        return getByteArray(SlookAirButtonFrequentContactAdapter.DATA);
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final /* synthetic */ Object jO() {
        return new d(this);
    }

    public final Map<String, g> mD() {
        Map<String, g> hashMap = new HashMap(this.aHk);
        for (int i = 0; i < this.aHk; i++) {
            c cVar = new c(this.aoy, this.aoU + i);
            if (cVar.getString("asset_key") != null) {
                hashMap.put(cVar.getString("asset_key"), cVar);
            }
        }
        return hashMap;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] byteArray = getByteArray(SlookAirButtonFrequentContactAdapter.DATA);
        Map mD = mD();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (byteArray == null ? "null" : Integer.valueOf(byteArray.length)));
        stringBuilder.append(", numAssets=" + mD.size());
        if (isLoggable && !mD.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : mD.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
