package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.j;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> jBA;
    private View nvd;

    protected final void Oe() {
        super.Oe();
        Collection hashSet = new HashSet();
        hashSet.addAll(s.bYl());
        hashSet.addAll(s.bYm());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!bg.mA(stringExtra)) {
            hashSet.addAll(bg.f(stringExtra.split(",")));
        }
        this.jBA = new ArrayList();
        this.jBA.addAll(hashSet);
    }

    public final void hf(int i) {
        if (i < this.oCR.getHeaderViewsCount()) {
            w.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            w.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int q = s.q(new int[]{16, 1, 2, 4, 16384, 64, 65536, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT});
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", q);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(R.l.eyk, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(R.l.fmW));
            d.a(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(R.a.aRq, R.a.aQY);
            return;
        }
        a aVar = (a) this.oCR.getAdapter().getItem(i);
        if (aVar != null) {
            af afVar = aVar.jiL;
            if (afVar != null) {
                String str = afVar.field_username;
                w.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{str});
                final Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", str);
                String str2 = null;
                if (o.dH(str)) {
                    str2 = getString(R.l.eQo, new Object[]{Integer.valueOf(j.eC(str))});
                }
                com.tencent.mm.pluginsdk.ui.applet.d.b(this.uSU, str, getString(R.l.eLK), str, str2, getString(R.l.dIA), new k.a(this) {
                    final /* synthetic */ SelectLuckyMoneyContactUI nve;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            this.nve.setResult(-1, intent2);
                            this.nve.finish();
                        }
                    }
                });
            }
        }
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return getString(R.l.eyl);
    }

    protected final com.tencent.mm.ui.contact.o Oi() {
        return new t(this, this.jBA);
    }

    protected final m Oj() {
        return new q(this, this.jBA, false, this.scene);
    }

    public final int[] aIO() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.nvd == null) {
            View inflate = View.inflate(this, R.i.dnw, null);
            this.nvd = inflate.findViewById(R.h.content);
            ((TextView) inflate.findViewById(R.h.cIJ)).setText(R.l.exF);
            listView.addHeaderView(inflate);
        }
        this.nvd.setVisibility(i);
    }

    protected final void aIP() {
        super.aIP();
        aHf();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aIP();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            w.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            w.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            w.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            w.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
            setResult(-1, intent);
            finish();
        }
    }
}
