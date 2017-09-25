package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI extends MMPreference {
    private f isJ;
    private Profession[] rCb = null;

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        zi(R.l.fke);
        this.isJ = this.vrv;
        Preference preferenceTitleCategory = new PreferenceTitleCategory(this.uSU.uTo);
        preferenceTitleCategory.setTitle(getString(R.l.fkd));
        preferenceTitleCategory.setKey("title_category");
        this.isJ.a(preferenceTitleCategory);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("key_profession_list");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length > 0) {
            this.rCb = new Profession[parcelableArrayExtra.length];
            for (int i2 = 0; i2 < this.rCb.length; i2++) {
                this.rCb[i2] = (Profession) parcelableArrayExtra[i2];
            }
        }
        if (this.rCb != null) {
            Profession[] professionArr = this.rCb;
            int length = professionArr.length;
            int i3 = 0;
            while (i < length) {
                Profession profession = professionArr[i];
                if (!(profession == null || bg.mA(profession.rDp))) {
                    Preference preference = new Preference(this.uSU.uTo);
                    preference.setTitle(profession.rDp);
                    preference.setKey("index_" + i3);
                    this.isJ.a(preference);
                }
                i3++;
                i++;
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletSelectProfessionUI rOc;

            {
                this.rOc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rOc.setResult(0);
                this.rOc.finish();
                return true;
            }
        });
    }

    public final int ON() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.startsWith("index_")) {
            String[] split = preference.igL.split("_");
            if (split.length == 2) {
                Parcelable parcelable = this.rCb[bg.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", parcelable);
                setResult(-1, intent);
            } else {
                w.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", new Object[]{preference.igL, preference.getTitle()});
                setResult(0);
            }
            finish();
        }
        return true;
    }
}
