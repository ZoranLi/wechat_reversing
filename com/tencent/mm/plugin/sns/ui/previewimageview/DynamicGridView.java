package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView extends WrappingGridView {
    private int fl = -1;
    private List<Long> idList = new ArrayList();
    boolean llp = false;
    private BitmapDrawable qOA;
    private Rect qOB;
    private Rect qOC;
    private Rect qOD;
    private int qOE = 0;
    private int qOF = 0;
    private int qOG = -1;
    private int qOH = -1;
    private int qOI = -1;
    private int qOJ = -1;
    private int qOK;
    private long qOL = -1;
    private boolean qOM = false;
    private boolean qON;
    private int qOO = 0;
    private boolean qOP = false;
    private List<ObjectAnimator> qOQ = new LinkedList();
    boolean qOR;
    boolean qOS;
    boolean qOT = true;
    private boolean qOU = true;
    private OnScrollListener qOV;
    f qOW;
    e qOX;
    private OnItemClickListener qOY;
    private OnItemClickListener qOZ = new OnItemClickListener(this) {
        final /* synthetic */ DynamicGridView qPl;

        {
            this.qPl = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!this.qPl.llp && this.qPl.isEnabled() && this.qPl.qOY != null) {
                this.qPl.qOY.onItemClick(adapterView, view, i, j);
            }
        }
    };
    private boolean qPa;
    private Stack<a> qPb;
    private a qPc;
    private View qPd;
    d qPe = new d();
    int qPf = -1;
    float qPg;
    float qPh;
    private float qPi;
    private float qPj;
    private OnScrollListener qPk = new OnScrollListener(this) {
        private int kuc;
        final /* synthetic */ DynamicGridView qPl;
        private int qPm = -1;
        private int qPn = -1;
        private int qPo;
        private int qPp;

        {
            this.qPl = r2;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.qPo = i;
            this.qPp = i2;
            this.qPm = this.qPm == -1 ? this.qPo : this.qPm;
            this.qPn = this.qPn == -1 ? this.qPp : this.qPn;
            if (!(this.qPo == this.qPm || !this.qPl.qOM || this.qPl.qOL == -1)) {
                this.qPl.dN(this.qPl.qOL);
                this.qPl.blG();
            }
            if (!(this.qPo + this.qPp == this.qPm + this.qPn || !this.qPl.qOM || this.qPl.qOL == -1)) {
                this.qPl.dN(this.qPl.qOL);
                this.qPl.blG();
            }
            this.qPm = this.qPo;
            this.qPn = this.qPp;
            if (DynamicGridView.blD() && this.qPl.qOT) {
                for (int i4 = 0; i4 < i2; i4++) {
                    View childAt = this.qPl.getChildAt(i4);
                    if (childAt != null) {
                        if (this.qPl.qOL != -1 && Boolean.TRUE != childAt.getTag(com.tencent.mm.plugin.sns.i.f.pCq)) {
                            if (i4 % 2 == 0) {
                                this.qPl.cG(childAt);
                            } else {
                                this.qPl.cH(childAt);
                            }
                            childAt.setTag(com.tencent.mm.plugin.sns.i.f.pCq, Boolean.valueOf(true));
                        } else if (this.qPl.qOL == -1 && childAt.getRotation() != 0.0f) {
                            childAt.setRotation(0.0f);
                            childAt.setTag(com.tencent.mm.plugin.sns.i.f.pCq, Boolean.valueOf(false));
                        }
                    }
                }
            }
            if (this.qPl.qOV != null) {
                this.qPl.qOV.onScroll(absListView, i, i2, i3);
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            this.kuc = i;
            this.qPl.xV = i;
            if (this.qPp > 0 && this.kuc == 0) {
                if (this.qPl.qOM && this.qPl.qON) {
                    this.qPl.blB();
                } else if (this.qPl.qOP) {
                    this.qPl.blC();
                }
            }
            if (this.qPl.qOV != null) {
                this.qPl.qOV.onScrollStateChanged(absListView, i);
            }
        }
    };
    private int xV = 0;

    private static class a {
        List<Pair<Integer, Integer>> qPr = new Stack();

        a() {
        }

        public final void dg(int i, int i2) {
            this.qPr.add(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    private class d extends Handler {
        final /* synthetic */ DynamicGridView qPl;

        private d(DynamicGridView dynamicGridView) {
            this.qPl = dynamicGridView;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    DynamicGridView dynamicGridView = this.qPl;
                    View childAt = dynamicGridView.getChildAt(dynamicGridView.qPf);
                    new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.qPf).append(",lastTouchX ").append(dynamicGridView.qPg).append(",lastTouchY ").append(dynamicGridView.qPh);
                    if (!dynamicGridView.qOR && !dynamicGridView.qOS && f.c(childAt, dynamicGridView.qPg, dynamicGridView.qPh)) {
                        dynamicGridView.un(dynamicGridView.qPf);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public interface e {
        void blx();

        void l(Rect rect);

        boolean m(Rect rect);

        void ul(int i);

        void um(int i);
    }

    public interface f {
        void bly();
    }

    private interface h {
        void dh(int i, int i2);
    }

    private class b implements h {
        static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
        public int AS;
        public int AT;
        final /* synthetic */ DynamicGridView qPl;

        private class a implements OnPreDrawListener {
            private final int aaG;
            private final View qPs;
            private final int qPt;
            final /* synthetic */ b qPu;

            a(b bVar, View view, int i, int i2) {
                this.qPu = bVar;
                this.qPs = view;
                this.qPt = i;
                this.aaG = i2;
            }

            public final boolean onPreDraw() {
                this.qPu.qPl.getViewTreeObserver().removeOnPreDrawListener(this);
                this.qPu.qPl.qOE = this.qPu.qPl.qOE + this.qPu.AT;
                this.qPu.qPl.qOF = this.qPu.qPl.qOF + this.qPu.AS;
                DynamicGridView.a(this.qPu.qPl, this.qPt, this.aaG);
                this.qPs.setVisibility(0);
                if (this.qPu.qPl.qPd != null) {
                    this.qPu.qPl.qPd.setVisibility(4);
                }
                return true;
            }
        }

        public b(DynamicGridView dynamicGridView, int i, int i2) {
            this.qPl = dynamicGridView;
            this.AS = i;
            this.AT = i2;
        }

        public final void dh(int i, int i2) {
            if ($assertionsDisabled || this.qPl.qPd != null) {
                this.qPl.getViewTreeObserver().addOnPreDrawListener(new a(this, this.qPl.qPd, i, i2));
                this.qPl.qPd = this.qPl.dP(this.qPl.qOL);
                return;
            }
            throw new AssertionError();
        }
    }

    private class c implements h {
        public int AS;
        public int AT;
        final /* synthetic */ DynamicGridView qPl;

        private class a implements OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int aaG;
            private final int qPt;
            final /* synthetic */ c qPv;

            a(c cVar, int i, int i2) {
                this.qPv = cVar;
                this.qPt = i;
                this.aaG = i2;
            }

            public final boolean onPreDraw() {
                this.qPv.qPl.getViewTreeObserver().removeOnPreDrawListener(this);
                this.qPv.qPl.qOE = this.qPv.qPl.qOE + this.qPv.AT;
                this.qPv.qPl.qOF = this.qPv.qPl.qOF + this.qPv.AS;
                DynamicGridView.a(this.qPv.qPl, this.qPt, this.aaG);
                new StringBuilder("id ").append(this.qPv.qPl.dO(this.qPv.qPl.qOL));
                if (!(this.qPv.qPl.qPd == null || this.qPv.qPl.qPd == null)) {
                    if ($assertionsDisabled || this.qPv.qPl.qPd != null) {
                        this.qPv.qPl.qPd.setVisibility(0);
                        this.qPv.qPl.qPd = this.qPv.qPl.dP(this.qPv.qPl.qOL);
                        if (this.qPv.qPl.qPd != null) {
                            if ($assertionsDisabled || this.qPv.qPl.qPd != null) {
                                this.qPv.qPl.qPd.setVisibility(4);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                    throw new AssertionError();
                }
                return true;
            }
        }

        public c(DynamicGridView dynamicGridView, int i, int i2) {
            this.qPl = dynamicGridView;
            this.AS = i;
            this.AT = i2;
        }

        public final void dh(int i, int i2) {
            this.qPl.getViewTreeObserver().addOnPreDrawListener(new a(this, i, i2));
        }
    }

    private class g implements h {
        private int AS;
        private int AT;
        final /* synthetic */ DynamicGridView qPl;

        public g(DynamicGridView dynamicGridView, int i, int i2) {
            this.qPl = dynamicGridView;
            this.AS = i;
            this.AT = i2;
        }

        public final void dh(int i, int i2) {
            this.qPl.qOE = this.qPl.qOE + this.AT;
            this.qPl.qOF = this.qPl.qOF + this.AS;
        }
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, int i, int i2) {
        Object obj = i2 > i ? 1 : null;
        Collection linkedList = new LinkedList();
        int min;
        View dP;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                dP = dynamicGridView.dP(dynamicGridView.up(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(dP, (float) ((-dP.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) dP.getHeight()));
                } else {
                    linkedList.add(d(dP, (float) dP.getWidth(), 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                dP = dynamicGridView.dP(dynamicGridView.up(min));
                if ((dynamicGridView.getColumnCount() + min) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(dP, (float) (dP.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-dP.getHeight())));
                } else {
                    linkedList.add(d(dP, (float) (-dP.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter(dynamicGridView) {
            final /* synthetic */ DynamicGridView qPl;

            {
                this.qPl = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.qPl.qOS = true;
                DynamicGridView.b(this.qPl);
            }

            public final void onAnimationEnd(Animator animator) {
                this.qPl.qOS = false;
                DynamicGridView.b(this.qPl);
            }
        });
        animatorSet.start();
    }

    static /* synthetic */ void b(DynamicGridView dynamicGridView) {
        boolean z = (dynamicGridView.qOR || dynamicGridView.qOS) ? false : true;
        dynamicGridView.setEnabled(z);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.qOV = onScrollListener;
    }

    public final void un(int i) {
        if (this.qOU) {
            requestDisallowInterceptTouchEvent(true);
            if (blD() && this.qOT) {
                blz();
            }
            if (i != -1) {
                this.llp = uo(i);
                if (this.llp) {
                    this.qOM = true;
                }
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.qOY = onItemClickListener;
        super.setOnItemClickListener(this.qOZ);
    }

    @TargetApi(11)
    private void blz() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(com.tencent.mm.plugin.sns.i.f.pCq))) {
                if (i % 2 == 0) {
                    cG(childAt);
                } else {
                    cH(childAt);
                }
                childAt.setTag(com.tencent.mm.plugin.sns.i.f.pCq, Boolean.valueOf(true));
            }
        }
    }

    @TargetApi(11)
    final void hP(boolean z) {
        for (Animator cancel : this.qOQ) {
            cancel.cancel();
        }
        this.qOQ.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                if (z) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(com.tencent.mm.plugin.sns.i.f.pCq, Boolean.valueOf(false));
            }
        }
    }

    private void init(Context context) {
        super.setOnScrollListener(this.qPk);
        this.qOO = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.qOK = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.pzl);
    }

    @TargetApi(11)
    private void cG(View view) {
        ObjectAnimator cI = cI(view);
        cI.setFloatValues(new float[]{-2.0f, 2.0f});
        cI.start();
        this.qOQ.add(cI);
    }

    @TargetApi(11)
    private void cH(View view) {
        ObjectAnimator cI = cI(view);
        cI.setFloatValues(new float[]{2.0f, -2.0f});
        cI.start();
        this.qOQ.add(cI);
    }

    @TargetApi(11)
    private ObjectAnimator cI(final View view) {
        if (!blE()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ DynamicGridView qPl;

            public final void onAnimationEnd(Animator animator) {
                view.setLayerType(0, null);
            }
        });
        return objectAnimator;
    }

    private void df(int i, int i2) {
        ((d) getAdapter()).de(i, i2);
    }

    private int getColumnCount() {
        return ((d) getAdapter()).getColumnCount();
    }

    private void dN(long j) {
        this.idList.clear();
        int dO = dO(j);
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (dO != firstVisiblePosition && ((d) getAdapter()).uk(firstVisiblePosition)) {
                this.idList.add(Long.valueOf(up(firstVisiblePosition)));
            }
            firstVisiblePosition++;
        }
    }

    public final int dO(long j) {
        View dP = dP(j);
        if (dP == null) {
            return -1;
        }
        return getPositionForView(dP);
    }

    public final View dP(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.fl);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.qPg = motionEvent.getX();
                this.qPh = motionEvent.getY();
                this.qPf = f.a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.qPf);
                if (!this.qOR && this.qPf >= 0) {
                    d dVar = this.qPe;
                    dVar.removeMessages(1);
                    dVar.sendEmptyMessageDelayed(1, 300);
                }
                this.qOI = -1;
                this.qOJ = -1;
                this.qOG = (int) motionEvent.getX();
                this.qOH = (int) motionEvent.getY();
                this.fl = motionEvent.getPointerId(0);
                if (this.llp && isEnabled()) {
                    layoutChildren();
                    uo(pointToPosition(this.qOG, this.qOH));
                    break;
                } else if (!isEnabled()) {
                    return false;
                }
                break;
            case 1:
                blC();
                if (this.qPa && this.qPc != null) {
                    a aVar = this.qPc;
                    Collections.reverse(aVar.qPr);
                    if (!aVar.qPr.isEmpty()) {
                        this.qPb.push(this.qPc);
                        this.qPc = new a();
                        break;
                    }
                }
                break;
            case 2:
                this.qPg = motionEvent.getX();
                this.qPh = motionEvent.getY();
                if (this.qOM && this.fl != -1) {
                    if (this.qOJ == -1 && this.qOI == -1) {
                        this.qOI = (int) motionEvent.getY(findPointerIndex);
                        this.qOJ = (int) motionEvent.getX(findPointerIndex);
                        this.qOG = this.qOJ;
                        this.qOH = this.qOI;
                        break;
                    }
                    this.qPi = motionEvent.getRawX();
                    this.qPj = motionEvent.getRawY();
                    this.qOI = (int) motionEvent.getY(findPointerIndex);
                    this.qOJ = (int) motionEvent.getX(findPointerIndex);
                    int i = this.qOJ - this.qOG;
                    this.qOB.offsetTo((i + this.qOD.left) + this.qOF, ((this.qOI - this.qOH) + this.qOD.top) + this.qOE);
                    if (this.qOA != null) {
                        this.qOA.setBounds(this.qOB);
                    }
                    invalidate();
                    blG();
                    this.qON = false;
                    blB();
                    if (this.qOX == null) {
                        return false;
                    }
                    Rect rect = new Rect(this.qOB);
                    rect.offset(0, this.qOB.height() >>> 1);
                    this.qOX.l(rect);
                    return false;
                }
                break;
            case 3:
                blF();
                blC();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.fl) {
                    blC();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean blA() {
        int dO = dO(this.qOL);
        if (dO == -1) {
            return false;
        }
        this.qOX.um(dO);
        if (this.qPd == null) {
            return false;
        }
        h bVar;
        int positionForView = getPositionForView(this.qPd);
        int childCount = getChildCount() - 1;
        new StringBuilder("switch ").append(positionForView).append(",").append(childCount);
        df(positionForView, childCount);
        if (this.qPa) {
            this.qPc.dg(positionForView, childCount);
        }
        this.qOH = this.qOI;
        this.qOG = this.qOJ;
        if (blD() && blE()) {
            bVar = new b(this, 0, 0);
        } else if (blE()) {
            bVar = new g(this, 0, 0);
        } else {
            bVar = new c(this, 0, 0);
        }
        dN(this.qOL);
        bVar.dh(positionForView, childCount);
        return true;
    }

    private boolean uo(int i) {
        if (!((d) getAdapter()).uj(i)) {
            return false;
        }
        this.qOE = 0;
        this.qOF = 0;
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt == null) {
            return false;
        }
        this.qOL = getAdapter().getItemId(i);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        int top = childAt.getTop();
        int left = childAt.getLeft();
        Bitmap createBitmap = Bitmap.createBitmap(childAt.getWidth(), childAt.getHeight(), Config.ARGB_8888);
        childAt.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
        this.qOC = new Rect(left, top, left + width, top + height);
        this.qOB = new Rect(this.qOC.left - ((int) (((float) width) * 0.05f)), this.qOC.top - ((int) (((float) height) * 0.05f)), ((int) (((float) width) * 0.05f)) + this.qOC.right, ((int) (((float) height) * 0.05f)) + this.qOC.bottom);
        this.qOD = new Rect(this.qOB);
        bitmapDrawable.setBounds(this.qOC);
        this.qOA = bitmapDrawable;
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.qOA, "bounds", new TypeEvaluator<Rect>(this) {
            final /* synthetic */ DynamicGridView qPl;

            {
                this.qPl = r1;
            }

            public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                return new Rect(AnonymousClass4.c(rect.left, rect2.left, f), AnonymousClass4.c(rect.top, rect2.top, f), AnonymousClass4.c(rect.right, rect2.right, f), AnonymousClass4.c(rect.bottom, rect2.bottom, f));
            }

            private static int c(int i, int i2, float f) {
                return (int) (((float) i) + (((float) (i2 - i)) * f));
            }
        }, new Object[]{this.qOB});
        ofObject.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ DynamicGridView qPl;

            {
                this.qPl = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.qPl.invalidate();
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ DynamicGridView qPl;

            {
                this.qPl = r1;
            }

            public final void onAnimationStart(Animator animator) {
                this.qPl.qOR = true;
                DynamicGridView.b(this.qPl);
            }

            public final void onAnimationEnd(Animator animator) {
                this.qPl.qOR = false;
                DynamicGridView.b(this.qPl);
            }
        });
        ofObject.setDuration(10);
        ofObject.start();
        if (blD()) {
            childAt.setVisibility(4);
        }
        dN(this.qOL);
        if (this.qOX != null) {
            this.qOX.ul(i);
        }
        return true;
    }

    private void blB() {
        boolean z = true;
        Rect rect = this.qOB;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.qOO, 0);
        } else if (height2 + i < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            z = false;
        } else {
            smoothScrollBy(this.qOO, 0);
        }
        this.qON = z;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    private void blC() {
        this.qPe.removeMessages(1);
        final View dP = dP(this.qOL);
        Rect rect;
        if (this.qOB != null) {
            rect = new Rect(this.qOB);
            rect.offset(0, this.qOB.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.qOX != null && this.qOX.m(r0) && blA()) {
            this.qOA = null;
            blF();
            if (this.qOW != null) {
                this.qOW.bly();
            }
        } else if (dP == null || !(this.qOM || this.qOP)) {
            blF();
        } else {
            this.qOM = false;
            this.qOP = false;
            this.qON = false;
            this.fl = -1;
            this.qOB.set(dP.getLeft(), dP.getTop(), dP.getRight(), dP.getBottom());
            new StringBuilder("animating to  ").append(this.qOB);
            if (VERSION.SDK_INT > 11) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.qOA, "bounds", new TypeEvaluator<Rect>(this) {
                    final /* synthetic */ DynamicGridView qPl;

                    {
                        this.qPl = r1;
                    }

                    public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
                        Rect rect = (Rect) obj;
                        Rect rect2 = (Rect) obj2;
                        return new Rect(AnonymousClass7.c(rect.left, rect2.left, f), AnonymousClass7.c(rect.top, rect2.top, f), AnonymousClass7.c(rect.right, rect2.right, f), AnonymousClass7.c(rect.bottom, rect2.bottom, f));
                    }

                    private static int c(int i, int i2, float f) {
                        return (int) (((float) i) + (((float) (i2 - i)) * f));
                    }
                }, new Object[]{this.qOB});
                ofObject.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ DynamicGridView qPl;

                    {
                        this.qPl = r1;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.qPl.invalidate();
                    }
                });
                ofObject.addListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ DynamicGridView qPl;

                    public final void onAnimationStart(Animator animator) {
                        this.qPl.qOR = true;
                        DynamicGridView.b(this.qPl);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        this.qPl.qOR = false;
                        DynamicGridView.b(this.qPl);
                        if (!(this.qPl.qOA == null || this.qPl.qOW == null)) {
                            this.qPl.qOW.bly();
                        }
                        this.qPl.cJ(dP);
                    }
                });
                ofObject.setDuration(200);
                ofObject.start();
            } else {
                this.qOA.setBounds(this.qOB);
                invalidate();
                cJ(dP);
            }
        }
        if (this.qOX != null) {
            this.qOX.blx();
        }
    }

    private void cJ(View view) {
        this.idList.clear();
        this.qOL = -1;
        view.setVisibility(0);
        this.qOA = null;
        if (blD() && this.qOT) {
            if (this.llp) {
                hP(false);
                blz();
            } else {
                hP(true);
            }
        }
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
    }

    static boolean blD() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean blE() {
        return VERSION.SDK_INT < 21;
    }

    private void blF() {
        View dP = dP(this.qOL);
        if (dP != null) {
            if (this.qOM) {
                cJ(dP);
            }
            this.qOM = false;
            this.qON = false;
            this.fl = -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void blG() {
        /*
        r14 = this;
        r0 = r14.qOI;
        r1 = r14.qOH;
        r6 = r0 - r1;
        r0 = r14.qOJ;
        r1 = r14.qOG;
        r7 = r0 - r1;
        r0 = r14.qOC;
        r0 = r0.centerY();
        r1 = r14.qOE;
        r0 = r0 + r1;
        r8 = r0 + r6;
        r0 = r14.qOC;
        r0 = r0.centerX();
        r1 = r14.qOF;
        r0 = r0 + r1;
        r9 = r0 + r7;
        r0 = r14.qOL;
        r0 = r14.dP(r0);
        r14.qPd = r0;
        r0 = r14.qPd;
        if (r0 != 0) goto L_0x002f;
    L_0x002e:
        return;
    L_0x002f:
        r4 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r14.qPd;
        r10 = r14.cK(r0);
        r0 = r14.idList;
        r11 = r0.iterator();
    L_0x003e:
        r0 = r11.hasNext();
        if (r0 == 0) goto L_0x0166;
    L_0x0044:
        r0 = r11.next();
        r0 = (java.lang.Long) r0;
        r12 = r0.longValue();
        r5 = r14.dP(r12);
        if (r5 == 0) goto L_0x01e5;
    L_0x0054:
        r3 = r14.cK(r5);
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x0151;
    L_0x005e:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0151;
    L_0x0064:
        r0 = 1;
    L_0x0065:
        if (r0 == 0) goto L_0x0073;
    L_0x0067:
        r0 = r5.getBottom();
        if (r8 >= r0) goto L_0x0073;
    L_0x006d:
        r0 = r5.getLeft();
        if (r9 > r0) goto L_0x0124;
    L_0x0073:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x0154;
    L_0x0079:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 >= r12) goto L_0x0154;
    L_0x007f:
        r0 = 1;
    L_0x0080:
        if (r0 == 0) goto L_0x008e;
    L_0x0082:
        r0 = r5.getBottom();
        if (r8 >= r0) goto L_0x008e;
    L_0x0088:
        r0 = r5.getRight();
        if (r9 < r0) goto L_0x0124;
    L_0x008e:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x0157;
    L_0x0094:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0157;
    L_0x009a:
        r0 = 1;
    L_0x009b:
        if (r0 == 0) goto L_0x00a9;
    L_0x009d:
        r0 = r5.getTop();
        if (r8 <= r0) goto L_0x00a9;
    L_0x00a3:
        r0 = r5.getLeft();
        if (r9 > r0) goto L_0x0124;
    L_0x00a9:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x015a;
    L_0x00af:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 >= r12) goto L_0x015a;
    L_0x00b5:
        r0 = 1;
    L_0x00b6:
        if (r0 == 0) goto L_0x00c4;
    L_0x00b8:
        r0 = r5.getTop();
        if (r8 <= r0) goto L_0x00c4;
    L_0x00be:
        r0 = r5.getRight();
        if (r9 < r0) goto L_0x0124;
    L_0x00c4:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 >= r12) goto L_0x015d;
    L_0x00ca:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 != r12) goto L_0x015d;
    L_0x00d0:
        r0 = 1;
    L_0x00d1:
        if (r0 == 0) goto L_0x00dc;
    L_0x00d3:
        r0 = r5.getBottom();
        r12 = r14.qOK;
        r0 = r0 - r12;
        if (r8 < r0) goto L_0x0124;
    L_0x00dc:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 <= r12) goto L_0x0160;
    L_0x00e2:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 != r12) goto L_0x0160;
    L_0x00e8:
        r0 = 1;
    L_0x00e9:
        if (r0 == 0) goto L_0x00f4;
    L_0x00eb:
        r0 = r5.getTop();
        r12 = r14.qOK;
        r0 = r0 + r12;
        if (r8 > r0) goto L_0x0124;
    L_0x00f4:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 != r12) goto L_0x0162;
    L_0x00fa:
        r0 = r3.x;
        r12 = r10.x;
        if (r0 <= r12) goto L_0x0162;
    L_0x0100:
        r0 = 1;
    L_0x0101:
        if (r0 == 0) goto L_0x010c;
    L_0x0103:
        r0 = r5.getLeft();
        r12 = r14.qOK;
        r0 = r0 + r12;
        if (r9 > r0) goto L_0x0124;
    L_0x010c:
        r0 = r3.y;
        r12 = r10.y;
        if (r0 != r12) goto L_0x0164;
    L_0x0112:
        r0 = r3.x;
        r3 = r10.x;
        if (r0 >= r3) goto L_0x0164;
    L_0x0118:
        r0 = 1;
    L_0x0119:
        if (r0 == 0) goto L_0x01e5;
    L_0x011b:
        r0 = r5.getRight();
        r3 = r14.qOK;
        r0 = r0 - r3;
        if (r9 >= r0) goto L_0x01e5;
    L_0x0124:
        r0 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cE(r5);
        r3 = r14.qPd;
        r3 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cE(r3);
        r0 = r0 - r3;
        r3 = java.lang.Math.abs(r0);
        r0 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cF(r5);
        r12 = r14.qPd;
        r12 = com.tencent.mm.plugin.sns.ui.previewimageview.f.cF(r12);
        r0 = r0 - r12;
        r0 = java.lang.Math.abs(r0);
        r12 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r12 < 0) goto L_0x01e5;
    L_0x0146:
        r12 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r12 < 0) goto L_0x01e5;
    L_0x014a:
        r1 = r3;
        r2 = r5;
    L_0x014c:
        r4 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x003e;
    L_0x0151:
        r0 = 0;
        goto L_0x0065;
    L_0x0154:
        r0 = 0;
        goto L_0x0080;
    L_0x0157:
        r0 = 0;
        goto L_0x009b;
    L_0x015a:
        r0 = 0;
        goto L_0x00b6;
    L_0x015d:
        r0 = 0;
        goto L_0x00d1;
    L_0x0160:
        r0 = 0;
        goto L_0x00e9;
    L_0x0162:
        r0 = 0;
        goto L_0x0101;
    L_0x0164:
        r0 = 0;
        goto L_0x0119;
    L_0x0166:
        if (r4 == 0) goto L_0x002e;
    L_0x0168:
        r0 = r14.qPd;
        r1 = r14.getPositionForView(r0);
        r2 = r14.getPositionForView(r4);
        r0 = new java.lang.StringBuilder;
        r3 = "switch ";
        r0.<init>(r3);
        r0 = r0.append(r1);
        r3 = ",";
        r0 = r0.append(r3);
        r0.append(r2);
        r0 = r14.getAdapter();
        r0 = (com.tencent.mm.plugin.sns.ui.previewimageview.d) r0;
        r3 = -1;
        if (r2 == r3) goto L_0x019d;
    L_0x0191:
        r3 = r0.uk(r1);
        if (r3 == 0) goto L_0x019d;
    L_0x0197:
        r0 = r0.uk(r2);
        if (r0 != 0) goto L_0x01a4;
    L_0x019d:
        r0 = r14.qOL;
        r14.dN(r0);
        goto L_0x002e;
    L_0x01a4:
        r14.df(r1, r2);
        r0 = r14.qPa;
        if (r0 == 0) goto L_0x01b0;
    L_0x01ab:
        r0 = r14.qPc;
        r0.dg(r1, r2);
    L_0x01b0:
        r0 = r14.qOI;
        r14.qOH = r0;
        r0 = r14.qOJ;
        r14.qOG = r0;
        r0 = blD();
        if (r0 == 0) goto L_0x01d3;
    L_0x01be:
        r0 = blE();
        if (r0 == 0) goto L_0x01d3;
    L_0x01c4:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$b;
        r0.<init>(r14, r7, r6);
    L_0x01c9:
        r4 = r14.qOL;
        r14.dN(r4);
        r0.dh(r1, r2);
        goto L_0x002e;
    L_0x01d3:
        r0 = blE();
        if (r0 == 0) goto L_0x01df;
    L_0x01d9:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$g;
        r0.<init>(r14, r7, r6);
        goto L_0x01c9;
    L_0x01df:
        r0 = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView$c;
        r0.<init>(r14, r7, r6);
        goto L_0x01c9;
    L_0x01e5:
        r0 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.blG():void");
    }

    private Point cK(View view) {
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        return new Point(positionForView % columnCount, positionForView / columnCount);
    }

    private long up(int i) {
        return getAdapter().getItemId(i);
    }

    @TargetApi(11)
    private static AnimatorSet d(View view, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.qOA != null) {
            this.qOA.draw(canvas);
        }
    }
}
