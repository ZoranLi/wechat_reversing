package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ai.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(17)
public class En_c4f742e5 extends MMActivity implements LocationWidget.a {
    private String desc;
    private SnsAdClick fTG = null;
    private SnsUploadConfigView qpS;
    private RangeWidget qsA;
    private SnsUploadSayFooter qsB;
    private KeyboardLinearLayout qsC;
    private boolean qsD = false;
    private int qsE = 0;
    private boolean qsF = false;
    private long qsG = 0;
    private y qsH = null;
    private String qsI = "";
    private String qsJ = "";
    private ArrayList<String> qsK;
    private int qsL = 0;
    private int qsM = 0;
    private boolean qsN = false;
    private boolean qsO = false;
    private boolean qsP = false;
    private String qsQ = null;
    private FrameLayout qsR = null;
    private long qsS = 0;
    private SnsEditText qsw;
    private LinearLayout qsx;
    private AtContactWidget qsy;
    private LocationWidget qsz;

    static /* synthetic */ boolean b(En_c4f742e5 en_c4f742e5) {
        en_c4f742e5.aHf();
        if (!en_c4f742e5.qsB.bli()) {
            return false;
        }
        en_c4f742e5.qsB.blj();
        return true;
    }

    static /* synthetic */ void i(En_c4f742e5 en_c4f742e5) {
        en_c4f742e5.qsw.requestFocus();
        w.d("MicroMsg.SnsUploadUI", "request fouces");
        if (en_c4f742e5.qsB.bli()) {
            en_c4f742e5.qsB.blj();
        }
        en_c4f742e5.uSU.ipu.postInvalidate();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.qsw != null) {
            bundle.putString("contentdesc", this.qsw.getText().toString());
        }
        bundle.getString("contentdesc");
        this.qsH.D(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        e.f(this);
        super.onCreate(bundle);
        if (bDZ()) {
            View a;
            qP("");
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
            this.qsF = getIntent().getBooleanExtra("KSnsPostManu", false);
            this.qsG = getIntent().getLongExtra("KTouchCameraTime", 0);
            this.qsE = getIntent().getIntExtra("Ksnsupload_type", 0);
            this.fTG = (SnsAdClick) getIntent().getParcelableExtra("KsnsAdTag");
            this.qsD = getIntent().getBooleanExtra("Kis_take_photo", false);
            this.qsO = getIntent().getBooleanExtra("need_result", false);
            this.qsP = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
            this.qsQ = getIntent().getStringExtra("Ksnsupload_canvas_info");
            this.qsw = (SnsEditText) findViewById(f.pEL);
            this.qsw.setTextSize(1, (v.dI(this.uSU.uTo) * this.qsw.getTextSize()) / com.tencent.mm.bg.a.getDensity(this.uSU.uTo));
            if (!bg.mA(getIntent().getStringExtra("Kdescription"))) {
                this.qsw.setText(getIntent().getStringExtra("Kdescription"));
            } else if (!(this.qsw == null || bundle == null)) {
                CharSequence string = bundle.getString("contentdesc");
                if (string != null) {
                    this.qsw.setText(string);
                }
            }
            if (this.qsE == 8) {
                this.qsw.setText(getIntent().getStringExtra("Kdescription"));
                this.qsw.setEnabled(false);
            }
            this.qsC = (KeyboardLinearLayout) findViewById(f.czn);
            this.qsB = (SnsUploadSayFooter) findViewById(f.czE);
            SnsUploadSayFooter snsUploadSayFooter = this.qsB;
            MMEditText mMEditText = this.qsw;
            snsUploadSayFooter.qGv = mMEditText;
            mMEditText.setOnClickListener(new OnClickListener(snsUploadSayFooter) {
                final /* synthetic */ SnsUploadSayFooter qKi;

                {
                    this.qKi = r1;
                }

                public final void onClick(View view) {
                    if (this.qKi.getVisibility() == 8) {
                        this.qKi.setVisibility(0);
                    }
                    if (this.qKi.bli()) {
                        this.qKi.YD();
                    }
                }
            });
            mMEditText.setOnEditorActionListener(new OnEditorActionListener(snsUploadSayFooter) {
                final /* synthetic */ SnsUploadSayFooter qKi;

                {
                    this.qKi = r1;
                }

                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return false;
                }
            });
            this.qsB.setVisibility(8);
            this.qsR = (FrameLayout) findViewById(f.pDE);
            this.qsR.post(new Runnable(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final void run() {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    this.qsT.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    ae.beA();
                    r.cY(displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
            });
            this.qsw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final void onClick(View view) {
                    En_c4f742e5.i(this.qsT);
                }
            });
            this.qsw.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final boolean onLongClick(View view) {
                    En_c4f742e5.i(this.qsT);
                    return false;
                }
            });
            WrapScollview wrapScollview = (WrapScollview) findViewById(f.pDL);
            wrapScollview.ipu = this.qsw;
            wrapScollview.qLM = false;
            this.qpS = (SnsUploadConfigView) findViewById(f.pCc);
            com.tencent.mm.ui.j.a.a aVar = this.qpS;
            aVar.qKd.tna = -1000.0f;
            aVar.qKd.tmZ = -1000.0f;
            if (!aVar.qFL) {
                h.vJ();
                int f = bg.f((Integer) h.vI().vr().get(68404, null));
                aVar.qJY = (f & 2) != 0;
                aVar.qJZ = (f & 8) != 0;
                if (!b.Hp()) {
                    aVar.qJZ = false;
                }
                if (!m.yk()) {
                    aVar.qJY = false;
                }
            }
            aVar.hM(false);
            aVar.ble();
            aVar.blf();
            if (aVar.qJZ) {
                aVar.qKe.a(aVar);
            }
            if (this.qsE != 0) {
                SnsUploadConfigView snsUploadConfigView = this.qpS;
                snsUploadConfigView.qJU.setVisibility(8);
                snsUploadConfigView.qJV.setVisibility(8);
                snsUploadConfigView.qJW.setVisibility(8);
            }
            if (this.qsE == 9) {
                this.qpS.qJW.setVisibility(0);
            }
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.qsT.qsE == 9) {
                        this.qsT.setResult(0, new Intent());
                        this.qsT.finish();
                    } else {
                        g.a(this.qsT, j.pMT, 0, j.dDl, j.dGs, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass14 qsX;

                            {
                                this.qsX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (this.qsX.qsT.fTG != null) {
                                    this.qsX.qsT.fTG.gy(10);
                                }
                                this.qsX.qsT.setResult(0, new Intent());
                                this.qsX.qsT.finish();
                            }
                        }, null, c.aSJ);
                    }
                    return true;
                }
            });
            a(0, getString(j.dIA), new OnMenuItemClickListener(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (!this.qsT.isFinishing() && System.currentTimeMillis() - this.qsT.qsS >= 500) {
                        this.qsT.qsS = System.currentTimeMillis();
                        com.tencent.mm.plugin.report.service.f.rY(22);
                        com.tencent.mm.ui.tools.a.c Ch = com.tencent.mm.ui.tools.a.c.d(this.qsT.qsw).Ch(com.tencent.mm.i.b.sx());
                        Ch.wpp = true;
                        Ch.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                            final /* synthetic */ AnonymousClass2 qsU;

                            {
                                this.qsU = r1;
                            }

                            public final void ro(String str) {
                                int blh = this.qsU.qsT.qpS.blh();
                                h.vJ();
                                h.vI().vr().set(68404, Integer.valueOf(blh));
                                this.qsU.qsT.desc = this.qsU.qsT.qsw.getText().toString();
                                int i = this.qsU.qsT.qsw.qBu;
                                int blg = this.qsU.qsT.qpS.blg();
                                int blh2 = this.qsU.qsT.qpS.blh();
                                if (this.qsU.qsT.qsO) {
                                    this.qsU.qsT.setResult(-1, new Intent());
                                }
                                if (this.qsU.qsT.qsH instanceof ag) {
                                    ag agVar = (ag) this.qsU.qsT.qsH;
                                    LocationWidget n = this.qsU.qsT.qsz;
                                    ajq com_tencent_mm_protocal_c_ajq = new ajq();
                                    com_tencent_mm_protocal_c_ajq.tna = n.quN;
                                    com_tencent_mm_protocal_c_ajq.tmZ = n.nXM;
                                    com_tencent_mm_protocal_c_ajq.aLh = n.aLh;
                                    com_tencent_mm_protocal_c_ajq.quO = n.quO;
                                    agVar.qwp = com_tencent_mm_protocal_c_ajq;
                                }
                                if (this.qsU.qsT.qsH instanceof ad) {
                                    this.qsU.qsT.qsw.setText("");
                                }
                                PInt pInt = new PInt();
                                this.qsU.qsT.qsH.a(blg, blh2, this.qsU.qsT.qpS.qKe.wrt, this.qsU.qsT.desc, this.qsU.qsT.qsy.bif(), this.qsU.qsT.qsz.bjd(), i, this.qsU.qsT.qsN, this.qsU.qsT.qsK, pInt, this.qsU.qsT.qsQ, this.qsU.qsT.qsL, this.qsU.qsT.qsM);
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                Object[] objArr = new Object[4];
                                objArr[0] = Long.valueOf(this.qsU.qsT.qsG);
                                objArr[1] = Long.valueOf(bg.Ny());
                                objArr[2] = Integer.valueOf(this.qsU.qsT.qsF ? 0 : 1);
                                objArr[3] = Integer.valueOf(pInt.value);
                                gVar.i(13303, objArr);
                                String str2 = "MicroMsg.SnsUploadUI";
                                String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                                objArr = new Object[4];
                                objArr[0] = Long.valueOf(this.qsU.qsT.qsG);
                                objArr[1] = Long.valueOf(bg.Ny());
                                objArr[2] = Integer.valueOf(this.qsU.qsT.qsF ? 0 : 1);
                                objArr[3] = Integer.valueOf(pInt.value);
                                w.d(str2, str3, objArr);
                                com.tencent.mm.plugin.report.service.g.oUh.A(10910, "1");
                                if (!bg.mA(this.qsU.qsT.qsI)) {
                                    if (this.qsU.qsT.qsN) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(11455, new Object[]{"", this.qsU.qsT.qsI, Integer.valueOf(-1), Integer.valueOf(-1)});
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(11455, new Object[]{this.qsU.qsT.qsI, "", Integer.valueOf(-1), Integer.valueOf(-1)});
                                    }
                                }
                                if (this.qsU.qsT.fTG != null) {
                                    this.qsU.qsT.fTG.gy(9);
                                }
                                if (this.qsU.qsT.qsP) {
                                    Intent intent = new Intent(this.qsU.qsT, En_424b8e16.class);
                                    intent.putExtra("sns_resume_state", false);
                                    intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                                    intent.addFlags(67108864);
                                    this.qsU.qsT.startActivity(intent);
                                }
                                com.tencent.mm.sdk.b.a.urY.m(new pn());
                            }

                            public final void YN() {
                            }

                            public final void Yp() {
                                g.h(this.qsU.qsT, j.pMV, j.pMW);
                            }
                        });
                    }
                    return false;
                }
            }, l.b.uTY);
            findViewById(f.pGo).setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    w.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
                    if (En_c4f742e5.b(this.qsT)) {
                        return true;
                    }
                    return false;
                }
            });
            this.qsy = (AtContactWidget) findViewById(f.pBP);
            this.qsy.qpS = this.qpS;
            this.qsz = (LocationWidget) findViewById(f.pDi);
            this.qsz.quP = this;
            switch (this.qsE) {
                case 0:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                    this.qsA = (RangeWidget) findViewById(f.pDw);
                    findViewById(f.pDx).setVisibility(8);
                    break;
                case 1:
                case 11:
                    this.qsA = (RangeWidget) findViewById(f.pDw);
                    findViewById(f.pDx).setVisibility(8);
                    break;
                case 2:
                case 8:
                    this.qsA = (RangeWidget) findViewById(f.pDw);
                    findViewById(f.pDx).setVisibility(8);
                    this.qsy.setVisibility(8);
                    break;
            }
            this.qsA.qpS = this.qpS;
            aHf();
            w.d("MicroMsg.SnsUploadUI", "share type %d, isManuSnsPost:%b", new Object[]{Integer.valueOf(this.qsE), Boolean.valueOf(this.qsF)});
            switch (this.qsE) {
                case 0:
                    this.qsH = new ag(this);
                    break;
                case 1:
                case 11:
                    this.qsH = new z(this);
                    this.qsA.qxb = true;
                    break;
                case 2:
                    this.qsH = new ab(this);
                    this.qsA.qxb = true;
                    break;
                case 3:
                    this.qsH = new ah(this, 9);
                    this.qsA.qxb = true;
                    break;
                case 4:
                    this.qsH = new o(this);
                    this.qsA.qxb = true;
                    break;
                case 5:
                    this.qsH = new ah(this, 14);
                    this.qsA.qxb = true;
                    break;
                case 6:
                    this.qsH = new ah(this, 12);
                    this.qsA.qxb = true;
                    break;
                case 7:
                    this.qsH = new ah(this, 13);
                    this.qsA.qxb = true;
                    break;
                case 8:
                    this.qsH = new bd(this);
                    this.qsA.qxb = true;
                    break;
                case 9:
                    h.vJ();
                    CharSequence ap = bg.ap((String) h.vI().vr().get(68408, ""), "");
                    h.vJ();
                    int a2 = bg.a((Integer) h.vI().vr().get(7489, Integer.valueOf(0)), 0);
                    if (bg.mA(ap)) {
                        z = false;
                    }
                    this.qsH = new ad(this, z);
                    this.qsw.qBu = a2;
                    this.qsw.append(ap);
                    this.qsw.addTextChangedListener(new TextWatcher(this) {
                        final /* synthetic */ En_c4f742e5 qsT;

                        {
                            this.qsT = r1;
                        }

                        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }

                        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            if (this.qsT.qsw.getText().toString().trim().length() > 0) {
                                this.qsT.kr(true);
                            } else {
                                this.qsT.kr(false);
                            }
                        }

                        public final void afterTextChanged(Editable editable) {
                        }
                    });
                    break;
                case 10:
                    this.qsH = new m(this);
                    this.qsA.qxb = true;
                    break;
                case 12:
                    this.qsH = new n(this);
                    this.qsA.qxb = true;
                    break;
                case 13:
                    this.qsH = new p(this);
                    this.qsA.qxb = true;
                    break;
                case 14:
                    this.qsH = new ac(this);
                    break;
            }
            this.qsH.C(bundle);
            if (this.qsH instanceof a) {
                View findViewById = findViewById(f.pEK);
                View findViewById2 = findViewById(f.pER);
                DynamicGridView dynamicGridView = (DynamicGridView) findViewById(f.pFF);
                dynamicGridView.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ En_c4f742e5 qsT;

                    {
                        this.qsT = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return En_c4f742e5.b(this.qsT);
                    }
                });
                a = ((a) this.qsH).a(findViewById, findViewById(f.pCg), dynamicGridView, findViewById2);
                dynamicGridView.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) this.qsz.getLayoutParams();
                layoutParams.addRule(3, f.pFF);
                this.qsz.setLayoutParams(layoutParams);
            } else {
                a = this.qsH.bir();
                this.qsx = (LinearLayout) findViewById(f.pGw);
                this.qsx.setVisibility(0);
                this.qsx.setClipChildren(false);
                if (a != null) {
                    this.qsx.addView(a);
                } else {
                    this.qsx.setVisibility(8);
                }
            }
            if (this.qsH instanceof z) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) a.getLayoutParams();
                layoutParams2.width = -1;
                a.setLayoutParams(layoutParams2);
            }
            biN();
            this.qsC.uRI = new KeyboardLinearLayout.a(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final void nx(int i) {
                    if (i == -3) {
                        w.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                        new com.tencent.mm.sdk.platformtools.ae().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass8 qsV;

                            {
                                this.qsV = r1;
                            }

                            public final void run() {
                                SnsUploadSayFooter c = this.qsV.qsT.qsB;
                                c.setVisibility(0);
                                if (c.nuO != null) {
                                    c.nuO.setImageResource(i.e.pAu);
                                }
                                this.qsV.qsT.qsB.postInvalidate();
                                this.qsV.qsT.uSU.ipu.postInvalidate();
                            }
                        }, 100);
                        return;
                    }
                    new com.tencent.mm.sdk.platformtools.ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 qsV;

                        {
                            this.qsV = r1;
                        }

                        public final void run() {
                            SnsUploadSayFooter c = this.qsV.qsT.qsB;
                            if (!c.bli()) {
                                c.setVisibility(8);
                            }
                            this.qsV.qsT.qsB.postInvalidate();
                            this.qsV.qsT.uSU.ipu.postInvalidate();
                        }
                    }, 200);
                    w.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
                }
            };
            if (this.qsE == 0) {
                if (!(this.qsH instanceof ag)) {
                    w.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
                } else if (VERSION.SDK_INT < 11) {
                    w.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
                } else {
                    new Runnable(this) {
                        final /* synthetic */ En_c4f742e5 qsT;

                        {
                            this.qsT = r1;
                        }

                        public final void run() {
                            OnDragListener anonymousClass1 = new OnDragListener(this) {
                                final /* synthetic */ AnonymousClass9 qsW;

                                {
                                    this.qsW = r1;
                                }

                                public final boolean onDrag(View view, DragEvent dragEvent) {
                                    boolean z;
                                    switch (dragEvent.getAction()) {
                                        case 1:
                                        case 2:
                                        case 4:
                                        case 5:
                                            w.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[]{Integer.valueOf(dragEvent.getAction())});
                                            z = true;
                                            break;
                                        case 3:
                                            w.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
                                            ClipData clipData = dragEvent.getClipData();
                                            if (clipData == null) {
                                                z = true;
                                                break;
                                            }
                                            int itemCount = clipData.getItemCount();
                                            List arrayList = new ArrayList();
                                            for (int i = 0; i < itemCount; i++) {
                                                Item itemAt = clipData.getItemAt(i);
                                                if (itemAt == null) {
                                                    w.e("MicroMsg.SnsUploadUI", "item == null");
                                                } else if (itemAt.getIntent() != null) {
                                                    this.qsW.qsT.startActivity(itemAt.getIntent());
                                                } else if (itemAt.getUri() != null) {
                                                    com.tencent.mm.pluginsdk.ui.tools.l lVar = new com.tencent.mm.pluginsdk.ui.tools.l(this.qsW.qsT.uSU.uTo, itemAt.getUri());
                                                    if (lVar.fileType != 0 && lVar.filePath != null) {
                                                        switch (lVar.fileType) {
                                                            case 3:
                                                                arrayList.add(lVar.filePath);
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                    }
                                                    w.e("MicroMsg.SnsUploadUI", "get file path failed");
                                                }
                                            }
                                            if (arrayList.size() >= 0) {
                                                ((ag) this.qsW.qsT.qsH).d(arrayList, 0, false);
                                                z = true;
                                                break;
                                            }
                                            w.e("MicroMsg.SnsUploadUI", "no image file available");
                                            return true;
                                            break;
                                        default:
                                            w.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                                            z = false;
                                            break;
                                    }
                                    return z;
                                }
                            };
                            if (this.qsT.qsR != null) {
                                this.qsT.qsR.setOnDragListener(anonymousClass1);
                            }
                        }
                    }.run();
                }
            }
            e.g(this);
            return;
        }
        w.e("MicroMsg.SnsUploadUI", "onCreate acc not ready finish");
        w.bIQ();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        SnsUploadSayFooter snsUploadSayFooter = this.qsB;
        int i2 = (snsUploadSayFooter.bli() || snsUploadSayFooter.getVisibility() == 0) ? 1 : 0;
        if (i2 != 0) {
            this.qsB.blj();
            return true;
        } else if (this.qsE == 9) {
            setResult(0, new Intent());
            finish();
            return true;
        } else {
            g.a(this, j.pMT, 0, j.dDl, j.dGs, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ En_c4f742e5 qsT;

                {
                    this.qsT = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.qsT.fTG != null) {
                        this.qsT.fTG.gy(10);
                    }
                    this.qsT.setResult(0, new Intent());
                    this.qsT.finish();
                }
            }, null, c.aSJ);
            return true;
        }
    }

    public final void biN() {
        if (this.qsH.biq()) {
            kr(true);
        } else {
            kr(false);
        }
    }

    protected void onPause() {
        if (this.qsE == 9) {
            String trim = this.qsw.getText().toString().trim();
            h.vJ();
            h.vI().vr().set(68408, trim);
            if (bg.mA(trim)) {
                h.vJ();
                h.vI().vr().set(7489, Integer.valueOf(0));
            } else {
                h.vJ();
                h.vI().vr().set(7489, Integer.valueOf(this.qsw.qBu));
            }
        }
        super.aHf();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.qsB.post(new Runnable(this) {
            final /* synthetic */ En_c4f742e5 qsT;

            {
                this.qsT = r1;
            }

            public final void run() {
                com.tencent.mm.compatible.util.j.f(this.qsT);
            }
        });
        if (this.qsH != null && (this.qsH instanceof ac)) {
            ac acVar = (ac) this.qsH;
            if (acVar.qvb != null && !bg.mA(acVar.fVB)) {
                acVar.qvb.ak(acVar.fVB, false);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qsH != null) {
            this.qsH.bis();
        }
        if (this.qsz != null) {
            this.qsz.stop();
        }
        if (this.qsB != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.qsB;
            if (snsUploadSayFooter.nuR != null) {
                snsUploadSayFooter.nuR.anN();
                snsUploadSayFooter.nuR.destroy();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.qsw != null) {
            this.qsw.clearFocus();
        }
        if (i2 == -1) {
            if (this.qsH.a(i, intent)) {
                biN();
            }
            switch (i) {
                case 5:
                    if (intent != null) {
                        this.qsA.a(i, i2, intent, this.qsy);
                        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                        if (intExtra >= 2) {
                            this.qsI = intent.getStringExtra("Klabel_name_list");
                            this.qsJ = intent.getStringExtra("Kother_user_name_list");
                            List list;
                            if (bg.mA(this.qsI)) {
                                list = null;
                            } else {
                                list = Arrays.asList(this.qsI.split(","));
                            }
                            List list2;
                            if (bg.mA(this.qsJ)) {
                                list2 = null;
                            } else {
                                list2 = Arrays.asList(this.qsJ.split(","));
                            }
                            this.qsK = new ArrayList();
                            this.qsL = 0;
                            if (r1 != null && r1.size() > 0) {
                                Collection hashSet = new HashSet();
                                for (String ze : r1) {
                                    List<String> zh = com.tencent.mm.plugin.label.a.a.aFG().zh(com.tencent.mm.plugin.label.a.a.aFG().ze(ze));
                                    if (zh == null || zh.size() == 0) {
                                        w.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                                        this.qsK = new ArrayList(hashSet);
                                    } else {
                                        for (String ze2 : zh) {
                                            hashSet.add(ze2);
                                            this.qsL++;
                                            w.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[]{ze2});
                                        }
                                    }
                                }
                                this.qsK = new ArrayList(hashSet);
                            }
                            if (r1 != null) {
                                int i3 = 0;
                                for (String ze22 : r1) {
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
                            if (r2 != null && r2.size() > 0) {
                                for (String ze222 : r2) {
                                    if (!this.qsK.contains(ze222)) {
                                        this.qsK.add(ze222);
                                        this.qsM++;
                                    }
                                }
                            }
                            if (intExtra == 2) {
                                this.qsN = false;
                                return;
                            } else {
                                this.qsN = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 6:
                    if (intent != null) {
                        this.qsy.P(intent);
                        return;
                    }
                    return;
                case 8:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                        SnsUploadConfigView snsUploadConfigView = this.qpS;
                        if (booleanExtra) {
                            snsUploadConfigView.qJY = true;
                            snsUploadConfigView.hM(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (intent != null) {
                        this.qsz.P(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return i.g.pIw;
    }

    public final ArrayList<Exif.a> biO() {
        if (!(this.qsH instanceof ag)) {
            return null;
        }
        ag agVar = (ag) this.qsH;
        ArrayList arrayList = agVar.qwj.qwu;
        ArrayList<Exif.a> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Exif.a aVar = (Exif.a) agVar.qwl.get((String) it.next());
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    public final boolean biP() {
        return this.qsD;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.SnsUploadUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    this.qsz.biZ();
                    return;
                } else {
                    g.a(this, getString(j.eFI), getString(j.eFM), getString(j.evw), getString(j.dGs), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ En_c4f742e5 qsT;

                        {
                            this.qsT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.qsT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ En_c4f742e5 qsT;

                        {
                            this.qsT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
