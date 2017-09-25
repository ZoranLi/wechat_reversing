package com.tencent.mm.ui.account.bind;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.wcdb.FileUtils;

public class BindMobileUI extends MMWizardActivity {
    private String countryCode = null;
    private String fOI;
    private String hJF = null;
    private TextView iUO;
    private LinearLayout uZF;
    private TextView uZG;
    private String uZJ = null;
    private i vcA;
    private Button vcB;
    private TextView vcC;
    private TextView vcD;
    private CheckBox vcE;
    private CheckBox vcF;
    private LinearLayout vcG;
    private ImageView vcH;
    private boolean vcI;
    private BindWordingContent vcs;
    private int vct;
    private EditText vcy;
    private TextView vcz;

    static /* synthetic */ void a(BindMobileUI bindMobileUI, final String str) {
        if (bindMobileUI.vcA == null) {
            bindMobileUI.vcA = new i(b.whX, bindMobileUI, new a(bindMobileUI) {
                final /* synthetic */ BindMobileUI vcK;

                public final void zC(int i) {
                    boolean z = true;
                    if (i == 1) {
                        if (this.vcK.vcI) {
                            Context context = this.vcK;
                            boolean z2 = !this.vcK.vcE.isChecked();
                            if (this.vcK.vcF.isChecked()) {
                                z = false;
                            }
                            BindMobileStatusUI.c(context, z2, z);
                            this.vcK.exit(-1);
                            return;
                        }
                        Intent intent = new Intent(this.vcK, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", this.vcK.vcs);
                        intent.putExtra("kstyle_bind_recommend_show", this.vcK.vct);
                        intent.putExtra("Kfind_friend_by_mobile_flag", this.vcK.vcE.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", this.vcK.vcF.isChecked());
                        MMWizardActivity.z(this.vcK, intent);
                    } else if (i == 2) {
                        BindMobileUI.d(this.vcK, str);
                    }
                }
            });
            bindMobileUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMobileUI.vcA);
        }
        bindMobileUI.vcA.Uf(str);
        if (bindMobileUI.vcI) {
            bindMobileUI.vcA.whT = false;
        }
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, final String str) {
        String string = bindMobileUI.uSU.uTo.getString(R.l.dOj);
        g.a(bindMobileUI.uSU.uTo, String.format("%s\n%s", new Object[]{bindMobileUI.uSU.uTo.getString(R.l.dOk), str}), string, new OnClickListener(bindMobileUI) {
            final /* synthetic */ BindMobileUI vcK;

            public final void onClick(DialogInterface dialogInterface, int i) {
                BindMobileUI.a(this.vcK, str);
            }
        }, null);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.vcs);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.vct);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.vcE.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.vcF.isChecked());
        intent.putExtra("is_bind_for_chatroom_upgrade", bindMobileUI.vcI);
        z(bindMobileUI, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dNN);
        this.hJF = bg.ap(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bg.ap(getIntent().getStringExtra("couttry_code"), "");
        this.uZJ = bg.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.vcs = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.vct = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.vcI = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
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
        zu(1);
        return true;
    }

    protected final void KC() {
        this.vcy = (EditText) findViewById(R.h.bti);
        this.uZF = (LinearLayout) findViewById(R.h.bGQ);
        this.uZG = (TextView) findViewById(R.h.bGS);
        this.vcz = (TextView) findViewById(R.h.bGO);
        this.iUO = (TextView) findViewById(R.h.btm);
        this.vcB = (Button) findViewById(R.h.bsU);
        this.vcC = (TextView) findViewById(R.h.btj);
        this.iUO.setText(getString(R.l.dNM));
        this.vcD = (TextView) findViewById(R.h.bsV);
        this.vcG = (LinearLayout) findViewById(R.h.btl);
        this.vcF = (CheckBox) findViewById(R.h.bte);
        this.vcE = (CheckBox) findViewById(R.h.btd);
        this.vcH = (ImageView) findViewById(R.h.bth);
        if (this.vcs != null) {
            if (this.vcs.title != null && this.vcs.title.length() > 0) {
                this.iUO.setText(this.vcs.title);
            }
            if (this.vcs.content != null && this.vcs.content.length() > 0) {
                this.vcD.setText(this.vcs.content);
            }
            switch (this.vcs.hRA.intValue()) {
                case 0:
                    this.vcH.setImageResource(R.g.bcw);
                    break;
                case 1:
                    this.vcH.setImageResource(R.g.bcz);
                    break;
                case 2:
                    this.vcH.setImageResource(R.g.bcx);
                    break;
            }
        }
        switch (this.vct) {
            case 0:
                this.vcG.setVisibility(0);
                this.vcF.setVisibility(0);
                this.vcD.setVisibility(8);
                break;
            case 1:
                this.vcG.setVisibility(8);
                this.vcF.setVisibility(8);
                this.vcD.setVisibility(0);
                break;
        }
        if (bg.mA(this.hJF) && bg.mA(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            w.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bg.mA(simCountryIso)) {
                w.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.ai.b.a g = com.tencent.mm.ai.b.g(this, simCountryIso, getString(R.l.bGO));
                if (g == null) {
                    w.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                } else {
                    this.hJF = g.hJF;
                    this.countryCode = g.hJE;
                }
            }
        }
        if (!(this.hJF == null || this.hJF.equals(""))) {
            this.uZG.setText(this.hJF);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.vcz.setText("+" + this.countryCode);
        }
        if (!(this.uZJ == null || this.uZJ.equals(""))) {
            this.vcy.setText(this.uZJ);
        }
        this.vcB.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI vcK;

            {
                this.vcK = r1;
            }

            public final void onClick(View view) {
                if (this.vcK.vcy.getText().toString() == null || this.vcK.vcy.getText().toString().length() == 0) {
                    Toast.makeText(this.vcK, this.vcK.getString(R.l.dNx), 0).show();
                    return;
                }
                this.vcK.fOI = this.vcK.vcz.getText().toString().trim() + bg.zc(this.vcK.vcy.getText().toString());
                BindMobileUI.c(this.vcK, this.vcK.fOI);
            }
        });
        this.vcC.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI vcK;

            {
                this.vcK = r1;
            }

            public final void onClick(View view) {
                this.vcK.zu(1);
            }
        });
        if (this.vcI) {
            zi(R.l.dNm);
            this.vcH.setVisibility(8);
            this.iUO.setText(R.l.dNF);
            this.vcG.setVisibility(8);
            this.vcF.setVisibility(8);
            this.vcF.setChecked(false);
            this.vcE.setVisibility(0);
            this.vcE.setChecked(false);
            this.vcD.setVisibility(8);
            this.vcD.setText(getString(R.l.dNn));
            this.vcC.setVisibility(8);
            this.vcB.setText(R.l.dNm);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BindMobileUI vcK;

                {
                    this.vcK = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.vcK.zu(1);
                    return true;
                }
            });
        }
        this.uZF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI vcK;

            {
                this.vcK = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.vcK.hJF);
                intent.putExtra("couttry_code", this.vcK.countryCode);
                com.tencent.mm.plugin.c.a.imv.b(intent, this.vcK);
            }
        });
        this.uZF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindMobileUI vcK;

            {
                this.vcK = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.vcK.hJF);
                intent.putExtra("couttry_code", this.vcK.countryCode);
                com.tencent.mm.plugin.c.a.imv.b(intent, this.vcK);
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
        return R.i.cVv;
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
        w.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
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
