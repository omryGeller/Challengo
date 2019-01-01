package anyvisioninternal.com.anyvision.challengo;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<GameModel> games;
    public GameAdapter(Context context){
        this.context = context;
        this.games = new ArrayList<>();
        for(int i = 0 ; i < 15 ; i++){
            String prize = "";
            int game =0;
            if(i % 2 == 0){
                game = R.drawable.memory_game;
            }
            else {
                game = R.drawable.trivia;
            }
             int min = 50;
             int max = 500;
             int random = new Random().nextInt((max - min) + 1) + min;
            prize = String.valueOf(random);
            games.add(new GameModel(prize,game));
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item, viewGroup, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ImageView)viewHolder.itemView.findViewById(R.id.gameImage)).setImageResource(games.get(i).getImage());
        ((TextView)viewHolder.itemView.findViewById(R.id.prizeMoney)).setText(games.get(i).getPrize());
        viewHolder.itemView.findViewById(R.id.playBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = View.inflate(context,R.layout.dialog_game,null);
                builder.setView(view);
                final AlertDialog alertDialog = builder.create();
                view.findViewById(R.id.startGameBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                view.findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }
    public class GameViewHolder extends RecyclerView.ViewHolder {

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
