package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.sdk.platformtools.bg;

public final class d {

    private static class a implements i<Bundle, ContentValues> {
        private a() {
        }

        public final /* synthetic */ Object al(Object obj) {
            a aVar;
            String string = ((Bundle) obj).getString(SlookAirButtonFrequentContactAdapter.ID);
            b PZ = c.PZ();
            if (bg.mA(string)) {
                aVar = null;
            } else {
                aVar = new a();
                aVar.field_id = string;
                if (!PZ.b(aVar, new String[]{SlookAirButtonFrequentContactAdapter.ID})) {
                    aVar = null;
                }
            }
            return aVar == null ? null : aVar.pv();
        }
    }

    private static class b implements i<ContentValues, Bundle> {
        private b() {
        }

        public final /* synthetic */ Object al(Object obj) {
            ContentValues contentValues = (ContentValues) obj;
            b PZ = c.PZ();
            com.tencent.mm.sdk.e.c a = d.a(contentValues);
            boolean b = (a == null || (a.uxb > 0 && PZ.a(a))) ? false : PZ.b(a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("result", b);
            return bundle;
        }
    }

    public static a oS(String str) {
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        return a((ContentValues) e.a("com.tencent.mm", bundle, a.class));
    }

    public static a a(ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        a aVar = new a();
        aVar.field_id = contentValues.getAsString(SlookAirButtonFrequentContactAdapter.ID);
        aVar.field_appId = contentValues.getAsString("appId");
        aVar.field_cacheKey = contentValues.getAsString("cacheKey");
        aVar.field_updateTime = bg.c(contentValues.getAsLong("updateTime"));
        aVar.field_interval = bg.f(contentValues.getAsInteger("interval"));
        aVar.uxb = bg.c(contentValues.getAsLong("rowid"));
        return aVar;
    }
}
