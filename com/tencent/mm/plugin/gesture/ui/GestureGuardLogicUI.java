package com.tencent.mm.plugin.gesture.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gesture.a.b;
import com.tencent.mm.plugin.gesture.a.c;
import com.tencent.mm.plugin.gesture.a.d;
import com.tencent.mm.plugin.gesture.a.e;
import com.tencent.mm.plugin.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, com.tencent.mm.plugin.gesture.ui.widget.PatternLockView.a {
    private String hEr = null;
    private ae mHandler = new ae(Looper.getMainLooper());
    private int mIb = 0;
    private int mIc = 0;
    private a[] mId = null;
    private Animation mIe = null;
    private List<c> mIf = null;
    private List<c> mIg = null;
    private boolean mIh = false;
    private int mIi = 0;
    private k mIj = null;
    private k mIk = null;
    private String mIl = null;
    private ViewFlipper mIm = null;
    private Dialog mIn = null;
    private boolean mIo = true;
    private boolean mIp = false;
    private int mStatus;
    private int mjs = 0;

    private interface a {
        void onDone();
    }

    static /* synthetic */ void aCQ() {
        ag.a(m.xL(), 9, "PatternLockUpdate", "");
        g.oUh.i(11473, new Object[0]);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.mIi + 1;
        gestureGuardLogicUI.mIi = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!ab.getPackageName().equals(intent.getPackage()) || bg.mA(intent.getAction()) || bg.mA(intent.getStringExtra("next_action"))) {
            w.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            return;
        }
        this.mIm = new ViewFlipper(this);
        this.mId = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.mId;
        int length = aVarArr.length;
        while (i < length) {
            a aVar = aVarArr[i];
            this.mIm.addView(aVar.mView);
            aVar.mIy.mJa = this;
            aVar.mIz.setOnClickListener(this);
            i++;
        }
        setContentView(this.mIm);
        this.hEr = getIntent().getStringExtra("token");
        this.mIl = getIntent().getStringExtra(Columns.TYPE);
        KC();
    }

    protected void onResume() {
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            d.aCF();
            e aCz = b.aCz();
            if (aCz.mHZ != -1) {
                d.a(aCz);
                if (aCz.mIa / 1000 < 600) {
                    b.k(aCz.mHZ, aCz.mIa);
                    i = 1;
                    if (i != 0) {
                        this.mIi = b.aCD();
                        if (this.mIi != -1) {
                            return;
                        }
                    }
                    this.mIi = 0;
                }
                b.aCA();
            }
            i = 0;
            if (i != 0) {
                this.mIi = b.aCD();
                if (this.mIi != -1) {
                    return;
                }
            }
            this.mIi = 0;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mIj != null) {
            ap.vd().c(this.mIj);
            this.mIj = null;
        }
        if (this.mIk != null) {
            ap.vd().c(this.mIk);
            this.mIk = null;
        }
        if (this.mIn != null && this.mIn.isShowing()) {
            this.mIn.dismiss();
        }
        this.mIm.removeAllViews();
        this.mIm = null;
        for (int i = 0; i < this.mId.length; i++) {
            a aVar = this.mId[i];
            aVar.mIy.setOnClickListener(null);
            aVar.mIz.setOnClickListener(null);
            aVar.mView = null;
            aVar.mIw = null;
            aVar.mIx = null;
            aVar.mIy = null;
            aVar.mIz = null;
            this.mId[i] = null;
        }
        this.mId = null;
    }

    protected final void KC() {
        aHf();
        zj(R.l.fmW);
        this.mIe = AnimationUtils.loadAnimation(this, R.a.aRF);
        this.mIb = getResources().getColor(R.e.aUa);
        this.mIc = getResources().getColor(R.e.aUb);
        Intent intent = getIntent();
        String action = intent.getAction();
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(action)) {
            this.mStatus = 16;
            J(1, false);
        } else if ("action.verify_pattern".equals(action)) {
            d.aCF();
            if (d.aCH()) {
                this.mIh = true;
                this.mStatus = 20;
            } else {
                this.mIh = false;
                this.mStatus = 0;
            }
            J(0, false);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GestureGuardLogicUI mIq;

            {
                this.mIq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.mIq.aCL()) {
                    this.mIq.finish();
                }
                return true;
            }
        });
        w.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        aCM();
    }

    protected final int getLayoutId() {
        return R.i.dfL;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (intent == null) {
            w.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
            return;
        }
        int intExtra = intent.getIntExtra("key_result", 0);
        if (intExtra == 0) {
            this.hEr = intent.getStringExtra("key_token");
            this.mIl = intent.getStringExtra("key_type");
            String stringExtra = getIntent().getStringExtra("next_action");
            if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                if ("next_action.modify_pattern".equals(stringExtra)) {
                    this.mIp = true;
                }
                this.mIo = false;
                b(null);
                kt(false);
                this.mStatus = 16;
                J(1, false);
            } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                String str = this.hEr;
                final com.tencent.mm.y.u.a anonymousClass12 = new com.tencent.mm.y.u.a(this) {
                    final /* synthetic */ GestureGuardLogicUI mIq;

                    {
                        this.mIq = r1;
                    }

                    public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                        if (i2 == 0) {
                            b.aCE();
                            b.aCw();
                            b.aCA();
                            Toast.makeText(this.mIq, this.mIq.getString(R.l.eqv), 0).show();
                        } else {
                            Toast.makeText(this.mIq, this.mIq.getString(R.l.eqg), 0).show();
                        }
                        this.mIq.hEr = null;
                        this.mIq.mIl = null;
                        this.mIq.finish();
                        return 0;
                    }
                };
                a(new OnCancelListener(this) {
                    final /* synthetic */ GestureGuardLogicUI mIq;

                    {
                        this.mIq = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.mIq.mId[this.mIq.mjs].mIy.aCT();
                        if (this.mIq.mIj != null && !this.mIq.mIj.hsG) {
                            ap.vd().c(this.mIq.mIj);
                        }
                    }
                });
                if (str == null) {
                    aCP();
                    anonymousClass12.a(3, -6, getString(R.l.eqi), null, null);
                } else {
                    com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                    aVar.hsm = new auo();
                    aVar.hsn = new aup();
                    aVar.hsl = 688;
                    aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                    com.tencent.mm.y.b BE = aVar.BE();
                    auo com_tencent_mm_protocal_c_auo = (auo) BE.hsj.hsr;
                    com_tencent_mm_protocal_c_auo.tYi = new avw().bb(str.getBytes());
                    com_tencent_mm_protocal_c_auo.ou = 3;
                    u.a(BE, new com.tencent.mm.y.u.a(this) {
                        final /* synthetic */ GestureGuardLogicUI mIq;

                        public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                            w.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                            this.mIq.aCP();
                            if (i == 0 && i2 == 0) {
                                b.a(((aup) bVar.hsk.hsr).tTB);
                                GestureGuardLogicUI.aCQ();
                            }
                            d.aCF().aCK();
                            if (anonymousClass12 != null) {
                                return anonymousClass12.a(i, i2, str, bVar, kVar);
                            }
                            return 0;
                        }
                    }, false);
                }
            } else {
                this.mStatus = 1;
            }
            aCM();
        } else if (intExtra == -1) {
            Toast.makeText(this, getString(R.l.eqg), 0).show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.h.cKc) {
            com.tencent.mm.bb.d.b(this, "wallet", ".pwd.ui.WalletGestureCheckPwdUI", MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && aCL()) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean aCL() {
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            aCO();
            return false;
        }
        if (this.mIo) {
            String stringExtra = getIntent().getStringExtra("next_action");
            stringExtra = ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) ? getString(R.l.eqd) : getString(R.l.eqe);
            new com.tencent.mm.ui.base.h.a(this).kK(false).SX(stringExtra).zZ(R.l.eqb).a(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI mIq;

                {
                    this.mIq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.mIq.aCO();
                    this.mIq.finish();
                }
            }).Aa(R.l.epZ).b(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI mIq;

                {
                    this.mIq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).WJ().show();
        } else {
            new com.tencent.mm.ui.base.h.a(this).kK(true).zX(R.l.eqf).zZ(R.l.eqa).a(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI mIq;

                {
                    this.mIq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).WJ().show();
        }
        return true;
    }

    private void aCM() {
        while (true) {
            final a aVar = this.mId[this.mjs];
            String stringExtra;
            List list;
            com.tencent.mm.y.b.a aVar2;
            aok com_tencent_mm_protocal_c_aok;
            long elapsedRealtime;
            switch (this.mStatus) {
                case 0:
                    qP(getString(R.l.eqs));
                    this.mIh = false;
                    aVar.mIy.mIO = true;
                    aVar.mIy.mJa = this;
                    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.mIw.setText(getString(R.l.eqr));
                    } else {
                        aVar.mIw.setText(getString(R.l.eqq));
                    }
                    aVar.mIw.setTextColor(this.mIb);
                    if (aVar.mIz.getVisibility() != 0) {
                        aVar.mIz.setVisibility(0);
                        return;
                    }
                    return;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.mIy.aCT();
                        J(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        list = this.mIg;
                        final com.tencent.mm.y.u.a anonymousClass26 = new com.tencent.mm.y.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqv), 0).show();
                                } else {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqg), 0).show();
                                }
                                this.mIq.mIg = null;
                                this.mIq.finish();
                                return 0;
                            }
                        };
                        a(new OnCancelListener(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.mIq.mId[this.mIq.mjs].mIy.aCT();
                                if (this.mIq.mIk != null && !this.mIq.mIk.hsG) {
                                    ap.vd().c(this.mIq.mIk);
                                }
                            }
                        });
                        aVar2 = new com.tencent.mm.y.b.a();
                        aVar2.hsm = new aok();
                        aVar2.hsn = new aol();
                        aVar2.hsl = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.y.b BE = aVar2.BE();
                        com_tencent_mm_protocal_c_aok = (aok) BE.hsj.hsr;
                        com_tencent_mm_protocal_c_aok.ou = 3;
                        avw com_tencent_mm_protocal_c_avw = new avw();
                        d.aCF();
                        com_tencent_mm_protocal_c_aok.tTz = com_tencent_mm_protocal_c_avw.bb(d.aG(list));
                        u.a(BE, new com.tencent.mm.y.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                w.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                this.mIq.aCP();
                                if (i == 0 && i2 == 0) {
                                    b.a(((aol) bVar.hsk.hsr).tTB);
                                    this.mIq.mIh = false;
                                    GestureGuardLogicUI.aCQ();
                                }
                                if (anonymousClass26 != null) {
                                    return anonymousClass26.a(i, i2, str, bVar, kVar);
                                }
                                return 0;
                            }
                        }, false);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        b.co(SystemClock.elapsedRealtime());
                        aCN();
                        return;
                    } else {
                        return;
                    }
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    b.k(elapsedRealtime, 0);
                    b.nR(this.mIi);
                    b.aCy();
                    if (this.mIi == 5) {
                        this.mIh = true;
                        b.j(elapsedRealtime, 0);
                        aVar.mIy.aCT();
                        aVar.mIy.mIO = false;
                        this.mStatus = 20;
                        aCM();
                        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(this);
                        aVar3.kK(false).SX(String.format(getString(R.l.eqc), new Object[]{Long.valueOf(10)}));
                        aVar3.zZ(R.l.epY).a(new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.mIq.onClick(this.mIq.mId[this.mIq.mjs].mIz);
                            }
                        });
                        aVar3.Aa(R.l.epX).b(new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.mIq.aCO();
                                this.mIq.finish();
                            }
                        });
                        aVar3.WJ().show();
                        return;
                    }
                    aVar.mIy.mIO = false;
                    aVar.mIy.a(PatternLockView.b.Wrong);
                    a(String.format(getResources().getString(R.l.eqj, new Object[]{Integer.valueOf(5 - this.mIi)}), new Object[0]), new a(this) {
                        final /* synthetic */ GestureGuardLogicUI mIq;

                        public final void onDone() {
                            this.mIq.mStatus = 0;
                            aVar.mIy.aCT();
                            aVar.mIy.mIO = true;
                        }
                    });
                    return;
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
                        qP(getString(R.l.eqt));
                    } else {
                        qP(getString(R.l.equ));
                    }
                    this.mIh = false;
                    aVar.mIy.mIO = true;
                    aVar.mIy.mJa = this;
                    aVar.mIw.setText(getString(R.l.eqp));
                    aVar.mIw.setTextColor(getResources().getColor(R.e.aUa));
                    if (aVar.mIz.getVisibility() != 8) {
                        aVar.mIz.setVisibility(8);
                        return;
                    }
                    return;
                case 17:
                    aVar.mIw.setText(getResources().getString(R.l.eqn));
                    aVar.mIw.setTextColor(this.mIb);
                    aVar.mIy.aCT();
                    aVar.mIy.mIO = true;
                    if (aVar.mIz.getVisibility() != 8) {
                        aVar.mIz.setVisibility(8);
                        return;
                    }
                    return;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.mIp) {
                            this.mIp = false;
                            a(this.hEr, this.mIf, new com.tencent.mm.y.u.a(this) {
                                final /* synthetic */ GestureGuardLogicUI mIq;

                                {
                                    this.mIq = r1;
                                }

                                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                    if (i2 == 0) {
                                        Toast.makeText(this.mIq, this.mIq.getString(R.l.eqx), 0).show();
                                        g.oUh.i(11474, new Object[0]);
                                    } else {
                                        Toast.makeText(this.mIq, this.mIq.getString(R.l.eqg), 0).show();
                                    }
                                    this.mIq.hEr = null;
                                    this.mIq.mIf = null;
                                    this.mIq.finish();
                                    return 0;
                                }
                            });
                            return;
                        }
                        list = this.mIg;
                        List list2 = this.mIf;
                        final com.tencent.mm.y.u.a anonymousClass22 = new com.tencent.mm.y.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqx), 0).show();
                                } else {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqg), 0).show();
                                }
                                this.mIq.mIg = null;
                                this.mIq.mIf = null;
                                this.mIq.finish();
                                return 0;
                            }
                        };
                        aVar2 = new com.tencent.mm.y.b.a();
                        a(new OnCancelListener(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.mIq.mId[this.mIq.mjs].mIy.aCT();
                                if (this.mIq.mIk != null && !this.mIq.mIk.hsG) {
                                    ap.vd().c(this.mIq.mIk);
                                }
                            }
                        });
                        aVar2.hsm = new aok();
                        aVar2.hsn = new aol();
                        aVar2.hsl = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.y.b BE2 = aVar2.BE();
                        com_tencent_mm_protocal_c_aok = (aok) BE2.hsj.hsr;
                        com_tencent_mm_protocal_c_aok.ou = 1;
                        avw com_tencent_mm_protocal_c_avw2 = new avw();
                        d.aCF();
                        com_tencent_mm_protocal_c_aok.tTz = com_tencent_mm_protocal_c_avw2.bb(d.aG(list));
                        avw com_tencent_mm_protocal_c_avw3 = new avw();
                        d.aCF();
                        com_tencent_mm_protocal_c_aok.tTA = com_tencent_mm_protocal_c_avw3.bb(d.aG(list2));
                        u.a(BE2, new com.tencent.mm.y.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                w.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                this.mIq.aCP();
                                if (i == 0 && i2 == 0) {
                                    b.a(((aol) bVar.hsk.hsr).tTB);
                                    GestureGuardLogicUI.aCQ();
                                }
                                d.aCF().aCK();
                                if (anonymousClass22 != null) {
                                    return anonymousClass22.a(i, i2, str, bVar, kVar);
                                }
                                return 0;
                            }
                        }, false);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        a(this.hEr, this.mIf, new com.tencent.mm.y.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqw), 0).show();
                                } else {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqg), 0).show();
                                }
                                this.mIq.hEr = null;
                                this.mIq.mIf = null;
                                this.mIq.finish();
                                return 0;
                            }
                        });
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        a(this.hEr, this.mIf, new com.tencent.mm.y.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI mIq;

                            {
                                this.mIq = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                                if (i2 == 0) {
                                    b.co(SystemClock.elapsedRealtime());
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqx), 0).show();
                                    this.mIq.aCN();
                                } else {
                                    Toast.makeText(this.mIq, this.mIq.getString(R.l.eqg), 0).show();
                                }
                                this.mIq.hEr = null;
                                this.mIq.mIf = null;
                                return 0;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                case 19:
                    aVar.mIy.mIO = false;
                    aVar.mIy.a(PatternLockView.b.Wrong);
                    a(getResources().getString(R.l.eqo), new a(this) {
                        final /* synthetic */ GestureGuardLogicUI mIq;

                        public final void onDone() {
                            this.mIq.mHandler.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass25 mIv;

                                {
                                    this.mIv = r1;
                                }

                                public final void run() {
                                    this.mIv.mIq.mHandler.removeCallbacks(this);
                                    aVar.mIy.aCT();
                                    this.mIv.mIq.mStatus = 16;
                                    this.mIv.mIq.J(1, true);
                                    this.mIv.mIq.aCM();
                                }
                            }, 500);
                        }
                    });
                    return;
                case 20:
                    qP(getString(R.l.eqs));
                    this.mIh = true;
                    aVar.mIy.mIO = false;
                    aVar.mIy.mJa = null;
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (b.aCv().mIa / 1000))) / 60.0d);
                    aVar.mIw.setText(String.format(getString(R.l.eqm), new Object[]{Long.valueOf(elapsedRealtime)}));
                    aVar.mIw.setTextColor(getResources().getColor(R.e.aUb));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(final PatternLockView patternLockView, final List<c> list) {
        boolean z = true;
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.mIO = false;
                patternLockView.a(PatternLockView.b.Wrong);
                a(String.format(getString(R.l.eqk), new Object[]{Integer.valueOf(4)}), new a(this) {
                    final /* synthetic */ GestureGuardLogicUI mIq;

                    public final void onDone() {
                        patternLockView.aCT();
                        patternLockView.mIO = true;
                    }
                });
                return;
            }
            this.mIf = list;
            patternLockView.aCT();
            this.mStatus = 17;
            J(2, true);
        } else if (this.mStatus == 0) {
            final com.tencent.mm.y.u.a anonymousClass3 = new com.tencent.mm.y.u.a(this) {
                final /* synthetic */ GestureGuardLogicUI mIq;

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    if (i2 == 0) {
                        this.mIq.mIh = false;
                        this.mIq.mIi = 0;
                        b.aCE();
                        b.aCw();
                        b.aCA();
                        this.mIq.mIg = list;
                        this.mIq.mStatus = 1;
                        this.mIq.aCM();
                    } else if (i2 == -3) {
                        GestureGuardLogicUI.k(this.mIq);
                        this.mIq.mStatus = 2;
                        this.mIq.aCM();
                    } else {
                        Toast.makeText(this.mIq, this.mIq.getString(R.l.eqh), 0).show();
                    }
                    return 0;
                }
            };
            apd aCC = b.aCC();
            apc aCB = b.aCB();
            g.oUh.i(11453, new Object[0]);
            a(new OnCancelListener(this) {
                final /* synthetic */ GestureGuardLogicUI mIq;

                {
                    this.mIq = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.mIq.mId[this.mIq.mjs].mIy.aCT();
                    if (this.mIq.mIk != null && !this.mIq.mIk.hsG) {
                        ap.vd().c(this.mIq.mIk);
                    }
                }
            });
            d.aCF();
            boolean b = d.b(aCC);
            d.aCF();
            boolean z2 = d.b(aCB) ? b ? aCB.version < aCC.tUf : false : true;
            w.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(b), Boolean.valueOf(d.b(aCB)), Boolean.valueOf(z2)}));
            if (z2) {
                com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                aVar.hsm = new aok();
                aVar.hsn = new aol();
                aVar.hsl = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                com.tencent.mm.y.b BE = aVar.BE();
                aok com_tencent_mm_protocal_c_aok = (aok) BE.hsj.hsr;
                com_tencent_mm_protocal_c_aok.ou = 2;
                avw com_tencent_mm_protocal_c_avw = new avw();
                d.aCF();
                com_tencent_mm_protocal_c_aok.tTz = com_tencent_mm_protocal_c_avw.bb(d.aG(list));
                u.a(BE, new com.tencent.mm.y.u.a(this) {
                    final /* synthetic */ GestureGuardLogicUI mIq;

                    public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                        w.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                        this.mIq.aCP();
                        if (i == 0 && i2 == 0) {
                            b.a(((aol) bVar.hsk.hsr).tTB);
                        }
                        if (anonymousClass3 != null) {
                            return anonymousClass3.a(i, i2, str, bVar, kVar);
                        }
                        return 0;
                    }
                }, false);
                return;
            }
            aCP();
            d.aCF();
            apc aCB2 = b.aCB();
            if (aCB2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                stringBuilder.append(new o(com.tencent.mm.u.c.uH()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(d.aG(list)));
                z = new String(aCB2.tUc.tZp.sYA).equals(com.tencent.mm.a.g.n(stringBuilder.toString().getBytes()));
            }
            if (z) {
                anonymousClass3.a(3, 0, null, null, null);
                return;
            } else {
                anonymousClass3.a(3, -3, null, null, null);
                return;
            }
        } else if (this.mStatus != 17) {
            return;
        } else {
            if (this.mIf.equals(list)) {
                patternLockView.aCT();
                this.mIh = false;
                this.mIi = 0;
                b.aCE();
                b.aCw();
                b.aCA();
                b.aCy();
                this.mStatus = 18;
            } else {
                this.mStatus = 19;
            }
        }
        aCM();
    }

    private void a(String str, List<c> list, final com.tencent.mm.y.u.a aVar) {
        a(new OnCancelListener(this) {
            final /* synthetic */ GestureGuardLogicUI mIq;

            {
                this.mIq = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.mIq.mId[this.mIq.mjs].mIy.aCT();
                if (this.mIq.mIj != null && !this.mIq.mIj.hsG) {
                    ap.vd().c(this.mIq.mIj);
                }
            }
        });
        if (str == null) {
            aCP();
            aVar.a(3, -6, getString(R.l.eqi), null, null);
            return;
        }
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new auo();
        aVar2.hsn = new aup();
        aVar2.hsl = 688;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        com.tencent.mm.y.b BE = aVar2.BE();
        auo com_tencent_mm_protocal_c_auo = (auo) BE.hsj.hsr;
        com_tencent_mm_protocal_c_auo.tYi = new avw().bb(str.getBytes());
        avw com_tencent_mm_protocal_c_avw = new avw();
        d.aCF();
        com_tencent_mm_protocal_c_auo.tYj = com_tencent_mm_protocal_c_avw.bb(d.aG(list));
        u.a(BE, new com.tencent.mm.y.u.a(this) {
            final /* synthetic */ GestureGuardLogicUI mIq;

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                w.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                this.mIq.aCP();
                if (i == 0 && i2 == 0) {
                    b.a(((aup) bVar.hsk.hsr).tTB);
                    GestureGuardLogicUI.aCQ();
                }
                d.aCF().aCK();
                if (aVar != null) {
                    return aVar.a(i, i2, str, bVar, kVar);
                }
                return 0;
            }
        }, false);
    }

    private void aCN() {
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            d.aCF().eK(true);
            d.aCF().eL(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
        } else {
            w.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
    }

    private void aCO() {
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            Iterator it = d.aCF().mHS.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) ((WeakReference) it.next()).get();
                if (!(activity == null || activity.isFinishing())) {
                    activity.finish();
                }
                it.remove();
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.mId[this.mjs];
        if (motionEvent.getAction() != 2 && motionEvent.getAction() != 7) {
            return super.dispatchTouchEvent(motionEvent);
        }
        motionEvent.offsetLocation((float) (-aVar.mIx.getLeft()), (float) ((-aVar.mIx.getTop()) - getWindow().findViewById(16908290).getTop()));
        return aVar.mIx.dispatchTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        a aVar = this.mId[this.mjs];
        if (aVar.mIy != null) {
            PatternLockView patternLockView = aVar.mIy;
            boolean z2 = z && !this.mIh;
            patternLockView.mIO = z2;
        }
    }

    public final void a(PatternLockView patternLockView) {
        patternLockView.a(PatternLockView.b.Correct);
    }

    private void J(int i, boolean z) {
        int i2 = i - this.mjs;
        if (i2 != 0) {
            this.mjs = i;
            if (!z) {
                this.mIm.setInAnimation(null);
                this.mIm.setOutAnimation(null);
            } else if (i2 > 0) {
                this.mIm.setInAnimation(this, R.a.aRN);
                this.mIm.setOutAnimation(this, R.a.aRM);
            } else {
                this.mIm.setInAnimation(this, R.a.aRL);
                this.mIm.setOutAnimation(this, R.a.aRO);
            }
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.mIm.showNext();
                }
                return;
            }
            while (i2 < 0) {
                this.mIm.showPrevious();
                i2++;
            }
        }
    }

    private void a(String str, final a aVar) {
        TextView textView = this.mId[this.mjs].mIw;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.mIc);
        textView.startAnimation(this.mIe);
        this.mIe.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ GestureGuardLogicUI mIq;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.mIq.mIe.setAnimationListener(null);
                if (aVar != null) {
                    aVar.onDone();
                }
            }
        });
    }

    private void a(OnCancelListener onCancelListener) {
        if (this.mIn == null) {
            this.mIn = com.tencent.mm.ui.base.g.a(this, getString(R.l.eql), false, onCancelListener);
        } else {
            this.mIn.show();
        }
    }

    private void aCP() {
        if (this.mIn != null && this.mIn.isShowing()) {
            this.mIn.dismiss();
        }
    }

    protected final int Ol() {
        return 1;
    }
}
