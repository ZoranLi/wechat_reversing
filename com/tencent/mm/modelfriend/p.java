package com.tencent.mm.modelfriend;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class p extends i<o> implements a {
    public static final String[] gUx = new String[]{i.a(o.gTP, "GoogleFriend")};
    public e gUz;
    public m hBv = new m(this) {
        final /* synthetic */ p hBw;

        {
            this.hBw = r1;
        }

        protected final boolean Fc() {
            if (this.hBw.gUz != null && !this.hBw.gUz.bKn()) {
                return true;
            }
            String str = "MicroMsg.GoogleContact.GoogleFriendUI";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.hBw.gUz == null ? "null" : Boolean.valueOf(this.hBw.gUz.bKn());
            w.w(str, str2, objArr);
            return false;
        }
    };

    public final /* synthetic */ boolean b(c cVar) {
        return a((o) cVar);
    }

    public p(e eVar) {
        super(eVar, o.gTP, "GoogleFriend", null);
        this.gUz = eVar;
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    private boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (((int) this.gUz.insert("GoogleFriend", "googleitemid", oVar.pv())) > 0) {
            return true;
        }
        return false;
    }

    public final boolean f(ArrayList<o> arrayList) {
        int i = 0;
        if (arrayList.size() <= 0) {
            w.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            return false;
        }
        long cs;
        g gVar;
        if (this.gUz instanceof g) {
            g gVar2 = (g) this.gUz;
            cs = gVar2.cs(Thread.currentThread().getId());
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", Long.valueOf(cs));
            gVar = gVar2;
        } else {
            gVar = null;
            cs = -1;
        }
        while (i < arrayList.size()) {
            a((o) arrayList.get(i));
            i++;
        }
        if (gVar != null) {
            gVar.aD(cs);
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.hBv.b(2, this.hBv, "");
        return true;
    }

    public final Cursor ji(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        return this.gUz.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder, null);
    }

    public final boolean b(o oVar) {
        Cursor a = this.gUz.a("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bg.my(oVar.field_googleitemid) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (!moveToFirst) {
            return a(oVar);
        }
        int update = this.gUz.update("GoogleFriend", oVar.pv(), new StringBuilder("googleitemid=?").toString(), new String[]{oVar.field_googleitemid});
        if (update > 0) {
            doNotify();
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean x(String str, int i) {
        return this.gUz.eE("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid='" + str + "'");
    }

    public final boolean y(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.gUz.eE("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status='0" + "' WHERE username='" + str + "'");
    }

    public final void clear() {
        this.gUz.eE("GoogleFriend", " delete from GoogleFriend");
        this.hBv.b(5, this.hBv, "");
    }
}
