package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import java.util.ArrayList;
import java.util.List;

public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = a.class.getSimpleName();
    private a vgr;

    public static abstract class a extends BaseExpandableListAdapter {
        private SparseArray<d> vgs = new SparseArray();
        private AnimatedExpandableListView vgt;

        public abstract View a(int i, int i2, View view);

        public abstract int ua(int i);

        static /* synthetic */ void a(a aVar, int i) {
            d zJ = aVar.zJ(i);
            zJ.miy = true;
            zJ.vgE = 0;
            zJ.vgD = true;
        }

        static /* synthetic */ void a(a aVar, int i, int i2) {
            d zJ = aVar.zJ(i);
            zJ.miy = true;
            zJ.vgE = i2;
            zJ.vgD = false;
        }

        final d zJ(int i) {
            d dVar = (d) this.vgs.get(i);
            if (dVar != null) {
                return dVar;
            }
            dVar = new d();
            this.vgs.put(i, dVar);
            return dVar;
        }

        public final int getChildType(int i, int i2) {
            if (zJ(i).miy) {
                return 0;
            }
            return 1;
        }

        public final int getChildTypeCount() {
            return 2;
        }

        public final View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            d zJ = zJ(i);
            if (!zJ.miy) {
                return a(i, i2, view);
            }
            View view2;
            if (view instanceof b) {
                view2 = view;
            } else {
                view2 = new b(viewGroup.getContext());
                view2.setLayoutParams(new LayoutParams(-1, 0));
            }
            if (i2 < zJ.vgE) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            int i3;
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final b bVar = (b) view2;
            bVar.vgy.clear();
            Drawable divider = expandableListView.getDivider();
            int measuredWidth = viewGroup.getMeasuredWidth();
            int dividerHeight = expandableListView.getDividerHeight();
            if (divider != null) {
                bVar.uXa = divider;
                bVar.vgz = measuredWidth;
                bVar.dividerHeight = dividerHeight;
                divider.setBounds(0, 0, measuredWidth, dividerHeight);
            }
            measuredWidth = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            dividerHeight = 0;
            int height = viewGroup.getHeight();
            int ua = ua(i);
            for (i3 = zJ.vgE; i3 < ua; i3++) {
                View a = a(i, i3, null);
                a.measure(measuredWidth, makeMeasureSpec);
                dividerHeight += a.getMeasuredHeight();
                if (dividerHeight >= height) {
                    bVar.db(a);
                    dividerHeight += ((ua - i3) - 1) * (dividerHeight / (i3 + 1));
                    break;
                }
                bVar.db(a);
            }
            Object tag = bVar.getTag();
            if (tag == null) {
                i3 = 0;
            } else {
                i3 = ((Integer) tag).intValue();
            }
            Animation cVar;
            if (zJ.vgD && r2 != 1) {
                cVar = new c(bVar, 0, dividerHeight, zJ);
                ck.CTRL_INDEX;
                cVar.setDuration(150);
                cVar.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a vgv;

                    public final void onAnimationEnd(Animation animation) {
                        this.vgv.zJ(i).miy = false;
                        this.vgv.notifyDataSetChanged();
                        bVar.setTag(Integer.valueOf(0));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(1));
                return view2;
            } else if (zJ.vgD || r2 == 2) {
                return view2;
            } else {
                if (zJ.vgF == -1) {
                    zJ.vgF = dividerHeight;
                }
                cVar = new c(bVar, zJ.vgF, 0, zJ);
                ck.CTRL_INDEX;
                cVar.setDuration(150);
                ua = i;
                final d dVar = zJ;
                final b bVar2 = bVar;
                cVar.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a vgv;

                    public final void onAnimationEnd(Animation animation) {
                        this.vgv.zJ(ua).miy = false;
                        expandableListView.collapseGroup(ua);
                        this.vgv.notifyDataSetChanged();
                        dVar.vgF = -1;
                        bVar2.setTag(Integer.valueOf(0));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(2));
                return view2;
            }
        }

        public final int getChildrenCount(int i) {
            d zJ = zJ(i);
            if (zJ.miy) {
                return zJ.vgE + 1;
            }
            return ua(i);
        }
    }

    private static class b extends View {
        int dividerHeight;
        Drawable uXa;
        List<View> vgy = new ArrayList();
        int vgz;

        public b(Context context) {
            super(context);
        }

        public final void db(View view) {
            view.layout(0, 0, getWidth(), getHeight());
            this.vgy.add(view);
        }

        protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int size = this.vgy.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.vgy.get(i5)).layout(i, i2, i3, i4);
            }
        }

        public final void dispatchDraw(Canvas canvas) {
            canvas.save();
            if (this.uXa != null) {
                this.uXa.setBounds(0, 0, this.vgz, this.dividerHeight);
            }
            int size = this.vgy.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.vgy.get(i);
                view.draw(canvas);
                canvas.translate(0.0f, (float) view.getMeasuredHeight());
                if (this.uXa != null) {
                    this.uXa.draw(canvas);
                    canvas.translate(0.0f, (float) this.dividerHeight);
                }
            }
            canvas.restore();
        }
    }

    private static class c extends Animation {
        private int vgA;
        private int vgB;
        private d vgC;
        private View view;

        private c(View view, int i, int i2, d dVar) {
            this.vgA = i;
            this.vgB = i2 - i;
            this.view = view;
            this.vgC = dVar;
            this.view.getLayoutParams().height = i;
            this.view.requestLayout();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            if (f < 1.0f) {
                int i = this.vgA + ((int) (((float) this.vgB) * f));
                this.view.getLayoutParams().height = i;
                this.vgC.vgF = i;
                this.view.requestLayout();
                return;
            }
            i = this.vgA + this.vgB;
            this.view.getLayoutParams().height = i;
            this.vgC.vgF = i;
            this.view.requestLayout();
        }
    }

    private static class d {
        boolean miy = false;
        boolean vgD = false;
        int vgE;
        int vgF = -1;
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof a) {
            this.vgr = (a) expandableListAdapter;
            this.vgr.vgt = this;
            return;
        }
        throw new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
    }

    @SuppressLint({"NewApi"})
    public final boolean zH(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < getChildCount() && getChildAt(flatListPosition).getBottom() >= getBottom()) {
                this.vgr.zJ(i).vgF = -1;
                return expandGroup(i);
            }
        }
        a.a(this.vgr, i);
        return expandGroup(i);
    }

    public final boolean zI(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < 0 || flatListPosition >= getChildCount()) {
                return collapseGroup(i);
            }
            if (getChildAt(flatListPosition).getBottom() >= getBottom()) {
                return collapseGroup(i);
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        flatListPosition = getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = getPackedPositionGroup(expandableListPosition);
        if (flatListPosition == -1 || packedPositionGroup != i) {
            flatListPosition = 0;
        }
        a.a(this.vgr, i, flatListPosition);
        this.vgr.notifyDataSetChanged();
        return isGroupExpanded(i);
    }
}
