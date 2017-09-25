package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public final class l implements com.tencent.mm.vending.c.b<k> {
    protected k rub;
    public final c ruc;
    public final a rud;
    public final b rue;

    public class a implements e<aui, Integer> {
        final /* synthetic */ l ruf;

        public a(l lVar) {
            this.ruf = lVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            Integer num = (Integer) obj;
            k kVar = this.ruf.rub;
            int intValue = num.intValue();
            kVar.rtX = intValue;
            kVar.rtU.SU();
            g.a(g.bN(Integer.valueOf(intValue)).a(kVar.rtT.rtO).a(new com.tencent.mm.vending.c.a<Void, arc>(kVar) {
                final /* synthetic */ k rua;

                {
                    this.rua = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    arc com_tencent_mm_protocal_c_arc = (arc) obj;
                    this.rua.rtU.aCP();
                    this.rua.ink = g.cbB();
                    this.rua.ink.cbA();
                    this.rua.rtY = com_tencent_mm_protocal_c_arc.tVz;
                    Intent intent = new Intent(this.rua.rtU, WalletLqtCheckPwdInputDialogUI.class);
                    intent.putExtra("lqt_fetch_pwd_title", this.rua.rtU.getString(R.l.fgv));
                    intent.putExtra("lqt_fetch_pwd_money", (((double) this.rua.rtX) / 100.0d));
                    this.rua.rtU.startActivityForResult(intent, k.rtR);
                    return wCE;
                }
            }));
            return null;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public class b implements e<Void, Void> {
        final /* synthetic */ l ruf;

        public b(l lVar) {
            this.ruf = lVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            k kVar = this.ruf.rub;
            kVar.ink = g.cbB();
            kVar.ink.cbA();
            kVar.rtU.b(new m(null, 0), true);
            return wCE;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public class c implements e<aso, Integer> {
        final /* synthetic */ l ruf;

        public c(l lVar) {
            this.ruf = lVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            Integer num = (Integer) obj;
            k kVar = this.ruf.rub;
            int intValue = num.intValue();
            String stringExtra = kVar.rtU.getIntent().getStringExtra("lqt_save_fund_code");
            kVar.rtW = intValue;
            kVar.rtU.SU();
            g.a(g.s(stringExtra, Integer.valueOf(intValue)).a(kVar.rtT.rtL).a(new com.tencent.mm.vending.c.a<asf, asf>(kVar) {
                final /* synthetic */ k rua;

                {
                    this.rua = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    asf com_tencent_mm_protocal_c_asf = (asf) obj;
                    this.rua.rtV = com_tencent_mm_protocal_c_asf.tbC;
                    this.rua.rtU.aCP();
                    return com_tencent_mm_protocal_c_asf;
                }
            }).a(new com.tencent.mm.vending.c.a<Void, asf>(kVar) {
                final /* synthetic */ k rua;

                {
                    this.rua = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    asf com_tencent_mm_protocal_c_asf = (asf) obj;
                    k kVar = this.rua;
                    String str = com_tencent_mm_protocal_c_asf.tWD;
                    kVar.ink = g.cbB();
                    kVar.ink.cbA();
                    com.tencent.mm.pluginsdk.wallet.e.a(kVar.rtU, kVar.rtZ != null ? kVar.rtZ.field_bindSerial : "", str, "", 45, k.rtQ);
                    return null;
                }
            }).a(new com.tencent.mm.vending.g.d.a(kVar) {
                final /* synthetic */ k rua;

                {
                    this.rua = r1;
                }

                public final void aD(Object obj) {
                    this.rua.rtU.aCP();
                    g.cbB().bJ(obj);
                }
            }));
            return null;
        }

        public final String NN() {
            return "Vending.UI";
        }
    }

    public final /* bridge */ /* synthetic */ Object NM() {
        return this.rub;
    }

    public l() {
        this(new k());
    }

    public l(k kVar) {
        this.ruc = new c(this);
        this.rud = new a(this);
        this.rue = new b(this);
        this.rub = kVar;
    }
}
