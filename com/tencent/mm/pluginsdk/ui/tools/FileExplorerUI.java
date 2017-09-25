package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
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
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileExplorerUI extends MMActivity {
    private int sVp = 0;
    private ListView sVq;
    private a sVr;
    private TextView sVs;
    private TextView sVt;
    private View sVu;
    private View sVv;
    private String sVw;
    private String sVx;
    private File sVy;
    private File sVz;

    private class a extends BaseAdapter {
        String hYa;
        final /* synthetic */ FileExplorerUI sVA;
        private File sVD;
        private File sVE;
        private File[] sVF;

        private a(FileExplorerUI fileExplorerUI) {
            this.sVA = fileExplorerUI;
        }

        public final void c(File file, File file2) {
            this.sVD = file;
            if (file2.getAbsolutePath().equalsIgnoreCase(this.hYa)) {
                this.sVD = null;
            }
            this.sVE = file2;
            if (this.sVE.canRead() && this.sVE.isDirectory()) {
                this.sVF = this.sVE.listFiles(new FileFilter(this) {
                    final /* synthetic */ a sVG;

                    {
                        this.sVG = r1;
                    }

                    public final boolean accept(File file) {
                        if (file.isHidden()) {
                            return false;
                        }
                        return true;
                    }
                });
                if (this.sVF.length > 0) {
                    File[] fileArr = this.sVF;
                    if (fileArr != null && fileArr.length != 0) {
                        List<b> arrayList = new ArrayList();
                        List<b> arrayList2 = new ArrayList();
                        for (File file3 : fileArr) {
                            b bVar = new b(this.sVA);
                            bVar.file = file3;
                            bVar.sVH = com.tencent.mm.platformtools.c.mp(file3.getName()).toUpperCase();
                            if (file3.isDirectory()) {
                                arrayList.add(bVar);
                            } else {
                                arrayList2.add(bVar);
                            }
                        }
                        Collections.sort(arrayList, new Comparator<b>(this) {
                            final /* synthetic */ a sVG;

                            {
                                this.sVG = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((b) obj).sVH.compareTo(((b) obj2).sVH);
                            }
                        });
                        Collections.sort(arrayList2, new Comparator<b>(this) {
                            final /* synthetic */ a sVG;

                            {
                                this.sVG = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((b) obj).sVH.compareTo(((b) obj2).sVH);
                            }
                        });
                        int i = 0;
                        for (b bVar2 : arrayList) {
                            fileArr[i] = bVar2.file;
                            i++;
                        }
                        for (b bVar22 : arrayList2) {
                            fileArr[i] = bVar22.file;
                            i++;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.sVF = new File[0];
        }

        public final int getCount() {
            int i = 0;
            if (this.sVF == null) {
                return 0;
            }
            int length = this.sVF.length;
            if (this.sVD != null) {
                i = 1;
            }
            return i + length;
        }

        public final Object getItem(int i) {
            if (this.sVD != null && i == 0) {
                return this.sVD;
            }
            w.d("FileExplorer", "pos:" + i + ", subFile length:" + this.sVF.length);
            File[] fileArr = this.sVF;
            if (this.sVD != null) {
                i--;
            }
            return fileArr[i];
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.sVA, R.i.dhD, null);
                c cVar = new c(this.sVA);
                cVar.jbU = (ImageView) view.findViewById(R.h.bPy);
                cVar.kzl = (TextView) view.findViewById(R.h.bPE);
                cVar.sVI = (TextView) view.findViewById(R.h.bPH);
                view.setTag(cVar);
            }
            c cVar2 = (c) view.getTag();
            File file = (File) getItem(i);
            if (file == this.sVD) {
                cVar2.kzl.setText(file.getName());
                cVar2.jbU.setImageResource(R.g.biF);
                cVar2.sVI.setVisibility(0);
            } else {
                cVar2.jbU.setImageResource(FileExplorerUI.w(file));
                cVar2.kzl.setText(file.getName());
                cVar2.sVI.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + bg.ay(file.length())));
            }
            return view;
        }
    }

    private class b {
        File file;
        final /* synthetic */ FileExplorerUI sVA;
        String sVH;

        public b(FileExplorerUI fileExplorerUI) {
            this.sVA = fileExplorerUI;
        }
    }

    private class c {
        ImageView jbU;
        TextView kzl;
        final /* synthetic */ FileExplorerUI sVA;
        TextView sVI;

        public c(FileExplorerUI fileExplorerUI) {
            this.sVA = fileExplorerUI;
        }
    }

    static /* synthetic */ int w(File file) {
        return file.isDirectory() ? R.g.biG : Nl(file.getName());
    }

    protected final int getLayoutId() {
        return R.i.dhC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (bg.mA(stringExtra)) {
            zi(R.l.eGA);
        } else {
            qP(stringExtra);
        }
        KC();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.sVr.sVD == null) {
            if (this.sVz != null) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(131074, this.sVz.getAbsolutePath());
            }
            if (this.sVy != null) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(131073, this.sVy.getAbsolutePath());
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (1 == this.sVp) {
            this.sVz = this.sVr.sVD;
        } else if (this.sVp == 0) {
            this.sVy = this.sVr.sVD;
        }
        this.sVr.c(this.sVr.sVD.getParentFile(), this.sVr.sVD);
        this.sVr.notifyDataSetChanged();
        this.sVq.setSelection(0);
        return true;
    }

    protected final void KC() {
        File file;
        File externalStorageDirectory;
        t vr;
        File file2;
        TextView textView;
        boolean z;
        TextView textView2;
        boolean z2 = true;
        Object obj = null;
        this.sVq = (ListView) findViewById(R.h.cuk);
        this.sVs = (TextView) findViewById(R.h.czs);
        this.sVu = findViewById(R.h.czt);
        this.sVt = (TextView) findViewById(R.h.cAg);
        this.sVv = findViewById(R.h.cAh);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FileExplorerUI sVA;

            {
                this.sVA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.sVA.sVr.sVD != null) {
                    if (1 == this.sVA.sVp) {
                        this.sVA.sVz = this.sVA.sVr.sVD;
                    } else if (this.sVA.sVp == 0) {
                        this.sVA.sVy = this.sVA.sVr.sVD;
                    }
                    this.sVA.sVr.c(this.sVA.sVr.sVD.getParentFile(), this.sVA.sVr.sVD);
                    this.sVA.sVr.notifyDataSetChanged();
                    this.sVA.sVq.setSelection(0);
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(131074, this.sVA.sVz.getAbsolutePath());
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(131073, this.sVA.sVy.getAbsolutePath());
                    this.sVA.finish();
                }
                return true;
            }
        });
        this.sVw = getString(R.l.eGy);
        this.sVx = getString(R.l.eGz);
        File rootDirectory = h.getRootDirectory();
        if (rootDirectory.canRead()) {
            file = rootDirectory;
        } else {
            rootDirectory = h.getDataDirectory();
            if (rootDirectory.canRead()) {
                this.sVw = rootDirectory.getName();
                file = rootDirectory;
            } else {
                file = null;
            }
        }
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            externalStorageDirectory = h.getExternalStorageDirectory();
        } else {
            rootDirectory = h.getDownloadCacheDirectory();
            if (rootDirectory.canRead()) {
                this.sVx = rootDirectory.getName();
                externalStorageDirectory = rootDirectory;
            } else {
                externalStorageDirectory = null;
            }
        }
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file3 = new File(str);
            if (file3.exists()) {
                rootDirectory = file3;
                this.sVy = rootDirectory;
                ap.yY();
                vr = com.tencent.mm.u.c.vr();
                if (externalStorageDirectory != null) {
                    obj = externalStorageDirectory.getAbsolutePath();
                }
                str = (String) vr.get(131074, obj);
                if (!(str == null || externalStorageDirectory == null || externalStorageDirectory.getAbsolutePath().equals(str))) {
                    file2 = new File(str);
                    if (file2.exists()) {
                        rootDirectory = file2;
                        this.sVz = rootDirectory;
                        this.sVr = new a();
                        if (externalStorageDirectory == null) {
                            xS(1);
                            this.sVr.hYa = externalStorageDirectory.getPath();
                            this.sVr.c(this.sVz.getParentFile(), this.sVz);
                        } else if (file == null) {
                            xS(0);
                            this.sVr.hYa = file.getPath();
                            this.sVr.c(this.sVy.getParentFile(), this.sVy);
                        } else {
                            w.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                            return;
                        }
                        textView = this.sVs;
                        if (file == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        textView.setEnabled(z);
                        textView2 = this.sVt;
                        if (externalStorageDirectory == null) {
                            z2 = false;
                        }
                        textView2.setEnabled(z2);
                        this.sVq.setAdapter(this.sVr);
                        this.sVr.notifyDataSetChanged();
                        this.sVq.setOnItemClickListener(new OnItemClickListener(this) {
                            final /* synthetic */ FileExplorerUI sVA;

                            {
                                this.sVA = r1;
                            }

                            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                File file = (File) this.sVA.sVr.getItem(i);
                                if (1 == this.sVA.sVp) {
                                    if (file.isFile()) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(131074, this.sVA.sVr.sVE.getAbsolutePath());
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(131073, this.sVA.sVy.getAbsolutePath());
                                    } else {
                                        this.sVA.sVz = file;
                                    }
                                } else if (this.sVA.sVp == 0) {
                                    if (file.isFile()) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(131073, this.sVA.sVr.sVE.getAbsolutePath());
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(131074, this.sVA.sVz.getAbsolutePath());
                                    } else {
                                        this.sVA.sVy = file;
                                    }
                                }
                                if (file == this.sVA.sVr.sVD) {
                                    this.sVA.sVr.c(this.sVA.sVr.sVD.getParentFile(), this.sVA.sVr.sVD);
                                } else if (file.isDirectory()) {
                                    this.sVA.sVr.c(this.sVA.sVr.sVE, file);
                                } else if (file.isFile()) {
                                    this.sVA.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
                                    this.sVA.finish();
                                }
                                this.sVA.sVr.notifyDataSetChanged();
                                this.sVA.sVq.setSelection(0);
                            }
                        });
                        this.sVs.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FileExplorerUI sVA;

                            public final void onClick(View view) {
                                this.sVA.xS(0);
                                this.sVA.sVr.hYa = file.getPath();
                                this.sVA.sVr.c(this.sVA.sVy.getParentFile(), this.sVA.sVy);
                                this.sVA.sVr.notifyDataSetInvalidated();
                                this.sVA.sVr.notifyDataSetChanged();
                                this.sVA.sVq.setSelection(0);
                            }
                        });
                        this.sVt.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ FileExplorerUI sVA;

                            public final void onClick(View view) {
                                this.sVA.xS(1);
                                this.sVA.sVr.hYa = externalStorageDirectory.getPath();
                                this.sVA.sVr.c(this.sVA.sVz.getParentFile(), this.sVA.sVz);
                                this.sVA.sVr.notifyDataSetInvalidated();
                                this.sVA.sVr.notifyDataSetChanged();
                                this.sVA.sVq.setSelection(0);
                            }
                        });
                    }
                }
                rootDirectory = externalStorageDirectory;
                this.sVz = rootDirectory;
                this.sVr = new a();
                if (externalStorageDirectory == null) {
                    xS(1);
                    this.sVr.hYa = externalStorageDirectory.getPath();
                    this.sVr.c(this.sVz.getParentFile(), this.sVz);
                } else if (file == null) {
                    w.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                    return;
                } else {
                    xS(0);
                    this.sVr.hYa = file.getPath();
                    this.sVr.c(this.sVy.getParentFile(), this.sVy);
                }
                textView = this.sVs;
                if (file == null) {
                    z = false;
                } else {
                    z = true;
                }
                textView.setEnabled(z);
                textView2 = this.sVt;
                if (externalStorageDirectory == null) {
                    z2 = false;
                }
                textView2.setEnabled(z2);
                this.sVq.setAdapter(this.sVr);
                this.sVr.notifyDataSetChanged();
                this.sVq.setOnItemClickListener(/* anonymous class already generated */);
                this.sVs.setOnClickListener(/* anonymous class already generated */);
                this.sVt.setOnClickListener(/* anonymous class already generated */);
            }
        }
        rootDirectory = file;
        this.sVy = rootDirectory;
        ap.yY();
        vr = com.tencent.mm.u.c.vr();
        if (externalStorageDirectory != null) {
            obj = externalStorageDirectory.getAbsolutePath();
        }
        str = (String) vr.get(131074, obj);
        file2 = new File(str);
        if (file2.exists()) {
            rootDirectory = file2;
            this.sVz = rootDirectory;
            this.sVr = new a();
            if (externalStorageDirectory == null) {
                xS(1);
                this.sVr.hYa = externalStorageDirectory.getPath();
                this.sVr.c(this.sVz.getParentFile(), this.sVz);
            } else if (file == null) {
                xS(0);
                this.sVr.hYa = file.getPath();
                this.sVr.c(this.sVy.getParentFile(), this.sVy);
            } else {
                w.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                return;
            }
            textView = this.sVs;
            if (file == null) {
                z = true;
            } else {
                z = false;
            }
            textView.setEnabled(z);
            textView2 = this.sVt;
            if (externalStorageDirectory == null) {
                z2 = false;
            }
            textView2.setEnabled(z2);
            this.sVq.setAdapter(this.sVr);
            this.sVr.notifyDataSetChanged();
            this.sVq.setOnItemClickListener(/* anonymous class already generated */);
            this.sVs.setOnClickListener(/* anonymous class already generated */);
            this.sVt.setOnClickListener(/* anonymous class already generated */);
        }
        rootDirectory = externalStorageDirectory;
        this.sVz = rootDirectory;
        this.sVr = new a();
        if (externalStorageDirectory == null) {
            xS(1);
            this.sVr.hYa = externalStorageDirectory.getPath();
            this.sVr.c(this.sVz.getParentFile(), this.sVz);
        } else if (file == null) {
            w.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            return;
        } else {
            xS(0);
            this.sVr.hYa = file.getPath();
            this.sVr.c(this.sVy.getParentFile(), this.sVy);
        }
        textView = this.sVs;
        if (file == null) {
            z = false;
        } else {
            z = true;
        }
        textView.setEnabled(z);
        textView2 = this.sVt;
        if (externalStorageDirectory == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.sVq.setAdapter(this.sVr);
        this.sVr.notifyDataSetChanged();
        this.sVq.setOnItemClickListener(/* anonymous class already generated */);
        this.sVs.setOnClickListener(/* anonymous class already generated */);
        this.sVt.setOnClickListener(/* anonymous class already generated */);
    }

    private void xS(int i) {
        if (1 == i) {
            this.sVp = 1;
            this.sVt.setTextColor(getResources().getColor(R.e.aWu));
            this.sVs.setTextColor(getResources().getColor(R.e.aVo));
            this.sVu.setVisibility(4);
            this.sVv.setVisibility(0);
            return;
        }
        this.sVp = 0;
        this.sVs.setTextColor(getResources().getColor(R.e.aWu));
        this.sVt.setTextColor(getResources().getColor(R.e.aVo));
        this.sVu.setVisibility(0);
        this.sVv.setVisibility(4);
    }

    public static int Nl(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bg.mz(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return R.k.dtv;
        }
        if (Nm(toLowerCase)) {
            return R.g.biH;
        }
        toLowerCase2 = bg.mz(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dtm;
        }
        toLowerCase2 = bg.mz(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dtn;
        }
        if (bg.mz(toLowerCase).toLowerCase().endsWith(".pdf")) {
            return R.k.dti;
        }
        toLowerCase2 = bg.mz(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dtk;
        }
        toLowerCase2 = bg.mz(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
            obj = 1;
        }
        if (obj != null) {
            return R.k.dtc;
        }
        return R.k.dto;
    }

    public static boolean Nm(String str) {
        String toLowerCase = bg.mz(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    public static boolean Nn(String str) {
        String toLowerCase = bg.mz(str).toLowerCase();
        return toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
