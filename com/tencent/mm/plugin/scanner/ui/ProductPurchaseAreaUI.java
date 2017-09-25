package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class ProductPurchaseAreaUI extends MMPreference {
    protected f jid;
    private String kMS;
    private List<a> oZj;
    private int oZk;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        n.a bA = i.bA(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bA == null || bA.per == null) {
            w.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            return;
        }
        this.kMS = bA.field_productid;
        this.oZk = bA.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        w.i("MicroMsg.ProductPurchaseAreaUI", "referkey:" + stringExtra);
        if (!bg.mA(stringExtra)) {
            for (int i = 0; i < bA.per.size(); i++) {
                if (stringExtra.equals(((com.tencent.mm.plugin.scanner.a.a) bA.per.get(i)).oVK)) {
                    this.oZj = ((com.tencent.mm.plugin.scanner.a.a) bA.per.get(i)).hSY;
                    qP(((com.tencent.mm.plugin.scanner.a.a) bA.per.get(i)).title);
                    aYF();
                    return;
                }
            }
        }
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductPurchaseAreaUI oZl;

            {
                this.oZl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oZl.finish();
                return false;
            }
        });
        this.jid = this.vrv;
    }

    private void aYF() {
        if (this.oZj != null) {
            for (int i = 0; i < this.oZj.size(); i++) {
                a aVar = (a) this.oZj.get(i);
                String valueOf = String.valueOf(i);
                if (aVar != null) {
                    Preference aVar2 = new a(this);
                    aVar2.setKey(valueOf);
                    aVar2.setTitle(aVar.name);
                    aVar2.setSummary(aVar.desc);
                    aVar2.oXf = aVar.hku;
                    this.jid.a(aVar2);
                    if (i != this.oZj.size() - 1) {
                        this.jid.a(new g(this.uSU.uTo));
                    }
                }
            }
            this.jid.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (this.oZj == null) {
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.igL).intValue();
            if (intValue < 0 || intValue >= this.oZj.size()) {
                return false;
            }
            a aVar = (a) this.oZj.get(intValue);
            if (aVar == null) {
                return false;
            }
            String str = null;
            switch (aVar.type) {
                case 1:
                    str = aVar.hSX;
                    if (!bg.mA(aVar.hSX)) {
                        g(this.uSU.uTo, aVar.hSX, this.oZk);
                        break;
                    }
                    w.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                    break;
                case 9:
                    str = aVar.oVS;
                    if (!bg.mA(aVar.oVS)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", aVar.oVS);
                        intent.putExtra("key_product_scene", 12);
                        d.b(this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    w.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + aVar.hSX);
                    if (!bg.mA(aVar.hSX)) {
                        g(this.uSU.uTo, aVar.hSX, this.oZk);
                        break;
                    }
                    break;
            }
            ap.vd().a(new h(this.kMS, aVar.oVR, aVar.type, str, this.oZj.size(), aVar.showType), 0);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", e, "", new Object[0]);
            return false;
        }
    }

    private static void g(Context context, String str, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", i.sc(i));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final int ON() {
        return R.o.ftU;
    }
}
