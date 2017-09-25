package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bj.d;
import com.tencent.mm.e.a.eq;
import com.tencent.mm.e.a.er;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.b.af;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static final UriMatcher lqF;
    private static boolean lre = false;
    private static aj lrf = new aj(new a() {
        public final boolean oQ() {
            ExtControlProviderSNS.lre = false;
            return false;
        }
    }, false);
    private static final String[] lrh = new String[]{"feedId", "desc", SlookSmartClipMetaTag.TAG_TYPE_URL, "nickname", "avatar", "timestamp", "mediaCount", Columns.TYPE, "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private boolean fJl = false;
    private boolean fJm = false;
    private int fJn = 0;
    private String lri = "";

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lqF = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    }

    private static void dO(boolean z) {
        if (z) {
            lre = true;
            lrf.v(15000, 15000);
            return;
        }
        lrf.v(0, 0);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.ExtControlProviderSNS", "query() " + uri);
        a(uri, getContext(), lqF);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return null;
        } else if (lre) {
            w.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            md(5);
            return null;
        } else {
            dO(true);
            if (!acK()) {
                dO(false);
                md(1);
                return this.jPp;
            } else if (!bW(getContext())) {
                w.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                dO(false);
                md(2);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                w.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                dO(false);
                md(3);
                return null;
            } else {
                String str3 = strArr2[0];
                if (bg.mA(str3)) {
                    w.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    dO(false);
                    md(3);
                    return null;
                }
                try {
                    long j;
                    Cursor bL;
                    if ("0".equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = Long.valueOf(com.tencent.mm.plugin.ext.a.a.vA(str3.trim())).longValue();
                    }
                    switch (lqF.match(uri)) {
                        case 17:
                            bL = bL(j);
                            break;
                        default:
                            bL = null;
                            break;
                    }
                    if (bL != null) {
                        md(0);
                    } else {
                        md(4);
                    }
                    dO(false);
                    return bL;
                } catch (Throwable e) {
                    w.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                    dO(false);
                    md(4);
                    return null;
                }
            }
        }
    }

    private Cursor bL(long j) {
        int i = 1;
        w.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = " + j);
        try {
            af Ra;
            w.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", Long.valueOf(j));
            if (j == 0) {
                ap.yY();
                Ra = c.wR().Ra(m.xL());
            } else {
                ap.yY();
                Ra = c.wR().ez(j);
            }
            if (Ra == null || ((int) Ra.gTQ) <= 0) {
                w.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.fJl = com.tencent.mm.j.a.ez(Ra.field_type);
                this.fJm = m.eH(Ra.field_username);
                w.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", Ra.field_username, Boolean.valueOf(this.fJl), Boolean.valueOf(this.fJm));
                final com.tencent.mm.pluginsdk.f.a.a aVar = new com.tencent.mm.pluginsdk.f.a.a();
                aVar.b(10000, new Runnable(this) {
                    final /* synthetic */ ExtControlProviderSNS lrj;

                    public final void run() {
                        b ezVar = new ez();
                        ezVar.fJk.type = 1;
                        ezVar.fJk.username = Ra.field_username;
                        ezVar.fJk.fJl = this.lrj.fJl;
                        ezVar.fJk.fJm = this.lrj.fJm;
                        ezVar.fJk.fJn = this.lrj.fJn;
                        ezVar.fJk.fJo = new bb.a(this) {
                            final /* synthetic */ AnonymousClass2 lrk;

                            {
                                this.lrk = r1;
                            }

                            public final void a(e eVar) {
                                aVar.countDown();
                            }
                        };
                        com.tencent.mm.sdk.b.a.urY.m(ezVar);
                    }
                });
            }
            if (i == 0) {
                w.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                return null;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
        }
        return ard();
    }

    private Cursor ard() {
        w.i("MicroMsg.ExtControlProviderSNS", new StringBuilder("getSnsCursor() , needDownload = true").toString());
        d dVar = new d(lrh, (byte) 0);
        b eqVar = new eq();
        eqVar.fIB.fID = this.lri;
        if (com.tencent.mm.sdk.b.a.urY.m(eqVar)) {
            Cursor cursor = eqVar.fIC.fIu;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    w.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + count);
                    if (count <= 0 || !cursor.moveToFirst()) {
                        w.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + dVar.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                b erVar = new er();
                                erVar.fIE.fIG = cursor;
                                if (com.tencent.mm.sdk.b.a.urY.m(erVar)) {
                                    ap.yY();
                                    com.tencent.mm.j.a Ra = c.wR().Ra(erVar.fIF.fIH);
                                    if (Ra != null && ((int) Ra.gTQ) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = "";
                                        String str2 = "";
                                        switch (erVar.fIF.fIL) {
                                            case 1:
                                            case 7:
                                            case 8:
                                                i = 2;
                                                break;
                                            case 2:
                                                i = 1;
                                                break;
                                            case 3:
                                                i = 6;
                                                break;
                                            case 4:
                                                i = 3;
                                                break;
                                            case 5:
                                                i = 4;
                                                break;
                                            default:
                                                i = 5;
                                                break;
                                        }
                                        if (!(erVar.fIF.fIN == null || erVar.fIF.fIN.size() <= 0 || getContext() == null)) {
                                            w.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", Integer.valueOf(erVar.fIF.fIN.size()));
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) erVar.fIF.fIN.get(0);
                                                if (!(erVar.fIF.fIO == null || erVar.fIF.fIO.size() <= 0 || getContext() == null)) {
                                                    w.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(erVar.fIF.fIO.size()), Integer.valueOf(erVar.fIF.fIP), Integer.valueOf(erVar.fIF.fIQ));
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) erVar.fIF.fIO.get(0);
                                                    }
                                                }
                                                str = com.tencent.mm.x.b.hd(erVar.fIF.fIH);
                                                objArr = new Object[11];
                                                objArr[0] = com.tencent.mm.plugin.ext.a.a.bK((long) erVar.fIF.fII);
                                                objArr[1] = erVar.fIF.fIJ;
                                                objArr[2] = obj;
                                                objArr[3] = Ra.tL();
                                                if (str == null) {
                                                    str = "";
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(erVar.fIF.fIK);
                                                objArr[6] = Integer.valueOf(erVar.fIF.fIM);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(erVar.fIF.fIP);
                                                objArr[10] = Integer.valueOf(erVar.fIF.fIQ);
                                                dVar.addRow(objArr);
                                            }
                                        }
                                        String str3 = str;
                                        w.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(erVar.fIF.fIO.size()), Integer.valueOf(erVar.fIF.fIP), Integer.valueOf(erVar.fIF.fIQ));
                                        str2 = (String) erVar.fIF.fIO.get(0);
                                        str = com.tencent.mm.x.b.hd(erVar.fIF.fIH);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = com.tencent.mm.plugin.ext.a.a.bK((long) erVar.fIF.fII);
                                            objArr[1] = erVar.fIF.fIJ;
                                            objArr[2] = obj;
                                            objArr[3] = Ra.tL();
                                            if (str == null) {
                                                str = "";
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(erVar.fIF.fIK);
                                            objArr[6] = Integer.valueOf(erVar.fIF.fIM);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(erVar.fIF.fIP);
                                            objArr[10] = Integer.valueOf(erVar.fIF.fIQ);
                                            dVar.addRow(objArr);
                                        } catch (Throwable e) {
                                            w.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            w.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    w.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        w.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + dVar.getCount());
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    w.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.close();
                    return null;
                }
            }
            return dVar;
        }
        dVar.close();
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
