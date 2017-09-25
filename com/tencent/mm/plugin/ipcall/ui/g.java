package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.d.m;
import com.tencent.mm.plugin.ipcall.a.e;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.k.a.b.b;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends Dialog {
    View khv;
    private int lJn = R.e.aTQ;
    private int lJo = R.g.bfc;
    private ScrollView liX;
    private Context mContext;
    private ae mHandler = new ae();
    private ArrayList<a> mItemList;
    private OnClickListener mOnClickListener = new OnClickListener(this) {
        final /* synthetic */ g mUK;

        {
            this.mUK = r1;
        }

        public final void onClick(View view) {
            if (view == this.mUK.mUq) {
                this.mUK.oq(1);
            } else if (view == this.mUK.mUr) {
                this.mUK.oq(2);
            } else if (view == this.mUK.mUs) {
                this.mUK.oq(3);
            }
        }
    };
    private Button mUB;
    private PasterEditText mUC;
    private Button mUD;
    private Button mUE;
    private TextView mUF;
    private Animation mUG;
    private int mUH = R.g.bfb;
    private int mUI = R.e.aWv;
    private int mUl = 0;
    private int mUm;
    private long mUn;
    private LinearLayout mUo;
    private LinearLayout mUp;
    private RelativeLayout mUq;
    private RelativeLayout mUr;
    private RelativeLayout mUs;
    private ImageView mUt;
    private ImageView mUu;
    private ImageView mUv;
    private int mUw;
    private FrameLayout mUx;
    private FlowLayout mUy;
    private Button mUz;
    private Activity qb;
    private CharSequence uI;

    public static class a {
        public String mQY;
        public String mQZ;
        public boolean mUL;
    }

    static /* synthetic */ void a(g gVar, TextView textView) {
        a aVar = (a) textView.getTag();
        textView.setTextSize(0, gVar.getContext().getResources().getDimension(R.f.aZS) * com.tencent.mm.bg.a.dI(gVar.getContext()));
        if (aVar.mUL) {
            textView.setBackgroundResource(gVar.mUH);
            textView.setTextColor(gVar.mContext.getResources().getColor(gVar.mUI));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        textView.setBackgroundResource(gVar.lJo);
        textView.setTextColor(gVar.mContext.getResources().getColor(gVar.lJn));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    static /* synthetic */ void g(g gVar) {
        ap.vd().a(new m(gVar.mUm, gVar.mUw, gVar.os(gVar.mUw)), 0);
        if (gVar.mUw == 3) {
            gVar.ot(2);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new Runnable(gVar) {
            final /* synthetic */ g mUK;

            {
                this.mUK = r1;
            }

            public final void run() {
                this.mUK.dismiss();
            }
        }, 1800);
        com.tencent.mm.ui.snackbar.a.e(gVar.qb, gVar.mContext.getString(R.l.euG));
        d.a(1, -1, gVar.mUw, gVar.or(gVar.mUw), 0, -1, -1, gVar.mUm, gVar.mUn);
    }

    public g(Activity activity, Context context, int i, long j) {
        CharSequence format;
        super(context, R.m.foK);
        setCancelable(false);
        this.mContext = context;
        this.mUm = i;
        this.mUn = j;
        this.qb = activity;
        this.khv = View.inflate(this.mContext, R.i.dgm, null);
        this.mUo = (LinearLayout) this.khv.findViewById(R.h.caR);
        this.mUp = (LinearLayout) this.khv.findViewById(R.h.caS);
        this.mUG = AnimationUtils.loadAnimation(ab.getContext(), R.a.aQJ);
        this.mUG.setDuration(200);
        this.mUG.setStartOffset(100);
        aFf();
        this.mUq = (RelativeLayout) this.khv.findViewById(R.h.caT);
        this.mUr = (RelativeLayout) this.khv.findViewById(R.h.caU);
        this.mUs = (RelativeLayout) this.khv.findViewById(R.h.caV);
        this.mUq.setOnClickListener(this.mOnClickListener);
        this.mUr.setOnClickListener(this.mOnClickListener);
        this.mUs.setOnClickListener(this.mOnClickListener);
        this.mUt = (ImageView) this.khv.findViewById(R.h.bXo);
        this.mUu = (ImageView) this.khv.findViewById(R.h.bXp);
        this.mUv = (ImageView) this.khv.findViewById(R.h.bXq);
        this.mUw = 0;
        oq(this.mUw);
        this.mUD = (Button) this.khv.findViewById(R.h.bXW);
        this.mUE = (Button) this.khv.findViewById(R.h.bXX);
        this.mUF = (TextView) this.khv.findViewById(R.h.bXY);
        if (c.aFz() != null) {
            format = String.format(this.mContext.getString(R.l.evf), new Object[]{r0.tIO});
        } else {
            format = null;
        }
        if (bg.mA(format)) {
            this.mUF.setVisibility(4);
        } else {
            this.mUF.setVisibility(0);
            this.mUF.setText(format);
        }
        this.mUD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g mUK;

            {
                this.mUK = r1;
            }

            public final void onClick(View view) {
                this.mUK.dismiss();
                d.a(1, -1, this.mUK.mUw, this.mUK.or(this.mUK.mUw), 1, -1, 1, this.mUK.mUm, this.mUK.mUn);
            }
        });
        this.mUE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g mUK;

            {
                this.mUK = r1;
            }

            public final void onClick(View view) {
                this.mUK.dismiss();
                Intent intent = new Intent();
                intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
                intent.setClass(this.mUK.mContext, IPCallShareCouponCardUI.class);
                this.mUK.mContext.startActivity(intent);
                d.a(1, -1, this.mUK.mUw, this.mUK.or(this.mUK.mUw), 1, 1, -1, this.mUK.mUm, this.mUK.mUn);
            }
        });
        this.liX = (ScrollView) this.khv.findViewById(R.h.bPr);
        final View childAt = ((ViewGroup) this.qb.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ g mUK;

            public final void onGlobalLayout() {
                Rect rect = new Rect();
                childAt.getWindowVisibleDisplayFrame(rect);
                if (childAt.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                    g gVar = this.mUK;
                    gVar.khv.postDelayed(new Runnable(gVar) {
                        final /* synthetic */ g mUK;

                        {
                            this.mUK = r1;
                        }

                        public final void run() {
                            this.mUK.liX.fullScroll(130);
                        }
                    }, 100);
                }
            }
        });
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.khv);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        ot(0);
    }

    private void oq(int i) {
        this.mUw = i;
        if (i == 0) {
            this.mUt.setVisibility(4);
            this.mUu.setVisibility(4);
            this.mUv.setVisibility(4);
            this.mUB.setEnabled(false);
            ot(0);
        } else if (i == 1) {
            this.mUt.setVisibility(0);
            this.mUu.setVisibility(4);
            this.mUv.setVisibility(4);
            this.mUB.setEnabled(true);
            ot(1);
        } else if (i == 2) {
            this.mUt.setVisibility(0);
            this.mUu.setVisibility(0);
            this.mUv.setVisibility(4);
            this.mUB.setEnabled(true);
            ot(1);
        } else if (i == 3) {
            this.mUt.setVisibility(0);
            this.mUu.setVisibility(0);
            this.mUv.setVisibility(0);
            this.mUB.setEnabled(true);
            ot(0);
        }
    }

    private void aFf() {
        String dF;
        f fVar;
        this.mUx = (FrameLayout) this.khv.findViewById(R.h.bQj);
        this.mUy = (FlowLayout) this.khv.findViewById(R.h.bQi);
        this.mUz = (Button) this.khv.findViewById(R.h.bEx);
        this.mUB = (Button) this.khv.findViewById(R.h.bEy);
        this.mUC = (PasterEditText) this.khv.findViewById(R.h.bED);
        this.mUz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g mUK;

            {
                this.mUK = r1;
            }

            public final void onClick(View view) {
                this.mUK.dismiss();
                int i = -1;
                d.a(-1, 1, i, "", 0, -1, -1, this.mUK.mUm, this.mUK.mUn);
            }
        });
        this.mUB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g mUK;

            {
                this.mUK = r1;
            }

            public final void onClick(View view) {
                g.g(this.mUK);
            }
        });
        e aEa = e.aEa();
        if (aEa.mML == null) {
            w.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            b bVar = b.c.sFE;
            dF = b.dF(39, 1);
            if (bg.mA(dF)) {
                w.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] d = com.tencent.mm.a.e.d(dF, 0, -1);
                if (d != null) {
                    aEa.av(d);
                } else {
                    w.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (aEa.mML != null) {
            String str;
            dF = v.e(ab.getContext().getSharedPreferences(ab.bIX(), 0));
            if (!"language_default".equalsIgnoreCase(dF) || Locale.getDefault() == null) {
                str = dF;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = aEa.mML.iterator();
            while (it.hasNext()) {
                fVar = (f) it.next();
                if (str.equalsIgnoreCase(fVar.mRa)) {
                    w.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(aEa.mML.size())});
                    break;
                }
            }
            w.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(aEa.mML.size())});
        }
        fVar = null;
        if (fVar != null) {
            ArrayList arrayList = fVar.mRb;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.e eVar = (com.tencent.mm.plugin.ipcall.a.g.e) it2.next();
                a aVar = new a();
                aVar.mQY = eVar.mQY;
                aVar.mQZ = eVar.mQZ;
                aVar.mUL = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a aVar2 = (a) it3.next();
                FlowLayout flowLayout = this.mUy;
                View textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(R.f.aZS) * com.tencent.mm.bg.a.dI(getContext()));
                textView.setBackgroundResource(this.lJo);
                textView.setTextColor(this.mContext.getResources().getColor(this.lJn));
                textView.setTag(aVar2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(aVar2.mQZ);
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ g mUK;

                    {
                        this.mUK = r1;
                    }

                    public final void onClick(View view) {
                        a aVar = (a) view.getTag();
                        if (aVar.mUL) {
                            aVar.mUL = false;
                        } else {
                            aVar.mUL = true;
                        }
                        g.a(this.mUK, (TextView) view);
                    }
                });
                flowLayout.addView(textView);
            }
        }
    }

    private String or(int i) {
        String str = "";
        if (i == 3) {
            return "";
        }
        if (!bg.mA(this.mUC.getText().toString().trim())) {
            str = "0";
        }
        if (this.mItemList == null) {
            return str;
        }
        Iterator it = this.mItemList.iterator();
        String str2 = str;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.mUL) {
                str = str2;
            } else if (str2.equals("")) {
                str2 = aVar.mQY;
            } else {
                str = str2 + "_" + aVar.mQY;
            }
            str2 = str;
        }
        return str2;
    }

    private LinkedList<bly> os(int i) {
        LinkedList<bly> linkedList = new LinkedList();
        if (i == 3) {
            return linkedList;
        }
        String trim = this.mUC.getText().toString().trim();
        if (!bg.mA(trim)) {
            bly com_tencent_mm_protocal_c_bly = new bly();
            com_tencent_mm_protocal_c_bly.fxo = 0;
            com_tencent_mm_protocal_c_bly.opI = trim;
            linkedList.add(com_tencent_mm_protocal_c_bly);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.mUL) {
                    bly com_tencent_mm_protocal_c_bly2 = new bly();
                    try {
                        com_tencent_mm_protocal_c_bly2.fxo = bg.getInt(aVar.mQY, 0);
                        linkedList.add(com_tencent_mm_protocal_c_bly2);
                    } catch (NumberFormatException e) {
                        w.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + aVar.mQY);
                    }
                }
            }
        }
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uI = charSequence;
        } else {
            this.uI = null;
        }
    }

    public final void show() {
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void ot(int i) {
        if (i == 0) {
            this.mUo.setVisibility(0);
            this.mUp.setVisibility(4);
            if (this.mUl == 1) {
                ((LayoutParams) this.mUx.getLayoutParams()).height = 0;
                this.mUx.requestLayout();
            }
            bg.cX(this.khv);
        } else if (i == 1) {
            this.mUo.setVisibility(0);
            this.mUp.setVisibility(4);
            if (this.mUl == 0) {
                ((LayoutParams) this.mUx.getLayoutParams()).height = -2;
                this.mUx.requestLayout();
                this.mUx.startAnimation(this.mUG);
            }
        } else if (i == 2) {
            this.mUo.setVisibility(4);
            this.mUp.setVisibility(0);
            bg.cX(this.khv);
        }
        this.mUl = i;
    }
}
