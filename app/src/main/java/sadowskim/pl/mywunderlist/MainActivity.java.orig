package sadowskim.pl.mywunderlist;

import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> feature/preference-fragment
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
<<<<<<< HEAD
import android.view.MenuInflater;
=======
>>>>>>> feature/preference-fragment
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.IOnLongClickListener, PreferencesFragment.IPreferencesListener {
=======
public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.IOnLongClickListener, SettingsFragment.IPreferencesListener {
>>>>>>> feature/preference-fragment

    static final int ADD_LIST_ITEM_REQUEST = 1;
    static final int EDIT_LIST_ITEM_REQUEST = 2;

    private ArrayList<String> listDataSet;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

<<<<<<< HEAD
    private RelativeLayout relativeLayout; //TODO: #1 difference - coordinator layout
    private LinearLayout fragmentContainer;
    private MenuItem preferencesButton;
    //private Comparator<String> itemsComparer; //TODO: #2 commented
=======
    private RelativeLayout mainLayout;
    private LinearLayout fragmentContainer;
    //private MenuItem preferencesButton;

    private SettingsFragment.SortingMode sortingMode;

    private static String filename = "data";

    private static ArrayList<String> readResult;
>>>>>>> feature/preference-fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //TODO: #3 difference

        relativeLayout = findViewById(R.id.relative_layout);
        fragmentContainer = findViewById(R.id.fragment_container);

        mainLayout = findViewById(R.id.main_layout);
        fragmentContainer = findViewById(R.id.fragment_container);
        //preferencesButton = findViewById(R.id.open_preferences);
        sortingMode = SettingsFragment.SortingMode.None;

        initializeDataSet(10);
        initializeListView();
        initalizeItemTouchHelper();
<<<<<<< HEAD
        //initializeSharedPreferences();
=======
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.open_preferences) {
            mainLayout.setVisibility(View.GONE);
            fragmentContainer.setVisibility(View.VISIBLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getPreferencesTitle());
            //preferencesButton.setVisible(false);

            Fragment fragment = new SettingsFragment(this);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_content, fragment);
            transaction.commit();
            return true;
        }else if (id == android.R.id.home) {
            mainLayout.setVisibility(View.VISIBLE);
            fragmentContainer.setVisibility(View.GONE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle(getActivityTitle());
            //preferencesButton.setVisible(true);
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
    public String getActivityTitle() {
        return "My Wunderlist";
    }

    public String getPreferencesTitle() {
        return "Settings";
>>>>>>> feature/preference-fragment
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_LIST_ITEM_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                //Retrieve data in the intent
                String newListItem = data.getStringExtra("newListItem");
                listDataSet.add(newListItem);
                Sort(sortingMode);
                adapter.notifyDataSetChanged();
                //saveList(this, listDataSet);
                runSaveList();
            }
        }
        else if(requestCode == EDIT_LIST_ITEM_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                String newText = data.getStringExtra("newText");
                int position = data.getIntExtra("position", 0);
                listDataSet.set(position, newText);
                Sort(sortingMode);
                adapter.notifyDataSetChanged();
                //saveList(this, listDataSet);
                runSaveList();
            }
        }
    }

    @Override
    public void OnSetSortingMode(PreferencesFragment.SortingMode mode) {
//        if (mode == PreferencesFragment.SortingMode.Alphabetically)
//            itemsComparer = new TodoItem.NameComparer();
//        else if (mode == PreferencesFragment.SortingMode.ByNewest)
//            itemsComparer = new TodoItem.DateComparer();

        SortItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_menu, menu);
        preferencesButton = menu.findItem(R.id.open_preferences);
        return true;
    }

//    @Override
    public String getActivityTitle() {
        return "My Wunderlist";
    }

    public String getPreferencesTitle() {
        return "Settings";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.open_preferences) {
            relativeLayout.setVisibility(View.GONE);
            fragmentContainer.setVisibility(View.VISIBLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getPreferencesTitle());
            preferencesButton.setVisible(false);

            Fragment fragment = new PreferencesFragment(this);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_content, fragment);
            transaction.commit();
            return true;
        }
        else if (id == android.R.id.home) {
            relativeLayout.setVisibility(View.VISIBLE);
            fragmentContainer.setVisibility(View.GONE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle(getActivityTitle());
            preferencesButton.setVisible(true);

            getFragmentManager().popBackStack();
            return  true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    private void initializeDataSet(int n)
    {
        //listDataSet = readList(this);
        listDataSet = runReadList();

        if(listDataSet == null) {
            listDataSet = new ArrayList<String>();
            for(int i = 0; i < n; i++)
            {
                listDataSet.add("List item " + i);
            }
        }
    }

    private void initializeListView()
    {
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // add row separator
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter = new RecyclerViewAdapter(listDataSet, this, this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void initalizeItemTouchHelper()
    {
        ItemTouchHelper mIth = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT) {
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        //do nothing
                        return true;// true if moved, false otherwise
                    }

                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        // remove from adapter
                        final int position = viewHolder.getAdapterPosition();
                        adapter.removeItem(position);
                        //saveList(getApplicationContext(), listDataSet);
                        runSaveList();
                    }
                });

        mIth.attachToRecyclerView(recyclerView);
    }

    private void initializeSharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String s = prefs.getString(getResources().getString(R.string.preferences_select_sorting_key), null);
        if (s.equals(getResources().getStringArray(R.array.sorting_value)[0]))
            OnSetSortingMode(PreferencesFragment.SortingMode.Alphabetically);
        else
            OnSetSortingMode(PreferencesFragment.SortingMode.ByNewest);
    }

    public void onClickAddButton(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, ADD_LIST_ITEM_REQUEST);
    }

    public void onLongClickItem(int position) {
        Intent intent = new Intent(this, EditItemActivity.class);
        intent.putExtra("position", position);
        startActivityForResult(intent, EDIT_LIST_ITEM_REQUEST);
    }

<<<<<<< HEAD
//    public void OnSetSortingMode(PreferencesFragment.SortingMode mode) {
//        //TODO: implement
//    }

    private void SortItems()
    {
        Collections.sort(listDataSet, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        adapter.notifyDataSetChanged();
=======
    public void onSetSortingMode(SettingsFragment.SortingMode mode) {
        sortingMode = mode;
        Sort(mode);
    }

    public void runSaveList()
    {
        Runnable runnable = new Runnable() {
            public void run() {
                saveList(getApplicationContext(), listDataSet);
            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();
    }

    public ArrayList<String> runReadList()
    {
        Runnable runnable = new Runnable() {
            public void run() {
                readResult = readList(getApplicationContext());
            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();
        try {
            mythread.join();
        }
        catch(InterruptedException e) {
            return null;
        }
        return readResult;
    }

    public static void saveList(Context context, ArrayList<String> list) {
        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(list);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> readList(Context context)
    {
        ArrayList<String> list = null;
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fis);
            list = (ArrayList<String>) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public void Sort(SettingsFragment.SortingMode mode)
    {
        if(mode == SettingsFragment.SortingMode.None)
        {
            //do nothing
        }
        else if(mode == SettingsFragment.SortingMode.Alphabetically)
        {
            Collections.sort(listDataSet, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            });
            adapter.notifyDataSetChanged();
        }
>>>>>>> feature/preference-fragment
    }
}
