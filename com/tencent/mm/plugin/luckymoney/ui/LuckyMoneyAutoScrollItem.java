package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> nqD;
    private int jon;
    private Context mContext;
    private CountDownTimer nqA;
    private int nqB;
    b nqC;
    private a nqx;
    private long nqy;
    int nqz;

    private class a extends BaseAdapter {
        final /* synthetic */ LuckyMoneyAutoScrollItem nqF;

        class a {
            ImageView nqH;
            final /* synthetic */ a nqI;

            a(a aVar) {
                this.nqI = aVar;
            }
        }

        private a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
            this.nqF = luckyMoneyAutoScrollItem;
        }

        public final int getCount() {
            return 2147483646;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i % 10);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.nqF.mContext).inflate(R.i.dgX, null);
                a aVar2 = new a(this);
                aVar2.nqH = (ImageView) view.findViewById(R.h.cHG);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.nqH.setImageResource(((Integer) LuckyMoneyAutoScrollItem.nqD.get(i % 10)).intValue());
            return view;
        }
    }

    interface b {
        void aIp();
    }

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.jon + 1;
        luckyMoneyAutoScrollItem.jon = i;
        return i;
    }

    static {
        SparseArray sparseArray = new SparseArray();
        nqD = sparseArray;
        sparseArray.put(0, Integer.valueOf(R.g.bhE));
        nqD.put(1, Integer.valueOf(R.g.bhF));
        nqD.put(2, Integer.valueOf(R.g.bhG));
        nqD.put(3, Integer.valueOf(R.g.bhH));
        nqD.put(4, Integer.valueOf(R.g.bhI));
        nqD.put(5, Integer.valueOf(R.g.bhJ));
        nqD.put(6, Integer.valueOf(R.g.bhK));
        nqD.put(7, Integer.valueOf(R.g.bhL));
        nqD.put(8, Integer.valueOf(R.g.bhM));
        nqD.put(9, Integer.valueOf(R.g.bhN));
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.nqx = null;
        this.nqy = 900;
        this.nqz = 0;
        this.jon = 0;
        this.nqC = null;
        this.mContext = context;
        this.nqx = new a();
        setAdapter(this.nqx);
        this.nqB = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        w.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", new Object[]{Integer.valueOf(this.nqB)});
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void aIo() {
        if (this.nqA != null) {
            this.nqA.cancel();
        }
        final long j = ((long) (this.nqz * 50)) + this.nqy;
        af.v(new Runnable(this) {
            final /* synthetic */ LuckyMoneyAutoScrollItem nqF;

            public final void run() {
                this.nqF.nqA = new CountDownTimer(this, j) {
                    final /* synthetic */ AnonymousClass1 nqG;

                    public final void onTick(long j) {
                        this.nqG.nqF.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(this.nqG.nqF));
                    }

                    public final void onFinish() {
                        if (this.nqG.nqF.nqC != null) {
                            this.nqG.nqF.nqC.aIp();
                        }
                    }
                }.start();
            }
        });
    }
}
