package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.u;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends u {
    protected static a gTP;
    private Map<String, j> hwI = new HashMap();
    private List<String> hwJ;

    static {
        a aVar = new a();
        aVar.hXH = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatLocalId";
        aVar.uxd.put("bizChatLocalId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "bizChatLocalId";
        aVar.columns[1] = "bizChatServId";
        aVar.uxd.put("bizChatServId", "TEXT");
        stringBuilder.append(" bizChatServId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "brandUserName";
        aVar.uxd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatType";
        aVar.uxd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "headImageUrl";
        aVar.uxd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "chatName";
        aVar.uxd.put("chatName", "TEXT default '' ");
        stringBuilder.append(" chatName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "chatNamePY";
        aVar.uxd.put("chatNamePY", "TEXT default '' ");
        stringBuilder.append(" chatNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatVersion";
        aVar.uxd.put("chatVersion", "INTEGER default '-1' ");
        stringBuilder.append(" chatVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "needToUpdate";
        aVar.uxd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "bitFlag";
        aVar.uxd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "maxMemberCnt";
        aVar.uxd.put("maxMemberCnt", "INTEGER default '0' ");
        stringBuilder.append(" maxMemberCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "ownerUserId";
        aVar.uxd.put("ownerUserId", "TEXT");
        stringBuilder.append(" ownerUserId TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "userList";
        aVar.uxd.put("userList", "TEXT");
        stringBuilder.append(" userList TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "addMemberUrl";
        aVar.uxd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[14] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean fu(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final List<String> DU() {
        if (this.hwJ != null) {
            return this.hwJ;
        }
        String str = this.field_userList;
        if (bg.mA(str)) {
            return new LinkedList();
        }
        this.hwJ = bg.f(str.split(";"));
        return this.hwJ;
    }

    public final String eK(String str) {
        j ip = ip(str);
        if (ip == null) {
            return "";
        }
        return bg.ap(ip.field_userName, "");
    }

    public final j ip(String str) {
        if (!this.hwI.containsKey(str) || this.hwI.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            j iD = w.DL().iD(str);
            if (iD != null) {
                this.hwI.put(iD.field_userId, iD);
            }
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (this.hwI.containsKey(str)) {
            return (j) this.hwI.get(str);
        }
        return null;
    }

    public final boolean DV() {
        if (this.field_bizChatServId == null) {
            return false;
        }
        return this.field_bizChatServId.endsWith("@qy_g");
    }

    public final boolean DW() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (DV() && bg.mA(this.field_userList)) {
            return true;
        }
        if (!bg.mA(this.field_chatNamePY) || bg.mA(this.field_chatName)) {
            return false;
        }
        return true;
    }
}
