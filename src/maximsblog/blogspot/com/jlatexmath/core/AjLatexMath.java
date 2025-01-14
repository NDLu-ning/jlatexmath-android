package maximsblog.blogspot.com.jlatexmath.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class AjLatexMath {

	private static Context mContext;
	private static Paint st;

	/**
	 * 初始化画笔以及公式解析类
	 *
	 * @param context
	 */
	public static synchronized void init(Context context) {
		if (mContext != null) {
			return;
		}
		mContext = context;
		st = getPaint();
		TeXFormula.getPartialTeXFormula("{x^{2}+ x-1= 0 }").setDEBUG(false);
	}

	public static AssetManager getAssetManager() {
		AssetManager mng = mContext.getAssets();
		return mng;
	}

	/**
	 * 同步画笔颜色，使生成图片与文字夜色一致
	 *
	 * @param color
	 */
	@Deprecated
	public static void setColor(int color) {
		if (st == null) {
			init(mContext);
		}
		st.setColor(color);
	}

	public static Context getContext() {
		return mContext;
	}

	public static Paint getPaint() {
		Paint p = new Paint();
		p.setStyle(Style.FILL_AND_STROKE);
		p.setColor(Color.BLACK);
		p.setStrokeWidth(0);
		return p;
	}

	@Deprecated
	public static float getLeading(float textSize){
		st.setTextSize(textSize);
		return st.getFontSpacing();
	}
}
