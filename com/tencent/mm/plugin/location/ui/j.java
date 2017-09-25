package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import java.util.ArrayList;

public final class j {
    public TextView Fy;
    public Context context;
    private String kwe;
    ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ j neI;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            j jVar;
            Message obtain;
            String eK;
            switch (message.what) {
                case 1:
                    this.neI.Fy.setText(this.neI.neH);
                    return;
                case 2:
                    w.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[]{Boolean.valueOf(this.neI.nel), Boolean.valueOf(this.neI.neG)});
                    if (!this.neI.nel && !this.neI.neG) {
                        jVar = this.neI;
                        jVar.Fy.setTextColor(jVar.neD);
                        jVar.Fy.invalidate();
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0) {
                            this.neI.Fy.setText(this.neI.context.getString(R.l.eYm));
                            return;
                        }
                        this.neI.Fy.setText(this.neI.context.getResources().getQuantityString(R.j.dsE, intValue, new Object[]{Integer.valueOf(intValue)}));
                        return;
                    }
                    return;
                case 3:
                    if (this.neI.neG || this.neI.nel) {
                        removeMessages(3);
                        obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        return;
                    }
                    this.neI.neH = this.neI.Fy.getText().toString();
                    this.neI.aGH();
                    eK = n.eK((String) message.obj);
                    this.neI.Fy.setText(this.neI.context.getString(R.l.eYs, new Object[]{eK}));
                    if (this.neI.nel || this.neI.neG) {
                        this.neI.aGI();
                        return;
                    }
                    return;
                case 4:
                    if (this.neI.neG || this.neI.nel) {
                        removeMessages(4);
                        obtain = Message.obtain();
                        obtain.what = 4;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        return;
                    }
                    this.neI.neH = this.neI.Fy.getText().toString();
                    this.neI.aGH();
                    eK = n.eK((String) message.obj);
                    this.neI.Fy.setText(this.neI.context.getString(R.l.eYt, new Object[]{eK}));
                    if (this.neI.nel || this.neI.neG) {
                        this.neI.aGI();
                        return;
                    }
                    return;
                case 5:
                    this.neI.neG = true;
                    this.neI.nel = false;
                    this.neI.aGH();
                    eK = n.eK((String) message.obj);
                    this.neI.Fy.setText(this.neI.context.getString(R.l.eYu, new Object[]{eK}));
                    return;
                case 6:
                    this.neI.nel = true;
                    this.neI.neG = false;
                    this.neI.aGH();
                    this.neI.Fy.setText(this.neI.context.getString(R.l.eYr));
                    return;
                case 7:
                    this.neI.neG = true;
                    jVar = this.neI;
                    jVar.Fy.setTextColor(jVar.neE);
                    jVar.Fy.invalidate();
                    this.neI.Fy.setText(this.neI.context.getString(R.l.eYv));
                    this.neI.neH = this.neI.Fy.getText().toString();
                    this.neI.aGI();
                    return;
                case 8:
                    jVar = this.neI;
                    jVar.Fy.setTextColor(jVar.neF);
                    jVar.Fy.invalidate();
                    this.neI.Fy.setText(this.neI.context.getString(R.l.eYw));
                    return;
                case 9:
                    this.neI.nel = false;
                    if (!this.neI.neG) {
                        this.neI.fo(true);
                        return;
                    }
                    return;
                case 10:
                    this.neI.neG = false;
                    this.neI.fo(false);
                    return;
                default:
                    return;
            }
        }
    };
    private final int neA = 10;
    boolean neB = true;
    private int neC = Color.parseColor("#44FEBB");
    int neD = Color.parseColor("#FFFFFF");
    int neE = Color.parseColor("#E54646");
    int neF = Color.parseColor("#FFC90C");
    public boolean neG = false;
    public String neH = "";
    public boolean nel = false;
    private ViewGroup nen;
    ArrayList<String> neo;
    private final int nep = 100;
    private final int neq = 1;
    private final int ner = 2;
    private final int nes = 3;
    private final int neu = 4;
    private final int nev = 5;
    private final int new = 6;
    private final int nex = 7;
    private final int ney = 8;
    private final int nez = 9;

    public j(Context context, ViewGroup viewGroup, String str) {
        this.context = context;
        this.nen = viewGroup;
        this.Fy = (TextView) this.nen.findViewById(R.h.title);
        this.kwe = str;
        init();
    }

    private void init() {
        w.d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.Fy.invalidate();
        this.neo = new ArrayList();
        for (String add : l.aGf().zq(this.kwe)) {
            this.neo.add(add);
        }
        fo(false);
    }

    public final void aGH() {
        this.Fy.setTextColor(this.neC);
        this.Fy.invalidate();
    }

    public final void fo(boolean z) {
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.neo.size());
        w.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[]{Integer.valueOf(this.neo.size()), Boolean.valueOf(z)});
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
        } else {
            this.mHandler.sendMessage(obtain);
        }
    }

    public final void aGI() {
        this.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.mHandler.sendMessageDelayed(obtain, 100);
    }
}
