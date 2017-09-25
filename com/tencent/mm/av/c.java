package com.tencent.mm.av;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<b> implements a {
    public static final String[] gUx = new String[]{i.a(b.gTP, "fmessage_conversation")};
    private static final String[] hXE = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    private final int fxm = 1;
    public e gUz;
    private Runnable hXF = new Runnable(this) {
        final /* synthetic */ c hXG;

        {
            this.hXG = r1;
        }

        public final void run() {
            w.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(this.hXG.Km()));
            ap.yY();
            com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(r0));
        }
    };
    protected Context mContext = null;

    public c(e eVar) {
        super(eVar, b.gTP, "fmessage_conversation", hXE);
        this.gUz = eVar;
        this.mContext = ab.getContext();
    }

    public final Cursor Kk() {
        return this.gUz.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    }

    public final int getCount() {
        int i = 0;
        Cursor a = this.gUz.a("select count(*) from fmessage_conversation", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        w.d("MicroMsg.FMessageConversationStorage", "getCount = " + i);
        return i;
    }

    public final boolean D(String str, int i) {
        if (str == null || str.length() == 0) {
            w.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c kX = kX(str);
        if (kX == null) {
            w.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = " + str);
            return false;
        } else if (i == kX.field_state) {
            w.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            return true;
        } else {
            kX.field_state = i;
            kX.field_lastModifiedTime = System.currentTimeMillis();
            if (!super.c(kX, new String[0])) {
                return false;
            }
            Qr(str);
            return true;
        }
    }

    public final boolean Kl() {
        if (this.gUz.eE("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            w.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            return true;
        }
        w.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        return false;
    }

    public final int Km() {
        int i = 0;
        Cursor a = this.gUz.a(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        w.d("MicroMsg.FMessageConversationStorage", "getNewCount = " + i);
        return i;
    }

    public final List<String> Kn() {
        Cursor a = this.gUz.a(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(a.getColumnIndex("contentNickname")));
        }
        a.close();
        return arrayList;
    }

    public final boolean kW(String str) {
        if (str == null || str.length() == 0) {
            w.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c kX = kX(str);
        if (kX == null || !str.equals(kX.field_talker)) {
            w.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = " + str);
            return false;
        }
        kX.field_isNew = 0;
        return super.c(kX, new String[0]);
    }

    public final b kX(String str) {
        if (str == null || str.length() == 0) {
            w.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            return null;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_talker = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        w.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = " + str);
        return null;
    }

    public final b kY(String str) {
        b bVar = null;
        if (str == null || str.length() == 0) {
            w.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
        } else {
            Cursor a = this.gUz.a("select * from fmessage_conversation  where encryptTalker=" + g.dP(str), null, 2);
            if (a.moveToFirst()) {
                bVar = new b();
                bVar.b(a);
            }
            a.close();
        }
        return bVar;
    }

    public final void a(String str, l lVar) {
        int i = 0;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            return;
        }
        long j;
        try {
            j = bg.getLong(str, 0);
        } catch (Exception e) {
            w.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            w.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        } else if (h.vG().uV()) {
            com.tencent.mm.sdk.e.c fVar = new f();
            if (l.Kx().b(j, fVar)) {
                w.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = " + j);
                com.tencent.mm.sdk.e.c kX = l.Ky().kX(fVar.field_talker);
                if (kX == null) {
                    w.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + fVar.field_talker);
                    if (bg.mA(fVar.field_talker)) {
                        w.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                        return;
                    }
                    com.tencent.mm.sdk.e.c bVar = new b();
                    if (fVar.field_type == 0) {
                        au.a RF = au.a.RF(fVar.field_msgContent);
                        bVar.field_displayName = RF.getDisplayName();
                        if (RF.scene == 4 && RF.bMH() != null) {
                            bVar.field_displayName = RF.bMH();
                        }
                        bVar.field_addScene = RF.scene;
                        bVar.field_isNew = 1;
                        bVar.field_contentFromUsername = RF.rUK;
                        bVar.field_contentNickname = RF.fFa;
                        bVar.field_contentPhoneNumMD5 = RF.uJX;
                        bVar.field_contentFullPhoneNumMD5 = RF.uJY;
                        w.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                    } else if (fVar.Kp()) {
                        d RI = d.RI(fVar.field_msgContent);
                        bVar.field_displayName = RI.getDisplayName();
                        bVar.field_addScene = RI.scene;
                        bVar.field_isNew = 1;
                        bVar.field_contentFromUsername = RI.rUK;
                        bVar.field_contentNickname = RI.fFa;
                        bVar.field_contentVerifyContent = RI.content;
                        w.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                    }
                    bVar.field_lastModifiedTime = System.currentTimeMillis();
                    bVar.field_state = 0;
                    bVar.field_talker = fVar.field_talker;
                    bVar.field_encryptTalker = fVar.field_encryptTalker;
                    bVar.field_fmsgSysRowId = j;
                    bVar.field_fmsgIsSend = fVar.field_isSend;
                    bVar.field_fmsgType = fVar.field_type;
                    bVar.field_fmsgContent = fVar.field_msgContent;
                    if (fVar.Kp()) {
                        i = fVar.field_type;
                    }
                    bVar.field_recvFmsgType = i;
                    w.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + bVar.field_fmsgContent);
                    l.Ky().b(bVar);
                } else {
                    w.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + fVar.field_talker);
                    if (fVar.Kp()) {
                        kX.field_isNew = 1;
                    }
                    kX.field_lastModifiedTime = System.currentTimeMillis();
                    kX.field_encryptTalker = fVar.field_encryptTalker;
                    kX.field_fmsgSysRowId = j;
                    kX.field_fmsgIsSend = fVar.field_isSend;
                    kX.field_fmsgType = fVar.field_type;
                    kX.field_fmsgContent = fVar.field_msgContent;
                    if (fVar.Kp()) {
                        kX.field_recvFmsgType = fVar.field_type;
                        w.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + kX.field_recvFmsgType);
                    }
                    if (fVar.field_type == 0) {
                        au.a RF2 = au.a.RF(fVar.field_msgContent);
                        kX.field_contentFromUsername = RF2.rUK;
                        kX.field_contentNickname = RF2.fFa;
                        kX.field_contentPhoneNumMD5 = RF2.uJX;
                        kX.field_contentFullPhoneNumMD5 = RF2.uJY;
                        w.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + kX.field_contentFromUsername + "new friend Nickname: " + kX.field_contentNickname);
                    } else if (fVar.Kp()) {
                        if ((fVar.field_isSend >= 2 ? 1 : 0) == 0) {
                            d RI2 = d.RI(fVar.field_msgContent);
                            kX.field_contentVerifyContent = RI2.content;
                            kX.field_contentFromUsername = RI2.rUK;
                            kX.field_contentNickname = RI2.fFa;
                            w.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + kX.field_contentVerifyContent + " receive, new friend Username: " + kX.field_contentFromUsername + " new friend Nickname: " + kX.field_contentNickname);
                            String str2 = kX.field_contentFromUsername;
                            String str3 = kX.field_contentNickname;
                            b jvVar = new jv();
                            jvVar.fQj.userName = str2;
                            jvVar.fQj.aIO = str3;
                            jvVar.fQj.type = 1;
                            com.tencent.mm.sdk.b.a.urY.m(jvVar);
                        }
                    }
                    l.Ky().c(kX, new String[0]);
                    if (Km() == 0) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(340225, Long.valueOf(System.currentTimeMillis()));
                    }
                }
                Ko();
                return;
            }
            w.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = " + j);
        } else {
            w.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        }
    }

    public final void Ko() {
        af.I(this.hXF);
        af.f(this.hXF, 500);
    }

    public final boolean c(long j, String str) {
        String str2;
        w.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", Long.valueOf(j), str);
        if (!bg.mA(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + bg.my(str) + "'";
        } else if (j <= 0) {
            return false;
        } else {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j + "'";
        }
        if (!this.gUz.eE("fmessage_conversation", str2)) {
            return false;
        }
        w.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", Long.valueOf(j), str);
        Qr(str);
        return true;
    }
}
