package com.tencent.mm.ui.widget.celltextview.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.ui.widget.celltextview.c.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {

    public interface a extends b<b> {
        void Ct(int i);

        void Cu(int i);

        void Cv(int i);

        void Cw(int i);

        void Cx(int i);

        void U(String str, int i, int i2);

        void a(com.tencent.mm.ui.widget.celltextview.c.b bVar);

        void a(ArrayList<e> arrayList, CharSequence charSequence);

        void aB(LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> linkedList);

        List<com.tencent.mm.ui.widget.celltextview.c.b> caV();

        String caW();

        int getMaxLines();

        int getMeasuredHeight();

        int getMeasuredWidth();

        int getPaddingBottom();

        int getPaddingLeft();

        int getPaddingRight();

        int getPaddingTop();

        Paint getPaint();

        String getText();

        float getTextSize();

        void onDraw(Canvas canvas);

        void requestLayout();

        void setBackgroundDrawable(Drawable drawable);

        void setMaxWidth(int i);

        void setMinHeight(int i);

        void setMinWidth(int i);

        void setPadding(int i, int i2, int i3, int i4);

        void setTextColor(int i);

        void setTextSize(float f);
    }

    public interface b extends c<a> {
        View getView();
    }
}
