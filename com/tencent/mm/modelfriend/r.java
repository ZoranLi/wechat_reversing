package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;

public final class r extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private g hnH;

    public r(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(q qVar) {
        if (jj(qVar.getUsername())) {
            qVar.fRW = -1;
            if (this.hnH.update("invitefriendopen", qVar.pv(), "username=?", new String[]{qVar.getUsername()}) > 0) {
                return true;
            }
            return false;
        }
        qVar.fRW = -1;
        if (((int) this.hnH.insert("invitefriendopen", "username", qVar.pv())) == -1) {
            return false;
        }
        return true;
    }

    public final boolean jj(String str) {
        Cursor a = this.hnH.a("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bg.my(str) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }
}
