package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.b.k.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.i.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.bac;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;

public final class o implements e {
    public final b Ro() {
        String str = null;
        if (!h.vG().gXp || !a.QJ()) {
            return null;
        }
        int i;
        final aba Rm = k.Rm();
        b bVar = new b();
        if (Rm != null) {
            str = Rm.mQZ;
        }
        bVar.fNG = str;
        bVar.jhd = Rm == null ? 0 : Rm.tGY;
        if (Rm == null) {
            final Cursor a = c.PW().a(new String[]{"brandId", "versionType"}, 4, 0);
            Iterator anonymousClass1 = new Iterator<Object[]>(this) {
                boolean iCG;
                final Object[] iCH = new Object[3];
                final /* synthetic */ o iCJ;

                public final /* synthetic */ Object next() {
                    this.iCH[0] = a.getString(0);
                    this.iCH[1] = Integer.valueOf(a.getInt(1));
                    this.iCH[2] = Integer.valueOf(0);
                    return this.iCH;
                }

                public final boolean hasNext() {
                    if (this.iCG) {
                        boolean moveToNext = a.moveToNext();
                        if (moveToNext) {
                            return moveToNext;
                        }
                        a.close();
                        return moveToNext;
                    }
                    this.iCG = true;
                    return a.moveToFirst();
                }

                public final void remove() {
                }
            };
            i = 4;
        } else {
            Object anonymousClass2 = new Iterator<Object[]>(this) {
                final Object[] iCH = new Object[3];
                final /* synthetic */ o iCJ;
                final Iterator<bac> iCK = Rm.tGX.iterator();

                public final /* synthetic */ Object next() {
                    bac com_tencent_mm_protocal_c_bac = (bac) this.iCK.next();
                    this.iCH[0] = com_tencent_mm_protocal_c_bac.username;
                    this.iCH[1] = Integer.valueOf(com_tencent_mm_protocal_c_bac.tLJ);
                    this.iCH[2] = Integer.valueOf(com_tencent_mm_protocal_c_bac.tkv);
                    return this.iCH;
                }

                public final boolean hasNext() {
                    return this.iCK.hasNext();
                }

                public final void remove() {
                }
            };
            i = Rm.tGX.size();
        }
        bVar.hoO = new ArrayList(i);
        while (anonymousClass1.hasNext()) {
            Object[] objArr = (Object[]) anonymousClass1.next();
            WxaAttributes d = c.PR().d((String) objArr[0], "nickname", "brandIconURL");
            if (d != null) {
                e.c cVar = new e.c();
                cVar.username = (String) objArr[0];
                cVar.iPk = ((Integer) objArr[1]).intValue();
                cVar.fWF = ((Integer) objArr[2]).intValue();
                cVar.fFa = d.field_nickname;
                cVar.jhe = d.field_brandIconURL;
                bVar.hoO.add(cVar);
            }
        }
        k.hC(a.iCz);
        return bVar;
    }

    public final void a(Context context, String str, e.a aVar) {
        Intent intent = new Intent(context, AppBrandLauncherUI.class);
        intent.putExtra("extra_enter_scene", 10);
        intent.putExtra("extra_enter_scene_note", str + ":" + aVar.tag);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public final void a(Context context, e.c cVar, String str) {
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1054;
        appBrandStatObject.fCN = str;
        ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(context, cVar.username, cVar.iPk, cVar.fWF, null, appBrandStatObject);
    }
}
