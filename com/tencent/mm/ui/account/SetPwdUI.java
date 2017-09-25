package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public abstract class SetPwdUI extends MMActivity implements e {
    public String fGV = null;
    private ProgressDialog isv = null;
    public boolean ppy = true;
    private String vbJ;
    private String vbK;
    public avw vbL = null;

    protected enum a {
        ;

        public static int[] bRj() {
            return (int[]) vbS.clone();
        }

        static {
            vbO = 1;
            vbP = 2;
            vbQ = 3;
            vbR = 4;
            vbS = new int[]{vbO, vbP, vbQ, vbR};
        }
    }

    protected abstract String bQT();

    protected abstract String bQU();

    protected abstract boolean s(int i, int i2, String str);

    protected abstract void zB(int i);

    public void onCreate(Bundle bundle) {
        ap.vd().a(bQV(), (e) this);
        super.onCreate(bundle);
        this.fGV = getIntent().getStringExtra("setpwd_ticket");
        byte[] PT = bg.PT(aq.ze().getString("_auth_key", ""));
        dv dvVar = new dv();
        if (bg.bm(PT)) {
            this.vbL = new avw().bb(new byte[0]);
        } else {
            this.vbL = new avw().bb(PT);
            try {
                dvVar.aD(PT);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SetPwdUI", e, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        }
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ SetPwdUI vbM;

            {
                this.vbM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vbM.vbJ = this.vbM.bQT();
                this.vbM.vbK = this.vbM.bQU();
                if (!bg.mA(this.vbM.vbJ)) {
                    if (!this.vbM.vbJ.equals(this.vbM.vbK)) {
                        this.vbM.zB(a.vbO);
                    } else if (this.vbM.vbJ.length() > 16) {
                        this.vbM.zB(a.vbP);
                    } else if (bg.PH(this.vbM.vbJ)) {
                        g.h(this.vbM, R.l.eJB, R.l.eJP);
                    } else if (bg.PM(this.vbM.vbJ)) {
                        this.vbM.aHf();
                        if (bg.mA(this.vbM.fGV)) {
                            SetPwdUI setPwdUI = this.vbM;
                            ap.yY();
                            setPwdUI.fGV = (String) c.vr().get(77830, null);
                        }
                        final k a = this.vbM.a(this.vbM.vbJ, this.vbM.fGV, this.vbM.vbL);
                        ap.vd().a(a, 0);
                        this.vbM.isv = this.vbM.a(this.vbM, this.vbM.getString(R.l.dIO), this.vbM.getString(R.l.eIZ), new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 vbN;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(a);
                            }
                        });
                        if (this.vbM.bQY() && !this.vbM.ppy) {
                            w.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                            com.tencent.mm.plugin.report.service.g.oUh.i(11868, Integer.valueOf(0));
                        }
                    } else if (this.vbM.vbJ.length() < 8 || this.vbM.vbJ.length() >= 16) {
                        this.vbM.zB(a.vbQ);
                    } else {
                        this.vbM.zB(a.vbR);
                    }
                }
                return true;
            }
        }, b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SetPwdUI vbM;

            {
                this.vbM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.vbM.bQY() && this.vbM.ppy) {
                    w.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                    com.tencent.mm.plugin.report.service.g.oUh.i(11868, Integer.valueOf(1));
                }
                this.vbM.aHf();
                this.vbM.setResult(0);
                this.vbM.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        ap.vd().b(bQV(), (e) this);
        super.onDestroy();
    }

    protected ProgressDialog a(Context context, String str, String str2, OnCancelListener onCancelListener) {
        return g.a(context, str2, true, onCancelListener);
    }

    protected int bQV() {
        return 383;
    }

    protected k a(String str, String str2, avw com_tencent_mm_protocal_c_avw) {
        return new af(str, str2, com_tencent_mm_protocal_c_avw);
    }

    public final void a(int i, int i2, String str, k kVar) {
        azf com_tencent_mm_protocal_c_azf = null;
        if (kVar.getType() == bQV()) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (kVar.getType() == 383 && i == 0 && i2 == 0) {
                Toast.makeText(this, getString(R.l.elY), 0).show();
                af afVar = (af) kVar;
                if (!(afVar.gUA == null || afVar.gUA.hsk.hsr == null)) {
                    com_tencent_mm_protocal_c_azf = (azf) afVar.gUA.hsk.hsr;
                }
                if (!(com_tencent_mm_protocal_c_azf == null || com_tencent_mm_protocal_c_azf.thf == null)) {
                    byte[] toByteArray = com_tencent_mm_protocal_c_azf.thf.tZp.toByteArray();
                    Editor edit = ab.getContext().getSharedPreferences("auth_info_key_prefs", 4).edit();
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", d.sYN);
                    edit.putString("_auth_key", bg.bo(toByteArray));
                    ap.yY();
                    edit.putInt("_auth_uin", c.uH());
                    edit.commit();
                }
                setResult(-1);
            }
            if (!s(i, i2, str)) {
                Toast.makeText(this, getString(R.l.elX, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    protected final boolean p(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.imw.a(this.uSU.uTo, i, i2, str)) {
            return true;
        }
        return false;
    }

    public boolean bQY() {
        return false;
    }

    public void onBackPressed() {
        if (this.ppy) {
            if (bQY()) {
                w.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                com.tencent.mm.plugin.report.service.g.oUh.i(11868, Integer.valueOf(1));
            }
            super.onBackPressed();
        }
    }
}
