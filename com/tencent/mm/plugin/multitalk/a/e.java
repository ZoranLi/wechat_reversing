package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.mc;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.f;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class e implements a {
    private long hPZ = 0;
    public b ict;
    public boolean kmK;
    private Timer lPE;
    private boolean mMu;
    public h mNu;
    c nPA = new c<ja>(this) {
        final /* synthetic */ e nPB;

        {
            this.nPB = r2;
            this.usg = ja.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ja jaVar = (ja) bVar;
            if (jaVar instanceof ja) {
                switch (jaVar.fOT.action) {
                    case 1:
                        jaVar.fOU.fOV = this.nPB.aMM();
                        break;
                }
            }
            return false;
        }
    };
    public boolean nPf;
    public boolean nPg;
    private int nPh;
    public boolean nPi = true;
    public HashSet<String> nPj = new HashSet();
    public com.tencent.mm.plugin.multitalk.ui.widget.e nPk = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
    public MultiTalkGroup nPl = null;
    private k nPm;
    public int nPn = 0;
    private int nPo = 0;
    private int nPp = 2;
    private boolean nPq = false;
    private long nPr = 0;
    private long nPs = 30000;
    public a nPt;
    public i.a nPu;
    public MultiTalkGroup nPv = null;
    public long nPw = 0;
    public aj nPx = new aj(Looper.getMainLooper(), new aj.a(this) {
        final /* synthetic */ e nPB;

        {
            this.nPB = r1;
        }

        public final boolean oQ() {
            w.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
            if (this.nPB.nPv == null) {
                this.nPB.nPw = 0;
                this.nPB.nPx.KH();
                return false;
            } else if (e.cB(ab.getContext())) {
                this.nPB.b(this.nPB.nPv);
                this.nPB.nPv = null;
                this.nPB.nPw = 0;
                this.nPB.nPx.KH();
                g.oUh.a(500, 7, 1, false);
                return false;
            } else if (System.currentTimeMillis() - this.nPB.nPw < 60000) {
                return true;
            } else {
                this.nPB.nPv = null;
                this.nPB.nPw = 0;
                this.nPB.nPx.KH();
                return false;
            }
        }
    }, true);
    public ae nPy = new ae(Looper.getMainLooper());
    BroadcastReceiver nPz = new BroadcastReceiver(this) {
        final /* synthetic */ e nPB;

        {
            this.nPB = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (!this.nPB.aMM()) {
                return;
            }
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                this.nPB.nPy.removeCallbacksAndMessages(null);
                this.nPB.nPy.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nPC;

                    {
                        this.nPC = r1;
                    }

                    public final void run() {
                        i.a aNg = i.aNg();
                        if (aNg != this.nPC.nPB.nPu) {
                            i.a aVar = this.nPC.nPB.nPu;
                            this.nPC.nPB.nPu = aNg;
                            if (aVar == i.a.WIFI || aVar == i.a._4G) {
                                if (this.nPC.nPB.nPu == i.a._3GOr_2G) {
                                    w.i("MicroMsg.MT.MultiTalkManager", "switch network to 2G Or 3G");
                                    this.nPC.nPB.pS(0);
                                }
                            } else if (aVar == i.a._3GOr_2G && (this.nPC.nPB.nPu == i.a.WIFI || this.nPC.nPB.nPu == i.a._4G)) {
                                w.i("MicroMsg.MT.MultiTalkManager", "switch network to WIFI or 4G");
                                this.nPC.nPB.pS(1);
                            }
                            if (this.nPC.nPB.nPt != null) {
                                this.nPC.nPB.nPt.a(this.nPC.nPB.nPu);
                                return;
                            }
                            return;
                        }
                        w.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[]{this.nPC.nPB.nPu.name()});
                    }
                }, 8000);
                return;
            }
            w.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[]{Integer.valueOf(i.n(context, intent))});
            if (i.n(context, intent) == 0) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nPC;

                    {
                        this.nPC = r1;
                    }

                    public final void run() {
                        o.aNm().nOT.lZ(false);
                    }
                });
            } else {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nPC;

                    {
                        this.nPC = r1;
                    }

                    public final void run() {
                        o.aNm().nOT.lZ(true);
                    }
                });
            }
        }
    };

    public e() {
        com.tencent.mm.sdk.b.a.urY.b(this.nPA);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ab.getContext().registerReceiver(this.nPz, intentFilter);
        this.mNu = new h(ab.getContext());
        this.ict = new b(ab.getContext());
    }

    public final boolean aMK() {
        if (i.aNf()) {
            return false;
        }
        return i.pT(this.nPh);
    }

    public final boolean aML() {
        if (i.aNf()) {
            return false;
        }
        return i.pU(this.nPh);
    }

    public final boolean aMM() {
        boolean z;
        if (this.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Init || this.nPl == null) {
            z = false;
        } else {
            z = true;
        }
        w.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean aMN() {
        boolean z;
        if (this.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Starting || this.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
            z = true;
        } else {
            z = false;
        }
        w.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean aMO() {
        boolean z;
        if (this.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
            z = true;
        } else {
            z = false;
        }
        w.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final long aMP() {
        return System.currentTimeMillis() - this.hPZ;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        if (!aMM()) {
            w.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            this.nPl = multiTalkGroup;
            this.nPn = 0;
            this.nPh = 1;
            this.nPj.clear();
            aMQ();
            sort();
            return true;
        } else if (i.a(multiTalkGroup, this.nPl)) {
            w.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            MultiTalkGroup multiTalkGroup2 = this.nPl;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.wPj) {
                hashMap.put(multiTalkGroupMember.wPk, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.wPj) {
                if (!m.xL().equals(multiTalkGroupMember2.wPk) && m.xL().equals(multiTalkGroupMember2.wPl) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.wPk) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.wPk)).status == 20) {
                        String str = multiTalkGroupMember2.wPk;
                        Toast.makeText(ab.getContext(), com.tencent.mm.pluginsdk.ui.d.h.a(ab.getContext(), ab.getContext().getString(R.l.eCp, new Object[]{n.eK(str)})), 0).show();
                    }
                }
            }
            this.nPl = multiTalkGroup;
            aMQ();
            sort();
            return true;
        } else {
            w.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[]{i.h(this.nPl), i.h(multiTalkGroup)});
            return false;
        }
    }

    private void sort() {
        w.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[]{this.nPl.wPj});
        List linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.nPl.wPj) {
            if (multiTalkGroupMember.wPk.equals(m.xL())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>(this) {
            final /* synthetic */ e nPB;

            {
                this.nPB = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return -((MultiTalkGroupMember) obj).wPk.compareTo(((MultiTalkGroupMember) obj2).wPk);
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>(this) {
            final /* synthetic */ e nPB;

            {
                this.nPB = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (multiTalkGroupMember.wOf > multiTalkGroupMember2.wOf) {
                    return -1;
                }
                return multiTalkGroupMember.wOf < multiTalkGroupMember2.wOf ? 1 : 0;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>(this) {
            final /* synthetic */ e nPB;

            {
                this.nPB = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (!(multiTalkGroupMember.status == 10 && multiTalkGroupMember2.status == 10)) {
                    if (multiTalkGroupMember.status == 10) {
                        return -1;
                    }
                    if (multiTalkGroupMember.status == 10) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        if (obj != null) {
            linkedList.add(obj);
        }
        this.nPl.wPj = linkedList;
        w.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[]{this.nPl.wPj});
    }

    private void aMQ() {
        for (MultiTalkGroupMember multiTalkGroupMember : this.nPl.wPj) {
            if (multiTalkGroupMember.status != 10 && this.nPj.remove(multiTalkGroupMember.wPk)) {
                w.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[]{multiTalkGroupMember.wPk});
            }
        }
    }

    public final void a(Activity activity, String str, String str2) {
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.kmK);
        objArr[1] = Boolean.valueOf(this.nPg);
        objArr[2] = Boolean.valueOf(this.nPi);
        objArr[3] = this.nPk.toString();
        objArr[4] = Boolean.valueOf(this.nPl == null);
        w.i(str3, str4, objArr);
        d.aMI();
        if (aMY()) {
            com.tencent.mm.ui.base.g.h(activity, R.l.esz, R.l.dIO);
        } else if (d.brj()) {
            com.tencent.mm.ui.base.g.h(activity, R.l.esD, R.l.dIO);
        } else if (d.brk()) {
            com.tencent.mm.ui.base.g.h(activity, R.l.esC, R.l.dIO);
        } else if (com.tencent.mm.al.a.HD()) {
            com.tencent.mm.ui.base.g.h(activity, R.l.esy, R.l.dIO);
        } else if (d.brl()) {
            com.tencent.mm.ui.base.g.h(activity, R.l.esB, R.l.dIO);
        } else if (aMM()) {
            com.tencent.mm.al.a.a(activity, R.l.eBZ, null);
        } else if (!this.nPq || System.currentTimeMillis() - this.nPr >= this.nPs) {
            this.nPq = false;
            List<String> f = bg.f(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.wPg = o.aNm().nOT.cdp();
            multiTalkGroup.wPh = str2;
            for (String str5 : f) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.wPk = str5;
                if (str5.equals(m.xL())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.wPj.add(multiTalkGroupMember);
            }
            o.aNm().nOT.aK(bg.f((Integer) ap.yW().get(1)), m.xL());
            if (o.aNm().nOT.f(multiTalkGroup.wPg, str2, f)) {
                d.aMG();
            } else {
                d.aMH();
            }
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Creating);
            c(multiTalkGroup);
        } else {
            com.tencent.mm.al.a.a(activity, R.l.eCi, null);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        int i = 4;
        w.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(false), Boolean.valueOf(z3)});
        o.aNn().aMX();
        if (aMM()) {
            com.tencent.mm.sdk.b.b mcVar = new mc();
            mcVar.fTv.type = 2;
            com.tencent.mm.sdk.b.a.urY.m(mcVar);
            String l = i.l(this.nPl);
            d.AW(l);
            if (this.nPk != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                boolean k = i.k(this.nPl);
                long aMP = aMP();
                if (!k) {
                    i = z2 ? aMP >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                d.a(k, aMP, l, i);
            } else {
                d.pR(this.nPn);
                d.l((long) this.nPn, l);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.e eVar = this.nPk;
            if (this.nPt != null) {
                this.nPt.aMw();
            }
            this.nPk = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
            aMW();
            aDI();
            Wp();
            o.aNl().reset();
            o.aNo().aNh();
            if (this.nPl != null) {
                a(this.nPl, eVar, z2);
                String str = this.nPl.wPf;
                if (bg.mA(str)) {
                    str = this.nPl.wPg;
                }
                o.aNm().nOT.Bf(str);
                this.nPl = null;
            }
            this.nPh = 0;
            this.nPg = true;
            this.kmK = false;
            this.nPi = true;
            this.hPZ = 0;
            this.nPn = 0;
            this.nPj.clear();
            this.nPo = 0;
            return;
        }
        aMW();
        aDI();
        Wp();
        this.nPl = null;
        this.nPh = 0;
        this.hPZ = 0;
        this.nPn = 0;
        this.nPj.clear();
        this.nPk = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
        this.nPo = 0;
    }

    public final void b(String str, String str2, boolean z, boolean z2) {
        if (!j.et(str)) {
            w.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{str});
            ag.a.hlS.a(str, "", new ag.b.a(this) {
                final /* synthetic */ e nPB;

                {
                    this.nPB = r1;
                }

                public final void p(String str, boolean z) {
                }
            });
        }
        au auVar = new au();
        auVar.setType(64);
        auVar.z(System.currentTimeMillis());
        auVar.dv(6);
        auVar.dw(2);
        String eK = n.eK(str2);
        if (!(eK == null || eK.equals(""))) {
            str2 = eK;
        }
        eK = str2 + ab.getContext().getString(R.l.eCs);
        auVar.setContent(eK);
        if (j.eu(str)) {
            auVar.cH(str);
            ap.yY();
            com.tencent.mm.u.c.wT().L(auVar);
            ap.yY();
            com.tencent.mm.e.b.aj Rm = com.tencent.mm.u.c.wW().Rm(str);
            if (Rm != null) {
                if (z) {
                    Rm.dt(Rm.field_unReadCount + 1);
                }
                Rm.setContent(eK);
                ap.yY();
                if (com.tencent.mm.u.c.wW().a(Rm, str) == -1) {
                    w.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :" + str);
                }
                if (z2) {
                    ((ai) ap.getNotification()).a(auVar);
                    return;
                }
                return;
            }
            com.tencent.mm.storage.ae aeVar = new com.tencent.mm.storage.ae();
            aeVar.setUsername(str);
            if (z) {
                aeVar.dt(1);
            }
            aeVar.setContent(eK);
            ap.yY();
            com.tencent.mm.u.c.wW().d(aeVar);
            if (z2) {
                ((ai) ap.getNotification()).a(auVar);
            }
        }
    }

    public static void AX(String str) {
        w.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        ce auVar = new au();
        auVar.setType(64);
        auVar.z(System.currentTimeMillis());
        auVar.dv(6);
        auVar.setContent(ab.getContext().getString(R.l.eCu));
        if (j.eu(str)) {
            auVar.cH(str);
            auVar.setContent(auVar.field_content);
            ap.yY();
            com.tencent.mm.u.c.wT().L(auVar);
        }
    }

    private static void a(MultiTalkGroup multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e eVar, boolean z) {
        w.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting && z) {
            ce auVar = new au();
            auVar.setType(64);
            auVar.z(System.currentTimeMillis());
            auVar.dv(6);
            auVar.setContent(ab.getContext().getString(R.l.eCu));
            if (j.eu(multiTalkGroup.wPh)) {
                auVar.cH(multiTalkGroup.wPh);
                auVar.setContent(auVar.field_content);
                ap.yY();
                com.tencent.mm.u.c.wT().L(auVar);
            }
        }
    }

    public final void e(int i, Object obj) {
        int i2;
        w.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -14256:
                w.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = R.l.eBQ;
                if (!(obj == null || ((y) obj) == null)) {
                    com.tencent.wecall.talkroom.model.a.chg().mk(false);
                    break;
                }
            case -14255:
                String str = "MicroMsg.MT.MultiTalkManager";
                String str2 = "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.nPl;
                objArr[2] = this.nPl != null ? this.nPl.wPh : "";
                w.i(str, str2, objArr);
                if (obj != null) {
                    y yVar = (y) obj;
                    if (yVar != null) {
                        w.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + yVar.groupId);
                        if (yVar.wLI != null) {
                            o.aNp().Bh(yVar.wLI.wNQ);
                            w.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + yVar.wLI.wNQ);
                        }
                        if (!o.aNm().nOT.Bf(yVar.groupId)) {
                            w.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + yVar.groupId);
                        }
                    }
                }
                i2 = R.l.eCq;
                break;
            case -1400:
                i2 = R.l.eBP;
                break;
            case -1300:
                i2 = R.l.eBO;
                this.nPq = true;
                this.nPr = System.currentTimeMillis();
                if (obj != null) {
                    x xVar = (x) obj;
                    if (xVar != null) {
                        w.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + xVar.wNd);
                        if (xVar.wNd != 0) {
                            this.nPs = (long) (xVar.wNd * 1000);
                            break;
                        }
                    }
                }
                break;
            case -1200:
                i2 = R.l.eBN;
                break;
            case -1100:
                i2 = R.l.eBM;
                break;
            case DownloadResult.CODE_UNDEFINED /*-1000*/:
                i2 = R.l.eBL;
                break;
            case -900:
                i2 = R.l.eBY;
                break;
            case -800:
                i2 = R.l.eBX;
                break;
            case -700:
                i2 = R.l.eBW;
                break;
            case -600:
                i2 = R.l.eBV;
                break;
            case -500:
                i2 = R.l.eBU;
                break;
            case -400:
                i2 = R.l.eBT;
                break;
            case -300:
                i2 = R.l.eBS;
                break;
            case -200:
                d.fR(false);
                i2 = R.l.eBR;
                break;
            case -100:
                d.fQ(false);
                i2 = R.l.eBK;
                break;
            default:
                i2 = R.l.eBV;
                break;
        }
        if (i != -800 && i != -500) {
            Toast.makeText(ab.getContext(), ab.getContext().getString(i2), 0).show();
            c(false, false, true);
        }
    }

    public final void b(final MultiTalkGroup multiTalkGroup) {
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.kmK);
        objArr[1] = Boolean.valueOf(this.nPg);
        objArr[2] = Boolean.valueOf(this.nPi);
        objArr[3] = this.nPk.toString();
        objArr[4] = Boolean.valueOf(this.nPl == null);
        w.i(str, str2, objArr);
        d.aMJ();
        if (f.sm() || cB(ab.getContext())) {
            int i;
            boolean z;
            str = i.m(multiTalkGroup);
            ap.yY();
            com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
            if (com.tencent.mm.i.g.sV().getInt("MultitalkBlockReceiver", 0) == 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i == 0 || Rc.tA()) {
                w.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                af.f(new Runnable(this) {
                    final /* synthetic */ e nPB;

                    public final void run() {
                        String str = multiTalkGroup.wPf;
                        if (bg.mA(str)) {
                            str = multiTalkGroup.wPg;
                        }
                        o.aNm().nOT.Bf(str);
                    }
                }, 1000);
                d.ae(3, i.l(multiTalkGroup));
                return;
            }
            if (!(aMM() || d.brk() || d.brj() || com.tencent.mm.al.a.HD())) {
                if (((TelephonyManager) ab.getContext().getSystemService("phone")).getCallState() != 0) {
                    i = 1;
                } else {
                    z = false;
                }
                if (i == 0 && !d.brl() && com.tencent.mm.j.a.ez(Rc.field_type)) {
                    if (!j.et(multiTalkGroup.wPh)) {
                        w.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.wPh});
                        ag.a.hlS.a(multiTalkGroup.wPh, "", null);
                    }
                    w.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
                    b(com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting);
                    d.ae(1, i.l(multiTalkGroup));
                    if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                        w.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[]{str, m.xL()});
                        c(multiTalkGroup);
                        return;
                    }
                    w.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[]{str, m.xL()});
                    if (a(multiTalkGroup)) {
                        this.nPf = false;
                        aMR();
                        aDK();
                        return;
                    }
                    return;
                }
            }
            w.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[]{i.h(multiTalkGroup)});
            if (!j.et(multiTalkGroup.wPh)) {
                w.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.wPh});
                ag.a.hlS.a(multiTalkGroup.wPh, "", new ag.b.a(this) {
                    final /* synthetic */ e nPB;

                    {
                        this.nPB = r1;
                    }

                    public final void p(String str, boolean z) {
                    }
                });
            }
            af.f(new Runnable(this) {
                final /* synthetic */ e nPB;

                public final void run() {
                    String str = multiTalkGroup.wPf;
                    if (bg.mA(str)) {
                        str = multiTalkGroup.wPg;
                    }
                    o.aNm().nOT.Bf(str);
                }
            }, 1000);
            d.ae(3, i.l(multiTalkGroup));
            return;
        }
        w.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.nPv == null && this.nPx.bJq()) {
            this.nPv = multiTalkGroup;
            this.nPx.v(2000, 2000);
            this.nPw = System.currentTimeMillis();
            g.oUh.a(500, 6, 1, false);
        }
    }

    private void c(MultiTalkGroup multiTalkGroup) {
        if (a(multiTalkGroup)) {
            this.nPf = false;
            aMR();
            aDK();
            com.tencent.mm.bb.d.b(ab.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
    }

    private void aMR() {
        e eVar;
        boolean z;
        e eVar2;
        if (this.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Creating) {
            eVar = this;
        } else if (ap.yZ().qO() || ap.yZ().qI()) {
            eVar = this;
        } else {
            z = true;
            eVar2 = this;
            eVar2.nPg = z;
            this.kmK = false;
            this.nPu = i.aNg();
        }
        eVar2 = eVar;
        z = false;
        eVar2.nPg = z;
        this.kmK = false;
        this.nPu = i.aNg();
    }

    public final void d(MultiTalkGroup multiTalkGroup) {
        d.ae(2, i.l(multiTalkGroup));
        a(multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting, true);
    }

    public final void e(MultiTalkGroup multiTalkGroup) {
        w.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        d.fQ(true);
        if (a(multiTalkGroup)) {
            aMS();
        }
    }

    public final void f(MultiTalkGroup multiTalkGroup) {
        w.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        com.tencent.mm.sdk.b.b mcVar = new mc();
        mcVar.fTv.type = 1;
        com.tencent.mm.sdk.b.a.urY.m(mcVar);
        d.fR(true);
        if (this.nPk != com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Starting);
            c(multiTalkGroup);
        }
        if (aMM() && a(multiTalkGroup)) {
            aMS();
        }
    }

    private void aMS() {
        if (i.i(this.nPl)) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Talking);
        } else {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Starting);
        }
        if (this.nPt != null) {
            this.nPt.aJN();
            i.a aNg = i.aNg();
            if (aNg != this.nPu) {
                this.nPu = aNg;
                if (this.nPu == i.a._3GOr_2G) {
                    w.i("MicroMsg.MT.MultiTalkManager", "now network is on 2G Or 3G...");
                    pS(0);
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.mm.bb.d.b(ab.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        w.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[]{i.h(multiTalkGroup)});
        if (!aMM() || !a(multiTalkGroup)) {
            return;
        }
        if (i.j(this.nPl)) {
            if (this.nPk != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking && i.i(multiTalkGroup)) {
                b(com.tencent.mm.plugin.multitalk.ui.widget.e.Talking);
            }
            if (this.nPt != null && i.c(this.nPk)) {
                this.nPt.aMx();
            }
        } else if (this.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting) {
            c(false, true, false);
        } else {
            c(false, false, false);
        }
    }

    public final void aMT() {
        w.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    }

    public final void fN(boolean z) {
        this.kmK = z;
        if (this.nPt != null) {
            this.nPt.fN(this.kmK);
        }
    }

    public final void aMU() {
        w.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[]{Integer.valueOf(this.nPh)});
    }

    public final void aU(List<com.tencent.pb.common.b.a.a.aj> list) {
        if (aMM()) {
            this.nPj.clear();
            w.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[]{list});
            for (com.tencent.pb.common.b.a.a.aj ajVar : list) {
                if (ajVar.wNm == 2 || ajVar.wNm == 3) {
                    this.nPj.add(ajVar.wNl);
                }
            }
            this.nPj.remove(m.xL());
            w.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[]{this.nPj});
            if (this.nPm != null) {
                this.nPm.pV(this.nPj.size());
            }
            if (this.nPt != null) {
                this.nPt.aMy();
            }
        }
    }

    public final void fS(boolean z) {
        if (aMM() && !this.mMu) {
            this.mMu = true;
            d.d(i.aNd(), o.aNn().aMK(), z);
            Toast.makeText(ab.getContext(), R.l.eCg, 0).show();
            CharSequence string = ab.getContext().getString(R.l.eBF);
            CharSequence string2 = ab.getContext().getString(R.l.eCj);
            Intent intent = new Intent();
            intent.setClass(ab.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(ab.getContext(), 43, intent, 134217728);
            int i = R.g.bhV;
            if (com.tencent.mm.compatible.util.d.ep(19)) {
                i = R.g.bhU;
            }
            Notification a = d.a(new Builder(ab.getContext()).setTicker(string2).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(string2).setContentIntent(activity));
            a.icon = i;
            a.flags |= 32;
            ap.getNotification().a(43, a, false);
            if (this.nPt != null) {
                this.nPt.aDP();
            }
            af.v(new Runnable(this) {
                final /* synthetic */ e nPB;

                {
                    this.nPB = r1;
                }

                public final void run() {
                    Intent intent = new Intent();
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.putExtra("enterMainUiWxGroupId", this.nPB.nPl != null ? this.nPB.nPl.wPh : "");
                    intent.setClass(ab.getContext(), MultiTalkMainUI.class);
                    intent.putExtra("enterMainUiSource", 1);
                    com.tencent.mm.plugin.voip.model.d.bpe().a(intent, new com.tencent.mm.plugin.voip.ui.a(this) {
                        final /* synthetic */ AnonymousClass14 nPF;

                        {
                            this.nPF = r1;
                        }

                        public final boolean aDL() {
                            if (this.nPF.nPB.aMN() || this.nPF.nPB.aMO()) {
                                return true;
                            }
                            return false;
                        }

                        public final void a(Intent intent, com.tencent.mm.plugin.voip.ui.h hVar) {
                            if (this.nPF.nPB.aMO()) {
                                int i = this.nPF.nPB.nPn;
                                hVar.HE(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
                                return;
                            }
                            hVar.HE(ab.getContext().getString(R.l.eCw));
                        }
                    });
                }
            });
        }
    }

    public final void aDI() {
        this.mMu = false;
        com.tencent.mm.plugin.voip.model.d.bpe().dismiss();
        ((NotificationManager) ab.getContext().getSystemService("notification")).cancel(43);
    }

    public final void aMV() {
        w.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.nPt == null) {
            w.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
        } else if (this.nPj.size() == 0) {
            w.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
        } else {
            if (this.nPm == null) {
                w.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[]{Integer.valueOf(this.nPj.size())});
                this.nPm = new k(this.nPt);
                this.nPm.pV(this.nPj.size());
            }
            if (!this.nPm.fBn) {
                this.nPm.start();
            }
        }
    }

    public final void aMW() {
        w.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.nPm != null) {
            this.nPm.stop();
            this.nPm = null;
        }
    }

    public final void fT(boolean z) {
        o.aNm().nOT.fT(z);
        w.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[]{Boolean.valueOf(z)});
        this.nPg = z;
        if (this.nPt != null) {
            this.nPt.fO(this.nPg);
        }
    }

    public final boolean pS(int i) {
        if (!aMN()) {
            return false;
        }
        w.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + i);
        boolean pS = o.aNm().nOT.pS(i);
        w.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[]{Boolean.valueOf(pS)});
        int i2 = this.nPh;
        this.nPh = i;
        if (aML()) {
            aMV();
        } else {
            aMW();
        }
        if (this.nPt == null || i2 == this.nPh) {
            return pS;
        }
        this.nPt.ct(i2, this.nPh);
        return pS;
    }

    private void b(com.tencent.mm.plugin.multitalk.ui.widget.e eVar) {
        boolean z = true;
        com.tencent.mm.plugin.multitalk.ui.widget.e eVar2 = this.nPk;
        this.nPk = eVar;
        if (eVar2 != eVar) {
            if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                com.tencent.mm.sdk.b.b mcVar = new mc();
                mcVar.fTv.type = 1;
                com.tencent.mm.sdk.b.a.urY.m(mcVar);
                d.a(i.k(this.nPl), aMP(), i.l(this.nPl));
                o.aNn().aMX();
                if (ap.yZ().qO() || ap.yZ().qI()) {
                    z = false;
                }
                fT(z);
            }
            if (this.nPt != null) {
                this.nPt.a(eVar);
            }
        }
    }

    private void aDK() {
        w.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.lPE != null) {
            this.lPE.cancel();
            return;
        }
        this.hPZ = System.currentTimeMillis();
        this.nPn = 0;
        this.lPE = new Timer();
        this.lPE.schedule(new TimerTask(this) {
            final /* synthetic */ e nPB;

            {
                this.nPB = r1;
            }

            public final void run() {
                if (this.nPB.aMP() >= 45000 && this.nPB.nPk != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 nPD;

                        {
                            this.nPD = r1;
                        }

                        public final void run() {
                            this.nPD.nPB.c(false, true, false);
                        }
                    });
                }
                if (this.nPB.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                    e eVar = this.nPB;
                    eVar.nPn++;
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 nPD;

                        {
                            this.nPD = r1;
                        }

                        public final void run() {
                            if (this.nPD.nPB.nPk == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                                com.tencent.mm.plugin.voip.model.d.bpe().tt(this.nPD.nPB.nPn);
                                if (this.nPD.nPB.nPt != null) {
                                    this.nPD.nPB.nPt.aDQ();
                                }
                            }
                        }
                    });
                }
            }
        }, 1000, 1000);
    }

    private void Wp() {
        if (this.lPE != null) {
            this.lPE.cancel();
            this.lPE = null;
        }
    }

    public final void fU(boolean z) {
        if (!this.nPf) {
            this.mNu.o(R.k.dyQ, 0, z);
            this.ict.requestFocus();
            this.nPf = true;
        }
    }

    public final void aMX() {
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ e nPB;

            {
                this.nPB = r1;
            }

            public final void run() {
                this.nPB.mNu.stop();
                this.nPB.nPf = false;
                this.nPB.ict.rY();
                ap.yZ().setSpeakerphoneOn(this.nPB.nPg);
            }
        }, "MultiTalkManager_stop_ring");
    }

    private static boolean aMY() {
        boolean z;
        Exception e;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                w.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            w.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    public static boolean cB(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            w.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                w.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ab.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        w.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
        return true;
    }
}
