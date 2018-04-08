package sadowskim.pl.mywunderlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mateuszsadowski on 27/03/2018.
 */

public class EditItemActivity extends MainActivity {
    private EditText input;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        input = findViewById(R.id.edit_item_input_text);
        position = getIntent().getExtras().getInt("position");
    }

    public void onClickSaveButton(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("newText", input.getText().toString());
        intent.putExtra("position", position);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void onClickCancelButton(View view)
    {
        Intent intent = new Intent();
        finish();
    }
}
