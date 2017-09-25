package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class AppBrandOpenWeRunSettingUI extends MMActivity implements e {
    private ImageView ioV;
    private TextView ioX;
    private TextView ipa;
    private TextView jiJ;
    private TextView jiK;
    private x jiL = null;
    p jiM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(getString(R.l.dEY));
        this.ioV = (ImageView) findViewById(R.h.cpy);
        this.jiJ = (TextView) findViewById(R.h.cpz);
        this.ipa = (TextView) findViewById(R.h.cpB);
        this.ioX = (TextView) findViewById(R.h.cpC);
        this.jiK = (TextView) findViewById(R.h.cpA);
        this.jiK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppBrandOpenWeRunSettingUI jiN;

            {
                this.jiN = r1;
            }

            public final void onClick(View view) {
                d.mN(13);
                Object obj = this.jiN;
                obj.getString(R.l.dIO);
                obj.jiM = g.a(obj, obj.getString(R.l.eTE), true, null);
                obj.jiM.show();
                ap.vd().a(30, obj);
                List linkedList = new LinkedList();
                linkedList.add("gh_43f2581f6fd6");
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(1));
                ap.vd().a(new n(1, linkedList, linkedList2, "", ""), 0);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandOpenWeRunSettingUI jiN;

            {
                this.jiN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jiN.finish();
                return true;
            }
        });
        String mz = bg.mz(getIntent().getStringExtra("OpenWeRunSettingName"));
        ap.yY();
        this.jiL = c.wR().Rc("gh_43f2581f6fd6");
        if (this.jiL == null || ((int) this.jiL.gTQ) == 0) {
            getString(R.l.dIO);
            this.jiM = g.a(this, getString(R.l.dJd), true, null);
            this.jiM.show();
            a.hlS.a("gh_43f2581f6fd6", "", new b.a(this) {
                final /* synthetic */ AppBrandOpenWeRunSettingUI jiN;

                {
                    this.jiN = r1;
                }

                public final void p(String str, boolean z) {
                    w.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[]{Boolean.valueOf(z), str});
                    AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI = this.jiN;
                    ap.yY();
                    appBrandOpenWeRunSettingUI.jiL = c.wR().Rc("gh_43f2581f6fd6");
                    this.jiN.WS();
                    this.jiN.jiM.dismiss();
                }
            });
        }
        this.ioX.setText(getString(R.l.dEZ, new Object[]{mz}));
        WS();
    }

    protected final int getLayoutId() {
        return R.i.cUg;
    }

    private void WS() {
        com.tencent.mm.pluginsdk.ui.a.b.a(this.ioV, this.jiL.field_username);
        this.jiJ.setText(this.jiL.tL());
        if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            this.ipa.setTextColor(r.fe(this.uSU.uTo));
            this.ipa.setText(R.l.eTC);
            this.ipa.setCompoundDrawablesWithIntrinsicBounds(R.g.bkm, 0, 0, 0);
            this.jiK.setText(R.l.eTC);
            this.jiK.setClickable(false);
            return;
        }
        this.ipa.setTextColor(r.ff(this.uSU.uTo));
        this.ipa.setText(R.l.eTJ);
        this.ipa.setCompoundDrawablesWithIntrinsicBounds(R.g.bkl, 0, 0, 0);
        this.jiK.setText(R.l.eTA);
        this.jiK.setClickable(true);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof n) {
            ap.vd().b(30, this);
            if (i == 0 && i2 == 0) {
                String bCI = ((n) kVar).bCI();
                w.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[]{bCI});
                ap.yY();
                this.jiL = c.wR().Rc("gh_43f2581f6fd6");
                af afVar = this.jiL;
                if (afVar == null || bg.mA(bCI)) {
                    w.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + bCI + ", contact = " + afVar);
                } else {
                    BizInfo bizInfo = null;
                    if (o.eT(afVar.field_username)) {
                        String mz = bg.mz(afVar.field_username);
                        bizInfo = com.tencent.mm.modelbiz.e.hW(mz);
                        if (bizInfo != null) {
                            bizInfo.field_username = bCI;
                        }
                        com.tencent.mm.modelbiz.w.DH().hP(mz);
                        afVar.bX(mz);
                    }
                    afVar.setUsername(bCI);
                    if (((int) afVar.gTQ) == 0) {
                        ap.yY();
                        c.wR().S(afVar);
                    }
                    if (((int) afVar.gTQ) <= 0) {
                        w.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        o.p(afVar);
                        ap.yY();
                        af Rc = c.wR().Rc(afVar.field_username);
                        if (bizInfo != null) {
                            com.tencent.mm.modelbiz.w.DH().d(bizInfo);
                        } else {
                            bizInfo = com.tencent.mm.modelbiz.e.hW(Rc.field_username);
                            if (bizInfo == null || bizInfo.CB()) {
                                w.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                a.hlS.J(Rc.field_username, "");
                                com.tencent.mm.x.b.he(Rc.field_username);
                            } else if (Rc.bLh()) {
                                w.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(Rc.gkI)});
                                a.hlS.J(Rc.field_username, "");
                                com.tencent.mm.x.b.he(Rc.field_username);
                            }
                        }
                    }
                }
                com.tencent.mm.modelbiz.w.DH().e(com.tencent.mm.modelbiz.w.DH().hO(this.jiL.field_username));
                ap.yY();
                c.vr().set(327825, Boolean.valueOf(true));
                setResult(-1);
                com.tencent.mm.sdk.platformtools.af.f(new Runnable(this) {
                    final /* synthetic */ AppBrandOpenWeRunSettingUI jiN;

                    {
                        this.jiN = r1;
                    }

                    public final void run() {
                        this.jiN.finish();
                    }
                }, 1500);
            } else {
                w.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 4 && i2 == -24 && !bg.mA(str)) {
                    Toast.makeText(ab.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.jiM != null) {
                this.jiM.dismiss();
            }
            WS();
        }
    }
}
