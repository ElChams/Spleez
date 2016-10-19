package com.slpeez.spleez.Activity;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by alexduffaut on 20/03/16.
 */
public class MenuScroll_Activity extends LinearLayout {

    protected final int MenuMargin = 150;

    private View menu;
    private  View content;


    public enum  Menustate{
        OPEN,CLOSE
    };
    protected int currentContentOffset = 0;
    protected Menustate menuCurrentState = Menustate.CLOSE;


    public MenuScroll_Activity(Context context, AttributeSet attributes, int defstyle){
        super(context,attributes,defstyle);

    }

    public MenuScroll_Activity(Context context, AttributeSet attributes){
        super(context,attributes);

    }
    public MenuScroll_Activity(Context context){
        super(context);

    }
    private void calculateChildDimension(){
        this.content.getLayoutParams().width= this.getWidth();
        this.content.getLayoutParams().height= this.getHeight();

        this.menu.getLayoutParams().height=this.getHeight();
        this.menu.getLayoutParams().width=this.getWidth()- MenuMargin;

    }

    protected void onattachedtoWindow(){
        super.onAttachedToWindow();

        this.menu=this.getChildAt(0);
        this.content=this.getChildAt(1);

        this.menu.setVisibility(View.GONE);
    }

    protected void OnLayout(boolean change, int left, int top, int right, int bottom){
        if(change)
            this.calculateChildDimension();

            this.menu.layout(left, top, right - MenuMargin , bottom);

            this.content.layout(left + this.currentContentOffset, top, right + this.currentContentOffset, bottom);


    }

    public void toogleMenu(){

        switch (this.menuCurrentState){
            case CLOSE:
                this.menu.setVisibility(View.VISIBLE);
                this.currentContentOffset= this.getMenuWidth();
                this.content.offsetLeftAndRight(currentContentOffset);
                this.menuCurrentState= Menustate.OPEN;
                break;
            case OPEN:
                this.content.offsetLeftAndRight(-currentContentOffset);
                this.currentContentOffset= 0;
                this.menuCurrentState= Menustate.CLOSE;
                this.menu.setVisibility(View.GONE);
                break;

        }
        this.invalidate();
    }
    private int getMenuWidth(){
        return this.menu.getLayoutParams().width;

    }

}
