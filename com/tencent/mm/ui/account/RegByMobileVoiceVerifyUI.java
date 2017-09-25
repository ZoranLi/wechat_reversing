package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class RegByMobileVoiceVerifyUI extends MMActivity implements e {
    private String fOI;
    private TextView itE;
    private String oVk;
    private String plh;
    private String uXZ;
    private s vaA;
    private t vaB;
    private int vaC = 0;

    static /* synthetic */ int d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        switch (regByMobileVoiceVerifyUI.vaC) {
            case 0:
                return 14;
            case 2:
                return 8;
            default:
                return 16;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fOI = getIntent().getExtras().getString("bindmcontact_mobile");
        this.vaC = getIntent().getExtras().getInt("voice_verify_type");
        if (this.vaC == 0 || this.vaC == 2 || this.vaC == 3) {
            ap.vd().a((int) a.CTRL_INDEX, (e) this);
        } else if (this.vaC == 4 || this.vaC == 1) {
            ap.vd().a(132, (e) this);
        }
        this.oVk = b.Oz();
        KC();
    }

    protected void onResume() {
        super.onResume();
        if (this.vaC == 0 || this.vaC == 2 || this.vaC == 3) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R200_500," + ap.ec("R200_500") + ",1");
            b.mM("R200_500");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(132, (e) this);
        ap.vd().b((int) a.CTRL_INDEX, (e) this);
        if (this.vaC == 0 || this.vaC == 2 || this.vaC == 3) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R200_500," + ap.ec("R200_500") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        b.mN(this.oVk);
        aHf();
        finish();
        return true;
    }

    protected final void KC() {
        zi(R.l.dOq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI vaD;

            {
                this.vaD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vaD.aHf();
                this.vaD.finish();
                return true;
            }
        });
        this.itE = (TextView) findViewById(R.h.car);
        Button button = (Button) findViewById(R.h.btt);
        this.uXZ = RegByMobileVoiceVerifySelectUI.SQ(this.fOI);
        this.itE.setText(this.uXZ);
        this.plh = com.tencent.mm.ai.b.jO(this.fOI);
        findViewById(R.h.cby).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI vaD;

            {
                this.vaD = r1;
            }

            public final void onClick(View view) {
                this.vaD.startActivityForResult(new Intent(this.vaD, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", this.vaD.plh), 10000);
            }
        });
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI vaD;

            {
                this.vaD = r1;
            }

            public final void onClick(View view) {
                if (this.vaD.vaC == 0 || this.vaD.vaC == 2 || this.vaD.vaC == 3) {
                    this.vaD.vaA = new s(this.vaD.fOI, RegByMobileVoiceVerifyUI.d(this.vaD), "", 1, this.vaD.plh);
                    ap.vd().a(this.vaD.vaA, 0);
                    g.a(this.vaD, R.l.dOo, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 vaE;

                        {
                            this.vaE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vaE.vaD.finish();
                        }
                    });
                } else if (this.vaD.vaC == 4 || this.vaD.vaC == 1) {
                    this.vaD.vaB = new t(this.vaD.fOI, 1, "", 1, this.vaD.plh);
                    ap.vd().a(this.vaD.vaB, 0);
                    g.a(this.vaD, R.l.dOo, R.l.dIO, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 vaE;

                        {
                            this.vaE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vaE.vaD.finish();
                        }
                    });
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10000 && intent != null) {
            this.uXZ = intent.getStringExtra("voice_verify_language");
            this.plh = intent.getStringExtra("voice_verify_code");
            this.itE.setText(this.uXZ);
        }
    }

    protected final int getLayoutId() {
        return R.i.cVG;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }
}
