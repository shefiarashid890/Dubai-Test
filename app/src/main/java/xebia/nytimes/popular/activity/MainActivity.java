package xebia.nytimes.popular.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import xebia.nytimes.popular.constant.NYTimesConstants;
import xebia.nytimes.popular.R;
import xebia.nytimes.popular.adapter.NYTimesAdapter;
import xebia.nytimes.popular.model.NYDetails;
import xebia.nytimes.popular.model.Result;
import xebia.nytimes.popular.rest.ApiClient;
import xebia.nytimes.popular.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));

        setSupportActionBar(toolbar);

        if (NYTimesConstants.API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY https://developer.nytimes.com/get-started", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ny_times_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<NYDetails> call = apiService.getPopularNYDetails(NYTimesConstants.API_KEY);
        call.enqueue(new Callback<NYDetails>() {
            @Override
            public void onResponse(Call<NYDetails> call, Response<NYDetails> response) {
                List<Result> movies = response.body().getResults();
                recyclerView.setAdapter(new NYTimesAdapter(movies, R.layout.list_item_nytimes, MainActivity.this));
            }

            @Override
            public void onFailure(Call<NYDetails> call, Throwable t) {
                // Failed
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.menuSearch);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setQueryHint("Search");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    public String getAPIKey() {
        return NYTimesConstants.API_KEY;
    }
}
