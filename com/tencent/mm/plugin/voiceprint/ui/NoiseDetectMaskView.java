package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar kYg = null;
    private Context mContext = null;
    TextView rdn;
    TextView rdo;
    b rdp;
    a rdq;

    public interface a {
        void boJ();
    }

    public interface b {
        void boK();
    }

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(R.i.dkm, this);
        this.kYg = (ProgressBar) findViewById(R.h.cot);
        this.rdn = (TextView) findViewById(R.h.cos);
        this.rdo = (TextView) findViewById(R.h.cou);
        this.rdo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoiseDetectMaskView rdr;

            {
                this.rdr = r1;
            }

            public final void onClick(View view) {
                if (this.rdr.rdp != null) {
                    this.rdr.rdp.boK();
                }
            }
        });
        findViewById(R.h.caZ).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoiseDetectMaskView rdr;

            {
                this.rdr = r1;
            }

            public final void onClick(View view) {
                if (this.rdr.rdq != null) {
                    this.rdr.rdq.boJ();
                }
            }
        });
    }
}
