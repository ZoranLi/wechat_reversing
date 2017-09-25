package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class h extends Fragment implements OnCancelListener, OnDismissListener {
    int oG = 0;
    int oH = 0;
    boolean oI = true;
    public boolean oJ = true;
    int oK = -1;
    Dialog oL;
    boolean oM;
    boolean oN;
    boolean oO;

    public void a(l lVar, String str) {
        this.oN = false;
        this.oO = true;
        p aV = lVar.aV();
        aV.a((Fragment) this, str);
        aV.commit();
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.oO) {
            this.oN = false;
        }
    }

    public final void onDetach() {
        super.onDetach();
        if (!this.oO && !this.oN) {
            this.oN = true;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oJ = this.pl == 0;
        if (bundle != null) {
            this.oG = bundle.getInt("android:style", 0);
            this.oH = bundle.getInt("android:theme", 0);
            this.oI = bundle.getBoolean("android:cancelable", true);
            this.oJ = bundle.getBoolean("android:showsDialog", this.oJ);
            this.oK = bundle.getInt("android:backStackId", -1);
        }
    }

    public final LayoutInflater c(Bundle bundle) {
        if (!this.oJ) {
            return super.c(bundle);
        }
        this.oL = aF();
        if (this.oL == null) {
            return (LayoutInflater) this.ph.mContext.getSystemService("layout_inflater");
        }
        Dialog dialog = this.oL;
        switch (this.oG) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
        }
        dialog.requestWindowFeature(1);
        return (LayoutInflater) this.oL.getContext().getSystemService("layout_inflater");
    }

    public Dialog aF() {
        return new Dialog(aG(), this.oH);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.oM && !this.oN) {
            this.oN = true;
            this.oO = false;
            if (this.oL != null) {
                this.oL.dismiss();
                this.oL = null;
            }
            this.oM = true;
            if (this.oK >= 0) {
                this.pg.F(this.oK);
                this.oK = -1;
                return;
            }
            p aV = this.pg.aV();
            aV.a(this);
            aV.commitAllowingStateLoss();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.oJ) {
            View view = this.mView;
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.oL.setContentView(view);
            }
            this.oL.setOwnerActivity(aG());
            this.oL.setCancelable(this.oI);
            this.oL.setOnCancelListener(this);
            this.oL.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.oL.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public final void onStart() {
        super.onStart();
        if (this.oL != null) {
            this.oM = false;
            this.oL.show();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.oL != null) {
            Bundle onSaveInstanceState = this.oL.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.oG != 0) {
            bundle.putInt("android:style", this.oG);
        }
        if (this.oH != 0) {
            bundle.putInt("android:theme", this.oH);
        }
        if (!this.oI) {
            bundle.putBoolean("android:cancelable", this.oI);
        }
        if (!this.oJ) {
            bundle.putBoolean("android:showsDialog", this.oJ);
        }
        if (this.oK != -1) {
            bundle.putInt("android:backStackId", this.oK);
        }
    }

    public final void onStop() {
        super.onStop();
        if (this.oL != null) {
            this.oL.hide();
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.oL != null) {
            this.oM = true;
            this.oL.dismiss();
            this.oL = null;
        }
    }
}
