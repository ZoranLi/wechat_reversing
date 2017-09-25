package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.l;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI extends MMActivity implements com.tencent.mm.pluginsdk.ui.tools.p.a, com.tencent.mm.ui.bizchat.BizChatSearchListView.a {
    p kaB;
    String kbi;
    private OnScrollListener mxt = new OnScrollListener(this) {
        boolean kap = false;
        final /* synthetic */ BizChatSearchUI vvX;

        {
            this.vvX = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && this.kap && this.vvX.vvW.vwl) {
                a a = this.vvX.vvW;
                if (a.bTs() && !a.vwn) {
                    a.vwn = true;
                    ap.vd().a(new l(a.kbi, a.kwE, a.vwr), 0);
                    a.bTu();
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3) {
                this.kap = true;
            } else {
                this.kap = false;
            }
        }
    };
    private int scene;
    private String vvS;
    private c vvT;
    BizChatSearchListView vvU;
    TextView vvV;
    private a vvW;

    private static class b {
        public View ipu;
        public TextView kze;
        public View mdr;
    }

    private static class c {
        View kar;
        View kas;
        View kat;

        final void h(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            View view = this.kar;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.kas.setVisibility(8);
            View view2 = this.kat;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    private static class d {
        public View ipu;
        public TextView mdw;
    }

    private static class e {
        public View ipu;
        public ImageView jbU;
        public TextView mdw;
    }

    private static class f {
        public View ipu;
        public ImageView ipv;
        public TextView ipw;
        public TextView ipx;
    }

    private static class g {
        public static int vwA = 6;
        public static int vwB = 1;
        public static int vwC = 2;
        public static int vwu = 0;
        public static int vwv = 1;
        public static int vww = 2;
        public static int vwx = 3;
        public static int vwy = 4;
        public static int vwz = 5;
        public Object data;
        public int knu;

        public g() {
            this.knu = vwu;
            this.data = null;
        }

        public g(int i, Object obj) {
            this.knu = i;
            this.data = obj;
        }
    }

    private static class a extends BaseAdapter implements com.tencent.mm.y.e {
        public static int vvY = 3;
        private int Ul = 0;
        private Context context;
        private com.tencent.mm.ah.a.a.c hIy;
        String kbi;
        String kwE;
        private int scene;
        private int vvZ;
        boolean vwa;
        boolean vwb;
        private ArrayList<com.tencent.mm.modelbiz.a.c> vwc = new ArrayList();
        private ArrayList<Object> vwd = new ArrayList();
        private ArrayList<com.tencent.mm.modelbiz.a.c> vwe = new ArrayList();
        private g vwf;
        private ArrayList<g> vwg = new ArrayList();
        private g vwh;
        private g vwi;
        private ArrayList<g> vwj = new ArrayList();
        private g vwk;
        public boolean vwl = true;
        public boolean vwm = false;
        public boolean vwn = false;
        private boolean vwo = true;
        private int vwp = 0;
        public boolean vwq = false;
        int vwr = 0;

        public final /* synthetic */ Object getItem(int i) {
            return AG(i);
        }

        public a(Context context, String str, int i) {
            boolean z;
            boolean z2 = false;
            this.context = context;
            this.kbi = str;
            this.scene = i;
            if (this.scene == 1 || this.scene == 2) {
                z = true;
            } else {
                z = false;
            }
            this.vwa = z;
            if (this.scene == 1 || this.scene == 3) {
                z2 = true;
            }
            this.vwb = z2;
            this.vvZ = this.scene == 1 ? vvY : Integer.MAX_VALUE;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIO = com.tencent.mm.modelbiz.a.e.iz(this.kbi);
            aVar.hIL = true;
            aVar.hJh = true;
            aVar.hJa = R.k.bes;
            this.hIy = aVar.Hg();
            if (this.vwa) {
                ap.vd().a(1364, (com.tencent.mm.y.e) this);
            }
        }

        public final int getCount() {
            return this.Ul;
        }

        public final int getItemViewType(int i) {
            g AG = AG(i);
            if (AG != null) {
                return AG.knu;
            }
            return g.vwu;
        }

        public final int getViewTypeCount() {
            return g.vwA;
        }

        public final g AG(int i) {
            int i2;
            if (i < this.vwp) {
                if (i == 0) {
                    if (this.vwf == null) {
                        this.vwf = new g(g.vwz, Integer.valueOf(g.vwB));
                    }
                    return this.vwf;
                } else if (i == this.vwp - 1 && this.vwm && bTr()) {
                    if (this.vwh == null) {
                        this.vwh = new g();
                    }
                    this.vwh.knu = g.vwy;
                    this.vwh.data = Integer.valueOf(g.vwB);
                    return this.vwh;
                } else if (i == this.vwp - 1 && this.vwl && bTr()) {
                    if (this.vwh == null) {
                        this.vwh = new g();
                    }
                    this.vwh.knu = g.vwx;
                    this.vwh.data = Integer.valueOf(g.vwB);
                    return this.vwh;
                } else {
                    i2 = i - 1;
                    if (i2 >= 0 && i2 < this.vwg.size()) {
                        return (g) this.vwg.get(i2);
                    }
                }
            } else if (i == this.vwp) {
                if (this.vwi == null) {
                    this.vwi = new g(g.vwz, Integer.valueOf(g.vwC));
                }
                return this.vwi;
            } else if (i == this.Ul - 1 && this.vwo && bTr()) {
                if (this.vwk == null) {
                    this.vwk = new g(g.vwx, Integer.valueOf(g.vwC));
                }
                return this.vwk;
            } else {
                i2 = (i - this.vwp) - 1;
                if (i2 >= 0 && i2 < this.vwj.size()) {
                    return (g) this.vwj.get(i2);
                }
            }
            return new g();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            g AG = AG(i);
            String str;
            CharSequence a;
            if (AG.knu == g.vwv || AG.knu == g.vww) {
                CharSequence charSequence;
                String str2;
                boolean z2;
                CharSequence charSequence2;
                boolean z3;
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.ddF, viewGroup, false);
                    view.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
                    f fVar = new f();
                    fVar.ipv = (ImageView) view.findViewById(R.h.bqM);
                    fVar.ipw = (TextView) view.findViewById(R.h.cJh);
                    fVar.ipx = (TextView) view.findViewById(R.h.bIb);
                    fVar.ipu = view.findViewById(R.h.cAN);
                    view.setTag(fVar);
                }
                f fVar2 = (f) view.getTag();
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (AG.data instanceof com.tencent.mm.modelbiz.a.c) {
                    com.tencent.mm.modelbiz.a.c cVar = (com.tencent.mm.modelbiz.a.c) AG.data;
                    if (cVar != null) {
                        if (!cVar.DV()) {
                            j iD = w.DL().iD(cVar.field_bizChatServId);
                            if (iD != null) {
                                str4 = iD.field_userName;
                                str = iD.field_headImageUrl;
                            }
                        }
                        str4 = cVar.field_chatName;
                        str = cVar.field_headImageUrl;
                    } else {
                        str = str4;
                        str4 = str3;
                    }
                    charSequence = str5;
                    str2 = str;
                    z2 = false;
                    charSequence2 = str4;
                    z3 = true;
                } else if (AG.data instanceof gu) {
                    gu guVar = (gu) AG.data;
                    gx gxVar = guVar.tkO;
                    str2 = gxVar.khr;
                    str5 = gxVar.tkG;
                    boolean equals = "userid".equals(guVar.tkP);
                    z3 = !equals;
                    String str6 = guVar.tkQ;
                    r1 = str2;
                    str2 = str5;
                    z2 = equals;
                    r3 = str6;
                } else {
                    str2 = str4;
                    r1 = str3;
                    r3 = str5;
                    z3 = false;
                    z2 = false;
                }
                if (z3) {
                    a = a(this.context, com.tencent.mm.as.d.a(charSequence2, this.kwE), com.tencent.mm.plugin.fts.d.d.b.mcC);
                } else {
                    a = a(this.context, new SpannableString(charSequence2), com.tencent.mm.plugin.fts.d.d.b.mcC);
                }
                if (z2) {
                    str = this.context.getString(R.l.dPh);
                    SpannableString a2 = a(this.context, com.tencent.mm.as.d.a(charSequence, this.kwE), com.tencent.mm.plugin.fts.d.d.b.mcC);
                    charSequence2 = TextUtils.concat(new CharSequence[]{str, a2});
                } else {
                    charSequence2 = "";
                }
                if (AG.knu == g.vwv && i == this.vwp - 1 && this.vwp != this.Ul) {
                    z = false;
                }
                n(fVar2.ipu, z);
                n.GW().a(str2, fVar2.ipv, this.hIy);
                com.tencent.mm.plugin.fts.d.e.a(a, fVar2.ipw);
                com.tencent.mm.plugin.fts.d.e.a(charSequence2, fVar2.ipx);
                return view;
            } else if (AG.knu == g.vwz) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.ddL, viewGroup, false);
                    b bVar = new b();
                    bVar.kze = (TextView) view.findViewById(R.h.bWg);
                    bVar.mdr = view.findViewById(R.h.cqD);
                    bVar.ipu = view.findViewById(R.h.cAN);
                    view.setTag(bVar);
                }
                b bVar2 = (b) view.getTag();
                str = ((Integer) AG.data).intValue() == g.vwB ? this.context.getResources().getString(R.l.dPf) : ((Integer) AG.data).intValue() == g.vwC ? this.context.getResources().getString(R.l.dOY) : "";
                com.tencent.mm.plugin.fts.d.e.a(str, bVar2.kze);
                if (i == 0) {
                    bVar2.mdr.setVisibility(8);
                } else {
                    bVar2.mdr.setVisibility(0);
                }
                bVar2.ipu.setBackgroundResource(R.g.bgi);
                return view;
            } else if (AG.knu == g.vwx) {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.ddV, viewGroup, false);
                    e eVar = new e();
                    eVar.mdw = (TextView) view.findViewById(R.h.cIJ);
                    eVar.jbU = (ImageView) view.findViewById(R.h.bWx);
                    eVar.ipu = view.findViewById(R.h.cAN);
                    view.setTag(eVar);
                }
                e eVar2 = (e) view.getTag();
                a = "";
                if (((Integer) AG.data).intValue() == g.vwB) {
                    a = this.context.getResources().getString(R.l.dPe);
                } else if (((Integer) AG.data).intValue() == g.vwC) {
                    Object string = this.context.getResources().getString(R.l.dPd);
                }
                if (((Integer) AG.data).intValue() == g.vwB && this.vwp != this.Ul) {
                    z = false;
                }
                n(eVar2.ipu, z);
                eVar2.mdw.setText(a);
                eVar2.jbU.setImageResource(R.k.dxo);
                return view;
            } else if (AG.knu != g.vwy) {
                return null;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.context).inflate(R.i.ddN, viewGroup, false);
                    d dVar = new d();
                    dVar.mdw = (TextView) view.findViewById(R.h.cIJ);
                    dVar.ipu = view.findViewById(R.h.cAN);
                    view.setTag(dVar);
                }
                d dVar2 = (d) view.getTag();
                if (((Integer) AG.data).intValue() == g.vwB && this.vwp != this.Ul) {
                    z = false;
                }
                n(dVar2.ipu, z);
                dVar2.mdw.setText(this.context.getResources().getString(R.l.dPa));
                return view;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.y.k r12) {
            /*
            r8 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = r8.vwa;
            if (r0 == 0) goto L_0x0045;
        L_0x0007:
            r0 = r12.getType();
            r4 = 1364; // 0x554 float:1.911E-42 double:6.74E-321;
            if (r0 != r4) goto L_0x0045;
        L_0x000f:
            r0 = r12 instanceof com.tencent.mm.modelbiz.a.l;
            if (r0 == 0) goto L_0x0045;
        L_0x0013:
            r8.vwn = r3;
            r12 = (com.tencent.mm.modelbiz.a.l) r12;
            r0 = r12.gUA;
            if (r0 == 0) goto L_0x0046;
        L_0x001b:
            r0 = r12.gUA;
            r0 = r0.hsj;
            r0 = r0.hsr;
            if (r0 == 0) goto L_0x0046;
        L_0x0023:
            r0 = r12.gUA;
            r0 = r0.hsj;
            r0 = r0.hsr;
            r0 = (com.tencent.mm.protocal.c.gv) r0;
        L_0x002b:
            r4 = r0.fDs;
            r5 = r0.tkL;
            r6 = r8.kwE;
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x0045;
        L_0x0037:
            r6 = r8.kbi;
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x0045;
        L_0x003f:
            r5 = r8.vwr;
            r0 = r0.offset;
            if (r5 == r0) goto L_0x0048;
        L_0x0045:
            return;
        L_0x0046:
            r0 = r1;
            goto L_0x002b;
        L_0x0048:
            if (r9 != 0) goto L_0x004c;
        L_0x004a:
            if (r10 == 0) goto L_0x0050;
        L_0x004c:
            r8.bTq();
            goto L_0x0045;
        L_0x0050:
            r0 = r12.gUA;
            if (r0 == 0) goto L_0x0074;
        L_0x0054:
            r0 = r12.gUA;
            r0 = r0.hsk;
            r0 = r0.hsr;
            if (r0 == 0) goto L_0x0074;
        L_0x005c:
            r0 = r12.gUA;
            r0 = r0.hsk;
            r0 = r0.hsr;
            r0 = (com.tencent.mm.protocal.c.gw) r0;
        L_0x0064:
            if (r0 == 0) goto L_0x0070;
        L_0x0066:
            r1 = r0.tkR;
            if (r1 == 0) goto L_0x0070;
        L_0x006a:
            r1 = r0.tkR;
            r1 = r1.ret;
            if (r1 == 0) goto L_0x0076;
        L_0x0070:
            r8.bTq();
            goto L_0x0045;
        L_0x0074:
            r0 = r1;
            goto L_0x0064;
        L_0x0076:
            r1 = r0.tkS;
            r0 = r0.tkT;
            r5 = r8.kwE;
            r5 = r4.equals(r5);
            if (r5 == 0) goto L_0x0045;
        L_0x0082:
            r8.vwm = r3;
            r5 = r8.vwr;
            r6 = r1.size();
            r5 = r5 + r6;
            r8.vwr = r5;
            r5 = r8.bTr();
            if (r5 == 0) goto L_0x00b3;
        L_0x0093:
            r5 = r8.vwd;
            r5 = r5.size();
            r6 = r8.vwc;
            r6 = r6.size();
            if (r5 >= r6) goto L_0x00a5;
        L_0x00a1:
            r8.aW(r4, r2);
            goto L_0x0045;
        L_0x00a5:
            r4 = r8.vwd;
            r4 = r4.size();
            r5 = r8.vwc;
            r5 = r5.size();
            if (r4 > r5) goto L_0x0101;
        L_0x00b3:
            r4 = r8.bTs();
            if (r4 == 0) goto L_0x00bb;
        L_0x00b9:
            r8.vwl = r0;
        L_0x00bb:
            r0 = r8.bTt();
            if (r0 != 0) goto L_0x0045;
        L_0x00c1:
            r4 = r1.iterator();
        L_0x00c5:
            r0 = r4.hasNext();
            if (r0 == 0) goto L_0x0101;
        L_0x00cb:
            r0 = r4.next();
            r1 = r0;
            r1 = (com.tencent.mm.protocal.c.gu) r1;
            r5 = r1.tkO;
            r0 = r5.tkM;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 != 0) goto L_0x00c5;
        L_0x00dc:
            r0 = r8.vwc;
            r6 = r0.iterator();
        L_0x00e2:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x0106;
        L_0x00e8:
            r0 = r6.next();
            r0 = (com.tencent.mm.modelbiz.a.c) r0;
            r7 = r5.tkM;
            r0 = r0.field_bizChatServId;
            r0 = r7.equals(r0);
            if (r0 == 0) goto L_0x00e2;
        L_0x00f8:
            r0 = r2;
        L_0x00f9:
            if (r0 != 0) goto L_0x00c5;
        L_0x00fb:
            r0 = r8.vwd;
            r0.add(r1);
            goto L_0x00c5;
        L_0x0101:
            r8.ld(r2);
            goto L_0x0045;
        L_0x0106:
            r0 = r3;
            goto L_0x00f9;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.bizchat.BizChatSearchUI.a.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
        }

        private void bTq() {
            if (bTs()) {
                this.vwm = false;
                this.vwq = true;
                bTu();
            }
        }

        private boolean bTr() {
            return this.scene == 1;
        }

        final boolean bTs() {
            return this.scene == 2;
        }

        private boolean bTt() {
            return this.scene == 3;
        }

        private static SpannableString a(Context context, Spannable spannable, int i) {
            int i2 = 0;
            SpannableString c = h.c(context, (CharSequence) spannable, i);
            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            if (foregroundColorSpanArr != null) {
                int length = foregroundColorSpanArr.length;
                while (i2 < length) {
                    Object obj = foregroundColorSpanArr[i2];
                    c.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), spannable.getSpanFlags(obj));
                    i2++;
                }
            }
            return c;
        }

        private static void n(View view, boolean z) {
            if (z) {
                view.setBackgroundResource(R.g.beo);
            } else {
                view.setBackgroundResource(R.g.bep);
            }
        }

        final void aW(String str, boolean z) {
            com.tencent.mm.modelbiz.a.b DK = w.DK();
            String str2 = this.kbi;
            List<com.tencent.mm.modelbiz.a.c> arrayList = new ArrayList();
            if (!bg.mA(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("select BizChatInfo.*");
                stringBuilder.append(" from BizChatConversation , BizChatInfo");
                stringBuilder.append(" where BizChatConversation.brandUserName").append(" = '").append(str2).append("'");
                stringBuilder.append(" and BizChatInfo.brandUserName").append(" = '").append(str2).append("'");
                stringBuilder.append(" and BizChatConversation.bizChatId");
                stringBuilder.append(" = BizChatInfo.bizChatLocalId");
                stringBuilder.append(" and BizChatInfo.chatName").append(" like '%").append(str).append("%'");
                stringBuilder.append(" order by BizChatConversation.flag").append(" desc");
                stringBuilder.append(" , BizChatConversation.lastMsgTime").append(" desc");
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", stringBuilder.toString());
                Cursor rawQuery = DK.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            com.tencent.mm.modelbiz.a.c cVar = new com.tencent.mm.modelbiz.a.c();
                            cVar.b(rawQuery);
                            arrayList.add(cVar);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
            }
            QZ();
            for (com.tencent.mm.modelbiz.a.c cVar2 : arrayList) {
                boolean DV = cVar2.DV();
                if (DV && this.vwb) {
                    this.vwe.add(cVar2);
                } else if (!DV && this.vwa) {
                    this.vwd.add(cVar2);
                    this.vwc.add(cVar2);
                }
            }
            if (this.vwa) {
                boolean z2;
                if (this.vwd.size() <= this.vvZ) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.vwm = z2;
            }
            ld(z);
        }

        final void Tk(final String str) {
            if (this.vwa) {
                af.f(new Runnable(this) {
                    final /* synthetic */ a vwt;

                    public final void run() {
                        if (str.equals(this.vwt.kwE)) {
                            ap.vd().a(new l(this.vwt.kbi, str, 0), 0);
                        }
                    }
                }, 200);
            }
        }

        final void QZ() {
            this.vwr = 0;
            this.vwd.clear();
            this.vwc.clear();
            this.vwe.clear();
        }

        final void ld(boolean z) {
            int i;
            int i2 = 1;
            this.vwg.clear();
            this.vwj.clear();
            for (i = 0; i < Math.min(this.vvZ, this.vwd.size()); i++) {
                this.vwg.add(new g(g.vwv, this.vwd.get(i)));
            }
            for (i = 0; i < Math.min(this.vvZ, this.vwe.size()); i++) {
                this.vwj.add(new g(g.vww, this.vwe.get(i)));
            }
            int size = this.vwd.size();
            int size2 = this.vwe.size();
            if (this.scene != 2) {
                this.vwl = this.vwd.size() > this.vvZ;
            }
            this.vwo = this.vwe.size() > this.vvZ;
            if (size > 0 || this.vwm) {
                size = Math.min(size, this.vvZ) + 1;
                if (bTr()) {
                    i = (this.vwm || this.vwl) ? 1 : 0;
                    i += size;
                } else {
                    i = size;
                }
            } else {
                i = 0;
            }
            this.vwp = i;
            if (size2 > 0) {
                i = (i + 1) + Math.min(size2, this.vvZ);
                if (bTr()) {
                    if (!this.vwo) {
                        i2 = 0;
                    }
                    i += i2;
                }
            }
            this.Ul = i;
            if (z) {
                notifyDataSetChanged();
                bTu();
            }
        }

        final void bTu() {
            BizChatSearchUI bizChatSearchUI = (BizChatSearchUI) this.context;
            if (!bTr()) {
                if (bg.mA(this.kwE)) {
                    bizChatSearchUI.vvV.setVisibility(0);
                    bizChatSearchUI.vvV.setText("");
                    bizChatSearchUI.vvU.setVisibility(8);
                } else if (bTs() && this.vwm) {
                    bizChatSearchUI.vvV.setVisibility(0);
                    bizChatSearchUI.vvV.setText(R.l.dPa);
                    bizChatSearchUI.vvU.setVisibility(8);
                } else if (bTs() && this.vwq) {
                    bizChatSearchUI.vvV.setVisibility(0);
                    bizChatSearchUI.vvV.setText(R.l.dPb);
                    bizChatSearchUI.vvU.setVisibility(8);
                } else if (getCount() <= 0) {
                    bizChatSearchUI.vvV.setVisibility(0);
                    bizChatSearchUI.vvV.setText(com.tencent.mm.plugin.fts.d.f.a(bizChatSearchUI.getString(R.l.ePC), bizChatSearchUI.getString(R.l.ePB), com.tencent.mm.plugin.fts.d.b.a.d(this.kwE, this.kwE)).mdL);
                    bizChatSearchUI.vvU.setVisibility(8);
                } else {
                    bizChatSearchUI.vvV.setVisibility(8);
                    bizChatSearchUI.vvU.setVisibility(0);
                }
                if (!bTs()) {
                    return;
                }
                if (this.vwn) {
                    bizChatSearchUI.AF(1);
                } else if (this.vwl) {
                    bizChatSearchUI.AF(2);
                } else {
                    bizChatSearchUI.AF(0);
                }
            } else if (bg.mA(this.kwE)) {
                bizChatSearchUI.vvV.setVisibility(8);
                bizChatSearchUI.vvU.setVisibility(8);
            } else if (getCount() <= 0) {
                bizChatSearchUI.vvV.setVisibility(0);
                bizChatSearchUI.vvU.setVisibility(8);
            } else {
                bizChatSearchUI.vvV.setVisibility(8);
                bizChatSearchUI.vvU.setVisibility(0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final void OF() {
    }

    public final void OG() {
    }

    protected final void KC() {
        if (bg.mA(this.kbi)) {
            this.kbi = getIntent().getStringExtra("enterprise_biz_name");
            this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
            this.vvS = getIntent().getStringExtra("biz_chat_search_text");
            if (bg.mA(this.kbi)) {
                finish();
            }
        }
        this.vvU = (BizChatSearchListView) findViewById(R.h.btM);
        this.vvV = (TextView) findViewById(R.h.cop);
        this.vvW = new a(this.uSU.uTo, this.kbi, this.scene);
        if (this.vvW.bTs()) {
            this.vvT = new c();
            BizChatSearchListView bizChatSearchListView = this.vvU;
            c cVar = this.vvT;
            View inflate = View.inflate(this.uSU.uTo, R.i.dgN, null);
            cVar.kar = inflate.findViewById(R.h.cbQ);
            cVar.kas = inflate.findViewById(R.h.cbL);
            cVar.kat = inflate.findViewById(R.h.cbR);
            cVar.kar.setVisibility(8);
            cVar.kas.setVisibility(8);
            cVar.kat.setVisibility(8);
            bizChatSearchListView.addFooterView(inflate);
            AF(0);
        }
        this.vvU.setAdapter(this.vvW);
        this.vvU.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatSearchUI vvX;

            {
                this.vvX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                long j2 = -1;
                g AG = this.vvX.vvW.AG(i);
                MMActivity mMActivity = this.vvX;
                Intent intent;
                if (AG.knu == g.vwv || AG.knu == g.vww) {
                    com.tencent.mm.modelbiz.a.c cVar;
                    if (AG.data instanceof com.tencent.mm.modelbiz.a.c) {
                        cVar = (com.tencent.mm.modelbiz.a.c) AG.data;
                        j2 = cVar != null ? cVar.field_bizChatLocalId : -1;
                    } else if (AG.data instanceof gu) {
                        gx gxVar = ((gu) AG.data).tkO;
                        String str = mMActivity.kbi;
                        j jVar = new j();
                        jVar.field_userId = gxVar.tkM;
                        jVar.field_userName = gxVar.khr;
                        jVar.field_brandUserName = str;
                        jVar.field_headImageUrl = gxVar.tkG;
                        jVar.field_profileUrl = gxVar.tkU;
                        jVar.field_UserVersion = gxVar.ver;
                        jVar.field_addMemberUrl = gxVar.tkK;
                        if (!w.DL().b(jVar) ? w.DL().a(jVar) : true) {
                            cVar = new com.tencent.mm.modelbiz.a.c();
                            cVar.field_bizChatServId = jVar.field_userId;
                            cVar.field_brandUserName = jVar.field_brandUserName;
                            cVar.field_chatName = jVar.field_userName;
                            cVar.field_chatType = 1;
                            cVar = com.tencent.mm.modelbiz.a.e.e(cVar);
                            if (cVar != null) {
                                com.tencent.mm.modelbiz.a.a U = w.DK().U(cVar.field_bizChatLocalId);
                                U.field_bizChatId = cVar.field_bizChatLocalId;
                                U.field_unReadCount = 0;
                                if (bg.mA(U.field_brandUserName)) {
                                    U.field_brandUserName = cVar.field_brandUserName;
                                    U.field_lastMsgTime = System.currentTimeMillis();
                                    U.field_flag = U.field_lastMsgTime;
                                }
                                if (!w.DK().b(U)) {
                                    w.DK().a(U);
                                }
                                j2 = cVar.field_bizChatLocalId;
                            }
                        }
                    }
                    if (!bg.mA(mMActivity.kbi) && j2 >= 0) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", mMActivity.kbi);
                        intent.putExtra("key_biz_chat_id", j2);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.bb.d.a(mMActivity.uSU.uTo, ".ui.chatting.En_5b8fbb1e", intent);
                    }
                } else if (AG.knu != g.vwx) {
                } else {
                    if (((Integer) AG.data).intValue() == g.vwB) {
                        intent = new Intent(mMActivity.uSU.uTo, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", mMActivity.kbi);
                        intent.putExtra("biz_chat_search_scene", 2);
                        intent.putExtra("biz_chat_search_text", mMActivity.kaB.bzZ());
                        mMActivity.startActivity(intent);
                    } else if (((Integer) AG.data).intValue() == g.vwC) {
                        intent = new Intent(mMActivity.uSU.uTo, BizChatSearchUI.class);
                        intent.putExtra("enterprise_biz_name", mMActivity.kbi);
                        intent.putExtra("biz_chat_search_scene", 3);
                        intent.putExtra("biz_chat_search_text", mMActivity.kaB.bzZ());
                        mMActivity.startActivity(intent);
                    }
                }
            }
        });
        this.vvU.vvR = this;
        if (this.vvW.bTs()) {
            this.vvU.setOnScrollListener(this.mxt);
        }
        this.kaB = new p();
        this.kaB.lK(this.vvW.bTr());
        this.kaB.a(this);
        this.kaB.sXA = false;
    }

    public final void OE() {
    }

    public final void OD() {
        finish();
    }

    public final void mR(String str) {
        CharSequence charSequence = null;
        if (!bg.mA(str) || this.vvS == null) {
            a aVar = this.vvW;
            aVar.kwE = str;
            if (bg.mA(str)) {
                aVar.QZ();
                aVar.vwm = false;
                aVar.vwq = false;
                aVar.ld(true);
                return;
            } else if (aVar.bTs()) {
                aVar.vwm = true;
                aVar.vwq = false;
                aVar.bTu();
                aVar.aW(str, false);
                aVar.Tk(str);
                return;
            } else {
                aVar.aW(str, true);
                if (aVar.vwa && aVar.vwm) {
                    aVar.Tk(str);
                    return;
                }
                return;
            }
        }
        String str2 = this.vvS;
        this.vvS = null;
        if (!str2.equals("")) {
            this.kaB.Ug(str2);
        }
        p pVar = this.kaB;
        if (this.vvW.bTr()) {
            charSequence = this.uSU.uTo.getResources().getString(R.l.dPc);
        } else if (this.vvW.bTs()) {
            charSequence = this.uSU.uTo.getResources().getString(R.l.dPg);
        } else if (this.vvW.bTt()) {
            charSequence = this.uSU.uTo.getResources().getString(R.l.dOZ);
        }
        pVar.setHint(charSequence);
        this.kaB.clearFocus();
    }

    public final boolean mQ(String str) {
        aHf();
        return true;
    }

    public final void aej() {
        aHf();
    }

    public final void aek() {
    }

    protected void onPause() {
        super.onPause();
        this.kaB.cancel();
        this.kaB.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kaB.a((FragmentActivity) this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kaB.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return R.i.dbj;
    }

    public final boolean ael() {
        aHf();
        return false;
    }

    public final void AF(int i) {
        if (this.vvT != null) {
            c cVar = this.vvT;
            switch (i) {
                case 1:
                    cVar.h(true, false);
                    return;
                case 2:
                    cVar.h(false, true);
                    return;
                default:
                    cVar.h(false, false);
                    return;
            }
        }
    }
}
