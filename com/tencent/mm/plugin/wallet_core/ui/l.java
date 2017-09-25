package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.b.f.f;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.e.a.mg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class l extends i implements c {
    private static HashMap<String, Boolean> rNE = new HashMap();
    public OnCancelListener FU;
    public ImageView hBi;
    private boolean isPaused = false;
    public View khv;
    private Animation lOR;
    private int lOS = 0;
    protected MyKeyboardWindow mKeyboard;
    protected View npM;
    protected PayInfo oLz;
    public TextView oRW;
    public TextView oYv;
    protected boolean ppy;
    public Button rMX;
    public ImageView rMY;
    public TextView rMZ;
    private Animation rNA = null;
    private String rNB = "";
    private long rNC = -1;
    boolean rND = false;
    public TextView rNa;
    public FavourLayout rNb;
    public ImageView rNc;
    public TextView rNd;
    public EditHintPasswdView rNe;
    public c rNf;
    public View rNg;
    public View rNh;
    public TextView rNi;
    public ImageView rNj;
    public TextView rNk;
    public TextView rNl;
    public View rNm;
    public TextView rNn;
    public a rNo;
    public OnClickListener rNp;
    public boolean rNq = false;
    protected boolean rNr = true;
    public Bankcard rNs = null;
    public TextView rNt;
    public View rNu;
    public TextView rNv;
    public ImageView rNw;
    protected int rNx = 0;
    protected boolean rNy = false;
    private int rNz = 0;
    protected com.tencent.mm.plugin.wallet_core.d.a rwv = new com.tencent.mm.plugin.wallet_core.d.a();
    protected a rzJ = null;
    public TextView rzU;
    public FavorPayInfo rzg = new FavorPayInfo();

    public interface a {
        void aQt();
    }

    private static class b implements OnCancelListener {
        private OnCancelListener rNO = null;

        public b(OnCancelListener onCancelListener) {
            this.rNO = onCancelListener;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            l.iI(false);
            if (this.rNO != null) {
                this.rNO.onCancel(dialogInterface);
            }
        }
    }

    public interface c {
        void a(String str, FavorPayInfo favorPayInfo, boolean z);
    }

    static /* synthetic */ void a(l lVar) {
        lVar.rNt.setText(lVar.getContext().getString(R.l.fjk));
        lVar.rNx = 1;
        lVar.rNC = bg.NA();
        lVar.rNu.setVisibility(0);
        lVar.rNw.setVisibility(0);
        lVar.rNv.setVisibility(8);
        lVar.rNe.setVisibility(8);
        lVar.npM.setVisibility(8);
        lVar.rMZ.setText(R.l.fje);
        iI(false);
        lVar.oLz.sYf = 1;
        g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
        e.CM(9);
    }

    static /* synthetic */ boolean c(l lVar) {
        String str = "MicroMsg.WalletPwdDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!lVar.isPaused);
        w.i(str, str2, objArr);
        return !lVar.isPaused;
    }

    public l(Context context) {
        super(context, R.m.foO);
        bV(context);
    }

    public void bV(Context context) {
        w.v("MicroMsg.WalletPwdDialog", "alvinluo WalletPwdDialog initView");
        da(context);
        db(context);
        bvd();
    }

    public final void da(Context context) {
        this.khv = View.inflate(context, bvh(), null);
        this.rMX = (Button) this.khv.findViewById(R.h.ckg);
        this.rMY = (ImageView) this.khv.findViewById(R.h.cRz);
        this.mKeyboard = (MyKeyboardWindow) this.khv.findViewById(R.h.cHC);
        this.npM = this.khv.findViewById(R.h.cHB);
        this.oYv = (TextView) this.khv.findViewById(R.h.content);
        this.rMZ = (TextView) this.khv.findViewById(R.h.cRA);
        this.oRW = (TextView) this.khv.findViewById(R.h.bPo);
        this.rzU = (TextView) this.khv.findViewById(R.h.cqn);
        this.rzU.getPaint().setFlags(16);
        this.rNa = (TextView) this.khv.findViewById(R.h.bsu);
        this.rNb = (FavourLayout) this.khv.findViewById(R.h.bPl);
        this.rNc = (ImageView) this.khv.findViewById(R.h.bsn);
        this.rNg = this.khv.findViewById(R.h.bPg);
        this.rNd = (TextView) this.khv.findViewById(R.h.clj);
        this.hBi = (ImageView) this.khv.findViewById(R.h.bBF);
        this.rNh = this.khv.findViewById(R.h.bsl);
        this.rNi = (TextView) this.khv.findViewById(R.h.cCC);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.hBi, e.getUsername());
        this.rNe = (EditHintPasswdView) this.khv.findViewById(R.h.bXJ);
        this.rNj = (ImageView) this.khv.findViewById(R.h.bVO);
        this.rNt = (TextView) this.khv.findViewById(R.h.cRu);
        this.rNu = this.khv.findViewById(R.h.bPT);
        this.rNv = (TextView) this.khv.findViewById(R.h.bPV);
        this.rNw = (ImageView) this.khv.findViewById(R.h.bPS);
        this.rNk = (TextView) this.khv.findViewById(R.h.byY);
        this.rNl = (TextView) this.khv.findViewById(R.h.cvf);
        this.rNm = this.khv.findViewById(R.h.bPf);
        this.rNn = (TextView) this.khv.findViewById(R.h.bPk);
        this.rNb.setVisibility(8);
    }

    @TargetApi(14)
    public void db(Context context) {
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.rMX.setEnabled(false);
        this.rMX.setTextColor(context.getResources().getColorStateList(R.e.aWe));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rNe);
        this.rNe.wFT = new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a(this) {
            final /* synthetic */ l rNF;

            {
                this.rNF = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    this.rNF.bvj();
                    g.oUh.i(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            }
        };
        this.rNe.requestFocus();
        TextView textView = (TextView) this.khv.findViewById(R.h.cRA);
        if (textView != null) {
            textView.setText(m.xY() ? context.getString(R.l.fjj) : context.getString(R.l.fji));
        }
        EditText editText = (EditText) this.khv.findViewById(R.h.cQh);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            AccessibilityDelegate cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ l rNF;

            {
                this.rNF = r1;
            }

            public final void onClick(View view) {
                if (!this.rNF.npM.isShown()) {
                    this.rNF.npM.setVisibility(0);
                }
            }
        });
        this.khv.findViewById(R.h.bkI).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ l rNF;

            {
                this.rNF = r1;
            }

            public final void onClick(View view) {
                if (this.rNF.npM.isShown()) {
                    this.rNF.npM.setVisibility(8);
                }
            }
        });
    }

    private void bvd() {
        boolean z;
        w.v("MicroMsg.WalletPwdDialog", "alvinluo updateFingerprintMode");
        this.rNz = 0;
        this.rNt.setVisibility(8);
        this.rNu.setVisibility(8);
        this.rNC = bg.NA();
        af btS = com.tencent.mm.plugin.wallet_core.model.m.btS();
        d dVar = com.tencent.mm.pluginsdk.l.a.sBC;
        if (btS == null || !dVar.auS()) {
            z = true;
        } else {
            z = dVar.avk();
        }
        w.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[]{Boolean.valueOf(z)});
        if ((this.oLz == null || !(this.oLz.sYh == 100000 || this.oLz.sYh == 100102)) && z) {
            if (this.oLz != null && this.oLz.sYh == 100001) {
                this.oLz.sYf = 1;
            }
            if (dVar == null || !dVar.auZ() || dVar.auU()) {
                z = false;
            } else {
                z = true;
            }
            w.v("MicroMsg.WalletPwdDialog", "alvinluo isDeviceSupportFp: %b", new Object[]{Boolean.valueOf(z)});
            boolean z2 = dVar != null && dVar.auS();
            if (z2 && z && this.rNy && !bvk()) {
                this.rNt.setVisibility(0);
                this.rNt.setText(getContext().getString(R.l.fjk));
                this.rNx = 1;
                this.rNu.setVisibility(0);
                this.rNw.setVisibility(0);
                this.rNe.setVisibility(8);
                this.npM.setVisibility(8);
                this.rMZ.setText(R.l.fje);
                if (this.oLz != null) {
                    this.oLz.sYf = 1;
                }
                bvf();
                g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else if (z2 && z && this.rNy && bvk()) {
                this.rNt.setText(getContext().getString(R.l.ffL));
                this.rNt.setVisibility(0);
                this.rNx = 0;
                this.rNu.setVisibility(8);
                this.rNe.setVisibility(0);
                if (!this.npM.isShown()) {
                    this.npM.setVisibility(0);
                }
                this.rMZ.setText(R.l.fji);
                if (this.oLz != null) {
                    this.oLz.sYf = 0;
                }
                g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                e.CM(8);
            } else {
                if (this.oLz != null) {
                    this.oLz.sYf = 0;
                }
                this.rNt.setVisibility(8);
                g.oUh.i(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            }
            w.i("MicroMsg.WalletPwdDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.rNy + ", isForcePwdMode:" + bvk());
            this.rNt.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ l rNF;

                {
                    this.rNF = r1;
                }

                public final void onClick(View view) {
                    if (this.rNF.rNx == 0) {
                        l.a(this.rNF);
                    } else if (this.rNF.rNx == 1) {
                        this.rNF.bve();
                    }
                    if (this.rNF.rNx == 1) {
                        l.bvg();
                        if (l.c(this.rNF)) {
                            this.rNF.bvf();
                        }
                    }
                }
            });
            return;
        }
        if (!this.npM.isShown()) {
            this.npM.setVisibility(0);
        }
        if (this.oLz != null) {
            this.oLz.sYf = 0;
            this.oLz.fLU = "";
            this.oLz.fLV = "";
        }
        this.rNu.setVisibility(0);
        this.rNv.setVisibility(0);
        TextView textView = this.rNv;
        int i = (this.oLz == null || this.oLz.sYh != 100102) ? R.l.ffK : R.l.ffM;
        textView.setText(i);
        this.rNv.setTextColor(getContext().getResources().getColor(R.e.aWo));
        if (z) {
            this.rNh.setVisibility(8);
            this.rNi.setVisibility(8);
        } else {
            this.rNh.setVisibility(0);
            this.rNi.setVisibility(0);
        }
        if (this.oLz != null && this.oLz.sYh == 100102) {
            h.vI().vr().a(com.tencent.mm.storage.w.a.uBj, Boolean.valueOf(true));
            dVar.ek(false);
            h.vI().vr().a(com.tencent.mm.storage.w.a.uBh, Boolean.valueOf(false));
        }
        g.oUh.i(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }

    private void bve() {
        this.rNt.setText(getContext().getString(R.l.ffL));
        this.rNx = 0;
        this.rNC = bg.NA();
        this.rNu.setVisibility(8);
        this.rNe.setVisibility(0);
        if (!this.npM.isShown()) {
            this.npM.setVisibility(0);
        }
        this.rMZ.setText(R.l.fji);
        iI(true);
        this.oLz.sYf = 0;
        g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        e.CM(29);
        bvg();
    }

    private void bvf() {
        com.tencent.mm.plugin.soter.c.a.blS();
        final com.tencent.mm.sdk.b.b koVar = new ko();
        koVar.fQZ.fLT = this.oLz.fJH;
        koVar.fQZ.fRb = 1;
        koVar.fQZ.fRd = new Runnable(this) {
            final /* synthetic */ l rNF;

            public final void run() {
                w.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
                com.tencent.mm.e.a.ko.b bVar = koVar.fRa;
                if (bVar == null) {
                    this.rNF.oLz.sYf = 0;
                    w.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    return;
                }
                int i = bVar.errCode;
                w.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), bVar.fPf});
                if (i == 0) {
                    w.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[]{bVar.fRe});
                    this.rNF.oLz.sYf = 1;
                    this.rNF.oLz.fLU = bVar.fLU;
                    this.rNF.oLz.fLV = bVar.fLV;
                    this.rNF.oLz.fRe = bVar.fRe;
                    this.rNF.oLz.fLS = bVar.fLS;
                    PayInfo payInfo = this.rNF.oLz;
                    payInfo.sYg++;
                    this.rNF.rNv.setText("");
                    this.rNF.bvj();
                    g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
                    com.tencent.mm.plugin.soter.c.a.us(0);
                    return;
                }
                boolean z;
                w.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                this.rNF.oLz.sYf = 0;
                this.rNF.rNu.setVisibility(0);
                this.rNF.rNv.setTextColor(this.rNF.getContext().getResources().getColor(R.e.aVD));
                this.rNF.rNv.setText(R.l.ffJ);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int e = currentTimeMillis - this.rNF.lOS;
                if (e > 1) {
                    this.rNF.lOS = currentTimeMillis;
                    this.rNF.rNz = this.rNF.rNz + 1;
                    payInfo = this.rNF.oLz;
                    payInfo.sYg++;
                }
                g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
                boolean z2 = i == 2 || i == 10308;
                if (bVar.fRf == 2) {
                    z = true;
                } else {
                    z = false;
                }
                w.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[]{Boolean.valueOf(z2), Integer.valueOf(this.rNF.rNz), Integer.valueOf(i), Boolean.valueOf(z)});
                if ((z || (this.rNF.rNz < 3 && e > 1)) && !z2) {
                    w.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
                    if (this.rNF.rNA == null) {
                        this.rNF.rNA = com.tencent.mm.ui.c.a.eH(this.rNF.getContext());
                    }
                    this.rNF.rNw.setVisibility(8);
                    this.rNF.rNv.setVisibility(4);
                    this.rNF.rNA.reset();
                    this.rNF.rNA.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass5 rNH;

                        {
                            this.rNH = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                            w.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
                            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 rNI;

                                {
                                    this.rNI = r1;
                                }

                                public final void run() {
                                    this.rNI.rNH.rNF.rNv.setVisibility(0);
                                }
                            });
                        }

                        public final void onAnimationEnd(Animation animation) {
                            w.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
                            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 rNI;

                                {
                                    this.rNI = r1;
                                }

                                public final void run() {
                                    this.rNI.rNH.rNF.rNv.setVisibility(8);
                                    this.rNI.rNH.rNF.rNw.setVisibility(0);
                                }
                            });
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    this.rNF.rNv.startAnimation(this.rNF.rNA);
                    com.tencent.mm.plugin.soter.c.a.us(1);
                } else if (this.rNF.rNz >= 3 || z2) {
                    w.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
                    l.bvg();
                    this.rNF.rNx = 0;
                    this.rNF.rNC = bg.NA();
                    this.rNF.rNt.setVisibility(8);
                    this.rNF.rNu.setVisibility(8);
                    this.rNF.rNv.setVisibility(0);
                    this.rNF.rNv.setText(R.l.ffK);
                    this.rNF.rNv.setTextColor(this.rNF.getContext().getResources().getColor(R.e.aWo));
                    this.rNF.rMZ.setText(R.l.fji);
                    this.rNF.rNe.setVisibility(0);
                    if (!this.rNF.npM.isShown()) {
                        this.rNF.npM.setVisibility(0);
                    }
                    com.tencent.mm.plugin.soter.c.a.us(2);
                    l.iI(true);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(koVar, Looper.getMainLooper());
    }

    private static void bvg() {
        w.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.urY.m(new mg());
    }

    public int bvh() {
        return R.i.dqD;
    }

    private void iG(boolean z) {
        View findViewById = this.khv.findViewById(R.h.brW);
        if (findViewById == null) {
            return;
        }
        if (z) {
            findViewById.setVisibility(0);
            this.rND = true;
            return;
        }
        findViewById.setVisibility(8);
        this.rND = false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.FU != null) {
                this.FU.onCancel(this);
            }
            if (this.rNo != null) {
                this.rNo.aQt();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.khv);
        f.cfX().cfY();
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.ppy = z;
        setCanceledOnTouchOutside(this.ppy);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e.getMessage());
        }
        bvg();
        this.rwv.destory();
        if (this.lOR != null) {
            this.lOR.cancel();
        }
    }

    public final void Ip(String str) {
        this.oYv.setText(str);
    }

    public final void Iq(String str) {
        if (TextUtils.isEmpty(str)) {
            this.oRW.setVisibility(8);
            return;
        }
        this.oRW.setVisibility(0);
        this.oRW.setText(str);
    }

    private void Ir(String str) {
        if (TextUtils.isEmpty(str)) {
            w.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
            this.rNk.setVisibility(8);
            return;
        }
        this.rNk.setVisibility(0);
        this.rNk.setText(str);
    }

    public final void dO(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.rNd.setVisibility(8);
        } else {
            this.rNd.setVisibility(0);
            this.rNd.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.rNn.setVisibility(8);
            return;
        }
        this.rNn.setText(str);
        this.rNn.setVisibility(0);
    }

    public final void Is(String str) {
        if (TextUtils.isEmpty(str)) {
            this.rzU.setVisibility(8);
            return;
        }
        this.rzU.setVisibility(0);
        this.rzU.setText(str);
    }

    private void f(Bankcard bankcard) {
        if (bankcard == null) {
            w.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
        } else if (bankcard.btA()) {
            this.rNc.setImageResource(R.g.blG);
        } else if (bankcard.btB()) {
            this.rwv.a(bankcard, this.rNc);
        } else {
            this.rwv.a(getContext(), bankcard, this.rNc);
        }
    }

    public final void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.rNh.setVisibility(8);
            this.rNi.setVisibility(8);
            return;
        }
        this.rNh.setOnClickListener(onClickListener);
        this.rNa.setText(str);
        if (this.rNr) {
            this.rNh.setVisibility(0);
            this.rNi.setVisibility(0);
        } else {
            this.rNh.setVisibility(8);
            this.rNi.setVisibility(8);
        }
        if (z) {
            this.rNg.setVisibility(0);
        } else {
            this.rNg.setVisibility(8);
        }
    }

    public final void a(final Context context, final Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        this.rzJ = b.rJj.a(orders);
        if (orders == null || orders.rGf == null || orders.rGf.rxQ == null || orders.rGf.rxQ.size() <= 0 || this.rzJ == null) {
            this.rNd.setVisibility(8);
            return;
        }
        if (favorPayInfo == null) {
            this.rzg = this.rzJ.Il(orders.rGf.rxP);
        } else {
            this.rzg = favorPayInfo;
        }
        this.rNd.setVisibility(0);
        if (this.rNh != null) {
            this.rNh.setTag(this.rzg);
        }
        this.rNs = bankcard;
        this.rNm.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ l rNF;

            public final void onClick(View view) {
                this.rNF.rNj.setVisibility(8);
                h.a(context, orders, this.rNF.rzg.rFm, new com.tencent.mm.plugin.wallet_core.ui.h.b(this) {
                    final /* synthetic */ AnonymousClass6 rNK;

                    {
                        this.rNK = r1;
                    }

                    public final void a(FavorPayInfo favorPayInfo) {
                        List list;
                        String o;
                        String string;
                        String str;
                        String str2;
                        String str3;
                        String str4 = null;
                        this.rNK.rNF.rzg = favorPayInfo;
                        this.rNK.rNF.rNq = false;
                        int i = this.rNK.rNF.rzg.rFn;
                        String str5 = this.rNK.rNF.rzg.rFo;
                        ArrayList it = com.tencent.mm.plugin.wallet_core.model.m.btS().it(true);
                        if (i != 0) {
                            List arrayList = new ArrayList();
                            for (int i2 = 0; i2 < it.size(); i2++) {
                                boolean z;
                                if (bg.mA(str5)) {
                                    if (!((Bankcard) it.get(i2)).field_bankcardType.equals("CFT")) {
                                        z = true;
                                    }
                                    z = false;
                                } else {
                                    if (((Bankcard) it.get(i2)).field_bankcardType.equals(str5)) {
                                        z = true;
                                    }
                                    z = false;
                                }
                                if (z) {
                                    arrayList.add((Bankcard) it.get(i2));
                                }
                            }
                            list = arrayList;
                        } else {
                            list = it;
                        }
                        this.rNK.rNF.rzg.rFq = "";
                        if (a.a(this.rNK.rNF.rzg, this.rNK.rNF.rNs)) {
                            this.rNK.rNF.rNq = true;
                            if (list.size() == 0) {
                                this.rNK.rNF.rzg.rFq = context.getString(R.l.ffG);
                            } else {
                                this.rNK.rNF.rzg.rFq = context.getString(R.l.ffH);
                            }
                            this.rNK.rNF.dismiss();
                            if (this.rNK.rNF.rNf != null) {
                                this.rNK.rNF.rNf.a(this.rNK.rNF.rNe.getText(), this.rNK.rNF.rzg, this.rNK.rNF.rNq);
                                return;
                            }
                        }
                        if (this.rNK.rNF.rNh != null) {
                            this.rNK.rNF.rNh.setTag(this.rNK.rNF.rzg);
                        }
                        com.tencent.mm.plugin.wallet.a.h Ii = this.rNK.rNF.rzJ.Ii(this.rNK.rNF.rzg.rFm);
                        if (Ii == null || Ii.rxW <= 0.0d) {
                            o = e.o(orders.rGf.rxM);
                            string = context.getString(R.l.fjf);
                            str = null;
                            str2 = null;
                            str3 = o;
                        } else {
                            str = e.o(Ii.rxV);
                            str2 = e.o(orders.rGf.rxM);
                            str3 = str;
                            string = null;
                            str = Ii.rxY;
                        }
                        if (Ii == null || Ii.rxX == 0) {
                            o = null;
                        } else {
                            o = Ii.rxZ;
                            if (!bg.mA(str)) {
                                o = "," + o;
                            }
                        }
                        if (bg.mA(str) && bg.mA(o)) {
                            str4 = string;
                        } else if (!bg.mA(string)) {
                            str4 = "," + string;
                        }
                        this.rNK.rNF.Iq(str3);
                        this.rNK.rNF.Is(str2);
                        this.rNK.rNF.dO(str, str4);
                        l lVar = this.rNK.rNF;
                        str = orders.oga;
                        lVar.It(o);
                    }
                });
            }
        });
        Assert.assertNotNull(this.rzJ);
        a aVar = this.rzJ;
        String str = this.rzg.rFm;
        if (aVar.rJf.get(str) != null) {
            int i;
            ArrayList it = com.tencent.mm.plugin.wallet_core.model.m.btS().it(true);
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            for (i = 0; i < it.size(); i++) {
                hashMap.put(((Bankcard) it.get(i)).field_bankcardType, Integer.valueOf(0));
            }
            if (aVar.rJd.rxQ != null) {
                for (i = 0; i < aVar.rJd.rxQ.size(); i++) {
                    p pVar = (p) aVar.rJd.rxQ.get(i);
                    if (pVar != null) {
                        if (!((pVar.ryA != 0 ? 1 : null) == null || hashMap.containsKey(pVar.ryB) || bg.mA(pVar.ryB))) {
                            hashMap2.put(pVar.rxJ, Integer.valueOf(0));
                        }
                    }
                }
            }
            double d = ((com.tencent.mm.plugin.wallet.a.h) aVar.rJf.get(str)).rxW;
            if (aVar.rJd.rxR != null && aVar.rJd.rxR.ryb != null) {
                List list = aVar.rJd.rxR.ryb;
                i = 0;
                while (i < list.size()) {
                    com.tencent.mm.plugin.wallet.a.h hVar = (com.tencent.mm.plugin.wallet.a.h) list.get(i);
                    if (hVar != null) {
                        Object obj;
                        String[] Ij = a.Ij(hVar.ryd);
                        for (int length = Ij.length - 1; length >= 0; length--) {
                            if (hashMap2.containsKey(Ij[length])) {
                                obj = 1;
                                w.v("MicroMsg.FavorLogicHelper", "hasNotSupportFavor favid:" + Ij[length]);
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null && ((com.tencent.mm.plugin.wallet.a.h) list.get(i)).rxW > d) {
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        this.rNj.setVisibility(8);
    }

    public final void bvi() {
        if (this.rMX != null) {
            this.rNp = null;
            this.rMX.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ l rNF;

                {
                    this.rNF = r1;
                }

                public final void onClick(View view) {
                    this.rNF.bvj();
                }
            });
        }
    }

    public void bvj() {
        iI(false);
        if (this.rNp != null) {
            this.rNp.onClick(this, 0);
        }
        dismiss();
        if (this.rNf != null) {
            this.rNf.a(this.rNe.getText(), this.rzg, this.rNq);
        }
        if (this.rNC < 0) {
            w.e("MicroMsg.WalletPwdDialog", "hy: not set update mode time yet. abandon");
        } else if (this.rNx == 0) {
            g.oUh.a(686, 0, 1, false);
            g.oUh.a(686, 1, bg.aB(this.rNC), false);
        } else if (this.rNx == 1) {
            g.oUh.a(686, 2, 1, false);
            g.oUh.a(686, 3, bg.aB(this.rNC), false);
        }
    }

    public final void b(final OnCancelListener onCancelListener) {
        if (this.rMY != null) {
            this.FU = onCancelListener;
            this.rMY.setVisibility(0);
            this.rMY.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ l rNF;

                public final void onClick(View view) {
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(null);
                    }
                    if (this.rNF.rNo != null) {
                        this.rNF.rNo.aQt();
                    }
                    this.rNF.cancel();
                    if (this.rNF.rNt.isShown()) {
                        g.oUh.i(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                        return;
                    }
                    g.oUh.i(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
    }

    public final void iH(boolean z) {
        if (z) {
            this.rNh.setVisibility(0);
        } else {
            this.rNh.setVisibility(8);
        }
    }

    private void an(LinkedList<String> linkedList) {
        if (this.rNb == null) {
            return;
        }
        if (linkedList == null || linkedList.size() <= 0) {
            this.rNb.setVisibility(8);
            return;
        }
        this.rNb.ao(linkedList);
        this.rNb.setVisibility(0);
    }

    public final void It(String str) {
        if (bg.mA(str)) {
            this.rNl.setVisibility(8);
            return;
        }
        this.rNl.setText(str);
        this.rNl.setVisibility(0);
    }

    public final void aWw() {
        if (this.rNe != null) {
            this.rNe.aWw();
        }
    }

    public static l a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        return a(context, true, orders, favorPayInfo, bankcard, payInfo, null, cVar, onClickListener, onCancelListener);
    }

    public static l a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, String str, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (orders == null || orders.rGe == null || orders.rGe.size() <= 0) {
            return null;
        }
        String av;
        String str2;
        List buM;
        String string;
        String string2;
        String string3;
        String str3;
        boolean z2;
        String string4;
        a a = b.rJj.a(orders);
        if (a != null) {
            if (favorPayInfo != null && bankcard != null) {
                boolean z3 = false;
                if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                    z3 = true;
                }
                av = a.av(favorPayInfo.rFm, z3);
                Map hashMap = new HashMap();
                if (a.rJd.rxR == null || a.rJd.rxR.ryb == null) {
                    w.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
                } else {
                    double d;
                    List list = a.rJd.rxR.ryb;
                    if (a.rJf.containsKey(av)) {
                        d = ((com.tencent.mm.plugin.wallet.a.h) a.rJf.get(av)).rye;
                    } else {
                        d = 0.0d;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        com.tencent.mm.plugin.wallet.a.h hVar = (com.tencent.mm.plugin.wallet.a.h) list.get(i);
                        str2 = null;
                        if (av.equals("0") && !hVar.equals("0")) {
                            str2 = hVar.ryd;
                        } else if (hVar.ryd.startsWith(av) && !av.equals(hVar.ryd)) {
                            str2 = hVar.ryd.replace(av + "-", "");
                        }
                        String[] Ij = a.Ij(str2);
                        if (Ij != null && Ij.length > 0) {
                            p pVar = (p) a.rJe.get(Ij[0]);
                            if (pVar != null) {
                                if ((pVar.ryA != 0 ? 1 : null) != null && pVar.ryD.size() > 0) {
                                    Iterator it = pVar.ryD.iterator();
                                    while (it.hasNext()) {
                                        String a2 = n.a((com.tencent.mm.bd.b) it.next());
                                        com.tencent.mm.plugin.wallet_core.ui.a.a aVar = (com.tencent.mm.plugin.wallet_core.ui.a.a) hashMap.get(a2);
                                        if (aVar == null || hVar.rye > aVar.rJg.rye) {
                                            aVar = new com.tencent.mm.plugin.wallet_core.ui.a.a();
                                            aVar.rJg = hVar;
                                            aVar.ofY = pVar.ofY;
                                            aVar.rJh = hVar.rye - d;
                                            aVar.rJi = pVar.ryB;
                                            hashMap.put(a2, aVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.tencent.mm.plugin.wallet_core.ui.a.a aVar2 = (com.tencent.mm.plugin.wallet_core.ui.a.a) hashMap.get(bankcard.field_bindSerial);
                com.tencent.mm.plugin.wallet_core.ui.a.a aVar3 = (com.tencent.mm.plugin.wallet_core.ui.a.a) a.au(av, true).get(bankcard.field_bankcardType);
                if (aVar2 != null && aVar2.rJg != null && !bg.mA(aVar2.rJg.ryd)) {
                    favorPayInfo.rFm = aVar2.rJg.ryd;
                } else if (aVar3 == null || aVar3.rJg == null || bg.mA(aVar3.rJg.ryd)) {
                    favorPayInfo.rFm = av;
                } else {
                    favorPayInfo.rFm = aVar3.rJg.ryd;
                }
            } else if (orders.rGf != null) {
                favorPayInfo = a.Il(a.Im(orders.rGf.rxP));
            }
            buM = a.buM();
        } else {
            w.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            buM = null;
        }
        String str4 = "";
        Object[] objArr;
        if (payInfo.fRv == 32 || payInfo.fRv == 33) {
            string = payInfo.sYe.getString("extinfo_key_5", "");
            string2 = payInfo.sYe.getString("extinfo_key_1", "");
            string3 = context.getString(R.l.fjh);
            if (bg.mA(string)) {
                string = string3;
                string3 = str4;
            } else {
                string3 = string;
            }
            if (bg.mA(string2)) {
                w.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                str4 = string3;
            } else {
                ap.yY();
                x Ra = com.tencent.mm.u.c.wR().Ra(string2);
                if (Ra != null) {
                    string3 = Ra.tL();
                    objArr = new Object[1];
                    StringBuilder append = new StringBuilder().append(e.UQ(string3));
                    if (bg.mA(str)) {
                        string3 = "";
                    } else {
                        string3 = "(" + str + ")";
                    }
                    objArr[0] = append.append(string3).toString();
                    str4 = bg.i(string, objArr);
                } else {
                    w.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + string2);
                    str4 = string3;
                }
            }
        } else if (payInfo.fRv == 31) {
            string = payInfo.sYe.getString("extinfo_key_1", "");
            if (bg.mA(string)) {
                w.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                ap.yY();
                r6 = com.tencent.mm.u.c.wR().Ra(string);
                if (r6 != null) {
                    string = r6.tK();
                    r6 = R.l.fjh;
                    objArr = new Object[1];
                    objArr[0] = string + (bg.mA(str) ? "" : "(" + str + ")");
                    str4 = context.getString(r6, objArr);
                } else {
                    w.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + string);
                }
            }
        } else if (payInfo.fRv == 42) {
            string = payInfo.sYe.getString("extinfo_key_1", "");
            if (bg.mA(string)) {
                w.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                ap.yY();
                r6 = com.tencent.mm.u.c.wR().Ra(string);
                if (r6 != null) {
                    string = r6.tK();
                    r6 = R.l.fjd;
                    objArr = new Object[1];
                    objArr[0] = string + (bg.mA(str) ? "" : "(" + str + ")");
                    str4 = context.getString(r6, objArr);
                } else {
                    w.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + string);
                }
            }
        }
        if (!bg.mA(str4) || orders == null || orders.rGe == null) {
            w.w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
            str3 = str4;
        } else {
            Commodity commodity = (Commodity) orders.rGe.get(0);
            if (commodity != null) {
                string3 = commodity.ofP;
                Object obj = (payInfo == null || !(payInfo.fRv == 31 || payInfo.fRv == 32 || payInfo.fRv == 33)) ? null : 1;
                if (obj != null) {
                    if (!bg.mA(string3)) {
                        string3 = string3 + "\n";
                    }
                    string3 = string3 + commodity.desc;
                }
                if (bg.mA(string3)) {
                    string3 = commodity.desc;
                }
            } else {
                string3 = str4;
            }
            str3 = string3;
        }
        string = null;
        if (a == null || favorPayInfo == null) {
            str2 = null;
            string3 = null;
            str4 = null;
            string2 = null;
            z2 = false;
        } else {
            com.tencent.mm.plugin.wallet.a.h Ii = a.Ii(favorPayInfo.rFm);
            if (Ii != null && Ii.rxW > 0.0d) {
                z2 = true;
                string2 = e.d(orders.rFM, orders.oga);
                str2 = e.d(Ii.rxV, orders.oga);
                str4 = Ii.rxY;
                if (rNE.containsKey(payInfo.fJH)) {
                    string3 = str4;
                    str4 = string2;
                    string2 = str2;
                    str2 = null;
                } else {
                    g.oUh.i(14530, new Object[]{Integer.valueOf(3)});
                    string3 = str4;
                    str4 = string2;
                    string2 = str2;
                    str2 = null;
                }
            } else if (buM == null || buM.size() <= 0) {
                z2 = false;
                str4 = null;
                string2 = e.d(orders.rFM, orders.oga);
                str2 = null;
                string3 = null;
            } else {
                z2 = true;
                string3 = null;
                str4 = null;
                string2 = e.d(Ii.rxV, orders.oga);
                str2 = context.getString(R.l.fjf);
            }
            if (!(Ii == null || Ii.rxX == 0)) {
                string = Ii.rxZ;
                if (!bg.mA(string3)) {
                    string = "," + string;
                }
            }
            if (!(bg.mA(string3) && bg.mA(r4))) {
                if (bg.mA(str2)) {
                    str2 = null;
                } else {
                    str2 = "," + str2;
                }
            }
        }
        if (orders.oQs > 0.0d) {
            Resources resources = context.getResources();
            int i2 = R.l.feU;
            Object[] objArr2 = new Object[1];
            objArr2[0] = e.d(orders.oQs, orders.oga);
            string4 = resources.getString(i2, objArr2);
        } else {
            string4 = null;
        }
        if (bankcard == null) {
            av = "";
        } else {
            av = bankcard.field_desc;
        }
        final Dialog lVar = new l(context);
        lVar.a(context, orders, favorPayInfo, bankcard);
        lVar.iH(z);
        lVar.rNr = z;
        lVar.bvi();
        lVar.b(new b(onCancelListener));
        lVar.setOnCancelListener(new b(onCancelListener));
        lVar.setCancelable(true);
        lVar.Ip(str3);
        lVar.Iq(string2);
        lVar.Is(str4);
        final PayInfo payInfo2 = payInfo;
        final View.OnClickListener onClickListener2 = onClickListener;
        lVar.a(av, new View.OnClickListener() {
            public final void onClick(View view) {
                l.rNE.put(payInfo2.fJH, Boolean.valueOf(true));
                onClickListener2.onClick(view);
                if (lVar.rND) {
                    g.oUh.i(14530, new Object[]{Integer.valueOf(2)});
                }
            }
        }, z2);
        lVar.f(bankcard);
        boolean z4 = orders.rGc == 1;
        lVar.oLz = payInfo;
        lVar.rNy = z4;
        if (!m.xY()) {
            lVar.bvd();
        }
        lVar.dO(string3, str2);
        str2 = orders.oga;
        lVar.It(string);
        lVar.Ir(string4);
        lVar.rNf = cVar;
        lVar.an(a(bankcard, orders));
        if (a(bankcard, orders, payInfo.fJH)) {
            lVar.iG(true);
            g.oUh.i(14530, new Object[]{Integer.valueOf(1)});
        } else {
            lVar.iG(false);
        }
        lVar.show();
        com.tencent.mm.ui.base.g.a(context, lVar);
        return lVar;
    }

    private static LinkedList<String> a(Bankcard bankcard, Orders orders) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(orders == null || orders.rGf == null || orders.rGf.rya == null)) {
            Iterator it = orders.rGf.rya.rxE.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.ofe.equals(bankcard.field_bindSerial)) {
                    it = bVar.rxG.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wallet.a.c cVar = (com.tencent.mm.plugin.wallet.a.c) it.next();
                        if (cVar.rxI != 0) {
                            linkedList.add(cVar.rxH);
                        }
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    private static boolean a(Bankcard bankcard, Orders orders, String str) {
        if (rNE.containsKey(str) || orders.rGf == null || orders.rGf.rya == null) {
            return false;
        }
        boolean z;
        if (orders.rGf.rya.rxE.size() > 0) {
            Iterator it = orders.rGf.rya.rxE.iterator();
            z = false;
            while (it.hasNext()) {
                boolean z2;
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.ofe == null || !bVar.ofe.equals(bankcard.field_bindSerial)) {
                    z2 = z;
                } else {
                    z2 = true;
                }
                z = z2;
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        if (orders.rGf.rya.rxE.size() > 0) {
            return true;
        }
        if (orders.rGf.rya.rxF == null || orders.rGf.rya.rxF.ryg.size() <= 0) {
            return false;
        }
        return true;
    }

    public static l a(Context context, String str, String str2, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        return a(context, str, str2, "", cVar, onCancelListener, aVar);
    }

    public static l a(Context context, String str, String str2, String str3, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        l lVar = new l(context);
        lVar.bvi();
        lVar.b(onCancelListener);
        lVar.setOnCancelListener(onCancelListener);
        lVar.setCancelable(true);
        lVar.Ip(str);
        lVar.Iq(str2);
        lVar.iH(false);
        lVar.rNr = false;
        lVar.rNo = aVar;
        lVar.Ir(str3);
        lVar.rNf = cVar;
        lVar.show();
        com.tencent.mm.ui.base.g.a(context, lVar);
        return lVar;
    }

    public static l a(Context context, String str, double d, String str2, Bankcard bankcard, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        boolean z = true;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        Dialog lVar = new l(context);
        lVar.bvi();
        lVar.b(onCancelListener);
        lVar.setOnCancelListener(onCancelListener);
        lVar.setCancelable(true);
        lVar.Ip(str);
        lVar.Iq(e.d(d, str2));
        lVar.rNr = true;
        String str3 = bankcard == null ? "" : bankcard.field_desc;
        lVar.f(bankcard);
        if (TextUtils.isEmpty(str3)) {
            z = false;
        }
        lVar.iH(z);
        if (bankcard != null) {
            lVar.a(str3, onClickListener, false);
        }
        lVar.rNf = cVar;
        lVar.show();
        com.tencent.mm.ui.base.g.a(context, lVar);
        return lVar;
    }

    public final void buN() {
        this.isPaused = false;
        if (!m.xY() && this.rNx == 1) {
            bvf();
        }
    }

    public final void buO() {
        this.isPaused = true;
        if (!m.xY() && this.rNx == 1) {
            bve();
        }
    }

    private static void iI(boolean z) {
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uBd, Boolean.valueOf(z));
    }

    private static boolean bvk() {
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBd, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
