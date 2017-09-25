package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View lmQ = null;
    private View nsQ = null;

    public enum a {
        Chatromm,
        ContactLabel,
        ContactIpCall
    }

    public b(Context context, final a aVar) {
        super(context);
        this.context = context;
        View.inflate(getContext(), R.i.cTG, this);
        this.lmQ = findViewById(R.h.bGr);
        this.nsQ = this.lmQ.findViewById(R.h.bnL);
        LayoutParams layoutParams = this.nsQ.getLayoutParams();
        layoutParams.height = (int) (((float) com.tencent.mm.bg.a.U(this.context, R.f.aWM)) * com.tencent.mm.bg.a.dL(this.context));
        this.nsQ.setLayoutParams(layoutParams);
        this.contentView = (TextView) this.nsQ.findViewById(R.h.bnN);
        this.lmQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b vVO;

            public final void onClick(View view) {
                switch (aVar) {
                    case Chatromm:
                        Intent intent = new Intent();
                        intent.setClassName(this.vVO.context, "com.tencent.mm.ui.contact.ChatroomContactUI");
                        this.vVO.context.startActivity(intent);
                        return;
                    case ContactLabel:
                        d.b(this.vVO.context, "label", ".ui.ContactLabelManagerUI", new Intent());
                        return;
                    case ContactIpCall:
                        d.b(this.vVO.context, "ipcall", ".ui.IPCallAddressUI", new Intent());
                        return;
                    default:
                        w.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", aVar);
                        return;
                }
            }
        });
        this.nsQ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b vVO;

            {
                this.vVO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.vVO.context instanceof MMActivity) {
                    ((MMActivity) this.vVO.context).aHf();
                }
                return false;
            }
        });
        ImageView imageView = (ImageView) ((MaskLayout) this.nsQ.findViewById(R.h.bnM)).view;
        switch (aVar) {
            case Chatromm:
                this.contentView.setText(R.l.dCs);
                com.tencent.mm.x.d.a(getContext(), imageView, R.k.dwp);
                return;
            case ContactLabel:
                this.contentView.setText(R.l.dCv);
                com.tencent.mm.x.d.a(getContext(), imageView, R.k.dwq);
                return;
            case ContactIpCall:
                this.nsQ.setBackgroundResource(R.g.beo);
                this.contentView.setText(R.l.dCu);
                com.tencent.mm.x.d.a(getContext(), imageView, R.k.dws);
                return;
            default:
                return;
        }
    }

    public final void setVisible(boolean z) {
        this.lmQ.setVisibility(z ? 0 : 8);
    }
}
