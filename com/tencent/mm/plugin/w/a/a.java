package com.tencent.mm.plugin.w.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.LinkedList;

public interface a {

    public static class a {
        private static a ofo = null;

        public static void a(a aVar) {
            ofo = aVar;
        }

        public static a aRv() {
            return ofo;
        }
    }

    f Cl(String str);

    void Cm(String str);

    void Z(LinkedList<String> linkedList);

    Bitmap a(String str, int i, float f);

    i aRt();

    Cursor aRu();

    void bv(String str, int i);

    void c(f fVar);

    Cursor cG(int i, int i2);

    void d(f fVar);

    void e(f fVar);

    Cursor m(int[] iArr);

    Cursor qT(int i);
}
