package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.y.d;
import com.tencent.mm.e.a.jn;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.plugin.notification.d.e;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class a<T> implements c {
    public Context mContext;
    public b oad;
    protected FailSendMsgNotification oae;
    protected boolean oaf;
    protected ArrayList<Long> oag;
    protected ArrayList<Long> oah;
    protected ArrayList<Long> oai;
    private ArrayList<aj> oaj;
    private aj oak;
    private c oal;

    public abstract String K(int i, int i2, int i3);

    public abstract void M(ArrayList<Long> arrayList);

    public abstract void aPD();

    public abstract long be(T t);

    public abstract ArrayList<Long> bf(T t);

    public abstract String cA(int i, int i2);

    public abstract String cB(int i, int i2);

    public abstract void cL(long j);

    public abstract boolean cM(long j);

    public abstract int getType();

    public abstract String qG(int i);

    public a() {
        this.oad = null;
        this.oae = null;
        this.oaf = false;
        this.mContext = null;
        this.oag = null;
        this.oah = null;
        this.oai = null;
        this.oaj = new ArrayList();
        this.oak = null;
        this.oal = new c<qy>(this) {
            final /* synthetic */ a oam;

            {
                this.oam = r2;
                this.usg = qy.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                qy qyVar = (qy) bVar;
                a aVar = this.oam;
                long j = qyVar.fXV.fXW;
                w.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(qyVar.fXV.fXX)});
                if (aVar.oad.cO(j)) {
                    b bVar2 = aVar.oad;
                    int indexOf = bVar2.oao.indexOf(Long.valueOf(j));
                    if (indexOf != -1) {
                        bVar2.oao.set(indexOf, Long.valueOf(r4));
                    }
                }
                return false;
            }
        };
        this.oad = new b();
        this.oae = new FailSendMsgNotification(getType());
        this.oaf = false;
        this.mContext = ab.getContext();
        this.oag = new ArrayList();
        this.oah = new ArrayList();
        this.oai = new ArrayList();
        this.oae.oaX = new com.tencent.mm.plugin.notification.ui.a(this) {
            final /* synthetic */ a oam;

            {
                this.oam = r1;
            }

            public final void aPE() {
                w.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 oan;

                    {
                        this.oan = r1;
                    }

                    public final void run() {
                        g.oUh.i(11425, new Object[]{Integer.valueOf(this.oan.oam.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
                        this.oan.oam.aPB();
                        this.oan.oam.aPu();
                        this.oan.oam.aPt();
                    }
                });
            }

            public final void aPF() {
                w.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 oan;

                    {
                        this.oan = r1;
                    }

                    public final void run() {
                        g.oUh.i(11425, new Object[]{Integer.valueOf(this.oan.oam.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                        this.oan.oam.aPB();
                        this.oan.oam.aPx();
                        this.oan.oam.aED();
                        this.oan.oam.oae.dismiss();
                    }
                });
            }
        };
        this.oae.oaY = new com.tencent.mm.plugin.notification.ui.b(this) {
            final /* synthetic */ a oam;

            {
                this.oam = r1;
            }

            public final void aPG() {
                g.oUh.i(11425, new Object[]{Integer.valueOf(this.oam.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                this.oam.aPB();
                this.oam.aPD();
                if (!this.oam.oaf) {
                    this.oam.oae.dismiss();
                }
            }
        };
        this.oae.oaZ = new com.tencent.mm.plugin.notification.ui.c(this) {
            final /* synthetic */ a oam;

            {
                this.oam = r1;
            }

            public final void onDismiss() {
                this.oam.aED();
            }
        };
        aPo();
    }

    private void aPo() {
        this.oak = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a oam;

            {
                this.oam = r1;
            }

            public final boolean oQ() {
                if (!this.oam.oaf) {
                    return false;
                }
                w.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.oam.oad.oao.size()), Integer.valueOf(this.oam.oag.size()), Integer.valueOf(this.oam.oah.size())});
                this.oam.aPv();
                w.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.oam.oad.oao.size()), Integer.valueOf(this.oam.oag.size()), Integer.valueOf(this.oam.oah.size())});
                if (this.oam.oad.oao.size() > 0) {
                    this.oam.aPq();
                    return true;
                }
                this.oam.aPr();
                return true;
            }
        }, true);
    }

    public final void bc(T t) {
        if (t != null) {
            w.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[]{Long.valueOf(be(t)), aPy(), Boolean.valueOf(this.oaf)});
            if (this.oaf) {
                if (this.oad.cO(be(t)) && !this.oah.contains(Long.valueOf(be(t)))) {
                    this.oah.add(Long.valueOf(be(t)));
                }
                if (!this.oad.cO(be(t))) {
                    w.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.oad.cN(be(t));
                }
                aPq();
                w.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[]{Integer.valueOf(this.oag.size()), Integer.valueOf(this.oah.size())});
                if (this.oag.size() + this.oah.size() < this.oad.oao.size()) {
                    long aPH = this.oad.aPH();
                    if (aPH == -1) {
                        w.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    w.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[]{Long.valueOf(aPH)});
                    aPC();
                    cJ(aPH);
                    return;
                }
                aPr();
            } else if (this.oai.contains(Long.valueOf(be(t)))) {
                this.oai.remove(Long.valueOf(be(t)));
            } else if (t == null) {
                w.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                Collection bf = bf(t);
                if (bf == null || bf.size() <= 0) {
                    w.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                aED();
                b bVar = this.oad;
                if (bf != null && bf.size() > 0) {
                    bVar.oao.addAll(bf);
                }
                aPC();
                w.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[]{Integer.valueOf(this.oad.oao.size()), aPy()});
                g.oUh.i(11426, new Object[]{Integer.valueOf(getType())});
                af.f(new Runnable(this) {
                    final /* synthetic */ a oam;

                    {
                        this.oam = r1;
                    }

                    public final void run() {
                        this.oam.aPp();
                    }
                }, 1000);
            }
        }
    }

    public final void aPp() {
        w.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[]{Boolean.valueOf(e.aPO())});
        this.oae.obb = qG(this.oad.oao.size());
        this.oae.aPT();
        if (!e.aPO() && !this.oae.obg) {
            this.oae.oba = qG(this.oad.oao.size());
            this.oae.aPS();
            this.oae.aPR();
            w.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.oae.show();
            com.tencent.mm.sdk.b.a.urY.c(this.oal);
            com.tencent.mm.sdk.b.a.urY.b(this.oal);
        } else if (this.oae.obg) {
            this.oae.aPS();
            this.oae.aPR();
            w.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.oae.BU(qG(this.oad.oao.size()));
            com.tencent.mm.sdk.b.a.urY.c(this.oal);
            com.tencent.mm.sdk.b.a.urY.b(this.oal);
        } else {
            w.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[]{Boolean.valueOf(e.aPO())});
        }
    }

    public final void bd(T t) {
        w.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[]{Long.valueOf(be(t)), aPy()});
        if (this.oad.cO(be(t))) {
            long be = be(t);
            if (this.oai.contains(Long.valueOf(be)) && this.oah.contains(Long.valueOf(be))) {
                w.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.oai.remove(Long.valueOf(be));
                this.oah.remove(Long.valueOf(be));
            }
            if (this.oaf) {
                this.oag.add(Long.valueOf(be));
                aPq();
                w.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[]{Integer.valueOf(this.oag.size()), Integer.valueOf(this.oah.size())});
                if (this.oag.size() + this.oah.size() < this.oad.oao.size()) {
                    be = this.oad.aPH();
                    if (be == -1) {
                        w.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    w.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[]{Long.valueOf(be)});
                    aPC();
                    cJ(be);
                    return;
                }
                aPr();
                return;
            }
            this.oad.remove(be(t));
            if (this.oad.oao.size() == 0) {
                this.oae.dismiss();
                aED();
                com.tencent.mm.plugin.notification.d.a.qI(getType());
                return;
            }
            w.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.oae.BU(qG(this.oad.oao.size()));
        }
    }

    public final void aPq() {
        if (VERSION.SDK_INT >= 16) {
            this.oae.obb = qG(this.oad.oao.size());
            if (this.oah.size() <= 0) {
                this.oae.BU(cA(this.oad.oao.size(), this.oag.size() + this.oah.size()));
            } else {
                this.oae.BU(K(this.oad.oao.size(), this.oag.size() + this.oah.size(), this.oah.size()));
            }
        }
    }

    public final void aPr() {
        this.oaf = false;
        w.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size()), Integer.valueOf(this.oah.size()), Integer.valueOf(this.oag.size())});
        w.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size()), Integer.valueOf(this.oag.size()), Integer.valueOf(this.oah.size())});
        aPv();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.oag.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (!cM(l.longValue())) {
                arrayList.add(l);
            }
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            this.oag.remove((Long) it.next());
        }
        arrayList.clear();
        it = this.oah.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!cM(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.oah.remove((Long) it2.next());
        }
        w.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size()), Integer.valueOf(this.oag.size()), Integer.valueOf(this.oah.size())});
        if (this.oah.size() <= 0 || VERSION.SDK_INT < 16) {
            com.tencent.mm.plugin.notification.d.a.qI(getType());
        }
        g.oUh.i(11425, new Object[]{Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.oag.size()), Integer.valueOf(this.oah.size())});
        if (VERSION.SDK_INT >= 16) {
            this.oae.aPS();
            this.oae.obb = qG(this.oad.oao.size());
            FailSendMsgNotification failSendMsgNotification = this.oae;
            this.oad.oao.size();
            failSendMsgNotification.BU(cB(this.oag.size(), this.oah.size()));
            this.oae.aPR();
            if (this.oah.size() > 0) {
                this.oae.aPT();
                this.oae.show();
                aPA();
                aPC();
            }
        }
        b jnVar = new jn();
        jnVar.fPX.type = getType();
        com.tencent.mm.sdk.b.a.urY.m(jnVar);
        if (this.oak != null) {
            this.oak.KH();
        } else {
            w.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
        aPw();
        com.tencent.mm.sdk.b.a.urY.c(this.oal);
        aPs();
    }

    public void aPs() {
    }

    public final void aPt() {
        w.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size())});
        this.oaf = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.oae;
            failSendMsgNotification.obi = false;
            failSendMsgNotification.oaU = new d(failSendMsgNotification.mContext);
            failSendMsgNotification.aPQ();
            failSendMsgNotification.show();
            w.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.oae;
            failSendMsgNotification.oaU.j(2, true);
            failSendMsgNotification.obh = true;
            failSendMsgNotification.show();
            w.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.oae.BU(cA(this.oad.oao.size(), 0));
        }
        this.oad.currentIndex = 0;
        aPw();
        com.tencent.mm.sdk.b.a.urY.c(this.oal);
        com.tencent.mm.sdk.b.a.urY.b(this.oal);
        cJ(this.oad.aPH());
        if (this.oak != null) {
            this.oak.v(300000, 300000);
        } else {
            w.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    public final void aPu() {
        w.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size())});
        aPv();
        if (VERSION.SDK_INT >= 16) {
            this.oae.BU(qG(this.oad.oao.size()));
        }
        w.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size())});
    }

    public final void aPv() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.oad.oao.size(); i++) {
            long j = this.oad.get(i);
            if (!cM(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.oad.remove(((Long) it.next()).longValue());
            }
        }
    }

    public final void cJ(final long j) {
        af.f(new Runnable(this) {
            final /* synthetic */ a oam;

            public final void run() {
                this.oam.cK(j);
            }
        }, 200);
    }

    public final void cK(long j) {
        while (!cM(j)) {
            this.oah.add(Long.valueOf(j));
            w.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", new Object[]{Long.valueOf(j)});
            aPq();
            j = this.oad.aPH();
            if (j == -1) {
                w.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (this.oag.size() + this.oah.size() >= this.oad.oao.size()) {
                    w.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aPr();
                    return;
                }
                return;
            }
        }
        w.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", new Object[]{Long.valueOf(j)});
        cL(j);
        aj ajVar = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a oam;

            public final boolean oQ() {
                if (!(this.oam.oag.contains(Long.valueOf(j)) || this.oam.oah.contains(Long.valueOf(j)) || !this.oam.oad.cO(j))) {
                    w.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", new Object[]{Long.valueOf(j)});
                    this.oam.oah.add(Long.valueOf(j));
                    this.oam.oai.add(Long.valueOf(j));
                    if (this.oam.oag.size() + this.oam.oah.size() >= this.oam.oad.oao.size()) {
                        this.oam.aPr();
                    } else {
                        this.oam.cJ(this.oam.oad.aPH());
                    }
                }
                return true;
            }
        }, false);
        ajVar.v(1800000, 1800000);
        this.oaj.add(ajVar);
    }

    private void aPw() {
        Iterator it = this.oaj.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).KH();
        }
        this.oaj.clear();
        this.oai.clear();
    }

    public final void aPx() {
        w.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[]{Integer.valueOf(this.oad.oao.size())});
        if (this.oad.oao.size() > 0) {
            b bVar = this.oad;
            ArrayList arrayList = new ArrayList();
            Iterator it = bVar.oao.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            M(arrayList);
        }
    }

    public final void aED() {
        this.oad.clear();
        this.oaf = false;
        this.oag.clear();
        this.oah.clear();
        aPw();
    }

    private String aPy() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < this.oad.oao.size(); i++) {
            stringBuilder.append(this.oad.get(i) + ", ");
        }
        return stringBuilder.toString();
    }

    public final FailSendMsgNotification aPz() {
        return this.oae;
    }

    private void aPA() {
        this.oad.currentIndex = 0;
        if (this.oag.size() > 0) {
            Iterator it = this.oag.iterator();
            while (it.hasNext()) {
                this.oad.remove(((Long) it.next()).longValue());
            }
        }
        this.oag.clear();
        this.oah.clear();
    }

    protected final void aPB() {
        if (this.oad == null || this.oad.oao.size() == 0) {
            w.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            com.tencent.mm.plugin.notification.d.a.a qH = com.tencent.mm.plugin.notification.d.a.qH(getType());
            if (qH == null) {
                w.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.oak == null) {
                aPo();
            }
            b bVar = qH.oaq;
            Collection collection = qH.oas;
            Collection collection2 = qH.oat;
            int i = qH.oar;
            if (collection.size() == 0 && collection2.size() == 0 && i == 0) {
                w.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.oad.clear();
                this.oad = bVar;
                this.oag.clear();
                this.oah.clear();
                aPp();
            } else if (collection.size() + collection2.size() >= bVar.oao.size()) {
                w.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                aPr();
            } else {
                w.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.oad.clear();
                this.oad = bVar;
                this.oad.currentIndex = i;
                this.oag.clear();
                this.oag.addAll(collection);
                this.oah.clear();
                this.oah.addAll(collection2);
                aPq();
            }
        }
    }

    private void aPC() {
        com.tencent.mm.plugin.notification.d.a.a(getType(), new com.tencent.mm.plugin.notification.d.a.a(this.oad, this.oad.currentIndex, this.oag, this.oah));
    }
}
