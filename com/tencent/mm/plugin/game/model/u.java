package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;

public final class u extends i<q> {
    public static final String[] gUx = new String[]{i.a(q.gTP, "GameRawMessage")};

    public u(e eVar) {
        super(eVar, q.gTP, "GameRawMessage", null);
    }

    public final q cn(long j) {
        c qVar = new q();
        qVar.field_msgId = j;
        return b(qVar, new String[0]) ? qVar : null;
    }

    public final LinkedList<q> b(int i, long j, int i2, int i3) {
        Object obj;
        String str;
        if (j == 0) {
            obj = "9223372036854775807";
        } else {
            String valueOf = String.valueOf(j);
        }
        if (i2 == 0) {
            str = "(isRead=1 or isRead=0) ";
        } else if (i2 == 1) {
            str = "isRead=0 ";
        } else if (i2 != 2) {
            return null;
        } else {
            str = "isRead=1 ";
        }
        String str2 = "";
        if (i != 65536) {
            str2 = "msgType=" + i + " and ";
        }
        String valueOf2 = String.valueOf(i3);
        str2 = String.format("select * from GameRawMessage where " + str2 + "msgId<%s and " + str + "order by createTime desc limit %s", new Object[]{obj, valueOf2});
        LinkedList<q> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                q qVar = new q();
                qVar.b(rawQuery);
                linkedList.add(qVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return linkedList;
    }

    public final LinkedList<q> aAV() {
        LinkedList<q> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from GameRawMessage where msgType=20", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    q qVar = new q();
                    qVar.b(rawQuery);
                    linkedList.add(qVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final q xP(String str) {
        Cursor rawQuery = rawQuery("select * from GameRawMessage where msgType=20 and appId= \"" + str + "\" limit 1", new String[0]);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            q qVar = new q();
            qVar.b(rawQuery);
            return qVar;
        }
        rawQuery.close();
        return null;
    }

    public final boolean e(long[] jArr) {
        if (jArr.length == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("msgId in (");
        for (int i = 0; i < jArr.length; i++) {
            stringBuilder.append(jArr[i]);
            if (i != jArr.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        String stringBuilder2 = stringBuilder.toString();
        return eE("GameRawMessage", String.format("update GameRawMessage set isRead=1 where %s", new Object[]{stringBuilder2}));
    }

    public final void aAW() {
        eE("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
    }

    public final void aAX() {
        String str = "GameRawMessage";
        eE(str, "update GameRawMessage set isRead=1 where isRead=0 and " + l(2, 5, 6, 10, 11, 100) + " and isHidden = 0");
    }

    public final int aAY() {
        int i = 0;
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where " + l(2, 5, 6, 10, 11, 100) + " and isRead=0 and showInMsgList" + " = 1 and isHidden" + " = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public static String l(int... iArr) {
        String str = "" + "(";
        for (int i = 0; i < 5; i++) {
            str = str + "msgType=" + iArr[i] + " or ";
        }
        return (str + "msgType=" + iArr[5]) + ")";
    }
}
