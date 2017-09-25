package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.widget.ImageView;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bg.mA(str)) {
                a aVar = new a();
                aVar.hIN = m.jC(str);
                aVar.hIL = true;
                aVar.hJh = true;
                aVar.hJi = z;
                if (i != 0) {
                    aVar.hJe = i;
                }
                n.GW().a(str, imageView, aVar.Hg());
            }
        }
    }

    public static String bbN() {
        g baT = m.baT();
        List<f> arrayList = new ArrayList();
        Cursor a = baT.gUz.a("SELECT * FROM " + baT.getTableName() + " where status != 1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.b(a);
                arrayList.add(fVar);
            }
            a.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar2 : arrayList) {
            stringBuilder.append(fVar2.field_reserved1);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
