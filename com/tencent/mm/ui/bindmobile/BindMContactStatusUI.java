package com.tencent.mm.ui.bindmobile;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI extends MMWizardActivity {
    private Button jMI;
    private ImageView vcj;
    private TextView vck;
    private TextView vtO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dNR);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.cVD;
    }

    protected final void KC() {
        this.vcj = (ImageView) findViewById(R.h.btc);
        this.vtO = (TextView) findViewById(R.h.bta);
        this.vck = (TextView) findViewById(R.h.bsY);
        this.jMI = (Button) findViewById(R.h.btb);
        if (m.Fl() == a.SUCC) {
            this.vcj.setImageResource(R.k.dxH);
            ap.yY();
            String str = (String) c.vr().get(6, null);
            if (str == null || str.equals("")) {
                ap.yY();
                str = (String) c.vr().get(4097, null);
            }
            this.vck.setText(getString(R.l.dNO));
            this.vtO.setText(getString(R.l.dOi, new Object[]{str}));
        } else {
            this.vcj.setImageResource(R.k.dxI);
            this.vck.setText(R.l.dNY);
            this.vtO.setText(R.l.dNY);
            this.vck.setVisibility(8);
        }
        this.jMI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMContactStatusUI vtP;

            {
                this.vtP = r1;
            }

            public final void onClick(View view) {
                this.vtP.zu(1);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        zu(1);
        return true;
    }
}
