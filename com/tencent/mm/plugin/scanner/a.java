package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.i.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class a {

    private static class a implements k {
        private a() {
        }

        public final Bundle l(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            Set aXV = a.aXV();
            StringBuilder stringBuilder = new StringBuilder();
            if (!aXV.isEmpty()) {
                Iterator it = aXV.iterator();
                stringBuilder.append((String) it.next());
                while (it.hasNext()) {
                    stringBuilder.append("|");
                    stringBuilder.append((String) it.next());
                }
                bundle2.putString("wxCodePrefix", stringBuilder.toString());
            }
            return bundle2;
        }
    }

    public static boolean ak(int i, String str) {
        if (i != 22 || bg.mA(str)) {
            return false;
        }
        Set aXV;
        if (ab.bJb() || (Looper.myLooper() == Looper.getMainLooper() && !f.dV("com.tencent.mm"))) {
            aXV = aXV();
        } else {
            Set hashSet = new HashSet();
            Bundle a = e.a("com.tencent.mm", null, a.class);
            String str2 = "";
            if (a != null) {
                str2 = a.getString("wxCodePrefix", "");
            }
            String[] split = str2.split("|");
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!bg.mA(split[i2])) {
                    hashSet.add(split[i2]);
                }
            }
            aXV = hashSet;
        }
        for (String str22 : r0) {
            if (str.startsWith(str22)) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> aXV() {
        Set<String> hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (ab.bJb()) {
            String z;
            String str = "";
            c sW = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sW();
            if (sW != null) {
                z = sW.z("ScanCode", "weAppCodePrefix");
            } else {
                z = str;
            }
            w.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", z);
            if (!bg.mA(z)) {
                String[] split = z.split("|");
                for (int i = 0; i < split.length; i++) {
                    if (!bg.mA(split[i])) {
                        hashSet.add(split[i]);
                    }
                }
            }
        }
        return hashSet;
    }
}
