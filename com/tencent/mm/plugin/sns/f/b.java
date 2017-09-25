package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    private boolean fGu = true;
    public Context mContext;
    private int pPk = -1;
    public final int pZj = 14;
    private com.tencent.mm.plugin.sns.ui.b.b pZk;
    private FrameLayout pZl;
    AbsoluteLayout pZm = null;
    protected Animation pZn;
    protected Animation pZo;
    public boolean pZp = false;
    int[] pZq = new int[]{j.pKe, j.pKf, j.pKg, j.pKh};
    private int[] pZr = new int[]{i.pIN, i.pIP, i.pIO, i.pIM};
    private int[] pZs = this.pZq;
    private int[] pZt;
    private int[] pZu;
    public Map<Long, b> pZv = new HashMap();
    private Map<Long, b> pZw = new HashMap();
    private HashSet<Long> pZx = new HashSet();
    public h pZy = null;
    private HashMap<Long, Boolean> pZz = new HashMap();

    class a {
        View pOr = null;
        long pQL;
        final /* synthetic */ b pZD;
        String pZF;
        com.tencent.mm.plugin.sns.storage.b pZG;

        public a(b bVar, String str, View view, long j, com.tencent.mm.plugin.sns.storage.b bVar2) {
            this.pZD = bVar;
            this.pZF = str;
            this.pOr = view;
            this.pZG = bVar2;
            this.pQL = j;
        }
    }

    static class b {
        long hTn;
        StringBuffer pZH = new StringBuffer();
        String pZI;
        long pZJ;
        long pZK;
        String pZL;
        String pZM;

        public b(long j, String str, String str2, String str3, String str4) {
            this.pZI = str;
            this.pZL = str2;
            this.pZM = str3;
            this.hTn = j;
            this.pZJ = System.currentTimeMillis();
            this.pZH.append("1:0:" + str4);
        }

        public b(long j, String str, String str2, String str3) {
            this.pZI = str;
            this.pZL = str2;
            this.pZM = str3;
            this.hTn = j;
            this.pZJ = System.currentTimeMillis();
            this.pZH.append("0:0:");
        }

        public final void FM(String str) {
            w.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult " + str);
            if (this.pZH.length() != 0) {
                this.pZH.append("|");
            }
            this.pZH.append(str);
        }

        public final void qg() {
            this.pZK = System.currentTimeMillis();
            w.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.hTn + " uxinfo:" + this.pZI + " actionresult: " + this.pZH + " " + this.pZJ + " " + this.pZK);
            g.oUh.i(11988, new Object[]{this.pZM, this.pZL, "", "", com.tencent.mm.plugin.sns.data.i.df(this.hTn), this.pZI, this.pZH, Long.valueOf(this.pZJ / 1000), Long.valueOf(this.pZK / 1000)});
        }
    }

    public final void a(int i, String str, long j, String str2, bfc com_tencent_mm_protocal_c_bfc, boolean z, be beVar) {
        if (z && this.fGu && this.pZy != null && beVar != null) {
            this.pZx.add(Long.valueOf(j));
            this.pZw.put(Long.valueOf(j), new b(j, this.pZy.pZL, this.pZy.pZM, beVar.bll()));
        }
    }

    public final void a(int i, String str, long j, String str2, bfc com_tencent_mm_protocal_c_bfc, boolean z) {
        if (z && this.fGu) {
            if (this.pZx.contains(Long.valueOf(j))) {
                boolean z2 = false;
                if (this.pZz.containsKey(Long.valueOf(j))) {
                    z2 = ((Boolean) this.pZz.get(Long.valueOf(j))).booleanValue();
                }
                if (z2) {
                    b bVar = (b) this.pZw.get(Long.valueOf(j));
                    if (bVar != null) {
                        bVar.qg();
                    }
                }
            }
            this.pZw.remove(Long.valueOf(j));
            this.pZx.remove(Long.valueOf(j));
        }
    }

    public final void a(b bVar) {
        this.pZv.remove(Long.valueOf(bVar.hTn));
        bVar.qg();
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.b.b bVar, FrameLayout frameLayout) {
        g beD = ae.beD();
        h hVar = new h();
        c dX = com.tencent.mm.u.c.c.Az().dX("100007");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            if (bKK != null) {
                w.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + dX.field_expId + " " + dX.field_layerId + " " + dX.field_startTime + " " + dX.field_endTime);
                hVar.e(dX.field_layerId, dX.field_expId, bKK);
            }
        } else {
            w.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            hVar = null;
        }
        beD.qaA = hVar;
        this.pZy = ae.beD().bfD();
        if (this.pZy != null) {
            this.pZt = this.pZy.qaC;
            if (!this.pZy.bfE()) {
                this.fGu = false;
            }
        }
        this.mContext = context;
        this.pZk = bVar;
        this.pZl = frameLayout;
        this.pZn = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.pZn = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.pyR);
        this.pZo = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.pZo = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.sns.i.a.pyS);
    }

    public final int cq(View view) {
        if (this.pZp) {
            return 0;
        }
        if (this.pZm != null) {
            if (this.pZm.getTag() instanceof a) {
                final View view2 = ((a) this.pZm.getTag()).pOr;
                this.pZp = true;
                view2.startAnimation(this.pZo);
                this.pZo.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b pZD;

                    public final void onAnimationStart(Animation animation) {
                        this.pZD.pZp = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            this.pZD.bfB();
                        }
                        this.pZD.pZp = false;
                    }
                });
            } else {
                bfB();
            }
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return 0;
        } else {
            if (!this.fGu || this.pZy == null) {
                return 2;
            }
            boolean booleanValue;
            int i;
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            long j = bVar.pQL;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.pQK.qKz;
            if (this.pZz.containsKey(Long.valueOf(j))) {
                booleanValue = ((Boolean) this.pZz.get(Long.valueOf(j))).booleanValue();
            } else if (this.pZy == null) {
                booleanValue = false;
            } else if (bVar2 == null) {
                booleanValue = false;
            } else {
                for (i = 0; i < this.pZy.qao.size(); i++) {
                    if (bg.mA(a((a) this.pZy.qao.get(i), bVar2.qev))) {
                        this.pZz.put(Long.valueOf(j), Boolean.valueOf(false));
                        booleanValue = false;
                        break;
                    }
                }
                this.pZz.put(Long.valueOf(j), Boolean.valueOf(true));
                booleanValue = true;
            }
            if (!booleanValue) {
                return 2;
            }
            int length;
            int i2;
            String str = bVar.fGN;
            this.pZv.put(Long.valueOf(bVar.pQL), new b(bVar.pQL, bVar.pQK.bll(), this.pZy.pZL, this.pZy.pZM, this.mContext.getString(j.pKl)));
            if (this.pZx.contains(Long.valueOf(bVar.pQL))) {
                this.pZx.remove(Long.valueOf(bVar.pQL));
            }
            this.pZm = new AbsoluteLayout(this.mContext);
            this.pZm.setId(f.cTF);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.pZl.addView(this.pZm);
            final View inflate = r.eC(this.mContext).inflate(com.tencent.mm.plugin.sns.i.g.pGE, null);
            r12 = new TextView[3];
            ImageView[] imageViewArr = new ImageView[]{(TextView) inflate.findViewById(f.pAK), (TextView) inflate.findViewById(f.pAP), (TextView) inflate.findViewById(f.pAO)};
            imageViewArr[0] = (ImageView) inflate.findViewById(f.pAL);
            imageViewArr[1] = (ImageView) inflate.findViewById(f.pAN);
            imageViewArr[2] = (ImageView) inflate.findViewById(f.pAM);
            i = 0;
            if (!t.dp(bVar.pQL)) {
                for (int i3 : this.pZt) {
                    if (i3 == 3) {
                        i++;
                    }
                }
            }
            int i32 = 0;
            for (int i22 : this.pZt) {
                if (i22 == 0) {
                    i32++;
                }
            }
            if (i32 + i > 0) {
                length = (this.pZt.length - i32) - i;
                if (length == 0) {
                    return 2;
                }
                this.pZu = new int[length];
            } else {
                this.pZu = new int[this.pZt.length];
            }
            length = 0;
            i32 = 0;
            while (length < this.pZt.length) {
                if (this.pZt[length] != 0 && (i <= 0 || this.pZt[length] != 3)) {
                    this.pZu[i32] = this.pZt[length];
                    i32++;
                }
                length++;
            }
            if (t.do(bVar.pQL)) {
                for (length = 0; length < this.pZu.length; length++) {
                    if (this.pZu[length] == 3) {
                        this.pZu[length] = 4;
                        break;
                    }
                }
            }
            i = 0;
            int fromDPToPix = ((com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12) * 2) + (com.tencent.mm.bg.a.fromDPToPix(this.mContext, 8) * 2)) + com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12);
            for (int i4 = 0; i4 < this.pZu.length; i4++) {
                int i5;
                i32 = this.pZu[i4];
                i22 = this.pZu[i4] - 1;
                r12[i4].setText(this.pZs[i22]);
                TextView textView = r12[i4];
                Paint paint = new Paint();
                String charSequence = textView.getText().toString();
                paint.setTextSize(textView.getTextSize());
                length = ((int) paint.measureText(charSequence, 0, charSequence.length())) + fromDPToPix;
                if (length > i) {
                    i5 = length;
                } else {
                    i5 = i;
                }
                r12[i4].setCompoundDrawablePadding(com.tencent.mm.bg.a.fromDPToPix(this.mContext, 8));
                r12[i4].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.pZr[i22]), null, null, null);
                if (i22 == 1) {
                    imageViewArr[i4].setVisibility(0);
                } else {
                    imageViewArr[i4].setVisibility(8);
                }
                r12[i4].setTag(bVar);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                final View view3 = view;
                r12[i4].setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b pZD;

                    public final void onClick(View view) {
                        b bVar = this.pZD;
                        int i = i32;
                        com.tencent.mm.plugin.sns.data.b bVar2 = bVar3;
                        View view2 = inflate;
                        AbsoluteLayout absoluteLayout = this.pZD.pZm;
                        w.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i + " " + bVar2.pQL);
                        b bVar3 = (b) bVar.pZv.get(Long.valueOf(bVar2.pQL));
                        if (bVar3 != null) {
                            bVar3.FM("1:" + (i == 4 ? 3 : i) + ":" + bVar.mContext.getString(bVar.pZq[i - 1]));
                        }
                        if (i == 1) {
                            m Gg = ae.beL().Gg(bVar2.fGN);
                            if (Gg != null) {
                                if (Gg.tE(32)) {
                                    com.tencent.mm.plugin.sns.storage.a bhc = Gg.bhc();
                                    String str = bhc == null ? "" : bhc.iHN;
                                    g.oUh.i(11855, new Object[]{Integer.valueOf(1), Integer.valueOf(3), str});
                                }
                                ae.beN().delete(Gg.field_snsId);
                                ae.beP().dB(Gg.field_snsId);
                                k qVar = new q(Gg.field_snsId, 8);
                                h.vJ();
                                h.vH().gXC.a(qVar, 0);
                                bVar.a(bVar3);
                                bVar.bfB();
                            }
                        } else if (i == 2) {
                            bVar.a(view2, absoluteLayout, bVar2);
                        } else if (i == 3) {
                            if (!t.do(bVar2.pQL)) {
                                t.dm(bVar2.pQL);
                            }
                            bVar.a(bVar3);
                            bVar.bfB();
                        } else if (i == 4) {
                            if (t.do(bVar2.pQL)) {
                                t.dn(bVar2.pQL);
                            }
                            bVar.a(bVar3);
                            bVar.bfB();
                        }
                    }
                });
                i = i5;
            }
            for (length = 0; length < this.pZu.length; length++) {
                r12[length].setMaxWidth(i);
            }
            for (length = this.pZu.length; length < 3; length++) {
                r12[length].setVisibility(8);
            }
            Rect rect = new Rect();
            length = com.tencent.mm.pluginsdk.e.dr(this.mContext);
            int[] blm = bVar.pQK.blm();
            w.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + blm[0] + "  " + blm[1] + " height: " + length);
            i += com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12);
            i22 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 17.0f);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 2.0f);
            this.pPk = com.tencent.mm.pluginsdk.e.ds(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(i, -2, (blm[0] - i) - a, ((blm[1] - this.pPk) - length) + i22);
            this.pZm.setTag(new a(this, str, inflate, bVar.pQL, bVar.pQK.qKz));
            this.pZm.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.pZp = true;
            final View view4 = view;
            new com.tencent.mm.sdk.platformtools.ae().post(new Runnable(this) {
                final /* synthetic */ b pZD;

                public final void run() {
                    this.pZD.c(view4, inflate);
                }
            });
            return 1;
        }
    }

    final void a(View view, AbsoluteLayout absoluteLayout, com.tencent.mm.plugin.sns.data.b bVar) {
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.pZy != null && bVar.pQK != null && bVar.pQK.qKz != null) {
            int i;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.pQK.qKz;
            Paint paint = new Paint(1);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 12.0f);
            int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 10.0f);
            int a3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 150.0f);
            List<TextView> linkedList = new LinkedList();
            float a4 = (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 17.0f)) * com.tencent.mm.bg.a.dI(this.mContext)) + ((float) (a2 * 2));
            int i2 = (int) a4;
            int i3 = 0;
            for (i = 0; i < this.pZy.qao.size(); i++) {
                a aVar = (a) this.pZy.qao.get(i);
                final View textView = new TextView(this.mContext);
                textView.setPadding(a, a2, a, a2);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyY));
                Object a5 = a(aVar, bVar2.qev);
                textView.setText(a5);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i3 = Math.max(i3, ((int) paint.measureText(a5)) + (a * 2));
                textView.setTag(Integer.valueOf(i));
                linkedList.add(textView);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b pZD;

                    public final void onClick(View view) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b bVar = (b) this.pZD.pZv.get(Long.valueOf(bVar3.pQL));
                        int i = ((a) this.pZD.pZy.qao.get(intValue)).pZe;
                        if (bVar != null) {
                            bVar.FM("3:" + i + ":" + textView.getText());
                        }
                        if (((a) this.pZD.pZy.qao.get(intValue)).pZi == 1) {
                            Intent intent = new Intent();
                            intent.setClass(this.pZD.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", bVar3.pQL);
                            intent.putExtra("sns_uxinfo", bVar.pZI);
                            intent.putExtra("action_st_time", bVar.pZJ);
                            intent.putExtra("sns_actionresult", bVar.pZH.toString());
                            ((MMActivity) this.pZD.mContext).startActivity(intent);
                            this.pZD.pZv.remove(Long.valueOf(bVar3.pQL));
                            this.pZD.bfB();
                            return;
                        }
                        this.pZD.a(bVar);
                        this.pZD.bfB();
                    }
                });
            }
            w.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i3 + " " + i2);
            if (i3 < a3) {
                i3 = a3;
            }
            for (TextView textView2 : linkedList) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = (int) a4;
                textView2.setLayoutParams(layoutParams);
            }
            Rect rect = new Rect();
            int dr = com.tencent.mm.pluginsdk.e.dr(this.mContext);
            int[] blm = bVar.pQK.blm();
            i = (blm[0] - i3) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 2.0f);
            int i4 = ((blm[1] - this.pPk) - dr) + i2;
            be beVar = bVar.pQK;
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, i, i4 - (beVar.qKv != null ? beVar.qKv.getHeight() : 0)));
        }
    }

    private static String a(a aVar, Map<String, String> map) {
        if (aVar == null) {
            return "";
        }
        String str;
        if (v.bIK()) {
            str = aVar.pZf;
        } else if (v.bIL()) {
            str = aVar.pZg;
        } else {
            str = aVar.pZh;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '$') {
                if (stringBuffer2.length() == 0) {
                    stringBuffer2.append(charAt);
                } else if (stringBuffer2.charAt(stringBuffer2.length() - 1) == '$') {
                    stringBuffer.append('$');
                    stringBuffer2 = new StringBuffer();
                } else {
                    String str2 = (String) map.get(stringBuffer2.substring(1));
                    if (str2 == null) {
                        return "";
                    }
                    stringBuffer.append(str2);
                }
            } else if (stringBuffer2.length() == 0) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer2.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public final void c(View view, View view2) {
        view.getTag();
        view2.setVisibility(0);
        this.pZp = true;
        this.pZn.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b pZD;

            {
                this.pZD = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.pZD.pZp = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.pZD.pZp = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(this.pZn);
    }

    public final boolean bfB() {
        boolean z = false;
        if (this.pZm != null) {
            if (this.pZm.getTag() instanceof a) {
                b bVar = (b) this.pZv.get(Long.valueOf(((a) this.pZm.getTag()).pQL));
                if (bVar != null) {
                    boolean z2 = (bVar.pZH == null || bVar.pZH.length() == 0) ? false : true;
                    if (z2) {
                        if (!(bVar.pZH == null || bVar.pZH.length() == 0 || !bVar.pZH.toString().startsWith("1:0"))) {
                            z = true;
                        }
                        if (z) {
                            bVar.FM("2:0:");
                        }
                        a(bVar);
                    } else {
                        bVar.FM("2:0:");
                        a(bVar);
                    }
                }
            }
            this.pZl.removeView(this.pZm);
            this.pZm = null;
            return true;
        }
        this.pZp = false;
        return false;
    }
}
