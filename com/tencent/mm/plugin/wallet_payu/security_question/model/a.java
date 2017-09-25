package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public final class a extends d {
    private Bundle lHw;

    public a(MMActivity mMActivity, f fVar, Bundle bundle) {
        super(mMActivity, fVar);
        this.lHw = bundle;
    }

    public final boolean o(Object... objArr) {
        this.wEx.a(new c(this.lHw.getString("payu_reference")), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof c) && i == 0 && i2 == 0) {
            c cVar = (c) kVar;
            this.lHw.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.rSY));
            return false;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            b bVar = (b) kVar;
            if (i != 0 || i2 != 0 || !bVar.lva) {
                return false;
            }
            this.lHw.putString("payu_reference", bVar.rSX);
            com.tencent.mm.wallet_core.a.k(this.wEw, this.lHw);
            return true;
        }
    }

    public final boolean j(Object... objArr) {
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.lHw.getParcelable("key_security_question");
        String string = this.lHw.getString("key_question_answer");
        this.wEx.a(new b(this.lHw.getString("payu_reference"), payUSecurityQuestion.id, string), true);
        return false;
    }
}
