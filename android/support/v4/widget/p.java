package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class p extends e {
    private int Ds;
    private int Dt;
    private LayoutInflater Du;

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.Du.inflate(this.Ds, viewGroup, false);
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.Du.inflate(this.Dt, viewGroup, false);
    }
}
