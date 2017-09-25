package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.snackbar.b.c;

public final class a {
    private static boolean wjH = false;

    public static void c(Activity activity, String str, String str2) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(activity);
        aVar.mMessage = str;
        aVar.wjI = str2;
        aVar.wjV = 0;
        a(aVar.a(Short.valueOf((short) 2500)), null, null);
    }

    public static void a(int i, Activity activity, String str, String str2, b bVar, c cVar) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(activity);
        aVar.mMessage = str;
        aVar.wjI = str2;
        aVar = aVar.a(Short.valueOf((short) 2500));
        aVar.wjV = i;
        a(aVar, bVar, cVar);
    }

    public static void a(int i, Fragment fragment, String str, String str2, b bVar, c cVar) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(fragment.getContext(), fragment.mView);
        aVar.mMessage = str;
        aVar.wjI = str2;
        aVar = aVar.a(Short.valueOf((short) 2500));
        aVar.wjV = i;
        a(aVar, bVar, cVar);
    }

    public static void a(Context context, View view, String str) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(context, view);
        aVar.mMessage = str;
        aVar.a(Short.valueOf((short) 1500)).bZq();
    }

    public static void e(Activity activity, String str) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(activity);
        aVar.mMessage = str;
        a(aVar.a(Short.valueOf((short) 1500)), null, null);
    }

    private static void a(com.tencent.mm.ui.snackbar.b.a aVar, b bVar, c cVar) {
        if (bVar != null) {
            aVar.wjU.wjO = bVar;
        }
        if (cVar != null) {
            aVar.wjU.wjP = cVar;
        }
        aVar.bZq();
    }

    public static boolean asn() {
        return wjH;
    }

    public static void lD(boolean z) {
        wjH = z;
    }
}
