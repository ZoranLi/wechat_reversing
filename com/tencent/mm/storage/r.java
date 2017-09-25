package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.aa;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class r extends i<q> implements a, aa {
    public static final String[] gUx = new String[]{i.a(q.gTP, "chatroom")};
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    private e gUz;

    public final /* synthetic */ boolean a(c cVar) {
        q qVar = (q) cVar;
        if (super.a(qVar)) {
            Qr(qVar.field_chatroomname);
            return true;
        }
        w.w("MicroMsg.ChatroomStorage", "replace error");
        return false;
    }

    public r(e eVar) {
        super(eVar, q.gTP, "chatroom", gaK);
        this.gUz = eVar;
    }

    public final q fV(String str) {
        c qVar = new q();
        qVar.field_chatroomname = str;
        return super.b(qVar, "chatroomname") ? qVar : null;
    }

    public final q fW(String str) {
        c qVar = new q();
        qVar.field_chatroomname = str;
        return super.b(qVar, "chatroomname") ? qVar : qVar;
    }

    public final void g(String str, long j) {
        this.gUz.eE("chatroom", "update chatroom set modifytime = " + j + " where chatroomname = '" + bg.my(str) + "'");
    }

    public final String fX(String str) {
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gUz.a("select roomowner from chatroom where chatroomname='" + bg.my(str) + "'", null, 2);
        if (a == null) {
            w.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            return null;
        }
        q qVar;
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar != null) {
            return qVar.field_roomowner;
        }
        return null;
    }

    public final String fY(String str) {
        q qVar;
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gUz.a("select memberlist from chatroom where chatroomname='" + bg.my(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar == null) {
            return null;
        }
        return qVar.field_memberlist;
    }

    public final String eK(String str) {
        q qVar;
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gUz.a("select displayname from chatroom where chatroomname='" + bg.my(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar == null) {
            return null;
        }
        return qVar.field_displayname;
    }

    public final List<String> fZ(String str) {
        String fY = fY(str);
        if (fY == null) {
            return null;
        }
        List<String> linkedList = new LinkedList();
        if (!fY.equals("")) {
            String[] split = fY.split(";");
            for (Object add : split) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    public final boolean ga(String str) {
        q qVar = null;
        Cursor a = this.gUz.a("select * from chatroom where chatroomname='" + bg.my(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        }
        a.close();
        return qVar != null && (qVar.field_roomflag & 1) == 0;
    }

    public final boolean gb(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.gUz.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            return false;
        }
        Qr(str);
        return true;
    }

    public final int a(f fVar) {
        return 0;
    }
}
