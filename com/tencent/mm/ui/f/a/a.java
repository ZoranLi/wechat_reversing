package com.tencent.mm.ui.f.a;

import android.widget.ImageView;

public final class a {
    private static b wfO = null;

    public static void a(b bVar) {
        wfO = bVar;
    }

    public static void a(ImageView imageView, String str) {
        if (wfO != null) {
            wfO.a(imageView, str);
        }
    }
}
