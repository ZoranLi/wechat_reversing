package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public g hnH;

    public b(g gVar) {
        this.hnH = gVar;
    }

    public static Bitmap b(String str, float f) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        Bitmap c = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(stringBuilder.append(c.xb()).append(trim).toString(), f);
        if (c != null) {
            return Bitmap.createScaledBitmap(c, (int) (((float) c.getWidth()) * f), (int) (((float) c.getHeight()) * f), true);
        }
        return c;
    }

    public static Bitmap zS(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return com.tencent.mm.platformtools.j.mt(stringBuilder.append(c.xb()).append(trim).toString());
    }

    public static a h(String str, String str2, int i, int i2) {
        if (!e.aO(str)) {
            return null;
        }
        ap.yY();
        String xb = c.xb();
        int Pc = ExifHelper.Pc(str);
        String n = com.tencent.mm.a.g.n((str + System.currentTimeMillis()).getBytes());
        w.d("MicroMsg.MasSendInfoStorage", "insert : original img path = " + str);
        Options Pe = d.Pe(str);
        if (i2 != 0 || (e.aN(str) <= 204800 && (Pe == null || (Pe.outHeight <= 960 && Pe.outWidth <= 960)))) {
            e.a(xb, n, ".jpg", e.c(str, 0, e.aN(str)));
        } else {
            if (!d.a(str, 960, 960, CompressFormat.JPEG, 70, xb, n)) {
                return null;
            }
            e.h(xb, n, n + ".jpg");
        }
        String str3 = n + ".jpg";
        w.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = " + str3);
        if (i2 == 0 && Pc != 0 && !d.a(xb + str3, Pc, CompressFormat.JPEG, xb, n + ".jpg")) {
            return null;
        }
        n = com.tencent.mm.a.g.n((str3 + System.currentTimeMillis()).getBytes());
        if (!d.a(xb + str3, 120, 120, CompressFormat.JPEG, 90, xb, n)) {
            return null;
        }
        w.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = " + n);
        a aVar = new a();
        aVar.msgType = 3;
        aVar.nwQ = str2;
        aVar.nwR = i;
        aVar.nwP = n;
        aVar.filename = str3;
        return aVar;
    }

    public static String a(a aVar) {
        switch (aVar.msgType) {
            case 1:
                return aVar.aJm();
            case 3:
                return ab.getContext().getResources().getString(R.l.dIi);
            case 34:
                return ab.getContext().getResources().getString(R.l.dIY);
            case 43:
                return ab.getContext().getResources().getString(R.l.dIX);
            default:
                return ab.getContext().getResources().getString(R.l.dYJ);
        }
    }

    public final a zT(String str) {
        a aVar = null;
        Cursor a = this.hnH.a("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bg.my(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            }
            a.close();
        }
        return aVar;
    }
}
