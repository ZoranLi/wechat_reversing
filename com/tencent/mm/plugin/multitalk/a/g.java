package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.e.a.mc;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.pluginsdk.l.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.c.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements h {
    private List<com.tencent.mm.pluginsdk.l.g> hDb = new ArrayList();
    private ae handler = new ae(Looper.getMainLooper());
    private LinkedList<String> nPH = null;
    private LinkedList<String> nPI = new LinkedList();
    private LinkedList<String> nPJ = new LinkedList();

    public final LinkedList<String> aMZ() {
        if (this.nPJ == null) {
            this.nPJ = new LinkedList();
        }
        return this.nPJ;
    }

    public final synchronized void a(com.tencent.mm.pluginsdk.l.g gVar) {
        this.hDb.add(gVar);
    }

    public final synchronized void b(com.tencent.mm.pluginsdk.l.g gVar) {
        this.hDb.remove(gVar);
    }

    public final void AY(final String str) {
        if (o.dH(str) && Ba(str)) {
            w.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            ap.yY();
            c.vr().get(2, null);
            if (o.aNn().nPl != null && o.aNn().nPl.wPh.equals(str)) {
                w.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                o.aNn().c(false, false, false);
            }
            this.handler.postDelayed(new Runnable(this) {
                final /* synthetic */ g nPL;

                public final void run() {
                    this.nPL.Bh(str);
                    b mcVar = new mc();
                    mcVar.fTv.type = 2;
                    a.urY.m(mcVar);
                }
            }, 2000);
        }
    }

    public final boolean AZ(String str) {
        com.tencent.mm.al.b Bl = o.aNj().Bl(str);
        if (Bl == null || Bl.field_wxGroupId == null || !Bl.field_wxGroupId.equals(str)) {
            return false;
        }
        if (System.currentTimeMillis() - Bl.field_createTime <= 21600000) {
            return true;
        }
        w.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
        Bh(str);
        return false;
    }

    public final boolean Ba(String str) {
        if (this.nPH == null) {
            aNc();
        }
        if (this.nPH == null || !this.nPH.contains(str)) {
            return false;
        }
        return true;
    }

    public final List<String> Bb(String str) {
        List<com.tencent.mm.plugin.multitalk.b.b> Bm = o.aNk().Bm(str);
        List linkedList = new LinkedList();
        for (com.tencent.mm.plugin.multitalk.b.b bVar : Bm) {
            linkedList.add(bVar.field_userName);
        }
        return linkedList;
    }

    public final boolean cS(String str, String str2) {
        if (o.aNk().cV(str, str2) != null) {
            return true;
        }
        return false;
    }

    public final boolean gR(String str) {
        if (this.nPH != null) {
            w.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:" + str);
            this.nPH.remove(str);
        } else {
            aNc();
        }
        return o.aNj().gR(str);
    }

    public final boolean aMM() {
        return o.aNn().aMM();
    }

    public final boolean aMO() {
        return o.aNn().aMO();
    }

    public final boolean aNa() {
        return o.aNn().aMM() && (o.aNn().nPk == e.Starting || o.aNn().nPk == e.Creating);
    }

    public final boolean Bc(String str) {
        com.tencent.mm.plugin.voip.ui.g bpe = d.bpe();
        if (bpe != null) {
            Intent intent = bpe.intent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
                com.tencent.mm.plugin.voip.ui.h hVar = bpe.rnR;
                if (!i.wx(stringExtra) && str.equals(stringExtra) && hVar != null && hVar.getVisibility() == 0 && hVar.isShown()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean aNb() {
        return com.tencent.mm.plugin.voip.b.d.brk() || o.aNn().aMO() || o.aNn().aMM() || o.aNn().aMN();
    }

    public final String cT(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b cV = o.aNk().cV(str, str2);
        if (cV != null) {
            return cV.field_inviteUserName;
        }
        return null;
    }

    public final String eK(String str) {
        return n.eK(str);
    }

    public final boolean aJ(Context context) {
        return com.tencent.mm.n.a.aJ(context);
    }

    public final boolean Bd(String str) {
        com.tencent.mm.al.b Bl = o.aNj().Bl(str);
        if (Bl != null) {
            return com.tencent.wecall.talkroom.model.a.chg().b(Bl.field_groupId, Bl.field_roomId, Bl.field_roomKey, 1);
        }
        return false;
    }

    public final void Be(String str) {
        if (this.nPI == null) {
            this.nPI = new LinkedList();
            if (!this.nPI.contains(str)) {
                this.nPI.add(str);
            }
        } else if (!this.nPI.contains(str)) {
            this.nPI.add(str);
        }
    }

    public final boolean Bf(String str) {
        com.tencent.mm.al.b Bl = o.aNj().Bl(str);
        if (Bl != null) {
            return o.aNm().nOT.Bf(Bl.field_groupId);
        }
        return false;
    }

    public final boolean Bg(String str) {
        com.tencent.mm.al.b Bl = o.aNj().Bl(str);
        if (Bl != null) {
            return o.aNm().nOT.a(Bl.field_groupId, Bl.field_roomId, Bl.field_roomKey, Bl.field_routeId);
        }
        return false;
    }

    public final int cU(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b cV = o.aNk().cV(str, str2);
        if (cV != null) {
            return cV.field_status;
        }
        return 30;
    }

    public final void Bh(String str) {
        if (i.isNullOrEmpty(str)) {
            w.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            return;
        }
        w.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[]{str});
        gR(str);
        o.aNk().gR(str);
        Bk(str);
    }

    public final void a(String str, ay ayVar) {
        w.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[]{str});
        if (ayVar != null) {
            as[] asVarArr = ayVar.wMX;
            if (asVarArr != null && asVarArr.length > 0) {
                o.aNk().gR(str);
                for (as asVar : asVarArr) {
                    com.tencent.mm.plugin.multitalk.b.b bVar = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar.field_wxGroupId = str;
                    bVar.field_inviteUserName = asVar.wOr;
                    bVar.field_memberUuid = (long) asVar.taQ;
                    bVar.field_userName = asVar.wNl;
                    bVar.field_status = asVar.status;
                    if (!o.aNk().a(bVar)) {
                        w.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, asVar.wNl, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName});
                    }
                    w.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, asVar.wNl, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName});
                }
            }
        }
        if (b(str, ayVar)) {
            w.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:" + str);
            if (this.nPH == null) {
                aNc();
                if (this.nPH != null) {
                    this.nPH.add(str);
                }
            } else if (!this.nPH.contains(str)) {
                this.nPH.add(str);
            }
        }
        Bk(str);
    }

    public final void Bi(String str) {
        if (this.nPI == null) {
            this.nPI = new LinkedList();
        } else {
            this.nPI.remove(str);
        }
    }

    public final boolean Bj(String str) {
        if (this.nPI == null) {
            return false;
        }
        return this.nPI.contains(str);
    }

    final void Bk(final String str) {
        for (final com.tencent.mm.pluginsdk.l.g gVar : this.hDb) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ g nPL;

                public final void run() {
                    gVar.LI(str);
                }
            });
        }
    }

    public final com.tencent.mm.al.b Bl(String str) {
        return o.aNj().Bl(str);
    }

    public final void aNc() {
        LinkedList aNr = o.aNj().aNr();
        w.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.nPH = new LinkedList();
        Iterator it = aNr.iterator();
        while (it.hasNext()) {
            this.nPH.add(((com.tencent.mm.al.b) it.next()).field_wxGroupId);
        }
        b mcVar = new mc();
        mcVar.fTv.type = 1;
        a.urY.m(mcVar);
    }

    private static boolean b(String str, ay ayVar) {
        int i = 0;
        if (ayVar == null) {
            return false;
        }
        com.tencent.mm.al.b bVar = new com.tencent.mm.al.b();
        bVar.field_wxGroupId = str;
        bVar.field_groupId = ayVar.groupId;
        bVar.field_roomId = ayVar.rhn;
        bVar.field_roomKey = ayVar.rho;
        bVar.field_routeId = ayVar.wLL;
        bVar.field_inviteUserName = ayVar.wON;
        as[] asVarArr = ayVar.wMX;
        if (asVarArr.length > 0) {
            i = asVarArr.length;
        }
        bVar.field_memberCount = i;
        bVar.field_createTime = System.currentTimeMillis();
        if (o.aNj().Bl(str) == null) {
            return o.aNj().a(bVar);
        }
        return o.aNj().b(bVar);
    }

    static boolean c(String str, ay ayVar) {
        if (ayVar == null) {
            return false;
        }
        as[] asVarArr = ayVar.wMX;
        List linkedList = new LinkedList();
        for (as asVar : asVarArr) {
            linkedList.add(asVar.wNl);
        }
        ap.yY();
        String str2 = (String) c.vr().get(2, null);
        if (str2 == null) {
            w.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, ayVar);
            return true;
        }
        boolean z;
        List<com.tencent.mm.plugin.multitalk.b.b> Bm = o.aNk().Bm(str);
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.multitalk.b.b bVar = null;
        for (com.tencent.mm.plugin.multitalk.b.b bVar2 : Bm) {
            com.tencent.mm.plugin.multitalk.b.b bVar22;
            linkedList2.add(bVar22.field_userName);
            if (!bVar22.field_userName.equals(str2)) {
                bVar22 = bVar;
            }
            bVar = bVar22;
        }
        if (bVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (as asVar2 : asVarArr) {
                if (!(asVar2.wNl == null || !asVar2.wNl.equals(str2) || asVar2.status == bVar.field_status)) {
                    com.tencent.mm.plugin.multitalk.b.b bVar3 = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = asVar2.wOr;
                    bVar3.field_memberUuid = (long) asVar2.taQ;
                    bVar3.field_userName = asVar2.wNl;
                    bVar3.field_status = asVar2.status;
                    if (!o.aNk().a(bVar3)) {
                        w.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, asVar2.wNl, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName});
                        z = false;
                    }
                    w.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, asVar2.wNl, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName});
                }
            }
        }
        boolean z2 = z;
        for (as asVar3 : asVarArr) {
            if (!linkedList2.contains(asVar3.wNl)) {
                com.tencent.mm.plugin.multitalk.b.b bVar4 = new com.tencent.mm.plugin.multitalk.b.b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = asVar3.wOr;
                bVar4.field_memberUuid = (long) asVar3.taQ;
                bVar4.field_userName = asVar3.wNl;
                bVar4.field_status = asVar3.status;
                if (!o.aNk().a(bVar4)) {
                    w.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, asVar3.wNl, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName});
                    z2 = false;
                }
                w.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, asVar3.wNl, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName});
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (o.aNk().bv(str, str2)) {
                    w.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    w.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        return z;
    }
}
