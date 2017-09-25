package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.mm.bm.a.e;
import com.tencent.mm.bm.a.f;
import java.util.ArrayList;

public final class a implements OnGlobalLayoutListener {
    private Button jMI;
    private Button jMJ;
    public View kQt = View.inflate(this.mContext, f.wAp, null);
    private Context mContext;
    private int wuM;
    private BottomSheetBehavior wuN;
    public c wzi = new c(this.mContext);
    private String[] wzj;
    public int wzk;
    public OptionPicker wzl = ((OptionPicker) this.kQt.findViewById(e.wAg));
    public a wzm;

    public interface a<T> {
        void c(boolean z, T t);
    }

    public a(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.wzj = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.wzl.h(this.wzj);
        this.wzk = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 288);
        this.jMI = (Button) this.kQt.findViewById(e.cpm);
        this.jMI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a wzn;

            {
                this.wzn = r1;
            }

            public final void onClick(View view) {
                Object obj;
                a aVar = this.wzn;
                if (this.wzn.wzl == null) {
                    obj = null;
                } else {
                    OptionPicker optionPicker = this.wzn.wzl;
                    obj = (optionPicker.jyz == null || optionPicker.jyz.length <= 0) ? "" : optionPicker.jyz[optionPicker.getValue()];
                }
                aVar.d(true, obj);
            }
        });
        this.jMJ = (Button) this.kQt.findViewById(e.bvK);
        this.jMJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a wzn;

            {
                this.wzn = r1;
            }

            public final void onClick(View view) {
                this.wzn.d(false, null);
            }
        });
        this.wzi.setContentView(this.kQt);
        this.wuM = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 350);
        this.wuN = BottomSheetBehavior.i((View) this.kQt.getParent());
        if (this.wuN != null) {
            this.wuN.g(this.wuM);
            this.wuN.fb = false;
        }
        this.wzi.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ a wzn;

            {
                this.wzn = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.wzn.wzi = null;
            }
        });
    }

    public final void onGlobalLayout() {
    }

    public final void d(boolean z, Object obj) {
        if (this.wzm != null) {
            this.wzm.c(z, obj);
        }
    }
}
