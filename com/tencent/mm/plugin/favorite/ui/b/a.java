package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMImageView;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.plugin.fts.d.a.a {
    private static final ae handler = new ae(Looper.getMainLooper());
    private static final Pattern lMB = Pattern.compile("['\r\n' | '\n']+");
    public i iJC;
    public List<String> iJD;
    public String iMn;
    public CharSequence lMC;
    public CharSequence lMD;
    public CharSequence lME;
    public String lMF;
    public int lMG;
    private b lMH = new b(this);
    a lMI = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public TextView ipw;
        public MMImageView lMJ;
        public TextView lMK;
        public TextView lML;
        final /* synthetic */ a lMM;

        public a(a aVar) {
            this.lMM = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ a lMM;

        public b(a aVar) {
            this.lMM = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddJ, viewGroup, false);
            a aVar = this.lMM.lMI;
            aVar.lMJ = (MMImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.lMK = (TextView) inflate.findViewById(R.h.bmx);
            aVar.lML = (TextView) inflate.findViewById(R.h.cGB);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            a aVar3 = (a) aVar;
            a aVar4 = (a) aVar2;
            ch(aVar3.ipu);
            e.a(context, aVar3.lMJ, aVar4.iMn, aVar4.lMF, aVar4.lMG, aVar3.lMJ.getMeasuredWidth(), aVar3.lMJ.getMeasuredHeight());
            a.a(aVar3.ipw, aVar3.lMK, this.lMM.lMC, this.lMM.lMD);
            e.a(this.lMM.lME, aVar3.lML);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            a aVar2 = (a) aVar;
            com.tencent.mm.sdk.b.b fpVar = new fp();
            fpVar.fKp.type = 10;
            fpVar.fKp.fFx = aVar2.iJC.mam;
            fpVar.fKp.context = context;
            com.tencent.mm.sdk.b.a.urY.m(fpVar);
            return true;
        }
    }

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        if (e.a(charSequence, textView)) {
            if (e.a(charSequence2, textView2)) {
                textView.setMaxLines(1);
                textView2.setMaxLines(1);
                return;
            }
            textView.setMaxLines(2);
        } else if (e.a(charSequence2, textView2)) {
            textView2.setMaxLines(2);
        }
    }

    public a(int i) {
        super(7, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r11, com.tencent.mm.plugin.fts.d.a.a.a r12, java.lang.Object... r13) {
        /*
        r10 = this;
        r0 = r10.iJC;
        r0 = r0.mam;
        r2 = new com.tencent.mm.e.a.fp;
        r2.<init>();
        r3 = r2.fKp;
        r4 = 9;
        r3.type = r4;
        r3 = r2.fKp;
        r3.fFx = r0;
        r0 = com.tencent.mm.sdk.b.a.urY;
        r0.m(r2);
        r0 = r2.fKq;
        r4 = r0.fKA;
        r0 = r10.iJC;
        r0 = r0.mam;
        r2 = new com.tencent.mm.e.a.fp;
        r2.<init>();
        r3 = r2.fKp;
        r5 = 11;
        r3.type = r5;
        r3 = r2.fKp;
        r3.fFx = r0;
        r0 = r2.fKp;
        r1 = handler;
        r0.handler = r1;
        r0 = com.tencent.mm.sdk.b.a.urY;
        r0.m(r2);
        r0 = r2.fKq;
        r0 = r0.fKz;
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r1);
        r10.lMF = r0;
        r0 = r2.fKq;
        r0 = r0.thumbUrl;
        r1 = "";
        r0 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r1);
        r10.iMn = r0;
        r1 = r10.iJC;
        r2 = r10.iJD;
        r0 = com.tencent.mm.plugin.fts.d.f.a.mcJ;
        r0 = r0 * 2;
        r3 = (float) r0;
        r5 = r4.fTi;
        r0 = "";
        r6 = r4.type;
        switch(r6) {
            case 1: goto L_0x00d6;
            case 2: goto L_0x00e6;
            case 3: goto L_0x0153;
            case 4: goto L_0x0147;
            case 5: goto L_0x0067;
            case 6: goto L_0x00f2;
            case 7: goto L_0x01b7;
            case 8: goto L_0x0067;
            case 9: goto L_0x0067;
            case 10: goto L_0x015f;
            case 11: goto L_0x015f;
            case 12: goto L_0x0067;
            case 13: goto L_0x0067;
            case 14: goto L_0x0169;
            case 15: goto L_0x0067;
            case 16: goto L_0x01dd;
            default: goto L_0x0067;
        };
    L_0x0067:
        r0 = r4.title;
    L_0x0069:
        r1 = r1.hPr;
        switch(r1) {
            case 1: goto L_0x01e9;
            case 2: goto L_0x01e9;
            case 3: goto L_0x01e9;
            case 4: goto L_0x01e9;
            case 5: goto L_0x01e9;
            case 6: goto L_0x01e9;
            default: goto L_0x006e;
        };
    L_0x006e:
        r10.lMC = r0;
        r2 = r10.iJC;
        r3 = r10.iJD;
        r5 = r4.fTi;
        r0 = "";
        r1 = -1;
        r6 = r4.type;
        switch(r6) {
            case 2: goto L_0x020b;
            case 3: goto L_0x007f;
            case 4: goto L_0x007f;
            case 5: goto L_0x01f9;
            case 6: goto L_0x020f;
            case 7: goto L_0x01f9;
            case 8: goto L_0x007f;
            case 9: goto L_0x007f;
            case 10: goto L_0x022b;
            case 11: goto L_0x022b;
            case 12: goto L_0x01f9;
            case 13: goto L_0x007f;
            case 14: goto L_0x0235;
            case 15: goto L_0x01f9;
            default: goto L_0x007f;
        };
    L_0x007f:
        r0 = "";
    L_0x0082:
        r2 = r2.hPr;
        switch(r2) {
            case 6: goto L_0x0263;
            case 7: goto L_0x024b;
            case 8: goto L_0x024b;
            case 23: goto L_0x023a;
            default: goto L_0x0087;
        };
    L_0x0087:
        r2 = "";
        r9 = r0;
        r0 = r2;
        r2 = r9;
    L_0x008d:
        r3 = -1;
        if (r1 == r3) goto L_0x00ab;
    L_0x0090:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x00ab;
    L_0x0096:
        r2 = 2;
        r2 = new java.lang.CharSequence[r2];
        r3 = 0;
        r5 = r11.getResources();
        r1 = r5.getString(r1);
        r2[r3] = r1;
        r1 = 1;
        r2[r1] = r0;
        r0 = android.text.TextUtils.concat(r2);
    L_0x00ab:
        r10.lMD = r0;
        r5 = r10.iJC;
        r6 = r10.iJD;
        r0 = r4.fOu;
        r1 = r4.tzb;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r2 == 0) goto L_0x0397;
    L_0x00bb:
        r0 = 0;
    L_0x00bc:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 == 0) goto L_0x0272;
    L_0x00c2:
        r0 = new android.text.SpannableString;
        r1 = "";
        r0.<init>(r1);
    L_0x00ca:
        r10.lME = r0;
        r0 = r4.type;
        switch(r0) {
            case 3: goto L_0x037d;
            case 4: goto L_0x0381;
            case 5: goto L_0x0379;
            case 6: goto L_0x0385;
            case 7: goto L_0x00d1;
            case 8: goto L_0x0356;
            default: goto L_0x00d1;
        };
    L_0x00d1:
        r0 = com.tencent.mm.R.k.dxn;
    L_0x00d3:
        r10.lMG = r0;
        return;
    L_0x00d6:
        r0 = lMB;
        r5 = r4.desc;
        r0 = r0.matcher(r5);
        r5 = " ";
        r0 = r0.replaceAll(r5);
        goto L_0x0069;
    L_0x00e6:
        r0 = r11.getResources();
        r5 = com.tencent.mm.R.l.ePV;
        r0 = r0.getString(r5);
        goto L_0x0069;
    L_0x00f2:
        r0 = r5.iBi;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x012f;
    L_0x00fa:
        r0 = r5.iBi;
        r6 = r5.tyw;
        if (r6 == 0) goto L_0x0069;
    L_0x0100:
        r6 = r5.tyw;
        r6 = r6.fRX;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 != 0) goto L_0x0069;
    L_0x010a:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = r6.append(r0);
        r6 = "(";
        r0 = r0.append(r6);
        r5 = r5.tyw;
        r5 = r5.fRX;
        r0 = r0.append(r5);
        r5 = ")";
        r0 = r0.append(r5);
        r0 = r0.toString();
        goto L_0x0069;
    L_0x012f:
        r0 = r5.tyw;
        if (r0 == 0) goto L_0x0143;
    L_0x0133:
        r0 = r5.tyw;
        r0 = r0.fRX;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r6 == 0) goto L_0x0069;
    L_0x013d:
        r0 = r5.tyw;
        r0 = r0.label;
        goto L_0x0069;
    L_0x0143:
        r0 = r4.desc;
        goto L_0x0069;
    L_0x0147:
        r0 = r11.getResources();
        r5 = com.tencent.mm.R.l.ePZ;
        r0 = r0.getString(r5);
        goto L_0x0069;
    L_0x0153:
        r0 = r11.getResources();
        r5 = com.tencent.mm.R.l.eQa;
        r0 = r0.getString(r5);
        goto L_0x0069;
    L_0x015f:
        r6 = r5.tyA;
        if (r6 == 0) goto L_0x0069;
    L_0x0163:
        r0 = r5.tyA;
        r0 = r0.title;
        goto L_0x0069;
    L_0x0169:
        r6 = new java.lang.StringBuffer;
        r6.<init>();
        r0 = r5.tzn;
        r5 = r0.iterator();
    L_0x0174:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0194;
    L_0x017a:
        r0 = r5.next();
        r0 = (com.tencent.mm.protocal.c.rm) r0;
        r0 = com.tencent.mm.pluginsdk.model.c.p(r0);
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r7 != 0) goto L_0x0174;
    L_0x018a:
        r6.append(r0);
        r0 = " ";
        r6.append(r0);
        goto L_0x0174;
    L_0x0194:
        r0 = lMB;
        r5 = r6.toString();
        r0 = r0.matcher(r5);
        r5 = " ";
        r0 = r0.replaceAll(r5);
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r5 == 0) goto L_0x0069;
    L_0x01ab:
        r0 = r11.getResources();
        r5 = com.tencent.mm.R.l.ePX;
        r0 = r0.getString(r5);
        goto L_0x0069;
    L_0x01b7:
        r0 = r4.title;
        r5 = r4.desc;
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r5 != 0) goto L_0x0069;
    L_0x01c1:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r5.append(r0);
        r5 = "-";
        r0 = r0.append(r5);
        r5 = r4.desc;
        r0 = r0.append(r5);
        r0 = r0.toString();
        goto L_0x0069;
    L_0x01dd:
        r0 = r11.getResources();
        r5 = com.tencent.mm.R.l.ePY;
        r0 = r0.getString(r5);
        goto L_0x0069;
    L_0x01e9:
        r1 = r10.fRM;
        r5 = com.tencent.mm.plugin.fts.d.d.b.mcF;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r0, r1, r2, r3, r5);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
        goto L_0x006e;
    L_0x01f9:
        r5 = r4.appId;
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r5 != 0) goto L_0x0082;
    L_0x0201:
        r0 = com.tencent.mm.u.x.a.hlQ;
        r5 = r4.appId;
        r0 = r0.m(r11, r5);
        goto L_0x0082;
    L_0x020b:
        r0 = r4.title;
        goto L_0x0082;
    L_0x020f:
        r6 = r5.tyw;
        if (r6 == 0) goto L_0x0082;
    L_0x0213:
        r0 = r5.tyw;
        r0 = r0.label;
        r6 = r5.iBi;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 == 0) goto L_0x0082;
    L_0x021f:
        r5 = r5.tyw;
        r5 = r5.fRX;
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r5 == 0) goto L_0x0082;
    L_0x0229:
        goto L_0x007f;
    L_0x022b:
        r6 = r5.tyA;
        if (r6 == 0) goto L_0x0082;
    L_0x022f:
        r0 = r5.tyA;
        r0 = r0.desc;
        goto L_0x0082;
    L_0x0235:
        r0 = "";
        goto L_0x0082;
    L_0x023a:
        r1 = com.tencent.mm.R.l.ePU;
        r2 = com.tencent.mm.plugin.fts.d.b.a.b(r0, r3);
        r2 = com.tencent.mm.plugin.fts.d.f.b(r2);
        r2 = r2.mdL;
        r9 = r0;
        r0 = r2;
        r2 = r9;
        goto L_0x008d;
    L_0x024b:
        r0 = com.tencent.mm.R.l.ePW;
        r1 = r4.tzc;
        r1 = g(r1, r3);
        r2 = com.tencent.mm.plugin.fts.d.b.a.b(r1, r3);
        r2 = com.tencent.mm.plugin.fts.d.f.b(r2);
        r2 = r2.mdL;
        r9 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x008d;
    L_0x0263:
        r2 = com.tencent.mm.plugin.fts.d.b.a.b(r0, r3);
        r2 = com.tencent.mm.plugin.fts.d.f.b(r2);
        r2 = r2.mdL;
        r9 = r0;
        r0 = r2;
        r2 = r9;
        goto L_0x008d;
    L_0x0272:
        com.tencent.mm.u.ap.yY();
        r2 = com.tencent.mm.u.c.wR();
        r7 = r2.Rc(r1);
        r7.setUsername(r1);
        r2 = 0;
        r1 = com.tencent.mm.u.o.dH(r1);
        if (r1 == 0) goto L_0x0394;
    L_0x0287:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 != 0) goto L_0x0394;
    L_0x028d:
        com.tencent.mm.u.ap.yY();
        r1 = com.tencent.mm.u.c.wR();
        r1 = r1.Rc(r0);
        r1.setUsername(r0);
        r0 = r1;
    L_0x029c:
        r3 = 0;
        r1 = 0;
        r2 = 0;
        r5 = r5.hPr;
        switch(r5) {
            case 9: goto L_0x038c;
            case 10: goto L_0x0332;
            case 11: goto L_0x0331;
            case 12: goto L_0x0390;
            case 13: goto L_0x0300;
            case 14: goto L_0x02ff;
            case 15: goto L_0x02a4;
            case 16: goto L_0x038c;
            case 17: goto L_0x0332;
            case 18: goto L_0x0331;
            default: goto L_0x02a4;
        };
    L_0x02a4:
        r9 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r9;
    L_0x02a8:
        if (r0 == 0) goto L_0x033c;
    L_0x02aa:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r8 = 1;
        r0 = a(r0, r8);
        r0 = r5.append(r0);
        r5 = "-";
        r0 = r0.append(r5);
        r5 = c(r11, r7);
        r0 = r0.append(r5);
        r0 = r0.toString();
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x02ce:
        r5 = com.tencent.mm.R.f.aXs;
        r5 = com.tencent.mm.bg.a.T(r11, r5);
        r1 = com.tencent.mm.pluginsdk.ui.d.h.c(r11, r1, r5);
        if (r2 == 0) goto L_0x0389;
    L_0x02da:
        r2 = r10.fRM;
        r0 = com.tencent.mm.plugin.fts.d.b.a.a(r1, r2, r6, r0, r3);
        r0 = com.tencent.mm.plugin.fts.d.f.b(r0);
        r0 = r0.mdL;
    L_0x02e6:
        r1 = 2;
        r1 = new java.lang.CharSequence[r1];
        r2 = 0;
        r3 = r11.getResources();
        r5 = com.tencent.mm.R.l.ePA;
        r3 = r3.getString(r5);
        r1[r2] = r3;
        r2 = 1;
        r1[r2] = r0;
        r0 = android.text.TextUtils.concat(r1);
        goto L_0x00ca;
    L_0x02ff:
        r1 = 1;
    L_0x0300:
        r2 = 1;
        r3 = r1;
        r1 = r2;
    L_0x0303:
        if (r0 == 0) goto L_0x032b;
    L_0x0305:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = 0;
        r0 = a(r0, r5);
        r0 = r2.append(r0);
        r2 = "-";
        r0 = r0.append(r2);
        r2 = c(r11, r7);
        r0 = r0.append(r2);
        r0 = r0.toString();
    L_0x0326:
        r2 = 1;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x02ce;
    L_0x032b:
        r0 = 0;
        r0 = a(r7, r0);
        goto L_0x0326;
    L_0x0331:
        r1 = 1;
    L_0x0332:
        r2 = 1;
        r9 = r2;
        r2 = r1;
        r1 = r9;
    L_0x0336:
        r3 = 1;
        r9 = r3;
        r3 = r2;
        r2 = r9;
        goto L_0x02a8;
    L_0x033c:
        r0 = r7.field_username;
        r0 = com.tencent.mm.u.o.dH(r0);
        if (r0 == 0) goto L_0x034c;
    L_0x0344:
        r0 = c(r11, r7);
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x02ce;
    L_0x034c:
        r0 = 1;
        r0 = a(r7, r0);
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x02ce;
    L_0x0356:
        r0 = r4.fTi;
        r0 = r0.tzn;
        if (r0 == 0) goto L_0x00d1;
    L_0x035c:
        r0 = r4.fTi;
        r0 = r0.tzn;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00d1;
    L_0x0366:
        r0 = r4.fTi;
        r0 = r0.tzn;
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.protocal.c.rm) r0;
        r0 = r0.txx;
        r0 = com.tencent.mm.pluginsdk.c.LC(r0);
        goto L_0x00d3;
    L_0x0379:
        r0 = com.tencent.mm.R.k.dtu;
        goto L_0x00d3;
    L_0x037d:
        r0 = com.tencent.mm.R.k.dtt;
        goto L_0x00d3;
    L_0x0381:
        r0 = com.tencent.mm.R.k.dtr;
        goto L_0x00d3;
    L_0x0385:
        r0 = com.tencent.mm.R.k.dtf;
        goto L_0x00d3;
    L_0x0389:
        r0 = r1;
        goto L_0x02e6;
    L_0x038c:
        r9 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0336;
    L_0x0390:
        r3 = r1;
        r1 = r2;
        goto L_0x0303;
    L_0x0394:
        r0 = r2;
        goto L_0x029c;
    L_0x0397:
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.b.a.a(android.content.Context, com.tencent.mm.plugin.fts.d.a.a$a, java.lang.Object[]):void");
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.lMH;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.lMI;
    }

    private static String a(x xVar, boolean z) {
        String str;
        if (!z || bg.mA(xVar.field_conRemark)) {
            str = xVar.field_nickname;
        } else {
            str = xVar.field_conRemark;
        }
        if (bg.mA(str)) {
            return xVar.field_username;
        }
        return str;
    }

    private static String c(Context context, x xVar) {
        String str = xVar.field_conRemark;
        if (bg.mA(str)) {
            str = xVar.field_nickname;
        }
        if (bg.mA(str)) {
            return context.getString(R.l.ene);
        }
        return str;
    }

    private static String g(List<String> list, List<String> list2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String toLowerCase : list2) {
            CharSequence toLowerCase2 = toLowerCase.toLowerCase();
            for (String toLowerCase3 : list) {
                if (toLowerCase3.toLowerCase().contains(toLowerCase2)) {
                    stringBuffer.append(toLowerCase3);
                    stringBuffer.append(" ");
                }
            }
        }
        stringBuffer.trimToSize();
        return stringBuffer.toString();
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
