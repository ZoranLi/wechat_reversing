package com.tencent.mm.storage.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ak;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class b extends i<a> implements a {
    public static final String[] gUx = new String[]{i.a(a.gTP, "EmojiGroupInfo")};
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return c((a) cVar);
    }

    public b(e eVar) {
        super(eVar, a.gTP, "EmojiGroupInfo", null);
        this.gUz = eVar;
    }

    public final String getTableName() {
        return "EmojiGroupInfo";
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final boolean eu(Context context) {
        w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
        ev(context);
        w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
        return true;
    }

    private ArrayList<a> ev(Context context) {
        InputStream inputStream = null;
        Object arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                a aVar = new a();
                Element element = (Element) elementsByTagName.item(i);
                int intValue = Integer.decode(element.getAttribute(SlookAirButtonFrequentContactAdapter.ID)).intValue();
                if (!TextUtils.isEmpty(element.getAttribute("sort"))) {
                    w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", Integer.valueOf(intValue), Integer.decode(element.getAttribute("sort")));
                    int i2 = a.uKR;
                    if ((intValue & i2) == i2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0 || (bMY() <= 0 && !bNg())) {
                        aVar.field_sort = i + 1;
                    } else {
                        aVar.field_sort = -1;
                        h.vI().vr().set(208912, Boolean.valueOf(true));
                        w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
                    }
                }
                aVar.field_productID = String.valueOf(intValue);
                aVar.field_packName = element.getAttribute("name");
                if (!TextUtils.isEmpty(element.getAttribute(Columns.TYPE))) {
                    aVar.field_type = Integer.decode(element.getAttribute(Columns.TYPE)).intValue();
                }
                if (!TextUtils.isEmpty(element.getAttribute("free"))) {
                    aVar.field_packType = Integer.decode(element.getAttribute("free")).intValue();
                }
                if (aVar.field_type == a.TYPE_SYSTEM || aVar.field_type == a.TYPE_CUSTOM) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                cn(arrayList);
            }
            w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", bg.g(e2));
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e22, "", new Object[0]);
                }
            }
        } catch (Throwable e222) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", bg.g(e222));
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + e222.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2222) {
                    w.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e2222, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e3, "", new Object[0]);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.a.a aP(java.lang.String r9, boolean r10) {
        /*
        r8 = this;
        r1 = 0;
        r0 = "select * from EmojiGroupInfo where productID= ?";
        r2 = r8.gUz;	 Catch:{ Exception -> 0x0033, all -> 0x0062 }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0033, all -> 0x0062 }
        r4 = 0;
        r3[r4] = r9;	 Catch:{ Exception -> 0x0033, all -> 0x0062 }
        r4 = 2;
        r3 = r2.a(r0, r3, r4);	 Catch:{ Exception -> 0x0033, all -> 0x0062 }
        if (r3 == 0) goto L_0x0027;
    L_0x0013:
        r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x0075, all -> 0x0070 }
        if (r0 == 0) goto L_0x0027;
    L_0x0019:
        r0 = new com.tencent.mm.storage.a.a;	 Catch:{ Exception -> 0x0075, all -> 0x0070 }
        r0.<init>();	 Catch:{ Exception -> 0x0075, all -> 0x0070 }
        r0.b(r3);	 Catch:{ Exception -> 0x0079, all -> 0x0070 }
        if (r3 == 0) goto L_0x0026;
    L_0x0023:
        r3.close();
    L_0x0026:
        return r0;
    L_0x0027:
        if (r3 == 0) goto L_0x0081;
    L_0x0029:
        r3.close();
        r0 = r1;
    L_0x002d:
        if (r0 != 0) goto L_0x0026;
    L_0x002f:
        if (r10 == 0) goto L_0x006a;
    L_0x0031:
        r0 = r1;
        goto L_0x0026;
    L_0x0033:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0036:
        r4 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0073 }
        r6 = "get getEmojiGroupInof fail. product id is";
        r5.<init>(r6);	 Catch:{ all -> 0x0073 }
        r5 = r5.append(r9);	 Catch:{ all -> 0x0073 }
        r6 = " ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0073 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0073 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0073 }
        r0 = r0.toString();	 Catch:{ all -> 0x0073 }
        com.tencent.mm.sdk.platformtools.w.e(r4, r0);	 Catch:{ all -> 0x0073 }
        if (r2 == 0) goto L_0x007f;
    L_0x005d:
        r2.close();
        r0 = r3;
        goto L_0x002d;
    L_0x0062:
        r0 = move-exception;
        r2 = r1;
    L_0x0064:
        if (r2 == 0) goto L_0x0069;
    L_0x0066:
        r2.close();
    L_0x0069:
        throw r0;
    L_0x006a:
        r0 = new com.tencent.mm.storage.a.a;
        r0.<init>();
        goto L_0x0026;
    L_0x0070:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0064;
    L_0x0073:
        r0 = move-exception;
        goto L_0x0064;
    L_0x0075:
        r0 = move-exception;
        r2 = r3;
        r3 = r1;
        goto L_0x0036;
    L_0x0079:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x0036;
    L_0x007f:
        r0 = r3;
        goto L_0x002d;
    L_0x0081:
        r0 = r1;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.aP(java.lang.String, boolean):com.tencent.mm.storage.a.a");
    }

    private int bMY() {
        int i = 0;
        Cursor cursor = null;
        String str = "select  count(*) from EmojiInfo where catalog=?";
        try {
            cursor = this.gUz.a(str, new String[]{a.uKS}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
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

    public final boolean bMZ() {
        boolean z = true;
        Cursor cursor = null;
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where type=?", new String[]{a.TYPE_SYSTEM}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            a aVar = new a();
            aVar.b(cursor);
            if ((aVar.field_flag & 256) > 0) {
                z = false;
            }
            if (cursor == null) {
                return z;
            }
            cursor.close();
            return z;
        } catch (Exception e) {
            w.d("MicroMsg.emoji.EmojiGroupInfoStorage", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<a> bNa() {
        Cursor cursor = null;
        List<a> arrayList = new ArrayList();
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where " + yH(a.TYPE_SYSTEM) + " or " + yH(a.TYPE_CUSTOM) + " order by sort ASC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get system group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<a> bNb() {
        Cursor cursor = null;
        List<a> arrayList = new ArrayList();
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where " + bNj() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final HashMap<String, a> bNc() {
        Cursor cursor = null;
        HashMap<String, a> hashMap = new HashMap();
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where " + bNj() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                hashMap.put(aVar.field_productID, aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final ArrayList<a> bNd() {
        Cursor cursor = null;
        ArrayList<a> arrayList = new ArrayList();
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where " + bNk() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int bNe() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.gUz.a("select count(*) from EmojiGroupInfo where " + bNk() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + e.getMessage());
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

    public final HashMap<String, ak> bNf() {
        Cursor cursor = null;
        HashMap<String, ak> hashMap = new HashMap();
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where " + bNk() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            ak akVar = new ak();
            int columnIndex = cursor.getColumnIndex("productID");
            int columnIndex2 = cursor.getColumnIndex("packName");
            do {
                String string = cursor.getString(columnIndex);
                akVar.fGa = string;
                akVar.kSV = cursor.getString(columnIndex2);
                akVar.yD(7);
                hashMap.put(string, akVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean Sc(String str) {
        Cursor cursor = null;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
        }
        try {
            cursor = this.gUz.a("select count(*) from EmojiGroupInfo where productID = '" + str + "' AND " + bNl() + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            }
            if (cursor.getInt(0) > 0) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
            return z;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static boolean bNg() {
        return ((Boolean) h.vI().vr().get(208912, Boolean.valueOf(false))).booleanValue();
    }

    public final boolean c(a aVar) {
        if (aVar == null) {
            w.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
            return false;
        }
        aVar.field_lastUseTime = System.currentTimeMillis();
        aVar.field_sort = 1;
        w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", aVar.field_packName, Long.valueOf(aVar.field_lastUseTime));
        aVar.field_lastUseTime = System.currentTimeMillis();
        if (aVar != null) {
            aVar.field_flag &= -257;
        }
        boolean a = a(aVar);
        if (a) {
            a("event_update_group", 0, bg.bJZ().toString());
        }
        return a;
    }

    public final boolean cn(List<a> list) {
        if (list == null || list.size() <= 0) {
            w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
            return false;
        }
        long cs;
        g gVar;
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", Long.valueOf(cs));
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", r0.field_productID, Long.valueOf(r0.field_lastUseTime), Integer.valueOf(((a) list.get(i)).field_sort));
            a(r0);
        }
        if (gVar != null) {
            gVar.aD(cs);
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        a("event_update_group", 0, bg.bJZ().toString());
        return true;
    }

    public final boolean Sd(String str) {
        boolean z;
        if (!bg.mA(str)) {
            try {
                if (str.equals("com.tencent.xin.emoticon.tusiji")) {
                    str = a.uKQ;
                }
                c aP = aP(str, true);
                if (aP == null) {
                    z = false;
                } else {
                    if (aP != null) {
                        if (aP.field_type == a.TYPE_CUSTOM) {
                            w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
                        } else {
                            aP.field_flag |= 256;
                            aP.field_status = -1;
                            aP.field_sort = 1;
                            aP.field_recommand = 0;
                            aP.field_sync = 0;
                        }
                    }
                    aP.field_lastUseTime = System.currentTimeMillis();
                    aP.field_recommand = 0;
                    aP.field_sync = 0;
                    z = a(aP);
                }
            } catch (Exception e) {
                w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
            if (z) {
                a("event_update_group", 0, bg.bJZ().toString());
                Qr("delete_group");
            }
            return z;
        }
        z = false;
        if (z) {
            a("event_update_group", 0, bg.bJZ().toString());
            Qr("delete_group");
        }
        return z;
    }

    public final void ag(ArrayList<String> arrayList) {
        long cs;
        g gVar;
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", Long.valueOf(cs));
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Sd((String) it.next());
            }
        }
        if (gVar != null) {
            gVar.aD(cs);
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
        }
    }

    public final void bNh() {
        if (this.gUz.eE("EmojiGroupInfo", "UPDATE EmojiGroupInfo SET sort=-1,lastUseTime=" + System.currentTimeMillis() + " WHERE type=" + (a.TYPE_CUSTOM))) {
            a("event_update_group", 0, bg.bJZ().toString());
        }
        h.vI().vr().set(208912, Boolean.valueOf(true));
    }

    public final ArrayList<a> bNi() {
        Cursor cursor = null;
        ArrayList<a> arrayList = new ArrayList();
        try {
            cursor = this.gUz.a("select * from EmojiGroupInfo where " + bNk() + " or " + yH(a.TYPE_SYSTEM) + " or " + yH(a.TYPE_CUSTOM) + " or " + (" ( recommand = '1" + "' ) ") + " order by sort ASC,idx ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String bNj() {
        return yG(a.TYPE_SYSTEM) + " or " + yG(a.TYPE_CUSTOM) + " or " + yG(a.uKN) + " or " + yG(a.uKP);
    }

    private static String bNk() {
        return " ( " + yG(a.uKN) + " and " + bNl() + " ) ";
    }

    private static String yG(int i) {
        return " ( type = '" + i + "' ) ";
    }

    private static String bNl() {
        return " ( status = '7" + "' ) ";
    }

    private static String yH(int i) {
        return " ( " + yG(i) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bNm() {
        /*
        r7 = this;
        r6 = 2;
        r0 = 1;
        r1 = 0;
        r3 = "select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?";
        r2 = 4;
        r4 = new java.lang.String[r2];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4[r1] = r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = com.tencent.mm.storage.a.a.uKN;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4[r0] = r2;
        r2 = "0";
        r4[r6] = r2;
        r2 = 3;
        r5 = "7";
        r4[r2] = r5;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r5 = "checkStoreEmojiSync:%s";
        r6 = new java.lang.Object[r0];
        r6[r1] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r2, r5, r6);
        r2 = 0;
        r5 = r7.gUz;	 Catch:{ Exception -> 0x0060, all -> 0x0071 }
        r6 = 2;
        r2 = r5.a(r3, r4, r6);	 Catch:{ Exception -> 0x0060, all -> 0x0071 }
        if (r2 == 0) goto L_0x0059;
    L_0x004d:
        r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x007c, all -> 0x0071 }
        if (r3 == 0) goto L_0x0059;
    L_0x0053:
        if (r2 == 0) goto L_0x0058;
    L_0x0055:
        r2.close();
    L_0x0058:
        return r0;
    L_0x0059:
        if (r2 == 0) goto L_0x005e;
    L_0x005b:
        r2.close();
    L_0x005e:
        r0 = r1;
        goto L_0x0058;
    L_0x0060:
        r0 = move-exception;
        r0 = r2;
    L_0x0062:
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "checkStoreEmojiSync fail.";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x005e;
    L_0x006d:
        r0.close();
        goto L_0x005e;
    L_0x0071:
        r0 = move-exception;
    L_0x0072:
        if (r2 == 0) goto L_0x0077;
    L_0x0074:
        r2.close();
    L_0x0077:
        throw r0;
    L_0x0078:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0072;
    L_0x007c:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.bNm():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> bNn() {
        /*
        r8 = this;
        r0 = 2;
        r6 = 1;
        r5 = 0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "select productID from EmojiGroupInfo where type=? and sync=?";
        r3 = new java.lang.String[r0];
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = com.tencent.mm.storage.a.a.uKN;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3[r5] = r0;
        r0 = "1";
        r3[r6] = r0;
        r0 = 0;
        r4 = r8.gUz;	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        r5 = 2;
        r0 = r4.a(r2, r3, r5);	 Catch:{ Exception -> 0x0047, all -> 0x0061 }
        if (r0 == 0) goto L_0x0041;
    L_0x002d:
        r2 = r0.moveToFirst();	 Catch:{ Exception -> 0x0047 }
        if (r2 == 0) goto L_0x0041;
    L_0x0033:
        r2 = 0;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0047 }
        r1.add(r2);	 Catch:{ Exception -> 0x0047 }
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0047 }
        if (r2 != 0) goto L_0x0033;
    L_0x0041:
        if (r0 == 0) goto L_0x0046;
    L_0x0043:
        r0.close();
    L_0x0046:
        return r1;
    L_0x0047:
        r2 = move-exception;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "getNeedToSyncStoreEmojiProductList. exception.%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x006b }
        r5 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.bJZ();	 Catch:{ all -> 0x006b }
        r4[r5] = r6;	 Catch:{ all -> 0x006b }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0046;
    L_0x005d:
        r0.close();
        goto L_0x0046;
    L_0x0061:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0065:
        if (r1 == 0) goto L_0x006a;
    L_0x0067:
        r1.close();
    L_0x006a:
        throw r0;
    L_0x006b:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.bNn():java.util.List<java.lang.String>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> bNo() {
        /*
        r8 = this;
        r6 = 2;
        r5 = 1;
        r4 = 0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)";
        r0 = 5;
        r3 = new java.lang.String[r0];
        r0 = "0";
        r3[r4] = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = com.tencent.mm.storage.a.a.uKN;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3[r5] = r0;
        r0 = "7";
        r3[r6] = r0;
        r0 = 3;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3[r0] = r4;
        r0 = 4;
        r4 = "0";
        r3[r0] = r4;
        r0 = 0;
        r4 = r8.gUz;	 Catch:{ Exception -> 0x0065, all -> 0x007f }
        r5 = 2;
        r0 = r4.a(r2, r3, r5);	 Catch:{ Exception -> 0x0065, all -> 0x007f }
        if (r0 == 0) goto L_0x005f;
    L_0x004b:
        r2 = r0.moveToFirst();	 Catch:{ Exception -> 0x0065 }
        if (r2 == 0) goto L_0x005f;
    L_0x0051:
        r2 = 0;
        r2 = r0.getString(r2);	 Catch:{ Exception -> 0x0065 }
        r1.add(r2);	 Catch:{ Exception -> 0x0065 }
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x0065 }
        if (r2 != 0) goto L_0x0051;
    L_0x005f:
        if (r0 == 0) goto L_0x0064;
    L_0x0061:
        r0.close();
    L_0x0064:
        return r1;
    L_0x0065:
        r2 = move-exception;
        r2 = "MicroMsg.emoji.EmojiGroupInfoStorage";
        r3 = "getNeedToUploadStoreEmojiProductList. exception.%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0089 }
        r5 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.bJZ();	 Catch:{ all -> 0x0089 }
        r4[r5] = r6;	 Catch:{ all -> 0x0089 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x0089 }
        if (r0 == 0) goto L_0x0064;
    L_0x007b:
        r0.close();
        goto L_0x0064;
    L_0x007f:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0083:
        if (r1 == 0) goto L_0x0088;
    L_0x0085:
        r1.close();
    L_0x0088:
        throw r0;
    L_0x0089:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.b.bNo():java.util.List<java.lang.String>");
    }

    public final ArrayList<a> bNp() {
        ArrayList<a> arrayList = new ArrayList();
        String[] strArr = new String[]{a.uKN, "7", a.TYPE_SYSTEM, "0"};
        Cursor cursor = null;
        try {
            cursor = this.gUz.a(new StringBuilder("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC").toString(), strArr, 2);
            w.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                a aVar = new a();
                aVar.b(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void bNq() {
        w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
        c aP = aP(String.valueOf(a.uKR), false);
        if (aP == null) {
            aP = new a();
        } else {
            w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", aP.toString());
        }
        aP.field_productID = String.valueOf(a.uKR);
        aP.field_packName = "emoji_custom_group";
        aP.field_type = a.TYPE_CUSTOM;
        aP.field_status = 0;
        aP.field_packStatus = 1;
        aP.field_flag = 0;
        a(aP);
        w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
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
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", bg.g(e));
            w.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
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
        w.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return i;
    }
}
