package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.bind.a.a;
import com.tencent.mm.plugin.wallet.bind.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class WalletBankcardDetailUI extends WalletBaseUI {
    public Bankcard ruU;
    protected TextView rwK;
    private TextView rwL;
    private View rwM;
    protected LinearLayout rwN;
    protected LinearLayout rwO;
    protected LinearLayout rwP;

    protected final int getLayoutId() {
        return R.i.dqf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(621);
        zi(R.l.fdS);
        KC();
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        ho(621);
        super.onDestroy();
    }

    protected final void KC() {
        this.ruU = (Bankcard) this.uT.getParcelable("key_bankcard");
        if (this.ruU != null) {
            this.rwN = (LinearLayout) findViewById(R.h.cPs);
            this.rwO = (LinearLayout) findViewById(R.h.cPz);
            this.rwP = (LinearLayout) findViewById(R.h.cPx);
            this.rwL = (TextView) findViewById(R.h.cPv);
            this.rwM = findViewById(R.h.cPE);
            this.rwM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI rwQ;

                {
                    this.rwQ = r1;
                }

                public final void onClick(View view) {
                    e.m(this.rwQ, this.rwQ.ruU.field_repay_url, false);
                }
            });
            if (1 == this.ruU.field_bankcardState) {
                bss();
                return;
            }
            String str;
            if (this.ruU.btD()) {
                iq(true);
                this.rwK = (TextView) findViewById(R.h.cPr);
                o.bsC();
                o.bsD();
                str = this.ruU.field_bindSerial;
                this.rwK.setVisibility(8);
            } else {
                iq(false);
                this.rwK = (TextView) findViewById(R.h.cPw);
                o.bsC();
                o.bsD();
                str = this.ruU.field_bindSerial;
                this.rwK.setVisibility(8);
            }
            a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI rwQ;

                {
                    this.rwQ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    o.bsC();
                    List buw = o.bsD().buw();
                    if (buw != null && buw.size() > 1) {
                        o.bsC();
                        o.bsD();
                        String str = this.rwQ.ruU.field_bindSerial;
                    }
                    List arrayList = new ArrayList();
                    g.a(this.rwQ, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.rwQ.getString(R.l.fgb), false, new c(this) {
                        final /* synthetic */ AnonymousClass5 rwR;

                        {
                            this.rwR = r1;
                        }

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    this.rwR.rwQ.b(new a(this.rwR.rwQ.ruU.field_bankcardType, this.rwR.rwQ.ruU.field_bindSerial), true);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }

    public final void iq(boolean z) {
        if (z) {
            this.rwN.setVisibility(8);
            this.rwO.setVisibility(0);
            ((TextView) findViewById(R.h.cPq)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBankcardDetailUI rwQ;

                {
                    this.rwQ = r1;
                }

                public final void onClick(View view) {
                    this.rwQ.showDialog(0);
                }
            });
            TextView textView = (TextView) findViewById(R.h.cPD);
            TextView textView2 = (TextView) findViewById(R.h.cPA);
            TextView textView3 = (TextView) findViewById(R.h.cPB);
            ((TextView) findViewById(R.h.cPC)).setText(e.d(this.ruU.field_onceQuotaKind, null));
            textView.setText(e.d(this.ruU.field_onceQuotaVirtual, null));
            textView2.setText(e.d(this.ruU.field_dayQuotaKind, null));
            textView3.setText(e.d(this.ruU.field_dayQuotaVirtual, null));
            if (!bg.mA(this.ruU.field_repay_url)) {
                this.rwL.setVisibility(0);
                this.rwM.setVisibility(0);
                return;
            }
            return;
        }
        this.rwN.setVisibility(8);
        this.rwO.setVisibility(8);
        this.rwP.setVisibility(0);
    }

    public final void bss() {
        this.rwN.setVisibility(0);
        this.rwO.setVisibility(8);
        ((TextView) findViewById(R.h.cPt)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI rwQ;

            {
                this.rwQ = r1;
            }

            public final void onClick(View view) {
                this.rwQ.showDialog(0);
            }
        });
        ((TextView) findViewById(R.h.cPG)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI rwQ;

            {
                this.rwQ = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.wallet_core.a.k(this.rwQ, this.rwQ.uT);
            }
        });
    }

    private void ir(boolean z) {
        if (m.xY() || z || com.tencent.mm.pluginsdk.g.a.aCG()) {
            this.uT.putBoolean("offline_pay", false);
            com.tencent.mm.wallet_core.a.k(this, this.uT);
            return;
        }
        e.CM(0);
        g.a(this, R.l.fdU, -1, R.l.fdT, R.l.fdV, true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI rwQ;

            {
                this.rwQ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.pluginsdk.g.a.T(this.rwQ);
                e.CM(1);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBankcardDetailUI rwQ;

            {
                this.rwQ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.rwQ.ir(true);
                e.CM(2);
            }
        });
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return g.a(this.uSU.uTo, getString(R.l.fdQ), getResources().getStringArray(R.c.aSt), "", new c(this) {
            final /* synthetic */ WalletBankcardDetailUI rwQ;

            {
                this.rwQ = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.rwQ.getString(R.l.fdP)).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.rwQ.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof b) {
                if (this.rwK == null) {
                    return false;
                }
                this.rwK.setVisibility(0);
                return false;
            } else if (!(kVar instanceof a)) {
                return false;
            } else {
                a aVar = (a) kVar;
                w.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + aVar.rwm);
                switch (aVar.rwm) {
                    case 2:
                    case 3:
                        final int i3 = aVar.rwm;
                        g.a(this, aVar.rwn, null, false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBankcardDetailUI rwQ;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (i3 == 2) {
                                    this.rwQ.ir(true);
                                }
                                dialogInterface.dismiss();
                            }
                        });
                        return false;
                    default:
                        ir(false);
                        return false;
                }
            }
        } else if (!(kVar instanceof a)) {
            return false;
        } else {
            w.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            ir(false);
            return true;
        }
    }
}
