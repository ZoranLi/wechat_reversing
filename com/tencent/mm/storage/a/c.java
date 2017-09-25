package com.tencent.mm.storage.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.ao;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public final class c extends ao {
    public static int TYPE_TEXT = 4;
    protected static a gTP;
    public static final String kLB = File.separator;
    public static int uKP = -1;
    public static int uKT = 65;
    public static int uKU = 17;
    public static int uKV = 32;
    public static int uKW = 49;
    public static int uKX = 50;
    public static int uKY = 81;
    public static int uKZ = 1;
    public static int uLa = 2;
    public static int uLb = 3;
    public static int uLc = 10;
    public static int uLd = 11;
    public static int uLe = 0;
    public static int uLf = 1;
    public static int uLg = 3;
    public static int uLh = 4;
    public static int uLi = 8;
    public static int uLj = 0;
    public static int uLk = 1;
    public static int uLl = 0;
    public static int uLm = 1;
    public static int uLn = 1;
    public final String ozt;

    static {
        a aVar = new a();
        aVar.hXH = new Field[29];
        aVar.columns = new String[30];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5";
        aVar.uxd.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.uxc = "md5";
        aVar.columns[1] = "svrid";
        aVar.uxd.put("svrid", "TEXT");
        stringBuilder.append(" svrid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "catalog";
        aVar.uxd.put("catalog", "INTEGER");
        stringBuilder.append(" catalog INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "size";
        aVar.uxd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "start";
        aVar.uxd.put("start", "INTEGER");
        stringBuilder.append(" start INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "state";
        aVar.uxd.put("state", "INTEGER");
        stringBuilder.append(" state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "name";
        aVar.uxd.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "content";
        aVar.uxd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.uxd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.uxd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.uxd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.uxd.put("reserved4", "INTEGER");
        stringBuilder.append(" reserved4 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "app_id";
        aVar.uxd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId";
        aVar.uxd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastUseTime";
        aVar.uxd.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "framesInfo";
        aVar.uxd.put("framesInfo", "TEXT default '' ");
        stringBuilder.append(" framesInfo TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "idx";
        aVar.uxd.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "temp";
        aVar.uxd.put("temp", "INTEGER default '0' ");
        stringBuilder.append(" temp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "source";
        aVar.uxd.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "needupload";
        aVar.uxd.put("needupload", "INTEGER default '0' ");
        stringBuilder.append(" needupload INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "designerID";
        aVar.uxd.put("designerID", "TEXT");
        stringBuilder.append(" designerID TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "thumbUrl";
        aVar.uxd.put("thumbUrl", "TEXT");
        stringBuilder.append(" thumbUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "cdnUrl";
        aVar.uxd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "encrypturl";
        aVar.uxd.put("encrypturl", "TEXT");
        stringBuilder.append(" encrypturl TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "aeskey";
        aVar.uxd.put("aeskey", "TEXT");
        stringBuilder.append(" aeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "width";
        aVar.uxd.put("width", "INTEGER default '0' ");
        stringBuilder.append(" width INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[27] = "height";
        aVar.uxd.put("height", "INTEGER default '0' ");
        stringBuilder.append(" height INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "activityid";
        aVar.uxd.put("activityid", "TEXT");
        stringBuilder.append(" activityid TEXT");
        aVar.columns[29] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public c() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        this.ozt = stringBuilder.append(h.vI().gYf).append("emoji/").toString();
        reset();
    }

    public c(String str) {
        this.ozt = str;
        reset();
    }

    public final void reset() {
        this.field_md5 = "";
        this.field_svrid = "";
        this.field_catalog = uKU;
        this.field_type = uKZ;
        this.field_size = 0;
        this.field_start = 0;
        this.field_state = uLe;
        this.field_name = "";
        this.field_content = "";
        this.field_reserved1 = "";
        this.field_reserved2 = "";
        this.field_reserved3 = 0;
        this.field_reserved4 = 0;
        this.field_app_id = "";
        this.field_temp = 0;
    }

    public final byte[] dP(int i, int i2) {
        InputStream bc;
        Throwable e;
        String str;
        Throwable th;
        if (i < 0 || i2 < 0) {
            return null;
        }
        if (this.field_catalog == uKU || this.field_catalog == uKX || this.field_catalog == uKW) {
            try {
                w.d("MicroMsg.emoji.EmojiInfo", "get name %s", getName());
                bc = bc(ab.getContext(), getName());
                try {
                    bc.skip((long) i);
                    byte[] bArr = new byte[i2];
                    bc.read(bArr, 0, i2);
                    if (bc == null) {
                        return bArr;
                    }
                    try {
                        bc.close();
                        return bArr;
                    } catch (Throwable e2) {
                        w.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bg.g(e2));
                        return bArr;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        w.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bg.g(e));
                        if (bc != null) {
                            try {
                                bc.close();
                            } catch (Throwable e4) {
                                w.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bg.g(e4));
                            }
                        }
                        str = this.ozt + EP();
                        if (bNv()) {
                            str = this.ozt + this.field_groupId + File.separator + EP();
                        }
                        return e.c(str, this.field_start, i2);
                    } catch (Throwable th2) {
                        e4 = th2;
                        if (bc != null) {
                            try {
                                bc.close();
                            } catch (Throwable e22) {
                                w.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bg.g(e22));
                            }
                        }
                        throw e4;
                    }
                }
            } catch (Throwable e222) {
                th = e222;
                bc = null;
                e4 = th;
                w.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bg.g(e4));
                if (bc != null) {
                    bc.close();
                }
                str = this.ozt + EP();
                if (bNv()) {
                    str = this.ozt + this.field_groupId + File.separator + EP();
                }
                return e.c(str, this.field_start, i2);
            } catch (Throwable e2222) {
                th = e2222;
                bc = null;
                e4 = th;
                if (bc != null) {
                    bc.close();
                }
                throw e4;
            }
        }
        str = this.ozt + EP();
        if (bNv()) {
            str = this.ozt + this.field_groupId + File.separator + EP();
        }
        return e.c(str, this.field_start, i2);
    }

    public final boolean bNr() {
        if (this.field_catalog == uKU || this.field_catalog == uKX || this.field_catalog == uKW) {
            return true;
        }
        File file;
        if (bg.mA(this.field_groupId)) {
            file = new File(this.ozt + EP());
        } else {
            file = new File(this.ozt + this.field_groupId + File.separator + EP());
        }
        return file.exists() && file.length() > 0;
    }

    public final void bNs() {
        if (this.field_catalog != uKU && this.field_catalog != uKX && this.field_catalog != uKW) {
            File file;
            if (bg.mA(this.field_groupId)) {
                file = new File(this.ozt + EP());
            } else {
                file = new File(this.ozt + this.field_groupId + File.separator + EP());
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static InputStream bc(Context context, String str) {
        InputStream inputStream = null;
        if (!(context == null || bg.mA(str))) {
            try {
                w.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", str.split("\\.")[0]);
                inputStream = context.getResources().openRawResource(context.getResources().getIdentifier(r1, "drawable", context.getPackageName()));
            } catch (Exception e) {
                w.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", e.getMessage());
            }
        }
        return inputStream;
    }

    public final synchronized Bitmap ew(Context context) {
        return ex(context);
    }

    public final synchronized android.graphics.Bitmap ex(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.storage.a.c.ex(android.content.Context):android.graphics.Bitmap. bs: [B:70:0x0102, B:102:0x01b9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r5 = 19;
        r1 = 0;
        monitor-enter(r9);
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        com.tencent.mm.bg.a.fromDPToPix(r10, r0);	 Catch:{ all -> 0x0062 }
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = uKU;	 Catch:{ all -> 0x0062 }
        if (r0 == r2) goto L_0x0021;	 Catch:{ all -> 0x0062 }
    L_0x000f:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = com.tencent.mm.storage.a.a.uKR;	 Catch:{ all -> 0x0062 }
        if (r0 == r2) goto L_0x0021;	 Catch:{ all -> 0x0062 }
    L_0x0015:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = uKX;	 Catch:{ all -> 0x0062 }
        if (r0 == r2) goto L_0x0021;	 Catch:{ all -> 0x0062 }
    L_0x001b:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0062 }
        r2 = uKW;	 Catch:{ all -> 0x0062 }
        if (r0 != r2) goto L_0x00b5;
    L_0x0021:
        r0 = r9.getName();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r2 = r9.field_type;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r3 = uLa;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        if (r2 != r3) goto L_0x0039;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
    L_0x002b:
        r0 = r9.pM();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        if (r0 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
    L_0x0035:
        r0 = r9.getName();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
    L_0x0039:
        r2 = bc(r10, r0);	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        r0 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ Exception -> 0x030e }
        if (r2 == 0) goto L_0x0046;
    L_0x0043:
        r2.close();	 Catch:{ IOException -> 0x004d }
    L_0x0046:
        monitor-exit(r9);
        return r0;
    L_0x0048:
        r0 = r9.pM();	 Catch:{ Exception -> 0x0065, all -> 0x0097 }
        goto L_0x0039;
    L_0x004d:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0065:
        r0 = move-exception;
        r2 = r1;
    L_0x0067:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x030a }
        r4 = "exception:%s";	 Catch:{ all -> 0x030a }
        r5 = 1;	 Catch:{ all -> 0x030a }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x030a }
        r6 = 0;	 Catch:{ all -> 0x030a }
        r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ all -> 0x030a }
        r5[r6] = r0;	 Catch:{ all -> 0x030a }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x030a }
        if (r2 == 0) goto L_0x00b3;
    L_0x007c:
        r2.close();	 Catch:{ IOException -> 0x0081 }
        r0 = r1;
        goto L_0x0046;
    L_0x0081:
        r0 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ all -> 0x0062 }
        r4[r5] = r0;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        r0 = r1;
        goto L_0x0046;
    L_0x0097:
        r0 = move-exception;
    L_0x0098:
        if (r1 == 0) goto L_0x009d;
    L_0x009a:
        r1.close();	 Catch:{ IOException -> 0x009e }
    L_0x009d:
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x009e:
        r1 = move-exception;	 Catch:{ all -> 0x0062 }
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x009d;
    L_0x00b3:
        r0 = r1;
        goto L_0x0046;
    L_0x00b5:
        r0 = r9.bNv();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        if (r0 == 0) goto L_0x0124;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x00bb:
        r0 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r9.eN(r0, r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        if (r0 != 0) goto L_0x0314;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x00c7:
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = "_0";	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r0;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x00f2:
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x00f7:
        r2 = r0.exists();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        if (r2 == 0) goto L_0x0187;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x00fd:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f2, all -> 0x02e6 }
        r1 = r2;
    L_0x0107:
        if (r1 == 0) goto L_0x0046;
    L_0x0109:
        r1.close();	 Catch:{ IOException -> 0x010e }
        goto L_0x0046;
    L_0x010e:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x0124:
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = "_thumb";	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        goto L_0x00f7;
    L_0x0148:
        r0 = move-exception;
        r2 = r1;
        r8 = r0;
        r0 = r1;
        r1 = r8;
    L_0x014d:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02ef }
        r4 = "exception:%s";	 Catch:{ all -> 0x02ef }
        r5 = 1;	 Catch:{ all -> 0x02ef }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02ef }
        r6 = 0;	 Catch:{ all -> 0x02ef }
        r7 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x02ef }
        r5[r6] = r7;	 Catch:{ all -> 0x02ef }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x02ef }
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02ef }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02ef }
        com.tencent.mm.sdk.platformtools.w.e(r3, r1);	 Catch:{ all -> 0x02ef }
        if (r2 == 0) goto L_0x0046;
    L_0x016c:
        r2.close();	 Catch:{ IOException -> 0x0171 }
        goto L_0x0046;
    L_0x0171:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x0187:
        r0 = r9.bNv();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        if (r0 == 0) goto L_0x023d;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x018d:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        if (r0 >= r5) goto L_0x0311;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
    L_0x0191:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r1 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f2, all -> 0x02e9 }
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x01c0:
        r0 = r9.bNv();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        if (r0 == 0) goto L_0x0262;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
    L_0x01c6:
        r0 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = "cpan emojiinfo save cover.";	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        com.tencent.mm.sdk.platformtools.w.d(r0, r3);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = "_cover";	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r0 = r0.exists();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        if (r0 != 0) goto L_0x023a;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
    L_0x0204:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        if (r0 >= r5) goto L_0x023a;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
    L_0x0208:
        r0 = 100;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = "_cover";	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = 0;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        com.tencent.mm.sdk.platformtools.d.a(r2, r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
    L_0x023a:
        r0 = r2;
        goto L_0x0107;
    L_0x023d:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r3 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.append(r3);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0148, Exception -> 0x028b, all -> 0x02ca }
        r1 = com.tencent.mm.sdk.platformtools.d.decodeStream(r2);	 Catch:{ FileNotFoundException -> 0x02fd, Exception -> 0x02f2, all -> 0x02ec }
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x01c0;
    L_0x0262:
        r0 = 100;
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = r9.ozt;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = r9.EP();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = "_thumb";	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r5 = 0;	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        com.tencent.mm.sdk.platformtools.d.a(r2, r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x0303, Exception -> 0x02f7, all -> 0x02ca }
        r0 = r2;
        goto L_0x0107;
    L_0x028b:
        r0 = move-exception;
        r2 = r1;
        r8 = r0;
        r0 = r1;
        r1 = r8;
    L_0x0290:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02ef }
        r4 = "exception:%s";	 Catch:{ all -> 0x02ef }
        r5 = 1;	 Catch:{ all -> 0x02ef }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02ef }
        r6 = 0;	 Catch:{ all -> 0x02ef }
        r7 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x02ef }
        r5[r6] = r7;	 Catch:{ all -> 0x02ef }
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);	 Catch:{ all -> 0x02ef }
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02ef }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02ef }
        com.tencent.mm.sdk.platformtools.w.e(r3, r1);	 Catch:{ all -> 0x02ef }
        if (r2 == 0) goto L_0x0046;
    L_0x02af:
        r2.close();	 Catch:{ IOException -> 0x02b4 }
        goto L_0x0046;
    L_0x02b4:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x0046;
    L_0x02ca:
        r0 = move-exception;
    L_0x02cb:
        if (r1 == 0) goto L_0x02d0;
    L_0x02cd:
        r1.close();	 Catch:{ IOException -> 0x02d1 }
    L_0x02d0:
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x02d1:
        r1 = move-exception;	 Catch:{ all -> 0x0062 }
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0062 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0062 }
        r4 = 1;	 Catch:{ all -> 0x0062 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0062 }
        r5 = 0;	 Catch:{ all -> 0x0062 }
        r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x0062 }
        r4[r5] = r1;	 Catch:{ all -> 0x0062 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0062 }
        goto L_0x02d0;
    L_0x02e6:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02cb;
    L_0x02e9:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02cb;
    L_0x02ec:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02cb;
    L_0x02ef:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02cb;
    L_0x02f2:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x0290;
    L_0x02f7:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0290;
    L_0x02fd:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x014d;
    L_0x0303:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x014d;
    L_0x030a:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0098;
    L_0x030e:
        r0 = move-exception;
        goto L_0x0067;
    L_0x0311:
        r2 = r1;
        goto L_0x01c0;
    L_0x0314:
        r2 = r0;
        goto L_0x00f2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.c.ex(android.content.Context):android.graphics.Bitmap");
    }

    public final boolean bCU() {
        return this.field_catalog == uKX || this.field_catalog == uKW;
    }

    public final boolean bNt() {
        return this.field_catalog == uKU || this.field_catalog == uKX || this.field_catalog == uKW;
    }

    public final boolean bNu() {
        return this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    }

    public final boolean isGif() {
        return this.field_type == uLa || this.field_type == uLc;
    }

    public static boolean yI(int i) {
        return i == uKX || i == uKW;
    }

    public final boolean bNv() {
        if (!bg.mA(this.field_app_id) || bg.mA(this.field_groupId) || this.field_groupId.equals(String.valueOf(a.uKR)) || this.field_groupId.equals(String.valueOf(a.uKQ)) || this.field_groupId.equals(String.valueOf(a.uKS)) || this.field_groupId.equals(String.valueOf(uKT))) {
            return false;
        }
        return true;
    }

    public final void iY(String str) {
        this.field_md5 = str;
    }

    public final String EP() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    public final boolean bNw() {
        return EP().length() == 32;
    }

    public final void yJ(int i) {
        this.field_catalog = i;
    }

    public final void setType(int i) {
        this.field_type = i;
    }

    public final void setSize(int i) {
        this.field_size = i;
    }

    public final String getName() {
        return this.field_name == null ? "" : this.field_name;
    }

    public final String pM() {
        return this.field_content == null ? "" : this.field_content;
    }

    public final void yK(int i) {
        this.field_temp = 1;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean bNx() {
        if (this.field_catalog == uKU || this.field_catalog == a.uKR || this.field_catalog == uKX || this.field_catalog == uKW) {
            return true;
        }
        File file;
        if (bNv()) {
            String eN = eN(this.field_groupId, EP());
            if (eN == null) {
                eN = this.ozt + this.field_groupId + File.separator + EP();
            }
            file = new File(eN);
        } else {
            file = new File(this.ozt + EP());
        }
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public final String eN(String str, String str2) {
        if (bg.mA(str) && bg.mA(str2)) {
            w.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. productid and md5 are null.");
            return null;
        } else if (bg.mA(str2)) {
            return null;
        } else {
            if (bg.mA(str)) {
                return this.ozt + str2;
            }
            return this.ozt + str + kLB + str2;
        }
    }

    public final boolean equals(Object obj) {
        return bA(obj);
    }

    public final boolean bA(Object obj) {
        if (obj != null && (obj instanceof c) && ((c) obj).EP().equalsIgnoreCase(this.field_md5)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_md5:").append(this.field_md5).append("\n");
        stringBuilder.append("field_svrid:").append(this.field_svrid).append("\n");
        stringBuilder.append("field_catalog:").append(this.field_catalog).append("\n");
        stringBuilder.append("field_type:").append(this.field_type).append("\n");
        stringBuilder.append("field_size:").append(this.field_size).append("\n");
        stringBuilder.append("field_start:").append(this.field_start).append("\n");
        stringBuilder.append("field_state:").append(this.field_state).append("\n");
        stringBuilder.append("field_name:").append(this.field_name).append("\n");
        stringBuilder.append("field_content:").append(this.field_content).append("\n");
        stringBuilder.append("field_reserved1:").append(this.field_reserved1).append("\n");
        stringBuilder.append("field_reserved2:").append(this.field_reserved2).append("\n");
        stringBuilder.append("field_reserved3:").append(this.field_reserved3).append("\n");
        stringBuilder.append("field_reserved4:").append(this.field_reserved4).append("\n");
        stringBuilder.append("field_app_id:").append(this.field_app_id).append("\n");
        stringBuilder.append("field_groupId:").append(this.field_groupId).append("\n");
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        stringBuilder.append("field_framesInfo:").append(this.field_framesInfo).append("\n");
        stringBuilder.append("field_idx:").append(this.field_idx).append("\n");
        stringBuilder.append("field_temp:").append(this.field_temp).append("\n");
        stringBuilder.append("field_source:").append(this.field_source).append("\n");
        stringBuilder.append("field_needupload:").append(this.field_needupload).append("\n");
        stringBuilder.append("field_designerID:").append(this.field_designerID).append("\n");
        stringBuilder.append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
        return stringBuilder.toString();
    }
}
