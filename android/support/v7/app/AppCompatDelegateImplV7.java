package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.u;
import android.support.v4.view.ae;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.ap;
import android.support.v4.view.k;
import android.support.v4.view.z;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.at;
import android.support.v7.widget.h;
import android.support.v7.widget.t;
import android.support.v7.widget.x;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

class AppCompatDelegateImplV7 extends e implements k, android.support.v7.view.menu.f.a {
    private TextView Fy;
    t GM;
    private a GN;
    private d GO;
    android.support.v7.view.b GP;
    ActionBarContextView GQ;
    PopupWindow GR;
    Runnable GS;
    ai GT = null;
    private boolean GU;
    ViewGroup GV;
    private View GW;
    private boolean GX;
    private boolean GY;
    private boolean GZ;
    private PanelFeatureState[] Ha;
    private PanelFeatureState Hb;
    private boolean Hc;
    public boolean Hd;
    public int He;
    private final Runnable Hf = new Runnable(this) {
        final /* synthetic */ AppCompatDelegateImplV7 Hi;

        {
            this.Hi = r1;
        }

        public final void run() {
            if ((this.Hi.He & 1) != 0) {
                this.Hi.av(0);
            }
            if ((this.Hi.He & Downloads.RECV_BUFFER_SIZE) != 0) {
                this.Hi.av(108);
            }
            this.Hi.Hd = false;
            this.Hi.He = 0;
        }
    };
    private boolean Hg;
    private j Hh;
    private Rect hd;
    private Rect he;

    private static final class PanelFeatureState {
        boolean DR;
        int Hm;
        ViewGroup Hn;
        View Ho;
        View Hp;
        f Hq;
        e Hr;
        Context Hs;
        boolean Ht;
        boolean Hu;
        public boolean Hv;
        boolean Hw = false;
        boolean Hx;
        Bundle Hy;
        int background;
        int gravity;
        int windowAnimations;
        int x;
        int y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            boolean DR;
            int Hm;
            Bundle iR;

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.Hm);
                parcel.writeInt(this.DR ? 1 : 0);
                if (this.DR) {
                    parcel.writeBundle(this.iR);
                }
            }

            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.Hm = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.DR = z;
                if (savedState.DR) {
                    savedState.iR = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }

        PanelFeatureState(int i) {
            this.Hm = i;
        }

        final void e(f fVar) {
            if (fVar != this.Hq) {
                if (this.Hq != null) {
                    this.Hq.b(this.Hr);
                }
                this.Hq = fVar;
                if (fVar != null && this.Hr != null) {
                    fVar.a(this.Hr);
                }
            }
        }
    }

    private final class a implements android.support.v7.view.menu.l.a {
        final /* synthetic */ AppCompatDelegateImplV7 Hi;

        public a(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.Hi = appCompatDelegateImplV7;
        }

        public final boolean d(f fVar) {
            Callback callback = this.Hi.Fe.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, fVar);
            }
            return true;
        }

        public final void a(f fVar, boolean z) {
            this.Hi.c(fVar);
        }
    }

    class b implements android.support.v7.view.b.a {
        final /* synthetic */ AppCompatDelegateImplV7 Hi;
        private android.support.v7.view.b.a Hk;

        public b(AppCompatDelegateImplV7 appCompatDelegateImplV7, android.support.v7.view.b.a aVar) {
            this.Hi = appCompatDelegateImplV7;
            this.Hk = aVar;
        }

        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.Hk.a(bVar, menu);
        }

        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.Hk.b(bVar, menu);
        }

        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.Hk.a(bVar, menuItem);
        }

        public final void a(android.support.v7.view.b bVar) {
            this.Hk.a(bVar);
            if (this.Hi.GR != null) {
                this.Hi.Fe.getDecorView().removeCallbacks(this.Hi.GS);
            }
            if (this.Hi.GQ != null) {
                this.Hi.cX();
                this.Hi.GT = z.V(this.Hi.GQ).p(0.0f);
                this.Hi.GT.a(new an(this) {
                    final /* synthetic */ b Hl;

                    {
                        this.Hl = r1;
                    }

                    public final void q(View view) {
                        this.Hl.Hi.GQ.setVisibility(8);
                        if (this.Hl.Hi.GR != null) {
                            this.Hl.Hi.GR.dismiss();
                        } else if (this.Hl.Hi.GQ.getParent() instanceof View) {
                            z.Z((View) this.Hl.Hi.GQ.getParent());
                        }
                        this.Hl.Hi.GQ.removeAllViews();
                        this.Hl.Hi.GT.a(null);
                        this.Hl.Hi.GT = null;
                    }
                });
            }
            this.Hi.GP = null;
        }
    }

    private class c extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImplV7 Hi;

        public c(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
            this.Hi = appCompatDelegateImplV7;
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.Hi.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                x = (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) ? true : 0;
                if (x != 0) {
                    AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.Hi;
                    appCompatDelegateImplV7.a(appCompatDelegateImplV7.au(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(h.ey().a(getContext(), i, false));
        }
    }

    private final class d implements android.support.v7.view.menu.l.a {
        final /* synthetic */ AppCompatDelegateImplV7 Hi;

        public d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.Hi = appCompatDelegateImplV7;
        }

        public final void a(f fVar, boolean z) {
            Menu dC = fVar.dC();
            boolean z2 = dC != fVar;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.Hi;
            if (z2) {
                fVar = dC;
            }
            PanelFeatureState a = appCompatDelegateImplV7.a(fVar);
            if (a == null) {
                return;
            }
            if (z2) {
                this.Hi.a(a.Hm, a, dC);
                this.Hi.a(a, true);
                return;
            }
            this.Hi.a(a, z);
        }

        public final boolean d(f fVar) {
            if (fVar == null && this.Hi.Gy) {
                Callback callback = this.Hi.Fe.getCallback();
                if (!(callback == null || this.Hi.GD)) {
                    callback.onMenuOpened(108, fVar);
                }
            }
            return true;
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.Gu instanceof Activity) && u.b((Activity) this.Gu) != null) {
            ActionBar actionBar = this.Gx;
            if (actionBar == null) {
                this.Hg = true;
            } else {
                actionBar.w(true);
            }
        }
    }

    public final void cQ() {
        cW();
    }

    public final void cU() {
        cW();
        if (this.Gy && this.Gx == null) {
            if (this.Gu instanceof Activity) {
                this.Gx = new n((Activity) this.Gu, this.Gz);
            } else if (this.Gu instanceof Dialog) {
                this.Gx = new n((Dialog) this.Gu);
            }
            if (this.Gx != null) {
                this.Gx.w(this.Hg);
            }
        }
    }

    public final View findViewById(int i) {
        cW();
        return this.Fe.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.Gy && this.GU) {
            ActionBar cP = cP();
            if (cP != null) {
                cP.onConfigurationChanged(configuration);
            }
        }
        cS();
    }

    public final void onStop() {
        ActionBar cP = cP();
        if (cP != null) {
            cP.x(false);
        }
    }

    public final void onPostResume() {
        ActionBar cP = cP();
        if (cP != null) {
            cP.x(true);
        }
    }

    public final void setContentView(View view) {
        cW();
        ViewGroup viewGroup = (ViewGroup) this.GV.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.Gu.onContentChanged();
    }

    public final void setContentView(int i) {
        cW();
        ViewGroup viewGroup = (ViewGroup) this.GV.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.Gu.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        cW();
        ViewGroup viewGroup = (ViewGroup) this.GV.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.Gu.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        cW();
        ((ViewGroup) this.GV.findViewById(16908290)).addView(view, layoutParams);
        this.Gu.onContentChanged();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.Gx != null) {
            this.Gx.onDestroy();
        }
    }

    private void cW() {
        if (!this.GU) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.bl);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.k.LJ)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.LS, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.LJ, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.LK, false)) {
                    requestWindowFeature(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.LL, false)) {
                    requestWindowFeature(10);
                }
                this.GB = obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.LH, false);
                obtainStyledAttributes.recycle();
                this.Fe.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                if (this.GC) {
                    view = this.GA ? (ViewGroup) from.inflate(android.support.v7.a.a.h.KN, null) : (ViewGroup) from.inflate(android.support.v7.a.a.h.KM, null);
                    if (VERSION.SDK_INT >= 21) {
                        z.b(view, new android.support.v4.view.t(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Hi;

                            {
                                this.Hi = r1;
                            }

                            public final ap a(View view, ap apVar) {
                                int systemWindowInsetTop = apVar.getSystemWindowInsetTop();
                                int aw = this.Hi.aw(systemWindowInsetTop);
                                if (systemWindowInsetTop != aw) {
                                    apVar = apVar.d(apVar.getSystemWindowInsetLeft(), aw, apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
                                }
                                return z.a(view, apVar);
                            }
                        });
                        view2 = view;
                    } else {
                        ((x) view).a(new android.support.v7.widget.x.a(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Hi;

                            {
                                this.Hi = r1;
                            }

                            public final void d(Rect rect) {
                                rect.top = this.Hi.aw(rect.top);
                            }
                        });
                        view2 = view;
                    }
                } else if (this.GB) {
                    r0 = (ViewGroup) from.inflate(android.support.v7.a.a.h.KF, null);
                    this.Gz = false;
                    this.Gy = false;
                    view2 = r0;
                } else if (this.Gy) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.mContext, typedValue.resourceId) : this.mContext).inflate(android.support.v7.a.a.h.KO, null);
                    this.GM = (t) r0.findViewById(android.support.v7.a.a.f.JZ);
                    this.GM.b(this.Fe.getCallback());
                    if (this.Gz) {
                        this.GM.aA(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                    }
                    if (this.GX) {
                        this.GM.aA(2);
                    }
                    if (this.GY) {
                        this.GM.aA(5);
                    }
                    view2 = r0;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Gy + ", windowActionBarOverlay: " + this.Gz + ", android:windowIsFloating: " + this.GB + ", windowActionModeOverlay: " + this.GA + ", windowNoTitle: " + this.GC + " }");
                }
                if (this.GM == null) {
                    this.Fy = (TextView) view2.findViewById(android.support.v7.a.a.f.title);
                }
                at.bx(view2);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(android.support.v7.a.a.f.JM);
                ViewGroup viewGroup = (ViewGroup) this.Fe.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.Fe.setContentView(view2);
                contentFrameLayout.VX = new android.support.v7.widget.ContentFrameLayout.a(this) {
                    final /* synthetic */ AppCompatDelegateImplV7 Hi;

                    {
                        this.Hi = r1;
                    }

                    public final void onDetachedFromWindow() {
                        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.Hi;
                        if (appCompatDelegateImplV7.GM != null) {
                            appCompatDelegateImplV7.GM.dW();
                        }
                        if (appCompatDelegateImplV7.GR != null) {
                            appCompatDelegateImplV7.Fe.getDecorView().removeCallbacks(appCompatDelegateImplV7.GS);
                            if (appCompatDelegateImplV7.GR.isShowing()) {
                                try {
                                    appCompatDelegateImplV7.GR.dismiss();
                                } catch (IllegalArgumentException e) {
                                }
                            }
                            appCompatDelegateImplV7.GR = null;
                        }
                        appCompatDelegateImplV7.cX();
                        PanelFeatureState au = appCompatDelegateImplV7.au(0);
                        if (au != null && au.Hq != null) {
                            au.Hq.close();
                        }
                    }
                };
                this.GV = view2;
                CharSequence title = this.Gu instanceof Activity ? ((Activity) this.Gu).getTitle() : this.uI;
                if (!TextUtils.isEmpty(title)) {
                    f(title);
                }
                contentFrameLayout = (ContentFrameLayout) this.GV.findViewById(16908290);
                view = this.Fe.getDecorView();
                contentFrameLayout.VW.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (z.aj(contentFrameLayout)) {
                    contentFrameLayout.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.bl);
                int i = android.support.v7.a.a.k.LQ;
                if (contentFrameLayout.VQ == null) {
                    contentFrameLayout.VQ = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout.VQ);
                i = android.support.v7.a.a.k.LR;
                if (contentFrameLayout.VR == null) {
                    contentFrameLayout.VR = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout.VR);
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.LO)) {
                    i = android.support.v7.a.a.k.LO;
                    if (contentFrameLayout.VS == null) {
                        contentFrameLayout.VS = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.VS);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.LP)) {
                    i = android.support.v7.a.a.k.LP;
                    if (contentFrameLayout.VT == null) {
                        contentFrameLayout.VT = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.VT);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.LM)) {
                    i = android.support.v7.a.a.k.LM;
                    if (contentFrameLayout.VU == null) {
                        contentFrameLayout.VU = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.VU);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.LN)) {
                    i = android.support.v7.a.a.k.LN;
                    if (contentFrameLayout.VV == null) {
                        contentFrameLayout.VV = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.VV);
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout.requestLayout();
                this.GU = true;
                PanelFeatureState au = au(0);
                if (!this.GD) {
                    if (au == null || au.Hq == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
        }
        if (this.GC && i == 108) {
            return false;
        }
        if (this.Gy && i == 1) {
            this.Gy = false;
        }
        switch (i) {
            case 1:
                cY();
                this.GC = true;
                return true;
            case 2:
                cY();
                this.GX = true;
                return true;
            case 5:
                cY();
                this.GY = true;
                return true;
            case 10:
                cY();
                this.GA = true;
                return true;
            case 108:
                cY();
                this.Gy = true;
                return true;
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                cY();
                this.Gz = true;
                return true;
            default:
                return this.Fe.requestFeature(i);
        }
    }

    final void f(CharSequence charSequence) {
        if (this.GM != null) {
            this.GM.e(charSequence);
        } else if (this.Gx != null) {
            this.Gx.e(charSequence);
        } else if (this.Fy != null) {
            this.Fy.setText(charSequence);
        }
    }

    final void ar(int i) {
        if (i == 108) {
            ActionBar cP = cP();
            if (cP != null) {
                cP.y(false);
            }
        } else if (i == 0) {
            PanelFeatureState au = au(i);
            if (au.DR) {
                a(au, false);
            }
        }
    }

    final boolean as(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar cP = cP();
        if (cP == null) {
            return true;
        }
        cP.y(true);
        return true;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        Callback callback = this.Fe.getCallback();
        if (!(callback == null || this.GD)) {
            PanelFeatureState a = a(fVar.dC());
            if (a != null) {
                return callback.onMenuItemSelected(a.Hm, menuItem);
            }
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.GM == null || !this.GM.dT() || (ae.b(ViewConfiguration.get(this.mContext)) && !this.GM.dU())) {
            PanelFeatureState au = au(0);
            au.Hw = true;
            a(au, false);
            a(au, null);
            return;
        }
        Callback callback = this.Fe.getCallback();
        if (this.GM.isOverflowMenuShowing()) {
            this.GM.hideOverflowMenu();
            if (!this.GD) {
                callback.onPanelClosed(108, au(0).Hq);
            }
        } else if (callback != null && !this.GD) {
            if (this.Hd && (this.He & 1) != 0) {
                this.Fe.getDecorView().removeCallbacks(this.Hf);
                this.Hf.run();
            }
            PanelFeatureState au2 = au(0);
            if (au2.Hq != null && !au2.Hx && callback.onPreparePanel(0, au2.Hp, au2.Hq)) {
                callback.onMenuOpened(108, au2.Hq);
                this.GM.showOverflowMenu();
            }
        }
    }

    public final void invalidateOptionsMenu() {
        ActionBar cP = cP();
        if (cP == null || !cP.cM()) {
            invalidatePanelMenu(0);
        }
    }

    public final void cX() {
        if (this.GT != null) {
            this.GT.cancel();
        }
    }

    final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar cP = cP();
        if (cP != null && cP.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.Hb == null || !a(this.Hb, keyEvent.getKeyCode(), keyEvent)) {
            if (this.Hb == null) {
                PanelFeatureState au = au(0);
                b(au, keyEvent);
                boolean a = a(au, keyEvent.getKeyCode(), keyEvent);
                au.Ht = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.Hb == null) {
            return true;
        } else {
            this.Hb.Hu = true;
            return true;
        }
    }

    final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.Gu.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.Hc = (keyEvent.getFlags() & FileUtils.S_IWUSR) != 0;
                    break;
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState au = au(0);
                    if (au.DR) {
                        return true;
                    }
                    b(au, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                onKeyShortcut(keyCode, keyEvent);
            }
            return false;
        }
        PanelFeatureState au2;
        switch (keyCode) {
            case 4:
                z = this.Hc;
                this.Hc = false;
                au2 = au(0);
                if (au2 == null || !au2.DR) {
                    if (this.GP != null) {
                        this.GP.finish();
                        z = true;
                    } else {
                        ActionBar cP = cP();
                        z = cP != null && cP.collapseActionView();
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(au2, true);
                    return true;
                }
                break;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                if (this.GP != null) {
                    return true;
                }
                au2 = au(0);
                if (this.GM == null || !this.GM.dT() || ae.b(ViewConfiguration.get(this.mContext))) {
                    if (au2.DR || au2.Hu) {
                        z = au2.DR;
                        a(au2, true);
                    } else {
                        if (au2.Ht) {
                            if (au2.Hx) {
                                au2.Ht = false;
                                z = b(au2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(au2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.GM.isOverflowMenuShowing()) {
                    z = this.GM.hideOverflowMenu();
                } else {
                    if (!this.GD && b(au2, keyEvent)) {
                        z = this.GM.showOverflowMenu();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
        }
        return false;
    }

    public final void cR() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            android.support.v4.view.h.a(from, this);
        } else {
            android.support.v4.view.h.a(from);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
        r7 = this;
        r3 = 1;
        r4 = 0;
        r0 = r7.a(r9, r10, r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0059;
    L_0x000f:
        r2 = r3;
    L_0x0010:
        r0 = r7.Hh;
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new android.support.v7.app.j;
        r0.<init>();
        r7.Hh = r0;
    L_0x001b:
        if (r2 == 0) goto L_0x007c;
    L_0x001d:
        r0 = r8;
        r0 = (android.view.ViewParent) r0;
        if (r0 != 0) goto L_0x005b;
    L_0x0022:
        r0 = r4;
    L_0x0023:
        if (r0 == 0) goto L_0x007c;
    L_0x0025:
        r0 = r3;
    L_0x0026:
        r5 = r7.Hh;
        r1 = android.support.v7.widget.ar.hd();
        if (r0 == 0) goto L_0x0176;
    L_0x002e:
        if (r8 == 0) goto L_0x0176;
    L_0x0030:
        r0 = r8.getContext();
    L_0x0034:
        r0 = android.support.v7.app.j.a(r0, r11, r2, r3);
        if (r1 == 0) goto L_0x003e;
    L_0x003a:
        r0 = android.support.v7.widget.am.p(r0);
    L_0x003e:
        r1 = 0;
        r2 = -1;
        r6 = r9.hashCode();
        switch(r6) {
            case -1946472170: goto L_0x00fe;
            case -1455429095: goto L_0x00d7;
            case -1346021293: goto L_0x00f1;
            case -938935918: goto L_0x007e;
            case -937446323: goto L_0x00b4;
            case -658531749: goto L_0x010b;
            case -339785223: goto L_0x00a9;
            case 776382189: goto L_0x00cb;
            case 1125864064: goto L_0x0088;
            case 1413872058: goto L_0x00e4;
            case 1601505219: goto L_0x00bf;
            case 1666676343: goto L_0x009e;
            case 2001146706: goto L_0x0093;
            default: goto L_0x0047;
        };
    L_0x0047:
        r4 = r2;
    L_0x0048:
        switch(r4) {
            case 0: goto L_0x0118;
            case 1: goto L_0x011f;
            case 2: goto L_0x0126;
            case 3: goto L_0x012d;
            case 4: goto L_0x0134;
            case 5: goto L_0x013b;
            case 6: goto L_0x0142;
            case 7: goto L_0x0149;
            case 8: goto L_0x0150;
            case 9: goto L_0x0157;
            case 10: goto L_0x015e;
            case 11: goto L_0x0165;
            case 12: goto L_0x016c;
            default: goto L_0x004b;
        };
    L_0x004b:
        if (r1 != 0) goto L_0x0173;
    L_0x004d:
        if (r10 == r0) goto L_0x0173;
    L_0x004f:
        r0 = r5.a(r0, r9, r11);
    L_0x0053:
        if (r0 == 0) goto L_0x0008;
    L_0x0055:
        android.support.v7.app.j.a(r0, r11);
        goto L_0x0008;
    L_0x0059:
        r2 = r4;
        goto L_0x0010;
    L_0x005b:
        r1 = r7.Fe;
        r5 = r1.getDecorView();
        r1 = r0;
    L_0x0062:
        if (r1 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r3;
        goto L_0x0023;
    L_0x0066:
        if (r1 == r5) goto L_0x0075;
    L_0x0068:
        r0 = r1 instanceof android.view.View;
        if (r0 == 0) goto L_0x0075;
    L_0x006c:
        r0 = r1;
        r0 = (android.view.View) r0;
        r0 = android.support.v4.view.z.al(r0);
        if (r0 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r4;
        goto L_0x0023;
    L_0x0077:
        r1 = r1.getParent();
        goto L_0x0062;
    L_0x007c:
        r0 = r4;
        goto L_0x0026;
    L_0x007e:
        r3 = "TextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0087:
        goto L_0x0048;
    L_0x0088:
        r4 = "ImageView";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x0047;
    L_0x0091:
        r4 = r3;
        goto L_0x0048;
    L_0x0093:
        r3 = "Button";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x009c:
        r4 = 2;
        goto L_0x0048;
    L_0x009e:
        r3 = "EditText";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00a7:
        r4 = 3;
        goto L_0x0048;
    L_0x00a9:
        r3 = "Spinner";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00b2:
        r4 = 4;
        goto L_0x0048;
    L_0x00b4:
        r3 = "ImageButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00bd:
        r4 = 5;
        goto L_0x0048;
    L_0x00bf:
        r3 = "CheckBox";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00c8:
        r4 = 6;
        goto L_0x0048;
    L_0x00cb:
        r3 = "RadioButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00d4:
        r4 = 7;
        goto L_0x0048;
    L_0x00d7:
        r3 = "CheckedTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00e0:
        r4 = 8;
        goto L_0x0048;
    L_0x00e4:
        r3 = "AutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00ed:
        r4 = 9;
        goto L_0x0048;
    L_0x00f1:
        r3 = "MultiAutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00fa:
        r4 = 10;
        goto L_0x0048;
    L_0x00fe:
        r3 = "RatingBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0107:
        r4 = 11;
        goto L_0x0048;
    L_0x010b:
        r3 = "SeekBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0114:
        r4 = 12;
        goto L_0x0048;
    L_0x0118:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x011f:
        r1 = new android.support.v7.widget.AppCompatImageView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0126:
        r1 = new android.support.v7.widget.AppCompatButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x012d:
        r1 = new android.support.v7.widget.AppCompatEditText;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0134:
        r1 = new android.support.v7.widget.AppCompatSpinner;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x013b:
        r1 = new android.support.v7.widget.AppCompatImageButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0142:
        r1 = new android.support.v7.widget.AppCompatCheckBox;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0149:
        r1 = new android.support.v7.widget.AppCompatRadioButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0150:
        r1 = new android.support.v7.widget.AppCompatCheckedTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0157:
        r1 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x015e:
        r1 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0165:
        r1 = new android.support.v7.widget.AppCompatRatingBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x016c:
        r1 = new android.support.v7.widget.AppCompatSeekBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0173:
        r0 = r1;
        goto L_0x0053;
    L_0x0176:
        r0 = r10;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.Gu instanceof Factory) {
            View onCreateView = ((Factory) this.Gu).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r2 = -2;
        r3 = 0;
        r9 = 1;
        r0 = r11.DR;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r10.GD;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.Hm;
        if (r0 != 0) goto L_0x0032;
    L_0x0011:
        r4 = r10.mContext;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0022:
        r0 = r9;
    L_0x0023:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002d:
        r4 = r9;
    L_0x002e:
        if (r0 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x000c;
    L_0x0032:
        r0 = r10.Fe;
        r0 = r0.getCallback();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.Hm;
        r5 = r11.Hq;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000c;
    L_0x0048:
        r0 = r3;
        goto L_0x0023;
    L_0x004a:
        r4 = r3;
        goto L_0x002e;
    L_0x004c:
        r0 = r10.mContext;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000c;
    L_0x005a:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000c;
    L_0x0060:
        r0 = r11.Hn;
        if (r0 == 0) goto L_0x0068;
    L_0x0064:
        r0 = r11.Hw;
        if (r0 == 0) goto L_0x01e4;
    L_0x0068:
        r0 = r11.Hn;
        if (r0 != 0) goto L_0x0153;
    L_0x006c:
        r0 = r10.cV();
        r1 = new android.util.TypedValue;
        r1.<init>();
        r4 = r0.getResources();
        r4 = r4.newTheme();
        r5 = r0.getTheme();
        r4.setTo(r5);
        r5 = android.support.v7.a.a.a.actionBarPopupTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x0092;
    L_0x008d:
        r5 = r1.resourceId;
        r4.applyStyle(r5, r9);
    L_0x0092:
        r5 = android.support.v7.a.a.a.II;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x014c;
    L_0x009b:
        r1 = r1.resourceId;
        r4.applyStyle(r1, r9);
    L_0x00a0:
        r1 = new android.support.v7.view.d;
        r1.<init>(r0, r3);
        r0 = r1.getTheme();
        r0.setTo(r4);
        r11.Hs = r1;
        r0 = android.support.v7.a.a.k.bl;
        r0 = r1.obtainStyledAttributes(r0);
        r1 = android.support.v7.a.a.k.LI;
        r1 = r0.getResourceId(r1, r3);
        r11.background = r1;
        r1 = android.support.v7.a.a.k.LG;
        r1 = r0.getResourceId(r1, r3);
        r11.windowAnimations = r1;
        r0.recycle();
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$c;
        r1 = r11.Hs;
        r0.<init>(r10, r1);
        r11.Hn = r0;
        r0 = 81;
        r11.gravity = r0;
        r0 = r11.Hn;
        if (r0 == 0) goto L_0x000c;
    L_0x00d8:
        r0 = r11.Hp;
        if (r0 == 0) goto L_0x0166;
    L_0x00dc:
        r0 = r11.Hp;
        r11.Ho = r0;
        r0 = r9;
    L_0x00e1:
        if (r0 == 0) goto L_0x000c;
    L_0x00e3:
        r0 = r11.Ho;
        if (r0 == 0) goto L_0x01e1;
    L_0x00e7:
        r0 = r11.Hp;
        if (r0 == 0) goto L_0x01d2;
    L_0x00eb:
        r0 = r9;
    L_0x00ec:
        if (r0 == 0) goto L_0x000c;
    L_0x00ee:
        r0 = r11.Ho;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x01f7;
    L_0x00f6:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x00fc:
        r0 = r11.background;
        r4 = r11.Hn;
        r4.setBackgroundResource(r0);
        r0 = r11.Ho;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x0116;
    L_0x010b:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x0116;
    L_0x010f:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.Ho;
        r0.removeView(r4);
    L_0x0116:
        r0 = r11.Hn;
        r4 = r11.Ho;
        r0.addView(r4, r1);
        r0 = r11.Ho;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x012a;
    L_0x0125:
        r0 = r11.Ho;
        r0.requestFocus();
    L_0x012a:
        r1 = r2;
    L_0x012b:
        r11.Hu = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.x;
        r4 = r11.y;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.gravity;
        r0.gravity = r1;
        r1 = r11.windowAnimations;
        r0.windowAnimations = r1;
        r1 = r11.Hn;
        r8.addView(r1, r0);
        r11.DR = r9;
        goto L_0x000c;
    L_0x014c:
        r1 = android.support.v7.a.a.j.KV;
        r4.applyStyle(r1, r9);
        goto L_0x00a0;
    L_0x0153:
        r0 = r11.Hw;
        if (r0 == 0) goto L_0x00d8;
    L_0x0157:
        r0 = r11.Hn;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x00d8;
    L_0x015f:
        r0 = r11.Hn;
        r0.removeAllViews();
        goto L_0x00d8;
    L_0x0166:
        r0 = r11.Hq;
        if (r0 == 0) goto L_0x01cf;
    L_0x016a:
        r0 = r10.GO;
        if (r0 != 0) goto L_0x0175;
    L_0x016e:
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$d;
        r0.<init>(r10);
        r10.GO = r0;
    L_0x0175:
        r0 = r10.GO;
        r1 = r11.Hq;
        if (r1 != 0) goto L_0x0187;
    L_0x017b:
        r0 = 0;
    L_0x017c:
        r0 = (android.view.View) r0;
        r11.Ho = r0;
        r0 = r11.Ho;
        if (r0 == 0) goto L_0x01cf;
    L_0x0184:
        r0 = r9;
        goto L_0x00e1;
    L_0x0187:
        r1 = r11.Hr;
        if (r1 != 0) goto L_0x01a1;
    L_0x018b:
        r1 = new android.support.v7.view.menu.e;
        r4 = r11.Hs;
        r5 = android.support.v7.a.a.h.KJ;
        r1.<init>(r4, r5);
        r11.Hr = r1;
        r1 = r11.Hr;
        r1.dV = r0;
        r0 = r11.Hq;
        r1 = r11.Hr;
        r0.a(r1);
    L_0x01a1:
        r1 = r11.Hr;
        r0 = r11.Hn;
        r4 = r1.Qi;
        if (r4 != 0) goto L_0x01cc;
    L_0x01a9:
        r4 = r1.Du;
        r5 = android.support.v7.a.a.h.KG;
        r0 = r4.inflate(r5, r0, r3);
        r0 = (android.support.v7.view.menu.ExpandedMenuView) r0;
        r1.Qi = r0;
        r0 = r1.Ql;
        if (r0 != 0) goto L_0x01c0;
    L_0x01b9:
        r0 = new android.support.v7.view.menu.e$a;
        r0.<init>(r1);
        r1.Ql = r0;
    L_0x01c0:
        r0 = r1.Qi;
        r4 = r1.Ql;
        r0.setAdapter(r4);
        r0 = r1.Qi;
        r0.setOnItemClickListener(r1);
    L_0x01cc:
        r0 = r1.Qi;
        goto L_0x017c;
    L_0x01cf:
        r0 = r3;
        goto L_0x00e1;
    L_0x01d2:
        r0 = r11.Hr;
        r0 = r0.getAdapter();
        r0 = r0.getCount();
        if (r0 <= 0) goto L_0x01e1;
    L_0x01de:
        r0 = r9;
        goto L_0x00ec;
    L_0x01e1:
        r0 = r3;
        goto L_0x00ec;
    L_0x01e4:
        r0 = r11.Hp;
        if (r0 == 0) goto L_0x01f4;
    L_0x01e8:
        r0 = r11.Hp;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x01f4;
    L_0x01f0:
        r0 = r0.width;
        if (r0 == r1) goto L_0x012b;
    L_0x01f4:
        r1 = r2;
        goto L_0x012b;
    L_0x01f7:
        r1 = r0;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.GD) {
            return false;
        }
        if (panelFeatureState.Ht) {
            return true;
        }
        if (!(this.Hb == null || this.Hb == panelFeatureState)) {
            a(this.Hb, false);
        }
        Callback callback = this.Fe.getCallback();
        if (callback != null) {
            panelFeatureState.Hp = callback.onCreatePanelView(panelFeatureState.Hm);
        }
        boolean z = panelFeatureState.Hm == 0 || panelFeatureState.Hm == 108;
        if (z && this.GM != null) {
            this.GM.dV();
        }
        if (panelFeatureState.Hp == null && !(z && (this.Gx instanceof k))) {
            if (panelFeatureState.Hq == null || panelFeatureState.Hx) {
                if (panelFeatureState.Hq == null) {
                    Context dVar;
                    f fVar;
                    Context context = this.mContext;
                    if ((panelFeatureState.Hm == 0 || panelFeatureState.Hm == 108) && this.GM != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            dVar = new android.support.v7.view.d(context, 0);
                            dVar.getTheme().setTo(theme2);
                            fVar = new f(dVar);
                            fVar.a((android.support.v7.view.menu.f.a) this);
                            panelFeatureState.e(fVar);
                            if (panelFeatureState.Hq == null) {
                                return false;
                            }
                        }
                    }
                    dVar = context;
                    fVar = new f(dVar);
                    fVar.a((android.support.v7.view.menu.f.a) this);
                    panelFeatureState.e(fVar);
                    if (panelFeatureState.Hq == null) {
                        return false;
                    }
                }
                if (z && this.GM != null) {
                    if (this.GN == null) {
                        this.GN = new a(this);
                    }
                    this.GM.a(panelFeatureState.Hq, this.GN);
                }
                panelFeatureState.Hq.dv();
                if (callback.onCreatePanelMenu(panelFeatureState.Hm, panelFeatureState.Hq)) {
                    panelFeatureState.Hx = false;
                } else {
                    panelFeatureState.e(null);
                    if (!z || this.GM == null) {
                        return false;
                    }
                    this.GM.a(null, this.GN);
                    return false;
                }
            }
            panelFeatureState.Hq.dv();
            if (panelFeatureState.Hy != null) {
                panelFeatureState.Hq.f(panelFeatureState.Hy);
                panelFeatureState.Hy = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.Hp, panelFeatureState.Hq)) {
                boolean z2;
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.Hv = z2;
                panelFeatureState.Hq.setQwertyMode(panelFeatureState.Hv);
                panelFeatureState.Hq.dw();
            } else {
                if (z && this.GM != null) {
                    this.GM.a(null, this.GN);
                }
                panelFeatureState.Hq.dw();
                return false;
            }
        }
        panelFeatureState.Ht = true;
        panelFeatureState.Hu = false;
        this.Hb = panelFeatureState;
        return true;
    }

    public final void c(f fVar) {
        if (!this.GZ) {
            this.GZ = true;
            this.GM.dW();
            Callback callback = this.Fe.getCallback();
            if (!(callback == null || this.GD)) {
                callback.onPanelClosed(108, fVar);
            }
            this.GZ = false;
        }
    }

    public final void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Hm == 0 && this.GM != null && this.GM.isOverflowMenuShowing()) {
            c(panelFeatureState.Hq);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.DR || panelFeatureState.Hn == null)) {
            windowManager.removeView(panelFeatureState.Hn);
            if (z) {
                a(panelFeatureState.Hm, panelFeatureState, null);
            }
        }
        panelFeatureState.Ht = false;
        panelFeatureState.Hu = false;
        panelFeatureState.DR = false;
        panelFeatureState.Ho = null;
        panelFeatureState.Hw = true;
        if (this.Hb == panelFeatureState) {
            this.Hb = null;
        }
    }

    public final void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.Ha.length) {
                panelFeatureState = this.Ha[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.Hq;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.DR) && !this.GD) {
            this.Gu.onPanelClosed(i, menu);
        }
    }

    public final PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Ha;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.Hq == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    final PanelFeatureState au(int i) {
        Object obj = this.Ha;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.Ha = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.Ht || b(panelFeatureState, keyEvent)) && panelFeatureState.Hq != null) {
            return panelFeatureState.Hq.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.He |= 1 << i;
        if (!this.Hd) {
            z.a(this.Fe.getDecorView(), this.Hf);
            this.Hd = true;
        }
    }

    public final void av(int i) {
        PanelFeatureState au = au(i);
        if (au.Hq != null) {
            Bundle bundle = new Bundle();
            au.Hq.e(bundle);
            if (bundle.size() > 0) {
                au.Hy = bundle;
            }
            au.Hq.dv();
            au.Hq.clear();
        }
        au.Hx = true;
        au.Hw = true;
        if ((i == 108 || i == 0) && this.GM != null) {
            au = au(0);
            if (au != null) {
                au.Ht = false;
                b(au, null);
            }
        }
    }

    public final int aw(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.GQ == null || !(this.GQ.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.GQ.getLayoutParams();
            if (this.GQ.isShown()) {
                if (this.hd == null) {
                    this.hd = new Rect();
                    this.he = new Rect();
                }
                Rect rect = this.hd;
                Rect rect2 = this.he;
                rect.set(0, i, 0, 0);
                at.a(this.GV, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.GW == null) {
                        this.GW = new View(this.mContext);
                        this.GW.setBackgroundColor(this.mContext.getResources().getColor(android.support.v7.a.a.c.IP));
                        this.GV.addView(this.GW, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.GW.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.GW.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.GW == null) {
                    i3 = 0;
                }
                if (!(this.GA || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.GQ.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.GW != null) {
            View view = this.GW;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void cY() {
        if (this.GU) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}
