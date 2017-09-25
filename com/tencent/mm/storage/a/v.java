package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class v extends i<u> implements a {
    public static final String[] gUx = new String[]{i.a(u.gTP, "SmileyPanelConfigInfo")};
    private static final String[] uLw = new String[]{"position", "key"};
    public e gUz;

    public v(e eVar) {
        this(eVar, u.gTP, "SmileyPanelConfigInfo");
    }

    private v(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final ArrayList<u> alF() {
        Cursor a;
        Throwable e;
        ArrayList<u> arrayList = new ArrayList();
        try {
            a = this.gUz.a("SmileyPanelConfigInfo", uLw, null, null, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            u uVar = new u();
                            uVar.b(a);
                            arrayList.add(uVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", bg.g(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", bg.g(e));
            if (a != null) {
                a.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }
}
