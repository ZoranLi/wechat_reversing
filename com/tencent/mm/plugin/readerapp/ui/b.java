package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    public Context context;
    private f isJ;
    private x jiL;

    static class AnonymousClass3 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;
        final /* synthetic */ Context val$context;

        AnonymousClass3(boolean z, Context context, k kVar) {
            this.jWT = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            if (this.jWT) {
                b.gz(true);
            }
            int xW = m.xW();
            if (this.jWT) {
                xW &= -524289;
            } else {
                xW |= SQLiteGlobal.journalSizeLimit;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(xW));
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_aqr = new aqr();
            com_tencent_mm_protocal_c_aqr.tdB = SQLiteGlobal.journalSizeLimit;
            if (this.jWT) {
                xW = 0;
            } else {
                xW = 1;
            }
            com_tencent_mm_protocal_c_aqr.tVo = xW;
            ap.yY();
            c.wQ().b(new e.a(39, com_tencent_mm_protocal_c_aqr));
            if (!this.jWT) {
                final ProgressDialog a = g.a(this.val$context, this.val$context.getString(R.l.eHV), false, null);
                com.tencent.mm.plugin.readerapp.b.g.a(new com.tencent.mm.plugin.readerapp.b.g.a(this) {
                    final /* synthetic */ AnonymousClass3 oJW;

                    public final void aVY() {
                        if (a != null) {
                            a.dismiss();
                        }
                    }
                });
                b.gz(false);
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    static void gz(boolean z) {
        int xR = m.xR();
        if (z) {
            xR &= -1025;
        } else {
            xR |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        ap.yY();
        c.vr().set(40, Integer.valueOf(xR));
        xR = z ? 2 : 1;
        ap.yY();
        c.wQ().b(new com.tencent.mm.ao.g(26, xR));
    }

    public final boolean sa(String str) {
        boolean z = false;
        w.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.addFlags(67108864);
            intent.putExtra(Columns.TYPE, 20);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            com.tencent.mm.plugin.readerapp.a.a.imw.ou();
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            g.a(this.context, this.context.getString(R.l.dXQ), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ b oJU;

                {
                    this.oJU = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    final ProgressDialog a = g.a(this.oJU.context, this.oJU.context.getString(R.l.eHV), false, null);
                    com.tencent.mm.plugin.readerapp.b.g.a(new com.tencent.mm.plugin.readerapp.b.g.a(this) {
                        final /* synthetic */ AnonymousClass1 oJV;

                        public final void aVY() {
                            a.dismiss();
                        }
                    });
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td(str);
            boolean aVZ = com.tencent.mm.plugin.readerapp.b.c.aVZ();
            if (aVZ) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.vqm = z2;
            if (!aVZ) {
                z = true;
            }
            gz(z);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ b oJU;

                {
                    this.oJU = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.g(this.oJU.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(o.fl(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        adH();
        return true;
    }

    private void adH() {
        int i = 1;
        int i2 = (m.xW() & SQLiteGlobal.journalSizeLimit) == 0 ? 1 : 0;
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftB);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dZk));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_readerappnews_recv_remind");
        boolean aVZ = com.tencent.mm.plugin.readerapp.b.c.aVZ();
        w.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = " + aVZ);
        checkBoxPreference.vqm = aVZ;
        if (i2 != 0) {
            this.isJ.Te("contact_info_readerappnews_install");
            return;
        }
        this.isJ.Te("contact_info_readerappnews_subscribe");
        this.isJ.Te("contact_info_readerappnews_view");
        this.isJ.Te("contact_info_readerappnews_clear_data");
        this.isJ.Te("contact_info_readerappnews_uninstall");
        this.isJ.Te("contact_info_readerappnews_recv_remind");
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final ProgressDialog a = g.a(context, string, true, null);
        final ae anonymousClass3 = new AnonymousClass3(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
            }
        }, 5000);
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.plugin.readerapp.a.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
