package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cq;
import com.tencent.mm.e.a.db;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dt;
import com.tencent.mm.e.a.dw;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.ej;
import com.tencent.mm.e.a.hm;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI extends MMActivity {
    boolean fHN = false;
    private com.tencent.mm.t.f.a fSU;
    String filePath = null;
    private long gLE;
    String iAS = null;
    private String lcw;
    private au qVX;
    private HorizontalListView sQG;
    private HorizontalListView vGM;
    private c vGN;
    private a vGO;
    private int vGP;
    private String vGQ = "";
    private RelativeLayout vGR;
    private RelativeLayout vGS;
    private TextView vGT;
    private Boolean vGU = Boolean.valueOf(false);
    private b vGV;
    private List<c> vGW = new ArrayList();
    private List<f> vGX = new ArrayList();
    private long vGY = 0;
    private boolean vGZ = true;
    boolean vHa = false;
    boolean vHb = true;
    int vHc = 2;
    int vHd = -1;
    private HashMap<String, View> vHe = new HashMap();
    HashMap<String, c> vHf = new HashMap();
    Map<Integer, View> vHg = new HashMap();
    Map<String, Integer> vHh = new HashMap();
    WXMediaMessage vHi = null;
    private com.tencent.mm.sdk.b.c vHj = new com.tencent.mm.sdk.b.c<dt>(this) {
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;

        {
            this.vHl = r2;
            this.usg = dt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return this.vHl.bUN().n((dt) bVar);
        }
    };
    private com.tencent.mm.sdk.b.c vHk = new com.tencent.mm.sdk.b.c<dx>(this) {
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;

        {
            this.vHl = r2;
            this.usg = dx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return this.vHl.bUN().n((dx) bVar);
        }
    };
    private boolean vxp;
    boolean vye = false;

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;
        final /* synthetic */ eq vHn;
        final /* synthetic */ c vHo;

        AnonymousClass7(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, eq eqVar, c cVar) {
            this.vHl = chattingSendDataToDeviceUI;
            this.vHn = eqVar;
            this.vHo = cVar;
        }

        public final void run() {
            this.vHn.vOJ.setVisibility(0);
            this.vHn.vHs.setTextColor(this.vHl.getResources().getColor(R.e.aVM));
            this.vHn.vHs.setText(this.vHl.getText(R.l.dVD));
            this.vHo.fHR = "send_data_sending";
        }
    }

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String seV;
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;
        final /* synthetic */ eq vHn;
        final /* synthetic */ c vHo;
        final /* synthetic */ int vHp;
        final /* synthetic */ int vHq;

        AnonymousClass8(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, int i, eq eqVar, String str, c cVar, int i2) {
            this.vHl = chattingSendDataToDeviceUI;
            this.vHp = i;
            this.vHn = eqVar;
            this.seV = str;
            this.vHo = cVar;
            this.vHq = i2;
        }

        public final void run() {
            int i = this.vHp + 1;
            while (true) {
                if (i >= 100) {
                    try {
                        this.vHl.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass8 vHr;

                            {
                                this.vHr = r1;
                            }

                            public final void run() {
                                this.vHr.vHn.vOJ.setProgress(0);
                                this.vHr.vHl.vHe.remove(this.vHr.seV);
                                this.vHr.vHn.vOJ.setVisibility(4);
                                this.vHr.vHn.vHs.setText(this.vHr.vHl.getText(R.l.dVB));
                                this.vHr.vHn.vHs.setTextColor(this.vHr.vHl.getResources().getColor(R.e.aVM));
                                this.vHr.vHo.fHR = "send_data_sucess";
                                this.vHr.vHo.progress = 0;
                                this.vHr.vHl.lU(4);
                            }
                        });
                        return;
                    } catch (Exception e) {
                        w.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", e);
                    }
                } else {
                    this.vHn.vOJ.setProgress(i);
                    i++;
                    Thread.sleep((long) this.vHq);
                }
            }
        }
    }

    private class a extends BaseAdapter {
        private Context context;
        private com.tencent.mm.ah.a.a.c lir;
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;
        private Map<String, c> vHt;
        private List<Map<String, c>> vyd = new ArrayList();

        public final /* synthetic */ Object getItem(int i) {
            return AT(i);
        }

        public a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, Context context) {
            this.vHl = chattingSendDataToDeviceUI;
            this.context = context;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJa = R.g.bhr;
            this.lir = aVar.Hg();
        }

        public final void ao(List<c> list) {
            this.vyd.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.vHt = new HashMap();
                this.vHt.put("hard_device_info", list.get(i));
                this.vyd.add(this.vHt);
            }
        }

        public final int getCount() {
            return this.vyd.size();
        }

        public final c AT(int i) {
            return (c) ((Map) this.vyd.get(i)).get("hard_device_info");
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            eq eqVar;
            View view2;
            c AT = AT(i);
            w.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", Integer.valueOf(i), Integer.valueOf(getCount()));
            if (this.vHl.vHg.get(Integer.valueOf(i)) == null) {
                eqVar = new eq();
                View inflate = View.inflate(viewGroup.getContext(), R.i.dnP, null);
                eqVar.llw = inflate.findViewById(R.h.bGr);
                eqVar.kzl = (TextView) inflate.findViewById(R.h.cml);
                eqVar.jbU = (ImageView) inflate.findViewById(R.h.bWv);
                eqVar.vHs = (TextView) inflate.findViewById(R.h.cCu);
                eqVar.vOJ = (SendDataToDeviceProgressBar) inflate.findViewById(R.h.cCt);
                eqVar.vOJ.setVisibility(4);
                this.vHl.vHg.put(Integer.valueOf(i), inflate);
                inflate.setTag(eqVar);
                view2 = inflate;
            } else {
                View view3 = (View) this.vHl.vHg.get(Integer.valueOf(i));
                eqVar = (eq) view3.getTag();
                view2 = view3;
            }
            this.vHl.vHh.put(AT.deviceID, Integer.valueOf(i));
            Object obj = AT.gMX;
            int i2 = 8;
            int i3 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            CharSequence stringBuffer2 = new StringBuffer();
            float dI = com.tencent.mm.bg.a.dI(this.context);
            if (dI == 1.125f || dI == 1.25f) {
                i2 = 6;
            } else if (dI == 1.375f || dI == 1.625f) {
                i2 = 5;
            }
            for (int i4 = 0; i4 < obj.length(); i4++) {
                int codePointAt = Character.codePointAt(obj, i4);
                String substring = obj.substring(i4, i4 + 1);
                if (codePointAt < 0 || codePointAt > 255) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 <= i2) {
                    stringBuffer = stringBuffer.append(substring);
                } else {
                    stringBuffer2 = stringBuffer2.append(substring);
                }
            }
            eqVar.kzl.setText(stringBuffer.toString());
            if (i3 >= i2) {
                eqVar.vHs.setText(stringBuffer2);
            }
            c cVar = null;
            if (this.vHl.vHf.containsKey(AT(i).deviceID)) {
                cVar = (c) this.vHl.vHf.get(AT(i).deviceID);
            }
            if (!(cVar == null || cVar.fHR == null)) {
                w.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", Integer.valueOf(i), cVar.fHR);
                if (cVar.fHR.equals("send_data_sending")) {
                    eqVar.vHs.setText(this.context.getString(R.l.dVD));
                    eqVar.vHs.setTextColor(this.context.getResources().getColor(R.e.aVM));
                    eqVar.vOJ.setProgress(AT.progress);
                    eqVar.vOJ.setVisibility(0);
                    final c cVar2 = (c) this.vHl.vHf.get(AT.deviceID);
                    final int i5 = cVar2.progress;
                    if (i5 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i5);
                    }
                    e.b(new Runnable(this) {
                        final /* synthetic */ a vHu;

                        public final void run() {
                            int i = i5 + 1;
                            while (this.vHu.vHl.vHb) {
                                if (i >= 100) {
                                    try {
                                        if (cVar2.fHR.equals("send_data_sucess")) {
                                            this.vHu.vHl.runOnUiThread(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 vHv;

                                                {
                                                    this.vHv = r1;
                                                }

                                                public final void run() {
                                                    eqVar.vOJ.setProgress(0);
                                                    eqVar.vOJ.setVisibility(4);
                                                    eqVar.vHs.setText(this.vHv.vHu.vHl.getText(R.l.dVB));
                                                    eqVar.vHs.setTextColor(this.vHv.vHu.vHl.getResources().getColor(R.e.aVM));
                                                    cVar2.fHR = "send_data_sucess";
                                                    cVar2.progress = 0;
                                                    this.vHv.vHu.vHl.vHf.put(cVar2.deviceID, cVar2);
                                                    w.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", cVar2.deviceID);
                                                }
                                            });
                                            return;
                                        } else if (cVar2.fHR.equals("send_data_failed")) {
                                            this.vHu.vHl.runOnUiThread(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 vHv;

                                                {
                                                    this.vHv = r1;
                                                }

                                                public final void run() {
                                                    eqVar.vOJ.setProgress(0);
                                                    eqVar.vOJ.setVisibility(4);
                                                    eqVar.vHs.setText(this.vHv.vHu.vHl.getText(R.l.dVz));
                                                    eqVar.vHs.setTextColor(this.vHv.vHu.vHl.getResources().getColor(R.e.aVN));
                                                    cVar2.fHR = "send_data_failed";
                                                    cVar2.progress = 0;
                                                    this.vHv.vHu.vHl.vHf.put(cVar2.deviceID, cVar2);
                                                    w.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", cVar2.deviceID);
                                                }
                                            });
                                            return;
                                        }
                                    } catch (Exception e) {
                                        w.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", e);
                                    }
                                } else {
                                    eqVar.vOJ.setProgress(i);
                                    cVar2.progress = i;
                                    i++;
                                    Thread.sleep((long) i3);
                                }
                            }
                        }
                    }, "SendDataState_handler").start();
                } else if (cVar.fHR.equals("send_data_sucess")) {
                    eqVar.vHs.setText(this.context.getString(R.l.dVB));
                    eqVar.vHs.setTextColor(this.context.getResources().getColor(R.e.aVM));
                    eqVar.vOJ.setVisibility(4);
                } else if (cVar.fHR.equals("send_data_cancel")) {
                    eqVar.vHs.setText(this.context.getString(R.l.dVv));
                    eqVar.vHs.setTextColor(this.context.getResources().getColor(R.e.aVL));
                    eqVar.vOJ.setVisibility(4);
                } else if (cVar.fHR.equals("send_data_failed")) {
                    eqVar.vHs.setText(this.context.getString(R.l.dVz));
                    eqVar.vHs.setTextColor(this.context.getResources().getColor(R.e.aVN));
                    eqVar.vOJ.setVisibility(4);
                }
            }
            w.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", Integer.valueOf(i), AT.gMX);
            n.GW().a(AT.iconUrl, eqVar.jbU, this.lir);
            eqVar.llw.setTag(Integer.valueOf(i));
            return view2;
        }
    }

    public class b {
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;

        public b(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
            this.vHl = chattingSendDataToDeviceUI;
        }

        public final boolean n(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof dt) {
                List list = ((dt) bVar).fHE.fGQ;
                List arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    c cVar = new c(this.vHl);
                    cVar.fGl = (String) ((Map) list.get(i)).get("deviceType");
                    cVar.deviceID = (String) ((Map) list.get(i)).get("deviceID");
                    cVar.gMX = (String) ((Map) list.get(i)).get("displayName");
                    cVar.iconUrl = (String) ((Map) list.get(i)).get("iconUrl");
                    cVar.fHM = (String) ((Map) list.get(i)).get("ability");
                    cVar.vHx = (String) ((Map) list.get(i)).get("abilityInf");
                    if ((this.vHl.fHN && ChattingSendDataToDeviceUI.a(cVar, this.vHl.lcw)) || (!this.vHl.fHN && ChattingSendDataToDeviceUI.a(cVar, this.vHl.gLE))) {
                        if (this.vHl.vHf.containsKey(cVar.deviceID) && ((c) this.vHl.vHf.get(cVar.deviceID)).fHR != null) {
                            cVar.fHR = ((c) this.vHl.vHf.get(cVar.deviceID)).fHR;
                            cVar.progress = ((c) this.vHl.vHf.get(cVar.deviceID)).progress;
                        }
                        arrayList.add(cVar);
                    }
                }
                if (this.vHl.vGW.size() != arrayList.size()) {
                    this.vHl.vGW = arrayList;
                    this.vHl.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ b vHw;

                        {
                            this.vHw = r1;
                        }

                        public final void run() {
                            this.vHw.vHl.vGO.ao(this.vHw.vHl.vGW);
                            if (this.vHw.vHl.vGO.getCount() > 0) {
                                this.vHw.vHl.vGT.setText(R.l.dTd);
                                this.vHw.vHl.vGZ = false;
                            }
                            this.vHw.vHl.vGO.notifyDataSetChanged();
                        }
                    });
                }
            } else if (bVar instanceof dx) {
                dx dxVar = (dx) bVar;
                String str = dxVar.fHP.fHR;
                String str2 = dxVar.fHP.fwJ;
                if (str.equals("send_data_sending")) {
                    ChattingSendDataToDeviceUI.a(this.vHl, "send_data_sending", str2, dxVar.fHP.progress);
                } else if (str.equals("send_data_failed")) {
                    ChattingSendDataToDeviceUI.a(this.vHl, "send_data_failed", str2, 0);
                } else if (str.equals("send_data_sucess")) {
                    ChattingSendDataToDeviceUI chattingSendDataToDeviceUI = this.vHl;
                    try {
                        eq eqVar = (eq) ((View) chattingSendDataToDeviceUI.vHg.get(Integer.valueOf(((Integer) chattingSendDataToDeviceUI.vHh.get(str2)).intValue()))).getTag();
                        w.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", Integer.valueOf(eqVar.vOJ.getProgress()), str2);
                        c cVar2 = (c) chattingSendDataToDeviceUI.vHf.get(str2);
                        chattingSendDataToDeviceUI.runOnUiThread(new AnonymousClass7(chattingSendDataToDeviceUI, eqVar, cVar2));
                        int abs = Math.abs(eqVar.vOJ.getProgress());
                        cVar2.progress = abs;
                        w.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", Integer.valueOf(abs >= 100 ? 0 : 500 / (100 - abs)));
                        e.b(new AnonymousClass8(chattingSendDataToDeviceUI, abs, eqVar, str2, cVar2, r6), "progressSuccess_handler").start();
                        chattingSendDataToDeviceUI.vHf.put(cVar2.deviceID, cVar2);
                    } catch (Exception e) {
                        w.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", e);
                    }
                }
            }
            return true;
        }
    }

    public class c {
        String deviceID;
        String fGl;
        String fHM;
        String fHR;
        String gMX;
        String iconUrl;
        int progress;
        final /* synthetic */ ChattingSendDataToDeviceUI vHl;
        String vHx;

        public c(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
            this.vHl = chattingSendDataToDeviceUI;
        }
    }

    static /* synthetic */ void Tw(String str) {
        com.tencent.mm.sdk.b.b dxVar = new dx();
        dxVar.fHP.fHR = str;
        com.tencent.mm.sdk.b.a.urY.m(dxVar);
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, final String str, final String str2, final int i) {
        w.d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", str, Integer.valueOf(i));
        chattingSendDataToDeviceUI.runOnUiThread(new Runnable(chattingSendDataToDeviceUI) {
            final /* synthetic */ ChattingSendDataToDeviceUI vHl;
            TextView vHs;

            public final void run() {
                try {
                    c cVar = (c) this.vHl.vHf.get(str2);
                    cVar.fHR = str;
                    if (i > cVar.progress) {
                        cVar.progress = i;
                    }
                    View view = (View) this.vHl.vHg.get(Integer.valueOf(((Integer) this.vHl.vHh.get(str2)).intValue()));
                    eq eqVar = (eq) view.getTag();
                    if (eqVar == null) {
                        w.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                        return;
                    }
                    this.vHs = eqVar.vHs;
                    this.vHs.setVisibility(0);
                    if (str.equals("send_data_failed")) {
                        this.vHl.lU(5);
                        this.vHs.setText(this.vHl.getString(R.l.dVz));
                        this.vHl.vHe.remove(str2);
                        this.vHs.setTextColor(this.vHl.getResources().getColor(R.e.aVN));
                        ChattingSendDataToDeviceUI.a(false, 0, view);
                    } else if (str.equals("send_data_sending")) {
                        this.vHs.setText(this.vHl.getString(R.l.dVD));
                        this.vHs.setTextColor(this.vHl.getResources().getColor(R.e.aVM));
                        ChattingSendDataToDeviceUI.a(true, i, view);
                    } else if (str.equals("send_data_cancel")) {
                        this.vHl.lU(6);
                        this.vHs.setText(this.vHl.getString(R.l.dVv));
                        this.vHs.setTextColor(this.vHl.getResources().getColor(R.e.aVL));
                        ChattingSendDataToDeviceUI.a(true, 0, view);
                    }
                    this.vHl.vHf.put(cVar.deviceID, cVar);
                } catch (Exception e) {
                    w.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", e.getMessage());
                }
            }
        });
    }

    static /* synthetic */ void a(boolean z, int i, View view) {
        try {
            eq eqVar = (eq) view.getTag();
            if (eqVar != null) {
                if (z) {
                    eqVar.vOJ.setVisibility(0);
                    if (i > eqVar.vOJ.getProgress()) {
                        eqVar.vOJ.setProgress(i);
                        return;
                    }
                    return;
                }
                eqVar.vOJ.setVisibility(4);
                eqVar.vOJ.setProgress(0);
            }
        } catch (Exception e) {
            w.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", e);
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        int i = 6;
        super.onCreate(bundle);
        this.fHN = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
        w.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.fHN);
        if (!this.fHN) {
            this.gLE = getIntent().getExtras().getLong("Retr_Msg_Id");
            if (this.gLE != -1) {
                ap.yY();
                this.qVX = com.tencent.mm.u.c.wT().cA(this.gLE);
                if (!(this.qVX == null || this.qVX.field_msgId == 0)) {
                    this.vGP = this.qVX.field_type;
                    this.vxp = o.dH(this.qVX.field_talker);
                    this.vGQ = this.qVX.field_content;
                    if (this.vxp && this.qVX.field_isSend == 0) {
                        str = this.qVX.field_content;
                        int i2 = this.qVX.field_isSend;
                        if (this.vxp && str != null && i2 == 0) {
                            str = ay.gj(str);
                        }
                        this.vGQ = str;
                    }
                    Long LB;
                    d n;
                    if (this.qVX.field_type == 49) {
                        this.fSU = com.tencent.mm.t.f.a.ek(this.vGQ);
                        if (this.fSU == null) {
                            w.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
                        } else if (this.fSU.type == 3) {
                            this.vGY = 16;
                        } else if (this.fSU.type == 4) {
                            this.vGY = 8;
                        } else if (this.fSU.type == 5) {
                            this.vGY = 32;
                        } else if (this.fSU.type == 6) {
                            LB = com.tencent.mm.pluginsdk.b.a.LB(this.fSU.hhr);
                            if (LB == null) {
                                w.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
                            } else {
                                this.vGY = LB.longValue();
                            }
                        } else if (this.fSU.type == 2) {
                            this.vGY = 2;
                            n = n.GS().n(this.qVX);
                            if (n != null) {
                                this.vGQ = n.hFj;
                            }
                        } else {
                            w.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
                        }
                    } else {
                        if (this.qVX.field_type == 3) {
                            n = n.GS().n(this.qVX);
                            if (n != null) {
                                this.vGQ = n.hFj;
                            }
                        } else if (this.qVX.field_type == 43) {
                            r ls = com.tencent.mm.modelvideo.o.KV().ls(this.qVX.field_imgPath);
                            if (ls != null) {
                                this.vGQ = ls.Lh();
                            }
                        }
                        LB = com.tencent.mm.pluginsdk.b.a.LB(this.vGP);
                        if (LB == null) {
                            w.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
                        } else {
                            this.vGY = LB.longValue();
                        }
                    }
                    w.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", Long.valueOf(this.vGY));
                }
            }
        }
        this.vHc = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
        this.vHa = false;
        setFinishOnTouchOutside(true);
        this.vGW.clear();
        this.vHf.clear();
        this.vGR = (RelativeLayout) findViewById(R.h.cnW);
        com.tencent.mm.sdk.b.b ddVar = new dd();
        if (this.fHN) {
            this.lcw = getIntent().getExtras().getString("sns_local_id");
            if (this.lcw != null) {
                ddVar.fGW.fGN = this.lcw;
                w.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", this.lcw);
            }
        } else {
            ddVar.fGW.fGM = this.gLE;
        }
        com.tencent.mm.sdk.b.a.urY.m(ddVar);
        if (ddVar.fGX.fGu) {
            this.vGU = Boolean.valueOf(true);
            com.tencent.mm.sdk.b.a.urY.b(this.vHj);
            com.tencent.mm.sdk.b.a.urY.b(this.vHk);
            this.vGR.setVisibility(0);
            this.sQG = (HorizontalListView) findViewById(R.h.cbx);
            this.vGT = (TextView) findViewById(R.h.bqF);
            this.vGT.setText(R.l.dVs);
            this.vGO = new a(this, this);
            this.sQG.setAdapter(this.vGO);
            this.sQG.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ChattingSendDataToDeviceUI vHl;

                {
                    this.vHl = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.vHl.vHa = true;
                    c AT = this.vHl.vGO.AT(i);
                    String str = AT.fGl;
                    String str2 = AT.deviceID;
                    String str3 = AT.fHM;
                    try {
                        if (this.vHl.vHe.get(str2) != null) {
                            w.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                            com.tencent.mm.sdk.b.b cqVar = new cq();
                            cqVar.fGh.fwJ = str2;
                            com.tencent.mm.sdk.b.a.urY.m(cqVar);
                            ChattingSendDataToDeviceUI.a(this.vHl, "send_data_cancel", str2, 0);
                            AT.fHR = "send_data_cancel";
                            this.vHl.vHe.remove(str2);
                            eq eqVar = (eq) ((View) this.vHl.vHg.get(Integer.valueOf(i))).getTag();
                            eqVar.vHs.setText(this.vHl.getText(R.l.dVv));
                            eqVar.vHs.setTextColor(this.vHl.getResources().getColor(R.e.aVL));
                            eqVar.vOJ.setVisibility(8);
                            eqVar.vOJ.setProgress(0);
                            return;
                        }
                        AT.fHR = "send_data_sending";
                        this.vHl.vHf.put(AT.deviceID, AT);
                        this.vHl.vHe.put(str2, view);
                        ChattingSendDataToDeviceUI.a(this.vHl, "send_data_sending", str2, 1);
                        this.vHl.lU(3);
                        com.tencent.mm.sdk.b.b dwVar = new dw();
                        dwVar.fHK.fwJ = str2;
                        dwVar.fHK.fGl = str;
                        dwVar.fHK.data = this.vHl.vGQ;
                        dwVar.fHK.fHM = str3;
                        if (this.vHl.fHN) {
                            dwVar.fHK.fGN = this.vHl.lcw;
                            dwVar.fHK.fHN = this.vHl.fHN;
                        } else {
                            dwVar.fHK.fGM = this.vHl.gLE;
                        }
                        com.tencent.mm.sdk.b.a.urY.m(dwVar);
                        if (!dwVar.fHL.fHO) {
                            ChattingSendDataToDeviceUI.Tw("send_data_failed");
                            w.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
                        }
                    } catch (Exception e) {
                        ChattingSendDataToDeviceUI.Tw("send_data_failed");
                        w.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", e);
                    }
                }
            });
            bUM();
            if (this.fHN) {
                int i3;
                str = this.lcw;
                if (str != null) {
                    com.tencent.mm.sdk.b.b hmVar = new hm();
                    hmVar.fMT.fGN = str;
                    com.tencent.mm.sdk.b.a.urY.m(hmVar);
                    i3 = hmVar.fMU.fMV.ufB.tsN;
                    if (i3 == 1) {
                        i3 = 3;
                    } else if (i3 == 4) {
                        i3 = 1;
                    } else if (i3 == 15) {
                        i3 = 6;
                    } else if (i3 == 3) {
                        i3 = 5;
                    }
                    this.vHd = i3;
                }
                i3 = 0;
                this.vHd = i3;
            } else {
                long j = this.gLE;
                if (j == -1 || j == Long.MIN_VALUE) {
                    i = 0;
                } else {
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA(j);
                    if (cA.field_msgId != 0) {
                        i2 = cA.field_type;
                        String str2 = cA.field_content;
                        if (cA.axO()) {
                            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str2);
                            if (ek == null) {
                                w.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                            } else if (ek.type == 3) {
                                i = 1;
                            } else if (ek.type != 4) {
                                if (ek.type == 6) {
                                    i = 4;
                                } else if (ek.type == 2) {
                                    i = 3;
                                } else if (ek.type == 5) {
                                    i = 5;
                                }
                            }
                        } else if (i2 == 3) {
                            i = 3;
                        } else if (i2 == 48) {
                            i = 2;
                        } else if (i2 == 62) {
                        }
                    }
                    i = 0;
                }
                this.vHd = i;
            }
            lU(1);
        } else {
            this.vGR.setVisibility(8);
        }
        this.vGS = (RelativeLayout) findViewById(R.h.bpW);
        this.vGM = (HorizontalListView) findViewById(R.h.bpF);
        this.vGN = new c(this);
        this.vGM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ChattingSendDataToDeviceUI vHl;

            {
                this.vHl = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", Integer.valueOf(i));
                if (i == adapterView.getAdapter().getCount() - 1) {
                    Intent intent = new Intent(this.vHl, Sort3rdAppUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("KFlag", this.vHl.vGY);
                    this.vHl.startActivity(intent);
                } else if (this.vHl.vye && i == adapterView.getAdapter().getCount() - 2) {
                    if (this.vHl.filePath == null || this.vHl.iAS == null) {
                        g.bl(this.vHl.getBaseContext(), this.vHl.getString(R.l.ebP));
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.a.b(this.vHl, this.vHl.filePath, this.vHl.iAS.toLowerCase(), 1);
                    }
                } else if (i >= 0 && i < adapterView.getAdapter().getCount() - 1) {
                    final f fVar = (f) this.vHl.vGX.get(i);
                    if (com.tencent.mm.pluginsdk.model.app.g.a(this.vHl.getBaseContext(), fVar)) {
                        com.tencent.mm.bk.a.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 vHm;

                            public final void run() {
                                com.tencent.mm.pluginsdk.model.app.g.a(this.vHm.vHl.getBaseContext(), fVar.field_packageName, this.vHm.vHl.vHi, fVar.field_appId, fVar.field_openId, 0, null, null);
                            }
                        });
                        return;
                    }
                    g.bl(this.vHl.getBaseContext(), this.vHl.getString(R.l.dVu));
                    fVar.field_status = 4;
                    an.aRr().a(fVar, new String[0]);
                    this.vHl.bUL();
                }
            }
        });
        this.vGM.setAdapter(this.vGN);
    }

    private void lU(int i) {
        if (this.fHN) {
            com.tencent.mm.plugin.report.service.g.oUh.i(13197, Integer.valueOf(i), Integer.valueOf(this.vHd), "", Integer.valueOf(2), Integer.valueOf(this.vHc));
            return;
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.vHd);
        long j = this.gLE;
        String str = "";
        ap.yY();
        ce cA = com.tencent.mm.u.c.wT().cA(j);
        if (cA.field_msgId == 0) {
            str = "";
        } else {
            String str2 = cA.field_content;
            if (cA.field_type == 49) {
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str2);
                if (ek != null && ek.type == 6) {
                    str = ek.hhr;
                }
            }
        }
        objArr[2] = str;
        objArr[3] = Integer.valueOf(1);
        objArr[4] = Integer.valueOf(this.vHc);
        gVar.i(13197, objArr);
    }

    protected final int getLayoutId() {
        return R.i.cYN;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.sdk.b.b dbVar = new db();
        if (this.fHN) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            dbVar.fGK.fGN = this.lcw;
            dbVar.fGK.fGO = string;
            dbVar.fGK.fGP = i;
        } else {
            dbVar.fGK.fGM = this.gLE;
        }
        com.tencent.mm.sdk.b.a.urY.m(dbVar);
        if (dbVar.fGL.fGu && this.vGW.size() > 0) {
            w.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", Integer.valueOf(this.vGW.size()));
            this.vGO.ao(this.vGW);
            if (this.vGO.getCount() > 0) {
                this.vGT.setText(R.l.dTd);
                this.vGZ = false;
            }
            this.vGO.notifyDataSetChanged();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bUL() {
        /*
        r10 = this;
        r9 = 8;
        r8 = 2;
        r1 = 1;
        r2 = 0;
        r0 = r10.vGN;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r4 = r10.vGY;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x003b;
    L_0x0011:
        r3 = "MicroMsg.ChattingSendDataToDeviceUI";
        r4 = "mAppInfoAdapter is null %s, contentFlag %s";
        r5 = new java.lang.Object[r8];
        r0 = r10.vGN;
        if (r0 != 0) goto L_0x0039;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        r6 = r10.vGY;
        r0 = java.lang.Long.valueOf(r6);
        r5[r1] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);
        r0 = r10.vGS;
        if (r0 == 0) goto L_0x0038;
    L_0x0033:
        r0 = r10.vGS;
        r0.setVisibility(r9);
    L_0x0038:
        return;
    L_0x0039:
        r0 = r2;
        goto L_0x001e;
    L_0x003b:
        r4 = r10.vGY;
        r0 = com.tencent.mm.pluginsdk.model.app.g.b(r10, r4, r2);
        r10.vGX = r0;
        r4 = r10.vGY;
        r0 = com.tencent.mm.pluginsdk.model.app.g.m(r10, r4);
        if (r0 != 0) goto L_0x0054;
    L_0x004b:
        r0 = r10.vGS;
        if (r0 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r10.vGS;
        r0.setVisibility(r9);
    L_0x0054:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r10.vGX;
        if (r0 == 0) goto L_0x00a8;
    L_0x005d:
        r0 = r10.vGX;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00a8;
    L_0x0065:
        r0 = com.tencent.mm.pluginsdk.model.app.an.bDl();
        r4 = r10.vGY;
        r0 = r0.ef(r4);
        if (r0 == 0) goto L_0x0081;
    L_0x0071:
        r4 = r0.size();
        if (r4 <= 0) goto L_0x0081;
    L_0x0077:
        r4 = r10.vGX;
        r5 = new com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$4;
        r5.<init>(r10, r0);
        java.util.Collections.sort(r4, r5);
    L_0x0081:
        r0 = r10.vGX;
        r4 = r0.iterator();
    L_0x0087:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00a8;
    L_0x008d:
        r0 = r4.next();
        r0 = (com.tencent.mm.pluginsdk.model.app.f) r0;
        r5 = new com.tencent.mm.ui.chatting.dj;
        r5.<init>();
        r6 = r0.field_appId;
        r5.appId = r6;
        r6 = r0.field_appName;
        r5.gMX = r6;
        r0 = r0.field_appIconUrl;
        r5.iconUrl = r0;
        r3.add(r5);
        goto L_0x0087;
    L_0x00a8:
        r0 = r10.vHi;
        if (r0 != 0) goto L_0x00d2;
    L_0x00ac:
        r0 = 0;
        r4 = r10.qVX;
        r4 = r4.field_type;
        switch(r4) {
            case 1: goto L_0x01df;
            case 3: goto L_0x01ea;
            case 43: goto L_0x0271;
            case 48: goto L_0x0257;
            case 49: goto L_0x00e4;
            default: goto L_0x00b4;
        };
    L_0x00b4:
        r2 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
        r2.<init>(r0);
        r10.vHi = r2;
        r2 = r10.vHi;
        r4 = 620757000; // 0x25000008 float:1.1102241E-16 double:3.06694708E-315;
        r2.sdkVer = r4;
        r2 = r10.iAS;
        if (r2 == 0) goto L_0x00d2;
    L_0x00c6:
        r2 = r10.filePath;
        if (r2 == 0) goto L_0x00d2;
    L_0x00ca:
        if (r0 == 0) goto L_0x00d2;
    L_0x00cc:
        r0 = r0 instanceof com.tencent.mm.opensdk.modelmsg.WXFileObject;
        if (r0 == 0) goto L_0x00d2;
    L_0x00d0:
        r10.vye = r1;
    L_0x00d2:
        r0 = r10.vGN;
        r1 = r10.vye;
        r0.vye = r1;
        r0 = r10.vGN;
        r0.ao(r3);
        r0 = r10.vGN;
        r0.notifyDataSetChanged();
        goto L_0x0038;
    L_0x00e4:
        r4 = r10.fSU;
        if (r4 == 0) goto L_0x00b4;
    L_0x00e8:
        r4 = r10.fSU;
        r4 = r4.type;
        r5 = 3;
        if (r4 != r5) goto L_0x010d;
    L_0x00ef:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXMusicObject;
        r0.<init>();
        r2 = r10.fSU;
        r2 = r2.url;
        r0.musicUrl = r2;
        r2 = r10.fSU;
        r2 = r2.hhH;
        r0.musicDataUrl = r2;
        r2 = r10.fSU;
        r2 = r2.hhp;
        r0.musicLowBandUrl = r2;
        r2 = r10.fSU;
        r2 = r2.hhI;
        r0.musicLowBandDataUrl = r2;
        goto L_0x00b4;
    L_0x010d:
        r4 = r10.fSU;
        r4 = r4.type;
        r5 = 4;
        if (r4 != r5) goto L_0x0126;
    L_0x0114:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXVideoObject;
        r0.<init>();
        r2 = r10.fSU;
        r2 = r2.url;
        r0.videoUrl = r2;
        r2 = r10.fSU;
        r2 = r2.hhI;
        r0.videoLowBandUrl = r2;
        goto L_0x00b4;
    L_0x0126:
        r4 = r10.fSU;
        r4 = r4.type;
        r5 = 5;
        if (r4 != r5) goto L_0x0138;
    L_0x012d:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
        r2 = r10.fSU;
        r2 = r2.url;
        r0.<init>(r2);
        goto L_0x00b4;
    L_0x0138:
        r4 = r10.fSU;
        r4 = r4.type;
        r5 = 6;
        if (r4 != r5) goto L_0x018d;
    L_0x013f:
        r4 = com.tencent.mm.pluginsdk.model.app.an.abL();
        r5 = r10.fSU;
        r5 = r5.fCW;
        r4 = r4.LW(r5);
        if (r4 == 0) goto L_0x0183;
    L_0x014d:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage fileFullPath %s";
        r6 = new java.lang.Object[r1];
        r7 = r4.field_fileFullPath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r0, r5, r6);
        r0 = new com.tencent.mm.opensdk.modelmsg.WXFileObject;
        r2 = r4.field_fileFullPath;
        r0.<init>(r2);
        r2 = r4.field_fileFullPath;
        r10.filePath = r2;
        r2 = r10.fSU;
        r2 = r2.hhr;
        r10.iAS = r2;
    L_0x016d:
        r2 = r10.filePath;
        r2 = com.tencent.mm.pluginsdk.model.app.q.Ml(r2);
        if (r2 == 0) goto L_0x00b4;
    L_0x0175:
        r0 = com.tencent.mm.R.l.dVt;
        r0 = r10.getString(r0);
        com.tencent.mm.ui.base.g.bl(r10, r0);
        r10.finish();
        goto L_0x00d2;
    L_0x0183:
        r2 = "MicroMsg.ChattingSendDataToDeviceUI";
        r4 = "getWXMediaMessage attInfo is null";
        com.tencent.mm.sdk.platformtools.w.e(r2, r4);
        goto L_0x016d;
    L_0x018d:
        r4 = r10.fSU;
        r4 = r4.type;
        if (r4 != r8) goto L_0x00b4;
    L_0x0193:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXImageObject;
        r0.<init>();
        r4 = com.tencent.mm.ah.n.GS();
        r5 = r10.qVX;
        r4 = r4.n(r5);
        if (r4 == 0) goto L_0x01c4;
    L_0x01a4:
        r5 = com.tencent.mm.ah.n.GS();
        r6 = r4.hEZ;
        r5 = r5.ju(r6);
        r0.imagePath = r5;
        r5 = r0.imagePath;
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r5 == 0) goto L_0x01c4;
    L_0x01b8:
        r5 = com.tencent.mm.ah.n.GS();
        r4 = r4.hFb;
        r4 = r5.ju(r4);
        r0.imagePath = r4;
    L_0x01c4:
        r4 = r0.imagePath;
        r10.filePath = r4;
        r4 = r10.fSU;
        r4 = r4.hhr;
        r10.iAS = r4;
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage imagePath %s";
        r6 = new java.lang.Object[r1];
        r7 = r0.imagePath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        goto L_0x00b4;
    L_0x01df:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXTextObject;
        r2 = r10.qVX;
        r2 = r2.field_content;
        r0.<init>(r2);
        goto L_0x00b4;
    L_0x01ea:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXImageObject;
        r0.<init>();
        r4 = com.tencent.mm.ah.n.GS();
        r5 = r10.qVX;
        r4 = r4.n(r5);
        if (r4 == 0) goto L_0x0246;
    L_0x01fb:
        r5 = com.tencent.mm.ah.n.GS();
        r6 = r4.hEZ;
        r5 = r5.ju(r6);
        r0.imagePath = r5;
        r5 = r0.imagePath;
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r5 == 0) goto L_0x021b;
    L_0x020f:
        r5 = com.tencent.mm.ah.n.GS();
        r4 = r4.hFb;
        r4 = r5.ju(r4);
        r0.imagePath = r4;
    L_0x021b:
        r4 = r0.imagePath;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x0246;
    L_0x0223:
        r4 = r0.imagePath;
        r10.filePath = r4;
        r4 = r0.imagePath;
        r5 = ".";
        r4 = r4.lastIndexOf(r5);
        if (r4 < 0) goto L_0x0246;
    L_0x0232:
        r5 = r0.imagePath;
        r5 = r5.length();
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x0246;
    L_0x023c:
        r5 = r0.imagePath;
        r4 = r4 + 1;
        r4 = r5.substring(r4);
        r10.iAS = r4;
    L_0x0246:
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage imagePath %s";
        r6 = new java.lang.Object[r1];
        r7 = r0.imagePath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        goto L_0x00b4;
    L_0x0257:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r2 = r10.qVX;
        r2 = r2.field_content;
        r2 = r0.Aw(r2);
        r0 = new com.tencent.mm.opensdk.modelmsg.WXLocationObject;
        r4 = r2.naO;
        r6 = r2.naP;
        r0.<init>(r4, r6);
        goto L_0x00b4;
    L_0x0271:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXVideoObject;
        r0.<init>();
        com.tencent.mm.modelvideo.o.KV();
        r2 = r10.qVX;
        r2 = r2.field_imgPath;
        r2 = com.tencent.mm.modelvideo.s.lv(r2);
        if (r2 == 0) goto L_0x00b4;
    L_0x0283:
        r0.videoUrl = r2;
        r10.filePath = r2;
        r4 = ".";
        r4 = r2.lastIndexOf(r4);
        if (r4 < 0) goto L_0x00b4;
    L_0x0290:
        r5 = r2.length();
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x00b4;
    L_0x0298:
        r4 = r4 + 1;
        r2 = r2.substring(r4);
        r10.iAS = r2;
        goto L_0x00b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.bUL():void");
    }

    private void bUM() {
        com.tencent.mm.sdk.b.b dbVar = new db();
        if (this.fHN) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            dbVar.fGK.fGN = this.lcw;
            dbVar.fGK.fGO = string;
            dbVar.fGK.fGP = i;
        } else {
            dbVar.fGK.fGM = this.gLE;
        }
        com.tencent.mm.sdk.b.a.urY.m(dbVar);
        if (dbVar.fGL.fGu) {
            List list = dbVar.fGL.fGQ;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = new c(this);
                cVar.fGl = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.gMX = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.fHM = (String) ((Map) list.get(i2)).get("ability");
                cVar.vHx = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.fHN && a(cVar, this.lcw)) {
                    this.vGW.add(cVar);
                } else if (!this.fHN && a(cVar, this.gLE)) {
                    this.vGW.add(cVar);
                }
            }
            if (this.vGW.size() > 0) {
                w.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.vGO.ao(this.vGW);
                if (this.vGO.getCount() > 0) {
                    this.vGT.setText(R.l.dTd);
                    this.vGZ = false;
                }
                this.vGO.notifyDataSetChanged();
            }
        }
    }

    private static boolean a(String str, c cVar) {
        String str2 = cVar.fHM;
        String str3 = cVar.vHx;
        String host = Uri.parse(str).getHost();
        if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (jSONArray.getString(i).equals(host)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", e, str3, new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r8, java.lang.String r9) {
        /*
        r1 = 0;
        r0 = 1;
        if (r9 != 0) goto L_0x0005;
    L_0x0004:
        return r1;
    L_0x0005:
        r2 = new com.tencent.mm.e.a.hm;
        r2.<init>();
        r3 = r2.fMT;
        r3.fGN = r9;
        r3 = com.tencent.mm.sdk.b.a.urY;
        r3.m(r2);
        r2 = r2.fMU;
        r2 = r2.fMV;
        r3 = r2.ufB;
        r3 = r3.tsN;
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "isNeedToShowSnsInfo contentStyle %d";
        r6 = new java.lang.Object[r0];
        r7 = java.lang.Integer.valueOf(r3);
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r4 = r8.fHM;
        if (r4 != 0) goto L_0x003a;
    L_0x0030:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r2 = "ability is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        goto L_0x0004;
    L_0x003a:
        if (r3 != r0) goto L_0x0047;
    L_0x003c:
        r2 = "wxmsg_image";
        r2 = r4.contains(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0045:
        r1 = r0;
        goto L_0x0004;
    L_0x0047:
        r5 = 4;
        if (r3 != r5) goto L_0x0055;
    L_0x004a:
        r2 = "wxmsg_music";
        r2 = r4.contains(r2);
        if (r2 != 0) goto L_0x0045;
    L_0x0053:
        r0 = r1;
        goto L_0x0045;
    L_0x0055:
        r5 = 15;
        if (r3 != r5) goto L_0x0063;
    L_0x0059:
        r2 = "wxmsg_video";
        r2 = r4.contains(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0062:
        goto L_0x0045;
    L_0x0063:
        r0 = 3;
        if (r3 != r0) goto L_0x0053;
    L_0x0066:
        r0 = r2.ufB;
        r0 = r0.msN;
        r0 = a(r0, r8);
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, java.lang.String):boolean");
    }

    public void onBackPressed() {
        if (this.vHe.size() > 0) {
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
            aVar.zX(R.l.dVw);
            aVar.zZ(R.l.dVy).a(new OnClickListener(this) {
                final /* synthetic */ ChattingSendDataToDeviceUI vHl;

                {
                    this.vHl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    for (String str : this.vHl.vHe.keySet()) {
                        com.tencent.mm.sdk.b.b cqVar = new cq();
                        cqVar.fGh.fwJ = str;
                        com.tencent.mm.sdk.b.a.urY.m(cqVar);
                    }
                    this.vHl.finish();
                }
            });
            aVar.Aa(R.l.dVx).b(new OnClickListener(this) {
                final /* synthetic */ ChattingSendDataToDeviceUI vHl;

                {
                    this.vHl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            aVar.WJ().show();
            return;
        }
        super.onBackPressed();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r9, long r10) {
        /*
        r8 = 3;
        r1 = 0;
        r0 = 1;
        r2 = -1;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = r9.fHM;
        com.tencent.mm.u.ap.yY();
        r3 = com.tencent.mm.u.c.wT();
        r3 = r3.cA(r10);
        r4 = r3.field_msgId;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0009;
    L_0x001f:
        if (r2 == 0) goto L_0x0009;
    L_0x0021:
        r4 = r3.field_type;
        r5 = r3.field_content;
        r3 = r3.axO();
        if (r3 == 0) goto L_0x007c;
    L_0x002b:
        r3 = com.tencent.mm.t.f.a.ek(r5);
        if (r3 != 0) goto L_0x003b;
    L_0x0031:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r2 = "get content is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        goto L_0x0009;
    L_0x003b:
        r4 = r3.type;
        if (r4 != r8) goto L_0x004a;
    L_0x003f:
        r3 = "wxmsg_music";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0048:
        r1 = r0;
        goto L_0x0009;
    L_0x004a:
        r4 = r3.type;
        r5 = 4;
        if (r4 != r5) goto L_0x0051;
    L_0x004f:
        r0 = r1;
        goto L_0x0048;
    L_0x0051:
        r4 = r3.type;
        r5 = 6;
        if (r4 != r5) goto L_0x0061;
    L_0x0056:
        r3 = "wxmsg_file";
        r2 = r2.contains(r3);
        if (r2 != 0) goto L_0x0048;
    L_0x005f:
        r0 = r1;
        goto L_0x0048;
    L_0x0061:
        r4 = r3.type;
        r5 = 5;
        if (r4 != r5) goto L_0x006d;
    L_0x0066:
        r0 = r3.url;
        r0 = a(r0, r9);
        goto L_0x0048;
    L_0x006d:
        r3 = r3.type;
        r4 = 2;
        if (r3 != r4) goto L_0x005f;
    L_0x0072:
        r3 = "wxmsg_image";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x007b:
        goto L_0x0048;
    L_0x007c:
        if (r4 != r8) goto L_0x0088;
    L_0x007e:
        r3 = "wxmsg_image";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0087:
        goto L_0x0048;
    L_0x0088:
        r3 = 48;
        if (r4 != r3) goto L_0x0096;
    L_0x008c:
        r3 = "wxmsg_poi";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0095:
        goto L_0x0048;
    L_0x0096:
        r3 = 62;
        if (r4 != r3) goto L_0x005f;
    L_0x009a:
        r3 = "wxmsg_video";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x00a3:
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, long):boolean");
    }

    protected void onResume() {
        super.onResume();
        bUL();
        if (this.vGU.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) this.sQG.getLayoutParams();
            int i = layoutParams.height;
            float dI = com.tencent.mm.bg.a.dI(this);
            if (dI == 1.125f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.f.aXx);
            } else if (dI == 1.375f || dI == 1.25f || dI == 1.625f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.f.aXH);
            }
            this.sQG.setLayoutParams(layoutParams);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.ebP, R.l.ebQ, 1);
    }

    protected void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.vHb = false;
        if (this.vGU.booleanValue()) {
            if (!this.vHa) {
                lU(2);
            }
            com.tencent.mm.sdk.b.a.urY.c(this.vHj);
            com.tencent.mm.sdk.b.a.urY.c(this.vHk);
            com.tencent.mm.sdk.b.b ejVar = new ej();
            com.tencent.mm.sdk.b.a.urY.m(ejVar);
            if (ejVar.fIl.fHO) {
                w.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
        com.tencent.mm.sdk.platformtools.a.cU(getWindow().getDecorView());
        com.tencent.mm.sdk.platformtools.a.dU(this);
    }

    public final b bUN() {
        if (this.vGV == null) {
            this.vGV = new b(this);
        }
        return this.vGV;
    }
}
