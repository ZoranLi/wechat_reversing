package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import com.tencent.mm.R;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.nq;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.al;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;

public final class f implements am {
    private a jOG = new a(this) {
        final /* synthetic */ f srI;

        {
            this.srI = r1;
        }

        public final void a(d.a aVar) {
            String str = (String) bh.q(n.a(aVar.hst.tff), "sysmsg").get(".sysmsg.pushloginurl.url");
            if (bg.mA(str)) {
                w.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
            }
            b nqVar = new nq();
            nqVar.fUL.fUM = str;
            nqVar.fUL.type = 1;
            com.tencent.mm.sdk.b.a.urY.m(nqVar);
            aVar.hst.tfj = null;
        }
    };
    private e srF = new e();
    private al srG = new al(this) {
        final /* synthetic */ f srI;

        {
            this.srI = r1;
        }

        public final void yP() {
            ap.yY();
            if (c.wM()) {
                f.bAF();
            }
        }
    };
    private com.tencent.mm.sdk.b.c srH = new com.tencent.mm.sdk.b.c<nq>(this) {
        final /* synthetic */ f srI;

        {
            this.srI = r2;
            this.usg = nq.class.getName().hashCode();
        }

        private boolean a(final nq nqVar) {
            if (nqVar != null && (nqVar instanceof nq)) {
                final k cVar = new c(nqVar.fUL.fUM);
                ap.vd().a(971, new e(this) {
                    final /* synthetic */ AnonymousClass3 srL;

                    public final void a(int i, int i2, String str, k kVar) {
                        CharSequence charSequence;
                        Intent intent;
                        Object obj;
                        ap.vd().b(971, this);
                        qm qmVar = (qm) cVar.hKp.hsk.hsr;
                        w.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            if (qmVar.twc != null) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", nqVar.fUL.fUM);
                                intent2.putExtra("intent.key.type", 0);
                                intent2.putExtra("intent.key.icon.type", qmVar.twc.tvY);
                                intent2.putExtra("intent.key.ok.string", qmVar.twc.twm);
                                intent2.putExtra("intent.key.cancel.string", qmVar.twc.twn);
                                intent2.putExtra("intent.key.title.string", qmVar.twc.tvZ);
                                intent2.putExtra("intent.key.content.string", qmVar.twc.twr);
                                intent2.putExtra("intent.key.login.client.version", qmVar.twg);
                                intent2.putExtra("intent.key.function.control", qmVar.twh);
                                String str2 = qmVar.twc.tvZ;
                                StringBuilder stringBuilder = new StringBuilder();
                                Cursor cursor = null;
                                try {
                                    ap.yY();
                                    cursor = c.wW().a(o.hlr, null, com.tencent.mm.k.a.gTS, true);
                                    if (cursor != null) {
                                        int count;
                                        if (cursor.getCount() < qmVar.twc.two) {
                                            count = cursor.getCount();
                                        } else {
                                            count = qmVar.twc.two;
                                        }
                                        int columnIndex = cursor.getColumnIndex("username");
                                        for (int i3 = 0; i3 < count; i3++) {
                                            if (cursor.moveToPosition(i3)) {
                                                stringBuilder.append(cursor.getString(columnIndex));
                                                if (i3 < count - 1) {
                                                    stringBuilder.append(",");
                                                }
                                            }
                                        }
                                    }
                                    intent2.putExtra("intent.key.ok.session.list", stringBuilder.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence = str2;
                                        intent = intent2;
                                    }
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                                    if (cursor != null) {
                                        cursor.close();
                                        obj = str2;
                                        intent = intent2;
                                    }
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                                obj = str2;
                                intent = intent2;
                            }
                            charSequence = null;
                            intent = null;
                        } else if (i2 == -1) {
                            if (qmVar.twd != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", nqVar.fUL.fUM);
                                intent.putExtra("intent.key.type", -1);
                                intent.putExtra("intent.key.title.string", qmVar.twd.twa);
                                intent.putExtra("intent.key.icon.type", qmVar.twd.tvY);
                                intent.putExtra("intent.key.ok.string", qmVar.twd.twb);
                                intent.putExtra("intent.key.content.string", qmVar.twd.tvZ);
                                charSequence = qmVar.twd.tvZ;
                            }
                            charSequence = null;
                            intent = null;
                        } else {
                            if (i2 == -2 && qmVar.twe != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", nqVar.fUL.fUM);
                                intent.putExtra("intent.key.type", -2);
                                intent.putExtra("intent.key.title.string", qmVar.twe.twa);
                                intent.putExtra("intent.key.icon.type", qmVar.twe.tvY);
                                intent.putExtra("intent.key.ok.string", qmVar.twe.twb);
                                intent.putExtra("intent.key.content.string", qmVar.twe.tvZ);
                                charSequence = qmVar.twe.tvZ;
                            }
                            charSequence = null;
                            intent = null;
                        }
                        if (intent != null) {
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClass(ab.getContext(), ExtDeviceWXLoginUI.class);
                            ab.getContext().startActivity(intent);
                            Intent intent3 = new Intent(intent);
                            intent3.setFlags(67108864);
                            if (nqVar.fUL.type == 1) {
                                Notification notification = new Builder(ab.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(ab.getContext().getString(R.l.bpJ)).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(ab.getContext(), 0, intent3, 134217728)).getNotification();
                                notification.icon = com.tencent.mm.ba.a.bCk();
                                notification.flags |= 16;
                                notification.sound = RingtoneManager.getDefaultUri(2);
                                ap.getNotification().notify(38, notification);
                            }
                        }
                    }
                });
                ap.vd().a(cVar, 0);
            }
            return false;
        }
    };

    public final void onAccountRelease() {
        d.c.aA(Integer.valueOf(51));
        ap.getSysCmdMsgExtension().b("pushloginurl", this.jOG, true);
        ap.yY();
        c.b(this.srG);
        com.tencent.mm.sdk.b.a.urY.c(this.srH);
        bAF();
    }

    public final HashMap<Integer, g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(51), this.srF);
        ap.getSysCmdMsgExtension().a("pushloginurl", this.jOG, true);
        ap.yY();
        c.a(this.srG);
        com.tencent.mm.sdk.b.a.urY.b(this.srH);
    }

    public final void aN(boolean z) {
    }

    public static void bAF() {
        ap.getNotification().cancel(38);
    }
}
