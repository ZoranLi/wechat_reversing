package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    public boolean uVA = false;
    public com.tencent.mm.al.b uVB = new com.tencent.mm.al.b();
    public LinearLayout uVo;
    public View uVp;
    public TextView uVq;
    public TextView uVr;
    public TextView uVs;
    public String uVt;
    public String uVu;
    public boolean uVv;
    public int uVw = b.uVG;
    public a uVx;
    private final int uVy = 6;
    public LinearLayout uVz;

    class a {
        private Button lzR;
        TextView titleView;
        final /* synthetic */ MultiTalkRoomPopupNav uVC;
        LinearLayout uVD;

        public a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z) {
            this.uVC = multiTalkRoomPopupNav;
            this.lzR = (Button) multiTalkRoomPopupNav.findViewById(R.h.clE);
            this.titleView = (TextView) multiTalkRoomPopupNav.findViewById(R.h.clP);
            this.uVD = (LinearLayout) multiTalkRoomPopupNav.findViewById(R.h.clG);
            if (z) {
                this.uVD.setBackgroundResource(R.g.bhn);
                this.lzR.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.aVf));
                return;
            }
            this.uVD.setBackgroundResource(R.g.bhm);
            this.lzR.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.aTe));
        }

        public final void close() {
            this.uVD.setVisibility(8);
        }
    }

    enum b {
        ;

        static {
            uVE = 1;
            uVF = 2;
            uVG = 3;
            uVH = new int[]{uVE, uVF, uVG};
        }
    }

    static /* synthetic */ void SJ(String str) {
        w.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        com.tencent.mm.pluginsdk.l.a.sBz.Bh(str);
        w.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!com.tencent.mm.pluginsdk.l.a.sBz.Bf(str)) {
            w.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:" + str);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        if (multiTalkRoomPopupNav.uVt == null || multiTalkRoomPopupNav.uVu == null) {
            w.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.uVt + ",currentSenderUserName:" + multiTalkRoomPopupNav.uVu);
        } else if (!multiTalkRoomPopupNav.uVt.toLowerCase().endsWith("@chatroom") || multiTalkRoomPopupNav.uVv) {
            String str = multiTalkRoomPopupNav.uVt;
            if (com.tencent.mm.pluginsdk.l.a.sBz == null || !com.tencent.mm.pluginsdk.l.a.sBz.AZ(str)) {
                w.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
                g.b(multiTalkRoomPopupNav.getContext(), ab.getContext().getString(R.l.eCt), null, true);
                multiTalkRoomPopupNav.bQx();
                r3 = com.tencent.mm.plugin.report.service.g.oUh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.uVt;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
                r3.i(13945, r5);
                return;
            }
            List Bb = com.tencent.mm.pluginsdk.l.a.sBz.Bb(str);
            if (Bb.size() == 0) {
                w.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                g.b(multiTalkRoomPopupNav.getContext(), ab.getContext().getString(R.l.eCt), null, true);
                multiTalkRoomPopupNav.bQx();
                r3 = com.tencent.mm.plugin.report.service.g.oUh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.uVt;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
                r3.i(13945, r5);
                return;
            }
            if (Bb.size() == 1) {
                w.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
            }
            if (multiTalkRoomPopupNav.uVw == b.uVF) {
                multiTalkRoomPopupNav.uVA = true;
                Intent intent = new Intent();
                intent.putExtra("enterMainUiSource", 2);
                intent.putExtra("enterMainUiWxGroupId", str);
                d.b(ab.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                r3 = com.tencent.mm.plugin.report.service.g.oUh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(0);
                r5[4] = multiTalkRoomPopupNav.uVt;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
                r3.i(13945, r5);
            } else if (multiTalkRoomPopupNav.uVw == b.uVE) {
                if (com.tencent.mm.pluginsdk.l.a.sBz.cT(str, multiTalkRoomPopupNav.uVu) != null) {
                    r4 = ab.getContext().getString(R.l.eeu, new Object[]{com.tencent.mm.pluginsdk.l.a.sBz.eK(com.tencent.mm.pluginsdk.l.a.sBz.cT(str, multiTalkRoomPopupNav.uVu))});
                    r5 = k(Bb, multiTalkRoomPopupNav.uVu);
                    Bb.size();
                    multiTalkRoomPopupNav.d(r4, r5, str);
                }
                r3 = com.tencent.mm.plugin.report.service.g.oUh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(0);
                r5[4] = multiTalkRoomPopupNav.uVt;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
                r3.i(13945, r5);
            } else if (com.tencent.mm.pluginsdk.l.a.sBz.aNb()) {
                g.b(multiTalkRoomPopupNav.getContext(), ab.getContext().getString(R.l.eCd), null, true);
                r3 = com.tencent.mm.plugin.report.service.g.oUh;
                r5 = new Object[7];
                r5[0] = Integer.valueOf(4);
                r5[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
                r5[2] = Integer.valueOf(0);
                r5[3] = Integer.valueOf(1);
                r5[4] = multiTalkRoomPopupNav.uVt;
                r5[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
                r5[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
                r3.i(13945, r5);
            } else if (Bb.size() >= 9) {
                g.b(multiTalkRoomPopupNav.getContext(), ab.getContext().getString(R.l.eCf, new Object[]{Integer.valueOf(9)}), null, true);
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                if (multiTalkRoomPopupNav.uVw == b.uVE) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Integer.valueOf(1);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.uVt;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
                gVar.i(13945, objArr);
            } else {
                r4 = ab.getContext().getString(R.l.eCx);
                r5 = k(Bb, "");
                Bb.size();
                multiTalkRoomPopupNav.d(r4, r5, str);
                com.tencent.mm.plugin.report.service.g.oUh.i(13945, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.uVt, Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId), Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey));
            }
        } else {
            g.b(multiTalkRoomPopupNav.getContext(), ab.getContext().getString(R.l.eCk), null, true);
            multiTalkRoomPopupNav.bQx();
            com.tencent.mm.pluginsdk.l.a.sBz.gR(multiTalkRoomPopupNav.uVt);
            r3 = com.tencent.mm.plugin.report.service.g.oUh;
            r5 = new Object[7];
            r5[0] = Integer.valueOf(4);
            r5[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
            r5[2] = Integer.valueOf(0);
            r5[3] = Integer.valueOf(1);
            r5[4] = multiTalkRoomPopupNav.uVt;
            r5[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
            r5[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
            r3.i(13945, r5);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        w.i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:" + str);
        if (com.tencent.mm.pluginsdk.l.a.sBz.Bg(str)) {
            com.tencent.mm.pluginsdk.l.a.sBz.Be(str);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = multiTalkRoomPopupNav.uVt;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
            gVar.i(13945, objArr);
            return;
        }
        w.e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!" + str);
        Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eBS), 0).show();
        gVar = com.tencent.mm.plugin.report.service.g.oUh;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.uVw == b.uVE ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.uVt;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.uVB.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.uVB.field_roomKey);
        gVar.i(13945, objArr);
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    private void KC() {
        inflate(getContext(), R.i.djJ, this);
        this.uVo = (LinearLayout) findViewById(R.h.clN);
        this.uVp = findViewById(R.h.clM);
        this.uVq = (TextView) findViewById(R.h.clQ);
        this.uVr = (TextView) findViewById(R.h.clR);
        this.uVs = (TextView) findViewById(R.h.clS);
        this.uVz = (LinearLayout) findViewById(R.h.clI);
        this.uVo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MultiTalkRoomPopupNav uVC;

            {
                this.uVC = r1;
            }

            public final void onClick(View view) {
                if (com.tencent.mm.pluginsdk.l.a.sBy != null && com.tencent.mm.pluginsdk.l.a.sBz.aJ(this.uVC.getContext())) {
                    w.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
                } else if (com.tencent.mm.pluginsdk.l.a.sBy == null || !com.tencent.mm.pluginsdk.l.a.sBy.aGu()) {
                    MultiTalkRoomPopupNav.a(this.uVC);
                } else {
                    Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.esy), 0).show();
                    w.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
                }
            }
        });
    }

    public final void SI(String str) {
        this.uVp.setBackgroundResource(R.g.bhm);
        this.uVq.setTextColor(getResources().getColor(R.e.aVf));
        this.uVq.setText(str);
        if (this.uVz == null || this.uVz.getVisibility() != 0) {
            this.uVq.setVisibility(0);
            this.uVs.setVisibility(8);
            this.uVr.setVisibility(8);
            this.uVz.setVisibility(8);
        }
    }

    public final void bQx() {
        this.uVA = false;
        setVisibility(8);
        if (this.uVx != null) {
            this.uVx.close();
        }
    }

    private void d(String str, List<String> list, final String str2) {
        boolean z;
        this.uVp.setVisibility(8);
        this.uVo.setVisibility(8);
        if (this.uVw == b.uVE) {
            z = true;
        } else {
            z = false;
        }
        this.uVx = new a(this, z);
        if (com.tencent.mm.pluginsdk.l.a.sBz != null) {
            a aVar = this.uVx;
            OnClickListener anonymousClass2 = new OnClickListener(this) {
                final /* synthetic */ MultiTalkRoomPopupNav uVC;

                public final void onClick(View view) {
                    int i = 0;
                    w.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
                    if (str2 != null) {
                        if (com.tencent.mm.pluginsdk.l.a.sBz.aNb()) {
                            w.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                            g.b(this.uVC.getContext(), ab.getContext().getString(R.l.eCd), null, true);
                            return;
                        }
                        List Bb = com.tencent.mm.pluginsdk.l.a.sBz.Bb(this.uVC.uVt);
                        if (Bb.size() == 1) {
                            MultiTalkRoomPopupNav.SJ(str2);
                            com.tencent.mm.plugin.report.service.g.oUh.i(13945, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), this.uVC.uVt, Integer.valueOf(this.uVC.uVB.field_roomId), Long.valueOf(this.uVC.uVB.field_roomKey));
                        } else if (Bb.size() >= 9) {
                            w.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + Bb.size());
                            g.b(this.uVC.getContext(), ab.getContext().getString(R.l.eCf, new Object[]{Integer.valueOf(9)}), null, true);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr = new Object[7];
                            objArr[0] = Integer.valueOf(1);
                            if (this.uVC.uVw == b.uVE) {
                                i = 1;
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = Integer.valueOf(1);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = this.uVC.uVt;
                            objArr[5] = Integer.valueOf(this.uVC.uVB.field_roomId);
                            objArr[6] = Long.valueOf(this.uVC.uVB.field_roomKey);
                            gVar.i(13945, objArr);
                            return;
                        } else if (com.tencent.mm.pluginsdk.l.a.sBz.aNa()) {
                            w.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                            g.b(this.uVC.getContext(), ab.getContext().getString(R.l.eCc), null, true);
                            com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Integer.valueOf(1);
                            objArr2[1] = Integer.valueOf(this.uVC.uVw == b.uVE ? 1 : 0);
                            objArr2[2] = Integer.valueOf(0);
                            objArr2[3] = Integer.valueOf(1);
                            objArr2[4] = this.uVC.uVt;
                            objArr2[5] = Integer.valueOf(this.uVC.uVB.field_roomId);
                            objArr2[6] = Long.valueOf(this.uVC.uVB.field_roomKey);
                            gVar2.i(13945, objArr2);
                            return;
                        } else {
                            MultiTalkRoomPopupNav.a(this.uVC, str2);
                        }
                    }
                    this.uVC.uVx.close();
                    this.uVC.uVo.setVisibility(0);
                    this.uVC.uVp.setVisibility(0);
                    this.uVC.uVz.setVisibility(8);
                }
            };
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ MultiTalkRoomPopupNav uVC;

                public final void onClick(View view) {
                    int i = 1;
                    w.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
                    if (this.uVC.uVw == b.uVE) {
                        w.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
                        boolean Bd = com.tencent.mm.pluginsdk.l.a.sBz.Bd(str2);
                        com.tencent.mm.pluginsdk.l.a.sBz.Be(str2);
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Integer.valueOf(0);
                        if (Bd) {
                            i = 0;
                        }
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = this.uVC.uVt;
                        objArr[5] = Integer.valueOf(this.uVC.uVB.field_roomId);
                        objArr[6] = Long.valueOf(this.uVC.uVB.field_roomKey);
                        gVar.i(13945, objArr);
                    } else {
                        com.tencent.mm.plugin.report.service.g.oUh.i(13945, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), this.uVC.uVt, Integer.valueOf(this.uVC.uVB.field_roomId), Long.valueOf(this.uVC.uVB.field_roomKey));
                    }
                    this.uVC.uVx.close();
                    this.uVC.uVo.setVisibility(0);
                    this.uVC.uVp.setVisibility(0);
                    this.uVC.uVz.setVisibility(8);
                }
            };
            aVar.titleView.setText(str);
            aVar.uVD.setVisibility(0);
            aVar.uVC.uVz.setVisibility(0);
            aVar.uVC.uVz.removeAllViews();
            for (String str3 : list) {
                View imageView = new ImageView(aVar.uVC.getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 26), com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                aVar.uVC.uVz.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3, 0.1f, false);
            }
            ((Button) aVar.uVC.findViewById(R.h.clF)).setOnClickListener(anonymousClass2);
            ((Button) aVar.uVC.findViewById(R.h.clE)).setOnClickListener(anonymousClass3);
        }
    }

    public final void cr(List<String> list) {
        if (this.uVz != null && this.uVz.getVisibility() == 0) {
            this.uVz.removeAllViews();
            for (String str : list) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 26), com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.uVz.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str, 0.1f, false);
            }
        }
    }

    public static List<String> k(List<String> list, String str) {
        List<String> arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        if (!(str == null || str == "")) {
            for (String str2 : list) {
                if (!(str2 == null || str2.equals(str))) {
                    arrayList2.add(str2);
                }
            }
            list = arrayList2;
        }
        for (String str22 : r5) {
            arrayList.add(str22);
        }
        return arrayList;
    }
}
