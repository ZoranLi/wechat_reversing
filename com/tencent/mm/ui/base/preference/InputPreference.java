package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.s.a.g;

public class InputPreference extends Preference {
    private String qUN;
    public a qUQ;
    private OnClickListener qUT;
    private String vrf;
    public EditText vrg;
    private Button vrh;
    private OnEditorActionListener vri;

    public interface a {
    }

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qUT = new OnClickListener(this) {
            final /* synthetic */ InputPreference vrj;

            {
                this.vrj = r1;
            }

            public final void onClick(View view) {
                if (this.vrj.qUQ != null && this.vrj.vrg != null && this.vrj.vrg.getText() != null) {
                    this.vrj.vrg.getText().toString();
                }
            }
        };
        this.vri = new OnEditorActionListener(this) {
            final /* synthetic */ InputPreference vrj;

            {
                this.vrj = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.vrj.qUQ == null || this.vrj.vrg == null) {
                    return false;
                }
                if (this.vrj.vrg.getText() != null) {
                    this.vrj.vrg.getText().toString();
                }
                return true;
            }
        };
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.vrg = (EditText) view.findViewById(g.bKP);
        this.vrg.setHint(this.qUN);
        this.vrg.setOnEditorActionListener(this.vri);
        this.vrh = (Button) view.findViewById(g.button);
        this.vrh.setText(this.vrf);
        this.vrh.setOnClickListener(this.qUT);
    }
}
