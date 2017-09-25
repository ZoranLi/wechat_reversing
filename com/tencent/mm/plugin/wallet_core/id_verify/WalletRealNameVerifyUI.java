package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener, a {
    private String countryCode;
    private String hnO;
    private String hnP;
    private Button liz;
    private TextView mXh;
    private WalletFormView rCR;
    private WalletFormView rCS;
    private WalletFormView rCT;
    private WalletFormView rCU;
    private CheckBox rCV;
    private TextView rCW;
    private ElementQuery rCX;
    private Profession rCY;
    private boolean rCZ = false;
    private Profession[] rCb;
    private boolean rDa = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.wFr.hn(1616);
        this.rCX = (ElementQuery) this.uT.getParcelable("elemt_query");
        KC();
        q(new g());
    }

    public void onDestroy() {
        this.wFr.ho(1616);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.fjp);
        this.liz = (Button) findViewById(R.h.cnY);
        this.rCR = (WalletFormView) findViewById(R.h.cmm);
        this.rCS = (WalletFormView) findViewById(R.h.bxR);
        this.rCT = (WalletFormView) findViewById(R.h.csw);
        this.rCU = (WalletFormView) findViewById(R.h.csv);
        this.rCW = (TextView) findViewById(R.h.bXM);
        this.rCR.wFY = this;
        this.rCS.wFY = this;
        this.rCT.wFY = this;
        this.rCU.wFY = this;
        this.rCR.setFocusable(true);
        this.rCR.oNt.setVisibility(8);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.rCS);
        b bVar = this.rCS.wGa;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).CN(1);
        }
        this.rCT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI rDb;

            {
                this.rDb = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.rDb.uSU.uTo, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", this.rDb.rCb);
                this.rDb.startActivityForResult(intent, 1);
            }
        });
        this.rCU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI rDb;

            {
                this.rDb = r1;
            }

            public final void onClick(View view) {
                this.rDb.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false).putExtra("IsRealNameVerifyScene", true).putExtra("IsNeedShowSearchBar", true), 2);
            }
        });
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI rDb;

            {
                this.rDb = r1;
            }

            public final void onClick(View view) {
                this.rDb.b(new d(this.rDb.rCR.getText(), this.rDb.rCS.getText(), this.rDb.uT.getInt("entry_scene", -1)), true);
            }
        });
        d(this.rCS, 1, false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI rDb;

            {
                this.rDb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ((a) this.rDb.ccE()).c(this.rDb, 0);
                this.rDb.finish();
                return true;
            }
        });
        this.rCV = (CheckBox) findViewById(R.h.bob);
        this.mXh = (TextView) findViewById(R.h.bnZ);
        this.rCV.setChecked(true);
        this.rCV.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI rDb;

            {
                this.rDb = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.rDb.liz.setEnabled(true);
                    this.rDb.liz.setClickable(true);
                    return;
                }
                this.rDb.liz.setEnabled(false);
                this.rDb.liz.setClickable(false);
            }
        });
        this.mXh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI rDb;

            {
                this.rDb = r1;
            }

            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.rDb.getString(R.l.fef));
                linkedList2.add(Integer.valueOf(0));
                if (this.rDb.rCX != null && this.rDb.rCX.rFk) {
                    linkedList.add(this.rDb.getString(R.l.fee));
                    linkedList2.add(Integer.valueOf(1));
                }
                com.tencent.mm.ui.base.g.a(this.rDb, "", linkedList, linkedList2, "", new com.tencent.mm.ui.base.g.d(this) {
                    final /* synthetic */ AnonymousClass6 rDc;

                    {
                        this.rDc = r1;
                    }

                    public final void bN(int i, int i2) {
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", this.rDc.rDb.getString(R.l.fda, new Object[]{v.bIN()}));
                                break;
                            case 1:
                                if (this.rDc.rDb.rCX != null) {
                                    intent.putExtra("rawUrl", this.rDc.rDb.getString(R.l.fcZ, new Object[]{v.bIN(), this.rDc.rDb.rCX.ofd}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bb.d.b(this.rDc.rDb.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (kVar instanceof d) {
            com.tencent.mm.wallet_core.b ccE = ccE();
            Bundle bundle = null;
            if (ccE != null) {
                bundle = ccE.lHw;
            }
            String str2 = ((d) kVar).token;
            w.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (ccE == null) {
                return true;
            }
            bundle.putString("key_real_name_token", str2);
            bundle.putString("key_country_code", this.countryCode);
            bundle.putString("key_province_code", this.hnP);
            bundle.putString("key_city_code", this.hnO);
            bundle.putParcelable("key_profession", this.rCY);
            ccE.a((Activity) this, 0, bundle);
            return true;
        } else if (kVar instanceof g) {
            g gVar = (g) kVar;
            this.rCZ = gVar.rBZ == 1;
            if (gVar.rCa == 1) {
                z = true;
            }
            this.rDa = z;
            if (!this.rDa) {
                this.rCT.setVisibility(8);
            }
            if (!this.rCZ) {
                this.rCU.setVisibility(8);
            }
            if (this.rCZ || this.rDa) {
                this.rCW.setText(R.l.fjn);
            }
            this.rCb = gVar.rDo;
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drl;
    }

    public void onClick(View view) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.rCY = (Profession) intent.getParcelableExtra("key_select_profession");
                this.rCT.setText(this.rCY.rDp);
                return;
            }
            w.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
        } else if (i != 2) {
        } else {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("ProviceName");
                String stringExtra3 = intent.getStringExtra("CityName");
                this.countryCode = intent.getStringExtra("Country");
                this.hnP = intent.getStringExtra("Contact_Province");
                this.hnO = intent.getStringExtra("Contact_City");
                StringBuilder stringBuilder = new StringBuilder();
                if (!bg.mA(stringExtra)) {
                    stringBuilder.append(stringExtra);
                }
                if (!bg.mA(stringExtra2)) {
                    stringBuilder.append(" ").append(stringExtra2);
                }
                if (!bg.mA(stringExtra3)) {
                    stringBuilder.append(" ").append(stringExtra3);
                }
                this.rCU.setText(stringBuilder.toString());
                return;
            }
            w.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
        }
    }

    public final void gA(boolean z) {
        boolean z2;
        w.d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.rCR.getText();
        String text2 = this.rCS.getText();
        if (bg.mA(text)) {
            z2 = false;
        } else if (bg.mA(text2)) {
            z2 = false;
        } else {
            if (this.rCZ) {
                z2 = (bg.mA(this.countryCode) && bg.mA(this.hnP) && bg.mA(this.hnO)) ? false : true;
                if (!z2) {
                    z2 = false;
                }
            }
            z2 = (this.rDa && this.rCY == null) ? false : true;
        }
        if (z2) {
            this.liz.setEnabled(true);
            this.liz.setClickable(true);
            return;
        }
        this.liz.setEnabled(false);
        this.liz.setClickable(false);
    }
}
