package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

final class f extends Filter {
    a Bv;

    interface a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    f(a aVar) {
        this.Bv = aVar;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.Bv.convertToString((Cursor) obj);
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.Bv.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.Bv.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.Bv.changeCursor((Cursor) filterResults.values);
        }
    }
}
