package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class e extends BaseAdapter implements a, Filterable {
    protected boolean Bm;
    protected boolean Bn;
    public Cursor Bo;
    protected int Bp;
    protected a Bq;
    protected DataSetObserver Br;
    protected f Bs;
    protected FilterQueryProvider Bt;
    public Context mContext;

    private class a extends ContentObserver {
        final /* synthetic */ e Bu;

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            this.Bu.onContentChanged();
        }
    }

    public abstract void a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public final Cursor getCursor() {
        return this.Bo;
    }

    public int getCount() {
        if (!this.Bm || this.Bo == null) {
            return 0;
        }
        return this.Bo.getCount();
    }

    public Object getItem(int i) {
        if (!this.Bm || this.Bo == null) {
            return null;
        }
        this.Bo.moveToPosition(i);
        return this.Bo;
    }

    public long getItemId(int i) {
        if (this.Bm && this.Bo != null && this.Bo.moveToPosition(i)) {
            return this.Bo.getLong(this.Bp);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.Bm) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.Bo.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.Bo, viewGroup);
            }
            a(view, this.Bo);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.Bm) {
            return null;
        }
        this.Bo.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.Bo, viewGroup);
        }
        a(view, this.Bo);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.Bo) {
            cursor2 = null;
        } else {
            cursor2 = this.Bo;
            if (cursor2 != null) {
                if (this.Bq != null) {
                    cursor2.unregisterContentObserver(this.Bq);
                }
                if (this.Br != null) {
                    cursor2.unregisterDataSetObserver(this.Br);
                }
            }
            this.Bo = cursor;
            if (cursor != null) {
                if (this.Bq != null) {
                    cursor.registerContentObserver(this.Bq);
                }
                if (this.Br != null) {
                    cursor.registerDataSetObserver(this.Br);
                }
                this.Bp = cursor.getColumnIndexOrThrow("_id");
                this.Bm = true;
                notifyDataSetChanged();
            } else {
                this.Bp = -1;
                this.Bm = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.Bt != null) {
            return this.Bt.runQuery(charSequence);
        }
        return this.Bo;
    }

    public Filter getFilter() {
        if (this.Bs == null) {
            this.Bs = new f(this);
        }
        return this.Bs;
    }

    protected final void onContentChanged() {
        if (this.Bn && this.Bo != null && !this.Bo.isClosed()) {
            this.Bm = this.Bo.requery();
        }
    }
}
