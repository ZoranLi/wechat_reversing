package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class AddAppUI extends MMPreference implements e {
    private f isJ;
    private AppPreference qUi;
    private AppPreference qUj;

    static /* synthetic */ void a(AddAppUI addAppUI, String str) {
        Intent intent = new Intent(addAppUI, AppProfileUI.class);
        intent.putExtra("AppProfileUI_AppId", str);
        addAppUI.startActivity(intent);
    }

    static /* synthetic */ void f(com.tencent.mm.pluginsdk.model.app.f fVar) {
        fVar.field_status = 0;
        fVar.field_modifyTime = System.currentTimeMillis();
        an.aRr().a(fVar, new String[0]);
    }

    public final int ON() {
        return R.o.ftd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        KC();
        if (this.qUi != null) {
            this.qUi.onResume();
        }
        if (this.qUj != null) {
            this.qUj.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.qUi != null) {
            this.qUi.onPause();
        }
        if (this.qUj != null) {
            this.qUj.onPause();
        }
    }

    protected final void KC() {
        zi(R.l.dCe);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddAppUI qUk;

            {
                this.qUk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qUk.finish();
                return true;
            }
        });
        this.isJ = this.vrv;
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftd);
        this.qUi = (AppPreference) this.isJ.Td("addapp_added");
        this.qUi.qUm = 1;
        this.qUi.qUq = new OnItemClickListener(this) {
            final /* synthetic */ AddAppUI qUk;

            {
                this.qUk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.a(this.qUk, this.qUk.qUi.uw(i).field_appId);
            }
        };
        this.qUi.qUr = new OnItemClickListener(this) {
            final /* synthetic */ AddAppUI qUk;

            {
                this.qUk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.f(this.qUk.qUi.uw(i));
                this.qUk.KC();
            }
        };
        this.qUj = (AppPreference) this.isJ.Td("addapp_available");
        this.qUj.qUm = 0;
        this.qUj.qUq = new OnItemClickListener(this) {
            final /* synthetic */ AddAppUI qUk;

            {
                this.qUk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AddAppUI.a(this.qUk, this.qUk.qUj.uw(i).field_appId);
            }
        };
    }

    public final boolean a(f fVar, Preference preference) {
        if (!preference.igL.equals("addapp_recommend")) {
            return false;
        }
        String d = v.d(this.uSU.uTo.getSharedPreferences(ab.bIX(), 0));
        String string = getString(R.l.dCf, new Object[]{Integer.valueOf(d.sYN), d, v.bIM()});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
