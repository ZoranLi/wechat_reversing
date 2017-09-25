package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.os;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI extends MMPreference implements e {
    public p irJ = null;
    private f isJ;
    private boolean qEE = false;
    private x qEF = null;
    private boolean qEG = false;
    private boolean qEH = false;
    private long qEI = 0;
    private int scene = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.vJ();
        h.vH().gXC.a(291, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.qEE = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.qEI = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        w.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[]{Integer.valueOf(this.scene)});
        h.vJ();
        this.qEF = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(this.userName);
        if (this.qEF == null) {
            w.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[]{this.userName});
            finish();
        }
        this.qEF.setUsername(this.userName);
        KC();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        a.imw.ou();
        h.vJ();
        h.vH().gXC.b(291, this);
        if (this.qEI != 0 && this.qEI != -1) {
            b osVar = new os();
            osVar.fVL.fVM = this.qEH;
            osVar.fVL.fLo = this.qEI;
            com.tencent.mm.sdk.b.a.urY.m(osVar);
        }
    }

    public final int ON() {
        return m.pNy;
    }

    protected final void KC() {
        this.isJ = this.vrv;
        zi(j.pLX);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsPermissionUI qEJ;

            {
                this.qEJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qEJ.aHf();
                this.qEJ.setResult(-1, new Intent());
                this.qEJ.finish();
                return true;
            }
        });
        bap();
    }

    private void bap() {
        h.vJ();
        this.qEF = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(this.userName);
        this.qEF.setUsername(this.userName);
        boolean tF = this.qEF.tF();
        boolean GU = GU(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("sns_outside_permiss");
        checkBoxPreference.vqm = tF;
        int i = this.qEF.gkr;
        w.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            checkBoxPreference.setTitle(j.pLW);
        } else if (i == 2) {
            checkBoxPreference.setTitle(j.pLV);
        }
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("sns_black_permiss");
        if (i == 1) {
            checkBoxPreference.setTitle(j.pKx);
        } else if (i == 2) {
            checkBoxPreference.setTitle(j.pKw);
        }
        checkBoxPreference.vqm = GU;
        if (!com.tencent.mm.j.a.ez(this.qEF.field_type)) {
            this.isJ.Te("sns_black_permiss");
        }
        this.isJ.notifyDataSetChanged();
    }

    private static boolean GU(String str) {
        s dI = ae.beQ().dI(5);
        if (bg.mA(dI.field_memberList)) {
            return false;
        }
        return bg.f(dI.field_memberList.split(",")).contains(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        if (kVar.getType() == 291) {
            w.d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.irJ == null));
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            bap();
            if (this.qEG) {
                this.qEH = true;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        b pdVar;
        if (str.equals("sns_outside_permiss")) {
            pdVar = new pd();
            pdVar.fWa.fWc = true;
            pdVar.fWa.fWb = false;
            pdVar.fWa.username = this.userName;
            com.tencent.mm.sdk.b.a.urY.m(pdVar);
            if (this.qEF.tF()) {
                o.k(this.qEF);
            } else {
                o.j(this.qEF);
            }
            return true;
        } else if (!str.equals("sns_black_permiss")) {
            return false;
        } else {
            int i;
            pdVar = new pd();
            pdVar.fWa.fWc = false;
            pdVar.fWa.fWb = true;
            pdVar.fWa.username = this.userName;
            com.tencent.mm.sdk.b.a.urY.m(pdVar);
            boolean GU = GU(this.userName);
            String str2 = this.userName;
            if (GU) {
                i = 2;
            } else {
                i = 1;
            }
            if (i == 1 && 5 == 5) {
                this.qEG = true;
                this.qEH = false;
            } else {
                this.qEG = false;
                this.qEH = false;
            }
            List linkedList = new LinkedList();
            linkedList.add(str2);
            final k vVar = new v(i, 5, "", linkedList.size(), linkedList, this.scene);
            h.vJ();
            h.vH().gXC.a(vVar, 0);
            getString(j.dIO);
            this.irJ = g.a(this, getString(j.pMB), true, new OnCancelListener(this) {
                final /* synthetic */ SnsPermissionUI qEJ;

                public final void onCancel(DialogInterface dialogInterface) {
                    this.qEJ.onStop();
                    h.vJ();
                    h.vH().gXC.c(vVar);
                }
            });
            return true;
        }
    }
}
