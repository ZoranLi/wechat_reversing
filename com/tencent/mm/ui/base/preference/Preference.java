package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.s.a.c;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.ui.r;
import java.util.List;

public class Preference implements Comparable<Preference> {
    private boolean AK;
    public int PG;
    public String igL;
    public Drawable jQ;
    public int krt;
    public final Context mContext;
    private Bundle mExtras;
    private CharSequence owe;
    private CharSequence uI;
    private a vrS;
    private int vrT;
    private int vrU;
    private int vrV;
    private String vrW;
    boolean vrX;
    private boolean vrY;
    public boolean vrZ;
    String vsa;
    private Object vsb;
    private boolean vsc;
    private boolean vsd;
    private int vse;
    int vsf;
    private boolean vsg;
    private List<Preference> vsh;
    private int[] xQ;

    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new Creator<BaseSavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BaseSavedState[i];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public /* synthetic */ int compareTo(Object obj) {
        int i = 0;
        Preference preference = (Preference) obj;
        if (this.vrT != Integer.MAX_VALUE || (this.vrT == Integer.MAX_VALUE && preference.vrT != Integer.MAX_VALUE)) {
            return this.vrT - preference.vrT;
        }
        if (this.uI == null) {
            return 1;
        }
        if (preference.uI == null) {
            return -1;
        }
        CharSequence charSequence = this.uI;
        CharSequence charSequence2 = preference.uI;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = length < length2 ? length : length2;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char toLowerCase = Character.toLowerCase(charSequence.charAt(i3));
            i3 = i + 1;
            i = toLowerCase - Character.toLowerCase(charSequence2.charAt(i));
            if (i != 0) {
                return i;
            }
            i = i3;
            i3 = i4;
        }
        return length - length2;
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.xQ = new int[]{c.title, c.summary};
        this.vrT = Integer.MAX_VALUE;
        this.AK = true;
        this.vrX = true;
        this.vrZ = true;
        this.vsc = true;
        this.krt = -1;
        this.vsd = true;
        this.vse = h.diC;
        this.vsg = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.frx, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == m.hga) {
                this.PG = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == m.hgb) {
                this.igL = obtainStyledAttributes.getString(index);
            } else if (index == m.hgi) {
                this.vrU = obtainStyledAttributes.getResourceId(index, 0);
                this.uI = obtainStyledAttributes.getString(index);
                if (this.vrU != 0) {
                    this.uI = context.getString(this.vrU);
                }
            } else if (index == m.hgh) {
                this.owe = obtainStyledAttributes.getString(index);
                this.vrV = obtainStyledAttributes.getResourceId(index, 0);
                if (this.vrV != 0) {
                    this.owe = context.getString(this.vrV);
                }
            } else if (index == m.hgd) {
                this.vrT = obtainStyledAttributes.getInt(index, this.vrT);
            } else if (index == m.hfZ) {
                this.vrW = obtainStyledAttributes.getString(index);
            } else if (index == m.hgc) {
                this.vse = obtainStyledAttributes.getResourceId(index, this.vse);
            } else if (index == m.hgj) {
                this.vsf = obtainStyledAttributes.getResourceId(index, this.vsf);
            } else if (index == m.hfY) {
                this.AK = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.hgf) {
                this.vrX = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.hge) {
                this.vrZ = obtainStyledAttributes.getBoolean(index, this.vrZ);
            } else if (index == m.hfX) {
                this.vsa = obtainStyledAttributes.getString(index);
            } else if (index == m.hfW) {
                this.vsb = null;
            } else if (index == m.hgg) {
                this.vsd = obtainStyledAttributes.getBoolean(index, this.vsd);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.vsg = true;
        }
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public final void setLayoutResource(int i) {
        if (i != this.vse) {
            this.vsg = true;
        }
        this.vse = i;
    }

    public int getLayoutResource() {
        return this.vse;
    }

    public final void setWidgetLayoutResource(int i) {
        if (i != this.vsf) {
            this.vsg = true;
        }
        this.vsf = i;
    }

    public View getView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        return view;
    }

    public View onCreateView(ViewGroup viewGroup) {
        LayoutInflater eC = r.eC(this.mContext);
        View inflate = eC.inflate(this.vse, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.vsf != 0) {
                eC.inflate(this.vsf, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onBindView(View view) {
        int i = 0;
        View findViewById = view.findViewById(g.content);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.aXQ)) * com.tencent.mm.bg.a.dL(this.mContext)));
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
        }
        textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(getSummary());
                if (this.krt != -1) {
                    textView.setTextColor(this.krt);
                }
            } else if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.PG == 0 && this.jQ == null)) {
                if (this.jQ == null) {
                    this.jQ = this.mContext.getResources().getDrawable(this.PG);
                }
                if (this.jQ != null) {
                    imageView.setImageDrawable(this.jQ);
                }
            }
            if (this.jQ == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        if (this.vsd) {
            m(view, isEnabled());
        }
    }

    private void m(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.uI != null) || (charSequence != null && !charSequence.equals(this.uI))) {
            this.vrU = 0;
            this.uI = charSequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
        this.vrU = i;
    }

    public CharSequence getTitle() {
        return this.uI;
    }

    public CharSequence getSummary() {
        return this.owe;
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.owe != null) || (charSequence != null && !charSequence.equals(this.owe))) {
            this.owe = charSequence;
            notifyChanged();
        }
    }

    public void setSummary(int i) {
        setSummary(this.mContext.getString(i));
    }

    public final void setEnabled(boolean z) {
        if (this.AK != z) {
            this.AK = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public final boolean isEnabled() {
        return this.AK && this.vsc;
    }

    public final void setSelectable(boolean z) {
        if (this.vrX != z) {
            this.vrX = z;
            notifyChanged();
        }
    }

    public final void setKey(String str) {
        this.igL = str;
        if (this.vrY) {
            if (!(!TextUtils.isEmpty(this.igL))) {
                if (this.igL == null) {
                    throw new IllegalStateException("Preference does not have a key assigned.");
                }
                this.vrY = true;
            }
        }
    }

    public final boolean callChangeListener(Object obj) {
        return this.vrS == null ? true : this.vrS.a(this, obj);
    }

    public void a(a aVar) {
        this.vrS = aVar;
    }

    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        List list = this.vsh;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Preference preference = (Preference) list.get(i);
                if (preference.vsc == z) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    preference.vsc = z2;
                    preference.notifyDependencyChange(preference.shouldDisableDependents());
                    preference.notifyChanged();
                }
            }
        }
    }

    private boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
