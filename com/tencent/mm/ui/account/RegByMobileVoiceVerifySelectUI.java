package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements e {
    private f isJ;
    private String plh;
    private a[] vay;

    public final void a(int i, int i2, String str, k kVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int ON() {
        return R.i.cVF;
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).uXY;
        if (aVar == null) {
            return false;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("voice_verify_language", aVar.uXZ);
        bundle.putString("voice_verify_code", aVar.uYb);
        intent.putExtras(bundle);
        setResult(0, intent);
        finish();
        return true;
    }

    protected final void KC() {
        aHf();
        this.plh = getIntent().getExtras().getString("voice_verify_code");
        zi(R.l.dOp);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifySelectUI vaz;

            {
                this.vaz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vaz.aHf();
                this.vaz.finish();
                return true;
            }
        });
        this.vay = bQZ();
        if (this.vay != null && this.vay.length > 0) {
            this.isJ.removeAll();
            this.isJ.a(new PreferenceCategory(this));
            for (a aVar : this.vay) {
                if (aVar.uYb.equalsIgnoreCase(this.plh)) {
                    aVar.mEj = true;
                }
                Preference languagePreference = new LanguagePreference(this);
                languagePreference.a(aVar);
                languagePreference.setKey(aVar.uYb);
                this.isJ.a(languagePreference);
            }
        }
    }

    public static String SQ(String str) {
        a[] bQZ = bQZ();
        String jO = b.jO(str);
        for (a aVar : bQZ) {
            if (aVar.uYb.equalsIgnoreCase(jO)) {
                return aVar.uXZ;
            }
        }
        return "English";
    }

    private static a[] bQZ() {
        String[] split = ab.getContext().getString(R.l.dOm).trim().split(",");
        a[] aVarArr = new a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            aVarArr[i] = new a(split2[1], split2[2], split2[0], false);
        }
        return aVarArr;
    }
}
