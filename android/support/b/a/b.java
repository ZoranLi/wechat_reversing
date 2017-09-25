package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public final class b extends e implements Animatable {
    private a lW;
    private ArgbEvaluator lX;
    private final Callback lY;
    private Context mContext;

    private static class a extends ConstantState {
        int ma;
        f mb;
        ArrayList<Animator> mc;
        android.support.v4.e.a<Animator, String> md;

        public a(a aVar, Callback callback, Resources resources) {
        }

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final int getChangingConfigurations() {
            return this.ma;
        }
    }

    private static class b extends ConstantState {
        private final ConstantState me;

        public b(ConstantState constantState) {
            this.me = constantState;
        }

        public final Drawable newDrawable() {
            Drawable bVar = new b();
            bVar.mj = this.me.newDrawable();
            bVar.mj.setCallback(bVar.lY);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable bVar = new b();
            bVar.mj = this.me.newDrawable(resources);
            bVar.mj.setCallback(bVar.lY);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable bVar = new b();
            bVar.mj = this.me.newDrawable(resources, theme);
            bVar.mj.setCallback(bVar.lY);
            return bVar;
        }

        public final boolean canApplyTheme() {
            return this.me.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.me.getChangingConfigurations();
        }
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private b() {
        this(null, (byte) 0);
    }

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        this.lX = null;
        this.lY = new Callback(this) {
            final /* synthetic */ b lZ;

            {
                this.lZ = r1;
            }

            public final void invalidateDrawable(Drawable drawable) {
                this.lZ.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                this.lZ.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                this.lZ.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.lW = new a(null, this.lY, null);
    }

    public final Drawable mutate() {
        if (this.mj != null) {
            this.mj.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public final ConstantState getConstantState() {
        if (this.mj != null) {
            return new b(this.mj.getConstantState());
        }
        return null;
    }

    public final int getChangingConfigurations() {
        if (this.mj != null) {
            return this.mj.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.lW.ma;
    }

    public final void draw(Canvas canvas) {
        if (this.mj != null) {
            this.mj.draw(canvas);
            return;
        }
        this.lW.mb.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.mj != null) {
            this.mj.setBounds(rect);
        } else {
            this.lW.mb.setBounds(rect);
        }
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.mj != null) {
            return this.mj.setState(iArr);
        }
        return this.lW.mb.setState(iArr);
    }

    protected final boolean onLevelChange(int i) {
        if (this.mj != null) {
            return this.mj.setLevel(i);
        }
        return this.lW.mb.setLevel(i);
    }

    public final int getAlpha() {
        if (this.mj != null) {
            return android.support.v4.b.a.a.d(this.mj);
        }
        return this.lW.mb.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.mj != null) {
            this.mj.setAlpha(i);
        } else {
            this.lW.mb.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.mj != null) {
            this.mj.setColorFilter(colorFilter);
        } else {
            this.lW.mb.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, i);
        } else {
            this.lW.mb.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, colorStateList);
        } else {
            this.lW.mb.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, mode);
        } else {
            this.lW.mb.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.mj != null) {
            return this.mj.setVisible(z, z2);
        }
        this.lW.mb.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.mj != null) {
            return this.mj.isStateful();
        }
        return this.lW.mb.isStateful();
    }

    public final int getOpacity() {
        if (this.mj != null) {
            return this.mj.getOpacity();
        }
        return this.lW.mb.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.mj != null) {
            return this.mj.getIntrinsicWidth();
        }
        return this.lW.mb.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.mj != null) {
            return this.mj.getIntrinsicHeight();
        }
        return this.lW.mb.getIntrinsicHeight();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray obtainAttributes;
                if ("animated-vector".equals(name)) {
                    int[] iArr = a.lU;
                    obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f a = f.a(resources, resourceId, theme);
                        a.mp = false;
                        a.setCallback(this.lY);
                        if (this.lW.mb != null) {
                            this.lW.mb.setCallback(null);
                        }
                        this.lW.mb = a;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.lV);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.mContext, resourceId2);
                            loadAnimator.setTarget(this.lW.mb.ml.nj.ni.get(string));
                            if (VERSION.SDK_INT < 21) {
                                b(loadAnimator);
                            }
                            if (this.lW.mc == null) {
                                this.lW.mc = new ArrayList();
                                this.lW.md = new android.support.v4.e.a();
                            }
                            this.lW.mc.add(loadAnimator);
                            this.lW.md.put(loadAnimator, string);
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.mj != null) {
            return android.support.v4.b.a.a.e(this.mj);
        }
        return false;
    }

    private void b(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    b((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.lX == null) {
                    this.lX = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.lX);
            }
        }
    }

    public final boolean isRunning() {
        if (this.mj != null) {
            return ((AnimatedVectorDrawable) this.mj).isRunning();
        }
        ArrayList arrayList = this.lW.mc;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStarted() {
        ArrayList arrayList = this.lW.mc;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        if (this.mj != null) {
            ((AnimatedVectorDrawable) this.mj).start();
        } else if (!isStarted()) {
            ArrayList arrayList = this.lW.mc;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.mj != null) {
            ((AnimatedVectorDrawable) this.mj).stop();
            return;
        }
        ArrayList arrayList = this.lW.mc;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
