package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class BakMoveBaseUI extends MMActivity {
    protected TextView jKK;
    protected TextView jKL;
    protected ProgressBar jKM;
    protected TextView jKN;
    protected Button jKO;
    private WakeLock wakeLock;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKK = (TextView) findViewById(R.h.cGz);
        this.jKL = (TextView) findViewById(R.h.cGu);
        this.jKM = (ProgressBar) findViewById(R.h.ctp);
        this.jKN = (TextView) findViewById(R.h.cpF);
        this.jKO = (Button) findViewById(R.h.brq);
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "My Lock");
    }

    public void onResume() {
        super.onResume();
        this.wakeLock.acquire();
    }

    public void onPause() {
        super.onPause();
        this.wakeLock.release();
    }

    protected final int getLayoutId() {
        return R.i.cVj;
    }
}
