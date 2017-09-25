package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class n {
    private static final f<String, SpannableString> sTZ = new f(500);
    String iCS;
    private TextView kH;
    private Context mContext;
    private ArrayList<i> sUa;
    private ArrayList<a> sUb;
    private ArrayList<l> sUc;
    boolean sUd;
    boolean sUe;
    boolean sUf;
    boolean sUg;
    boolean sUh;
    boolean sUi;
    boolean sUj;
    boolean sUk;
    boolean sUl;
    boolean sUm;
    boolean sUn;
    int sUo;
    private int sUp;
    boolean sUq;
    Object sUr;

    class a {
        int end;
        final /* synthetic */ n sUs;
        int start;

        a(n nVar, int i, int i2) {
            this.sUs = nVar;
            this.start = i;
            this.end = i2;
        }
    }

    public n(Context context) {
        this.sUa = new ArrayList();
        this.sUb = new ArrayList();
        this.sUc = new ArrayList();
        this.kH = null;
        this.sUd = false;
        this.sUe = false;
        this.sUf = false;
        this.sUg = true;
        this.sUh = true;
        this.sUi = false;
        this.sUj = false;
        this.sUk = false;
        this.sUl = false;
        this.sUm = false;
        this.sUn = true;
        this.sUo = 0;
        this.sUp = 0;
        this.mContext = null;
        this.sUq = false;
        this.sUa = new ArrayList();
        this.sUb = new ArrayList();
        this.sUc = new ArrayList();
        this.mContext = context;
    }

    public final n j(TextView textView) {
        this.kH = textView;
        if (textView != null) {
            this.mContext = this.kH.getContext();
        }
        return this;
    }

    public final SpannableString a(CharSequence charSequence, int i, boolean z) {
        if (charSequence == null) {
            return new SpannableString("");
        }
        int i2;
        CharSequence charSequence2;
        CharSequence spannableString;
        Iterator it;
        Iterator it2;
        l lVar;
        Drawable drawable;
        int i3;
        this.sUp = i;
        String str = charSequence + "@" + this.sUp + "@" + this.sUd + "@" + this.sUf + "@" + this.sUg + "@" + this.sUh + "@" + this.sUo + "@" + this.sUq + "@" + this.sUk + "@" + this.sUl + "@" + this.sUm;
        if (z) {
            SpannableString spannableString2 = (SpannableString) sTZ.get(str);
            if (spannableString2 != null) {
                d(spannableString2);
                e(spannableString2);
                bGv();
                return spannableString2;
            }
        }
        this.sUa = new ArrayList();
        if (this.sUp <= 0) {
            if (this.kH != null) {
                this.sUp = (int) this.kH.getTextSize();
            } else {
                this.sUp = com.tencent.mm.bg.a.T(this.mContext, b.aXI);
            }
        }
        if (this.sUa == null) {
            this.sUa = new ArrayList();
        }
        if (this.sUb == null) {
            this.sUb = new ArrayList();
        }
        this.sUa.clear();
        this.sUb.clear();
        if (charSequence != null) {
            if (p.gRl.gPZ == 1) {
                i2 = 1;
            } else if (VERSION.SDK_INT == 16 && bg.ap(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0) {
                i2 = 1;
            }
            if (i2 != 0 && this.sUn && com.tencent.mm.pluginsdk.ui.d.d.a.sTj != null && (com.tencent.mm.pluginsdk.ui.d.d.a.sTj.x(charSequence) || com.tencent.mm.pluginsdk.ui.d.d.a.sTj.y(charSequence))) {
                charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
            if (this.sUd) {
                charSequence = B(charSequence);
            }
            if (this.sUk) {
                charSequence = z(charSequence);
            }
            if (this.sUm) {
                charSequence = A(charSequence);
            }
            if (this.sUn || com.tencent.mm.pluginsdk.ui.d.d.a.sTj == null) {
                charSequence2 = charSequence;
            } else {
                charSequence2 = com.tencent.mm.pluginsdk.ui.d.d.a.sTj.b(this.mContext, charSequence, this.sUp);
            }
            if (this.sUg) {
                this.sUb.addAll(C(charSequence2));
            }
            if (this.sUd) {
                this.sUb.addAll(D(charSequence2));
            }
            if (this.sUe) {
                this.sUb.addAll(E(charSequence2));
            }
            if (this.sUj) {
                this.sUb.addAll(I(charSequence2));
            }
            if (this.sUh) {
                this.sUb.addAll(F(charSequence2));
            }
            if (this.sUf) {
                this.sUb.addAll(G(charSequence2));
            }
            if (this.sUi) {
                this.sUb.addAll(H(charSequence2));
            }
            if (charSequence2 instanceof Spannable) {
                spannableString = new SpannableString(charSequence2);
            } else {
                spannableString = (SpannableString) charSequence2;
            }
            if (this.sUq) {
                it = this.sUa.iterator();
                while (it.hasNext()) {
                    i iVar;
                    iVar = (i) it.next();
                    iVar.iCS = this.iCS;
                    if (iVar.start <= spannableString.length() && iVar.end <= spannableString.length()) {
                        spannableString.setSpan(new l(this.sUo, iVar), iVar.start, iVar.end, 33);
                    }
                }
            }
            it2 = this.sUc.iterator();
            while (it2.hasNext()) {
                lVar = (l) it2.next();
                if (lVar.start <= spannableString.length() && lVar.end <= spannableString.length()) {
                    drawable = this.mContext.getResources().getDrawable(lVar.id);
                    if (lVar.width > 0 || lVar.height <= 0) {
                        if (this.kH != null) {
                            i3 = (int) (((float) this.sUp) * 1.3f);
                        } else {
                            i3 = (int) (this.kH.getTextSize() * 1.3f);
                        }
                        drawable.setBounds(0, 0, i3, i3);
                    } else {
                        drawable.setBounds(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.mContext, lVar.width), com.tencent.mm.bg.a.fromDPToPix(this.mContext, lVar.height));
                    }
                    d dVar = new d(drawable);
                    dVar.wuA = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 2);
                    spannableString.setSpan(dVar, lVar.start, lVar.start + 1, 18);
                }
            }
            e(spannableString);
            bGv();
            if (z) {
                sTZ.k(str, new SpannableString(spannableString));
            }
            return spannableString;
        }
        i2 = 0;
        charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
        if (this.sUd) {
            charSequence = B(charSequence);
        }
        if (this.sUk) {
            charSequence = z(charSequence);
        }
        if (this.sUm) {
            charSequence = A(charSequence);
        }
        if (this.sUn) {
        }
        charSequence2 = charSequence;
        if (this.sUg) {
            this.sUb.addAll(C(charSequence2));
        }
        if (this.sUd) {
            this.sUb.addAll(D(charSequence2));
        }
        if (this.sUe) {
            this.sUb.addAll(E(charSequence2));
        }
        if (this.sUj) {
            this.sUb.addAll(I(charSequence2));
        }
        if (this.sUh) {
            this.sUb.addAll(F(charSequence2));
        }
        if (this.sUf) {
            this.sUb.addAll(G(charSequence2));
        }
        if (this.sUi) {
            this.sUb.addAll(H(charSequence2));
        }
        if (charSequence2 instanceof Spannable) {
            spannableString = new SpannableString(charSequence2);
        } else {
            spannableString = (SpannableString) charSequence2;
        }
        if (this.sUq) {
            it = this.sUa.iterator();
            while (it.hasNext()) {
                iVar = (i) it.next();
                iVar.iCS = this.iCS;
                spannableString.setSpan(new l(this.sUo, iVar), iVar.start, iVar.end, 33);
            }
        }
        it2 = this.sUc.iterator();
        while (it2.hasNext()) {
            lVar = (l) it2.next();
            drawable = this.mContext.getResources().getDrawable(lVar.id);
            if (lVar.width > 0) {
            }
            if (this.kH != null) {
                i3 = (int) (this.kH.getTextSize() * 1.3f);
            } else {
                i3 = (int) (((float) this.sUp) * 1.3f);
            }
            drawable.setBounds(0, 0, i3, i3);
            d dVar2 = new d(drawable);
            dVar2.wuA = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 2);
            spannableString.setSpan(dVar2, lVar.start, lVar.start + 1, 18);
        }
        e(spannableString);
        bGv();
        if (z) {
            sTZ.k(str, new SpannableString(spannableString));
        }
        return spannableString;
    }

    private static void d(Spannable spannable) {
        int i = 0;
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        while (i < spans.length) {
            if (!((spans[i] instanceof d) || (spans[i] instanceof l))) {
                spannable.removeSpan(spans[i]);
            }
            i++;
        }
    }

    private CharSequence z(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTn.matcher(charSequence.toString());
        while (matcher.find()) {
            CharSequence replace;
            if (this.sUl) {
                replace = charSequence.toString().replace(matcher.group(0), "");
            } else {
                replace = charSequence.toString().replace(matcher.group(0), "  ");
                String group = matcher.group(1);
                int start = matcher.start();
                int i = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    l lVar = new l(start, i, identifier);
                    if (!bg.mA(group) && "original_label".equals(group)) {
                        lVar.height = 15;
                        lVar.width = 35;
                    }
                    this.sUc.add(lVar);
                } else {
                    w.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTk.matcher(replace);
            charSequence = replace;
        }
        return charSequence;
    }

    private CharSequence A(CharSequence charSequence) {
        int parseColor;
        CharSequence charSequence2 = charSequence;
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTl.matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Object group4 = matcher.group(3);
            if (group3.length() >= 2) {
                CharSequence replace = charSequence2.toString().replace(group, group4);
                int start = matcher.start(0);
                int length = group4.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    w.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                    charSequence2 = replace;
                } else {
                    try {
                        parseColor = Color.parseColor(group2);
                    } catch (Exception e) {
                        w.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", group2);
                        parseColor = 0;
                    }
                    i a = a.a(this.mContext, group3, start, length, parseColor, parseColor & -1711276033);
                    if (a != null) {
                        if (this.sUr != null) {
                            a.data = this.sUr;
                        }
                        this.sUa.add(a);
                        this.sUb.add(new a(this, start, length));
                    }
                    charSequence2 = replace;
                    matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTl.matcher(replace);
                    i = 1;
                }
            }
        }
        if (i == 0) {
            Matcher matcher2 = com.tencent.mm.pluginsdk.ui.d.g.a.sTm.matcher(charSequence);
            while (matcher2.find()) {
                CharSequence group5 = matcher2.group(0);
                String group6 = matcher2.group(1);
                Object group7 = matcher2.group(2);
                if (group6.length() >= 2) {
                    charSequence2 = charSequence2.toString().replace(group5, group7);
                    int start2 = matcher2.start(0);
                    parseColor = group7.length() + start2;
                    if (start2 < 0 || parseColor > charSequence.length()) {
                        w.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(parseColor), Integer.valueOf(charSequence.length()));
                    } else {
                        M(group6, start2, parseColor);
                        matcher2 = com.tencent.mm.pluginsdk.ui.d.g.a.sTl.matcher(charSequence2);
                    }
                }
            }
        }
        return charSequence2;
    }

    private CharSequence B(CharSequence charSequence) {
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTk.matcher(charSequence.toString());
        CharSequence charSequence2 = charSequence;
        while (matcher.find()) {
            CharSequence group = matcher.group(0);
            String group2 = matcher.group(1);
            Object group3 = matcher.group(2);
            if (group2.length() >= 2) {
                charSequence2 = charSequence2.toString().replace(group, group3);
                int start = matcher.start(0);
                int length = group3.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    w.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    M(group2, start, length);
                    matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTk.matcher(charSequence2);
                }
            }
        }
        return charSequence2;
    }

    private ArrayList<a> C(CharSequence charSequence) {
        int i = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
        ArrayList<a> arrayList = new ArrayList();
        Pattern pattern = com.tencent.mm.pluginsdk.ui.d.g.a.sTr;
        if (charSequence.length() <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            i = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            i iVar = new i(matcher.group(), 24, null);
            iVar.start = start;
            iVar.end = end;
            if (!a(this.sUb, new a(this, start, end))) {
                this.sUa.add(iVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> D(CharSequence charSequence) {
        Matcher matcher;
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTq.matcher(charSequence2.toLowerCase());
        } else {
            matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTp.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.sUb, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end < charSequence2.length()) {
                    char charAt = charSequence2.charAt(end);
                    if ('a' <= charAt && charAt <= 'z') {
                    }
                }
                i iVar = new i(charSequence2.substring(start, end), 1, this.sUr);
                iVar.start = start;
                iVar.end = end;
                this.sUa.add(iVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> E(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= m.CTRL_INDEX) {
            Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTw.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.sUb, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                    i iVar = new i(charSequence2.substring(start, end), 44, this.sUr);
                    iVar.start = start;
                    iVar.end = end;
                    this.sUa.add(iVar);
                    arrayList.add(new a(this, start, end));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<a> F(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTt.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.sUb, new a(this, start, end)) && start >= 0 && end <= charSequence2.length()) {
                i iVar = new i(charSequence2.substring(start, end), 28, null);
                iVar.start = start;
                iVar.end = end;
                this.sUa.add(iVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> G(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTs.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Object group = matcher.group();
            int i = end - start;
            if (group.startsWith("+")) {
                i--;
            }
            if ((!(i == 6 || i == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains(group)) && !a(this.sUb, new a(this, start, end))) {
                i iVar = new i(group, 25, this.sUr);
                iVar.start = start;
                iVar.end = end;
                this.sUa.add(iVar);
                arrayList.add(new a(this, start, end));
            }
        }
        return arrayList;
    }

    private ArrayList<a> H(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = a.aV(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            a aVar = new a(this, iVar.start, iVar.end);
            if (!a(this.sUb, aVar)) {
                this.sUa.add(iVar);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<a> I(CharSequence charSequence) {
        ArrayList<a> arrayList = new ArrayList();
        String charSequence2 = charSequence.toString();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTv.matcher(charSequence2);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            a aVar = new a(this, start, end);
            if (!a(this.sUb, aVar) && start >= 0 && end <= charSequence2.length()) {
                i iVar = new i(charSequence2.substring(start, end), 30, null);
                iVar.start = start;
                iVar.end = end;
                this.sUa.add(iVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTu.matcher(charSequence2);
            while (matcher.find()) {
                start = matcher.start();
                end = matcher.end();
                aVar = new a(this, start, end);
                if (!a(this.sUb, aVar) && start >= 0 && end <= charSequence2.length()) {
                    iVar = new i(charSequence2.substring(start, end), 30, null);
                    iVar.start = start;
                    iVar.end = end;
                    this.sUa.add(iVar);
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private boolean M(String str, int i, int i2) {
        i a = a.a(this.mContext, str, i, i2);
        if (a == null) {
            return false;
        }
        if (this.sUr != null) {
            a.data = this.sUr;
        }
        this.sUa.add(a);
        this.sUb.add(new a(this, i, i2));
        return true;
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj;
            a aVar2 = (a) it.next();
            if (aVar2.end <= aVar.start || aVar.end <= aVar2.start) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void e(Spannable spannable) {
        if (this.kH != null && !bg.mA(spannable.toString())) {
            if (r.ijv) {
                this.kH.setText(spannable, BufferType.SPANNABLE);
            } else {
                this.kH.setText(spannable);
            }
        }
    }

    private void bGv() {
        if (this.kH != null) {
            OnTouchListener kVar = new k();
            kVar.iCS = this.iCS;
            this.kH.setOnTouchListener(kVar);
        }
    }

    public static void clearCache() {
        sTZ.clear();
    }
}
