package com.example.libowen.fabo_android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by libowen on 2018/2/5.
 *
 *

 <com.example.libowen.fabo_android.ShapeSelectorView
 android:id="@+id/shape_selector_view"
 android:layout_width="100dp"
 android:layout_height="100dp"
 android:layout_alignParentTop="true"
 android:layout_alignParentLeft="true"
 app:shapeColor="@color/colorAccent"
 app:displayShapeName="true"
 />

 */

public class ShapeSelectorView extends View {
    private int shapeColor;
    private boolean displayShapeName;

    private int shapeWidth = 100;
    private int shapeHeight = 100;
    private int textXOffset = 0;
    private int textYOffset = 30;
    private Paint paintShape;

    private String[] shapeValues = {"square", "circle", "triangle"};
    private int currentShapeIndex = 0;

    /**
     * Android继承必须实现构造方法，否则会报错
     *
     * @param context
     * @param attrs
     * @Nullable 可以传空值
     */
    public ShapeSelectorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        setupPaint();
        setBackgroundColor(Color.YELLOW);
    }

    /**
     *
     1、当用户按下HOME键时
     2、长按HOME键，选择运行其他的程序时
     3、按下电源按键（关闭屏幕显示）时
     4、从activity A中启动一个新的activity时
     5、屏幕方向切换时，例如从竖屏切换到横屏时
     * @return
     */
    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState",super.onSaveInstanceState());
        bundle.putInt("currentShapeIndex",this.currentShapeIndex);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof  Bundle) {
            Bundle bundle = (Bundle) state;
            this.currentShapeIndex = bundle.getInt("currentShapeIndex");
            state = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(state);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String shapeSeleted = shapeValues[currentShapeIndex];
        if (shapeSeleted.equals("square")) {
            canvas.drawRect(0, 0, shapeWidth, shapeHeight, paintShape);
            textXOffset = 0;
        }else if (shapeSeleted.equals("circle")) {
            canvas.drawCircle(shapeWidth/2,shapeHeight/2,shapeWidth/2,paintShape);
            textXOffset = 12;
        }else if (shapeSeleted.equals("triangle")) {
            canvas.drawPath(getTrianglePath(),paintShape);
            textXOffset = 0;
        }

        if (displayShapeName) {
            canvas.drawText(shapeSeleted, textXOffset, shapeHeight + textYOffset, paintShape);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            currentShapeIndex++;
            if (currentShapeIndex > (shapeValues.length - 1)) {
                currentShapeIndex = 0;
            }
            postInvalidate();
            return true;
        }
        return result;
    }

    /**
     * MeasureSpec.EXACTLY是精确尺寸，当我们将控件的layout_width或layout_height指定为具体数值时如andorid:layout_width="50dip"，或者为FILL_PARENT是，都是控件大小已经确定的情况，都是精确尺寸。
     * MeasureSpec.AT_MOST是最大尺寸，当控件的layout_width或layout_height指定为WRAP_CONTENT时，控件大小一般随着控件的子空间或内容进行变化，此时控件尺寸只要不超过父控件允许的最大尺寸即可。因此，此时的mode是AT_MOST，size给出了父控件允许的最大尺寸。
     * MeasureSpec.UNSPECIFIED是未指定尺寸，这种情况不多，一般都是父控件是AdapterView，通过measure方法传入的模式。
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int textPadding = 10;
        int contentWidth = shapeWidth;

        int minw = contentWidth + getPaddingLeft() + getPaddingRight();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 0);

        int minh = shapeHeight + getPaddingBottom() + getPaddingTop();
        if (displayShapeName) {
            minh += textYOffset + textPadding;
        }
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);
        setMeasuredDimension(w, h);
    }

    private void setupPaint() {
        paintShape = new Paint();
        paintShape.setStyle(Paint.Style.FILL);
        paintShape.setColor(shapeColor);
        paintShape.setTextSize(30);
    }

    protected Path getTrianglePath() {
        Point p1 = new Point(0,shapeHeight),p2 = null,p3 = null;
        p2 = new Point(p1.x + shapeWidth,p1.y);
        p3 = new Point(p1.x + (shapeWidth/2),p1.y - shapeHeight);
        Path path = new Path();
        path.moveTo(p1.x,p1.y);
        path.lineTo(p2.x,p2.y);
        path.lineTo(p3.x,p3.y);
        return path;
    }

    public String getSeletedShape() {
        return shapeValues[currentShapeIndex];
    }

    /**
     * 1.obtainAttributes(AttributeSet set, int[] attrs) //从layout设置的属性集中获取attrs中的属性
     * 2.obtainStyledAttributes(int[] attrs) //从系统主题中获取attrs中的属性
     * 3.obtainStyledAttributes(int resId,int[] attrs) //从资源文件定义的style中读取属性
     * attrs:int[],我们自定义属性集合在R类中生成的int型数组.这个数组中包含了自定义属性的资源ID.
     * set： 属性值的集合
     * int defStyleAttr: 这是当前Theme中的包含的一个指向style的引用.当我们没有给自定义View设置declare-styleable资源集合时,默认从这个集合里面查找布局文件中配置属性值.传入0表示不向该defStyleAttr中查找默认值.
     * int defStyleRes: 这个也是一个指向Style的资源ID,但是仅在defStyleAttr为0或者defStyleAttr不为0但Theme中没有为defStyleAttr属性赋值时起作用.
     * 优先级如下：
     * set>defStyleAttr(主题可配置样式)>defStyleRes(默认样式)>NULL(主题中直接指定)
     * defStyle不为0且Theme中已经配置了defStyle时，defStyleRes不起效果
     * defStyleAttr和defStyleRes都可以设置成0表示不去搜索可配置的风格和默认风格
     *
     *在布局xml中直接定义 > 在布局xml中通过style定义 > 自定义View所在的Activity的Theme中指定style引用 > 构造函数中defStyleRes指定的默认值
     * https://blog.csdn.net/wzy_1988/article/details/49619773
     *
     * @param attrs
     */
    private void setupAttributes(AttributeSet attrs) {
        TypedArray Arr = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ShapeSelectorView, 0, 0);
        try {
            shapeColor = Arr.getColor(R.styleable.ShapeSelectorView_shapeColor, Color.BLACK);
            displayShapeName = Arr.getBoolean(R.styleable.ShapeSelectorView_displayShapeName, false);
        } finally {
            Arr.recycle();
        }
    }

    public boolean isDisplayShapeName() {
        return displayShapeName;
    }

    public void setDisplayShapeName(boolean displayShapeName) {
        this.displayShapeName = displayShapeName;
        invalidate(); //重绘
        requestLayout(); //重新刷新布局
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int shapeColor) {
        this.shapeColor = shapeColor;
        invalidate();
        requestLayout();
    }
}
