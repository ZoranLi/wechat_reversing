package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.hl;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;

public final class g extends l implements b {

    static class AnonymousClass1 implements a {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;
        final /* synthetic */ p jWV;

        AnonymousClass1(boolean z, k kVar, p pVar) {
            this.jWT = z;
            this.jWV = pVar;
        }

        public final boolean oQ() {
            int i;
            int xW = m.xW();
            if (this.jWT) {
                i = xW & -32769;
            } else {
                i = xW | WXMediaMessage.THUMB_LENGTH_LIMIT;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(i));
            ap.yY();
            c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.jWT) {
                g.QZ();
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
            if (this.jWV != null) {
                this.jWV.dismiss();
            }
            return true;
        }
    }

    public final /* bridge */ /* synthetic */ void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(f fVar, x xVar, boolean z, int i) {
        return super.a(fVar, xVar, z, i);
    }

    public final /* bridge */ /* synthetic */ boolean adI() {
        return super.adI();
    }

    public final /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public g(Context context) {
        super(context, new q(context));
        com.tencent.mm.sdk.b.a.urY.m(new hl());
    }

    public static void QZ() {
        ap.yY();
        c.wT().Ao("feedsapp");
        ap.yY();
        c.wW().Rl("feedsapp");
    }

    protected final void clear() {
        QZ();
    }

    protected final void gk(boolean z) {
        Context context = this.context;
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        new aj(new AnonymousClass1(z, null, com.tencent.mm.ui.base.g.a(context, string, true, null)), false).v(1500, 1500);
    }

    protected final boolean aTD() {
        return (m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
    }

    protected final int ON() {
        return R.o.ftp;
    }

    public final boolean sa(String str) {
        if ("contact_info_plugin_view".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            d.b(this.context, "sns", ".ui.En_424b8e16", intent);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            d.b(this.context, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if ("contact_info_plugin_black".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            d.b(this.context, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (!str.equals("contact_info_plugin_uninstall")) {
            return super.sa(str);
        }
        com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.eTI), "", this.context.getString(R.l.dIN), this.context.getString(R.l.dGs), new OnClickListener(this) {
            final /* synthetic */ g oup;

            {
                this.oup = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.oup.gk(false);
            }
        }, null);
        return true;
    }
}
