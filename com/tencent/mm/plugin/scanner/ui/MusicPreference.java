package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    public boolean kAq;
    private View mView;
    private OnClickListener oPX;
    public String oVO;
    public String oVP;
    public String oVQ;
    public ImageButton oYS;
    public a oYT;

    public interface a {
        void a(MusicPreference musicPreference);
    }

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.oYS = null;
        this.oVO = "";
        this.oVP = "";
        this.oVQ = "";
        setLayoutResource(R.i.djh);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    public final void gI(boolean z) {
        this.kAq = z;
        if (this.oYS == null) {
            return;
        }
        if (z) {
            this.oYS.setImageResource(R.g.bix);
        } else {
            this.oYS.setImageResource(R.g.biw);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.oPX == null) {
            this.oPX = new OnClickListener(this) {
                final /* synthetic */ MusicPreference oYU;

                {
                    this.oYU = r1;
                }

                public final void onClick(View view) {
                    if (this.oYU.oYT != null && view.getId() == R.h.csn) {
                        if (this.oYU.kAq) {
                            this.oYU.kAq = false;
                            this.oYU.oYS.setImageResource(R.g.biw);
                        } else {
                            this.oYU.kAq = true;
                            this.oYU.oYS.setImageResource(R.g.bix);
                        }
                        this.oYU.oYT.a(this.oYU);
                    }
                }
            };
        }
        this.oYS = (ImageButton) view.findViewById(R.h.csn);
        this.oYS.setOnClickListener(this.oPX);
        if (this.kAq) {
            this.oYS.setImageResource(R.g.bix);
        } else {
            this.oYS.setImageResource(R.g.biw);
        }
    }
}
