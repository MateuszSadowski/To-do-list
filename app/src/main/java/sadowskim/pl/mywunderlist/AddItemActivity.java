package sadowskim.pl.mywunderlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mateuszsadowski on 27/03/2018.
 */

public class AddItemActivity extends MainActivity {
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        input = findViewById(R.id.add_item_input_text);
    }

    public void onClickAddButtonAddItemActivity(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("newListItem", input.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void onClickCancelButton(View view)
    {
        Intent intent = new Intent();
        finish();
    }
}
