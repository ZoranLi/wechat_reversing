package com.tencent.mm.plugin.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.plugin.chatroom.d.m;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.utils.TbsLog;

public class RoomCardUI extends MMActivity implements e {
    private p iLz;
    private c ktC = new c<kr>(this) {
        final /* synthetic */ RoomCardUI kvi;

        {
            this.kvi = r2;
            this.usg = kr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kr krVar = (kr) bVar;
            String str = krVar.fRk.fRl;
            String str2 = krVar.fRk.fRm;
            int i = krVar.fRk.ret;
            if (i != 0 && str2 != null) {
                g.b(this.kvi, str2, str, true);
                if (this.kvi.kuH != null) {
                    ap.yY();
                    com.tencent.mm.u.c.wQ().c(this.kvi.kuH);
                }
            } else if (i == 0) {
                if (this.kvi.kvh) {
                    RoomCardUI.a(this.kvi, this.kvi.kuZ.getText().toString());
                } else {
                    this.kvi.ajv();
                }
            }
            if (!(this.kvi.kvh || this.kvi.iLz == null || !this.kvi.iLz.isShowing())) {
                this.kvi.iLz.dismiss();
            }
            return false;
        }
    };
    private String kuC;
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.b kuH;
    private String kuR;
    private int kuS;
    private String kuT;
    private boolean kuU;
    private String kuV;
    private String kuW;
    private long kuX;
    private TextView kuY;
    private MMEditText kuZ;
    private TextView kva;
    private TextView kvb;
    private ImageView kvc;
    private LinearLayout kvd;
    private LinearLayout kve;
    private LinearLayout kvf;
    private LinearLayout kvg;
    private boolean kvh = false;

    private class a implements TextWatcher {
        final /* synthetic */ RoomCardUI kvi;
        private int kvk = 280;
        private String kvl = "";
        private boolean kvm = false;

        public a(RoomCardUI roomCardUI) {
            this.kvi = roomCardUI;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.kvi.aju();
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        if (roomCardUI.ajt()) {
            String str = roomCardUI.kuZ.getText().toString();
            String sE = com.tencent.mm.i.b.sE();
            if (bg.mA(sE) || !str.matches(".*[" + sE + "].*")) {
                int i;
                int i2;
                roomCardUI.aHj();
                if (bg.mA(roomCardUI.kuZ.getText().toString())) {
                    i = R.l.eXl;
                    i2 = R.l.eXk;
                } else {
                    i = R.l.eDP;
                    i2 = R.l.eDR;
                }
                g.a(roomCardUI, i, 0, i2, R.l.eDQ, new OnClickListener(roomCardUI) {
                    final /* synthetic */ RoomCardUI kvi;

                    {
                        this.kvi = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RoomCardUI roomCardUI = this.kvi;
                        Context context = this.kvi.uSU.uTo;
                        this.kvi.getString(R.l.dIO);
                        roomCardUI.iLz = g.a(context, this.kvi.getString(R.l.eNe), false, null);
                        if (this.kvi.ajt()) {
                            this.kvi.kvh = false;
                            RoomCardUI.a(this.kvi, this.kvi.kuZ.getText().toString());
                        }
                    }
                }, new OnClickListener(roomCardUI) {
                    final /* synthetic */ RoomCardUI kvi;

                    {
                        this.kvi = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kvi.aju();
                    }
                });
                return;
            }
            g.b(roomCardUI.uSU.uTo, roomCardUI.getString(R.l.esK, new Object[]{sE}), roomCardUI.getString(R.l.dIO), true);
            return;
        }
        roomCardUI.ajv();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, final TextView textView) {
        l lVar = new l(roomCardUI);
        lVar.qJf = new n.c(roomCardUI) {
            final /* synthetic */ RoomCardUI kvi;

            {
                this.kvi = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.add(R.l.dGx);
            }
        };
        lVar.qJg = new d(roomCardUI) {
            final /* synthetic */ RoomCardUI kvi;

            public final void c(MenuItem menuItem, int i) {
                if (i == 0) {
                    ((ClipboardManager) textView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, textView.getText().toString()));
                }
            }
        };
        lVar.blb();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, String str) {
        if (roomCardUI.ajt()) {
            ap.vd().a(new m(roomCardUI.kuC, str), 0);
        }
    }

    protected final int getLayoutId() {
        return R.i.dmJ;
    }

    protected final void KC() {
        zi(R.l.eMS);
        a(0, getString(R.l.dGK), new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomCardUI kvi;

            {
                this.kvi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle().equals(this.kvi.getString(R.l.dHp))) {
                    RoomCardUI.a(this.kvi);
                }
                this.kvi.kuZ.setEnabled(true);
                this.kvi.kuZ.setFocusableInTouchMode(true);
                this.kvi.kuZ.setFocusable(true);
                this.kvi.kuZ.setCursorVisible(true);
                this.kvi.aB(0, this.kvi.getString(R.l.dHp));
                this.kvi.kr(false);
                this.kvi.aHj();
                this.kvi.kuZ.setSelection(this.kvi.kuZ.getText().toString().length());
                return true;
            }
        }, com.tencent.mm.ui.l.b.uTY);
        kr(true);
        this.kvf = (LinearLayout) findViewById(R.h.bWc);
        this.kvg = (LinearLayout) findViewById(R.h.czf);
        this.kuZ = (MMEditText) findViewById(R.h.coO);
        this.kva = (TextView) findViewById(R.h.coR);
        this.kvb = (TextView) findViewById(R.h.coQ);
        this.kvd = (LinearLayout) findViewById(R.h.czi);
        this.kvc = (ImageView) findViewById(R.h.coP);
        this.kve = (LinearLayout) findViewById(R.h.czk);
        this.kuZ.setText(this.kuV);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.kuZ.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        h.b(this.kuZ, Integer.valueOf(31));
        this.kuY = (TextView) findViewById(R.h.cba);
        this.kuY.setText(Integer.toString(com.tencent.mm.ui.tools.h.aI(280, this.kuV)));
        this.kve.setVisibility(8);
        this.kuZ.setCursorVisible(false);
        this.kuZ.setFocusable(false);
        if (this.kuU) {
            this.kvg.setVisibility(8);
        } else {
            zn(0);
            this.kvg.setVisibility(0);
            this.kuZ.setFocusable(false);
            this.kuZ.setCursorVisible(false);
            this.kuZ.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ RoomCardUI kvi;

                {
                    this.kvi = r1;
                }

                public final boolean onLongClick(View view) {
                    RoomCardUI.a(this.kvi, this.kvi.kuZ);
                    return true;
                }
            });
        }
        if (this.kuX != 0) {
            this.kva.setVisibility(0);
            this.kva.setText(o.Z("yyyy-MM-dd HH:mm", this.kuX));
        } else {
            this.kva.setVisibility(8);
        }
        if (bg.mA(this.kuV)) {
            this.kuZ.setEnabled(true);
            this.kuZ.setFocusableInTouchMode(true);
            this.kuZ.setFocusable(true);
            this.kvf.setVisibility(8);
            this.kuZ.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.kuZ.requestFocus();
            this.kuZ.setCursorVisible(true);
            aB(0, this.uSU.uTo.getString(R.l.dHp));
            aju();
            this.kuZ.performClick();
            aHj();
        } else {
            this.kvf.setVisibility(0);
        }
        this.kvb.setText(h.b(this, com.tencent.mm.u.n.eK(this.kuW), this.kvb.getTextSize()));
        ImageView imageView = this.kvc;
        String str = this.kuW;
        if (bg.mA(str)) {
            imageView.setImageResource(R.g.bes);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
        this.kuZ.addTextChangedListener(new a(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 0, 1, true);
        ap.vd().a(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, this);
        this.kuC = getIntent().getStringExtra("RoomInfo_Id");
        this.kuV = getIntent().getStringExtra("room_notice");
        this.kuW = getIntent().getStringExtra("room_notice_editor");
        this.kuX = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.kuR = getIntent().getStringExtra("room_name");
        this.kuS = getIntent().getIntExtra("room_member_count", 0);
        this.kuT = getIntent().getStringExtra("room_owner_name");
        this.kuU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        KC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomCardUI kvi;

            {
                this.kvi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kvi.goBack();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, this);
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
    }

    private void goBack() {
        if (!this.kuU) {
            setResult(0);
            finish();
        } else if (ajt()) {
            g.a(this, getString(R.l.eLS), null, getString(R.l.eLU), getString(R.l.eLT), new OnClickListener(this) {
                final /* synthetic */ RoomCardUI kvi;

                {
                    this.kvi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener(this) {
                final /* synthetic */ RoomCardUI kvi;

                {
                    this.kvi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kvi.setResult(0);
                    this.kvi.finish();
                }
            });
        } else {
            setResult(0);
            finish();
        }
    }

    private boolean ajt() {
        String obj = this.kuZ.getText().toString();
        if (bg.mA(obj)) {
            if (bg.mA(this.kuV)) {
                return false;
            }
            return true;
        } else if (this.kuV == null || !this.kuV.equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    private void aju() {
        if (ajt()) {
            kr(true);
        } else {
            kr(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            this.kuU = false;
            if (!this.kuU) {
                this.kve.setVisibility(8);
                this.kuZ.setFocusableInTouchMode(false);
                this.kuZ.setFocusable(false);
                this.kve.setVisibility(8);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
        if (kVar.getType() == TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE) {
            if (this.iLz != null && this.iLz.isShowing()) {
                this.iLz.dismiss();
            }
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
                this.kuV = this.kuZ.getText().toString();
                com.tencent.mm.plugin.report.service.g.oUh.a(219, 15, 1, true);
                ajv();
                return;
            }
            w.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[]{str});
            s.makeText(this, R.l.eNb, 1).show();
            w.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        w.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(kVar.getType())});
    }

    private void ajv() {
        Intent intent = new Intent();
        intent.putExtra("room_name", this.kuR);
        intent.putExtra("room_notice", this.kuV);
        setResult(-1, intent);
        finish();
    }
}
