package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import com.tencent.mm.y.e;
import java.util.HashSet;
import java.util.Set;

public abstract class b implements e {
    public Activity activity;
    Set<Integer> sEO = new HashSet();

    public abstract boolean b(p pVar);

    public abstract boolean c(p pVar);

    public abstract boolean d(p pVar);

    public abstract boolean e(p pVar);

    public b(Activity activity) {
        this.activity = activity;
    }

    public final boolean a(p pVar) {
        if (pVar.action == 0) {
            return false;
        }
        switch (pVar.action) {
            case 1:
                return b(pVar);
            case 2:
                return c(pVar);
            case 4:
                return d(pVar);
            case 5:
                return e(pVar);
            default:
                return false;
        }
    }
}
