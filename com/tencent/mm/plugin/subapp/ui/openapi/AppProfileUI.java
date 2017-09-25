package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ao.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements a {
    private ae handler = null;
    private f isJ;
    private com.tencent.mm.pluginsdk.model.app.f mxk;
    private AppHeaderPreference.a qUx;

    public final int ON() {
        return R.o.ftf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onResume() {
        super.onResume();
        an.aRr().c(this);
    }

    protected void onPause() {
        an.aRr().f(this);
        super.onPause();
    }

    protected final void KC() {
        boolean z = true;
        this.qUx = new AppHeaderPreference.a(this) {
            final /* synthetic */ AppProfileUI qUy;

            {
                this.qUy = r1;
            }

            public final String bnd() {
                return g.a(this.qUy.uSU.uTo, this.qUy.mxk, null);
            }

            public final Bitmap bne() {
                return g.b(this.qUy.mxk.field_appId, 1, com.tencent.mm.bg.a.getDensity(this.qUy));
            }

            public final String hT(boolean z) {
                return this.qUy.uSU.uTo.getString(z ? R.l.eTC : R.l.eTJ);
            }

            public final String getHint() {
                Context context = this.qUy.uSU.uTo;
                com.tencent.mm.pluginsdk.model.app.f a = this.qUy.mxk;
                if (context == null || a == null) {
                    return null;
                }
                String dz = g.dz(context);
                if (dz.equalsIgnoreCase("zh_CN")) {
                    return a.field_appDiscription;
                }
                return (dz.equalsIgnoreCase("zh_TW") || dz.equalsIgnoreCase("zh_HK")) ? bg.mA(a.field_appDiscription_tw) ? a.field_appDiscription : a.field_appDiscription_tw : dz.equalsIgnoreCase("en") ? bg.mA(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en : bg.mA(a.field_appDiscription_en) ? a.field_appDiscription : a.field_appDiscription_en;
            }
        };
        this.mxk = g.aJ(getIntent().getStringExtra("AppProfileUI_AppId"), true);
        String str = "initView : appInfo does not exist";
        if (this.mxk == null) {
            z = false;
        }
        Assert.assertTrue(str, z);
        zi(R.l.dIo);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppProfileUI qUy;

            {
                this.qUy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qUy.finish();
                return true;
            }
        });
        refresh();
    }

    private void refresh() {
        boolean z;
        boolean z2 = true;
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftf);
        if (this.mxk.field_status == 1) {
            this.isJ.Te("app_profile_add");
        } else {
            this.isJ.Te("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.isJ.Td("app_profile_header");
        AppHeaderPreference.a aVar = this.qUx;
        if (this.mxk.field_status == 1) {
            z = true;
        } else {
            z = false;
        }
        if (aVar == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        appHeaderPreference.qUo = aVar;
        appHeaderPreference.fYd = z;
    }

    private void bnf() {
        this.handler = new ae(this) {
            final /* synthetic */ AppProfileUI qUy;

            {
                this.qUy = r1;
            }

            public final void handleMessage(Message message) {
                this.qUy.finish();
            }
        };
        this.handler.sendEmptyMessageDelayed(0, 30);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.mxk.field_status = 1;
            this.mxk.field_modifyTime = System.currentTimeMillis();
            an.aRr().a(this.mxk, new String[0]);
            refresh();
            a(this.mxk, true);
            bnf();
            return true;
        } else if (!str.equals("app_profile_remove")) {
            return false;
        } else {
            this.mxk.field_status = 0;
            this.mxk.field_modifyTime = System.currentTimeMillis();
            an.aRr().a(this.mxk, new String[0]);
            refresh();
            a(this.mxk, false);
            bnf();
            return true;
        }
    }

    public final void a(String str, l lVar) {
        if (str.equals(this.mxk.field_appId)) {
            KC();
        }
    }

    private static void a(com.tencent.mm.pluginsdk.model.app.f fVar, boolean z) {
        List linkedList = new LinkedList();
        linkedList.add(new i.a(10165, fVar.field_appId + "," + (z ? "1" : "2")));
        ap.yY();
        c.wQ().b(new i(linkedList));
    }
}
