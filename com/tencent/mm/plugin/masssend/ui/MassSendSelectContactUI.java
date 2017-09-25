package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.l.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private HashSet<String> ipB;
    private List<String> jBA;
    private Button nyb;
    private boolean nyc;
    private MultiSelectContactView nyd;

    protected final void Oe() {
        super.Oe();
        this.jBA = new ArrayList();
        this.jBA.addAll(s.bYl());
        this.jBA.addAll(s.bYm());
        this.jBA.add(m.xL());
        this.ipB = new HashSet();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.nyd = this.nyd;
        if (this.nyd == null) {
            finish();
            return;
        }
        this.nyd.setBackgroundDrawable(null);
        a(1, getString(R.l.cjj), new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendSelectContactUI nye;

            {
                this.nye = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
                List f = bg.f((String[]) this.nye.ipB.toArray(new String[0]));
                if (f == null) {
                    w.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
                    return false;
                }
                f.remove(m.xL());
                String c = bg.c(f, ";");
                Intent intent = new Intent(this.nye, MassSendMsgUI.class);
                intent.putExtra("mass_send_contact_list", c);
                this.nye.startActivity(intent);
                return true;
            }
        }, b.uTY);
        this.nyb = (Button) findViewById(R.h.cBz);
        this.nyb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendSelectContactUI nye;

            {
                this.nye = r1;
            }

            public final void onClick(View view) {
                boolean z;
                w.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
                n nVar = (n) ((HeaderViewListAdapter) this.nye.oCR.getAdapter()).getWrappedAdapter();
                if (this.nye.nyc) {
                    this.nye.nyb.setText(R.l.eAD);
                    Iterator it = this.nye.ipB.iterator();
                    while (it.hasNext()) {
                        this.nye.nyd.MF((String) it.next());
                    }
                    this.nye.ipB.clear();
                } else {
                    this.nye.nyb.setText(R.l.eAw);
                    int count = nVar.getCount();
                    for (int i = 0; i < count; i++) {
                        a BL = nVar.BL(i);
                        if (!(BL == null || BL.jiL == null || this.nye.ipB.contains(BL.jiL.field_username))) {
                            this.nye.ipB.add(BL.jiL.field_username);
                            this.nye.nyd.MF(BL.jiL.field_username);
                        }
                    }
                }
                MassSendSelectContactUI massSendSelectContactUI = this.nye;
                if (this.nye.nyc) {
                    z = false;
                } else {
                    z = true;
                }
                massSendSelectContactUI.nyc = z;
                this.nye.pj(this.nye.ipB.size());
                nVar.notifyDataSetChanged();
            }
        });
        this.nyd.sJx = new MultiSelectContactView.a(this) {
            final /* synthetic */ MassSendSelectContactUI nye;

            {
                this.nye = r1;
            }

            public final void mK(String str) {
                if (str != null) {
                    this.nye.ipB.remove(str);
                    this.nye.pj(this.nye.ipB.size());
                }
            }
        };
        pj(this.ipB.size());
    }

    private void pj(int i) {
        if (i > 0) {
            aB(1, getString(R.l.cjj) + "(" + this.ipB.size() + ")");
            ae(1, true);
            return;
        }
        aB(1, getString(R.l.cjj));
        ae(1, false);
    }

    protected final void Ac(String str) {
        g.oUh.i(11225, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", bg.c(new ArrayList(this.ipB), ","));
        intent.putExtra("list_attr", s.q(new int[]{16384, 64}));
        d.a(this, ".ui.contact.SelectLabelContactUI", intent, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bg.mA(stringExtra)) {
                        w.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    w.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.ipB.add(str)) {
                            this.nyd.MF(str);
                        }
                        i3++;
                    }
                    pj(this.ipB.size());
                    bYb().notifyDataSetChanged();
                    if (this.kww != null) {
                        this.kww.clearFocus();
                        this.kww.bZQ();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.din;
    }

    public final void hf(int i) {
        n bYb = bYb();
        a BL = bYb.BL(i - this.oCR.getHeaderViewsCount());
        if (BL != null && BL.jiL != null) {
            w.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[]{BL.jiL.field_username});
            String str = BL.jiL.field_username;
            bYh();
            if (this.ipB.contains(str)) {
                this.ipB.remove(str);
                this.nyd.MF(str);
            } else {
                this.ipB.add(str);
                this.nyd.MF(str);
            }
            pj(this.ipB.size());
            bYb.notifyDataSetChanged();
            bYh();
            bYi();
        }
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return true;
    }

    protected final String Oh() {
        return getString(R.l.eAE);
    }

    protected final o Oi() {
        c.a aVar = new c.a();
        aVar.vWe = true;
        return new c(this, this.jBA, true, aVar);
    }

    protected final com.tencent.mm.ui.contact.m Oj() {
        return new q(this, this.jBA, true, this.scene);
    }

    public final boolean a(a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipB.contains(aVar.jiL.field_username);
    }

    public final int[] aIO() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    protected final boolean aJR() {
        return true;
    }
}
