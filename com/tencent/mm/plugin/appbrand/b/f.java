package com.tencent.mm.plugin.appbrand.b;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.k;
import java.lang.reflect.Field;
import java.util.Locale;

public final class f extends j {
    public static final String[] iCe = new String[]{i.a(a.izp, "AppBrandStarApp")};
    public final c iCf;
    public volatile int iCg = 10;
    public final g izH;

    class AnonymousClass1 implements com.tencent.mm.y.u.a {
        final /* synthetic */ String hqR;
        final /* synthetic */ int iCh;
        final /* synthetic */ long iCi;
        final /* synthetic */ f iCj;

        public AnonymousClass1(f fVar, String str, int i, long j) {
            this.iCj = fVar;
            this.hqR = str;
            this.iCh = i;
            this.iCi = j;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
            if (!(i == 0 && i2 == 0 && ((bgy) bVar.hsk.hsr).tqD.leR == 0) && this.iCj.izH.isOpen()) {
                com.tencent.mm.sdk.e.c aVar = new a();
                aVar.field_username = this.hqR;
                aVar.field_versionType = this.iCh;
                aVar.field_updateTime = this.iCi;
                this.iCj.iCf.b(aVar, false, new String[]{"updateTime", "username", "versionType"});
                if (!this.iCj.U(this.hqR, this.iCh)) {
                    this.iCj.a("single", 3, aVar);
                }
            }
            return 0;
        }
    }

    public enum b {
        ;

        static {
            iCm = 1;
            iCn = 2;
            iCo = new int[]{iCm, iCn};
        }
    }

    private static final class c extends i<a> {
        c(g gVar) {
            super(gVar, a.izp, "AppBrandStarApp", a.gaK);
        }
    }

    static final class a extends com.tencent.mm.e.b.k {
        static final String[] iCl = new String[]{"username", "versionType"};
        static final com.tencent.mm.sdk.e.c.a izp;

        protected final com.tencent.mm.sdk.e.c.a sY() {
            return izp;
        }

        static {
            int i = 0;
            com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
            aVar.hXH = new Field[3];
            aVar.columns = new String[4];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.columns[0] = "username";
            aVar.uxd.put("username", "TEXT");
            stringBuilder.append(" username TEXT");
            stringBuilder.append(", ");
            aVar.columns[1] = "versionType";
            aVar.uxd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.columns[2] = "updateTime";
            aVar.uxd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            aVar.columns[3] = "rowid";
            aVar.uxe = stringBuilder.toString();
            izp = aVar;
            String str = " PRIMARY KEY ( ";
            String[] strArr = iCl;
            int length = strArr.length;
            while (i < length) {
                str = str + ", " + strArr[i];
                i++;
            }
            String str2 = str.replaceFirst(",", "") + " )";
            StringBuilder stringBuilder2 = new StringBuilder();
            com.tencent.mm.sdk.e.c.a aVar2 = izp;
            aVar2.uxe = stringBuilder2.append(aVar2.uxe).append(",").append(str2).toString();
        }
    }

    public f(g gVar) {
        this.izH = gVar;
        this.iCf = new c(gVar);
    }

    public final void c(com.tencent.mm.sdk.e.j.a aVar) {
        a(aVar, d.vL().nJF.getLooper());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.b.f.b<java.util.ArrayList> hB(int r12) {
        /*
        r11 = this;
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r3 = 0;
        if (r12 != 0) goto L_0x0008;
    L_0x0006:
        r12 = com.tencent.mm.plugin.appbrand.b.f.b.iCm;
    L_0x0008:
        r0 = r11.izH;
        r1 = "AppBrandStarApp";
        r2 = new java.lang.String[r10];
        r4 = "username";
        r2[r8] = r4;
        r4 = "versionType";
        r2[r9] = r4;
        r4 = java.util.Locale.US;
        r5 = "%s desc limit %d offset 0";
        r6 = new java.lang.Object[r10];
        r7 = "updateTime";
        r6[r8] = r7;
        r7 = r11.iCg;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r9] = r7;
        r7 = java.lang.String.format(r4, r5, r6);
        r4 = r3;
        r5 = r3;
        r6 = r3;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        if (r0 != 0) goto L_0x003b;
    L_0x003a:
        return r3;
    L_0x003b:
        r1 = com.tencent.mm.plugin.appbrand.b.f.b.iCn;
        if (r1 != r12) goto L_0x0090;
    L_0x003f:
        r1 = r0.moveToLast();
        if (r1 == 0) goto L_0x008c;
    L_0x0045:
        r1 = new java.util.LinkedList;
        r1.<init>();
        r2 = new com.tencent.mm.plugin.appbrand.b.f$a;
        r2.<init>();
    L_0x004f:
        r2.b(r0);
        r3 = java.util.Locale.US;
        r4 = "$%s$%d@starapp";
        r5 = new java.lang.Object[r10];
        r6 = r2.field_username;
        r5[r8] = r6;
        r6 = r2.field_versionType;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r9] = r6;
        r3 = java.lang.String.format(r3, r4, r5);
        r4 = r2.field_username;
        r5 = r2.field_versionType;
        r6 = -1;
        r3 = com.tencent.mm.plugin.appbrand.config.p.a(r3, r4, r5, r6);
        r1.add(r3);
        r3 = com.tencent.mm.plugin.appbrand.b.f.b.iCn;
        if (r3 != r12) goto L_0x0097;
    L_0x007a:
        r3 = r0.moveToPrevious();
        if (r3 != 0) goto L_0x004f;
    L_0x0080:
        r3 = new java.util.ArrayList;
        r2 = r1.size();
        r3.<init>(r2);
        r3.addAll(r1);
    L_0x008c:
        r0.close();
        goto L_0x003a;
    L_0x0090:
        r1 = r0.moveToFirst();
        if (r1 == 0) goto L_0x008c;
    L_0x0096:
        goto L_0x0045;
    L_0x0097:
        r3 = r0.moveToNext();
        if (r3 != 0) goto L_0x004f;
    L_0x009d:
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.b.f.hB(int):com.tencent.mm.plugin.appbrand.b.f$b<java.util.ArrayList>");
    }

    public final boolean U(String str, int i) {
        Cursor cursor = null;
        if (!bg.mA(str)) {
            cursor = this.izH.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"username", "versionType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        }
        if (cursor == null) {
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        return moveToFirst;
    }

    public final boolean h(final String str, final int i, boolean z) {
        if (bg.mA(str)) {
            return false;
        }
        boolean z2;
        m mVar;
        final com.tencent.mm.sdk.e.c aVar = new a();
        aVar.field_username = str;
        aVar.field_versionType = i;
        if (this.iCf.b(aVar, new String[]{"versionType", "username"})) {
            this.iCf.b(aVar, false, a.iCl);
            if (U(str, i)) {
                z2 = false;
                if (z2 && z) {
                    mVar = new m(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, false, i, 1, 2, str, 1);
                    mVar.iCE = new com.tencent.mm.y.u.a(this) {
                        final /* synthetic */ f iCj;

                        public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                            if (!(i == 0 && i2 == 0 && ((bgy) bVar.hsk.hsr).tqD.leR == 0) && this.iCj.izH.isOpen()) {
                                this.iCj.iCf.a(aVar, false);
                                if (this.iCj.U(str, i)) {
                                    this.iCj.a("single", 2, aVar);
                                }
                            }
                            return 0;
                        }
                    };
                    mVar.BC();
                }
                return z2;
            }
            a("single", 5, aVar);
        }
        z2 = true;
        mVar = new m(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, false, i, 1, 2, str, 1);
        mVar.iCE = /* anonymous class already generated */;
        mVar.BC();
        return z2;
    }
}
