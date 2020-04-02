package com.maple.iosdialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.maple.msdialog.ActionSheetDialog;
import com.maple.msdialog.AlertDialog;
import com.maple.msdialog.AlertEditDialog;
import com.maple.msdialog.AlertNumberPickerDialog;

/**
 * Custom Dialog Demo
 *
 * @author maple
 * @time 17/3/28
 */
public class MainActivity extends Activity {
    public static final String DEF_BLUE = "#037BFF";
    public static final String DEF_RED = "#FD4A2E";
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
    }

    // -------------------------------- Action Sheet Dialog ----------------------------------------

    public void asMessage(View view) {
        new ActionSheetDialog(mContext)
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .setTitle("清空消息列表后，聊天记录依然保留，确定要清空消息列表？")
                .addSheetItem("清空消息列表", Color.parseColor(DEF_RED), which -> showToast("clear msg list"))
                .setCancelText("取 消")
                .show();
    }

    public void asImage(View view) {
        new ActionSheetDialog(mContext)
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .addSheetItem("发送给好友", Color.parseColor(DEF_BLUE), index -> {
                })
                .addSheetItem("转载到空间相册", Color.parseColor(DEF_BLUE), index -> {
                })
                .addSheetItem("上传到群相册", index -> {
                })
                .addSheetItem("保存到手机", index -> {
                })
                .addSheetItem("收藏", index -> {
                })
                .addSheetItem("查看聊天图片", which -> {
                })
                .show();
    }

    public void asList(View view) {
        new ActionSheetDialog(mContext)
                .setTitle("请选择操作")
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .addSheetItem("条目一", Color.parseColor(DEF_RED), which -> showToast("item " + which))
                .addSheetItem("条目二", which -> showToast("item " + which))
                .addSheetItem("条目三", Color.BLUE, which -> showToast("item " + which))
                .addSheetItem("条目四", Color.CYAN, which -> showToast("item " + which))
                .addSheetItem("条目五", which -> showToast("item " + which))
                .addSheetItem("条目六", which -> showToast("item " + which))
                .addSheetItem("条目七", which -> showToast("item " + which))
                .addSheetItem("条目八", which -> showToast("item " + which))
                .addSheetItem("条目九", which -> showToast("item " + which))
                .addSheetItem("条目十", which -> showToast("item " + which)).show();
    }

    // ------------------------------------ Alert Dialog -------------------------------------------

    public void adOne(View view) {
        new AlertDialog(mContext)
                .setCancelable(false)
                .setTitle("退出当前账号")
                .setMessage("再连续登陆15天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
                .setLeftButton("取消", null)
                .setRightButton("确认退出", v -> showToast("exit"))
                .show();
    }

    public void adTwo(View view) {
        new AlertDialog(mContext)
                .setCancelable(true)
                .setScaleWidth(0.7)// 设置宽度，占屏幕宽度百分比
                .setMessage("你现在无法接收到新消息提醒。请到系统-设置-通知中开启消息提醒")
                .setRightButton("确定", v -> showToast("OK"))
                .show();
    }

    // --------------------------------- Alert Edit Dialog -----------------------------------------

    public void aeOne(View view) {
        new AlertEditDialog(mContext)
                .setTitle("姓名")
                .setMessage("请输入您的真实姓名。")
                .setLeftButton("取消", null)
                .setRightButton("确定", str -> showToast(str))
                .show();
    }

    public void aeTwo(View view) {
        new AlertEditDialog(mContext)
                .setMessage("给自己起一个好听的名字吧")
                .setRightButton("确定", str -> {
                    if (!TextUtils.isEmpty(str)) {
                        showToast(str);
                    }
                })
                .show();
    }

    // --------------------------------- Number Picker Dialog -----------------------------------------


    String[] numbers;
    int index = 0;
    String defValue;

    public void npOne(View view) {
        numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        defValue = numbers[index];
        new AlertNumberPickerDialog(mContext)
                .setTitle("Number")
                .setNumberValues(numbers, index, (picker, oldVal, newVal) -> defValue = numbers[newVal])
                .setLeftButton("Cancel", null)
                .setRightButton("OK", v -> showToast(defValue))
                .show();
    }


    public void npTwo(View view) {
        numbers = new String[]{"北京", "上海", "天津", "杭州", "苏州", "深圳"};
        defValue = numbers[index];
        new AlertNumberPickerDialog(mContext)
                .setScaleWidth(0.8)
                .setCancelable(false)
                .setTitle("选择城市")
                .setNumberValues(numbers, index, (picker, oldVal, newVal) -> defValue = numbers[newVal])
                .setNumberValueSuffix("市")
                .setLeftButton("取消", null)
                .setRightButton("确定", v -> showToast(defValue))
                .show();

    }
    // ----------------------------------- other methods -------------------------------------------

    private void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

}
