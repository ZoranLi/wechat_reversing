package com.tencent.mm.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.DragSortListView.h;
import com.tencent.smtt.sdk.WebView;

public class i implements h {
    private ListView Fg;
    private ImageView kZz;
    private Bitmap wxx;
    int wxy = WebView.NIGHT_MODE_COLOR;

    public i(ListView listView) {
        this.Fg = listView;
    }

    public final View Cp(int i) {
        View childAt = this.Fg.getChildAt((this.Fg.getHeaderViewsCount() + i) - this.Fg.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.wxx = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.kZz == null) {
            this.kZz = new ImageView(this.Fg.getContext());
        }
        this.kZz.setBackgroundColor(this.wxy);
        this.kZz.setPadding(0, 0, 0, 0);
        this.kZz.setImageBitmap(this.wxx);
        this.kZz.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.kZz;
    }

    public void e(Point point) {
    }

    public final void dD(View view) {
        ((ImageView) view).setImageDrawable(null);
        w.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.wxx.toString());
        this.wxx.recycle();
        this.wxx = null;
    }
}
