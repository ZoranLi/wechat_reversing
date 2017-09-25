package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics oKK;
    private boolean qsF = false;
    private long qsG = 0;
    private y qsH = null;
    private String qsI = "";
    private String qsJ = "";
    private ArrayList<String> qsK;
    private int qsL = 0;
    private int qsM = 0;
    private boolean qsN = false;
    private SnsEditText qsw;
    private LinearLayout qsx;
    private SnsSightUploadSayFooter qxu;
    private int qxv = 0;

    public void onCreate(Bundle bundle) {
        e.f(this);
        super.onCreate(bundle);
        this.oKK = getResources().getDisplayMetrics();
        this.qsH = new ak(this);
        this.qsH.C(bundle);
        this.qsx = (LinearLayout) findViewById(f.pGw);
        this.qsx.addView(this.qsH.bir());
        zi(j.pMJ);
        cO().cP().setBackgroundDrawable(getResources().getDrawable(c.black));
        this.qsF = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.qsG = getIntent().getLongExtra("KTouchCameraTime", 0);
        KC();
        e.g(this);
    }

    protected final int getLayoutId() {
        return g.pIb;
    }

    protected final void KC() {
        this.qsw = (SnsEditText) findViewById(f.pEL);
        this.qsw.setTextSize(1, (v.dI(this.uSU.uTo) * this.qsw.getTextSize()) / a.getDensity(this.uSU.uTo));
        final int paddingLeft = this.oKK.widthPixels - (this.qsw.getPaddingLeft() + this.qsx.getPaddingRight());
        this.qsw.postDelayed(new Runnable(this) {
            final /* synthetic */ SightUploadUI qxx;

            public final void run() {
                this.qxx.qsw.setWidth((int) (((double) paddingLeft) * 0.7d));
                this.qxx.qsx.setLayoutParams(new LayoutParams((int) (((double) paddingLeft) * 0.3d), this.qxx.qsx.getHeight()));
            }
        }, 100);
        if (!bg.mA(getIntent().getStringExtra("Kdescription"))) {
            this.qsw.setText(getIntent().getStringExtra("Kdescription"));
        }
        this.qsw.wvo = new MMEditText.a(this) {
            final /* synthetic */ SightUploadUI qxx;

            {
                this.qxx = r1;
            }

            public final void aIv() {
                this.qxx.aHf();
                b okVar = new ok();
                okVar.fVy.type = 0;
                okVar.fVy.fVA = false;
                com.tencent.mm.sdk.b.a.urY.m(okVar);
                this.qxx.finish();
            }
        };
        this.qxu = (SnsSightUploadSayFooter) findViewById(f.czE);
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.qxu;
        MMEditText mMEditText = this.qsw;
        snsSightUploadSayFooter.qGv = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener(snsSightUploadSayFooter) {
            final /* synthetic */ SnsSightUploadSayFooter qGy;

            {
                this.qGy = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (this.qGy.getVisibility() == 8) {
                    this.qGy.setVisibility(0);
                }
                if (this.qGy.nuR.getVisibility() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    this.qGy.YD();
                }
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener(snsSightUploadSayFooter) {
            final /* synthetic */ SnsSightUploadSayFooter qGy;

            {
                this.qGy = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        af.f(new Runnable(snsSightUploadSayFooter) {
            final /* synthetic */ SnsSightUploadSayFooter qGy;

            {
                this.qGy = r1;
            }

            public final void run() {
                this.qGy.qGv.performClick();
                this.qGy.qGv.requestFocus();
                this.qGy.fCi.aHj();
            }
        }, 200);
        this.qxu.setVisibility(0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SightUploadUI qxx;

            {
                this.qxx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                b okVar = new ok();
                okVar.fVy.type = 0;
                okVar.fVy.fVA = false;
                com.tencent.mm.sdk.b.a.urY.m(okVar);
                this.qxx.aHf();
                this.qxx.finish();
                return true;
            }
        });
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            a(1, i.pJd, new OnMenuItemClickListener(this) {
                final /* synthetic */ SightUploadUI qxx;

                {
                    this.qxx = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.base.g.a(this.qxx.uSU.uTo, null, new String[]{this.qxx.getString(j.pKb)}, null, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass4 qxy;

                        {
                            this.qxy = r1;
                        }

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    b okVar = new ok();
                                    okVar.fVy.type = 0;
                                    okVar.fVy.fVD = true;
                                    okVar.fVy.fVA = true;
                                    com.tencent.mm.sdk.b.a.urY.m(okVar);
                                    this.qxy.qxx.aHf();
                                    this.qxy.qxx.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return false;
                }
            });
        }
        a(0, getString(j.dIA), new OnMenuItemClickListener(this) {
            final /* synthetic */ SightUploadUI qxx;

            {
                this.qxx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.qxx.isFinishing()) {
                    this.qxx.desc = this.qxx.qsw.getText().toString();
                    final int i = this.qxx.qsw.qBu;
                    com.tencent.mm.ui.tools.a.c Ch = com.tencent.mm.ui.tools.a.c.d(this.qxx.qsw).Ch(com.tencent.mm.i.b.sx());
                    Ch.wpp = true;
                    Ch.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                        final /* synthetic */ AnonymousClass5 qxA;

                        public final void ro(String str) {
                            PInt pInt = new PInt();
                            this.qxA.qxx.qsH.a(this.qxA.qxx.qxv, 0, null, this.qxA.qxx.desc, null, this.qxA.qxx.qxu.qGx.bjd(), i, this.qxA.qxx.qsN, this.qxA.qxx.qsK, pInt, "", this.qxA.qxx.qsL, this.qxA.qxx.qsM);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr = new Object[4];
                            objArr[0] = Long.valueOf(this.qxA.qxx.qsG);
                            objArr[1] = Long.valueOf(bg.Ny());
                            objArr[2] = Integer.valueOf(this.qxA.qxx.qsF ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            gVar.i(13303, objArr);
                            String str2 = "MicroMsg.SightUploadUI";
                            String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                            objArr = new Object[4];
                            objArr[0] = Long.valueOf(this.qxA.qxx.qsG);
                            objArr[1] = Long.valueOf(bg.Ny());
                            objArr[2] = Integer.valueOf(this.qxA.qxx.qsF ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            w.d(str2, str3, objArr);
                        }

                        public final void YN() {
                        }

                        public final void Yp() {
                            com.tencent.mm.ui.base.g.h(this.qxA.qxx, j.pMV, j.pMW);
                        }
                    });
                }
                return false;
            }
        }, l.b.uUa);
        kr(true);
    }

    public void onResume() {
        super.onResume();
        w.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.qxu;
        if (snsSightUploadSayFooter.nuR.getVisibility() == 8) {
            snsSightUploadSayFooter.fCi.aHj();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.qsH.bis();
        this.qxu.qGx.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.qxu;
        if (snsSightUploadSayFooter.nuR != null) {
            snsSightUploadSayFooter.nuR.anN();
            snsSightUploadSayFooter.nuR.destroy();
        }
    }

    protected void onPause() {
        super.onPause();
        aHf();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6 || i == 5 || i == 10) {
                SnsSightUploadSayFooter snsSightUploadSayFooter = this.qxu;
                if (intent != null) {
                    if (i == 10) {
                        snsSightUploadSayFooter.qGx.P(intent);
                    } else if (i == 5) {
                        snsSightUploadSayFooter.qGw.a(i, i2, intent, null);
                    }
                }
            }
            if (i == 5 && intent != null) {
                int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                if (intExtra >= 2) {
                    this.qsI = intent.getStringExtra("Klabel_name_list");
                    this.qsJ = intent.getStringExtra("Kother_user_name_list");
                    List<String> asList = Arrays.asList(this.qsI.split(","));
                    List list;
                    if (bg.mA(this.qsJ)) {
                        list = null;
                    } else {
                        list = Arrays.asList(this.qsJ.split(","));
                    }
                    this.qsK = new ArrayList();
                    if (asList != null && asList.size() > 0) {
                        for (String ze : asList) {
                            List<String> zh = com.tencent.mm.plugin.label.a.a.aFG().zh(com.tencent.mm.plugin.label.a.a.aFG().ze(ze));
                            if (zh == null || zh.size() == 0) {
                                w.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                                break;
                            }
                            for (String ze2 : zh) {
                                if (!this.qsK.contains(ze2)) {
                                    this.qsK.add(ze2);
                                    w.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[]{ze2});
                                }
                            }
                        }
                    }
                    if (asList != null) {
                        int i3 = 0;
                        for (String ze22 : asList) {
                            int i4;
                            if (bg.mA(ze22)) {
                                i4 = i3;
                            } else {
                                i4 = i3 + 1;
                            }
                            i3 = i4;
                        }
                        this.qsL = i3;
                    }
                    this.qsM = 0;
                    if (r1 != null && r1.size() > 0) {
                        for (String ze222 : r1) {
                            if (!this.qsK.contains(ze222)) {
                                this.qsK.add(ze222);
                                this.qsM++;
                            }
                        }
                    }
                    if (intExtra == 2) {
                        this.qsN = false;
                    } else {
                        this.qsN = true;
                    }
                }
                if (1 == intExtra) {
                    this.qxv = 1;
                } else {
                    this.qxv = 0;
                }
            }
        }
    }
}
