package com.google.android.gms.c;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ad implements ai {
    private static final Uri aAv;
    private final LogPrinter aAw = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        aAv = builder.build();
    }

    public final void b(ae aeVar) {
        List<af> arrayList = new ArrayList(aeVar.aAG.values());
        Collections.sort(arrayList, new Comparator<af>(this) {
            final /* synthetic */ ad aAx;

            {
                this.aAx = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((af) obj).getClass().getCanonicalName().compareTo(((af) obj2).getClass().getCanonicalName());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (af obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.aAw.println(stringBuilder.toString());
    }

    public final Uri ja() {
        return aAv;
    }
}
