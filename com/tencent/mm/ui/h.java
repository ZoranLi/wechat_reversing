package com.tencent.mm.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class h extends Fragment {
    public boolean uPP;
    public boolean uPQ;
    private FragmentActivity uPR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uPR = aG();
    }

    public void onDestroy() {
        super.onDestroy();
        this.uPQ = true;
    }

    public h(boolean z) {
        this.uPQ = false;
        this.uPP = z;
    }

    public h() {
        this.uPQ = false;
        this.uPP = false;
    }

    public void startActivity(Intent intent) {
        FragmentActivity bPj = bPj();
        if (bPj == null) {
            ab.getContext().startActivity(intent);
        } else {
            bPj.a((Fragment) this, intent, -1);
        }
    }

    public void finish() {
        if (this.uPP) {
            if (bPj() != null) {
                bPj().finish();
            }
        } else if (bPj() != null) {
            bPj().aR().popBackStack();
        }
    }

    public final int getIntExtra(String str, int i) {
        if (this.uPP && this.oW == null && bPj() != null) {
            return bPj().getIntent().getIntExtra(str, i);
        }
        if (this.oW != null) {
            return this.oW.getInt(str, i);
        }
        return i;
    }

    public final String getStringExtra(String str) {
        String str2 = null;
        if (this.uPP && bPj() != null) {
            str2 = bPj().getIntent().getStringExtra(str);
        }
        if (str2 != null || this.oW == null) {
            return str2;
        }
        return this.oW.getString(str);
    }

    public final SharedPreferences SB(String str) {
        return bPj().getSharedPreferences(str, 0);
    }

    public FragmentActivity bPj() {
        if (this.uPR == null) {
            this.uPR = aG();
        }
        return this.uPR;
    }

    public final View findViewById(int i) {
        View view = this.mView;
        View view2 = null;
        if (view != null) {
            view2 = view.findViewById(i);
        }
        return view2 != null ? view2 : bPj().findViewById(i);
    }

    public final void sendBroadcast(Intent intent) {
        bPj().sendBroadcast(intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        } else if (i == 82 && keyEvent.getAction() == 1) {
            return onKeyUp(i, keyEvent);
        } else {
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean isFinishing() {
        if (bPj() == null) {
            return true;
        }
        return bPj().isFinishing();
    }

    public final void setRequestedOrientation(int i) {
        if (bPj() != null) {
            bPj().setRequestedOrientation(i);
        }
    }

    public final WindowManager getWindowManager() {
        if (bPj() != null) {
            return bPj().getWindowManager();
        }
        return null;
    }

    public final Boolean aS(String str, boolean z) {
        if (this.uPP && this.oW == null) {
            return Boolean.valueOf(bPj().getIntent().getBooleanExtra(str, z));
        }
        return Boolean.valueOf(this.oW.getBoolean(str, z));
    }

    public final long SC(String str) {
        if (this.uPP && this.oW == null) {
            return bPj().getIntent().getLongExtra(str, -1);
        }
        if (this.oW != null) {
            return this.oW.getLong(str, -1);
        }
        return -1;
    }

    public final void bPk() {
        if (this.uPP) {
            bPj().setResult(-1);
        }
    }

    public final void overridePendingTransition(int i, int i2) {
        if (bPj() != null) {
            bPj().overridePendingTransition(i, i2);
        }
    }

    public final boolean isShowing() {
        return !this.uPQ;
    }
}
