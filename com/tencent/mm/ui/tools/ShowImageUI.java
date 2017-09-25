package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI extends MMActivity {
    private MMGestureGallery klE;
    private a woA;
    private boolean woB;
    private boolean woz;

    private class a extends BaseAdapter {
        String imagePath;
        final /* synthetic */ ShowImageUI woC;

        private a(ShowImageUI showImageUI) {
            this.woC = showImageUI;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (o.Pj(this.imagePath)) {
                Context context = viewGroup.getContext();
                String str = this.imagePath;
                d dVar = new d(str);
                if (view == null || !(view instanceof MMGIFImageView)) {
                    view = new MMGIFImageView(context);
                } else {
                    MMGIFImageView mMGIFImageView = (MMGIFImageView) view;
                }
                view.cs(str, str);
                view.a(str, new e(this) {
                    final /* synthetic */ a woF;

                    public final void invalidate() {
                        view.invalidate();
                    }
                });
                if (view.getDrawable() != null && (view.getDrawable() instanceof com.tencent.mm.plugin.gif.a)) {
                    ((com.tencent.mm.plugin.gif.a) view.getDrawable()).stop();
                }
                if (view.getDrawable() != null && (view.getDrawable() instanceof com.tencent.mm.plugin.gif.a)) {
                    ((com.tencent.mm.plugin.gif.a) view.getDrawable()).start();
                }
            } else {
                Bitmap mt = j.mt(this.imagePath);
                if (mt == null) {
                    w.w("MicroMsg.ShowImageUI", "get image fail");
                    if (view == null || (view instanceof MultiTouchImageView)) {
                        view = View.inflate(viewGroup.getContext(), R.i.doA, null);
                    }
                    ((ImageView) view.findViewById(R.h.bWV)).setImageResource(R.k.dwC);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                } else {
                    Context context2 = viewGroup.getContext();
                    if (view == null || !(view instanceof MultiTouchImageView)) {
                        view = new MultiTouchImageView(context2, mt.getWidth(), mt.getHeight());
                    } else {
                        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                        multiTouchImageView.dZ(mt.getWidth(), mt.getHeight());
                    }
                    view.setLayoutParams(new LayoutParams(-1, -1));
                    view.setImageBitmap(mt);
                    view.vol = true;
                }
            }
            return view;
        }
    }

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        ap.yY();
        ce cA = c.wT().cA(longExtra);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
        if (o.Pj(stringExtra) || (cA.axO() && ek != null && ek.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", cA.field_content);
            if (ek != null && ek.type == 2) {
                stringExtra = q.fQ("msg_" + cA.field_msgSvrId);
                q.yC().n(stringExtra, true).l("prePublishId", "msg_" + cA.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.doz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!bg.mA(stringExtra)) {
            qP(stringExtra);
        }
        this.woz = getIntent().getBooleanExtra("key_favorite", false);
        this.woB = getIntent().getBooleanExtra("show_menu", true);
        this.klE = (MMGestureGallery) findViewById(R.h.bSr);
        this.klE.setVerticalFadingEdgeEnabled(false);
        this.klE.setHorizontalFadingEdgeEnabled(false);
        this.woA = new a();
        this.woA.imagePath = getIntent().getStringExtra("key_image_path");
        this.klE.setAdapter(this.woA);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowImageUI woC;

            {
                this.woC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.woC.finish();
                return true;
            }
        });
        if (this.woB) {
            a(0, R.k.dyx, new OnMenuItemClickListener(this) {
                final /* synthetic */ ShowImageUI woC;

                {
                    this.woC = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    if (this.woC.woz && com.tencent.mm.bb.d.Jt("favorite")) {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(this.woC.getString(R.l.eLL));
                        linkedList2.add(Integer.valueOf(1));
                        linkedList.add(this.woC.getString(R.l.eGa));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(this.woC.getString(R.l.eOm));
                    } else {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(this.woC.getString(R.l.eLL));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(this.woC.getString(R.l.eOm));
                    }
                    b ddVar = new dd();
                    ddVar.fGW.fGM = this.woC.getIntent().getLongExtra("key_message_id", -1);
                    com.tencent.mm.sdk.b.a.urY.m(ddVar);
                    if (ddVar.fGX.fGu) {
                        linkedList2.add(Integer.valueOf(3));
                        linkedList.add(this.woC.getString(R.l.dUu));
                    }
                    g.a(this.woC, "", linkedList, linkedList2, "", false, new g.d(this) {
                        final /* synthetic */ AnonymousClass2 woD;

                        {
                            this.woD = r1;
                        }

                        public final void bN(int i, int i2) {
                            switch (i2) {
                                case 0:
                                    ShowImageUI.b(this.woD.woC);
                                    return;
                                case 1:
                                    Activity activity = this.woD.woC;
                                    cb cbVar = new cb();
                                    long longExtra = activity.getIntent().getLongExtra("key_message_id", -1);
                                    if (-1 == longExtra) {
                                        w.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                                        com.tencent.mm.pluginsdk.model.e.a(cbVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.getIntent().getStringExtra("key_image_path"));
                                    } else {
                                        com.tencent.mm.pluginsdk.model.e.a(cbVar, longExtra);
                                    }
                                    cbVar.fFA.activity = activity;
                                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                                    return;
                                case 2:
                                    k.h(this.woD.woC.getIntent().getStringExtra("key_image_path"), this.woD.woC);
                                    return;
                                case 3:
                                    ShowImageUI.d(this.woD.woC);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }
}
