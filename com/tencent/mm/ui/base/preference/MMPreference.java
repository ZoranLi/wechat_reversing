package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference.a;

public abstract class MMPreference extends MMActivity {
    public SharedPreferences hgx;
    private boolean lEy = false;
    public ListView mUX;
    private boolean raa = false;
    public h vrv;
    protected RelativeLayout vrw;
    protected TextView vrx;
    protected ImageView vry;

    public abstract int ON();

    public abstract boolean a(f fVar, Preference preference);

    public int getLayoutId() {
        return h.cki;
    }

    public boolean OM() {
        return true;
    }

    public void onResume() {
        if (OM()) {
            this.vrv.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.vrv = a(this.hgx);
        this.mUX = (ListView) findViewById(16908298);
        this.vrw = (RelativeLayout) findViewById(g.hcR);
        this.vrx = (TextView) findViewById(g.hcQ);
        this.vry = (ImageView) findViewById(g.hcP);
        int aeq = aeq();
        if (aeq != -1) {
            this.mUX.addHeaderView(getLayoutInflater().inflate(aeq, null));
        }
        View agV = agV();
        if (agV != null) {
            if (agV.getLayoutParams() != null) {
                agV.setLayoutParams(new LayoutParams(agV.getLayoutParams()));
            } else {
                w.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.mUX.addFooterView(agV);
        }
        View aZS = aZS();
        if (aZS != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(g.hcO);
            frameLayout.addView(aZS);
            frameLayout.setVisibility(0);
        }
        this.vrv.b(new a(this) {
            final /* synthetic */ MMPreference vrz;

            {
                this.vrz = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                if (!this.vrz.raa && preference.isEnabled() && preference.vrX) {
                    boolean z;
                    this.vrz.raa = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.vqm = checkBoxPreference.isChecked();
                        if (checkBoxPreference.vrZ) {
                            this.vrz.hgx.edit().putBoolean(preference.igL, checkBoxPreference.isChecked()).commit();
                        }
                        this.vrz.lEy = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.igL != null) {
                        this.vrz.a(this.vrz.vrv, preference);
                    }
                    if (z) {
                        this.vrz.vrv.notifyDataSetChanged();
                    }
                    this.vrz.raa = false;
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
        });
        aeq = ON();
        if (aeq != -1) {
            this.vrv.addPreferencesFromResource(aeq);
        }
        this.mUX.setAdapter(this.vrv);
        this.mUX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MMPreference vrz;

            {
                this.vrz = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Preference preference = (Preference) adapterView.getAdapter().getItem(i);
                if (preference != null && preference.isEnabled() && preference.vrX && !(preference instanceof CheckBoxPreference)) {
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.vqw = new DialogPreference.a(this) {
                            final /* synthetic */ AnonymousClass2 vrB;

                            public final void bSW() {
                                this.vrB.vrz.lEy = true;
                                if (dialogPreference.vrZ) {
                                    this.vrB.vrz.hgx.edit().putString(preference.igL, dialogPreference.getValue()).commit();
                                }
                                this.vrB.vrz.vrv.notifyDataSetChanged();
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.vqy = new EditPreference.a(this) {
                            final /* synthetic */ AnonymousClass2 vrB;

                            public final void bSW() {
                                this.vrB.vrz.lEy = true;
                                if (editPreference.vrZ) {
                                    this.vrB.vrz.hgx.edit().putString(preference.igL, editPreference.value).commit();
                                }
                                this.vrB.vrz.vrv.notifyDataSetChanged();
                            }
                        };
                    }
                    if (preference.igL != null) {
                        this.vrz.a(this.vrz.vrv, preference);
                    }
                }
            }
        });
        this.mUX.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ MMPreference vrz;

            {
                this.vrz = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.vrz.mUX.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.vrz.mUX.getHeaderViewsCount();
                    if (headerViewsCount >= this.vrz.vrv.getCount()) {
                        w.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(this.vrz.vrv.getCount()));
                    } else {
                        this.vrz.vrv.getItem(headerViewsCount);
                    }
                }
                return false;
            }
        });
        this.mUX.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MMPreference vrz;

            {
                this.vrz = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    View currentFocus = this.vrz.getCurrentFocus();
                    if (currentFocus != null) {
                        currentFocus.clearFocus();
                    }
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final void setSelection(int i) {
        this.mUX.setSelection(i);
    }

    public int aeq() {
        return -1;
    }

    public View agV() {
        return null;
    }

    public View aZS() {
        return null;
    }

    public h a(SharedPreferences sharedPreferences) {
        return new h(this, sharedPreferences);
    }
}
