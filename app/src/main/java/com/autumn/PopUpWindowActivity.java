package com.autumn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.autumn.util.ToastUtil;

public class PopUpWindowActivity extends AppCompatActivity {

    private Button btnPop;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);
        btnPop = findViewById(R.id.btn_pop);
        btnPop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //把layout_pop.xml文件加载进去
                View popview = getLayoutInflater().inflate(R.layout.layout_pop, null);
                //对好的按钮进行事件监听
                TextView textView = popview.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        //可关闭
                        pop.dismiss();
                        ToastUtil.showMsg(PopUpWindowActivity.this, "妙啊");
                    }
                });
                pop = new PopupWindow(popview, btnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.setOutsideTouchable(true);
                pop.setFocusable(true);
                pop.showAsDropDown(btnPop);
            }
        });
    }
}
