package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.e.i;
import android.support.v4.e.j;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends g implements android.support.v4.app.a.a, android.support.v4.app.b.a {
    final Handler mHandler = new Handler(this) {
        final /* synthetic */ FragmentActivity pX;

        {
            this.pX = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.pX.pQ) {
                        this.pX.n(false);
                        return;
                    }
                    return;
                case 2:
                    this.pX.aP();
                    this.pX.pN.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final j pN = new j(new a(this));
    boolean pO;
    boolean pP;
    boolean pQ;
    boolean pR;
    boolean pS;
    boolean pT;
    int pU;
    boolean pV;
    j<String> pW;
    boolean pp;

    static final class b {
        Object pY;
        List<Fragment> pZ;
        i<String, s> qa;

        b() {
        }
    }

    class a extends k<FragmentActivity> {
        final /* synthetic */ FragmentActivity pX;

        public a(FragmentActivity fragmentActivity) {
            this.pX = fragmentActivity;
            super(fragmentActivity);
        }

        public final void a(String str, PrintWriter printWriter, String[] strArr) {
            this.pX.dump(str, null, printWriter, strArr);
        }

        public final boolean aS() {
            return !this.pX.isFinishing();
        }

        public final LayoutInflater onGetLayoutInflater() {
            return this.pX.getLayoutInflater().cloneInContext(this.pX);
        }

        public final void aT() {
            this.pX.aQ();
        }

        public final void b(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.pX.a(fragment, intent, i, null);
        }

        public final boolean onHasWindowAnimations() {
            return this.pX.getWindow() != null;
        }

        public final int onGetWindowAnimations() {
            Window window = this.pX.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public final View onFindViewById(int i) {
            return this.pX.findViewById(i);
        }

        public final boolean onHasView() {
            Window window = this.pX.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.pN.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.pW.get(i4);
            this.pW.remove(i4);
            if (str != null) {
                Fragment i5 = this.pN.i(str);
                if (i5 != null) {
                    i5.onActivityResult(65535 & i, i2, intent);
                    return;
                }
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.pN.ph.pg.popBackStackImmediate()) {
            aE();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.pN.ph.pg.dispatchConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        j jVar = this.pN;
        jVar.ph.pg.a(jVar.ph, jVar.ph, null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.pN.ph.qd = bVar.qa;
        }
        if (bundle != null) {
            this.pN.ph.pg.restoreAllState(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.pZ : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.pU = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                    this.pW = new j(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.pW.put(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.pW == null) {
            this.pW = new j();
            this.pU = 0;
        }
        this.pN.ph.pg.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        j jVar = this.pN;
        onCreatePanelMenu |= jVar.ph.pg.dispatchCreateOptionsMenu(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.pN.ph.pg.onCreateView(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        n(false);
        this.pN.ph.pg.dispatchDestroy();
        k kVar = this.pN.ph;
        if (kVar.py != null) {
            kVar.py.bi();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.pN.ph.pg.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.pN.ph.pg.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.pN.ph.pg.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.pN.ph.pg.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.pP = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            aP();
        }
        this.pN.ph.pg.G(4);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.pN.noteStateNotSaved();
    }

    public void onStateNotSaved() {
        this.pN.noteStateNotSaved();
    }

    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.pP = true;
        this.pN.execPendingActions();
    }

    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        aP();
        this.pN.execPendingActions();
    }

    protected final void aP() {
        this.pN.ph.pg.dispatchResume();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.pS) {
            this.pS = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(0, view, menu) | this.pN.ph.pg.dispatchPrepareOptionsMenu(menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        List list;
        if (this.pQ) {
            n(true);
        }
        m mVar = this.pN.ph.pg;
        if (mVar.qj != null) {
            list = null;
            for (int i = 0; i < mVar.qj.size(); i++) {
                Fragment fragment = (Fragment) mVar.qj.get(i);
                if (fragment != null && fragment.po) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fragment);
                    fragment.pp = true;
                    fragment.oY = fragment.oX != null ? fragment.oX.mIndex : -1;
                    if (m.DEBUG) {
                        new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                    }
                }
            }
        } else {
            list = null;
        }
        i aU = this.pN.ph.aU();
        if (list == null && aU == null) {
            return null;
        }
        b bVar = new b();
        bVar.pY = null;
        bVar.pZ = list;
        bVar.qa = aU;
        return bVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.pN.ph.pg.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
        if (this.pW.size() > 0) {
            bundle.putInt("android:support:next_request_index", this.pU);
            int[] iArr = new int[this.pW.size()];
            String[] strArr = new String[this.pW.size()];
            for (int i = 0; i < this.pW.size(); i++) {
                iArr[i] = this.pW.keyAt(i);
                strArr[i] = (String) this.pW.valueAt(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.pQ = false;
        this.pR = false;
        this.mHandler.removeMessages(1);
        if (!this.pO) {
            this.pO = true;
            this.pN.ph.pg.dispatchActivityCreated();
        }
        this.pN.noteStateNotSaved();
        this.pN.execPendingActions();
        k kVar = this.pN.ph;
        if (!kVar.pz) {
            kVar.pz = true;
            if (kVar.py != null) {
                kVar.py.bd();
            } else if (!kVar.pA) {
                kVar.py = kVar.a("(root)", kVar.pz, false);
                if (!(kVar.py == null || kVar.py.ny)) {
                    kVar.py.bd();
                }
            }
            kVar.pA = true;
        }
        this.pN.ph.pg.dispatchStart();
        k kVar2 = this.pN.ph;
        if (kVar2.qd != null) {
            int i;
            int size = kVar2.qd.size();
            t[] tVarArr = new t[size];
            for (i = size - 1; i >= 0; i--) {
                tVarArr[i] = (t) kVar2.qd.valueAt(i);
            }
            for (i = 0; i < size; i++) {
                t tVar = tVarArr[i];
                if (tVar.pp) {
                    if (t.DEBUG) {
                        new StringBuilder("Finished Retaining in ").append(tVar);
                    }
                    tVar.pp = false;
                    for (int size2 = tVar.ru.size() - 1; size2 >= 0; size2--) {
                        a aVar = (a) tVar.ru.valueAt(size2);
                        if (aVar.pp) {
                            if (t.DEBUG) {
                                new StringBuilder("  Finished Retaining: ").append(aVar);
                            }
                            aVar.pp = false;
                            if (!(aVar.ny == aVar.rC || aVar.ny)) {
                                aVar.stop();
                            }
                        }
                        if (aVar.ny && aVar.rA && !aVar.rD) {
                            aVar.c(aVar.rz, aVar.mData);
                        }
                    }
                }
                tVar.bh();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.pQ = true;
        this.mHandler.sendEmptyMessage(1);
        this.pN.ph.pg.dispatchStop();
    }

    public void aQ() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.pS = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.pO);
        printWriter.print("mResumed=");
        printWriter.print(this.pP);
        printWriter.print(" mStopped=");
        printWriter.print(this.pQ);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.pR);
        k kVar = this.pN.ph;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(kVar.pz);
        if (kVar.py != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(kVar.py)));
            printWriter.println(":");
            kVar.py.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
        }
        this.pN.ph.pg.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String x(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (WebView.NIGHT_MODE_COLOR & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(x(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final void n(boolean z) {
        if (!this.pR) {
            this.pR = true;
            this.pp = z;
            this.mHandler.removeMessages(1);
            j jVar = this.pN;
            boolean z2 = this.pp;
            k kVar = jVar.ph;
            kVar.qe = z2;
            if (kVar.py != null && kVar.pz) {
                kVar.pz = false;
                if (z2) {
                    kVar.py.bf();
                } else {
                    kVar.py.be();
                }
            }
            this.pN.ph.pg.G(2);
        }
    }

    public final l aR() {
        return this.pN.ph.pg;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.pV || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void C(int i) {
        if (!this.pT && i != -1 && (-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.pW.get(i3);
            this.pW.remove(i3);
            if (str != null && this.pN.i(str) != null) {
                Fragment.aJ();
            }
        }
    }

    public void a(Fragment fragment, Intent intent, int i) {
        a(fragment, intent, i, null);
    }

    public final void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.pV = true;
        if (i == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.pV = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            a.a(this, intent, ((d(fragment) + 1) << 16) + (65535 & i), bundle);
            this.pV = false;
        }
    }

    private int d(Fragment fragment) {
        if (this.pW.size() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.pW.indexOfKey(this.pU) >= 0) {
            this.pU = (this.pU + 1) % 65534;
        }
        int i = this.pU;
        this.pW.put(i, fragment.oV);
        this.pU = (this.pU + 1) % 65534;
        return i;
    }
}
