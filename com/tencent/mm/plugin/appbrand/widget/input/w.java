package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan.Standard;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.bi.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.widget.a.d;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
public abstract class w extends EditText implements d, y {
    private static final String juU = "-1";
    private final ae jiB = new ae(Looper.getMainLooper());
    private volatile String jsR = juU;
    InputConnection juR;
    private Method juS;
    boolean juT = false;
    private final b juV;
    private final Map<com.tencent.mm.plugin.appbrand.widget.input.y.a, Object> juW = new android.support.v4.e.a();
    private final Map<OnFocusChangeListener, Object> juX = new android.support.v4.e.a();
    private final Map<y.b, Object> juY = new android.support.v4.e.a();
    private final a juZ = new a(this);
    private final PasswordTransformationMethod jva = new k();
    private boolean jvb;
    private int jvc = 0;
    boolean jvd = false;
    private final int[] jve = new int[2];

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jvf = new int[Alignment.values().length];

        static {
            try {
                jvf[Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jvf[Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private final class a implements TextWatcher {
        final Map<TextWatcher, Object> jvg = new android.support.v4.e.a();
        final /* synthetic */ w jvh;

        public a(w wVar) {
            this.jvh = wVar;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.b(this.jvh) && !this.jvg.isEmpty()) {
                for (TextWatcher beforeTextChanged : (TextWatcher[]) this.jvg.keySet().toArray(new TextWatcher[this.jvg.size()])) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.b(this.jvh) && !this.jvg.isEmpty()) {
                for (TextWatcher onTextChanged : (TextWatcher[]) this.jvg.keySet().toArray(new TextWatcher[this.jvg.size()])) {
                    onTextChanged.onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void afterTextChanged(Editable editable) {
            if (d.Yu()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                final String a = w.a(editable, pBool, pInt);
                final int i = pInt.value;
                if (pBool.value && !bg.mA(a)) {
                    final int selectionEnd = Selection.getSelectionEnd(editable);
                    final boolean b = w.b(this.jvh);
                    this.jvh.post(new Runnable(this) {
                        final /* synthetic */ a jvm;

                        public final void run() {
                            if (b) {
                                this.jvm.jvh.r(a);
                            } else {
                                this.jvm.jvh.setText(a);
                            }
                            try {
                                this.jvm.jvh.setSelection(Math.min(selectionEnd + i, a.length()));
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[]{e});
                            }
                        }
                    });
                    return;
                }
            }
            if (!w.b(this.jvh)) {
                this.jvh.jvc = 0;
                if (!this.jvg.isEmpty()) {
                    for (TextWatcher afterTextChanged : (TextWatcher[]) this.jvg.keySet().toArray(new TextWatcher[this.jvg.size()])) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            }
        }
    }

    protected abstract void YR();

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i = 0;
        while (i < length) {
            String str;
            int codePointAt = obj.codePointAt(i);
            c yz = com.tencent.mm.bi.b.bKy().yz(codePointAt);
            if (yz == null || yz.uyp == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), Character.toChars(yz.uyp) + (yz.uyq != 0 ? Character.toChars(yz.uyq) : ""));
                pBool.value = true;
                pInt.value++;
            }
            i++;
            obj = str;
        }
        return obj;
    }

    static /* synthetic */ boolean b(w wVar) {
        return wVar.jvc > 0;
    }

    public final String Yi() {
        return this.jsR;
    }

    public final void rp(String str) {
        juU.equals(this.jsR);
        this.jsR = str;
    }

    public String toString() {
        return String.format(Locale.US, "[%s|%s]", new Object[]{getClass().getSimpleName(), this.jsR});
    }

    public final View getView() {
        return this;
    }

    public boolean YQ() {
        return true;
    }

    public final b Zi() {
        return this.juV;
    }

    public void l(float f, float f2) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.input.y.a aVar) {
        this.juW.put(aVar, this);
    }

    public final void a(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.juX.put(onFocusChangeListener, this);
        }
    }

    public final void b(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.juX.remove(onFocusChangeListener);
        }
    }

    public final void a(y.b bVar) {
        this.juY.put(bVar, this);
    }

    public w(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        iV(3);
        setSingleLine(true);
        try {
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(R.g.bcd));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[]{bg.g(e)});
        }
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.juZ);
        super.setPadding(0, 0, 0, 0);
        try {
            this.juS = TextView.class.getDeclaredMethod("nullLayouts", new Class[0]);
        } catch (Exception e2) {
        }
        if (YQ()) {
            this.juV = new b(this);
        } else {
            this.juV = null;
        }
        this.jvb = true;
    }

    public boolean Yh() {
        return false;
    }

    private void iV(int i) {
        setGravity(((getGravity() & -8388612) & -8388614) | i);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Alignment alignment;
            hint = ad.s(hint);
            switch (gravity & 7) {
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
            hint.setSpan(new Standard(alignment), 0, getHint().length(), 18);
            super.setHint(hint);
            if (VERSION.SDK_INT >= 17) {
                switch (AnonymousClass1.jvf[alignment.ordinal()]) {
                    case 1:
                        gravity = 4;
                        break;
                    case 2:
                        gravity = 6;
                        break;
                    default:
                        gravity = 5;
                        break;
                }
                super.setTextAlignment(gravity);
            }
        }
    }

    public final int iW(int i) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[]{Integer.valueOf(i), Integer.valueOf(getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())))), getLayout()});
        return getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())));
    }

    public final int Zj() {
        return iW(getLineCount()) + getPaddingBottom();
    }

    public final void Zk() {
        iV(3);
    }

    public final void Zl() {
        iV(5);
    }

    public final void Zm() {
        iV(1);
    }

    public void setSelection(int i) {
        if (getEditableText() != null) {
            super.setSelection(Math.min(i, getEditableText().length()));
        }
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.juR = super.onCreateInputConnection(editorInfo);
        return this.juR;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setMinHeight(int i) {
        if (getMinHeight() != i) {
            super.setMinHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        if (getMaxHeight() != i) {
            super.setMaxHeight(i);
        }
    }

    protected final void onMeasure(int i, int i2) {
        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i, i2);
        if (!this.juY.isEmpty()) {
            for (Object obj : this.juY.keySet().toArray()) {
                y.b bVar = (y.b) obj;
                getMeasuredWidth();
                getMeasuredHeight();
                bVar.YS();
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z, i, i2, i3, i4);
    }

    final void Zn() {
        this.jvc++;
    }

    final void Zo() {
        this.jvc = Math.max(0, this.jvc - 1);
    }

    public final void r(CharSequence charSequence) {
        Zn();
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, BufferType.EDITABLE);
        } else {
            clearComposingText();
            if (TextUtils.isEmpty(charSequence)) {
                editableText.clear();
            } else {
                editableText.replace(0, editableText.length(), charSequence);
            }
        }
        Zo();
    }

    public final void m(m mVar) {
        if (this.juV != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = this.juV.jvY;
            cVar.jwj = mVar;
            i g = i.g(mVar);
            com.tencent.mm.plugin.appbrand.widget.input.i.a aVar = cVar.jwi;
            if (aVar != null && !g.jtr.containsKey(aVar)) {
                g.jtr.put(aVar, g);
            }
        }
    }

    public final void n(m mVar) {
        if (this.juV != null) {
            i.g(mVar).a(this.juV.jvY.jwi);
        }
    }

    public final void cA(boolean z) {
        this.jvd = true;
    }

    public final boolean Zp() {
        return this.jvd;
    }

    public void cx(boolean z) {
        Zn();
        this.juT = z;
        setTransformationMethod(z ? this.jva : null);
        Zo();
    }

    public void setInputType(int i) {
        if (getInputType() != i) {
            super.setInputType(i);
        }
    }

    public void setSingleLine(boolean z) {
    }

    public final void setTextSize(float f) {
        super.setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.juZ;
        if (textWatcher != null) {
            aVar.jvg.put(textWatcher, aVar);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.juZ;
        if (textWatcher != null) {
            aVar.jvg.remove(textWatcher);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.juW.isEmpty()) {
            for (com.tencent.mm.plugin.appbrand.widget.input.y.a Zq : (com.tencent.mm.plugin.appbrand.widget.input.y.a[]) this.juW.keySet().toArray(new com.tencent.mm.plugin.appbrand.widget.input.y.a[this.juW.size()])) {
                Zq.Zq();
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            clearComposingText();
        }
        if (z) {
            YR();
        }
        if (!this.juX.isEmpty()) {
            for (OnFocusChangeListener onFocusChange : (OnFocusChangeListener[]) this.juX.keySet().toArray(new OnFocusChangeListener[this.juX.size()])) {
                onFocusChange.onFocusChange(this, z);
            }
        }
    }

    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        super.clearFocus();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (130 == i && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(262144);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        return super.requestFocus(i, rect);
    }

    @Deprecated
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void destroy() {
        this.juW.clear();
        this.juY.clear();
        this.juX.clear();
        this.juZ.jvg.clear();
        if (this.juV != null) {
            b bVar = this.juV;
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = bVar.jvY;
            i.g(cVar.jwj).a(cVar.jwi);
            bVar.jwb = null;
            bVar.jvW.dismiss();
        }
        setOnFocusChangeListener(null);
    }
}
