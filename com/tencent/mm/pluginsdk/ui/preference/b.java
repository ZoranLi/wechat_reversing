package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.av.f;
import com.tencent.mm.av.h;
import com.tencent.mm.av.j;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.fh;
import com.tencent.mm.e.b.bz;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import junit.framework.Assert;

public final class b {
    public String fFa;
    public boolean fZK;
    public String hku;
    public long id;
    public String ovd;
    public int prC;
    public String sSg;
    public String username;

    public static b a(Context context, f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        long j = fVar.uxb;
        boolean Kp = fVar.Kp();
        String str7 = fVar.field_talker;
        String str8 = fVar.field_msgContent;
        int i = fVar.field_type;
        int i2 = 0;
        if (i == 0) {
            a RF = a.RF(str8);
            str = RF.rUK;
            str2 = RF.fFa;
            str3 = RF.uJX;
            str4 = RF.uJY;
            i2 = RF.scene;
            str5 = null;
        } else if (Kp) {
            d RI = d.RI(str8);
            str = RI.rUK;
            str2 = RI.fFa;
            str5 = RI.content;
            if (RI.uKk == 1) {
                str4 = null;
                str3 = null;
                str6 = RI.uKm;
            } else {
                str4 = null;
                str3 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        b a = a(context, j, Kp, str7, str8, i, str, str2, str3, str4, str5, i2);
        a.sSg = str6;
        return a;
    }

    public static b a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        b bVar = new b();
        bVar.id = j;
        bVar.fZK = !z;
        w.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", Integer.valueOf(i), str, Integer.valueOf(i2));
        if (i == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.fFa = str4;
                switch (i2) {
                    case 4:
                        bVar.hku = context.getString(R.l.dTu);
                        break;
                    case 10:
                    case 11:
                        com.tencent.mm.sdk.b.b fhVar = new fh();
                        fhVar.fJR.fJO = str5;
                        fhVar.fJR.fJP = str6;
                        com.tencent.mm.sdk.b.a.urY.m(fhVar);
                        bVar.hku = context.getString(R.l.dTx, new Object[]{bg.ap(fhVar.fJS.fJT, "")});
                        break;
                    case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                        bVar.hku = context.getString(R.l.dTG);
                        break;
                    case 32:
                        bVar.hku = context.getString(R.l.dTA);
                        break;
                    case m.CTRL_INDEX /*58*/:
                    case bc.CTRL_INDEX /*59*/:
                    case 60:
                        bVar.ovd = a.RF(str2).ovd;
                        bVar.hku = context.getString(R.l.dTv);
                        break;
                    default:
                        bVar.hku = context.getString(R.l.dTz);
                        break;
                }
            }
            w.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + str);
            return null;
        } else if (z) {
            bVar.username = str3;
            bVar.fFa = str4;
            if (str7 == null || str7.trim().equals("")) {
                bVar.hku = context.getString(R.l.ekZ);
            } else {
                bVar.hku = str7;
            }
        } else {
            bVar.username = str;
            bVar.hku = str2;
        }
        return bVar;
    }

    public static b a(Context context, bz bzVar) {
        w.d("MicroMsg.FMessageProvider", "build lbs, talker = " + bzVar.field_sayhiuser + ", scene = " + bzVar.field_scene);
        b bVar = new b();
        bVar.id = bzVar.uxb;
        bVar.fZK = bzVar.field_isSend == 1;
        bVar.username = bzVar.field_sayhiuser;
        bVar.prC = bzVar.field_scene;
        if (bzVar.field_isSend == 1) {
            bVar.hku = bzVar.field_content;
        } else {
            d RI = d.RI(bzVar.field_content);
            if (RI.content == null || RI.content.trim().equals("")) {
                bVar.hku = context.getString(R.l.dTI);
            } else {
                bVar.hku = RI.content;
            }
            bVar.fFa = RI.fFa;
        }
        return bVar;
    }

    public static b a(Context context, j jVar) {
        w.d("MicroMsg.FMessageProvider", "build shake, talker = " + jVar.field_talker + ", scene = " + jVar.field_scene);
        b bVar = new b();
        bVar.id = jVar.uxb;
        bVar.fZK = jVar.field_isSend == 1;
        bVar.username = jVar.field_sayhiuser;
        bVar.prC = jVar.field_scene;
        if (jVar.field_isSend == 1) {
            bVar.hku = jVar.field_content;
        } else {
            d RI = d.RI(jVar.field_content);
            if (RI.content == null || RI.content.trim().equals("")) {
                bVar.hku = context.getString(R.l.dTI);
            } else {
                bVar.hku = RI.content;
            }
            bVar.fFa = RI.fFa;
        }
        return bVar;
    }

    public static b[] a(Context context, f[] fVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (fVarArr == null || fVarArr.length == 0 || fVarArr[0] == null) ? "null" : fVarArr[0].field_talker;
        w.d(str, stringBuilder.append(str2).toString());
        if (fVarArr == null || fVarArr.length == 0) {
            w.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            return null;
        }
        b[] bVarArr = new b[fVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, fVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, bz[] bzVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (bzVarArr == null || bzVarArr.length == 0 || bzVarArr[0] == null) ? "null" : bzVarArr[0].field_sayhiuser;
        w.d(str, stringBuilder.append(str2).toString());
        if (bzVarArr == null || bzVarArr.length == 0) {
            w.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            return null;
        }
        b[] bVarArr = new b[bzVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, bzVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, j[] jVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (jVarArr == null || jVarArr.length == 0 || jVarArr[0] == null) ? "null" : jVarArr[0].field_sayhiuser;
        w.d(str, stringBuilder.append(str2).toString());
        if (jVarArr == null || jVarArr.length == 0) {
            w.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            return null;
        }
        b[] bVarArr = new b[jVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, jVarArr[i]);
        }
        return bVarArr;
    }

    public static void ay(String str, int i) {
        f[] fVarArr;
        h[] hVarArr;
        b[] a;
        j[] jVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            w.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            j[] lj = l.KA().lj(str);
            fVarArr = null;
            hVarArr = null;
            a = a(ab.getContext(), lj);
            jVarArr = lj;
        } else if (i == 18) {
            w.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
            bz[] le = l.Kz().le(str);
            fVarArr = null;
            bz[] bzVarArr = le;
            a = a(ab.getContext(), le);
            jVarArr = null;
        } else {
            f[] kZ = l.Kx().kZ(str);
            fVarArr = kZ;
            hVarArr = null;
            a = a(ab.getContext(), kZ);
            jVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                b bVar = a[i3];
                au auVar = new au();
                auVar.setContent(bVar.hku);
                int fG = o.fG(bVar.username);
                if (fVarArr != null) {
                    i4 = i2 + 1;
                    auVar.z(fVarArr[i2].field_createTime);
                } else if (hVarArr != null) {
                    i4 = i2 + 1;
                    auVar.z(hVarArr[i2].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i4 = i2 + 1;
                    auVar.z(jVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                auVar.cH(bVar.username);
                auVar.setType(fG);
                if (bVar.fZK) {
                    auVar.dv(2);
                    auVar.dw(1);
                } else {
                    auVar.dv(6);
                    auVar.dw(0);
                }
                ap.yY();
                long L = c.wT().L(auVar);
                Assert.assertTrue(L != -1);
                w.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + L);
                i3++;
                i2 = i4;
            }
            au auVar2 = new au();
            if (fVarArr != null) {
                auVar2.z(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr != null) {
                auVar2.z((hVarArr[hVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                auVar2.z((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            auVar2.cH(str);
            auVar2.setContent(ab.getContext().getString(R.l.eYy));
            auVar2.setType(10000);
            auVar2.dv(6);
            auVar2.dw(0);
            ap.yY();
            w.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + c.wT().L(auVar2));
        }
    }

    public static x b(f fVar) {
        x xVar = new x();
        if (fVar == null) {
            return xVar;
        }
        if (fVar.field_type == 0) {
            a RF = a.RF(fVar.field_msgContent);
            xVar = new x();
            xVar.setUsername(RF.rUK);
            xVar.bO(RF.gtR);
            xVar.bR(RF.getDisplayName());
            xVar.bS(RF.hCe);
            xVar.bT(RF.hCf);
            xVar.di(RF.gkr);
            xVar.cf(RF.getProvince());
            xVar.cg(RF.getCity());
            xVar.ce(RF.signature);
            xVar.de(RF.rWg);
            xVar.cj(RF.gkG);
            return xVar;
        }
        d RI = d.RI(fVar.field_msgContent);
        xVar = new x();
        xVar.setUsername(RI.rUK);
        xVar.bO(RI.gtR);
        xVar.bR(RI.fFa);
        xVar.bS(RI.hCe);
        xVar.bT(RI.hCf);
        xVar.di(RI.gkr);
        xVar.ce(RI.signature);
        xVar.cf(RI.getProvince());
        xVar.cg(RI.getCity());
        return xVar;
    }
}
