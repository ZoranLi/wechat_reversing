package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class PayUMallOrderDetailUI extends WalletBaseUI {
    private TextView nsH;
    private TextView nte;
    private String ocu = "";
    private apu rRN;
    private LinearLayout rRO;
    private LinearLayout rRP;
    private LinearLayout rRQ;
    private LinearLayout rRR;
    private LinearLayout rRS;
    private LinearLayout rRT;
    private LinearLayout rRU;
    private TextView rRV;
    private TextView rRW;
    private TextView rRX;
    private TextView rRY;
    private TextView rRZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(1520);
        this.ocu = this.uT.getString("key_trans_id");
        if (bg.mA(this.ocu)) {
            w.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        k(new c(this.ocu));
        this.rRO = (LinearLayout) findViewById(R.h.bIM);
        this.rRP = (LinearLayout) findViewById(R.h.bIu);
        this.rRQ = (LinearLayout) findViewById(R.h.bIz);
        this.rRR = (LinearLayout) findViewById(R.h.bID);
        this.rRS = (LinearLayout) findViewById(R.h.bIK);
        this.rRT = (LinearLayout) findViewById(R.h.bIF);
        this.rRU = (LinearLayout) findViewById(R.h.bIO);
        this.rRV = (TextView) findViewById(R.h.bIN);
        this.rRW = (TextView) findViewById(R.h.bIv);
        this.rRX = (TextView) findViewById(R.h.bIA);
        this.rRY = (TextView) findViewById(R.h.bIE);
        this.nsH = (TextView) findViewById(R.h.bIL);
        this.nte = (TextView) findViewById(R.h.bIG);
        this.rRZ = (TextView) findViewById(R.h.bIP);
        bvE();
    }

    private void bvE() {
        if (this.rRN != null) {
            if (bg.mA(this.rRN.ogJ)) {
                this.rRO.setVisibility(8);
            } else {
                this.rRO.setVisibility(0);
                this.rRV.setText(this.rRN.ogJ);
            }
            if (bg.mA(this.rRN.ogT)) {
                this.rRP.setVisibility(8);
            } else {
                this.rRP.setVisibility(0);
                this.rRW.setText(this.rRN.ogT);
            }
            if (bg.mA(this.rRN.ogL)) {
                this.rRQ.setVisibility(8);
            } else {
                this.rRQ.setVisibility(0);
                this.rRX.setText(this.rRN.ogL);
            }
            if (bg.mA(this.rRN.ogP)) {
                this.rRR.setVisibility(8);
            } else {
                this.rRR.setVisibility(0);
                this.rRY.setText(e.d(((double) this.rRN.tUP) / 100.0d, this.rRN.ogP));
            }
            if (this.rRN.ogM >= 0) {
                this.rRS.setVisibility(0);
                this.nsH.setText(e.CK(this.rRN.ogM));
            } else {
                this.rRS.setVisibility(8);
            }
            if (bg.mA(this.rRN.ogN)) {
                this.rRT.setVisibility(8);
            } else {
                this.rRT.setVisibility(0);
                this.nte.setText(this.rRN.ogN);
            }
            switch (this.rRN.ogR) {
                case 3:
                    this.rRZ.setText(R.l.fdy);
                    return;
                case 5:
                    this.rRZ.setText(R.l.fga);
                    return;
                default:
                    this.rRZ.setText(R.l.fiQ);
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof c) {
            this.rRN = ((c) kVar).rRM;
            bvE();
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        ho(1520);
    }

    protected final int getLayoutId() {
        return R.i.dkw;
    }
}
