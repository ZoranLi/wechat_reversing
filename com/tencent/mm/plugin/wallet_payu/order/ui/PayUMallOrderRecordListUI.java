package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    protected final void aRK() {
        hn(1519);
        hn(1544);
    }

    protected final void aRL() {
        ho(1519);
        ho(1544);
    }

    protected final void db(String str, String str2) {
        k(new b(str));
    }

    protected final void aRM() {
        k(new a(this.wa));
    }

    protected final String qX(int i) {
        return e.a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Iterator it;
        if (kVar instanceof a) {
            if (this.lOO != null) {
                this.lOO.dismiss();
                this.lOO = null;
            }
            a aVar = (a) kVar;
            LinkedList linkedList = ((apy) aVar.gUA.hsk.hsr).tUX;
            List linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                aqi com_tencent_mm_protocal_c_aqi = (aqi) it.next();
                i iVar = new i();
                iVar.muS = com_tencent_mm_protocal_c_aqi.muS;
                iVar.ogT = com_tencent_mm_protocal_c_aqi.ogT;
                iVar.ogU = com_tencent_mm_protocal_c_aqi.ogU;
                iVar.ogM = com_tencent_mm_protocal_c_aqi.ogM;
                iVar.ogP = com_tencent_mm_protocal_c_aqi.ogP;
                iVar.ogL = com_tencent_mm_protocal_c_aqi.ogL;
                iVar.ogS = "0";
                iVar.ogO = com_tencent_mm_protocal_c_aqi.ogO;
                iVar.ogR = com_tencent_mm_protocal_c_aqi.ogR;
                iVar.ogX = 1;
                iVar.ogW = com_tencent_mm_protocal_c_aqi.ogW;
                iVar.ogV = com_tencent_mm_protocal_c_aqi.ogV;
                iVar.ogQ = com_tencent_mm_protocal_c_aqi.ogQ;
                iVar.ogK = (double) com_tencent_mm_protocal_c_aqi.tUP;
                iVar.ogN = com_tencent_mm_protocal_c_aqi.ogN;
                iVar.ogJ = com_tencent_mm_protocal_c_aqi.ogJ;
                linkedList2.add(iVar);
            }
            aX(linkedList2);
            aY(null);
            this.mCount = this.ohS.size();
            this.nrj = aVar.bvD() > this.mCount;
            this.ohR.notifyDataSetChanged();
            w.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            w.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.bvD());
            w.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.nrj);
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ PayUMallOrderRecordListUI rSa;

                {
                    this.rSa = r1;
                }

                public final void run() {
                    if (this.rSa.nrj) {
                        w.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
                        if (!this.rSa.ohU) {
                            this.rSa.kwZ.bSh();
                            this.rSa.kwZ.setAdapter(this.rSa.ohR);
                            this.rSa.ohU = true;
                        }
                    } else {
                        w.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
                        this.rSa.kwZ.bSi();
                    }
                    this.rSa.ohR.notifyDataSetChanged();
                }
            });
            this.kxr = false;
        } else if (kVar instanceof g) {
            if (this.lOO != null) {
                this.lOO.dismiss();
                this.lOO = null;
            }
            g gVar = (g) kVar;
            if (gVar.aRF() == 2) {
                if (this.ohS != null) {
                    this.ohS.clear();
                }
                this.mCount = 0;
                this.nrj = false;
                this.kwZ.bSi();
            } else {
                String aRG = gVar.aRG();
                w.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:" + aRG);
                if (!bg.mA(aRG)) {
                    for (i iVar2 : this.ohS) {
                        if (aRG.equals(iVar2.ogJ)) {
                            this.ohS.remove(iVar2);
                            this.mCount = this.ohS.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ PayUMallOrderRecordListUI rSa;

                {
                    this.rSa = r1;
                }

                public final void run() {
                    this.rSa.ohR.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.ohS.size() != 0) {
            ks(true);
            findViewById(R.h.bLY).setVisibility(8);
        } else {
            ks(false);
            findViewById(R.h.bLY).setVisibility(0);
        }
        return true;
    }
}
