package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.ru;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.collect.b.d;
import com.tencent.mm.plugin.collect.b.i;
import com.tencent.mm.plugin.collect.b.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.jk;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class CollectMainUI extends WalletPreferenceUI implements com.tencent.mm.plugin.collect.b.b.a, com.tencent.mm.sdk.platformtools.au.a {
    private static int kCN;
    private static int kCV = -1;
    private static int kCW = -1;
    private static int kCX = -1;
    private static int kCY = -1;
    private f jid = null;
    private long kBQ;
    protected TextView kCA;
    private RelativeLayout kCB;
    private Bitmap kCC = null;
    protected String kCD = null;
    protected String kCE = null;
    protected String kCF = null;
    private String kCG = null;
    private List<a> kCH = new LinkedList();
    private double kCI;
    private String kCJ = null;
    private String kCK = null;
    protected boolean kCL = false;
    private long kCM;
    private View kCO;
    private b kCP = new b(this);
    private SpannableStringBuilder kCQ;
    private SpannableStringBuilder kCR;
    private int kCS;
    private d kCT;
    private boolean kCU = false;
    private Vibrator kCe;
    private ImageView kCf = null;
    private ImageView kCg = null;
    private TextView kCh = null;
    private TextView kCi = null;
    private TextView kCj = null;
    private TextView kCk = null;
    protected TextView kCl = null;
    private CdnImageView kCm = null;
    private TextView kCn = null;
    private View kCo = null;
    private TextView kCp = null;
    private Dialog kCq = null;
    private View kCr = null;
    private View kCs = null;
    protected ScrollView kCt = null;
    private boolean kCu = false;
    private View kCv = null;
    private ImageView kCw;
    private TextView kCx;
    private TextView kCy;
    private TextView kCz;

    private class b {
        final /* synthetic */ CollectMainUI kCZ;
        public boolean kDg;
        LinkedList<a> kDh = new LinkedList();

        public b(CollectMainUI collectMainUI) {
            this.kCZ = collectMainUI;
        }

        public final void XK() {
            if (this.kDg) {
                w.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.kDh.size());
            } else if (!this.kDh.isEmpty()) {
                final a aVar = (a) this.kDh.poll();
                this.kDg = true;
                this.kCZ.akx();
                this.kCZ.kCv.setLayoutParams(new LayoutParams(this.kCZ.kCr.getWidth(), this.kCZ.kCr.getHeight()));
                if (this.kCZ.kCL) {
                    this.kCZ.kCv.setPadding(0, CollectMainUI.kCY, 0, 0);
                } else {
                    this.kCZ.kCv.setPadding(0, CollectMainUI.kCX, 0, 0);
                }
                this.kCZ.kCx.setText(h.b(this.kCZ.uSU.uTo, aVar.gMX, this.kCZ.kCx.getTextSize()));
                com.tencent.mm.pluginsdk.ui.a.b.a(this.kCZ.kCw, aVar.username);
                this.kCZ.kCy.setText(e.d(aVar.kBc, aVar.fFd));
                this.kCZ.kCv.setVisibility(0);
                final AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
                int i = 0;
                for (int i2 = 0; i2 < this.kCZ.kCH.size(); i2++) {
                    if (((a) this.kCZ.kCH.get(i2)).fTA.equals(aVar.fTA)) {
                        i = i2;
                    }
                }
                float akA = (float) CollectMainUI.kCV;
                float height = 0.0f + ((float) (this.kCZ.kCr.getHeight() / 2));
                if (this.kCZ.kCo.getVisibility() == 0) {
                    height += (float) this.kCZ.kCo.getHeight();
                }
                height += (float) ((i * CollectMainUI.kCW) + (CollectMainUI.kCW / 2));
                int[] iArr = new int[2];
                this.kCZ.kCr.getLocationInWindow(iArr);
                animationSet.addAnimation(new TranslateAnimation(0.0f, akA, 0.0f, (float) ((int) (height + ((float) (iArr[1] - CollectMainUI.kCN))))));
                animationSet.setDuration(300);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b kDj;

                    public final void onAnimationEnd(Animation animation) {
                        this.kDj.kCZ.kCv.setVisibility(8);
                        w.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + aVar.fTA);
                        for (int i = 0; i < this.kDj.kCZ.kCH.size(); i++) {
                            if (((a) this.kDj.kCZ.kCH.get(i)).fTA.equals(aVar.fTA)) {
                                ((a) this.kDj.kCZ.kCH.get(i)).klI = true;
                                w.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + aVar.fTA);
                                break;
                            }
                        }
                        this.kDj.kCZ.akx();
                        this.kDj.kDg = false;
                        this.kDj.XK();
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setInterpolator(new LinearInterpolator());
                scaleAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b kDj;

                    public final void onAnimationEnd(Animation animation) {
                        animationSet.setStartOffset(1700);
                        this.kDj.kCZ.kCv.startAnimation(animationSet);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                        this.kDj.kCZ.kCv.setVisibility(0);
                    }
                });
                this.kCZ.kCv.startAnimation(scaleAnimation);
            }
        }
    }

    class a extends q {
        final /* synthetic */ CollectMainUI kCZ;
        public boolean klI = false;

        public a(CollectMainUI collectMainUI, q qVar) {
            this.kCZ = collectMainUI;
            this.username = qVar.username;
            this.fTA = qVar.fTA;
            this.kBc = qVar.kBc;
            this.kBd = qVar.kBd;
            this.scene = qVar.scene;
            this.status = qVar.status;
            this.gMX = qVar.gMX;
        }
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI) {
        int i = 0;
        if (collectMainUI.kCC == null || collectMainUI.kCC.isRecycled()) {
            w.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
            Toast.makeText(collectMainUI.uSU.uTo, collectMainUI.getString(R.l.dWZ), 1).show();
        } else {
            if (!(collectMainUI.kCC == null || collectMainUI.kCC.isRecycled())) {
                int i2;
                if (collectMainUI.kCL) {
                    g.oUh.i(11343, new Object[]{Integer.valueOf(1), Integer.valueOf((int) Math.round(collectMainUI.kCI * 100.0d))});
                } else {
                    g.oUh.i(11343, new Object[]{Integer.valueOf(0)});
                }
                if (collectMainUI.kCu) {
                    i2 = 0;
                } else {
                    collectMainUI.kCt = (ScrollView) ((ViewStub) collectMainUI.findViewById(R.h.bDY)).inflate();
                    collectMainUI.akt();
                    collectMainUI.kCu = true;
                    i2 = 250;
                }
                collectMainUI.kCt.setVisibility(4);
                ((ImageView) collectMainUI.kCt.findViewById(R.h.bDT)).setImageBitmap(collectMainUI.kCC);
                b((ImageView) collectMainUI.kCt.findViewById(R.h.bDU));
                final LinearLayout linearLayout = (LinearLayout) collectMainUI.kCt.findViewById(R.h.bEj);
                TextView textView = (TextView) collectMainUI.kCt.findViewById(R.h.bDW);
                CharSequence de = e.de(e.eK(m.xL()), 10);
                if (!bg.mA(collectMainUI.akr())) {
                    de = de + collectMainUI.getString(R.l.dWU, new Object[]{r3});
                }
                textView.setText(h.b(collectMainUI, de, textView.getTextSize()));
                LinearLayout linearLayout2 = (LinearLayout) collectMainUI.kCt.findViewById(R.h.bDS);
                TextView textView2 = (TextView) collectMainUI.kCt.findViewById(R.h.bDP);
                TextView textView3 = (TextView) collectMainUI.kCt.findViewById(R.h.bDQ);
                TextView textView4 = (TextView) collectMainUI.kCt.findViewById(R.h.bDR);
                if (collectMainUI.kCL) {
                    if (bg.mA(collectMainUI.kCK)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setText(collectMainUI.kCK);
                        textView3.setVisibility(0);
                    }
                    textView2.setText(collectMainUI.aks());
                    textView4.setText(e.n(collectMainUI.kCI));
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                af.f(new Runnable(collectMainUI) {
                    final /* synthetic */ CollectMainUI kCZ;

                    public final void run() {
                        w.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[]{Integer.valueOf(linearLayout.getHeight()), Integer.valueOf(linearLayout.getWidth())});
                        Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Config.ARGB_8888);
                        linearLayout.draw(new Canvas(createBitmap));
                        try {
                            String str = k.bGD() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                            com.tencent.mm.sdk.platformtools.d.a(createBitmap, 100, CompressFormat.PNG, str, false);
                            Toast.makeText(this.kCZ.uSU.uTo, this.kCZ.getString(R.l.eaX, new Object[]{str}), 1).show();
                            k.b(str, this.kCZ.uSU.uTo);
                        } catch (Exception e) {
                            w.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e.getMessage());
                        }
                        this.kCZ.kCt.setVisibility(8);
                    }
                }, (long) i2);
                i = 1;
            }
            if (i == 0) {
                Toast.makeText(collectMainUI.uSU.uTo, collectMainUI.getString(R.l.dWZ), 1).show();
            }
        }
        collectMainUI.vrv.notifyDataSetChanged();
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI, final alp com_tencent_mm_protocal_c_alp) {
        if (com_tencent_mm_protocal_c_alp == null || bg.mA(com_tencent_mm_protocal_c_alp.fNG)) {
            w.d("MicroMsg.CollectMainUI", "empty item return");
            return;
        }
        com.tencent.mm.plugin.wallet_core.ui.k.a aVar;
        CharSequence charSequence;
        ap.yY();
        String str = (String) c.vr().get(com.tencent.mm.storage.w.a.uIz, "");
        if (bg.mA(str)) {
            collectMainUI.kCm.setVisibility(8);
            collectMainUI.kCl.setTextSize(1, 12.0f);
            collectMainUI.kCU = true;
        } else {
            collectMainUI.kCm.L(str, 0, 0);
            collectMainUI.kCm.setVisibility(0);
            collectMainUI.kCl.setTextSize(1, 15.0f);
            collectMainUI.kCU = false;
        }
        AnonymousClass7 anonymousClass7 = null;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com_tencent_mm_protocal_c_alp.fNG);
        SpannableStringBuilder spannableStringBuilder2;
        if (com_tencent_mm_protocal_c_alp.type == 1) {
            if (com_tencent_mm_protocal_c_alp.url.equals("wxpay://f2f/f2fdetail")) {
                anonymousClass7 = new com.tencent.mm.plugin.wallet_core.ui.k.a(collectMainUI) {
                    final /* synthetic */ CollectMainUI kCZ;

                    public final void akv() {
                        Intent intent = new Intent(this.kCZ.uSU.uTo, CollectBillUI.class);
                        intent.putExtra("key_from_scene", 0);
                        this.kCZ.startActivityForResult(intent, 4097);
                        g.oUh.i(13944, new Object[]{Integer.valueOf(1)});
                        g.oUh.i(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(1), com_tencent_mm_protocal_c_alp.fNG, "", "", "", Integer.valueOf(2)});
                    }
                };
            }
            g.oUh.i(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(1), com_tencent_mm_protocal_c_alp.fNG, "", "", "", Integer.valueOf(1)});
            spannableStringBuilder2 = spannableStringBuilder;
            aVar = anonymousClass7;
            charSequence = spannableStringBuilder2;
        } else if (com_tencent_mm_protocal_c_alp.type == 2) {
            AnonymousClass8 anonymousClass8 = new com.tencent.mm.plugin.wallet_core.ui.k.a(collectMainUI) {
                final /* synthetic */ CollectMainUI kCZ;

                public final void akv() {
                    if (bg.mA(com_tencent_mm_protocal_c_alp.url)) {
                        w.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
                        return;
                    }
                    e.m(this.kCZ.uSU.uTo, com_tencent_mm_protocal_c_alp.url, false);
                    g.oUh.i(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(2), com_tencent_mm_protocal_c_alp.fNG, "", "", com_tencent_mm_protocal_c_alp.url, Integer.valueOf(2)});
                }
            };
            g.oUh.i(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(2), com_tencent_mm_protocal_c_alp.fNG, "", "", com_tencent_mm_protocal_c_alp.url, Integer.valueOf(1)});
            spannableStringBuilder2 = spannableStringBuilder;
            r1 = anonymousClass8;
            r0 = spannableStringBuilder2;
        } else if (com_tencent_mm_protocal_c_alp.type == 3) {
            AnonymousClass9 anonymousClass9 = new com.tencent.mm.plugin.wallet_core.ui.k.a(collectMainUI) {
                final /* synthetic */ CollectMainUI kCZ;

                public final void akv() {
                    com.tencent.mm.sdk.b.b prVar = new pr();
                    prVar.fWB.userName = com_tencent_mm_protocal_c_alp.tQu;
                    prVar.fWB.fWD = bg.ap(com_tencent_mm_protocal_c_alp.tQv, "");
                    prVar.fWB.scene = 1072;
                    prVar.fWB.fWE = 0;
                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                    g.oUh.i(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(3), com_tencent_mm_protocal_c_alp.fNG, com_tencent_mm_protocal_c_alp.tQu, com_tencent_mm_protocal_c_alp.tQv, "", Integer.valueOf(2)});
                }
            };
            g.oUh.i(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(3), com_tencent_mm_protocal_c_alp.fNG, com_tencent_mm_protocal_c_alp.tQu, com_tencent_mm_protocal_c_alp.tQv, "", Integer.valueOf(1)});
            spannableStringBuilder2 = spannableStringBuilder;
            r1 = anonymousClass9;
            r0 = spannableStringBuilder2;
        } else {
            w.w("MicroMsg.CollectMainUI", "unknown type: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alp.type)});
            charSequence = new SpannableStringBuilder(collectMainUI.getString(R.l.dWG));
            aVar = new com.tencent.mm.plugin.wallet_core.ui.k.a(collectMainUI) {
                final /* synthetic */ CollectMainUI kCZ;

                {
                    this.kCZ = r1;
                }

                public final void akv() {
                    Intent intent = new Intent(this.kCZ.uSU.uTo, CollectBillUI.class);
                    intent.putExtra("key_from_scene", 0);
                    this.kCZ.startActivityForResult(intent, 4097);
                    g.oUh.i(13944, new Object[]{Integer.valueOf(1)});
                }
            };
        }
        collectMainUI.kCl.setClickable(true);
        collectMainUI.kCl.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(collectMainUI));
        charSequence.setSpan(new com.tencent.mm.plugin.wallet_core.ui.k(5, aVar), 0, charSequence.length(), 18);
        collectMainUI.kCl.setText(charSequence);
        collectMainUI.akw();
    }

    static /* synthetic */ void r(CollectMainUI collectMainUI) {
        collectMainUI.kBQ &= -32769;
        ap.yY();
        c.vr().set(147457, Long.valueOf(collectMainUI.kBQ));
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amp = new amp();
        com_tencent_mm_protocal_c_amp.oTE = 2;
        ap.yY();
        c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(ag.CTRL_INDEX, com_tencent_mm_protocal_c_amp));
        com.tencent.mm.plugin.collect.a.a.ajY().akc();
    }

    static /* synthetic */ void s(CollectMainUI collectMainUI) {
        collectMainUI.kBQ |= 32768;
        ap.yY();
        c.vr().set(147457, Long.valueOf(collectMainUI.kBQ));
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amp = new amp();
        com_tencent_mm_protocal_c_amp.oTE = 1;
        ap.yY();
        c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(ag.CTRL_INDEX, com_tencent_mm_protocal_c_amp));
        com.tencent.mm.plugin.collect.a.a.ajY().akb();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        cO().cP().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.aSv)));
        View customView = cO().cP().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.e.aUl));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.e.white));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.e.aSw));
        }
        ap.yY();
        this.kCS = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDY, Integer.valueOf(0))).intValue();
        this.kBQ = m.xQ();
        int intExtra = getIntent().getIntExtra("key_from_scene", 1);
        g.oUh.i(14021, new Object[]{Integer.valueOf(2), Integer.valueOf(intExtra)});
        ap.yY();
        boolean equals = ((String) c.vr().get(327731, "0")).equals("0");
        overridePendingTransition(R.a.aRN, R.a.aRM);
        if (equals) {
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, m.xY() ? R.l.dWK : R.l.dWJ, R.l.dWL, new OnClickListener(this) {
                final /* synthetic */ CollectMainUI kCZ;

                {
                    this.kCZ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            ap.yY();
            c.vr().set(327731, "1");
            ap.yY();
            c.vr().jY(true);
        }
        com.tencent.mm.plugin.collect.a.a.ajY();
        com.tencent.mm.plugin.collect.b.b ajZ = com.tencent.mm.plugin.collect.a.a.ajZ();
        if (!ajZ.kcI.contains(this)) {
            ajZ.kcI.add(this);
        }
        KC();
        akq();
        aiQ();
        this.kCe = (Vibrator) getSystemService("vibrator");
        this.kCM = bg.Ny();
        if (kCV < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            kCV = (displayMetrics.widthPixels / 2) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.uSU.uTo, 20.0f);
            kCW = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.uSU.uTo, 60.0f);
            kCX = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.uSU.uTo, 40.0f);
            kCY = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.uSU.uTo, 70.0f);
        }
        akw();
        o.ev(16, 0);
    }

    protected void onDestroy() {
        if (this.kCf != null) {
            this.kCf.setImageBitmap(null);
        }
        Bitmap bitmap = this.kCC;
        if (!(bitmap == null || bitmap.isRecycled())) {
            w.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        if (this.kCq != null) {
            this.kCq.dismiss();
        }
        com.tencent.mm.plugin.collect.a.a.ajY();
        com.tencent.mm.plugin.collect.a.a.ajZ().kcI.remove(this);
        this.kCe.cancel();
        if (this.kCT != null) {
            com.tencent.mm.y.e eVar = this.kCT;
            for (Entry entry : eVar.gUK.entrySet()) {
                w.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
                ap.vd().c((com.tencent.mm.y.k) entry.getKey());
            }
            ap.vd().b(1588, eVar);
        }
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eFh);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kCZ.finish();
                return true;
            }
        });
        this.jid = this.vrv;
        this.kCo = findViewById(R.h.bDM);
        this.kCi = (TextView) findViewById(R.h.bDD);
        this.kCh = (TextView) findViewById(R.h.bDC);
        this.kCj = (TextView) findViewById(R.h.bDE);
        this.kCk = (TextView) findViewById(R.h.bDL);
        this.kCA = (TextView) findViewById(R.h.bsx);
        this.kCr = (RelativeLayout) findViewById(R.h.bDK);
        this.kCs = findViewById(R.h.bDI);
        this.kCO = LayoutInflater.from(this).inflate(R.i.cZh, null, false);
        this.kCl = (TextView) this.kCO.findViewById(R.h.bDB);
        this.kCm = (CdnImageView) this.kCO.findViewById(R.h.bDA);
        this.kCn = (TextView) findViewById(R.h.bDV);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(R.l.bDV));
        spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.k(new com.tencent.mm.plugin.wallet_core.ui.k.a(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void akv() {
                CollectMainUI.a(this.kCZ);
                g.oUh.i(13944, new Object[]{Integer.valueOf(5)});
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.kCn.setText(spannableStringBuilder);
        this.kCn.setClickable(true);
        this.kCn.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this));
        this.mUX.addFooterView(this.kCO, null, false);
        this.mUX.setFooterDividersEnabled(false);
        this.kCf = (ImageView) findViewById(R.h.bDG);
        this.kCg = (ImageView) findViewById(R.h.bDH);
        this.kCp = (TextView) findViewById(R.h.bDZ);
        this.kCz = (TextView) findViewById(R.h.bEk);
        this.kCz.setClickable(true);
        this.kCz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this));
        this.kCQ = new SpannableStringBuilder(getString(R.l.dWM));
        this.kCR = new SpannableStringBuilder(getString(R.l.dWN));
        com.tencent.mm.plugin.wallet_core.ui.k kVar = new com.tencent.mm.plugin.wallet_core.ui.k(new com.tencent.mm.plugin.wallet_core.ui.k.a(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void akv() {
                Intent intent = new Intent();
                intent.setClass(this.kCZ.uSU.uTo, CollectCreateQRCodeUI.class);
                intent.putExtra("key_currency_unit", this.kCZ.kCF);
                this.kCZ.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
            }
        });
        com.tencent.mm.plugin.wallet_core.ui.k kVar2 = new com.tencent.mm.plugin.wallet_core.ui.k(new com.tencent.mm.plugin.wallet_core.ui.k.a(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void akv() {
                this.kCZ.kCL = false;
                this.kCZ.aku();
                this.kCZ.kCz.setText(this.kCZ.kCQ);
                this.kCZ.akw();
            }
        });
        this.kCQ.setSpan(kVar, 0, this.kCQ.length(), 18);
        this.kCR.setSpan(kVar2, 0, this.kCR.length(), 18);
        this.kCz.setText(this.kCQ);
        this.kCB = (RelativeLayout) findViewById(R.h.bEa);
        b(this.kCg);
        this.kCf.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final boolean onLongClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.kCZ.getString(R.l.dWT));
                linkedList2.add(Integer.valueOf(0));
                com.tencent.mm.ui.base.g.a(this.kCZ.uSU.uTo, this.kCZ.getString(R.l.dWV), linkedList, linkedList2, null, true, new com.tencent.mm.ui.base.g.d(this) {
                    final /* synthetic */ AnonymousClass16 kDe;

                    {
                        this.kDe = r1;
                    }

                    public final void bN(int i, int i2) {
                        switch (i2) {
                            case 0:
                                CollectMainUI.a(this.kDe.kCZ);
                                g.oUh.i(13944, new Object[]{Integer.valueOf(6)});
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.kCv = findViewById(R.h.bDN);
        this.kCw = (ImageView) findViewById(R.h.bEc);
        this.kCx = (TextView) findViewById(R.h.bEe);
        this.kCy = (TextView) findViewById(R.h.bEd);
        this.kCr.postDelayed(new Runnable(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void run() {
                int[] iArr = new int[2];
                this.kCZ.kCr.getLocationInWindow(iArr);
                CollectMainUI.kCN = iArr[1];
            }
        }, 300);
        final com.tencent.mm.sdk.b.b ruVar = new ru();
        ruVar.fYM.fYO = "8";
        ruVar.nFq = new Runnable(this) {
            final /* synthetic */ CollectMainUI kCZ;

            public final void run() {
                if (bg.mA(ruVar.fYN.fYP)) {
                    w.i("MicroMsg.CollectMainUI", "no bulletin data");
                } else {
                    e.a((TextView) this.kCZ.findViewById(R.h.bsx), ruVar.fYN.fYP, ruVar.fYN.content, ruVar.fYN.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(ruVar);
    }

    protected final void aiQ() {
        if (bg.mA(this.kCD)) {
            w.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            return;
        }
        aku();
        akx();
        at btK = com.tencent.mm.plugin.wallet_core.model.h.btK();
        int i = this.kCL ? 33 : 32;
        if (btK != null) {
            g.oUh.i(13447, new Object[]{Integer.valueOf(i), btK.tdX, btK.tdY, this.kCD, Double.valueOf(this.kCI), Long.valueOf(bg.Ny()), Long.valueOf(btK.tdW), btK.tdZ, btK.tea});
        }
    }

    protected void aku() {
        this.kCf.setImageBitmap(null);
        this.kCg.setVisibility(8);
        if (this.kCL) {
            if (bg.mA(this.kCG)) {
                w.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                return;
            }
            this.kCC = com.tencent.mm.bf.a.a.b(this, this.kCG, 0, 3);
        } else if (bg.mA(this.kCD)) {
            w.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            return;
        } else {
            this.kCC = com.tencent.mm.bf.a.a.b(this, this.kCD, 0, 3);
        }
        if (this.kCC == null || this.kCC.isRecycled()) {
            this.kCg.setVisibility(8);
            w.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bg.mz(this.kCG));
        } else {
            this.kCf.setImageBitmap(this.kCC);
            this.kCg.setVisibility(0);
        }
        if (this.kCL) {
            this.kCj.setText(aks());
            this.kCi.setText(e.n(this.kCI));
            this.kCi.setVisibility(0);
            this.kCj.setVisibility(0);
            if (bg.mA(this.kCK)) {
                this.kCh.setVisibility(8);
            } else {
                this.kCh.setText(h.b(this.uSU.uTo, this.kCK, this.kCh.getTextSize()));
                this.kCh.setVisibility(0);
            }
            findViewById(R.h.bDF).setVisibility(0);
            return;
        }
        this.kCj.setVisibility(8);
        this.kCi.setVisibility(8);
        this.kCh.setVisibility(8);
        findViewById(R.h.bDF).setVisibility(8);
    }

    private void akw() {
        getWindow().getDecorView().post(new Runnable(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void run() {
                int dP = com.tencent.mm.bg.a.dP(this.kCZ.uSU.uTo);
                int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.kCZ.uSU.uTo, 58);
                if (this.kCZ.kCU) {
                    fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.kCZ.uSU.uTo, 50);
                }
                int[] iArr = new int[2];
                this.kCZ.mUX.getLocationInWindow(iArr);
                int bottom = (this.kCZ.kCO.getBottom() + iArr[1]) - dP;
                int height = (this.kCZ.mUX.getHeight() - this.kCZ.kCO.getHeight()) + iArr[1];
                if (bottom > 0) {
                    height += bottom;
                }
                fromDPToPix = (dP - height) - fromDPToPix;
                int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(this.kCZ.uSU.uTo, 34);
                w.d("MicroMsg.CollectMainUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[]{Integer.valueOf(dP), Integer.valueOf(height), Integer.valueOf(this.kCZ.kCO.getHeight()), Integer.valueOf(iArr[1]), Integer.valueOf(bottom), Integer.valueOf(fromDPToPix)});
                if (fromDPToPix > fromDPToPix2) {
                    this.kCZ.kCO.setPadding(0, fromDPToPix, 0, fromDPToPix2);
                } else {
                    this.kCZ.kCO.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
                }
                this.kCZ.kCO.requestLayout();
            }
        });
    }

    private static void b(ImageView imageView) {
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, m.xL(), 0.06f, false);
    }

    private void akx() {
        double d;
        if (this.kCH == null || this.kCH.size() <= 0) {
            d = 0.0d;
        } else {
            this.kCr.setBackgroundResource(R.g.bem);
            this.jid.removeAll();
            d = 0.0d;
            for (int i = 0; i < this.kCH.size(); i++) {
                Preference cVar;
                a aVar = (a) this.kCH.get(i);
                String valueOf = String.valueOf(i);
                if (i == this.kCH.size() - 1) {
                    cVar = new c(this, R.i.cZj);
                } else {
                    cVar = new c(this);
                }
                cVar.setKey(valueOf);
                valueOf = aVar.gMX;
                if (bg.mA(valueOf) && !bg.mA(aVar.username)) {
                    valueOf = e.eK(aVar.username);
                }
                cVar.mTitle = valueOf;
                cVar.gLD = aVar.username;
                if (aVar.status == 0) {
                    cVar.setSummary(R.l.dWS);
                } else if (aVar.status == 1) {
                    if (aVar.klI) {
                        d += aVar.kBc;
                        cVar.setSummary(e.d(aVar.kBc, aVar.fFd));
                    } else {
                        cVar.setSummary(R.l.dWR);
                    }
                    this.jid.a(cVar);
                } else if (aVar.status == 2) {
                    cVar.setSummary(R.l.dWQ);
                }
                this.jid.a(cVar);
            }
            this.jid.notifyDataSetChanged();
            this.kCk.setText(e.d(d, ((a) this.kCH.get(0)).fFd));
            this.kCk.setVisibility(0);
        }
        if (d <= 0.0d || this.kCH.size() <= 0) {
            this.kCk.setVisibility(8);
            this.kCo.setVisibility(8);
            this.kCs.setVisibility(8);
        } else if (this.kCH.size() > 1) {
            this.kCo.setVisibility(0);
            this.kCs.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.cZg;
    }

    public final int ON() {
        return R.o.ftl;
    }

    public final int aeq() {
        return R.i.cZi;
    }

    public boolean f(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        return false;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final void b(q qVar) {
        Object obj = null;
        w.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (((this.kCS == 1 || this.kCS == 0) && qVar.msgType == 9) || (this.kCS == 8 && qVar.msgType == 26)) {
            if (this.kCe != null) {
                this.kCe.vibrate(50);
            }
            if (((long) qVar.kBd) < this.kCM) {
                w.d("MicroMsg.CollectMainUI", "Recieve but time out ");
                return;
            }
            Object obj2;
            int i = 0;
            while (i < this.kCH.size()) {
                if (qVar.status == 0 && bg.mz(qVar.username).equals(((a) this.kCH.get(i)).username) && ((a) this.kCH.get(i)).status == 2) {
                    this.kCH.remove(i);
                    this.kCH.add(i, new a(this, qVar));
                    obj2 = 1;
                    break;
                } else if (qVar.fTA.equals(((a) this.kCH.get(i)).fTA)) {
                    w.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + qVar.fTA);
                    if (((a) this.kCH.get(i)).status == 0) {
                        ((a) this.kCH.get(i)).status = qVar.status;
                        ((a) this.kCH.get(i)).kBc = qVar.kBc;
                        ((a) this.kCH.get(i)).fFd = qVar.fFd;
                        if (qVar.status == 1) {
                            a aVar = (a) this.kCH.get(i);
                            this.kCP.kDh.add(aVar);
                        }
                    }
                    int i2 = 1;
                } else {
                    i++;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                for (i = 0; i < this.kCH.size(); i++) {
                    if (qVar.kBd > ((q) this.kCH.get(i)).kBd) {
                        this.kCH.add(i, new a(this, qVar));
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    this.kCH.add(new a(this, qVar));
                }
            }
            af.v(new Runnable(this) {
                final /* synthetic */ CollectMainUI kCZ;

                {
                    this.kCZ = r1;
                }

                public final void run() {
                    this.kCZ.akx();
                    this.kCZ.kCP.XK();
                    this.kCZ.akw();
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                if (i2 != -1 || intent == null) {
                    this.kCL = false;
                } else {
                    this.kCG = intent.getStringExtra("ftf_pay_url");
                    this.kCI = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.kCJ = intent.getStringExtra("ftf_fixed_fee_type");
                    this.kCK = intent.getStringExtra("ftf_fixed_desc");
                    this.kCF = intent.getStringExtra("key_currency_unit");
                    this.kCz.setText(this.kCR);
                    this.kCL = true;
                }
                aiQ();
                akw();
                return;
            case 4097:
                this.kBQ = m.xQ();
                return;
            default:
                return;
        }
    }

    protected void onResume() {
        super.onResume();
        au.a(this);
    }

    protected void onPause() {
        super.onPause();
        au.a(null);
    }

    public final void XF() {
        w.i("MicroMsg.CollectMainUI", "do screen shot");
        g.oUh.i(13944, new Object[]{Integer.valueOf(9)});
        com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.dWX), "", getString(R.l.dWW), getString(R.l.dGs), false, new OnClickListener(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CollectMainUI.a(this.kCZ);
                g.oUh.i(13944, new Object[]{Integer.valueOf(10)});
            }
        }, new OnClickListener(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.aRL, R.a.aRO);
    }

    protected void akq() {
        this.kCT = new d();
        ap.vd().a(1588, this.kCT);
        d dVar = this.kCT;
        com.tencent.mm.plugin.collect.b.d.a anonymousClass6 = new com.tencent.mm.plugin.collect.b.d.a(this) {
            final /* synthetic */ CollectMainUI kCZ;

            {
                this.kCZ = r1;
            }

            public final void bG(String str, String str2) {
                w.i("MicroMsg.CollectMainUI", "get cache: %s, %s", new Object[]{str, str2});
                this.kCZ.kCD = str;
                this.kCZ.kCE = str2;
                alp p = CollectMainUI.aky();
                List q = CollectMainUI.akz();
                CollectMainUI.a(this.kCZ, p);
                this.kCZ.ak(q);
            }

            public final void a(boolean z, jk jkVar) {
                w.i("MicroMsg.CollectMainUI", "get from cgi: %s", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    this.kCZ.kCD = jkVar.url;
                    this.kCZ.kCE = jkVar.rDD;
                    CollectMainUI.a(this.kCZ, jkVar.tpq);
                    this.kCZ.ak(jkVar.tpp);
                    this.kCZ.aiQ();
                }
            }
        };
        ap.yY();
        String str = (String) c.vr().get(com.tencent.mm.storage.w.a.uIw, "");
        ap.yY();
        String str2 = (String) c.vr().get(com.tencent.mm.storage.w.a.uIx, "");
        if (bg.mA(str)) {
            w.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
            str = com.tencent.mm.plugin.wallet_core.model.m.btS().bup();
        }
        anonymousClass6.bG(str, str2);
        com.tencent.mm.y.k iVar = new i();
        dVar.gUK.put(iVar, anonymousClass6);
        ap.vd().a(iVar, 0);
    }

    private static alp aky() {
        try {
            ap.yY();
            return x(new JSONObject((String) c.vr().get(com.tencent.mm.storage.w.a.uIy, "")));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
            return null;
        }
    }

    private static List<alp> akz() {
        List<alp> arrayList = new ArrayList();
        try {
            ap.yY();
            String str = (String) c.vr().get(com.tencent.mm.storage.w.a.uIA, "");
            if (!bg.mA(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(x(jSONArray.getJSONObject(i)));
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.CollectMainUI", e, "", new Object[0]);
        }
        return arrayList;
    }

    private static alp x(JSONObject jSONObject) {
        alp com_tencent_mm_protocal_c_alp = new alp();
        com_tencent_mm_protocal_c_alp.type = jSONObject.optInt(Columns.TYPE, -1);
        com_tencent_mm_protocal_c_alp.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
        com_tencent_mm_protocal_c_alp.fNG = jSONObject.optString("wording", "");
        com_tencent_mm_protocal_c_alp.tQu = jSONObject.optString("waapp_username", "");
        com_tencent_mm_protocal_c_alp.tQv = jSONObject.optString("waapp_path", "");
        return com_tencent_mm_protocal_c_alp;
    }

    protected String akr() {
        if (bg.mA(this.kCE)) {
            this.kCE = com.tencent.mm.plugin.wallet_core.model.m.btS().akr();
            this.kCE = e.UJ(this.kCE);
        }
        return this.kCE;
    }

    protected String aks() {
        return e.UG(this.kCJ);
    }

    protected final void ak(final List<alp> list) {
        if (list != null) {
            for (alp com_tencent_mm_protocal_c_alp : list) {
                if (com_tencent_mm_protocal_c_alp.type == 1) {
                    g.oUh.i(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(1), com_tencent_mm_protocal_c_alp.fNG, "", "", "", Integer.valueOf(1)});
                } else if (com_tencent_mm_protocal_c_alp.type == 2) {
                    g.oUh.i(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(2), com_tencent_mm_protocal_c_alp.fNG, "", "", com_tencent_mm_protocal_c_alp.url, Integer.valueOf(1)});
                } else if (com_tencent_mm_protocal_c_alp.type == 3) {
                    g.oUh.i(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(3), com_tencent_mm_protocal_c_alp.fNG, com_tencent_mm_protocal_c_alp.tQu, com_tencent_mm_protocal_c_alp.tQv, "", Integer.valueOf(1)});
                }
            }
        }
        this.kCB.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CollectMainUI kCZ;

            public final void onClick(View view) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.kCZ.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJf = new n.c(this) {
                    final /* synthetic */ AnonymousClass11 kDd;

                    {
                        this.kDd = r1;
                    }

                    public final void a(l lVar) {
                        com.tencent.mm.plugin.collect.a.a.ajY();
                        if (com.tencent.mm.plugin.collect.a.a.aka()) {
                            lVar.add(0, 1, 0, R.l.dWH);
                        } else {
                            lVar.add(0, 1, 0, R.l.dWO);
                        }
                        if (list != null) {
                            for (int i = 0; i < list.size(); i++) {
                                alp com_tencent_mm_protocal_c_alp = (alp) list.get(i);
                                if (!bg.mA(com_tencent_mm_protocal_c_alp.fNG)) {
                                    lVar.add(0, (i + 1) + 1, 0, com_tencent_mm_protocal_c_alp.fNG);
                                }
                            }
                        }
                    }
                };
                eVar.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass11 kDd;

                    {
                        this.kDd = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                com.tencent.mm.plugin.collect.a.a.ajY();
                                if (com.tencent.mm.plugin.collect.a.a.aka()) {
                                    CollectMainUI.r(this.kDd.kCZ);
                                    Toast.makeText(this.kDd.kCZ.uSU.uTo, R.l.dWI, 1).show();
                                    g.oUh.i(13944, new Object[]{Integer.valueOf(8)});
                                    return;
                                }
                                CollectMainUI.s(this.kDd.kCZ);
                                Toast.makeText(this.kDd.kCZ.uSU.uTo, R.l.dWP, 1).show();
                                g.oUh.i(13944, new Object[]{Integer.valueOf(7)});
                                return;
                            default:
                                int itemId = (menuItem.getItemId() - 1) - 1;
                                if (itemId < 0) {
                                    w.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[]{Integer.valueOf(itemId)});
                                    return;
                                }
                                alp com_tencent_mm_protocal_c_alp = (alp) list.get(itemId);
                                if (com_tencent_mm_protocal_c_alp.type == 1) {
                                    w.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[]{com_tencent_mm_protocal_c_alp.url});
                                    g.oUh.i(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(1), com_tencent_mm_protocal_c_alp.fNG, "", "", "", Integer.valueOf(2)});
                                    return;
                                } else if (com_tencent_mm_protocal_c_alp.type == 2) {
                                    if (!bg.mA(com_tencent_mm_protocal_c_alp.url)) {
                                        e.m(this.kDd.kCZ.uSU.uTo, com_tencent_mm_protocal_c_alp.url, false);
                                        g.oUh.i(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(2), com_tencent_mm_protocal_c_alp.fNG, "", "", com_tencent_mm_protocal_c_alp.url, Integer.valueOf(2)});
                                        return;
                                    }
                                    return;
                                } else if (com_tencent_mm_protocal_c_alp.type == 3) {
                                    com.tencent.mm.sdk.b.b prVar = new pr();
                                    prVar.fWB.userName = com_tencent_mm_protocal_c_alp.tQu;
                                    prVar.fWB.fWD = bg.ap(com_tencent_mm_protocal_c_alp.tQv, "");
                                    prVar.fWB.scene = 1072;
                                    prVar.fWB.fWE = 0;
                                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                                    g.oUh.i(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(3), com_tencent_mm_protocal_c_alp.fNG, com_tencent_mm_protocal_c_alp.tQu, com_tencent_mm_protocal_c_alp.tQv, "", Integer.valueOf(2)});
                                    return;
                                } else {
                                    return;
                                }
                        }
                    }
                };
                eVar.bzh();
            }
        });
    }

    protected void akt() {
    }
}
