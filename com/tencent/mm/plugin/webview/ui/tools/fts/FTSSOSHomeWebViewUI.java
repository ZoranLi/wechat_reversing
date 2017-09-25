package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.as.i;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass28;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayout;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FTSSOSHomeWebViewUI extends BaseSOSWebViewUI {
    private FTSMainUIEducationLayout pfZ;
    private OnClickListener pgk = new OnClickListener(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onClick(View view) {
            this.shv.bzc();
            if (this.shv.sgG) {
                this.shv.shi.yw(1);
                final int a = d.a((JSONObject) view.getTag(), ((TextView) view).getText().toString(), this.shv);
                if (!(this.shv.sgD == a || this.shv.byU().qGU.isEmpty())) {
                    String byX = this.shv.byX();
                    this.shv.byU().clearText();
                    this.shv.byU().q(byX, null);
                    this.shv.byU().bZc();
                }
                this.shv.sgD = a;
                this.shv.wv(a);
                try {
                    this.shv.shq = 0;
                    Bundle bundle = new Bundle();
                    bundle.putInt(Columns.TYPE, a);
                    bundle.putBoolean("isHomePage", true);
                    if (a != 0) {
                        bundle.putInt("scene", 22);
                    } else {
                        bundle.putInt("scene", 20);
                    }
                    bundle = this.shv.iYF.l(4, bundle);
                    this.shv.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass13 shx;

                        public final void run() {
                            boolean z = false;
                            if (this.shx.shv.rVm != null) {
                                z = this.shx.shv.rVm.a(bundle.getString(Columns.TYPE, "0"), bundle.getString("isMostSearchBiz", "0"), bundle.getString("isSug", "0"), bundle.getString("scene", "0"), bundle.getString("isLocalSug", "0"), this.shx.shv.byX(), this.shx.shv.byY(), this.shx.shv.byZ(), this.shx.shv.byS(), this.shx.shv.shq);
                            }
                            if (z) {
                                this.shx.shv.byU().GR(this.shx.shv.ww(a));
                                i.aW(a, 22);
                                this.shx.shv.shi.yw(7);
                                this.shx.shv.byR();
                            }
                        }
                    });
                } catch (Exception e) {
                }
            }
        }
    };
    private View pwq;
    private View sgU;
    private ListView sgV;
    private a sgW;
    private a sgX;
    private b sgY;
    private c sgZ;
    private FTSMainUIHotWordLayout sha;
    private FTSMainUIEducationLayoutWithAll shb;
    private View shc;
    private TextView shd;
    private View she;
    private View shf;
    private View shg;
    private View shh;
    private b shi;
    private int shj;
    private boolean shk;
    private OnClickListener shl = new OnClickListener(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout.a aVar = (com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout.a) view.getTag();
            switch (aVar.fTP) {
                case 1:
                    if (this.shv.sgG) {
                        this.shv.shp = null;
                        this.shv.shq = 0;
                        this.shv.byU().clearText();
                        this.shv.byU().q(aVar.wiB, null);
                        this.shv.byU().bZc();
                        this.shv.shi.yw(13);
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putInt(Columns.TYPE, 0);
                            bundle.putBoolean("isHomePage", true);
                            bundle.putInt("scene", 20);
                            bundle = this.shv.iYF.l(4, bundle);
                            final Map hashMap = new HashMap();
                            hashMap.put("sceneActionType", "2");
                            hashMap.put("recommendId", this.shv.sha.bZh());
                            this.shv.handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass14 shz;

                                public final void run() {
                                    boolean a;
                                    if (this.shz.shv.rVm != null) {
                                        a = this.shz.shv.rVm.a(bundle.getString(Columns.TYPE, "0"), bundle.getString("isMostSearchBiz", "0"), bundle.getString("isSug", "0"), bundle.getString("scene", "0"), bundle.getString("isLocalSug", "0"), this.shz.shv.byX(), this.shz.shv.byY(), this.shz.shv.byZ(), 0, this.shz.shv.byS(), this.shz.shv.shq, hashMap);
                                    } else {
                                        a = false;
                                    }
                                    if (a) {
                                        this.shz.shv.byU().GR(this.shz.shv.ww(0));
                                        this.shz.shv.shi.yw(7);
                                        this.shz.shv.byR();
                                    }
                                }
                            });
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    }
                    return;
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.jumpUrl);
                    intent.putExtra("convertActivityFromTranslucent", false);
                    com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    break;
            }
            try {
                hashMap = new HashMap();
                hashMap.put("isclick", Integer.valueOf(1));
                hashMap.put("scene", Integer.valueOf(20));
                hashMap.put("recommendid", this.shv.sha.bZh());
                hashMap.put("businesstype", Integer.valueOf(0));
                hashMap.put("docid", aVar.wiB != null ? Uri.encode(aVar.wiB) : "");
                hashMap.put("docpos", Integer.valueOf(aVar.wiC + 1));
                hashMap.put("ishomepage", Integer.valueOf(1));
                hashMap.put("typepos", Integer.valueOf(1));
                hashMap.put("jumpurl", Uri.encode(aVar.jumpUrl));
                String n = d.n(hashMap);
                bundle = new Bundle();
                bundle.putString("logString", n);
                this.shv.iYF.d(131, bundle);
            } catch (Exception e2) {
                w.w("MicroMsg.FTS.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", new Object[]{e2.toString()});
            }
        }
    };
    private com.tencent.mm.plugin.webview.ui.tools.fts.a.a shm = new com.tencent.mm.plugin.webview.ui.tools.fts.a.a(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onAnimationEnd() {
            this.shv.shi.yw(4);
        }
    };
    private com.tencent.mm.plugin.webview.ui.tools.fts.c.a shn = new com.tencent.mm.plugin.webview.ui.tools.fts.c.a(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onAnimationEnd() {
            this.shv.shi.yw(9);
        }
    };
    private com.tencent.mm.plugin.webview.ui.tools.fts.b.a sho = new com.tencent.mm.plugin.webview.ui.tools.fts.b.a(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onAnimationEnd() {
            this.shv.shi.yw(3);
        }
    };
    private String shp;
    int shq;
    private OnClickListener shr = new OnClickListener(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onClick(View view) {
            c cVar = (c) view.getTag();
            if (cVar.type == 1) {
                Bundle bundle = new Bundle();
                bundle.putString("history", cVar.content);
                try {
                    this.shv.iYF.p(5, bundle);
                } catch (RemoteException e) {
                }
                af.v(new AnonymousClass2(this.shv.sgW, cVar));
            } else if (cVar.type == 2) {
                this.shv.sgW.clear();
                this.shv.byU().q(cVar.content, null);
                FTSSOSHomeWebViewUI.a(this.shv, cVar, 2);
                this.shv.shq = 2;
                this.shv.bzb();
            }
        }
    };
    private OnItemClickListener shs = new OnItemClickListener(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c wx = this.shv.sgW.wx(i);
            this.shv.byU().q(wx.content, null);
            if (wx.type == 2) {
                FTSSOSHomeWebViewUI.a(this.shv, wx, 1);
                this.shv.shq = 1;
            }
            this.shv.WV();
        }
    };
    private OnClickListener sht = new OnClickListener(this) {
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        {
            this.shv = r1;
        }

        public final void onClick(View view) {
            FTSSOSHomeWebViewUI.t(this.shv);
        }
    };
    private boolean shu;
    private TextView titleView;

    private class a extends BaseAdapter {
        private List<c> shA;
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ List shB;
            final /* synthetic */ a shC;

            AnonymousClass1(a aVar, List list) {
                this.shC = aVar;
                this.shB = list;
            }

            public final void run() {
                if (this.shC.shA.size() > 0) {
                    for (c cVar : this.shC.shA) {
                        if (!this.shB.contains(cVar)) {
                            this.shB.add(cVar);
                        }
                    }
                }
                this.shC.shA = this.shB;
                this.shC.notifyDataSetChanged();
            }
        }

        class AnonymousClass2 implements Runnable {
            final /* synthetic */ a shC;
            final /* synthetic */ c shD;

            AnonymousClass2(a aVar, c cVar) {
                this.shC = aVar;
                this.shD = cVar;
            }

            public final void run() {
                this.shC.shA.remove(this.shD);
                this.shC.notifyDataSetChanged();
            }
        }

        class AnonymousClass3 implements Runnable {
            final /* synthetic */ List shB;
            final /* synthetic */ a shC;

            AnonymousClass3(a aVar, List list) {
                this.shC = aVar;
                this.shB = list;
            }

            public final void run() {
                for (c cVar : this.shB) {
                    if (!this.shC.shA.contains(cVar)) {
                        this.shC.shA.add(cVar);
                    }
                }
                this.shC.notifyDataSetChanged();
            }
        }

        private class a {
            ImageView jbU;
            TextView kxh;
            final /* synthetic */ a shC;
            ImageView shE;

            public a(a aVar) {
                this.shC = aVar;
            }
        }

        private a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
            this.shv = fTSSOSHomeWebViewUI;
            this.shA = new ArrayList();
        }

        public final /* synthetic */ Object getItem(int i) {
            return wx(i);
        }

        public final void clear() {
            af.v(new Runnable(this) {
                final /* synthetic */ a shC;

                {
                    this.shC = r1;
                }

                public final void run() {
                    this.shC.shA.clear();
                    this.shC.notifyDataSetChanged();
                }
            });
        }

        public final int getCount() {
            return this.shA.size() > 6 ? 6 : this.shA.size();
        }

        public final c wx(int i) {
            return (c) this.shA.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a(this);
                view = LayoutInflater.from(this.shv.uSU.uTo).inflate(R.i.doS, null);
                aVar2.jbU = (ImageView) view.findViewById(R.h.bWx);
                aVar2.kxh = (TextView) view.findViewById(R.h.bGD);
                aVar2.shE = (ImageView) view.findViewById(R.h.cHi);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            c wx = wx(i);
            wx.position = i;
            if (wx.icon != 0) {
                aVar.jbU.setVisibility(0);
                aVar.jbU.setImageResource(wx.icon);
            } else {
                aVar.jbU.setVisibility(4);
            }
            if (wx.shK != 0) {
                aVar.shE.setVisibility(0);
                aVar.shE.setImageResource(wx.shK);
                aVar.shE.setTag(wx);
                aVar.shE.setOnClickListener(this.shv.shr);
            } else {
                aVar.shE.setVisibility(4);
            }
            aVar.kxh.setText(wx.content);
            return view;
        }
    }

    private class c {
        String content;
        int icon;
        int position;
        int shK;
        final /* synthetic */ FTSSOSHomeWebViewUI shv;
        int type;

        public c(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
            this.shv = fTSSOSHomeWebViewUI;
        }

        public final boolean equals(Object obj) {
            return this.content.equals(((c) obj).content);
        }
    }

    private class b extends com.tencent.mm.sdk.d.d {
        com.tencent.mm.sdk.d.c shF = new a(this);
        com.tencent.mm.sdk.d.c shG = new d(this);
        com.tencent.mm.sdk.d.c shH = new b(this);
        com.tencent.mm.sdk.d.c shI = new c(this);
        final /* synthetic */ FTSSOSHomeWebViewUI shv;

        private class a extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ b shJ;

            public a(b bVar) {
                this.shJ = bVar;
            }

            public final void enter() {
                super.enter();
                FTSSOSHomeWebViewUI.x(this.shJ.shv);
            }

            public final void exit() {
                super.exit();
            }

            public final boolean f(Message message) {
                switch (message.what) {
                    case 0:
                    case 13:
                        if (this.shJ.shv.byX().length() > 0) {
                            this.shJ.shv.byU().bZc();
                            this.shJ.shv.byU().vqz.clearFocus();
                            this.shJ.shv.wv(0);
                            this.shJ.shv.sgX.wy(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sid);
                            FTSSOSHomeWebViewUI.e(this.shJ.shv, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sid);
                            this.shJ.shv.sgz.setBackgroundResource(R.e.white);
                            this.shJ.shv.sgW.clear();
                            break;
                        }
                        break;
                    case 1:
                        this.shJ.shv.byU().bZc();
                        this.shJ.shv.sgY.wy(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sid);
                        FTSSOSHomeWebViewUI.e(this.shJ.shv, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sid);
                        this.shJ.shv.sgz.setBackgroundResource(R.e.white);
                        this.shJ.shv.sgW.clear();
                        this.shJ.shv.shk = true;
                        break;
                    case 3:
                        this.shJ.shv.sgF = true;
                        this.shJ.b(this.shJ.shG);
                        break;
                    case 4:
                        this.shJ.shv.sgF = true;
                        this.shJ.b(this.shJ.shH);
                        break;
                    case 5:
                        if (this.shJ.shv.byU().vqz.hasFocus() && this.shJ.shv.byX().length() > 0) {
                            this.shJ.shv.bzb();
                            break;
                        }
                }
                return super.f(message);
            }

            public final String getName() {
                return "InitSate";
            }
        }

        private class b extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ b shJ;

            public b(b bVar) {
                this.shJ = bVar;
            }

            public final void enter() {
                super.enter();
                this.shJ.shv.sgA.vqz.clearFocus();
                this.shJ.shv.sgU.setVisibility(0);
                this.shJ.shv.sgz.setPadding(this.shJ.shv.shj, 0, 0, 0);
                this.shJ.shv.byU().bZc();
                this.shJ.shv.sgB.setVisibility(0);
                this.shJ.shv.nVk.setVisibility(8);
                this.shJ.shv.shf.setVisibility(0);
                this.shJ.shv.sgW.clear();
                this.shJ.shv.shh.setVisibility(0);
                this.shJ.shv.pfZ.setVisibility(8);
                this.shJ.shv.sha.setVisibility(8);
                if (!this.shJ.shv.shk) {
                    this.shJ.shv.shc.setVisibility(0);
                }
                this.shJ.shv.byU().jbU.setVisibility(8);
                this.shJ.shv.pwq.setVisibility(0);
                if (com.tencent.mm.compatible.util.d.eo(23) && !h.sf()) {
                    this.shJ.shv.setStatusBarColor(this.shJ.shv.getResources().getColor(R.e.white));
                }
            }

            public final void exit() {
                super.exit();
            }

            public final boolean f(Message message) {
                switch (message.what) {
                    case 2:
                        FTSSOSHomeWebViewUI.I(this.shJ.shv);
                        this.shJ.shv.shc.setVisibility(8);
                        this.shJ.shv.wv(0);
                        this.shJ.shv.sgX.wy(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic);
                        FTSSOSHomeWebViewUI.e(this.shJ.shv, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic);
                        break;
                    case 3:
                    case 4:
                        this.shJ.b(this.shJ.shF);
                        break;
                    case 5:
                        if (this.shJ.shv.byU().vqz.hasFocus()) {
                            this.shJ.b(this.shJ.shG);
                            break;
                        }
                        break;
                }
                return super.f(message);
            }

            public final String getName() {
                return "SearchNoFocusState";
            }
        }

        private class c extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ b shJ;

            public c(b bVar) {
                this.shJ = bVar;
            }

            public final void enter() {
                super.enter();
                this.shJ.shv.sgz.setPadding(this.shJ.shv.shj, 0, 0, 0);
                this.shJ.shv.byU().bZc();
                this.shJ.shv.sgB.setVisibility(0);
                this.shJ.shv.nVk.setVisibility(8);
                this.shJ.shv.shf.setVisibility(0);
                this.shJ.shv.shh.setVisibility(0);
                this.shJ.shv.pfZ.setVisibility(8);
                this.shJ.shv.sha.setVisibility(8);
                this.shJ.shv.shc.setVisibility(8);
                this.shJ.shv.byU().bZb();
                this.shJ.shv.pwq.setVisibility(0);
            }

            public final boolean f(Message message) {
                switch (message.what) {
                    case 0:
                        if (this.shJ.shv.byX().length() > 0) {
                            this.shJ.shv.byU().bZc();
                            this.shJ.shv.byU().vqz.clearFocus();
                            this.shJ.shv.sgW.clear();
                            this.shJ.b(this.shJ.shH);
                            break;
                        }
                        break;
                    case 2:
                        FTSSOSHomeWebViewUI.I(this.shJ.shv);
                        this.shJ.shv.shc.setVisibility(8);
                        this.shJ.shv.wv(0);
                        c J = this.shJ.shv.sgZ;
                        int i = com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic;
                        if (i != J.shT) {
                            ObjectAnimator ofFloat;
                            ObjectAnimator ofFloat2;
                            ObjectAnimator ofFloat3;
                            ObjectAnimator ofFloat4;
                            ObjectAnimator ofFloat5;
                            AnimatorSet animatorSet;
                            switch (com.tencent.mm.plugin.webview.ui.tools.fts.c.AnonymousClass2.shZ[i - 1]) {
                                case 1:
                                    ofFloat = ObjectAnimator.ofFloat(J.shN, "y", new float[]{J.shS[0][1], J.shS[0][0]});
                                    ofFloat2 = ObjectAnimator.ofFloat(J.shN, "x", new float[]{J.shS[1][1], J.shS[1][0]});
                                    ofFloat3 = ObjectAnimator.ofFloat(J.shM, "alpha", new float[]{0.0f, 1.0f});
                                    ofFloat4 = ObjectAnimator.ofFloat(J.shP, "alpha", new float[]{0.0f, 1.0f});
                                    ofFloat5 = ObjectAnimator.ofFloat(J.shQ, "alpha", new float[]{1.0f, 0.0f});
                                    ValueAnimator.ofInt(new int[]{J.shV, J.shU}).addUpdateListener(new AnimatorUpdateListener(J) {
                                        final /* synthetic */ c sij;

                                        {
                                            this.sij = r1;
                                        }

                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            this.sij.shN.setPadding(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0, 0, 0);
                                        }
                                    });
                                    ValueAnimator.ofInt(new int[]{c.shL, 0}).addUpdateListener(new AnimatorUpdateListener(J) {
                                        final /* synthetic */ c sij;

                                        {
                                            this.sij = r1;
                                        }

                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                            w.i("MicroMsg.FTS.SosAnimatorController", "widthSearchBarAnimator value : %d", new Object[]{Integer.valueOf(intValue)});
                                            LayoutParams layoutParams = (LayoutParams) this.sij.shN.getLayoutParams();
                                            layoutParams.leftMargin = c.shL - intValue;
                                            layoutParams.rightMargin = c.shL - intValue;
                                            layoutParams.width = (intValue * 2) + ((int) this.sij.shS[2][0]);
                                            this.sij.shN.requestLayout();
                                        }
                                    });
                                    animatorSet = new AnimatorSet();
                                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat, r8, ofFloat3, ofFloat4, ofFloat5, r7});
                                    animatorSet.setDuration(300);
                                    animatorSet.addListener(new AnimatorListener(J) {
                                        final /* synthetic */ c sij;

                                        {
                                            this.sij = r1;
                                        }

                                        public final void onAnimationStart(Animator animator) {
                                            this.sij.nKt = true;
                                            this.sij.shP.setVisibility(0);
                                            this.sij.shM.setVisibility(0);
                                            this.sij.shR.setVisibility(8);
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            this.sij.nKt = false;
                                            if (this.sij.sii != null) {
                                                this.sij.sii.onAnimationEnd();
                                            }
                                            this.sij.shO.setVisibility(0);
                                            this.sij.shN.setPadding(0, 0, 0, 0);
                                            this.sij.shQ.setAlpha(1.0f);
                                            this.sij.shQ.setVisibility(8);
                                        }

                                        public final void onAnimationCancel(Animator animator) {
                                            this.sij.nKt = false;
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }
                                    });
                                    animatorSet.start();
                                    break;
                                case 2:
                                    ofFloat = ObjectAnimator.ofFloat(J.shN, "y", new float[]{J.shS[0][0], J.shS[0][1]});
                                    ofFloat2 = ObjectAnimator.ofFloat(J.shN, "x", new float[]{J.shS[1][0], J.shS[1][1]});
                                    ofFloat3 = ObjectAnimator.ofFloat(J.shM, "alpha", new float[]{1.0f, 0.0f});
                                    ofFloat4 = ObjectAnimator.ofFloat(J.shP, "alpha", new float[]{1.0f, 0.0f});
                                    ofFloat5 = ObjectAnimator.ofFloat(J.shQ, "alpha", new float[]{0.0f, 1.0f});
                                    ValueAnimator.ofInt(new int[]{J.shU, J.shV}).addUpdateListener(new AnimatorUpdateListener(J) {
                                        final /* synthetic */ c sij;

                                        {
                                            this.sij = r1;
                                        }

                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            this.sij.shN.setPadding(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0, 0, 0);
                                        }
                                    });
                                    ValueAnimator.ofInt(new int[]{0, c.shL}).addUpdateListener(new AnimatorUpdateListener(J) {
                                        final /* synthetic */ c sij;

                                        {
                                            this.sij = r1;
                                        }

                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                            LayoutParams layoutParams = (LayoutParams) this.sij.shN.getLayoutParams();
                                            layoutParams.leftMargin = c.shL - intValue;
                                            layoutParams.rightMargin = c.shL - intValue;
                                            layoutParams.width = (intValue * 2) + ((int) this.sij.shS[2][0]);
                                            this.sij.shN.setLayoutParams(layoutParams);
                                        }
                                    });
                                    animatorSet = new AnimatorSet();
                                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat, r8, ofFloat3, ofFloat4, ofFloat5, r7});
                                    animatorSet.setDuration(300);
                                    animatorSet.addListener(new AnimatorListener(J) {
                                        final /* synthetic */ c sij;

                                        {
                                            this.sij = r1;
                                        }

                                        public final void onAnimationStart(Animator animator) {
                                            this.sij.nKt = true;
                                            this.sij.shO.setVisibility(8);
                                            this.sij.shQ.setVisibility(0);
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            this.sij.nKt = false;
                                            if (this.sij.sii != null) {
                                                this.sij.sii.onAnimationEnd();
                                            }
                                            this.sij.shR.setVisibility(0);
                                            this.sij.shP.setAlpha(1.0f);
                                            this.sij.shP.setVisibility(8);
                                        }

                                        public final void onAnimationCancel(Animator animator) {
                                            this.sij.nKt = false;
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }
                                    });
                                    animatorSet.start();
                                    break;
                            }
                            J.shT = i;
                        }
                        FTSSOSHomeWebViewUI.e(this.shJ.shv, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic);
                        break;
                    case 5:
                        if (this.shJ.shv.byU().vqz.hasFocus()) {
                            this.shJ.b(this.shJ.shG);
                            break;
                        }
                        break;
                    case 9:
                        this.shJ.b(this.shJ.shF);
                        break;
                    case 10:
                        if (this.shJ.shv.byX().length() > 0) {
                            this.shJ.b(this.shJ.shH);
                            break;
                        }
                        break;
                }
                return super.f(message);
            }

            public final String getName() {
                return "SearchWithFocusNoResultState";
            }
        }

        private class d extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ b shJ;

            public d(b bVar) {
                this.shJ = bVar;
            }

            public final void enter() {
                super.enter();
                this.shJ.shv.sgU.setVisibility(0);
                this.shJ.shv.sgz.setPadding(0, 0, 0, 0);
                this.shJ.shv.shc.setVisibility(8);
                this.shJ.shv.bzc();
                this.shJ.shv.byU().bZb();
                this.shJ.shv.shh.setVisibility(8);
                this.shJ.shv.pfZ.setVisibility(8);
                this.shJ.shv.sha.setVisibility(8);
                this.shJ.shv.pwq.setVisibility(0);
                if (!this.shJ.shv.byU().vqz.hasFocus()) {
                    this.shJ.shv.byU().bYZ();
                    this.shJ.shv.aHj();
                }
                if (com.tencent.mm.compatible.util.d.eo(23) && !h.sf()) {
                    this.shJ.shv.setStatusBarColor(this.shJ.shv.getResources().getColor(R.e.white));
                }
                if (!TextUtils.isEmpty(this.shJ.shv.byY())) {
                    this.shJ.shv.byU().wia.setVisibility(0);
                }
            }

            public final void exit() {
                super.exit();
            }

            public final boolean f(Message message) {
                switch (message.what) {
                    case 0:
                    case 11:
                        if (this.shJ.shv.byX().length() > 0) {
                            this.shJ.b(this.shJ.shH);
                            break;
                        }
                        break;
                    case 2:
                        FTSSOSHomeWebViewUI.I(this.shJ.shv);
                        this.shJ.shv.shc.setVisibility(8);
                        this.shJ.shv.wv(0);
                        this.shJ.shv.sgY.wy(com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic);
                        FTSSOSHomeWebViewUI.e(this.shJ.shv, com.tencent.mm.plugin.webview.ui.tools.fts.a.b.sic);
                        break;
                    case 3:
                    case 4:
                        this.shJ.b(this.shJ.shF);
                        break;
                    case 5:
                        if (!this.shJ.shv.byU().vqz.hasFocus()) {
                            this.shJ.b(this.shJ.shI);
                            break;
                        }
                        break;
                    case 12:
                        if (TextUtils.isEmpty(this.shJ.shv.byX())) {
                            BaseSOSWebViewUI baseSOSWebViewUI = this.shJ.shv;
                            c cVar = (baseSOSWebViewUI.sgC == null || baseSOSWebViewUI.sgC.size() <= 0) ? null : (c) baseSOSWebViewUI.sgC.get(0);
                            if (cVar != null) {
                                this.shJ.shv.sgA.a(cVar.sgR, cVar.qGU, com.tencent.mm.ui.fts.widget.FTSEditTextView.b.UserInput);
                                this.shJ.b(this.shJ.shH);
                                break;
                            }
                        }
                        break;
                }
                return super.f(message);
            }

            public final String getName() {
                return "SearchWithFocusState";
            }
        }

        protected b(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, String str, Looper looper) {
            this.shv = fTSSOSHomeWebViewUI;
            super(str, looper);
            b(this.shF);
            b(this.shG);
            b(this.shH);
            b(this.shI);
            c(this.shF);
        }

        public final boolean bza() {
            com.tencent.mm.sdk.d.a bKi = bKi();
            return bKi == this.shG || bKi == this.shH || bKi == this.shI;
        }
    }

    static /* synthetic */ void I(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.shb.setVisibility(8);
        fTSSOSHomeWebViewUI.she.setVisibility(8);
    }

    static /* synthetic */ void a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, c cVar, int i) {
        Map hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(fTSSOSHomeWebViewUI.scene));
        hashMap.put("businessType", "0");
        hashMap.put("scene", Integer.valueOf(fTSSOSHomeWebViewUI.scene));
        hashMap.put("docid", cVar.content);
        hashMap.put("docpos", Integer.valueOf(cVar.position + 1));
        hashMap.put("typepos", Integer.valueOf(1));
        hashMap.put("suggestionid", fTSSOSHomeWebViewUI.shp);
        hashMap.put("clicktype", Integer.valueOf(i));
        hashMap.put("clicksource", Integer.valueOf(1));
        hashMap.put("sceneactiontype", Integer.valueOf(1));
        hashMap.put("h5version", Integer.valueOf(d.hPo));
        hashMap.put("query", fTSSOSHomeWebViewUI.byY());
        hashMap.put("sessionid", fTSSOSHomeWebViewUI.fFF);
        i.jZ(d.n(hashMap));
    }

    static /* synthetic */ void a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, String str, int i) {
        try {
            fTSSOSHomeWebViewUI.sha.c(new JSONObject(str), i);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void e(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI, int i) {
        fTSSOSHomeWebViewUI.sgZ.shT = i;
        fTSSOSHomeWebViewUI.sgY.shT = i;
        fTSSOSHomeWebViewUI.sgX.shT = i;
    }

    static /* synthetic */ void t(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        if (fTSSOSHomeWebViewUI.shb.getVisibility() == 0) {
            fTSSOSHomeWebViewUI.bzc();
        } else if (fTSSOSHomeWebViewUI.shb.getVisibility() != 0) {
            fTSSOSHomeWebViewUI.shb.setVisibility(0);
            fTSSOSHomeWebViewUI.she.setVisibility(0);
            fTSSOSHomeWebViewUI.shb.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(fTSSOSHomeWebViewUI) {
                final /* synthetic */ FTSSOSHomeWebViewUI shv;

                {
                    this.shv = r1;
                }

                public final boolean onPreDraw() {
                    this.shv.shb.getViewTreeObserver().removeOnPreDrawListener(this);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.shv.shb, View.TRANSLATION_Y, new float[]{(float) (-this.shv.shb.getHeight()), 0.0f});
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.shv.she, View.ALPHA, new float[]{0.0f, 1.0f});
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setInterpolator(new AccelerateInterpolator());
                    animatorSet.setDuration(300);
                    animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
                    animatorSet.start();
                    return true;
                }
            });
        }
    }

    static /* synthetic */ void x(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        fTSSOSHomeWebViewUI.titleView.setVisibility(0);
        fTSSOSHomeWebViewUI.shf.setVisibility(0);
        fTSSOSHomeWebViewUI.pfZ.setVisibility(0);
        fTSSOSHomeWebViewUI.sha.setVisibility(0);
        fTSSOSHomeWebViewUI.sgU.setVisibility(8);
        fTSSOSHomeWebViewUI.pwq.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.eo(23) && !h.sf()) {
            fTSSOSHomeWebViewUI.setStatusBarColor(fTSSOSHomeWebViewUI.getResources().getColor(R.e.aVP));
        }
        fTSSOSHomeWebViewUI.nVk.setVisibility(0);
        fTSSOSHomeWebViewUI.shc.setVisibility(8);
        fTSSOSHomeWebViewUI.shb.setVisibility(8);
        fTSSOSHomeWebViewUI.sgB.setVisibility(8);
        fTSSOSHomeWebViewUI.sgA.bZb();
        fTSSOSHomeWebViewUI.wv(0);
        fTSSOSHomeWebViewUI.pfZ.setVisibility(0);
        fTSSOSHomeWebViewUI.sha.setVisibility(0);
        fTSSOSHomeWebViewUI.sgD = 0;
        fTSSOSHomeWebViewUI.byU().vqz.clearFocus();
        fTSSOSHomeWebViewUI.sgW.clear();
        fTSSOSHomeWebViewUI.shk = false;
    }

    protected final void axz() {
        super.axz();
        this.shi = new b(this, "sos_home_webview_ui", getMainLooper());
        this.shh = findViewById(R.h.cIZ);
        this.shg = findViewById(R.h.cAl);
        this.she = findViewById(R.h.cjH);
        this.shc = findViewById(R.h.bKC);
        this.shd = (TextView) findViewById(R.h.bKB);
        this.shc.setOnClickListener(this.sht);
        this.shf = findViewById(R.h.cJa);
        this.titleView = (TextView) findViewById(R.h.cJh);
        this.sgU = findViewById(R.h.cSv);
        this.sgU.setVisibility(8);
        ((WebViewKeyboardLinearLayout) this.sgU).uRI = new com.tencent.mm.ui.KeyboardLinearLayout.a(this) {
            final /* synthetic */ FTSSOSHomeWebViewUI shv;

            {
                this.shv = r1;
            }

            public final void nx(int i) {
                if (i == -2) {
                    this.shv.shi.yw(12);
                }
                this.shv.seP = i;
            }
        };
        this.pfZ = (FTSMainUIEducationLayout) findViewById(R.h.cAF);
        this.pfZ.i(this.pgk);
        this.shb = (FTSMainUIEducationLayoutWithAll) findViewById(R.h.cAG);
        this.shb.i(this.pgk);
        this.sha = (FTSMainUIHotWordLayout) findViewById(R.h.cAJ);
        this.sha.i(this.shl);
        this.sgX = new a(this, this.sgz, this.titleView, byU().jbU, this.nVk, this.sgB, byU().vqz, this.shg);
        this.sgX.shW = this.shm;
        this.sgY = new b(this, this.sgz, this.titleView, this.nVk, this.sgB, this.shg, this.shh);
        this.sgY.sig = this.sho;
        this.sgZ = new c(this, this.sgz, this.titleView, byU().jbU, this.nVk, this.sgB, byU().vqz, this.shg);
        this.sgZ.sii = this.shn;
        this.sgV = (ListView) findViewById(R.h.cFY);
        this.sgW = new a();
        this.sgV.setAdapter(this.sgW);
        this.sgV.setOnItemClickListener(this.shs);
        this.pwq = findViewById(R.h.cFX);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            this.pfZ.U(new JSONObject(this.iYF.l(2, bundle).getString("result")));
        } catch (Exception e) {
        }
        try {
            bundle = new Bundle();
            bundle.putString("key", "tabSlice");
            this.shb.U(new JSONObject(this.iYF.l(2, bundle).getString("result")));
        } catch (Exception e2) {
        }
        this.uSU.ipu.postDelayed(new Runnable(this) {
            final /* synthetic */ FTSSOSHomeWebViewUI shv;

            {
                this.shv = r1;
            }

            public final void run() {
                int i = 0;
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("key", "discoverSearchEntry");
                    i = new JSONObject(this.shv.iYF.l(2, bundle).getString("result")).optInt("keyboardState");
                } catch (Exception e) {
                }
                if (i == 0) {
                    this.shv.byU().bYZ();
                    this.shv.byU().bYY();
                }
                this.shv.byU().bZi();
            }
        }, 128);
        this.sgV.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSSOSHomeWebViewUI shv;

            {
                this.shv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.shv.aHf();
                return false;
            }
        });
        findViewById(R.h.bGA).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSSOSHomeWebViewUI shv;

            {
                this.shv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.shv.byU().vqz.clearFocus();
                this.shv.aHf();
                return false;
            }
        });
        this.she.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSSOSHomeWebViewUI shv;

            {
                this.shv = r1;
            }

            public final void onClick(View view) {
                this.shv.bzc();
            }
        });
        this.titleView.setText(getIntent().getStringExtra("title"));
        this.shj = ((LayoutParams) this.titleView.getLayoutParams()).leftMargin - ((int) getResources().getDimension(R.f.bbf));
        this.shi.start();
        try {
            bundle = new Bundle();
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putInt("scene", 20);
            this.iYF.d(129, bundle);
        } catch (Exception e3) {
        }
    }

    protected final int WR() {
        if (!com.tencent.mm.compatible.util.d.eo(23) || h.sf()) {
            return super.WR();
        }
        return getResources().getColor(R.e.aVP);
    }

    public final void gM(boolean z) {
        super.gM(z);
        this.shi.yw(5);
    }

    protected final void byP() {
        super.byP();
        wv(this.sgD);
        byU().GR(ww(this.sgD));
    }

    private void bzb() {
        try {
            this.sgW.clear();
            w.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "start to update history");
            Bundle bundle = new Bundle();
            bundle.putInt("webview_id", hashCode());
            bundle.putString("query", byY());
            bundle.putInt("count", 6);
            bundle.putInt("scene", this.scene);
            this.iYF.p(3, bundle);
        } catch (RemoteException e) {
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, com.tencent.mm.ui.fts.widget.FTSEditTextView.b bVar) {
        if (bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.UserInput) {
            this.shq = 0;
        }
        if (this.shi.bza()) {
            super.a(str, str2, list, bVar);
        } else if (byX().length() == 0) {
            this.pfZ.setVisibility(0);
            this.sha.setVisibility(0);
            this.sgW.clear();
        } else {
            this.pfZ.setVisibility(8);
            this.sha.setVisibility(8);
            if (bVar != com.tencent.mm.ui.fts.widget.FTSEditTextView.b.SetText) {
                bzb();
            }
        }
    }

    public final boolean WV() {
        if (this.sgG) {
            this.shi.yw(0);
            super.WV();
        }
        return true;
    }

    private void wv(int i) {
        this.shb.BS(i);
        this.shd.setText(this.shb.BT(i));
        byU().v(d.a(i, this.uSU.uTo));
    }

    public final String byS() {
        if (this.shq == 0) {
            return "";
        }
        return this.shp;
    }

    protected final void byO() {
        super.byO();
        this.shi.yw(11);
    }

    public final int byT() {
        return this.shq;
    }

    protected final void byQ() {
        super.byQ();
        byU().GR(getString(R.l.dIz));
        this.shi.yw(2);
        this.sgz.setBackgroundResource(R.g.bki);
        this.sgU.setVisibility(8);
        this.pwq.setVisibility(8);
        if (this.rVm != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.rVm;
            String str = "0";
            String str2 = "0";
            String str3 = "0";
            String str4 = "20";
            String str5 = "0";
            if (dVar.sjS) {
                w.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", new Object[]{str, str2, str3, str4, str5});
                Map hashMap = new HashMap();
                hashMap.put(Columns.TYPE, str);
                hashMap.put("isMostSearchBiz", str2);
                hashMap.put("isSug", str3);
                hashMap.put("isLocalSug", str5);
                hashMap.put("scene", str4);
                af.v(new AnonymousClass28(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("switchToTabSearch", hashMap, dVar.sjU, dVar.sjV)));
            } else {
                w.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
            }
        }
        this.shp = null;
        this.shq = 0;
    }

    protected final int getLayoutId() {
        return R.i.doQ;
    }

    protected final String getHint() {
        return getString(R.l.dIz);
    }

    protected final void p(int i, final Bundle bundle) {
        int i2 = 0;
        super.p(i, bundle);
        List arrayList;
        switch (i) {
            case 119:
                this.shi.yw(8);
                return;
            case 122:
                this.shi.yw(10);
                return;
            case 126:
                arrayList = new ArrayList();
                if (byU().vqz.hasFocus()) {
                    String string = bundle.getString("query");
                    if (byY().equals(string)) {
                        for (String str : bundle.getStringArrayList("result")) {
                            if (d.af(str, string)) {
                                i2++;
                                if (i2 <= 2) {
                                    c cVar = new c(this);
                                    cVar.type = 1;
                                    cVar.icon = R.k.dzG;
                                    cVar.content = str;
                                    cVar.shK = R.g.bkh;
                                    arrayList.add(cVar);
                                }
                            }
                        }
                    }
                }
                af.v(new AnonymousClass1(this.sgW, arrayList));
                return;
            case 127:
                arrayList = new ArrayList();
                if (byU().vqz.hasFocus()) {
                    if (byY().equals(bundle.getString("query"))) {
                        this.shp = bundle.getString("suggestionId");
                        for (String str2 : bundle.getStringArrayList("result")) {
                            c cVar2 = new c(this);
                            cVar2.type = 2;
                            cVar2.icon = 0;
                            cVar2.content = str2;
                            cVar2.shK = R.g.bkj;
                            arrayList.add(cVar2);
                        }
                    }
                }
                af.v(new AnonymousClass3(this.sgW, arrayList));
                return;
            case 130:
                af.v(new Runnable(this) {
                    final /* synthetic */ FTSSOSHomeWebViewUI shv;

                    public final void run() {
                        FTSSOSHomeWebViewUI.a(this.shv, bundle.getString("fts_key_json_data"), bundle.getInt("fts_key_is_cache_data", 0));
                        this.shv.sha.setVisibility(this.shv.pfZ.getVisibility());
                    }
                });
                return;
            default:
                return;
        }
    }

    private String ww(int i) {
        int i2 = -1;
        switch (i) {
            case 1:
                i2 = R.l.ePQ;
                break;
            case 2:
                i2 = R.l.ePP;
                break;
            case 8:
                i2 = R.l.enl;
                break;
            case 16:
                i2 = R.l.enk;
                break;
            case 64:
                i2 = R.l.dDY;
                break;
            case FileUtils.S_IWUSR /*128*/:
                i2 = R.l.enh;
                break;
            case 256:
            case 384:
                i2 = R.l.eng;
                break;
            case 512:
                i2 = R.l.eni;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.l.enj;
                break;
        }
        if (i2 < 0) {
            return getString(R.l.dIz);
        }
        return getString(R.l.ePO, new Object[]{getString(i2)});
    }

    private void bzc() {
        if (this.shb.getVisibility() == 0 && !this.shu) {
            this.shu = true;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.shb, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.shb.getHeight())});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.she, View.ALPHA, new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300);
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            animatorSet.addListener(new AnimatorListener(this) {
                final /* synthetic */ FTSSOSHomeWebViewUI shv;

                {
                    this.shv = r1;
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    this.shv.shb.setVisibility(8);
                    this.shv.she.setVisibility(8);
                    this.shv.shu = false;
                }

                public final void onAnimationCancel(Animator animator) {
                    this.shv.shb.setVisibility(8);
                    this.shv.she.setVisibility(8);
                    this.shv.shu = false;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            animatorSet.start();
        }
    }

    public void onBackPressed() {
        if (this.shb.getVisibility() == 0) {
            bzc();
        } else {
            super.onBackPressed();
        }
        byU().bZc();
    }

    public final boolean bza() {
        return this.shi.bza();
    }
}
