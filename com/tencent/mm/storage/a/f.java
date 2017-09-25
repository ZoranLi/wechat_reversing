package com.tencent.mm.storage.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.emoji.d;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class f extends i<c> implements a {
    public static final String[] gUx = new String[]{i.a(c.gTP, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )"};
    private static int[] uLp = new int[]{2, 4, 8};
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return s((c) cVar);
    }

    public f(e eVar) {
        super(eVar, c.gTP, "EmojiInfo", null);
        this.gUz = eVar;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    public final int a(com.tencent.mm.bj.f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final boolean eu(Context context) {
        w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        c Si = Si("86cb157e9c44b2c9934e4e430790776d");
        c Si2 = Si("68f9864ca5c0a5d823ed7184e113a4aa");
        w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", Integer.valueOf(yL(c.uKV)));
        if (Si != null || ((Si2 != null && Si2.pM().length() == 0) || r2 <= 2)) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            yN(c.uKU);
            yN(c.uKX);
            yN(c.uKW);
        }
        Si = Si("9bd1281af3a31710a45b84d736363691");
        if (Si != null && Si.field_catalog == c.uKU) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            yN(c.uKU);
            yN(c.uKX);
            yN(c.uKW);
        }
        InputStream bc = c.bc(context, "icon_002_cover.png");
        if (bc != null) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            yN(c.uKU);
            yN(c.uKX);
            yN(c.uKW);
        }
        if (bc != null) {
            try {
                bc.close();
            } catch (Exception e) {
            }
        }
        if (yL(c.uKU) != 0) {
            return true;
        }
        InputStream inputStream = null;
        try {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<c> a = a(new InputStream[]{inputStream});
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                g gVar;
                currentTimeMillis = -1;
                if (this.gUz instanceof g) {
                    g gVar2 = (g) this.gUz;
                    currentTimeMillis = gVar2.cs(Thread.currentThread().getId());
                    gVar = gVar2;
                } else {
                    gVar = null;
                }
                for (c Si3 : a) {
                    if (this.gUz.replace("EmojiInfo", "md5", Si3.pv()) < 0) {
                        if (gVar != null) {
                            gVar.aD(currentTimeMillis);
                        }
                    }
                }
                if (gVar != null) {
                    gVar.aD(currentTimeMillis);
                }
            }
            w.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            w.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e2));
                }
            }
        } catch (IOException e3) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e22));
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e4) {
                    w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e4));
                }
            }
        }
        return true;
    }

    public final c r(c cVar) {
        if (bg.mA(cVar.EP()) || cVar.EP().length() <= 0) {
            w.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        } else if (!s(cVar)) {
            return null;
        } else {
            Qr("create_emoji_info_notify");
            return cVar;
        }
    }

    public final c b(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, str3, 1);
    }

    public final c c(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, str3, 1);
    }

    public final c a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        return a(str, str2, i, i2, i3, null, str3, str4, 1);
    }

    private c a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, int i4) {
        if (str == null || str.length() <= 0) {
            w.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        }
        c cVar;
        if (str == null || str.length() <= 0) {
            w.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            cVar = null;
        } else {
            cVar = Si(str);
            if (cVar == null) {
                d.akT();
                cVar = new c(d.akU());
                cVar.field_catalog = i;
            }
            cVar.field_md5 = str;
            cVar.field_svrid = str2;
            cVar.field_type = i2;
            cVar.field_size = i3;
            cVar.field_state = c.uLe;
            cVar.field_reserved1 = null;
            cVar.field_reserved2 = null;
            cVar.field_app_id = str4;
            cVar.field_temp = 1;
            cVar.field_reserved4 = 0;
            if (!TextUtils.isEmpty(str5)) {
                cVar.field_groupId = str5;
            }
        }
        cVar.field_state = c.uLg;
        if (!s(cVar)) {
            return null;
        }
        Qr("create_emoji_info_notify");
        return cVar;
    }

    public final boolean s(c cVar) {
        if (cVar == null || !cVar.bNw()) {
            w.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        long replace = this.gUz.replace("EmojiInfo", "md5", cVar.pv());
        if (replace != -1) {
            Qr(cVar.EP());
        }
        if (replace >= 0) {
            return true;
        }
        return false;
    }

    public final boolean t(c cVar) {
        if (cVar == null || !cVar.bNw()) {
            w.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        int update = this.gUz.update("EmojiInfo", cVar.pv(), "md5=?", new String[]{cVar.EP()});
        if (update > 0) {
            Qr(cVar.EP());
            Qr("event_update_emoji");
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean u(c cVar) {
        if (cVar == null || !cVar.bNw()) {
            w.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        if (this.gUz.update("EmojiInfo", cVar.pv(), "md5=?", new String[]{cVar.EP()}) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.a.c Si(java.lang.String r12) {
        /*
        r11 = this;
        r2 = 1;
        r3 = 0;
        r9 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r12);
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = r12.length();
        r1 = 32;
        if (r0 == r1) goto L_0x0020;
    L_0x0011:
        r0 = "MicroMsg.emoji.EmojiInfoStorage";
        r1 = "md5 is null or invalue. md5:%s";
        r2 = new java.lang.Object[r2];
        r2[r3] = r12;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r9;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = r11.gUz;	 Catch:{ Exception -> 0x0055 }
        r1 = "EmojiInfo";
        r2 = 0;
        r3 = "md5=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0055 }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ Exception -> 0x0055 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 2;
        r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0055 }
        if (r1 == 0) goto L_0x0086;
    L_0x0039:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        if (r0 == 0) goto L_0x0086;
    L_0x003f:
        r2 = new com.tencent.mm.storage.a.c;	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        com.tencent.mm.plugin.emoji.d.akT();	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        r0 = com.tencent.mm.plugin.emoji.d.akU();	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x007b, all -> 0x0078 }
        r2.b(r1);	 Catch:{ Exception -> 0x0081, all -> 0x0078 }
        r0 = r2;
    L_0x004f:
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1.close();
        goto L_0x001f;
    L_0x0055:
        r0 = move-exception;
        r1 = r0;
        r0 = r9;
    L_0x0058:
        r2 = "MicroMsg.emoji.EmojiInfoStorage";
        r3 = "[getByMd5]Exception:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0071 }
        r5 = 0;
        r1 = r1.toString();	 Catch:{ all -> 0x0071 }
        r4[r5] = r1;	 Catch:{ all -> 0x0071 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0071 }
        if (r9 == 0) goto L_0x001f;
    L_0x006d:
        r9.close();
        goto L_0x001f;
    L_0x0071:
        r0 = move-exception;
    L_0x0072:
        if (r9 == 0) goto L_0x0077;
    L_0x0074:
        r9.close();
    L_0x0077:
        throw r0;
    L_0x0078:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0072;
    L_0x007b:
        r0 = move-exception;
        r10 = r0;
        r0 = r9;
        r9 = r1;
        r1 = r10;
        goto L_0x0058;
    L_0x0081:
        r0 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x0058;
    L_0x0086:
        r0 = r9;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.f.Si(java.lang.String):com.tencent.mm.storage.a.c");
    }

    private int yL(int i) {
        int i2 = 0;
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), "0"}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e));
            w.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i2;
    }

    public final int Se(String str) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e));
            w.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        w.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return i;
    }

    public final int jZ(boolean z) {
        int i = 0;
        Cursor cursor = null;
        String str = "select count(*)  from EmojiInfo where catalog=? ";
        String[] strArr = new String[]{a.uKS};
        if (z) {
            str = "select  count(*) from EmojiInfo where catalog=?  or catalog=?";
            strArr = new String[]{String.valueOf(a.uKR), String.valueOf(a.uKS)};
        }
        try {
            cursor = this.gUz.a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e));
            w.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final List<c> bNy() {
        List<c> arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(a.uKR), String.valueOf(a.uKS), String.valueOf(c.uLh)};
        Cursor a = this.gUz.a("select  * from EmojiInfo where catalog=?  or catalog=? and state!=? order by reserved3 asc", strArr, 2);
        if (a.moveToFirst()) {
            do {
                d.akT();
                c cVar = new c(d.akU());
                cVar.b(a);
                arrayList.add(cVar);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public final List<String> bNz() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select md5 from EmojiInfo where catalog=?  order by reserved3 asc", new String[]{a.uKS}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", bg.g(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<String> bNA() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select md5 from EmojiInfo where catalog=? and source=?", new String[]{a.uKS, c.uLk}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", bg.g(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor yM(int i) {
        return this.gUz.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), "0"}, null, null, null);
    }

    private boolean yN(int i) {
        if (this.gUz.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(Context context, c cVar) {
        int available;
        if (cVar.field_catalog == c.uKU || cVar.field_catalog == c.uKX || cVar.field_catalog == c.uKW) {
            InputStream inputStream = null;
            try {
                inputStream = c.bc(context, cVar.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e));
                    }
                }
            } catch (Throwable e2) {
                w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (Throwable e22) {
                        w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e22));
                        available = 0;
                    }
                } else {
                    available = 0;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        w.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", bg.g(e3));
                    }
                }
            }
        } else {
            available = com.tencent.mm.a.e.aN(cVar.ozt + cVar.EP());
        }
        if (available != 0 && available != cVar.field_size) {
            cVar.field_size = available;
            t(cVar);
        }
    }

    private static List<c> a(InputStream[] inputStreamArr) {
        List<c> arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i = 0; i <= 0; i++) {
                InputStream inputStream = inputStreamArr[i];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        Element element = (Element) elementsByTagName.item(i2);
                        int intValue = Integer.decode(element.getAttribute(SlookAirButtonFrequentContactAdapter.ID)).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                            d.akT();
                            c cVar = new c(d.akU());
                            element = (Element) elementsByTagName2.item(i3);
                            cVar.field_md5 = element.getAttribute("md5");
                            if (cVar.bNw()) {
                                String str;
                                cVar.field_catalog = intValue;
                                cVar.field_groupId = String.valueOf(intValue);
                                cVar.field_name = element.getAttribute("name");
                                cVar.field_type = Integer.decode(element.getAttribute(Columns.TYPE)).intValue();
                                Node firstChild = element.getFirstChild();
                                String data = firstChild instanceof CharacterData ? ((CharacterData) firstChild).getData() : "";
                                if (cVar.field_type == c.TYPE_TEXT) {
                                    str = new String(Base64.decode(data, 0));
                                } else {
                                    str = data;
                                }
                                cVar.field_content = str;
                                arrayList.add(cVar);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.a.c Sj(java.lang.String r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 2;
        r0 = "select * from EmojiInfo where +groupId = ? and temp=? limit 1 ";
        r1 = new java.lang.String[r1];
        r3 = 0;
        r1[r3] = r8;
        r3 = 1;
        r4 = "0";
        r1[r3] = r4;
        r3 = r7.gUz;	 Catch:{ Exception -> 0x0033 }
        r4 = 2;
        r1 = r3.a(r0, r1, r4);	 Catch:{ Exception -> 0x0033 }
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        if (r0 == 0) goto L_0x006b;
    L_0x001d:
        r3 = new com.tencent.mm.storage.a.c;	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        com.tencent.mm.plugin.emoji.d.akT();	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r0 = com.tencent.mm.plugin.emoji.d.akU();	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r3.b(r1);	 Catch:{ Exception -> 0x0066, all -> 0x005d }
        r0 = r3;
    L_0x002d:
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();
    L_0x0032:
        return r0;
    L_0x0033:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0036:
        r3 = "MicroMsg.emoji.EmojiInfoStorage";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0056 }
        r5 = "getFirstEmojiByGroupId fail.";
        r4.<init>(r5);	 Catch:{ all -> 0x0056 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0056 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0056 }
        r1 = r1.toString();	 Catch:{ all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r1);	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x0032;
    L_0x0052:
        r2.close();
        goto L_0x0032;
    L_0x0056:
        r0 = move-exception;
    L_0x0057:
        if (r2 == 0) goto L_0x005c;
    L_0x0059:
        r2.close();
    L_0x005c:
        throw r0;
    L_0x005d:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0057;
    L_0x0060:
        r0 = move-exception;
        r6 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0036;
    L_0x0066:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0036;
    L_0x006b:
        r0 = r2;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.f.Sj(java.lang.String):com.tencent.mm.storage.a.c");
    }

    public final List<c> ud(String str) {
        List<c> arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.gUz.a(str2, new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                d.akT();
                c cVar = new c(d.akU());
                cVar.b(cursor);
                arrayList.add(cVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            w.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean co(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("catalog");
        stringBuilder.append("=");
        stringBuilder.append(c.uKT);
        stringBuilder.append(",");
        stringBuilder.append("source");
        stringBuilder.append("=");
        stringBuilder.append(c.uLj);
        stringBuilder.append(",");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(c.uLl);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append("'" + ((String) list.get(i)) + "'");
            if (i < list.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        w.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.gUz.eE("EmojiInfo", stringBuilder.toString())) {
            Qr("delete_emoji_info_notify");
        }
        return true;
    }

    public final boolean cp(List<String> list) {
        w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            return false;
        }
        long cs;
        g gVar;
        List<String> bNz = bNz();
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        int i = 1;
        for (String str : list) {
            c Si = Si(str);
            if (!(Si == null || bg.mA(Si.EP()))) {
                Si.field_reserved3 = i;
                if (!bNz.isEmpty()) {
                    bNz.remove(str);
                }
                i++;
                if (this.gUz.replace("EmojiInfo", "md5", Si.pv()) < 0) {
                    if (gVar != null) {
                        gVar.aD(cs);
                    }
                    w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            }
            i = i;
        }
        if (!bNz.isEmpty()) {
            for (String str2 : bNz) {
                c Si2 = Si(str2);
                if (!(Si2 == null || bg.mA(Si2.EP()))) {
                    Si2.field_reserved3 = i;
                    i++;
                    if (this.gUz.replace("EmojiInfo", "md5", Si2.pv()) < 0) {
                        if (gVar != null) {
                            gVar.aD(cs);
                        }
                        w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return false;
                    }
                }
            }
        }
        if (gVar != null) {
            gVar.aD(cs);
        }
        String str3 = "MicroMsg.emoji.EmojiInfoStorage";
        String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
        w.i(str3, str4, objArr);
        return true;
    }

    public final boolean j(List<c> list, String str) {
        if (list.size() <= 0) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            return false;
        }
        long cs;
        g gVar;
        c cVar;
        w.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", str, Integer.valueOf(list.size()));
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        List<c> ud = ud(str);
        Map hashMap = new HashMap();
        for (c cVar2 : ud) {
            hashMap.put(cVar2.EP(), cVar2);
        }
        for (int i = 0; i < list.size(); i++) {
            cVar2 = (c) list.get(i);
            cVar2.field_temp = 0;
            this.gUz.replace("EmojiInfo", "md5", cVar2.pv());
            hashMap.remove(cVar2.EP());
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            cVar2 = (c) entry.getValue();
            cVar2.field_temp = 1;
            this.gUz.update("EmojiInfo", cVar2.pv(), "md5=?", new String[]{str2});
            w.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", cVar2.field_groupId);
        }
        if (gVar != null) {
            gVar.aD(cs);
        }
        return true;
    }

    public final boolean Sk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.gUz.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            return false;
        }
    }

    public final List<String> bNB() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", bg.g(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int bNC() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.gUz.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getCount();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", bg.g(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final boolean ax(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            return false;
        }
        w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", Integer.valueOf(linkedList.size()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(c.uLm);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append("'" + ((String) linkedList.get(i)) + "'");
            if (i < linkedList.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        w.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        return this.gUz.eE("EmojiInfo", stringBuilder.toString());
    }

    public final ArrayList<String> bND() {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(c.uLm), String.valueOf(a.uKS)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", bg.g(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int bNE() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(a.uKS)}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", bg.g(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final ArrayList<c> bNF() {
        Cursor a;
        Throwable e;
        try {
            a = this.gUz.a("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(a.uKS), String.valueOf(a.uKT)}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ArrayList<c> arrayList = new ArrayList();
                        do {
                            c cVar = new c();
                            cVar.b(a);
                            if ((cVar.field_reserved4 & c.uLn) != c.uLn) {
                                arrayList.add(cVar);
                            }
                        } while (a.moveToNext());
                        if (a == null) {
                            return arrayList;
                        }
                        a.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", bg.g(e));
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", bg.g(e));
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return null;
    }

    public final String getKey() {
        Cursor a;
        String string;
        Throwable e;
        c cVar;
        try {
            a = this.gUz.a("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        string = a.getString(0);
                        w.i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + bg.Qj(string));
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", bg.g(e));
                        if (a != null) {
                            a.close();
                        }
                        string = bg.em(ab.getContext());
                        if (bg.mA(string)) {
                            string = com.tencent.mm.a.g.n("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
                        } else {
                            string = com.tencent.mm.a.g.n(string.getBytes());
                        }
                        w.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bg.Qj(string));
                        cVar = new c();
                        cVar.field_md5 = string;
                        cVar.field_catalog = 153;
                        if (s(cVar)) {
                            return string;
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", bg.g(e));
            if (a != null) {
                a.close();
            }
            string = bg.em(ab.getContext());
            if (bg.mA(string)) {
                string = com.tencent.mm.a.g.n("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
            } else {
                string = com.tencent.mm.a.g.n(string.getBytes());
            }
            w.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bg.Qj(string));
            cVar = new c();
            cVar.field_md5 = string;
            cVar.field_catalog = 153;
            if (s(cVar)) {
                return string;
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        string = bg.em(ab.getContext());
        if (bg.mA(string)) {
            string = com.tencent.mm.a.g.n(string.getBytes());
        } else {
            string = com.tencent.mm.a.g.n("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
        }
        w.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bg.Qj(string));
        cVar = new c();
        cVar.field_md5 = string;
        cVar.field_catalog = 153;
        if (s(cVar)) {
            return null;
        }
        return string;
    }

    public final boolean cq(List<ov> list) {
        int i = 0;
        if (list == null || list.isEmpty()) {
            w.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            return false;
        }
        long cs;
        g gVar;
        w.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", Integer.valueOf(list.size()));
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            w.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", Long.valueOf(cs));
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        while (i < list.size()) {
            ov ovVar = (ov) list.get(i);
            c Si = Si(ovVar.tup);
            if (Si == null) {
                Si = new c();
                Si.field_md5 = ovVar.tup;
                Si.field_catalog = c.uKT;
                w.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            Si.field_cdnUrl = ovVar.msN;
            Si.field_encrypturl = ovVar.tur;
            Si.field_aeskey = ovVar.tus;
            Si.field_designerID = ovVar.tuq;
            Si.field_thumbUrl = ovVar.ohq;
            Si.field_groupId = ovVar.tgW;
            t(Si);
            i++;
        }
        if (gVar != null) {
            gVar.aD(cs);
            w.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        return true;
    }
}
