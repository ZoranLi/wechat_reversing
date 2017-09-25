package com.tencent.mm.plugin.notification.d;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;

public final class c extends a<au> {
    private com.tencent.mm.sdk.b.c oau = new com.tencent.mm.sdk.b.c<nw>(this) {
        final /* synthetic */ c oaw;

        {
            this.oaw = r2;
            this.usg = nw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final nw nwVar = (nw) bVar;
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 oay;

                public final void run() {
                    ce ceVar = nwVar.fVc.fCZ;
                    if (c.BT(ceVar.field_talker)) {
                        this.oay.oaw.bc(ceVar);
                    }
                }
            });
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oav = new com.tencent.mm.sdk.b.c<ny>(this) {
        final /* synthetic */ c oaw;

        {
            this.oaw = r2;
            this.usg = ny.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ny nyVar = (ny) bVar;
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 oaA;

                public final void run() {
                    ce ceVar = nyVar.fVe.fCZ;
                    if (c.BT(ceVar.field_talker)) {
                        this.oaA.oaw.bd(ceVar);
                    }
                }
            });
            return false;
        }
    };

    protected final /* bridge */ /* synthetic */ long be(Object obj) {
        return ((au) obj).field_msgId;
    }

    protected final /* synthetic */ ArrayList bf(Object obj) {
        return e.P((au) obj);
    }

    public static boolean BT(String str) {
        if ((x.QM(str) || x.QO(str)) && !x.eO(str)) {
            return false;
        }
        return true;
    }

    public final void aPI() {
        com.tencent.mm.sdk.b.a.urY.b(this.oau);
    }

    public final void aPJ() {
        com.tencent.mm.sdk.b.a.urY.b(this.oav);
    }

    public final void cL(final long j) {
        ap.yY();
        final au cA = com.tencent.mm.u.c.wT().cA(j);
        af.v(new Runnable(this) {
            final /* synthetic */ c oaw;

            public final void run() {
                w.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[]{Long.valueOf(j)});
                b mvVar = new mv();
                mvVar.fUd.fCZ = cA;
                com.tencent.mm.sdk.b.a.urY.m(mvVar);
            }
        });
    }

    public final void aPK() {
        com.tencent.mm.sdk.b.a.urY.c(this.oau);
    }

    public final void aPL() {
        com.tencent.mm.sdk.b.a.urY.c(this.oav);
    }

    protected final void aPD() {
        w.d("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[]{Integer.valueOf(this.oad.oao.size())});
        if (this.oad.oao.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            w.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        } else if (this.oad.oao.size() == 1) {
            long j = this.oad.get(0);
            ap.yY();
            String str = com.tencent.mm.u.c.wT().cA(j).field_talker;
            Intent intent2 = new Intent();
            intent2.putExtra("Main_User", str);
            intent2.putExtra("From_fail_notify", true);
            intent2.addFlags(67108864);
            intent2.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (VERSION.SDK_INT < 16) {
                intent2.putExtra("resend_fail_messages", true);
            }
            d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
        }
    }

    protected final int getType() {
        return 1;
    }

    protected final void M(ArrayList<Long> arrayList) {
        ap.yY();
        com.tencent.mm.u.c.wT().J(arrayList);
    }

    protected final String qG(int i) {
        return this.mContext.getString(R.l.eDS, new Object[]{Integer.valueOf(i)});
    }

    protected final String cA(int i, int i2) {
        return this.mContext.getString(R.l.eEy, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String K(int i, int i2, int i3) {
        return this.mContext.getString(R.l.eEz, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String cB(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.eEw, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.eEv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean cM(long j) {
        ap.yY();
        w.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(com.tencent.mm.u.c.wT().cA(j).field_msgId)});
        if (com.tencent.mm.u.c.wT().cA(j).field_msgId != 0) {
            return true;
        }
        return false;
    }
}
