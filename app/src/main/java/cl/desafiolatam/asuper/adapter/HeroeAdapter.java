package cl.desafiolatam.asuper.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.asuper.R;
import cl.desafiolatam.asuper.databinding.ItemLayautBinding;
import cl.desafiolatam.asuper.modelo.HeroesItem;

//recibe un adapter y que reciba un custom viewHolder
public class HeroeAdapter extends RecyclerView.Adapter<HeroeAdapter.CustomViewHolder> {

    private List<HeroesItem> lista = new ArrayList<>();
    private MiOnClickListener listener;



    //hacemos el setter de los HeroesItem
    public void setLista(List<HeroesItem> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

  //seter
      public void setListener(MiOnClickListener listener) {
          this.listener = listener;
      }

    //implementa los 3 métodos///////
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layaut, parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindData(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
 /////////////////////////////////////

    class CustomViewHolder extends RecyclerView.ViewHolder{

        private ItemLayautBinding binding;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemLayautBinding.bind(itemView);
        }

        public void bindData(HeroesItem heroeIt){
            Picasso.get().load(heroeIt.getImages().getMd()).into(binding.imageView2);
            binding.textView17.setText(heroeIt.getName());
            binding.textView18.setText(heroeIt.getSlug());
           itemView.setOnClickListener(v -> {
               listener.onClickListener(heroeIt);
           });
          }
        }
    public interface MiOnClickListener{
        void onClickListener(HeroesItem heroesItem);
    }

}
