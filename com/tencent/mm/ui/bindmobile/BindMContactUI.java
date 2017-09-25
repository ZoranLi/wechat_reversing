package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.wcdb.FileUtils;

public class BindMContactUI extends MMWizardActivity {
    private String countryCode = null;
    private String fOI;
    private int fromScene = 0;
    private String hJF = null;
    private boolean jFm = false;
    private LinearLayout uZF;
    private TextView uZG;
    private String uZJ = null;
    private i vcA;
    private CheckBox vcE;
    private boolean vcP = false;
    private boolean vcR = false;
    private EditText vcy;
    private TextView vcz;
    private boolean vtG = false;
    private TextView vtQ;
    private LinearLayout vtR;
    private boolean vtS = false;

    static /* synthetic */ void b(BindMContactUI bindMContactUI, final String str) {
        if (bindMContactUI.vcA == null) {
            int i = b.whX;
            if (bindMContactUI.vtS) {
                i = b.whY;
            }
            bindMContactUI.vcA = new i(i, bindMContactUI, new a(bindMContactUI) {
                final /* synthetic */ BindMContactUI vtT;

                public final void zC(int i) {
                    Intent intent;
                    if (i == 1) {
                        if (this.vtT.vcP) {
                            w.i("MicroMsg.BindMContactUI", "to startMySafedeviceListUI");
                            if (!m.xT()) {
                                com.tencent.mm.sdk.b.b rcVar = new rc();
                                rcVar.fYc.fYd = true;
                                rcVar.fYc.fYe = true;
                                com.tencent.mm.sdk.b.a.urY.m(rcVar);
                            }
                            this.vtT.zu(1);
                            intent = new Intent();
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.c.a.imv.d(this.vtT, intent);
                        } else if (this.vtT.vtS) {
                            w.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for change mobile");
                            g.bl(this.vtT, this.vtT.getString(R.l.eNB));
                            MMWizardActivity.z(this.vtT, new Intent(this.vtT, BindMContactStatusUI.class));
                        } else if (this.vtT.fromScene == 5) {
                            w.i("MicroMsg.BindMContactUI", "to finish  finishWizard for get phone number");
                            this.vtT.zu(-1);
                        } else {
                            if (this.vtT.jFm) {
                                if (this.vtT.vtG) {
                                    com.tencent.mm.plugin.report.service.g.oUh.i(11002, Integer.valueOf(3), Integer.valueOf(3));
                                } else {
                                    com.tencent.mm.plugin.report.service.g.oUh.i(11002, Integer.valueOf(1), Integer.valueOf(2));
                                }
                            }
                            w.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for contact sync or other");
                            MMWizardActivity.z(this.vtT, new Intent(this.vtT, BindMContactStatusUI.class));
                        }
                    } else if (i == 2) {
                        w.i("MicroMsg.BindMContactUI", "reg next to BindMContactVerifyUI for bind mobile");
                        intent = new Intent(this.vtT, BindMContactVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("is_bind_for_safe_device", this.vtT.vcP);
                        intent.putExtra("is_bind_for_contact_sync", this.vtT.vtG);
                        intent.putExtra("is_bind_for_change_mobile", this.vtT.vtS);
                        intent.putExtra("KEnterFromBanner", this.vtT.jFm);
                        if (this.vtT.vcE != null) {
                            intent.putExtra("BIND_FIND_ME_BY_MOBILE", this.vtT.vcE.isChecked());
                        }
                        intent.putExtra("BIND_FOR_QQ_REG", this.vtT.vcR);
                        intent.putExtra("bind_scene", this.vtT.fromScene);
                        MMWizardActivity.z(this.vtT, intent);
                    }
                }
            });
            bindMContactUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactUI.vcA);
        }
        i iVar = bindMContactUI.vcA;
        boolean z = (bindMContactUI.vcP || bindMContactUI.vtG) ? false : true;
        iVar.whT = z;
        bindMContactUI.vcA.Uf(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dNP);
        this.hJF = bg.ap(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bg.ap(getIntent().getStringExtra("couttry_code"), "");
        this.uZJ = bg.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.vcA != null) {
            getContentResolver().unregisterContentObserver(this.vcA);
            this.vcA.recycle();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bTh();
        return true;
    }

    private void bTh() {
        if (this.vcP || this.vtG) {
            uVi.clear();
            zu(1);
            return;
        }
        g.a((Context) this, this.vtS ? R.l.dNC : R.l.dNB, this.vtS ? R.l.dNE : R.l.dND, new OnClickListener(this) {
            final /* synthetic */ BindMContactUI vtT;

            {
                this.vtT = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.vtT.zu(1);
            }
        }, null);
    }

    protected final void KC() {
        this.vcP = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.vtG = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.vcR = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.vtS = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.jFm = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        w.i("MicroMsg.BindMContactUI", "bindScene:%d", Integer.valueOf(this.fromScene));
        this.vcy = (EditText) findViewById(R.h.bti);
        this.uZF = (LinearLayout) findViewById(R.h.bGQ);
        this.uZG = (TextView) findViewById(R.h.bGS);
        this.vcz = (TextView) findViewById(R.h.bGO);
        this.vcE = (CheckBox) findViewById(R.h.btf);
        this.vtR = (LinearLayout) findViewById(R.h.btg);
        this.vtQ = (TextView) findViewById(R.h.cCT);
        if (this.vtS) {
            ap.yY();
            String str = (String) c.vr().get(6, null);
            if (!bg.mA(str)) {
                String yU;
                if (str.startsWith("+")) {
                    yU = an.yU(str);
                    String str2 = yU;
                    yU = str.substring(yU.length() + 1);
                    str = str2;
                } else {
                    yU = str;
                    str = "86";
                }
                an anVar = new an();
                str = an.formatNumber(str, yU);
                this.vtQ.setText(getString(R.l.dNq, new Object[]{str}));
            }
        }
        if (!(this.hJF == null || this.hJF.equals(""))) {
            this.uZG.setText(this.hJF);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.vcz.setText("+" + this.countryCode);
        }
        if (this.uZJ == null || this.uZJ.equals("")) {
            ap.vL().a(new af.a(this) {
                String kvq;
                final /* synthetic */ BindMContactUI vtT;

                {
                    this.vtT = r1;
                }

                public final boolean Bo() {
                    if (bg.mA((this.vtT.vcy.getText()).trim())) {
                        if (bg.mA(this.kvq)) {
                            this.vtT.vcy.setText("");
                        } else {
                            this.vtT.vcy.setText(this.kvq);
                            this.vtT.vcy.setSelection(this.kvq.length());
                        }
                    }
                    return true;
                }

                public final boolean Bn() {
                    this.kvq = com.tencent.mm.modelsimple.c.y(this.vtT, this.vtT.countryCode);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView";
                }
            });
        } else {
            this.vcy.setText(this.uZJ);
            this.vcy.setSelection(this.uZJ.length());
        }
        if (com.tencent.mm.ai.b.Hp()) {
            this.vtR.setVisibility(4);
            this.vcE.setChecked(true);
        }
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMContactUI vtT;

            {
                this.vtT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vtT.fOI = this.vtT.vcz.getText().toString().trim() + bg.zc(this.vtT.vcy.getText().toString());
                if (!com.tencent.mm.pluginsdk.a.LA(this.vtT.fOI) || bg.zc(this.vtT.vcy.getText().toString()).length() <= 0) {
                    g.h(this.vtT, R.l.dNL, R.l.dIO);
                } else {
                    w.i("MicroMsg.BindMContactUI", "do next, send sms to self");
                    BindMContactUI.b(this.vtT, this.vtT.fOI);
                }
                return true;
            }
        });
        this.vcy.requestFocus();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMContactUI vtT;

            {
                this.vtT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vtT.bTh();
                return true;
            }
        });
        this.uZF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMContactUI vtT;

            {
                this.vtT = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.vtT.hJF);
                intent.putExtra("couttry_code", this.vtT.countryCode);
                com.tencent.mm.plugin.c.a.imv.b(intent, this.vtT);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.hJF = bg.ap(intent.getStringExtra("country_name"), "");
                this.countryCode = bg.ap(intent.getStringExtra("couttry_code"), "");
                if (!this.hJF.equals("")) {
                    this.uZG.setText(this.hJF);
                }
                if (!this.countryCode.equals("")) {
                    this.vcz.setText("+" + this.countryCode);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.cVB;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.vcA != null) {
                    this.vcA.bRm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
