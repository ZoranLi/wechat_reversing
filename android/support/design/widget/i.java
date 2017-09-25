package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class i {
    private static Method hH;
    private static boolean hI;
    private static Field hJ;
    private static boolean hK;

    static boolean a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!hI) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                hH = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            hI = true;
        }
        if (hH != null) {
            try {
                hH.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    static boolean b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!hK) {
            try {
                Field declaredField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                hJ = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            hK = true;
        }
        if (hJ != null) {
            try {
                hJ.set(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
