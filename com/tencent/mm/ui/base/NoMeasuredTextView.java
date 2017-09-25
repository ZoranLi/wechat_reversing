package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable.Factory;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.bg;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final Metrics vpf = new Metrics();
    private int PN;
    private ColorStateList ec;
    public TextPaint gm;
    private int iO;
    private CharSequence mText;
    private int tW;
    private boolean vmh;
    private Factory voA;
    private TruncateAt voB;
    private CharSequence voC;
    private int voD;
    private KeyListener voE;
    private Layout voF;
    private float voG;
    private float voH;
    private int voI;
    private int voJ;
    private int voK;
    private int voL;
    private boolean voM;
    private boolean voN;
    private int voO;
    private boolean voP;
    private BoringLayout voQ;
    private boolean voR;
    private int voS;
    private FontMetricsInt voT;
    private boolean voU;
    public boolean voV;
    private b voW;
    private boolean voX;
    private boolean voY;
    private boolean voZ;
    private int voy;
    private Editable.Factory voz;
    private boolean vpa;
    private int vpb;
    private int vpc;
    private int vpd;
    private int vpe;

    public enum a {
        ;

        static {
            vpg = 1;
            vph = 2;
            vpi = 3;
            vpj = new int[]{vpg, vph, vpi};
        }
    }

    class b {
        final Rect vpk = new Rect();
        Drawable vpl;
        Drawable vpm;
        Drawable vpn;
        Drawable vpo;
        int vpp;
        int vpq;
        int vpr;
        int vps;
        int vpt;
        int vpu;
        int vpv;
        int vpw;
        int vpx;
        final /* synthetic */ NoMeasuredTextView vpy;

        b(NoMeasuredTextView noMeasuredTextView) {
            this.vpy = noMeasuredTextView;
        }
    }

    public final void kV(boolean z) {
        if (this.voX != z) {
            invalidate();
        }
        this.voX = z;
    }

    public final void kW(boolean z) {
        if (this.voY != z) {
            invalidate();
        }
        this.voY = z;
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.voz = Editable.Factory.getInstance();
        this.voA = Factory.getInstance();
        this.voB = null;
        this.voD = a.vpg;
        this.tW = 51;
        this.voG = 1.0f;
        this.voH = 0.0f;
        this.voI = Integer.MAX_VALUE;
        this.voJ = 1;
        this.voK = 0;
        this.voL = 1;
        this.iO = Integer.MAX_VALUE;
        this.voM = false;
        this.PN = 0;
        this.voN = false;
        this.voO = -1;
        this.voP = true;
        this.voR = false;
        this.voU = false;
        this.voV = false;
        this.voX = false;
        this.voY = false;
        this.voZ = false;
        this.vpa = false;
        this.vpb = -1;
        this.vpc = -1;
        this.vpd = -1;
        this.vpe = -1;
        this.mText = "";
        this.voC = "";
        this.gm = new TextPaint(1);
        this.gm.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.voT = this.gm.getFontMetricsInt();
        bSS();
        bSn();
        setEllipsize(null);
    }

    private void a(Drawable drawable, Drawable drawable2) {
        b bVar = this.voW;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b(this);
                this.voW = bVar;
            }
            if (!(bVar.vpn == drawable || bVar.vpn == null)) {
                bVar.vpn.setCallback(null);
            }
            bVar.vpn = drawable;
            if (!(bVar.vpl == null || bVar.vpl == null)) {
                bVar.vpl.setCallback(null);
            }
            bVar.vpl = null;
            if (!(bVar.vpo == drawable2 || bVar.vpo == null)) {
                bVar.vpo.setCallback(null);
            }
            bVar.vpo = drawable2;
            if (!(bVar.vpm == null || bVar.vpm == null)) {
                bVar.vpm.setCallback(null);
            }
            bVar.vpm = null;
            Rect rect = bVar.vpk;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.vpr = rect.width();
                bVar.vpv = rect.height();
            } else {
                bVar.vpv = 0;
                bVar.vpr = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.vps = rect.width();
                bVar.vpw = rect.height();
                bVar.vpt = 0;
                bVar.vpp = 0;
                bVar.vpu = 0;
                bVar.vpq = 0;
            }
            bVar.vpw = 0;
            bVar.vps = 0;
            bVar.vpt = 0;
            bVar.vpp = 0;
            bVar.vpu = 0;
            bVar.vpq = 0;
        } else if (bVar != null) {
            if (bVar.vpx == 0) {
                this.voW = null;
            } else {
                if (bVar.vpn != null) {
                    bVar.vpn.setCallback(null);
                }
                bVar.vpn = null;
                if (bVar.vpl != null) {
                    bVar.vpl.setCallback(null);
                }
                bVar.vpl = null;
                if (bVar.vpo != null) {
                    bVar.vpo.setCallback(null);
                }
                bVar.vpo = null;
                if (bVar.vpm != null) {
                    bVar.vpm.setCallback(null);
                }
                bVar.vpm = null;
                bVar.vpv = 0;
                bVar.vpr = 0;
                bVar.vpw = 0;
                bVar.vps = 0;
                bVar.vpt = 0;
                bVar.vpp = 0;
                bVar.vpu = 0;
                bVar.vpq = 0;
            }
        }
        invalidate();
    }

    public final void An(int i) {
        if (i != this.vpb) {
            this.vpb = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.voW == null || this.voW.vpn != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(drawable, null);
            }
        }
    }

    public final void Ao(int i) {
        if (i != this.vpc) {
            this.vpc = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.voW == null || this.voW.vpo != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(null, drawable);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ec != null && this.ec.isStateful()) {
            updateTextColors();
        }
        b bVar = this.voW;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.vpl != null && bVar.vpl.isStateful()) {
                bVar.vpl.setState(drawableState);
            }
            if (bVar.vpm != null && bVar.vpm.isStateful()) {
                bVar.vpm.setState(drawableState);
            }
            if (bVar.vpn != null && bVar.vpn.isStateful()) {
                bVar.vpn.setState(drawableState);
            }
            if (bVar.vpo != null && bVar.vpo.isStateful()) {
                bVar.vpo.setState(drawableState);
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.voW == null) {
            return verifyDrawable;
        }
        return drawable == this.voW.vpn || drawable == this.voW.vpl || drawable == this.voW.vpo || drawable == this.voW.vpm;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.voW;
            if (bVar != null) {
                int compoundPaddingTop;
                if (drawable == bVar.vpn) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.vpv) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.vpo) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.vps;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.vpw) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.vpl) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.vpt) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.vpm) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.vpu) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.vpq;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
    }

    private int getCompoundPaddingTop() {
        b bVar = this.voW;
        if (bVar == null || bVar.vpl == null || !this.voZ) {
            return getPaddingTop();
        }
        return bVar.vpp + (getPaddingTop() + bVar.vpx);
    }

    private int getCompoundPaddingBottom() {
        b bVar = this.voW;
        if (bVar == null || bVar.vpm == null || !this.vpa) {
            return getPaddingBottom();
        }
        return bVar.vpq + (getPaddingBottom() + bVar.vpx);
    }

    private int getCompoundPaddingLeft() {
        b bVar = this.voW;
        if (bVar == null || bVar.vpn == null || !this.voX) {
            return getPaddingLeft();
        }
        return bVar.vpr + (getPaddingLeft() + bVar.vpx);
    }

    private int getCompoundPaddingRight() {
        b bVar = this.voW;
        if (bVar == null || bVar.vpo == null || !this.voY) {
            return getPaddingRight();
        }
        return bVar.vps + (getPaddingRight() + bVar.vpx);
    }

    private int getExtendedPaddingTop() {
        if (this.voF == null || this.voJ != 1) {
            return getCompoundPaddingTop();
        }
        if (this.voF.getLineCount() <= this.voI) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.voF.getLineTop(this.voI);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i = this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return compoundPaddingTop;
        }
        if (i == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    private int getExtendedPaddingBottom() {
        if (this.voF == null || this.voJ != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.voF.getLineCount() <= this.voI) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.voF.getLineTop(this.voI);
        if (lineTop >= compoundPaddingTop) {
            return compoundPaddingBottom;
        }
        int i = this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return (compoundPaddingBottom + compoundPaddingTop) - lineTop;
        }
        return i != 80 ? compoundPaddingBottom + ((compoundPaddingTop - lineTop) / 2) : compoundPaddingBottom;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            bSQ();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public final void H(float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(0, f, system.getDisplayMetrics());
        if (applyDimension != this.gm.getTextSize()) {
            this.gm.setTextSize(applyDimension);
            this.voT = this.gm.getFontMetricsInt();
            this.voS = (int) (Math.ceil((double) (this.voT.descent - this.voT.ascent)) + 2.0d);
            if (this.voF != null) {
                bSQ();
                requestLayout();
                invalidate();
            }
        }
    }

    public final void setTextColor(int i) {
        this.ec = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        } else if (this.ec != colorStateList) {
            this.ec = colorStateList;
            updateTextColors();
        }
    }

    public final void wa() {
        Object obj = null;
        if (5 != (this.tW & 7)) {
            obj = 1;
        }
        if (53 != this.tW) {
            invalidate();
        }
        this.tW = 53;
        if (this.voF != null && r0 != null) {
            ea(this.voF.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
    }

    private void updateTextColors() {
        int i = 0;
        int colorForState = this.ec.getColorForState(getDrawableState(), 0);
        if (colorForState != this.voy) {
            this.voy = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
    }

    public final void setText(CharSequence charSequence) {
        int i = this.voD;
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(this.mText)) {
            int i2;
            if (charSequence instanceof Spanned) {
                this.voR = false;
            } else {
                this.voR = true;
            }
            if (i == a.vpi || this.voE != null) {
                charSequence = this.voz.newEditable(charSequence);
            } else if (i == a.vph) {
                charSequence = this.voA.newSpannable(charSequence);
            }
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.voV) {
                if (this.voM) {
                    i2 = this.iO;
                    if (getMeasuredWidth() > 0) {
                        i2 = Math.min(this.iO, getMeasuredWidth());
                    }
                    charSequence = TextUtils.ellipsize(charSequence, this.gm, (float) (i2 - compoundPaddingLeft), TruncateAt.END);
                } else if (getMeasuredWidth() > 0) {
                    charSequence = TextUtils.ellipsize(charSequence, this.gm, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
                } else {
                    this.voU = true;
                }
            }
            this.voD = i;
            this.mText = charSequence;
            this.voC = charSequence;
            if (this.voR) {
                bSS();
                invalidate();
                return;
            }
            if (getWidth() != 0) {
                if (this.voF == null) {
                    bSR();
                    if (this.voF.getHeight() != getHeight()) {
                        requestLayout();
                    }
                    invalidate();
                    return;
                }
                i2 = this.voF.getHeight();
                i = this.voF.getWidth();
                ea(i, i - compoundPaddingLeft);
                if (this.voB != TruncateAt.MARQUEE) {
                    if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                        i = this.voF.getHeight();
                        if (i == i2 && i == getHeight()) {
                            invalidate();
                            return;
                        }
                    }
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.voU && getMeasuredWidth() > 0) {
            setText(TextUtils.ellipsize(this.mText, this.gm, (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            this.voU = false;
        }
    }

    private int bSP() {
        int i = this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        Layout layout = this.voF;
        if (i == 48) {
            return 0;
        }
        int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (height >= measuredHeight) {
            return 0;
        }
        if (i == 80) {
            return measuredHeight - height;
        }
        return (measuredHeight - height) >> 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        b bVar = this.voW;
        float f = -1.0f;
        if (bVar != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.voX && bVar.vpn != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.vpv) / 2)));
                bVar.vpn.draw(canvas);
                canvas.restore();
            }
            if (this.voY && bVar.vpo != null) {
                float measureText;
                canvas.save();
                if (this.voR) {
                    measureText = this.gm.measureText(this.mText, 0, this.mText.length());
                    f = measureText;
                } else {
                    measureText = (float) Math.ceil((double) Layout.getDesiredWidth(this.voC, this.gm));
                }
                canvas.translate((measureText + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((compoundPaddingTop + scrollY) + ((i - bVar.vpw) / 2)));
                bVar.vpo.draw(canvas);
                canvas.restore();
            }
            if (this.voZ && bVar.vpl != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.vpt) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.vpl.draw(canvas);
                canvas.restore();
            }
            if (this.vpa && bVar.vpm != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.vpu) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.vpq));
                bVar.vpm.draw(canvas);
                canvas.restore();
            }
        }
        this.gm.setColor(this.voy);
        this.gm.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f2 = (float) (extendedPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f2, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        compoundPaddingTop = 0;
        compoundPaddingBottom = 0;
        if ((this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            compoundPaddingTop = bSP();
            compoundPaddingBottom = bSP();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + compoundPaddingTop));
        if (this.voR) {
            float f3 = (float) (((height - (this.voT.bottom - this.voT.top)) / 2) - this.voT.top);
            compoundPaddingBottom = 0;
            if ((this.tW & 7) != 3) {
                switch (this.tW & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.gm.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.gm.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f3, this.gm);
        } else {
            if (this.voF == null) {
                bSR();
            }
            this.voF.draw(canvas, null, null, compoundPaddingBottom - compoundPaddingTop);
        }
        canvas.restore();
    }

    public void getFocusedRect(Rect rect) {
        if (this.voF == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = Selection.getSelectionEnd(this.mText);
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int lineForOffset = this.voF.getLineForOffset(selectionEnd);
        rect.top = this.voF.getLineTop(lineForOffset);
        rect.bottom = this.voF.getLineBottom(lineForOffset);
        rect.left = (int) this.voF.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            selectionEnd += bSP();
        }
        rect.offset(lineForOffset, selectionEnd);
    }

    public int getBaseline() {
        if (this.voF == null) {
            return super.getBaseline();
        }
        int bSP;
        if ((this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            bSP = bSP();
        } else {
            bSP = 0;
        }
        return (bSP + getExtendedPaddingTop()) + this.voF.getLineBaseline(0);
    }

    private void bSQ() {
        if ((this.voF instanceof BoringLayout) && this.voQ == null) {
            this.voQ = (BoringLayout) this.voF;
        }
        this.voF = null;
    }

    private void bSR() {
        int compoundPaddingLeft;
        if (this.voM) {
            compoundPaddingLeft = (this.iO - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        ea(compoundPaddingLeft, compoundPaddingLeft);
    }

    private void ea(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.tW & 7) {
            case 1:
                alignment = Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.voB == null || this.voE != null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            this.voF = new StaticLayout(this.voC, 0, this.voC.length(), this.gm, i3, alignment, this.voG, this.voH, this.voP, this.voB, i2);
        } else {
            this.voF = new StaticLayout(this.voC, this.gm, i3, alignment, this.voG, this.voH, this.voP);
        }
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.voS);
        } else if (this.voR) {
            if (this.voS == 0) {
                bSS();
            }
            setMeasuredDimension(size, this.voS);
        } else {
            int i3;
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.voM) {
                compoundPaddingLeft = this.iO - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.voF == null) {
                ea(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                if (this.voF.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    ea(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == 1073741824) {
                this.voO = -1;
                compoundPaddingLeft = size2;
            } else {
                Layout layout = this.voF;
                if (layout == null) {
                    compoundPaddingLeft = 0;
                } else {
                    i3 = layout.getLineCount();
                    int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
                    compoundPaddingLeft = layout.getLineTop(i3) + compoundPaddingBottom;
                    if (this.voJ != 1) {
                        compoundPaddingLeft = Math.min(compoundPaddingLeft, this.voI);
                    } else if (i3 > this.voI) {
                        compoundPaddingLeft = (layout.getLineTop(this.voI) + layout.getBottomPadding()) + compoundPaddingBottom;
                        i3 = this.voI;
                    }
                    if (this.voL != 1) {
                        compoundPaddingLeft = Math.max(compoundPaddingLeft, this.voK);
                    } else if (i3 < this.voK) {
                        compoundPaddingLeft += (this.voK - i3) * Math.round((((float) this.gm.getFontMetricsInt(null)) * this.voG) + this.voH);
                    }
                    compoundPaddingLeft = Math.max(compoundPaddingLeft, getSuggestedMinimumHeight());
                }
                this.voO = compoundPaddingLeft;
                if (mode == Integer.MIN_VALUE) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
        }
    }

    private void bSS() {
        if (this.voS == 0) {
            this.voS = (int) (Math.ceil((double) (this.voT.descent - this.voT.ascent)) + 2.0d);
        }
    }

    public final void bSn() {
        this.vmh = true;
        this.voK = 1;
        this.voI = 1;
        this.voL = 1;
        this.voJ = 1;
        requestLayout();
        invalidate();
    }

    public final void setEllipsize(TruncateAt truncateAt) {
        this.voB = truncateAt;
        if (this.voF != null) {
            bSQ();
            requestLayout();
            invalidate();
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.voF != null) {
            return this.voF.getWidth();
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollRange() {
        if (this.voF != null) {
            return this.voF.getHeight();
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (bg.mA((String) contentDescription)) {
            contentDescription = this.mText;
        }
        accessibilityNodeInfo.setText(contentDescription);
    }
}
