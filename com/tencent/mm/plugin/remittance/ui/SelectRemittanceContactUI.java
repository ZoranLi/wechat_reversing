package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private int fromScene;
    private List<String> jBA;
    private View nvd;
    private List<String> oRS;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void Oe() {
        super.Oe();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        w.v("MicroMsg.SelectRemittanceContactUI", "recent list:" + stringExtra);
        this.oRS = new ArrayList();
        if (!bg.mA(stringExtra)) {
            this.oRS = bg.f(stringExtra.split(","));
        }
        Collection hashSet = new HashSet();
        hashSet.addAll(s.bYl());
        hashSet.addAll(s.bYm());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!bg.mA(stringExtra2)) {
            hashSet.addAll(bg.f(stringExtra2.split(",")));
        }
        this.jBA = new ArrayList();
        this.jBA.addAll(hashSet);
    }

    protected final o Oi() {
        return new b(this, this.oRS, this.jBA, this.fromScene);
    }

    protected final m Oj() {
        return new q(this, this.jBA, false, this.scene);
    }

    public final int[] aIO() {
        if (this.fromScene == 1) {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        }
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void hf(int i) {
        if (i < this.oCR.getHeaderViewsCount()) {
            w.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            w.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            if (this.fromScene == 1) {
                intent.putExtra("list_attr", s.q(new int[]{s.vYN, 16384, 64, Downloads.RECV_BUFFER_SIZE, 262144}));
                intent.putExtra("min_limit_num", 1);
                intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
                intent.putExtra("titile", getString(R.l.eQy));
            } else {
                int q = s.q(new int[]{16, 1, 2, 4, 16384});
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", q);
                intent.putExtra("titile", getString(R.l.eLA));
                intent.putExtra("sub_title", getString(R.l.fmW));
            }
            d.a(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(R.a.aRq, R.a.aQY);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.oCR.getAdapter().getItem(i);
        if (aVar != null) {
            af afVar = aVar.jiL;
            if (afVar != null) {
                w.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{afVar.field_username});
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", r0);
                setResult(-1, intent2);
                finish();
                aHf();
                if (bYb() instanceof b) {
                    int i2;
                    q = i - this.oCR.getHeaderViewsCount();
                    b bVar = (b) bYb();
                    w.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[]{Integer.valueOf(q)});
                    if (bVar.oRQ >= 0) {
                        if (bVar.oRR < 0) {
                            i2 = 1;
                        } else if (q > bVar.oRQ && q < bVar.oRR) {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            g.oUh.i(13721, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        g.oUh.i(13721, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                    }
                }
            }
        }
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

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        if (this.fromScene == 1) {
            return getString(R.l.eQv);
        }
        return getString(R.l.eLB);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.nvd == null) {
            View inflate = View.inflate(this, R.i.dnw, null);
            this.nvd = inflate.findViewById(R.h.content);
            TextView textView = (TextView) inflate.findViewById(R.h.cIJ);
            if (this.fromScene == 1) {
                textView.setText(R.l.eQs);
            } else {
                textView.setText(R.l.eLl);
            }
            listView.addHeaderView(inflate);
        }
        this.nvd.setVisibility(i);
    }

    protected final void aIP() {
        super.aIP();
        aHf();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aIP();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
