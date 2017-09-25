package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class BindQQUI extends MMWizardActivity implements e {
    p irJ;
    private String plp = null;
    private String plq = null;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        ap.vd().a((int) i.CTRL_BYTE, (e) this);
        ap.vd().a(255, (e) this);
    }

    public void onDestroy() {
        ap.vd().b((int) i.CTRL_BYTE, (e) this);
        ap.vd().b(255, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        KC();
    }

    protected final int getLayoutId() {
        return R.i.cVH;
    }

    protected final void KC() {
        ap.yY();
        long longValue = new o(bg.f((Integer) c.vr().get(9, null))).longValue();
        TextView textView;
        Button button;
        if (longValue == 0) {
            zi(R.l.dOv);
            textView = (TextView) findViewById(R.h.cDa);
            textView.setVisibility(8);
            textView.setText(R.l.dOu);
            ((TextView) findViewById(R.h.cDb)).setVisibility(8);
            button = (Button) findViewById(R.h.btv);
            button.setVisibility(0);
            button.setText(R.l.btv);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BindQQUI vuJ;

                {
                    this.vuJ = r1;
                }

                public final void onClick(View view) {
                    MMWizardActivity.z(this.vuJ, new Intent(this.vuJ, VerifyQQUI.class));
                }
            });
            zn(1);
        } else {
            zi(R.l.dOt);
            textView = (TextView) findViewById(R.h.cDa);
            textView.setVisibility(8);
            textView.setText(R.l.dOr);
            textView = (TextView) findViewById(R.h.cDb);
            textView.setVisibility(0);
            textView.setText(getString(R.l.dOs) + longValue);
            button = (Button) findViewById(R.h.btv);
            button.setVisibility(8);
            button.setText(R.l.erK);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BindQQUI vuJ;

                {
                    this.vuJ = r1;
                }

                public final void onClick(View view) {
                }
            });
            a(1, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI vuJ;

                {
                    this.vuJ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    l lVar = new l(this.vuJ.uSU.uTo);
                    lVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass7 vuK;

                        {
                            this.vuK = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.setHeaderTitle(R.l.dNK);
                            lVar.dX(0, R.l.eUD);
                        }
                    };
                    lVar.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass7 vuK;

                        {
                            this.vuK = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Context context = this.vuK.vuJ;
                                    ap.vd().a(new h(h.hRL), 0);
                                    context.getString(R.l.dIO);
                                    context.irJ = g.a(context, context.getString(R.l.eSL), true, new OnCancelListener(context) {
                                        final /* synthetic */ BindQQUI vuJ;

                                        {
                                            this.vuJ = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
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
        if (this.type == 1) {
            a(0, getString(R.l.dHy), new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI vuJ;

                {
                    this.vuJ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.vuJ.zu(1);
                    return true;
                }
            });
        } else {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI vuJ;

                {
                    this.vuJ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.vuJ.aHf();
                    this.vuJ.finish();
                    return true;
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        if (kVar.getType() == i.CTRL_BYTE) {
            if (i == 0 && i2 == 0) {
                this.plp = ((h) kVar).IO();
                if (this.plp != null && this.plp.length() > 0) {
                    ap.yY();
                    c.vr().set(102407, this.plp);
                }
                if (bg.mA(this.plq)) {
                    ap.vd().a(new v(2), 0);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.plq);
                MMWizardActivity.z(this, intent);
                return;
            }
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            if (i2 == -3) {
                w.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                g.a(this.uSU.uTo, getString(R.l.eUG), null, getString(R.l.eUH), getString(R.l.eUF), true, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI vuJ;

                    {
                        this.vuJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", this.vuJ.getString(R.l.eUE));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bb.d.b(this.vuJ, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI vuJ;

                    {
                        this.vuJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -81) {
                g.a((Context) this, R.l.eRH, R.l.dIO, null);
            } else if (i2 == -82) {
                g.a((Context) this, R.l.eRI, R.l.dIO, null);
            } else if (i2 == -83) {
                g.a((Context) this, R.l.eRF, R.l.dIO, null);
            } else if (i2 == -84) {
                g.a((Context) this, R.l.eRG, R.l.dIO, null);
            } else if (i2 == -85) {
                g.a((Context) this, R.l.eRE, R.l.dIO, null);
            } else if (i2 == -86) {
                g.a((Context) this, R.l.eRJ, R.l.dIO, null);
            }
        } else if (kVar.getType() != 255) {
        } else {
            if (i2 == 0) {
                MMWizardActivity.z(this, new Intent(this, StartUnbindQQ.class));
            } else {
                g.a(this.uSU.uTo, getString(R.l.eUG), null, getString(R.l.eUH), getString(R.l.eUF), true, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI vuJ;

                    {
                        this.vuJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", this.vuJ.getString(R.l.eUE));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bb.d.b(this.vuJ, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI vuJ;

                    {
                        this.vuJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    w.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    ap.vd().a(new h(h.hRL), 0);
                    getString(R.l.dIO);
                    this.irJ = g.a((Context) this, getString(R.l.eSL), true, new OnCancelListener(this) {
                        final /* synthetic */ BindQQUI vuJ;

                        {
                            this.vuJ = r1;
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
