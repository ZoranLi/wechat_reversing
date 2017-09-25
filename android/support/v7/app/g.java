package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v4.widget.m;
import android.support.v7.a.a.f;
import android.support.v7.view.b;
import android.support.v7.view.d;
import android.support.v7.view.e;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ViewStubCompat;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import android.widget.PopupWindow;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Calendar;

class g extends f {
    private static m GF;
    private int GG = -100;
    private boolean GH;
    boolean GI = true;

    class a extends a {
        final /* synthetic */ g GJ;

        a(g gVar, Callback callback) {
            this.GJ = gVar;
            super(gVar, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.GJ.GI) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            Object aVar = new android.support.v7.view.f.a(this.GJ.mContext, callback);
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.GJ;
            if (appCompatDelegateImplV7.GP != null) {
                appCompatDelegateImplV7.GP.finish();
            }
            android.support.v7.view.b.a bVar = new b(appCompatDelegateImplV7, aVar);
            ActionBar cP = appCompatDelegateImplV7.cP();
            if (cP != null) {
                appCompatDelegateImplV7.GP = cP.a(bVar);
            }
            if (appCompatDelegateImplV7.GP == null) {
                appCompatDelegateImplV7.cX();
                if (appCompatDelegateImplV7.GP != null) {
                    appCompatDelegateImplV7.GP.finish();
                }
                android.support.v7.view.b.a bVar2 = new b(appCompatDelegateImplV7, bVar);
                if (appCompatDelegateImplV7.GQ == null) {
                    if (appCompatDelegateImplV7.GB) {
                        Context dVar;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = appCompatDelegateImplV7.mContext.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Theme newTheme = appCompatDelegateImplV7.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new d(appCompatDelegateImplV7.mContext, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = appCompatDelegateImplV7.mContext;
                        }
                        appCompatDelegateImplV7.GQ = new ActionBarContextView(dVar);
                        appCompatDelegateImplV7.GR = new PopupWindow(dVar, null, android.support.v7.a.a.a.IG);
                        m.a(appCompatDelegateImplV7.GR, 2);
                        appCompatDelegateImplV7.GR.setContentView(appCompatDelegateImplV7.GQ);
                        appCompatDelegateImplV7.GR.setWidth(-1);
                        dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                        appCompatDelegateImplV7.GQ.ay(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        appCompatDelegateImplV7.GR.setHeight(-2);
                        appCompatDelegateImplV7.GS = new Runnable(appCompatDelegateImplV7) {
                            final /* synthetic */ AppCompatDelegateImplV7 Hi;

                            {
                                this.Hi = r1;
                            }

                            public final void run() {
                                this.Hi.GR.showAtLocation(this.Hi.GQ, 55, 0, 0);
                                this.Hi.cX();
                                z.d(this.Hi.GQ, 0.0f);
                                this.Hi.GT = z.V(this.Hi.GQ).p(1.0f);
                                this.Hi.GT.a(new an(this) {
                                    final /* synthetic */ AnonymousClass5 Hj;

                                    {
                                        this.Hj = r1;
                                    }

                                    public final void q(View view) {
                                        z.d(this.Hj.Hi.GQ, 1.0f);
                                        this.Hj.Hi.GT.a(null);
                                        this.Hj.Hi.GT = null;
                                    }

                                    public final void p(View view) {
                                        this.Hj.Hi.GQ.setVisibility(0);
                                    }
                                });
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImplV7.GV.findViewById(f.JS);
                        if (viewStubCompat != null) {
                            viewStubCompat.Du = LayoutInflater.from(appCompatDelegateImplV7.cV());
                            appCompatDelegateImplV7.GQ = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (appCompatDelegateImplV7.GQ != null) {
                    appCompatDelegateImplV7.cX();
                    appCompatDelegateImplV7.GQ.dO();
                    b eVar = new e(appCompatDelegateImplV7.GQ.getContext(), appCompatDelegateImplV7.GQ, bVar2, appCompatDelegateImplV7.GR == null);
                    if (bVar.a(eVar, eVar.getMenu())) {
                        eVar.invalidate();
                        appCompatDelegateImplV7.GQ.c(eVar);
                        appCompatDelegateImplV7.GP = eVar;
                        z.d(appCompatDelegateImplV7.GQ, 0.0f);
                        appCompatDelegateImplV7.GT = z.V(appCompatDelegateImplV7.GQ).p(1.0f);
                        appCompatDelegateImplV7.GT.a(new an(appCompatDelegateImplV7) {
                            final /* synthetic */ AppCompatDelegateImplV7 Hi;

                            {
                                this.Hi = r1;
                            }

                            public final void q(View view) {
                                z.d(this.Hi.GQ, 1.0f);
                                this.Hi.GT.a(null);
                                this.Hi.GT = null;
                            }

                            public final void p(View view) {
                                this.Hi.GQ.setVisibility(0);
                                this.Hi.GQ.sendAccessibilityEvent(32);
                                if (this.Hi.GQ.getParent() != null) {
                                    z.Z((View) this.Hi.GQ.getParent());
                                }
                            }
                        });
                        if (appCompatDelegateImplV7.GR != null) {
                            appCompatDelegateImplV7.Fe.getDecorView().post(appCompatDelegateImplV7.GS);
                        }
                    } else {
                        appCompatDelegateImplV7.GP = null;
                    }
                }
                appCompatDelegateImplV7.GP = appCompatDelegateImplV7.GP;
            }
            b bVar3 = appCompatDelegateImplV7.GP;
            if (bVar3 != null) {
                return aVar.b(bVar3);
            }
            return null;
        }
    }

    g(Context context, Window window, c cVar) {
        super(context, window, cVar);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.GG == -100) {
            this.GG = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public final boolean cS() {
        this.GH = true;
        int at = at(this.GG == -100 ? d.Gs : this.GG);
        if (at == -1) {
            return false;
        }
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i = configuration.uiMode & 48;
        at = at == 2 ? 32 : 16;
        if (i == at) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = at | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    int at(int i) {
        Location location = null;
        switch (i) {
            case -100:
                return -1;
            case 0:
                boolean z;
                if (GF == null) {
                    GF = new m(this.mContext.getApplicationContext());
                }
                m mVar = GF;
                a aVar = m.HS;
                if (m.a(aVar)) {
                    z = aVar.HU;
                } else {
                    Location o;
                    if (android.support.v4.content.e.d(mVar.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        o = mVar.o(TencentLocation.NETWORK_PROVIDER);
                    } else {
                        o = null;
                    }
                    if (android.support.v4.content.e.d(mVar.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        location = mVar.o("gps");
                    }
                    if (location == null || o == null) {
                        if (location != null) {
                            o = location;
                        }
                    } else if (location.getTime() > o.getTime()) {
                        o = location;
                    }
                    if (o != null) {
                        m.b(o);
                        z = aVar.HU;
                    } else {
                        int i2 = Calendar.getInstance().get(11);
                        z = i2 < 6 || i2 >= 22;
                    }
                }
                return z ? 2 : 1;
            default:
                return i;
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.GG != -100) {
            bundle.putInt("appcompat:local_night_mode", this.GG);
        }
    }
}
