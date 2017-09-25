package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.q;

public abstract class i extends q {
    public SharedPreferences hgx;
    public boolean lEy = false;
    public ListView mUX;
    public boolean raa = false;
    public h vrv;

    public abstract int ON();

    public abstract boolean a(f fVar, Preference preference);

    protected final int getLayoutId() {
        return h.hes;
    }

    public void onResume() {
        super.onResume();
        this.vrv.notifyDataSetChanged();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hgx = SB(bPj().getPackageName() + "_preferences");
        this.vrv = new h(this.uSU.uTo, this.hgx);
        this.mUX = (ListView) findViewById(16908298);
        this.vrv.b(new a(this) {
            final /* synthetic */ i vrN;

            {
                this.vrN = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                if (!this.vrN.raa && preference.isEnabled() && preference.vrX) {
                    boolean z;
                    this.vrN.raa = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.vqm = checkBoxPreference.isChecked();
                        if (checkBoxPreference.vrZ) {
                            this.vrN.hgx.edit().putBoolean(preference.igL, checkBoxPreference.isChecked()).commit();
                        }
                        this.vrN.lEy = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.igL != null) {
                        this.vrN.a(this.vrN.vrv, preference);
                    }
                    if (z) {
                        this.vrN.vrv.notifyDataSetChanged();
                    }
                    this.vrN.raa = false;
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
        });
        int ON = ON();
        if (ON != -1) {
            this.vrv.addPreferencesFromResource(ON);
        }
        this.mUX.setAdapter(this.vrv);
        this.mUX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ i vrN;

            {
                this.vrN = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.vrN.mUX.getHeaderViewsCount()) {
                    final Preference preference = (Preference) this.vrN.vrv.getItem(i - this.vrN.mUX.getHeaderViewsCount());
                    if (preference.isEnabled() && preference.vrX && !(preference instanceof CheckBoxPreference)) {
                        if (preference instanceof DialogPreference) {
                            final DialogPreference dialogPreference = (DialogPreference) preference;
                            dialogPreference.showDialog();
                            dialogPreference.vqw = new DialogPreference.a(this) {
                                final /* synthetic */ AnonymousClass2 vrO;

                                public final void bSW() {
                                    this.vrO.vrN.lEy = true;
                                    if (dialogPreference.vrZ) {
                                        this.vrO.vrN.hgx.edit().putString(preference.igL, dialogPreference.getValue()).commit();
                                    }
                                    this.vrO.vrN.vrv.notifyDataSetChanged();
                                }
                            };
                        }
                        if (preference instanceof EditPreference) {
                            final EditPreference editPreference = (EditPreference) preference;
                            editPreference.showDialog();
                            editPreference.vqy = new EditPreference.a(this) {
                                final /* synthetic */ AnonymousClass2 vrO;

                                public final void bSW() {
                                    this.vrO.vrN.lEy = true;
                                    if (editPreference.vrZ) {
                                        this.vrO.vrN.hgx.edit().putString(preference.igL, editPreference.value).commit();
                                    }
                                    this.vrO.vrN.vrv.notifyDataSetChanged();
                                }
                            };
                        }
                        if (preference.igL != null) {
                            this.vrN.a(this.vrN.vrv, preference);
                        }
                    }
                }
            }
        });
        this.mUX.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ i vrN;

            {
                this.vrN = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.vrN.mUX.getHeaderViewsCount()) {
                    return false;
                }
                this.vrN.vrv.getItem(i - this.vrN.mUX.getHeaderViewsCount());
                h hVar = this.vrN.vrv;
                ListView listView = this.vrN.mUX;
                return i.bSZ();
            }
        });
    }

    public final boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean bSZ() {
        return false;
    }
}
