package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.MMHorList;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private final int lMV = com.tencent.mm.bg.a.fromDPToPix(null, 58);
    private ae mHandler;
    private String nek;
    private final int qZh = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    private final int qZi = 5;
    private MMHorList qZj;
    a qZk;
    private aj qZl;

    private static class a extends BaseAdapter {
        private Context mContext;
        String nek;
        List<String> qZo = new LinkedList();

        class a {
            public ImageView ipv;
            public TextView jWd;
            final /* synthetic */ a qZp;

            a(a aVar) {
                this.qZp = aVar;
            }
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return this.qZo.size();
        }

        public final Object getItem(int i) {
            return this.qZo.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String str = (String) this.qZo.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dpa, null);
                a aVar2 = new a(this);
                aVar2.ipv = (ImageView) view.findViewById(R.h.bZO);
                aVar2.jWd = (TextView) view.findViewById(R.h.cKm);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ipv.setBackgroundResource(str.equals(this.nek) ? R.g.bkt : 0);
            aVar.jWd.setVisibility(8);
            b.b(aVar.ipv, str, true);
            return view;
        }
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        inflate(getContext(), R.i.doZ, this);
        this.qZj = (MMHorList) findViewById(R.h.bWp);
        this.qZj.vkI = true;
        this.qZj.vkH = true;
        this.qZj.vkJ = this.lMV;
        this.qZk = new a(getContext());
        this.qZj.setAdapter(this.qZk);
        this.mHandler = new ae(Looper.getMainLooper());
        this.qZj.vks = new com.tencent.mm.ui.base.MMHorList.a(this) {
            final /* synthetic */ TalkRoomAvatarsFrame qZm;

            {
                this.qZm = r1;
            }

            public final void bnZ() {
                this.qZm.qZl.KH();
            }

            public final void boa() {
                this.qZm.qZl.v(2000, 2000);
            }

            public final void aIp() {
                this.qZm.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qZn;

                    {
                        this.qZn = r1;
                    }

                    public final void run() {
                        this.qZn.qZm.qZk.notifyDataSetChanged();
                    }
                });
            }
        };
        this.qZl = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ TalkRoomAvatarsFrame qZm;

            {
                this.qZm = r1;
            }

            public final boolean oQ() {
                this.qZm.aFP();
                return false;
            }
        }, false);
    }

    public final void Ht(String str) {
        if (this.qZj != null) {
            if (!bg.mA(this.nek) || !bg.mA(str)) {
                if (bg.mA(this.nek) || !this.nek.equals(str)) {
                    this.nek = str;
                    aFP();
                }
            }
        }
    }

    private void aFP() {
        this.qZk.nek = this.nek;
        if (bg.mA(this.nek)) {
            this.qZk.notifyDataSetChanged();
        } else if (!this.qZj.nUI) {
            a aVar = this.qZk;
            int indexOf = aVar.qZo.indexOf(this.nek) * this.lMV;
            int i = this.qZj.vkv;
            if (indexOf < i) {
                this.qZj.Aj(indexOf);
            } else if (indexOf > i + (this.lMV * 4)) {
                this.qZj.Aj(indexOf - (this.lMV * 4));
            } else {
                this.qZk.notifyDataSetChanged();
            }
        }
    }
}
