package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMTagPanel extends FlowLayout {
    private boolean lIu = false;
    public int lJn = com.tencent.mm.s.a.d.aVo;
    public int lJo = f.bks;
    public int mUH = f.bkr;
    public int mUI = com.tencent.mm.s.a.d.aWu;
    public boolean mqM = true;
    public LinkedList<d> tzv = new LinkedList();
    public boolean vmA = true;
    public boolean vmB = false;
    public boolean vmC = false;
    public int vmD = f.hbU;
    private int vmE = 0;
    public int vmF = f.hbV;
    private int vmG = com.tencent.mm.s.a.d.white;
    private d vmH = null;
    private LinkedList<d> vmI = new LinkedList();
    public a vmJ;
    private int vmK;
    private View vmL;
    public MMEditText vmM;
    public boolean vmN = false;
    private OnClickListener vmO = new OnClickListener(this) {
        final /* synthetic */ MMTagPanel vmP;

        {
            this.vmP = r1;
        }

        public final void onClick(final View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                this.vmP.a((TextView) view, true, false);
                if (this.vmP.vmJ != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 vmR;

                        public final void run() {
                            this.vmR.vmP.vmJ.uN(((TextView) view).getText().toString());
                        }
                    });
                }
            } else if (!this.vmP.vmz || this.vmP.vmB) {
                this.vmP.a((TextView) view, false, false);
                if (this.vmP.vmJ != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 vmR;

                        public final void run() {
                            this.vmR.vmP.vmJ.uM(((TextView) view).getText().toString());
                        }
                    });
                }
            } else if (this.vmP.vmH == null) {
                this.vmP.vmH = MMTagPanel.a(this.vmP, ((TextView) view).getText().toString());
                if (this.vmP.vmH != null) {
                    this.vmP.a(this.vmP.vmH.vnb, false, true);
                }
            } else if (this.vmP.vmH.vnb == view) {
                this.vmP.vmH = null;
                this.vmP.a((TextView) view, false, false);
                if (this.vmP.vmJ != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 vmR;

                        public final void run() {
                            this.vmR.vmP.vmJ.uM(((TextView) view).getText().toString());
                        }
                    });
                }
            } else {
                this.vmP.bSA();
                this.vmP.vmH = MMTagPanel.a(this.vmP, ((TextView) view).getText().toString());
                this.vmP.a(this.vmP.vmH.vnb, false, true);
            }
        }
    };
    public boolean vmy = true;
    private boolean vmz = false;

    public interface a {
        void aoI();

        void h(boolean z, int i);

        void uM(String str);

        void uN(String str);

        void uO(String str);

        void uP(String str);

        void uQ(String str);
    }

    public class b implements InputFilter {
        int mark;
        final /* synthetic */ MMTagPanel vmP;
        List<String> vmS = new LinkedList();

        public b(MMTagPanel mMTagPanel) {
            this.vmP = mMTagPanel;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            w.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.vmP.lIu));
            this.mark = -1;
            this.vmS.clear();
            char[] cArr = new char[(i2 - i)];
            TextUtils.getChars(charSequence, i, i2, cArr, 0);
            if (this.vmP.vmA) {
                int i5 = i;
                while (i5 < i2) {
                    if (cArr[i5] == '\n' || cArr[i5] == ',' || cArr[i5] == ';' || cArr[i5] == '、' || cArr[i5] == '，' || cArr[i5] == '；') {
                        if (-1 == this.mark) {
                            this.vmS.add((spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i5)).trim());
                        } else {
                            this.vmS.add(charSequence.subSequence(this.mark, i5).toString().trim());
                        }
                        this.mark = i5 + 1;
                    }
                    i5++;
                }
                if (this.vmP.vmN) {
                    i5 = h.Un(spanned.toString());
                    if (this.vmP.lIu && charSequence.equals("\n") && 36 < i5) {
                        this.vmS.clear();
                    }
                }
                if (this.vmS.isEmpty()) {
                    return null;
                }
                String charSequence2;
                if (this.vmP.vmJ != null) {
                    for (final String charSequence22 : this.vmS) {
                        if (charSequence22.length() > 0) {
                            this.vmP.post(new Runnable(this) {
                                final /* synthetic */ b vmU;

                                public final void run() {
                                    this.vmU.vmP.vmJ.uQ(charSequence22.trim());
                                }
                            });
                        }
                    }
                }
                if (this.mark >= i2) {
                    spanned.length();
                    charSequence22 = spanned.subSequence(i4, spanned.length()).toString();
                } else {
                    charSequence22 = charSequence.subSequence(this.mark, i2).toString() + spanned.subSequence(i4, spanned.length());
                }
                this.vmP.post(new Runnable(this) {
                    final /* synthetic */ b vmU;

                    public final void run() {
                        this.vmU.vmP.vmM.setText("");
                        this.vmU.vmP.vmM.append(charSequence22);
                    }
                });
                return "";
            }
            Object obj = null;
            final StringBuilder stringBuilder = new StringBuilder();
            while (i < i2) {
                if (cArr[i] == '\n') {
                    obj = 1;
                } else {
                    stringBuilder.append(cArr[i]);
                }
                i++;
            }
            if (obj == null) {
                return null;
            }
            CharSequence stringBuilder2 = stringBuilder.toString();
            stringBuilder.insert(0, spanned.subSequence(0, i3));
            stringBuilder.append(spanned.subSequence(i4, spanned.length()));
            this.vmP.post(new Runnable(this) {
                final /* synthetic */ b vmU;

                public final void run() {
                    this.vmU.vmP.vmJ.uQ(stringBuilder.toString());
                }
            });
            return stringBuilder2;
        }
    }

    public class c implements InputFilter {
        final /* synthetic */ MMTagPanel vmP;
        int vmW = 36;
        private int vmX = 256;
        public int vmY;

        public c(MMTagPanel mMTagPanel) {
            this.vmP = mMTagPanel;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int Un = h.Un(spanned.toString()) + h.Un(charSequence.toString());
            if (i4 > i3) {
                if (Un - (i4 - i3) > this.vmW) {
                    this.vmP.lIu = true;
                    this.vmY = (Un - (i4 - i3)) - this.vmW;
                } else {
                    this.vmP.lIu = false;
                }
            } else if (Un > this.vmW) {
                this.vmP.lIu = true;
                this.vmY = Un - this.vmW;
            } else {
                this.vmP.lIu = false;
            }
            if (this.vmP.vmN && 1 == this.vmY && charSequence.equals("\n")) {
                this.vmY = 0;
            }
            if (this.vmP.vmJ != null) {
                this.vmP.post(new Runnable(this) {
                    final /* synthetic */ c vmZ;

                    {
                        this.vmZ = r1;
                    }

                    public final void run() {
                        this.vmZ.vmP.vmJ.h(this.vmZ.vmP.lIu, h.aI(this.vmZ.vmY, ""));
                    }
                });
            }
            if (Un > this.vmX) {
                return "";
            }
            return charSequence;
        }
    }

    public static final class d {
        public String vna;
        public TextView vnb;
    }

    static /* synthetic */ d a(MMTagPanel mMTagPanel, String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.MMTagPanel", "want to get tag info, but it is null or empty");
            return null;
        }
        Iterator it = mMTagPanel.tzv.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.vna)) {
                return dVar;
            }
        }
        w.w("MicroMsg.MMTagPanel", "want to get tag %s, but it not exsited!", str);
        return null;
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void auy() {
    }

    private void init() {
        this.vmK = getContext().getResources().getDimensionPixelSize(e.aXs);
        this.vmL = LayoutInflater.from(getContext()).inflate(com.tencent.mm.s.a.h.heH, null);
        this.vmM = (MMEditText) this.vmL.findViewById(g.bKP);
        this.vmM.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MMTagPanel vmP;

            {
                this.vmP = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && 67 == i) {
                    w.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", Integer.valueOf(this.vmP.vmM.getSelectionStart()), Integer.valueOf(this.vmP.vmM.getSelectionEnd()));
                    boolean z = this.vmP.vmM.getSelectionStart() == 0 && this.vmP.vmM.getSelectionStart() == this.vmP.vmM.getSelectionEnd();
                    if (z) {
                        this.vmP.auy();
                        if (!(this.vmP.tzv == null || this.vmP.tzv.isEmpty())) {
                            if (!this.vmP.vmB && this.vmP.vmH == null) {
                                this.vmP.vmH = (d) this.vmP.tzv.getLast();
                                this.vmP.a(this.vmP.vmH.vnb, false, true);
                                this.vmP.vmM.setCursorVisible(false);
                            } else if (this.vmP.vmH == null || this.vmP.tzv == null || this.vmP.tzv.getLast() == null || bg.mA(this.vmP.vmH.vna) || bg.mA(((d) this.vmP.tzv.getLast()).vna) || this.vmP.vmH.vna.equals(((d) this.vmP.tzv.getLast()).vna)) {
                                String str = ((d) this.vmP.tzv.getLast()).vna;
                                this.vmP.removeTag(str);
                                if (this.vmP.vmJ != null) {
                                    this.vmP.vmJ.uO(str);
                                }
                                this.vmP.bSA();
                            } else {
                                w.i("MicroMsg.MMTagPanel", "change hight");
                                this.vmP.bSA();
                                this.vmP.vmH = (d) this.vmP.tzv.getLast();
                                this.vmP.a(this.vmP.vmH.vnb, false, true);
                                this.vmP.vmM.setCursorVisible(false);
                            }
                        }
                    }
                }
                return false;
            }
        });
        this.vmM.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMTagPanel vmP;

            {
                this.vmP = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (this.vmP.vmJ != null) {
                    this.vmP.vmJ.uP(obj);
                }
                if (obj.length() > 0) {
                    this.vmP.bSA();
                }
            }
        });
        this.vmM.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMTagPanel vmP;

            {
                this.vmP = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                w.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
                if (z && this.vmP.vmJ != null) {
                    this.vmP.vmJ.aoI();
                }
            }
        });
        this.vmM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMTagPanel vmP;

            {
                this.vmP = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.MMTagPanel", "on edittext click");
                this.vmP.bSA();
                if (this.vmP.vmJ != null) {
                    this.vmP.vmJ.aoI();
                }
            }
        });
        this.vmM.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MMTagPanel vmP;

            {
                this.vmP = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                w.d("MicroMsg.MMTagPanel", "on action %d, %s", Integer.valueOf(i), keyEvent);
                return false;
            }
        });
        final c cVar = new c(this);
        b bVar = new b(this);
        this.vmM.setFilters(new InputFilter[]{cVar, bVar});
        bSx();
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMTagPanel vmP;

            {
                this.vmP = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", Boolean.valueOf(this.vmP.vmz));
                if (this.vmP.vmz) {
                    this.vmP.bSA();
                    this.vmP.vmM.requestFocus();
                    this.vmP.vmM.setSelection(this.vmP.vmM.getText().length());
                    ((InputMethodManager) this.vmP.getContext().getSystemService("input_method")).showSoftInput(this.vmP.vmM, 0);
                    w.d("MicroMsg.MMTagPanel", "on content click");
                    if (this.vmP.vmJ != null) {
                        this.vmP.vmJ.aoI();
                    }
                }
            }
        });
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMTagPanel vmP;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.vmP.vmC) {
                    String bSt = this.vmP.bSt();
                    if (!bg.mA(bSt)) {
                        if (cVar != null && h.Un(bSt) > cVar.vmW) {
                            int Uo = cVar.vmW - h.Uo(bSt);
                            if (Uo <= bSt.length()) {
                                bSt = bSt.substring(0, Uo);
                            }
                        }
                        this.vmP.aT(bSt, true);
                        if (this.vmP.vmJ != null) {
                            this.vmP.vmJ.uQ(bSt);
                        }
                        this.vmP.bSu();
                    }
                }
                return false;
            }
        });
    }

    public final void Ak(int i) {
        this.vmE = i;
        if (this.vmM != null) {
            com.tencent.mm.bg.a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(e.aXH);
            this.vmM.setBackgroundResource(this.vmE);
        }
    }

    public final void Tb(String str) {
        if (this.vmM != null) {
            this.vmM.setHint(str);
        }
    }

    public final String bSt() {
        if (this.vmM != null) {
            return this.vmM.getText().toString();
        }
        return "";
    }

    public final void bSu() {
        if (this.vmM != null) {
            this.vmM.setText("");
        }
    }

    public final boolean bSv() {
        if (this.vmM == null) {
            return false;
        }
        return this.vmM.isFocused();
    }

    public final void bSw() {
        if (this.vmM != null && !this.vmM.isFocused()) {
            this.vmM.requestFocus();
        }
    }

    public final void bSx() {
        if (this.vmM != null && this.vmM.isFocused()) {
            w.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                IBinder windowToken = this.vmM.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    this.vmM.clearFocus();
                }
            }
        }
    }

    public final void kU(boolean z) {
        if (z != this.vmz) {
            this.vmz = z;
            removeView(this.vmL);
            if (this.vmz) {
                addView(this.vmL);
                bSx();
            }
        }
    }

    public final ArrayList<String> bSy() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.tzv.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bg.mA(dVar.vna)) {
                arrayList.add(dVar.vna);
            }
        }
        return arrayList;
    }

    public void bSm() {
        this.tzv.clear();
        removeAllViews();
        Iterator it = this.tzv.iterator();
        while (it.hasNext()) {
            a((d) it.next());
        }
    }

    public final void a(Collection<String> collection, List<String> list) {
        bSm();
        if (this.vmz) {
            addView(this.vmL);
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                aT(str, collection == null ? false : collection.contains(str));
            }
        }
    }

    public final d bSz() {
        if (!this.vmI.isEmpty()) {
            return (d) this.vmI.removeFirst();
        }
        d dVar = new d();
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(this.lJo);
        textView.setTextColor(getResources().getColor(this.lJn));
        textView.setTag(Integer.valueOf(0));
        textView.setGravity(17);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.vmD, 0);
        textView.setOnClickListener(this.vmy ? this.vmO : null);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine();
        dVar.vnb = textView;
        return dVar;
    }

    public final void a(d dVar) {
        dVar.vnb.setOnClickListener(null);
        if (this.vmI.size() < 16) {
            this.vmI.add(dVar);
        }
    }

    public final void a(d dVar, String str, boolean z) {
        dVar.vna = str;
        dVar.vnb.setText(com.tencent.mm.ui.f.c.b.a(getContext(), (CharSequence) str, this.vmK));
        dVar.vnb.setOnClickListener(this.vmy ? this.vmO : null);
        a(dVar.vnb, z, false);
    }

    public final void bSA() {
        if (this.vmM != null) {
            w.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", Boolean.valueOf(this.vmM.isFocused()));
            this.vmM.setCursorVisible(true);
        }
        if (this.vmH != null) {
            boolean z;
            TextView textView = this.vmH.vnb;
            if (((Integer) this.vmH.vnb.getTag()).intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            a(textView, z, false);
            this.vmH = null;
        }
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        textView.setTextSize(0, getContext().getResources().getDimension(e.aXs) * com.tencent.mm.bg.a.dI(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.vmF);
            textView.setTextColor(getResources().getColor(this.vmG));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.vmD, 0);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.mUH);
            textView.setTextColor(getResources().getColor(this.mUI));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.lJo);
            textView.setTextColor(getResources().getColor(this.lJn));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public final void aT(String str, boolean z) {
        if (bg.mA(str)) {
            w.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            return;
        }
        String trim = str.trim();
        w.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", trim);
        removeTag(trim);
        Iterator it = this.tzv.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).vna)) {
                w.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", trim);
                return;
            }
        }
        d bSz = bSz();
        a(bSz, trim, z);
        this.tzv.add(bSz);
        if (this.vmz) {
            addView(bSz.vnb, getChildCount() - 1);
        } else {
            addView(bSz.vnb);
        }
        bSA();
    }

    public final void removeTag(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            return;
        }
        Iterator it = this.tzv.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.vna)) {
                this.tzv.remove(dVar);
                removeView(dVar.vnb);
                a(dVar);
                bSA();
                return;
            }
        }
        w.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", str);
    }

    public final void aU(String str, boolean z) {
        if (bg.mA(str)) {
            w.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            return;
        }
        Iterator it = this.tzv.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.vna)) {
                a(dVar, str, z);
                bSA();
                return;
            }
        }
        w.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mqM) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
