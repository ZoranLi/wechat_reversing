package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private ProgressBar jFc;
    private c oBX = new c(this);
    private String oBy;
    private long oCO = 0;
    private List<a> oCP = new ArrayList();
    private String oCQ;
    private ListView oCR;
    private TextView oCS;
    private b oCT;
    private com.tencent.mm.plugin.qqmail.b.p.a oCU = new com.tencent.mm.plugin.qqmail.b.p.a(this) {
        final /* synthetic */ CompressPreviewUI oCV;

        {
            this.oCV = r1;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            this.oCV.oCQ = (String) map.get(".Response.result.compressfilepath");
            int i = bg.getInt((String) map.get(".Response.result.filelist.count"), 0);
            int i2 = 0;
            while (i2 < i) {
                try {
                    String str2 = ".Response.result.filelist.list.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    String str3 = (String) map.get(str2 + ".path");
                    if (str3 != null) {
                        String str4;
                        String decode = URLDecoder.decode(str3, ProtocolPackage.ServerEncoding);
                        String str5 = (String) map.get(str2 + ".parentpath");
                        int i3 = bg.getInt((String) map.get(str2 + ".size"), 0);
                        int i4 = bg.getInt((String) map.get(str2 + ".type"), 0);
                        boolean equals = ((String) map.get(str2 + ".preview")).equals("1");
                        String str6 = (String) map.get(str2 + ".name");
                        List h = this.oCV.oCP;
                        CompressPreviewUI compressPreviewUI = this.oCV;
                        if (i3 == 0) {
                            str4 = "";
                        } else {
                            str4 = "(" + bg.ay((long) i3) + ")";
                        }
                        h.add(new a(compressPreviewUI, decode, str6, str5, i4, str4, equals));
                    }
                    i2++;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.CompressPreviewUI", e, "", new Object[0]);
                }
            }
            this.oCV.CW("");
        }

        public final void onError(int i, String str) {
            if (i == -5) {
                this.oCV.oBX.a(new com.tencent.mm.plugin.qqmail.ui.c.a(this) {
                    final /* synthetic */ AnonymousClass5 oCW;

                    {
                        this.oCW = r1;
                    }

                    public final void aUC() {
                        this.oCW.oCV.aUR();
                    }

                    public final void aUD() {
                    }
                });
                return;
            }
            this.oCV.jFc.setVisibility(8);
            this.oCV.oCS.setVisibility(0);
            this.oCV.oCR.setVisibility(8);
        }
    };
    private String ozZ = null;
    private String ozl = null;

    private class a {
        String id;
        String name;
        final /* synthetic */ CompressPreviewUI oCV;
        String oCX;
        String oCY;
        boolean oCZ;
        int type;

        public a(CompressPreviewUI compressPreviewUI, String str, String str2, String str3, int i, String str4, boolean z) {
            this.oCV = compressPreviewUI;
            this.id = str;
            this.name = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.oCX = str3;
            this.type = i;
            this.oCY = str4;
            this.oCZ = z;
        }

        public final boolean aUS() {
            return this.type == 1;
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ CompressPreviewUI oCV;
        a oDa;
        List<a> oDb;

        private class a {
            ImageView jbU;
            TextView kzl;
            TextView oDc;
            ImageView oDd;
            final /* synthetic */ b oDe;

            public a(b bVar) {
                this.oDe = bVar;
            }
        }

        private b(CompressPreviewUI compressPreviewUI) {
            this.oCV = compressPreviewUI;
            this.oDb = null;
        }

        public final /* synthetic */ Object getItem(int i) {
            return rE(i);
        }

        public final String aUT() {
            if (this.oDa == null || this.oDa.oCX == null) {
                return null;
            }
            if (this.oDa.oCX.length() == 0) {
                return "";
            }
            int indexOf = this.oDa.id.indexOf(this.oDa.oCX);
            if (indexOf >= 0) {
                return this.oDa.id.substring(0, indexOf) + this.oDa.oCX;
            }
            return null;
        }

        public final int getCount() {
            return this.oDb != null ? this.oDb.size() : 0;
        }

        public final a rE(int i) {
            return (this.oDb == null || this.oDb.size() <= i) ? null : (a) this.oDb.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            int Nl;
            if (view == null) {
                view = View.inflate(this.oCV.uSU.uTo, R.i.dhA, null);
                a aVar = new a(this);
                aVar.jbU = (ImageView) view.findViewById(R.h.bPy);
                aVar.kzl = (TextView) view.findViewById(R.h.bPE);
                aVar.oDc = (TextView) view.findViewById(R.h.bPF);
                aVar.oDd = (ImageView) view.findViewById(R.h.bPG);
                view.setTag(aVar);
            }
            a aVar2 = (a) view.getTag();
            a rE = rE(i);
            if (i != 0 || aUT() == null) {
                imageView = aVar2.jbU;
                Nl = rE.aUS() ? R.g.biG : FileExplorerUI.Nl(rE.name);
            } else {
                imageView = aVar2.jbU;
                Nl = R.g.biF;
            }
            imageView.setImageResource(Nl);
            aVar2.oDd.setVisibility(rE.oCZ ? 0 : 4);
            aVar2.kzl.setText(rE.name);
            aVar2.oDc.setText(rE.oCY);
            return view;
        }
    }

    protected final int getLayoutId() {
        return R.i.dhB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ozl = getIntent().getStringExtra("mail_id");
        this.ozZ = getIntent().getStringExtra("attach_id");
        this.oCO = getIntent().getLongExtra("attach_size", 0);
        this.oBy = getIntent().getStringExtra("attach_name");
        KC();
        qP(this.oBy);
    }

    protected final void KC() {
        this.oCR = (ListView) findViewById(R.h.bEt);
        this.oCS = (TextView) findViewById(R.h.bEr);
        this.jFc = (ProgressBar) findViewById(R.h.bEs);
        if (this.ozl == null || this.ozZ == null) {
            this.jFc.setVisibility(8);
            this.oCS.setText(R.l.eyM);
            return;
        }
        this.oCT = new b();
        this.oCR.setAdapter(this.oCT);
        this.oCR.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI oCV;

            {
                this.oCV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a rE = this.oCV.oCT.rE(i);
                String str = rE.id;
                b a = this.oCV.oCT;
                if (str.equals(a.oDa == null ? null : a.oDa.id)) {
                    this.oCV.CW(this.oCV.oCT.aUT());
                } else if (rE.aUS()) {
                    this.oCV.CW(rE.id);
                } else if (rE.oCZ) {
                    String[] strArr = new String[]{"mailid=" + this.oCV.ozl, "attachid=" + rE.id, "compressfilepath=" + this.oCV.oCQ, "texttype=html"};
                    Intent intent = new Intent(this.oCV, MailWebViewUI.class);
                    intent.putExtra("uri", "/cgi-bin/viewdocument");
                    intent.putExtra("params", strArr);
                    intent.putExtra("baseurl", p.aUt());
                    intent.putExtra("method", "get");
                    intent.putExtra("singleColumn", FileExplorerUI.Nm(rE.name));
                    intent.putExtra("title", this.oCV.getString(R.l.eIl));
                    this.oCV.startActivity(intent);
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI oCV;

            {
                this.oCV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oCV.onKeyDown(4, null);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ CompressPreviewUI oCV;

            {
                this.oCV = r1;
            }

            public final void onClick(View view) {
                c.a(this.oCV.oCR);
            }
        };
        a(0, getString(R.l.dGE), new OnMenuItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI oCV;

            {
                this.oCV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.oCV, AttachDownloadPage.class);
                intent.putExtra("attach_name", this.oCV.oBy);
                intent.putExtra("mail_id", this.oCV.ozl);
                intent.putExtra("attach_id", this.oCV.ozZ);
                intent.putExtra("total_size", this.oCV.oCO);
                intent.putExtra("is_preview", 0);
                intent.putExtra("is_compress", true);
                this.oCV.startActivity(intent);
                return true;
            }
        });
        aUR();
    }

    public void onDestroy() {
        super.onDestroy();
        this.oBX.release();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.oCT.aUT() != null) {
            CW(this.oCT.aUT());
            return true;
        } else if (keyEvent != null) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            return true;
        }
    }

    private void CW(String str) {
        w.i("MicroMsg.CompressPreviewUI", "curPath=" + str);
        this.jFc.setVisibility(8);
        this.oCS.setVisibility(8);
        this.oCR.setVisibility(0);
        a CX = CX(str);
        List arrayList = new ArrayList();
        if (CX != null) {
            arrayList.add(CX);
        }
        for (int i = 0; i < this.oCP.size(); i++) {
            a aVar = (a) this.oCP.get(i);
            if ((str.endsWith(aVar.oCX) && aVar.oCX.length() > 0) || aVar.oCX.equals(str)) {
                arrayList.add(aVar);
            }
        }
        b bVar = this.oCT;
        bVar.oDa = CX;
        bVar.oDb = arrayList;
        this.oCT.notifyDataSetChanged();
        this.oCR.setSelection(0);
    }

    private a CX(String str) {
        for (a aVar : this.oCP) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void aUR() {
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.ozl);
        hashMap.put("attachid", this.ozZ);
        hashMap.put("fun", "list");
        com.tencent.mm.plugin.qqmail.b.w.aUz().a("/cgi-bin/viewcompress", hashMap, new p.c(), this.oCU);
    }
}
