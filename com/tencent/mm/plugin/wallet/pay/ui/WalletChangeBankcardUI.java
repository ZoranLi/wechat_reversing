package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rx;
import com.tencent.mm.e.a.sf;
import com.tencent.mm.e.a.sg;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.a {
    public static int ryZ = 1;
    protected int fRv = 0;
    protected TextView kna;
    public String lOK;
    public Orders oSJ = null;
    public l ruh;
    public ArrayList<Bankcard> ruj;
    public Bankcard ruk = null;
    public Authen rxw = null;
    protected ListView rza;
    protected Button rzb;
    public int rzc;
    public e rzd = null;
    public PayInfo rze = null;
    protected String rzf = null;
    public FavorPayInfo rzg;
    private a rzh;
    c rzi = null;
    private com.tencent.mm.sdk.b.c rzj = new com.tencent.mm.sdk.b.c<sf>(this) {
        final /* synthetic */ WalletChangeBankcardUI rzk;

        {
            this.rzk = r2;
            this.usg = sf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.i("MicroMsg.WalletSelectUseBankcardUI", "realnameNotifyListener %s", new Object[]{Integer.valueOf(((sf) bVar).fZL.result)});
            if (-1 == ((sf) bVar).fZL.result) {
                this.rzk.vt(-1);
            }
            return false;
        }
    };

    private void vt(int i) {
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        if (ai != null) {
            ai.c(this, 1);
        } else {
            finish();
        }
        b sgVar = new sg();
        sgVar.fZM.result = -1;
        com.tencent.mm.sdk.b.a.urY.m(sgVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.WalletSelectUseBankcardUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == ryZ) {
            vt(-1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fkh);
        Bundle bundle2 = this.uT;
        bundle2.putInt("key_err_code", 0);
        this.rzc = bundle2.getInt("key_support_bankcard", 1);
        this.rxw = (Authen) bundle2.getParcelable("key_authen");
        this.oSJ = (Orders) bundle2.getParcelable("key_orders");
        this.rze = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.rzg = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        this.fRv = this.rze == null ? 0 : this.rze.fRv;
        w.i("MicroMsg.WalletSelectUseBankcardUI", "pay_scene %d", new Object[]{Integer.valueOf(this.fRv)});
        if (this.uT.getBoolean("key_is_filter_bank_type")) {
            iu(true);
        } else {
            this.ruj = it(bsL());
        }
        if (!(this.oSJ == null || this.oSJ.rGe == null || this.oSJ.rGe.size() <= 0)) {
            this.rzf = getString(R.l.feT, new Object[]{com.tencent.mm.wallet_core.ui.e.d(this.oSJ.rFM, this.oSJ.oga), ((Commodity) this.oSJ.rGe.get(0)).desc});
        }
        bsM();
        KC();
        o.ev(7, 0);
        com.tencent.mm.sdk.b.a.urY.b(this.rzj);
        if (this.uT.getBoolean("key_is_filter_bank_type") && this.rzd != null) {
            this.rzd.rKH = false;
        }
    }

    private ArrayList<Bankcard> it(boolean z) {
        if (this.fRv == 8) {
            com.tencent.mm.plugin.wallet.a.o.bsC();
            return com.tencent.mm.plugin.wallet.a.o.bsD().iB(z);
        }
        com.tencent.mm.plugin.wallet.a.o.bsC();
        return com.tencent.mm.plugin.wallet.a.o.bsD().it(z);
    }

    public void onDestroy() {
        if (this.rzh != null) {
            this.rzh.bsK();
            this.rzh.release();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.rzj);
        this.rzi = null;
        super.onDestroy();
    }

    private boolean bsL() {
        return (this.rze == null || this.rze.fRv == 11) ? false : true;
    }

    protected final void bsM() {
        if (this.ruj != null) {
            Collections.sort(this.ruj, new Comparator<Bankcard>(this) {
                final /* synthetic */ WalletChangeBankcardUI rzk;

                {
                    this.rzk = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    Bankcard bankcard = (Bankcard) obj;
                    Bankcard bankcard2 = (Bankcard) obj2;
                    if (bankcard.btA()) {
                        return -1;
                    }
                    if (bankcard.btB()) {
                        return bankcard2.btA() ? 1 : -1;
                    } else {
                        if (bg.PO(bankcard.field_forbidWord) < bg.PO(bankcard2.field_forbidWord)) {
                            return 1;
                        }
                        return bg.PO(bankcard.field_forbidWord) <= bg.PO(bankcard2.field_forbidWord) ? 0 : -1;
                    }
                }
            });
        }
    }

    public final void KC() {
        this.rzb = (Button) findViewById(R.h.cqJ);
        this.rzb.setEnabled(false);
        this.rzb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletChangeBankcardUI rzk;

            {
                this.rzk = r1;
            }

            public final void onClick(View view) {
                this.rzk.bsO();
            }
        });
        if (bg.mA(this.uT.getString("key_pwd1"))) {
            this.rzb.setText(R.l.dHT);
        } else {
            this.rzb.setText(R.l.fjg);
        }
        this.rza = (ListView) findViewById(R.h.cDo);
        this.rzd = bsN();
        this.rza.setAdapter(this.rzd);
        this.rza.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletChangeBankcardUI rzk;

            {
                this.rzk = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.rzk.vu(i);
            }
        });
        ar();
    }

    public e bsN() {
        bsM();
        return new e(this, this.ruj, this.rzc, this.oSJ);
    }

    public final void ar() {
        this.kna = (TextView) findViewById(R.h.bXM);
        if (this.rzg != null && !bg.mA(this.rzg.rFq)) {
            this.kna.setVisibility(0);
            this.kna.setText(this.rzg.rFq);
        } else if (this.uT.getInt("key_main_bankcard_state", 0) != 0) {
            this.kna.setVisibility(0);
            this.kna.setText(this.rzf);
        } else {
            this.kna.setVisibility(8);
        }
    }

    protected void vu(int i) {
        int size = this.ruj != null ? this.ruj.size() : 0;
        if (this.ruj != null && i < size) {
            Bankcard bankcard = (Bankcard) this.ruj.get(i);
            this.ruk = bankcard;
            this.rzd.rKG = bankcard.field_bindSerial;
            this.rzb.setEnabled(true);
            this.rzd.notifyDataSetChanged();
            bsO();
        } else if (size == i) {
            this.uT.putInt("key_err_code", -1003);
            com.tencent.mm.wallet_core.a.k(this, this.uT);
        }
    }

    public void onResume() {
        this.uT.putInt("key_err_code", 0);
        super.onResume();
        if (this.rzi != null) {
            this.rzi.buN();
        }
    }

    public final boolean aIY() {
        if (super.aIY()) {
            return true;
        }
        if (this.rze == null || !this.rze.mqD) {
            return false;
        }
        if (this.rze.mqD) {
            return true;
        }
        com.tencent.mm.plugin.wallet.a.o.bsC();
        if (com.tencent.mm.plugin.wallet.a.o.bsD().bum()) {
            return false;
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dqr;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.rzg != null && this.ruj.size() == 0) {
            FavorPayInfo favorPayInfo = this.rzg;
            boolean z = (favorPayInfo == null || favorPayInfo.rFn == 0) ? false : true;
            if (z) {
                w.i("MicroMsg.WalletSelectUseBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.uT.getString("key_is_cur_bankcard_bind_serial");
                if (bg.mA(string)) {
                    w.e("MicroMsg.WalletSelectUseBankcardUI", "curBankcardBindSerial null & finish");
                    return super.onKeyUp(i, keyEvent);
                }
                List it = it(true);
                if (it != null && this.ruk == null) {
                    for (int i2 = 0; i2 < it.size(); i2++) {
                        if (string.equals(((Bankcard) it.get(i2)).field_bindSerial)) {
                            w.i("MicroMsg.WalletSelectUseBankcardUI", "get cur bankcard, bind_serial:" + string);
                            this.ruk = (Bankcard) it.get(i2);
                            break;
                        }
                    }
                    if (this.ruk == null) {
                        w.e("MicroMsg.WalletSelectUseBankcardUI", "mDefaultBankcard still null & finish");
                        return super.onKeyUp(i, keyEvent);
                    }
                }
                bsO();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putString("pwd", this.lOK);
            this.uT.putBoolean("key_need_verify_sms", false);
            com.tencent.mm.pluginsdk.l.a.sBC.a(this.rxw.oLz.sYf == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                case 100102:
                    this.rze.sYh = i2;
                    bsO();
                    return true;
                case 100100:
                case 100101:
                    this.rze.sYh = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.rzh == null) {
                        this.rzh = new a(this, this);
                    }
                    this.rzh.a(z, this.rze.fLS, this.rze.fJH);
                    w.i("MicroMsg.WalletSelectUseBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.b.e) {
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                Bundle bundle2 = this.uT;
                com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                if (!bg.mA(this.lOK)) {
                    bundle2.putString("key_pwd1", this.lOK);
                }
                bundle2.putString("kreq_token", bVar.token);
                bundle2.putParcelable("key_authen", bVar.ryN);
                String str2 = "key_need_verify_sms";
                if (!bVar.ryL) {
                    z = true;
                }
                bundle2.putBoolean(str2, z);
                bundle2.putParcelable("key_pay_info", this.rze);
                bundle2.putInt("key_pay_flag", 3);
                Parcelable parcelable = bVar.ocy;
                if (parcelable != null) {
                    bundle2.putParcelable("key_realname_guide_helper", parcelable);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.lOK);
                com.tencent.mm.pluginsdk.l.a.sBC.a(bVar.bsH(), true, bundle3);
                if (bVar.rzL) {
                    bundle2.putParcelable("key_orders", bVar.ryM);
                    if (this.rze != null && this.rze.fRv == 8) {
                        b rxVar = new rx();
                        rxVar.fZq.fZr = this.rxw.ofe;
                        com.tencent.mm.sdk.b.a.urY.m(rxVar);
                    }
                }
                com.tencent.mm.wallet_core.a.k(this, bundle2);
                return true;
            }
        }
        return false;
    }

    public void bsO() {
        w.d("MicroMsg.WalletSelectUseBankcardUI", "pay with old bankcard!");
        String string = this.uT.getString("key_pwd1");
        if (bg.mA(string)) {
            re(4);
            this.ruh = l.a(this, this.oSJ, this.rzg, this.ruk, this.rze, new l.c(this) {
                final /* synthetic */ WalletChangeBankcardUI rzk;

                {
                    this.rzk = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.rzk.rzg = favorPayInfo;
                    this.rzk.uT.putParcelable("key_favor_pay_info", this.rzk.rzg);
                    if (this.rzk.rzg == null || !z) {
                        this.rzk.lOK = str;
                        this.rzk.aHf();
                        this.rzk.HM(str);
                        this.rzk.rzi = null;
                        return;
                    }
                    if (this.rzk.rzg != null) {
                        this.rzk.iu(true);
                        this.rzk.rzd.e(this.rzk.ruj, false);
                    }
                    if (this.rzk.ruh != null) {
                        this.rzk.ruh.dismiss();
                    }
                    this.rzk.ar();
                    this.rzk.re(0);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletChangeBankcardUI rzk;

                {
                    this.rzk = r1;
                }

                public final void onClick(View view) {
                    if (this.rzk.ruh != null) {
                        this.rzk.ruh.dismiss();
                    }
                    this.rzk.iu(false);
                    this.rzk.rzd.e(this.rzk.ruj, true);
                    this.rzk.rzg = (FavorPayInfo) view.getTag();
                    if (this.rzk.rzg != null) {
                        this.rzk.rzg.rFq = "";
                    }
                    this.rzk.uT.putParcelable("key_favor_pay_info", this.rzk.rzg);
                    this.rzk.ar();
                    this.rzk.re(0);
                    this.rzk.rzi = null;
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletChangeBankcardUI rzk;

                {
                    this.rzk = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.rzk.lOK = null;
                    if (this.rzk.uSU.ipu.getVisibility() != 0) {
                        this.rzk.bsQ();
                    }
                    this.rzk.rzi = null;
                }
            });
            this.rzi = this.ruh;
            return;
        }
        HM(string);
    }

    public void HM(String str) {
        this.rxw.rDC = str;
        if (this.ruk != null) {
            this.uT.putString("key_mobile", this.ruk.field_mobile);
            this.uT.putParcelable("key_bankcard", this.ruk);
            this.rxw.ofe = this.ruk.field_bindSerial;
            this.rxw.ofd = this.ruk.field_bankcardType;
            if (this.rzg != null) {
                this.rxw.rDO = this.rzg.rFm;
            } else {
                this.rxw.rDO = null;
            }
            if (this.oSJ.rGf != null) {
                this.rxw.rDN = this.oSJ.rGf.rxP;
            }
            if (this.oSJ != null && this.oSJ.rBY == 3) {
                boolean z;
                if (this.ruk.btD()) {
                    this.rxw.fRW = 3;
                } else {
                    this.rxw.fRW = 6;
                }
                Bundle bundle = this.uT;
                String str2 = "key_is_oversea";
                if (this.ruk.btD()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.uT.putString("key_pwd1", str);
        this.uT.putParcelable("key_authen", this.rxw);
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.rxw, this.oSJ, false);
        if (a != null) {
            a.gWO = "PayProcess";
            a.uT = this.uT;
            if (this.rze.fRv == 6 && this.rze.sYa == 100) {
                a.hPi = 100;
            } else {
                a.hPi = this.rze.fRv;
            }
            k(a);
        }
    }

    protected final boolean bsP() {
        return true;
    }

    public final void qU(int i) {
        if (i == 0) {
            bsQ();
        } else if (i == 1) {
            this.uT.putString("key_pwd1", "");
            bsO();
        } else {
            w.w("MicroMsg.WalletSelectUseBankcardUI", "hy: clean ui data not handled");
        }
    }

    public final void bsQ() {
        ccB();
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        if (ai != null) {
            ai.d(this, this.uT);
        } else {
            finish();
        }
    }

    protected int Ol() {
        return 1;
    }

    protected final void iu(boolean z) {
        this.ruj = it(bsL());
        if (this.rzg != null) {
            Object obj;
            if (this.rzg.rFn != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && z) {
                String str = this.rzg.rFo;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.ruj.size(); i++) {
                    Bankcard bankcard = (Bankcard) this.ruj.get(i);
                    if (bg.mA(str)) {
                        if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                            arrayList.add(bankcard);
                        }
                    } else if (bankcard.field_bankcardType.equals(str)) {
                        arrayList.add(bankcard);
                    }
                }
                this.ruj = arrayList;
                bsM();
            }
        }
    }

    protected final boolean aJb() {
        return true;
    }

    public final void c(boolean z, String str, String str2) {
        w.i("MicroMsg.WalletSelectUseBankcardUI", "onGenFinish callback");
        if (z) {
            w.i("MicroMsg.WalletSelectUseBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.rze.fLU = str;
            this.rze.fLV = str2;
            HM(this.lOK);
            return;
        }
        w.e("MicroMsg.WalletSelectUseBankcardUI", "onGenFinish callback, result.isSuccess is false");
        HM(this.lOK);
    }

    public void onPause() {
        super.onPause();
        if (this.rzi != null) {
            this.rzi.buO();
        }
    }
}
