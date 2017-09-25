package com.tencent.mm.plugin.multitalk.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> ipA;
    private HashSet<String> ipB;
    private c nPA = new c<ja>(this) {
        final /* synthetic */ MultiTalkSelectContactUI nQT;

        {
            this.nQT = r2;
            this.usg = ja.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ja jaVar = (ja) bVar;
            if ((jaVar instanceof ja) && jaVar.fOT.action == 0) {
                this.nQT.finish();
            }
            return false;
        }
    };
    private boolean nQQ;
    private d nQR;
    private boolean nQS = false;

    protected final void Oe() {
        super.Oe();
        this.nQQ = getIntent().getBooleanExtra("key_need_gallery", false);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!o.dH(this.chatroomName)) {
            finish();
        }
        this.ipB = new HashSet();
        this.ipA = new HashSet();
    }

    protected void KC() {
        super.KC();
        this.nQR = new d(this);
        if (this.nQQ) {
            this.nQR.setVisible(true);
        } else {
            this.nQR.setVisible(false);
        }
        int i = R.l.dHT;
        if (this.nQQ) {
            i = R.l.eCo;
        }
        a(1, getString(i), new OnMenuItemClickListener(this) {
            final /* synthetic */ MultiTalkSelectContactUI nQT;

            {
                this.nQT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (am.isNetworkConnected(ab.getContext())) {
                    List linkedList = new LinkedList();
                    linkedList.addAll(this.nQT.ipB);
                    linkedList.add(m.xL());
                    String c = bg.c(linkedList, ",");
                    if (this.nQT.nQQ) {
                        com.tencent.mm.plugin.multitalk.a.d.a(this.nQT.ipB.size(), this.nQT.nQS, 1, "", this.nQT.nQR.nRx);
                        com.tencent.mm.plugin.multitalk.a.o.aNn().a(this.nQT, c, this.nQT.chatroomName);
                    } else {
                        com.tencent.mm.plugin.multitalk.a.d.a(this.nQT.ipB.size(), this.nQT.nQS, 2, i.aNd(), 0);
                        this.nQT.setResult(-1, this.nQT.getIntent().putExtra("Select_Contact", c));
                        this.nQT.finish();
                    }
                } else {
                    com.tencent.mm.al.a.a(this.nQT, R.l.fco, null);
                }
                this.nQT.aHf();
                return true;
            }
        }, l.b.uTY);
        Ok();
        this.nyd.setBackgroundResource(R.e.aVg);
        this.nyd.sJt.setTextColor(-1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bg.mA(stringExtra)) {
            this.ipA.addAll(bg.f(stringExtra.split(",")));
        }
        this.ipA.add(m.xL());
        if (this.nQQ) {
            this.nQR.Bn(m.xL());
        }
        com.tencent.mm.sdk.b.a.urY.b(this.nPA);
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.nPA);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.djK;
    }

    protected final boolean Of() {
        return false;
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        return getIntent().getStringExtra("titile");
    }

    protected final com.tencent.mm.ui.contact.o Oi() {
        return new a(this, this.chatroomName);
    }

    protected final com.tencent.mm.ui.contact.m Oj() {
        return new b(this, this.chatroomName);
    }

    public final void hf(int i) {
        n bYb = bYb();
        com.tencent.mm.ui.contact.a.a BL = bYb.BL(i - this.oCR.getHeaderViewsCount());
        if (BL != null && BL.jiL != null) {
            w.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[]{BL.jiL.field_username});
            String str = BL.jiL.field_username;
            if (!m.xL().equals(str)) {
                bYh();
                if (this.ipB.contains(str)) {
                    if (this.nQQ) {
                        d dVar = this.nQR;
                        if (dVar.size != 0) {
                            int i2;
                            boolean z;
                            boolean z2;
                            int i3 = -1;
                            for (i2 = 0; i2 < dVar.nRq.getChildCount(); i2++) {
                                if (dVar.nRq.getChildAt(i2).getTag().equals(str)) {
                                    i3 = i2;
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (i3 < 0) {
                                i2 = 0;
                                while (i2 < dVar.nRr.getChildCount()) {
                                    if (dVar.nRr.getChildAt(i2).getTag().equals(str)) {
                                        z2 = true;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            i2 = i3;
                            z2 = false;
                            if (i2 >= 0) {
                                if (z2) {
                                    dVar.nRr.removeViewAt(i2);
                                    dVar.size--;
                                }
                                if (z) {
                                    if (dVar.size <= 5) {
                                        dVar.nRq.removeViewAt(i2);
                                        dVar.size--;
                                    } else {
                                        dVar.nRq.removeViewAt(i2);
                                        View childAt = dVar.nRr.getChildAt(0);
                                        dVar.nRr.removeViewAt(0);
                                        dVar.nRq.addView(childAt);
                                        dVar.size--;
                                    }
                                }
                                dVar.pW(dVar.size);
                                dVar.pX(dVar.size);
                            }
                        }
                    }
                    this.ipB.remove(str);
                } else if (this.ipA.size() + this.ipB.size() == 9) {
                    this.nQS = true;
                    Toast.makeText(this, R.l.eCl, 0).show();
                    return;
                } else {
                    if (this.nQQ) {
                        this.nQR.Bn(str);
                    }
                    this.ipB.add(str);
                }
                bYb.notifyDataSetChanged();
                Ok();
            }
        }
    }

    protected final void aIP() {
        super.aIP();
        aHf();
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipB.contains(aVar.jiL.field_username);
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.ipA.contains(aVar.jiL.field_username);
    }

    private void Ok() {
        if (this.ipB.size() > 0) {
            ae(1, true);
        } else {
            ae(1, false);
        }
    }

    protected final int Ol() {
        return 1;
    }
}
