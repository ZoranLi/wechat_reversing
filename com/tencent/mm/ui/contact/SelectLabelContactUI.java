package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.l.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> ipB;
    private int kwO;
    private String label;
    private HashSet<String> vZt;

    protected final void Oe() {
        super.Oe();
        this.label = getIntent().getStringExtra("label");
        this.kwO = getIntent().getIntExtra("list_attr", 0);
        this.ipB = new HashSet();
        this.vZt = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bg.mA(stringExtra)) {
            this.vZt.addAll(bg.f(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bg.mA(stringExtra)) {
            this.ipB.addAll(bg.f(stringExtra.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (s.ee(this.kwO, 64)) {
            a(1, getString(R.l.dHT), new OnMenuItemClickListener(this) {
                final /* synthetic */ SelectLabelContactUI vZM;

                {
                    this.vZM = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    w.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[]{new ArrayList(this.vZM.ipB).toString()});
                    this.vZM.TR(bg.c(r0, ","));
                    return true;
                }
            }, b.uTY);
        }
        Ok();
    }

    public final void hf(int i) {
        int headerViewsCount = i - this.oCR.getHeaderViewsCount();
        n bYb = bYb();
        a BL = bYb.BL(headerViewsCount);
        if (BL != null && BL.jiL != null) {
            String str = BL.jiL.field_username;
            w.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[]{str});
            if (!s.ee(this.kwO, 64)) {
                TR(str);
            } else if (this.vZt.contains(str) || this.ipB.contains(str) || !s.ee(this.kwO, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.vZt.size() + this.ipB.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                if (!this.vZt.contains(str)) {
                    if (this.ipB.contains(str)) {
                        this.ipB.remove(str);
                    } else {
                        this.ipB.add(str);
                    }
                }
                Ok();
                bYb.notifyDataSetChanged();
            } else {
                g.a(this.uSU.uTo, getString(R.l.eQp, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE))}), getString(R.l.dIs), new OnClickListener(this) {
                    final /* synthetic */ SelectLabelContactUI vZM;

                    {
                        this.vZM = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    }

    private void Ok() {
        if (!s.ee(this.kwO, 64) || this.ipB.size() <= 0) {
            aB(1, getString(R.l.dHT));
            ae(1, false);
            return;
        }
        aB(1, getString(R.l.dHT) + "(" + this.ipB.size() + ")");
        ae(1, true);
    }

    private void TR(String str) {
        if (s.ee(this.kwO, 16384)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            return;
        }
        intent = new Intent();
        intent.setClass(this, En_5b8fbb1e.class);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        startActivity(intent);
        finish();
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return this.label;
    }

    protected final o Oi() {
        return new h(this, s.ee(this.kwO, 64), com.tencent.mm.plugin.label.a.a.aFG().zh(com.tencent.mm.plugin.label.a.a.aFG().ze(this.label)));
    }

    protected final m Oj() {
        return null;
    }

    public final boolean a(a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipB.contains(aVar.jiL.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.vZt.contains(aVar.jiL.field_username);
    }
}
