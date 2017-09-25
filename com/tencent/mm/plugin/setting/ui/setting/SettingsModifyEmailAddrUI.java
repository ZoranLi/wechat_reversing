package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.w.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SettingsModifyEmailAddrUI extends MMActivity implements e {
    private ProgressDialog isv;
    private EditText plk;
    private String pll;
    private String plm;
    private TextView pln;
    private TextView plo;
    private String plp = null;
    private String plq = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.vd().a(138, this);
        ap.vd().a(i.CTRL_BYTE, this);
        ap.vd().a(256, this);
        ap.vd().a(108, this);
        ap.vd().a(255, this);
    }

    protected final int getLayoutId() {
        return R.i.doc;
    }

    public void onDestroy() {
        ap.vd().b(138, this);
        ap.vd().b(i.CTRL_BYTE, this);
        ap.vd().b(256, this);
        ap.vd().b(108, this);
        ap.vd().b(255, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.doc);
        this.plk = (EditText) findViewById(R.h.cDs);
        this.pln = (TextView) findViewById(R.h.cKA);
        this.plo = (TextView) findViewById(R.h.ckU);
        ap.yY();
        this.pll = (String) c.vr().get(5, null);
        this.plk.setText(this.pll);
        ap.yY();
        Integer num = (Integer) c.vr().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        Boolean valueOf = Boolean.valueOf(z);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyEmailAddrUI plr;

            {
                this.plr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plr.aHf();
                this.plr.finish();
                return true;
            }
        });
        if (valueOf.booleanValue()) {
            this.pln.setVisibility(0);
            this.pln.setText(getString(R.l.eUD));
            this.plo.setText(getString(R.l.eSU));
            this.plo.setTextColor(getResources().getColor(R.e.aSA));
            this.plk.setEnabled(false);
            this.plk.setFilters(new InputFilter[]{new InputFilter(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                {
                    this.plr = r1;
                }

                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
                }
            }});
            this.pln.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                {
                    this.plr = r1;
                }

                public final void onClick(View view) {
                    ap.vd().a(new h(h.hRO), 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.plr;
                    Context context = this.plr;
                    this.plr.getString(R.l.dIO);
                    settingsModifyEmailAddrUI.isv = g.a(context, this.plr.getString(R.l.eUI), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass22 pls;

                        {
                            this.pls = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    this.plr.aHf();
                }
            });
            cY(this.plk);
        } else if (bg.mA(this.pll)) {
            bai();
        } else {
            this.pln.setVisibility(0);
            this.pln.setText(getString(R.l.eRt));
            this.plo.setText(getString(R.l.eRs));
            this.plo.setTextColor(getResources().getColor(R.e.aVD));
            this.plk.setEnabled(false);
            this.plk.setFilters(new InputFilter[]{new InputFilter(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                {
                    this.plr = r1;
                }

                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
                }
            }});
            this.pln.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                {
                    this.plr = r1;
                }

                public final void onClick(View view) {
                    ap.yY();
                    final k adVar = new ad((String) c.vr().get(2, null));
                    ap.vd().a(adVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.plr;
                    Context context = this.plr.uSU.uTo;
                    this.plr.getString(R.l.dIO);
                    settingsModifyEmailAddrUI.isv = g.a(context, this.plr.getString(R.l.eSo), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass24 plu;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(adVar);
                        }
                    });
                    this.plr.aHf();
                }
            });
            a(0, getString(R.l.dGK), new OnMenuItemClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                {
                    this.plr = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.plr.bai();
                    return true;
                }
            });
            cY(this.plk);
        }
    }

    private void bai() {
        this.pln.setVisibility(8);
        this.pln.setText(getString(R.l.eUD));
        this.plo.setText(getString(R.l.eSU));
        this.plo.setTextColor(getResources().getColor(R.e.aSA));
        this.plk.setEnabled(true);
        this.plk.setFilters(new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ SettingsModifyEmailAddrUI plr;

            {
                this.plr = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return null;
            }
        }});
        CharSequence bj = d.bj(this);
        if (!bg.mA(bj)) {
            this.plk.setText(bj);
        }
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyEmailAddrUI plr;

            {
                this.plr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plr.plm = this.plr.plk.getText().toString().trim();
                if (bg.PK(this.plr.plm)) {
                    ap.yY();
                    Integer num = (Integer) c.vr().get(7, null);
                    boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
                    Boolean valueOf = Boolean.valueOf(z);
                    if (this.plr.plm.equals(this.plr.pll) && valueOf.booleanValue()) {
                        this.plr.finish();
                    } else {
                        final k aVar = new a(a.hpO, this.plr.plm);
                        ap.vd().a(aVar, 0);
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.plr;
                        Context context = this.plr;
                        this.plr.getString(R.l.dIO);
                        settingsModifyEmailAddrUI.isv = g.a(context, this.plr.getString(R.l.eSh), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass27 plv;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(aVar);
                            }
                        });
                        this.plr.aHf();
                    }
                } else {
                    g.h(this.plr.uSU.uTo, R.l.eZU, R.l.dIO);
                }
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (!com.tencent.mm.plugin.setting.a.imw.a(this.uSU.uTo, i, i2, str)) {
            if (kVar.getType() == i.CTRL_BYTE) {
                if (i == 0 && i2 == 0) {
                    this.plq = ((h) kVar).IP().tru;
                    this.plp = ((h) kVar).IO();
                    if (bg.mA(this.plq)) {
                        ap.vd().a(new v(2), 0);
                        return;
                    }
                    ap.vd().a(new a(a.hpP, this.plk.getText().toString().trim()), 0);
                    return;
                }
                if (this.isv != null) {
                    this.isv.dismiss();
                    this.isv = null;
                }
                if (i2 == -3) {
                    w.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    g.a(this.uSU.uTo, getString(R.l.eUG), null, getString(R.l.eUH), getString(R.l.eUF), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.plr.getString(R.l.eUE));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.bb.d.b(this.plr, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    g.a(this, R.l.eRI, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    g.a(this, R.l.eRF, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    g.a(this, R.l.eRG, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    g.a(this, R.l.eRB, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            } else if (kVar.getType() == 256) {
                com.tencent.mm.plugin.setting.a.imw.ou();
                if (((a) kVar).AJ() == a.hpO) {
                    if (i == 0 && i2 == 0) {
                        g.a(this.uSU.uTo, R.l.eSn, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                        return;
                    }
                    if (this.isv != null) {
                        this.isv.dismiss();
                        this.isv = null;
                    }
                    if (i2 == -82) {
                        g.a(this, R.l.eRI, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                    } else if (i2 == -83) {
                        g.a(this, R.l.eRF, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                    } else if (i2 == -84) {
                        g.a(this, R.l.eRG, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                    } else if (i2 == -85) {
                        g.a(this, R.l.eRB, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                    } else if (i2 == -86) {
                        g.a(this, R.l.eRJ, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                    } else {
                        g.a(this.uSU.uTo, getString(R.l.eSm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                    }
                } else if (((a) kVar).AJ() == a.hpP) {
                    if (this.isv != null) {
                        this.isv.dismiss();
                        this.isv = null;
                    }
                    if (i == 0 && i2 == 0) {
                        ap.yY();
                        Integer valueOf = Integer.valueOf(((Integer) c.vr().get(7, null)).intValue() | 2);
                        ap.yY();
                        c.vr().set(7, valueOf);
                        if (bg.mA(this.plq)) {
                            g.a(this.uSU.uTo, R.l.eRC, R.l.dIO, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                                {
                                    this.plr = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.plr.finish();
                                }
                            });
                        } else {
                            g.a(this.uSU.uTo, this.plq, "", getString(R.l.dAN), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ SettingsModifyEmailAddrUI plr;

                                {
                                    this.plr = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.plr.finish();
                                }
                            });
                        }
                    }
                }
            } else if (kVar.getType() == 138) {
            } else {
                if (kVar.getType() == 108) {
                    if (this.isv != null) {
                        this.isv.dismiss();
                        this.isv = null;
                    }
                    if (i == 0 && i2 == 0) {
                        g.a(this.uSU.uTo, R.l.eSn, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI plr;

                            {
                                this.plr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.plr.finish();
                            }
                        });
                        return;
                    }
                    g.a(this.uSU.uTo, getString(R.l.eSm, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.plr.finish();
                        }
                    });
                } else if (kVar.getType() != 255) {
                } else {
                    if (i2 == 0) {
                        ap.vd().a(new a(a.hpP, this.plk.getText().toString().trim()), 0);
                        return;
                    }
                    if (this.isv != null) {
                        this.isv.dismiss();
                        this.isv = null;
                    }
                    g.a(this.uSU.uTo, getString(R.l.eUG), null, getString(R.l.eUH), getString(R.l.eUF), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.plr.getString(R.l.eUE));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.bb.d.b(this.plr, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    w.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.pll + " newEmail: " + this.plm);
                    ap.vd().a(new h(h.hRO), 0);
                    getString(R.l.dIO);
                    this.isv = g.a(this, getString(R.l.eSL), true, new OnCancelListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI plr;

                        {
                            this.plr = r1;
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
}
