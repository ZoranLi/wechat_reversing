package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bj.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.ext.b.b;
import com.tencent.mm.pluginsdk.f.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.x.n;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> jBA = new ArrayList();
    private static final String[] lrh = new String[]{"userId", "nickname", "avatar", "content", "msgId", "msgType"};
    private Cursor lrl = null;

    static {
        int i = 0;
        String[] strArr = o.hly;
        int length = strArr.length;
        while (i < length) {
            jBA.add(strArr[i]);
            i++;
        }
        jBA.add("officialaccounts");
        jBA.add("helper_entry");
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return null;
        } else if (!acK()) {
            md(1);
            return this.jPp;
        } else if (!bW(getContext())) {
            w.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            md(2);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            w.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            md(3);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (bg.mA(trim)) {
                w.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                md(3);
                return null;
            }
            final Cursor a = ap.yY().hkL.a(trim, "@micromsg.no.verify.biz.qq.com", null, jBA, false, false, false, 1, null);
            if (a == null) {
                w.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                md(3);
                return null;
            }
            final a aVar = new a();
            aVar.b(4000, new Runnable(this) {
                final /* synthetic */ ExtControlProviderSearchContact lrm;

                public final void run() {
                    this.lrm.lrl = ExtControlProviderSearchContact.d(a);
                    aVar.countDown();
                }
            });
            if (this.lrl != null) {
                md(0);
            } else {
                md(4);
            }
            return this.lrl;
        }
    }

    public static Cursor d(Cursor cursor) {
        Object dVar = new d(lrh, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    af xVar = new x();
                    xVar.b(cursor);
                    if (!o.dH(xVar.field_username)) {
                        ByteArrayOutputStream byteArrayOutputStream;
                        Bitmap b = n.Bz().b(xVar.field_username, true, 0);
                        if (b != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            w.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        ap.yY();
                        au[] bn = c.wT().bn(xVar.field_username, 1);
                        byte[] bArr;
                        if (bn == null || bn.length != 1) {
                            w.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = com.tencent.mm.plugin.ext.a.a.bK((long) ((int) xVar.gTQ));
                            objArr[1] = xVar.tL();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = bArr;
                            objArr[3] = "";
                            objArr[4] = "0";
                            objArr[5] = Integer.valueOf(0);
                            dVar.addRow(objArr);
                        } else {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = com.tencent.mm.plugin.ext.a.a.bK((long) ((int) xVar.gTQ));
                            objArr2[1] = xVar.tL();
                            if (byteArrayOutputStream == null) {
                                bArr = null;
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = bArr;
                            objArr2[3] = bn[0].field_type == 1 ? bn[0].field_content : "";
                            objArr2[4] = com.tencent.mm.plugin.ext.a.a.bK(bn[0].field_msgId);
                            objArr2[5] = Integer.valueOf(b.H(bn[0]));
                            dVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i2 >= 15) {
                        break;
                    }
                    i = i2;
                }
            }
            cursor.close();
            return dVar;
        } catch (Throwable e) {
            w.e("MicroMsg.ExtControlProviderSearchContact", e.getMessage());
            w.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            dVar.close();
            return null;
        }
    }

    public String getType(Uri uri) {
        return null;
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
}
