package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.l.b;
import java.util.Map;

public class GameRegionSelectUI extends MMPreference {
    private f isJ;
    private a mEf;
    private Map<String, a> mEk;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
    }

    protected void onDestroy() {
        a.mGh.aCe();
        super.onDestroy();
    }

    public final int ON() {
        return -1;
    }

    protected final void KC() {
        zi(R.l.epw);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRegionSelectUI mEl;

            {
                this.mEl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mEl.setResult(0);
                this.mEl.aHf();
                this.mEl.finish();
                return true;
            }
        });
        a(0, getString(R.l.epv), new OnMenuItemClickListener(this) {
            final /* synthetic */ GameRegionSelectUI mEl;

            {
                this.mEl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                if (this.mEl.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) != 1) {
                    i = 1;
                }
                if (i != 0) {
                    g.a(this.mEl, true, this.mEl.getString(R.l.ept), "", this.mEl.getString(R.l.epu), this.mEl.getString(R.l.eps), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 mEm;

                        {
                            this.mEm = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.mEm.mEl.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
                            if (this.mEm.mEl.mEf != null) {
                                e.X(this.mEm.mEl, this.mEm.mEl.mEf.gkH);
                                a.mGh.mGg = true;
                            }
                            Intent intent = new Intent();
                            a cg = e.cg(this.mEm.mEl);
                            if (cg != null) {
                                intent.putExtra("gameRegionName", e.a(cg));
                                this.mEm.mEl.setResult(-1, intent);
                            } else {
                                this.mEm.mEl.setResult(1);
                            }
                            this.mEm.mEl.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 mEm;

                        {
                            this.mEm = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    if (this.mEl.mEf != null) {
                        e.X(this.mEl, this.mEl.mEf.gkH);
                        a.mGh.mGg = true;
                    }
                    Intent intent = new Intent();
                    a cg = e.cg(this.mEl);
                    if (cg != null) {
                        intent.putExtra("gameRegionName", e.a(cg));
                        this.mEl.setResult(-1, intent);
                    } else {
                        this.mEl.setResult(1);
                    }
                    this.mEl.finish();
                }
                return true;
            }
        }, b.uTY);
        this.isJ.removeAll();
        this.mEk = a.mGh.aCg();
        a cg = e.cg(this);
        if (cg != null) {
            cg.mEj = true;
        }
        for (a cg2 : this.mEk.values()) {
            if (cg2 != null) {
                Preference gameRegionPreference = new GameRegionPreference(this);
                if (cg2 == null || bg.mA(cg2.gkH)) {
                    w.e("MicroMsg.GameRegionPreference", "setData region error");
                } else {
                    gameRegionPreference.mEf = cg2;
                    gameRegionPreference.setKey(cg2.gkH);
                }
                if (cg2.isDefault) {
                    this.isJ.a(gameRegionPreference, 0);
                } else {
                    this.isJ.a(gameRegionPreference);
                }
            }
        }
        this.isJ.a(new PreferenceCategory(this));
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof GameRegionPreference)) {
            return false;
        }
        a aVar = ((GameRegionPreference) preference).mEf;
        if (aVar == null) {
            return false;
        }
        this.mEf = aVar;
        for (a aVar2 : this.mEk.values()) {
            aVar2.mEj = false;
        }
        aVar.mEj = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
