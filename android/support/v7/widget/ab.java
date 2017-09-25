package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class ab {
    protected final h YQ;
    int YR = Integer.MIN_VALUE;

    static class AnonymousClass1 extends ab {
        AnonymousClass1(h hVar) {
            super(hVar);
        }

        public final int fk() {
            return this.YQ.aar - this.YQ.getPaddingRight();
        }

        public final int getEnd() {
            return this.YQ.aar;
        }

        public final void ba(int i) {
            this.YQ.bg(i);
        }

        public final int fj() {
            return this.YQ.getPaddingLeft();
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bg(view) + layoutParams.leftMargin);
        }

        public final int aY(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bh(view) + layoutParams.topMargin);
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + h.bk(view);
        }

        public final int aV(View view) {
            return h.bi(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public final int fl() {
            return (this.YQ.aar - this.YQ.getPaddingLeft()) - this.YQ.getPaddingRight();
        }

        public final int getEndPadding() {
            return this.YQ.getPaddingRight();
        }

        public final int getMode() {
            return this.YQ.aap;
        }

        public final int fm() {
            return this.YQ.aaq;
        }
    }

    static class AnonymousClass2 extends ab {
        AnonymousClass2(h hVar) {
            super(hVar);
        }

        public final int fk() {
            return this.YQ.RQ - this.YQ.getPaddingBottom();
        }

        public final int getEnd() {
            return this.YQ.RQ;
        }

        public final void ba(int i) {
            this.YQ.bh(i);
        }

        public final int fj() {
            return this.YQ.getPaddingTop();
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bh(view) + layoutParams.topMargin);
        }

        public final int aY(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bg(view) + layoutParams.leftMargin);
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + h.bl(view);
        }

        public final int aV(View view) {
            return h.bj(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
        }

        public final int fl() {
            return (this.YQ.RQ - this.YQ.getPaddingTop()) - this.YQ.getPaddingBottom();
        }

        public final int getEndPadding() {
            return this.YQ.getPaddingBottom();
        }

        public final int getMode() {
            return this.YQ.aaq;
        }

        public final int fm() {
            return this.YQ.aap;
        }
    }

    public abstract int aV(View view);

    public abstract int aW(View view);

    public abstract int aX(View view);

    public abstract int aY(View view);

    public abstract void ba(int i);

    public abstract int fj();

    public abstract int fk();

    public abstract int fl();

    public abstract int fm();

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    public ab(h hVar) {
        this.YQ = hVar;
    }

    public final int fi() {
        return Integer.MIN_VALUE == this.YR ? 0 : fl() - this.YR;
    }
}
