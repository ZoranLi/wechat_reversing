package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private LinkedList<rj> kXy = new LinkedList();
    private Context mContext;
    private Animation mUG;
    private Animation oxE;
    private Animation oxF;
    private HashMap<String, Boolean> oxG = new HashMap();

    class a {
        TextView iUO;
        ImageView jki;
        final /* synthetic */ a oxH;

        public a(a aVar, View view) {
            this.oxH = aVar;
            this.jki = (ImageView) view.findViewById(R.h.bNO);
            this.iUO = (TextView) view.findViewById(R.h.bNX);
        }
    }

    public a(Context context) {
        this.mContext = context;
        this.mUG = AnimationUtils.loadAnimation(this.mContext, R.a.aQJ);
        this.oxF = AnimationUtils.loadAnimation(this.mContext, R.a.aQJ);
        this.oxE = AnimationUtils.loadAnimation(this.mContext, R.a.aQK);
        this.mUG.setInterpolator(new AccelerateDecelerateInterpolator());
        this.oxF.setInterpolator(new AccelerateInterpolator());
        this.oxE.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mUG.setDuration(300);
        this.oxF.setDuration(1000);
        this.oxE.setDuration(1000);
    }

    public final void H(LinkedList<rj> linkedList) {
        this.kXy = linkedList;
        if (this.kXy != null && this.kXy.size() > 0) {
            int size = this.kXy.size();
            for (int i = 0; i < size; i++) {
                String a = a((rj) this.kXy.get(i));
                if (!this.oxG.containsKey(a)) {
                    this.oxG.put(a, Boolean.valueOf(false));
                }
            }
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.kXy == null ? 1 : this.kXy.size() + 1;
    }

    public final Object getItem(int i) {
        if (this.kXy != null && i < this.kXy.size()) {
            return this.kXy.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.dcg, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        rj rjVar = (rj) getItem(i);
        if (rjVar != null) {
            if (bg.mA(rjVar.jOp)) {
                aVar.iUO.setText(rjVar.jNj);
            } else {
                aVar.iUO.setText(rjVar.jOp);
            }
            if (bg.mA(rjVar.jNj)) {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.jki, rjVar.twU);
            } else {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.jki, rjVar.jNj);
            }
            String a = a(rjVar);
            view.clearAnimation();
            if (this.oxG.containsKey(a) && !((Boolean) this.oxG.get(a)).booleanValue()) {
                view.startAnimation(this.mUG);
                this.oxG.put(a, Boolean.valueOf(true));
            }
        }
        if (i + 1 == getCount()) {
            aVar.iUO.setText("");
            aVar.jki.setImageResource(R.g.bbB);
            if (view != null) {
                this.oxF.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a oxH;

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        view.startAnimation(this.oxH.oxE);
                    }
                });
                this.oxE.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a oxH;

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        view.startAnimation(this.oxH.oxF);
                    }
                });
                view.startAnimation(this.oxF);
            }
        }
        return view;
    }

    private static String a(rj rjVar) {
        if (rjVar == null) {
            return "";
        }
        if (bg.mA(rjVar.jNj)) {
            return rjVar.twU;
        }
        return rjVar.jNj;
    }
}
