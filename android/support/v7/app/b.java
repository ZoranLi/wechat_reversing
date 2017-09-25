package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.support.v7.app.a.AnonymousClass2;
import android.support.v7.app.a.AnonymousClass3;
import android.support.v7.app.a.AnonymousClass4;
import android.support.v7.app.a.AnonymousClass5;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class b extends i implements DialogInterface {
    private a Gn = new a(getContext(), this, getWindow());

    public static class a {
        public final android.support.v7.app.a.a Go;
        public int oH;

        public a(Context context) {
            this(context, b.c(context, 0));
        }

        private a(Context context, int i) {
            this.Go = new android.support.v7.app.a.a(new ContextThemeWrapper(context, b.c(context, i)));
            this.oH = i;
        }
    }

    public b(Context context, int i) {
        super(context, c(context, i));
    }

    static int c(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Gn.setTitle(charSequence);
    }

    protected final void onCreate(Bundle bundle) {
        int indexOfChild;
        super.onCreate(bundle);
        a aVar = this.Gn;
        int i = (aVar.FD == 0 || aVar.FI != 1) ? aVar.FC : aVar.FD;
        aVar.Fd.setContentView(i);
        View findViewById = aVar.Fe.findViewById(f.Kf);
        View findViewById2 = findViewById.findViewById(f.Kx);
        View findViewById3 = findViewById.findViewById(f.JX);
        View findViewById4 = findViewById.findViewById(f.JW);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.JY);
        View inflate = aVar.mView != null ? aVar.mView : aVar.Fh != 0 ? LayoutInflater.from(aVar.mContext).inflate(aVar.Fh, viewGroup, false) : null;
        Object obj = inflate != null ? 1 : null;
        if (obj == null || !a.aI(inflate)) {
            aVar.Fe.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (obj != null) {
            FrameLayout frameLayout = (FrameLayout) aVar.Fe.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (aVar.Fm) {
                frameLayout.setPadding(aVar.Fi, aVar.Fj, aVar.Fk, aVar.Fl);
            }
            if (aVar.Fg != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(f.Kx);
        inflate = viewGroup.findViewById(f.JX);
        View findViewById6 = viewGroup.findViewById(f.JW);
        ViewGroup b = a.b(findViewById5, findViewById2);
        ViewGroup b2 = a.b(inflate, findViewById3);
        ViewGroup b3 = a.b(findViewById6, findViewById4);
        aVar.Fw = (NestedScrollView) aVar.Fe.findViewById(f.Ki);
        aVar.Fw.setFocusable(false);
        aVar.Fw.setNestedScrollingEnabled(false);
        aVar.jq = (TextView) b2.findViewById(16908299);
        if (aVar.jq != null) {
            if (aVar.Ff != null) {
                aVar.jq.setText(aVar.Ff);
            } else {
                aVar.jq.setVisibility(8);
                aVar.Fw.removeView(aVar.jq);
                if (aVar.Fg != null) {
                    ViewGroup viewGroup2 = (ViewGroup) aVar.Fw.getParent();
                    indexOfChild = viewGroup2.indexOfChild(aVar.Fw);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(aVar.Fg, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    b2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        aVar.Fn = (Button) b3.findViewById(16908313);
        aVar.Fn.setOnClickListener(aVar.FJ);
        if (TextUtils.isEmpty(aVar.Fo)) {
            aVar.Fn.setVisibility(8);
        } else {
            aVar.Fn.setText(aVar.Fo);
            aVar.Fn.setVisibility(0);
            indexOfChild = 1;
        }
        aVar.Fq = (Button) b3.findViewById(16908314);
        aVar.Fq.setOnClickListener(aVar.FJ);
        if (TextUtils.isEmpty(aVar.Fr)) {
            aVar.Fq.setVisibility(8);
        } else {
            aVar.Fq.setText(aVar.Fr);
            aVar.Fq.setVisibility(0);
            indexOfChild |= 2;
        }
        aVar.Ft = (Button) b3.findViewById(16908315);
        aVar.Ft.setOnClickListener(aVar.FJ);
        if (TextUtils.isEmpty(aVar.Fu)) {
            aVar.Ft.setVisibility(8);
        } else {
            aVar.Ft.setText(aVar.Fu);
            aVar.Ft.setVisibility(0);
            indexOfChild |= 4;
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            b3.setVisibility(8);
        }
        if (aVar.Fz != null) {
            b.addView(aVar.Fz, 0, new LayoutParams(-1, -2));
            aVar.Fe.findViewById(f.Kw).setVisibility(8);
        } else {
            aVar.kI = (ImageView) aVar.Fe.findViewById(16908294);
            if ((!TextUtils.isEmpty(aVar.uI) ? 1 : null) != null) {
                aVar.Fy = (TextView) aVar.Fe.findViewById(f.JV);
                aVar.Fy.setText(aVar.uI);
                if (aVar.Fx != 0) {
                    aVar.kI.setImageResource(aVar.Fx);
                } else if (aVar.jQ != null) {
                    aVar.kI.setImageDrawable(aVar.jQ);
                } else {
                    aVar.Fy.setPadding(aVar.kI.getPaddingLeft(), aVar.kI.getPaddingTop(), aVar.kI.getPaddingRight(), aVar.kI.getPaddingBottom());
                    aVar.kI.setVisibility(8);
                }
            } else {
                aVar.Fe.findViewById(f.Kw).setVisibility(8);
                aVar.kI.setVisibility(8);
                b.setVisibility(8);
            }
        }
        Object obj2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        obj = (b == null || b.getVisibility() == 8) ? null : 1;
        Object obj3 = (b3 == null || b3.getVisibility() == 8) ? null : 1;
        if (obj3 == null && b2 != null) {
            findViewById = b2.findViewById(f.Kv);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (!(obj == null || aVar.Fw == null)) {
            aVar.Fw.setClipToPadding(true);
        }
        if (obj2 == null) {
            inflate = aVar.Fg != null ? aVar.Fg : aVar.Fw;
            if (inflate != null) {
                int i2 = (obj != null ? 1 : 0) | (obj3 != null ? 2 : 0);
                findViewById5 = aVar.Fe.findViewById(f.Kh);
                findViewById = aVar.Fe.findViewById(f.Kg);
                if (VERSION.SDK_INT >= 23) {
                    z.c(inflate, i2, 3);
                    if (findViewById5 != null) {
                        b2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        b2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i2 & 1) == 0) {
                        b2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i2 & 2) == 0) {
                        b2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (aVar.Ff != null) {
                            aVar.Fw.Dm = new AnonymousClass2(aVar, findViewById5, findViewById);
                            aVar.Fw.post(new AnonymousClass3(aVar, findViewById5, findViewById));
                        } else if (aVar.Fg != null) {
                            aVar.Fg.setOnScrollListener(new AnonymousClass4(aVar, findViewById5, findViewById));
                            aVar.Fg.post(new AnonymousClass5(aVar, findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                b2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                b2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = aVar.Fg;
        if (listView != null && aVar.FA != null) {
            listView.setAdapter(aVar.FA);
            int i3 = aVar.FB;
            if (i3 >= 0) {
                listView.setItemChecked(i3, true);
                listView.setSelection(i3);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        a aVar = this.Gn;
        boolean z = aVar.Fw != null && aVar.Fw.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        a aVar = this.Gn;
        boolean z = aVar.Fw != null && aVar.Fw.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
