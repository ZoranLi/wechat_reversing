package com.tencent.mm.ui.account.bind;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Map.Entry;

public class BindMobileStatusUI extends MMWizardActivity {
    private SharedPreferences hgx;
    private Button jMI;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> jWK = new HashMap();
    private int status;
    private ImageView vcj;
    private TextView vck;
    private TextView vcl;
    private ImageView vcm;
    private ImageView vcn;
    private Boolean vco = Boolean.valueOf(true);
    private Boolean vcp = Boolean.valueOf(true);
    private RelativeLayout vcq;
    private RelativeLayout vcr;
    private BindWordingContent vcs;
    private int vct;
    private boolean vcu;
    private boolean vcv;
    private SparseArray<String> vcw = new SparseArray(3);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = m.xP();
        this.vcw.put(8, "settings_find_me_by_mobile");
        this.vcw.put(7, "settings_recommend_mobilefriends_to_me");
        this.vcw.put(32, "settings_autoadd_mobilefriends");
        e(false, 512, 8);
        e(false, 256, 7);
        zi(R.l.dNQ);
        this.vcs = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.vct = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.vcu = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.vcv = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.cVw;
    }

    protected void onPause() {
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.jWK.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            a suVar = new su();
            suVar.tAG = intValue;
            suVar.tAH = intValue2;
            ap.yY();
            c.wQ().b(new e.a(23, suVar));
            w.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.jWK.clear();
        super.onPause();
    }

    private boolean e(boolean z, int i, int i2) {
        w.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.jWK.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        String str = (String) this.vcw.get(i2);
        if (!(this.hgx == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i2 == 8 || i2 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.hgx.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        return true;
    }

    protected final void KC() {
        boolean z = true;
        this.vcj = (ImageView) findViewById(R.h.btc);
        this.vcl = (TextView) findViewById(R.h.bta);
        this.vck = (TextView) findViewById(R.h.bsZ);
        this.jMI = (Button) findViewById(R.h.btb);
        this.vcm = (ImageView) findViewById(R.h.btz);
        this.vcn = (ImageView) findViewById(R.h.bty);
        this.vcq = (RelativeLayout) findViewById(R.h.bsW);
        this.vcr = (RelativeLayout) findViewById(R.h.bsX);
        switch (this.vct) {
            case 0:
                boolean z2;
                this.vcq.setVisibility(8);
                this.vcr.setVisibility(8);
                if (this.vcu) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                e(z2, 512, 8);
                if (this.vcv) {
                    z = false;
                }
                e(z, 256, 7);
                break;
            case 1:
                this.vcq.setVisibility(0);
                this.vcq.setBackgroundResource(R.g.bcA);
                this.vcr.setVisibility(8);
                break;
        }
        if (this.vcs != null) {
            switch (this.vcs.hRA.intValue()) {
                case 2:
                    this.vck.setVisibility(8);
                    break;
            }
        }
        this.jMI.setVisibility(8);
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMobileStatusUI vcx;

            {
                this.vcx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vcx.zu(1);
                return false;
            }
        });
        if (com.tencent.mm.modelfriend.m.Fl() == com.tencent.mm.modelfriend.m.a.hBs || com.tencent.mm.modelfriend.m.Fl() == com.tencent.mm.modelfriend.m.a.hBt) {
            this.vcj.setImageResource(R.g.bcy);
            ap.yY();
            String str = (String) c.vr().get(6, null);
            if (str == null || str.equals("")) {
                ap.yY();
                c.vr().get(4097, null);
            }
        } else {
            this.vcj.setImageResource(R.g.bcv);
            this.vck.setVisibility(8);
            this.vcl.setText(getString(R.l.dNl));
        }
        this.vcm.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileStatusUI vcx;

            {
                this.vcx = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                this.vcx.vco = Boolean.valueOf(!this.vcx.vco.booleanValue());
                if (this.vcx.vco.booleanValue()) {
                    this.vcx.vcm.setImageResource(R.k.dvN);
                } else {
                    this.vcx.vcm.setImageResource(R.k.dvO);
                }
                BindMobileStatusUI bindMobileStatusUI = this.vcx;
                if (this.vcx.vco.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.e(z, 512, 8);
            }
        });
        this.vcn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileStatusUI vcx;

            {
                this.vcx = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                this.vcx.vcp = Boolean.valueOf(!this.vcx.vcp.booleanValue());
                if (this.vcx.vcp.booleanValue()) {
                    this.vcx.vcn.setImageResource(R.k.dvN);
                } else {
                    this.vcx.vcn.setImageResource(R.k.dvO);
                }
                BindMobileStatusUI bindMobileStatusUI = this.vcx;
                if (this.vcx.vcp.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.e(z, 256, 7);
                if (!this.vcx.vcp.booleanValue()) {
                    this.vcx.e(false, 2097152, 32);
                }
            }
        });
        this.jMI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileStatusUI vcx;

            {
                this.vcx = r1;
            }

            public final void onClick(View view) {
                this.vcx.zu(1);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        zu(1);
        return true;
    }

    public static void c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int xP = m.xP();
        xP = z ? xP | 512 : xP & -513;
        xP = z2 ? xP | 256 : xP & -257;
        ap.yY();
        c.vr().set(7, Integer.valueOf(xP));
        a suVar = new su();
        suVar.tAG = 8;
        if (z2) {
            xP = 1;
        } else {
            xP = 2;
        }
        suVar.tAH = xP;
        ap.yY();
        c.wQ().b(new e.a(23, suVar));
        a suVar2 = new su();
        suVar2.tAG = 7;
        if (!z) {
            i = 2;
        }
        suVar.tAH = i;
        ap.yY();
        c.wQ().b(new e.a(23, suVar2));
        com.tencent.mm.plugin.c.a.imw.ou();
    }
}
