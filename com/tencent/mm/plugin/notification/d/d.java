package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kf;
import com.tencent.mm.e.a.mw;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.e.a.pf;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class d extends a<b> {
    private c oaB = new c<pf>(this) {
        final /* synthetic */ d oaD;

        {
            this.oaD = r2;
            this.usg = pf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final pf pfVar = (pf) bVar;
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 oaF;

                public final void run() {
                    pf pfVar = pfVar;
                    b bVar = new b();
                    bVar.id = pfVar.fWf.fWe;
                    this.oaF.oaD.bd(bVar);
                }
            });
            return false;
        }
    };
    private c oaC = new c<pe>(this) {
        final /* synthetic */ d oaD;

        {
            this.oaD = r2;
            this.usg = pe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final pe peVar = (pe) bVar;
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 oaH;

                public final void run() {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(589825, Boolean.valueOf(true));
                    pe peVar = peVar;
                    b bVar = new b();
                    bVar.id = peVar.fWd.fWe;
                    this.oaH.oaD.bc(bVar);
                }
            });
            return false;
        }
    };

    protected final /* bridge */ /* synthetic */ long be(Object obj) {
        return ((b) obj).id;
    }

    protected final /* synthetic */ ArrayList bf(Object obj) {
        ArrayList bdx = m.pQG.bdx();
        if (bdx.size() == 0) {
            w.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        return bdx;
    }

    protected final void aPD() {
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                w.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[]{componentName.getClassName()});
                if (componentName.getClassName().contains("En_424b8e16")) {
                    w.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        com.tencent.mm.bb.d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
    }

    protected final int getType() {
        return 2;
    }

    protected final void M(ArrayList<Long> arrayList) {
        b kfVar = new kf();
        kfVar.fQI.fMd = arrayList;
        com.tencent.mm.sdk.b.a.urY.m(kfVar);
    }

    public final void aPI() {
        com.tencent.mm.sdk.b.a.urY.b(this.oaC);
    }

    public final void aPJ() {
        com.tencent.mm.sdk.b.a.urY.b(this.oaB);
    }

    public final void cL(final long j) {
        af.v(new Runnable(this) {
            final /* synthetic */ d oaD;

            public final void run() {
                w.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[]{Long.valueOf(j)});
                b mwVar = new mw();
                mwVar.fUe.fUf = (int) j;
                com.tencent.mm.sdk.b.a.urY.m(mwVar);
            }
        });
    }

    public final void aPK() {
        com.tencent.mm.sdk.b.a.urY.c(this.oaC);
    }

    public final void aPL() {
        com.tencent.mm.sdk.b.a.urY.c(this.oaB);
    }

    protected final String qG(int i) {
        return this.mContext.getString(R.l.eDT, new Object[]{Integer.valueOf(i)});
    }

    protected final String cA(int i, int i2) {
        return this.mContext.getString(R.l.eEA, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String K(int i, int i2, int i3) {
        return this.mContext.getString(R.l.eEB, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String cB(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.eEx, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.eDU, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean cM(long j) {
        w.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[]{Long.valueOf(j), Boolean.valueOf(m.pQG.sN((int) j))});
        return m.pQG.sN((int) j);
    }

    protected final void aPs() {
        if (ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(589825, Boolean.valueOf(false));
        }
    }
}
