package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d implements f {
    private byte[] aFF;
    private Map<String, g> aGR;
    private Uri apg;

    public d(f fVar) {
        this.apg = fVar.getUri();
        this.aFF = fVar.getData();
        Map hashMap = new HashMap();
        for (Entry entry : fVar.mD().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((g) entry.getValue()).jO());
            }
        }
        this.aGR = Collections.unmodifiableMap(hashMap);
    }

    public final byte[] getData() {
        return this.aFF;
    }

    public final Uri getUri() {
        return this.apg;
    }

    public final /* synthetic */ Object jO() {
        return this;
    }

    public final Map<String, g> mD() {
        return this.aGR;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.apg);
        stringBuilder.append(", dataSz=" + (this.aFF == null ? "null" : Integer.valueOf(this.aFF.length)));
        stringBuilder.append(", numAssets=" + this.aGR.size());
        if (isLoggable && !this.aGR.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.aGR.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
