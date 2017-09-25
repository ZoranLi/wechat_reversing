package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.l.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private HashSet<String> ipB;
    private List<String> jBA;

    protected final void Oe() {
        super.Oe();
        this.jBA = new ArrayList();
        Collection f = bg.f(bg.ap(getIntent().getStringExtra("Block_list"), "").split(","));
        Collection bYl = s.bYl();
        bYl.addAll(f);
        this.jBA.addAll(bYl);
        this.jBA.addAll(s.bYm());
        this.ipB = new HashSet();
        String ap = bg.ap(getIntent().getStringExtra("Select_Contact"), "");
        if (!bg.mA(ap)) {
            this.ipB.addAll(bg.f(ap.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.SnsAddressUI", "Create!");
        a(1, getString(R.l.dHT), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsAddressUI vZO;

            {
                this.vZO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                List f = bg.f((String[]) this.vZO.ipB.toArray(new String[0]));
                if (f == null || f.size() == 0) {
                    intent.putExtra("Select_Contact", "");
                } else {
                    intent.putExtra("Select_Contact", bg.c(f, ","));
                }
                this.vZO.setResult(-1, intent);
                this.vZO.finish();
                af.f(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 vZP;

                    {
                        this.vZP = r1;
                    }

                    public final void run() {
                        if (!this.vZP.vZO.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                            this.vZP.vZO.moveTaskToBack(true);
                        }
                    }
                }, 100);
                return true;
            }
        }, b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsAddressUI vZO;

            {
                this.vZO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vZO.finish();
                if (!this.vZO.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    this.vZO.moveTaskToBack(true);
                }
                return true;
            }
        });
        Iterator it = this.ipB.iterator();
        while (it.hasNext()) {
            this.nyd.MF((String) it.next());
        }
        this.nyd.sJx = new a(this) {
            final /* synthetic */ SnsAddressUI vZO;

            {
                this.vZO = r1;
            }

            public final void mK(String str) {
                if (str != null) {
                    this.vZO.ipB.remove(str);
                    this.vZO.Ok();
                }
            }
        };
        Ok();
    }

    public final void hf(int i) {
        n bYb = bYb();
        com.tencent.mm.ui.contact.a.a BL = bYb.BL(i - this.oCR.getHeaderViewsCount());
        if (BL != null && BL.jiL != null) {
            w.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[]{BL.jiL.field_username});
            String str = BL.jiL.field_username;
            bYh();
            if (this.ipB.contains(str)) {
                this.ipB.remove(str);
                this.nyd.MF(str);
            } else if (this.ipB.size() < v.uzf) {
                this.ipB.add(str);
                this.nyd.MF(str);
            } else {
                Toast.makeText(this, R.l.eWT, 0).show();
                w.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[]{Integer.valueOf(v.uzf)});
            }
            Ok();
            bYb.notifyDataSetChanged();
        }
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return true;
    }

    protected final String Oh() {
        return bg.ap(getIntent().getStringExtra("Add_address_titile"), "");
    }

    protected final o Oi() {
        c.a aVar = new c.a();
        aVar.vWe = true;
        aVar.vWl = true;
        aVar.vWn = getString(R.l.dCH);
        aVar.vWm = bg.ap(getIntent().getStringExtra("Add_get_from_sns"), "");
        return new c(this, this.jBA, true, aVar);
    }

    protected final m Oj() {
        return new q(this, this.jBA, true, this.scene);
    }

    private void Ok() {
        String format;
        boolean z;
        if (this.ipB.size() == 0) {
            format = String.format("%s", new Object[]{getString(R.l.dHT)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(R.l.dHT), Integer.valueOf(this.ipB.size()), Integer.valueOf(v.uzf)});
        }
        aB(1, format);
        if (this.ipB.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        ae(1, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bg.mA(stringExtra)) {
                        w.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    w.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.ipB.add(str)) {
                            this.nyd.MF(str);
                        }
                        i3++;
                    }
                    Ok();
                    bYb().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean aJR() {
        return true;
    }

    protected final void Ac(String str) {
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(this.ipB);
        intent.putExtra("always_select_contact", bg.c(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", s.q(new int[]{16384, 64}));
        startActivityForResult(intent, 3);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipB.contains(aVar.jiL.field_username);
    }

    public final int[] aIO() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void mK(String str) {
        this.ipB.remove(str);
        bYb().notifyDataSetChanged();
        Ok();
    }
}
