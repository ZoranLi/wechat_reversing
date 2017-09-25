package com.tencent.mm.pluginsdk.b;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class b {
    private static HashMap<String, a> sBJ = new HashMap();
    private static final Pattern sBK = Pattern.compile(" +");

    public static void a(a aVar, String... strArr) {
        synchronized (sBJ) {
            for (Object put : strArr) {
                sBJ.put(put, aVar);
                w.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", put);
            }
        }
    }

    public static void B(String... strArr) {
        synchronized (sBJ) {
            for (Object remove : strArr) {
                sBJ.remove(remove);
                w.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", remove);
            }
        }
    }

    public static boolean aO(Context context, String str) {
        String[] split = sBK.split(str);
        synchronized (sBJ) {
            a aVar = (a) sBJ.get(split[0]);
        }
        if (aVar == null) {
            return false;
        }
        w.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", split[0]);
        return aVar.a(context, split);
    }
}
