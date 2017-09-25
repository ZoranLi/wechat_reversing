package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.m;
import android.support.v4.view.m.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public class p {
    public final String TAG;
    public ae hgN;
    public MenuItem lHT;
    public boolean wnY;
    public boolean wnZ;
    private boolean woa;
    private boolean wob;
    public boolean woc;
    public f wod;
    public b woe;
    private com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a wof;
    private boolean wog;
    private ArrayList<String> woh;
    private boolean woi;
    public int woj;
    private int wok;
    public a wol;

    public interface a {
        void bZR();

        void collapseActionView();
    }

    public interface b {
        void OD();

        void OE();

        void OF();

        void OG();

        boolean mQ(String str);

        void mR(String str);
    }

    public p() {
        this.wnY = false;
        this.wnZ = false;
        this.woa = false;
        this.wob = true;
        this.woc = true;
        this.lHT = null;
        this.hgN = new ae(Looper.getMainLooper());
        this.wod = null;
        this.wog = true;
        this.woj = k.dGO;
        this.wok = 0;
        this.wog = true;
        this.wnY = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public p(boolean z, boolean z2) {
        this.wnY = false;
        this.wnZ = false;
        this.woa = false;
        this.wob = true;
        this.woc = true;
        this.lHT = null;
        this.hgN = new ae(Looper.getMainLooper());
        this.wod = null;
        this.wog = true;
        this.woj = k.dGO;
        this.wok = 0;
        this.wog = true;
        this.wnY = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public final String bzZ() {
        if (this.wod != null) {
            return this.wod.bzZ();
        }
        return "";
    }

    public final void Ug(String str) {
        if (this.wod != null) {
            this.wod.Ug(str);
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.wod != null) {
            this.wod.setHint(charSequence);
        }
    }

    public final void clearFocus() {
        if (this.wod != null) {
            this.wod.bZt();
        }
    }

    public boolean bGI() {
        return false;
    }

    public void bGJ() {
    }

    public void bGK() {
    }

    public final void a(final FragmentActivity fragmentActivity, Menu menu) {
        w.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            w.w(this.TAG, "on add search menu, activity is null");
            return;
        }
        if (this.wod == null) {
            if (this.wog) {
                this.wod = new ActionBarSearchView(fragmentActivity);
            } else {
                this.wod = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.wod.a(this.wof);
            }
            this.wod.lI(this.woi);
            this.wod.ak(this.woh);
        }
        this.wod.a(new com.tencent.mm.ui.tools.ActionBarSearchView.b(this) {
            final /* synthetic */ p wom;

            {
                this.wom = r1;
            }

            public final void aHo() {
                if (this.wom.wnZ) {
                    this.wom.bGJ();
                } else {
                    w.v(this.wom.TAG, "onVoiceSearchRequired, but not in searching");
                }
            }

            public final void aHn() {
                if (this.wom.woe != null) {
                    this.wom.woe.OG();
                }
            }

            public final void zE(String str) {
                if (!this.wom.wnZ) {
                    w.v(this.wom.TAG, "onSearchTextChange %s, but not in searching", str);
                } else if (this.wom.woe != null) {
                    this.wom.woe.mR(str);
                }
            }

            public final void OF() {
                if (this.wom.woe != null) {
                    this.wom.woe.OF();
                }
            }
        });
        this.wod.lE(bGI());
        this.wod.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ p wom;

            {
                this.wom = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.wom.woe == null) {
                    return false;
                }
                return this.wom.woe.mQ(this.wom.bzZ());
            }
        });
        if (this.wok != 0) {
            this.wod.Cd(this.wok);
        }
        this.lHT = menu.add(0, g.cjK, 0, this.woj);
        this.lHT.setEnabled(this.wob);
        this.lHT.setIcon(j.dsU);
        m.a(this.lHT, (View) this.wod);
        if (this.wnY) {
            m.a(this.lHT, 9);
        } else {
            m.a(this.lHT, 2);
        }
        if (this.wnY) {
            m.a(this.lHT, new e(this) {
                final /* synthetic */ p wom;

                public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                    this.wom.a(fragmentActivity, false);
                    return true;
                }

                public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    this.wom.b(fragmentActivity, false);
                    return true;
                }
            });
        } else {
            this.wol = new a(this) {
                final /* synthetic */ p wom;

                public final void bZR() {
                    this.wom.a(fragmentActivity, true);
                }

                public final void collapseActionView() {
                    this.wom.b(fragmentActivity, true);
                }
            };
        }
        this.wod.a(new com.tencent.mm.ui.tools.ActionBarSearchView.a(this) {
            final /* synthetic */ p wom;

            {
                this.wom = r1;
            }

            public final void aHp() {
                if (this.wom.wnY) {
                    if (this.wom.lHT != null) {
                        m.c(this.wom.lHT);
                    }
                } else if (this.wom.wol != null) {
                    this.wom.wol.collapseActionView();
                }
            }
        });
    }

    public void a(Activity activity, Menu menu) {
        w.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.wnZ), Boolean.valueOf(this.woa), Boolean.valueOf(this.wob));
        if (activity == null) {
            w.w(this.TAG, "on hanle status fail, activity is null");
            return;
        }
        this.lHT = menu.findItem(g.cjK);
        if (this.lHT == null) {
            w.w(this.TAG, "can not find search menu, error");
            return;
        }
        this.lHT.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ p wom;

            {
                this.wom = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
    }

    private void b(final Activity activity, Menu menu) {
        if (!this.wob) {
            return;
        }
        if (this.wnZ || this.woa) {
            this.woa = false;
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != g.cjK) {
                        item.setVisible(false);
                    }
                }
            }
            this.hgN.postDelayed(new Runnable(this) {
                final /* synthetic */ p wom;

                public final void run() {
                    if (this.wom.lHT == null) {
                        w.w(this.wom.TAG, "on post expand search menu, but item is null");
                        return;
                    }
                    w.i(this.wom.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(this.wom.wnZ));
                    if (this.wom.wnY) {
                        if (!this.wom.wnZ) {
                            m.b(this.wom.lHT);
                        }
                    } else if (this.wom.wol != null) {
                        this.wom.wol.bZR();
                    }
                    final View a = m.a(this.wom.lHT);
                    if (a != null && this.wom.wnZ) {
                        a.findViewById(g.bKP).requestFocus();
                        if (this.wom.woc) {
                            this.wom.hgN.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass10 wop;

                                public final void run() {
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(g.bKP), 0);
                                }
                            }, 128);
                        }
                    }
                }
            }, 128);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        w.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.wnZ));
        if (4 != i || !this.wnZ) {
            return false;
        }
        bZQ();
        return true;
    }

    public final void lK(boolean z) {
        boolean z2 = false;
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.wnZ);
        if (this.lHT == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        w.d(str, str2, objArr);
        if (!this.wnZ) {
            if (this.wob) {
                this.woc = z;
                if (this.lHT != null) {
                    this.hgN.post(new Runnable(this) {
                        final /* synthetic */ p wom;

                        {
                            this.wom = r1;
                        }

                        public final void run() {
                            if (this.wom.lHT == null) {
                                w.w(this.wom.TAG, "post do expand search menu, but search menu item is null");
                            } else if (this.wom.wnY) {
                                m.b(this.wom.lHT);
                            } else if (this.wom.wol != null) {
                                this.wom.wol.bZR();
                            }
                        }
                    });
                    return;
                } else {
                    this.woa = true;
                    return;
                }
            }
            w.w(this.TAG, "can not expand now");
        }
    }

    public final void bZQ() {
        w.d(this.TAG, "do collapse");
        if (this.wnZ && this.lHT != null) {
            if (this.wnY) {
                m.c(this.lHT);
            } else if (this.wol != null) {
                this.wol.collapseActionView();
            }
        }
    }

    public final boolean bZu() {
        if (this.wod != null) {
            return this.wod.bZu();
        }
        return false;
    }

    public final boolean bZv() {
        if (this.wod != null) {
            return this.wod.bZv();
        }
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z) {
        w.d(this.TAG, "doNewExpand, searchViewExpand " + this.wnZ);
        if (!this.wnZ) {
            this.wnZ = true;
            b((Activity) fragmentActivity, null);
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ p wom;

                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        w.w(this.wom.TAG, "want to expand search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.aQ();
                    }
                }
            });
            if (this.woe != null) {
                this.woe.OE();
            }
        }
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z) {
        w.d(this.TAG, "doNewCollapse, searchViewExpand " + this.wnZ);
        if (this.wnZ) {
            this.wnZ = false;
            bGK();
            if (this.wod != null) {
                this.wod.lH(false);
            }
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ p wom;

                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        w.w(this.wom.TAG, "want to collapse search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.aQ();
                    }
                }
            });
            if (this.woe != null) {
                this.hgN.post(new Runnable(this) {
                    final /* synthetic */ p wom;

                    {
                        this.wom = r1;
                    }

                    public final void run() {
                        this.wom.woe.OD();
                    }
                });
            }
        }
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ p wom;

            public final void run() {
                if (this.wom.lHT == null) {
                    w.w(this.wom.TAG, "want to collapse search view, but search menu item is null");
                    return;
                }
                if (!(fragmentActivity == null || fragmentActivity.isFinishing())) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        View currentFocus = fragmentActivity.getCurrentFocus();
                        if (currentFocus != null) {
                            IBinder windowToken = currentFocus.getWindowToken();
                            if (windowToken != null) {
                                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                            }
                        }
                    }
                }
                View a = m.a(this.wom.lHT);
                if (a != null) {
                    a.findViewById(g.bKP).clearFocus();
                }
            }
        });
    }
}
