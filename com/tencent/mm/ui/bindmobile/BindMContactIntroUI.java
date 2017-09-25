package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;

public class BindMContactIntroUI extends MMWizardActivity implements e {
    private String fOI;
    private p irJ = null;
    private boolean jFm = false;
    private String plp = null;
    private String plq = null;
    private i vcA;
    private boolean vcP = false;
    private ImageView vcj;
    private TextView vtB;
    private TextView vtC;
    private Button vtD;
    private Button vtE;
    private a vtF;
    private boolean vtG = false;
    private int vtH = 0;

    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = true;
        switch (bindMContactIntroUI.vtF) {
            case NO_INIT:
                bindMContactIntroUI.lc(false);
                return;
            case SET_MOBILE:
                final String str = bindMContactIntroUI.fOI;
                if (bindMContactIntroUI.vcA == null) {
                    bindMContactIntroUI.vcA = new i(b.whX, bindMContactIntroUI, new i.a(bindMContactIntroUI) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        public final void zC(int i) {
                            Intent intent;
                            if (i == 1) {
                                if (this.vtI.vcP) {
                                    if (!m.xT()) {
                                        com.tencent.mm.sdk.b.b rcVar = new rc();
                                        rcVar.fYc.fYd = true;
                                        rcVar.fYc.fYe = true;
                                        com.tencent.mm.sdk.b.a.urY.m(rcVar);
                                    }
                                    this.vtI.zu(1);
                                    intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.plugin.c.a.imv.d(this.vtI, intent);
                                    return;
                                }
                                MMWizardActivity.z(this.vtI, new Intent(this.vtI, BindMContactStatusUI.class).putExtra("is_bind_for_contact_sync", this.vtI.vtG));
                                if (!this.vtI.jFm) {
                                    return;
                                }
                                if (this.vtI.vtG) {
                                    g.oUh.i(11002, Integer.valueOf(3), Integer.valueOf(3));
                                    return;
                                }
                                g.oUh.i(11002, Integer.valueOf(1), Integer.valueOf(2));
                            } else if (i == 2) {
                                intent = new Intent(this.vtI, BindMContactVerifyUI.class);
                                intent.putExtra("bindmcontact_mobile", str);
                                intent.putExtra("is_bind_for_safe_device", this.vtI.vcP);
                                intent.putExtra("is_bind_for_contact_sync", this.vtI.vtG);
                                intent.putExtra("KEnterFromBanner", this.vtI.jFm);
                                MMWizardActivity.z(this.vtI, intent);
                            }
                        }
                    });
                    bindMContactIntroUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactIntroUI.vcA);
                }
                i iVar = bindMContactIntroUI.vcA;
                if (bindMContactIntroUI.vcP || bindMContactIntroUI.vtG) {
                    z = false;
                }
                iVar.whT = z;
                bindMContactIntroUI.vcA.Uf(str);
                return;
            case SUCC_UNLOAD:
                ap.yY();
                c.vr().set(12322, Boolean.valueOf(false));
                com.tencent.mm.platformtools.m.a(bindMContactIntroUI, new Runnable(bindMContactIntroUI) {
                    final /* synthetic */ BindMContactIntroUI vtI;

                    {
                        this.vtI = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.modelfriend.m.Fj()) {
                            BindMContactIntroUI.bTg();
                            this.vtI.vtD.setText(this.vtI.getString(R.l.dNG));
                            this.vtI.vtF = a.SUCC;
                            ap.yY();
                            boolean b = bg.b((Boolean) c.vr().get(12322, Boolean.valueOf(false)), false);
                            if (this.vtI.jFm && b) {
                                g.oUh.i(11002, Integer.valueOf(3), Integer.valueOf(3));
                            }
                        }
                    }
                }, true, bindMContactIntroUI.vtH);
                return;
            case SUCC:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        switch (bindMContactIntroUI.vtF) {
            case SET_MOBILE:
                com.tencent.mm.modelfriend.m.Fm();
                bindMContactIntroUI.KC();
                return;
            case SUCC_UNLOAD:
                bindMContactIntroUI.lc(true);
                return;
            case SUCC:
                bindMContactIntroUI.lc(true);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void bTg() {
        int xP = m.xP();
        com.tencent.mm.modelfriend.m.Fi();
        xP &= -131073;
        ap.yY();
        c.vr().set(7, Integer.valueOf(xP));
        com.tencent.mm.plugin.c.a.imw.ou();
    }

    protected final int getLayoutId() {
        return R.i.cVC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(132, (e) this);
        ap.vd().a(255, (e) this);
        ap.vd().a((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
        zi(R.l.dNR);
    }

    public void onDestroy() {
        ap.vd().b(132, (e) this);
        ap.vd().b(255, (e) this);
        ap.vd().b((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
        if (this.vcA != null) {
            getContentResolver().unregisterContentObserver(this.vcA);
            this.vcA.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        KC();
    }

    protected final void KC() {
        this.vcP = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.vtG = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.jFm = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.vtH = getIntent().getIntExtra("key_upload_scene", 0);
        this.vtF = com.tencent.mm.modelfriend.m.Fl();
        w.d("MicroMsg.BindMContactIntroUI", "state " + this.vtF);
        ap.yY();
        this.fOI = (String) c.vr().get(6, null);
        if (this.fOI == null || this.fOI.equals("")) {
            ap.yY();
            this.fOI = (String) c.vr().get(4097, null);
        }
        this.vcj = (ImageView) findViewById(R.h.cCZ);
        this.vtB = (TextView) findViewById(R.h.cCX);
        this.vtC = (TextView) findViewById(R.h.cCW);
        this.vtD = (Button) findViewById(R.h.cCV);
        this.vtE = (Button) findViewById(R.h.cCY);
        this.vtD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactIntroUI vtI;

            {
                this.vtI = r1;
            }

            public final void onClick(View view) {
                BindMContactIntroUI.a(this.vtI);
            }
        });
        this.vtE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactIntroUI vtI;

            {
                this.vtI = r1;
            }

            public final void onClick(View view) {
                BindMContactIntroUI.b(this.vtI);
            }
        });
        if (getIntent().getBooleanExtra("skip", false)) {
            a(0, getString(R.l.dHy), new OnMenuItemClickListener(this) {
                final /* synthetic */ BindMContactIntroUI vtI;

                {
                    this.vtI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.vtI.aXS();
                    return true;
                }
            });
        } else {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BindMContactIntroUI vtI;

                {
                    this.vtI = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.vtI.aXS();
                    return true;
                }
            });
        }
        if (this.vtF == a.SUCC_UNLOAD || this.vtF == a.SUCC) {
            String value = com.tencent.mm.i.g.sV().getValue("ShowUnbindPhone");
            int i = 2;
            if (!bg.mA(value)) {
                i = bg.PY(value);
            }
            if (i != 0) {
                a(1, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ BindMContactIntroUI vtI;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        l lVar = new l(this.vtI.uSU.uTo);
                        lVar.qJf = new n.c(this) {
                            final /* synthetic */ AnonymousClass23 vtM;

                            {
                                this.vtM = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                lVar.setHeaderTitle(R.l.dNK);
                                if ((i & 2) != 0) {
                                    lVar.dX(0, R.l.dNX);
                                }
                                if ((i & 1) != 0) {
                                    lVar.dX(1, R.l.dNs);
                                }
                            }
                        };
                        lVar.qJg = new d(this) {
                            final /* synthetic */ AnonymousClass23 vtM;

                            {
                                this.vtM = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        com.tencent.mm.ui.base.g.a(this.vtM.vtI.uSU.uTo, this.vtM.vtI.getString(R.l.dNU), this.vtM.vtI.getString(R.l.dNV), this.vtM.vtI.getString(R.l.dGs), this.vtM.vtI.getString(R.l.dNT), null, new DialogInterface.OnClickListener(this.vtM.vtI) {
                                            final /* synthetic */ BindMContactIntroUI vtI;

                                            {
                                                this.vtI = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                if (this.vtI.fOI != null && !this.vtI.fOI.equals("")) {
                                                    ap.vd().a(new h(h.hRM), 0);
                                                    BindMContactIntroUI bindMContactIntroUI = this.vtI;
                                                    Context context = this.vtI;
                                                    this.vtI.getString(R.l.dIO);
                                                    bindMContactIntroUI.irJ = com.tencent.mm.ui.base.g.a(context, this.vtI.getString(R.l.eSL), true, new OnCancelListener(this) {
                                                        final /* synthetic */ AnonymousClass24 vtN;

                                                        {
                                                            this.vtN = r1;
                                                        }

                                                        public final void onCancel(DialogInterface dialogInterface) {
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                        return;
                                    case 1:
                                        Intent intent = new Intent();
                                        intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                                        com.tencent.mm.bb.d.b(this.vtM.vtI, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        lVar.blb();
                        return false;
                    }
                });
            }
        }
        switch (this.vtF) {
            case NO_INIT:
                af(1, false);
                this.vcj.setImageResource(R.k.dxI);
                this.vtC.setVisibility(0);
                this.vtE.setVisibility(8);
                this.vtB.setText(R.l.dNI);
                this.vtC.setText(R.l.dNH);
                this.vtD.setText(R.l.dNk);
                return;
            case SET_MOBILE:
                af(1, false);
                this.vcj.setImageResource(R.k.dxI);
                this.vtC.setVisibility(0);
                this.vtE.setVisibility(0);
                this.vtB.setText(String.format(getString(R.l.dOi), new Object[]{this.fOI}));
                this.vtC.setText(R.l.dOa);
                this.vtD.setText(R.l.dOd);
                this.vtE.setText(R.l.dNt);
                return;
            case SUCC_UNLOAD:
                af(1, true);
                this.vcj.setImageResource(R.k.dxH);
                this.vtC.setVisibility(0);
                this.vtE.setVisibility(0);
                this.vtB.setText(String.format(getString(R.l.dOi), new Object[]{this.fOI}));
                this.vtC.setText(R.l.dNp);
                this.vtD.setText(R.l.dOb);
                this.vtE.setText(R.l.dNr);
                return;
            case SUCC:
                af(1, true);
                this.vcj.setImageResource(R.k.dxH);
                this.vtC.setVisibility(0);
                this.vtE.setVisibility(0);
                this.vtB.setText(String.format(getString(R.l.dOi), new Object[]{this.fOI}));
                this.vtC.setText(R.l.dNp);
                this.vtD.setText(R.l.dNG);
                this.vtE.setText(R.l.dNr);
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    private void aXS() {
        aHf();
        if (this.vtG) {
            cancel();
            finish();
            return;
        }
        zu(1);
    }

    private void lc(boolean z) {
        Intent intent = new Intent(this, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", this.vcP);
        intent.putExtra("is_bind_for_contact_sync", this.vtG);
        intent.putExtra("is_bind_for_change_mobile", z);
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!bg.mA(simCountryIso)) {
            com.tencent.mm.ai.b.a g = com.tencent.mm.ai.b.g(this, simCountryIso, getString(R.l.bGO));
            if (g != null) {
                intent.putExtra("country_name", g.hJF);
                intent.putExtra("couttry_code", g.hJE);
            }
        }
        MMWizardActivity.z(this, intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 132 && i == 0 && i2 == 0) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            if (((t) kVar).AJ() == 3) {
                com.tencent.mm.modelsimple.d.bd(this);
                if (bg.mA(this.plq)) {
                    MMWizardActivity.z(this, new Intent(this, BindMContactStatusUI.class));
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, this.plq, "", getString(R.l.dAN), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MMWizardActivity.z(this.vtI, new Intent(this.vtI, BindMContactStatusUI.class));
                        }
                    });
                    return;
                }
            }
            return;
        }
        Object obj;
        if (!com.tencent.mm.plugin.c.a.imw.a((Context) this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, R.l.dNv, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, R.l.dNx, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, R.l.dNA, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, R.l.dNw, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, R.l.dNy, 0).show();
                    obj = 1;
                    break;
                default:
                    break;
            }
        }
        obj = 1;
        if (obj == null) {
            final k tVar;
            Context context;
            if (kVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE) {
                if (this.irJ != null) {
                    this.irJ.dismiss();
                    this.irJ = null;
                }
                if (i == 0 && i2 == 0) {
                    this.plq = ((h) kVar).IP().tru;
                    this.plp = ((h) kVar).IO();
                    if (bg.mA(this.plq)) {
                        ap.vd().a(new v(2), 0);
                        return;
                    }
                    tVar = new t(this.fOI, 3, "", 0, "");
                    ap.vd().a(tVar, 0);
                    context = this.uSU.uTo;
                    getString(R.l.dIO);
                    this.irJ = com.tencent.mm.ui.base.g.a(context, getString(R.l.dNZ), true, new OnCancelListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(tVar);
                        }
                    });
                    return;
                } else if (i2 == -3) {
                    w.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eUG), null, getString(R.l.eUH), getString(R.l.eUF), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.vtI.getString(R.l.eUE));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.bb.d.b(this.vtI, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -81) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRH, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRI, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRF, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRG, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRD, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -86) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRJ, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
            if (kVar.getType() == 255) {
                if (this.irJ != null) {
                    this.irJ.dismiss();
                    this.irJ = null;
                }
                if (i2 == 0) {
                    tVar = new t(this.fOI, 3, "", 0, "");
                    ap.vd().a(tVar, 0);
                    context = this.uSU.uTo;
                    getString(R.l.dIO);
                    this.irJ = com.tencent.mm.ui.base.g.a(context, getString(R.l.dNZ), true, new OnCancelListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(tVar);
                        }
                    });
                } else {
                    w.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                    com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eUG), null, getString(R.l.eUH), getString(R.l.eUF), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.vtI.getString(R.l.eUE));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.bb.d.b(this.vtI, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
            if (kVar.getType() == 132) {
                if (this.irJ != null) {
                    this.irJ.dismiss();
                    this.irJ = null;
                }
                if (((t) kVar).AJ() != 3) {
                    return;
                }
                if (i2 == -82) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRI, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRF, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRG, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    com.tencent.mm.ui.base.g.a((Context) this, R.l.eRD, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    Toast.makeText(this, getString(R.l.dNW, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    w.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.fOI);
                    ap.vd().a(new h(h.hRM), 0);
                    getString(R.l.dIO);
                    this.irJ = com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eSL), true, new OnCancelListener(this) {
                        final /* synthetic */ BindMContactIntroUI vtI;

                        {
                            this.vtI = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactIntroUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.vcA != null) {
                    this.vcA.bRm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
