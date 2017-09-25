package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public final class h {
    public static final Bitmap IG(String str) {
        Bitmap bf = b.bEa().bf(str);
        if (bf == null) {
            n.Bl();
            w.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", d.r(str, false));
            return d.hn(d.r(str, false));
        }
        w.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", str);
        return bf;
    }

    public static String IH(String str) {
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (!o.dH(str)) {
            return com.tencent.mm.u.n.a(Rc, str);
        }
        String string = ab.getContext().getString(R.l.dVr);
        String a = com.tencent.mm.u.n.a(Rc, str);
        if (Rc.field_username.equals(a) || bg.mA(a)) {
            return string;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.bnw R(com.tencent.mm.storage.au r9) {
        /*
        r8 = 3;
        r7 = 2;
        r6 = -1;
        r3 = 0;
        r2 = 1;
        r4 = new com.tencent.mm.protocal.c.bnw;
        r4.<init>();
        r0 = r9.field_msgId;
        r4.umI = r0;
        r0 = r9.field_createTime;
        r4.umN = r0;
        r4.mtd = r2;
        r4.umO = r2;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x004c;
    L_0x001a:
        r0 = com.tencent.mm.u.m.xL();
        r0 = IH(r0);
        r4.tNz = r0;
        r0 = com.tencent.mm.u.m.xL();
        r4.umH = r0;
    L_0x002a:
        r0 = 0;
        r1 = r9.isSystem();
        if (r1 == 0) goto L_0x0086;
    L_0x0031:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEG;
        r0 = r0.getString(r1);
        r4.mtd = r8;
    L_0x003d:
        if (r0 != 0) goto L_0x0049;
    L_0x003f:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEF;
        r0 = r0.getString(r1);
    L_0x0049:
        r4.opI = r0;
        return r4;
    L_0x004c:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.u.o.dH(r0);
        if (r0 == 0) goto L_0x0079;
    L_0x0054:
        r1 = r9.field_talker;
        r0 = r9.field_content;
        r0 = com.tencent.mm.u.ay.gh(r0);
        if (r0 == r6) goto L_0x043f;
    L_0x005e:
        r5 = r9.field_content;
        r0 = r5.substring(r3, r0);
        r0 = r0.trim();
        if (r0 == 0) goto L_0x043f;
    L_0x006a:
        r5 = r0.length();
        if (r5 <= 0) goto L_0x043f;
    L_0x0070:
        r1 = IH(r0);
        r4.tNz = r1;
        r4.umH = r0;
        goto L_0x002a;
    L_0x0079:
        r0 = r9.field_talker;
        r0 = IH(r0);
        r4.tNz = r0;
        r0 = r9.field_talker;
        r4.umH = r0;
        goto L_0x002a;
    L_0x0086:
        r1 = r9.bMh();
        if (r1 == 0) goto L_0x009a;
    L_0x008c:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEm;
        r0 = r0.getString(r1);
        r1 = 4;
        r4.mtd = r1;
        goto L_0x003d;
    L_0x009a:
        r1 = r9.bMk();
        if (r1 == 0) goto L_0x00ca;
    L_0x00a0:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.u.o.dH(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x00a8:
        r0 = r9.field_isSend;
        if (r0 == r2) goto L_0x00c6;
    L_0x00ac:
        r0 = r9.field_content;
        r0 = com.tencent.mm.u.ay.gh(r0);
        if (r0 == r6) goto L_0x00c2;
    L_0x00b4:
        r1 = r9.field_content;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = r0.trim();
        goto L_0x003d;
    L_0x00c2:
        r0 = r9.field_content;
        goto L_0x003d;
    L_0x00c6:
        r0 = r9.field_content;
        goto L_0x003d;
    L_0x00ca:
        r1 = r9.bLZ();
        if (r1 == 0) goto L_0x0110;
    L_0x00d0:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEI;
        r0 = r0.getString(r1);
        r1 = 6;
        r4.mtd = r1;
        r1 = com.tencent.mm.modelvoice.q.C(r9);
        r4.umO = r1;
        r1 = new com.tencent.mm.modelvoice.n;
        r5 = r9.field_content;
        r1.<init>(r5);
        r6 = r1.time;
        r1 = com.tencent.mm.modelvoice.q.aw(r6);
        r5 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r6 = com.tencent.mm.R.l.ema;
        r2 = new java.lang.Object[r2];
        r1 = (int) r1;
        r1 = java.lang.Integer.valueOf(r1);
        r2[r3] = r1;
        r1 = r5.getString(r6, r2);
        r2 = new com.tencent.mm.bd.b;
        r1 = r1.getBytes();
        r2.<init>(r1);
        r4.umP = r2;
        goto L_0x003d;
    L_0x0110:
        r1 = r9.bMl();
        if (r1 == 0) goto L_0x0122;
    L_0x0116:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEH;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0122:
        r1 = r9.bMm();
        if (r1 == 0) goto L_0x0134;
    L_0x0128:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEE;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0134:
        r1 = r9.bMa();
        if (r1 == 0) goto L_0x0175;
    L_0x013a:
        r1 = r9.field_content;
        r1 = com.tencent.mm.t.f.a.ek(r1);
        if (r1 == 0) goto L_0x003d;
    L_0x0142:
        r0 = r1.hiW;
        r5 = "wxpay://c2cbizmessagehandler/hongbao/receivehongbao";
        r0 = r0.startsWith(r5);
        if (r0 == 0) goto L_0x015c;
    L_0x014d:
        r0 = 5;
        r4.mtd = r0;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x0158;
    L_0x0154:
        r0 = r1.hiQ;
        goto L_0x003d;
    L_0x0158:
        r0 = r1.hiP;
        goto L_0x003d;
    L_0x015c:
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x0172;
    L_0x0160:
        r0 = r1.hiQ;
    L_0x0162:
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEg;
        r2 = new java.lang.Object[r2];
        r2[r3] = r0;
        r0 = r1.getString(r5, r2);
        goto L_0x003d;
    L_0x0172:
        r0 = r1.hiP;
        goto L_0x0162;
    L_0x0175:
        r1 = r9.bMb();
        if (r1 == 0) goto L_0x018a;
    L_0x017b:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEf;
        r0 = r0.getString(r1);
        r1 = 5;
        r4.mtd = r1;
        goto L_0x003d;
    L_0x018a:
        r1 = r9.axO();
        if (r1 == 0) goto L_0x02ec;
    L_0x0190:
        r1 = r9.field_content;
        r1 = com.tencent.mm.t.f.a.ek(r1);
        if (r1 == 0) goto L_0x003d;
    L_0x0198:
        r5 = r1.type;
        switch(r5) {
            case 2: goto L_0x019f;
            case 3: goto L_0x01ce;
            case 4: goto L_0x0208;
            case 5: goto L_0x01b1;
            case 6: goto L_0x01eb;
            case 7: goto L_0x019d;
            case 8: goto L_0x02d3;
            case 9: goto L_0x019d;
            case 10: goto L_0x025f;
            case 11: goto L_0x019d;
            case 12: goto L_0x019d;
            case 13: goto L_0x027c;
            case 14: goto L_0x019d;
            case 15: goto L_0x0242;
            case 16: goto L_0x02b6;
            case 17: goto L_0x019d;
            case 18: goto L_0x019d;
            case 19: goto L_0x0225;
            case 20: goto L_0x0299;
            default: goto L_0x019d;
        };
    L_0x019d:
        goto L_0x003d;
    L_0x019f:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEm;
        r0 = r0.getString(r1);
        r1 = new java.lang.Object[r3];
        r0 = java.lang.String.format(r0, r1);
        goto L_0x003d;
    L_0x01b1:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eDX;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x01ce:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEa;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x01eb:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eDW;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0208:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEe;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0225:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEc;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0242:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eDV;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x025f:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEb;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x027c:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eDZ;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0299:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEd;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x02b6:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEh;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x02d3:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEi;
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r6 = "";
        r1 = com.tencent.mm.sdk.platformtools.bg.ap(r1, r6);
        r2[r3] = r1;
        r0 = r0.getString(r5, r2);
        goto L_0x003d;
    L_0x02ec:
        r1 = r9.bMn();
        if (r1 == 0) goto L_0x0391;
    L_0x02f2:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEj;
        r1 = r0.getString(r1);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.h.j(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        if (r0 == 0) goto L_0x043c;
    L_0x030a:
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.h.j(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r1 = r9.field_imgPath;
        r1 = r0.ub(r1);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.h.j(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r3 = r1.EP();
        r0 = r0.ue(r3);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x0362;
    L_0x0336:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = com.tencent.mm.R.l.eEj;
        r0 = r0.getString(r3);
    L_0x0340:
        r3 = new com.tencent.mm.protocal.c.bnf;
        r3.<init>();
        r5 = r1.EP();
        r3.tuy = r5;
        r1 = r1.isGif();
        if (r1 == 0) goto L_0x038e;
    L_0x0351:
        r3.jOc = r2;
    L_0x0353:
        r1 = new com.tencent.mm.bd.b;	 Catch:{ IOException -> 0x0439 }
        r2 = r3.toByteArray();	 Catch:{ IOException -> 0x0439 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0439 }
        r4.umP = r1;	 Catch:{ IOException -> 0x0439 }
    L_0x035e:
        r4.mtd = r7;
        goto L_0x003d;
    L_0x0362:
        r3 = new java.lang.StringBuilder;
        r0 = "[";
        r3.<init>(r0);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.h.j(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r5 = r1.EP();
        r0 = r0.ue(r5);
        r0 = r3.append(r0);
        r3 = "]";
        r0 = r0.append(r3);
        r0 = r0.toString();
        goto L_0x0340;
    L_0x038e:
        r3.jOc = r7;
        goto L_0x0353;
    L_0x0391:
        r1 = r9.bMj();
        if (r1 == 0) goto L_0x03a3;
    L_0x0397:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEn;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03a3:
        r1 = r9.bMd();
        if (r1 != 0) goto L_0x03b8;
    L_0x03a9:
        r1 = r9.bMe();
        if (r1 != 0) goto L_0x03b8;
    L_0x03af:
        r1 = r9.field_type;
        r5 = 64;
        if (r1 != r5) goto L_0x03eb;
    L_0x03b5:
        r1 = r2;
    L_0x03b6:
        if (r1 == 0) goto L_0x03fb;
    L_0x03b8:
        r0 = r9.field_content;
        r1 = com.tencent.mm.storage.au.uJQ;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x03df;
    L_0x03c2:
        r0 = r9.field_content;
        r1 = new com.tencent.mm.e.a.rr;
        r1.<init>();
        r5 = r1.fYI;
        r5.fJK = r2;
        r5 = r1.fYI;
        r5.content = r0;
        r0 = com.tencent.mm.sdk.b.a.urY;
        r0.m(r1);
        r0 = r1.fYJ;
        r0 = r0.type;
        if (r0 != r8) goto L_0x03ed;
    L_0x03dc:
        r0 = r2;
    L_0x03dd:
        if (r0 == 0) goto L_0x03ef;
    L_0x03df:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEK;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03eb:
        r1 = r3;
        goto L_0x03b6;
    L_0x03ed:
        r0 = r3;
        goto L_0x03dd;
    L_0x03ef:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eEJ;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03fb:
        r1 = r9.bMi();
        if (r1 == 0) goto L_0x0426;
    L_0x0401:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r1 = r9.field_content;
        r0 = r0.Av(r1);
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.R.l.eEh;
        r1 = r1.getString(r5);
        r2 = new java.lang.Object[r2];
        r0 = r0.getDisplayName();
        r2[r3] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x003d;
    L_0x0426:
        r1 = r9.field_type;
        r2 = -1879048186; // 0xffffffff90000006 float:-2.5243567E-29 double:NaN;
        if (r1 != r2) goto L_0x003d;
    L_0x042d:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.R.l.eDY;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0439:
        r1 = move-exception;
        goto L_0x035e;
    L_0x043c:
        r0 = r1;
        goto L_0x003d;
    L_0x043f:
        r0 = r1;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.h.R(com.tencent.mm.storage.au):com.tencent.mm.protocal.c.bnw");
    }

    public static byte[] G(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean bvO() {
        try {
            ab.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean bvP() {
        try {
            ab.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static byte[] II(String str) {
        return FileOp.c(new File(new File(a.hgp, "lib"), "lib" + str + ".so").getAbsolutePath(), 0, -1);
    }
}
