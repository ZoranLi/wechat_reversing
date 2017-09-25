package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.b;
import android.support.v7.view.menu.l.a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

final class g implements OnClickListener, OnDismissListener, OnKeyListener, a {
    b QK;
    e QL;
    private a QM;
    f dW;

    public g(f fVar) {
        this.dW = fVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.QK.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.QK.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.dW.D(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.dW.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.QL.a(this.dW, true);
    }

    public final void a(f fVar, boolean z) {
        if ((z || fVar == this.dW) && this.QK != null) {
            this.QK.dismiss();
        }
        if (this.QM != null) {
            this.QM.a(fVar, z);
        }
    }

    public final boolean d(f fVar) {
        if (this.QM != null) {
            return this.QM.d(fVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.dW.a((h) this.QL.getAdapter().getItem(i), null, 0);
    }
}
