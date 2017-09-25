package com.tencent.mm.ah;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.u;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class f extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0)", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    public static int hFE = 0;
    public static long hFR = 0;
    public com.tencent.mm.a.f<String, Bitmap> hFF = new com.tencent.mm.a.f(40, new com.tencent.mm.a.f.b<String, Bitmap>(this) {
        final /* synthetic */ f hFS;

        {
            this.hFS = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            String str = (String) obj;
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled()) {
                w.i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s bitmap:%s", str, bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    com.tencent.mm.a.f<String, String> hFG = new com.tencent.mm.a.f(40, new com.tencent.mm.a.f.b<String, String>(this) {
        final /* synthetic */ f hFS;

        {
            this.hFS = r1;
        }

        public final /* bridge */ /* synthetic */ void l(Object obj, Object obj2) {
        }
    });
    List<b> hFH = new ArrayList();
    Map<Integer, WeakReference<ImageView>> hFI = new HashMap();
    Map<Integer, WeakReference<ImageView>> hFJ = new HashMap();
    Map<Integer, WeakReference<View>> hFK = new HashMap();
    Set<Integer> hFL = new HashSet();
    private Map<String, String> hFM = new HashMap();
    private long hFN = 1;
    LayoutParams hFO = new LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> hFP;
    public int hFQ = ck.CTRL_INDEX;
    public ae hgN = new ae(Looper.getMainLooper());
    public g hnH = null;

    public static class a extends BitmapDrawable {
        public static void a(Bitmap bitmap, ImageView imageView) {
            if (imageView != null && imageView.getResources() != null) {
                Drawable aVar = new a(imageView.getResources(), bitmap);
                if (imageView.getLayerType() == 1) {
                    imageView.destroyDrawingCache();
                    imageView.setLayerType(0, null);
                }
                imageView.setImageDrawable(aVar);
            }
        }

        private a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public final void draw(Canvas canvas) {
            if (getBitmap() != null && !getBitmap().isRecycled()) {
                super.draw(canvas);
            } else if (getBitmap() != null) {
                w.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", getBitmap().toString());
            }
        }
    }

    static class b {
        int hFY;
        int hFZ;
        int hGa;
        String url;

        b(int i, String str, int i2, int i3) {
            this.hFY = i;
            this.url = str;
            this.hFZ = i2;
            this.hGa = i3;
        }
    }

    public f(g gVar) {
        a(gVar);
        this.hnH = gVar;
        GD();
    }

    public final void GD() {
        Cursor a = this.hnH.a("SELECT max(id) FROM ImgInfo2", null, 2);
        if (a.moveToFirst()) {
            this.hFN = a.getLong(0) + 1;
        }
        a.close();
        w.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.hFN);
    }

    private static void a(g gVar) {
        Object obj = null;
        Cursor a = gVar.a("PRAGMA table_info(ImgInfo2)", null, 2);
        int columnIndex = a.getColumnIndex("name");
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("hashdthumb".equals(string)) {
                    obj6 = 1;
                }
                if ("iscomplete".equals(string)) {
                    obj5 = 1;
                }
                if ("origImgMD5".equals(string)) {
                    obj4 = 1;
                }
                if ("compressType".equals(string)) {
                    obj3 = 1;
                }
                if ("midImgPath".equals(string)) {
                    obj2 = 1;
                }
                if ("forwardType".equals(string)) {
                    obj = 1;
                }
            }
        }
        a.close();
        long cs = h.vI().gYg.cs(Thread.currentThread().getId());
        if (obj6 == null) {
            gVar.eE("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
        }
        if (obj5 == null) {
            gVar.eE("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
        }
        if (obj4 == null) {
            gVar.eE("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
        }
        if (obj3 == null) {
            gVar.eE("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
        }
        if (obj2 == null) {
            gVar.eE("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
        }
        if (obj == null) {
            gVar.eE("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
        }
        if (cs > 0) {
            h.vI().gYg.aD(cs);
        }
    }

    public final String a(String str, String str2, String str3, boolean z) {
        if (bg.mA(str)) {
            return null;
        }
        String str4;
        String str5;
        String str6 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = ai(Long.valueOf(str.substring(11)).longValue()).hEZ;
            } catch (NumberFormatException e) {
                w.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        str4 = str6;
        if (str.startsWith("THUMBNAIL_DIRPATH://")) {
            str = str.substring(23);
            str5 = "th_";
        } else {
            str5 = str2;
        }
        str6 = com.tencent.mm.plugin.n.b.xb();
        String xc = com.tencent.mm.plugin.n.b.xc();
        if (bg.mA(str4)) {
            str4 = str;
        }
        return com.tencent.mm.sdk.platformtools.h.a(str6, xc, str5, str4, str3, 1, z);
    }

    public final String m(String str, String str2, String str3) {
        return a(str, str2, str3, true);
    }

    public final String js(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String str2 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = ai(Long.valueOf(str.substring(11)).longValue()).hEZ;
            } catch (NumberFormatException e) {
                w.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        String xb = com.tencent.mm.plugin.n.b.xb();
        String xc = com.tencent.mm.plugin.n.b.xc();
        String str3 = "th_";
        if (!bg.mA(str2)) {
            str = str2;
        }
        return com.tencent.mm.sdk.platformtools.h.f(xb, xc, str3, str, "");
    }

    public static String jt(String str) {
        return "THUMBNAIL_DIRPATH://th_" + str;
    }

    public final String ju(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = "";
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = fT(Integer.valueOf(trim.substring(12)).intValue()).hFb;
            } catch (NumberFormatException e) {
                w.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        return m(trim, str2, "");
    }

    public final String a(byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(8, bArr, z, compressFormat);
    }

    public final String a(byte[] bArr, CompressFormat compressFormat) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String n = com.tencent.mm.a.g.n((bg.Nz()).getBytes());
        w.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", m(n, "th_", ""));
        try {
            d.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, m(n, "th_", ""), true);
            return "THUMBNAIL_DIRPATH://th_" + n;
        } catch (IOException e) {
            w.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e);
            return a(9, bArr, true, compressFormat);
        } catch (Exception e2) {
            w.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", e2);
            return a(9, bArr, true, compressFormat);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(byte[] r11, android.graphics.Bitmap.CompressFormat r12, int r13, int r14) {
        /*
        r10 = this;
        r6 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.bm(r11);
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = "MicroMsg.ImgInfoStorage";
        r1 = "save dir thumb error, thumbBuf is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r6;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r0 = r0.getBytes();
        r8 = com.tencent.mm.a.g.n(r0);
        r0 = "th_";
        r1 = "";
        r9 = r10.m(r8, r0, r1);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r9);
        r1 = ".tmp";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = "MicroMsg.ImgInfoStorage";
        r2 = new java.lang.StringBuilder;
        r3 = "saveDirThumb, fullPath = ";
        r2.<init>(r3);
        r2 = r2.append(r9);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r7 = com.tencent.mm.modelsfs.FileOp.gQ(r0);	 Catch:{ IOException -> 0x01be, Exception -> 0x01bb, all -> 0x0190 }
        r7.write(r11);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r7.flush();	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r4 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r4.<init>();	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r3 = 0;
        r5 = 0;
        r1 = r14;
        r2 = r13;
        r3 = com.tencent.mm.sdk.platformtools.d.a(r0, r1, r2, r3, r4, r5);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        if (r3 == 0) goto L_0x0138;
    L_0x0078:
        r2 = 100;
        r1 = r11.length;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r4 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r1 <= r4) goto L_0x00b1;
    L_0x007f:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x01c6 }
        r1.<init>();	 Catch:{ Exception -> 0x01c6 }
        r4 = 100;
        r3.compress(r12, r4, r1);	 Catch:{ Exception -> 0x009f, all -> 0x01c1 }
    L_0x0089:
        r4 = r1.toByteArray();	 Catch:{ Exception -> 0x009f, all -> 0x01c1 }
        r4 = r4.length;	 Catch:{ Exception -> 0x009f, all -> 0x01c1 }
        r5 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r4 <= r5) goto L_0x00f7;
    L_0x0092:
        r4 = 15;
        if (r2 < r4) goto L_0x00f7;
    L_0x0096:
        r1.reset();	 Catch:{ Exception -> 0x009f, all -> 0x01c1 }
        r2 = r2 + -5;
        r3.compress(r12, r2, r1);	 Catch:{ Exception -> 0x009f, all -> 0x01c1 }
        goto L_0x0089;
    L_0x009f:
        r4 = move-exception;
        r6 = r1;
        r1 = r2;
    L_0x00a2:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = "compress bitmap failed.";
        com.tencent.mm.sdk.platformtools.w.e(r2, r4);	 Catch:{ all -> 0x0100 }
        if (r6 == 0) goto L_0x01ca;
    L_0x00ad:
        r6.close();	 Catch:{ Exception -> 0x00fd, IOException -> 0x0107 }
        r2 = r1;
    L_0x00b1:
        r1 = 1;
        com.tencent.mm.sdk.platformtools.d.a(r3, r2, r12, r9, r1);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r1 = "MicroMsg.ImgInfoStorage";
        r3 = "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r5 = 0;
        r4[r5] = r0;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r5 = 1;
        r4[r5] = r9;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r5 = 2;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r4[r5] = r2;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        com.tencent.mm.sdk.platformtools.w.d(r1, r3, r4);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
    L_0x00ce:
        r1 = com.tencent.mm.modelsfs.FileOp.aO(r0);
        if (r1 == 0) goto L_0x00e0;
    L_0x00d4:
        r1 = "MicroMsg.ImgInfoStorage";
        r2 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x00e0:
        if (r7 == 0) goto L_0x00e5;
    L_0x00e2:
        r7.close();	 Catch:{ Exception -> 0x01ad }
    L_0x00e5:
        r0 = new java.lang.StringBuilder;
        r1 = "THUMBNAIL_DIRPATH://th_";
        r0.<init>(r1);
        r0 = r0.append(r8);
        r0 = r0.toString();
        goto L_0x0011;
    L_0x00f7:
        r1.close();	 Catch:{ Exception -> 0x00fb, IOException -> 0x0107 }
        goto L_0x00b1;
    L_0x00fb:
        r1 = move-exception;
        goto L_0x00b1;
    L_0x00fd:
        r2 = move-exception;
        r2 = r1;
        goto L_0x00b1;
    L_0x0100:
        r1 = move-exception;
    L_0x0101:
        if (r6 == 0) goto L_0x0106;
    L_0x0103:
        r6.close();	 Catch:{ Exception -> 0x01aa, IOException -> 0x0107 }
    L_0x0106:
        throw r1;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
    L_0x0107:
        r1 = move-exception;
        r6 = r7;
    L_0x0109:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "save bitmap to image error, %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01b8 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x01b8 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x01b8 }
        r1 = 6;
        r2 = 1;
        r1 = r10.a(r1, r11, r2, r12);	 Catch:{ all -> 0x01b8 }
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r0);
        if (r2 == 0) goto L_0x0130;
    L_0x0124:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x0130:
        if (r6 == 0) goto L_0x0135;
    L_0x0132:
        r6.close();	 Catch:{ Exception -> 0x01b0 }
    L_0x0135:
        r0 = r1;
        goto L_0x0011;
    L_0x0138:
        r1 = r4.getDecodeResult();	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r1 < r2) goto L_0x00ce;
    L_0x0140:
        r1 = "MicroMsg.ImgInfoStorage";
        r2 = "hit image hole while extractThumbNail: %s, %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r5 = 0;
        r3[r5] = r0;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r5 = 1;
        r3[r5] = r9;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        com.tencent.mm.sdk.platformtools.w.w(r1, r2, r3);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r1 = 6;
        r1 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r0, r1, r4);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r2 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        r3 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r2.A(r3, r1);	 Catch:{ IOException -> 0x0107, Exception -> 0x0160 }
        goto L_0x00ce;
    L_0x0160:
        r1 = move-exception;
    L_0x0161:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "save bitmap to image error, %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01b6 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ all -> 0x01b6 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x01b6 }
        r1 = 6;
        r2 = 1;
        r1 = r10.a(r1, r11, r2, r12);	 Catch:{ all -> 0x01b6 }
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r0);
        if (r2 == 0) goto L_0x0188;
    L_0x017c:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x0188:
        if (r7 == 0) goto L_0x018d;
    L_0x018a:
        r7.close();	 Catch:{ Exception -> 0x01b2 }
    L_0x018d:
        r0 = r1;
        goto L_0x0011;
    L_0x0190:
        r1 = move-exception;
        r7 = r6;
    L_0x0192:
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r0);
        if (r2 == 0) goto L_0x01a4;
    L_0x0198:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "create thumbnail, delete tmp file";
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x01a4:
        if (r7 == 0) goto L_0x01a9;
    L_0x01a6:
        r7.close();	 Catch:{ Exception -> 0x01b4 }
    L_0x01a9:
        throw r1;
    L_0x01aa:
        r2 = move-exception;
        goto L_0x0106;
    L_0x01ad:
        r0 = move-exception;
        goto L_0x00e5;
    L_0x01b0:
        r0 = move-exception;
        goto L_0x0135;
    L_0x01b2:
        r0 = move-exception;
        goto L_0x018d;
    L_0x01b4:
        r0 = move-exception;
        goto L_0x01a9;
    L_0x01b6:
        r1 = move-exception;
        goto L_0x0192;
    L_0x01b8:
        r1 = move-exception;
        r7 = r6;
        goto L_0x0192;
    L_0x01bb:
        r1 = move-exception;
        r7 = r6;
        goto L_0x0161;
    L_0x01be:
        r1 = move-exception;
        goto L_0x0109;
    L_0x01c1:
        r2 = move-exception;
        r6 = r1;
        r1 = r2;
        goto L_0x0101;
    L_0x01c6:
        r1 = move-exception;
        r1 = r2;
        goto L_0x00a2;
    L_0x01ca:
        r2 = r1;
        goto L_0x00b1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ah.f.a(byte[], android.graphics.Bitmap$CompressFormat, int, int):java.lang.String");
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(i, bArr, z, compressFormat, false);
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat, boolean z2) {
        OutputStream gQ;
        Exception exception;
        OutputStream outputStream;
        Throwable th;
        if (bg.bm(bArr)) {
            w.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String n = com.tencent.mm.a.g.n((bg.Nz()).getBytes());
        String m = m(n, "th_", "");
        String str = m + ".tmp";
        w.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + m);
        try {
            gQ = FileOp.gQ(str);
            try {
                Bitmap decodeFile;
                gQ.write(bArr);
                gQ.flush();
                int i2 = z ? FileUtils.S_IWUSR : 120;
                int i3 = z ? FileUtils.S_IWUSR : 120;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                if (z2) {
                    decodeFile = d.decodeFile(str, null);
                } else {
                    decodeFile = d.a(str, i2, i3, false, decodeResultLogger, 0);
                }
                if (decodeFile != null) {
                    d.a(decodeFile, 90, compressFormat, m, true);
                    w.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", str, m);
                } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    w.w("MicroMsg.ImgInfoStorage", "hit image hole while extractThumbNail: %s, %s", str, m);
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str, i, decodeResultLogger));
                }
                if (FileOp.aO(str)) {
                    w.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (gQ != null) {
                    try {
                        gQ.close();
                    } catch (Exception e) {
                    }
                }
                return "THUMBNAIL_DIRPATH://th_" + n;
            } catch (Exception e2) {
                exception = e2;
                outputStream = gQ;
                try {
                    com.tencent.mm.plugin.report.service.g.oUh.a(111, 189, 1, false);
                    w.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + n + ", ex = " + exception.getMessage());
                    if (FileOp.aO(str)) {
                        w.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    gQ = outputStream;
                    if (FileOp.aO(str)) {
                        w.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (gQ != null) {
                        try {
                            gQ.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (FileOp.aO(str)) {
                    w.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (gQ != null) {
                    gQ.close();
                }
                throw th;
            }
        } catch (Exception e22) {
            exception = e22;
            outputStream = null;
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 189, 1, false);
            w.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + n + ", ex = " + exception.getMessage());
            if (FileOp.aO(str)) {
                w.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            gQ = null;
            if (FileOp.aO(str)) {
                w.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (gQ != null) {
                gQ.close();
            }
            throw th;
        }
    }

    public final String f(int i, byte[] bArr) {
        if (bg.bm(bArr)) {
            w.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger)) {
            String n = com.tencent.mm.a.g.n((bg.Nz()).getBytes());
            String m = m(n, "th_", "");
            w.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + m);
            FileOp.deleteFile(m);
            FileOp.k(m, bArr);
            return "THUMBNAIL_DIRPATH://th_" + n;
        } else if (decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            return null;
        } else {
            w.e("MicroMsg.ImgInfoStorage", "img in thumbBuf hits hole.");
            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(bArr, i, decodeResultLogger));
            return null;
        }
    }

    public final String v(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = fT(Integer.valueOf(trim.substring(12)).intValue()).hFb;
            } catch (NumberFormatException e) {
                w.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            return a(trim.substring(20).substring(3), "th_", "", z);
        }
        return a(trim, "", "", z);
    }

    public final Bitmap a(String str, float f, boolean z) {
        return a(str, false, f, z, false, false, -1);
    }

    public final boolean a(ImageView imageView, String str, float f, int i, int i2, int i3, ImageView imageView2, int i4, int i5, View view) {
        return a(imageView, str, false, f, i, i2, true, i3, imageView2, i4, i5, true, view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.widget.ImageView r13, java.lang.String r14, boolean r15, float r16, int r17, int r18, boolean r19, int r20, android.widget.ImageView r21, int r22, int r23, boolean r24, android.view.View r25) {
        /*
        r12 = this;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r14);
        if (r2 == 0) goto L_0x0017;
    L_0x0006:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "invalid uri is %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r14;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        r2 = 0;
    L_0x0016:
        return r2;
    L_0x0017:
        r3 = r12.hFM;
        monitor-enter(r3);
        r2 = r12.hFM;	 Catch:{ all -> 0x0041 }
        r2 = r2.containsKey(r14);	 Catch:{ all -> 0x0041 }
        r4 = 0;
        r6 = r12.b(r14, r15, r4);	 Catch:{ all -> 0x0041 }
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r6);	 Catch:{ all -> 0x0041 }
        if (r4 == 0) goto L_0x0044;
    L_0x002b:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = "getFullThumbPathByCache uri is null, uri:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0041 }
        r6 = 0;
        r7 = com.tencent.mm.sdk.platformtools.bg.mz(r14);	 Catch:{ all -> 0x0041 }
        r5[r6] = r7;	 Catch:{ all -> 0x0041 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r4, r5);	 Catch:{ all -> 0x0041 }
        r2 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0016;
    L_0x0041:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        throw r2;
    L_0x0044:
        if (r2 != 0) goto L_0x0096;
    L_0x0046:
        r2 = "hd";
        r2 = r6.endsWith(r2);	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x0096;
    L_0x004f:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0041 }
        r4 = "hd";
        r2 = r2.append(r4);	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r2);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x0096;
    L_0x0069:
        r2 = r12.hFM;	 Catch:{ all -> 0x0041 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x0041 }
        r5 = "hd";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0041 }
        r4 = r4.toString();	 Catch:{ all -> 0x0041 }
        r2.put(r14, r4);	 Catch:{ all -> 0x0041 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x0041 }
        r4 = "hd";
        r2 = r2.append(r4);	 Catch:{ all -> 0x0041 }
        r6 = r2.toString();	 Catch:{ all -> 0x0041 }
    L_0x0096:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        r10 = 0;
        r3 = 0;
        r2 = "hd";
        r2 = r6.endsWith(r2);
        if (r2 == 0) goto L_0x02fc;
    L_0x00a2:
        r2 = r12.hFF;
        r2 = r2.get(r6);
        r10 = r2;
        r10 = (android.graphics.Bitmap) r10;
        if (r10 != 0) goto L_0x017a;
    L_0x00ad:
        r8 = 1;
        r2 = r12;
        r3 = r13;
        r4 = r21;
        r5 = r25;
        r7 = r16;
        r9 = r20;
        r2.a(r3, r4, r5, r6, r7, r8, r9);
        r2 = 1;
        r3 = 0;
        r4 = r6.length();
        r4 = r4 + -2;
        r6 = r6.substring(r3, r4);
        r5 = r2;
        r2 = r10;
    L_0x00c9:
        if (r2 != 0) goto L_0x02f9;
    L_0x00cb:
        r2 = r12.hFF;
        r2 = r2.get(r6);
        r2 = (android.graphics.Bitmap) r2;
        r4 = r2;
    L_0x00d4:
        if (r4 == 0) goto L_0x01d1;
    L_0x00d6:
        r2 = r4.isRecycled();
        if (r2 != 0) goto L_0x01d1;
    L_0x00dc:
        r2 = "MicroMsg.ImgInfoStorage";
        r3 = "[setbitmapFromUri] bitmap width %d,height %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r4.getWidth();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r4.getHeight();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r5);
        r2 = 0;
        r13.setBackgroundDrawable(r2);
        com.tencent.mm.ah.f.a.a(r4, r13);
        r2 = r13.getLayoutParams();
        r2 = r2.width;
        r3 = -2;
        if (r2 == r3) goto L_0x01a7;
    L_0x010e:
        r2 = r12.hFO;
    L_0x0110:
        if (r23 != 0) goto L_0x01af;
    L_0x0112:
        r3 = 5;
        r2.gravity = r3;
    L_0x0115:
        r13.setLayoutParams(r2);
        r2 = r4.getWidth();
        r2 = (double) r2;
        r5 = r4.getHeight();
        r6 = (double) r5;
        r8 = 4612811918334230528; // 0x4004000000000000 float:0.0 double:2.5;
        r6 = r6 * r8;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 < 0) goto L_0x01b9;
    L_0x0129:
        r2 = 1;
    L_0x012a:
        r3 = r4.getHeight();
        r6 = (double) r3;
        r3 = r4.getWidth();
        r8 = (double) r3;
        r10 = 4612811918334230528; // 0x4004000000000000 float:0.0 double:2.5;
        r8 = r8 * r10;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 < 0) goto L_0x01bc;
    L_0x013b:
        r3 = 1;
    L_0x013c:
        if (r2 != 0) goto L_0x0140;
    L_0x013e:
        if (r3 == 0) goto L_0x0145;
    L_0x0140:
        r2 = android.widget.ImageView.ScaleType.CENTER;
        r13.setScaleType(r2);
    L_0x0145:
        if (r21 == 0) goto L_0x015e;
    L_0x0147:
        r2 = new android.widget.FrameLayout$LayoutParams;
        r3 = r4.getWidth();
        r5 = r4.getHeight();
        r2.<init>(r3, r5);
        if (r23 != 0) goto L_0x01bf;
    L_0x0156:
        r3 = 5;
        r2.gravity = r3;
    L_0x0159:
        r0 = r21;
        r0.setLayoutParams(r2);
    L_0x015e:
        if (r25 == 0) goto L_0x0177;
    L_0x0160:
        r2 = new android.widget.FrameLayout$LayoutParams;
        r3 = r4.getWidth();
        r4 = r4.getHeight();
        r2.<init>(r3, r4);
        if (r23 != 0) goto L_0x01c8;
    L_0x016f:
        r3 = 5;
        r2.gravity = r3;
    L_0x0172:
        r0 = r25;
        r0.setLayoutParams(r2);
    L_0x0177:
        r2 = 1;
        goto L_0x0016;
    L_0x017a:
        r2 = r12.hFF;
        r4 = 0;
        r5 = r6.length();
        r5 = r5 + -2;
        r4 = r6.substring(r4, r5);
        r2 = r2.remove(r4);
        if (r2 == 0) goto L_0x01a3;
    L_0x018d:
        r2 = "MicroMsg.ImgInfoStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "remove low quality thumb from cacheMap, path: ";
        r4.<init>(r5);
        r4 = r4.append(r6);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.d(r2, r4);
    L_0x01a3:
        r5 = r3;
        r2 = r10;
        goto L_0x00c9;
    L_0x01a7:
        r2 = r13.getLayoutParams();
        r2 = (android.widget.FrameLayout.LayoutParams) r2;
        goto L_0x0110;
    L_0x01af:
        r3 = 1;
        r0 = r23;
        if (r0 != r3) goto L_0x0115;
    L_0x01b4:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0115;
    L_0x01b9:
        r2 = 0;
        goto L_0x012a;
    L_0x01bc:
        r3 = 0;
        goto L_0x013c;
    L_0x01bf:
        r3 = 1;
        r0 = r23;
        if (r0 != r3) goto L_0x0159;
    L_0x01c4:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0159;
    L_0x01c8:
        r3 = 1;
        r0 = r23;
        if (r0 != r3) goto L_0x0172;
    L_0x01cd:
        r3 = 3;
        r2.gravity = r3;
        goto L_0x0172;
    L_0x01d1:
        if (r22 <= 0) goto L_0x02aa;
    L_0x01d3:
        r0 = r22;
        r13.setBackgroundResource(r0);
        r2 = 0;
        r13.setImageDrawable(r2);
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = r17;
        if (r0 >= r2) goto L_0x01e8;
    L_0x01e2:
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = r18;
        if (r0 < r2) goto L_0x0283;
    L_0x01e8:
        r0 = r18;
        r1 = r17;
        if (r0 <= r1) goto L_0x0275;
    L_0x01ee:
        r2 = 1126170624; // 0x43200000 float:160.0 double:5.564022167E-315;
        r0 = r18;
        r3 = (float) r0;
        r2 = r2 / r3;
    L_0x01f4:
        r0 = r17;
        r3 = (float) r0;
        r3 = r3 * r2;
        r3 = (int) r3;
        r0 = r18;
        r4 = (float) r0;
        r2 = r2 * r4;
        r2 = (int) r2;
        if (r3 <= 0) goto L_0x027d;
    L_0x0200:
        r3 = (float) r3;
        r3 = r3 * r16;
        r3 = (int) r3;
        if (r2 <= 0) goto L_0x0280;
    L_0x0206:
        r2 = (float) r2;
        r2 = r2 * r16;
        r2 = (int) r2;
    L_0x020a:
        r4 = (float) r3;
        r7 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = r7 * r16;
        r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        if (r4 >= 0) goto L_0x02f6;
    L_0x0213:
        r4 = "MicroMsg.ImgInfoStorage";
        r7 = "pic to small width is %d ";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r8[r9] = r3;
        com.tencent.mm.sdk.platformtools.w.d(r4, r7, r8);
        r3 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r3 = r3 * r16;
        r3 = (int) r3;
        r4 = r3;
    L_0x022c:
        r3 = (float) r2;
        r7 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = r7 * r16;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 >= 0) goto L_0x024d;
    L_0x0235:
        r3 = "MicroMsg.ImgInfoStorage";
        r7 = "pic to small height is %d ";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r8[r9] = r2;
        com.tencent.mm.sdk.platformtools.w.d(r3, r7, r8);
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r2 * r16;
        r2 = (int) r2;
    L_0x024d:
        r3 = new android.widget.FrameLayout$LayoutParams;
        r3.<init>(r4, r2);
        if (r23 != 0) goto L_0x02a1;
    L_0x0254:
        r2 = 5;
        r3.gravity = r2;
    L_0x0257:
        if (r25 == 0) goto L_0x02f3;
    L_0x0259:
        r0 = r25;
        r0.setLayoutParams(r3);
        r2 = r3;
    L_0x025f:
        r13.setLayoutParams(r2);
        if (r5 != 0) goto L_0x0272;
    L_0x0264:
        r8 = 1;
        r2 = r12;
        r3 = r13;
        r4 = r21;
        r5 = r25;
        r7 = r16;
        r9 = r20;
        r2.a(r3, r4, r5, r6, r7, r8, r9);
    L_0x0272:
        r2 = 0;
        goto L_0x0016;
    L_0x0275:
        r2 = 1126170624; // 0x43200000 float:160.0 double:5.564022167E-315;
        r0 = r17;
        r3 = (float) r0;
        r2 = r2 / r3;
        goto L_0x01f4;
    L_0x027d:
        r3 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x0200;
    L_0x0280:
        r2 = 75;
        goto L_0x0206;
    L_0x0283:
        if (r17 <= 0) goto L_0x029b;
    L_0x0285:
        r0 = r17;
        r2 = (float) r0;
        r2 = r2 * r16;
        r3 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = r2 * r3;
        r3 = (int) r2;
        if (r18 <= 0) goto L_0x029e;
    L_0x0290:
        r0 = r18;
        r2 = (float) r0;
        r2 = r2 * r16;
        r4 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r2 = r2 * r4;
        r2 = (int) r2;
        goto L_0x020a;
    L_0x029b:
        r17 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x0285;
    L_0x029e:
        r18 = 75;
        goto L_0x0290;
    L_0x02a1:
        r2 = 1;
        r0 = r23;
        if (r0 != r2) goto L_0x0257;
    L_0x02a6:
        r2 = 3;
        r3.gravity = r2;
        goto L_0x0257;
    L_0x02aa:
        r2 = r12.hFP;
        if (r2 == 0) goto L_0x02b6;
    L_0x02ae:
        r2 = r12.hFP;
        r2 = r2.get();
        if (r2 != 0) goto L_0x02c5;
    L_0x02b6:
        r2 = new android.graphics.drawable.ColorDrawable;
        r3 = -1118482; // 0xffffffffffeeeeee float:NaN double:NaN;
        r2.<init>(r3);
        r3 = new java.lang.ref.SoftReference;
        r3.<init>(r2);
        r12.hFP = r3;
    L_0x02c5:
        r2 = r12.hFP;
        r2 = r2.get();
        r2 = (android.graphics.drawable.ColorDrawable) r2;
        r13.setImageDrawable(r2);
        r2 = new android.widget.FrameLayout$LayoutParams;
        if (r17 <= 0) goto L_0x02ed;
    L_0x02d4:
        r0 = r17;
        r3 = (float) r0;
        r3 = r3 * r16;
        r4 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r3 = r3 * r4;
        r3 = (int) r3;
        if (r18 <= 0) goto L_0x02f0;
    L_0x02df:
        r0 = r18;
        r4 = (float) r0;
        r4 = r4 * r16;
        r7 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r4 = r4 * r7;
        r4 = (int) r4;
        r2.<init>(r3, r4);
        goto L_0x025f;
    L_0x02ed:
        r17 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x02d4;
    L_0x02f0:
        r18 = 75;
        goto L_0x02df;
    L_0x02f3:
        r2 = r3;
        goto L_0x025f;
    L_0x02f6:
        r4 = r3;
        goto L_0x022c;
    L_0x02f9:
        r4 = r2;
        goto L_0x00d4;
    L_0x02fc:
        r5 = r3;
        r2 = r10;
        goto L_0x00c9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ah.f.a(android.widget.ImageView, java.lang.String, boolean, float, int, int, boolean, int, android.widget.ImageView, int, int, boolean, android.view.View):boolean");
    }

    private void a(ImageView imageView, ImageView imageView2, View view, String str, float f, boolean z, int i) {
        int hashCode;
        int i2;
        int hashCode2 = str.hashCode();
        int hashCode3 = imageView.hashCode();
        for (b bVar : this.hFH) {
            if (hashCode3 == bVar.hFY) {
                w.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", Integer.valueOf(bVar.hFY), bVar.url);
                bVar.url = str;
                if (!this.hFL.contains(Integer.valueOf(hashCode2))) {
                    this.hFL.add(Integer.valueOf(hashCode2));
                    a(str, f, z, i);
                    return;
                }
                return;
            }
        }
        this.hFI.put(Integer.valueOf(hashCode3), new WeakReference(imageView));
        if (imageView2 != null) {
            hashCode = imageView2.hashCode();
            this.hFJ.put(Integer.valueOf(hashCode), new WeakReference(imageView2));
            i2 = hashCode;
        } else {
            i2 = 0;
        }
        if (view != null) {
            hashCode = view.hashCode();
            this.hFK.put(Integer.valueOf(hashCode), new WeakReference(view));
        } else {
            hashCode = 0;
        }
        this.hFH.add(new b(hashCode3, str, i2, hashCode));
        if (!this.hFL.contains(Integer.valueOf(hashCode2))) {
            this.hFL.add(Integer.valueOf(hashCode2));
            a(str, f, z, i);
        }
    }

    private void a(String str, float f, boolean z, int i) {
        h.vJ();
        final String str2 = str;
        final float f2 = f;
        final boolean z2 = z;
        final int i2 = i;
        h.vL().D(new Runnable(this) {
            final /* synthetic */ f hFS;

            public final void run() {
                this.hFS.a(str2, true, f2, true, false, z2, i2);
                this.hFS.hgN.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 hFX;

                    {
                        this.hFX = r1;
                    }

                    public final void run() {
                        f fVar = this.hFX.hFS;
                        String str = str2;
                        w.d("MicroMsg.ImgInfoStorage", "checkrefresh load done, uri: %s", str);
                        fVar.hFL.remove(Integer.valueOf(str.hashCode()));
                        for (b bVar : fVar.hFH) {
                            if (str.equals(bVar.url)) {
                                Bitmap bitmap = (Bitmap) fVar.hFF.get(str);
                                if (!(bitmap == null || bitmap.isRecycled())) {
                                    ImageView imageView = (ImageView) ((WeakReference) fVar.hFI.get(Integer.valueOf(bVar.hFY))).get();
                                    if (imageView != null) {
                                        w.i("MicroMsg.ImgInfoStorage", "[checkrefresh] bitmap width %d,height %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                                        a.a(bitmap, imageView);
                                        imageView.setLayoutParams(fVar.hFO);
                                        int i = bitmap.getWidth() >= bitmap.getHeight() * 2 ? 1 : 0;
                                        int i2 = bitmap.getHeight() >= bitmap.getWidth() * 2 ? 1 : 0;
                                        if (!(i == 0 && i2 == 0)) {
                                            w.d("MicroMsg.ImgInfoStorage", "bm: w:%d, h:%d ", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                                            imageView.setScaleType(ScaleType.CENTER);
                                        }
                                        if (fVar.hFJ.get(Integer.valueOf(bVar.hFZ)) != null) {
                                            imageView = (ImageView) ((WeakReference) fVar.hFJ.get(Integer.valueOf(bVar.hFZ))).get();
                                            if (imageView != null) {
                                                imageView.setLayoutParams(new LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
                                            }
                                        }
                                        if (fVar.hFK.get(Integer.valueOf(bVar.hGa)) != null) {
                                            View view = (View) ((WeakReference) fVar.hFK.get(Integer.valueOf(bVar.hGa))).get();
                                            if (view != null) {
                                                view.setLayoutParams(new LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|loadImginBackground";
            }
        });
    }

    public final Bitmap a(String str, float f) {
        return a(str, true, f, false, true, false, 0);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i) {
        return a(str, z, f, z2, z3, z4, i, true);
    }

    private Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5) {
        return a(str, z, f, z2, z3, z4, i, z5, null);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5, Bitmap bitmap) {
        if (!z) {
            str = b(str, false, true);
        }
        if (str == null) {
            return null;
        }
        Bitmap bitmap2 = null;
        Object obj = bitmap != null ? 1 : null;
        if (z5) {
            bitmap2 = (Bitmap) this.hFF.get(str);
            if (bitmap2 == null) {
                String str2 = "MicroMsg.ImgInfoStorage";
                String str3 = "bm is null:%b,  url:%s";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bitmap2 == null);
                objArr[1] = str;
                w.h(str2, str3, objArr);
            }
        }
        if (bitmap2 != null && !bitmap2.isRecycled() && obj == null) {
            return bitmap2;
        }
        Bitmap bitmap3;
        bg.Nz();
        if (obj != null) {
            bitmap3 = bitmap;
        } else {
            bitmap3 = d.a(str, f, 0);
        }
        if (bitmap3 == null) {
            bitmap3 = com.tencent.mm.platformtools.j.mt(str);
        }
        if (bitmap3 == null) {
            return bitmap2;
        }
        Bitmap createScaledBitmap;
        long currentTimeMillis = System.currentTimeMillis();
        int width = bitmap3.getWidth();
        int height = bitmap3.getHeight();
        if (z3) {
            if (hFE == 0) {
                hFE = com.tencent.mm.bg.a.U(ab.getContext(), com.tencent.mm.plugin.comm.a.b.kDz);
            }
            if (width > hFE || height > hFE) {
                if (width > height) {
                    height = (height * hFE) / width;
                    width = hFE;
                } else if (width == height) {
                    height = hFE;
                    width = hFE;
                } else {
                    width = (width * hFE) / height;
                    height = hFE;
                }
            }
        }
        if (z4) {
            int i2;
            if (str.endsWith("hd")) {
                i2 = width;
                width = height;
            } else {
                i2 = (int) ((((float) bitmap3.getWidth()) * f) * 1.25f);
                width = (int) ((((float) bitmap3.getHeight()) * f) * 1.25f);
            }
            if (((float) i2) >= 160.0f * f || ((float) width) >= 160.0f * f) {
                float f2;
                if (width > i2) {
                    f2 = (160.0f * f) / ((float) width);
                } else {
                    f2 = (160.0f * f) / ((float) i2);
                }
                height = (int) (f2 * ((float) width));
                width = (int) (((float) i2) * f2);
            } else {
                height = width;
                width = i2;
            }
            if (((float) width) < 60.0f * f) {
                w.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", Integer.valueOf(width));
                width = (int) (60.0f * f);
            }
            if (((float) height) < 60.0f * f) {
                w.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", Integer.valueOf(height));
                height = (int) (60.0f * f);
            }
            Context context = ab.getContext();
            int[] iArr = new int[2];
            float f3;
            if (height >= width) {
                f3 = ((float) height) / ((float) width);
                if (f3 <= 2.0f) {
                    height = com.tencent.mm.bg.a.U(context, com.tencent.mm.plugin.comm.a.b.aWH);
                    width = (int) (((float) height) / f3);
                } else {
                    width = com.tencent.mm.bg.a.U(context, com.tencent.mm.plugin.comm.a.b.aWI);
                    height = (int) (((float) width) * f3);
                }
            } else {
                f3 = ((float) width) / ((float) height);
                if (f3 <= 2.0f) {
                    width = com.tencent.mm.bg.a.U(context, com.tencent.mm.plugin.comm.a.b.aWH);
                    height = (int) (((float) width) / f3);
                } else {
                    height = com.tencent.mm.bg.a.U(context, com.tencent.mm.plugin.comm.a.b.aWI);
                    width = (int) (((float) height) * f3);
                }
            }
            iArr[0] = width;
            iArr[1] = height;
            width = iArr[0];
            height = iArr[1];
        }
        try {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, width, height, true);
        } catch (OutOfMemoryError e) {
            createScaledBitmap = bitmap3;
        }
        if (bitmap3 != createScaledBitmap && obj == null) {
            w.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", bitmap3.toString());
            bitmap3.recycle();
        }
        if (z4) {
            bitmap2 = d.b(createScaledBitmap, i);
        } else if (z2) {
            bitmap2 = d.a(createScaledBitmap, true, (float) com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 3));
            w.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", createScaledBitmap.toString());
            createScaledBitmap.recycle();
        } else {
            bitmap2 = createScaledBitmap;
        }
        str2 = "MicroMsg.ImgInfoStorage";
        str3 = "cached file :%s bitmap time:%s bitmap:%s";
        objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = (System.currentTimeMillis() - currentTimeMillis);
        objArr[2] = bitmap2 == null ? "" : bitmap2.toString();
        w.i(str2, str3, objArr);
        if (bitmap2 == null || obj != null) {
            return bitmap2;
        }
        this.hFF.k(str, bitmap2);
        return bitmap2;
    }

    public final Bitmap a(String str, float f, Context context) {
        return a(str, f, context, -1);
    }

    public final Bitmap a(String str, float f, Context context, int i) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        Bitmap bitmap = (Bitmap) this.hFF.get(trim);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap c = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(trim, f);
        if (c == null) {
            return c;
        }
        int a;
        int i2;
        int width = c.getWidth();
        int height = c.getHeight();
        if (width >= height) {
            a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, (float) this.hFQ);
            i2 = (int) ((((float) height) / ((float) width)) * ((float) a));
        } else {
            i2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, (float) this.hFQ);
            a = (int) ((((float) width) / ((float) height)) * ((float) i2));
        }
        if (a <= 0 || i2 <= 0 || a > 2048 || i2 > 2048) {
            w.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", Integer.valueOf(a), Integer.valueOf(i2));
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 188, 1, false);
            bitmap = null;
        } else {
            try {
                bitmap = Bitmap.createScaledBitmap(c, a, i2, true);
            } catch (Exception e) {
                w.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", e.getMessage());
                bitmap = null;
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 188, 1, false);
            }
        }
        if (i != -1) {
            bitmap = d.b(bitmap, i);
        }
        if (c != bitmap) {
            w.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", c.toString());
            c.recycle();
        }
        w.d("MicroMsg.ImgInfoStorage", "cached file " + trim);
        this.hFF.k(trim, bitmap);
        return bitmap;
    }

    public final d n(au auVar) {
        d aj = aj(auVar.field_msgId);
        if (aj.hEY != 0) {
            return aj;
        }
        aj = ai(auVar.field_msgSvrId);
        if (aj.hEY != 0) {
            return aj;
        }
        w.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        return null;
    }

    public final d b(Long l) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "id=?", new String[]{String.valueOf(l)}, null, null, null);
        if (a != null && a.moveToFirst()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    private d z(String str, int i) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[]{str, String.valueOf(i)}, null, null, null);
        if (a != null && a.moveToFirst()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    public final void o(au auVar) {
        d n = n(auVar);
        if (n == null || n.hEY == 0) {
            w.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            return;
        }
        FileOp.deleteFile(m(n.hEZ, "", ""));
        FileOp.deleteFile(m(n.hFb, "", ""));
        FileOp.deleteFile(m(n.hFb, "", "") + "hd");
        this.hnH.delete("ImgInfo2", "id=?", new String[]{n.hEY});
        if (n.GB()) {
            n = fT(n.hFi);
            if (n != null) {
                FileOp.deleteFile(m(n.hEZ, "", ""));
                FileOp.deleteFile(m(n.hFb, "", ""));
                FileOp.deleteFile(m(n.hFb, "", "") + "hd");
                this.hnH.delete("ImgInfo2", "id=?", new String[]{n.hEY});
            }
        }
    }

    public final String d(d dVar) {
        String str = null;
        if (dVar != null && dVar.GB()) {
            Cursor a = a("ImgInfo2", new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{dVar.hFi});
            if (a.moveToFirst()) {
                str = a.getString(0);
            }
            a.close();
        }
        return str;
    }

    public final HashMap<Long, d> a(Long... lArr) {
        Object obj = 1;
        int length = lArr.length;
        String str = "(";
        int i = 0;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor a = a("ImgInfo2", null, "msgSvrId in " + (str + ")"), null);
        HashMap<Long, d> hashMap = new HashMap();
        while (a.moveToNext()) {
            d dVar = new d();
            dVar.b(a);
            hashMap.put(Long.valueOf(dVar.fTQ), dVar);
        }
        a.close();
        return hashMap;
    }

    public final HashMap<Long, d> b(Long... lArr) {
        Object obj = 1;
        int length = lArr.length;
        String str = "(";
        int i = 0;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor a = a("ImgInfo2", null, "msglocalid in " + (str + ")"), null);
        HashMap<Long, d> hashMap = new HashMap();
        while (a.moveToNext()) {
            d dVar = new d();
            dVar.b(a);
            hashMap.put(Long.valueOf(dVar.fTQ), dVar);
        }
        a.close();
        return hashMap;
    }

    public final d fT(int i) {
        return b(Long.valueOf((long) i));
    }

    public final d ai(long j) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j)});
        if (a != null && a.moveToFirst()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    public final d aj(long j) {
        d dVar = new d();
        Cursor a = a("ImgInfo2", null, "msglocalid=?", new String[]{String.valueOf(j)});
        if (a != null && a.moveToLast()) {
            dVar.b(a);
        }
        a.close();
        return dVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ah.d fU(int r9) {
        /*
        r8 = this;
        r2 = 0;
        r0 = "ImgInfo2";
        r1 = 0;
        r3 = "reserved1=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x002d }
        r5 = 0;
        r6 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x002d }
        r4[r5] = r6;	 Catch:{ Exception -> 0x002d }
        r3 = r8.a(r0, r1, r3, r4);	 Catch:{ Exception -> 0x002d }
        if (r3 == 0) goto L_0x005e;
    L_0x0018:
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        if (r0 == 0) goto L_0x005e;
    L_0x001e:
        r1 = new com.tencent.mm.ah.d;	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        r1.<init>();	 Catch:{ Exception -> 0x0053, all -> 0x0050 }
        r1.b(r3);	 Catch:{ Exception -> 0x0058, all -> 0x0050 }
        r0 = r1;
    L_0x0027:
        if (r3 == 0) goto L_0x002c;
    L_0x0029:
        r3.close();
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0030:
        r3 = "MicroMsg.ImgInfoStorage";
        r4 = "Exception :%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0049 }
        r6 = 0;
        r1 = r1.toString();	 Catch:{ all -> 0x0049 }
        r5[r6] = r1;	 Catch:{ all -> 0x0049 }
        com.tencent.mm.sdk.platformtools.w.w(r3, r4, r5);	 Catch:{ all -> 0x0049 }
        if (r2 == 0) goto L_0x002c;
    L_0x0045:
        r2.close();
        goto L_0x002c;
    L_0x0049:
        r0 = move-exception;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();
    L_0x004f:
        throw r0;
    L_0x0050:
        r0 = move-exception;
        r2 = r3;
        goto L_0x004a;
    L_0x0053:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        r2 = r3;
        goto L_0x0030;
    L_0x0058:
        r0 = move-exception;
        r2 = r3;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0030;
    L_0x005e:
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ah.f.fU(int):com.tencent.mm.ah.d");
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return this.hnH.query(str, strArr, str2, strArr2, null, null, null);
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2) {
        return a(str, strArr, str2, strArr2, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2) {
        return a(str, i, i2, i3, pString, pInt, pInt2, "", "", -1, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str2, String str3, long j, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.ah.m.a aVar) {
        d a;
        long e;
        if (i == 0) {
            a = a(str, 0, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.hFb;
            e = e(a);
            if (e == -1) {
                return e;
            }
            doNotify();
            return e;
        } else if (i == 1) {
            a = a(str, 1, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.hFb;
            a.ag(0);
            a.y(0);
            a.fO((int) FileOp.ki(m(a.hEZ, "", "")));
            d a2 = a(str, 0, false, i2, i3, new PInt(), new PInt(), "", j, str2, str3, bVar2, bVar, aVar);
            a2.jo(a.hEZ);
            a2.jq(a.hFb);
            a2.jp(a.hFa);
            a2.fO(0);
            long cs = this.hnH.cs(Thread.currentThread().getId());
            a2.fP((int) e(a));
            e = e(a2);
            w.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", Long.valueOf(e), Long.valueOf(a2.hEY), Long.valueOf(a2.hFg), a2.hEZ, a2.hFa, Integer.valueOf(a2.hrs));
            if (cs > 0) {
                h.vI().gYg.aD(cs);
            }
            if (e == -1) {
                return e;
            }
            doNotify();
            return e;
        } else {
            Assert.assertTrue(false);
            return 0;
        }
    }

    private long e(d dVar) {
        long insert = this.hnH.insert("ImgInfo2", SlookAirButtonFrequentContactAdapter.ID, dVar.pv());
        if (insert != -1) {
            dVar.GC();
        }
        w.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", Long.valueOf(insert), Long.valueOf(dVar.hEY), Long.valueOf(dVar.hFg), Long.valueOf(dVar.fTQ), Integer.valueOf(dVar.hFi));
        return insert;
    }

    private String A(String str, int i) {
        d z = z(FileOp.ko(str), i);
        if (!bg.mA(z.hFb)) {
            String v = v(z.hFb, true);
            if (FileOp.aO(v)) {
                return v;
            }
        }
        return null;
    }

    public final Bitmap a(String str, int i, int i2, PInt pInt, PInt pInt2, boolean z, String str2, com.tencent.mm.a.b bVar) {
        Bitmap bitmap;
        String str3;
        w.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s]", str, Integer.valueOf(i), Boolean.valueOf(z), bg.bJZ());
        Bitmap bitmap2 = (Bitmap) this.hFF.get(str);
        if (bitmap2 == null || bitmap2.isRecycled()) {
            String A = A(str, i);
            if (bg.mA(A)) {
                bitmap = bitmap2;
                str3 = str;
            } else if (A.endsWith("hd")) {
                bitmap = bitmap2;
                str3 = A;
            } else {
                bitmap = d.cz(A, 0);
                str3 = str;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                int Pf = d.Pf(str3);
                int Pc = ExifHelper.Pc(str3) + (i2 * 90);
                if (Pf > 0) {
                    bitmap = d.c(str3, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, Pf, Pc, 0);
                    str3 = A;
                } else {
                    bitmap = d.a(str3, 120, 120, true, false, 0);
                    str3 = A;
                }
            } else {
                str3 = A;
            }
        } else {
            bitmap = bitmap2;
            str3 = null;
        }
        if (bitmap != null) {
            this.hFF.k(str, bitmap);
            pInt.value = bitmap.getWidth();
            pInt2.value = bitmap.getHeight();
            if (z) {
                if (str3 == null) {
                    str3 = A(str, i);
                }
                if (!bg.mA(str3) && str3.endsWith("hd")) {
                    str3 = str3.substring(0, str3.length() - 2);
                }
                if (bVar != null) {
                    bVar.nV();
                }
                if (bg.mA(str3) || !FileOp.aO(str3)) {
                    try {
                        d.a(bitmap, 100, CompressFormat.JPEG, str2, false);
                    } catch (IOException e) {
                    }
                } else {
                    FileOp.p(str3, str2);
                    w.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", str3);
                }
            }
        }
        return bitmap;
    }

    public static synchronized String GE() {
        String n;
        synchronized (f.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (hFR == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            hFR = currentTimeMillis;
            n = com.tencent.mm.a.g.n(String.valueOf(currentTimeMillis).getBytes());
        }
        return n;
    }

    public final String a(String str, String str2, int i, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str3, com.tencent.mm.a.b bVar) {
        int intValue;
        int i2;
        String value;
        int indexOf;
        int intValue2;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        if (bg.mA(str3)) {
            str3 = com.tencent.mm.a.g.n((str + System.currentTimeMillis()).getBytes());
        }
        String a = a(str3, "", ".jpg", false);
        if (bVar == null) {
            a = a(str3, "", ".jpg", true);
        }
        pString.value = str3;
        pString2.value = a;
        if (z && !bg.mA(str2) && i == 0) {
            d z4 = z(str2, i);
            if (!bg.mA(z4.hEZ)) {
                String m = m(z4.hEZ, "", "");
                if (bVar != null) {
                    bVar.nV();
                }
                FileOp.p(m, a);
                if (FileOp.ki(m) <= 0) {
                    w.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", str, a);
                } else if (bg.mA(z4.hFj)) {
                    return null;
                } else {
                    return z4.hFj;
                }
            }
        }
        try {
            intValue = am.isWifi(ab.getContext()) ? Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressPicLevelForWifi")).intValue() : am.is2G(ab.getContext()) ? Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressPicLevelFor2G")).intValue() : Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressPicLevelFor3G")).intValue();
        } catch (Exception e) {
            intValue = 0;
        }
        w.i("MicroMsg.ImgInfoStorage", "CompressPicLevel-level:%d", Integer.valueOf(intValue));
        if (intValue <= 10 || intValue > 100) {
            i2 = 70;
        } else {
            i2 = intValue;
        }
        int i5 = 0;
        try {
            if (am.isWifi(ab.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressResolutionForWifi");
            } else if (am.is2G(ab.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressResolutionFor2G");
            } else {
                value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressResolutionFor3G");
            }
            indexOf = value.indexOf("*");
            if (-1 != indexOf) {
                intValue2 = Integer.valueOf(value.substring(0, indexOf)).intValue();
                intValue = Integer.valueOf(value.substring(indexOf + 1)).intValue();
                i5 = intValue2;
            } else {
                intValue = 0;
                i5 = 0;
            }
            intValue2 = i5;
            i5 = intValue;
        } catch (Exception e2) {
            intValue2 = 0;
        }
        try {
            i3 = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("UseOptImage"), 0);
            h.vG();
            if ((((int) (new o(com.tencent.mm.kernel.a.uH()).longValue() / 100)) % 100) + 1 <= i3) {
                z2 = true;
            } else {
                z2 = false;
            }
            w.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(new o(com.tencent.mm.kernel.a.uH()).longValue()), Long.valueOf(new o(com.tencent.mm.kernel.a.uH()).longValue() / 100), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIu()), Integer.valueOf(VERSION.SDK_INT));
        } catch (Throwable e3) {
            w.e("MicroMsg.ImgInfoStorage", "get useopt :%s", bg.g(e3));
            z2 = false;
        }
        if (com.tencent.mm.sdk.a.b.bIu()) {
            z2 = true;
        }
        if (com.tencent.mm.compatible.util.d.ep(16)) {
            z3 = false;
        } else {
            z3 = z2;
        }
        w.i("MicroMsg.ImgInfoStorage", "CompressResolution-width:%d CompressResolution-height:%d", Integer.valueOf(intValue2), Integer.valueOf(i5));
        if (intValue2 <= 0) {
            intValue = 960;
        } else {
            intValue = intValue2;
        }
        if (i5 <= 0) {
            i5 = 960;
        }
        if (intValue < i5) {
            intValue2 = i5;
            i5 = intValue;
        } else {
            intValue2 = intValue;
        }
        intValue = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (intValue <= 0) {
            intValue = 100;
        }
        int i6 = intValue * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        intValue = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (intValue <= 0 || intValue >= 100) {
            i4 = 10;
        } else {
            i4 = intValue;
        }
        int queryQuality = MMNativeJpeg.queryQuality(str);
        Object obj = 1;
        if (queryQuality != 0 && queryQuality <= i2) {
            obj = null;
        }
        w.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", str, a, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i4));
        if (z) {
            boolean z5;
            long j;
            boolean z6;
            Options Pe = d.Pe(str);
            int i7 = Pe != null ? Pe.outWidth : -1;
            int i8 = Pe != null ? Pe.outHeight : -1;
            int i9 = 0;
            indexOf = 0;
            if (Pe != null) {
                if (i7 < i8) {
                    indexOf = i7;
                    i9 = i8;
                } else {
                    indexOf = i8;
                    i9 = i7;
                }
            }
            long ki = FileOp.ki(str);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str);
            if (i != 0 || ((r4 == null && ki <= 204800 && (Pe == null || (indexOf <= i5 && i9 <= intValue2))) || ki <= ((long) i6))) {
                w.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", Integer.valueOf(queryQuality), Long.valueOf(ki), Integer.valueOf(i7), Integer.valueOf(i8));
                FileOp.p(str, a);
                com.tencent.mm.modelcdntran.g.El();
                if (!c.fA(256)) {
                    w.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i == 1) {
                    int i10;
                    int i11 = 0;
                    try {
                        i11 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e4) {
                    }
                    try {
                        intValue = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e5) {
                        intValue = 0;
                    }
                    w.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", Integer.valueOf(i11), Integer.valueOf(intValue));
                    if (i11 <= 10 || i11 > 100) {
                        i11 = 52;
                    }
                    if (intValue <= 0 || intValue > 800) {
                        i3 = 800;
                    } else {
                        i3 = intValue;
                    }
                    if (intValue2 > i3) {
                        i10 = i3;
                    } else {
                        i10 = intValue2;
                    }
                    if (i5 > i3) {
                        i6 = i3;
                    } else {
                        i6 = i5;
                    }
                    z2 = true;
                    if (queryQuality != 0 && queryQuality <= i11) {
                        z2 = false;
                    }
                    if (z2 || ki > 800 || (Pe != null && (indexOf > i3 || i9 > i3))) {
                        pString3.value = com.tencent.mm.a.g.n((str + System.currentTimeMillis()).getBytes());
                        pString4.value = a(pString3.value, "", ".jpg", false);
                        w.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", pString3.value, pString4.value, Boolean.valueOf(false), Integer.valueOf(d.a(false, str, i6, i10, CompressFormat.JPEG, i11, pString4.value, bVar)), Integer.valueOf(i6), Integer.valueOf(i10));
                        intValue2 = intValue;
                        i6 = 38;
                        z5 = false;
                        j = 0;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        w.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", Boolean.valueOf(z2), Integer.valueOf(indexOf), Integer.valueOf(i9), Integer.valueOf(i6), Integer.valueOf(i10), pString3.value, pString4.value);
                        j = 0;
                        intValue2 = 1;
                        i6 = 38;
                        z5 = false;
                    }
                }
                j = 0;
                intValue2 = 1;
                i6 = 38;
                z5 = false;
            } else {
                if (indexOf < i5) {
                    intValue = indexOf;
                } else {
                    intValue = i5;
                }
                if (i9 < intValue2) {
                    intValue2 = i9;
                }
                if (Pe == null || i7 >= i8) {
                    indexOf = intValue2;
                    intValue2 = intValue;
                } else {
                    indexOf = intValue;
                }
                if (queryQuality < 55 || !IsJpegFile) {
                    z2 = false;
                } else {
                    z2 = z3;
                }
                if (z2) {
                    i6 = 18;
                } else {
                    i6 = 8;
                }
                long Nz = bg.Nz();
                i5 = d.a(z2, str, intValue2, indexOf, CompressFormat.JPEG, i2, a, bVar);
                if (i5 == 1 || !z2) {
                    int i12 = i5;
                    z6 = z2;
                    intValue = i12;
                } else {
                    i6 = 28;
                    intValue = d.a(false, str, intValue2, indexOf, CompressFormat.JPEG, i2, a, bVar);
                    z6 = false;
                }
                w.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", Long.valueOf(ki), Long.valueOf(FileOp.ki(a)), Long.valueOf((100 * FileOp.ki(a)) / ki), Integer.valueOf(i4), a);
                if ((ki - FileOp.ki(a)) * 100 < ((long) i4) * ki) {
                    FileOp.p(str, a);
                    z6 = false;
                    i6 = 48;
                    intValue = 1;
                }
                long Nz2 = bg.Nz() - Nz;
                if (intValue != 1) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(111, 187, 1, false);
                    w.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", str);
                    return null;
                }
                long j2 = Nz2;
                intValue2 = intValue;
                z5 = z6;
                j = j2;
            }
            Options Pe2 = d.Pe(a);
            i9 = Pe2 != null ? Pe2.outWidth : -1;
            i3 = Pe2 != null ? Pe2.outHeight : -1;
            long ki2 = FileOp.ki(a);
            i4 = MMNativeJpeg.queryQuality(a);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(a);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            Integer[] numArr = new Object[13];
            numArr[0] = Integer.valueOf(intValue2);
            numArr[1] = Long.valueOf(j);
            numArr[2] = Integer.valueOf(i6);
            numArr[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
            numArr[4] = Long.valueOf(ki);
            numArr[5] = Integer.valueOf(i7);
            numArr[6] = Integer.valueOf(i8);
            numArr[7] = Integer.valueOf(i);
            numArr[8] = Long.valueOf(ki2);
            numArr[9] = Integer.valueOf(i9);
            numArr[10] = Integer.valueOf(i3);
            numArr[11] = Integer.valueOf(queryQuality);
            numArr[12] = Integer.valueOf(i4);
            gVar.i(11713, (Object[]) numArr);
            w.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(intValue2), Boolean.valueOf(z5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(queryQuality), Long.valueOf(ki), Boolean.valueOf(IsJpegFile), Integer.valueOf(i9), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(ki2), Boolean.valueOf(IsJpegFile2), str, a);
            if (i == 0 && ki2 >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(a)) {
                value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNUploadImg");
                if (!bg.mA(value) && value.equals("1")) {
                    long Nz3 = bg.Nz();
                    if (z5) {
                        String str4 = a + ".prog";
                        FileOp.p(a, str4);
                        z2 = (bg.mA(str4) || bg.mA(a) || !new File(str4).exists()) ? false : MMJpegOptim.convertToProgressive(str4, a, i2) == 0;
                        FileOp.deleteFile(str4);
                        if (z2) {
                            z6 = z2;
                            intValue = 19;
                        } else {
                            intValue = 29;
                            z6 = MMNativeJpeg.convertToProgressive(a, i2);
                        }
                    } else {
                        intValue = 9;
                        z6 = MMNativeJpeg.convertToProgressive(a, i2);
                    }
                    Nz3 = bg.Nz() - Nz3;
                    long ki3 = FileOp.ki(a);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.oUh;
                    Integer[] numArr2 = new Object[14];
                    numArr2[0] = Integer.valueOf(z6 ? 1 : -1);
                    numArr2[1] = Long.valueOf(Nz3);
                    numArr2[2] = Integer.valueOf(intValue);
                    numArr2[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
                    numArr2[4] = Long.valueOf(ki);
                    numArr2[5] = Integer.valueOf(i7);
                    numArr2[6] = Integer.valueOf(i8);
                    numArr2[7] = Integer.valueOf(i);
                    numArr2[8] = Long.valueOf(ki2);
                    numArr2[9] = Integer.valueOf(i9);
                    numArr2[10] = Integer.valueOf(i3);
                    numArr2[11] = Integer.valueOf(queryQuality);
                    numArr2[12] = Integer.valueOf(i4);
                    numArr2[13] = Long.valueOf(ki3);
                    gVar2.i(11713, (Object[]) numArr2);
                    w.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", Integer.valueOf(intValue2), Boolean.valueOf(z6), Long.valueOf(ki3), Boolean.valueOf(z5), Integer.valueOf(intValue), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(queryQuality), Long.valueOf(ki), Boolean.valueOf(IsJpegFile), Integer.valueOf(i9), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(ki2), Boolean.valueOf(IsJpegFile2), str, a);
                    if (!z6) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(111, 186, 1, false);
                        w.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", a);
                    }
                }
            }
        }
        return null;
    }

    private d a(String str, int i, boolean z, int i2, int i3, PInt pInt, PInt pInt2, String str2, long j, String str3, String str4, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, com.tencent.mm.ah.m.a aVar) {
        if (!FileOp.aO(str)) {
            return null;
        }
        String str5;
        String str6;
        PString pString;
        PString pString2;
        PString pString3;
        String a;
        String ko = FileOp.ko(str);
        w.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", str);
        if (FileOp.aO(str)) {
            if (bg.mA(str3)) {
                str3 = GE();
            }
            str5 = "THUMBNAIL_DIRPATH://th_" + str3;
            String a2 = a(str5, "th_", "", false);
            if (bVar == null) {
                a2 = m(str5, "th_", "");
            }
            if (z) {
                if (bg.mA(str2) || !FileOp.aO(str2)) {
                    long NA = bg.NA();
                    a(str, i, i3, pInt, pInt2, true, a2, bVar);
                    if (FileOp.aO(a2)) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10921, Long.valueOf(FileOp.ki(a2)), Long.valueOf(FileOp.ki(str)), Integer.valueOf(90), Long.valueOf(bg.aB(NA)));
                    } else {
                        w.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                    }
                } else {
                    FileOp.p(str2, a2);
                }
                w.d("MicroMsg.ImgInfoStorage", "insert: thumbName = " + str5);
            }
            str6 = str5;
        } else {
            w.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
            str6 = null;
        }
        if (aVar == null || aVar.hFc != i) {
            com.tencent.mm.a.b bVar3;
            if (aVar == null || aVar.hFc == i) {
                bVar3 = bVar2;
                str5 = str4;
            } else {
                bVar3 = null;
                str5 = null;
            }
            pString = new PString();
            pString2 = new PString();
            pString3 = new PString();
            a = a(str, ko, i, z, pString, pString2, pString3, new PString(), str5, bVar3);
            w.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, r10.value);
        } else {
            com.tencent.mm.ah.m.a.a GL = aVar.GL();
            pString = GL.hHo;
            pString2 = GL.hHp;
            a = GL.hFj;
            pString3 = GL.hHq;
            PString pString4 = GL.hHr;
            w.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, pString4.value);
        }
        d dVar = new d();
        dVar.fRW = -1;
        long j2 = this.hFN;
        this.hFN = 1 + j2;
        dVar.ah(j2);
        dVar.ag(j);
        if (!bg.mA(a)) {
            dVar.jr(a);
        }
        dVar.fR(0);
        dVar.cGa = i2;
        dVar.hFx = true;
        if (i2 == 4) {
            if (str.startsWith(u.xh())) {
                dVar.fQ(3);
            } else {
                dVar.fQ(2);
            }
        } else {
            dVar.fQ(1);
        }
        if (z) {
            dVar.jo(pString.value + ".jpg");
            if (!(pString3 == null || bg.mA(pString3.value))) {
                dVar.jp(pString3.value + ".jpg");
            }
            if (bg.mA(dVar.hFb)) {
                dVar.jq(str6);
            }
            dVar.fO((int) FileOp.ki(pString2.value));
            if (dVar.hrs == 0) {
                w.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", pString2.value);
            }
            dVar.jn(ko);
        }
        dVar.fN((int) bg.Ny());
        dVar.fS(i);
        w.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + dVar.hrs);
        return dVar;
    }

    public final long a(byte[] bArr, long j, boolean z, String str, PString pString, PInt pInt, PInt pInt2) {
        return a(bArr, j, z, "", 0, str, pString, pInt, pInt2);
    }

    public final long a(byte[] bArr, long j, boolean z, String str, int i, String str2, PString pString, PInt pInt, PInt pInt2) {
        String str3 = "SERVERID://" + j;
        String n = com.tencent.mm.a.g.n(str3.getBytes());
        String m = m(n, "th_", "");
        if (bArr != null && bArr.length >= 0) {
            Bitmap be = d.be(bArr);
            if (be == null) {
                w.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!(z || be == null)) {
                try {
                    be = d.J(be);
                    pInt.value = be.getWidth();
                    pInt2.value = be.getHeight();
                    d.a(be, 90, CompressFormat.JPEG, m, true);
                } catch (IOException e) {
                    w.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + n + " " + new String(bArr));
                }
            }
        }
        d dVar = new d();
        if (bg.mA(str)) {
            str = str3;
        } else {
            dVar.setOffset(i);
            dVar.fO(i);
        }
        dVar.fRW = -1;
        long j2 = this.hFN;
        this.hFN = 1 + j2;
        dVar.ah(j2);
        dVar.jo(str);
        dVar.jq("THUMBNAIL_DIRPATH://th_" + n);
        pString.value = dVar.hFb;
        if (z) {
            dVar.y(0);
        } else {
            dVar.y(j);
        }
        dVar.jr(str2);
        dVar.fN((int) bg.Ny());
        long e2 = e(dVar);
        if (e2 != -1) {
            doNotify();
        }
        return e2;
    }

    public final int a(int i, d dVar) {
        return a(Long.valueOf((long) i), dVar);
    }

    public final int a(Long l, d dVar) {
        int i;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues pv = dVar.pv();
        if (pv.size() == 0) {
            i = 1;
        } else {
            i = this.hnH.update("ImgInfo2", pv, "id=?", new String[]{String.valueOf(l)});
        }
        w.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), pv.toString());
        if (i != -1) {
            dVar.GC();
            doNotify();
        }
        return i;
    }

    public final Bitmap a(long j, String str, int i, int i2, int i3, boolean z) {
        Object obj;
        if (z) {
            obj = "location_backgroup_key_from" + j;
        } else {
            String str2 = "location_backgroup_key_tor" + j;
        }
        Bitmap bitmap = (Bitmap) this.hFF.get(obj);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        bitmap = d.f(str, i, i2, i3);
        this.hFF.k(obj, bitmap);
        return bitmap;
    }

    public final boolean a(String str, String str2, int i, int i2) {
        w.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), bg.bJZ());
        long currentTimeMillis = System.currentTimeMillis();
        float density = com.tencent.mm.bg.a.getDensity(ab.getContext());
        if (bg.mA(str) || bg.mA(str2)) {
            return false;
        }
        String b = b(str2, false, true);
        if (bg.mA(b)) {
            return false;
        }
        String str3;
        String substring;
        int i3;
        int i4;
        boolean a;
        if (b.endsWith("hd")) {
            str3 = b;
            substring = b.substring(0, b.length() - 2);
        } else {
            str3 = b + "hd";
            substring = b;
        }
        Options Pe = d.Pe(substring);
        if (Pe == null || Pe.outWidth <= 0 || Pe.outHeight <= 0) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 185, 1, false);
            if (e.aN(substring) > 0) {
                return false;
            }
            Pe = new Options();
            d.b(Pe);
            w.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", Pe, Integer.valueOf(Pe.outWidth), Integer.valueOf(Pe.outHeight));
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 183, 1, false);
        }
        int i5 = (int) ((((float) Pe.outWidth) * density) * 1.25f);
        int i6 = (int) ((((float) Pe.outHeight) * density) * 1.25f);
        if (((float) i5) >= 160.0f * density || ((float) i6) >= 160.0f * density) {
            float f;
            if (i6 > i5) {
                f = (160.0f * density) / ((float) i6);
            } else {
                f = (160.0f * density) / ((float) i5);
            }
            i3 = (int) (((float) i5) * f);
            i4 = (int) (f * ((float) i6));
        } else {
            i4 = i6;
            i3 = i5;
        }
        i3 = Math.max(i3, i5);
        i6 = Math.max(i4, i6);
        if (i2 == 0) {
            try {
                a = d.a(str, i6, i3, CompressFormat.JPEG, str3, new PInt(), new PInt());
            } catch (Exception e) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 184, 1, false);
                w.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", e.toString());
                return false;
            }
        }
        a = d.b(str, i6, i3, CompressFormat.JPEG, str3, new PInt(), new PInt());
        w.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", (System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i6), Integer.valueOf(i3), Boolean.valueOf(a));
        a(substring, true, com.tencent.mm.bg.a.getDensity(ab.getContext()), true, false, true, i, false);
        if (a) {
            synchronized (this.hFM) {
                if (this.hFM.containsKey(str2) && !((String) this.hFM.get(str2)).endsWith("hd")) {
                    this.hFM.put(str2, str3);
                }
            }
            return a;
        }
        com.tencent.mm.plugin.report.service.g.oUh.a(111, 184, 1, false);
        return a;
    }

    public final String b(String str, boolean z, boolean z2) {
        if (str != null && this.hFM.containsKey(str)) {
            return (String) this.hFM.get(str);
        }
        String str2;
        if (z) {
            str2 = str;
        } else {
            str2 = v(str, z2);
        }
        if (bg.mA(str2)) {
            return str2;
        }
        this.hFM.put(str, str2);
        return str2;
    }

    public final String jv(String str) {
        return b(str, false, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p(com.tencent.mm.storage.au r10) {
        /*
        r6 = 0;
        r1 = 0;
        r8 = 1;
        if (r10 != 0) goto L_0x0011;
    L_0x0006:
        r0 = "MicroMsg.ImgInfoStorage";
        r2 = "[getBigPicPath] msg is null.";
        com.tencent.mm.sdk.platformtools.w.w(r0, r2);
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = java.lang.System.currentTimeMillis();
        r0 = r10.field_isSend;
        if (r0 != r8) goto L_0x0029;
    L_0x0019:
        r0 = com.tencent.mm.ah.n.GS();
        r2 = r10.field_msgId;
        r0 = r0.aj(r2);
        r2 = r0.hEY;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0033;
    L_0x0029:
        r0 = com.tencent.mm.ah.n.GS();
        r2 = r10.field_msgSvrId;
        r0 = r0.ai(r2);
    L_0x0033:
        r2 = com.tencent.mm.kernel.h.vI();
        r2 = r2.isSDCardAvailable();
        if (r2 == 0) goto L_0x0081;
    L_0x003d:
        r2 = r10.field_isSend;
        if (r2 != r8) goto L_0x00a5;
    L_0x0041:
        r3 = com.tencent.mm.ah.e.c(r0);
        r2 = com.tencent.mm.ah.n.GS();
        r6 = "";
        r7 = "";
        r2 = r2.m(r3, r6, r7);
        if (r3 == 0) goto L_0x0063;
    L_0x0055:
        r3 = r3.length();
        if (r3 <= 0) goto L_0x0063;
    L_0x005b:
        r3 = com.tencent.mm.modelsfs.FileOp.aO(r2);
        if (r3 == 0) goto L_0x0063;
    L_0x0061:
        r0 = r2;
        goto L_0x0010;
    L_0x0063:
        r2 = r0.hEZ;
        r0 = com.tencent.mm.ah.n.GS();
        r3 = "";
        r6 = "";
        r0 = r0.m(r2, r3, r6);
        if (r2 == 0) goto L_0x0081;
    L_0x0075:
        r2 = r2.length();
        if (r2 <= 0) goto L_0x0081;
    L_0x007b:
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r0);
        if (r2 != 0) goto L_0x0010;
    L_0x0081:
        r0 = "MicroMsg.ImgInfoStorage";
        r2 = "getBigPicPath use time:%s";
        r3 = new java.lang.Object[r8];
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = java.lang.System.currentTimeMillis();
        r4 = r8 - r4;
        r4 = r7.append(r4);
        r4 = r4.toString();
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.w.d(r0, r2, r3);
        r0 = r1;
        goto L_0x0010;
    L_0x00a5:
        r2 = r0.GA();
        if (r2 == 0) goto L_0x0081;
    L_0x00ab:
        r1 = r0.hEZ;
        r2 = r0.GB();
        if (r2 == 0) goto L_0x00df;
    L_0x00b3:
        r0 = com.tencent.mm.ah.e.a(r0);
        if (r0 == 0) goto L_0x00df;
    L_0x00b9:
        r2 = r0.hEY;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x00df;
    L_0x00bf:
        r2 = r0.GA();
        if (r2 == 0) goto L_0x00df;
    L_0x00c5:
        r2 = com.tencent.mm.ah.n.GS();
        r3 = r0.hEZ;
        r4 = "";
        r5 = "";
        r2 = r2.m(r3, r4, r5);
        r2 = com.tencent.mm.modelsfs.FileOp.aO(r2);
        if (r2 == 0) goto L_0x00df;
    L_0x00db:
        r0 = r0.hEZ;
        goto L_0x0010;
    L_0x00df:
        r0 = r1;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ah.f.p(com.tencent.mm.storage.au):java.lang.String");
    }
}
