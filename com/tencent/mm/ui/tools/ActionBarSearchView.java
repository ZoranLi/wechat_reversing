package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements f {
    private TextWatcher sQf = new TextWatcher(this) {
        final /* synthetic */ ActionBarSearchView wkt;

        {
            this.wkt = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.wkt.bZs();
            t b = this.wkt.wkm;
            if (b.woX) {
                EditText editText = (EditText) b.woV.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.jqT == null || b.jqT.length() == 0)) || (b.jqT != null && b.jqT.equals(charSequence.toString()))) {
                        w.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.jqT);
                    } else {
                        b.jqT = charSequence != null ? charSequence.toString() : "";
                        b.woU = t.i(b.jqT, b.woW);
                        if (t.a(editText, b.woW)) {
                            w.d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (this.wkt.wkn != null) {
                this.wkt.wkn.zE(charSequence == null ? "" : charSequence.toString());
            }
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private View wkh;
    private ActionBarEditText wki;
    private ImageButton wkj;
    private int wkk = c.wkv;
    private boolean wkl = false;
    private t wkm;
    public b wkn;
    public a wko;
    private OnFocusChangeListener wkp = new OnFocusChangeListener(this) {
        final /* synthetic */ ActionBarSearchView wkt;

        {
            this.wkt = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            w.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (this.wkt.wkq != null) {
                this.wkt.wkq.onFocusChange(view, z);
            }
        }
    };
    public OnFocusChangeListener wkq;
    private OnClickListener wkr = new OnClickListener(this) {
        final /* synthetic */ ActionBarSearchView wkt;

        {
            this.wkt = r1;
        }

        public final void onClick(View view) {
            if (c.wkv == this.wkt.wkk) {
                w.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                this.wkt.lH(true);
                if (this.wkt.wkn != null) {
                    this.wkt.wkn.OF();
                    return;
                }
                return;
            }
            w.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (this.wkt.wkn != null) {
                this.wkt.wkn.aHo();
            }
        }
    };
    private OnClickListener wks = new OnClickListener(this) {
        final /* synthetic */ ActionBarSearchView wkt;

        {
            this.wkt = r1;
        }

        public final void onClick(View view) {
            if (this.wkt.wko != null) {
                this.wkt.wko.aHp();
            }
        }
    };

    public interface a {
        void aHp();
    }

    public interface b {
        void OF();

        void aHn();

        void aHo();

        void zE(String str);
    }

    private enum c {
        ;

        static {
            wkv = 1;
            wkw = 2;
            wkx = new int[]{wkv, wkw};
        }
    }

    class d extends Drawable {
        private RectF fw;
        private String jqT;
        private float wkA;
        private float wkB;
        private Bitmap wkC;
        final /* synthetic */ ActionBarSearchView wkt;
        private Paint wky;
        private int wkz = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ab.getContext(), 2.0f);

        d(ActionBarSearchView actionBarSearchView, EditText editText, String str) {
            this.wkt = actionBarSearchView;
            this.wky = new Paint(editText.getPaint());
            this.jqT = str;
            this.wky.setColor(ab.getResources().getColor(com.tencent.mm.s.a.d.aUd));
            this.wkC = com.tencent.mm.sdk.platformtools.d.t(actionBarSearchView.getResources().getDrawable(j.dsU));
            this.wkA = this.wky.measureText(this.jqT);
            FontMetrics fontMetrics = this.wky.getFontMetrics();
            this.wkB = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((((this.wkA + ((float) (this.wkz * 2))) + ((float) (this.wkz * 2))) + ((float) this.wkC.getWidth())) + 2.0f), (int) (((float) this.wkC.getHeight()) > this.wkB ? (float) this.wkC.getHeight() : this.wkB));
        }

        public final void draw(Canvas canvas) {
            FontMetricsInt fontMetricsInt = this.wky.getFontMetricsInt();
            Rect bounds = getBounds();
            int i = (bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top;
            canvas.drawBitmap(this.wkC, (float) ((int) ((((float) (bounds.right - bounds.left)) - (this.fw.right - this.fw.left)) / 2.0f)), (float) bounds.top, null);
            canvas.drawText(this.jqT, (float) ((bounds.left + this.wkC.getWidth()) + 2), (float) i, this.wky);
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.wky.getFontMetrics();
            this.fw = new RectF((float) (this.wkz + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - this.wkz), (float) i4);
            invalidateSelf();
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        ActionBarSearchView wku;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            w.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    w.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    w.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        w.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.wku.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ActionBarSearchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.hdG, this, true);
        this.wkh = findViewById(g.bmv);
        this.wkh.setOnClickListener(this.wks);
        this.wki = (ActionBarEditText) findViewById(g.bKP);
        this.wkm = new t(this.wki);
        this.wki.wku = this;
        this.wki.post(new Runnable(this) {
            final /* synthetic */ ActionBarSearchView wkt;

            {
                this.wkt = r1;
            }

            public final void run() {
                this.wkt.wki.setText("");
                if (this.wkt.wkn != null) {
                    this.wkt.wkn.aHn();
                }
            }
        });
        this.wkj = (ImageButton) findViewById(g.cGq);
        this.wki.addTextChangedListener(this.sQf);
        this.wki.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ActionBarSearchView wkt;

            {
                this.wkt = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67) {
                    return false;
                }
                w.d("MicroMsg.ActionBarSearchView", "on back key click.");
                t b = this.wkt.wkm;
                if (b.woX) {
                    EditText editText = (EditText) b.woV.get();
                    if (!(editText == null || b.woU == null)) {
                        CharSequence text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart == editText.getSelectionEnd()) {
                            b Cf = b.Cf(selectionStart);
                            if (Cf != null && Cf.wpa) {
                                text.delete(Cf.start, Cf.start + Cf.length);
                                editText.setTextKeepState(text);
                                editText.setSelection(Cf.start);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        });
        this.wki.wsl = new com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a(this) {
            final /* synthetic */ ActionBarSearchView wkt;

            {
                this.wkt = r1;
            }

            public final void a(EditText editText, int i, int i2) {
                w.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
                t b = this.wkt.wkm;
                if (b.woX) {
                    EditText editText2 = (EditText) b.woV.get();
                    if (editText2 != null && editText == editText2) {
                        CharSequence text = editText2.getText();
                        int selectionStart = editText2.getSelectionStart();
                        int selectionEnd = editText2.getSelectionEnd();
                        if (selectionStart >= 0 && selectionEnd >= selectionStart) {
                            if (selectionStart == selectionEnd) {
                                b Cf = b.Cf(selectionStart);
                                if (Cf != null && Cf.wpa) {
                                    editText2.setTextKeepState(text);
                                    editText2.setSelection(Cf.length + Cf.start);
                                    return;
                                }
                                return;
                            }
                            b Cf2 = b.Cf(selectionStart);
                            if (Cf2 != null && Cf2.wpa) {
                                selectionStart = Cf2.start + Cf2.length;
                            }
                            if (selectionStart >= selectionEnd) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart);
                                return;
                            }
                            b Cf3 = b.Cf(selectionEnd);
                            if (Cf3 != null && Cf3.wpa) {
                                int i3 = Cf3.start;
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart, i3);
                            }
                        }
                    }
                }
            }
        };
        this.wki.setOnFocusChangeListener(this.wkp);
        com.tencent.mm.ui.tools.a.c.d(this.wki).Ch(100).a(null);
        this.wkj.setOnClickListener(this.wkr);
    }

    public final String bzZ() {
        if (this.wki.getEditableText() != null) {
            return this.wki.getEditableText().toString();
        }
        return "";
    }

    public final void a(b bVar) {
        this.wkn = bVar;
    }

    public final void a(a aVar) {
        this.wko = aVar;
    }

    public final void Ug(String str) {
        if (str == null) {
            str = "";
        }
        this.wki.setText(str);
        this.wki.setSelection(str.length());
    }

    public final void setHint(CharSequence charSequence) {
        this.wki.setHint(charSequence);
    }

    public final void lE(boolean z) {
        this.wkl = z;
        bZs();
    }

    public final void lF(boolean z) {
        this.wki.setEnabled(z);
    }

    public final void lG(boolean z) {
        this.wkj.setEnabled(z);
    }

    private void ei(int i, int i2) {
        this.wkj.setImageResource(i);
        this.wkj.setBackgroundResource(0);
        if (i == f.hbY) {
            this.wkj.setContentDescription(getContext().getString(k.hft));
        } else {
            this.wkj.setContentDescription(getContext().getString(k.bCu));
        }
        LayoutParams layoutParams = this.wkj.getLayoutParams();
        layoutParams.width = i2;
        this.wkj.setLayoutParams(layoutParams);
    }

    private void bZs() {
        if (this.wki.getEditableText() != null && !bg.mA(this.wki.getEditableText().toString())) {
            ei(f.hbQ, getResources().getDimensionPixelSize(e.aXF));
            this.wkk = c.wkv;
        } else if (this.wkl) {
            ei(f.hbY, getResources().getDimensionPixelSize(e.aXF));
            this.wkk = c.wkw;
        } else {
            ei(0, 0);
            this.wkk = c.wkv;
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.wki.setOnEditorActionListener(onEditorActionListener);
    }

    public final void lH(boolean z) {
        if (z) {
            this.wki.setText("");
            return;
        }
        this.wki.removeTextChangedListener(this.sQf);
        this.wki.setText("");
        this.wki.addTextChangedListener(this.sQf);
    }

    public final void bZt() {
        this.wki.clearFocus();
    }

    public final void a(com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a aVar) {
    }

    public final boolean bZu() {
        if (this.wki != null) {
            return this.wki.hasFocus();
        }
        return false;
    }

    public final boolean bZv() {
        if (this.wki != null) {
            return this.wki.requestFocus();
        }
        return false;
    }

    public final void ak(ArrayList<String> arrayList) {
        if (this.wkm != null) {
            t tVar = this.wkm;
            tVar.woW = arrayList;
            if (tVar.woX) {
                EditText editText = (EditText) tVar.woV.get();
                if (editText != null) {
                    t.a(editText, tVar.woW);
                }
            }
        }
    }

    public final void lI(boolean z) {
        if (this.wkm != null) {
            this.wkm.woX = z;
        }
    }

    public final void Cd(int i) {
        if (this.wki != null) {
            this.wki.setCompoundDrawables(ab.getResources().getDrawable(i), null, null, null);
        }
    }

    public final void Uh(String str) {
        if (this.wki != null) {
            this.wki.setCompoundDrawables(new d(this, this.wki, str), null, null, null);
            this.wki.setHint("");
        }
    }
}
