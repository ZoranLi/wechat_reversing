package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.account.h;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class ShareToQQUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private EditText oBT;
    private TextView pio;
    private int pip;
    private boolean piq = false;

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        w.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.piq) {
            String string = shareToQQUI.uSU.uTo.getString(R.l.dIO);
            g.a(shareToQQUI.uSU.uTo, shareToQQUI.uSU.uTo.getString(R.l.ehf), string, new OnClickListener(shareToQQUI) {
                final /* synthetic */ ShareToQQUI pir;

                {
                    this.pir = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(this.pir.uSU.uTo, FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    this.pir.uSU.uTo.startActivityForResult(intent, 8);
                }
            }, null);
        }
    }

    protected final int getLayoutId() {
        return R.i.dan;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(26, this);
        KC();
        if (m.ym()) {
            c cVar = new c("290293790992170");
            ap.yY();
            cVar.TX(bg.mz((String) com.tencent.mm.u.c.vr().get(65830, null)));
            new h(cVar, new a(this) {
                final /* synthetic */ ShareToQQUI pir;

                {
                    this.pir = r1;
                }

                public final void m(Bundle bundle) {
                    super.m(bundle);
                }

                public final void onError(int i, String str) {
                    super.onError(i, str);
                    if (i == 3) {
                        ShareToQQUI.d(this.pir);
                    }
                }
            }).bQS();
        }
    }

    public void onDestroy() {
        ap.vd().b(26, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eRg);
        this.oBT = (EditText) findViewById(R.h.content);
        this.pio = (TextView) findViewById(R.h.cTh);
        this.oBT.addTextChangedListener(new MMEditText.c(this.oBT, this.pio, 280));
        this.pip = getIntent().getIntExtra("show_to", 2);
        if (this.pip == 4) {
            this.oBT.setText(R.l.eQP);
        } else {
            this.oBT.setText(R.l.eQR);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQUI pir;

            {
                this.pir = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pir.aHf();
                this.pir.finish();
                return true;
            }
        });
        a(0, getString(R.l.dIE), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQUI pir;

            {
                this.pir = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                k abVar;
                this.pir.piq = true;
                if (this.pir.pip == 2 || this.pir.pip == 1) {
                    boolean z;
                    boolean z2;
                    String obj = this.pir.oBT.getText().toString();
                    if (this.pir.pip == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.pir.pip == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    abVar = new ab(obj, z, z2);
                } else if (this.pir.pip == 4) {
                    ap.yY();
                    long c = bg.c((Long) com.tencent.mm.u.c.vr().get(65831, null));
                    ap.yY();
                    String mz = bg.mz((String) com.tencent.mm.u.c.vr().get(65830, null));
                    if (bg.aA(c) > 86400000 && mz.length() > 0) {
                        c cVar = new c("290293790992170");
                        cVar.TX(mz);
                        new h(cVar, new a(this) {
                            final /* synthetic */ AnonymousClass2 pis;

                            {
                                this.pis = r1;
                            }

                            public final void m(Bundle bundle) {
                                super.m(bundle);
                            }

                            public final void onError(int i, String str) {
                                super.onError(i, str);
                            }
                        }).bQS();
                    }
                    abVar = new ab(this.pir.oBT.getText().toString());
                } else {
                    g.h(this.pir.uSU.uTo, R.l.eWe, R.l.dIO);
                    return true;
                }
                ap.vd().a(abVar, 0);
                ShareToQQUI shareToQQUI = this.pir;
                Context context = this.pir.uSU.uTo;
                this.pir.getString(R.l.dIO);
                shareToQQUI.isv = g.a(context, this.pir.getString(R.l.ezo), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 pis;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(abVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 4 && i2 == -68) {
                if (bg.mA(str)) {
                    str = "error";
                }
                g.a(this, str, getString(R.l.dIO), new OnClickListener(this) {
                    final /* synthetic */ ShareToQQUI pir;

                    {
                        this.pir = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(this.pir.uSU.uTo, FacebookAuthUI.class);
                        intent.putExtra("is_force_unbind", true);
                        this.pir.uSU.uTo.startActivity(intent);
                        this.pir.aHf();
                        this.pir.finish();
                    }
                }, null);
            } else if (i == 0 && i2 == 0) {
                aHf();
                String string = getString(R.l.eWg);
                AnonymousClass4 anonymousClass4 = new OnDismissListener(this) {
                    final /* synthetic */ ShareToQQUI pir;

                    {
                        this.pir = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.pir.finish();
                    }
                };
                g.bl(this, string);
            } else {
                this.piq = false;
                if (!com.tencent.mm.plugin.setting.a.imw.a(this.uSU.uTo, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.eWf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }
}
