package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<a> jT = new ArrayList();
    private Context mContext;
    private int pl;
    private l qR;
    private OnTabChangeListener qY;
    private a qZ;
    private boolean ra;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String rb;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.rb = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.rb);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.rb + "}";
        }
    }

    static final class a {
        public Fragment ov;
        public final Class<?> rc;
        public final Bundle rd;
        public final String tag;
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.pl = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.qY = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        p pVar = null;
        for (int i = 0; i < this.jT.size(); i++) {
            a aVar = (a) this.jT.get(i);
            aVar.ov = this.qR.k(aVar.tag);
            if (!(aVar.ov == null || aVar.ov.pn)) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.qZ = aVar;
                } else {
                    if (pVar == null) {
                        pVar = this.qR.aV();
                    }
                    pVar.b(aVar.ov);
                }
            }
        }
        this.ra = true;
        p a = a(currentTabTag, pVar);
        if (a != null) {
            a.commit();
            this.qR.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ra = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.rb = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.rb);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.ra) {
            p a = a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.qY != null) {
            this.qY.onTabChanged(str);
        }
    }

    private p a(String str, p pVar) {
        a aVar = null;
        int i = 0;
        while (i < this.jT.size()) {
            a aVar2 = (a) this.jT.get(i);
            if (!aVar2.tag.equals(str)) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.qZ != aVar) {
            if (pVar == null) {
                pVar = this.qR.aV();
            }
            if (!(this.qZ == null || this.qZ.ov == null)) {
                pVar.b(this.qZ.ov);
            }
            if (aVar != null) {
                if (aVar.ov == null) {
                    aVar.ov = Fragment.a(this.mContext, aVar.rc.getName(), aVar.rd);
                    pVar.a(this.pl, aVar.ov, aVar.tag);
                } else {
                    pVar.c(aVar.ov);
                }
            }
            this.qZ = aVar;
        }
        return pVar;
    }
}
