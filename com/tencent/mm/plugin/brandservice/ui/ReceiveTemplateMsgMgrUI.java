package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI extends MMPreference implements e {
    private static LinkedList<aki> kbm;
    private ProgressDialog isv;
    protected f jid;
    private String kbl;
    private boolean kbn = false;

    protected final int getLayoutId() {
        return R.i.dmd;
    }

    public final int ON() {
        return R.o.ftV;
    }

    public final int aeq() {
        return R.i.dmc;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(1031, this);
        ap.vd().a(1030, this);
        KC();
    }

    protected void onPause() {
        if (this.kbn) {
            w.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.kbn = false;
            ap.vd().a(new l(this.kbl, kbm), 0);
        }
        super.onPause();
    }

    protected void onDestroy() {
        ap.vd().b(1031, this);
        ap.vd().b(1030, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.dZl);
        this.jid = this.vrv;
        this.kbl = getIntent().getStringExtra("enterprise_biz_name");
        if (bg.mA(this.kbl)) {
            w.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            return;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReceiveTemplateMsgMgrUI kbo;

            {
                this.kbo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kbo.finish();
                return true;
            }
        });
        final k eVar = new com.tencent.mm.plugin.brandservice.a.e(this.kbl);
        ap.vd().a(eVar, 0);
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.eIz), true, new OnCancelListener(this) {
            final /* synthetic */ ReceiveTemplateMsgMgrUI kbo;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(eVar);
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        if (kbm == null) {
            w.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
        } else {
            String str = preference.igL;
            if (bg.mA(str)) {
                w.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
            } else {
                Iterator it = kbm.iterator();
                while (it.hasNext()) {
                    aki com_tencent_mm_protocal_c_aki = (aki) it.next();
                    if (str.equals(bg.mz(com_tencent_mm_protocal_c_aki.tOb))) {
                        this.kbn = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            com_tencent_mm_protocal_c_aki.teT = 0;
                        } else {
                            com_tencent_mm_protocal_c_aki.teT = 1;
                        }
                        if (this.kbn) {
                            w.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                            af.f(new Runnable(this) {
                                final /* synthetic */ ReceiveTemplateMsgMgrUI kbo;

                                {
                                    this.kbo = r1;
                                }

                                public final void run() {
                                    if (this.kbo.kbn) {
                                        this.kbo.kbn = false;
                                        ap.vd().a(new l(this.kbo.kbl, ReceiveTemplateMsgMgrUI.kbm), 0);
                                    }
                                }
                            }, 4000);
                        }
                    }
                }
                if (this.kbn) {
                    w.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                    af.f(/* anonymous class already generated */, 4000);
                }
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        akk com_tencent_mm_protocal_c_akk = null;
        if (kVar == null) {
            w.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        w.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
        if (kVar.getType() == 1031) {
            if (this.isv != null && this.isv.isShowing()) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) kVar;
                if (!(eVar.gUA == null || eVar.gUA.hsk.hsr == null)) {
                    com_tencent_mm_protocal_c_akk = (akk) eVar.gUA.hsk.hsr;
                }
                kbm = com_tencent_mm_protocal_c_akk.tOc;
                LinkedList linkedList = kbm;
                this.jid.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    w.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    cd(true);
                    return;
                }
                cd(false);
                w.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[]{Integer.valueOf(linkedList.size())});
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    aki com_tencent_mm_protocal_c_aki = (aki) it.next();
                    Preference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.vrZ = false;
                    checkBoxPreference.setKey(com_tencent_mm_protocal_c_aki.tOb);
                    checkBoxPreference.setTitle(com_tencent_mm_protocal_c_aki.fDC);
                    checkBoxPreference.vqm = com_tencent_mm_protocal_c_aki.teT == 0;
                    this.jid.a(checkBoxPreference);
                }
                this.jid.notifyDataSetChanged();
                w.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                return;
            }
            Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eIx), 1).show();
            cd(true);
        } else if (kVar.getType() != 1030) {
        } else {
            if (i != 0 || i2 != 0) {
                Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eIy), 0).show();
            }
        }
    }

    private void cd(boolean z) {
        View findViewById = findViewById(R.h.cwe);
        View findViewById2 = findViewById(R.h.cwf);
        if (findViewById == null) {
            return;
        }
        if (z) {
            ((TextView) findViewById).setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
                return;
            }
            return;
        }
        ((TextView) findViewById).setVisibility(8);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
    }
}
