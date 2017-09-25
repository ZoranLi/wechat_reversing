package com.tencent.mm.u.b;

import android.content.SharedPreferences;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public abstract class a implements e {
    protected com.tencent.mm.u.b.e.a hoG;
    protected String hoH = Ag();
    protected String[] hoI = Af();

    public abstract String Ag();

    public final boolean gA(String str) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef == null || !ef.getBoolean(this.hoH + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef != null) {
            ef.edit().putBoolean(this.hoH + str, z).commit();
            if (!(this.hoI == null || strArr == null || this.hoI.length != strArr.length)) {
                int i = 0;
                for (String str2 : this.hoI) {
                    if (str2 != null) {
                        ef.edit().putString(this.hoH + str2 + str, strArr[i] != null ? strArr[i] : "").commit();
                    }
                    i++;
                }
            }
            if (this.hoG != null) {
                this.hoG.As();
            }
        }
    }

    public final String O(String str, String str2) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef == null) {
            return null;
        }
        return ef.getString(this.hoH + str2 + str, null);
    }

    public final void gB(String str) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef != null) {
            ef.edit().remove(this.hoH + str).commit();
            if (this.hoI != null) {
                for (String str2 : this.hoI) {
                    if (str2 != null) {
                        ef.edit().remove(this.hoH + str2 + str).commit();
                    }
                }
            }
            if (this.hoG != null) {
                this.hoG.At();
            }
        }
    }

    public final void a(com.tencent.mm.u.b.e.a aVar) {
        this.hoG = aVar;
    }

    protected String[] Af() {
        return null;
    }
}
