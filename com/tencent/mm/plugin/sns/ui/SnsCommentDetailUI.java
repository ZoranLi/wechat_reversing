package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mm.e.a.ge;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.ml;
import com.tencent.mm.e.a.pb;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.e.a.pl;
import com.tencent.mm.e.a.pm;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.a.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsCommentDetailUI extends MMActivity implements com.tencent.mm.plugin.sns.b.g.a, com.tencent.mm.plugin.sns.model.b.b, e {
    public static int qzV = 34;
    private String fVJ;
    private String gKJ;
    private boolean iLs = false;
    private com.tencent.mm.sdk.b.c iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jc jcVar = (jc) bVar;
            if (jcVar instanceof jc) {
                switch (jcVar.fPc.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.qAs.bjW();
                        break;
                }
            }
            return false;
        }
    };
    private int jNY = 0;
    private l kmS;
    private int knu;
    private ClipboardManager lMa;
    private OnClickListener mAD = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r1;
        }

        public final void onClick(View view) {
            w.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(this.qAs, view);
        }
    };
    private int mScreenHeight;
    private int mScreenWidth;
    private String nTE = "";
    private LinearLayout pSl;
    private Dialog qAa = null;
    private af qAb = new af();
    private com.tencent.mm.sdk.b.c qAc = new com.tencent.mm.sdk.b.c<pk>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = pk.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pk pkVar = (pk) bVar;
            if (pkVar instanceof pk) {
                String str = pkVar.fWn.id;
                String str2 = pkVar.fWn.result;
                String str3 = pkVar.fWn.fWo;
                if (pkVar.fWn.type == 1) {
                    SnsCommentDetailUI.a(this.qAs, str, str2, str3);
                } else if (pkVar.fWn.type == 2) {
                    SnsCommentDetailUI.a(this.qAs, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qAd = new com.tencent.mm.sdk.b.c<pl>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = pl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pl plVar = (pl) bVar;
            if (plVar instanceof pl) {
                String str = plVar.fWp.id;
                if (plVar.fWp.type == 1) {
                    SnsCommentDetailUI.b(this.qAs, str);
                } else if (plVar.fWp.type == 2) {
                    SnsCommentDetailUI.c(this.qAs, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qAe = new com.tencent.mm.sdk.b.c<pm>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = pm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pm pmVar = (pm) bVar;
            if (pmVar instanceof pm) {
                String str = pmVar.fWq.id;
                if (pmVar.fWq.type == 1) {
                    SnsCommentDetailUI.d(this.qAs, str);
                } else if (pmVar.fWq.type == 2) {
                    SnsCommentDetailUI.e(this.qAs, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qAf = new com.tencent.mm.sdk.b.c<gg>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = gg.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gg ggVar = (gg) bVar;
            if (ggVar instanceof gg) {
                SnsCommentDetailUI.a(this.qAs, ggVar.fLx.fLA, ggVar.fLx.fLz, ggVar);
            }
            return false;
        }
    };
    private c qAg = new c(this);
    private OnClickListener qAh = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r1;
        }

        public final void onClick(View view) {
            String str = (String) view.getTag();
            w.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:" + str);
            Intent intent = new Intent();
            m e = this.qAs.hJ(true);
            if (e.tE(32)) {
                k cVar = new com.tencent.mm.plugin.sns.a.a.c(e.bhH(), 1, 2, "", e.bhL());
                h.vJ();
                h.vH().gXC.a(cVar, 0);
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 37);
                com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qAs);
                return;
            }
            intent.putExtra("Contact_User", str);
            com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qAs);
        }
    };
    private OnClickListener qAi = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r1;
        }

        public final void onClick(View view) {
            w.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            this.qAs.bjV();
            if (this.qAs.qzI) {
                this.qAs.hI(true);
            }
        }
    };
    private com.tencent.mm.sdk.b.c qAj = new com.tencent.mm.sdk.b.c<pb>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = pb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.qAs.bjU();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qAk = new com.tencent.mm.sdk.b.c<ge>(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r2;
            this.usg = ge.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return false;
        }
    };
    boolean qAl = false;
    private LinearLayout qAm = null;
    private boolean qAn = false;
    PhotosContent qAo = null;
    int qAp = 0;
    public com.tencent.mm.u.ag.b.a qAq = new com.tencent.mm.u.ag.b.a(this) {
        final /* synthetic */ SnsCommentDetailUI qAs;

        {
            this.qAs = r1;
        }

        public final void p(String str, final boolean z) {
            new ae(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass19 qAw;

                public final void run() {
                    if (z && !this.qAw.qAs.isFinishing() && this.qAw.qAs.qAp < 5) {
                        this.qAw.qAs.bjU();
                    }
                    SnsCommentDetailUI snsCommentDetailUI = this.qAw.qAs;
                    snsCommentDetailUI.qAp++;
                }
            }, 500);
        }
    };
    private be qAr = null;
    private boolean qqa;
    private SnsCommentFooter qqb;
    private an qqd;
    private c qqj;
    private com.tencent.mm.plugin.sns.f.b qqk;
    private p qqm = null;
    private g qri;
    private OnTouchListener qtw = bg.bJY();
    private View qzA;
    private b qzB;
    private ScaleAnimation qzC;
    private ScaleAnimation qzD;
    LinearLayout qzE;
    LinearLayout qzF;
    private LinkedList<bba> qzG;
    private int qzH = -1;
    private boolean qzI = false;
    private aq qzJ;
    private String qzK;
    private ar qzL;
    private int qzM = 0;
    private ImageView qzN;
    private j qzO;
    private boolean qzP = false;
    private long qzQ = 0;
    private bf qzR;
    private boolean qzS = false;
    private int qzT;
    private int qzU = 103;
    public int qzW = com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX;
    private com.tencent.mm.plugin.sns.ui.b.b qzX;
    private SnsTranslateResultView qzY;
    private boolean qzZ = false;
    private long qzt = 0;
    private long qzu = 0;
    private View qzv;
    private TextView qzw;
    private LinearLayout qzx;
    private SnsDetailLuckyHeader qzy;
    private ListView qzz;

    class AnonymousClass32 implements AnimationListener {
        boolean qAJ = false;
        final /* synthetic */ LinearLayout qAK;
        final /* synthetic */ SnsCommentDetailUI qAs;

        AnonymousClass32(SnsCommentDetailUI snsCommentDetailUI, LinearLayout linearLayout) {
            this.qAs = snsCommentDetailUI;
            this.qAK = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.qAK != null) {
                this.qAK.setPressed(false);
            }
            if (!this.qAJ) {
                this.qAJ = true;
                if (this.qAs.qzA != null) {
                    this.qAs.qzA.clearAnimation();
                    this.qAs.qzA.setVisibility(8);
                }
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    class b extends BaseAdapter {
        Activity activity;
        String fGN;
        public LinkedList<bba> qAQ;
        LinkedList<bba> qAR;
        final /* synthetic */ SnsCommentDetailUI qAs;

        class a {
            ImageView ipv;
            TextView iuD;
            TextView lle;
            TextView ovh;
            final /* synthetic */ b qAS;
            SnsTranslateResultView qAT;
            Object qAU;
            bba qAV;
            String userName;

            a(b bVar) {
                this.qAS = bVar;
            }
        }

        public b(SnsCommentDetailUI snsCommentDetailUI, LinkedList<bba> linkedList, LinkedList<bba> linkedList2, Activity activity, String str) {
            this.qAs = snsCommentDetailUI;
            this.qAQ = linkedList;
            this.qAR = linkedList2;
            this.activity = activity;
            this.fGN = str;
        }

        public final int getCount() {
            int i = 0;
            if (this.qAR.size() > 0) {
                if (this.qAQ != null) {
                    i = this.qAQ.size();
                }
                return i + 1;
            } else if (this.qAQ != null) {
                return this.qAQ.size();
            } else {
                return 0;
            }
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence tL;
            x Ra;
            int length;
            String str;
            int i2;
            CharSequence charSequence;
            CharSequence charSequence2;
            if (this.qAR.size() > 0) {
                if (i == 0) {
                    return this.qAs.pSl;
                }
                i--;
            }
            bba com_tencent_mm_protocal_c_bba = (bba) this.qAQ.get(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = r.eC(this.activity).inflate(i.g.pHu, null);
                view.setOnTouchListener(this.qAs.qtw);
                a aVar2 = new a(this);
                aVar2.ipv = (ImageView) view.findViewById(f.pAV);
                aVar2.ipv.setOnClickListener(this.qAs.qAh);
                aVar2.ovh = (TextView) view.findViewById(f.pBe);
                aVar2.ovh.setOnTouchListener(new aa());
                aVar2.ovh.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b qAS;

                    {
                        this.qAS = r1;
                    }

                    public final void onClick(View view) {
                        w.i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
                    }
                });
                aVar2.lle = (TextView) view.findViewById(f.pBh);
                aVar2.iuD = (TextView) view.findViewById(f.pAY);
                aVar2.qAT = (SnsTranslateResultView) view.findViewById(f.pFZ);
                aVar2.qAT.setVisibility(8);
                if (this.qAs.knu == 11) {
                    view.findViewById(f.pCb).setBackgroundResource(i.e.pzA);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                aVar = (a) view.getTag();
            }
            aVar.qAV = com_tencent_mm_protocal_c_bba;
            aVar.userName = com_tencent_mm_protocal_c_bba.tgG;
            int i3 = this.qAs.knu == 11 ? 3 : 2;
            int i4 = this.qAs.knu == 11 ? 3 : 2;
            h.vJ();
            x Ra2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(aVar.userName);
            if (i == 0 && this.qAR.isEmpty()) {
                if (this.qAs.knu == 11) {
                    view.setBackgroundResource(i.e.pzB);
                } else {
                    view.setBackgroundResource(i.e.pAl);
                }
            } else if (this.qAs.knu == 11) {
                view.setBackgroundResource(i.e.pAn);
            } else {
                view.setBackgroundResource(i.e.pAm);
            }
            if (i == 0) {
                view.findViewById(f.pED).setVisibility(0);
                view.findViewById(f.pEE).setVisibility(8);
                if (this.qAs.knu == 11) {
                    ((ImageView) view.findViewById(f.pED)).setImageResource(i.i.pJa);
                }
            } else {
                view.findViewById(f.pED).setVisibility(4);
                view.findViewById(f.pEE).setVisibility(0);
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ipv, com_tencent_mm_protocal_c_bba.tgG, true);
            aVar.ipv.setTag(com_tencent_mm_protocal_c_bba.tgG);
            if (Ra2 != null) {
                tL = Ra2.tL();
            } else {
                Object obj = com_tencent_mm_protocal_c_bba.tNz != null ? com_tencent_mm_protocal_c_bba.tNz : com_tencent_mm_protocal_c_bba.tgG;
            }
            m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(this.qAs.fVJ);
            aVar.iuD.setText(com_tencent_mm_protocal_c_bba.opI + " ");
            String charSequence3 = aVar.iuD.getText().toString();
            if (Gf != null) {
                h.vJ();
                Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(Gf.field_userName);
            } else {
                Ra = null;
            }
            if (com_tencent_mm_protocal_c_bba.ubP == 1) {
                if (Ra != null) {
                    String tL2 = Ra.tL();
                    length = this.qAs.getString(j.pKt).length();
                    str = this.qAs.getString(j.pKt) + tL2 + this.qAs.getString(j.pKr) + charSequence3;
                    i2 = length;
                    length = 0;
                    charSequence = tL2;
                    charSequence2 = null;
                }
                str = charSequence3;
                i2 = 0;
                length = 0;
                charSequence = null;
                charSequence2 = null;
            } else {
                if (!bg.mA(com_tencent_mm_protocal_c_bba.uce)) {
                    Ra = this.qAs.qzL.Rc(com_tencent_mm_protocal_c_bba.uce);
                    str = Ra == null ? com_tencent_mm_protocal_c_bba.uce : Ra.tL();
                    int length2 = this.qAs.getString(j.pMj).length();
                    String str2 = this.qAs.getString(j.pMj) + str + this.qAs.getString(j.pKr) + charSequence3;
                    i2 = 0;
                    length = length2;
                    charSequence = null;
                    Object obj2 = str;
                    str = str2;
                }
                str = charSequence3;
                i2 = 0;
                length = 0;
                charSequence = null;
                charSequence2 = null;
            }
            aVar.ovh.setText(tL, BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.d.h.d(aVar.ovh, i3);
            CharSequence iVar = new com.tencent.mm.pluginsdk.ui.d.i(aVar.ovh.getText());
            iVar.a(new com.tencent.mm.pluginsdk.ui.d.m(com_tencent_mm_protocal_c_bba.tgG, this.qAs.qzO, i3), tL, 0, 33);
            aVar.ovh.setText(iVar, BufferType.SPANNABLE);
            aVar.lle.setText(ay.l(this.activity, ((long) com_tencent_mm_protocal_c_bba.ogM) * 1000));
            Object iVar2 = new com.tencent.mm.pluginsdk.ui.d.i(str);
            if (charSequence != null) {
                iVar2.a(new com.tencent.mm.pluginsdk.ui.d.m(Gf.field_userName, this.qAs.qzO, i4), charSequence, i2, 33);
            } else if (charSequence2 != null) {
                iVar2.a(new com.tencent.mm.pluginsdk.ui.d.m(com_tencent_mm_protocal_c_bba.uce, this.qAs.qzO, i4), charSequence2, length, 33);
            }
            aVar.iuD.setText(iVar2, BufferType.SPANNABLE);
            aVar.iuD.setVisibility(0);
            com.tencent.mm.pluginsdk.ui.d.h.d(aVar.iuD, 2);
            this.qAs.kmS.a(view, this.qAs.qzX.qNC, this.qAs.qzX.qNp);
            str = ao.dv(this.qAs.fVJ, String.valueOf(com_tencent_mm_protocal_c_bba.ubK != 0 ? (long) com_tencent_mm_protocal_c_bba.ubK : com_tencent_mm_protocal_c_bba.ubN));
            if (ao.bJ(str, 4) && aVar.qAT != null) {
                com.tencent.mm.plugin.sns.model.ao.b Fq = ao.Fq(str);
                if (Fq != null) {
                    aVar.qAT.setVisibility(0);
                    if (!Fq.hoD) {
                        aVar.qAT.uh(2);
                    } else if (Fq.hrm) {
                        aVar.qAT.setVisibility(8);
                    } else {
                        aVar.qAT.a(Fq, 2, Fq.result, Fq.hwe, Fq.pXz);
                    }
                } else {
                    aVar.qAT.setVisibility(8);
                }
            }
            view.setClickable(true);
            w.d("MicroMsg.SnsCommentDetailUI", "position " + com_tencent_mm_protocal_c_bba.tgG + " self " + this.qAs.gKJ + " commentid " + com_tencent_mm_protocal_c_bba.ubK + " snsid " + this.qAs.fVJ);
            if (this.qAs.gKJ.equals(com_tencent_mm_protocal_c_bba.tgG)) {
                aVar.qAU = com_tencent_mm_protocal_c_bba;
            } else {
                aVar.qAU = new Object[]{Integer.valueOf(i), com_tencent_mm_protocal_c_bba, com_tencent_mm_protocal_c_bba.tgG, tL};
            }
            l lVar = new l(this.qAs.fVJ, com_tencent_mm_protocal_c_bba, com_tencent_mm_protocal_c_bba.tgG, com_tencent_mm_protocal_c_bba.opI, aVar.iuD, 2);
            lVar.tag = aVar;
            view.setTag(lVar);
            view.setOnClickListener(this.qAs.mAD);
            return view;
        }
    }

    class c implements Runnable {
        int Dn = -1;
        int kpi;
        private int offset = 0;
        private int qAW = -1;
        private int qAX = 10;
        final /* synthetic */ SnsCommentDetailUI qAs;

        c(SnsCommentDetailUI snsCommentDetailUI) {
            this.qAs = snsCommentDetailUI;
        }

        public final void run() {
            this.qAX = 10;
            this.qAs.qzI = true;
            this.qAW = this.qAs.qqb.getTop();
            int i = this.qAW - this.kpi;
            w.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[]{Integer.valueOf(this.qAs.qzz.getBottom()), Integer.valueOf(this.qAs.qzH), Integer.valueOf(this.qAW), Integer.valueOf(this.qAs.qqb.getTop()), Integer.valueOf(i)});
            if (i == this.offset) {
                this.qAs.qzz.setSelectionFromTop(this.qAs.qzz.getHeaderViewsCount() + this.Dn, i);
                this.qAX = 0;
                this.offset = 0;
                return;
            }
            int i2 = this.qAX;
            this.qAX = i2 - 1;
            if (i2 > 0) {
                new ae().postDelayed(this, 100);
                this.offset = i;
                return;
            }
            this.offset = 0;
            this.qAX = 0;
        }
    }

    class a extends com.tencent.mm.pluginsdk.ui.d.m {
        final /* synthetic */ SnsCommentDetailUI qAs;

        a(SnsCommentDetailUI snsCommentDetailUI) {
            this.qAs = snsCommentDetailUI;
        }

        public final void onClick(View view) {
            this.qAs.qzR.qKG.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVR);
            if (this.nII) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, int i, int i2, gg ggVar) {
        if (i2 == -1) {
            m hJ = snsCommentDetailUI.hJ(false);
            if (hJ != null) {
                bfc bhd = hJ.bhd();
                if (bhd.ufB.tsN == 1 && bhd.ufB.tsO.size() == 4 && i > 1) {
                    i++;
                }
                if (snsCommentDetailUI.qAo != null) {
                    TagImageView tagImageView = (TagImageView) snsCommentDetailUI.qAo.findViewById(aq.qDQ[i]);
                    if (tagImageView != null) {
                        int[] iArr = new int[2];
                        tagImageView.getLocationInWindow(iArr);
                        ggVar.fLy.fEb = iArr[0];
                        ggVar.fLy.fEc = iArr[1];
                        ggVar.fLy.fEd = tagImageView.getWidth();
                        ggVar.fLy.fEe = tagImageView.getHeight();
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, View view) {
        a aVar = view.getTag() instanceof l ? (a) ((l) view.getTag()).tag : null;
        if (aVar == null) {
            return;
        }
        if (aVar.qAU instanceof bba) {
            if (snsCommentDetailUI.qzI) {
                snsCommentDetailUI.hI(false);
            }
            final bba com_tencent_mm_protocal_c_bba = (bba) aVar.qAU;
            final CharSequence charSequence = aVar.iuD.getText().toString();
            Context context = snsCommentDetailUI.uSU.uTo;
            String[] strArr = new String[]{snsCommentDetailUI.uSU.uTo.getString(j.dGx), snsCommentDetailUI.uSU.uTo.getString(j.dGB)};
            snsCommentDetailUI.uSU.uTo.getString(j.dGs);
            com.tencent.mm.ui.base.g.a(context, null, strArr, new com.tencent.mm.ui.base.g.c(snsCommentDetailUI) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            this.qAs.lMa.setText(charSequence);
                            com.tencent.mm.ui.base.g.bl(this.qAs.uSU.uTo, this.qAs.uSU.uTo.getString(j.dGy));
                            return;
                        case 1:
                            int i2;
                            String str = "MicroMsg.SnsCommentDetailUI";
                            StringBuilder append = new StringBuilder("del snsId:").append(this.qAs.fVJ).append(" commentId:");
                            if (com_tencent_mm_protocal_c_bba != null) {
                                i2 = com_tencent_mm_protocal_c_bba.ubK;
                            } else {
                                i2 = 0;
                            }
                            w.e(str, append.append(i2).toString());
                            final k qVar = new q(u.GA(this.qAs.fVJ), u.Eu(this.qAs.fVJ) ? 4 : 6, com_tencent_mm_protocal_c_bba);
                            h.vJ();
                            h.vH().gXC.a(qVar, 0);
                            SnsCommentDetailUI snsCommentDetailUI = this.qAs;
                            Context context = this.qAs;
                            this.qAs.getString(j.dIO);
                            snsCommentDetailUI.qqm = com.tencent.mm.ui.base.g.a(context, this.qAs.getString(j.pKE), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass37 qAP;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    h.vJ();
                                    h.vH().gXC.c(qVar);
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (aVar.qAU instanceof Object[]) {
            final Object[] objArr = (Object[]) aVar.qAU;
            SnsCommentFooter snsCommentFooter = snsCommentDetailUI.qqb;
            boolean z = !(snsCommentFooter.pUa == null || snsCommentFooter.pUa.tgG == null || !snsCommentFooter.pUa.tgG.equals((String) objArr[2])) || snsCommentFooter.bka();
            if (z) {
                snsCommentDetailUI.qqb.a(snsCommentDetailUI.getString(j.pMj) + objArr[3], (bba) objArr[1]);
                snsCommentDetailUI.qqb.hK(true);
                int intValue = ((Integer) objArr[0]).intValue();
                if (ai.n(com.tencent.mm.plugin.sns.storage.h.Gg(snsCommentDetailUI.qzK)).ucn.size() > 0) {
                    intValue++;
                    if (intValue > snsCommentDetailUI.qzB.getCount()) {
                        intValue = snsCommentDetailUI.qzB.getCount() - 1;
                    }
                }
                snsCommentDetailUI.qAg.Dn = intValue;
                snsCommentDetailUI.qAg.kpi = view.getHeight();
                snsCommentDetailUI.bim();
                return;
            }
            String[] strArr2 = new String[]{snsCommentDetailUI.getString(j.pMj) + objArr[3]};
            snsCommentDetailUI.getString(j.dGs);
            com.tencent.mm.ui.base.g.a(snsCommentDetailUI, null, strArr2, new com.tencent.mm.ui.base.g.c(snsCommentDetailUI) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            this.qAs.qqb.a(this.qAs.getString(j.pMj) + objArr[3], (bba) objArr[1]);
                            this.qAs.qqb.hK(true);
                            int intValue = ((Integer) objArr[0]).intValue();
                            if (ai.n(com.tencent.mm.plugin.sns.storage.h.Gg(this.qAs.qzK)).ucn.size() > 0) {
                                intValue++;
                                if (intValue > this.qAs.qzB.getCount()) {
                                    intValue = this.qAs.qzB.getCount() - 1;
                                }
                            }
                            this.qAs.qAg.Dn = intValue;
                            this.qAs.qAg.run();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.bH(str, 4);
        if (snsCommentDetailUI.qzB != null) {
            snsCommentDetailUI.qzB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, bba com_tencent_mm_protocal_c_bba, int i) {
        if (str != null && !str.trim().equals("") && u.GC(snsCommentDetailUI.fVJ)) {
            m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(snsCommentDetailUI.fVJ);
            bba a = com.tencent.mm.plugin.sns.model.al.a.a(Gf, Gf.tE(32) ? 8 : 2, str, com_tencent_mm_protocal_c_bba, true, i);
            if (ai.m(Gf) != null) {
                b bVar = snsCommentDetailUI.qzB;
                bVar.qAQ.add(a);
                bVar.notifyDataSetChanged();
                new ae().postDelayed(new Runnable(bVar) {
                    final /* synthetic */ b qAS;

                    {
                        this.qAS = r1;
                    }

                    public final void run() {
                        this.qAS.qAs.qzz.setSelection((this.qAS.qAs.qzz.getHeaderViewsCount() + this.qAS.qAQ.size()) - 1);
                    }
                }, 60);
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, String str2, String str3) {
        m hJ = snsCommentDetailUI.hJ(false);
        if (hJ != null && hJ.bhe().equals(str)) {
            if (bg.mA(str2)) {
                snsCommentDetailUI.qzY.setVisibility(8);
            } else {
                ao.bH(str, 4);
                com.tencent.mm.plugin.sns.model.ao.b Fq = ao.Fq(str);
                snsCommentDetailUI.qzY.setVisibility(0);
                snsCommentDetailUI.qzY.a(Fq, 1, str2, str3, Fq.pXz);
            }
            snsCommentDetailUI.qzw.setTag(new ar(snsCommentDetailUI.fVJ, hJ.bhy(), true, false, 2));
        }
    }

    static /* synthetic */ void b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        if (snsCommentDetailUI.hJ(false).bhe().equals(str)) {
            snsCommentDetailUI.qzY.setVisibility(0);
            snsCommentDetailUI.qzY.uh(1);
        }
    }

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.bH(str, 4);
        if (snsCommentDetailUI.qzB != null) {
            snsCommentDetailUI.qzB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        m hJ = snsCommentDetailUI.hJ(false);
        if (hJ.bhe().equals(str)) {
            ao.bI(str, 4);
            snsCommentDetailUI.qzY.setVisibility(8);
            snsCommentDetailUI.qzw.setTag(new ar(snsCommentDetailUI.fVJ, hJ.bhy(), true, false, 2));
        }
    }

    static /* synthetic */ void e(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.bI(str, 4);
        if (snsCommentDetailUI.qzB != null) {
            snsCommentDetailUI.qzB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void s(SnsCommentDetailUI snsCommentDetailUI) {
        if (snsCommentDetailUI.qqb != null) {
            snsCommentDetailUI.qqb.hK(false);
            if (snsCommentDetailUI.qqb.bka()) {
                snsCommentDetailUI.qqb.bkg();
            } else {
                snsCommentDetailUI.qqb.state = 0;
            }
        }
    }

    static /* synthetic */ void u(SnsCommentDetailUI snsCommentDetailUI) {
        int i;
        int count = snsCommentDetailUI.qzB.getCount() - 1;
        bba bkh = snsCommentDetailUI.qqb.bkh();
        long j = bkh.ubK != 0 ? (long) bkh.ubK : bkh.ubN;
        if (bkh != null) {
            i = 0;
            while (i < snsCommentDetailUI.qzB.qAQ.size()) {
                bba com_tencent_mm_protocal_c_bba = (bba) snsCommentDetailUI.qzB.qAQ.get(i);
                if ((com_tencent_mm_protocal_c_bba.ubK != 0 ? (long) com_tencent_mm_protocal_c_bba.ubK : com_tencent_mm_protocal_c_bba.ubN) == j) {
                    break;
                }
                i++;
            }
        }
        i = count;
        snsCommentDetailUI.qAg.kpi = snsCommentDetailUI.bjS();
        if (ai.m(com.tencent.mm.plugin.sns.storage.h.Gf(snsCommentDetailUI.fVJ)).ucn.size() > 0) {
            i++;
            if (i > snsCommentDetailUI.qzB.getCount()) {
                i = snsCommentDetailUI.qzB.getCount() - 1;
            }
        }
        snsCommentDetailUI.qAg.Dn = i;
        snsCommentDetailUI.bim();
    }

    static /* synthetic */ void v(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        if (u.GC(snsCommentDetailUI.fVJ)) {
            m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(snsCommentDetailUI.fVJ);
            if (Gf.field_likeFlag == 0) {
                Gf.field_likeFlag = 1;
                com.tencent.mm.plugin.sns.storage.h.a(Gf.bhe(), Gf);
                if (Gf.tE(32)) {
                    i = 7;
                }
                com.tencent.mm.plugin.sns.model.al.a.a(Gf, i, "");
                snsCommentDetailUI.qzB.notifyDataSetChanged();
            } else {
                Gf.field_likeFlag = 0;
                com.tencent.mm.plugin.sns.storage.h.a(Gf.bhe(), Gf);
                com.tencent.mm.plugin.sns.model.al.a.Fp(Gf.bhe());
            }
            bbk m = ai.m(com.tencent.mm.plugin.sns.storage.h.Gf(snsCommentDetailUI.fVJ));
            if (m != null) {
                snsCommentDetailUI.qzG = m.ucn;
                snsCommentDetailUI.e(m.ucn, m.ucq.isEmpty());
                b bVar = snsCommentDetailUI.qzB;
                bVar.qAR = m.ucn;
                bVar.notifyDataSetChanged();
            }
        }
    }

    private static boolean f(LinkedList<bba> linkedList, LinkedList<bba> linkedList2) {
        if (linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.size() != linkedList2.size()) {
            return false;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            if (!((bba) linkedList.get(i)).tgG.equals(((bba) linkedList2.get(i)).tgG)) {
                return false;
            }
        }
        return true;
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }

    private void hI(boolean z) {
        this.qzI = false;
        if (this.qqb.bka()) {
            this.qqb.bkg();
            this.qqb.GR(getString(j.pMR));
        }
        this.qqb.hK(false);
        if (z) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.qzz);
        }
    }

    private m hJ(boolean z) {
        m Gf;
        if (bg.mA(this.qzK)) {
            Gf = com.tencent.mm.plugin.sns.storage.h.Gf(this.fVJ);
            if (Gf == null) {
                finish();
                return null;
            }
            this.qzK = Gf.bhy();
            return Gf;
        }
        Gf = com.tencent.mm.plugin.sns.storage.h.Gg(this.qzK);
        if (Gf == null) {
            if (z) {
                Toast.makeText(this, j.pLQ, 0).show();
            }
            finish();
            return null;
        }
        this.fVJ = Gf.bhe();
        return Gf;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        com.tencent.mm.pluginsdk.e.f(this);
        super.onCreate(bundle);
        com.tencent.mm.plugin.sns.model.ae.beB().a(5, "@__weixintimtline", (com.tencent.mm.plugin.sns.b.g.a) this);
        this.lMa = (ClipboardManager) getSystemService("clipboard");
        this.qzt = System.currentTimeMillis();
        this.kmS = new l(this);
        this.qzR = new bf(this, new com.tencent.mm.plugin.sns.ui.bf.a(this) {
            final /* synthetic */ SnsCommentDetailUI qAs;

            {
                this.qAs = r1;
            }

            public final void bjX() {
                this.qAs.bjW();
            }
        }, 1, this.qAb);
        this.qzX = new com.tencent.mm.plugin.sns.ui.b.b(this, this, this.qAb) {
            final /* synthetic */ SnsCommentDetailUI qAs;

            public final void b(View view, int i, int i2, int i3) {
            }

            public final void bm(Object obj) {
                this.qAs.bjV();
                this.qAs.qqd.a((View) obj, 2, null);
            }

            public final void bin() {
            }

            public final void cx(View view) {
            }

            public final void cw(View view) {
            }

            public final void cu(View view) {
            }

            public final void cv(View view) {
            }

            public final void cy(View view) {
                this.qAs.qqj.ct(view);
            }

            public final void bio() {
                this.qAs.qqj.bfB();
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                this.qAs.setResult(-1, intent);
                this.qAs.finish();
            }
        };
        FrameLayout frameLayout = (FrameLayout) findViewById(f.pGg);
        this.qqk = new com.tencent.mm.plugin.sns.f.b(this, this.qzX, frameLayout);
        this.qqj = new c(this, this.qzX, frameLayout, this.qqk);
        this.qzX.aFp();
        this.fVJ = bg.ap(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (bg.mA(this.fVJ)) {
            this.fVJ = u.S("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.qzK = bg.ap(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (bg.mA(this.qzK)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.qzK = u.S("sns_table_", (long) intExtra);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            bfc com_tencent_mm_protocal_c_bfc = new bfc();
            try {
                com_tencent_mm_protocal_c_bfc.aD(byteArrayExtra);
                if (com.tencent.mm.plugin.sns.model.ae.beL().dG(new BigInteger(com_tencent_mm_protocal_c_bfc.mQY).longValue()) == null) {
                    w.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    com.tencent.mm.sdk.e.c mVar = new m();
                    mVar.field_snsId = new BigInteger(com_tencent_mm_protocal_c_bfc.mQY).longValue();
                    try {
                        mVar.field_content = com_tencent_mm_protocal_c_bfc.toByteArray();
                    } catch (Exception e) {
                    }
                    mVar.field_createTime = com_tencent_mm_protocal_c_bfc.ogM;
                    mVar.field_userName = com_tencent_mm_protocal_c_bfc.jNj;
                    mVar.field_type = com_tencent_mm_protocal_c_bfc.ufB.tsN;
                    mVar.bhv();
                    bbk com_tencent_mm_protocal_c_bbk = new bbk();
                    com_tencent_mm_protocal_c_bbk.ucj = new avw();
                    try {
                        mVar.field_attrBuf = com_tencent_mm_protocal_c_bbk.toByteArray();
                    } catch (IOException e2) {
                    }
                    com.tencent.mm.plugin.sns.model.ae.beL().b(mVar);
                    w.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                } else {
                    w.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        m hJ = hJ(true);
        w.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.fVJ + " localSnsId: " + this.qzK);
        if (hJ != null) {
            w.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", new Object[]{bg.ap(hJ.field_userName, "")});
        }
        if (u.GC(this.fVJ)) {
            if (!u.Eu(this.fVJ)) {
                h.vJ();
                h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.l(u.GA(this.fVJ), 0), 0);
            } else if (hJ == null) {
                h.vJ();
                h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.p(u.GA(this.fVJ)), 0);
            } else if (!o.eT(hJ.field_userName)) {
                h.vJ();
                h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.p(u.GA(this.fVJ)), 0);
            }
        }
        h.vJ();
        h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
        h.vJ();
        h.vH().gXC.a(218, this);
        h.vJ();
        h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, this);
        h.vJ();
        h.vH().gXC.a(682, this);
        h.vJ();
        h.vH().gXC.a(JsApiCheckIsSupportFaceDetect.CTRL_INDEX, this);
        h.vJ();
        h.vH().gXC.a(683, this);
        this.qzL = com.tencent.mm.plugin.sns.model.ae.bez();
        this.qqd = new an(this);
        this.qzJ = new aq(this.uSU.uTo);
        this.qzO = new j(this, 1, this.qAb);
        if (hJ != null) {
            this.knu = au.c(hJ.bhd());
        }
        if (hJ != null && hJ.tE(32)) {
            this.qri = new g(2);
            au.c(hJ.bhd());
        }
        KC();
        if (hJ != null && hJ.tE(32)) {
            this.qri.a(0, hJ.bhy(), hJ.bhH(), hJ.bhu(), this.qzv, hJ.field_snsId, this.qAr, ai.m(hJ), this.knu, 2);
        }
        if (this.qzv != null) {
            com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) this.qzv.findViewById(f.Kd);
            if (hJ.bhd().ufB != null && hJ.bhd().ufB.tsN == 15 && (aVar instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) aVar).pvc.bbZ();
            }
            com.tencent.mm.plugin.sns.a.a.j.a(hJ, true, z);
        }
        if (this.qzz != null) {
            this.qzz.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                {
                    this.qAs = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.qAs.qqj != null) {
                        this.qAs.qqj.bfB();
                    }
                    return false;
                }
            });
            com.tencent.mm.sdk.b.a.urY.b(this.iOT);
            com.tencent.mm.sdk.b.a.urY.b(this.qAc);
            com.tencent.mm.sdk.b.a.urY.b(this.qAd);
            com.tencent.mm.sdk.b.a.urY.b(this.qAe);
            com.tencent.mm.sdk.b.a.urY.b(this.qAf);
            com.tencent.mm.sdk.b.a.urY.b(this.qAj);
            com.tencent.mm.sdk.b.a.urY.b(this.qAk);
            com.tencent.mm.pluginsdk.e.g(this);
        }
    }

    public void onDestroy() {
        com.tencent.mm.plugin.sns.model.ae.beB().a(this, 5);
        h.vJ();
        h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
        h.vJ();
        h.vH().gXC.b(218, this);
        h.vJ();
        h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, this);
        h.vJ();
        h.vH().gXC.b(JsApiCheckIsSupportFaceDetect.CTRL_INDEX, this);
        h.vJ();
        h.vH().gXC.b(683, this);
        h.vJ();
        h.vH().gXC.b(682, this);
        com.tencent.mm.plugin.sns.model.ae.beI().Q(this);
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
        if (this.qzO != null) {
            this.qzO.activity = null;
        }
        aa.bjf();
        if (this.qqb != null) {
            this.qqb.aIL();
        }
        m hJ = hJ(false);
        if (!(this.qri == null || hJ == null || !hJ.tE(32))) {
            this.qri.q(0, hJ.bhy(), hJ.bhH());
            com.tencent.mm.plugin.sns.storage.a bhc = hJ.bhc();
            String str = bhc == null ? "" : bhc.pZI;
            com.tencent.mm.plugin.sns.a.a.i beF = com.tencent.mm.plugin.sns.model.ae.beF();
            Object[] objArr = new Object[1];
            objArr[0] = com.tencent.mm.plugin.sns.a.a.f.a(hJ.field_snsId, com.tencent.mm.plugin.sns.data.i.df(hJ.field_snsId), str, Long.valueOf(this.qzt), Long.valueOf(System.currentTimeMillis()));
            beF.i(12012, objArr);
            com.tencent.mm.modelsns.b gA = com.tencent.mm.modelsns.b.gA(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
            gA.kG(com.tencent.mm.plugin.sns.data.i.df(hJ.field_snsId)).kG(str).kG(this.qzt).kG(System.currentTimeMillis());
            gA.JE();
        }
        this.qzX.amk();
        com.tencent.mm.sdk.b.a.urY.c(this.qAc);
        com.tencent.mm.sdk.b.a.urY.c(this.qAd);
        com.tencent.mm.sdk.b.a.urY.c(this.qAe);
        com.tencent.mm.sdk.b.a.urY.c(this.qAf);
        com.tencent.mm.sdk.b.a.urY.c(this.qAj);
        com.tencent.mm.sdk.b.a.urY.c(this.qAk);
        super.onDestroy();
    }

    public void onResume() {
        com.tencent.mm.plugin.sns.model.ae.beG().a(this);
        if (this.qqb != null) {
            SnsCommentFooter snsCommentFooter = this.qqb;
            if (u.GC(this.fVJ)) {
                if (snsCommentFooter.qAZ != null) {
                    snsCommentFooter.qAZ.setEnabled(true);
                }
                if (snsCommentFooter.qAY != null) {
                    snsCommentFooter.qAY.setEnabled(true);
                }
            } else {
                if (snsCommentFooter.qAZ != null) {
                    snsCommentFooter.qAZ.setEnabled(false);
                }
                if (snsCommentFooter.qAY != null) {
                    snsCommentFooter.qAY.setEnabled(false);
                }
            }
        }
        com.tencent.mm.sdk.b.b qvVar = new qv();
        qvVar.fXQ.fXR = 0;
        qvVar.fXQ.fXS = 1;
        qvVar.fXQ.fXT = 0;
        qvVar.fXQ.type = 0;
        com.tencent.mm.sdk.b.a.urY.m(qvVar);
        if (this.qri != null) {
            this.qri.onResume();
        }
        super.onResume();
    }

    public void onPause() {
        com.tencent.mm.plugin.sns.model.ae.beG().b(this);
        super.onPause();
        this.qqb.nuR.onPause();
        new qv().fXQ.type = 1;
        if (this.qri != null) {
            this.qri.jXw = bg.NA();
        }
    }

    protected final int getLayoutId() {
        return i.g.pHs;
    }

    protected final void KC() {
        zi(j.pKB);
        AnonymousClass17 anonymousClass17 = new OnClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI qAs;

            {
                this.qAs = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.qAs.qzz);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI qAs;

            {
                this.qAs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.qAs.qqb != null) {
                    this.qAs.qqb.hK(false);
                }
                this.qAs.finish();
                return true;
            }
        });
        this.gKJ = com.tencent.mm.u.m.xL();
        if (com.tencent.mm.plugin.sns.model.ae.beu()) {
            finish();
        }
        final m hJ = hJ(true);
        if (hJ == null) {
            w.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fVJ);
            finish();
            return;
        }
        boolean z;
        w.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fVJ + "localId " + this.qzK + "  username:" + hJ.field_userName);
        if (!u.GC(this.fVJ) && hJ.bhA()) {
            ali bhq = hJ.bhq();
            findViewById(f.pFA).setVisibility(0);
            TextView textView = (TextView) findViewById(f.pDu);
            switch (bhq.tPN) {
                case bh.CTRL_INDEX /*201*/:
                    if (bg.mA(bhq.tPV)) {
                        textView.setText(j.pMc);
                    } else {
                        textView.setText(bhq.tPV);
                    }
                    findViewById(f.pFB).setVisibility(8);
                    z = false;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*210*/:
                    if (bg.mA(bhq.tPV)) {
                        textView.setText(j.pMe);
                    } else {
                        textView.setText(bhq.tPV);
                    }
                    findViewById(f.pFB).setVisibility(8);
                    z = false;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                    if (bg.mA(bhq.tPV)) {
                        textView.setText(j.pMd);
                    } else {
                        textView.setText(bhq.tPV);
                    }
                    findViewById(f.pFB).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (bg.mA(bhq.tPV)) {
                        textView.setText(j.pMf);
                    } else {
                        textView.setText(bhq.tPV);
                    }
                    findViewById(f.pFB).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(f.pFA).setVisibility(8);
        z = false;
        if (z) {
            findViewById(f.pFA).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                public final void onClick(View view) {
                    if (!hJ.tE(32)) {
                        ai.tg(hJ.qnk);
                        ai.te(hJ.qnk);
                        com.tencent.mm.plugin.sns.model.ae.beH().bdz();
                        Intent intent = new Intent();
                        this.qAs.setResult(-1, intent);
                        if (this.qAs.iLs) {
                            intent.putExtra("sns_gallery_force_finish", true);
                        }
                        this.qAs.finish();
                        this.qAs.finish();
                    }
                }
            });
        }
        this.qzz = (ListView) findViewById(f.pBc);
        this.qzz.post(new Runnable(this) {
            final /* synthetic */ SnsCommentDetailUI qAs;

            {
                this.qAs = r1;
            }

            public final void run() {
                this.qAs.qzH = this.qAs.qzz.getBottom();
                w.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + this.qAs.qzH);
            }
        });
        this.qzz.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SnsCommentDetailUI qAs;

            {
                this.qAs = r1;
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 1) {
                    this.qAs.aHf();
                    SnsCommentDetailUI.s(this.qAs);
                }
            }
        });
        this.qzv = r.eC(this.uSU.uTo).inflate(i.g.pHt, null);
        this.qzv.setOnClickListener(this.qAi);
        this.qzz.addHeaderView(this.qzv);
        z = bjU();
        if (z) {
            m hJ2 = hJ(false);
            if (hJ2 != null) {
                this.knu = au.c(hJ2.bhd());
            }
            if (this.knu == 11 && com.tencent.mm.u.m.xL().equals(hJ.field_userName)) {
                this.qzy = new SnsDetailLuckyHeader(this);
                this.qzy.setLayoutParams(new LayoutParams(-1, -2));
                this.qzy.setOnClickListener(this.qAi);
            }
            this.qzx = new LinearLayout(this.uSU.uTo);
            this.qzx.setLayoutParams(new LayoutParams(-1, -2));
            this.qzx.setOnClickListener(this.qAi);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 2.0f);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.uSU.uTo);
            linearLayout.setBackgroundResource(i.e.pAo);
            linearLayout.setLayoutParams(layoutParams);
            this.pSl = linearLayout;
            if ((hJ.field_localPrivate & 1) != 0) {
                findViewById(f.pBY).setVisibility(8);
                View textView2 = new TextView(this);
                textView2.setLayoutParams(new LayoutParams(-1, -2));
                textView2.setText(getString(j.pKH));
                textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                textView2.setGravity(17);
                textView2.setPadding(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 7.0f), 0, 0);
                this.qzz.addFooterView(textView2);
            }
            if (this.qzy != null) {
                this.qzZ = true;
                this.qzz.addHeaderView(this.qzy);
            }
            bbk m = ai.m(hJ);
            if (m == null) {
                this.qzx.setVisibility(8);
                this.qzB = new b(this, new LinkedList(), new LinkedList(), this, hJ.bhy());
            } else {
                this.qzG = m.ucn;
                e(m.ucn, m.ucq.isEmpty());
                if (this.qzy != null) {
                    this.qzy.a(hJ, this.qzX);
                }
                this.qzB = new b(this, m.ucq, m.ucn, this, hJ.bhy());
            }
            this.qzz.addHeaderView(this.qzx);
            this.qzz.setAdapter(this.qzB);
            this.qqb = (SnsCommentFooter) findViewById(f.pBY);
            this.qqb.qBe = new a(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                public final void bjY() {
                    if (com.tencent.mm.plugin.sns.lucky.a.m.ET(hJ.bhy())) {
                        if (this.qAs.uSU.uTG != 1 && !this.qAs.qqb.bke()) {
                            SnsCommentDetailUI.u(this.qAs);
                        }
                    } else if (this.qAs.qAa == null || !this.qAs.qAa.isShowing()) {
                        this.qAs.qAa = com.tencent.mm.plugin.sns.lucky.ui.a.e(this.qAs.uSU.uTo, this.qAs.qAo.tR(0));
                    }
                }
            };
            this.qqb.qBf = new d(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                {
                    this.qAs = r1;
                }

                public final void azn() {
                    if (!this.qAs.qqb.qBb) {
                        SnsCommentDetailUI.u(this.qAs);
                    }
                }
            };
            hJ2 = hJ(true);
            if (!(hJ2 == null || hJ2.bhx())) {
                this.qqb.setVisibility(8);
            }
            this.qqb.bkb();
            this.qqb.bkf();
            this.qqb.a(new c(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                public final void GF(String str) {
                    int i = 1;
                    if (com.tencent.mm.plugin.sns.lucky.a.m.ET(hJ.bhy())) {
                        bba bkh = this.qAs.qqb.bkh();
                        if (this.qAs.qqb.qBa != 1) {
                            i = 0;
                        }
                        SnsCommentDetailUI.a(this.qAs, str, bkh, i);
                        this.qAs.qqb.hK(false);
                        w.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
                        SnsCommentDetailUI.s(this.qAs);
                        new ae().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass14 qAu;

                            {
                                this.qAu = r1;
                            }

                            public final void run() {
                                SnsCommentDetailUI.u(this.qAu.qAs);
                            }
                        }, 100);
                        return;
                    }
                    com.tencent.mm.plugin.sns.lucky.ui.a.e(this.qAs.uSU.uTo, this.qAs.qAo.tR(0));
                }
            });
            SnsCommentFooter snsCommentFooter = this.qqb;
            b anonymousClass15 = new b(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                {
                    this.qAs = r1;
                }

                public final void bjZ() {
                    SnsCommentDetailUI.v(this.qAs);
                    if (this.qAs.qzz.getFirstVisiblePosition() > 1 || this.qAs.qzz.getLastVisiblePosition() <= 0) {
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.b(this.qAs.qzz, 1);
                    }
                }
            };
            int i = hJ.field_likeFlag;
            snsCommentFooter.qAY.setVisibility(0);
            snsCommentFooter.qAY.setOnClickListener(new com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass7(snsCommentFooter, anonymousClass15));
            this.qqb.bki();
            this.qzP = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
            if (this.qzP) {
                this.qzQ = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
                if (!(this.qzQ == 0 || this.qzB.qAQ == null)) {
                    int i2 = 0;
                    while (i2 < this.qzB.qAQ.size()) {
                        bba com_tencent_mm_protocal_c_bba = (bba) this.qzB.qAQ.get(i2);
                        if ((com_tencent_mm_protocal_c_bba.ubK != 0 ? (long) com_tencent_mm_protocal_c_bba.ubK : com_tencent_mm_protocal_c_bba.ubN) == this.qzQ) {
                            int i3;
                            this.qzz.setSelection(i2);
                            com.tencent.mm.j.a Rc = this.qzL.Rc(com_tencent_mm_protocal_c_bba.tgG);
                            String tL = Rc != null ? Rc.tL() : com_tencent_mm_protocal_c_bba.tNz != null ? com_tencent_mm_protocal_c_bba.tNz : com_tencent_mm_protocal_c_bba.tgG;
                            this.qqb.a(getString(j.pMj) + tL, com_tencent_mm_protocal_c_bba);
                            if (m.ucn.size() > 0) {
                                i3 = i2 + 1;
                                if (i3 > this.qzB.getCount()) {
                                    i3 = this.qzB.getCount() - 1;
                                }
                            } else {
                                i3 = i2;
                            }
                            this.qAg.Dn = i3;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (this.qzP) {
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ SnsCommentDetailUI qAs;

                    {
                        this.qAs = r1;
                    }

                    public final void run() {
                        this.qAs.aHf();
                        this.qAs.qAg.kpi = this.qAs.bjS();
                        this.qAs.qAg.run();
                    }
                }, 100);
            }
            this.qzY = (SnsTranslateResultView) this.qzv.findViewById(f.pFZ);
            this.qzY.ap(((TextView) this.qzv.findViewById(f.bIb)).getTextSize());
            this.qzY.pby.setBackgroundResource(i.e.pAk);
            this.qzY.pby.setTag(new ar(this.fVJ, hJ.bhy(), false, true, 2));
            this.kmS.a(this.qzY.pby, this.qzX.qNs, this.qzX.qNp);
            if (ao.bJ(this.fVJ, 4)) {
                com.tencent.mm.plugin.sns.model.ao.b Fq = ao.Fq(this.fVJ);
                if (Fq == null || !Fq.hoD) {
                    this.qzY.setVisibility(8);
                    return;
                }
                this.qzY.setVisibility(0);
                this.qzY.a(null, 1, Fq.result, Fq.hwe, false);
                return;
            }
            this.qzY.setVisibility(8);
            return;
        }
        w.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader " + z);
        finish();
    }

    private int bjS() {
        if (this.qzz == null || this.qzz.getChildCount() <= 1) {
            return 0;
        }
        View childAt = this.qzz.getChildAt(0);
        if (childAt != null) {
            return childAt.getHeight();
        }
        return 0;
    }

    private LinearLayout tT(int i) {
        if (this.qAm == null) {
            this.qAm = (LinearLayout) r.eC(this).inflate(i, null);
            return this.qAm;
        }
        this.qAl = true;
        return this.qAm;
    }

    private static boolean bjT() {
        return (com.tencent.mm.plugin.sns.model.al.a.bfk() & 1) <= 0;
    }

    final boolean bjU() {
        final m hJ = hJ(true);
        if (hJ == null) {
            return false;
        }
        w.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.qzv.toString());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        bPP().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mScreenWidth = this.mScreenHeight < this.mScreenWidth ? this.mScreenHeight : this.mScreenWidth;
        this.qzT = com.tencent.mm.plugin.sns.model.ae.beS();
        final bfc bhd = hJ.bhd();
        this.knu = au.c(bhd);
        ImageView imageView = (ImageView) this.qzv.findViewById(f.pAU);
        if (imageView == null || hJ == null) {
            w.e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (imageView == null) + " " + (hJ == null));
            return false;
        }
        ((MaskImageButton) imageView).wnt = hJ.bhy();
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, hJ.getUserName(), true);
        imageView.setTag(hJ.getUserName());
        imageView.setOnClickListener(this.qzX.qNq);
        TextView textView = (TextView) this.qzv.findViewById(f.cof);
        h.vJ();
        final x Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(hJ.getUserName());
        w.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + hJ.getUserName() + " " + hJ.bhe() + " " + hJ.bhr());
        if (Rc == null) {
            return false;
        }
        CharSequence charSequence;
        int i;
        CharSequence iVar;
        String str;
        View findViewById;
        ViewStub viewStub;
        TagImageView tagImageView;
        final List linkedList;
        final com.tencent.mm.plugin.sns.storage.b bha;
        int i2;
        alj com_tencent_mm_protocal_c_alj;
        float a;
        float a2;
        float f;
        int i3;
        alj com_tencent_mm_protocal_c_alj2;
        aq aqVar;
        PhotosContent photosContent;
        String bhy;
        int hashCode;
        int i4;
        CharSequence charSequence2;
        CharSequence charSequence3;
        com.tencent.mm.plugin.sns.storage.a bhc;
        AsyncTextView asyncTextView;
        AsyncTextView asyncTextView2;
        com.tencent.mm.plugin.sns.storage.a bhc2;
        Iterator it;
        String str2;
        com.tencent.mm.j.a Rb;
        CharSequence iVar2;
        TextPaint paint;
        bbk m;
        Iterator it2;
        Object obj;
        bba com_tencent_mm_protocal_c_bba;
        StringBuilder append;
        ImageButton imageButton;
        m hJ2;
        final ImageView imageView2;
        final ImageView imageView3;
        final TextView textView2;
        final TextView textView3;
        final m mVar;
        if (Rc.tJ() == 0) {
            w.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[]{hJ.getUserName()});
            com.tencent.mm.u.ag.a.yI().a(hJ.getUserName(), "", this.qAq);
        }
        String ap = bg.ap(Rc == null ? hJ.getUserName() : Rc.tL(), "");
        if (hJ.bhK() && bg.mA(ap)) {
            com.tencent.mm.plugin.sns.storage.b bha2 = hJ.bha();
            if (!(bha2 == null || bg.mA(bha2.fFa))) {
                LinearLayout linearLayout;
                ViewGroup.LayoutParams layoutParams;
                charSequence = bha2.fFa;
                charSequence.length();
                i = this.knu != 11 ? 3 : 2;
                iVar = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence));
                iVar.f(new com.tencent.mm.pluginsdk.ui.d.m(new com.tencent.mm.plugin.sns.data.a(hJ.bhK(), Rc.getUsername(), hJ.bhy(), 2), this.qzO, i), charSequence);
                textView.setOnTouchListener(new aa());
                textView.setText(iVar, BufferType.SPANNABLE);
                ((TextView) this.qzv.findViewById(f.pGn)).setText("");
                this.qAr = new be(this.qzv);
                if (hJ.bhK()) {
                    this.qAr.setVisibility(8);
                } else {
                    this.qAr.p(Long.valueOf(hJ.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.qAr, 0, this.qzK, hJ.field_snsId));
                    this.qAr.a(hJ.bha(), hJ.bhc());
                    this.qAr.a(this.qzX.qNz, this.qzX.qNO);
                    this.qAr.setVisibility(0);
                }
                str = bhd.ufy;
                this.qzw = (TextView) this.qzv.findViewById(f.bIb);
                this.qzw.setTag(new ar(this.fVJ, hJ.bhy(), true, false, 2));
                this.kmS.a(this.qzw, this.qzX.qNs, this.qzX.qNp);
                findViewById = this.qzv.findViewById(f.pBT);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                if (hJ.bhK() || hJ.bha() == null || hJ.bha().qeJ != 1) {
                    ap = str;
                } else {
                    this.qzw.setVisibility(8);
                    this.qzw = (TextView) this.qzv.findViewById(f.pCo);
                    this.qzw.setClickable(false);
                    this.qzw.setLongClickable(false);
                    linearLayout = (LinearLayout) this.qzv.findViewById(f.pCL);
                    linearLayout.setBackground(bPP().getResources().getDrawable(i.e.pAi));
                    layoutParams = new LinearLayout.LayoutParams(((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12), -2);
                    layoutParams.setMargins(0, com.tencent.mm.bg.a.fromDPToPix(bPP(), 5), 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                    TextView textView4 = (TextView) this.qzv.findViewById(f.pCk);
                    textView4.setClickable(false);
                    textView4.setLongClickable(false);
                    if (bg.mA(hJ.bha().qeK)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(hJ.bha().qeK + " ");
                        com.tencent.mm.pluginsdk.ui.d.h.d(textView4, 2);
                        textView4.setVisibility(0);
                    }
                    if (bg.mA(hJ.bha().qeL)) {
                        ap = bhd.ufy;
                    } else {
                        ap = hJ.bha().qeL;
                    }
                    this.kmS.a(linearLayout, this.qzX.qNG, this.qzX.qNp);
                    if (hJ.bha().bfK()) {
                        this.qzv.findViewById(f.pBT).setVisibility(0);
                        ((Button) this.qzv.findViewById(f.pBU)).setText(hJ.bha().bfG());
                        ((Button) this.qzv.findViewById(f.pBV)).setText(hJ.bha().bfH());
                        ((Button) this.qzv.findViewById(f.pBU)).setOnClickListener(this.qzX.qNR);
                        ((Button) this.qzv.findViewById(f.pBV)).setOnClickListener(this.qzX.qNS);
                    }
                }
                if (ap != null || ap.equals("")) {
                    this.qzw.setVisibility(8);
                } else {
                    this.qzw.setText(ap + " ");
                    com.tencent.mm.pluginsdk.ui.d.h.d(this.qzw, 2);
                    this.qzw.setVisibility(0);
                }
                au.d(bhd);
                viewStub = (ViewStub) this.qzv.findViewById(f.pCK);
                if (!this.qAn) {
                    if (this.knu == 2) {
                        viewStub.setLayoutResource(i.g.pIp);
                    } else if (this.knu == 3) {
                        viewStub.setLayoutResource(i.g.pIm);
                    } else if (this.knu == 4) {
                        viewStub.setLayoutResource(i.g.pIn);
                    } else if (this.knu == 5) {
                        viewStub.setLayoutResource(i.g.pIo);
                    } else if (this.knu != 6) {
                        if (this.knu != 1 || this.knu == 0) {
                            viewStub.setLayoutResource(i.g.pHL);
                        } else if (this.knu == 9) {
                            viewStub.setLayoutResource(i.g.pFd);
                        } else if (this.knu == 11) {
                            viewStub.setLayoutResource(i.g.pHB);
                        }
                    }
                    if (this.knu != 2 || this.knu == 3 || this.knu == 4 || this.knu == 5) {
                        this.qAo = (PhotosContent) viewStub.inflate();
                    } else if (this.knu == 9) {
                        viewStub.inflate();
                    } else if (this.knu == 11) {
                        this.qAo = (PhotosContent) viewStub.inflate();
                    } else {
                        viewStub.setVisibility(8);
                    }
                    this.qAn = true;
                }
                if (this.knu != 6) {
                    LinearLayout.LayoutParams layoutParams2;
                    if (this.knu != 2 || this.knu == 3 || this.knu == 4 || this.knu == 5) {
                        if (this.qAo == null) {
                            this.qAo.bjz();
                            for (i = 0; i < aq.qDM[this.knu]; i++) {
                                tagImageView = (TagImageView) this.qAo.findViewById(aq.qDQ[i]);
                                this.qAo.a(tagImageView);
                                tagImageView.setOnClickListener(this.qzX.que);
                                this.kmS.a(tagImageView, this.qzX.qND, this.qzX.qNp);
                            }
                            this.qAo.tQ(this.qzT);
                            linkedList = new LinkedList();
                            if (hJ.bhK() && this.knu == 2) {
                                bha = hJ.bha();
                                if (bha == null && bha.qeJ == 1) {
                                    alh com_tencent_mm_protocal_c_alh;
                                    i = ((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (bhd.ufB == null || bhd.ufB.tsO.size() <= 0) {
                                        com_tencent_mm_protocal_c_alh = null;
                                    } else {
                                        com_tencent_mm_protocal_c_alh = (alh) bhd.ufB.tsO.get(0);
                                    }
                                    i = (((i - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 20);
                                    i2 = (int) ((com_tencent_mm_protocal_c_alh.tPl.tPZ * ((float) i)) / com_tencent_mm_protocal_c_alh.tPl.tPY);
                                    com_tencent_mm_protocal_c_alj = new alj();
                                    com_tencent_mm_protocal_c_alj.tPY = (float) i;
                                    com_tencent_mm_protocal_c_alj.tPZ = (float) i2;
                                    com_tencent_mm_protocal_c_alj.tQa = com_tencent_mm_protocal_c_alj.tPY * com_tencent_mm_protocal_c_alj.tPZ;
                                    linkedList.add(com_tencent_mm_protocal_c_alj);
                                    layoutParams2 = (LinearLayout.LayoutParams) this.qAo.getLayoutParams();
                                    layoutParams2.leftMargin = com.tencent.mm.bg.a.fromDPToPix(bPP(), 10);
                                    layoutParams2.rightMargin = com.tencent.mm.bg.a.fromDPToPix(bPP(), 10);
                                    this.qAo.setLayoutParams(layoutParams2);
                                    this.qzv.findViewById(f.pCL).setTag(this.qAo.tR(0));
                                    this.qzv.findViewById(f.pCL).setOnClickListener(this.qzX.qNT);
                                    for (i = 0; i < aq.qDM[this.knu]; i++) {
                                        this.kmS.a((TagImageView) this.qAo.findViewById(aq.qDQ[i]), this.qzX.qNG, this.qzX.qNp);
                                    }
                                    this.qzv.findViewById(f.pBU).setTag(this.qAo.tR(0));
                                    this.qzv.findViewById(f.pBV).setTag(this.qAo.tR(0));
                                } else if (bha != null && bha.qez > 0.0f && bha.qeA > 0.0f) {
                                    a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qez, 1, bha.qeB, bha.qeC);
                                    a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeA, 1, bha.qeB, bha.qeC);
                                    if (bha.qey == 0) {
                                        i2 = ((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth();
                                        if (a < ((float) (((i2 - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)))) {
                                            a2 = (float) (((i2 - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12));
                                            f = (float) ((int) ((bha.qeA * a2) / bha.qez));
                                        } else {
                                            f = a2;
                                            a2 = a;
                                        }
                                        com_tencent_mm_protocal_c_alj = new alj();
                                        com_tencent_mm_protocal_c_alj.tPY = a2;
                                        com_tencent_mm_protocal_c_alj.tPZ = f;
                                        com_tencent_mm_protocal_c_alj.tQa = com_tencent_mm_protocal_c_alj.tPY * com_tencent_mm_protocal_c_alj.tPZ;
                                        linkedList.add(com_tencent_mm_protocal_c_alj);
                                    } else if (bha.qey == 1) {
                                        i2 = (((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12);
                                        i3 = (int) ((((float) i2) * bha.qeA) / bha.qez);
                                        com_tencent_mm_protocal_c_alj2 = new alj();
                                        if (i2 > 0) {
                                            a = (float) i2;
                                        }
                                        com_tencent_mm_protocal_c_alj2.tPY = a;
                                        if (i3 > 0) {
                                            a2 = (float) i3;
                                        }
                                        com_tencent_mm_protocal_c_alj2.tPZ = a2;
                                        com_tencent_mm_protocal_c_alj2.tQa = com_tencent_mm_protocal_c_alj2.tPY * com_tencent_mm_protocal_c_alj2.tPZ;
                                        linkedList.add(com_tencent_mm_protocal_c_alj2);
                                    } else if (bha.qey == 2) {
                                        i2 = ((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12);
                                        i3 = (int) ((((float) i2) * bha.qeA) / bha.qez);
                                        com_tencent_mm_protocal_c_alj2 = new alj();
                                        if (i2 > 0) {
                                            a = (float) i2;
                                        }
                                        com_tencent_mm_protocal_c_alj2.tPY = a;
                                        if (i3 > 0) {
                                            a2 = (float) i3;
                                        }
                                        com_tencent_mm_protocal_c_alj2.tPZ = a2;
                                        com_tencent_mm_protocal_c_alj2.tQa = com_tencent_mm_protocal_c_alj2.tPY * com_tencent_mm_protocal_c_alj2.tPZ;
                                        linkedList.add(com_tencent_mm_protocal_c_alj2);
                                    }
                                }
                                if (!bg.mA(bha.qeE)) {
                                    final PhotosContent photosContent2 = this.qAo;
                                    final TagImageView tR = this.qAo.tR(0);
                                    d.a("adId", bha.qeE, false, 41, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                                        final /* synthetic */ SnsCommentDetailUI qAs;

                                        public final void bgn() {
                                        }

                                        public final void bgo() {
                                        }

                                        public final void FW(String str) {
                                            MaskImageView maskImageView = (MaskImageView) photosContent2.findViewById(f.pDn);
                                            if (maskImageView != null) {
                                                maskImageView.setVisibility(0);
                                                maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
                                                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeF, 1, bha.qeB, bha.qeC);
                                                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeG, 1, bha.qeB, bha.qeC);
                                                float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeH, 1, bha.qeB, bha.qeC);
                                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeI, 1, bha.qeB, bha.qeC);
                                                ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                                                layoutParams.setMargins((int) ((((float) tR.getRight()) - a3) - a), (int) ((((float) tR.getBottom()) - a4) - a2), 0, 0);
                                                maskImageView.setLayoutParams(layoutParams);
                                            }
                                        }
                                    });
                                }
                            }
                            this.qzv.addOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
                                boolean qAA = false;
                                final /* synthetic */ SnsCommentDetailUI qAs;

                                public final void onViewAttachedToWindow(View view) {
                                    w.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[]{Boolean.valueOf(this.qAA)});
                                    if (this.qAA) {
                                        this.qAA = false;
                                        if (bhd != null && hJ != null && this.qAs.qAo != null) {
                                            aq z = this.qAs.qzJ;
                                            PhotosContent photosContent = this.qAs.qAo;
                                            bfc com_tencent_mm_protocal_c_bfc = bhd;
                                            String bhy = hJ.bhy();
                                            int hashCode = this.qAs.hashCode();
                                            int y = this.qAs.knu;
                                            hJ.tE(32);
                                            z.a(photosContent, com_tencent_mm_protocal_c_bfc, bhy, hashCode, y, -1, false, an.uJL, linkedList);
                                        }
                                    }
                                }

                                public final void onViewDetachedFromWindow(View view) {
                                    w.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
                                    this.qAA = true;
                                }
                            });
                            aqVar = this.qzJ;
                            photosContent = this.qAo;
                            bhy = hJ.bhy();
                            hashCode = hashCode();
                            i4 = this.knu;
                            hJ.tE(32);
                            aqVar.a(photosContent, bhd, bhy, hashCode, i4, -1, false, an.uJL, linkedList);
                        } else {
                            w.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.knu + ",stub is " + viewStub.toString());
                        }
                    } else if (this.knu == 11) {
                        this.qAo.bjz();
                        tagImageView = (TagImageView) this.qAo.findViewById(f.pBq);
                        this.qAo.a(tagImageView);
                        tagImageView.setOnClickListener(this.qzX.que);
                        ap = hJ.bhy();
                        List arrayList = new ArrayList();
                        arrayList.add(tagImageView);
                        ao aoVar = new ao();
                        aoVar.fJz = ap;
                        aoVar.index = 0;
                        aoVar.qBO = arrayList;
                        aoVar.qze = true;
                        if (tagImageView != null) {
                            tagImageView.setTag(aoVar);
                        }
                        textView = (TextView) this.qzv.findViewById(f.pCH);
                        if (com.tencent.mm.u.m.xL().equals(bhd.jNj)) {
                            textView.setVisibility(8);
                        } else {
                            bbk n = ai.n(hJ);
                            if (n.ucB == null || n.ucB.udd == 0) {
                                textView.setVisibility(8);
                            } else {
                                textView.setText(getString(j.pJN, new Object[]{Integer.valueOf(n.ucB.udd)}));
                                textView.setVisibility(0);
                            }
                        }
                        ali bhq = hJ.bhq();
                        if (bhq == null) {
                            w.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + hJ.bhy());
                        } else if (com.tencent.mm.u.m.xL().equals(bhd.jNj)) {
                            aqVar = this.qzJ;
                            photosContent = this.qAo;
                            bhy = hJ.bhy();
                            hashCode = hashCode();
                            i4 = this.knu;
                            hJ.tE(32);
                            aqVar.a(photosContent, bhd, bhy, hashCode, i4, -1, false, an.uJL, true);
                        } else if (com.tencent.mm.plugin.sns.lucky.a.m.h(hJ)) {
                            aqVar = this.qzJ;
                            photosContent = this.qAo;
                            bhy = hJ.bhy();
                            hashCode = hashCode();
                            i4 = this.knu;
                            hJ.tE(32);
                            aqVar.a(photosContent, bhd, bhy, hashCode, i4, -1, false, an.uJL, false);
                        } else if (bhq.fZG == 0) {
                            aqVar = this.qzJ;
                            photosContent = this.qAo;
                            bhy = hJ.bhy();
                            hashCode = hashCode();
                            i4 = this.knu;
                            hJ.tE(32);
                            aqVar.a(photosContent, bhd, bhy, hashCode, i4, -1, false, an.uJL, true);
                        } else {
                            w.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + bhq.fZG);
                        }
                    } else if (this.knu == 9) {
                        alh com_tencent_mm_protocal_c_alh2;
                        final aj ajVar = new aj();
                        View view = this.qzv;
                        r9 = view.findViewById(f.bAe);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(f.Kd);
                        ajVar.qxD = r9;
                        ajVar.qjB = (ImageView) view.findViewById(f.cGq);
                        ajVar.qxE = (MMPinProgressBtn) view.findViewById(f.progress);
                        ajVar.qjE = (TextView) view.findViewById(f.pCv);
                        ajVar.qxF = (TextView) view.findViewById(f.pCu);
                        ajVar.pwp = aVar;
                        ajVar.a(bhd, 0, hJ.bhy(), hJ.bhK());
                        ajVar.qjE.setVisibility(8);
                        ajVar.pwp.bi(ajVar);
                        r9.setTag(ajVar);
                        ajVar.qxD.setOnClickListener(this.qzX.qNM);
                        if (hJ.bfJ()) {
                            this.kmS.a(r9, this.qzX.qNG, this.qzX.qNp);
                        } else {
                            this.kmS.a(r9, this.qzX.qNF, this.qzX.qNp);
                        }
                        Pair a3 = com.tencent.mm.modelsns.e.a(bhd, ajVar.pwp.bbU(), hJ.bhK());
                        if (hJ.bhK()) {
                            com.tencent.mm.plugin.sns.storage.b bha3 = hJ.bha();
                            if (bha3 != null && bha3.qeJ == 1) {
                                if (bhd.ufB == null || bhd.ufB.tsO.size() <= 0) {
                                    com_tencent_mm_protocal_c_alh2 = null;
                                } else {
                                    com_tencent_mm_protocal_c_alh2 = (alh) bhd.ufB.tsO.get(0);
                                }
                                if (com_tencent_mm_protocal_c_alh2 != null) {
                                    i2 = (((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 20);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * com_tencent_mm_protocal_c_alh2.tPl.tPZ) / com_tencent_mm_protocal_c_alh2.tPl.tPY)));
                                }
                                layoutParams2 = (LinearLayout.LayoutParams) ajVar.qxD.getLayoutParams();
                                layoutParams2.leftMargin = com.tencent.mm.bg.a.fromDPToPix(bPP(), 10);
                                layoutParams2.rightMargin = com.tencent.mm.bg.a.fromDPToPix(bPP(), 10);
                                ajVar.qxD.setLayoutParams(layoutParams2);
                                this.qzv.findViewById(f.pCL).setTag(ajVar);
                                this.qzv.findViewById(f.pCL).setOnClickListener(this.qzX.qNT);
                                this.qzv.findViewById(f.pBU).setTag(ajVar);
                                this.qzv.findViewById(f.pBV).setTag(ajVar);
                            } else if (bha3 != null && bha3.qez > 0.0f && bha3.qeA > 0.0f) {
                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha3.qez, 1, bha3.qeB, bha3.qeC);
                                a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha3.qeA, 1, bha3.qeB, bha3.qeC);
                                if (bha3.qey == 0) {
                                    i2 = ((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (a4 >= ((float) (((i2 - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)))) {
                                        a2 = (float) (((i2 - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12));
                                        f = (float) ((int) ((bha3.qeA * a2) / bha3.qez));
                                    } else {
                                        f = a;
                                        a2 = a4;
                                    }
                                    a3 = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) f));
                                } else if (bha3.qey == 1) {
                                    i2 = (((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * bha3.qeA) / bha3.qez)));
                                } else if (bha3.qey == 2) {
                                    i2 = ((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * bha3.qeA) / bha3.qez)));
                                }
                            }
                        }
                        if (a3 != null) {
                            aVar.cR(((Integer) a3.first).intValue(), ((Integer) a3.second).intValue());
                            layoutParams = ajVar.qxF.getLayoutParams();
                            layoutParams.width = ((Integer) a3.first).intValue();
                            layoutParams.height = ((Integer) a3.second).intValue();
                            ajVar.qxF.setLayoutParams(layoutParams);
                        }
                        if (bhd.ufB == null || bhd.ufB.tsO.size() <= 0) {
                            com_tencent_mm_protocal_c_alh2 = null;
                        } else {
                            com_tencent_mm_protocal_c_alh2 = (alh) bhd.ufB.tsO.get(0);
                        }
                        if (hJ.bhK()) {
                            ajVar.pwp.a(new com.tencent.mm.plugin.sight.decode.a.b.e(this) {
                                final /* synthetic */ SnsCommentDetailUI qAs;

                                public final void a(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                                    if (i != -1 && this.qAs.qri != null) {
                                        this.qAs.qri.da(hJ.field_snsId);
                                    }
                                }
                            });
                            if (!this.qri.db(hJ.field_snsId)) {
                                ajVar.pwp.a(new com.tencent.mm.plugin.sight.decode.a.b.f(this) {
                                    final /* synthetic */ SnsCommentDetailUI qAs;

                                    public final void a(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                        if (this.qAs.qri != null) {
                                            int bce = (int) bVar.bce();
                                            this.qAs.qri.q(hJ.field_snsId, bg.NA());
                                            this.qAs.qri.u(hJ.field_snsId, bce);
                                            if (j >= 3) {
                                                this.qAs.qri.p(hJ.field_snsId, hJ.field_snsId);
                                                ajVar.pwp.a(null);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if (bhd.ufB != null && bhd.ufB.tsO.size() > 0) {
                            com.tencent.mm.plugin.sns.model.ae.beI();
                            if (com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_alh2)) {
                                if (com.tencent.mm.plugin.sns.model.ae.beI().u(com_tencent_mm_protocal_c_alh2)) {
                                    ajVar.qjB.setVisibility(0);
                                    ajVar.qxE.setVisibility(8);
                                    ajVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this, i.i.dzz));
                                } else if (com.tencent.mm.plugin.sns.model.ae.beI().v(com_tencent_mm_protocal_c_alh2)) {
                                    ajVar.qjB.setVisibility(8);
                                    ajVar.qxE.setVisibility(8);
                                } else if (!hJ.bhK() || com.tencent.mm.plugin.sns.model.ae.beI().l(hJ) > 5) {
                                    com.tencent.mm.plugin.sns.model.ae.beI().x(com_tencent_mm_protocal_c_alh2);
                                    ajVar.qjB.setVisibility(0);
                                    ajVar.qxE.setVisibility(8);
                                    ajVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this, i.i.dzz));
                                } else {
                                    ajVar.qjB.setVisibility(8);
                                    ajVar.qxE.setVisibility(8);
                                }
                                if (ajVar.pwp.bbV()) {
                                    w.d("MicroMsg.SnsCommentDetailUI", "play video error " + com_tencent_mm_protocal_c_alh2.mQY + " " + com_tencent_mm_protocal_c_alh2.msN + " " + com_tencent_mm_protocal_c_alh2.tPi);
                                    com.tencent.mm.plugin.sns.model.ae.beI().x(com_tencent_mm_protocal_c_alh2);
                                    ajVar.qjB.setVisibility(0);
                                    ajVar.qxE.setVisibility(8);
                                    ajVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this, i.i.dzz));
                                }
                            } else if (com.tencent.mm.plugin.sns.model.ae.beI().w(com_tencent_mm_protocal_c_alh2)) {
                                ajVar.qjB.setVisibility(8);
                                ajVar.qxE.setVisibility(0);
                                ajVar.qxE.caB();
                            } else if (hJ.bhK() && com.tencent.mm.plugin.sns.model.ae.beI().l(hJ) == 5) {
                                com.tencent.mm.plugin.sns.model.ae.beI().z(com_tencent_mm_protocal_c_alh2);
                                ajVar.qjB.setVisibility(8);
                                ajVar.qxE.setVisibility(0);
                                ajVar.qxE.caB();
                            } else {
                                com.tencent.mm.plugin.sns.model.ae.beI().x(com_tencent_mm_protocal_c_alh2);
                                ajVar.qjB.setVisibility(0);
                                ajVar.qxE.setVisibility(8);
                                ajVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this, i.i.dzz));
                            }
                            aVar.bi(ajVar);
                            com.tencent.mm.plugin.sns.model.ae.beI().a(hJ, com_tencent_mm_protocal_c_alh2, aVar, hashCode(), 0, an.uJL, hJ.bhK());
                            r9.setTag(ajVar);
                            if (this.qri != null) {
                                boolean z = hJ.bhK() ? com.tencent.mm.plugin.sns.model.ae.beI().l(hJ) == 5 : com.tencent.mm.plugin.sns.model.ae.beI().k(hJ) == 5;
                                this.qri.l(hJ.field_snsId, z);
                            }
                        }
                    } else if (this.knu == 0) {
                        linearLayout = (LinearLayout) this.qzv.findViewById(f.pFe);
                        View tT = tT(i.g.pHK);
                        if (!this.qAl) {
                            linearLayout.removeView(this.qAo);
                            linearLayout.addView(tT, 3);
                            if (tT.getLayoutParams() != null) {
                                r0 = new LinearLayout.LayoutParams(tT.getLayoutParams());
                            } else {
                                r0 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            r0.setMargins(r0.leftMargin, com.tencent.mm.bg.a.fromDPToPix(this, 12), r0.rightMargin, r0.bottomMargin);
                            tT.setLayoutParams(r0);
                        }
                        if (bhd.ufB.tsO.isEmpty()) {
                            tT.setVisibility(8);
                        } else {
                            r1 = (alh) bhd.ufB.tsO.get(0);
                            MMImageView mMImageView = (MMImageView) tT.findViewById(f.pCJ);
                            com.tencent.mm.plugin.sns.model.ae.beI().b(r1, mMImageView, i.i.dtg, hashCode(), an.uJL);
                            this.qzN = (ImageView) tT.findViewById(f.state);
                            this.qzN.setOnTouchListener(this.qtw);
                            this.nTE = bhd.mQY;
                            bjW();
                            mMImageView.setTag(new q(bhd, this.qzK, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                            mMImageView.setOnClickListener(this.qzR.qKO);
                            CharSequence charSequence4 = r1.msk;
                            if (!bg.mA(charSequence4)) {
                                ((TextView) tT.findViewById(f.pDD)).setText(charSequence4);
                            }
                            charSequence2 = r1.fDC;
                            if (!bg.mA(charSequence2)) {
                                ((TextView) tT.findViewById(f.pGi)).setText(new SpannableString(charSequence2), BufferType.SPANNABLE);
                            }
                            tT.setTag(new q(bhd, this.qzK));
                            this.kmS.a(tT, this.qzX.qNE, this.qzX.qNp);
                            tT.setOnClickListener(this.qzR.qFc);
                            com.tencent.mm.plugin.sns.data.i.b(mMImageView, this);
                        }
                    } else {
                        Object obj2;
                        Object obj3;
                        Object obj4;
                        linearLayout = (LinearLayout) this.qzv.findViewById(f.pFe);
                        r9 = tT(i.g.pHJ);
                        View view2 = (MMImageView) r9.findViewById(f.pCJ);
                        if (!this.qAl) {
                            linearLayout.removeView(this.qAo);
                            linearLayout.addView(r9, 3);
                            if (r9.getLayoutParams() != null) {
                                r0 = new LinearLayout.LayoutParams(r9.getLayoutParams());
                            } else {
                                r0 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            r0.setMargins(r0.leftMargin, com.tencent.mm.bg.a.fromDPToPix(this, 12), r0.rightMargin, r0.bottomMargin);
                            r9.setLayoutParams(r0);
                        }
                        Object obj5 = null;
                        if (hJ.bhK()) {
                            if (hJ.bha().qeJ == 2) {
                                obj5 = 1;
                                r9.setTag(hJ);
                                r9.setTag(f.pDd, view2);
                                r9.setOnClickListener(this.qzX.qNW);
                            }
                            obj2 = null;
                            obj3 = obj5;
                        } else {
                            if (bhd.ufB.tsN == 9) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKI);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 10) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKK);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 17) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKL);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 22) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKM);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 23) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKN);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 14) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKJ);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 12) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKR);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN == 13) {
                                if (bhd.ufB.tsO.size() > 0) {
                                    r9.setTag(new q(bhd, this.qzK));
                                    r9.setOnClickListener(this.qzR.qKS);
                                    obj2 = null;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsN != 15) {
                                r9.setTag(new q(bhd, this.qzK));
                                r9.setOnClickListener(this.qzR.qFc);
                                if ((bhd.hhv & 1) > 0) {
                                    int i5 = 1;
                                    obj3 = null;
                                }
                            } else if (bhd.ufB.tsO.size() > 0) {
                                r9.setTag(new q(bhd, this.qzK));
                                r9.setOnClickListener(this.qzX.qNN);
                                obj2 = null;
                                obj3 = null;
                            }
                            obj2 = null;
                            obj3 = null;
                        }
                        if (obj3 != null) {
                            this.kmS.a(r9, this.qzX.qNH, this.qzX.qNp);
                        } else {
                            this.kmS.a(r9, this.qzX.qNE, this.qzX.qNp);
                        }
                        String Hd = bjT() ? au.Hd(bhd.ufB.msN) : "";
                        String str3 = bhd.ufB.fDC;
                        if (obj3 != null) {
                            charSequence3 = bhd.ufB.msk;
                        } else {
                            obj4 = Hd;
                        }
                        r9.findViewById(f.state).setVisibility(8);
                        if (!bhd.ufB.tsO.isEmpty()) {
                            view2.setVisibility(0);
                            r1 = (alh) bhd.ufB.tsO.get(0);
                            if (bhd.ufB.tsN == 15) {
                                ((ImageView) r9.findViewById(f.state)).setImageResource(i.e.bhp);
                                ((ImageView) r9.findViewById(f.state)).setVisibility(0);
                                com.tencent.mm.plugin.sns.model.ae.beI().b(r1, view2, i.i.dtr, hashCode(), an.bLR().yE(bhd.ogM));
                                Hd = str3;
                            } else if (bhd.ufB.tsN == 5) {
                                str3 = au.Hd(r1.msN);
                                str = r1.fDC;
                                r9.findViewById(f.state).setVisibility(0);
                                com.tencent.mm.plugin.sns.model.ae.beI().b(r1, view2, i.i.dtr, hashCode(), an.uJL);
                                Hd = str;
                                obj4 = str3;
                            } else if (bhd.ufB.tsN == 18) {
                                r9.findViewById(f.state).setVisibility(0);
                                ((ImageView) r9.findViewById(f.state)).setImageResource(i.e.bkX);
                                view2.setVisibility(0);
                                com.tencent.mm.plugin.sns.model.ae.beI().b(r1, view2, i.i.dtr, hashCode(), an.uJL);
                                Hd = str3;
                            } else {
                                com.tencent.mm.plugin.sns.model.ae.beI().b(r1, view2, hashCode(), an.uJL);
                                Hd = str3;
                            }
                        } else if (bhd.ufB.tsN == 18) {
                            ((ImageView) r9.findViewById(f.state)).setVisibility(0);
                            ((ImageView) r9.findViewById(f.state)).setImageResource(i.e.bkX);
                            view2.setVisibility(0);
                            com.tencent.mm.plugin.sns.model.ae.beI().a(view2, -1, i.i.dtr, hashCode());
                            Hd = str3;
                        } else {
                            view2.setVisibility(0);
                            com.tencent.mm.plugin.sns.model.ae.beI().a(view2, -1, i.i.dtu, hashCode());
                            Hd = str3;
                        }
                        com.tencent.mm.plugin.sns.data.i.b(view2, this);
                        if (bhd.ufB.tsN == 15) {
                            charSequence3 = "";
                            charSequence2 = getString(j.pKY);
                        } else {
                            obj3 = Hd;
                        }
                        if (bg.mA(charSequence3)) {
                            r9.findViewById(f.pDD).setVisibility(8);
                        } else {
                            r9.findViewById(f.pDD).setVisibility(0);
                            ((TextView) r9.findViewById(f.pDD)).setText(charSequence3);
                        }
                        textView = (TextView) r9.findViewById(f.pGi);
                        if (bg.mA(charSequence2)) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            if (obj2 != null) {
                                textView.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence2, bPP(), textView));
                            } else {
                                textView.setText(charSequence2);
                            }
                        }
                    }
                }
                textView = (TextView) this.qzv.findViewById(f.pAT);
                if (hJ.bhK()) {
                    charSequence2 = bhd.ufz != null ? null : bhd.ufz.hAF;
                    iVar = bhd.ufz != null ? null : bhd.ufz.ndv;
                    textView.setTag(hJ.bhy());
                    if (bg.mA(charSequence2) || !bg.mA(iVar)) {
                        textView.setVisibility(0);
                        if (bg.mA(iVar)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            if (hJ.field_snsId == 0 || bg.mA(charSequence2)) {
                                textView.setText(iVar);
                            } else {
                                textView.setText(charSequence2 + "·" + iVar);
                            }
                        } else {
                            textView.setText(charSequence2);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    bhc = hJ.bhc();
                    if (bhc != null) {
                        iVar = bhc.qdP;
                        ap = bhc.qdQ;
                        textView.setTag(hJ.bhy());
                        if (!bg.mA(iVar)) {
                            if (bg.mA(ap)) {
                                textView.setVisibility(0);
                                if (!bg.mA(iVar)) {
                                    textView.setTextColor(-11048043);
                                    textView.setClickable(true);
                                    textView.setText(iVar);
                                }
                            } else {
                                textView.setVisibility(0);
                            }
                            textView.setText(iVar);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    }
                    textView.setVisibility(8);
                }
                textView.setOnClickListener(this.qzX.qNL);
                ((TextView) this.qzv.findViewById(f.pBI)).setText(ay.l(bPP(), ((long) hJ.bhr()) * 1000));
                asyncTextView = (AsyncTextView) this.qzv.findViewById(f.pAS);
                asyncTextView.setOnClickListener(this.qzX.qNP);
                asyncTextView.setVisibility(8);
                asyncTextView2 = (AsyncTextView) this.qzv.findViewById(f.pAR);
                asyncTextView2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsCommentDetailUI qAs;

                    public final void onClick(View view) {
                        k cVar = new com.tencent.mm.plugin.sns.a.a.c(hJ.bhH(), 24, 2, "", hJ.bhL());
                        h.vJ();
                        h.vH().gXC.a(cVar, 0);
                        this.qAs.qqb.b(Rc.tL(), null);
                        this.qAs.qqb.hK(true);
                        this.qAs.qzA.setVisibility(8);
                        SnsCommentDetailUI.u(this.qAs);
                    }
                });
                asyncTextView2.setVisibility(8);
                if (hJ.bhK()) {
                    bhc2 = hJ.bhc();
                    asyncTextView.setTag(hJ.bhy());
                    if (bhc2.qdR != com.tencent.mm.plugin.sns.storage.a.qdD) {
                        if (bg.mA(bhc2.qdS)) {
                            asyncTextView.setText(bhc2.qdS);
                            asyncTextView.setVisibility(0);
                        } else {
                            asyncTextView.setVisibility(8);
                        }
                    } else if (bhc2.qdR == com.tencent.mm.plugin.sns.storage.a.qdE) {
                        if (!bg.mA(bhc2.qdS)) {
                            bhy = "";
                            it = bhc2.qdU.iterator();
                            while (it.hasNext()) {
                                str2 = (String) it.next();
                                Rb = this.qzL.Rb(str2);
                                if (Rb == null) {
                                    str = Rb.tL();
                                    if (bg.mA(str)) {
                                        bhy = bhy + str;
                                    } else {
                                        bhy = bhy + str2;
                                    }
                                } else {
                                    bhy = bhy + str2;
                                }
                                if (bhc2.qdU.getLast() != str2) {
                                    bhy = bhy + ",";
                                }
                            }
                            iVar = String.format(bhc2.qdS, new Object[]{bhy});
                            asyncTextView.getTextSize();
                            iVar2 = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.d(this, iVar, 1));
                            iVar2.f(null, iVar);
                            paint = asyncTextView.getPaint();
                            if (com.tencent.mm.bg.a.W(this, (int) Layout.getDesiredWidth(iVar2, 0, iVar2.length(), paint)) > this.qzW) {
                                while (bhy.length() > 1) {
                                    bhy = bhy.substring(0, bhy.length() - 2);
                                    iVar2 = String.format(bhc2.qdS, new Object[]{bhy + "..."});
                                    asyncTextView.getTextSize();
                                    charSequence3 = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.d(this, iVar2, 1));
                                    charSequence3.f(null, iVar2);
                                    i4 = com.tencent.mm.bg.a.W(this, (int) Layout.getDesiredWidth(charSequence3, 0, charSequence3.length(), paint));
                                    asyncTextView.setText(charSequence3, BufferType.SPANNABLE);
                                    asyncTextView.setVisibility(0);
                                    if (i4 <= this.qzW) {
                                        break;
                                    }
                                }
                            }
                            asyncTextView.setText(iVar2, BufferType.SPANNABLE);
                            asyncTextView.setVisibility(0);
                        } else {
                            asyncTextView.setVisibility(8);
                        }
                    }
                    if (asyncTextView.getVisibility() != 8 && bg.mA(bhc2.qdT)) {
                        asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
                        asyncTextView.setOnClickListener(null);
                    }
                    if (hJ.bhd().ufB.tsP != 4) {
                        asyncTextView2.setTag(hJ.bhy());
                        asyncTextView2.setVisibility(0);
                        asyncTextView2.setText(String.format("%s%s%s", new Object[]{bPP().getResources().getString(j.pKj), charSequence, bPP().getResources().getString(j.pKk)}));
                    } else {
                        asyncTextView2.setVisibility(8);
                    }
                }
                textView = (TextView) this.qzv.findViewById(f.pBl);
                textView.setOnTouchListener(new aa());
                ap = com.tencent.mm.plugin.sns.c.a.imw.m(this, bhd.ufA.mQY);
                au.a(bhd, this);
                if (com.tencent.mm.plugin.sns.c.a.imw.bn(ap)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    iVar = new SpannableString(getString(j.pKA) + ap);
                    iVar.setSpan(new a(this), 0, iVar.length(), 33);
                    textView.setText(iVar, BufferType.SPANNABLE);
                    if (bhd.ufA == null || !com.tencent.mm.pluginsdk.model.app.g.LY(bhd.ufA.mQY)) {
                        textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
                        textView.setOnTouchListener(null);
                    }
                    textView.setTag(bhd);
                }
                textView = (TextView) this.qzv.findViewById(f.pBk);
                if (hJ.getUserName().equals(this.gKJ)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setTag(hJ.bhy() + ";" + hJ.bhe());
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsCommentDetailUI qAs;

                        {
                            this.qAs = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.g.a(this.qAs, j.pMI, j.dIO, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass26 qAE;

                                {
                                    this.qAE = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + this.qAE.qAs.qzK);
                                    m Gg = com.tencent.mm.plugin.sns.storage.h.Gg(this.qAE.qAs.qzK);
                                    if (Gg == null) {
                                        w.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[]{this.qAE.qAs.qzK});
                                    } else if (!Gg.tE(32)) {
                                        if (Gg.field_snsId == 0) {
                                            com.tencent.mm.plugin.sns.model.ae.beL().tI(Gg.qnk);
                                        } else {
                                            com.tencent.mm.plugin.sns.model.ae.beK().ds(Gg.field_snsId);
                                            h.vJ();
                                            h.vH().gXC.a(new q(Gg.field_snsId, 1), 0);
                                            com.tencent.mm.plugin.sns.model.ae.beL().delete(Gg.field_snsId);
                                            com.tencent.mm.plugin.sns.model.ae.beP().dB(Gg.field_snsId);
                                        }
                                        Intent intent = new Intent();
                                        intent.putExtra("sns_gallery_op_id", u.GB(this.qAE.qAs.qzK));
                                        this.qAE.qAs.setResult(-1, intent);
                                        if (this.qAE.qAs.iLs && !Gg.isValid()) {
                                            intent.putExtra("sns_gallery_force_finish", true);
                                        }
                                        bfc bhd = Gg.bhd();
                                        if (bhd != null) {
                                            String str = bhd.ufA == null ? null : bhd.ufA.mQY;
                                            if (!bg.mA(str) && com.tencent.mm.plugin.sns.c.a.imw.bo(str)) {
                                                String bm = com.tencent.mm.plugin.sns.c.a.imw.bm(str);
                                                com.tencent.mm.sdk.b.b mlVar = new ml();
                                                mlVar.fTI.appId = str;
                                                mlVar.fTI.fTJ = bhd.jNj;
                                                mlVar.fTI.fwP = bm;
                                                com.tencent.mm.sdk.b.a.urY.m(mlVar);
                                            }
                                        }
                                        this.qAE.qAs.finish();
                                    }
                                }
                            }, null);
                        }
                    });
                }
                textView = (TextView) this.qzv.findViewById(f.pGx);
                m = ai.m(hJ);
                if (m != null) {
                    textView.setVisibility(8);
                } else {
                    if (m.uct.size() > 0) {
                        if (this.gKJ.equals(m.tgG)) {
                            textView.setVisibility(8);
                            it2 = m.uct.iterator();
                            while (it2.hasNext()) {
                                if (this.gKJ.equals(((bba) it2.next()).tgG)) {
                                    textView.setVisibility(0);
                                    charSequence2 = getString(j.pMM);
                                    textView.setVisibility(0);
                                    textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, charSequence2, textView.getTextSize()));
                                    break;
                                }
                            }
                        }
                        textView.setVisibility(0);
                        it = m.uct.iterator();
                        obj = null;
                        str2 = "";
                        while (it.hasNext()) {
                            com_tencent_mm_protocal_c_bba = (bba) it.next();
                            if (obj != null) {
                                obj = 1;
                                str2 = str2 + "  ";
                            } else {
                                str2 = str2 + ",  ";
                            }
                            if (com_tencent_mm_protocal_c_bba.tNz == null) {
                                append = new StringBuilder().append(str2);
                                ap = com_tencent_mm_protocal_c_bba.tNz;
                            } else {
                                Rb = this.qzL.Rc(com_tencent_mm_protocal_c_bba.tgG);
                                append = new StringBuilder().append(str2);
                                ap = Rb != null ? com_tencent_mm_protocal_c_bba.tgG : Rb.tL();
                            }
                            str2 = append.append(ap).toString();
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, getString(j.pML, new Object[]{str2}), textView.getTextSize()));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (m != null || this.gKJ == null || !this.gKJ.equals(m.tgG) || ((m.tQZ != 3 || m.ucy == null) && (m.tQZ != 5 || m.tPQ == null))) {
                        this.qzv.findViewById(f.pBm).setVisibility(8);
                    } else {
                        this.qzv.findViewById(f.pBm).setVisibility(0);
                        this.qzv.findViewById(f.pBm).setTag(Integer.valueOf(hJ.qnk));
                        this.qzv.findViewById(f.pBm).setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ SnsCommentDetailUI qAs;

                            {
                                this.qAs = r1;
                            }

                            public final void onClick(View view) {
                                try {
                                    int intValue = ((Integer) view.getTag()).intValue();
                                    Intent intent = new Intent();
                                    intent.putExtra("sns_label_sns_info", intValue);
                                    com.tencent.mm.plugin.sns.c.a.imv.y(intent, this.qAs);
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                }
                this.qzC = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.qzC.setDuration(150);
                this.qzD = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.qzD.setDuration(150);
                if (this.qzA == null) {
                    this.qzA = this.qzv.findViewById(f.pAW);
                    this.qzA.setVisibility(8);
                }
                this.qzE = (LinearLayout) this.qzv.findViewById(f.pBb);
                this.qzE.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsCommentDetailUI qAs;

                    public final void onClick(View view) {
                        if (com.tencent.mm.plugin.sns.lucky.a.m.ET(hJ.bhy())) {
                            this.qAs.qqb.pUa = null;
                            this.qAs.qqb.GR("");
                            this.qAs.qqb.qBa = 0;
                            this.qAs.qqb.hK(true);
                            this.qAs.qzA.setVisibility(8);
                            SnsCommentDetailUI.u(this.qAs);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.a.e(this.qAs.uSU.uTo, this.qAs.qAo.tR(0));
                    }
                });
                this.qzE.setOnTouchListener(this.qtw);
                this.qzF = (LinearLayout) this.qzv.findViewById(f.pBA);
                this.qzF.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsCommentDetailUI qAs;

                    {
                        this.qAs = r1;
                    }

                    public final void onClick(View view) {
                        SnsCommentDetailUI snsCommentDetailUI = this.qAs;
                        LinearLayout linearLayout = (LinearLayout) view;
                        ImageView imageView = (ImageView) linearLayout.findViewById(f.pBz);
                        Animation scaleAnimation = new ScaleAnimation(0.9f, DownloadHelper.SAVE_FATOR, 0.9f, DownloadHelper.SAVE_FATOR, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(400);
                        scaleAnimation.setStartOffset(100);
                        scaleAnimation.setRepeatCount(0);
                        imageView.clearAnimation();
                        imageView.startAnimation(scaleAnimation);
                        scaleAnimation.setAnimationListener(new AnonymousClass32(snsCommentDetailUI, linearLayout));
                        SnsCommentDetailUI.v(this.qAs);
                    }
                });
                this.qzF.setOnTouchListener(this.qtw);
                imageButton = (ImageButton) this.qzv.findViewById(f.pBJ);
                hJ2 = hJ(true);
                if (!(hJ2 == null || (hJ2.bht() & 1) == 0)) {
                    imageButton.setVisibility(8);
                }
                if (!(hJ2 == null || hJ2.bhx())) {
                    imageButton.setVisibility(8);
                }
                imageView2 = (ImageView) this.qzF.findViewById(f.pBz);
                imageView3 = (ImageView) this.qzE.findViewById(f.pBa);
                textView2 = (TextView) this.qzF.findViewById(f.pBB);
                textView3 = (TextView) this.qzE.findViewById(f.pBi);
                if (this.knu == 11) {
                    this.qzv.findViewById(f.pAW).setBackgroundResource(i.e.pzD);
                    imageButton.setImageResource(i.e.pzL);
                    imageView2.setImageResource(i.e.pzM);
                    imageView3.setImageResource(i.e.pzN);
                    textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
                    textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
                    this.qzF.setBackgroundResource(i.e.pzO);
                    this.qzE.setBackgroundResource(i.e.pzP);
                }
                mVar = hJ;
                imageButton.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsCommentDetailUI qAs;

                    public final void onClick(View view) {
                        w.d("MicroMsg.SnsCommentDetailUI", "showComment click" + this.qAs.qzA.getVisibility());
                        bfc bhd = mVar.bhd();
                        if (bhd != null && bhd.ufB.tsN == 21 && !com.tencent.mm.plugin.sns.lucky.a.m.ET(mVar.bhy())) {
                            com.tencent.mm.plugin.sns.lucky.ui.a.e(this.qAs.uSU.uTo, this.qAs.qAo.tR(0));
                        } else if (this.qAs.qzA.getVisibility() == 0) {
                            this.qAs.bjV();
                        } else {
                            this.qAs.qzA.setVisibility(0);
                            this.qAs.qzA.startAnimation(this.qAs.qzC);
                            if (this.qAs.knu == 11) {
                                this.qAs.qzv.findViewById(f.pAW).setBackgroundResource(i.e.pzD);
                            }
                            if (u.GC(this.qAs.fVJ)) {
                                this.qAs.qzE.setEnabled(true);
                                imageView2.setImageResource(i.e.pzE);
                                this.qAs.qzF.setEnabled(true);
                                textView2.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                textView3.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(this.qAs.fVJ);
                                if (this.qAs.knu == 11) {
                                    imageView2.setImageResource(i.e.pzM);
                                    imageView3.setImageResource(i.e.pzN);
                                    textView2.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
                                    textView3.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
                                } else {
                                    imageView2.setImageResource(i.e.pzE);
                                    textView2.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                    textView3.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                }
                                if (Gf.field_likeFlag == 0) {
                                    textView2.setText(this.qAs.getString(j.pLI));
                                    return;
                                } else {
                                    textView2.setText(this.qAs.getString(j.pLi));
                                    return;
                                }
                            }
                            this.qAs.qzE.setEnabled(false);
                            this.qAs.qzF.setEnabled(false);
                            textView2.setText(this.qAs.getString(j.pLI));
                            textView2.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pza));
                            textView3.setTextColor(this.qAs.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pza));
                            if (this.qAs.knu == 11) {
                                imageView2.setImageResource(i.i.pIR);
                            } else {
                                imageView2.setImageResource(i.i.pIT);
                            }
                        }
                    }
                });
                return true;
            }
        }
        Object obj6 = ap;
        charSequence.length();
        if (this.knu != 11) {
        }
        iVar = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence));
        iVar.f(new com.tencent.mm.pluginsdk.ui.d.m(new com.tencent.mm.plugin.sns.data.a(hJ.bhK(), Rc.getUsername(), hJ.bhy(), 2), this.qzO, i), charSequence);
        textView.setOnTouchListener(new aa());
        textView.setText(iVar, BufferType.SPANNABLE);
        ((TextView) this.qzv.findViewById(f.pGn)).setText("");
        this.qAr = new be(this.qzv);
        if (hJ.bhK()) {
            this.qAr.setVisibility(8);
        } else {
            this.qAr.p(Long.valueOf(hJ.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.qAr, 0, this.qzK, hJ.field_snsId));
            this.qAr.a(hJ.bha(), hJ.bhc());
            this.qAr.a(this.qzX.qNz, this.qzX.qNO);
            this.qAr.setVisibility(0);
        }
        str = bhd.ufy;
        this.qzw = (TextView) this.qzv.findViewById(f.bIb);
        this.qzw.setTag(new ar(this.fVJ, hJ.bhy(), true, false, 2));
        this.kmS.a(this.qzw, this.qzX.qNs, this.qzX.qNp);
        findViewById = this.qzv.findViewById(f.pBT);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (hJ.bhK()) {
        }
        ap = str;
        if (ap != null) {
        }
        this.qzw.setVisibility(8);
        au.d(bhd);
        viewStub = (ViewStub) this.qzv.findViewById(f.pCK);
        if (this.qAn) {
            if (this.knu == 2) {
                viewStub.setLayoutResource(i.g.pIp);
            } else if (this.knu == 3) {
                viewStub.setLayoutResource(i.g.pIm);
            } else if (this.knu == 4) {
                viewStub.setLayoutResource(i.g.pIn);
            } else if (this.knu == 5) {
                viewStub.setLayoutResource(i.g.pIo);
            } else if (this.knu != 6) {
                if (this.knu != 1) {
                }
                viewStub.setLayoutResource(i.g.pHL);
            }
            if (this.knu != 2) {
            }
            this.qAo = (PhotosContent) viewStub.inflate();
            this.qAn = true;
        }
        if (this.knu != 6) {
            if (this.knu != 2) {
            }
            if (this.qAo == null) {
                w.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.knu + ",stub is " + viewStub.toString());
            } else {
                this.qAo.bjz();
                for (i = 0; i < aq.qDM[this.knu]; i++) {
                    tagImageView = (TagImageView) this.qAo.findViewById(aq.qDQ[i]);
                    this.qAo.a(tagImageView);
                    tagImageView.setOnClickListener(this.qzX.que);
                    this.kmS.a(tagImageView, this.qzX.qND, this.qzX.qNp);
                }
                this.qAo.tQ(this.qzT);
                linkedList = new LinkedList();
                bha = hJ.bha();
                if (bha == null) {
                }
                a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qez, 1, bha.qeB, bha.qeC);
                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bha.qeA, 1, bha.qeB, bha.qeC);
                if (bha.qey == 0) {
                    i2 = ((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth();
                    if (a < ((float) (((i2 - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)))) {
                        f = a2;
                        a2 = a;
                    } else {
                        a2 = (float) (((i2 - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12));
                        f = (float) ((int) ((bha.qeA * a2) / bha.qez));
                    }
                    com_tencent_mm_protocal_c_alj = new alj();
                    com_tencent_mm_protocal_c_alj.tPY = a2;
                    com_tencent_mm_protocal_c_alj.tPZ = f;
                    com_tencent_mm_protocal_c_alj.tQa = com_tencent_mm_protocal_c_alj.tPY * com_tencent_mm_protocal_c_alj.tPZ;
                    linkedList.add(com_tencent_mm_protocal_c_alj);
                } else if (bha.qey == 1) {
                    i2 = (((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12);
                    i3 = (int) ((((float) i2) * bha.qeA) / bha.qez);
                    com_tencent_mm_protocal_c_alj2 = new alj();
                    if (i2 > 0) {
                        a = (float) i2;
                    }
                    com_tencent_mm_protocal_c_alj2.tPY = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    com_tencent_mm_protocal_c_alj2.tPZ = a2;
                    com_tencent_mm_protocal_c_alj2.tQa = com_tencent_mm_protocal_c_alj2.tPY * com_tencent_mm_protocal_c_alj2.tPZ;
                    linkedList.add(com_tencent_mm_protocal_c_alj2);
                } else if (bha.qey == 2) {
                    i2 = ((((WindowManager) bPP().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(bPP(), 50)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12)) - com.tencent.mm.bg.a.fromDPToPix(bPP(), 12);
                    i3 = (int) ((((float) i2) * bha.qeA) / bha.qez);
                    com_tencent_mm_protocal_c_alj2 = new alj();
                    if (i2 > 0) {
                        a = (float) i2;
                    }
                    com_tencent_mm_protocal_c_alj2.tPY = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    com_tencent_mm_protocal_c_alj2.tPZ = a2;
                    com_tencent_mm_protocal_c_alj2.tQa = com_tencent_mm_protocal_c_alj2.tPY * com_tencent_mm_protocal_c_alj2.tPZ;
                    linkedList.add(com_tencent_mm_protocal_c_alj2);
                }
                if (bg.mA(bha.qeE)) {
                    final PhotosContent photosContent22 = this.qAo;
                    final TagImageView tR2 = this.qAo.tR(0);
                    d.a("adId", bha.qeE, false, 41, 0, /* anonymous class already generated */);
                }
                this.qzv.addOnAttachStateChangeListener(/* anonymous class already generated */);
                aqVar = this.qzJ;
                photosContent = this.qAo;
                bhy = hJ.bhy();
                hashCode = hashCode();
                i4 = this.knu;
                hJ.tE(32);
                aqVar.a(photosContent, bhd, bhy, hashCode, i4, -1, false, an.uJL, linkedList);
            }
        }
        textView = (TextView) this.qzv.findViewById(f.pAT);
        if (hJ.bhK()) {
            if (bhd.ufz != null) {
            }
            if (bhd.ufz != null) {
            }
            textView.setTag(hJ.bhy());
            if (bg.mA(charSequence2)) {
            }
            textView.setVisibility(0);
            if (bg.mA(iVar)) {
                textView.setText(charSequence2);
                textView.setClickable(false);
                textView.setTextColor(-9211021);
            } else {
                textView.setTextColor(-11048043);
                textView.setClickable(true);
                if (hJ.field_snsId == 0) {
                }
                textView.setText(iVar);
            }
        } else {
            bhc = hJ.bhc();
            if (bhc != null) {
                iVar = bhc.qdP;
                ap = bhc.qdQ;
                textView.setTag(hJ.bhy());
                if (bg.mA(iVar)) {
                    if (bg.mA(ap)) {
                        textView.setVisibility(0);
                        if (bg.mA(iVar)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            textView.setText(iVar);
                        }
                    } else {
                        textView.setVisibility(0);
                    }
                    textView.setText(iVar);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                }
            }
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.qzX.qNL);
        ((TextView) this.qzv.findViewById(f.pBI)).setText(ay.l(bPP(), ((long) hJ.bhr()) * 1000));
        asyncTextView = (AsyncTextView) this.qzv.findViewById(f.pAS);
        asyncTextView.setOnClickListener(this.qzX.qNP);
        asyncTextView.setVisibility(8);
        asyncTextView2 = (AsyncTextView) this.qzv.findViewById(f.pAR);
        asyncTextView2.setOnClickListener(/* anonymous class already generated */);
        asyncTextView2.setVisibility(8);
        if (hJ.bhK()) {
            bhc2 = hJ.bhc();
            asyncTextView.setTag(hJ.bhy());
            if (bhc2.qdR != com.tencent.mm.plugin.sns.storage.a.qdD) {
                if (bhc2.qdR == com.tencent.mm.plugin.sns.storage.a.qdE) {
                    if (!bg.mA(bhc2.qdS)) {
                        bhy = "";
                        it = bhc2.qdU.iterator();
                        while (it.hasNext()) {
                            str2 = (String) it.next();
                            Rb = this.qzL.Rb(str2);
                            if (Rb == null) {
                                bhy = bhy + str2;
                            } else {
                                str = Rb.tL();
                                if (bg.mA(str)) {
                                    bhy = bhy + str2;
                                } else {
                                    bhy = bhy + str;
                                }
                            }
                            if (bhc2.qdU.getLast() != str2) {
                                bhy = bhy + ",";
                            }
                        }
                        iVar = String.format(bhc2.qdS, new Object[]{bhy});
                        asyncTextView.getTextSize();
                        iVar2 = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.d(this, iVar, 1));
                        iVar2.f(null, iVar);
                        paint = asyncTextView.getPaint();
                        if (com.tencent.mm.bg.a.W(this, (int) Layout.getDesiredWidth(iVar2, 0, iVar2.length(), paint)) > this.qzW) {
                            while (bhy.length() > 1) {
                                bhy = bhy.substring(0, bhy.length() - 2);
                                iVar2 = String.format(bhc2.qdS, new Object[]{bhy + "..."});
                                asyncTextView.getTextSize();
                                charSequence3 = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.d(this, iVar2, 1));
                                charSequence3.f(null, iVar2);
                                i4 = com.tencent.mm.bg.a.W(this, (int) Layout.getDesiredWidth(charSequence3, 0, charSequence3.length(), paint));
                                asyncTextView.setText(charSequence3, BufferType.SPANNABLE);
                                asyncTextView.setVisibility(0);
                                if (i4 <= this.qzW) {
                                    break;
                                }
                            }
                        }
                        asyncTextView.setText(iVar2, BufferType.SPANNABLE);
                        asyncTextView.setVisibility(0);
                    } else {
                        asyncTextView.setVisibility(8);
                    }
                }
            } else if (bg.mA(bhc2.qdS)) {
                asyncTextView.setVisibility(8);
            } else {
                asyncTextView.setText(bhc2.qdS);
                asyncTextView.setVisibility(0);
            }
            asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
            asyncTextView.setOnClickListener(null);
            if (hJ.bhd().ufB.tsP != 4) {
                asyncTextView2.setVisibility(8);
            } else {
                asyncTextView2.setTag(hJ.bhy());
                asyncTextView2.setVisibility(0);
                asyncTextView2.setText(String.format("%s%s%s", new Object[]{bPP().getResources().getString(j.pKj), charSequence, bPP().getResources().getString(j.pKk)}));
            }
        }
        textView = (TextView) this.qzv.findViewById(f.pBl);
        textView.setOnTouchListener(new aa());
        ap = com.tencent.mm.plugin.sns.c.a.imw.m(this, bhd.ufA.mQY);
        au.a(bhd, this);
        if (com.tencent.mm.plugin.sns.c.a.imw.bn(ap)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            iVar = new SpannableString(getString(j.pKA) + ap);
            iVar.setSpan(new a(this), 0, iVar.length(), 33);
            textView.setText(iVar, BufferType.SPANNABLE);
            textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
            textView.setOnTouchListener(null);
            textView.setTag(bhd);
        }
        textView = (TextView) this.qzv.findViewById(f.pBk);
        if (hJ.getUserName().equals(this.gKJ)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setTag(hJ.bhy() + ";" + hJ.bhe());
            textView.setOnClickListener(/* anonymous class already generated */);
        }
        textView = (TextView) this.qzv.findViewById(f.pGx);
        m = ai.m(hJ);
        if (m != null) {
            if (m.uct.size() > 0) {
                textView.setVisibility(8);
            } else if (this.gKJ.equals(m.tgG)) {
                textView.setVisibility(8);
                it2 = m.uct.iterator();
                while (it2.hasNext()) {
                    if (this.gKJ.equals(((bba) it2.next()).tgG)) {
                        textView.setVisibility(0);
                        charSequence2 = getString(j.pMM);
                        textView.setVisibility(0);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, charSequence2, textView.getTextSize()));
                        break;
                    }
                }
            } else {
                textView.setVisibility(0);
                it = m.uct.iterator();
                obj = null;
                str2 = "";
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bba = (bba) it.next();
                    if (obj != null) {
                        str2 = str2 + ",  ";
                    } else {
                        obj = 1;
                        str2 = str2 + "  ";
                    }
                    if (com_tencent_mm_protocal_c_bba.tNz == null) {
                        Rb = this.qzL.Rc(com_tencent_mm_protocal_c_bba.tgG);
                        append = new StringBuilder().append(str2);
                        if (Rb != null) {
                        }
                    } else {
                        append = new StringBuilder().append(str2);
                        ap = com_tencent_mm_protocal_c_bba.tNz;
                    }
                    str2 = append.append(ap).toString();
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, getString(j.pML, new Object[]{str2}), textView.getTextSize()));
            }
            if (m != null) {
            }
            this.qzv.findViewById(f.pBm).setVisibility(8);
        } else {
            textView.setVisibility(8);
        }
        this.qzC = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qzC.setDuration(150);
        this.qzD = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qzD.setDuration(150);
        if (this.qzA == null) {
            this.qzA = this.qzv.findViewById(f.pAW);
            this.qzA.setVisibility(8);
        }
        this.qzE = (LinearLayout) this.qzv.findViewById(f.pBb);
        this.qzE.setOnClickListener(/* anonymous class already generated */);
        this.qzE.setOnTouchListener(this.qtw);
        this.qzF = (LinearLayout) this.qzv.findViewById(f.pBA);
        this.qzF.setOnClickListener(/* anonymous class already generated */);
        this.qzF.setOnTouchListener(this.qtw);
        imageButton = (ImageButton) this.qzv.findViewById(f.pBJ);
        hJ2 = hJ(true);
        imageButton.setVisibility(8);
        imageButton.setVisibility(8);
        imageView2 = (ImageView) this.qzF.findViewById(f.pBz);
        imageView3 = (ImageView) this.qzE.findViewById(f.pBa);
        textView2 = (TextView) this.qzF.findViewById(f.pBB);
        textView3 = (TextView) this.qzE.findViewById(f.pBi);
        if (this.knu == 11) {
            this.qzv.findViewById(f.pAW).setBackgroundResource(i.e.pzD);
            imageButton.setImageResource(i.e.pzL);
            imageView2.setImageResource(i.e.pzM);
            imageView3.setImageResource(i.e.pzN);
            textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
            textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzb));
            this.qzF.setBackgroundResource(i.e.pzO);
            this.qzE.setBackgroundResource(i.e.pzP);
        }
        mVar = hJ;
        imageButton.setOnClickListener(/* anonymous class already generated */);
        return true;
    }

    private void bjV() {
        if (this.qzA != null && this.qzA.getVisibility() != 8) {
            this.qzA.startAnimation(this.qzD);
            this.qzD.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ SnsCommentDetailUI qAs;

                {
                    this.qAs = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    w.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
                    if (this.qAs.qzA != null) {
                        this.qAs.qzA.clearAnimation();
                        this.qAs.qzA.setVisibility(8);
                    }
                }
            });
        }
    }

    private void bim() {
        if (this.uSU.uTG == 1 || this.qqb.bke()) {
            this.qAg.run();
        } else {
            this.qqa = true;
        }
    }

    private void bjW() {
        if (this.qzN != null) {
            this.qzN.setPressed(false);
            if (bf.DJ(this.nTE)) {
                this.qzN.setImageResource(i.e.bho);
            } else {
                this.qzN.setImageResource(i.e.bhp);
            }
        }
    }

    private boolean e(List<bba> list, boolean z) {
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 32.0f);
        int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 6.0f);
        int a3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 10.0f);
        int a4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 17.0f);
        if (this.qzx == null) {
            return false;
        }
        int i;
        w.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[]{Integer.valueOf(((WindowManager) this.uSU.uTo.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(i.d.aXH))});
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.qzx.getParent() != null) {
                this.qzx.setVisibility(8);
            }
            this.qzx.removeAllViews();
            this.qzx.setVisibility(8);
            this.pSl.setVisibility(8);
            return false;
        }
        this.qzx.getParent();
        this.qzx.removeAllViews();
        this.qzx.setVisibility(0);
        if (this.knu != 11) {
            this.qzx.setBackgroundResource(i.e.pzz);
        } else if (this.qzZ) {
            m hJ = hJ(false);
            if (hJ == null) {
                this.qzx.setBackgroundResource(i.e.pzB);
            } else if (this.gKJ.equals(hJ.field_userName)) {
                this.qzx.setBackgroundResource(i.e.pzC);
            } else {
                this.qzx.setBackgroundResource(i.e.pzB);
            }
        } else {
            this.qzx.setBackgroundResource(i.e.pzB);
        }
        this.qzx.setPadding(0, a2, 0, a2);
        View imageView = new ImageView(this.uSU.uTo);
        if (this.knu == 11) {
            imageView.setImageResource(i.i.pIX);
        } else {
            imageView.setImageResource(i.i.pIW);
        }
        imageView.setPadding(a3, a4, a3, 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.qzx.addView(imageView);
        a3 = com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, qzV);
        i = ((int) (f - ((float) a3))) / (a2 + a);
        if (((int) (f - ((float) a3))) % (a2 + a) > a) {
            i++;
        }
        w.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[]{Integer.valueOf(i)});
        View hVar = new h(this.uSU.uTo);
        hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        hVar.qpW = i;
        for (a3 = 0; a3 < list.size(); a3++) {
            bba com_tencent_mm_protocal_c_bba = (bba) list.get(a3);
            View touchImageView = new TouchImageView(this.uSU.uTo);
            touchImageView.setScaleType(ScaleType.FIT_XY);
            touchImageView.setImageResource(i.e.pzF);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a, a);
            layoutParams2.setMargins(0, a2, a2, 0);
            touchImageView.setLayoutParams(layoutParams2);
            touchImageView.setTag(com_tencent_mm_protocal_c_bba.tgG);
            com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, com_tencent_mm_protocal_c_bba.tgG, true);
            touchImageView.setOnClickListener(this.qAh);
            hVar.addView(touchImageView);
        }
        this.qzx.addView(hVar);
        this.pSl.setVisibility(z ? 8 : 0);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(this.fVJ);
        bbk m = ai.m(Gf);
        e(m.ucn, m.ucq.isEmpty());
        if (this.qzy != null) {
            this.qzy.a(Gf, this.qzX);
        }
        if (this.qAo != null) {
            this.qzT = com.tencent.mm.plugin.sns.model.ae.beS();
            this.qAo.tQ(this.qzT);
        }
    }

    public final void ES(String str) {
    }

    public final void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i == 15) {
            if (this.qzX != null && this.qzX.qNp != null) {
                this.qzX.qNp.onActivityResult(i, i2, intent);
            }
        } else if (i == 16) {
            w.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            com.tencent.mm.sdk.b.b geVar = new ge();
            geVar.fLv.scene = 1;
            com.tencent.mm.sdk.b.a.urY.m(geVar);
        } else if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 218 && this.qqm != null) {
            this.qqm.dismiss();
        }
        if (i == 0 && i2 == 0) {
            m Gf = com.tencent.mm.plugin.sns.storage.h.Gf(this.fVJ);
            if (Gf == null) {
                w.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fVJ);
                finish();
                return;
            }
            w.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fVJ + "  username:" + Gf.field_userName);
            if (this.qzv == null) {
                w.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                return;
            }
            bjU();
            bbk m = ai.m(Gf);
            w.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + m.ucn.size() + " " + m.ucq.size());
            if (m != null) {
                if (!f(this.qzG, m.ucn)) {
                    e(m.ucn, m.ucq.isEmpty());
                    this.qzG = m.ucn;
                }
                if (this.qzy != null) {
                    this.qzy.a(Gf, this.qzX);
                }
                b bVar = this.qzB;
                LinkedList linkedList = m.ucq;
                LinkedList linkedList2 = m.ucn;
                bVar.qAQ = linkedList;
                bVar.qAR = linkedList2;
                this.qzB.notifyDataSetChanged();
            }
        }
    }

    public final void ap(String str, boolean z) {
    }

    public final void bit() {
        if (this.uSU.uTG == 2) {
            w.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.qzI = false;
            if (this.qqb.nuS) {
                this.qqb.nuS = false;
            } else if (this.qqb.bka()) {
                this.qqb.bkg();
                this.qqb.GR(getString(j.pMR));
            }
        } else if (this.uSU.uTG == 1) {
            bjV();
            this.qqa = false;
            this.qAg.run();
        }
    }
}
