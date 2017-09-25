package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class u {
    private final DataSetObservable xo = new DataSetObservable();
    private DataSetObserver xp;

    public abstract boolean a(View view, Object obj);

    public abstract int getCount();

    public Object b(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void d(Object obj) {
    }

    public void ba() {
    }

    public Parcelable bb() {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int j(Object obj) {
        return -1;
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            if (this.xp != null) {
                this.xp.onChanged();
            }
        }
        this.xo.notifyChanged();
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.xo.registerObserver(dataSetObserver);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.xo.unregisterObserver(dataSetObserver);
    }

    final void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.xp = dataSetObserver;
        }
    }

    public CharSequence bK() {
        return null;
    }
}
