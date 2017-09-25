package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bo;
import com.tencent.mm.e.a.ga;
import com.tencent.mm.e.a.os;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.a.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;

public final class a {
    public static Context context = null;
    private static boolean pNA = false;
    private static String pNB = "0";
    private static OnClickListener pNC = null;
    public static int pND = -1;
    private static int pNE = -1;
    public static long pNF = 0;
    private static View pNG = null;
    private static b pNH = null;
    private static c pNI = null;
    private static com.tencent.mm.sdk.b.c pNJ = new com.tencent.mm.sdk.b.c<os>() {
        {
            this.usg = os.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            os osVar = (os) bVar;
            if (osVar instanceof os) {
                boolean z = osVar.fVL.fVM;
                long j = osVar.fVL.fLo;
                w.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
                if (!(j == 0 || a.pNF == 0 || a.pNF != j)) {
                    if (z) {
                        a.pND = 4;
                    } else {
                        a.pND = 3;
                    }
                    a.bdg();
                }
            }
            return false;
        }
    };
    private static com.tencent.mm.sdk.b.c pNK = new com.tencent.mm.sdk.b.c<ga>() {
        {
            this.usg = ga.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ga gaVar = (ga) bVar;
            if (gaVar instanceof ga) {
                boolean z = gaVar.fLm.fLn;
                long j = gaVar.fLm.fLo;
                w.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
                if (!(j == 0 || a.pNF == 0 || j != a.pNF)) {
                    if (z) {
                        a.pND = 2;
                    } else {
                        a.pND = 1;
                    }
                    a.bdg();
                }
            }
            return false;
        }
    };

    public static void b(Context context, ViewGroup viewGroup) {
        if (g.Ae().gu("7") != null) {
            pNA = true;
            pNB = g.Ae().gu("7").value;
            w.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[]{pNB});
            pNG = viewGroup;
            pNH = new b(viewGroup);
            context = context;
            com.tencent.mm.sdk.b.a.urY.b(pNJ);
            com.tencent.mm.sdk.b.a.urY.b(pNK);
            pNC = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() instanceof m) {
                        a.a(view, view.getContext(), (m) view.getTag());
                    }
                }
            };
            pNI = new c() {
                public final void c(m mVar) {
                    a.a(a.context, mVar);
                }

                public final void d(m mVar) {
                    a.b(a.context, mVar);
                }

                public final void e(m mVar) {
                    a.c(a.context, mVar);
                }
            };
            pNH.pNN = pNI;
        }
    }

    public static void a(View view, Context context, m mVar) {
        if (context != null) {
            if (mVar != null) {
                pNF = mVar.field_snsId;
            }
            b bVar = pNH;
            if (view != null && !bVar.pOg) {
                com.tencent.mm.sdk.b.a.urY.m(new bo());
                if (bVar.pOe) {
                    bVar.bdj();
                    return;
                }
                if (bVar.jkQ == 0) {
                    bVar.jkQ = e.ds(context);
                }
                if (bVar.Sa == 0) {
                    bVar.Sa = e.dr(context);
                }
                if (bVar.pNZ == 0) {
                    bVar.pNZ = view.getMeasuredHeight();
                    if (bVar.pNZ <= 0) {
                        bVar.pNZ = com.tencent.mm.bg.a.fromDPToPix(context, 15);
                    }
                }
                if (bVar.pOa <= 0) {
                    bVar.pOa = com.tencent.mm.bg.a.fromDPToPix(context, 8);
                }
                if (bVar.pOb <= 0) {
                    bVar.pOb = com.tencent.mm.bg.a.fromDPToPix(context, 3);
                }
                if (bVar.mScreenHeight == 0) {
                    bVar.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                    bVar.mScreenHeight -= bVar.Sa;
                    bVar.mScreenHeight -= bVar.jkQ;
                }
                if (bVar.pOc == 0) {
                    bVar.pOc = com.tencent.mm.bg.a.fromDPToPix(context, ck.CTRL_INDEX);
                }
                if (bVar.pOd == 0) {
                    bVar.pOd = com.tencent.mm.bg.a.fromDPToPix(context, 13);
                }
                bVar.pNS = new NotInterestMenu(context);
                if (bVar.pNN != null) {
                    bVar.pNS.pNN = bVar.pNN;
                }
                bVar.pNS.pNO = bVar.pNU;
                bVar.pNS.pyJ = mVar;
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                w.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", new Object[]{Arrays.toString(iArr)});
                int i = (((iArr[1] - bVar.jkQ) - bVar.Sa) + bVar.pNZ) - bVar.pOa;
                w.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.jkQ), Integer.valueOf(bVar.Sa), Integer.valueOf(bVar.pNZ), Integer.valueOf(bVar.pOa)});
                w.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bVar.pOc), Integer.valueOf(bVar.mScreenHeight)});
                if (bVar.pOc + i <= bVar.mScreenHeight) {
                    bVar.pNS.setBackgroundResource(i.e.pzS);
                    bVar.pOh = true;
                } else {
                    bVar.pNS.setBackgroundResource(i.e.pzT);
                    i = (((iArr[1] - bVar.jkQ) - bVar.Sa) - bVar.pOc) + bVar.pOb;
                    w.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.jkQ), Integer.valueOf(bVar.Sa), Integer.valueOf(bVar.pNZ), Integer.valueOf(bVar.pOb), Integer.valueOf(bVar.pOc)});
                    bVar.pOh = false;
                }
                if (bVar.pOf == null) {
                    bVar.pOf = new AbsoluteLayout(context);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bVar.pOf.setBackgroundDrawable(context.getResources().getDrawable(i.e.pzx));
                    bVar.pOf.setPadding(bVar.pOd, 0, bVar.pOd, 0);
                    bVar.pOf.setLayoutParams(layoutParams);
                }
                if (bVar.pNT != null) {
                    bVar.pNT.addView(bVar.pOf);
                }
                bVar.pOf.addView(bVar.pNS, new AbsoluteLayout.LayoutParams(-1, -2, 0, i));
                bVar.pNS.setVisibility(4);
                if (bVar.pOh) {
                    bVar.pNS.startAnimation(bVar.pNV);
                } else {
                    bVar.pNS.startAnimation(bVar.pNW);
                }
            }
        }
    }

    public static void bdf() {
        if (pNH != null) {
            pNH.bdj();
        }
    }

    private static void a(m mVar) {
        boolean equals = pNB.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (mVar.field_type == 1) {
            if (equals) {
                pNE = 5;
            } else {
                pNE = 0;
            }
        } else if (mVar.field_type == 2) {
            if (equals) {
                pNE = 4;
            } else {
                pNE = 1;
            }
        } else if (mVar.field_type == 15) {
            if (!equals) {
                pNE = 2;
            }
        } else if (!com.tencent.mm.plugin.sns.data.i.f(mVar)) {
        } else {
            if (equals) {
                pNE = 6;
            } else {
                pNE = 3;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, com.tencent.mm.plugin.sns.storage.m r7) {
        /*
        r0 = 2;
        r1 = 1;
        r2 = pNA;
        if (r2 == 0) goto L_0x004c;
    L_0x0006:
        if (r7 == 0) goto L_0x004c;
    L_0x0008:
        if (r6 == 0) goto L_0x004c;
    L_0x000a:
        r2 = r7.field_snsId;
        pNF = r2;
        a(r7);
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.class;
        r2.<init>(r6, r3);
        r3 = "sns_info_svr_id";
        r4 = pNF;
        r2.putExtra(r3, r4);
        r3 = "sns_info_not_interest_scene";
        r4 = pNA;
        if (r4 == 0) goto L_0x006a;
    L_0x0027:
        r4 = pNB;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x006a;
    L_0x002f:
        r4 = pNB;
        r5 = "1";
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0045;
    L_0x003a:
        r4 = pNB;
        r5 = "2";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x004d;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        r2.putExtra(r3, r0);
        r6.startActivity(r2);
    L_0x004c:
        return;
    L_0x004d:
        r4 = pNB;
        r5 = "3";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x006a;
    L_0x0058:
        r4 = com.tencent.mm.plugin.sns.data.i.f(r7);
        if (r4 == 0) goto L_0x0060;
    L_0x005e:
        r0 = 4;
        goto L_0x0046;
    L_0x0060:
        r4 = r7.field_type;
        if (r4 != r1) goto L_0x0066;
    L_0x0064:
        r0 = 3;
        goto L_0x0046;
    L_0x0066:
        r1 = r7.field_type;
        if (r1 == r0) goto L_0x0046;
    L_0x006a:
        r0 = 0;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.abtest.a.a(android.content.Context, com.tencent.mm.plugin.sns.storage.m):void");
    }

    public static void a(ContextMenu contextMenu, m mVar) {
        if (pNA && pNB.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && mVar != null && !mVar.tE(32) && !mVar.field_userName.equals(ae.ber()) && mVar.field_type != 15) {
            contextMenu.add(0, 13, 0, j.pLm);
        }
    }

    public static void b(Context context, m mVar) {
        if (mVar != null && context != null) {
            a(mVar);
            String str = mVar.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", mVar.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    public static void c(Context context, m mVar) {
        if (mVar != null && context != null) {
            a(mVar);
            Intent intent = new Intent();
            w.i("MicroMsg.NotInteresetABTestManager", "expose id " + mVar.bhe());
            intent.putExtra("showShare", false);
            intent.putExtra("k_expose_msg_id", mVar == null ? 0 : mVar.field_snsId);
            intent.putExtra("k_username", mVar == null ? "" : mVar.field_userName);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static void a(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (pNA && !bg.mA(pNB) && !pNB.equals("0")) {
            cVar.qMM = (ImageView) view.findViewById(f.pEP);
            cVar.qMM.setVisibility(8);
            cVar.qMN = false;
            if (!pNB.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                cVar.qMM.setOnClickListener(pNC);
            }
        }
    }

    public static void bdg() {
        if (pNA && pNF != 0) {
            String str = pND + "|" + pNE + "|" + pNF;
            g.Ae().gu("7").hoE = 4;
            g.Ae().gu("7").result = str;
            com.tencent.mm.u.a.f.a(g.Ae().gu("7"));
            w.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", new Object[]{Integer.valueOf(4), str});
        }
        pNE = -1;
        pND = -1;
        pNF = 0;
    }

    public static void b(m mVar) {
        if (pNA) {
            pNF = mVar.field_snsId;
            a(mVar);
        }
    }

    public static void clean() {
        pNE = -1;
        pND = -1;
        pNF = 0;
        pNC = null;
        pNI = null;
        pNG = null;
        context = null;
        pNA = false;
        pNB = "0";
        com.tencent.mm.u.a.f.gz("7");
        com.tencent.mm.sdk.b.a.urY.c(pNJ);
        com.tencent.mm.sdk.b.a.urY.c(pNK);
    }
}
