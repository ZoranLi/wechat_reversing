package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;

public final class b {

    static class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ PBool wbG;

        AnonymousClass1(PBool pBool) {
            this.wbG = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.wbG.value = true;
        }
    }

    static class AnonymousClass3 implements OnCancelListener {
        final /* synthetic */ PBool wbG;

        AnonymousClass3(PBool pBool) {
            this.wbG = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.wbG.value = true;
        }
    }

    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ PBool wbG;

        AnonymousClass5(PBool pBool) {
            this.wbG = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.wbG.value = true;
        }
    }

    static class AnonymousClass7 implements OnCancelListener {
        final /* synthetic */ PBool wbG;

        AnonymousClass7(PBool pBool) {
            this.wbG = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.wbG.value = true;
        }
    }

    static class AnonymousClass2 implements a {
        final /* synthetic */ String gTC;
        final /* synthetic */ ProgressDialog ktL;
        final /* synthetic */ PBool wbG;

        AnonymousClass2(PBool pBool, ProgressDialog progressDialog, String str) {
            this.wbG = pBool;
            this.ktL = progressDialog;
            this.gTC = str;
        }

        public final boolean zs() {
            return this.wbG.value || this.ktL == null || !this.ktL.isShowing();
        }

        public final void zr() {
            ap.yY();
            af Rc = c.wR().Rc(this.gTC);
            Rc.tj();
            if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                o.m(Rc.field_username, false);
            } else {
                ap.yY();
                c.wR().a(this.gTC, Rc);
            }
            ap.yY();
            c.wW().Rl(this.gTC);
            if (this.ktL != null) {
                this.ktL.dismiss();
            }
        }
    }

    static class AnonymousClass4 implements a {
        final /* synthetic */ ProgressDialog ktL;
        final /* synthetic */ String uPi;
        final /* synthetic */ PBool wbG;

        AnonymousClass4(PBool pBool, ProgressDialog progressDialog, String str) {
            this.wbG = pBool;
            this.ktL = progressDialog;
            this.uPi = str;
        }

        public final boolean zs() {
            return this.wbG.value || this.ktL == null || !this.ktL.isShowing();
        }

        public final void zr() {
            e.u(this.uPi, false);
            if (this.ktL != null) {
                this.ktL.dismiss();
            }
        }
    }

    static class AnonymousClass6 implements a {
        final /* synthetic */ PBool wbG;
        final /* synthetic */ ProgressDialog wbH;

        AnonymousClass6(PBool pBool, ProgressDialog progressDialog) {
            this.wbG = pBool;
            this.wbH = progressDialog;
        }

        public final boolean zs() {
            return this.wbG.value || this.wbH == null || !this.wbH.isShowing();
        }

        public final void zr() {
            if (this.wbH != null) {
                this.wbH.dismiss();
            }
        }
    }

    static class AnonymousClass8 implements a {
        final /* synthetic */ ProgressDialog ktL;
        final /* synthetic */ PBool wbG;

        AnonymousClass8(PBool pBool, ProgressDialog progressDialog) {
            this.wbG = pBool;
            this.ktL = progressDialog;
        }

        public final boolean zs() {
            return this.wbG.value;
        }

        public final void zr() {
            if (this.ktL != null) {
                this.ktL.dismiss();
            }
        }
    }
}
