package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.view.g;
import android.support.v4.widget.e;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements android.support.v7.view.c {
    private static final boolean abX;
    static final a acG = new a();
    private final OnItemSelectedListener Gf;
    private final h Um;
    private final SearchAutoComplete abY;
    private final View abZ;
    private CharSequence acA;
    private CharSequence acB;
    private boolean acC;
    private int acD;
    private SearchableInfo acE;
    private Bundle acF;
    private Runnable acH;
    private final Runnable acI;
    private Runnable acJ;
    private final WeakHashMap<String, ConstantState> acK;
    OnKeyListener acL;
    private final OnEditorActionListener acM;
    private final OnItemClickListener acN;
    private TextWatcher acO;
    private final View aca;
    private final View acb;
    private final ImageView acc;
    private final ImageView acd;
    private final ImageView ace;
    private final ImageView acf;
    private final View acg;
    private final ImageView ach;
    private final Drawable aci;
    private final int acj;
    private final int ack;
    private final Intent acl;
    private final Intent acm;
    private final CharSequence acn;
    private c aco;
    private b acp;
    private OnFocusChangeListener acq;
    private d acr;
    private OnClickListener acs;
    private boolean act;
    private boolean acu;
    private e acv;
    private boolean acw;
    private CharSequence acx;
    private boolean acy;
    private boolean acz;
    private int iO;
    private final OnClickListener mOnClickListener;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean acU;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.acU = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.acU));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.acU + "}";
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int acV;
        SearchView acW;

        static /* synthetic */ boolean a(SearchAutoComplete searchAutoComplete) {
            return TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, android.support.v7.a.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.acV = getThreshold();
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.acV = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.acW.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.o(getContext())) {
                    SearchView.acG.a(this);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.acW.gC();
        }

        public boolean enoughToFilter() {
            return this.acV <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.acW.clearFocus();
                        this.acW.X(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    private static class a {
        Method acQ;
        Method acR;
        private Method acS;
        Method acT;

        a() {
            try {
                this.acQ = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.acQ.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.acR = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.acR.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.acS = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.acS.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.acT = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.acT.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        final void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.acS != null) {
                try {
                    this.acS.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(true)});
                } catch (Exception e) {
                }
            }
        }
    }

    public interface b {
        boolean onClose();
    }

    public interface c {
        boolean gE();
    }

    public interface d {
        boolean gF();

        boolean gG();
    }

    static /* synthetic */ void a(SearchView searchView) {
        int[] iArr = searchView.abY.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = searchView.aca.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = searchView.acb.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        searchView.invalidate();
    }

    static /* synthetic */ void a(SearchView searchView, CharSequence charSequence) {
        boolean z = true;
        CharSequence text = searchView.abY.getText();
        searchView.acB = text;
        boolean z2 = !TextUtils.isEmpty(text);
        searchView.W(z2);
        if (z2) {
            z = false;
        }
        searchView.Y(z);
        searchView.gy();
        searchView.gx();
        if (!(searchView.aco == null || TextUtils.equals(charSequence, searchView.acA))) {
            charSequence.toString();
        }
        searchView.acA = charSequence.toString();
    }

    static /* synthetic */ boolean b(SearchView searchView, int i) {
        if (searchView.acr != null && searchView.acr.gF()) {
            return false;
        }
        CharSequence text = searchView.abY.getText();
        Cursor cursor = searchView.acv.Bo;
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = searchView.acv.convertToString(cursor);
                if (convertToString != null) {
                    searchView.h(convertToString);
                } else {
                    searchView.h(text);
                }
            } else {
                searchView.h(text);
            }
        }
        return true;
    }

    static /* synthetic */ void d(SearchView searchView) {
        if (searchView.acg.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.aca.getPaddingLeft();
            Rect rect = new Rect();
            boolean bw = at.bw(searchView);
            int dimensionPixelSize = searchView.act ? resources.getDimensionPixelSize(android.support.v7.a.a.d.IU) + resources.getDimensionPixelSize(android.support.v7.a.a.d.IT) : 0;
            searchView.abY.getDropDownBackground().getPadding(rect);
            searchView.abY.setDropDownHorizontalOffset(bw ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            searchView.abY.setDropDownWidth((dimensionPixelSize + ((searchView.acg.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    static /* synthetic */ void h(SearchView searchView) {
        if (!TextUtils.isEmpty(searchView.abY.getText())) {
            searchView.abY.setText("");
            searchView.abY.requestFocus();
            searchView.X(true);
        } else if (!searchView.act) {
        } else {
            if (searchView.acp == null || !searchView.acp.onClose()) {
                searchView.clearFocus();
                searchView.V(true);
            }
        }
    }

    static /* synthetic */ void j(SearchView searchView) {
        CharSequence text = searchView.abY.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (searchView.aco != null) {
                c cVar = searchView.aco;
                text.toString();
                if (cVar.gE()) {
                    return;
                }
            }
            if (searchView.acE != null) {
                searchView.a(0, null, text.toString());
            }
            searchView.X(false);
            searchView.abY.dismissDropDown();
        }
    }

    static /* synthetic */ void l(SearchView searchView) {
        String str = null;
        if (searchView.acE != null) {
            SearchableInfo searchableInfo = searchView.acE;
            try {
                Intent intent;
                String str2;
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    intent = new Intent(searchView.acl);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    str2 = "calling_package";
                    if (searchActivity != null) {
                        str = searchActivity.flattenToShortString();
                    }
                    intent.putExtra(str2, str);
                    searchView.getContext().startActivity(intent);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    String string;
                    Intent intent2 = searchView.acm;
                    ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                    intent = new Intent("android.intent.action.SEARCH");
                    intent.setComponent(searchActivity2);
                    Parcelable activity = PendingIntent.getActivity(searchView.getContext(), 0, intent, 1073741824);
                    Bundle bundle = new Bundle();
                    if (searchView.acF != null) {
                        bundle.putParcelable("app_data", searchView.acF);
                    }
                    Intent intent3 = new Intent(intent2);
                    String str3 = "free_form";
                    int i = 1;
                    if (VERSION.SDK_INT >= 8) {
                        Resources resources = searchView.getResources();
                        string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : str3;
                        str2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                        str3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                        if (searchableInfo.getVoiceMaxResults() != 0) {
                            i = searchableInfo.getVoiceMaxResults();
                        }
                    } else {
                        str2 = null;
                        string = str3;
                        str3 = null;
                    }
                    intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
                    intent3.putExtra("android.speech.extra.PROMPT", str2);
                    intent3.putExtra("android.speech.extra.LANGUAGE", str3);
                    intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
                    String str4 = "calling_package";
                    if (searchActivity2 != null) {
                        str = searchActivity2.flattenToShortString();
                    }
                    intent3.putExtra(str4, str);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                    searchView.getContext().startActivity(intent3);
                }
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        abX = z;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.acH = new Runnable(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) this.acP.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    a aVar = SearchView.acG;
                    View view = this.acP;
                    if (aVar.acT != null) {
                        try {
                            aVar.acT.invoke(inputMethodManager, new Object[]{Integer.valueOf(0), null});
                            return;
                        } catch (Exception e) {
                        }
                    }
                    inputMethodManager.showSoftInput(view, 0);
                }
            }
        };
        this.acI = new Runnable(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void run() {
                SearchView.a(this.acP);
            }
        };
        this.acJ = new Runnable(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void run() {
                if (this.acP.acv != null && (this.acP.acv instanceof ak)) {
                    this.acP.acv.changeCursor(null);
                }
            }
        };
        this.acK = new WeakHashMap();
        this.mOnClickListener = new OnClickListener(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void onClick(View view) {
                if (view == this.acP.acc) {
                    this.acP.gB();
                } else if (view == this.acP.ace) {
                    SearchView.h(this.acP);
                } else if (view == this.acP.acd) {
                    SearchView.j(this.acP);
                } else if (view == this.acP.acf) {
                    SearchView.l(this.acP);
                } else if (view == this.acP.abY) {
                    this.acP.gD();
                }
            }
        };
        this.acL = new OnKeyListener(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (this.acP.acE == null) {
                    return false;
                }
                if (this.acP.abY.isPopupShowing() && this.acP.abY.getListSelection() != -1) {
                    return this.acP.b(i, keyEvent);
                }
                if (SearchAutoComplete.a(this.acP.abY) || !g.a(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                this.acP.a(0, null, this.acP.abY.getText().toString());
                return true;
            }
        };
        this.acM = new OnEditorActionListener(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.j(this.acP);
                return true;
            }
        };
        this.acN = new OnItemClickListener(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.acP.bq(i);
            }
        };
        this.Gf = new OnItemSelectedListener(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.b(this.acP, i);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.acO = new TextWatcher(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.a(this.acP, charSequence);
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        this.Um = h.ey();
        ap a = ap.a(context, attributeSet, k.cH, i);
        LayoutInflater.from(context).inflate(a.getResourceId(k.MV, h.KQ), this, true);
        this.abY = (SearchAutoComplete) findViewById(f.Kp);
        this.abY.acW = this;
        this.abZ = findViewById(f.Kl);
        this.aca = findViewById(f.Ko);
        this.acb = findViewById(f.Ku);
        this.acc = (ImageView) findViewById(f.Kj);
        this.acd = (ImageView) findViewById(f.Km);
        this.ace = (ImageView) findViewById(f.Kk);
        this.acf = (ImageView) findViewById(f.Kq);
        this.ach = (ImageView) findViewById(f.Kn);
        this.aca.setBackgroundDrawable(a.getDrawable(k.MW));
        this.acb.setBackgroundDrawable(a.getDrawable(k.Na));
        this.acc.setImageDrawable(a.getDrawable(k.MZ));
        this.acd.setImageDrawable(a.getDrawable(k.MT));
        this.ace.setImageDrawable(a.getDrawable(k.MQ));
        this.acf.setImageDrawable(a.getDrawable(k.Nc));
        this.ach.setImageDrawable(a.getDrawable(k.MZ));
        this.aci = a.getDrawable(k.MY);
        this.acj = a.getResourceId(k.Nb, h.KP);
        this.ack = a.getResourceId(k.MR, 0);
        this.acc.setOnClickListener(this.mOnClickListener);
        this.ace.setOnClickListener(this.mOnClickListener);
        this.acd.setOnClickListener(this.mOnClickListener);
        this.acf.setOnClickListener(this.mOnClickListener);
        this.abY.setOnClickListener(this.mOnClickListener);
        this.abY.addTextChangedListener(this.acO);
        this.abY.setOnEditorActionListener(this.acM);
        this.abY.setOnItemClickListener(this.acN);
        this.abY.setOnItemSelectedListener(this.Gf);
        this.abY.setOnKeyListener(this.acL);
        this.abY.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ SearchView acP;

            {
                this.acP = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.acP.acq != null) {
                    this.acP.acq.onFocusChange(this.acP, z);
                }
            }
        });
        boolean z = a.getBoolean(k.MU, true);
        if (this.act != z) {
            this.act = z;
            V(z);
            gA();
        }
        int dimensionPixelSize = a.getDimensionPixelSize(k.MP, -1);
        if (dimensionPixelSize != -1) {
            this.iO = dimensionPixelSize;
            requestLayout();
        }
        this.acn = a.getText(k.MS);
        this.acx = a.getText(k.MX);
        dimensionPixelSize = a.getInt(k.MN, -1);
        if (dimensionPixelSize != -1) {
            this.abY.setImeOptions(dimensionPixelSize);
        }
        dimensionPixelSize = a.getInt(k.MO, -1);
        if (dimensionPixelSize != -1) {
            this.abY.setInputType(dimensionPixelSize);
        }
        setFocusable(a.getBoolean(k.MM, true));
        a.aeG.recycle();
        this.acl = new Intent("android.speech.action.WEB_SEARCH");
        this.acl.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.acl.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.acm = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.acm.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.acg = findViewById(this.abY.getDropDownAnchor());
        if (this.acg != null) {
            if (VERSION.SDK_INT >= 11) {
                this.acg.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                    final /* synthetic */ SearchView acP;

                    {
                        this.acP = r1;
                    }

                    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        SearchView.d(this.acP);
                    }
                });
            } else {
                this.acg.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ SearchView acP;

                    {
                        this.acP = r1;
                    }

                    public final void onGlobalLayout() {
                        SearchView.d(this.acP);
                    }
                });
            }
        }
        V(this.act);
        gA();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.acy || !isFocusable()) {
            return false;
        }
        if (this.acu) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.abY.requestFocus(i, rect);
        if (requestFocus) {
            V(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.acy = true;
        X(false);
        super.clearFocus();
        this.abY.clearFocus();
        this.acy = false;
    }

    protected void onMeasure(int i, int i2) {
        if (this.acu) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.iO <= 0) {
                    size = Math.min(gv(), size);
                    break;
                } else {
                    size = Math.min(this.iO, size);
                    break;
                }
            case 0:
                if (this.iO <= 0) {
                    size = gv();
                    break;
                } else {
                    size = this.iO;
                    break;
                }
            case 1073741824:
                if (this.iO > 0) {
                    size = Math.min(this.iO, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int gv() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.a.a.d.IV);
    }

    private void V(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.acu = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.abY.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.acc.setVisibility(i2);
        W(z2);
        View view = this.abZ;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.ach.getDrawable() == null || this.act)) {
            i = 0;
        }
        this.ach.setVisibility(i);
        gy();
        if (z2) {
            z3 = false;
        }
        Y(z3);
        gx();
    }

    private boolean gw() {
        return (this.acw || this.acz) && !this.acu;
    }

    private void W(boolean z) {
        int i = 8;
        if (this.acw && gw() && hasFocus() && (z || !this.acz)) {
            i = 0;
        }
        this.acd.setVisibility(i);
    }

    private void gx() {
        int i = 8;
        if (gw() && (this.acd.getVisibility() == 0 || this.acf.getVisibility() == 0)) {
            i = 0;
        }
        this.acb.setVisibility(i);
    }

    private void gy() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.abY.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.act || this.acC)) {
            i = 0;
        }
        ImageView imageView = this.ace;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.ace.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void gz() {
        post(this.acI);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.acI);
        post(this.acJ);
        super.onDetachedFromWindow();
    }

    private void X(boolean z) {
        if (z) {
            post(this.acH);
            return;
        }
        removeCallbacks(this.acH);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private boolean b(int i, KeyEvent keyEvent) {
        if (this.acE == null || this.acv == null || keyEvent.getAction() != 0 || !g.a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return bq(this.abY.getListSelection());
        }
        if (i != 21 && i != 22) {
            return (i == 19 && this.abY.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.abY.length();
            }
            this.abY.setSelection(i2);
            this.abY.setListSelection(0);
            this.abY.clearListSelection();
            acG.a(this.abY);
            return true;
        }
    }

    private void gA() {
        CharSequence text = this.acx != null ? this.acx : (!abX || this.acE == null || this.acE.getHintId() == 0) ? this.acn : getContext().getText(this.acE.getHintId());
        SearchAutoComplete searchAutoComplete = this.abY;
        if (text == null) {
            text = "";
        }
        if (this.act && this.aci != null) {
            int textSize = (int) (((double) this.abY.getTextSize()) * 1.25d);
            this.aci.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.aci), 1, 2, 33);
            spannableStringBuilder.append(text);
            Object obj = spannableStringBuilder;
        }
        searchAutoComplete.setHint(text);
    }

    private void Y(boolean z) {
        int i;
        if (this.acz && !this.acu && z) {
            i = 0;
            this.acd.setVisibility(8);
        } else {
            i = 8;
        }
        this.acf.setVisibility(i);
    }

    private void gB() {
        V(false);
        this.abY.requestFocus();
        X(true);
        if (this.acs != null) {
            this.acs.onClick(this);
        }
    }

    final void gC() {
        V(this.acu);
        gz();
        if (this.abY.hasFocus()) {
            gD();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        gz();
    }

    public final void onActionViewCollapsed() {
        CharSequence charSequence = "";
        this.abY.setText(charSequence);
        this.abY.setSelection(this.abY.length());
        this.acB = charSequence;
        clearFocus();
        V(true);
        this.abY.setImeOptions(this.acD);
        this.acC = false;
    }

    public final void onActionViewExpanded() {
        if (!this.acC) {
            this.acC = true;
            this.acD = this.abY.getImeOptions();
            this.abY.setImeOptions(this.acD | 33554432);
            this.abY.setText("");
            gB();
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.acU = this.acu;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            V(savedState.acU);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean bq(int i) {
        if (this.acr != null && this.acr.gG()) {
            return false;
        }
        Cursor cursor = this.acv.Bo;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent a = a(cursor, 0, null);
            if (a != null) {
                try {
                    getContext().startActivity(a);
                } catch (RuntimeException e) {
                    new StringBuilder("Failed launch activity: ").append(a);
                }
            }
        }
        X(false);
        this.abY.dismissDropDown();
        return true;
    }

    final void h(CharSequence charSequence) {
        this.abY.setText(charSequence);
        this.abY.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, 0, null));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.acB);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.acF != null) {
            intent.putExtra("app_data", this.acF);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (abX) {
            intent.setComponent(this.acE.getSearchActivity());
        }
        return intent;
    }

    private Intent a(Cursor cursor, int i, String str) {
        try {
            String a = ak.a(cursor, "suggest_intent_action");
            if (a == null && VERSION.SDK_INT >= 8) {
                a = this.acE.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = ak.a(cursor, "suggest_intent_data");
            if (abX && a2 == null) {
                a2 = this.acE.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = ak.a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return a(a, a2 == null ? null : Uri.parse(a2), ak.a(cursor, "suggest_intent_extra_data"), ak.a(cursor, "suggest_intent_query"), 0, null);
        } catch (RuntimeException e) {
            int position;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            new StringBuilder("Search suggestions cursor at row ").append(position).append(" returned exception.");
            return null;
        }
    }

    private void gD() {
        a aVar = acG;
        SearchAutoComplete searchAutoComplete = this.abY;
        if (aVar.acQ != null) {
            try {
                aVar.acQ.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e) {
            }
        }
        aVar = acG;
        searchAutoComplete = this.abY;
        if (aVar.acR != null) {
            try {
                aVar.acR.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e2) {
            }
        }
    }

    static boolean o(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
