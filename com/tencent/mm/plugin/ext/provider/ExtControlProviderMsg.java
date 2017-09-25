package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.e.a.et;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.ew;
import com.tencent.mm.e.a.fc;
import com.tencent.mm.e.a.fd;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher lqF;
    private static final String[] lqI = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, "content", DownloadInfo.STATUS, "createTime"};
    private static final String[] lqJ = new String[]{"userId", "unReadCount"};
    private static final String[] lqK = new String[]{"userId", "unReadCount"};
    private static final String[] lqL = new String[]{"userId", "retCode", "msgId"};
    private static final String[] lqM = new String[]{"msgId", "retCode"};
    private static final String[] lqN = new String[]{"msgId", "retCode"};
    private boolean lqG;
    private Context lqH;
    private MatrixCursor lqO;
    private String[] lqq;
    private int lqr;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lqF = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
        lqF.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
        lqF.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
        lqF.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
        lqF.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
        lqF.addURI("com.tencent.mm.plugin.ext.message", JsApiStartPlayVoice.NAME, 12);
        lqF.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
        lqF.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    }

    public ExtControlProviderMsg() {
        this.lqO = null;
        this.lqG = false;
        this.lqq = null;
        this.lqr = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i, Context context) {
        this.lqO = null;
        this.lqG = false;
        this.lqq = null;
        this.lqr = -1;
        this.lqG = true;
        this.lqq = strArr;
        this.lqr = i;
        this.lqH = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.lqG);
        if (this.lqG) {
            a(uri, this.lqH, this.lqr, this.lqq);
            if (bg.mA(this.lqz)) {
                w.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                bS(3, 7);
                return ExtContentProviderBase.me(7);
            } else if (bg.mA(aqX())) {
                w.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                bS(3, 6);
                return ExtContentProviderBase.me(6);
            } else {
                int aqY = aqY();
                if (aqY != 1) {
                    w.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + aqY);
                    bS(2, aqY);
                    return ExtContentProviderBase.me(aqY);
                }
            }
        }
        this.lqH = getContext();
        a(uri, this.lqH, lqF);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return null;
        } else if (!acK()) {
            md(1);
            return this.jPp;
        } else if (!bW(this.lqH)) {
            w.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            md(2);
            return null;
        }
        String mz = bg.mz(uri.getQueryParameter("source"));
        String mz2 = bg.mz(uri.getQueryParameter("count"));
        if (!this.lqG) {
            this.lqr = lqF.match(uri);
        }
        switch (this.lqr) {
            case 7:
                return c(strArr2, mz);
            case 8:
                return m(strArr2);
            case 9:
                return a(strArr2, mz, mz2);
            case 10:
                return aqZ();
            case 11:
                return n(strArr2);
            case 12:
                return o(strArr2);
            case 13:
                return p(strArr2);
            case 14:
                return q(strArr2);
            default:
                bS(3, 15);
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor m(String[] strArr) {
        w.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            md(3);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(lqJ);
        try {
            int fM;
            if ("*".equals(strArr[0])) {
                ap.yY();
                fM = c.wW().fM("");
                matrixCursor.addRow(new Object[]{"0", Integer.valueOf(fM)});
            } else {
                for (String vA : strArr) {
                    long vA2 = a.vA(vA);
                    ap.yY();
                    af ez = c.wR().ez(vA2);
                    if (ez != null && ((int) ez.gTQ) > 0) {
                        ap.yY();
                        int fM2 = c.wW().fM(" and ( rconversation.username='" + ez.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(vA2), Integer.valueOf(fM2)});
                    }
                }
            }
            md(0);
            return matrixCursor;
        } catch (Throwable e) {
            w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            md(4);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str, String str2) {
        Throwable e;
        MatrixCursor matrixCursor;
        w.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        w.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", str, str2);
        if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            bS(3, 3701);
            return ExtContentProviderBase.me(3701);
        } else if (bg.mA(str)) {
            w.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            bS(3, 3702);
            return ExtContentProviderBase.me(3702);
        } else if (bg.mA(str2)) {
            w.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            bS(3, 3703);
            return ExtContentProviderBase.me(3703);
        } else {
            af Rc;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bd RZ = b.aqM().RZ(strArr[0]);
                    if (RZ == null || bg.mA(RZ.field_openId) || bg.mA(RZ.field_username)) {
                        w.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        bS(3, 3704);
                        return ExtContentProviderBase.me(3704);
                    }
                    ap.yY();
                    Rc = c.wR().Rc(RZ.field_username);
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = null;
                    w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    z(3, 4, 12);
                    return ExtContentProviderBase.me(12);
                }
            }
            long vA = a.vA(strArr[0]);
            ap.yY();
            Rc = c.wR().ez(vA);
            if (Rc == null || Rc.field_username == null || Rc.field_username.length() <= 0) {
                w.e("MicroMsg.ExtControlProviderMsg", "contact is null");
                bS(3, 3705);
                return ExtContentProviderBase.me(3705);
            }
            boolean z2;
            Cursor bk;
            String tL = Rc.tL();
            if (Rc.field_username.endsWith("@chatroom")) {
                tL = n.eK(Rc.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = bg.getInt(str2, 0);
                } catch (Exception e3) {
                    w.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", str2);
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    ap.yY();
                    bk = c.wT().bk(Rc.field_username, 15);
                } else {
                    ap.yY();
                    bk = c.wT().bk(Rc.field_username, i);
                }
            } else {
                ap.yY();
                bk = c.wT().bk(Rc.field_username, 3);
            }
            if (bk == null) {
                w.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                z(3, 4, 3706);
                return ExtContentProviderBase.me(3706);
            }
            matrixCursor = new MatrixCursor(lqI);
            try {
                if (bk.getCount() <= 0 || !bk.moveToFirst()) {
                    bk.close();
                    z(2, 0, 1);
                    return matrixCursor;
                }
                au auVar = new au();
                do {
                    auVar.b(bk);
                    a(matrixCursor, auVar, Rc, z2, tL, z, strArr[0]);
                } while (bk.moveToNext());
                bk.close();
                z(2, 0, 1);
                return matrixCursor;
            } catch (Exception e4) {
                e = e4;
                w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                z(3, 4, 12);
                return ExtContentProviderBase.me(12);
            }
        }
    }

    private Cursor aqZ() {
        w.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        Object matrixCursor = new MatrixCursor(lqK);
        try {
            ap.yY();
            Cursor aKf = c.wT().aKf();
            if (aKf != null) {
                if (aKf.moveToFirst()) {
                    do {
                        String string = aKf.getString(aKf.getColumnIndex("talker"));
                        ap.yY();
                        af Rc = c.wR().Rc(string);
                        if (!o.dH(string)) {
                            int i = (o.fE(Rc.field_username) || o.fC(Rc.field_username) || x.yC(Rc.field_verifyFlag) || o.fu(Rc.field_username) || o.fv(Rc.field_username)) ? 0 : 1;
                            if (i == 0) {
                                long j = (long) ((int) Rc.gTQ);
                                matrixCursor.addRow(new Object[]{a.bK(j), Integer.valueOf(aKf.getInt(aKf.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (aKf.moveToNext());
                }
                aKf.close();
            }
            md(0);
            return matrixCursor;
        } catch (Throwable e) {
            w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            md(4);
            return null;
        }
    }

    private Cursor c(String[] strArr, String str) {
        Throwable e;
        boolean z = true;
        w.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            md(3);
            return null;
        }
        MatrixCursor matrixCursor;
        try {
            long vA = a.vA(strArr[0]);
            ap.yY();
            ce cA = c.wT().cA(vA);
            ap.yY();
            af Rc = c.wR().Rc(cA.field_talker);
            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                md(3);
                return null;
            }
            boolean z2;
            String tL = Rc.tL();
            if (Rc.field_username.endsWith("@chatroom")) {
                tL = n.eK(Rc.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(lqI);
            try {
                a(matrixCursor, cA, Rc, z2, tL, z, strArr[0]);
                md(0);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                md(4);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            md(4);
            return null;
        }
    }

    private Cursor n(String[] strArr) {
        Cursor cursor = null;
        w.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            w.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            md(3);
        } else {
            try {
                final int intValue = Integer.valueOf(strArr[0]).intValue();
                final long vA = a.vA(strArr[1]);
                if (vA <= 0) {
                    md(3);
                } else {
                    final com.tencent.mm.pluginsdk.f.a.a aVar = new com.tencent.mm.pluginsdk.f.a.a();
                    final String[] strArr2 = strArr;
                    aVar.b(4000, new Runnable(this) {
                        final /* synthetic */ ExtControlProviderMsg lqR;

                        public final void run() {
                            if (intValue == 1) {
                                b.aqJ();
                                af bI = b.bI(vA);
                                if (bI == null || ((int) bI.gTQ) <= 0) {
                                    this.lqR.md(3);
                                    aVar.countDown();
                                    return;
                                }
                                com.tencent.mm.sdk.b.b ewVar = new ew();
                                ewVar.fJf.op = 1;
                                ewVar.fJf.username = bI.field_username;
                                if (com.tencent.mm.sdk.b.a.urY.m(ewVar)) {
                                    this.lqR.lqO = new MatrixCursor(ExtControlProviderMsg.lqL);
                                    if (bI == null || ((int) bI.gTQ) <= 0 || !ewVar.fJg.fFj) {
                                        this.lqR.lqO.addRow(new Object[]{strArr2[1], Integer.valueOf(2), "0"});
                                        this.lqR.md(3);
                                    } else {
                                        this.lqR.lqO.addRow(new Object[]{strArr2[1], Integer.valueOf(1), "0"});
                                        this.lqR.md(0);
                                    }
                                    w.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", Boolean.valueOf(ewVar.fJg.fFj), ewVar.fJg.fyF);
                                } else {
                                    this.lqR.md(4);
                                    aVar.countDown();
                                    return;
                                }
                            } else if (intValue == 2) {
                                com.tencent.mm.sdk.b.b ewVar2 = new ew();
                                ewVar2.fJf.op = 2;
                                if (com.tencent.mm.sdk.b.a.urY.m(ewVar2)) {
                                    String str = ewVar2.fJg.fyF;
                                    this.lqR.lqO = new MatrixCursor(ExtControlProviderMsg.lqL);
                                    com.tencent.mm.sdk.b.b fcVar = new fc();
                                    fcVar.fJC.fyF = str;
                                    if (com.tencent.mm.sdk.b.a.urY.m(fcVar)) {
                                        w.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", Long.valueOf(fcVar.fJD.fGM));
                                        if (fcVar.fJD.fGM > 0) {
                                            try {
                                                if (!ewVar2.fJg.fFj) {
                                                    this.lqR.lqO.addRow(new Object[]{strArr2[1], Integer.valueOf(4), a.bK(r2)});
                                                    this.lqR.md(4);
                                                } else if (ab.getContext() == null || !am.isConnected(ab.getContext())) {
                                                    this.lqR.lqO.addRow(new Object[]{strArr2[1], Integer.valueOf(6), a.bK(r2)});
                                                    this.lqR.md(4);
                                                } else {
                                                    this.lqR.lqO.addRow(new Object[]{strArr2[1], Integer.valueOf(1), a.bK(r2)});
                                                    this.lqR.md(0);
                                                }
                                            } catch (Throwable e) {
                                                w.w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                                                w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                                                this.lqR.md(4);
                                            }
                                        } else {
                                            this.lqR.md(3);
                                        }
                                    } else {
                                        this.lqR.md(4);
                                        this.lqR.lqO.close();
                                        aVar.countDown();
                                        return;
                                    }
                                }
                                this.lqR.md(4);
                                aVar.countDown();
                                return;
                            }
                            aVar.countDown();
                        }
                    });
                    cursor = this.lqO;
                }
            } catch (Throwable e) {
                w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (this.lqO != null) {
                    this.lqO.close();
                }
                md(4);
            }
        }
        return cursor;
    }

    private Cursor o(String[] strArr) {
        MatrixCursor matrixCursor;
        Throwable th;
        w.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            w.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            md(3);
            return null;
        }
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long vA = a.vA(strArr[1]);
            if (vA <= 0) {
                md(3);
                return null;
            } else if (intValue == 3) {
                MatrixCursor matrixCursor2 = new MatrixCursor(lqM);
                try {
                    com.tencent.mm.sdk.b.b fdVar = new fd();
                    fdVar.fJE.fGM = vA;
                    com.tencent.mm.sdk.b.a.urY.m(fdVar);
                    if (fdVar.fJF.fyF == null || fdVar.fJF.fyF.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        md(4);
                        return matrixCursor2;
                    }
                    com.tencent.mm.sdk.b.b evVar = new ev();
                    evVar.fJa.op = 1;
                    evVar.fJa.fyF = fdVar.fJF.fyF;
                    if (com.tencent.mm.sdk.b.a.urY.m(evVar)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        md(0);
                    } else {
                        w.e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        md(4);
                    }
                    b.aqJ();
                    b.bJ(vA);
                    return matrixCursor2;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    matrixCursor = matrixCursor2;
                    th = th2;
                    w.e("MicroMsg.ExtControlProviderMsg", th.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", th, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    md(4);
                    return null;
                }
            } else if (intValue != 4) {
                return null;
            } else {
                com.tencent.mm.sdk.b.b evVar2 = new ev();
                evVar2.fJa.op = 2;
                if (com.tencent.mm.sdk.b.a.urY.m(evVar2)) {
                    w.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                    md(0);
                    return null;
                }
                w.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                md(4);
                return null;
            }
        } catch (Exception e2) {
            th = e2;
            matrixCursor = null;
            w.e("MicroMsg.ExtControlProviderMsg", th.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", th, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            md(4);
            return null;
        }
    }

    private Cursor p(String[] strArr) {
        w.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            bS(3, 3801);
            return ExtContentProviderBase.me(3801);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    w.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
                } else {
                    long vA = a.vA(strArr[i]);
                    b.aqJ();
                    b.bJ(vA);
                }
                i++;
            } catch (Throwable e) {
                w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                bS(4, 12);
                return ExtContentProviderBase.me(12);
            }
        }
        bS(0, 1);
        return ExtContentProviderBase.me(1);
    }

    private Cursor q(final String[] strArr) {
        w.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            md(3);
            return null;
        }
        try {
            long vA = a.vA(strArr[0]);
            if (vA <= 0) {
                md(3);
                return null;
            }
            b.aqJ();
            final com.tencent.mm.j.a bI = b.bI(vA);
            if (bI == null || ((int) bI.gTQ) <= 0) {
                w.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                md(3);
                return null;
            }
            this.lqO = new MatrixCursor(lqN);
            final com.tencent.mm.pluginsdk.f.a.a aVar = new com.tencent.mm.pluginsdk.f.a.a();
            aVar.b(15000, new Runnable(this) {
                final /* synthetic */ ExtControlProviderMsg lqR;

                public final void run() {
                    com.tencent.mm.sdk.b.b etVar = new et();
                    etVar.fIV.toUserName = bI.field_username;
                    etVar.fIV.content = strArr[1];
                    etVar.fIV.type = o.fG(bI.field_username);
                    etVar.fIV.flags = 0;
                    if (com.tencent.mm.sdk.b.a.urY.m(etVar)) {
                        k kVar = etVar.fIW.fIX;
                        try {
                            final String bK = a.bK(etVar.fIW.fGM);
                            ap.vd().a(522, new e(this) {
                                final /* synthetic */ AnonymousClass2 lqU;

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.y.k r13) {
                                    /*
                                    r9 = this;
                                    r8 = 522; // 0x20a float:7.31E-43 double:2.58E-321;
                                    r7 = 4;
                                    r6 = 2;
                                    r5 = 1;
                                    r4 = 0;
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "onSceneEnd errType=%s, errCode=%s";
                                    r2 = new java.lang.Object[r6];
                                    r3 = java.lang.Integer.valueOf(r10);
                                    r2[r4] = r3;
                                    r3 = java.lang.Integer.valueOf(r11);
                                    r2[r5] = r3;
                                    com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);
                                    if (r13 != 0) goto L_0x003e;
                                L_0x001f:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "scene == null";
                                    com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                                    r0 = com.tencent.mm.u.ap.vd();
                                    r0.b(r8, r9);
                                    r0 = r9.lqU;
                                    r0 = r0.lqR;
                                    r0.md(r7);
                                    r0 = r9.lqU;
                                    r0 = r2;
                                    r0.countDown();
                                L_0x003d:
                                    return;
                                L_0x003e:
                                    r0 = r13.getType();
                                    switch(r0) {
                                        case 522: goto L_0x005b;
                                        default: goto L_0x0045;
                                    };
                                L_0x0045:
                                    r0 = r9.lqU;
                                    r0 = r0.lqR;
                                    r0.md(r4);
                                L_0x004c:
                                    r0 = r9.lqU;
                                    r0 = r2;
                                    r0.countDown();
                                    r0 = com.tencent.mm.u.ap.vd();
                                    r0.b(r8, r9);
                                    goto L_0x003d;
                                L_0x005b:
                                    if (r10 != 0) goto L_0x0080;
                                L_0x005d:
                                    if (r11 != 0) goto L_0x0080;
                                L_0x005f:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "rtSENDMSG onSceneEnd ok, ";
                                    com.tencent.mm.sdk.platformtools.w.d(r0, r1);
                                    r0 = r9.lqU;
                                    r0 = r0.lqR;
                                    r0 = r0.lqO;
                                    r1 = new java.lang.Object[r6];
                                    r2 = r0;
                                    r1[r4] = r2;
                                    r2 = java.lang.Integer.valueOf(r5);
                                    r1[r5] = r2;
                                    r0.addRow(r1);
                                    goto L_0x0045;
                                L_0x0080:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = new java.lang.StringBuilder;
                                    r2 = "rtSENDMSG onSceneEnd err, errType = ";
                                    r1.<init>(r2);
                                    r1 = r1.append(r10);
                                    r2 = ", errCode = ";
                                    r1 = r1.append(r2);
                                    r1 = r1.append(r11);
                                    r1 = r1.toString();
                                    com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                                    r0 = r9.lqU;
                                    r0 = r0.lqR;
                                    r0 = r0.lqO;
                                    r1 = new java.lang.Object[r6];
                                    r2 = r0;
                                    r1[r4] = r2;
                                    r2 = java.lang.Integer.valueOf(r6);
                                    r1[r5] = r2;
                                    r0.addRow(r1);
                                    r0 = r9.lqU;
                                    r0 = r0.lqR;
                                    r0.md(r7);
                                    goto L_0x004c;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2.1.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
                                }
                            });
                            ap.vd().a(kVar, 0);
                            return;
                        } catch (Throwable e) {
                            w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                            this.lqR.md(4);
                            aVar.countDown();
                            return;
                        }
                    }
                    this.lqR.md(4);
                    aVar.countDown();
                }
            });
            return this.lqO;
        } catch (Throwable e) {
            w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.lqO != null) {
                this.lqO.close();
            }
            md(4);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, au auVar, x xVar, boolean z, String str, boolean z2, String str2) {
        if (auVar != null) {
            if (bg.mA(str2)) {
                w.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            } else if (auVar.field_type != 9999 && auVar.field_type != 10000) {
                String str3 = "";
                String str4 = "";
                if (z) {
                    int gh = ay.gh(auVar.field_content);
                    if (gh != -1 && auVar.field_content.length() > gh) {
                        String trim = auVar.field_content.substring(0, gh).trim();
                        if (trim != null && trim.length() > 0 && auVar.field_content.length() >= gh + 2) {
                            str3 = n.eK(trim);
                            str4 = auVar.field_content.substring(gh + 2);
                        }
                    }
                }
                String str5 = "";
                int H = com.tencent.mm.plugin.ext.b.b.H(auVar);
                if (H == 1) {
                    if (z) {
                        str3 = str3 + "!]" + str4;
                    } else {
                        str3 = auVar.field_content;
                    }
                } else if (H == 2) {
                    p gR = m.Ly().gR((int) auVar.field_msgId);
                    if (gR == null || gR.fyF == null) {
                        str4 = str5;
                    } else {
                        str4 = q.js(gR.fyF);
                        w.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", str4);
                    }
                    str3 = str4;
                } else if (!z) {
                    if (this.lqH != null) {
                        str3 = this.lqH.getString(R.l.egR);
                    } else {
                        str3 = "";
                    }
                }
                if (!z2) {
                    str2 = a.bK((long) ((int) xVar.gTQ));
                }
                try {
                    if (bg.mA(str2)) {
                        w.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                        return;
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = a.bK(auVar.field_msgId);
                    objArr[1] = str2;
                    objArr[2] = str;
                    objArr[3] = Integer.valueOf(auVar.field_isSend == 0 ? 1 : 2);
                    objArr[4] = Integer.valueOf(H);
                    objArr[5] = str3;
                    objArr[6] = Integer.valueOf(auVar.field_status == 4 ? 1 : 2);
                    objArr[7] = Long.valueOf(auVar.field_createTime);
                    matrixCursor.addRow(objArr);
                } catch (Throwable e) {
                    w.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                }
            }
        }
    }
}
