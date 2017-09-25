package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.n.d;

public final class e {
    boolean mSA = false;
    public TextView mSB = null;
    public TextView mSC = null;
    public LinearLayout mSD = null;
    public TextView mSE = null;
    public ImageView mSF = null;
    ListView mSw;
    public h mSx;
    View mSy;
    public IPCallAddressUI mSz;

    class AnonymousClass9 implements d {
        final /* synthetic */ e mSG;
        final /* synthetic */ k mSH;
        final /* synthetic */ int mSI;

        AnonymousClass9(e eVar, k kVar, int i) {
            this.mSG = eVar;
            this.mSH = kVar;
            this.mSI = i;
        }

        public final void c(MenuItem menuItem, int i) {
            if (i == 0) {
                e eVar = this.mSG;
                k kVar = this.mSH;
                int i2 = this.mSI;
                l aEo;
                if (kVar.field_addressId > 0) {
                    aEo = i.aEo();
                    if (kVar.field_addressId > 0 && aEo.gUz.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)}) < 0) {
                        w.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[]{Integer.valueOf(aEo.gUz.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)})), Long.valueOf(r4)});
                    }
                } else {
                    aEo = i.aEo();
                    if (!bg.mA(kVar.field_phonenumber) && aEo.gUz.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber}) < 0) {
                        w.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[]{Integer.valueOf(aEo.gUz.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber})), r1});
                    }
                }
                h hVar = eVar.mSx;
                hVar.mVI.remove(i2);
                hVar.notifyDataSetChanged();
                if (eVar.mSx.getCount() > 0) {
                    eVar.mSy.setVisibility(8);
                } else {
                    eVar.mSy.setVisibility(0);
                }
            }
        }
    }

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.mSw = listView;
        this.mSz = iPCallAddressUI;
        this.mSy = view;
    }

    public final void aEX() {
        af.v(new Runnable(this) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final void run() {
                ap.yY();
                if (((Boolean) c.vr().get(a.uBD, Boolean.valueOf(false))).booleanValue()) {
                    this.mSG.mSF.setVisibility(0);
                } else {
                    this.mSG.mSF.setVisibility(8);
                }
                ap.yY();
                String str = (String) c.vr().get(a.uBF, "");
                ap.yY();
                String str2 = (String) c.vr().get(a.uBG, "");
                if (!bg.mA(str)) {
                    this.mSG.mSE.setText(str);
                    this.mSG.mSD.setVisibility(0);
                } else if (bg.mA(str2)) {
                    this.mSG.mSE.setText("");
                    this.mSG.mSD.setVisibility(8);
                } else {
                    this.mSG.mSE.setText(str2);
                    this.mSG.mSD.setVisibility(0);
                }
            }
        });
    }

    public final void aEY() {
        af.v(new Runnable(this) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final void run() {
                adf aFz = com.tencent.mm.plugin.ipcall.b.c.aFz();
                if (aFz != null) {
                    this.mSG.mSB.setText(aFz.tIK);
                    if (bg.mA(aFz.tIS)) {
                        this.mSG.mSC.setText("");
                        this.mSG.mSC.setVisibility(8);
                        return;
                    }
                    this.mSG.mSC.setText(aFz.tIS);
                    this.mSG.mSC.setVisibility(0);
                    return;
                }
                this.mSG.mSB.setText("");
                this.mSG.mSC.setText("");
                this.mSG.mSC.setVisibility(8);
            }
        });
    }
}
