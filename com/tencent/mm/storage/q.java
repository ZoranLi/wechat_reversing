package com.tencent.mm.storage;

import com.tencent.mm.e.b.ae;
import com.tencent.mm.g.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q extends ae {
    protected static a gTP;
    public Map<String, b> hwI = new HashMap();
    private com.tencent.mm.g.a.a.a uyV = new com.tencent.mm.g.a.a.a();
    public com.tencent.mm.g.a.a.a uyW = this.uyV;
    private List<String> uyX = new LinkedList();

    static {
        a aVar = new a();
        aVar.hXH = new Field[18];
        aVar.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroomname";
        aVar.uxd.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "chatroomname";
        aVar.columns[1] = "addtime";
        aVar.uxd.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "memberlist";
        aVar.uxd.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "displayname";
        aVar.uxd.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "chatroomnick";
        aVar.uxd.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roomflag";
        aVar.uxd.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "roomowner";
        aVar.uxd.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "roomdata";
        aVar.uxd.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "isShowname";
        aVar.uxd.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "selfDisplayName";
        aVar.uxd.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "style";
        aVar.uxd.put("style", "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatroomdataflag";
        aVar.uxd.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "modifytime";
        aVar.uxd.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "chatroomnotice";
        aVar.uxd.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "chatroomVersion";
        aVar.uxd.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "chatroomnoticeEditor";
        aVar.uxd.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomnoticePublishTime";
        aVar.uxd.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "chatroomLocalVersion";
        aVar.uxd.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        aVar.columns[18] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final List<String> DU() {
        if (this.uyX == null || this.uyX.size() == 0) {
            this.uyX = QK(this.field_memberlist);
        }
        return this.uyX;
    }

    private void a(com.tencent.mm.g.a.a.a aVar) {
        if (this.field_roomdata == null) {
            aVar = new com.tencent.mm.g.a.a.a();
        }
        Iterator it = aVar.gMT.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.hwI.put(bVar.userName, bVar);
        }
    }

    public final void bKR() {
        if (!bg.bm(this.field_roomdata)) {
            try {
                this.uyW = (com.tencent.mm.g.a.a.a) new com.tencent.mm.g.a.a.a().aD(this.field_roomdata);
            } catch (Exception e) {
                this.uyW = new com.tencent.mm.g.a.a.a();
            }
            a(this.uyW);
        }
    }

    public final boolean b(com.tencent.mm.g.a.a.a aVar) {
        return this.uyV.aUk() == aVar.aUk();
    }

    public final b QI(String str) {
        if (this.hwI.size() <= 0) {
            bKR();
        }
        if (this.hwI.containsKey(str)) {
            return (b) this.hwI.get(str);
        }
        return null;
    }

    public final int bKS() {
        if (b(this.uyW)) {
            bKR();
        }
        return this.uyW.fPC;
    }

    public final boolean bKT() {
        if (b(this.uyW)) {
            bKR();
        }
        return this.uyW.fPC < this.uyW.gMW;
    }

    public static boolean bKU() {
        return false;
    }

    public final void eA(int i) {
        this.field_chatroomdataflag = (this.uyW.fRW & -3) | (i & 2);
    }

    public final int bKV() {
        if (b(this.uyW)) {
            bKR();
        }
        return this.uyW.type;
    }

    public final int bKW() {
        if (b(this.uyW)) {
            bKR();
        }
        return this.uyW.gMU;
    }

    public final String eK(String str) {
        b QI = QI(str);
        if (QI == null) {
            return "";
        }
        return bg.ap(QI.gMX, "");
    }

    public final q jX(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean bKX() {
        return this.field_isShowname > 0;
    }

    private static int FO(String str) {
        int i = 0;
        try {
            i = bg.getInt(str, 0);
        } catch (Exception e) {
            if (str != null) {
                w.e("MicroMsg.ChatRoomMember", "parserInt error " + str);
            }
        }
        return i;
    }

    private static com.tencent.mm.g.a.a.a QJ(String str) {
        com.tencent.mm.g.a.a.a aVar = new com.tencent.mm.g.a.a.a();
        if (bg.mA(str)) {
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map q = bh.q(str, "RoomData");
        if (q == null) {
            w.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            return null;
        }
        int i = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                String str2;
                b bVar = new b();
                if (i == 0) {
                    obj = ".RoomData.Member.$UserName";
                    obj2 = ".RoomData.Member.DisplayName";
                    obj3 = ".RoomData.Member.Flag";
                } else if (i != 0) {
                    String str3 = ".RoomData.Member" + i + ".$UserName";
                    String str4 = ".RoomData.Member" + i + ".DisplayName";
                    String str5 = ".RoomData.Member" + i + ".Flag";
                    str2 = str3;
                    str3 = str4;
                    str4 = str5;
                } else {
                    obj3 = null;
                    obj2 = null;
                    obj = null;
                }
                str2 = bg.ap((String) q.get(obj), "");
                if (bg.mA(str2)) {
                    aVar.type = FO((String) q.get(".RoomData.Type"));
                    aVar.status = FO((String) q.get(".RoomData.Status"));
                    aVar.gMU = FO((String) q.get(".RoomData.MaxCount"));
                    aVar.gMV = bg.ap((String) q.get(".RoomData.ExtInfo.Upgrader"), "");
                    return aVar;
                }
                bVar.userName = str2;
                bVar.gMX = bg.ap((String) q.get(obj2), "");
                bVar.gMY = FO((String) q.get(obj3));
                aVar.gMT.add(bVar);
                i++;
            } catch (Exception e) {
                return aVar;
            }
        }
    }

    public static List<String> QK(String str) {
        List<String> linkedList = new LinkedList();
        if (bg.mA(str)) {
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        return linkedList;
    }

    public final q bX(List<String> list) {
        String str;
        if (list == null || list.size() == 0) {
            str = "";
        } else {
            str = "";
            for (int i = 0; i < list.size(); i++) {
                str = str + ((String) list.get(i));
                if (i < list.size() - 1) {
                    str = str + ";";
                }
            }
        }
        this.field_memberlist = str;
        return this;
    }

    public final q eJ(String str, String str2) {
        return a(str, QJ(str2), false);
    }

    public final q a(String str, com.tencent.mm.g.a.a.a aVar, boolean z) {
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            b bVar = null;
            Iterator it = aVar.gMT.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.userName == null || !bVar2.userName.equals(str)) {
                    bVar2 = bVar;
                }
                bVar = bVar2;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.gMX;
                this.field_isShowname = bVar.gMY & 1;
                i = bVar.gMY;
            } else {
                i = 0;
            }
            w.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            aVar.fRW = (i & 2) | (aVar.fRW & -3);
            this.field_chatroomdataflag = aVar.fRW;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.uyW = aVar;
        } catch (Throwable e) {
            w.e("MicroMsg.ChatRoomMember", "exception:%s", bg.g(e));
        }
        a(aVar);
        return this;
    }

    public final com.tencent.mm.g.a.a.a bKY() {
        if (b(this.uyW)) {
            bKR();
        }
        return this.uyW;
    }
}
