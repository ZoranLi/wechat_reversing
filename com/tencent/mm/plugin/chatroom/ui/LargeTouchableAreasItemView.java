package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int kur = Color.argb(0, 0, 0, 0);
    private final Paint fu = new Paint();
    private final ArrayList<b> kus = new ArrayList();
    private c kut;
    a kuu;
    private int kuv;
    private boolean kuw;
    private int kux = -1;
    private int kuy = -1;
    private ImageButton kuz;

    public interface a {
        void dk(boolean z);
    }

    private static class b {
        public int color;
        public Rect rect;

        public b(Rect rect, int i) {
            this.rect = rect;
            this.color = i;
        }
    }

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.kut = new c(this);
        this.fu.setStyle(Style.FILL);
        this.kuv = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.i.cYP, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.kuz = (ImageButton) findViewById(R.h.bvc);
        this.kuz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LargeTouchableAreasItemView kuA;

            {
                this.kuA = r1;
            }

            public final void onClick(View view) {
                this.kuA.dj(!this.kuA.kuw);
                if (this.kuA.kuu != null) {
                    this.kuA.kuu.dk(this.kuA.kuw);
                }
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != this.kux || i6 != this.kuy) {
            this.kux = i5;
            this.kuy = i6;
            c cVar = this.kut;
            if (cVar.kyr != null) {
                cVar.kyr.clear();
            }
            cVar.kys = null;
            Rect rect = new Rect((i5 - this.kuz.getWidth()) - this.kuv, 0, i5, i6);
            i5 = kur;
            View view = this.kuz;
            c cVar2 = this.kut;
            TouchDelegate touchDelegate = new TouchDelegate(rect, view);
            if (cVar2.kyr == null) {
                cVar2.kyr = new ArrayList();
            }
            cVar2.kyr.add(touchDelegate);
            this.kus.add(new b(rect, i5));
            setTouchDelegate(this.kut);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Iterator it = this.kus.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.fu.setColor(bVar.color);
            canvas.drawRect(bVar.rect, this.fu);
        }
        super.dispatchDraw(canvas);
    }

    public final void dj(boolean z) {
        if (this.kuw != z) {
            this.kuw = z;
            this.kuz.setImageResource(this.kuw ? R.k.dvN : R.k.dvO);
        }
    }
}
