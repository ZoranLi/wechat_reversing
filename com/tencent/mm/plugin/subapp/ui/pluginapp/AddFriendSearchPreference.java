package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference extends Preference {
    private Context context;
    private String qUM;
    String qUN;
    private OnClickListener qUO;
    public OnClickListener qUP;
    public a qUQ;
    public TextView qUR;
    private TextView qUS;
    private OnClickListener qUT;

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qUM = "";
        this.qUN = "";
        this.qUO = null;
        this.qUP = null;
        this.qUQ = null;
        this.qUR = null;
        this.qUS = null;
        this.qUT = new OnClickListener(this) {
            final /* synthetic */ AddFriendSearchPreference qUU;

            {
                this.qUU = r1;
            }

            public final void onClick(View view) {
                if (this.qUU.qUQ != null && this.qUU.qUR != null && this.qUU.qUR.getText() != null) {
                    this.qUU.qUR.getText().toString();
                }
            }
        };
        this.context = context;
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.diF, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), 0, viewGroup2.getPaddingBottom());
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        view.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AddFriendSearchPreference qUU;

            {
                this.qUU = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.qUR = (TextView) view.findViewById(R.h.bKP);
        this.qUS = (TextView) view.findViewById(R.h.cCD);
        this.qUS.setText(this.qUN);
        if (this.qUP != null) {
            this.qUS.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ AddFriendSearchPreference qUU;

                {
                    this.qUU = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        this.qUU.qUP.onClick(view);
                    }
                    return true;
                }
            });
        }
        if (this.qUQ != null) {
            Button button = (Button) view.findViewById(R.h.button);
            button.setOnClickListener(this.qUT);
            button.setVisibility(0);
        }
    }
}
