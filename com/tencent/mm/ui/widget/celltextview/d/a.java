package com.tencent.mm.ui.widget.celltextview.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.celltextview.b.a.b;
import com.tencent.mm.ui.widget.celltextview.c.d;
import com.tencent.mm.ui.widget.celltextview.c.e;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.ui.widget.celltextview.b.a.a {
    private int PN;
    private int el;
    private int em;
    private int iO;
    private TextPaint jux;
    private Context mContext;
    private float mGH;
    private int vpx;
    private String wxZ;
    private b wyE;
    private com.tencent.mm.ui.widget.celltextview.f.a wyF;
    private int wyG = Integer.MAX_VALUE;
    private int wyH;
    private int wyI;
    private float wyJ;
    private boolean wyK = true;
    private CharSequence wyL;
    private int wyM;
    private int wyN;
    private int wyO;
    private int wyP;
    private int wyQ = -16776961;
    private boolean wyR = true;
    private Drawable wyS;
    private int wyT;
    private LinkedList<a> wyU;
    private LinkedList<a> wyV;
    private com.tencent.mm.ui.widget.celltextview.c.b wyW;
    private int wyX;
    private int wya;
    private int wyb;
    private ArrayList<e> wyc;
    private LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> wyd;
    private ArrayList<d> wyj;
    private float wyk;
    private int xT = WebView.NIGHT_MODE_COLOR;

    private class a {
        int wyY;
        Rect wyZ;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (this.wyY != ((a) obj).wyY) {
                return false;
            }
            return true;
        }
    }

    public final /* bridge */ /* synthetic */ Paint getPaint() {
        return this.jux;
    }

    public a(Context context, TextPaint textPaint) {
        this.mContext = context;
        this.wyj = new ArrayList();
        this.wyF = new com.tencent.mm.ui.widget.celltextview.f.b();
        this.mGH = com.tencent.mm.ui.widget.celltextview.g.b.f(context, 14.0f);
        this.wyP = (int) com.tencent.mm.ui.widget.celltextview.g.b.f(context, 6.0f);
        this.jux = textPaint;
        this.jux.setColor(this.xT);
        this.jux.setTextSize(this.mGH);
    }

    public final void Cu(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (size <= 0) {
            Context context = this.mContext;
            size = context == null ? 0 : context.getResources().getDisplayMetrics().widthPixels;
        }
        if (this.iO > 0 && this.iO < r2) {
            size = this.iO;
        }
        int i2 = (this.PN == 0 || this.PN <= size) ? size : this.PN;
        if (this.wyK) {
            Object obj;
            d dVar;
            this.wyK = false;
            int aC = aC(this.wyU) + aC(this.wyV);
            int i3 = ((i2 - aC) - this.wyM) - this.wyN;
            if (this.wyR) {
                com.tencent.mm.ui.widget.celltextview.a.b caU = com.tencent.mm.ui.widget.celltextview.a.b.caU();
                ArrayList arrayList = this.wyc;
                CharSequence charSequence = this.wyL;
                com.tencent.mm.ui.widget.celltextview.a.a aVar = new com.tencent.mm.ui.widget.celltextview.a.a(charSequence == null ? "" : charSequence.toString(), this.mGH, (float) i3);
                aVar.al(arrayList);
                com.tencent.mm.ui.widget.celltextview.a.a aVar2 = (com.tencent.mm.ui.widget.celltextview.a.a) caU.wyn.get(aVar);
                if (aVar2 != null) {
                    LinkedList linkedList = this.wyd;
                    if (!(aVar2.wyd == null || linkedList == null)) {
                        linkedList.clear();
                        linkedList.addAll(aVar2.wyd);
                    }
                    ArrayList arrayList2 = this.wyc;
                    if (!(aVar2.wyc == null || arrayList2 == null)) {
                        arrayList2.clear();
                        arrayList2.addAll(aVar2.wyc);
                    }
                    arrayList2 = this.wyj;
                    if (!(aVar2.wyj == null || arrayList2 == null)) {
                        arrayList2.clear();
                        arrayList2.addAll(aVar2.wyj);
                    }
                    obj = 1;
                    w.i("CellLayout", "[measureImpl] target at Cache!!!");
                } else {
                    w.i("CellLayout", "[measureImpl] don't target at Cache!!!");
                    obj = null;
                    CD(i3);
                    com.tencent.mm.ui.widget.celltextview.a.b.caU().a(this.wyL, this.mGH, (float) i3, this.wyd, this.wyj, this.wyc);
                }
            } else {
                obj = null;
                CD(i3);
                com.tencent.mm.ui.widget.celltextview.a.b.caU().a(this.wyL, this.mGH, (float) i3, this.wyd, this.wyj, this.wyc);
            }
            this.wyI = this.wyj.size();
            int cbb = cbb();
            Iterator it = this.wyj.iterator();
            float f = 0.0f;
            while (it.hasNext()) {
                dVar = (d) it.next();
                f = dVar.wyv > f ? dVar.wyv : f;
            }
            this.wyk = Math.min((float) i3, f);
            if (obj == null) {
                int i4;
                float f2;
                float f3;
                float f4 = this.wyk;
                float b = this.wyF.b(this.jux);
                Iterator it2 = this.wyj.iterator();
                int i5 = -1;
                while (it2.hasNext()) {
                    dVar = (d) it2.next();
                    i4 = i5 + 1;
                    int size2 = dVar.getSize();
                    RectF CA = dVar.CA(size2 - 1);
                    f2 = f4 - (CA == null ? 0.0f : CA.right);
                    if (f2 == 0.0f || Math.abs(f2) > b) {
                        i5 = i4;
                    } else {
                        i5 = -1;
                        for (int i6 = 0; i6 < size2; i6++) {
                            e Cz = dVar.Cz(i6);
                            i5 = Cz.getType() == 2 ? i5 + 1 : i5 + Cz.getLength();
                        }
                        f3 = i5 == 0 ? 0.0f : f2 / ((float) i5);
                        float f5 = 0.0f;
                        for (int i7 = 0; i7 < size2; i7++) {
                            RectF CA2 = dVar.CA(i7);
                            e Cz2 = dVar.Cz(i7);
                            i5 = Cz2.getLength();
                            if (Cz2.getType() == 2) {
                                i5 = 1;
                            }
                            float width = CA2.width();
                            CA2.left = f5;
                            CA2.right = (((float) i5) * f3) + (width + f5);
                            f5 += CA2.width();
                        }
                        dVar.wyv = f5;
                        dVar.wyz = f3;
                        String str = "CellLayout";
                        String str2 = "[adaptLetterSpacing] line:%s size:%s letterSpacing:%s textSize:%s lineRight:%s";
                        Object[] objArr = new Object[5];
                        objArr[0] = Integer.valueOf(i4);
                        objArr[1] = Integer.valueOf(size2);
                        objArr[2] = Float.valueOf(f3);
                        objArr[3] = Float.valueOf(b);
                        objArr[4] = Float.valueOf(CA == null ? 0.0f : CA.right);
                        w.i(str, str2, objArr);
                        i5 = i4;
                    }
                }
                if (this.wyd != null) {
                    Iterator it3 = this.wyd.iterator();
                    while (it3.hasNext()) {
                        com.tencent.mm.ui.widget.celltextview.c.b bVar = (com.tencent.mm.ui.widget.celltextview.c.b) it3.next();
                        i3 = bVar.abH;
                        int i8 = bVar.wd;
                        LinkedList linkedList2 = new LinkedList();
                        LinkedList linkedList3 = new LinkedList();
                        Iterator it4 = this.wyj.iterator();
                        while (it4.hasNext()) {
                            dVar = (d) it4.next();
                            if (dVar.wyx <= i3 && i3 <= dVar.wyy) {
                                if (dVar.wyx <= i8 && i8 <= dVar.wyy) {
                                    linkedList2.add(dVar);
                                    break;
                                }
                                linkedList2.add(dVar);
                            } else if (dVar.wyx <= i8 && i8 <= dVar.wyy) {
                                linkedList2.add(dVar);
                                break;
                            } else if (linkedList2.size() > 0) {
                                linkedList2.add(dVar);
                            }
                        }
                        Iterator it5 = linkedList2.iterator();
                        while (it5.hasNext()) {
                            dVar = (d) it5.next();
                            w.i("CellLayout", "[getLineIndex] line:[%s:%s]", Integer.valueOf(dVar.wyx), Integer.valueOf(dVar.wyy));
                            int i9 = dVar.wyx;
                            f2 = -1.0f;
                            f3 = -1.0f;
                            for (i4 = 0; i4 < dVar.getSize(); i4++) {
                                int length = dVar.Cz(i4).getLength();
                                if (i9 <= i3 && i3 <= i9 + length) {
                                    f2 = (float) ((int) (dVar.CA(i4).left + dVar.Cz(i4).m(i3 - i9, dVar.wyz)));
                                }
                                if (i9 <= i8 && i8 < i9 + length) {
                                    f3 = (float) ((int) (dVar.CA(i4).left + dVar.Cz(i4).m(i8 - i9, dVar.wyz)));
                                }
                                i9 += length;
                            }
                            if (f2 >= 0.0f && r5 < 0.0f) {
                                f3 = dVar.wyv;
                            } else if (f2 < 0.0f && r5 >= 0.0f) {
                                f2 = 0.0f;
                            } else if (f2 < 0.0f && r5 < 0.0f) {
                                f2 = 0.0f;
                                f3 = dVar.wyv;
                            }
                            if (f2 >= 0.0f && f3 >= 0.0f && f2 < f3) {
                                w.i("CellLayout", "[getLineIndex] rect:[%s:%s]", Float.valueOf(f2), Float.valueOf(f3));
                                linkedList3.add(new RectF(f2, dVar.CA(0).top, f3, dVar.CA(0).bottom));
                            }
                        }
                        bVar.wyr = linkedList3;
                    }
                }
            }
            this.wyJ = (float) ((this.el + this.em) + cbb);
            if (((float) this.wyH) > this.wyJ) {
                this.wyJ = (float) this.wyH;
            }
            if (mode == 1073741824 || (mode == 0 && i2 > 0)) {
                this.wyk = (float) i2;
            } else {
                this.wyk = ((this.wyk + ((float) this.wyM)) + ((float) this.wyN)) + ((float) aC);
            }
            this.wyk = Math.max(this.wyk, (float) this.PN);
            this.wyJ = Math.max(this.wyJ, (float) this.wyT);
            return;
        }
        w.w("CellLayout", "[measureImpl] content is not change!");
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        float cbb = (float) cbb();
        if (this.wyO == 80) {
            canvas.translate((float) aC(this.wyU), this.wyJ - cbb);
        } else if (this.wyO == 3) {
            canvas.translate((float) (this.wyM + aC(this.wyU)), (this.wyJ - cbb) / 2.0f);
        } else if (this.wyO == 16) {
            canvas.translate((float) (this.wyM + aC(this.wyU)), (this.wyJ - cbb) / 2.0f);
        }
        if (this.wyW != null) {
            com.tencent.mm.ui.widget.celltextview.c.b bVar = this.wyW;
            Iterator it = bVar.wyr.iterator();
            while (it.hasNext()) {
                RectF rectF = (RectF) it.next();
                canvas.save();
                canvas.clipRect(rectF);
                canvas.drawColor(bVar.jkE);
                canvas.restore();
            }
        }
        int size = this.wyj.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.wyj.get(i);
            int size2 = dVar.getSize();
            canvas.save();
            if (this.wyO == 1 || this.wyO == 17) {
                float f = (this.wyk - dVar.wyv) / 2.0f;
                dVar.wyA = f;
                canvas.translate(f, 0.0f);
            }
            for (int i2 = 0; i2 < size2; i2++) {
                dVar.Cz(i2).a(canvas, dVar.CA(i2), dVar.wyz, this.wyF.b(this.jux));
            }
            canvas.restore();
        }
        canvas.restore();
    }

    public final void requestLayout() {
        this.wyK = true;
    }

    public final void setTextColor(int i) {
        this.xT = i;
        this.jux.setColor(i);
    }

    public final void Ct(int i) {
        this.wyG = i;
    }

    public final void setTextSize(float f) {
        this.mGH = f;
        this.jux.setTextSize(f);
    }

    public final void setMaxWidth(int i) {
        this.iO = i;
    }

    public final void setMinWidth(int i) {
        this.PN = i;
    }

    public final void a(ArrayList<e> arrayList, CharSequence charSequence) {
        this.wyc = arrayList;
        this.wyL = charSequence;
    }

    public final void aB(LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> linkedList) {
        this.wyd = linkedList;
    }

    public final void a(com.tencent.mm.ui.widget.celltextview.c.b bVar) {
        this.wyW = bVar;
    }

    public final List<com.tencent.mm.ui.widget.celltextview.c.b> caV() {
        return this.wyd;
    }

    public final void U(String str, int i, int i2) {
        this.wxZ = str;
        this.wya = i;
        this.wyb = i2;
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        this.wyM = i;
        this.el = i2;
        this.em = i4;
        this.wyN = i3;
        if (this.wyS != null) {
            Rect rect = new Rect();
            this.wyS.getPadding(rect);
            w.i("CellLayout", "[measureImpl] drawableRect:%s", rect);
            this.wyM = rect.left;
            this.wyN = rect.right;
            this.el = rect.top;
            this.em = rect.bottom;
            this.PN = this.wyS.getMinimumWidth();
            this.wyH = this.wyS.getMinimumHeight();
        }
    }

    public final void Cv(int i) {
        this.wyO = i;
    }

    public final void Cw(int i) {
        this.wyP = i;
    }

    public final void setMinHeight(int i) {
        this.wyH = i;
    }

    public final void Cx(int i) {
        this.wyQ = i;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.wyS = drawable;
    }

    public final String caW() {
        if (this.wyc == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.wyc.iterator();
        while (it.hasNext()) {
            String text = ((e) it.next()).getText();
            if (text != null) {
                stringBuilder.append(text);
            }
        }
        return stringBuilder.toString();
    }

    public final String getText() {
        if (this.wyL == null) {
            return "";
        }
        return this.wyL.toString();
    }

    public final int getMaxLines() {
        return this.wyG;
    }

    public final float getTextSize() {
        return this.mGH;
    }

    public final int getMeasuredWidth() {
        return (int) this.wyk;
    }

    public final int getMeasuredHeight() {
        return (int) this.wyJ;
    }

    public final int getPaddingLeft() {
        return this.wyM;
    }

    public final int getPaddingRight() {
        return this.wyN;
    }

    public final int getPaddingTop() {
        return this.el;
    }

    public final int getPaddingBottom() {
        return this.em;
    }

    private void CD(int i) {
        if (this.wyc != null && this.wyc.size() != 0) {
            Object obj;
            this.wyj.clear();
            d cbc = cbc();
            int i2 = 0;
            loop0:
            while (i2 < this.wyc.size()) {
                e eVar = (e) this.wyc.get(i2);
                eVar.cba();
                d dVar = cbc;
                e eVar2 = eVar;
                while (eVar2 != null && !TextUtils.isEmpty(eVar2.getText())) {
                    if (this.wyG > 0 && this.wyG < this.wyj.size()) {
                        obj = 1;
                        break loop0;
                    }
                    int i3 = i - this.wyX;
                    com.tencent.mm.ui.widget.celltextview.c.a a = this.wyF.a(eVar2, this.jux, i3, i, i2 < this.wyc.size() + -1);
                    float b = this.wyF.b(this.jux);
                    int i4 = a.wyp;
                    float f = a.width;
                    if (i4 > 0 && (eVar2.caX() || f <= ((float) i3) || f - ((float) i3) <= b)) {
                        e caY = eVar2.caY();
                        caY.v(0, i4, null);
                        float f2 = 0.0f;
                        for (int i5 = 0; i5 < this.wyj.size() - 1; i5++) {
                            f2 += ((d) this.wyj.get(i5)).wyw;
                        }
                        dVar.a(caY, new RectF((float) this.wyX, f2, ((float) this.wyX) + f, caY.Cy(this.wyP) + f2));
                        this.wyX = (int) (((float) this.wyX) + f);
                        if (i4 >= eVar2.getLength()) {
                            eVar2 = null;
                        } else {
                            eVar2 = eVar2.caY();
                            eVar2.v(i4, -1, null);
                        }
                    }
                    if (eVar2 == null && cZ(eVar.getText(), eVar.getText().length() - 1) == '\n') {
                        dVar = cbc();
                    } else if (eVar2 != null) {
                        dVar = cbc();
                    }
                }
                i2++;
                cbc = dVar;
            }
            cbd();
            obj = null;
            if (obj != null) {
                CE(i);
            }
        }
    }

    private int cbb() {
        Iterator it = this.wyj.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (int) (((d) it.next()).wyw + ((float) i));
        }
        return i;
    }

    private void CE(int i) {
        int i2;
        e Cz;
        if (this.wyj.size() < 2) {
            cbc();
        }
        d dVar = (d) this.wyj.get(this.wyj.size() - 2);
        float measureText = this.jux.measureText("...", 0, 3);
        this.wyX = 0;
        int size = dVar.getSize();
        int i3 = 0;
        while (i3 < size) {
            e Cz2 = dVar.Cz(i3);
            int i4 = (int) ((((float) i) - measureText) - ((float) this.wyX));
            if (i4 > 0) {
                boolean z;
                com.tencent.mm.ui.widget.celltextview.f.a aVar = this.wyF;
                Paint paint = this.jux;
                if (i3 < size - 1) {
                    z = true;
                } else {
                    z = false;
                }
                com.tencent.mm.ui.widget.celltextview.c.a a = aVar.a(Cz2, paint, i4, i, z);
                int i5 = a.wyp;
                float width = dVar.CA(i3).width();
                if (width <= ((float) i4)) {
                    this.wyX = (int) (((float) this.wyX) + width);
                    i3++;
                } else {
                    if (Cz2.caX()) {
                        if (cZ(Cz2.getText(), i5 - 1) == '\n') {
                            i5--;
                        }
                        Cz2.v(0, i5, "...");
                        dVar.CB(i3 + 1);
                        this.wyX = (int) (((float) this.wyX) + a.width);
                        i2 = 1;
                    } else {
                        dVar.CB(i3);
                        i2 = 0;
                    }
                    this.wyX += (int) measureText;
                    if (this.wyj.size() == 2 && r1 == 0 && ((d) this.wyj.get(1)).Cz(0) == null) {
                        Cz = dVar.Cz(dVar.getSize() - 1);
                        if (Cz != null && Cz.caX()) {
                            Cz.v(0, -1, "...");
                            i2 = 1;
                        }
                    }
                    this.wyk = ((float) this.wyX) <= this.wyk ? (float) this.wyX : this.wyk;
                    if (i2 == 0) {
                        RectF rectF = new RectF(dVar.CA(dVar.getSize() - 1));
                        Cz2 = dVar.Cz(dVar.getSize() - 1);
                        if (Cz2.caX() && Cz2.getText().endsWith("\n")) {
                            Cz2.v(0, Cz2.getText().length() - 1, null);
                        }
                        rectF.left = rectF.right;
                        rectF.right = (float) this.wyX;
                        dVar.a(new e(this.jux, 0, "...", this.mGH), rectF);
                    }
                }
            }
            return;
        }
        i2 = 0;
        this.wyX += (int) measureText;
        Cz = dVar.Cz(dVar.getSize() - 1);
        Cz.v(0, -1, "...");
        i2 = 1;
        if (((float) this.wyX) <= this.wyk) {
        }
        this.wyk = ((float) this.wyX) <= this.wyk ? (float) this.wyX : this.wyk;
        if (i2 == 0) {
            RectF rectF2 = new RectF(dVar.CA(dVar.getSize() - 1));
            Cz2 = dVar.Cz(dVar.getSize() - 1);
            Cz2.v(0, Cz2.getText().length() - 1, null);
            rectF2.left = rectF2.right;
            rectF2.right = (float) this.wyX;
            dVar.a(new e(this.jux, 0, "...", this.mGH), rectF2);
        }
    }

    private d cbc() {
        cbd();
        this.wyX = 0;
        d dVar = new d();
        dVar.wyw = 0.0f;
        this.wyj.add(dVar);
        return dVar;
    }

    private void cbd() {
        int size = this.wyj.size() - 1;
        if (size >= 0) {
            int i;
            d dVar = (d) this.wyj.get(size);
            int i2 = 0;
            for (i = 0; i < dVar.getSize(); i++) {
                i2 += dVar.Cz(i).getLength();
            }
            if (size == 0) {
                dVar.et(0, i2);
                return;
            }
            i = ((d) this.wyj.get(size - 1)).wyy;
            dVar.et(i, i + i2);
        }
    }

    private static char cZ(String str, int i) {
        if (i < 0 || str == null || i >= str.length()) {
            return '\u0000';
        }
        return str.charAt(i);
    }

    private int aC(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (((a) it.next()).wyZ.width() + this.vpx) + i;
        }
        return i;
    }
}
